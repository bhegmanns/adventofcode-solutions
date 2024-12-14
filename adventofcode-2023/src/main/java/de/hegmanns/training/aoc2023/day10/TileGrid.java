package de.hegmanns.training.aoc2023.day10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class TileGrid {

    List<List<Tile>> grid = new ArrayList<>();

    int height;
    int width;
    private GridCoordinate startCoordinate;

    List<List<Boolean>> possibleWays;
    List<List<Long>> longGrid;

    public TileGrid() {

    }

    public void addTileLineIntoGrid(List<Tile> tiles) {
        if (!grid.isEmpty()) {
            if (tiles.size() != grid.get(0).size()) {
                throw new IllegalArgumentException("tiles have to be same size");
            }
        }
        grid.add(tiles);

    }

    public List<GridCoordinate> getCoordinateFrom(Tile tile) {
        List<GridCoordinate> result = new ArrayList<>();

        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(y).size(); x++) {
                if (grid.get(y).get(x) == tile) {
                    result.add(new GridCoordinate(x, y));
                }
            }
        }

        return result;
    }

    public List<List<Long>> calculateFarthestPointLoop() {
        List<GridCoordinate> coordinateFrom = getCoordinateFrom(Tile.S);
        if (coordinateFrom.size() != 1) {
            throw new RuntimeException("found " + coordinateFrom.size() + " S-tiles, but there have to be one exaclty!");
        }
        this.startCoordinate = coordinateFrom.get(0);
        this.height = grid.size();
        this.width = grid.get(0).size();

        setupBooleanGrid();
        setupLongGrid();

        setInLongGrid(longGrid, startCoordinate, 0);
        setInBooleanGrid(possibleWays, startCoordinate, true);

        GridCoordinate currentPosition = startCoordinate;


        List<GridCoordinate> visitedCoordinates = new ArrayList<>();
        visitedCoordinates.add(currentPosition);
        List<GridCoordinate> gridCoordinates = lookupWay(currentPosition);

        while (!gridCoordinates.isEmpty()) {

            List<GridCoordinate> toVisit = new ArrayList<>();
            for (var c : gridCoordinates) {
                if (!visitedCoordinates.contains(c)) {
                    toVisit.add(c);
                }
            }
            gridCoordinates = new ArrayList<>();
            for (var c : toVisit) {
                visitedCoordinates.add(c);
                gridCoordinates.addAll(lookupWay(c));
            }
        }



        return longGrid;
    }

    private List<GridCoordinate> lookupWay(GridCoordinate currentPosition) {
        Tile currentTile = currentPosition.getTileFromTileGrid(this);
        List<GridCoordinate> possibleNextCoordinates = new ArrayList<>();
        try {
            for (var d : List.of(Direction.NORTH, Direction.WEST, Direction.EAST, Direction.SOUTH)) {
                GridCoordinate newCoordinate = currentPosition.getCoordinate(d);
                Tile tileFromTileGrid = newCoordinate.getTileFromTileGrid(this);
                if (currentTile.isConnectable(tileFromTileGrid, d)) {
                    setInBooleanGrid(possibleWays, newCoordinate, true);
                    setInLongGrid(longGrid, newCoordinate, 0L);

                    possibleNextCoordinates.add(newCoordinate);
                }
            }
        } catch (RuntimeException e) {
            // nothing to do, it's a brute force method ;)
        }
        return possibleNextCoordinates;
    }

    private Map<GridCoordinate, Tile> getTilesAround(GridCoordinate coordinate) {
        Map<GridCoordinate, Tile> result = new HashMap<>();

        try {
            for (var d : List.of(Direction.NORTH, Direction.WEST, Direction.EAST, Direction.SOUTH)) {
                GridCoordinate newCoordinate = coordinate.getCoordinate(d);
                Tile tileFromTileGrid = newCoordinate.getTileFromTileGrid(this);
                result.put(newCoordinate, tileFromTileGrid);
            }
        } catch (RuntimeException e) {
            // nothing to do, it's a brute force method ;)
        }

        return result;
    }

    private void setInLongGrid(List<List<Long>> longGrid, GridCoordinate coordinate, long value) {
        longGrid.get(coordinate.y()).set(coordinate.x(), value);
    }

    private void setInBooleanGrid(List<List<Boolean>> longGrid, GridCoordinate coordinate, boolean value) {
        longGrid.get(coordinate.y()).set(coordinate.x(), value);
    }

    private void setupLongGrid() {
        longGrid = new ArrayList<>();
//        IntStream.range(1, 100).b
        IntStream.range(0, height).forEach(i -> longGrid.add(new ArrayList<>(LongStream.range(0, width).map(j -> -1L).boxed().toList())));
    }

    private void setupBooleanGrid() {

        possibleWays = new ArrayList<>();
        IntStream.range(0, height)
                .forEach(i -> possibleWays.add(
                        new ArrayList<>(IntStream.range(0, width)
                                .mapToObj(j -> false).toList())
                ));
    }

    public void printOut(List<List<Long>> longGrid) {
        for (int i = 0; i < longGrid.size(); i++) {
            for (int j = 0; j < longGrid.get(i).size(); j++) {
                System.out.print(String.format("%2s", longGrid.get(i).get(j)));
            }
            System.out.println();
        }
    }

    public void printOutGrid() {
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                System.out.print(grid.get(i).get(j).sign);
            }
            System.out.println();
        }
    }

    List<GridCoordinate> workArround(List<List<Long>> longGrid, GridCoordinate currentPosition) {
        System.out.println(currentPosition);
        Tile currentTile = currentPosition.getTileFromTileGrid(this);
        long currentLong = currentPosition.getLongFromLongGrid(longGrid);

        List<GridCoordinate> possibleFurtherPosition = new ArrayList<>();
        if (currentTile == Tile.GROUND) {
            return possibleFurtherPosition;
        }
//        if (currentTile == Tile.S && currentPosition.getLongFromLongGrid(longGrid) == 0L) {
//            return possibleFurtherPosition;
//        }
        if (currentTile == Tile.S && currentPosition.getLongFromLongGrid(longGrid) == -1L) {
            longGrid.get(currentPosition.y()).set(currentPosition.x(), 0L);
            currentLong = 0L;
        }

        if (currentTile != Tile.S) {
            if (setDistanceValue(currentPosition, currentTile, currentTile.connecting1, longGrid, currentLong)) {
                possibleFurtherPosition.add(currentPosition.getCoordinate(currentTile.connecting1));
            }
            if (setDistanceValue(currentPosition, currentTile, currentTile.connecting2, longGrid, currentLong)) {
                possibleFurtherPosition.add(currentPosition.getCoordinate(currentTile.connecting2));
            }
        } else {
            if (setDistanceValue(currentPosition, currentTile, Direction.NORTH, longGrid, currentLong)) {
                possibleFurtherPosition.add(currentPosition.getCoordinate(Direction.NORTH));
            }
            if (setDistanceValue(currentPosition, currentTile, Direction.WEST, longGrid, currentLong)) {
                possibleFurtherPosition.add(currentPosition.getCoordinate(Direction.WEST));
            }
            if (setDistanceValue(currentPosition, currentTile, Direction.SOUTH, longGrid, currentLong)) {
                possibleFurtherPosition.add(currentPosition.getCoordinate(Direction.SOUTH));
            }
            if (setDistanceValue(currentPosition, currentTile, Direction.EAST, longGrid, currentLong)) {
                possibleFurtherPosition.add(currentPosition.getCoordinate(Direction.EAST));
            }
        }

        return possibleFurtherPosition;
    }

    boolean setDistanceValue(GridCoordinate currentPosition, Tile currentTile, Direction direction, List<List<Long>> longGrid, long currentLong) {
        GridCoordinate coordinate = currentPosition.getCoordinate(direction);
        Tile tileForCoordinate = coordinate.getTileFromTileGrid(this);
        if (tileForCoordinate == null) {
            return false;
        }

        if (currentTile.isConnectable(tileForCoordinate, direction)) {
            if (coordinate.getLongFromLongGrid(longGrid) == -1L) {
                longGrid.get(coordinate.y()).set(coordinate.x(), currentLong + 1);
                return true;
//                workArround(longGrid, coordinate);
            } else {
//                return false;
                long actualValue = coordinate.getLongFromLongGrid(longGrid);
                if (actualValue > currentLong + 1) {
                    longGrid.get(coordinate.y()).set(coordinate.x(), currentLong + 1);
                    return true;
//                    workArround(longGrid, coordinate);
                }
                return true;
            }
        }
        return false;
    }


    public static List<Tile> parseToTileLine(String line) {
        List<Tile> tiles = line.chars().mapToObj(c -> Character.valueOf((char) c)).map(Tile::parse).toList();
        return new ArrayList<>(tiles);
    }
}

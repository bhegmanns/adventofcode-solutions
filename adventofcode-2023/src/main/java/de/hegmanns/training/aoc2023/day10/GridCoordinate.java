package de.hegmanns.training.aoc2023.day10;

import java.time.Year;
import java.util.List;

public record GridCoordinate(int x, int y) {

    public Tile getTileFromTileGrid(TileGrid tileGrid) {
//        if (y < 0 || x < 0) {
//            return null;
//        }
//        if (y > tileGrid.grid.size() || x > tileGrid.grid.get(0).size()) {
//            return null;
//        }
        try {
            return tileGrid.grid.get(y).get(x);
        }catch(Exception e){
            return null;
        }
    }

    public long getLongFromLongGrid(List<List<Long>> longGrid) {
        return longGrid.get(y).get(x);
    }

    public GridCoordinate getCoordinate(Direction direction) {
        return switch (direction) {
            case SOUTH -> new GridCoordinate(x, y + 1);
            case NORTH -> new GridCoordinate(x, y - 1);
            case WEST -> new GridCoordinate(x - 1, y);
            case EAST -> new GridCoordinate(x + 1, y);

            case ALL -> null;
        };
    }
}

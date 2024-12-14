package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2023.day10.Direction;
import de.hegmanns.training.aoc2023.day10.GridCoordinate;
import de.hegmanns.training.aoc2023.day10.TileGrid;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;

public class SolutionDay10 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        SolutionDay10 solution = new SolutionDay10();
        System.out.println("Part 1: " + solution.getSolution1());
        System.out.println("===");
        System.out.println("Part 2: " + solution.getSolution2());
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay09.class, "day10t.txt");
    }


    @Override
    public Long solvePart1(List<String> input) {
        TileGrid tileGrid = new TileGrid();
        input.stream().map(TileGrid::parseToTileLine).forEach(tileGrid::addTileLineIntoGrid);

        List<List<Long>> lists = tileGrid.calculateFarthestPointLoop();
        tileGrid.printOutGrid();
        System.out.println();
        tileGrid.printOut(lists);


        System.out.println("---");
        tileGrid.printOut(lists);

        long currentValue = -1;
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                currentValue = Math.max(lists.get(i).get(j), currentValue);
            }
        }
        return currentValue;
    }

    private List<GridCoordinate> getCoordinates(List<List<Long>> lists, GridCoordinate coordinate) {
        GridCoordinate coordinate1 = coordinate.getCoordinate(Direction.NORTH);
        GridCoordinate coordinate2 = coordinate.getCoordinate(Direction.WEST);
        GridCoordinate coordinate3 = coordinate.getCoordinate(Direction.EAST);
        GridCoordinate coordinate4 = coordinate.getCoordinate(Direction.SOUTH);

        List<GridCoordinate> coords = new ArrayList<>();
        coords.add(coordinate1);
        coords.add(coordinate2);
        coords.add(coordinate3);
        coords.add(coordinate4);

        List<GridCoordinate> result = new ArrayList<>();
        for (var c : coords) {
            if (c.x() < 0 || c.y() < 0) {
                continue;
            }
            try{
                Long l = lists.get(c.y()).get(c.x());
                if (l != -1) {
                    result.add(c);
                }
            }catch(Exception e){
                continue;
            }
        }
        return result;
    }

    @Override
    public Long solvePart2(List<String> input) {
        return null;
    }

    @Override
    public Long getSolution1() {
        return new SolutionDay10().solvePart1(getInputList());
    }

    @Override
    public Long getSolution2() {
        return new SolutionDay10().solvePart2(getInputList());
    }
}

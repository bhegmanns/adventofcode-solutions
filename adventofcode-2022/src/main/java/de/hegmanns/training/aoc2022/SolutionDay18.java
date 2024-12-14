package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2022.day18.Coordinate;
import de.hegmanns.training.aoc2022.day18.Shape;
import de.hegmanns.training.aoc2022.day18.SurfaceArea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionDay18 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay18.class, "day18.txt");

        SolutionDay18 solution = new SolutionDay18();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    @Override
    public Long solvePart1(List<String> input) {

        List<Shape> shapes = parseToShapes(input);

        long countFree = shapes.size()*6;

        for (int i = 0; i < shapes.size(); i++) {
            for (int j = 0; j < shapes.size(); j++) {
                if (shapes.get(i).isConnected(shapes.get(j))) {
                    countFree--;
                }
            }
        }



        return countFree;
    }

    @Override
    public Long solvePart2(List<String> input) {
        long surfaceRate = solvePart1(input);
        List<Shape> shapes = parseToShapes(input);

        SurfaceArea surfaceArea = new SurfaceArea(shapes);
        Coordinate[] boundary = surfaceArea.getBoundary();

        Coordinate minBoundary = new Coordinate(boundary[0].getX() + 1, boundary[0].getY() + 1, boundary[0].getZ() + 1);
        Coordinate maxBoundary = new Coordinate(boundary[1].getX() - 1, boundary[1].getY() - 1, boundary[1].getZ() - 1);

        for (int z = minBoundary.getZ(); z <= maxBoundary.getZ(); z++) {
            for (int x = minBoundary.getX(); x <= maxBoundary.getX(); x++) {
                for (int y = minBoundary.getY(); x <= maxBoundary.getZ(); y++) {

                }
            }

        }
        return null;
    }

    @Override
    public Long getSolution1() {
        return null;
    }

    @Override
    public Long getSolution2() {
        return null;
    }

    private List<Shape> parseToShapes(List<String> input) {
        //2,2,2
        List<Shape> shapes = new ArrayList<>(input.size());
        for (String line : input) {
            String[] splitLine = line.split(",");
            int[] ints = Arrays.stream(splitLine).mapToInt(Integer::parseInt).toArray();
            shapes.add(new Shape(ints[0], ints[1], ints[2]));
        }

        return shapes;
    }
}

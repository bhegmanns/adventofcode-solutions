package de.hegmanns.training.aoc2021;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2021.day05.Line;
import de.hegmanns.training.aoc2021.day05.Point;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SolutionDay05 implements AoCSolution<Integer, Integer> {

    public static void main(String[] args) {
        List<String> input = AoCFileReader.getInputAsList(SolutionDay05.class, "day05.txt");
        SolutionDay05 solution = new SolutionDay05();
        System.out.println("part1 >>> " + solution.solvePart1(input));
        System.out.println("part2 >>> " + solution.solvePart2(input));
    }

    @Override
    public Integer solvePart1(List<String> input) {
        List<Line> relevantLines = input.stream().map(i -> new Line(i)).filter(l -> l.isHorizontal() || l.isVertical()).collect(Collectors.toList());
        return getCountOfAtLeastTimesOverlappedPoints(relevantLines, 2);
    }

    @Override
    public Integer solvePart2(List<String> input) {
        List<Line> relevantLines = input.stream().map(i -> new Line(i)).filter(l -> l.isDiagonal() || l.isHorizontal() || l.isVertical()).collect(Collectors.toList());
        return getCountOfAtLeastTimesOverlappedPoints(relevantLines, 2);
    }

    private static void incrementForPoint(Map<Point, Integer> map, Point point) {
        Integer i = map.get(point);
        if (i == null) {
            i = 0;
        }
        map.put(point, i + 1);
    }

    public static Map<Point, Integer> getMapOfCountOfOverlappedPoints(List<Line> lines) {
        return
                lines.stream()
                        .map(Line::getOverlappedPoints)
                        .flatMap(x -> x.stream())
                        .collect(
                                HashMap::new,
                                SolutionDay05::incrementForPoint,
                                (m1, m2) -> m1.putAll(m2)
                        );

    }

    protected static int getCountOfAtLeastTimesOverlappedPoints(List<Line>  lines,int minimumOverlapCount) {
        return (int) getMapOfCountOfOverlappedPoints(lines).values().stream().filter(i -> i >= minimumOverlapCount).count();
    }
}

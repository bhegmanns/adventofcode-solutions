package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2022.day14.Sensor;
import de.hegmanns.training.aoc2022.day14.SensorBeaconMap;

import java.util.List;

public class SolutionDay15 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay15.class, "day15.txt");

        SolutionDay15 solution = new SolutionDay15(2000000L);
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    private long interestedLine;

    public SolutionDay15(long interestedLine) {
        this.interestedLine = interestedLine;
    }
    @Override
    public Long solvePart1(List<String> input) {

        SensorBeaconMap sensorBeaconMap = new SensorBeaconMap();
        input.stream().map(Sensor::createFromDefinitionLine).forEach(sensorBeaconMap::addSensor);

        return sensorBeaconMap.calculateCountOfNotContainedBeaconsInLine(interestedLine);
    }

    @Override
    public Long solvePart2(List<String> input) {
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
}

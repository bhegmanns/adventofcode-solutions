package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2023.day05.Almanach;
import de.hegmanns.training.aoc2023.day05.MappingRule;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SolutionDay05 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        SolutionDay05 solution = new SolutionDay05();
        System.out.println("Part 1: " + solution.getSolution1());
        System.out.println("===");
        System.out.println("Part 2: " + solution.getSolution2());
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay05.class, "day05t.txt");
    }

    @Override
    public Long solvePart1(List<String> input) {
        Almanach almanach = new Almanach();

        String seeds = input.get(0);
        MappingRule currentMappingRule = null;
        MappingRule.MappingRuleBuilder builder = null;
        for (int i = 1; i < input.size(); i++) {
            String line = input.get(i);
            if (line.isBlank() || line.isEmpty()) {
                if (builder != null) {
                    almanach.addMappingRule(builder.build());
                    builder = null;
                }
                continue;
            }
            if (line.contains("map")) {
                int indexOfMap = line.indexOf("map");
                builder = MappingRule.MappingRuleBuilder.create(line.substring(0, indexOfMap));
            } else {
                builder.withDefinitionLine(line);
            }
        }
        if (builder != null) {
            almanach.addMappingRule(builder.build());
        }
        //seeds: 79 14 55 13
        String[] split = seeds.split(":");
        String[] split1 = split[1].trim().split(" ");
        List<String> split11 = List.of(split1);
        List<Long> collect = split11.stream().map(Long::parseLong).collect(Collectors.toList());
        Map<Long, Long> locationsFromSeed = almanach.getLocationsFromSeed("seed", "location", collect);
        return locationsFromSeed.values().stream().min(Long::compareTo).get();
    }

    @Override
    public Long solvePart2(List<String> input) {
        Almanach almanach = new Almanach();

        String seeds = input.get(0);
        MappingRule currentMappingRule = null;
        MappingRule.MappingRuleBuilder builder = null;
        for (int i = 1; i < input.size(); i++) {
            String line = input.get(i);
            if (line.isBlank() || line.isEmpty()) {
                if (builder != null) {
                    almanach.addMappingRule(builder.build());
                    builder = null;
                }
                continue;
            }
            if (line.contains("map")) {
                int indexOfMap = line.indexOf("map");
                builder = MappingRule.MappingRuleBuilder.create(line.substring(0, indexOfMap));
            } else {
                builder.withDefinitionLine(line);
            }
        }
        if (builder != null) {
            almanach.addMappingRule(builder.build());
        }
        //seeds: 79 14 55 13
        String[] split = seeds.split(":");
        String[] split1 = split[1].trim().split(" ");
        List<String> split11 = List.of(split1);
        List<Long> collect = split11.stream().map(Long::parseLong).collect(Collectors.toList());
        long lowestNumber = Long.MAX_VALUE;
        for (int i = 0; i < collect.size(); i+=2) {
            System.out.println("seed " + collect.get(i) + ":" + collect.get(i+1) );
            lowestNumber = Math.min(lowestNumber,
                    almanach.getLowestNumber("seed", "location", collect.get(i), collect.get(i +1)));
        }
        return lowestNumber;
    }

    @Override
    public Long getSolution1() {
        return (new SolutionDay05()).solvePart1(getInputList());
    }

    @Override
    public Long getSolution2() {
        return (new SolutionDay05()).solvePart2(getInputList());
    }
}

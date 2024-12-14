package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2023.day03.NumberAtPosition;
import de.hegmanns.training.aoc2023.day03.StringAnalyser;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import java.util.*;
import java.util.stream.Collectors;

public class SolutionDay03 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        SolutionDay03 solution = new SolutionDay03();
        System.out.println("Part 1: " + solution.getSolution1());
        System.out.println("===");
        System.out.println("Part 2: " + solution.getSolution2());
    }

    private List<String> createRaster(List<String> lineDefinitions) {
        int length = lineDefinitions.get(0).length();

        List<String> raster = new ArrayList<>();
        raster.add(".".repeat(length+2));
        for (String line : lineDefinitions) {
            raster.add("." + line + ".");
        }
        raster.add(".".repeat(length+2));

        return raster;
    }



    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay01.class, "day03t.txt");
    }

    @Override
    public Long solvePart1(List<String> input) {
        List<String> raster = createRaster(input);
        long sum = 0;

        for (int i = 1 ; i < raster.size() ; i++) {
            List<NumberAtPosition> allNumbers = StringAnalyser.findAllNumbers(raster.get(i));

            for (NumberAtPosition numberAtPosition : allNumbers) {
                int startPosition = numberAtPosition.getStartPosition();
                int finalPosition = numberAtPosition.getFinalPosition();
                // same line
                String s = raster.get(i).substring(startPosition-1, finalPosition+1);
                if (StringAnalyser.containsSymbols(s)) {
                    sum += numberAtPosition.getNumber();
                    continue;
                }
                // line above
                s = raster.get(i-1).substring(startPosition - 1, finalPosition + 1);
                if (StringAnalyser.containsSymbols(s)) {
                    sum += numberAtPosition.getNumber();
                    continue;
                }
                // line under
                s = raster.get(i + 1).substring(startPosition - 1, finalPosition + 1);
                if (StringAnalyser.containsSymbols(s)) {
                    sum += numberAtPosition.getNumber();
                    continue;
                }

            }

        }
        return sum;
    }

    private static record FromTo(int line, int firstPosition, int lastPosition) {

        public boolean contains(int x, int y) {
            return y == line && x >= firstPosition && x <= lastPosition;
        }
    }
    @Override
    public Long solvePart2(List<String> input) {
        List<String> raster = createRaster(input);
        Map<Integer, List<Integer>> posititionsOfStarsInLine = new HashMap<>();
        Map<FromTo, NumberAtPosition> numbersInLines = new HashMap<>();
        for (int i = 0; i < raster.size(); i++) {
            var starsInCurrentLine = StringAnalyser.getPositionsOfSymbol(raster.get(i), '*');
            posititionsOfStarsInLine.put(i, starsInCurrentLine);
            List<NumberAtPosition> allNumbers = StringAnalyser.findAllNumbers(raster.get(i));
            int finalI = i;
            allNumbers.forEach(n -> numbersInLines.put(new FromTo(finalI, n.getStartPosition(), n.getFinalPosition() - 1), n));
        }

        long sum = 0;
        for (int line = 0; line < raster.size(); line++) {
            List<Integer> starPositionsOfLine = posititionsOfStarsInLine.get(line);
            if (starPositionsOfLine != null && !starPositionsOfLine.isEmpty()) {
                int finalLine = line;
                for (int x : starPositionsOfLine) {
                    List<FromTo> left = numbersInLines.keySet().stream().filter(f -> f.contains(x-1, finalLine)).collect(Collectors.toList());
                    List<FromTo> right= numbersInLines.keySet().stream().filter(f -> f.contains(x+1, finalLine)).collect(Collectors.toList());

                    List<FromTo> above1 = numbersInLines.keySet().stream().filter(f -> f.contains(x-1, finalLine-1)).collect(Collectors.toList());
                    List<FromTo> above2 = numbersInLines.keySet().stream().filter(f -> f.contains(x, finalLine-1)).collect(Collectors.toList());
                    List<FromTo> above3 = numbersInLines.keySet().stream().filter(f -> f.contains(x+1, finalLine-1)).collect(Collectors.toList());

                    List<FromTo> down1 = numbersInLines.keySet().stream().filter(f -> f.contains(x-1, finalLine+1)).collect(Collectors.toList());
                    List<FromTo> down2 = numbersInLines.keySet().stream().filter(f -> f.contains(x, finalLine+1)).collect(Collectors.toList());
                    List<FromTo> down3 = numbersInLines.keySet().stream().filter(f -> f.contains(x+1, finalLine+1)).collect(Collectors.toList());

                    Set<FromTo> set = new HashSet<>();
                    set.addAll(left);
                    set.addAll(right);
                    set.addAll(above1);
                    set.addAll(above2);
                    set.addAll(above3);
                    set.addAll(down1);
                    set.addAll(down2);
                    set.addAll(down3);

                    if (set.size() > 2) {
                        throw new RuntimeException("Problem Star(" + x + line + ") has " + set.size() + " neighbar-numbers.");
                    }
                    if (set.size() == 2) {
                        List<Long> collect = set.stream().map(f -> numbersInLines.get(f)).map(NumberAtPosition::getNumber).collect(Collectors.toList());
                        sum += collect.get(0) * collect.get(1);
                    }
                }
            }
        }

        return sum;
    }

    @Override
    public Long getSolution1() {
        return (new SolutionDay03()).solvePart1(getInputList());
    }

    @Override
    public Long getSolution2() {
        return (new SolutionDay03()).solvePart2(getInputList());
    }
}

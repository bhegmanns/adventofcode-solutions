package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SolutionDay20 implements AoCSolution<Long, Long> {

    public record Number(long value, int index) {
    }

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay20.class, "day20.txt");

        SolutionDay20 solution = new SolutionDay20();

        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }


    @Override
    public Long solvePart1(List<String> input) {
        List<Long> collect = input.stream().map(Long::parseLong).toList();

        AtomicInteger indexCoder = new AtomicInteger(0);

        List<Number> groveNumbers = collect.stream().map(v -> new Number(v, indexCoder.getAndIncrement())).toList();
        System.out.printf("" + groveNumbers.get(0));

        List<Number> solution = new ArrayList<>(groveNumbers);

        for (Number number : groveNumbers) {
            int index = solution.indexOf(number);
            solution.remove(index);
            int newIndex = Math.floorMod(index + number.value(), solution.size());


            solution.add(newIndex, number);
        }

        Number firstZero = solution.stream().filter(g -> g.value() == 0).findFirst().orElseThrow();
        int indexOfFirstZero = solution.indexOf(firstZero);

        Number first = solution.get((indexOfFirstZero + 1000) % solution.size());
        Number second = solution.get((indexOfFirstZero + 2000) % solution.size());
        Number third = solution.get((indexOfFirstZero + 3000) % solution.size());


        return first.value() + second.value() + third.value();
    }

    private static final long FAKTOR = 811589153L;
    @Override
    public Long solvePart2(List<String> input) {
        List<Long> collect = input.stream().map(Long::parseLong).toList();

        AtomicInteger indexCoder = new AtomicInteger(0);

        List<Number> groveNumbers = collect.stream().map(v -> new Number(v * FAKTOR, indexCoder.getAndIncrement())).toList();
        List<Number> solution = new ArrayList<>(groveNumbers);

        for (int i = 0; i < 10; i++) {
            System.out.printf("");
            for (Number number : groveNumbers) {
                int index = solution.indexOf(number);
                solution.remove(index);
                int newIndex = Math.floorMod(index + number.value(), solution.size());

                solution.add(newIndex, number);
            }
        }

        Number firstZero = solution.stream().filter(g -> g.value() == 0).findFirst().orElseThrow();
        int indexOfFirstZero = solution.indexOf(firstZero);

        Number first = solution.get((indexOfFirstZero + 1000) % solution.size());
        Number second = solution.get((indexOfFirstZero + 2000) % solution.size());
        Number third = solution.get((indexOfFirstZero + 3000) % solution.size());
        return first.value() + second.value() + third.value();
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

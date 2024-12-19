package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2024.day07.*;
import java.util.List;

public class SolutionDay07 implements AoCSolution<Long, Long> {
    public static final String FILE_NAME = "day07_task.txt";


    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay07.class, FILE_NAME);

        SolutionDay07 solution = new SolutionDay07();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("===");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay07.class, FILE_NAME);
    }


    @Override
    public Long solvePart1(List<String> input) {
        List<Operation> operations = input.stream().map(Operation::parse).toList();
        return operations.stream().map(o -> o.atLeastOneOperatorExistsForOperandAndResult(Operator.PLUS, Operator.TIMES)?o.getExpectedResult():0L)
                .mapToLong(Long::longValue).sum();
    }


    @Override
    public Long solvePart2(List<String> input) {
        List<Operation> operations = input.stream().map(Operation::parse).toList();
        return operations.stream().map(o -> o.atLeastOneOperatorExistsForOperandAndResult(Operator.PLUS, Operator.TIMES, Operator.CONCATENATE)?o.getExpectedResult():0L)
                .mapToLong(Long::longValue).sum();
    }

    @Override
    public Long getSolution1() {
        return solvePart1(getInputList());
    }

    @Override
    public Long getSolution2() {
        return solvePart2(getInputList());
    }
}

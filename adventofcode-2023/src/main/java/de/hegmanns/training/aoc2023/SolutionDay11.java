package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2023.day11.Matrix;
import de.hegmanns.training.aoc2023.day11.MatrixElementValue;
import de.hegmanns.training.aoc2023.day11.MatrixPosition;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
public class SolutionDay11 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        SolutionDay11 solution = new SolutionDay11();
        System.out.println("Part 1: " + solution.getSolution1());
        System.out.println("===");
        System.out.println("Part 2: " + solution.getSolution2());
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay11.class, "day11t.txt");
    }

    @Override
    public Long solvePart1(List<String> input) {
        Matrix matrix = buildFromInput(input);
        long sum = resolvePart2WithExtension(matrix, 2);
        return sum;
    }

    public static long resolvePart2WithExtension(Matrix matrix, int extension) {

        int rowsToExtend = 0;
        for (int row = matrix.getCountOfRows() - 1; row >= 0; row--) {
            if (!matrix.getRowAsString(row).chars().filter(c -> c != '.').findAny().isPresent()) {
                matrix.douplicateRow(row, extension-1);
                rowsToExtend++;
            }
        }



        int columnsToExtend = 0;
        for (int column = matrix.getCountOfColumns()-1; column >=0; column--) {
            if (!matrix.getColumnAsString(column).chars().filter(c -> c != '.').findAny().isPresent()) {
                matrix.douplicateColumn(column, extension-1);
                columnsToExtend++;
            }
        }


        List<MatrixElementValue> allGalaxies = matrix.filter(s -> s == '#');

        long sum = 0L;
        for (int i = 0; i < allGalaxies.size(); i++) {
            for (int j = i + 1; j < allGalaxies.size(); j++) {
                MatrixPosition from = allGalaxies.get(i).position();
                MatrixPosition to = allGalaxies.get(j).position();
                long way = matrix.calculateDifference(from, to);
                sum += way;
            }
        }

        log.error("extended row {}", rowsToExtend);
        log.error("extended columns {}", columnsToExtend);

        return sum;
    }

    public static Matrix buildFromInput(List<String> input) {
        Matrix.MatrixBuilder builder = Matrix.MatrixBuilder.create();
        input.forEach(builder::withLineOfCharacters);

        return builder.build();
    }

    @Override
    public Long solvePart2(List<String> input) {
        Matrix matrix = buildFromInput(input);
        long sum = resolvePart2WithExtension(matrix, 1000000);

        return sum;
    }

    @Override
    public Long getSolution1() {
        return new SolutionDay11().solvePart1(getInputList());
    }

    @Override
    public Long getSolution2() {
        return new SolutionDay11().solvePart2(getInputList());
    }
}

package de.hegmanns.training.aoc2023.day11;

public record MatrixPosition(int column, int row) {

    public int calculateWayDifference(MatrixPosition matrixPosition) {
        int diffColumns = column - matrixPosition.column;
        int diffRows = row - matrixPosition.row;

        return Math.abs(diffColumns) + Math.abs(diffRows);
    }
}

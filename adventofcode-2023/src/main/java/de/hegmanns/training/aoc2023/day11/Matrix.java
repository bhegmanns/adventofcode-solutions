package de.hegmanns.training.aoc2023.day11;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Matrix {

    public enum ColumnShift{
        LEFT, RIGHT;
    }
    public enum RowShift{
        UP, DOWN;
    }

    /**
     * content[column][row]
     * content[x][y]
     *
     */
    private char[][] content;
    @Getter
    private int countOfColumns;
    @Getter
    private int countOfRows;


    private Map<Integer, Integer> douplicatedColumns = new HashMap<>();
    private Map<Integer, Integer> douplicatedRows = new HashMap<>();

    private Matrix(int initialCountOfColumns, int initialCountOfRows){
        content = new char[initialCountOfColumns][initialCountOfRows];
        this.countOfColumns = initialCountOfColumns;
        this.countOfRows = initialCountOfRows;
    }

    public long calculateDifference(MatrixPosition from, MatrixPosition to) {
        long difference = from.calculateWayDifference(to);

        int minimumColumn = Math.min(from.column(), to.column());
        int maximumColumn = Math.max(from.column(), to.column());
        int minimumRow = Math.min(from.row(), to.row());
        int maximumRow = Math.max(from.row(), to.row());

        long sumOfAdditionalRowSpaces = this.douplicatedRows.entrySet()
                .stream().filter(e -> e.getKey() > minimumRow && e.getKey() < maximumRow).mapToLong(e -> (long) e.getValue()).sum();

        long sumOfAdditionalColumnSpaces = this.douplicatedColumns.entrySet()
                .stream().filter(e -> e.getKey() > minimumColumn && e.getKey() < maximumColumn)
                .mapToLong(e -> (long) e.getValue()).sum();



        return difference + sumOfAdditionalColumnSpaces + sumOfAdditionalRowSpaces;
    }

    public void douplicateRow(int rowIndex, int factor) {
        douplicatedRows.put(rowIndex, factor);
    }

    public void douplicateColumn(int columnIndex, int factor) {
        douplicatedColumns.put(columnIndex, factor);
    }

    private void setMatrixRow(char[] row, int rowIndex) {
        for (int column = 0; column <countOfColumns; column++) {
            content[column][rowIndex] = row[column];
        }
    }

    private void setAllElementsAsLinesIntoMatrix(List<String> lineContents) {
        int index = 0;
        for (var line : lineContents) {
            char[] charArray = line.toCharArray();
            setMatrixRow(charArray, index++);
        }
    }

    public String getRowAsString(int rowIndex) {
        StringBuilder builder = new StringBuilder("");
        for (int currentColumn = 0; currentColumn < countOfColumns; currentColumn++) {
            builder.append("" + content[currentColumn][rowIndex]);
        }
        return builder.toString();
    }

    public String getColumnAsString(int columnIndex) {
        if (columnIndex < 0 || columnIndex > countOfColumns) {
            throw new IllegalArgumentException("expected columnIndex " + columnIndex + " is out of bounds");
        }
        return new String(content[columnIndex]);
    }

    public void addRow(char[] row, int rowIndex) {
        if (row.length != countOfColumns) {
            throw new IllegalArgumentException("expected " + countOfColumns + " elements to add");
        }

        char[][] newContent = new char[countOfColumns][countOfRows+1];

        for (int currentColumn = 0; currentColumn < countOfColumns; currentColumn++) {
            for (int currentRow = 0; currentRow < rowIndex; currentRow++) {
                newContent[currentColumn][currentRow] = content[currentColumn][currentRow];
            }
        }

        //insert row
        for (int currentColumn = 0; currentColumn < countOfColumns; currentColumn++) {
            newContent[currentColumn][rowIndex] = row[currentColumn];
        }

        // the rest
        for (int currentColumn = 0; currentColumn < countOfColumns; currentColumn++) {
            for (int currentRow = rowIndex; currentRow < countOfRows; currentRow++) {
                newContent[currentColumn][currentRow+1] = content[currentColumn][currentRow];
            }
        }

        countOfRows++;
        content = newContent;
    }

    public void addColumnWithEqualContent(char content, int columnIndex) {
        char[] charArray = ("" + content).repeat(countOfRows).toCharArray();
        addColumn(charArray, columnIndex);
    }

    public void addRowWithEqualContent(char content, int rowIndex) {
        char[] charArray = ("" + content).repeat(countOfColumns).toCharArray();
        addRow(charArray, rowIndex);
    }
    public void addColumn(char[] column, int columnIndex) {
        if (column.length != countOfRows) {
            throw new IllegalArgumentException("expected " + countOfRows + " length");
        }
        char[][] newContent = new char[countOfColumns+1][countOfRows];

        for (int currentColumn = 0; currentColumn < columnIndex; currentColumn++) {
            for (int currentRow = 0; currentRow < countOfRows; currentRow++) {
                newContent[currentColumn][currentRow] = content[currentColumn][currentRow];
            }
        }

        //insert column
        for (int currentRow = 0; currentRow < countOfRows; currentRow++) {
            newContent[columnIndex][currentRow] = column[currentRow];
        }

        // the rest
        for (int currentColumn = columnIndex; currentColumn < countOfColumns; currentColumn++) {
            for (int currentRow = 0; currentRow < countOfRows; currentRow++) {
                newContent[currentColumn+1][currentRow] = content[currentColumn][currentRow];
            }
        }

        countOfColumns++;
        content = newContent;
    }



    public List<MatrixElementValue> filter(Predicate<Character> characterPredicate) {
        List<MatrixElementValue> result = new ArrayList<>();
        for (int i = 0; i < countOfColumns; i++) {
            for (int j = 0; j < countOfRows; j++) {
                if (characterPredicate.test(content[i][j])) {
                    result.add(new MatrixElementValue(content[i][j], new MatrixPosition(i, j)));
                }
            }
        }
        return result;
    }

    public void printOut() {
        for (int currentRow = 0; currentRow < countOfRows; currentRow++) {
            for (int currentColumn = 0; currentColumn < countOfColumns; currentColumn++) {
                System.out.print(content[currentColumn][currentRow]);
            }
            System.out.println();
        }
    }



    public static class MatrixBuilder{

        private List<String> linesOfCharacters = new ArrayList<>();
        private int matrixWith;
        public static MatrixBuilder create(){
            return new MatrixBuilder();
        }

        public MatrixBuilder withLineOfCharacters(String lineOfCharacters) {
            if (linesOfCharacters.size() == 0) {
                matrixWith=lineOfCharacters.length();
            }
            if (lineOfCharacters.length() != matrixWith) {
                throw new IllegalArgumentException("unexpected line length, expected equal length of all lines (" + matrixWith + ")");
            }
            linesOfCharacters.add(lineOfCharacters);
            return this;
        }

        public Matrix build() {
            Matrix m = new Matrix(linesOfCharacters.get(0).length(), linesOfCharacters.size());
            m.setAllElementsAsLinesIntoMatrix(linesOfCharacters);
            return m;
        }
    }
}

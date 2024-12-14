package de.hegmanns.training.aoc2023.day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReflectionPattern {


    private List<String> lines = new ArrayList<>();
    private List<String> columns = new ArrayList<>();

    public ReflectionPattern(List<String> lines) {
        this.lines = lines;
        for (int row = 0; row < this.lines.get(0).length(); row++) {

            StringBuilder rowBuilder = new StringBuilder("");
            for (int line = 0; line < lines.size(); line++) {
                rowBuilder.append(""+lines.get(line).charAt(row));
            }
            columns.add(rowBuilder.toString());
        }
    }

    public void printout() {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public List<String> getLines() {
        return lines;
    }

    public List<String> getColumns() {
        return columns;
    }

    public int findHorizontalReflectionLineWithSmudge() {
        int horizontalReflectionLineWithoutSmudge = findHorizontalReflectionLine();
        System.out.println("reflectionLineWithoutSmudge=" + horizontalReflectionLineWithoutSmudge);
        printout();
        System.out.println();
        for (int row = 0; row < lines.size(); row++) {
            String currentRow = lines.get(row);
            for (int column = 0; column < columns.size(); column++) {
                StringBuilder smdugeRow = new StringBuilder(currentRow);
                char charAtPosition = currentRow.charAt(column);
                char newCharAtPosition = switch (charAtPosition) {
                    case '.' -> '#';
                    case '#' -> '.';
                    default -> throw new IllegalStateException("Unexpected value: " + charAtPosition);
                };
                smdugeRow.setCharAt(column, newCharAtPosition);
                lines.set(row, smdugeRow.toString());
                int horizontalReflectionLine = findHorizontalReflectionLine();
                if (horizontalReflectionLine != 0) {
                    System.out.println("FOUND for " + row + "," + column + " >>> " + horizontalReflectionLine);
                    if (horizontalReflectionLine == horizontalReflectionLineWithoutSmudge && horizontalReflectionLineWithoutSmudge!=0) {
                        System.out.println("reflection line " + horizontalReflectionLine + " is same as without smudge, go on ...");
                        continue;
                    }
                    printout();
                    return horizontalReflectionLine;
                }
            }
            lines.set(row, currentRow);
        }
        throw new RuntimeException("no result ... :(");
//        return 0;
    }
    public int findVerticalReflectionLineWithSmudge() {
        System.out.println("START findVerticalReflectionLineWithSmudge for ");
        printout();
        System.out.println();
        for (int column = 0; column < columns.size(); column++) {
            StringBuilder currentColumn = new StringBuilder(columns.get(column));
            for (int row = 0; row < lines.size(); row++) {
                StringBuilder smudgeColumn = new StringBuilder(currentColumn.toString());
                char charAtPosition = columns.get(column).charAt(row);
                char newCharAtPosition = switch (charAtPosition) {
                    case '.' -> '#';
                    case '#' -> '.';
                    default -> throw new IllegalStateException("Unexpected value: " + charAtPosition);
                };
                smudgeColumn.setCharAt(row, newCharAtPosition);
                columns.set(column, smudgeColumn.toString());
                int verticalReflectionLine = findVerticalReflectionLine();
                if (verticalReflectionLine != 0) {
                    System.out.println("FOUND for " + column + "," + row + " >>> " + verticalReflectionLine);
                    printout();
                    return verticalReflectionLine;
                }
            }
            columns.set(column, currentColumn.toString());
        }
        return 0;

        /*
        for (int row = 0; row < lines.size(); row++) {
            StringBuilder currentRow = new StringBuilder(lines.get(row));
            for (int column = 0; column < columns.size(); column++) {
                StringBuilder smudgeRow = new StringBuilder(currentRow.toString());
                char chartAtPosition = lines.get(row).charAt(column);
                char newCharAtPosition = switch (chartAtPosition) {
                    case '.' -> '#';
                    case '#' -> '.';
                    default -> throw new IllegalStateException("Unexpected value: " + chartAtPosition);
                };
                smudgeRow.setCharAt(column, newCharAtPosition);
                lines.set(row, smudgeRow.toString());
                int verticalReflectionLine = findVerticalReflectionLine();
                if (verticalReflectionLine != 0) {
                    return verticalReflectionLine;
                }
            }
            lines.set(row, currentRow.toString());
        }
        return 0;

         */
    }

    public int findVerticalReflectionLine() {
        Integer result = null;

        for (int column = 0; column < columns.size(); column++) {
            List<String> leftPart = new ArrayList<>(columns.subList(0, column));
            List<String> rightPart = new ArrayList<>(columns.subList(column, columns.size()));
            Collections.reverse(leftPart);

            int min = Math.min(leftPart.size(), rightPart.size());
            boolean reflected = true;
            if (leftPart.isEmpty() || rightPart.isEmpty()) {
                continue;
            }
            for (int currentRow = 0; currentRow < min; currentRow++) {
                if (!rightPart.get(currentRow).equals(leftPart.get(currentRow))) {
                    reflected=false;
                    break;
                }
            }
            if (reflected) {
                result=column;
                break;
            }
        }

        return result==null?0:result;
    }

    public int findHorizontalReflectionLine() {
        Integer result = null;
        for (int line = 0; line < lines.size(); line++) {
            List<String> upperPart = new ArrayList<>(lines.subList(0, line));
            List<String> bottomPart = new ArrayList<>(lines.subList(line, lines.size()));
            Collections.reverse(upperPart);

            int min = Math.min(bottomPart.size(), upperPart.size());
            boolean reflected = true;
            if (bottomPart.isEmpty() || upperPart.isEmpty()) {
                reflected=false;
                continue;
            }
            for (int currentLine = 0; currentLine < min; currentLine++) {
                if (!bottomPart.get(currentLine).equals(upperPart.get(currentLine))) {
                    reflected=false;
                }
            }

            if (reflected) {
                result = line;
                break;
            }

        }

        return result==null?0:result;
    }




    /*
#.##..##.
..#.##.#.
##......#
##......#
..#.##.#.
..##..##.
#.#.##.#.
*/
/*
#...##..#
#....#..#
..##..###
#####.##.
#####.##.
..##..###
#....#..#
 */


    public static class ReflectionPatternBuilder {
        private List<String> lines = new ArrayList<>();

        List<ReflectionPattern> reflectionPatterns = new ArrayList<>();

        public static ReflectionPatternBuilder create() {
            return new ReflectionPatternBuilder();
        }

        public ReflectionPatternBuilder addLine(String line) {
            if (line == null) {
                return this;
            }
            if (line.trim().isEmpty() || line.trim().isBlank()) {
                reflectionPatterns.add(new ReflectionPattern(lines));
                lines = new ArrayList<>();
            }else{
                lines.add(line);
            }
            return this;
        }

        public List<ReflectionPattern> build() {
            if (!lines.isEmpty()) {
                reflectionPatterns.add(new ReflectionPattern(lines));
            }

            return reflectionPatterns;
        }
    }
}

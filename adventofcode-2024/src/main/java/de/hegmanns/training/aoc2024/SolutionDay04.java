package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.*;

import java.util.*;
import java.util.stream.*;

public class SolutionDay04 implements AoCSolution<Long, Long> {
    public static final String FILE_NAME = "day04_task.txt";

    private String puzzleWord = "XMAS";
    private char firstCharacter = 'X';

    public SolutionDay04() {
        super();
    }

    public SolutionDay04(String puzzleWord, char firstCharacter) {
        super();
        this.puzzleWord = puzzleWord;
        this.firstCharacter = firstCharacter;
    }

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay04.class, FILE_NAME);

        SolutionDay04 solution = new SolutionDay04();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("===");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }

    private static List<String> getInputList() {
        return AoCFileReader.getInputAsList(SolutionDay04.class, FILE_NAME);
    }


    @Override
    public Long solvePart1(List<String> input) {
        long countOfXmas = 0L;
        for (int line = 0 ; line < input.size() ; line++) {
            for (int column = 0 ; column < input.get(line).length() ; column++) {
                char characterInPoint = input.get(line).charAt(column);
                if (characterInPoint == firstCharacter) {
                    if (existsLeft(input, line, column)) {
                        countOfXmas++;
                    }
                    if (existsRight(input, line, column)) {
                        countOfXmas++;
                    }
                    if (existUp(input, line, column)) {
                        countOfXmas++;
                    }
                    if (existDown(input, line, column)) {
                        countOfXmas++;
                    }
                    if (existLeftDown(input, line, column)) {
                        countOfXmas++;
                    }
                    if (existRightDown(input, line, column)) {
                        countOfXmas++;
                    }
                    if (existRightUp(input, line, column)) {
                        countOfXmas++;
                    }
                    if (existLeftUp(input, line, column)) {
                        countOfXmas++;
                    }
                }
            }
        }

        return countOfXmas;
    }

    boolean existsInArray(List<Character> characters) {
        StringBuilder sb = new StringBuilder();
        for (Character character : characters) {
            sb.append("" + character);
        }

        return sb.toString().startsWith(this.puzzleWord);
    }

    List<Character> buildTestStringLeft(List<String> input, int line, int column) {
        String stringInLine = input.get(line);
        String leftPartInLine = stringInLine.substring(0, column+1);
        List<Character> testString = new ArrayList<>();
        StringBuffer sb = new StringBuffer(leftPartInLine);
        for (int c : sb.reverse().chars().toArray()) {
            testString.add((char)c);
        }
        return testString;
    }

    boolean existsLeft(List<String> input, int line, int column) {
        return existsInArray(buildTestStringLeft(input, line, column));
    }

    List<Character> buildTestStringRight(List<String> input, int line, int column) {
        String stringInLine = input.get(line);
        String leftPartInLine = stringInLine.substring(column);
        List<Character> testString = new ArrayList<>();
        StringBuffer sb = new StringBuffer(leftPartInLine);
        for (int c : sb.chars().toArray()) {
            testString.add((char)c);
        }
        return testString;
    }

    private boolean existsRight(List<String> input, int line, int column) {
        return existsInArray(buildTestStringRight(input, line, column));
    }

    List<Character> buildTestStringUp(List<String> input, int line, int column) {
        List<Character> testString = new ArrayList<>();

        for (int l = line ; line>=0 ; line--) {
            testString.add(input.get(line).charAt(column));
        }

        return testString;
    }
    private boolean existUp(List<String> input, int line, int column) {
        return existsInArray(buildTestStringUp(input, line, column));
    }

    List<Character> buildTestStringLeftUp(List<String> input, int line, int column) {
        List<Character> testString = new ArrayList<>();
        int currentColumn = column;
        for (int l = line ; l>=0 ; l--) {
            String currentLine = input.get(l);
            if (currentColumn >=0) {
                testString.add(currentLine.charAt(currentColumn));
                currentColumn--;
            } else {
                break;
            }
        }

        return testString;
    }

    private boolean existLeftUp(List<String> input, int line, int column) {
        return existsInArray(buildTestStringLeftUp(input, line, column));
    }

    List<Character> buildTestStringRightUp(List<String> input, int line, int column) {
        List<Character> testString = new ArrayList<>();

        int currentColumn = column;
        for (int l = line ; line>=0 ; line--) {
            String currentLine = input.get(line);
            if (currentColumn < currentLine.length()) {
                testString.add(input.get(line).charAt(currentColumn));
                currentColumn++;
            } else {
                break;
            }
        }

        return testString;
    }

    private boolean existRightUp(List<String> input, int line, int column) {

        return existsInArray(buildTestStringRightUp(input, line, column));
    }

    List<Character> buildTestStringDown(List<String> input, int line, int column) {
        List<Character> testString = new ArrayList<>();

        for (int currentLine = line ; currentLine<input.size() ; currentLine++) {
            testString.add(input.get(currentLine).charAt(column));
        }

        return testString;
    }

    private boolean existDown(List<String> input, int line, int column) {
        return existsInArray(buildTestStringDown(input, line, column));
    }

    List<Character> buildTestStringLeftDown(List<String> input, int line, int column) {
        List<Character> testString = new ArrayList<>();

        int currentColumn = column;
        for (int currentIndex = line ; currentIndex<input.size() ; currentIndex++) {
            String currentLine = input.get(currentIndex);
            if (currentColumn >= 0) {
                testString.add(currentLine.charAt(currentColumn));
                currentColumn--;
            } else {
                break;
            }
        }

        return testString;
    }
    private boolean existLeftDown(List<String> input, int line, int column) {

        return existsInArray(buildTestStringLeftDown(input, line, column));
    }

    List<Character> buildTestStringRightDown(List<String> input, int line, int column){
        List<Character> testString = new ArrayList<>();

        int currentColumn = column;
        for (int currentIndex = line ; currentIndex<input.size() ; currentIndex++) {
            String currentLine = input.get(currentIndex);
            if (currentColumn < currentLine.length()) {
                testString.add(currentLine.charAt(currentColumn));
                currentColumn++;
            } else {
                break;
            }
        }

        return testString;
    }
    private boolean existRightDown(List<String> input, int line, int column) {

        return existsInArray(buildTestStringRightDown(input, line, column));
    }



    @Override
    public Long solvePart2(List<String> input) {
        long countOfXmas = 0L;
        for (int line = 1 ; line < input.size()-1 ; line++) {
            for (int column = 1 ; column < input.get(line).length()-1 ; column++) {
                char characterInPoint = input.get(line).charAt(column);
                if (characterInPoint == 'A') {
                    String firstDiagonale = "" + input.get(line-1).charAt(column-1) + characterInPoint + input.get(line+1).charAt(column+1);
                    String secondDiagonale = "" + input.get(line-1).charAt(column+1) + characterInPoint + input.get(line+1).charAt(column-1);
                    if (firstDiagonale.equals("MAS") || firstDiagonale.equals("SAM")) {
                        if (secondDiagonale.equals("MAS") || secondDiagonale.equals("SAM")) {
                            countOfXmas++;
                        }
                    }
                }
            }
        }

        return countOfXmas;
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

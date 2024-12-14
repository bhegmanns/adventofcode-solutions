package de.hegmanns.training.aoc2023.day03;

import java.util.ArrayList;
import java.util.List;

public class StringAnalyser {

    public static List<NumberAtPosition> findAllNumbers(String line) {
        List<NumberAtPosition> result = new ArrayList<>();
        if (line == null) {
            return result;
        }

        char[] charArray = line.toCharArray();
        String currentNumberRepresentation = null;
        int currentStartPosition = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
                if (currentNumberRepresentation == null) {
                    currentNumberRepresentation = "" + charArray[i];
                    currentStartPosition = i;
                } else {
                    currentNumberRepresentation += "" + charArray[i];
                }
            } else {
                if (currentNumberRepresentation != null) {
                    NumberAtPosition numberAtPosition = new NumberAtPosition();
                    numberAtPosition.setNumber(Long.parseLong(currentNumberRepresentation));
                    numberAtPosition.setStartPosition(currentStartPosition);
                    numberAtPosition.setFinalPosition(currentStartPosition + currentNumberRepresentation.length());
                    result.add(numberAtPosition);
                    currentNumberRepresentation=null;
                }
            }
        }
        if (currentNumberRepresentation != null) {
            NumberAtPosition numberAtPosition = new NumberAtPosition();
            numberAtPosition.setNumber(Long.parseLong(currentNumberRepresentation));
            numberAtPosition.setStartPosition(currentStartPosition);
            numberAtPosition.setFinalPosition(currentStartPosition + currentNumberRepresentation.length());
            result.add(numberAtPosition);
        }

        return result;
    }

    public static boolean containsSymbols(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                continue;
            } else {
                return true;
            }
        }
        return false;
    }

    public static List<Integer> getPositionsOfSymbol(String s, char expectedSymbol) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == expectedSymbol) {
                positions.add(i);
            }
        }
        return positions;
    }

    public static boolean containsSymbol(String s, char expectedSymbol) {
        return s.contains("" + expectedSymbol);
    }
}

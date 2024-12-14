package de.hegmanns.training.aoc2023.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class OasisCalculator {

    public static List<Long> parseToLongList(String definitionLine) {
        if (definitionLine == null) {
            return Collections.EMPTY_LIST;
        }
        return Arrays.stream(definitionLine.trim().split(" ")).filter(Predicate.not(String::isEmpty)).filter(Predicate.not(String::isBlank))
                .map(String::trim).map(Long::parseLong).toList();
    }

    public static long calculatePreviousOasisValue(List<Long> oasisNumbers) {
        List<List<Long>> numbers = new ArrayList<>();
        numbers.add(new ArrayList<>(oasisNumbers));
        List<Long> currentOasisNumbers = new ArrayList<>(oasisNumbers);

        boolean allZero = true;
        do {
            List<Long> diffNumbers = new ArrayList<>();
            long furtherLong = currentOasisNumbers.get(0);
            allZero=true;
            for (var l : currentOasisNumbers.stream().skip(1).toList()) {
                long difference = l - furtherLong;
                diffNumbers.add(difference);
                allZero = allZero && difference == 0;
                furtherLong = l;
            }
            numbers.add(diffNumbers);
            currentOasisNumbers=diffNumbers;
        } while (!allZero);

        for (int i = numbers.size() - 1; i > 0; i--) {
            List<Long> longs = numbers.get(i);
            Long l = longs.get(0);

            List<Long> formerLongs = numbers.get(i - 1);
            Long formerFirst = formerLongs.get(0);
            formerLongs.add(0, formerFirst-l);
        }

        List<Long> firstLongs = numbers.get(0);
        return firstLongs.get(0);
    }

    public static long calculateNextOasisValue(List<Long> oasisNumbers) {
        List<List<Long>> numbers = new ArrayList<>();
        numbers.add(new ArrayList<>(oasisNumbers));
        List<Long> currentOasisNumbers = new ArrayList<>(oasisNumbers);

        boolean allZero = true;
        do {
            List<Long> diffNumbers = new ArrayList<>();
            long furtherLong = currentOasisNumbers.get(0);
            allZero=true;
            for (var l : currentOasisNumbers.stream().skip(1).toList()) {
                long difference = l - furtherLong;
                diffNumbers.add(difference);
                allZero = allZero && difference == 0;
                furtherLong = l;
            }
            numbers.add(diffNumbers);
            currentOasisNumbers=diffNumbers;
        } while (!allZero);

        for (int i = numbers.size() - 1; i > 0; i--) {
            List<Long> longs = numbers.get(i);
            Long l = longs.get(longs.size() - 1);

            List<Long> formerLongs = numbers.get(i - 1);
            Long formerLast = formerLongs.get(formerLongs.size() - 1);
            formerLongs.add(l + formerLast);
        }


        List<Long> firstLongs = numbers.get(0);
        return firstLongs.get(firstLongs.size() - 1);
    }
}

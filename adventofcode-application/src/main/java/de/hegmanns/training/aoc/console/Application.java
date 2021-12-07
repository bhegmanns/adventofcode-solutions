package de.hegmanns.training.aoc.console;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;

import java.lang.reflect.Constructor;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Year currentYear = Year.now();
        String basePackageName = createBasePackageName(currentYear.getValue());

        System.out.println("solutions for advent-of-code - " + currentYear.getValue());

        for (int i = 1; i < 25; i++) {
            SolutionPair solutionPair = null;
            AocApplicationException currentAocApplicationException = null;
            try {
                solutionPair = proceedFor(basePackageName, i);
                System.out.println("-- DAY " + String.format("%1$02d", i) + " --");
            } catch (AocApplicationException e) {
                if (e.isWriteDown()) {
                    System.out.println("-- DAY " + String.format("%1$02d", i) + " --");
                    currentAocApplicationException = e;
                } else {
                    continue;
                }
            } catch (Exception e) {
                continue;
            }
            if (solutionPair.getSolutionPart1() != null) {
                System.out.println(" PART 1 >>> " + solutionPair.getSolutionPart1());
            } else{
                if (currentAocApplicationException != null && currentAocApplicationException.isErrorPart1()) {
                    System.out.println(" PART 1 >>> EXECUTION ERROR");
                }
            }

            if (solutionPair.getSolutionPart2() != null) {
                System.out.println(" PART 2 >>> " + solutionPair.getSolutionPart2());
            } else {
                if (currentAocApplicationException != null && currentAocApplicationException.isErrorPart2()) {
                    System.out.println(" PART 2 >>> EXECUTION ERROR");
                }
            }
            System.out.println();
        }
    }

    private static SolutionPair proceedFor(String basePackage, int day) {
        String daystring = String.format("%1$02d", day);
        String expectedClassName = basePackage + ".SolutionDay" + daystring;

        List<AocApplicationException.Reason> noProceedReasons = new ArrayList<>();
        Class<?> expectedClass = null;
        try {
            expectedClass = Class.forName(expectedClassName);
        } catch (Exception e) {
            noProceedReasons.add(AocApplicationException.Reason.NOT_LOADING_CLASS);
            throw new AocApplicationException(noProceedReasons);
        }
        List<String> input = null;
        try {
            input = AoCFileReader.getInputAsList(expectedClass, "day" + daystring + ".txt");
        } catch (Exception e) {
            noProceedReasons.add(AocApplicationException.Reason.NO_DATA_FILE);
            throw new AocApplicationException(noProceedReasons);
        }

        if (input.size() == 0) {
            noProceedReasons.add(AocApplicationException.Reason.EMPTY_DATA_FILE);
            throw new AocApplicationException(noProceedReasons);
        }

        Constructor<?> defaultConstructor = null;
        try {
            defaultConstructor = expectedClass.getDeclaredConstructor();
        } catch (Exception e) {
            noProceedReasons.add(AocApplicationException.Reason.NO_DEFAULT_CONSTRUCTOR);
            throw new AocApplicationException(noProceedReasons);
        }

        AoCSolution<?, ?> solutionInstance = null;
        try {
            solutionInstance = (AoCSolution<?, ?>) defaultConstructor.newInstance();
        } catch (Exception e) {
            noProceedReasons.add(AocApplicationException.Reason.INSTANCE_NOT_CREATED);
            throw new AocApplicationException(noProceedReasons);
        }

        Object solution1 = null;
        try {
            solution1 = solutionInstance.solvePart1(input);
        } catch (Exception e) {
            noProceedReasons.add(AocApplicationException.Reason.SOLVE_PART_1);
        }

        Object solution2 = null;
        try {
            solution2 = solutionInstance.solvePart2(input);
        } catch (Exception e) {
            noProceedReasons.add(AocApplicationException.Reason.SOLVE_PART_2);
        }

        SolutionPair solutionPair = new SolutionPair(solution1, solution2);
        return solutionPair;
    }

    private static String createBasePackageName(int year) {
        return "de.hegmanns.training.aoc" + year;
    }
}

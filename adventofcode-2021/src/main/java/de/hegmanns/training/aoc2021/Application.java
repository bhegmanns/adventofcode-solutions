package de.hegmanns.training.aoc2021;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("All available results for advent-of-code-2021");

        for (int day = 1; day < 26; day++) {

            System.out.println("--- DAY " + day + " ---");
            String daystring = String.format("%1$02d", day);
            String filename = "day" + daystring + ".txt";
            String className = "de.hegmanns.training.aoc2021.SolutionDay" + daystring;
            Class<?> solutionClass = null;
            List<String> input = null;

            try {
                solutionClass = Class.forName(className);
            } catch (Exception e) {
                System.out.println("NOT AVAILABLE > could not instantiate class '" + className + "'");
                continue;
            }
            try {
                input = AoCFileReader.getInputAsList(solutionClass, filename);
            } catch (Exception e) {
                System.out.println("NOT AVAILABLE > could not read file '" + filename + "'");
                continue;
            }

            if (true) {

                try {
                    AoCSolution<?, ?> solutionInstance = (AoCSolution<?, ?>) solutionClass.getDeclaredConstructor().newInstance();
                    System.out.println("PART 1 >>> " + solutionInstance.solvePart1(input));
                    System.out.println("PART 2 >>> " + solutionInstance.solvePart2(input));
                } catch (Exception e) {
                    System.out.println("ERROR ...");
                }
                System.out.println();
            } else {

            }
        }
    }

    public void doAny(){

        System.out.println("--- DAY 01 ---");
        SolutionDay01 solution01 = new SolutionDay01();
        List<String> inputDay01 = AoCFileReader.getInputAsList(solution01.getClass(), "day01.txt");
        System.out.println("PART 1 >>> " + solution01.solvePart1(inputDay01));
        System.out.println("PART 2 >>> " + solution01.solvePart2(inputDay01));

        System.out.println("--- DAY 02 ---");
        SolutionDay02 solution02 = new SolutionDay02();
        List<String> inputDay02 = AoCFileReader.getInputAsList(solution02.getClass(), "day02.txt");
        System.out.println("PART 1 >>> " + solution02.solvePart1(inputDay02));
        System.out.println("PART 2 >>> " + solution02.solvePart2(inputDay02));

        System.out.println("--- DAY 03 ---");
        SolutionDay03 solution03 = new SolutionDay03();
        List<String> inputDay03 = AoCFileReader.getInputAsList(solution03.getClass(), "day03.txt");
        System.out.println("PART 1 >>> " + solution03.solvePart1(inputDay03));
        System.out.println("PART 2 >>> " + solution03.solvePart2(inputDay03));

//        System.out.println("--- DAY 04 ---");
//        SolutionDay04 solution04 = new SolutionDay04();
//        List<String> inputDay04 = AoCFileReader.getInputAsList(solution04.getClass(), "day04.txt");
//        System.out.println("PART 1 >>> " + solution04.solvePart1(inputDay04));
//        System.out.println("PART 2 >>> " + solution04.solvePart2(inputDay04));

        System.out.println("--- DAY 05 ---");
        SolutionDay05 solution05 = new SolutionDay05();
        List<String> inputDay05 = AoCFileReader.getInputAsList(solution05.getClass(), "day05.txt");
        System.out.println("PART 1 >>> " + solution05.solvePart1(inputDay05));
        System.out.println("PART 2 >>> " + solution05.solvePart2(inputDay05));

        System.out.println("--- DAY 06 ---");
        SolutionDay06 solution06 = new SolutionDay06();
        List<String> inputDay06 = AoCFileReader.getInputAsList(solution06.getClass(), "day06.txt");
        System.out.println("PART 1 >>> " + solution06.solvePart1(inputDay06));
        System.out.println("PART 2 >>> " + solution06.solvePart2(inputDay06));

    }
}

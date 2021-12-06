package de.hegmanns.training.aoc2021;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;

import java.util.List;

public class Application {

    /**
     * Tries to instantiate all classes in this package 'de.hegmanns.training.aoc2021' and name 'SolutionDayXY' and
     * loading the data-file dayXY.txt.
     * Only if the class is instantiated and the file is loaded both tasks of the day should be proceeded und printed out.
     * @param args nothing
     */
    public static void main(String[] args) {
        System.out.println("All available results for advent-of-code-2021");

        for (int day = 1; day < 26; day++) {

            String daystring = String.format("%1$02d", day);
            String filename = "day" + daystring + ".txt";
            String className = "de.hegmanns.training.aoc2021.SolutionDay" + daystring;
            Class<?> solutionClass = null;
            List<String> input = null;

            try {
                solutionClass = Class.forName(className);
            } catch (Exception e) {
//                System.out.println("NOT AVAILABLE > could not instantiate class '" + className + "'");
                continue;
            }
            try {
                input = AoCFileReader.getInputAsList(solutionClass, filename);
            } catch (Exception e) {
//                System.out.println("NOT AVAILABLE > could not read file '" + filename + "'");
                continue;
            }
            System.out.println("--- DAY " + day + " ---");
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


}

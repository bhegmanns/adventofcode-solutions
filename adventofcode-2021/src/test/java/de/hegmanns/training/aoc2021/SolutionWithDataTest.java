package de.hegmanns.training.aoc2021;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class SolutionWithDataTest {

    @ParameterizedTest(name = "Data-Test for day {0} part {1}, expected solution {2}")
//    @CsvSource({"04, 1, 4512", "04, 2, 1924"})
    @Disabled // disable because there isn't any source
    public void checkForOnlyOnePart(String day, int part,  String solution1) throws Exception {
        String className1 = "de.hegmanns.training.aoc2021.SolutionDay" + day;
        Class<?> solutionClass = Class.forName(className1);

        AoCSolution<?, ?> solutionInstance = (AoCSolution<?, ?>) solutionClass.getDeclaredConstructor().newInstance();

        List<String> inputAsList = AoCFileReader.getInputAsList(this.getClass(), "day" + day + ".txt");
        Object result;
        if (part == 1) {
            result = solutionInstance.solvePart1(inputAsList);
        } else {
            result = solutionInstance.solvePart2(inputAsList);
        }
        MatcherAssert.assertThat("PART " + part, "" + result, Matchers.equalTo(solution1));

    }


    @ParameterizedTest(name = "Data-Test for day {0}")
    @CsvSource({"01, 1184, 1158", "02, 1250395, 1451210346", "03, 738234, 3969126", "04, 11536,1284", "05, 7318, 19939", "06, 365862, 1653250886439"})
    public void checkBothParts(String day, String solution1, String solution2) throws Exception {
        String className1 = "de.hegmanns.training.aoc2021.SolutionDay" + day;
        Class<?> solutionClass = Class.forName(className1);

        AoCSolution<?, ?> solutionInstance = (AoCSolution<?, ?>) solutionClass.getDeclaredConstructor().newInstance();

        List<String> inputAsList = AoCFileReader.getInputAsList(this.getClass(), "day" + day + ".txt");
        Object result1 = solutionInstance.solvePart1(inputAsList);
        Object result2 = solutionInstance.solvePart2(inputAsList);
        MatcherAssert.assertThat("PART 1", "" + result1, Matchers.equalTo(solution1));
        MatcherAssert.assertThat("PART 2", "" + result2, Matchers.equalTo(solution2));

    }
}

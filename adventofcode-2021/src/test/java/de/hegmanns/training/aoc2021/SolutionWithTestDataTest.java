package de.hegmanns.training.aoc2021;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;

public class SolutionWithTestDataTest {

    @ParameterizedTest(name = "Data-Test for day {0} part {1}, expected solution {2}")
//    @CsvSource({"04, 1, 4512", "04, 2, 1924"})
    @Disabled // disable because there isn't any source
    public void checkForOnlyOnePart(String day, int part,  String solution1) throws Exception {
        String className1 = "de.hegmanns.training.aoc2021.SolutionDay" + day;
        Class<?> solutionClass = Class.forName(className1);

        AoCSolution<?, ?> solutionInstance = (AoCSolution<?, ?>) solutionClass.getDeclaredConstructor().newInstance();

        List<String> inputAsList = AoCFileReader.getInputAsList(this.getClass(), "day" + day + "_test.txt");
        Object result;
        if (part == 1) {
            result = solutionInstance.solvePart1(inputAsList);
        } else {
            result = solutionInstance.solvePart2(inputAsList);
        }
        MatcherAssert.assertThat("PART " + part, "" + result, Matchers.equalTo(solution1));

    }

    @ParameterizedTest(name = "Data-Test for day {0}")
    @CsvSource({"01, 7, 5", "02, 150, 900", "03, 198, 230", "04, 4512, 1924", "05, 5, 12", "06, 5934, 26984457539"})
    public void checkBothParts(String day, String solution1, String solution2) throws Exception {
        String className1 = "de.hegmanns.training.aoc2021.SolutionDay" + day;
        Class<?> solutionClass = Class.forName(className1);

        AoCSolution<?,?> solutionInstance = (AoCSolution<?, ?>) solutionClass.getDeclaredConstructor().newInstance();

        List<String> inputAsList = AoCFileReader.getInputAsList(this.getClass(), "day" + day + "_test.txt");
        Object result1 = solutionInstance.solvePart1(inputAsList);
        Object result2 = solutionInstance.solvePart2(inputAsList);
        MatcherAssert.assertThat("PART 1", "" + result1, Matchers.equalTo(solution1));
        MatcherAssert.assertThat("PART 2", "" + result2, Matchers.equalTo(solution2));
    }
}

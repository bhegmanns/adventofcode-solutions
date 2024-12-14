package de.hegmanns.training.aoc2022;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

public class SolutionDay06Test {

    SolutionDay06 solution = new SolutionDay06();

    @ParameterizedTest
    @CsvSource({"mjqjpqmgbljsphdztnvjfqwrcgsmlb, 7", "bvwbjplbgvbhsrlpgdmjqwftvncz, 5", "nppdvjthqldpwncqszvftbrmjlhg, 6", "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg, 10", "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw, 11"})
    public void examplesForPart1(String dataStream, int firstMarker) {
        MatcherAssert.assertThat(solution.solvePart1(Arrays.asList(dataStream)), Matchers.is(firstMarker));
    }

    @ParameterizedTest
    @CsvSource({"mjqjpqmgbljsphdztnvjfqwrcgsmlb, 19", "bvwbjplbgvbhsrlpgdmjqwftvncz, 23", "nppdvjthqldpwncqszvftbrmjlhg, 23", "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg, 29", "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw, 26"})
    public void examplesForPart2(String dataStream, int firstMarker) {
        MatcherAssert.assertThat(solution.solvePart2(Arrays.asList(dataStream)), Matchers.is(firstMarker));
    }
}

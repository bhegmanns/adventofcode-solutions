package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class SolutionDay03Test {

    @Test
    public void exampleForPart1() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay03.class, "day03e.txt");
        SolutionDay03 solution = new SolutionDay03();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(4361L));
    }

    @Test
    public void exampleForPart2() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay03.class, "day03e.txt");
        SolutionDay03 solution = new SolutionDay03();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(467835L));
    }

    @Test
    void realTask1() {
        MatcherAssert.assertThat((new SolutionDay03()).getSolution1(), Matchers.equalTo(530495L));
    }

    @Test
    void realTask2() {
        MatcherAssert.assertThat(new SolutionDay03().getSolution2(), Matchers.equalTo(80253814L));
    }


    @ParameterizedTest
    @CsvSource({"144,..12*12...",
            "144,...*...;.12.12.;.......",
            "144,.12.12;...*..",
            "144,...12...;..*.....;..12....",
            "144,...12...;...*....;..12....",
            "144,...12...;....*...;..12....",
            "0,...12...;.....*..;..12....",
            "0,...12...;......*.;..12...."
    })
    public void examplesForPart1(long expectedSolution, String lines) {
        List<String> input = new ArrayList<>(List.of(lines.split(";")));

        SolutionDay03 solutionDay03 = new SolutionDay03();
        Long result = solutionDay03.solvePart2(input);
        MatcherAssert.assertThat(result, Matchers.is(expectedSolution));
    }
}

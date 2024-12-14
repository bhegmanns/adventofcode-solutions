package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static de.hegmanns.training.aoc2023.SolutionDay21.getSolutionInstance;

public class SolutionDay13Test {

    private List<String> getTestInputAsList() {
        return AoCFileReader.getInputAsList(SolutionDay13.class, "day13e.txt");
    }

    @Test
    public void exampleForPart1() {
        List<String> inputAsList = getTestInputAsList();
        SolutionDay13 solution = new SolutionDay13();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(405L));
    }

    @Test
    public void exampleForPart2() {
        List<String> inputAsList = getTestInputAsList();
        SolutionDay13 solution = new SolutionDay13();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(405L));
    }

    @Test
    void realTask1() {
        MatcherAssert.assertThat((new SolutionDay13()).getSolution1(), Matchers.equalTo(9177603L));
    }

    @Test
    void realTask2() {
        MatcherAssert.assertThat(new SolutionDay13().getSolution2(), Matchers.equalTo(632003913611L));
    }
}

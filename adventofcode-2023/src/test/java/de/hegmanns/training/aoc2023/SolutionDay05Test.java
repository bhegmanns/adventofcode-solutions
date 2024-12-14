package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay05Test {

    @Test
    public void exampleForPart1() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay05.class, "day05e.txt");
        SolutionDay05 solution = new SolutionDay05();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(35L));
    }

    @Test
    public void exampleForPart2() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay05.class, "day05e.txt");
        SolutionDay05 solution = new SolutionDay05();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(46L));
    }

    @Test
    void realTask1() {
        MatcherAssert.assertThat((new SolutionDay05()).getSolution1(), Matchers.equalTo(26273516L));
    }

    @Test
    void realTask2() {
        MatcherAssert.assertThat(new SolutionDay05().getSolution2(), Matchers.equalTo(34039469L));
    }

}

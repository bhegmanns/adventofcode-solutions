package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay06Test {

    @Test
    public void exampleForPart1() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay05.class, "day06e.txt");
        SolutionDay06 solution = new SolutionDay06();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(288L));
    }

    @Test
    public void exampleForPart2() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay06.class, "day06e.txt");
        SolutionDay06 solution = new SolutionDay06();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(71503L));
    }

    @Test
    void realTask1() {
        MatcherAssert.assertThat((new SolutionDay06()).getSolution1(), Matchers.equalTo(293046L));
    }

    @Test
    void realTask2() {
        MatcherAssert.assertThat(new SolutionDay06().getSolution2(), Matchers.equalTo(35150181L));
    }

}

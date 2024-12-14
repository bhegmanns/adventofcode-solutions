package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay10Test {

    @Test
    public void exampleForPart1_example1() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay10.class, "day10_1e.txt");
        SolutionDay10 solution = new SolutionDay10();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(4L));
    }

    @Test
    public void exampleForPart1_example2() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay10.class, "day10_2e.txt");
        SolutionDay10 solution = new SolutionDay10();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(8L));
    }

    @Test
    public void exampleForPart2() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay10.class, "day10_1e.txt");
        SolutionDay10 solution = new SolutionDay10();

        System.out.println(">>>" + solution.solvePart2(inputAsList));
        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(2L));
    }


}

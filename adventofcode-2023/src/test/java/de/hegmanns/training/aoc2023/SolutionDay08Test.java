package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay08Test {

    @Test
    public void exampleForPart1Example1() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay08.class, "day08_1e.txt");
        SolutionDay08 solution = new SolutionDay08();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(2L));
    }

    @Test
    public void exampleForPart1Example2() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay08.class, "day08_2e.txt");
        SolutionDay08 solution = new SolutionDay08();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(6L));
    }

    @Test
    public void exampleForPart2() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay08.class, "day08_3e.txt");
        SolutionDay08 solution = new SolutionDay08();

        System.out.println(">>>" + solution.solvePart2(inputAsList));
        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(6L));
    }

    @Test
    void realTask1() {
        MatcherAssert.assertThat((new SolutionDay08()).getSolution1(), Matchers.equalTo(23147L));
    }

    @Test
    void realTask2() {
        MatcherAssert.assertThat(new SolutionDay08().getSolution2(), Matchers.equalTo(22289513667691L));
    }

}

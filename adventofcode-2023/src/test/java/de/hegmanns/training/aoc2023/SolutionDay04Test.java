package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class SolutionDay04Test {

    @Test
    public void exampleForPart1() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay03.class, "day04e.txt");
        SolutionDay04 solution = new SolutionDay04();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(13L));
    }

    @Test
    public void exampleForPart2() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay03.class, "day04e.txt");
        SolutionDay04 solution = new SolutionDay04();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(30L));
    }

    @Test
    public void exampleForPart2WithoutLastCard() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay03.class, "day04e.txt");
        inputAsList = inputAsList.stream().limit(inputAsList.size() - 1).collect(Collectors.toList());

        SolutionDay04 solution = new SolutionDay04();
        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(29L));
    }

    @Test
    void realTask1() {
        MatcherAssert.assertThat((new SolutionDay04()).getSolution1(), Matchers.equalTo(20107L));
    }

    @Test
    void realTask2() {
        MatcherAssert.assertThat(new SolutionDay04().getSolution2(), Matchers.equalTo(8172507L));
    }

}

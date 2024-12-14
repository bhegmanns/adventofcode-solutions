package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay07Test {

    @Test
    public void exampleForPart1() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay07.class, "day07e.txt");
        SolutionDay07 solution = new SolutionDay07();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(6440L));
    }

    @Test
    public void exampleForPart2() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay07.class, "day07e.txt");
        SolutionDay07 solution = new SolutionDay07();

        System.out.println(">>>" + solution.solvePart2(inputAsList));
        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(5905L));
    }

    @Test
    void realTask1() {
        MatcherAssert.assertThat((new SolutionDay07()).getSolution1(), Matchers.equalTo(253954294L));
    }

    @Test
    void realTask2() {
        MatcherAssert.assertThat(new SolutionDay07().getSolution2(), Matchers.equalTo(254837398L));
    }

}

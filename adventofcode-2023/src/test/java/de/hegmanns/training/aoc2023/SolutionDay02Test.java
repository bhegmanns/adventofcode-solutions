package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay02Test {

    @Test
    public void exampleForPart1() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay02.class, "day02.txt");
        SolutionDay02 solution = new SolutionDay02();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(8L));
    }

    @Test
    public void exampleForPart2() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay02.class, "day02.txt");
        SolutionDay02 solution = new SolutionDay02();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(2286L));
    }
}

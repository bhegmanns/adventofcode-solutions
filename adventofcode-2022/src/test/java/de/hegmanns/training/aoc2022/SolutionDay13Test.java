package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay13Test {

    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay13.class, "day13.txt");
        SolutionDay13 solution = new SolutionDay13();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.is(13L));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay13.class, "day13.txt");
        SolutionDay13 solution = new SolutionDay13();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.is(140L));
    }
}

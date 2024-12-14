package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay15Test {

    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay15.class, "day15.txt");
        SolutionDay15 solution = new SolutionDay15(10L);

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.is(26L));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay15.class, "day15.txt");
        SolutionDay15 solution = new SolutionDay15(10L);

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.is(140L));
    }
}
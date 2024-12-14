package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay11Test {

    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay11.class, "day11.txt");
        SolutionDay11 solution = new SolutionDay11();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.is(10605L));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay11.class, "day11.txt");
        SolutionDay11 solution = new SolutionDay11();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.is(2713310158L));
    }
}

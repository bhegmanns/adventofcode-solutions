package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solutionday08Test {

    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay08.class, "day08.txt");
        SolutionDay08 solution = new SolutionDay08();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.is(21));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay08.class, "day08.txt");
        SolutionDay08 solution = new SolutionDay08();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.is(8L));
    }
}

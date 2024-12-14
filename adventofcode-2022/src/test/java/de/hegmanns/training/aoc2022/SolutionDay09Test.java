package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay09Test {

    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay09.class, "day09.txt");
        SolutionDay09 solution = new SolutionDay09();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.is(13L));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay09.class, "day09.txt");
        SolutionDay09 solution = new SolutionDay09();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.is(1L));
    }



    @Test
    public void exampleForPart2Example2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay09.class, "day09_2.txt");
        SolutionDay09 solution = new SolutionDay09();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.is(36L));
    }
}

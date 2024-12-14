package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay25Test {

    @Test
    public void testExample01() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay25.class, "day25.txt");
        SolutionDay25 solution = new SolutionDay25();
        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.is("2=-1=0"));
    }

    @Test
    public void testExample02() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay25.class, "day25.txt");
        SolutionDay25 solution = new SolutionDay25();
        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.is(1623178306L));

    }


}

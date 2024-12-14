package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay12Test {

    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay12.class, "day12.txt");
        SolutionDay12 solution = new SolutionDay12();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.is(31));
    }
}

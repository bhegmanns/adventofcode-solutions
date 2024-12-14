package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay16Test {

    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay16.class, "day16.txt");
        SolutionDay16 solution = new SolutionDay16();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.is(26L));
    }

}

package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay05Test {

    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay05.class, "day05.txt");
        SolutionDay05 solutionDay05 = new SolutionDay05();

        MatcherAssert.assertThat(solutionDay05.solvePart1(inputAsList), Matchers.is("CMZ"));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay05.class, "day05.txt");
        SolutionDay05 solutionDay05 = new SolutionDay05();

        MatcherAssert.assertThat(solutionDay05.solvePart2(inputAsList), Matchers.is("MCD"));
    }
}

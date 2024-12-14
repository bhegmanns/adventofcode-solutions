package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay01Test {

    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay01.class, "day01.txt");
        SolutionDay01 solutionDay01 = new SolutionDay01();

        MatcherAssert.assertThat(solutionDay01.solvePart1(inputAsList), Matchers.is(24000));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay01.class, "day01.txt");
        SolutionDay01 solutionDay01 = new SolutionDay01();

        MatcherAssert.assertThat(solutionDay01.solvePart2(inputAsList), Matchers.is(45000));
    }
}

package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionDay10Test {

    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay10.class, "day10.txt");
        SolutionDay10 solution = new SolutionDay10();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.is(13140L));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay10.class, "day10.txt");
        SolutionDay10 solution = new SolutionDay10();

        List<String> expectedResult = Arrays.asList(
                "##  ##  ##  ##  ##  ##  ##  ##  ##  ##  ",
                "###   ###   ###   ###   ###   ###   ### ",
                "####    ####    ####    ####    ####    ",
                "#####     #####     #####     #####     ",
                "######      ######      ######      ####",
                "#######       #######       #######     ");

        List<String> solutionList = solution.solvePart2(inputAsList);
        MatcherAssert.assertThat(solutionList, Matchers.contains(expectedResult.toArray()));
    }
}

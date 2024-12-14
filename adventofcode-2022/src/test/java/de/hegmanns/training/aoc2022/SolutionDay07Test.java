package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay07Test {

    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay07.class, "day07.txt");
        SolutionDay07 solution = new SolutionDay07();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.is(95437L));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay07.class, "day07.txt");
        SolutionDay07 solution = new SolutionDay07();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.is(24933642L));
    }
}

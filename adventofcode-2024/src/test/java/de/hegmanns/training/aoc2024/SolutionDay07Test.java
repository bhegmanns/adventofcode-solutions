package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay07Test {
    private static final String EXAMPLE_FILE_NAME = "day07_example.txt";


    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay07.class, EXAMPLE_FILE_NAME);
        SolutionDay07 solution = new SolutionDay07();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(3749L));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay07.class, EXAMPLE_FILE_NAME);
        SolutionDay07 solution = new SolutionDay07();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(11387L));
    }

    @Test
    void realTask1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay07.class, SolutionDay07.FILE_NAME);
        SolutionDay07 solution = new SolutionDay07();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(932137732557L));
    }

    @Test
    void realTask2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay07.class, SolutionDay07.FILE_NAME);
        SolutionDay07 solution = new SolutionDay07();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(661823605105500L));
    }
}

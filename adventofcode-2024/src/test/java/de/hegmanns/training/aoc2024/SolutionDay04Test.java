package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.*;
import org.hamcrest.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class SolutionDay04Test {
    private static final String EXAMPLE_FILE_NAME = "day04_example.txt";
    private static final String EXAMPLE2_FILE_NAME = "day04_2_example.txt";

    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay04.class, EXAMPLE_FILE_NAME);
        SolutionDay04 solution = new SolutionDay04();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(18L));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay04.class, EXAMPLE_FILE_NAME);
        SolutionDay04 solution = new SolutionDay04();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(9L));
    }

    @Test
    void realTask1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay04.class, SolutionDay04.FILE_NAME);
        SolutionDay04 solution = new SolutionDay04();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(2613L));
    }

    @Test
    void realTask2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay04.class, SolutionDay04.FILE_NAME);
        SolutionDay04 solution = new SolutionDay04();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(1905L));
    }
}

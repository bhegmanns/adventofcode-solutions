package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.*;
import org.hamcrest.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class SolutionDay05Test {
    private static final String EXAMPLE_FILE_NAME = "day05_example.txt";


    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay05.class, EXAMPLE_FILE_NAME);
        SolutionDay05 solution = new SolutionDay05();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(143L));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay05.class, EXAMPLE_FILE_NAME);
        SolutionDay05 solution = new SolutionDay05();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(123L));
    }

    @Test
    void realTask1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay05.class, SolutionDay05.FILE_NAME);
        SolutionDay05 solution = new SolutionDay05();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(5639L));
    }

    @Test
    void realTask2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay05.class, SolutionDay05.FILE_NAME);
        SolutionDay05 solution = new SolutionDay05();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(5273L));
    }
}

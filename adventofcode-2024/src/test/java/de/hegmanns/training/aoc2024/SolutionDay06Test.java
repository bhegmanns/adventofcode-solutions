package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.*;
import org.hamcrest.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class SolutionDay06Test {
    private static final String EXAMPLE_FILE_NAME = "day06_example.txt";


    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay06.class, EXAMPLE_FILE_NAME);
        SolutionDay06 solution = new SolutionDay06();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(41L));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay06.class, EXAMPLE_FILE_NAME);
        SolutionDay06 solution = new SolutionDay06();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(6L));
    }

    @Test
    void realTask1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay06.class, SolutionDay06.FILE_NAME);
        SolutionDay06 solution = new SolutionDay06();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(5453L));
    }

    @Test
    void realTask2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay06.class, SolutionDay06.FILE_NAME);
        SolutionDay06 solution = new SolutionDay06();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(2188L));
    }
}

package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.*;
import org.hamcrest.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class SolutionDay03Test {
    private static final String EXAMPLE_FILE_NAME = "day03_example.txt";
    private static final String EXAMPLE2_FILE_NAME = "day03_2_example.txt";

    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay03.class, EXAMPLE_FILE_NAME);
        SolutionDay03 solution = new SolutionDay03();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(161L));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay03.class, EXAMPLE2_FILE_NAME);
        SolutionDay03 solution = new SolutionDay03();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(48L));
    }

    @Test
    void realTask1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay03.class, SolutionDay03.FILE_NAME);
        SolutionDay03 solution = new SolutionDay03();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(161289189L));
    }

    @Test
    void realTask2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay03.class, SolutionDay03.FILE_NAME);
        SolutionDay03 solution = new SolutionDay03();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(83595109L));
    }
}

package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.*;
import org.hamcrest.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class SolutionDay08Test {
    private static final String EXAMPLE_FILE_NAME = "day08_example.txt";


    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay08.class, EXAMPLE_FILE_NAME);
        SolutionDay08 solution = new SolutionDay08();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(14L));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay08.class, EXAMPLE_FILE_NAME);
        SolutionDay08 solution = new SolutionDay08();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(34L));
    }

    @Test
    void realTask1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay08.class, SolutionDay08.FILE_NAME);
        SolutionDay08 solution = new SolutionDay08();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(398L));
    }

    @Test
    void realTask2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay08.class, SolutionDay08.FILE_NAME);
        SolutionDay08 solution = new SolutionDay08();

        //1213 ist zu klein
        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(1333L));
    }
}

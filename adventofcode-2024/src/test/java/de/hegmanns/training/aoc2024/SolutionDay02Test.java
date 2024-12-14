package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.*;
import org.hamcrest.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class SolutionDay02Test {

    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay02.class, "day02_example.txt");
        SolutionDay02 solution = new SolutionDay02();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(2L));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay02.class, "day02_example.txt");
        SolutionDay02 solution = new SolutionDay02();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(4L));
    }

    @Test
    void realTask1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay02.class, "day02_task.txt");
        SolutionDay02 solution = new SolutionDay02();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(524L));
    }

    @Test
    void realTask2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay01.class, "day02_task.txt");
        SolutionDay02 solution = new SolutionDay02();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(569L));
    }
}

package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.*;
import org.hamcrest.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class SolutionDay01Test {

    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay01.class, "day01_example.txt");
        SolutionDay01 solution = new SolutionDay01();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(11L));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay01.class, "day01_example.txt");
        SolutionDay01 solution = new SolutionDay01();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(31L));
    }

    @Test
    void realTask1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay01.class, "day01_task.txt");
        SolutionDay01 solution = new SolutionDay01();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(1223326L));
    }

    @Test
    void realTask2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay01.class, "day01_task.txt");
        SolutionDay01 solution = new SolutionDay01();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(21070419L));
    }
}

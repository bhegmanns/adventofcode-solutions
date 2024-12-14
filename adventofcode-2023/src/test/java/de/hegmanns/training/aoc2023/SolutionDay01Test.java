package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay01Test {

    @Test
    public void exampleForPart1() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay01.class, "day01.txt");
        SolutionDay01 solution = new SolutionDay01();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(142L));
    }

    @Test
    public void exampleForPart2() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay01.class, "day01_01.txt");
        SolutionDay01 solution = new SolutionDay01();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(281L));
    }

    @Test
    void realTask1() {
        MatcherAssert.assertThat((new SolutionDay01()).getSolution1(), Matchers.equalTo(54951L));
    }

    @Test
    void realTask2() {
        MatcherAssert.assertThat((new SolutionDay01()).getSolution2(), Matchers.equalTo(55218L));
    }
}

package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc2023.day11.Matrix;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay11Test {

    @Test
    public void exampleForPart1() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay11.class, "day11e.txt");
        SolutionDay11 solution = new SolutionDay11();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(374L));
    }


    @Test
    public void exampleForPart2_likePart1_withFactor2() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay11.class, "day11e.txt");
        Matrix matrix = SolutionDay11.buildFromInput(inputAsList);
        long result = SolutionDay11.resolvePart2WithExtension(matrix, 2);
        MatcherAssert.assertThat(result, Matchers.equalTo(374L));
    }

    @Test
    public void exampleForPart2_factor10() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay11.class, "day11e.txt");
        Matrix matrix = SolutionDay11.buildFromInput(inputAsList);
        long result = SolutionDay11.resolvePart2WithExtension(matrix, 10);
        MatcherAssert.assertThat(result, Matchers.equalTo(1030L));
    }

    @Test
    public void exampleForPart2_factor100() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay11.class, "day11e.txt");
        Matrix matrix = SolutionDay11.buildFromInput(inputAsList);
        long result = SolutionDay11.resolvePart2WithExtension(matrix, 100);
        MatcherAssert.assertThat(result, Matchers.equalTo(8410L));
    }

    @Test
    void realTask1() {
        MatcherAssert.assertThat((new SolutionDay11()).getSolution1(), Matchers.equalTo(9177603L));
    }

    @Test
    void realTask2() {
        MatcherAssert.assertThat(new SolutionDay11().getSolution2(), Matchers.equalTo(632003913611L));
    }

}

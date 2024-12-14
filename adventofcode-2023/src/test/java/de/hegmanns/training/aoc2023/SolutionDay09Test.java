package de.hegmanns.training.aoc2023;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionDay09Test {

    @Test
    public void exampleForPart1() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay09.class, "day09e.txt");
        SolutionDay09 solution = new SolutionDay09();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(114L));
    }

    @Test
    public void exampleForPart2() {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay09.class, "day09e.txt");
        SolutionDay09 solution = new SolutionDay09();

        System.out.println(">>>" + solution.solvePart2(inputAsList));
        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(2L));
    }

    @Test
    void realTask1() {
        MatcherAssert.assertThat((new SolutionDay09()).getSolution1(), Matchers.equalTo(1806615041L));
    }

    @Test
    void realTask2() {
        MatcherAssert.assertThat(new SolutionDay09().getSolution2(), Matchers.equalTo(1211L));
    }
}

package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.AoCFileReader;
import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import java.util.List;

public class SolutionDay10Test {
    private static final String EXAMPLE_FILE_NAME = "day10_example.txt";
    private static final String EXAMPLE_FILE_NAME_2 = "day10_2_example.txt";
    private static final String EXAMPLE_FILE_NAME_3 = "day10_3_example.txt";

    private SolutionDay10 solution = new SolutionDay10();

    public static List<String> getExampleInputAsList() {
        return AoCFileReader.getInputAsList(SolutionDay10.class, EXAMPLE_FILE_NAME);
    }
    public static List<String> getTaskInputAsList() {
        return AoCFileReader.getInputAsList(SolutionDay10.class, SolutionDay10.FILE_NAME);
    }



    @Test
    public void exampleForPart1(){
        MatcherAssert.assertThat(solution.solvePart1(getExampleInputAsList()), Matchers.equalTo(1L));
    }

    @Test
    public void exampleForPart1_2(){
        Assertions.assertThat(solution.solvePart1(AoCFileReader.getInputAsList(SolutionDay10.class, EXAMPLE_FILE_NAME_2))).isEqualTo(2L);
    }

    @Test
    public void exampleForPart1_3(){
        Assertions.assertThat(solution.solvePart1(AoCFileReader.getInputAsList(SolutionDay10.class, EXAMPLE_FILE_NAME_3))).isEqualTo(36L);
    }

    @Test
    public void exampleForPart2(){
        MatcherAssert.assertThat(solution.solvePart2(getExampleInputAsList()), Matchers.equalTo(16L));
    }

    @Test
    public void exampleForPart2_3(){
        Assertions.assertThat(solution.solvePart2(AoCFileReader.getInputAsList(SolutionDay10.class, EXAMPLE_FILE_NAME_3))).isEqualTo(81L);
    }

    @Test
    void realTask1(){
        MatcherAssert.assertThat(solution.solvePart1(getTaskInputAsList()), Matchers.equalTo(587L));
    }

    @Test
    void realTask2(){
        Assertions.assertThat(solution.solvePart2(getTaskInputAsList())).isEqualTo(1340L);
    }

}

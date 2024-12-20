package de.hegmanns.training.aoc2024;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc2024.day09.FileMap;
import de.hegmanns.training.aoc2024.day09.FileMapFactory;
import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

public class SolutionDay09Test {
    private static final String EXAMPLE_FILE_NAME = "day09_example.txt";
    private static final String EXAMPLE_FILE_NAME_2 = "day09_2_example.txt";


    public static List<String> getExampleInputAsList() {
        return AoCFileReader.getInputAsList(SolutionDay09.class, EXAMPLE_FILE_NAME);
    }
    public static List<String> getTaskInputAsList() {
        return AoCFileReader.getInputAsList(SolutionDay09.class, SolutionDay09.FILE_NAME);
    }
    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay09.class, EXAMPLE_FILE_NAME);
        SolutionDay09 solution = new SolutionDay09();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(1928L));
    }

    @Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay09.class, EXAMPLE_FILE_NAME);
        SolutionDay09 solution = new SolutionDay09();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.equalTo(2858L));
    }

    @Test
    void realTask1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay09.class, SolutionDay09.FILE_NAME);
        SolutionDay09 solution = new SolutionDay09();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.equalTo(6211348208140L));
    }

    @Test
    void realTask2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay09.class, SolutionDay09.FILE_NAME);
        SolutionDay09 solution = new SolutionDay09();


        Long solutionPart2 = solution.solvePart2(inputAsList);
        /*
        one of my first solution which match with the example
        I forgot to ensure, that the filespace should onely push forward and never push packward ...
         */
        Assertions.assertThat(solutionPart2).describedAs("is too high").isNotEqualTo(8358671598691L);
        Assertions.assertThat(solutionPart2).describedAs("is too low").isNotEqualTo(6211348208140L);
    }


    @ParameterizedTest
    @CsvSource({"1313165, 169", "9953877292941, 5848"})
    void checksForTask2(String inputLine, long expectedChecksum) {
        SolutionDay09 solution = new SolutionDay09();
        Long checksum = solution.solvePart2(List.of(inputLine));
        Assertions.assertThat(checksum).isEqualTo(expectedChecksum);
    }

    @Test
    void simpleStringWorks() {
        FileMap fileMapFromMapString = FileMapFactory.createFileMapFromMapString("1313165");
        fileMapFromMapString.optimizeSpacesWithFullMatch();

    }

    @ParameterizedTest
    @CsvSource({"1313165, 021......33333......", "9953877292941, 00000000063333333.11111...22222222................444444444..555555555....."})
    void checksForTask2CompressionMap(String inputLine, String expectedMap) {
        FileMap fileMap = FileMapFactory.createFileMapFromMapString(inputLine);
        fileMap.optimizeSpacesWithFullMatch();
        String result = fileMap.getMap().stream().map(i -> i != null ? "" + i : ".").collect(Collectors.joining(""));
        Assertions.assertThat(result).isEqualTo(expectedMap);
    }
}

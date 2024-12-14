package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc2022.day18.Shape;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionDay18Test {

    @Test
    public void twoShapeFromFirstExample() {
        Shape shape = new Shape(1, 1, 1);
        Shape otherShape = new Shape(2, 1, 1);

        List<String> shapeDefinitions = Arrays.asList("1,1,1", "2,1,1");

        SolutionDay18 solution = new SolutionDay18();

        Long aLong = solution.solvePart1(shapeDefinitions);

        MatcherAssert.assertThat(aLong, Matchers.is(10L));
    }

    @Test
    public void exampleForPart1(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay18.class, "day18.txt");
        SolutionDay18 solution = new SolutionDay18();

        MatcherAssert.assertThat(solution.solvePart1(inputAsList), Matchers.is(64L));
    }

    //@Test
    public void exampleForPart2(){
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay18.class, "day18.txt");
        SolutionDay18 solution = new SolutionDay18();

        MatcherAssert.assertThat(solution.solvePart2(inputAsList), Matchers.is(140L));
    }
}

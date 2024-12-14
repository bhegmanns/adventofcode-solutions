package de.hegmanns.training.aoc2023.day13;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class ReflectionPatternTest {

    @Test
    public void findHorizontalReflectionLineFromExample() {
        /*
        #...##..#
#....#..#
..##..###
#####.##.
#####.##.
..##..###
#....#..#
         */
        ReflectionPattern reflectionPattern = ReflectionPattern.ReflectionPatternBuilder.create()
                .addLine("#...##..#")
                .addLine("#....#..#")
                .addLine("..##..###")
                .addLine("#####.##.")
                .addLine("#####.##.")
                .addLine("..##..###")
                .addLine("#....#..#")
                .build().get(0);

        int horizontalReflectionLine = reflectionPattern.findHorizontalReflectionLine();
        MatcherAssert.assertThat(horizontalReflectionLine, Matchers.is(4));
    }

    @Test
    public void findVerticalReflectionLineFromExample() {

        ReflectionPattern reflectionPattern = ReflectionPattern.ReflectionPatternBuilder.create()
                .addLine("#.##..##.")
                .addLine("..#.##.#.")
                .addLine("##......#")
                .addLine("##......#")
                .addLine("..#.##.#.")
                .addLine("..##..##.")
                .addLine("#.#.##.#.")
                .build().get(0);

        int verticalReflectionLine = reflectionPattern.findVerticalReflectionLine();
        MatcherAssert.assertThat(verticalReflectionLine, Matchers.is(5));
    }

    @Test
    public void findHorizontalReflectionLineWithSmudgeForFirstExample() {
        ReflectionPattern reflectionPattern = ReflectionPattern.ReflectionPatternBuilder.create()
                .addLine("#.##..##.")
                .addLine("..#.##.#.")
                .addLine("##......#")
                .addLine("##......#")
                .addLine("..#.##.#.")
                .addLine("..##..##.")
                .addLine("#.#.##.#.")
                .build().get(0);

        int verticalReflectionLineWithSmudge = reflectionPattern.findHorizontalReflectionLineWithSmudge();
        MatcherAssert.assertThat(verticalReflectionLineWithSmudge, Matchers.is(3));
    }

    @Test
    public void findHorizontalReflectionLineWithSmudgeForSecondExample() {
        ReflectionPattern reflectionPattern = ReflectionPattern.ReflectionPatternBuilder.create()
                .addLine("#...##..#")
                .addLine("#....#..#")
                .addLine("..##..###")
                .addLine("#####.##.")
                .addLine("#####.##.")
                .addLine("..##..###")
                .addLine("#....#..#")
                .build().get(0);

        int verticalReflectionLineWithSmudge = reflectionPattern.findHorizontalReflectionLineWithSmudge();
        MatcherAssert.assertThat(verticalReflectionLineWithSmudge, Matchers.is(1));

    }
}

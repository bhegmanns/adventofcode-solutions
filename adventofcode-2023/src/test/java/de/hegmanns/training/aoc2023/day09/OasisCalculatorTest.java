package de.hegmanns.training.aoc2023.day09;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class OasisCalculatorTest {


    @Test
    public void parseLineToValues() {
        String line = "   0 3 6 9 12 15   ";
        List<Long> longs = OasisCalculator.parseToLongList(line);

        MatcherAssert.assertThat(longs, Matchers.contains(0L, 3L, 6L, 9L, 12L, 15L));
    }

    @Test
    public void parseLineWithBrightSpaces() {
        String line = "   0 3  6 9  12   15   ";
        List<Long> longs = OasisCalculator.parseToLongList(line);

        MatcherAssert.assertThat(longs, Matchers.contains(0L, 3L, 6L, 9L, 12L, 15L));
    }

    @Test
    public void parseEmptyString() {
        String line = "";
        List<Long> longs = OasisCalculator.parseToLongList(line);

        MatcherAssert.assertThat(longs, Matchers.empty());
    }

    @Test
    public void parseStringWithWhitespace() {
        String line = " ";
        List<Long> longs = OasisCalculator.parseToLongList(line);

        MatcherAssert.assertThat(longs, Matchers.empty());
    }

    @Test
    public void parseStringWithWhitespacesOnly() {
        String line = "      ";
        List<Long> longs = OasisCalculator.parseToLongList(line);

        MatcherAssert.assertThat(longs, Matchers.empty());
    }

    @Test
    public void parseNullString() {
        String line = null;
        List<Long> longs = OasisCalculator.parseToLongList(line);

        MatcherAssert.assertThat(longs, Matchers.empty());
    }

    @ParameterizedTest
    @CsvSource({"0 3 6 9 12 15, 18", "1 3 6 10 15 21, 28", "10 13 16 21 30 45, 68"})
    public void calculateNextOasisNumber(String definitionLine, long nextExpectedOasisNumber) {
        long nextOasisNumber = OasisCalculator.calculateNextOasisValue(OasisCalculator.parseToLongList(definitionLine));

        MatcherAssert.assertThat(nextOasisNumber, Matchers.is(nextExpectedOasisNumber));
    }

    @ParameterizedTest
    @CsvSource({"0 3 6 9 12 15, -3", "1 3 6 10 15 21, 0", "10 13 16 21 30 45, 5"})
    public void calculatePreviousOasisNumber(String definitionLine, long nextExpectedOasisNumber) {
        long previousOasisNumber = OasisCalculator.calculatePreviousOasisValue(OasisCalculator.parseToLongList(definitionLine));

        MatcherAssert.assertThat(previousOasisNumber, Matchers.is(nextExpectedOasisNumber));
    }

    @Test
    public void calculateNextNumber() {
        String definitionLine = "0 3 6 9 12 15";

        long l = OasisCalculator.calculateNextOasisValue(OasisCalculator.parseToLongList(definitionLine));
        MatcherAssert.assertThat(l, Matchers.is(18L));
    }

    @Test
    public void calculatePreviousNumber() {
        String definitionLine = "10 13 16 21 30 45";

        long previousOasisValue = OasisCalculator.calculatePreviousOasisValue(OasisCalculator.parseToLongList(definitionLine));
        MatcherAssert.assertThat(previousOasisValue, Matchers.is(5L));
    }
}

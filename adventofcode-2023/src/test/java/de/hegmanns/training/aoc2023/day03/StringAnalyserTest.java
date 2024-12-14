package de.hegmanns.training.aoc2023.day03;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StringAnalyserTest {

    @Test
    void findNoNumberAtPositionInStringWithoutNumbers() {
        List<NumberAtPosition> allNumbers =
                StringAnalyser.findAllNumbers("........................................................");
        MatcherAssert.assertThat(allNumbers, Matchers.empty());
    }

    @Test
    void findNoNumberAtPositionInEmpty() {
        List<NumberAtPosition> allNumbers =
                StringAnalyser.findAllNumbers("");
        MatcherAssert.assertThat(allNumbers, Matchers.empty());
    }

    @Test
    void findNoNumberAtPositionInNullString() {
        List<NumberAtPosition> allNumbers =
                StringAnalyser.findAllNumbers(null);
        MatcherAssert.assertThat(allNumbers, Matchers.empty());
    }

    @Test
    void findOneNumberAtPositionInStringWithNumberAtBeginning() {
        List<NumberAtPosition> allNumbers =
                StringAnalyser.findAllNumbers("1234........................");
        NumberAtPosition expectedNumberAtPosition = new NumberAtPosition();
        expectedNumberAtPosition.setNumber(1234L);
        expectedNumberAtPosition.setStartPosition(0);
        expectedNumberAtPosition.setFinalPosition(4);

        MatcherAssert.assertThat(allNumbers, Matchers.hasSize(1));
        MatcherAssert.assertThat(allNumbers.get(0), Matchers.samePropertyValuesAs(expectedNumberAtPosition));
    }

    @Test
    void findOneNumberAtPositionInStringWithNumberAtEnding() {
        List<NumberAtPosition> allNumbers =
                StringAnalyser.findAllNumbers("........................1234");
        NumberAtPosition expectedNumberAtPosition = new NumberAtPosition();
        expectedNumberAtPosition.setNumber(1234L);
        expectedNumberAtPosition.setStartPosition(24);
        expectedNumberAtPosition.setFinalPosition(28);

        MatcherAssert.assertThat(allNumbers, Matchers.hasSize(1));
        MatcherAssert.assertThat(allNumbers.get(0), Matchers.samePropertyValuesAs(expectedNumberAtPosition));
    }

    @Test
    void findOneNumberAtPositionInStringWithNumberInMiddle() {
        List<NumberAtPosition> allNumbers =
                StringAnalyser.findAllNumbers("...........12345.............");
        NumberAtPosition expectedNumberAtPosition = new NumberAtPosition();
        expectedNumberAtPosition.setNumber(12345L);
        expectedNumberAtPosition.setStartPosition(11);
        expectedNumberAtPosition.setFinalPosition(16);

        MatcherAssert.assertThat(allNumbers, Matchers.hasSize(1));
        MatcherAssert.assertThat(allNumbers.get(0), Matchers.samePropertyValuesAs(expectedNumberAtPosition));
    }

    @Test
    void findOneNumberAtPositionInStringWithCompleteNumber() {
        List<NumberAtPosition> allNumbers =
                StringAnalyser.findAllNumbers("123456789");
        NumberAtPosition expectedNumberAtPosition = new NumberAtPosition();
        expectedNumberAtPosition.setNumber(123456789L);
        expectedNumberAtPosition.setStartPosition(0);
        expectedNumberAtPosition.setFinalPosition(9);

        MatcherAssert.assertThat(allNumbers, Matchers.hasSize(1));
        MatcherAssert.assertThat(allNumbers.get(0), Matchers.samePropertyValuesAs(expectedNumberAtPosition));
    }

    @Test
    void findOneNumberAtPositionInStringWithNumbersInMiddle() {
        List<NumberAtPosition> allNumbers =
                StringAnalyser.findAllNumbers("...........12345......987.......");
        List<NumberAtPosition> expected = new ArrayList<>();
        NumberAtPosition expectedNumberAtPosition = new NumberAtPosition();
        expectedNumberAtPosition.setNumber(12345L);
        expectedNumberAtPosition.setStartPosition(11);
        expectedNumberAtPosition.setFinalPosition(16);
        expected.add(expectedNumberAtPosition);
        expectedNumberAtPosition = new NumberAtPosition();
        expectedNumberAtPosition.setNumber(987L);
        expectedNumberAtPosition.setStartPosition(22);
        expectedNumberAtPosition.setFinalPosition(25);
        expected.add(expectedNumberAtPosition);

        MatcherAssert.assertThat(allNumbers, Matchers.contains(expected.toArray()));
    }

    @Test
    void findOneNumberAtPositionInStringWithNumbersInMiddleAndEnding() {
        List<NumberAtPosition> allNumbers =
                StringAnalyser.findAllNumbers("...........12345......987.......456");
        List<NumberAtPosition> expected = new ArrayList<>();
        NumberAtPosition expectedNumberAtPosition = new NumberAtPosition();
        expectedNumberAtPosition.setNumber(12345L);
        expectedNumberAtPosition.setStartPosition(11);
        expectedNumberAtPosition.setFinalPosition(16);
        expected.add(expectedNumberAtPosition);
        expectedNumberAtPosition = new NumberAtPosition();
        expectedNumberAtPosition.setNumber(987L);
        expectedNumberAtPosition.setStartPosition(22);
        expectedNumberAtPosition.setFinalPosition(25);
        expected.add(expectedNumberAtPosition);
        expectedNumberAtPosition = new NumberAtPosition();
        expectedNumberAtPosition.setNumber(456L);
        expectedNumberAtPosition.setStartPosition(32);
        expectedNumberAtPosition.setFinalPosition(35);
        expected.add(expectedNumberAtPosition);

        MatcherAssert.assertThat(allNumbers, Matchers.contains(expected.toArray()));
    }

    @Test
    void findOneNumberAtPositionInStringWithNumbersInMiddleAndBeginning() {
        List<NumberAtPosition> allNumbers =
                StringAnalyser.findAllNumbers("456...........12345......987.......");
        List<NumberAtPosition> expected = new ArrayList<>();
        NumberAtPosition expectedNumberAtPosition = new NumberAtPosition();
        expectedNumberAtPosition.setNumber(456L);
        expectedNumberAtPosition.setStartPosition(0);
        expectedNumberAtPosition.setFinalPosition(3);
        expected.add(expectedNumberAtPosition);
        expectedNumberAtPosition = new NumberAtPosition();
        expectedNumberAtPosition.setNumber(12345L);
        expectedNumberAtPosition.setStartPosition(14);
        expectedNumberAtPosition.setFinalPosition(19);
        expected.add(expectedNumberAtPosition);
        expectedNumberAtPosition = new NumberAtPosition();
        expectedNumberAtPosition.setNumber(987L);
        expectedNumberAtPosition.setStartPosition(25);
        expectedNumberAtPosition.setFinalPosition(28);
        expected.add(expectedNumberAtPosition);

        MatcherAssert.assertThat(allNumbers, Matchers.contains(expected.toArray()));
    }

    @Test
    void findOneNumberAtPositionInStringWithNumbersInMiddleAndBeginningAndEnding() {
        List<NumberAtPosition> allNumbers =
                StringAnalyser.findAllNumbers("456...........12345......987.......159");
        List<NumberAtPosition> expected = new ArrayList<>();
        NumberAtPosition expectedNumberAtPosition = new NumberAtPosition();
        expectedNumberAtPosition.setNumber(456L);
        expectedNumberAtPosition.setStartPosition(0);
        expectedNumberAtPosition.setFinalPosition(3);
        expected.add(expectedNumberAtPosition);
        expectedNumberAtPosition = new NumberAtPosition();
        expectedNumberAtPosition.setNumber(12345L);
        expectedNumberAtPosition.setStartPosition(14);
        expectedNumberAtPosition.setFinalPosition(19);
        expected.add(expectedNumberAtPosition);
        expectedNumberAtPosition = new NumberAtPosition();
        expectedNumberAtPosition.setNumber(987L);
        expectedNumberAtPosition.setStartPosition(25);
        expectedNumberAtPosition.setFinalPosition(28);
        expected.add(expectedNumberAtPosition);
        expectedNumberAtPosition = new NumberAtPosition();
        expectedNumberAtPosition.setNumber(159);
        expectedNumberAtPosition.setStartPosition(35);
        expectedNumberAtPosition.setFinalPosition(38);
        expected.add(expectedNumberAtPosition);

        MatcherAssert.assertThat(allNumbers, Matchers.contains(expected.toArray()));
    }
}

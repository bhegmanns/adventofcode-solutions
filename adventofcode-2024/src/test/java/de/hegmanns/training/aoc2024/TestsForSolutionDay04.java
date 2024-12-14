package de.hegmanns.training.aoc2024;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.*;

public class TestsForSolutionDay04 {

    private static List<String> lines;
    private SolutionDay04 sut = new SolutionDay04();

    @BeforeAll
    static void setup() {
        lines = new ArrayList<>();
        lines.add("1234567890");
        lines.add("1234567890");
        lines.add("3333333333");
        lines.add("4444444444");
    }

    @ParameterizedTest
    @CsvSource({"3, 5, 4", "2,5,34", "0,5,6534"})
    void buildTestStringLeftDownWorks(int line, int column, String expectedString) {
        List<Character> characters = sut.buildTestStringLeftDown(lines, line, column);
        String result = "";
        for (Character character : characters) {
            result += character;
        }
        Assertions.assertThat(result).isEqualTo(expectedString);
    }

    @ParameterizedTest
    @CsvSource({"3, 5, 4", "2,5,34", "0,5,6734"})
    void buildTestStringRightDownWorks(int line, int column, String expectedString) {
        List<Character> characters = sut.buildTestStringRightDown(lines, line, column);
        String result = "";
        for (Character character : characters) {
            result += character;
        }
        Assertions.assertThat(result).isEqualTo(expectedString);
    }

    @ParameterizedTest
    @CsvSource({"3, 5, 4", "2,5,34", "0,5,6634"})
    void buildTestStringDownWorks(int line, int column, String expectedString) {
        List<Character> characters = sut.buildTestStringDown(lines, line, column);
        String result = "";
        for (Character character : characters) {
            result += character;
        }
        Assertions.assertThat(result).isEqualTo(expectedString);
    }

    @ParameterizedTest
    @CsvSource({"0, 5, 6", "1,5,65", "3,5,4343"})
    void buildTestStringLeftUpWorks(int line, int column, String expectedString) {
        List<Character> characters = sut.buildTestStringLeftUp(lines, line, column);
        String result = "";
        for (Character character : characters) {
            result += character;
        }
        Assertions.assertThat(result).isEqualTo(expectedString);
    }


    @ParameterizedTest
    @CsvSource({"0, 5, 6", "1,5,66", "3,5,4366"})
    void buildTestStringUpWorks(int line, int column, String expectedString) {
        List<Character> characters = sut.buildTestStringUp(lines, line, column);
        String result = "";
        for (Character character : characters) {
            result += character;
        }
        Assertions.assertThat(result).isEqualTo(expectedString);
    }

    @ParameterizedTest
    @CsvSource({"0, 5, 6", "1,5,67", "0,9,0", "1,9,0", "1,8, 90"})
    void buildTestStringRightUpWorks(int line, int column, String expectedString) {
        List<Character> characters = sut.buildTestStringRightUp(lines, line, column);
        String result = "";
        for (Character character : characters) {
            result += character;
        }
        Assertions.assertThat(result).isEqualTo(expectedString);
    }



    @ParameterizedTest
    @CsvSource({"0, 5, 654321", "0,0,1", "0,9,0987654321"})
    void buildLeftWorks(int line, int column, String expectedString) {
        List<Character> characters = sut.buildTestStringLeft(lines, line, column);
        String result = "";
        for (Character character : characters) {
            result += character;
        }
        Assertions.assertThat(result).isEqualTo(expectedString);
    }

    @ParameterizedTest
    @CsvSource({"0, 5, 67890", "0,0,1234567890", "0,9,0"})
    void buildRightWorks(int line, int column, String expectedString) {
        List<Character> characters = sut.buildTestStringRight(lines, line, column);
        String result = "";
        for (Character character : characters) {
            result += character;
        }
        Assertions.assertThat(result).isEqualTo(expectedString);
    }


    @ParameterizedTest
    @CsvSource({"MMMSXXMASM, false", "SXXMASM, false", "XXMASM, false", "XXXXXXXMASM, false", "XMASM, true", "MASM, false"})
    void findInArrayWorks(String elements, boolean find) {
        List<Character> characterList = elements.chars().mapToObj(c -> (char) c).toList();
        boolean b = sut.existsInArray(characterList);
        Assertions.assertThat(b).isEqualTo(find);
    }

    @Test
    void foo() {
        List<Character> characterList = "XXXXXXXMASM".chars().mapToObj(c -> (char) c).toList();
        boolean b = sut.existsInArray(characterList);
        Assertions.assertThat(b).isEqualTo(false);
    }

}

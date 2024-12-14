package de.hegmanns.training.aoc2023.day11;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MatrixTest {

    @Test
    public void getRowAsStringWorks() {
        Matrix matrix = Matrix.MatrixBuilder.create().
                withLineOfCharacters("11111")
                .withLineOfCharacters("22222")
                .withLineOfCharacters("33333")
                .build();

        matrix.getRowAsString(1);
        MatcherAssert.assertThat(matrix.getRowAsString(1), Matchers.equalTo("22222"));
    }

    @Test
    public void addRowEqualContentWorks() {
        Matrix matrix = Matrix.MatrixBuilder.create().
                withLineOfCharacters("11111")
                .withLineOfCharacters("22222")
                .withLineOfCharacters("33333")
                .build();

        matrix.addRowWithEqualContent('0', 1);

        MatcherAssert.assertThat(matrix.getRowAsString(1), Matchers.equalTo("00000"));
        MatcherAssert.assertThat(matrix.getRowAsString(2), Matchers.equalTo("22222"));
    }

    @Test
    public void addColumnEqualContentWorks() {
        Matrix matrix = Matrix.MatrixBuilder.create().
                withLineOfCharacters("11111")
                .withLineOfCharacters("22222")
                .withLineOfCharacters("33333")
                .build();

        matrix.addColumnWithEqualContent('0', 1);

        MatcherAssert.assertThat(matrix.getRowAsString(1), Matchers.equalTo("202222"));
        MatcherAssert.assertThat(matrix.getColumnAsString(1), Matchers.equalTo("000"));
    }

    @Test
    public void addRowWithShiftDown() {
        Matrix matrix = Matrix.MatrixBuilder.create().
                withLineOfCharacters("11111")
                .withLineOfCharacters("22222")
                .withLineOfCharacters("33333")
                .build();

        matrix.printOut();
        matrix.addRow("00000".toCharArray(), 1);
        System.out.println("----");
        matrix.printOut();
        MatcherAssert.assertThat(matrix.getRowAsString(1), Matchers.equalTo("00000"));
        MatcherAssert.assertThat(matrix.getRowAsString(2), Matchers.equalTo("22222"));
    }

    @Test
    public void addRowWithTooLongContent() {
        Matrix matrix = Matrix.MatrixBuilder.create().
                withLineOfCharacters("11111")
                .withLineOfCharacters("22222")
                .withLineOfCharacters("33333")
                .build();
        String tooLongContent = "000000";

        Assertions.assertThrows(IllegalArgumentException.class, () -> matrix.addRow(tooLongContent.toCharArray(), 1));
    }

    @Test
    public void addRowWithTooShortContent() {
        Matrix matrix = Matrix.MatrixBuilder.create().
                withLineOfCharacters("11111")
                .withLineOfCharacters("22222")
                .withLineOfCharacters("33333")
                .build();
        String tooShortContent = "0000";

        Assertions.assertThrows(IllegalArgumentException.class, () -> matrix.addRow(tooShortContent.toCharArray(), 1));
    }

    @Test
    public void addColumnWithShift() {
        Matrix matrix = Matrix.MatrixBuilder.create().
                withLineOfCharacters("11111")
                .withLineOfCharacters("22222")
                .withLineOfCharacters("33333")
                .build();

        matrix.printOut();
        matrix.addColumn("000".toCharArray(), 1);
        System.out.println("----");
        matrix.printOut();

        MatcherAssert.assertThat(matrix.getRowAsString(1), Matchers.equalTo("202222"));
        MatcherAssert.assertThat(matrix.getColumnAsString(1), Matchers.equalTo("000"));

    }

    @Test
    public void addColumnWithTooLongContent() {
        Matrix matrix = Matrix.MatrixBuilder.create().
                withLineOfCharacters("11111")
                .withLineOfCharacters("22222")
                .withLineOfCharacters("33333")
                .build();
        String tooLongContent = "0000";

        Assertions.assertThrows(IllegalArgumentException.class, () -> matrix.addColumn(tooLongContent.toCharArray(), 1));
    }

    @Test
    public void addColumnWithTooShortContent() {
        Matrix matrix = Matrix.MatrixBuilder.create().
                withLineOfCharacters("11111")
                .withLineOfCharacters("22222")
                .withLineOfCharacters("33333")
                .build();
        String tooShortContent = "00";

        Assertions.assertThrows(IllegalArgumentException.class, () -> matrix.addColumn(tooShortContent.toCharArray(), 1));
    }

    @Test
    public void findAllFilteredCharacters() {
        Matrix matrix = Matrix.MatrixBuilder.create().
                withLineOfCharacters ("11#11")
                .withLineOfCharacters("22222")
                .withLineOfCharacters("333#3")
                .build();

        List<MatrixElementValue> filter = matrix.filter(c -> c == '#');
        MatcherAssert.assertThat(filter, Matchers.hasSize(2));
        List<MatrixPosition> onlyPositions = filter.stream().map(MatrixElementValue::position).toList();
        MatcherAssert.assertThat(onlyPositions,
                Matchers.containsInAnyOrder(new MatrixPosition(2, 0), new MatrixPosition(3,2)));

    }

    @Test
    public void findAllFilteredCharactersWithNoResult() {
        Matrix matrix = Matrix.MatrixBuilder.create().
                withLineOfCharacters ("11111")
                .withLineOfCharacters("22222")
                .withLineOfCharacters("33313")
                .build();

        List<MatrixElementValue> filter = matrix.filter(c -> c == '#');
        MatcherAssert.assertThat(filter, Matchers.empty());
    }

    @Test
    public void findAllFilteredCharactersCompleteResult() {
        Matrix matrix = Matrix.MatrixBuilder.create().
                withLineOfCharacters ("#####")
                .withLineOfCharacters("#####")
                .withLineOfCharacters("#####")
                .build();

        List<MatrixElementValue> filter = matrix.filter(c -> c == '#');
        MatcherAssert.assertThat(filter, Matchers.hasSize(15));
    }
}

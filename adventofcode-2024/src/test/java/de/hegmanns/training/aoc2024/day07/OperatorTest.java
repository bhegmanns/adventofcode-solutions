package de.hegmanns.training.aoc2024.day07;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

public class OperatorTest {

    @Test
    void concatenateWorks() {
        Long firstValue = 123L;
        Long secondValue = 456L;

        Long calculate = Operator.CONCATENATE.calculate(firstValue, secondValue);
        Assertions.assertThat(calculate).isEqualTo(123456L);
    }

    @Test
    void concatenateWorksWithFirstZero() {
        Long firstValue = 0L;
        Long secondValue = 456L;
        Assertions.assertThat(Operator.CONCATENATE.calculate(firstValue, secondValue)).isEqualTo(456L);
    }

    @Test
    void concatenateWorksWithSecondZero() {
        Long firstValue = 123L;
        Long secondValue = 0L;
        Assertions.assertThat(Operator.CONCATENATE.calculate(firstValue, secondValue)).isEqualTo(1230L);
    }

    @Test
    void concatenateWorksWithBothZeros() {
        Long firstValue = 0L;
        Long secondValue = 0L;
        Assertions.assertThat(Operator.CONCATENATE.calculate(firstValue, secondValue)).isEqualTo(0L);
    }
}

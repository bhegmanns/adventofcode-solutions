package de.hegmanns.training.aoc2022.day18;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class ShapeTest {

    @Test
    void shapesAreConnected() {
        Shape shape = new Shape(1, 1, 1);
        Shape otherShape = new Shape(2, 1, 1);

        MatcherAssert.assertThat(shape.isConnected(otherShape), Matchers.is(true));
    }
}

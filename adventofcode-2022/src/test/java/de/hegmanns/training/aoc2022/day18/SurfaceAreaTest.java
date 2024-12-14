package de.hegmanns.training.aoc2022.day18;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SurfaceAreaTest {

    @Test
    public void boundingForOneShape() {
        Shape anyShape = new Shape(1, 1, 1);
        Shape anyOtherShape = new Shape(2, 2, 2);
        Shape shape3 = new Shape(1, 3, -1);

        List<Shape> shapes = Arrays.asList(anyShape, anyOtherShape, shape3);
        SurfaceArea surfaceArea = new SurfaceArea(shapes);

        Coordinate[] boundary = surfaceArea.getBoundary();

        MatcherAssert.assertThat(Arrays.stream(boundary).collect(Collectors.toList()), Matchers.contains(new Coordinate(1, 1, -1), new Coordinate(2, 3, 2)));
    }
}

package de.hegmanns.training.aoc2023.day21;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class GardenRockMapBoundariesTest {

    @Test
    void boundariesUnExpandedMap() {
        GardenRockMap map = GardenRockMapForTest.createBoundedRockMap5_5();

        MatcherAssert.assertThat(new MapPosition(0, 3).isLeftBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(1, 3).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(5, 3).isRightBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(6, 3).isRightBound(map), Matchers.is(false));

        MatcherAssert.assertThat(new MapPosition(3, 0).isUpperBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(3, 1).isUpperBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(3, 5).isBottomBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(3,6).isBottomBound(map), Matchers.is(false));

        MapPosition leftUpperCorner = new MapPosition(1, 1);
        MapPosition rightBottomCorner = new MapPosition(5, 5);

        MatcherAssert.assertThat(map.getOverflows(leftUpperCorner), Matchers.empty());
        MatcherAssert.assertThat(map.getOverflows(rightBottomCorner), Matchers.empty());
    }

    @Test
    void boundariesExpandedMap() {
        GardenRockMap map = GardenRockMapForTest.createCenteredRockMap5_5();
        map.expandLeftAndTop(1, 1);
        map.expandRightAndBottom(1, 1);

        MatcherAssert.assertThat(new MapPosition(0, 3).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1, 3).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(5, 3).isRightBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(6, 3).isRightBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(3, 0).isUpperBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(3, 1).isUpperBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(3, 5).isBottomBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(3,6).isBottomBound(map), Matchers.is(true));

        MatcherAssert.assertThat(new MapPosition(-4, 3).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(-5, 3).isLeftBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(3, -4).isUpperBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(3, -5).isUpperBound(map), Matchers.is(false));

        MatcherAssert.assertThat(new MapPosition(5,11).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(5,12).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(5,10).isBottomBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(5,9).isBottomBound(map), Matchers.is(true));

        MatcherAssert.assertThat(new MapPosition(11,3).isRightBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(12,3).isRightBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(10,3).isRightBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(9,3).isRightBound(map), Matchers.is(true));

        MapPosition leftUpperCorner = new MapPosition(-4, -4);
        MapPosition rightBottomCorner = new MapPosition(10, 10);
        MatcherAssert.assertThat(map.getOverflows(leftUpperCorner), Matchers.empty());
        MatcherAssert.assertThat(map.getOverflows(rightBottomCorner), Matchers.empty());
    }
}

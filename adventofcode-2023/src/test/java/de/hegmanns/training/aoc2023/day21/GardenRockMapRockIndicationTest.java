package de.hegmanns.training.aoc2023.day21;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class GardenRockMapRockIndicationTest {

    @Test
    void topRightNoExpand() {
        GardenRockMap map = GardenRockMapForTest.createCenteredRockMap5_5();

        MatcherAssert.assertThat(map.isRock(new MapPosition(3,3)), Matchers.is(true));

        MatcherAssert.assertThat("left-top", map.isRock(new MapPosition(1, 1)), Matchers.is(false));
        MatcherAssert.assertThat("right-bottom", map.isRock(new MapPosition(5, 5)), Matchers.is(false));
        MatcherAssert.assertThat("outside left-top", map.isRock(new MapPosition(0,0)), Matchers.is(false));
        MatcherAssert.assertThat("outside right-bottom", map.isRock(new MapPosition(6,6)), Matchers.is(false));
    }

    @Test
    void rightExpand() {
        GardenRockMap map = GardenRockMapForTest.createFullRockMap5_5();
        map.expandRightAndBottom(1, 0);

        MatcherAssert.assertThat("left-top", map.isRock(new MapPosition(1, 1)), Matchers.is(true));
        MatcherAssert.assertThat("outside left-top", map.isRock(new MapPosition(0, 1)), Matchers.is(false));
//        MatcherAssert.assertThat("first row right", map.isRock(new MapPosition(10, 1)), Matchers.is(true));
        MatcherAssert.assertThat("first row right inside", map.isRock(new MapPosition(9, 1)), Matchers.is(true));
        MatcherAssert.assertThat("first row right outside", map.isRock(new MapPosition(11, 1)), Matchers.is(false));
//        MatcherAssert.assertThat("last row left", map.isRock(new MapPosition(1, 5)), Matchers.is(true));
        MatcherAssert.assertThat("last row left outside", map.isRock(new MapPosition(0, 5)), Matchers.is(false));
//        MatcherAssert.assertThat("last row right", map.isRock(new MapPosition(10, 5)), Matchers.is(true));
        MatcherAssert.assertThat("last row right outside", map.isRock(new MapPosition(11, 5)), Matchers.is(false));
        MatcherAssert.assertThat("inside", map.isRock(new MapPosition(3,3)), Matchers.is(true));
        MatcherAssert.assertThat("outside", map.isRock(new MapPosition(-3,-3)), Matchers.is(false));
    }

    @Test
    void downExpand() {
        GardenRockMap map = GardenRockMapForTest.createFullRockMap5_5();
        map.expandRightAndBottom(0, 1);

        MatcherAssert.assertThat("left-top", map.isRock(new MapPosition(1, 1)), Matchers.is(true));
        MatcherAssert.assertThat("outside left-top", map.isRock(new MapPosition(0, 1)), Matchers.is(false));
        MatcherAssert.assertThat("first row right (inside)", map.getOverflows(new MapPosition(1,10)), Matchers.empty());
//        MatcherAssert.assertThat("first row right (isRock)", map.isRock(new MapPosition(1, 10)), Matchers.is(true));
        MatcherAssert.assertThat("first row right inside", map.isRock(new MapPosition(1, 9)), Matchers.is(true));
        MatcherAssert.assertThat("first row right outside", map.isRock(new MapPosition(11, 1)), Matchers.is(false));
        MatcherAssert.assertThat("last row left (inside)", map.getOverflows(new MapPosition(1,5)), Matchers.empty());
//        MatcherAssert.assertThat("last row left", map.isRock(new MapPosition(1, 5)), Matchers.is(true));
        MatcherAssert.assertThat("last row left outside", map.isRock(new MapPosition(0, 5)), Matchers.is(false));
        MatcherAssert.assertThat("last row right (inside)", map.getOverflows(new MapPosition(5, 10)), Matchers.empty());
        MatcherAssert.assertThat("last row right", map.isRock(new MapPosition(5, 10)), Matchers.is(true));
        MatcherAssert.assertThat("last row right outside", map.isRock(new MapPosition(11, 5)), Matchers.is(false));
    }

    @Test
    void expandRightAndBottom() {
        GardenRockMap map = GardenRockMapForTest.createFullRockMap5_5();
        map.expandRightAndBottom(1, 1);

        MatcherAssert.assertThat("left-top", map.isRock(new MapPosition(1, 1)), Matchers.is(true));

        MatcherAssert.assertThat("first row right (inside)", map.getOverflows(new MapPosition(10,1)), Matchers.empty());
//        MatcherAssert.assertThat("first row right", map.isRock(new MapPosition(10, 1)), Matchers.is(true));
        MatcherAssert.assertThat("first row outside right", map.isRock(new MapPosition(11, 1)), Matchers.is(false));

        MatcherAssert.assertThat("right-bottom (inside)", map.getOverflows(new MapPosition(10, 10)), Matchers.empty());
//        MatcherAssert.assertThat("right-bottom", map.isRock(new MapPosition(10, 10)), Matchers.is(true));
        MatcherAssert.assertThat("outside right-bottom", map.isRock(new MapPosition(11, 11)), Matchers.is(false));
        MatcherAssert.assertThat("inside right-bottom", map.isRock(new MapPosition(9, 9)), Matchers.is(true));
    }


}

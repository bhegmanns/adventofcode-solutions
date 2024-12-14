package de.hegmanns.training.aoc2023.day21;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class MapPositionTest {

    GardenRockMap anyMap = new GardenRockMap(10, 10);

    @Test
    void indicatedLeftTop() {
        MapPosition leftTopPosition = new MapPosition(1,1);
        MatcherAssert.assertThat(leftTopPosition.isUpperBound(anyMap), Matchers.is(true));
        MatcherAssert.assertThat(leftTopPosition.isLeftBound(anyMap), Matchers.is(true));
        MatcherAssert.assertThat(leftTopPosition.isRightBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(leftTopPosition.isBottomBound(anyMap), Matchers.is(false));
    }

    @Test
    void indicatedRightBottom() {
        MapPosition rightBottomPosition = new MapPosition(10, 10);
        MatcherAssert.assertThat(rightBottomPosition.isUpperBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(rightBottomPosition.isLeftBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(rightBottomPosition.isRightBound(anyMap), Matchers.is(true));
        MatcherAssert.assertThat(rightBottomPosition.isBottomBound(anyMap), Matchers.is(true));
    }

    @Test
    void indicatedCenter() {
        MapPosition centerPosition = new MapPosition(5,5);
        MatcherAssert.assertThat(centerPosition.isUpperBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(centerPosition.isLeftBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(centerPosition.isRightBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(centerPosition.isBottomBound(anyMap), Matchers.is(false));
    }

    @Test
    void indicatedTopLine() {
        MapPosition topLinePosition = new MapPosition(5,1);
        MatcherAssert.assertThat(topLinePosition.isUpperBound(anyMap), Matchers.is(true));
        MatcherAssert.assertThat(topLinePosition.isLeftBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(topLinePosition.isRightBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(topLinePosition.isBottomBound(anyMap), Matchers.is(false));
    }

    @Test
    void indicatedBottomLine() {
        MapPosition bottomLinePosition = new MapPosition(5,10);
        MatcherAssert.assertThat(bottomLinePosition.isUpperBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(bottomLinePosition.isLeftBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(bottomLinePosition.isRightBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(bottomLinePosition.isBottomBound(anyMap), Matchers.is(true));
    }

    @Test
    void indicatedLeftLine() {
        MapPosition leftLinePosition = new MapPosition(1,5);
        MatcherAssert.assertThat(leftLinePosition.isUpperBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(leftLinePosition.isLeftBound(anyMap), Matchers.is(true));
        MatcherAssert.assertThat(leftLinePosition.isRightBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(leftLinePosition.isBottomBound(anyMap), Matchers.is(false));
    }

    @Test
    void indicatedRightLine() {
        MapPosition rightLinePosition = new MapPosition(10,5);
        MatcherAssert.assertThat(rightLinePosition.isUpperBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(rightLinePosition.isLeftBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(rightLinePosition.isRightBound(anyMap), Matchers.is(true));
        MatcherAssert.assertThat(rightLinePosition.isBottomBound(anyMap), Matchers.is(false));
    }

    @Test
    void indicatedSecondRightLine() {
        MapPosition secondRightLinePosition = new MapPosition(9, 5);
        MatcherAssert.assertThat(secondRightLinePosition.isUpperBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondRightLinePosition.isLeftBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondRightLinePosition.isRightBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondRightLinePosition.isBottomBound(anyMap), Matchers.is(false));
    }

    @Test
    void indicatedSecondLeftLine() {
        MapPosition secondLeftLinePosition = new MapPosition(2, 5);
        MatcherAssert.assertThat(secondLeftLinePosition.isUpperBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondLeftLinePosition.isLeftBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondLeftLinePosition.isRightBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondLeftLinePosition.isBottomBound(anyMap), Matchers.is(false));
    }

    @Test
    void indicatedSecondTopLine() {
        MapPosition secondTopLinePosition = new MapPosition(5, 2);
        MatcherAssert.assertThat(secondTopLinePosition.isUpperBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondTopLinePosition.isLeftBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondTopLinePosition.isRightBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondTopLinePosition.isBottomBound(anyMap), Matchers.is(false));
    }

    @Test
    void indicatedSecondBottomLine() {
        MapPosition secondBottomLinePosition = new MapPosition(5, 9);
        MatcherAssert.assertThat(secondBottomLinePosition.isUpperBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondBottomLinePosition.isLeftBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondBottomLinePosition.isRightBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondBottomLinePosition.isBottomBound(anyMap), Matchers.is(false));
    }

    @Test
    void indicatesSecondTopLeftLine() {
        MapPosition secondTopLeftLinePosition = new MapPosition(2,2);
        MatcherAssert.assertThat(secondTopLeftLinePosition.isUpperBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondTopLeftLinePosition.isLeftBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondTopLeftLinePosition.isRightBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondTopLeftLinePosition.isBottomBound(anyMap), Matchers.is(false));
    }

    @Test
    void indicatesSecondBottomRightLine() {
        MapPosition secondBottomRightLinePosition = new MapPosition(9,9);
        MatcherAssert.assertThat(secondBottomRightLinePosition.isUpperBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondBottomRightLinePosition.isLeftBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondBottomRightLinePosition.isRightBound(anyMap), Matchers.is(false));
        MatcherAssert.assertThat(secondBottomRightLinePosition.isBottomBound(anyMap), Matchers.is(false));
    }

    @Test
    void expandMapToRight1() {
        GardenRockMap map = new GardenRockMap(10, 10);
        map.expandRightAndBottom(1, 0);

        MatcherAssert.assertThat(new MapPosition(1,1).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(1,1).isUpperBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,1).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,1).isRightBound(map), Matchers.is(false));

        MatcherAssert.assertThat(new MapPosition(20,1).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(20,1).isUpperBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(20,1).isLeftBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(20,1).isRightBound(map), Matchers.is(true));

        MatcherAssert.assertThat(new MapPosition(1,20).isBottomBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,20).isUpperBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(1,20).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,20).isRightBound(map), Matchers.is(false));

        MatcherAssert.assertThat(new MapPosition(20,20).isBottomBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(20,20).isUpperBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(20,20).isLeftBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(20,20).isRightBound(map), Matchers.is(true));
    }

    @Test
    void expandMapToLeft1() {
        GardenRockMap map = new GardenRockMap(10, 10);
        map.expandLeftAndTop(1, 0);

        MatcherAssert.assertThat(new MapPosition(1, 1).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(1, 1).isUpperBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1, 1).isLeftBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(1, 1).isRightBound(map), Matchers.is(false));

        MatcherAssert.assertThat(new MapPosition(-20, 1).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(-20, 1).isUpperBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(-20, 1).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(-20, 1).isRightBound(map), Matchers.is(false));

        MatcherAssert.assertThat(new MapPosition(-19, 1).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(-19, 1).isUpperBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(-19, 1).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(-19, 1).isRightBound(map), Matchers.is(false));

        MatcherAssert.assertThat(new MapPosition(-10, 1).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(-10, 1).isUpperBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(-10, 1).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(-10, 1).isRightBound(map), Matchers.is(false));

        MatcherAssert.assertThat(new MapPosition(-9, 1).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(-9, 1).isUpperBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(-9, 1).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(-9, 1).isRightBound(map), Matchers.is(false));

        MatcherAssert.assertThat(new MapPosition(-8, 1).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(-8, 1).isUpperBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(-8, 1).isLeftBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(-8, 1).isRightBound(map), Matchers.is(false));
    }

    @Test
    void expandMapToBottom1() {
        GardenRockMap map = new GardenRockMap(10, 10);
        map.expandRightAndBottom(0,1);
        /*
        1...10
        .
        .
        20
         */

        MatcherAssert.assertThat(new MapPosition(1,1).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(1,1).isUpperBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,1).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,1).isRightBound(map), Matchers.is(false));

        MatcherAssert.assertThat(new MapPosition(20,1).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(20,1).isUpperBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(20,1).isLeftBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(20,1).isRightBound(map), Matchers.is(true));

        MatcherAssert.assertThat(new MapPosition(1,20).isBottomBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,20).isUpperBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(1,20).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,20).isRightBound(map), Matchers.is(false));

        MatcherAssert.assertThat(new MapPosition(20,20).isBottomBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(20,20).isUpperBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(20,20).isLeftBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(20,20).isRightBound(map), Matchers.is(true));

        MatcherAssert.assertThat(new MapPosition(20,19).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(20,19).isUpperBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(20,19).isLeftBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(20,19).isRightBound(map), Matchers.is(true));
    }

    @Test
    void expandMapToTop1() {
        GardenRockMap map = new GardenRockMap(10, 10);
        map.expandLeftAndTop(0, 1);
        /*
        x = [1 ... 10]
        y = [-9 ... 0, 1 ... 10]
         */
        MatcherAssert.assertThat(new MapPosition(1,1).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(1,1).isUpperBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(1,1).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,1).isRightBound(map), Matchers.is(false));

        MatcherAssert.assertThat(new MapPosition(20,1).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(20,1).isUpperBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(20,1).isLeftBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(20,1).isRightBound(map), Matchers.is(true));

        MatcherAssert.assertThat(new MapPosition(1,20).isBottomBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,20).isUpperBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(1,20).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,20).isRightBound(map), Matchers.is(false));

        MatcherAssert.assertThat(new MapPosition(1,10).isBottomBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,10).isUpperBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(1,10).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,10).isRightBound(map), Matchers.is(false));

        MatcherAssert.assertThat(new MapPosition(1,-9).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(1,-9).isUpperBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,-9).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,-9).isRightBound(map), Matchers.is(false));

        MatcherAssert.assertThat(new MapPosition(1,-10).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(1,-10).isUpperBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,-10).isLeftBound(map), Matchers.is(true));
        MatcherAssert.assertThat(new MapPosition(1,-10).isRightBound(map), Matchers.is(false));

        MatcherAssert.assertThat(new MapPosition(10,-8).isBottomBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(10,-8).isUpperBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(10,-8).isLeftBound(map), Matchers.is(false));
        MatcherAssert.assertThat(new MapPosition(10,-8).isRightBound(map), Matchers.is(true));
    }
}

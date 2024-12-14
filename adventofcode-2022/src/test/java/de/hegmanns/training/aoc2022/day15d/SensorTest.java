package de.hegmanns.training.aoc2022.day15d;

import de.hegmanns.training.aoc2022.day14.Sensor;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SensorTest {

    @Test
    public void foo1() {
        Sensor s = Sensor.createFromDefinitionLine("Sensor at x=8, y=7: closest beacon is at x=2, y=10");

        MatcherAssert.assertThat(s.calculateRangeOfNotAdditionBeaconInLine(10).getPositionWidth(), Matchers.is(13L));
    }

    @Test
    public void foo2() {
        Sensor s = Sensor.createFromDefinitionLine("Sensor at x=8, y=7: closest beacon is at x=2, y=10");

        MatcherAssert.assertThat(s.calculateRangeOfNotAdditionBeaconInLine(16).getPositionWidth(), Matchers.is(1L));
    }

    @Test
    public void foo3() {
        Sensor s = Sensor.createFromDefinitionLine("Sensor at x=8, y=7: closest beacon is at x=2, y=10");

        MatcherAssert.assertThat(s.calculateRangeOfNotAdditionBeaconInLine(-1).getPositionWidth(), Matchers.is(3L));
    }

    @Test
    public void foo4() {
        Sensor s = Sensor.createFromDefinitionLine("Sensor at x=8, y=7: closest beacon is at x=2, y=10");

        MatcherAssert.assertThat(s.calculateRangeOfNotAdditionBeaconInLine(7).getPositionWidth(), Matchers.is(19L));
    }

    @Test
    public void foo5() {
        Sensor s = Sensor.createFromDefinitionLine("Sensor at x=8, y=7: closest beacon is at x=2, y=10");

        MatcherAssert.assertThat(s.calculateRangeOfNotAdditionBeaconInLine(17), Matchers.nullValue());
    }

    @Test
    public void foo6() {
        Sensor s = Sensor.createFromDefinitionLine("Sensor at x=8, y=7: closest beacon is at x=2, y=10");

        MatcherAssert.assertThat(s.calculateRangeOfNotAdditionBeaconInLine(-3), Matchers.nullValue());
    }

    @Test
    public void foo7() {
        Sensor s = Sensor.createFromDefinitionLine("Sensor at x=8, y=7: closest beacon is at x=2, y=10");

        MatcherAssert.assertThat(s.calculateRangeOfNotAdditionBeaconInLine(20), Matchers.nullValue());
    }
}

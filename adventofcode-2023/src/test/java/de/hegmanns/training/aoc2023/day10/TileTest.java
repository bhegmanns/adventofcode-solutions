package de.hegmanns.training.aoc2023.day10;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class TileTest {

    @Test
    void S_connectable_to_NS_direction_NOTH() {
        MatcherAssert.assertThat(Tile.S.isConnectable(Tile.NS, Direction.NORTH), Matchers.is(true));
    }

    @Test
    void S_notconnectable_to_NS_direction_WEST() {
        MatcherAssert.assertThat(Tile.S.isConnectable(Tile.NS, Direction.WEST), Matchers.is(false));
    }

    @Test
    void EW_notconnectable_to_NS_direction_EAST() {
        MatcherAssert.assertThat(Tile.EW.isConnectable(Tile.NS, Direction.EAST), Matchers.is(false));
    }

    @Test
    void EW_connectable_to_SW_direction_EAST() {
        MatcherAssert.assertThat(Tile.EW.isConnectable(Tile.SW, Direction.EAST), Matchers.is(true));
    }

    @Test
    void EW_connectable_to_NW_direction_EAST() {
        MatcherAssert.assertThat(Tile.EW.isConnectable(Tile.NW, Direction.EAST), Matchers.is(true));
    }

    @Test
    void EW_connectable_to_EW_direction_EAST() {
        MatcherAssert.assertThat(Tile.EW.isConnectable(Tile.EW, Direction.EAST), Matchers.is(true));
    }


}

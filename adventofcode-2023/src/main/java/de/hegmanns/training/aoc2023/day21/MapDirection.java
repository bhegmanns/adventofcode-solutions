package de.hegmanns.training.aoc2023.day21;

import java.util.function.Consumer;
import java.util.function.Function;

public enum MapDirection {

    LEFT((g) -> g.expandLeftAndTop(1, 0)),
    RIGHT(g -> g.expandRightAndBottom(1, 0)),
    UP(g -> g.expandLeftAndTop(0, 1)),
    DOWN(g -> g.expandRightAndBottom(0, 1));

    private Consumer<GardenRockMap> function;

    MapDirection(Consumer<GardenRockMap> function) {
        this.function = function;
    }

    public void acceptWithGardenRockMap(GardenRockMap map) {
        function.accept(map);
    }
}

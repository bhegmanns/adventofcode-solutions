package de.hegmanns.training.aoc2023.day21;

import java.util.Objects;

public class MapPosition {

    private int x;
    private int y;
    public MapPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void shift(int deltaX, int deltaY) {
        this.x = this.x + deltaX;
        this.y = this.y + deltaY;
    }

    public MapPosition getShiftedMapPosition(int deltaX, int deltaY) {
        return new MapPosition(this.x + deltaX, this.y + deltaY);
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapPosition that = (MapPosition) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "MapPosition{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Indicates is this {@link MapPosition} is inside the left bounds of the {@link GardenRockMap}.
     *
     * @param map the map
     * @return <i>true</i> is this instance is inside the left bound, <i>false</i> otherwise
     */
    public boolean isLeftBound(GardenRockMap map) {
        return !map.getOverflows(this).contains(MapDirection.LEFT);
    }

    /**
     * Indicates is this {@link MapPosition} is inside the upper bounds of the {@link GardenRockMap}.
     *
     * @param map the map
     * @return <i>true</i> is this instance is inside the upper bound, <i>false</i> otherwise
     */
    public boolean isUpperBound(GardenRockMap map) {
        return !map.getOverflows(this).contains(MapDirection.UP);
    }

    /**
     * Indicates is this {@link MapPosition} is inside the right bounds of the {@link GardenRockMap}.
     *
     * @param map the map
     * @return <i>true</i> is this instance is inside the right bound, <i>false</i> otherwise
     */
    public boolean isRightBound(GardenRockMap map) {
        return !map.getOverflows(this).contains(MapDirection.RIGHT);
    }

    /**
     * Indicates is this {@link MapPosition} is inside the bottom bounds of the {@link GardenRockMap}.
     *
     * @param map the map
     * @return <i>true</i> is this instance is inside the bottom bound, <i>false</i> otherwise
     */
    public boolean isBottomBound(GardenRockMap map) {
        return !map.getOverflows(this).contains(MapDirection.DOWN);
    }
}

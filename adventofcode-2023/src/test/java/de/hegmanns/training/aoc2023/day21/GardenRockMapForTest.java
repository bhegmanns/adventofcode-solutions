package de.hegmanns.training.aoc2023.day21;

public class GardenRockMapForTest {

    /**
     * .....
     * .....
     * ..#..
     * .....
     * .....
     * @return
     */
    public static GardenRockMap createCenteredRockMap5_5() {
        GardenRockMap map = new GardenRockMap(5, 5);
        map.getRockPositions().add(new MapPosition(3, 3));
        return map;
    }

    /**
     * #####
     * #...#
     * #...#
     * #...#
     * #####
     *
     * @return
     */
    public static GardenRockMap createBoundedRockMap5_5() {
        GardenRockMap map = new GardenRockMap(5, 5);

        map.getRockPositions().add(new MapPosition(1, 1));
        map.getRockPositions().add(new MapPosition(2, 1));
        map.getRockPositions().add(new MapPosition(3, 1));
        map.getRockPositions().add(new MapPosition(4, 1));
        map.getRockPositions().add(new MapPosition(5, 1));


        map.getRockPositions().add(new MapPosition(1, 5));
        map.getRockPositions().add(new MapPosition(2, 5));
        map.getRockPositions().add(new MapPosition(3, 5));
        map.getRockPositions().add(new MapPosition(4, 5));
        map.getRockPositions().add(new MapPosition(5, 5));

        map.getRockPositions().add(new MapPosition(1, 2));
        map.getRockPositions().add(new MapPosition(1, 3));
        map.getRockPositions().add(new MapPosition(1, 4));


        map.getRockPositions().add(new MapPosition(5, 2));
        map.getRockPositions().add(new MapPosition(5, 3));
        map.getRockPositions().add(new MapPosition(5, 4));

        return map;
    }

    /**
     *
     * #####
     * #####
     * #####
     * #####
     * #####
     *
     * @return
     */
    public static GardenRockMap createFullRockMap5_5() {
        GardenRockMap map = new GardenRockMap(5, 5);

        for (int row = 1; row <= 5; row++) {
            for (int column = 1; column <= 5; column++) {
                map.getRockPositions().add(new MapPosition(column, row));
            }
        }

        return map;
    }
}

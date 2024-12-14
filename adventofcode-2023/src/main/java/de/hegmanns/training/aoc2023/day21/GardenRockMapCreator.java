package de.hegmanns.training.aoc2023.day21;

import java.util.List;

public class GardenRockMapCreator {

    private final List<String> lines;
    private GardenRockMap gardenRockMap;
    private MapPosition startPosition;

    public GardenRockMapCreator(List<String> lines) {
        this.lines = lines;

        createFromInputLines();
    }


    private void createFromInputLines() {
        GardenRockMap.Builder builder = new GardenRockMap.Builder();
        int y = 1;
        for (var line : lines) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '#') {
                    builder.addRockPosition(i + 1, y);
                }
                if (line.charAt(i) == 'S') {
                    this.startPosition = new MapPosition(i + 1, y);
                }
            }
            y++;
        }

        this.gardenRockMap = builder.build();
    }

    public GardenRockMap getGardenRockMap() {
        return gardenRockMap;
    }

    public MapPosition getStartPosition() {
        return startPosition;
    }

}

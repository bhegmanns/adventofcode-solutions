package de.hegmanns.training.aoc2023.day02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    private long id;
    List<Grap> graps = new ArrayList<>();

    public Game(String lineDefinition) {
        //Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
        String[] gameSplit = lineDefinition.split(":");
        String[] grappedSplit = gameSplit[1].split(";");

        id = Long.parseLong(gameSplit[0].substring(5));
        for (String grap : grappedSplit) {
            graps.add(new Grap(grap));
        }
    }

    public long getId() {
        return id;
    }

    public boolean isPossible(Grap maxGrap) {
        for (Grap grap : graps) {
            for (Color c : Color.values()) {
                if (grap.getGrappedColor(c) > maxGrap.getGrappedColor(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public long getPower() {
        HashMap<Color, Long> minimumPowerMap = new HashMap<>();
        minimumPowerMap.put(Color.RED, 0L);
        minimumPowerMap.put(Color.BLUE, 0L);
        minimumPowerMap.put(Color.GREEN, 0L);
        for (Grap grap : graps) {
            for (Color c : Color.values()) {
                if (grap.getGrappedColor(c) > minimumPowerMap.get(c)) {
                    minimumPowerMap.put(c, grap.getGrappedColor(c));
                }
            }
        }
        long product = 1;
        for (Color c : Color.values()) {
            product *= minimumPowerMap.get(c);
        }
        return product;
    }
}

package de.hegmanns.training.aoc2023.day02;

import java.util.HashMap;

public class Grap {
    private HashMap<Color, Long> countOfColors = new HashMap<>();

    public Grap() {
    }

    public Grap(String grapLine) {
        if (grapLine == null) {
            return;
        }

        String[] splitColors = grapLine.trim().split(",");
        for (String splitColor : splitColors) {
            int firstWhiteSpace = splitColor.trim().indexOf(' ');
            if (firstWhiteSpace == -1 || splitColor.isEmpty() || splitColor.isBlank()) {
                continue;
            }
            long count = Long.parseLong(splitColor.trim().substring(0, firstWhiteSpace));
            String colorString = splitColor.trim().substring(firstWhiteSpace).trim();

            try {
                countOfColors.put(Color.valueOf(colorString.toUpperCase()), count);
            } catch (IllegalArgumentException e) {
                // nothing to do
            }
        }

    }

    public HashMap<Color, Long> getCountOfColors() {
        return countOfColors;
    }

    public void addGrappedColor(Color color, long count) {
        if (countOfColors.containsKey(color)) {
            throw new IllegalArgumentException("color already exists");
        }
        countOfColors.put(color, count);
    }

    public long getGrappedColor(Color color) {
        Long grappedCountOfColor = countOfColors.get(color);
        return grappedCountOfColor == null ? 0 : grappedCountOfColor;
    }
}

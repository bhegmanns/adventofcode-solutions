package de.hegmanns.training.aoc2023.day08;

public record Target(String leftTarget, String rightTarget) {

    public String getTarget(String navigation) {
        if (navigation.equalsIgnoreCase("L")) {
            return leftTarget;
        }
        if (navigation.equalsIgnoreCase("R")) {
            return rightTarget;
        }
        return null;
    }
}

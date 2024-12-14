package de.hegmanns.training.aoc2023.day08;


public class NavigationRule {

    private String from;
    private Target target;

    public NavigationRule(String from, Target target) {
        this.from = from;
        this.target = target;
    }

    public String getFrom() {
        return from;
    }

    public Target getTarget() {
        return target;
    }
}

package de.hegmanns.training.aoc2021.day06;

public class Lanternfish {
    private int timer;

    public Lanternfish(int timer) {
        this.timer = timer;
    }

    public boolean nextDay() {
        timer--;
        if (timer < 0) {
            timer = 6;
            return true;
        } else {
            return false;
        }
    }
}

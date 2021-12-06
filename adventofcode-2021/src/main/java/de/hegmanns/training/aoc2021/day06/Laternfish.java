package de.hegmanns.training.aoc2021.day06;

public class Laternfish {
    private int timer;

    public Laternfish(int timer) {
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

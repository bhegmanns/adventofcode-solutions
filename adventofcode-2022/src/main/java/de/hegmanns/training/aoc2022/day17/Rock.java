package de.hegmanns.training.aoc2022.day17;

import java.util.List;

public class Rock {

    private int height;
    private int width;
    private List<Coordinate> freeCoordinates;

    private boolean rested = false;

    private Tower tower;
    private Coordinate location;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean pushLeft() {
        if (rested) {
            return false;
        }
        rested = tower.pushRockLeft(this);
        return false;
    }

    public boolean pushRight() {
        if (rested) {
            return false;
        }
        rested = tower.pushRockRight(this);
        return false;
    }

    public boolean fallOneStep() {
        if (rested) {
            return false;
        }

        return tower.fallOneStep(this);
    }

}

package de.hegmanns.training.aoc2022.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Tower {

    public static final String FREEROW = ".......";
    public static final String FULLROW = "#######";
    private long currentHeight;
    private long currentPlace;

    private long skippedNotReachableRows = 0;

    private Rock currentRock = null;

    private List<String> rows = new ArrayList<>();


    public Tower() {
        this.currentHeight = 3;
        this.currentPlace = 3;
        this.rows.add(FREEROW);
        this.rows.add(FREEROW);
        this.rows.add(FREEROW);
    }

    public Coordinate placeRock(Rock rock) {
        int rocketHeight = rock.getHeight();

        int neededHeight = rocketHeight+3;
        expandTower(neededHeight);
        return null;
    }

    public boolean pushRockRight(Rock rock) {
        Rock currentFallingRock = getCurrentFallingRockOrFails();

        return false;
    }

    public boolean pushRockLeft(Rock rock) {

        //rock.setLocation(...);
        return false;
    }

    private Rock getCurrentFallingRockOrFails() {
        if (currentRock == null) {
            throw new NullPointerException("no falling rock available");
        }

        return currentRock;
    }

    private void expandTower(long newHeight) {
        if (currentHeight >= newHeight) {
            return;
        }
        LongStream.range(0, newHeight - currentHeight).forEach((i) -> this.rows.add("......."));
        this.currentHeight = newHeight;
    }

    public boolean fallOneStep(Rock rock) {
        if (currentPlace > 0) {
            // call free fall
        } else {
            // there are rocks, so we have to show

        }

        return false;
    }
}

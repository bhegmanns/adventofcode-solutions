package de.hegmanns.training.aoc2022.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Square {

    private int x;
    private int y;

    private char relativeHeight;

    private boolean isStart;
    private boolean isFinal;

    private List<Square> possibleNextWays = new ArrayList<>();

    private List<Square> possibleBackWays = new ArrayList<>();

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return x == square.x && y == square.y;
    }

    @Override
    public String toString() {
        return "Square{" +
                "x=" + x +
                ", y=" + y +
                ", relativeHeight=" + relativeHeight +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public char getRelativeHeight() {
        return relativeHeight;
    }

    public void setRelativeHeight(char relativeHeight) {
        this.relativeHeight = relativeHeight;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean possibleToReach(Square square) {
        if (this.isFinal) {
            return false;
        }
        char maxChar = (char)(this.getRelativeHeight() + 1);
        return square.getRelativeHeight()<=maxChar;
    }

    public boolean possibleWayBack(Square square) {
        if (this.isFinal) {
            return square.getRelativeHeight()=='z';
        }
        if (this.isStart) {
            return square.getRelativeHeight() == 'a';
        }
        return square.getRelativeHeight()>=this.getRelativeHeight()-1;
    }

    public List<Square> getPossibleNextWays() {
        return possibleNextWays;
    }

    public List<Square> getPossibleBackWays() {
        return possibleBackWays;
    }
}

package de.hegmanns.training.aoc2022.day08;

public class Tree {

    private final int relativeHeight;



    private boolean visible;

    public Tree(int relativeHeight) {
        this.relativeHeight = relativeHeight;
    }

    public int getRelativeHeight() {
        return relativeHeight;
    }

    public void setVisible() {
        this.visible = true;
    }

    public void setUnvisible() {
        this.visible = false;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }


    @Override
    public String toString() {
        return "Tree{" +
                "relativeHeight=" + relativeHeight +
                '}';
    }
}

package de.hegmanns.training.aoc2022.day09;

public abstract class Moveable {

    private Position currentPosition;

    private Moveable CorrespondingMovable;

    protected Moveable(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setCorrespondingMovable(Moveable movable) {
        this.CorrespondingMovable = movable;
    }

    public Moveable getCorrespondingMovable() {
        return CorrespondingMovable;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    protected void setCurrentPosition(Position newPosition){
        this.currentPosition = newPosition;
    }

    public void followToPosition(Grid grid, Position position) {
        Position currentHeadPosition = position;

        int deltaX = currentHeadPosition.getX()-currentPosition.getX();
        int deltaY = currentHeadPosition.getY()-currentPosition.getY();

        if (deltaX <= 1 && deltaX >= -1 && deltaY <= 1 && deltaY >= -1) {
            return;
        }

        currentPosition = grid.getPosition(currentPosition.getX() + Integer.signum(deltaX), currentPosition.getY() + Integer.signum(deltaY));


        if (getCorrespondingMovable() != null) {
            getCorrespondingMovable().followToPosition(grid, currentPosition);
        } else {
            currentPosition.markVisitedByTail(); // the last tail
        }
    }
}

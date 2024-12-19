package de.hegmanns.training.aoc2024.day06;

import de.hegmanns.training.aoc.common.geometric.Point;

import java.util.Map;

public class NorthpoleGuard {
    private Point currentPosition;

    private MovingDirection movingDirection = MovingDirection.UP;

    @Override
    public String toString() {
        return "NorthpoleGuard{" +
                "currentPosition=" + currentPosition +
                ", movingDirection=" + movingDirection +
                '}';
    }

    public int getxCoordinate() {
        return currentPosition.x();
    }

    public int getyCoordinate() {
        return currentPosition.y();
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public Point getPositionAfterMovement() {
        return currentPosition.move(new Point(movingDirection.xMovement, movingDirection.yMovement));
    }

    public void move() {
        currentPosition = getPositionAfterMovement();
    }

    public void turnRight() {
        movingDirection = movingDirection.turnRight();
    }

    public MovingDirection getMovingDirection() {
        return movingDirection;
    }

    public enum MovingDirection {
        UP(0,-1),
        DOWN(0,1),
        LEFT(-1,0),
        RIGHT(1,0);

        private int xMovement;
        private int yMovement;
        MovingDirection(int xMovement, int yMovement) {
            this.xMovement = xMovement;
            this.yMovement = yMovement;
        }

        private static Map<MovingDirection, MovingDirection> nextDirectionFromTurnRight =
                Map.of(UP, RIGHT,
                        RIGHT, DOWN,
                        DOWN, LEFT,
                        LEFT, UP);
        public MovingDirection turnRight() {
            return nextDirectionFromTurnRight.get(this);
        }
    };
    public NorthpoleGuard(int xCoordinate, int yCoordinate) {
        this.currentPosition = new Point(xCoordinate, yCoordinate);
    }


}

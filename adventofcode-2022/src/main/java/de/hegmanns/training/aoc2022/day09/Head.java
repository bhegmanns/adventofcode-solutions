package de.hegmanns.training.aoc2022.day09;

public class Head extends Moveable{

    private Tail tail;

    public Head(Position startPosition) {
        super(startPosition);
    }

    public void move(Grid grid, MovingDirection movingDirection, int amount) {

        for (int i = 0; i < amount; i++) {

            // movement
            setCurrentPosition(calculateEndpointAfterMoveStep(movingDirection));

            // following by tail
            if (this.getCorrespondingMovable() != null) {
                this.getCorrespondingMovable().followToPosition(grid, this.getCurrentPosition());
            } else {
                throw new RuntimeException("no defined tail for current head");
            }
        }
    }

    private Position calculateEndpointAfterMoveStep(MovingDirection movingDirection) {
        Position nextPosition = null;
        Position currentPosition = getCurrentPosition();
        switch (movingDirection) {
            case DOWN:
                nextPosition = new Position(currentPosition.getX() , currentPosition.getY()-1);
                break;
            case UP:
                nextPosition = new Position(currentPosition.getX() , currentPosition.getY()+1);
                break;
            case LEFT:
                nextPosition = new Position(currentPosition.getX()-1, currentPosition.getY() );
                break;
            case RIGHT:
                nextPosition = new Position(currentPosition.getX()+1, currentPosition.getY());
                break;
        }
        return nextPosition;
    }
}

package de.hegmanns.training.aoc2021.day02;

import javax.swing.text.html.Option;
import java.util.Optional;

public class MoveCommand {
    private MovingDirection movingDirection;
    private int amount;



    public MoveCommand(MovingDirection movingDirection, int amount) {
        this.movingDirection = movingDirection;
        this.amount = amount;
    }

    public MovingDirection getMovingDirection() {
        return movingDirection;
    }

    public void setMovingDirection(MovingDirection movingDirection) {
        this.movingDirection = movingDirection;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

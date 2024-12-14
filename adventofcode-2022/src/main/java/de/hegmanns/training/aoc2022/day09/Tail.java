package de.hegmanns.training.aoc2022.day09;

public class Tail extends Moveable{
    private Position currentPosition;

    public Tail(Moveable head){
        super(head.getCurrentPosition());
    }

}

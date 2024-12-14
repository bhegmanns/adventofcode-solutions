package de.hegmanns.training.aoc2022.day09;

import java.util.*;

public class Grid  {

    private Set<Position> positions;
    private Head head ;
    private Tail tail ;
    private List<Tail> tails;

    public Grid(int countTails){
        this.positions = new HashSet<>();
        this.tails = new ArrayList<>();

        Position startPosition = new Position(1, 1);
        startPosition.markVisitedByTail();
        positions.add(startPosition);
        head = new Head(startPosition);
        Moveable currentMoveable = head;

        for (int i = 0; i < countTails; i++) {
            Tail theNewTail = new Tail(currentMoveable);
            currentMoveable.setCorrespondingMovable(theNewTail);
            currentMoveable = theNewTail;
            this.tails.add(theNewTail);
        }
    }

    public Grid(){
        this(1);
    }

    public Head getHead() {
        return head;
    }

    public Tail getTail() {
        return tail;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public Position getPosition(int x, int y) {
        Position position = positions.stream().filter(p -> p.getY() == y && p.getX() == x).findFirst().orElse(new Position(x, y));
        positions.add(position);

        return position;
    }
}

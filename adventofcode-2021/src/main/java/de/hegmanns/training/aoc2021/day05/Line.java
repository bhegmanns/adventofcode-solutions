package de.hegmanns.training.aoc2021.day05;


import java.util.ArrayList;
import java.util.List;

public class Line {

    private Point from;
    private Point to;

    public Point getFrom() {
        return from;
    }

    public Point getTo() {
        return to;
    }

    public List<Point> getOverlappedPoints(){
        List<Point> points = new ArrayList<>();

        if (isVertical() || isHorizontal() || isDiagonal()) {
            Direction direction = from.getDirectionTo(to);

            var currentPoint = from.backToPointFromDirection(direction);
            do {
                currentPoint = currentPoint.toNextPointInDirection(direction);
                points.add(currentPoint);
//                System.out.println(">>> currentPoint = " + currentPoint);
            }while(!currentPoint.equals(to));
        }

        return points;
    }

    public boolean isVertical() {
        return from.haveSameXCoordinate(to);
    }

    public boolean isHorizontal() {
        return from.haveSameYCoordinate(to);
    }

    public boolean isDiagonal() {
        return Math.abs(from.getX() - to.getX()) == Math.abs(from.getY() - to.getY());
    }

    public Line(String lineDefinition) {
        String[] split = lineDefinition.split("->");
        String[] fromString = split[0].trim().split(",");
        String[] toString = split[1].trim().split(",");
        int fromX = Integer.parseInt(fromString[0]);
        int fromY = Integer.parseInt(fromString[1]);
        int toX = Integer.parseInt(toString[0]);
        int toY = Integer.parseInt(toString[1]);
        from = new Point(fromX, fromY);
        to = new Point(toX, toY);
    }


}

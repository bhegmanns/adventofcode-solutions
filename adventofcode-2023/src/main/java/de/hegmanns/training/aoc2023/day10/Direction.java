package de.hegmanns.training.aoc2023.day10;

public enum Direction{
    NORTH,
    WEST,
    SOUTH,
    EAST,
    ALL;

    public Direction getOppositeDirection() {
        return switch (this) {
            case ALL -> null;
            case EAST -> WEST;
            case WEST -> EAST;
            case NORTH -> SOUTH;
            case SOUTH -> NORTH;
        };
    }
}

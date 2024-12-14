package de.hegmanns.training.aoc2023.day10;

import de.hegmanns.training.aoc2023.day07.CamelCard;

import java.util.HashMap;
import java.util.Map;

public enum Tile {
    /*
    | is a vertical pipe connecting north and south.
- is a horizontal pipe connecting east and west.
L is a 90-degree bend connecting north and east.
J is a 90-degree bend connecting north and west.
7 is a 90-degree bend connecting south and west.
F is a 90-degree bend connecting south and east.
. is ground; there is no pipe in this tile.
     */
    NS('|', de.hegmanns.training.aoc2023.day10.Direction.NORTH, de.hegmanns.training.aoc2023.day10.Direction.SOUTH),
    EW('-', de.hegmanns.training.aoc2023.day10.Direction.EAST, de.hegmanns.training.aoc2023.day10.Direction.WEST),
    NE('L', de.hegmanns.training.aoc2023.day10.Direction.NORTH, de.hegmanns.training.aoc2023.day10.Direction.EAST),
    NW('J', de.hegmanns.training.aoc2023.day10.Direction.NORTH, de.hegmanns.training.aoc2023.day10.Direction.WEST),
    SW('7', de.hegmanns.training.aoc2023.day10.Direction.SOUTH, de.hegmanns.training.aoc2023.day10.Direction.WEST),
    SE('F', de.hegmanns.training.aoc2023.day10.Direction.SOUTH, de.hegmanns.training.aoc2023.day10.Direction.EAST),
    GROUND('.', null, null),
    S('S', Direction.ALL, Direction.ALL);

    char sign;
    Direction connecting1;
    Direction connecting2;

    Tile(char sign, Direction connecting1, Direction connecting2) {
        this.sign=sign;
        this.connecting1 = connecting1;
        this.connecting2 = connecting2;
        Reference.add(this);
    }

    public static Tile parse(char c) {
        return Reference.reference.get(c);
    }

    public boolean isConnectable(Tile tile, Direction direction) {
        if (this == GROUND || tile == GROUND) {
            return false;
        }

        if (this == S || this.connecting1 == direction || this.connecting2 == direction) {
            if (tile != S) {
                Direction oppositeDirection = direction.getOppositeDirection();
                return oppositeDirection == tile.connecting1 || oppositeDirection == tile.connecting2;
            }
            return true; // tile == S connectable to all
        }

        return false;
    }

    static class Reference {
        private static Map<Character, Tile> reference = new HashMap<>();

        static void add(Tile tile) {
            reference.put(tile.sign, tile);
        }
    }
}

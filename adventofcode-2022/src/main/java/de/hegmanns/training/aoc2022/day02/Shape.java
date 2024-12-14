package de.hegmanns.training.aoc2022.day02;

import java.util.List;

public enum Shape {
    ROCK("A", "X", 1), //
    PAPER("B", "Y", 2),//
    SCISSOR("C", "Z", 3);//

    private String opponentSymbol;
    private String ownSymbol;

    private Shape defeatAgainst;

    private Shape looseAgainst;

    private int points;

    private static boolean enriched = false;

    private Shape(String opponentSymbol, String ownSymbol, int points){
        this.opponentSymbol = opponentSymbol;
        this.ownSymbol = ownSymbol;
        this.points = points;
    }



    private static void enriche(){
        if (!enriched) {
            ROCK.defeatAgainst = SCISSOR;
            SCISSOR.defeatAgainst = PAPER;
            PAPER.defeatAgainst = ROCK;

            ROCK.looseAgainst = PAPER;
            SCISSOR.looseAgainst = ROCK;
            PAPER.looseAgainst = SCISSOR;
        }
        enriched=true;
    }
    public static Shape getOpponentBySymbol(String opponentSymbol) {
        enriche();

        for (Shape shape : Shape.values()) {
            if (shape.opponentSymbol.equals(opponentSymbol)) {
                return shape;
            }
        }

        return null; // will never happen
    }

    public Shape getDefeatAgainst() {
        return defeatAgainst;
    }

    public Shape getLooseAgainst() {
        return looseAgainst;
    }

    public int getPoints() {
        return points;
    }
}

package de.hegmanns.training.aoc2022.day12;

import java.util.*;
import java.util.stream.Collectors;

public class SolutionTree {

    private Set<Square> squares;
    private Square startSquare;
    private Square finalSquare;
    private boolean full;

    public SolutionTree(){
        this.squares = new HashSet<>();
    }

    public Square getSquareByCoordinates(int x, int y) {

        Square sq = null;
        if (!full) {
            sq = new Square(x, y);
        }
        Square exampleSquare = sq;
        Square squareForCoordinates = squares.stream().filter((s) -> s.equals(new Square(x, y))).findFirst().orElse(exampleSquare);

        if (squareForCoordinates == null) {
            throw new RuntimeException("SolutionTree is already calculated and no new Square-instances are possible");
        }
        squares.add(squareForCoordinates);
        return squareForCoordinates;
    }

    public void arrangePossibleSteps() {
        full = true;

        startSquare = squares.stream().filter(s -> s.isStart()).findFirst().get();
        finalSquare = squares.stream().filter(s -> s.isFinal()).findFirst().get();

        if (squares.stream().filter(Square::isStart).count() != 1 || squares.stream().filter(Square::isFinal).count() != 1) {
            throw new RuntimeException("Problem: more than on start and final square defined");
        }

        for (Square square : squares) {
            List<Square> directSquares = getDirectSquares(square);
            List<Square> collect = directSquares.stream().filter(square::possibleToReach).collect(Collectors.toList());
            square.getPossibleNextWays().addAll(collect);
            collect = directSquares.stream().filter(square::possibleWayBack).collect(Collectors.toList());
            square.getPossibleBackWays().addAll(collect);
        }
    }

    public List<List<Square>> calculateMovementsFromTargetToStart() {
        List<List<Square>> results = new ArrayList<>();
        List<List<Square>> movements = new ArrayList<>();
        List<Square> movement = new ArrayList<>();
        movement.add(finalSquare);
        movements.add(movement);

        //List<List<Square>> newMovements = new ArrayList<>();
        while (!movements.isEmpty()) {

            List<List<Square>> newMovements = new ArrayList<>();
            for (List<Square> currentMovement : movements) {
                Square lastElement = currentMovement.get(currentMovement.size() - 1);
                List<Square> possibleBackSquares = lastElement.getPossibleBackWays();
                List<Square> nextSquares = new ArrayList<>();
                for (Square possibleNextSquare : possibleBackSquares) {
                    if (!currentMovement.contains(possibleNextSquare)) {
                        nextSquares.add(possibleNextSquare);
                    }
                }
                if (!nextSquares.isEmpty()) {
                    for (Square s : nextSquares) {
                        List<Square> extendetMovement = new ArrayList<>(currentMovement);
                        extendetMovement.add(s);
                        if (s == startSquare) {
                            results.add(extendetMovement);
                        } else {
                            newMovements.add(extendetMovement);
                        }
                    }
                }
            }
            movements = newMovements;
            System.out.println(">>> " + movements.size());
        }

        return results;
    }

    public List<List<Square>> calculateMovementsFromStartToTarget() {
        List<List<Square>> results = new ArrayList<>();

        List<List<Square>> movements = new ArrayList<>();
        List<Square> movement = new ArrayList<>();
        movement.add(startSquare);
        movements.add(movement);

        while(!movements.isEmpty()) {
            List<List<Square>> movementsToDelete = new ArrayList<>();
            List<List<Square>> newMovements = new ArrayList<>();
            for (List<Square> currentMovement : movements) {
                Square lastElement = currentMovement.get(currentMovement.size() - 1);

                List<Square> possibleNextSquares = lastElement.getPossibleNextWays();

                List<Square> nextSquares = new ArrayList<>();
                for (Square possibleNextSquare : possibleNextSquares) {
                    if (!currentMovement.contains(possibleNextSquare)) {
                        nextSquares.add(possibleNextSquare);
                    }
                }
                if (nextSquares.isEmpty()) {
                    // current movement isn't possible :(
                    movementsToDelete.add(currentMovement);
                } else {
                    for (Square s : nextSquares) {
                        List<Square> extendetMovement = new ArrayList<>(currentMovement);
                        extendetMovement.add(s);
                        if (s == finalSquare) {
                            results.add(extendetMovement);
                        } else {
                            newMovements.add(extendetMovement);
                        }
                    }
                }

            }
            movements = newMovements;
            System.out.println("result.size = " + results.size());
            if (!movements.isEmpty()) {
                System.out.println(">>>" + movements.size());
                System.out.println(">>> " + movements.stream().map(List::size).sorted((a, b) -> a.compareTo(b)).findFirst().get());
            }
            System.out.println();
        }




        return results;
    }

    private List<Square> getDirectSquares(Square square){
        List<Square> directSquares = new ArrayList<>();

        squares.stream().filter(s -> s.equals(new Square(square.getX()-1, square.getY()))).findFirst().ifPresent(directSquares::add);
        squares.stream().filter(s -> s.equals(new Square(square.getX()+1, square.getY()))).findFirst().ifPresent(directSquares::add);
        squares.stream().filter(s -> s.equals(new Square(square.getX(), square.getY()-1))).findFirst().ifPresent(directSquares::add);
        squares.stream().filter(s -> s.equals(new Square(square.getX(), square.getY()+1))).findFirst().ifPresent(directSquares::add);

        return directSquares;
    }
}

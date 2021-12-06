package de.hegmanns.training.aoc2021.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BingoGame {

    private List<Integer> numbers = new ArrayList<>();
    private List<Bingo> bingos = new ArrayList<>();
    private Iterator<Integer> numberIterator;

    public BingoGame(List<String> input) {
        var iterator = input.iterator();
//        String[] split = iterator.next().split(",");
        numbers = Arrays.stream(iterator.next().split(",")).filter(s -> !s.equals("")).map(Integer::parseInt).collect(Collectors.toList());

        bingos = createBingoCards(iterator);
        numberIterator = numbers.iterator();
    }

    private List<Bingo> createBingoCards(Iterator<String> iterator){
        List<Bingo> bingos = new ArrayList<>();
        Bingo currentBingo = null;

        while (iterator.hasNext()) {
            var currentLine = iterator.next();
            if (currentLine.isEmpty()) {
                if (currentBingo != null) {
                    bingos.add(currentBingo);
                    currentBingo.prepareColumns();
                    currentBingo = null;
                }
            } else {
                var row = Arrays.stream(currentLine.split(" ")).map(String::trim).filter(s -> !s.equals("")).map(Integer::parseInt).collect(Collectors.toList());
                if (currentBingo == null) {
                    currentBingo = new Bingo();
                }
                currentBingo.addRow(row);
            }
        }
        if (currentBingo != null) {
            bingos.add(currentBingo);
            currentBingo.prepareColumns();
        }

        return bingos;
    }

    public void solve(int number) {
        var bingoIterator = bingos.iterator();
        while (bingoIterator.hasNext()) {
            var currentBingo = bingoIterator.next();
            currentBingo.solveNumber(number);
        }
    }

    public int solveWithNextNumber() {
        int currentNumber;
        if (numberIterator.hasNext()) {
            currentNumber = numberIterator.next();
            solve(currentNumber);
        }else{
            throw new RuntimeException("no available number");
        }
        return currentNumber;
    }

    public void printOutBingos() {
        for (Bingo bingo : bingos) {
            bingo.printOut();
            System.out.println();
        }
    }

    public boolean isAtLeastOneBingoSolved() {
        return bingos.stream().filter(Bingo::isSolved).count() != 0;
    }

    public boolean isEveryBingoSolved(){
        return bingos.stream().filter(b -> !b.isSolved()).count()==0;
    }

    public List<Bingo> getSolvedBingos() {
        List<Bingo> bingos = new ArrayList<>();
        for (Bingo bingo : this.bingos) {
            if (bingo.isSolved()) {
                bingos.add(bingo);
            }
        }
        return bingos;
    }

    public List<Bingo> getUnsolvedBingos() {
        List<Bingo> bingos = new ArrayList<>();
        for (Bingo bingo : this.bingos) {
            if (!bingo.isSolved()) {
                bingos.add(bingo);
            }
        }
        return bingos;
    }
}

package de.hegmanns.training.aoc2021.day04;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Integer> numbers = new ArrayList<>();
    private List<Boolean> solved = new ArrayList<>();
    private String[] formatTemplate = {"%5d", "(%3d)"};

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Boolean> getSolved() {
        return solved;
    }

    public void setSolved(List<Boolean> solved) {
        this.solved = solved;
    }

    public String[] getFormatTemplate() {
        return formatTemplate;
    }

    public void setFormatTemplate(String[] formatTemplate) {
        this.formatTemplate = formatTemplate;
    }

    public void printOut() {
        var numberIterator = numbers.iterator();
        var solvedIterator = solved.iterator();


        while (numberIterator.hasNext()) {
            var solved = solvedIterator.next();
            var number = numberIterator.next();


            System.out.print(String.format(formatTemplate[solved ? 1 : 0], number));
        }
        System.out.println();
    }


    public void setLine(List<Integer> lineElements){
        var iterator = lineElements.iterator();
        while (iterator.hasNext()) {
            var currentNumber = iterator.next();
            numbers.add(currentNumber);
            solved.add(false);
        }
    }

    public void markAsSolved(int number){
        var numberIterator = numbers.iterator();
        var currentIndex = 0;

        while (numberIterator.hasNext()) {
            var currentNumber = numberIterator.next();
            if (currentNumber == number) {
                solved.set(currentIndex, true);
            }
            currentIndex++;
        }
    }

    public int getSumSolved(){
        var solvedIterator = solved.iterator();
        var numberIterator = numbers.iterator();
        var sum = 0;
        while (solvedIterator.hasNext()) {
            var next = numberIterator.next();
            if (solvedIterator.next()) {
                sum += next;
            }
        }
        return sum;
    }

    public int getSumUnsolved(){
        var solvedIterator = solved.iterator();
        var numberIterator = numbers.iterator();
        var sum = 0;
        while (solvedIterator.hasNext()) {
            var next = numberIterator.next();
            if (!solvedIterator.next()) {
                sum += next;
            }
        }
        return sum;
    }

    public boolean isSolvedCompleted(){
        return solved.stream().filter(s -> !s).count()==0;
    }
}

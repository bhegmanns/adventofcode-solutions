package de.hegmanns.training.aoc2022.day11;

import java.util.ArrayList;
import java.util.List;

public class Monkey {
    private long countOfInspectedItems = 0;

    private List<Long> items;

    private long divisibleTestNumber;

    private Monkey monkeyForDivisibleTrue;
    private Monkey monkeyForDivisibleFalse;

    private WorryLevelOperation worryLevelOperation;
    private long worryLevelOperationOperand;

    public List<Long> getItems() {
        return items;
    }

    public List<Long> inspectAllItems() {
        List<Long> copy = new ArrayList<>(items);
        countOfInspectedItems += copy.size();
        items.clear();
        return copy;
    }

    public void setItems(List<Long> items) {
        this.items = items;
    }

    public long getDivisibleTestNumber() {
        return divisibleTestNumber;
    }

    public void setDivisibleTestNumber(long divisibleTestNumber) {
        this.divisibleTestNumber = divisibleTestNumber;
    }

    public Monkey getMonkeyForDivisibleTrue() {
        return monkeyForDivisibleTrue;
    }

    public void setMonkeyForDivisibleTrue(Monkey monkeyForDivisibleTrue) {
        this.monkeyForDivisibleTrue = monkeyForDivisibleTrue;
    }

    public Monkey getMonkeyForDivisibleFalse() {
        return monkeyForDivisibleFalse;
    }

    public void setMonkeyForDivisibleFalse(Monkey monkeyForDivisibleFalse) {
        this.monkeyForDivisibleFalse = monkeyForDivisibleFalse;
    }

    public WorryLevelOperation getWorryLevelOperation() {
        return worryLevelOperation;
    }

    public void setWorryLevelOperation(WorryLevelOperation worryLevelOperation) {
        this.worryLevelOperation = worryLevelOperation;
    }

    public long getWorryLevelOperationOperand() {
        return worryLevelOperationOperand;
    }

    public void setWorryLevelOperationOperand(long worryLevelOperationOperand) {
        this.worryLevelOperationOperand = worryLevelOperationOperand;
    }

    public long proceedWorryOperation(long operand) {
        return this.worryLevelOperation.proceedWorryOperation(operand, worryLevelOperationOperand);
    }

    public void itemForWorry(long worryOperand){
        if (worryOperand % this.divisibleTestNumber == 0) {
            monkeyForDivisibleTrue.getItems().add(worryOperand);
        } else {
            monkeyForDivisibleFalse.getItems().add(worryOperand);
        }
    }

    public long getCountOfInspectedItems() {
        return countOfInspectedItems;
    }
}

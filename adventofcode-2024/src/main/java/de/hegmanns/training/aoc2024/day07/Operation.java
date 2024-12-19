package de.hegmanns.training.aoc2024.day07;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Operation {
    private long expectedResult;
    private List<Long> operands;


    public static Operation parse(String operationString) {
        String[] split = operationString.split(": | ");
        if (split.length == 0) {
            throw new RuntimeException("invalid operation string: " + operationString);
        }
        Operation operation = new Operation();
        operation.expectedResult = Long.parseLong(split[0]);
        operation.operands = new ArrayList<>();
        for (int i = 1; i < split.length; i++) {
            operation.operands.add(Long.parseLong(split[i]));
        }
        return operation;
    }


    public boolean atLeastOneOperatorExistsForOperandAndResult() {

        long countOfCombinations = calculateCombinations();
        Operator[] operators = {Operator.PLUS, Operator.TIMES};


        for (long currentCombination = 0 ; currentCombination < countOfCombinations ; currentCombination++) {
            Long result = null;
            long combination = currentCombination;
            for (long operand : operands) {

                if (result == null) {
                    result = operand;
                } else {
                    // find the correct operator

                    Operator operator = operators[(int) (combination % 2)];
                    result = operators[(int) (combination % 2)].calculate(result, operand);
                    combination /= 2;
                }
            }
            if (expectedResult == result) {
                return true;
            }
        }

        return false;
    }


    private long calculateCombinations() {
        long result = 1;
        for (long operand : operands) {
            result *= 2;
        }
        return result;
    }
}

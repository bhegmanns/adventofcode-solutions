package de.hegmanns.training.aoc2022.day21;

public class MonkeyFactory {
/*
    root: pppw + sjmn
    dbpl: 5
    cczh: sllz + lgvd
    zczc: 2
    ptdq: humn - dvpt
    dvpt: 3
    lfqf: 4
    humn: 5
    ljgn: 2
    sjmn: drzm * dbpl
    sllz: 4
    pppw: cczh / lfqf
    lgvd: ljgn * ptdq
    drzm: hmdt - zczc
    hmdt: 32

 */
    public static Monkey parseToMonkey(String line, Monkeys monkeyCollection) {
        String[] split = line.split(":");
        String firstMonkeyName = split[0].substring(0, split[0].length());
        Monkey firstMonkey = monkeyCollection.getMonkeyByName(firstMonkeyName);
        String operationPart = split[1].trim();
        String[] operationParts = operationPart.split(" ");
        if (operationParts.length == 1) {
            // only equals
            // a check if parsable to long
            try {
                Long realNumber = Long.parseLong(operationParts[0].trim());
                firstMonkey.setValue(realNumber);
                MonkeyExpression monkeyExpression = new MonkeyExpression(firstMonkey, new MonkeyOperation(MonkeyOperationSymbol.EQUAL));
                firstMonkey.setMonkeyExpression(monkeyExpression);
                return firstMonkey;
            } catch (NumberFormatException e) {
                throw new RuntimeException("Uups, there is a pure equal expression with only other monkey ... :(");
            }
        } else {
            // cczh: sllz + lgvd
            // * -
            // (0) (1) (2)
            // firstOperator operatorSymbol thirdOperator
            Monkey firstOperator = monkeyCollection.getMonkeyByName(operationParts[0].trim());
            Monkey secondOperator = monkeyCollection.getMonkeyByName(operationParts[2].trim());
            String operatorSymbol = operationParts[1].trim();
            MonkeyOperationSymbol monkeyOperationSymbol = MonkeyOperationSymbol.parseSymbol(operatorSymbol);

            MonkeyExpression monkeyExpression = new MonkeyExpression(firstOperator, new MonkeyOperation(monkeyOperationSymbol, secondOperator));
            firstMonkey.setMonkeyExpression(monkeyExpression);
            monkeyExpression.setExpressionFor(firstMonkey);
            monkeyCollection.addOpenMonkeyExpression(monkeyExpression);
            return firstMonkey;
        }
    }
}

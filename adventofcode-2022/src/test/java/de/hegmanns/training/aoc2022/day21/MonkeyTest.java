package de.hegmanns.training.aoc2022.day21;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class MonkeyTest {

    @Test
    void resolvingMonkey() {
        Monkey currentMonkey = new Monkey("abc");
        Monkey secondOperator = new Monkey("second");
        Monkey firstOperator = new Monkey("first");
        MonkeyExpression expression = new MonkeyExpression(firstOperator, new MonkeyOperation(MonkeyOperationSymbol.PLUS, secondOperator));
        expression.setExpressionFor(currentMonkey);
        currentMonkey.setMonkeyExpression(expression);


        secondOperator.signalForSetValue(currentMonkey);
        firstOperator.signalForSetValue(currentMonkey);


        secondOperator.setValue(1L);
        MatcherAssert.assertThat(currentMonkey.getValue().isPresent(), Matchers.is(false));

        firstOperator.setValue(100L);
        MatcherAssert.assertThat(currentMonkey.getValue().isPresent(), Matchers.is(true));
        MatcherAssert.assertThat(currentMonkey.getValue().get(), Matchers.is(101L));
    }

    @Test
    void reverseResolvingMonkeyByGatheringFirstOperand() {
        Monkey currentMonkey = new Monkey("abc");
        Monkey secondOperator = new Monkey("second");
        Monkey firstOperator = new Monkey("first");
        MonkeyExpression expression = new MonkeyExpression(firstOperator, new MonkeyOperation(MonkeyOperationSymbol.PLUS, secondOperator));
        expression.setExpressionFor(currentMonkey);
        currentMonkey.setMonkeyExpression(expression);

        currentMonkey.setValue(100L);
        secondOperator.setValue(75L);

        currentMonkey.getMonkeyExpression().resolve();

        MatcherAssert.assertThat(firstOperator.getValue().isPresent(), Matchers.is(true));
        MatcherAssert.assertThat(firstOperator.getValue().get(), Matchers.is(25L));
    }

    @Test
    void reverseResolvingMonkeyByGatheringSecondOperand() {

    }
}

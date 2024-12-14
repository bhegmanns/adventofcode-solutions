package de.hegmanns.training.aoc2022.day21;

import java.util.Optional;

public class MonkeyOperation {

    private MonkeyOperationSymbol monkeyOperationSymbol;
    private Monkey monkey;

    public MonkeyOperation(MonkeyOperationSymbol monkeyOperationSymbol, Monkey monkey) {
        this.monkeyOperationSymbol = monkeyOperationSymbol;
        this.monkey = monkey;
    }

    public MonkeyOperation(MonkeyOperationSymbol monkeyExpression) {
        this.monkeyOperationSymbol = monkeyExpression;
    }

    public Monkey getMonkey() {
        return monkey;
    }

    public Optional<Long> resolve(Monkey monkey) {
        return Optional.ofNullable(this.monkeyOperationSymbol.resolve(monkey.getValue().orElse(null), this.monkey.getValue().orElse(null)));
    }

    public Optional<Long> resolveInverse(Monkey Monkey) {
        return Optional.ofNullable(this.monkeyOperationSymbol.resolveInverse(this.monkey.getValue().get(), monkey.getValue().get()));
    }
}

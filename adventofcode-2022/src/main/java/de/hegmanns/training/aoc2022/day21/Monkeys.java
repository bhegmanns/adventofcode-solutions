package de.hegmanns.training.aoc2022.day21;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Monkeys {

    private Set<Monkey> monkeys;

    private Set<MonkeyExpression> openExpressions;

    public Monkeys() {
        monkeys = new HashSet<>();
        openExpressions = new HashSet<>();
    }

    public void addOpenMonkeyExpression(MonkeyExpression monkeyExpression) {
        openExpressions.add(monkeyExpression);
    }

    public Monkey getMonkeyByName(String monkeyName) {
        Monkey exampleMonkey = new Monkey(monkeyName);
        if (!monkeys.contains(exampleMonkey)) {
            monkeys.add(exampleMonkey);
            return exampleMonkey;
        }

        return monkeys.stream().filter(m -> m.equals(exampleMonkey)).findFirst().orElseThrow();
    }

    public void startSolution() {
        for (Monkey monkey : this.monkeys) {
            Collection<Monkey> unresolvedMonkeys = monkey.getMonkeyExpression().getUnresolvedMonkeys();
            unresolvedMonkeys.add(monkey);

            for (Monkey m : unresolvedMonkeys) {
                m.signalForSetValue(monkey);
            }
        }

        for (Monkey monkey : this.monkeys) {
            monkey.getMonkeyExpression().resolve();
        }
    }

    public Set<Monkey> getMonkeys() {
        return monkeys;
    }
}

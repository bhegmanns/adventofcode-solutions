package de.hegmanns.training.aoc2022.day21;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class MonkeyExpression {

    private Monkey expressionFor;

    private Monkey monkey;

    private MonkeyOperation monkeyOperation;

    public void setExpressionFor(Monkey expressionFor) {
        this.expressionFor = expressionFor;
    }

    public MonkeyExpression(Monkey monkey, MonkeyOperation monkeyOperation) {
        this.monkey = monkey;
        this.monkeyOperation = monkeyOperation;
    }

    public Collection<Monkey> getUnresolvedMonkeys() {
        Collection<Monkey> solution = new ArrayList<>();

        if (!monkey.getValue().isPresent()) {
            solution.add(monkey);
        }

        if (monkeyOperation.getMonkey()!=null && !monkeyOperation.getMonkey().getValue().isPresent()) {
            solution.add(monkeyOperation.getMonkey());
        }

        return solution;
    }

    public boolean resolve() {

        Collection<Monkey> unresolvedMonkeys = getUnresolvedMonkeys();
        if (!unresolvedMonkeys.isEmpty()) {
            if (this.expressionFor.getValue().isPresent() && unresolvedMonkeys.size()==1) {
                // result is given and one of the operands, so we can make a reverse operation :)
                Optional<Long> aLong = this.monkeyOperation.resolveInverse(this.monkey);
                ((Monkey)(unresolvedMonkeys.toArray()[0])).setValue(aLong.get());
            } else {
                // nothing to do :(
            }
            return false;
        }

        Optional<Long> resolve = this.monkeyOperation.resolve(this.monkey);
        if (resolve.isPresent()) {
            this.expressionFor.setValue(resolve.get());
        }

        return resolve.isPresent();
    }
}

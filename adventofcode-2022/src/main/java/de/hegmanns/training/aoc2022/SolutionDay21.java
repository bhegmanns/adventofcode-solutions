package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2022.day21.Monkey;
import de.hegmanns.training.aoc2022.day21.MonkeyFactory;
import de.hegmanns.training.aoc2022.day21.Monkeys;

import java.util.List;

public class SolutionDay21 implements AoCSolution<Long, Long> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay21.class, "day21.txt");

        SolutionDay21 solution = new SolutionDay21();

        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: " + solution.solvePart2(inputAsList));
    }


    @Override
    public Long solvePart1(List<String> input) {
        Monkeys monkeyCollection = new Monkeys();
        input.forEach(l -> MonkeyFactory.parseToMonkey(l, monkeyCollection));


        while (monkeyCollection.getMonkeys().stream().filter(m -> m.getValue().isEmpty()).findFirst().isPresent()) {
            for (Monkey monkey : monkeyCollection.getMonkeys()) {
                if (monkey.getValue().isPresent()) {
                    continue;
                }

                monkey.getMonkeyExpression().resolve();
            }
        }

        Monkey rootMonkey = monkeyCollection.getMonkeyByName("root");

        return rootMonkey.getValue().get();
    }

    @Override
    public Long solvePart2(List<String> input) {
        Monkeys monkeyCollection = new Monkeys();
        input.stream().filter(s -> !s.startsWith("humn")).forEach(l -> MonkeyFactory.parseToMonkey(l, monkeyCollection));

        Monkey rootMonkey = monkeyCollection.getMonkeyByName("root");


        while (rootMonkey.getMonkeyExpression().getUnresolvedMonkeys().size()!=1) {
            for (Monkey monkey : monkeyCollection.getMonkeys()) {
                if (monkey.getValue().isPresent()) {
                    continue;
                }

                monkey.getMonkeyExpression().resolve();
            }
        }



        return rootMonkey.getValue().get();
    }

    @Override
    public Long getSolution1() {
        return null;
    }

    @Override
    public Long getSolution2() {
        return null;
    }
}

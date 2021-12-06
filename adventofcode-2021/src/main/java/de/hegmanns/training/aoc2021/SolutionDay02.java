package de.hegmanns.training.aoc2021;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;

import java.util.List;

public class SolutionDay02 implements AoCSolution<Integer, Integer> {

    public static void main(String[] args) {
        List<String> input = AoCFileReader.getInputAsList(SolutionDay02.class, "day02.txt");
        SolutionDay02 solution = new SolutionDay02();
        System.out.println("part1 >>> " + solution.solvePart1(input));
        System.out.println("part2 >>> " + solution.solvePart2(input));
    }

    @Override
    public Integer solvePart1(List<String> input) {
        var currentY = 0;
        var currentX = 0;
        var iterator = input.iterator();


        while (iterator.hasNext()) {
            var deltaX = 0;
            var deltaY = 0;
            var currentCommand = iterator.next();
            var split = currentCommand.split(" ");
            var command = split[0];
            var delta = Integer.parseInt(split[1]);

            switch (command) {
                case "forward":
                    deltaX = delta;break;
                case "up":
                    deltaY = -delta;break;
                case "down":
                    deltaY = delta;break;
                default:
                    System.out.println("PROBLEM!!!" + currentCommand);
            }
            currentX += deltaX;
            currentY += deltaY;
            if (currentY < 0){
                System.out.println("PROBLEM, currentY ist jetzt negativ ... :(" + currentCommand + "(" + currentY + ")");
            }

        }

        return currentX * currentY;
    }

    @Override
    public Integer solvePart2(List<String> input) {

        var currentY = 0;
        var currentX = 0;
        var aim = 0;

        var iterator = input.iterator();
        while (iterator.hasNext()) {
            var deltaX = 0;
            var deltaY = 0;
            var currentCommand = iterator.next();
            var split = currentCommand.split(" ");
            var command = split[0];
            var delta = Integer.parseInt(split[1]);
            switch(command){
                case "forward":
                    deltaX = delta;
                    deltaY = aim * delta;
                    break;
                case "up":
                    aim -= delta;
                    break;
                case "down":
                    aim += delta;
                    break;
                default:
                    System.out.println("POBLEM!!!" + currentCommand);
            }
            currentX += deltaX;
            currentY += deltaY;
//            println("command '" + currentCommand + "': (" + currentX + " / " + currentY + ")")
            if (currentY < 0){
                System.out.println("PROBLEM, currentY ist jetzt negativ ... :(" + currentCommand + "(" + currentY + ")");
            }

        }

        return currentX * currentY;
    }
}

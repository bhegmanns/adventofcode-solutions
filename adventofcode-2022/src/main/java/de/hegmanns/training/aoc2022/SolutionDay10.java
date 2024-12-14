package de.hegmanns.training.aoc2022;

import de.hegmanns.training.aoc.common.AoCFileReader;
import de.hegmanns.training.aoc.common.AoCSolution;
import de.hegmanns.training.aoc2022.day10.*;

import java.util.ArrayList;
import java.util.List;

public class SolutionDay10 implements AoCSolution<Long, List<String>> {

    public static void main(String[] args) {
        List<String> inputAsList = AoCFileReader.getInputAsList(SolutionDay10.class, "day10.txt");

        SolutionDay10 solution = new SolutionDay10();
        System.out.println("Part 1: " + solution.solvePart1(inputAsList));
        System.out.println("=====");
        System.out.println("Part 2: ");
        System.out.println("<SCREEN>");
        solution.solvePart2(inputAsList).stream().forEach(System.out::println);
        System.out.println("</SCREEN>");
    }


    @Override
    public Long solvePart1(List<String> input) {

        List<Command> commands = new ArrayList<>();
        for (String line : input) {
            String[] split = line.trim().split(" ");
            if (split.length == 1) {
                commands.add(new NoopCommand());
            }else{
                commands.add(new StepXCommand(Integer.parseInt(split[1].trim())));
            }
        }
        Register register = new Register(commands);
        RegisterValueGatherer gatherer = new RegisterValueGatherer();
        register.setValueGatherer(gatherer);
        register.proceedCommands();

        List<XRegisterValue> xRegisterValues = gatherer.getxRegisterValues();

        return gatherer.getxRegisterValues().stream().map(v -> v.getCyclePhase() * v.getxValue()).mapToLong(Long::longValue).sum();

    }

    @Override
    public List<String> solvePart2(List<String> input) {
        List<Command> commands = new ArrayList<>();
        for (String line : input) {
            String[] split = line.trim().split(" ");
            if (split.length == 1) {
                commands.add(new NoopCommand());
            }else{
                commands.add(new StepXCommand(Integer.parseInt(split[1].trim())));
            }
        }

        Crt crt = new Crt(commands);



        return crt.buildCrtScreen();
    }

    @Override
    public Long getSolution1() {
        return null;
    }

    @Override
    public List<String> getSolution2() {
        return null;
    }
}

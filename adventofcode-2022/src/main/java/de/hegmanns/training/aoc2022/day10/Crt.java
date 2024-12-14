package de.hegmanns.training.aoc2022.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Crt {

    private XRegisterValue registerValue = new XRegisterValue(0, 0);

    private List<String> resultLines;

    private List<Command> commands;

    public Crt(List<Command> commands) {
        this.commands = commands;
    }

    public List<String> buildCrtScreen() {
        resultLines = new ArrayList<>();

        String currentLine = "";
        for (Command command : commands) {
            XRegisterValue proceededValue = command.proceed(registerValue);

            long cycles = proceededValue.getCyclePhase() - registerValue.getCyclePhase();
            for (int i = 0; i < cycles; i++) {
                currentLine += calculateNextPixels(registerValue.getCyclePhase()  + i);
                if (currentLine.length() == 40) {
                    resultLines.add(currentLine);
                    currentLine = "";
                }
            }
            registerValue = proceededValue;

        }
        return resultLines;
    }

    private String calculateNextPixels(long cycle) {
        long xRegisterPosition = registerValue.getxValue();

        if (cycle%40 >= xRegisterPosition && cycle%40 < xRegisterPosition + 3) {
            return "#";
        } else {
            return " ";
        }
    }
}

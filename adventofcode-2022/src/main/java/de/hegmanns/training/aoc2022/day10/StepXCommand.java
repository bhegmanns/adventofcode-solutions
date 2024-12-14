package de.hegmanns.training.aoc2022.day10;

public class StepXCommand implements Command{

    private int step;

    public StepXCommand(int step) {
        this.step = step;
    }

    @Override
    public XRegisterValue proceed(XRegisterValue registerValue) {
        return new XRegisterValue(registerValue.getxValue() + step, registerValue.getCyclePhase()+2);
    }

    @Override
    public String toString() {
        return "StepXCommand{" +
                "step=" + step +
                '}';
    }
}

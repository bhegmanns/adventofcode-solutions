package de.hegmanns.training.aoc2022.day10;

public class NoopCommand implements Command{
    @Override
    public XRegisterValue proceed(XRegisterValue registerValue) {
        return new XRegisterValue(registerValue.getxValue(), registerValue.getCyclePhase()+1);
    }
}

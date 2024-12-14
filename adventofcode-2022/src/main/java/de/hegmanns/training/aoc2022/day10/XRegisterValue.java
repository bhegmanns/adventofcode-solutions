package de.hegmanns.training.aoc2022.day10;

public class XRegisterValue {

    private long xValue;
    private long cyclePhase;

    public XRegisterValue(long xValue, long cyclePhase) {
        this.xValue = xValue;
        this.cyclePhase = cyclePhase;
    }

    public long getxValue() {
        return xValue;
    }

    public long getCyclePhase() {
        return cyclePhase;
    }

    public long getCalculatedSignalStrength(){
        return xValue * cyclePhase;
    }

    @Override
    public String toString() {
        return "XRegisterValue{" +
                "xValue=" + xValue +
                ", cyclePhase=" + cyclePhase +
                '}';
    }
}

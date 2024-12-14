package de.hegmanns.training.aoc2022.day10;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RegisterValueGatherer {

    private List<XRegisterValue> xRegisterValues = new ArrayList<>();

    private long currentInterestedCircle = -20;

    public RegisterValueGatherer() {

    }

    public Optional<Long> getInterestedCircle(){
        currentInterestedCircle+=40;
        if (currentInterestedCircle > 220) {
            return Optional.empty();
        } else {
            return Optional.of(currentInterestedCircle);
        }
    }

    public List<XRegisterValue> getxRegisterValues() {
        return xRegisterValues;
    }

    public void info(Register register, XRegisterValue registerValue) {
        xRegisterValues.add(new XRegisterValue(registerValue.getxValue(), registerValue.getCyclePhase()));
    }
}

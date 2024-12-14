package de.hegmanns.training.aoc2022.day10;

import java.util.List;
import java.util.Optional;

public class Register {
    XRegisterValue xRegisterValue = new XRegisterValue(1, 0);

    private RegisterValueGatherer valueGatherer;

    private List<Command> commands;
    public Register(List<Command> commands){
        this.commands = commands;
    }

    public void setValueGatherer(RegisterValueGatherer valueGatherer) {
        this.valueGatherer = valueGatherer;
    }

    public void proceedCommands() {

        Optional<Long> currentInterestedCircle = valueGatherer.getInterestedCircle();
        for (Command command : commands) {

            XRegisterValue proceededResult = command.proceed(this.xRegisterValue);
            if (proceededResult.getCyclePhase() >= currentInterestedCircle.orElse(Long.MAX_VALUE)) {
                this.valueGatherer.info(this, new XRegisterValue(this.xRegisterValue.getxValue(), currentInterestedCircle.get()));
                currentInterestedCircle = valueGatherer.getInterestedCircle();
                if (!currentInterestedCircle.isPresent()) {
                    break;
                }
            }
            this.xRegisterValue = proceededResult;
        }
    }

}

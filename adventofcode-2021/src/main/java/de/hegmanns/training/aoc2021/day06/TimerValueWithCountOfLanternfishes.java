package de.hegmanns.training.aoc2021.day06;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class TimerValueWithCountOfLanternfishes {
    private int timerValue;
    private long countOfLanternfishes;

    public void incrementCountOfLanternfishes() {
        countOfLanternfishes++;
    }

    public int getTimerValue() {
        return timerValue;
    }

    public void setTimerValue(int timerValue) {
        this.timerValue = timerValue;
    }

    public long getCountOfLanternfishes() {
        return countOfLanternfishes;
    }

    public void setCountOfLanternfishes(long countOfLanternfishes) {
        this.countOfLanternfishes = countOfLanternfishes;
    }

    public void addToCountOfLanternfishes(long count) {
        this.countOfLanternfishes += count;
    }

    public TimerValueWithCountOfLanternfishes(int timerValue, long countOfLanternfishes) {
        this.timerValue = timerValue;
        this.countOfLanternfishes = countOfLanternfishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TimerValueWithCountOfLanternfishes that = (TimerValueWithCountOfLanternfishes) o;

        return new EqualsBuilder().append(timerValue, that.timerValue).append(countOfLanternfishes, that.countOfLanternfishes).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(timerValue).append(countOfLanternfishes).toHashCode();
    }
}

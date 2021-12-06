package de.hegmanns.training.aoc2021.day06;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class TimerValueWithCountOfLaternfishes {
    private int timerValue;
    private long countOfLaternfishes;

    public void incrementCountOfLaternfishes() {
        countOfLaternfishes++;
    }

    public int getTimerValue() {
        return timerValue;
    }

    public void setTimerValue(int timerValue) {
        this.timerValue = timerValue;
    }

    public long getCountOfLaternfishes() {
        return countOfLaternfishes;
    }

    public void setCountOfLaternfishes(long countOfLaternfishes) {
        this.countOfLaternfishes = countOfLaternfishes;
    }

    public void addToCountOfLaternfishes(long count) {
        this.countOfLaternfishes += count;
    }

    public TimerValueWithCountOfLaternfishes(int timerValue, long countOfLaternfishes) {
        this.timerValue = timerValue;
        this.countOfLaternfishes = countOfLaternfishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TimerValueWithCountOfLaternfishes that = (TimerValueWithCountOfLaternfishes) o;

        return new EqualsBuilder().append(timerValue, that.timerValue).append(countOfLaternfishes, that.countOfLaternfishes).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(timerValue).append(countOfLaternfishes).toHashCode();
    }
}

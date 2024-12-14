package de.hegmanns.training.aoc2023.day12;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ConditionField {

    private String field;
    List<Integer> length;

    public ConditionField(String field, List<Integer> length) {
        this.field = field;
        this.length = length;
    }

    /**
     * Returns the count of tries for a given field.
     *
     * @return the count of tries
     */
    public long getCountTries() {
        return (long)Math.pow(2, field.chars().filter(i -> i=='?').count());
    }
}

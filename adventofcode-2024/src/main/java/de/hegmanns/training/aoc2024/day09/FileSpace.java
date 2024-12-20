package de.hegmanns.training.aoc2024.day09;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileSpace {

    private int startIndex;
    private int endIndexInclusive;

    public static FileSpace of(int startIndex, int endIndexInclusive) {
        return new FileSpace(startIndex, endIndexInclusive);
    }

    public int getWidth() {
        return endIndexInclusive - startIndex + 1;
    }

    public void reduceFromStart(int amount) {
        startIndex += amount;
    }
}

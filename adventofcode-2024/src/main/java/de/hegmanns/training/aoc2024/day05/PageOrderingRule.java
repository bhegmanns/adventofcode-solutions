package de.hegmanns.training.aoc2024.day05;


import lombok.*;

@Data
@AllArgsConstructor
public class PageOrderingRule {

    private int before;
    private int after;

    public PageOrderingRule(String before, String after) {
        this(Integer.parseInt(before), Integer.parseInt(after));
    }
}

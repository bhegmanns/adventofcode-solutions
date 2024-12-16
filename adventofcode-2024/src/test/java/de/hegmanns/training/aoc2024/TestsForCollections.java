package de.hegmanns.training.aoc2024;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class TestsForCollections {

    @Test
    void linkedListCanBeInserted() {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");

        list.add(0, "b");
        list.add(1, "c");
        System.out.println(list);
    }
}

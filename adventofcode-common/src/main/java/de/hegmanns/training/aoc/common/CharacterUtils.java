package de.hegmanns.training.aoc.common;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class CharacterUtils {

    public static String toString(Collection<Character> chars) {
        return chars.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static List<Character> toList(String string) {
        return string.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }
}

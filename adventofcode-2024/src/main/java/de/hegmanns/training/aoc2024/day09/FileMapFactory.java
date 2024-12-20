package de.hegmanns.training.aoc2024.day09;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class FileMapFactory {

    public static FileMap createFileMapFromMapString(String mapString) {
        List<Integer> map = new ArrayList<>(mapString.length());
        List<Pair<Integer, Integer>> locationMap = new ArrayList<>();
        int fileIndex = 0;

        for (int i = 0; i < mapString.length(); i++) {
            if (i % 2 == 0) {
                for (int a = 0; a < Integer.parseInt("" + mapString.charAt(i)); a++) {
                    map.add(fileIndex);
                }
                fileIndex++;
            } else {
                for (int a = 0; a < Integer.parseInt("" + mapString.charAt(i)); a++) {
                    map.add(null);
                }

                locationMap.add(Pair.of(null, Integer.parseInt("" + mapString.charAt(i))));
            }

        }



        return FileMap.builder().map(map).build();
    }
}

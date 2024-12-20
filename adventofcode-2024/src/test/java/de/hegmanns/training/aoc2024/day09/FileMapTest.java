package de.hegmanns.training.aoc2024.day09;

import de.hegmanns.training.aoc2024.SolutionDay09Test;
import org.apache.commons.lang3.tuple.Pair;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FileMapTest {

    @Test
    void fileMapFactoryWithNull() {
        Pair<Object, Integer> objectIntegerPair = Pair.of(null, 1);

    }

    @Nested
    class SpacesTest {

        @Test
        void calculatesMapOfFreeSpacesForExampleInput() {
            String line = SolutionDay09Test.getExampleInputAsList().get(0);
            FileMap fileMap = FileMapFactory.createFileMapFromMapString(line);
            fileMap.createMapOfFreeSpaces();
            List<FileSpace> mapOfFreeSpaces = fileMap.getMapOfFreeSpaces();

            Assertions.assertThat(mapOfFreeSpaces).hasSize(8);
        }

        @Test
        void calculatesMapOfFreeSpacesForExampleInputAfterMovement() {
            String line = SolutionDay09Test.getExampleInputAsList().get(0);
            FileMap fileMap = FileMapFactory.createFileMapFromMapString(line);
            fileMap.optimizeSpacesWithFullMatch();
            List<FileSpace> mapOfFreeSpaces = fileMap.getMapOfFreeSpaces();

            Assertions.assertThat(mapOfFreeSpaces).hasSize(8);
            Assertions.assertThat(fileMap.getMap()).containsExactly(
                    0, 0, 9, 9, 2, 1, 1, 1, 7, 7, 7, null, 4, 4, null, 3, 3, 3, null, null, null, null, 5, 5, 5, 5, null, 6, 6, 6, 6, null, null, null, null, null, 8, 8, 8, 8, null, null);
        }
    }

    @Nested
    class CheckSumTest {

        @Test
        void calculatesCheckSum() {
            long checksum = FileMap.builder().map(List.of(0,0,9,9,8,1,1,1,8,8,8,2,7,7,7,3,3,3,6,4,4,6,5,5,5,5,6,6)).build().calculateCheckSum();
            Assertions.assertThat(checksum).isEqualTo(1928L);
        }

        @Test
        void calculatesCheckSumWithSomeNullValuesAtTheEnd() {
            List<Integer> map = new ArrayList<>(List.of(0, 0, 9, 9, 8, 1, 1, 1, 8, 8, 8, 2, 7, 7, 7, 3, 3, 3, 6, 4, 4, 6, 5, 5, 5, 5, 6, 6));
            map.add(null);
            map.add(null);
            long checksum = FileMap.builder().map(map).build().calculateCheckSum();
            Assertions.assertThat(checksum).isEqualTo(1928L);
        }

        @Test
        void calculatesCheckSumWithSomeNullValuesInTheMiddle() {
            List<Integer> map = new ArrayList<>(List.of(0, 0, 9, 9, 8, 1, 1, 1, 8, 8, 8, 2, 7, 7, 7, 3, 3, 3, 6, 4, 4, 6, 5, 5, 5, 5, 6, 6));
            map.set(2, null);
            map.set(4, null);
            long checksum = FileMap.builder().map(map).build().calculateCheckSum();
            Assertions.assertThat(checksum).isEqualTo(1878L);
        }

        @Test
        void calculateCheckSumWithSomeNullValuesInPositions() {
            String mapAsString = "00992111777.44.333....5555.6666.....8888..";
            List<Integer> map = new ArrayList<>();
            for (int i = 0; i < mapAsString.length(); i++) {
                if (mapAsString.charAt(i) != '.') {
                    map.add(Integer.parseInt("" + mapAsString.charAt(i)));
                } else {
                    map.add(null);
                }
            }
            FileMap fileMap = FileMap.builder().map(map).build();
            Assertions.assertThat(fileMap.calculateCheckSum()).isEqualTo(2858L);
        }
    }
}

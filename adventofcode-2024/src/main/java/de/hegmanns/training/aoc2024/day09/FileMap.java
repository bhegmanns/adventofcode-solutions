package de.hegmanns.training.aoc2024.day09;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class FileMap {
    private List<Integer> map;
    private List<FileSpace> mapOfFreeSpaces;

    public long calculateCheckSum() {
        long checksum = 0L;
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i) == null) {
                continue;
            }
            checksum += map.get(i)*i;
        }
        return checksum;
    }

    private int getLastRelevantIndex(int baseIndex) {
        int lastRelevantIndex = baseIndex;
        while (map.get(lastRelevantIndex) == null) {
            lastRelevantIndex--;
        }
        return lastRelevantIndex;
    }

    public void optimizeSpaces() {

        int lastRelevantIndex = getLastRelevantIndex(map.size()-1);

        int indexOfNextNull = map.indexOf(null);
        while(indexOfNextNull<lastRelevantIndex) {
            map.set(indexOfNextNull, map.get(lastRelevantIndex));
            map.set(lastRelevantIndex, null);
            lastRelevantIndex = getLastRelevantIndex(lastRelevantIndex);
            indexOfNextNull = map.subList(indexOfNextNull+1, map.size()).indexOf(null)+indexOfNextNull+1;
        }
    }

    void createMapOfFreeSpaces() {
        mapOfFreeSpaces = new java.util.ArrayList<>();
        Integer firstIndex = null;
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i) == null) {
                if (firstIndex == null) {
                    firstIndex = i;
                }
            } else {
                if (firstIndex != null) {
                    mapOfFreeSpaces.add(FileSpace.of(firstIndex, i-1));
                    firstIndex = null;
                }
            }
        }
    }

    private FileSpace getFirstFreeSpace(int expectedWidth) {
        return mapOfFreeSpaces.stream()
                .filter(p -> p.getWidth() >= expectedWidth)
                .findFirst().orElse(null);
    }

    public void optimizeSpacesWithFullMatch() {
        createMapOfFreeSpaces();
        int lastRelevantIndex = getLastRelevantIndex(map.size() - 1);
        int currentFileId = map.get(lastRelevantIndex);

        for (int fileId = currentFileId; fileId >=0; fileId--) {
            int firstIndexOfFileId = map.indexOf(fileId);
            int lastIndexOfFileId = map.lastIndexOf(fileId);
            int widthOfFileId = lastIndexOfFileId - firstIndexOfFileId + 1;

            FileSpace firstFreeSpace = getFirstFreeSpace(widthOfFileId);
            if (firstFreeSpace != null && firstFreeSpace.getStartIndex()<firstIndexOfFileId) {
                for (int i = 0; i < widthOfFileId; i++) {
                    map.set(firstFreeSpace.getStartIndex() + i, fileId);
                    map.set(firstIndexOfFileId + i, null);
                }
                firstFreeSpace.reduceFromStart(widthOfFileId);
            }

        }

    }
}

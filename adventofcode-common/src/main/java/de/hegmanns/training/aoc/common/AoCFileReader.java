package de.hegmanns.training.aoc.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AoCFileReader {

    public static List<String> getInputAsList(Class<?> relativeClass, String fileName) {
        String givenFilename = fileName;
        if (!fileName.contains(".")) {
            givenFilename += ".txt";
        }
        InputStream resourceAsStream = relativeClass.getResourceAsStream(givenFilename);
        if (resourceAsStream == null) {
            throw new RuntimeException("file '" + givenFilename + "' could not be opened");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream));
        String currentLine = null;
        List<String> result = new ArrayList<>();
        try {
            while ((currentLine = br.readLine()) != null) {
                result.add(currentLine);
            }
        } catch (IOException e) {

        }
        return result;
    }
}

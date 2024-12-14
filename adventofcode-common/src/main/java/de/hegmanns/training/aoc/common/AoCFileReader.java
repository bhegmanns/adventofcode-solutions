package de.hegmanns.training.aoc.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Special Reader for gathering the input for the task and returns it as a {@link List<String>}.
 * The resource (file) are placed in relative file to the given class.
 */
public class AoCFileReader {

    public AoCFileReader(Class<?> relativeClass, String fileName){

    }

    /**
     *
     * @param relativeClass
     * @param fileName
     * @return
     */
    public static List<String> getInputAsList(Class<?> relativeClass, String fileName) {



        InputStream resourceAsStream = getInputStream(relativeClass, fileName);

        BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream));
        String currentLine = null;
        List<String> result = new ArrayList<>();
        try {
            while ((currentLine = br.readLine()) != null) {
                result.add(currentLine);
            }
        } catch (IOException e) {
            System.out.println("IOException : " + e.getMessage());
        }
        return result;
    }

    public static InputStream getInputStream(Class<?> relativeClass, String fileName){
        String givenFilename = fileName;
        if (!fileName.contains(".")) {
            givenFilename += ".txt";
        }
        InputStream resourceAsStream = relativeClass.getResourceAsStream(givenFilename);
        if (resourceAsStream == null) {
            throw new RuntimeException("file '" + givenFilename + "' could not be opened");
        }
        return resourceAsStream;
    }

}

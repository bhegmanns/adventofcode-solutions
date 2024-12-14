package de.hegmanns.training.aoc2022.day01;

import de.hegmanns.training.aoc.common.AoCFilter;
import de.hegmanns.training.aoc2022.day01.CarriedCalories;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class InputDay01Filter extends AoCFilter<CarriedCalories> {
    private byte[] memory = new byte[1000];
    private int currentIndex = 0;
    /**
     * Creates a {@code FilterInputStream}
     * by assigning the  argument {@code in}
     * to the field {@code this.in} so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or {@code null} if
     *           this instance is to be created without an underlying stream.
     */
    public InputDay01Filter(InputStream in) {
        super(in);
    }

    @Override
    public CarriedCalories getNextInstance() {
        CarriedCalories carriedCalories = CarriedCalories.create();

        try {
            int available = this.available();
            this.read(memory, currentIndex, Math.min(available, memory.length - currentIndex));
            int offset = 0;
            for (int index = 0; index < memory.length; index++) {
                char currentCharacter = (char) memory[index];
                if (currentCharacter == '\r' || currentCharacter == '\n') {
                    String possibleLine = new String(memory, offset, index - offset);
                    if (possibleLine.trim().isEmpty()) {
                        continue;
                    }
                    carriedCalories.addCarriedFood(possibleLine.trim());
                    offset = index;
                }
            }
        }catch(IOException ioException){
            throw new RuntimeException(ioException);
        }

        return carriedCalories;
    }
}

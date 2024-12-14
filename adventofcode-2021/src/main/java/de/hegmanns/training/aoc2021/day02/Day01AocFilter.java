package de.hegmanns.training.aoc2021.day02;

import de.hegmanns.training.aoc.common.AoCFilter;

import java.io.IOException;
import java.io.InputStream;

public class Day01AocFilter extends AoCFilter<MoveCommand> {
    private byte[] memory = new byte[100];
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
    protected Day01AocFilter(InputStream in) {
        super(in);
    }

    @Override
    public MoveCommand getNextInstance() {
        int availableForNextReading = 0;
        try {
            availableForNextReading = this.available();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            this.read(memory, currentIndex, Math.min(memory.length-currentIndex, availableForNextReading));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String commandInString = new String(memory);
        String[] splittedCommandString = commandInString.split("\r\n");
        return null;
    }
}

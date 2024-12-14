package de.hegmanns.training.aoc.common;

import java.io.FilterInputStream;
import java.io.InputStream;

public abstract class AoCFilter<B> extends FilterInputStream {


    protected AoCFilter(Class<?> relativeClass, String fileName){
        this(AoCFileReader.getInputStream(relativeClass, fileName));
    }


    /**
     * Creates a {@code FilterInputStream}
     * by assigning the  argument {@code in}
     * to the field {@code this.in} so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or {@code null} if
     *           this instance is to be created without an underlying stream.
     */
    protected AoCFilter(InputStream in) {
        super(in);
    }

    /**
     *
     * @return the next instance or null if no more instance available
     */
    public abstract B getNextInstance();
}

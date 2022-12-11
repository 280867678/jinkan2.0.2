package org.apache.commons.p056io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: org.apache.commons.io.LineIterator */
/* loaded from: classes4.dex */
public class LineIterator implements Iterator<String> {
    public final BufferedReader bufferedReader;
    public String cachedLine;
    public boolean finished = false;

    public LineIterator(Reader reader) throws IllegalArgumentException {
        if (reader != null) {
            if (reader instanceof BufferedReader) {
                this.bufferedReader = (BufferedReader) reader;
                return;
            } else {
                this.bufferedReader = new BufferedReader(reader);
                return;
            }
        }
        throw new IllegalArgumentException("Reader must not be null");
    }

    public static void closeQuietly(LineIterator lineIterator) {
        if (lineIterator != null) {
            lineIterator.close();
        }
    }

    public void close() {
        this.finished = true;
        IOUtils.closeQuietly((Reader) this.bufferedReader);
        this.cachedLine = null;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        String readLine;
        if (this.cachedLine != null) {
            return true;
        }
        if (this.finished) {
            return false;
        }
        do {
            try {
                readLine = this.bufferedReader.readLine();
                if (readLine == null) {
                    this.finished = true;
                    return false;
                }
            } catch (IOException e) {
                close();
                throw new IllegalStateException(e);
            }
        } while (!isValidLine(readLine));
        this.cachedLine = readLine;
        return true;
    }

    public boolean isValidLine(String str) {
        return true;
    }

    @Override // java.util.Iterator
    public String next() {
        return nextLine();
    }

    public String nextLine() {
        if (hasNext()) {
            String str = this.cachedLine;
            this.cachedLine = null;
            return str;
        }
        throw new NoSuchElementException("No more lines");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Remove unsupported on LineIterator");
    }
}

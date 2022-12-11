package org.apache.commons.p056io.input;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.UnixLineEndingInputStream */
/* loaded from: classes4.dex */
public class UnixLineEndingInputStream extends InputStream {
    public final boolean ensureLineFeedAtEndOfFile;
    public final InputStream target;
    public boolean slashNSeen = false;
    public boolean slashRSeen = false;
    public boolean eofSeen = false;

    public UnixLineEndingInputStream(InputStream inputStream, boolean z) {
        this.target = inputStream;
        this.ensureLineFeedAtEndOfFile = z;
    }

    private int eofGame(boolean z) {
        if (z || !this.ensureLineFeedAtEndOfFile || this.slashNSeen) {
            return -1;
        }
        this.slashNSeen = true;
        return 10;
    }

    private int readWithUpdate() throws IOException {
        int read = this.target.read();
        boolean z = true;
        boolean z2 = read == -1;
        this.eofSeen = z2;
        if (z2) {
            return read;
        }
        this.slashNSeen = read == 10;
        if (read != 13) {
            z = false;
        }
        this.slashRSeen = z;
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.target.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        throw new UnsupportedOperationException("Mark notsupported");
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        boolean z = this.slashRSeen;
        if (this.eofSeen) {
            return eofGame(z);
        }
        int readWithUpdate = readWithUpdate();
        if (this.eofSeen) {
            return eofGame(z);
        }
        if (this.slashRSeen) {
            return 10;
        }
        return (!z || !this.slashNSeen) ? readWithUpdate : read();
    }
}

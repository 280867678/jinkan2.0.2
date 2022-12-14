package org.apache.commons.p056io.output;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: org.apache.commons.io.output.ChunkedOutputStream */
/* loaded from: classes4.dex */
public class ChunkedOutputStream extends FilterOutputStream {
    public static final int DEFAULT_CHUNK_SIZE = 4096;
    public final int chunkSize;

    public ChunkedOutputStream(OutputStream outputStream) {
        this(outputStream, 4096);
    }

    public ChunkedOutputStream(OutputStream outputStream, int i) {
        super(outputStream);
        if (i > 0) {
            this.chunkSize = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            int min = Math.min(i2, this.chunkSize);
            ((FilterOutputStream) this).out.write(bArr, i, min);
            i2 -= min;
            i += min;
        }
    }
}

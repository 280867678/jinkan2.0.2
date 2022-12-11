package org.apache.commons.p056io.output;

import java.io.IOException;
import java.io.OutputStream;
import me.tvspark.outline;

/* renamed from: org.apache.commons.io.output.ClosedOutputStream */
/* loaded from: classes4.dex */
public class ClosedOutputStream extends OutputStream {
    public static final ClosedOutputStream CLOSED_OUTPUT_STREAM = new ClosedOutputStream();

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("write(", i, ") failed: stream is closed"));
    }
}

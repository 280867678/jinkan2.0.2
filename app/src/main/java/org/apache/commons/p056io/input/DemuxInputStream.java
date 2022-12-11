package org.apache.commons.p056io.input;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.DemuxInputStream */
/* loaded from: classes4.dex */
public class DemuxInputStream extends InputStream {
    public final InheritableThreadLocal<InputStream> m_streams = new InheritableThreadLocal<>();

    public InputStream bindStream(InputStream inputStream) {
        InputStream inputStream2 = this.m_streams.get();
        this.m_streams.set(inputStream);
        return inputStream2;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.m_streams.get();
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InputStream inputStream = this.m_streams.get();
        if (inputStream != null) {
            return inputStream.read();
        }
        return -1;
    }
}

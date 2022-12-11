package org.apache.commons.p056io.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.AutoCloseInputStream */
/* loaded from: classes4.dex */
public class AutoCloseInputStream extends ProxyInputStream {
    public AutoCloseInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // org.apache.commons.p056io.input.ProxyInputStream
    public void afterRead(int i) throws IOException {
        if (i == -1) {
            close();
        }
    }

    @Override // org.apache.commons.p056io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterInputStream) this).in.close();
        ((FilterInputStream) this).in = new ClosedInputStream();
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }
}

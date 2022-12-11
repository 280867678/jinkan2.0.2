package org.apache.commons.p056io.output;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* renamed from: org.apache.commons.io.output.CloseShieldOutputStream */
/* loaded from: classes4.dex */
public class CloseShieldOutputStream extends ProxyOutputStream {
    public CloseShieldOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // org.apache.commons.p056io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterOutputStream) this).out = new ClosedOutputStream();
    }
}

package me.tvspark;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes4.dex */
public interface mx0 extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(uw0 uw0Var, long j) throws IOException;

    nx0 timeout();
}

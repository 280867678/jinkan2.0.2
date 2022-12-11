package me.tvspark;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* loaded from: classes4.dex */
public interface kx0 extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    nx0 timeout();

    void write(uw0 uw0Var, long j) throws IOException;
}

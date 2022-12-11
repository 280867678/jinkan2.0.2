package me.tvspark;

import java.io.IOException;

/* loaded from: classes4.dex */
public abstract class xw0 implements kx0 {
    public final kx0 delegate;

    public xw0(kx0 kx0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kx0Var, "delegate");
        this.delegate = kx0Var;
    }

    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final kx0 m4970deprecated_delegate() {
        return this.delegate;
    }

    @Override // me.tvspark.kx0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final kx0 delegate() {
        return this.delegate;
    }

    @Override // me.tvspark.kx0, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // me.tvspark.kx0
    public nx0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // me.tvspark.kx0
    public void write(uw0 uw0Var, long j) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "source");
        this.delegate.write(uw0Var, j);
    }
}

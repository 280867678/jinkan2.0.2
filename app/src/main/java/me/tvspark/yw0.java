package me.tvspark;

import java.io.IOException;

/* loaded from: classes4.dex */
public abstract class yw0 implements mx0 {
    public final mx0 delegate;

    public yw0(mx0 mx0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var, "delegate");
        this.delegate = mx0Var;
    }

    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final mx0 m4973deprecated_delegate() {
        return this.delegate;
    }

    @Override // me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final mx0 delegate() {
        return this.delegate;
    }

    @Override // me.tvspark.mx0
    public long read(uw0 uw0Var, long j) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
        return this.delegate.read(uw0Var, j);
    }

    @Override // me.tvspark.mx0
    public nx0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}

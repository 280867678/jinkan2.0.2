package me.tvspark;

/* loaded from: classes4.dex */
public final class tw0 implements kx0 {
    @Override // me.tvspark.kx0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // me.tvspark.kx0, java.io.Flushable
    public void flush() {
    }

    @Override // me.tvspark.kx0
    public nx0 timeout() {
        return nx0.NONE;
    }

    @Override // me.tvspark.kx0
    public void write(uw0 uw0Var, long j) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "source");
        uw0Var.skip(j);
    }
}

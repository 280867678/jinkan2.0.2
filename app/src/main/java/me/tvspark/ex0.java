package me.tvspark;

import java.io.OutputStream;

/* loaded from: classes4.dex */
public final class ex0 implements kx0 {
    public final nx0 Wwwwwwwwwwwwwwwwwwwwwww;
    public final OutputStream Wwwwwwwwwwwwwwwwwwwwwwww;

    public ex0(OutputStream outputStream, nx0 nx0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outputStream, "out");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nx0Var, "timeout");
        this.Wwwwwwwwwwwwwwwwwwwwwwww = outputStream;
        this.Wwwwwwwwwwwwwwwwwwwwwww = nx0Var;
    }

    @Override // me.tvspark.kx0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.close();
    }

    @Override // me.tvspark.kx0, java.io.Flushable
    public void flush() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.flush();
    }

    @Override // me.tvspark.kx0
    public nx0 timeout() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("sink(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(')');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // me.tvspark.kx0
    public void write(uw0 uw0Var, long j) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "source");
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var.Wwwwwwwwwwwwwwwwwwwwwww, 0L, j);
        while (j > 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.throwIfReached();
            ix0 ix0Var = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (ix0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            int min = (int) Math.min(j, ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.write(ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, min);
            int i = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + min;
            ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            long j2 = min;
            j -= j2;
            uw0Var.Wwwwwwwwwwwwwwwwwwwwwww -= j2;
            if (i == ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                jx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var);
            }
        }
    }
}

package me.tvspark;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public final class cx0 implements mx0 {
    public final nx0 Wwwwwwwwwwwwwwwwwwwwwww;
    public final InputStream Wwwwwwwwwwwwwwwwwwwwwwww;

    public cx0(InputStream inputStream, nx0 nx0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream, "input");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nx0Var, "timeout");
        this.Wwwwwwwwwwwwwwwwwwwwwwww = inputStream;
        this.Wwwwwwwwwwwwwwwwwwwwwww = nx0Var;
    }

    @Override // me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.close();
    }

    @Override // me.tvspark.mx0
    public long read(uw0 uw0Var, long j) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i == 0) {
            return 0L;
        }
        if (!(i >= 0)) {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("byteCount < 0: ", j).toString());
        }
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwww.throwIfReached();
            ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            int read = this.Wwwwwwwwwwwwwwwwwwwwwwww.read(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (int) Math.min(j, 8192 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            if (read == -1) {
                return -1L;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += read;
            long j2 = read;
            uw0Var.Wwwwwwwwwwwwwwwwwwwwwww += j2;
            return j2;
        } catch (AssertionError e) {
            if (!r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e)) {
                throw e;
            }
            throw new IOException(e);
        }
    }

    @Override // me.tvspark.mx0
    public nx0 timeout() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("source(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(')');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

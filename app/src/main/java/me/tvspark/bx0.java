package me.tvspark;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes4.dex */
public final class bx0 implements mx0 {
    public final Inflater Wwwwwwwwwwwwwwwwwwwww;
    public final ww0 Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;

    public bx0(ww0 ww0Var, Inflater inflater) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "source");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inflater, "inflater");
        this.Wwwwwwwwwwwwwwwwwwwwww = ww0Var;
        this.Wwwwwwwwwwwwwwwwwwwww = inflater;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 0) {
            return;
        }
        int remaining = i - this.Wwwwwwwwwwwwwwwwwwwww.getRemaining();
        this.Wwwwwwwwwwwwwwwwwwwwwwww -= remaining;
        this.Wwwwwwwwwwwwwwwwwwwwww.skip(remaining);
    }

    @Override // me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwww.end();
        this.Wwwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwww.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0097, code lost:
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009e, code lost:
        if (r1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != r1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a0, code lost:
        r8.Wwwwwwwwwwwwwwwwwwwwwwww = r1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        me.tvspark.jx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a9, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
        return -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007b A[Catch: DataFormatException -> 0x00ac, TryCatch #0 {DataFormatException -> 0x00ac, blocks: (B:20:0x0055, B:40:0x006f, B:22:0x007b, B:24:0x0083, B:29:0x008f, B:30:0x0096, B:33:0x0097, B:35:0x00a0), top: B:19:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006f A[SYNTHETIC] */
    @Override // me.tvspark.mx0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long read(uw0 uw0Var, long j) throws IOException {
        boolean z;
        int inflate;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (!(!this.Wwwwwwwwwwwwwwwwwwwwwww)) {
                throw new IllegalStateException("closed".toString());
            }
            if (i == 0) {
                return 0L;
            }
            while (true) {
                try {
                    if (this.Wwwwwwwwwwwwwwwwwwwww.needsInput()) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (!(this.Wwwwwwwwwwwwwwwwwwwww.getRemaining() == 0)) {
                            throw new IllegalStateException("?".toString());
                        }
                        if (this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            z = true;
                            ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                            inflate = this.Wwwwwwwwwwwwwwwwwwwww.inflate(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (int) Math.min(j, 8192 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                            if (inflate <= 0) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += inflate;
                                long j2 = inflate;
                                uw0Var.Wwwwwwwwwwwwwwwwwwwwwww += j2;
                                return j2;
                            } else if (this.Wwwwwwwwwwwwwwwwwwwww.finished() || this.Wwwwwwwwwwwwwwwwwwwww.needsDictionary()) {
                                break;
                            } else if (z) {
                                throw new EOFException("source exhausted prematurely");
                            }
                        } else {
                            ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwww.getBuffer().Wwwwwwwwwwwwwwwwwwwwwwww;
                            if (ix0Var == null) {
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                throw null;
                            }
                            int i2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i3 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i4 = i2 - i3;
                            this.Wwwwwwwwwwwwwwwwwwwwwwww = i4;
                            this.Wwwwwwwwwwwwwwwwwwwww.setInput(ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i3, i4);
                        }
                    }
                    ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    inflate = this.Wwwwwwwwwwwwwwwwwwwww.inflate(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (int) Math.min(j, 8192 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    if (inflate <= 0) {
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
                z = false;
            }
        } else {
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("byteCount < 0: ", j).toString());
        }
    }

    @Override // me.tvspark.mx0
    public nx0 timeout() {
        return this.Wwwwwwwwwwwwwwwwwwwwww.timeout();
    }
}

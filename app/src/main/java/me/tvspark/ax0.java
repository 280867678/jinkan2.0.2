package me.tvspark;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: classes4.dex */
public final class ax0 implements mx0 {
    public final CRC32 Wwwwwwwwwwwwwwwwwwww = new CRC32();
    public final bx0 Wwwwwwwwwwwwwwwwwwwww;
    public final Inflater Wwwwwwwwwwwwwwwwwwwwww;
    public final hx0 Wwwwwwwwwwwwwwwwwwwwwww;
    public byte Wwwwwwwwwwwwwwwwwwwwwwww;

    public ax0(mx0 mx0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var, "source");
        this.Wwwwwwwwwwwwwwwwwwwwwww = new hx0(mx0Var);
        Inflater inflater = new Inflater(true);
        this.Wwwwwwwwwwwwwwwwwwwwww = inflater;
        this.Wwwwwwwwwwwwwwwwwwwww = new bx0(this.Wwwwwwwwwwwwwwwwwwwwwww, inflater);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, int i2) {
        if (i2 == i) {
            return;
        }
        String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}, 3));
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) format, "java.lang.String.format(this, *args)");
        throw new IOException(format);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
        if (r10 <= 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
        r9 = (int) java.lang.Math.min(r7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - r8, r10);
        r6.Wwwwwwwwwwwwwwwwwwww.update(r7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (int) (r7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + r8), r9);
        r10 = r10 - r9;
        r7 = r7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
        if (r7 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
        me.tvspark.ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0043, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0 uw0Var, long j, long j2) {
        ix0 ix0Var = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (ix0Var == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        do {
            int i = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (j >= i - i2) {
                j -= i - i2;
                ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        } while (ix0Var != null);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    @Override // me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.Wwwwwwwwwwwwwwwwwwwww.close();
    }

    @Override // me.tvspark.mx0
    public long read(uw0 uw0Var, long j) throws IOException {
        long j2;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
        boolean z = false;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i == 0) {
                return 0L;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww == 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(10L);
                byte Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3L);
                boolean z2 = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >> 1) & 1) == 1;
                if (z2) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, 0L, 10L);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ID1ID2", 8075, this.Wwwwwwwwwwwwwwwwwwwwwww.readShort());
                this.Wwwwwwwwwwwwwwwwwwwwwww.skip(8L);
                if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >> 2) & 1) == 1) {
                    this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(2L);
                    if (z2) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, 0L, 2L);
                    }
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (z2) {
                        j2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, 0L, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    } else {
                        j2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwww.skip(j2);
                }
                if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >> 3) & 1) == 1) {
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((byte) 0, 0L, Long.MAX_VALUE);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                        throw new EOFException();
                    }
                    if (z2) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, 0L, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1);
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwww.skip(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1);
                }
                if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >> 4) & 1) == 1) {
                    z = true;
                }
                if (z) {
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((byte) 0, 0L, Long.MAX_VALUE);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
                        throw new EOFException();
                    }
                    if (z2) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, 0L, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 1);
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwww.skip(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 1);
                }
                if (z2) {
                    hx0 hx0Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    hx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(2L);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("FHCRC", hx0Var.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), (short) this.Wwwwwwwwwwwwwwwwwwww.getValue());
                    this.Wwwwwwwwwwwwwwwwwwww.reset();
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwww = (byte) 1;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww == 1) {
                long j3 = uw0Var.Wwwwwwwwwwwwwwwwwwwwwww;
                long read = this.Wwwwwwwwwwwwwwwwwwwww.read(uw0Var, j);
                if (read != -1) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, j3, read);
                    return read;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwww = (byte) 2;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww == 2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("CRC", this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), (int) this.Wwwwwwwwwwwwwwwwwwww.getValue());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ISIZE", this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), (int) this.Wwwwwwwwwwwwwwwwwwwwww.getBytesWritten());
                this.Wwwwwwwwwwwwwwwwwwwwwwww = (byte) 3;
                if (!this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("byteCount < 0: ", j).toString());
    }

    @Override // me.tvspark.mx0
    public nx0 timeout() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.timeout();
    }
}

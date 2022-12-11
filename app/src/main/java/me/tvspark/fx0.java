package me.tvspark;

/* loaded from: classes4.dex */
public final class fx0 implements mx0 {
    public final ww0 Wwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public ix0 Wwwwwwwwwwwwwwwwwwwwwww;
    public final uw0 Wwwwwwwwwwwwwwwwwwwwwwww;

    public fx0(ww0 ww0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "upstream");
        this.Wwwwwwwwwwwwwwwwwww = ww0Var;
        uw0 buffer = ww0Var.getBuffer();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = buffer;
        ix0 ix0Var = buffer.Wwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwww = ix0Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = ix0Var != null ? ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : -1;
    }

    @Override // me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.Wwwwwwwwwwwwwwwwwwwww = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r0 == r3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) goto L15;
     */
    @Override // me.tvspark.mx0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long read(uw0 uw0Var, long j) {
        ix0 ix0Var;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
        boolean z = true;
        if (!this.Wwwwwwwwwwwwwwwwwwwww) {
            ix0 ix0Var2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (ix0Var2 != null) {
                ix0 ix0Var3 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var2 == ix0Var3) {
                    int i = this.Wwwwwwwwwwwwwwwwwwwwww;
                    if (ix0Var3 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                }
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("Peek source is invalid because upstream source was used".toString());
            }
            this.Wwwwwwwwwwwwwwwwwww.request(this.Wwwwwwwwwwwwwwwwwwww + j);
            if (this.Wwwwwwwwwwwwwwwwwwwwwww == null && (ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww) != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = ix0Var;
                if (ix0Var == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                this.Wwwwwwwwwwwwwwwwwwwwww = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            long min = Math.min(j, this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwww);
            if (min <= 0) {
                return -1L;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, this.Wwwwwwwwwwwwwwwwwwww, min);
            this.Wwwwwwwwwwwwwwwwwwww += min;
            return min;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.mx0
    public nx0 timeout() {
        return this.Wwwwwwwwwwwwwwwwwww.timeout();
    }
}

package me.tvspark;

import java.nio.ByteBuffer;
import okio.ByteString;
import org.mozilla.javascript.tools.idswitch.Main;

/* loaded from: classes4.dex */
public final class gx0 implements vw0 {
    public final kx0 Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final uw0 Wwwwwwwwwwwwwwwwwwwwwwww = new uw0();

    public gx0(kx0 kx0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kx0Var, "sink");
        this.Wwwwwwwwwwwwwwwwwwwwww = kx0Var;
    }

    @Override // me.tvspark.vw0
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwww */
    public vw0 mo4956Wwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4956Wwwwwwwwwwwwwwwwwwwwwwwwwww(j);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.vw0
    public vw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
                this.Wwwwwwwwwwwwwwwwwwwwww.write(this.Wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.vw0
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public vw0 mo4957Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4957Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.vw0
    public vw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            uw0 uw0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            long j = uw0Var.Wwwwwwwwwwwwwwwwwwwwwww;
            if (j > 0) {
                this.Wwwwwwwwwwwwwwwwwwwwww.write(uw0Var, j);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.vw0
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0 mx0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var, "source");
        long j = 0;
        while (true) {
            long read = mx0Var.read(this.Wwwwwwwwwwwwwwwwwwwwwwww, 8192);
            if (read == -1) {
                return j;
            }
            j += read;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.vw0
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public vw0 mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Main.STRING_TAG_STR);
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.vw0
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public vw0 mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "byteString");
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.kx0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        Throwable th = null;
        try {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww > 0) {
                this.Wwwwwwwwwwwwwwwwwwwwww.write(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.Wwwwwwwwwwwwwwwwwwwwww.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // me.tvspark.vw0, me.tvspark.kx0, java.io.Flushable
    public void flush() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            uw0 uw0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            long j = uw0Var.Wwwwwwwwwwwwwwwwwwwwwww;
            if (j > 0) {
                this.Wwwwwwwwwwwwwwwwwwwwww.write(uw0Var, j);
            }
            this.Wwwwwwwwwwwwwwwwwwwwww.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.vw0
    public uw0 getBuffer() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.kx0
    public nx0 timeout() {
        return this.Wwwwwwwwwwwwwwwwwwwwww.timeout();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("buffer(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(')');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer, "source");
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            int write = this.Wwwwwwwwwwwwwwwwwwwwwwww.write(byteBuffer);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.vw0
    /* renamed from: write */
    public vw0 mo4961write(byte[] bArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "source");
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4961write(bArr);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.vw0
    /* renamed from: write */
    public vw0 mo4962write(byte[] bArr, int i, int i2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "source");
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4962write(bArr, i, i2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.kx0
    public void write(uw0 uw0Var, long j) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "source");
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.write(uw0Var, j);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.vw0
    /* renamed from: writeByte */
    public vw0 mo4963writeByte(int i) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4963writeByte(i);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.vw0
    /* renamed from: writeInt */
    public vw0 mo4964writeInt(int i) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4964writeInt(i);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.vw0
    /* renamed from: writeShort */
    public vw0 mo4965writeShort(int i) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4965writeShort(i);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }
}

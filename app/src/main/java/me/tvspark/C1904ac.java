package me.tvspark;

import java.nio.ByteBuffer;

/* renamed from: me.tvspark.ac */
/* loaded from: classes4.dex */
public final class C1904ac extends C2738w5 {
    public int Wwwwwwwwwwwww;
    public int Wwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwww;
    public final C2738w5 Wwwwwwwwwwwwwwwww = new C2738w5(2);

    public C1904ac() {
        super(2);
        clear();
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ByteBuffer byteBuffer;
        return this.Wwwwwwwwwwwwww >= this.Wwwwwwwwwwwww || ((byteBuffer = this.Wwwwwwwwwwwwwwwwwwwwwww) != null && byteBuffer.position() >= 3072000) || this.Wwwwwwwwwwwwwwww;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwww == 0;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        super.clear();
        this.Wwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwww = -9223372036854775807L;
        this.Wwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
        this.Wwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwww = false;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        super.clear();
        this.Wwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwww = -9223372036854775807L;
        this.Wwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
        if (this.Wwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwww = false;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2738w5 c2738w5) {
        ByteBuffer byteBuffer = c2738w5.Wwwwwwwwwwwwwwwwwwwwwww;
        if (byteBuffer != null) {
            c2738w5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer.remaining());
            this.Wwwwwwwwwwwwwwwwwwwwwww.put(byteBuffer);
        }
        if (c2738w5.isEndOfStream()) {
            setFlags(4);
        }
        if (c2738w5.isDecodeOnly()) {
            setFlags(Integer.MIN_VALUE);
        }
        if (c2738w5.isKeyFrame()) {
            setFlags(1);
        }
        int i = this.Wwwwwwwwwwwwww + 1;
        this.Wwwwwwwwwwwwww = i;
        long j = c2738w5.Wwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwww = j;
        if (i == 1) {
            this.Wwwwwwwwwwwwwww = j;
        }
        c2738w5.clear();
    }

    @Override // me.tvspark.C2738w5, me.tvspark.AbstractC2586s5
    public void clear() {
        super.clear();
        this.Wwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwww = -9223372036854775807L;
        this.Wwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
        this.Wwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwww = 32;
    }
}

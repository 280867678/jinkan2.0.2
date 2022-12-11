package com.google.common.hash;

import java.io.Serializable;
import java.nio.ByteBuffer;
import me.tvspark.AbstractC2350ly;
import me.tvspark.AbstractC2424ny;
import me.tvspark.AbstractC2461oy;
import me.tvspark.AbstractC2504py;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class SipHashFunction extends AbstractC2350ly implements Serializable {
    public static final AbstractC2461oy SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    public static final long serialVersionUID = 0;

    /* renamed from: c */
    public final int f587c;

    /* renamed from: d */
    public final int f588d;

    /* renamed from: k0 */
    public final long f589k0;

    /* renamed from: k1 */
    public final long f590k1;

    public SipHashFunction(int i, int i2, long j, long j2) {
        boolean z = true;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 <= 0 ? false : z, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.f587c = i;
        this.f588d = i2;
        this.f589k0 = j;
        this.f590k1 = j2;
    }

    public int bits() {
        return 64;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SipHashFunction) {
            SipHashFunction sipHashFunction = (SipHashFunction) obj;
            return this.f587c == sipHashFunction.f587c && this.f588d == sipHashFunction.f588d && this.f589k0 == sipHashFunction.f589k0 && this.f590k1 == sipHashFunction.f590k1;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((SipHashFunction.class.hashCode() ^ this.f587c) ^ this.f588d) ^ this.f589k0) ^ this.f590k1);
    }

    @Override // me.tvspark.AbstractC2461oy
    public AbstractC2504py newHasher() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.f587c, this.f588d, this.f589k0, this.f590k1);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Hashing.sipHash");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.f587c);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.f588d);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.f589k0);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", ");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, this.f590k1, ")");
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2424ny {
        public long Wwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwww = 0;
        public long Wwwwwwwwwwwwwwwwwwwwwwww = 0;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, long j, long j2) {
            super(8);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 8317987319222330741L;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 7237128888997146477L;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = 7816392313619706465L;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = 8387220255154660723L;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 8317987319222330741L ^ j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 7237128888997146477L ^ j2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = 7816392313619706465L ^ j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = 8387220255154660723L ^ j2;
        }

        @Override // me.tvspark.AbstractC2424ny
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwww += byteBuffer.remaining();
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww ^= (byteBuffer.get() & 255) << i;
                i += 8;
            }
        }

        @Override // me.tvspark.AbstractC2424ny
        public HashCode Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            long j = this.Wwwwwwwwwwwwwwwwwwwwwwww ^ (this.Wwwwwwwwwwwwwwwwwwwwwwwww << 56);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww ^= j;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = j ^ this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww ^= 255;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return HashCode.fromLong(((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww ^ this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) ^ this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) ^ this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = j + j2;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww += this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Long.rotateLeft(j2, 13);
                long rotateLeft = Long.rotateLeft(this.Wwwwwwwwwwwwwwwwwwwwwwwwww, 16);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = rotateLeft;
                long j3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                long j4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = j3 ^ j4;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = rotateLeft ^ this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                long rotateLeft2 = Long.rotateLeft(j4, 32);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = rotateLeft2;
                long j5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                long j6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = j5 + j6;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = rotateLeft2 + this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Long.rotateLeft(j6, 17);
                long rotateLeft3 = Long.rotateLeft(this.Wwwwwwwwwwwwwwwwwwwwwwwwww, 21);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = rotateLeft3;
                long j7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                long j8 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = j7 ^ j8;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = rotateLeft3 ^ this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Long.rotateLeft(j8, 32);
            }
        }

        @Override // me.tvspark.AbstractC2424ny
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwww += 8;
            long j = byteBuffer.getLong();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww ^= j;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = j ^ this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }
}

package com.google.common.hash;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import me.tvspark.AbstractC2350ly;
import me.tvspark.AbstractC2424ny;
import me.tvspark.AbstractC2461oy;
import me.tvspark.AbstractC2504py;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class Murmur3_128HashFunction extends AbstractC2350ly implements Serializable {
    public static final long serialVersionUID = 0;
    public final int seed;
    public static final AbstractC2461oy MURMUR3_128 = new Murmur3_128HashFunction(0);
    public static final AbstractC2461oy GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2424ny {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            super(16);
            long j = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        }

        public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
            long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
            return j3 ^ (j3 >>> 33);
        }

        @Override // me.tvspark.AbstractC2424ny
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
            long j;
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            long j7;
            long j8;
            long j9;
            long j10;
            long j11;
            long j12;
            long j13;
            long j14;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = byteBuffer.remaining() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j15 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j = 0;
                    j7 = (byteBuffer.get(0) & 255) ^ j;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    return;
                case 2:
                    j2 = 0;
                    j = j2 ^ ((byteBuffer.get(1) & 255) << 8);
                    j7 = (byteBuffer.get(0) & 255) ^ j;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    return;
                case 3:
                    j3 = 0;
                    j2 = j3 ^ ((byteBuffer.get(2) & 255) << 16);
                    j = j2 ^ ((byteBuffer.get(1) & 255) << 8);
                    j7 = (byteBuffer.get(0) & 255) ^ j;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    return;
                case 4:
                    j4 = 0;
                    j3 = j4 ^ ((byteBuffer.get(3) & 255) << 24);
                    j2 = j3 ^ ((byteBuffer.get(2) & 255) << 16);
                    j = j2 ^ ((byteBuffer.get(1) & 255) << 8);
                    j7 = (byteBuffer.get(0) & 255) ^ j;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    return;
                case 5:
                    j5 = 0;
                    j4 = j5 ^ ((byteBuffer.get(4) & 255) << 32);
                    j3 = j4 ^ ((byteBuffer.get(3) & 255) << 24);
                    j2 = j3 ^ ((byteBuffer.get(2) & 255) << 16);
                    j = j2 ^ ((byteBuffer.get(1) & 255) << 8);
                    j7 = (byteBuffer.get(0) & 255) ^ j;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    return;
                case 6:
                    j6 = 0;
                    j5 = j6 ^ ((byteBuffer.get(5) & 255) << 40);
                    j4 = j5 ^ ((byteBuffer.get(4) & 255) << 32);
                    j3 = j4 ^ ((byteBuffer.get(3) & 255) << 24);
                    j2 = j3 ^ ((byteBuffer.get(2) & 255) << 16);
                    j = j2 ^ ((byteBuffer.get(1) & 255) << 8);
                    j7 = (byteBuffer.get(0) & 255) ^ j;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    return;
                case 7:
                    j6 = ((byteBuffer.get(6) & 255) << 48) ^ 0;
                    j5 = j6 ^ ((byteBuffer.get(5) & 255) << 40);
                    j4 = j5 ^ ((byteBuffer.get(4) & 255) << 32);
                    j3 = j4 ^ ((byteBuffer.get(3) & 255) << 24);
                    j2 = j3 ^ ((byteBuffer.get(2) & 255) << 16);
                    j = j2 ^ ((byteBuffer.get(1) & 255) << 8);
                    j7 = (byteBuffer.get(0) & 255) ^ j;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    return;
                case 8:
                    j8 = 0;
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    return;
                case 9:
                    j9 = 0;
                    j8 = j9 ^ (byteBuffer.get(8) & 255);
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    return;
                case 10:
                    j10 = 0;
                    j9 = j10 ^ ((byteBuffer.get(9) & 255) << 8);
                    j8 = j9 ^ (byteBuffer.get(8) & 255);
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    return;
                case 11:
                    j11 = 0;
                    j10 = j11 ^ ((byteBuffer.get(10) & 255) << 16);
                    j9 = j10 ^ ((byteBuffer.get(9) & 255) << 8);
                    j8 = j9 ^ (byteBuffer.get(8) & 255);
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    return;
                case 12:
                    j12 = 0;
                    j11 = j12 ^ ((byteBuffer.get(11) & 255) << 24);
                    j10 = j11 ^ ((byteBuffer.get(10) & 255) << 16);
                    j9 = j10 ^ ((byteBuffer.get(9) & 255) << 8);
                    j8 = j9 ^ (byteBuffer.get(8) & 255);
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    return;
                case 13:
                    j13 = 0;
                    j12 = j13 ^ ((byteBuffer.get(12) & 255) << 32);
                    j11 = j12 ^ ((byteBuffer.get(11) & 255) << 24);
                    j10 = j11 ^ ((byteBuffer.get(10) & 255) << 16);
                    j9 = j10 ^ ((byteBuffer.get(9) & 255) << 8);
                    j8 = j9 ^ (byteBuffer.get(8) & 255);
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    return;
                case 14:
                    j14 = 0;
                    j13 = j14 ^ ((byteBuffer.get(13) & 255) << 40);
                    j12 = j13 ^ ((byteBuffer.get(12) & 255) << 32);
                    j11 = j12 ^ ((byteBuffer.get(11) & 255) << 24);
                    j10 = j11 ^ ((byteBuffer.get(10) & 255) << 16);
                    j9 = j10 ^ ((byteBuffer.get(9) & 255) << 8);
                    j8 = j9 ^ (byteBuffer.get(8) & 255);
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    return;
                case 15:
                    j14 = ((byteBuffer.get(14) & 255) << 48) ^ 0;
                    j13 = j14 ^ ((byteBuffer.get(13) & 255) << 40);
                    j12 = j13 ^ ((byteBuffer.get(12) & 255) << 32);
                    j11 = j12 ^ ((byteBuffer.get(11) & 255) << 24);
                    j10 = j11 ^ ((byteBuffer.get(10) & 255) << 16);
                    j9 = j10 ^ ((byteBuffer.get(9) & 255) << 8);
                    j8 = j9 ^ (byteBuffer.get(8) & 255);
                    j7 = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j7 * (-8663945395140668459L), 31) * 5545529020109919103L;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * (-8663945395140668459L);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }

        @Override // me.tvspark.AbstractC2424ny
        public HashCode Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j2 = j ^ i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
            long j3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^ i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j3;
            long j4 = j2 + j3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j3 + j4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j4);
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j5;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + j5;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).putLong(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww).array());
        }

        @Override // me.tvspark.AbstractC2424ny
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
            long j = byteBuffer.getLong();
            long j2 = byteBuffer.getLong();
            long rotateLeft = (Long.rotateLeft(j * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = rotateLeft;
            long rotateLeft2 = Long.rotateLeft(rotateLeft, 27);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = rotateLeft2;
            long j3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j4 = rotateLeft2 + j3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (j4 * 5) + 1390208809;
            long rotateLeft3 = (Long.rotateLeft(j2 * 5545529020109919103L, 33) * (-8663945395140668459L)) ^ j3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = rotateLeft3;
            long rotateLeft4 = Long.rotateLeft(rotateLeft3, 31);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = rotateLeft4;
            long j5 = rotateLeft4 + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j5;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (j5 * 5) + 944331445;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww += 16;
        }
    }

    public Murmur3_128HashFunction(int i) {
        this.seed = i;
    }

    public int bits() {
        return 128;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) obj).seed;
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // me.tvspark.AbstractC2461oy
    public AbstractC2504py newHasher() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.seed);
    }

    public String toString() {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Hashing.murmur3_128("), this.seed, ")");
    }
}

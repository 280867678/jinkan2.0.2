package com.google.common.hash;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import me.tvspark.AbstractC2350ly;
import me.tvspark.AbstractC2387my;
import me.tvspark.AbstractC2461oy;
import me.tvspark.AbstractC2504py;
import me.tvspark.AbstractC2652ty;
import me.tvspark.C2160gt;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class Murmur3_32HashFunction extends AbstractC2350ly implements Serializable {

    /* renamed from: C1 */
    public static final int f585C1 = -862048943;

    /* renamed from: C2 */
    public static final int f586C2 = 461845907;
    public static final int CHUNK_SIZE = 4;
    public static final long serialVersionUID = 0;
    public final int seed;
    public static final AbstractC2461oy MURMUR3_32 = new Murmur3_32HashFunction(0);
    public static final AbstractC2461oy GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    public Murmur3_32HashFunction(int i) {
        this.seed = i;
    }

    public static long charToThreeUtf8Bytes(char c) {
        return (((c & '?') | 128) << 16) | (((c >>> '\f') | 480) & 255) | ((((c >>> 6) & 63) | 128) << 8);
    }

    public static long charToTwoUtf8Bytes(char c) {
        return (((c & '?') | 128) << 8) | (((c >>> 6) | 960) & 255);
    }

    public static long codePointToFourUtf8Bytes(int i) {
        return (((i >>> 18) | 240) & 255) | ((((i >>> 12) & 63) | 128) << 8) | ((((i >>> 6) & 63) | 128) << 16) | (((i & 63) | 128) << 24);
    }

    public static HashCode fmix(int i, int i2) {
        int i3 = i ^ i2;
        int i4 = (i3 ^ (i3 >>> 16)) * (-2048144789);
        int i5 = (i4 ^ (i4 >>> 13)) * (-1028477387);
        return HashCode.fromInt(i5 ^ (i5 >>> 16));
    }

    public static int getIntLittleEndian(byte[] bArr, int i) {
        byte b = bArr[i + 3];
        byte b2 = bArr[i + 2];
        byte b3 = bArr[i + 1];
        return (bArr[i] & 255) | (b << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8);
    }

    public static int mixH1(int i, int i2) {
        return (Integer.rotateLeft(i ^ i2, 13) * 5) - 430675100;
    }

    public static int mixK1(int i) {
        return Integer.rotateLeft(i * f585C1, 15) * f586C2;
    }

    public int bits() {
        return 32;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Murmur3_32HashFunction) && this.seed == ((Murmur3_32HashFunction) obj).seed;
    }

    @Override // me.tvspark.AbstractC2350ly
    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i + i2, bArr.length);
        int i3 = this.seed;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5 + 4;
            if (i6 > i2) {
                break;
            }
            i3 = mixH1(i3, mixK1(getIntLittleEndian(bArr, i5 + i)));
            i5 = i6;
        }
        int i7 = i5;
        int i8 = 0;
        while (i7 < i2) {
            i4 ^= (bArr[i + i7] & 255) << i8;
            i7++;
            i8 += 8;
        }
        return fmix(mixK1(i4) ^ i3, i2);
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // me.tvspark.AbstractC2350ly
    public HashCode hashInt(int i) {
        return fmix(mixH1(this.seed, mixK1(i)), 4);
    }

    @Override // me.tvspark.AbstractC2350ly
    public HashCode hashLong(long j) {
        int i = (int) (j >>> 32);
        return fmix(mixH1(mixH1(this.seed, mixK1((int) j)), mixK1(i)), 8);
    }

    @Override // me.tvspark.AbstractC2350ly
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        if (C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(charset)) {
            int length = charSequence.length();
            int i = this.seed;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = i3 + 4;
                if (i5 > length) {
                    break;
                }
                char charAt = charSequence.charAt(i3);
                char charAt2 = charSequence.charAt(i3 + 1);
                char charAt3 = charSequence.charAt(i3 + 2);
                char charAt4 = charSequence.charAt(i3 + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                i = mixH1(i, mixK1((charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24)));
                i4 += 4;
                i3 = i5;
            }
            long j = 0;
            while (i3 < length) {
                char charAt5 = charSequence.charAt(i3);
                if (charAt5 < 128) {
                    j |= charAt5 << i2;
                    i2 += 8;
                    i4++;
                } else if (charAt5 < 2048) {
                    j |= charToTwoUtf8Bytes(charAt5) << i2;
                    i2 += 16;
                    i4 += 2;
                } else if (charAt5 < 55296 || charAt5 > 57343) {
                    j |= charToThreeUtf8Bytes(charAt5) << i2;
                    i2 += 24;
                    i4 += 3;
                } else {
                    int codePointAt = Character.codePointAt(charSequence, i3);
                    if (codePointAt == charAt5) {
                        return hashBytes(charSequence.toString().getBytes(charset));
                    }
                    i3++;
                    j |= codePointToFourUtf8Bytes(codePointAt) << i2;
                    i4 += 4;
                }
                if (i2 >= 32) {
                    i = mixH1(i, mixK1((int) j));
                    j >>>= 32;
                    i2 -= 32;
                }
                i3++;
            }
            return fmix(mixK1((int) j) ^ i, i4);
        }
        return hashBytes(charSequence.toString().getBytes(charset));
    }

    @Override // me.tvspark.AbstractC2350ly
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int i = this.seed;
        for (int i2 = 1; i2 < charSequence.length(); i2 += 2) {
            i = mixH1(i, mixK1(charSequence.charAt(i2 - 1) | (charSequence.charAt(i2) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i ^= mixK1(charSequence.charAt(charSequence.length() - 1));
        }
        return fmix(i, charSequence.length() * 2);
    }

    @Override // me.tvspark.AbstractC2461oy
    public AbstractC2504py newHasher() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.seed);
    }

    public String toString() {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Hashing.murmur3_32("), this.seed, ")");
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2387my {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // me.tvspark.AbstractC2504py
        public HashCode Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            int mixK1 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ^ Murmur3_32HashFunction.mixK1((int) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mixK1;
            return Murmur3_32HashFunction.fmix(mixK1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.AbstractC2387my
        public AbstractC2504py Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2, c);
            return this;
        }

        @Override // me.tvspark.AbstractC2504py, me.tvspark.AbstractC2652ty
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public AbstractC2504py mo4947Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4, i);
            return this;
        }

        @Override // me.tvspark.AbstractC2504py, me.tvspark.AbstractC2652ty
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public AbstractC2504py mo4948Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4, (int) j);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4, j >>> 32);
            return this;
        }

        @Override // me.tvspark.AbstractC2504py
        public AbstractC2504py Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                mo4947Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, byteBuffer.get() & 255);
            }
            byteBuffer.order(order);
            return this;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j) {
            long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j3 = ((j & 4294967295L) << i2) | j2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j3;
            int i3 = (i * 8) + i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
            if (i3 >= 32) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Murmur3_32HashFunction.mixH1(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Murmur3_32HashFunction.mixK1((int) j3));
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >>>= 32;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= 32;
            }
        }

        @Override // me.tvspark.AbstractC2387my, me.tvspark.AbstractC2504py
        public AbstractC2504py Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i + i2, bArr.length);
            int i3 = 0;
            while (true) {
                int i4 = i3 + 4;
                if (i4 <= i2) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4, Murmur3_32HashFunction.getIntLittleEndian(bArr, i3 + i));
                    i3 = i4;
                }
            }
            while (i3 < i2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, bArr[i + i3] & 255);
                i3++;
            }
            return this;
        }

        @Override // me.tvspark.AbstractC2504py, me.tvspark.AbstractC2652ty
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
        public AbstractC2652ty mo4947Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4, i);
            return this;
        }

        @Override // me.tvspark.AbstractC2504py, me.tvspark.AbstractC2652ty
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
        public AbstractC2652ty mo4948Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4, (int) j);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4, j >>> 32);
            return this;
        }

        @Override // me.tvspark.AbstractC2387my, me.tvspark.AbstractC2504py, me.tvspark.AbstractC2652ty
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public AbstractC2504py mo4944Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, Charset charset) {
            long charToThreeUtf8Bytes;
            int i;
            if (C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(charset)) {
                int length = charSequence.length();
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 4;
                    if (i3 > length) {
                        break;
                    }
                    char charAt = charSequence.charAt(i2);
                    char charAt2 = charSequence.charAt(i2 + 1);
                    char charAt3 = charSequence.charAt(i2 + 2);
                    char charAt4 = charSequence.charAt(i2 + 3);
                    if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                        break;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4, (charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24));
                    i2 = i3;
                }
                while (i2 < length) {
                    char charAt5 = charSequence.charAt(i2);
                    if (charAt5 < 128) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, charAt5);
                    } else {
                        if (charAt5 < 2048) {
                            charToThreeUtf8Bytes = Murmur3_32HashFunction.charToTwoUtf8Bytes(charAt5);
                            i = 2;
                        } else if (charAt5 < 55296 || charAt5 > 57343) {
                            charToThreeUtf8Bytes = Murmur3_32HashFunction.charToThreeUtf8Bytes(charAt5);
                            i = 3;
                        } else {
                            int codePointAt = Character.codePointAt(charSequence, i2);
                            if (codePointAt == charAt5) {
                                mo4945Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence.subSequence(i2, length).toString().getBytes(charset));
                                return this;
                            }
                            i2++;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4, Murmur3_32HashFunction.codePointToFourUtf8Bytes(codePointAt));
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, charToThreeUtf8Bytes);
                    }
                    i2++;
                }
                return this;
            }
            return mo4945Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence.toString().getBytes(charset));
        }
    }
}

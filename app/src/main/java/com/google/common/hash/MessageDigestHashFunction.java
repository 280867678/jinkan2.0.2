package com.google.common.hash;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import me.tvspark.AbstractC2313ky;
import me.tvspark.AbstractC2350ly;
import me.tvspark.AbstractC2504py;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class MessageDigestHashFunction extends AbstractC2350ly implements Serializable {
    public final int bytes;
    public final MessageDigest prototype;
    public final boolean supportsClone;
    public final String toString;

    /* loaded from: classes3.dex */
    public static final class SerializedForm implements Serializable {
        public static final long serialVersionUID = 0;
        public final String algorithmName;
        public final int bytes;
        public final String toString;

        public SerializedForm(String str, int i, String str2) {
            this.algorithmName = str;
            this.bytes = i;
            this.toString = str2;
        }

        private Object readResolve() {
            return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2313ky {
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final MessageDigest Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MessageDigest messageDigest, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = messageDigest;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // me.tvspark.AbstractC2313ky
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.update(byteBuffer);
        }

        @Override // me.tvspark.AbstractC2313ky
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.update(bArr, i, i2);
        }

        @Override // me.tvspark.AbstractC2504py
        public HashCode Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDigestLength() ? HashCode.fromBytesNoCopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.digest()) : HashCode.fromBytesNoCopy(Arrays.copyOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.digest(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }

        @Override // me.tvspark.AbstractC2313ky
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte b) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.update(b);
        }
    }

    public MessageDigestHashFunction(String str, int i, String str2) {
        if (str2 != null) {
            this.toString = str2;
            MessageDigest messageDigest = getMessageDigest(str);
            this.prototype = messageDigest;
            int digestLength = messageDigest.getDigestLength();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 4 && i <= digestLength, "bytes (%s) must be >= 4 and < %s", i, digestLength);
            this.bytes = i;
            this.supportsClone = supportsClone(this.prototype);
            return;
        }
        throw null;
    }

    public static MessageDigest getMessageDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static boolean supportsClone(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    public int bits() {
        return this.bytes * 8;
    }

    @Override // me.tvspark.AbstractC2461oy
    public AbstractC2504py newHasher() {
        if (this.supportsClone) {
            try {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((MessageDigest) this.prototype.clone(), this.bytes, null);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getMessageDigest(this.prototype.getAlgorithm()), this.bytes, null);
    }

    public String toString() {
        return this.toString;
    }

    public Object writeReplace() {
        return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString);
    }

    public MessageDigestHashFunction(String str, String str2) {
        MessageDigest messageDigest = getMessageDigest(str);
        this.prototype = messageDigest;
        this.bytes = messageDigest.getDigestLength();
        if (str2 != null) {
            this.toString = str2;
            this.supportsClone = supportsClone(this.prototype);
            return;
        }
        throw null;
    }
}

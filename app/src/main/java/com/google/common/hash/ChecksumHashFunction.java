package com.google.common.hash;

import java.io.Serializable;
import java.util.zip.Checksum;
import me.tvspark.AbstractC2313ky;
import me.tvspark.AbstractC2350ly;
import me.tvspark.AbstractC2504py;
import me.tvspark.AbstractC2541qy;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class ChecksumHashFunction extends AbstractC2350ly implements Serializable {
    public static final long serialVersionUID = 0;
    public final int bits;
    public final AbstractC2541qy<? extends Checksum> checksumSupplier;
    public final String toString;

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2313ky {
        public final Checksum Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Checksum checksum, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (checksum != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = checksum;
                return;
            }
            throw null;
        }

        @Override // me.tvspark.AbstractC2313ky
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.update(bArr, i, i2);
        }

        @Override // me.tvspark.AbstractC2504py
        public HashCode Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            long value = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getValue();
            return ChecksumHashFunction.this.bits == 32 ? HashCode.fromInt((int) value) : HashCode.fromLong(value);
        }

        @Override // me.tvspark.AbstractC2313ky
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte b) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.update(b);
        }
    }

    public ChecksumHashFunction(AbstractC2541qy<? extends Checksum> abstractC2541qy, int i, String str) {
        if (abstractC2541qy != null) {
            this.checksumSupplier = abstractC2541qy;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i == 32 || i == 64, "bits (%s) must be either 32 or 64", i);
            this.bits = i;
            if (str == null) {
                throw null;
            }
            this.toString = str;
            return;
        }
        throw null;
    }

    public int bits() {
        return this.bits;
    }

    @Override // me.tvspark.AbstractC2461oy
    public AbstractC2504py newHasher() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.checksumSupplier.mo4804get(), null);
    }

    public String toString() {
        return this.toString;
    }
}

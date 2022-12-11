package me.tvspark;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: me.tvspark.ly */
/* loaded from: classes4.dex */
public abstract class AbstractC2350ly implements AbstractC2461oy {
    public HashCode hashBytes(ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public HashCode hashBytes(byte[] bArr) {
        return hashBytes(bArr, 0, bArr.length);
    }

    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i + i2, bArr.length);
        return newHasher(i2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i, i2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public HashCode hashInt(int i) {
        return newHasher(4).mo4947Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public HashCode hashLong(long j) {
        return newHasher(8).mo4948Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2461oy
    public <T> HashCode hashObject(T t, Funnel<? super T> funnel) {
        AbstractC2387my abstractC2387my = (AbstractC2387my) newHasher();
        if (abstractC2387my != null) {
            funnel.funnel(t, abstractC2387my);
            return abstractC2387my.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        throw null;
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return newHasher().mo4944Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence, charset).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        AbstractC2387my abstractC2387my = (AbstractC2387my) newHasher(charSequence.length() * 2);
        if (abstractC2387my != null) {
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                abstractC2387my.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence.charAt(i));
            }
            return abstractC2387my.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        throw null;
    }

    public AbstractC2504py newHasher(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 0, "expectedInputSize must be >= 0 but was %s", i);
        return newHasher();
    }
}

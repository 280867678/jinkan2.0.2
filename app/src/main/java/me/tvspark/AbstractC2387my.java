package me.tvspark;

import java.nio.charset.Charset;

/* renamed from: me.tvspark.my */
/* loaded from: classes4.dex */
public abstract class AbstractC2387my implements AbstractC2504py {
    public abstract AbstractC2504py Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c);

    @Override // me.tvspark.AbstractC2504py, me.tvspark.AbstractC2652ty
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public AbstractC2504py mo4944Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, Charset charset) {
        return mo4945Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence.toString().getBytes(charset));
    }

    @Override // me.tvspark.AbstractC2652ty
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public AbstractC2504py mo4945Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 0, bArr.length);
    }

    @Override // me.tvspark.AbstractC2504py
    public abstract AbstractC2504py Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2);
}

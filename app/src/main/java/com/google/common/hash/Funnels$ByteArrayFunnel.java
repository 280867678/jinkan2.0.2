package com.google.common.hash;

import me.tvspark.AbstractC2652ty;

/* loaded from: classes3.dex */
public enum Funnels$ByteArrayFunnel implements Funnel<byte[]> {
    INSTANCE;

    @Override // com.google.common.hash.Funnel
    public void funnel(byte[] bArr, AbstractC2652ty abstractC2652ty) {
        abstractC2652ty.mo4945Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Funnels.byteArrayFunnel()";
    }
}

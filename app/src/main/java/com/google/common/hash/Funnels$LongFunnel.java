package com.google.common.hash;

import me.tvspark.AbstractC2652ty;

/* loaded from: classes3.dex */
public enum Funnels$LongFunnel implements Funnel<Long> {
    INSTANCE;

    @Override // com.google.common.hash.Funnel
    public void funnel(Long l, AbstractC2652ty abstractC2652ty) {
        abstractC2652ty.mo4948Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l.longValue());
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Funnels.longFunnel()";
    }
}

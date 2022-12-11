package com.google.common.hash;

import me.tvspark.AbstractC2652ty;

/* loaded from: classes3.dex */
public enum Funnels$IntegerFunnel implements Funnel<Integer> {
    INSTANCE;

    @Override // com.google.common.hash.Funnel
    public void funnel(Integer num, AbstractC2652ty abstractC2652ty) {
        abstractC2652ty.mo4947Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(num.intValue());
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Funnels.integerFunnel()";
    }
}

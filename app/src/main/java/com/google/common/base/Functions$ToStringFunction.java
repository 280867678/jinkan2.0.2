package com.google.common.base;

import me.tvspark.AbstractC2271jt;

/* loaded from: classes3.dex */
public enum Functions$ToStringFunction implements AbstractC2271jt<Object, String> {
    INSTANCE;

    @Override // me.tvspark.AbstractC2271jt
    /* renamed from: apply  reason: collision with other method in class */
    public String mo4462apply(Object obj) {
        if (obj != null) {
            return obj.toString();
        }
        throw null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Functions.toStringFunction()";
    }
}

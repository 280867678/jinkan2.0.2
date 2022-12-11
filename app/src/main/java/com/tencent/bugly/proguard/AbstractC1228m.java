package com.tencent.bugly.proguard;

import java.io.Serializable;

/* renamed from: com.tencent.bugly.proguard.m */
/* loaded from: classes3.dex */
public abstract class AbstractC1228m implements Serializable {
    /* renamed from: a */
    public abstract void mo2857a(C1223k c1223k);

    /* renamed from: a */
    public abstract void mo2856a(C1226l c1226l);

    /* renamed from: a */
    public abstract void mo2855a(StringBuilder sb, int i);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        mo2855a(sb, 0);
        return sb.toString();
    }
}

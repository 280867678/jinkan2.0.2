package com.tencent.bugly.crashreport.crash;

/* renamed from: com.tencent.bugly.crashreport.crash.b */
/* loaded from: classes3.dex */
public class C1158b implements Comparable<C1158b> {

    /* renamed from: a */
    public long f1208a = -1;

    /* renamed from: b */
    public long f1209b = -1;

    /* renamed from: c */
    public String f1210c = null;

    /* renamed from: d */
    public boolean f1211d = false;

    /* renamed from: e */
    public boolean f1212e = false;

    /* renamed from: f */
    public int f1213f = 0;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(C1158b c1158b) {
        int i;
        if (c1158b == null || this.f1209b - c1158b.f1209b > 0) {
            return 1;
        }
        return i < 0 ? -1 : 0;
    }
}

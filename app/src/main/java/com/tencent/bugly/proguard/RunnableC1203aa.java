package com.tencent.bugly.proguard;

/* renamed from: com.tencent.bugly.proguard.aa */
/* loaded from: classes3.dex */
public class RunnableC1203aa implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ String f1455a;

    /* renamed from: b */
    public final /* synthetic */ String f1456b;

    /* renamed from: c */
    public final /* synthetic */ String f1457c;

    public RunnableC1203aa(String str, String str2, String str3) {
        this.f1455a = str;
        this.f1456b = str2;
        this.f1457c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1205ba.m3058d(this.f1455a, this.f1456b, this.f1457c);
    }
}

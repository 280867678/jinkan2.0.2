package com.tencent.bugly.proguard;

import android.content.SharedPreferences;

/* renamed from: com.tencent.bugly.proguard.G */
/* loaded from: classes3.dex */
public class RunnableC1182G implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f1365a;

    /* renamed from: b */
    public final /* synthetic */ C1183H f1366b;

    public RunnableC1182G(C1183H c1183h, int i) {
        this.f1366b = c1183h;
        this.f1365a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean m3178b;
        SharedPreferences sharedPreferences;
        String str;
        m3178b = this.f1366b.m3178b(this.f1365a);
        sharedPreferences = this.f1366b.f1372f;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1365a);
        sb.append("_");
        str = this.f1366b.f1370d;
        sb.append(str);
        edit.putBoolean(sb.toString(), !m3178b).commit();
    }
}

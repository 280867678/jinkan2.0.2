package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.proguard.C1199X;

/* renamed from: com.tencent.bugly.crashreport.crash.f */
/* loaded from: classes3.dex */
public class RunnableC1162f implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ boolean f1223a;

    /* renamed from: b */
    public final /* synthetic */ Thread f1224b;

    /* renamed from: c */
    public final /* synthetic */ Throwable f1225c;

    /* renamed from: d */
    public final /* synthetic */ String f1226d;

    /* renamed from: e */
    public final /* synthetic */ byte[] f1227e;

    /* renamed from: f */
    public final /* synthetic */ boolean f1228f;

    /* renamed from: g */
    public final /* synthetic */ C1164h f1229g;

    public RunnableC1162f(C1164h c1164h, boolean z, Thread thread, Throwable th, String str, byte[] bArr, boolean z2) {
        this.f1229g = c1164h;
        this.f1223a = z;
        this.f1224b = thread;
        this.f1225c = th;
        this.f1226d = str;
        this.f1227e = bArr;
        this.f1228f = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1173l c1173l;
        Context context;
        try {
            C1199X.m3084a("post a throwable %b", Boolean.valueOf(this.f1223a));
            c1173l = this.f1229g.f1251s;
            c1173l.m3198b(this.f1224b, this.f1225c, false, this.f1226d, this.f1227e);
            if (!this.f1228f) {
                return;
            }
            C1199X.m3078c("clear user datas", new Object[0]);
            context = this.f1229g.f1249q;
            C1140a.m3421a(context).m3423a();
        } catch (Throwable th) {
            if (!C1199X.m3083a(th)) {
                th.printStackTrace();
            }
            C1199X.m3081b("java catch error: %s", this.f1225c.toString());
        }
    }
}

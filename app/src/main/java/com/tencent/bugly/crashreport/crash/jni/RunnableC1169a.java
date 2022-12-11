package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.C1161e;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import com.tencent.smtt.utils.TbsLog;

/* renamed from: com.tencent.bugly.crashreport.crash.jni.a */
/* loaded from: classes3.dex */
public class RunnableC1169a implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ NativeCrashHandler f1299a;

    public RunnableC1169a(NativeCrashHandler nativeCrashHandler) {
        this.f1299a = nativeCrashHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        boolean z;
        Context context2;
        String str;
        NativeExceptionHandler nativeExceptionHandler;
        Context context3;
        C1161e c1161e;
        String str2;
        C1161e c1161e2;
        context = this.f1299a.f1288e;
        if (!C1208ca.m3041a(context, "native_record_lock", 10000L)) {
            C1199X.m3078c("[Native] Failed to lock file for handling native crash record.", new Object[0]);
            return;
        }
        z = NativeCrashHandler.f1287d;
        if (!z) {
            this.f1299a.m3239a((int) TbsLog.TBSLOG_CODE_SDK_INIT, "false");
        }
        context2 = this.f1299a.f1288e;
        str = this.f1299a.f1292i;
        nativeExceptionHandler = this.f1299a.f1291h;
        CrashDetailBean m3226a = C1171c.m3226a(context2, str, nativeExceptionHandler);
        if (m3226a != null) {
            C1199X.m3078c("[Native] Get crash from native record.", new Object[0]);
            c1161e = this.f1299a.f1298o;
            if (!c1161e.m3286b(m3226a)) {
                c1161e2 = this.f1299a.f1298o;
                c1161e2.m3295a(m3226a, 3000L, false);
            }
            str2 = this.f1299a.f1292i;
            C1171c.m3220a(false, str2);
        }
        this.f1299a.m3233b();
        context3 = this.f1299a.f1288e;
        C1208ca.m3015b(context3, "native_record_lock");
    }
}

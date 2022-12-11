package com.umeng.analytics.pro;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMLog;
import me.tvspark.r40;
import me.tvspark.v51;

/* renamed from: com.umeng.analytics.pro.af */
/* loaded from: classes4.dex */
public class C1537af implements AbstractC1671z {

    /* renamed from: a */
    public boolean f2927a = false;

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:
        if (r3.versionCode >= 1) goto L17;
     */
    @Override // com.umeng.analytics.pro.AbstractC1671z
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String mo850a(Context context) {
        PackageInfo packageInfo;
        try {
            if (!this.f2927a) {
                v51 v51Var = v51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                if (v51Var != null) {
                    boolean z = false;
                    try {
                        packageInfo = origApplicationContext.getPackageManager().getPackageInfo("com.heytap.openid", 0);
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (Build.VERSION.SDK_INT >= 28) {
                        if (packageInfo != null && packageInfo.getLongVersionCode() >= 1) {
                            z = true;
                        }
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        this.f2927a = true;
                    } else {
                        if (packageInfo != null) {
                        }
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        this.f2927a = true;
                    }
                } else {
                    throw null;
                }
            }
            if (!r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                throw new RuntimeException("SDK Need Init First!");
            }
            if (!r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
                return null;
            } else if (!r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                throw new RuntimeException("SDK Need Init First!");
            } else {
                return v51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StubApp.getOrigApplicationContext(context.getApplicationContext()), "OUID");
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}

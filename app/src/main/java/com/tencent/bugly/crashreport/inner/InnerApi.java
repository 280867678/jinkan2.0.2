package com.tencent.bugly.crashreport.inner;

import com.tencent.bugly.crashreport.crash.C1172k;
import com.tencent.bugly.proguard.C1199X;
import java.util.Map;

/* loaded from: classes3.dex */
public class InnerApi {
    public static void postCocos2dxCrashAsync(int i, String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            C1199X.m3081b("post cocos2d-x fail args null", new Object[0]);
        } else if (i != 5 && i != 6) {
            C1199X.m3081b("post cocos2d-x fail category illeagle: %d", Integer.valueOf(i));
        } else {
            C1199X.m3078c("post cocos2d-x crash %s %s", str, str2);
            C1172k.m3210a(Thread.currentThread(), i, str, str2, str3, null);
        }
    }

    public static void postH5CrashAsync(Thread thread, String str, String str2, String str3, Map<String, String> map) {
        if (str == null || str2 == null || str3 == null) {
            C1199X.m3081b("post h5 fail args null", new Object[0]);
            return;
        }
        C1199X.m3078c("post h5 crash %s %s", str, str2);
        C1172k.m3210a(thread, 8, str, str2, str3, map);
    }

    public static void postU3dCrashAsync(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            C1199X.m3081b("post u3d fail args null", new Object[0]);
        }
        C1199X.m3078c("post u3d crash %s %s", str, str2);
        C1172k.m3210a(Thread.currentThread(), 4, str, str2, str3, null);
    }
}

package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

/* loaded from: classes4.dex */
public class TbsLinuxToolsJni {

    /* renamed from: a */
    public static boolean f1887a;

    /* renamed from: b */
    public static boolean f1888b;

    public TbsLinuxToolsJni(Context context) {
        m2782a(context);
    }

    private native int ChmodInner(String str, String str2);

    /* renamed from: a */
    private void m2782a(Context context) {
        synchronized (TbsLinuxToolsJni.class) {
            TbsLog.m2155i("TbsLinuxToolsJni", "TbsLinuxToolsJni init mbIsInited is " + f1888b);
            if (f1888b) {
                return;
            }
            f1888b = true;
            File file = TbsShareManager.isThirdPartyApp(context) ? new File(TbsShareManager.m2738a()) : C1381p.m2503a().m2437r(context);
            if (file != null) {
                if (!new File(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so").exists() && !TbsShareManager.isThirdPartyApp(context)) {
                    file = C1381p.m2503a().m2438q(context);
                }
                if (file != null) {
                    TbsLog.m2155i("TbsLinuxToolsJni", "TbsLinuxToolsJni init tbsSharePath is " + file.getAbsolutePath());
                    System.load(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
                    f1887a = true;
                }
            }
            ChmodInner("/checkChmodeExists", "700");
        }
    }

    /* renamed from: a */
    public int m2781a(String str, String str2) {
        if (!f1887a) {
            TbsLog.m2156e("TbsLinuxToolsJni", "jni not loaded!", true);
            return -1;
        }
        return ChmodInner(str, str2);
    }
}

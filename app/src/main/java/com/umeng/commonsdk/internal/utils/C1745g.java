package com.umeng.commonsdk.internal.utils;

import android.os.Build;
import com.umeng.commonsdk.internal.utils.C1741d;
import java.io.File;
import me.tvspark.outline;

/* renamed from: com.umeng.commonsdk.internal.utils.g */
/* loaded from: classes4.dex */
public class C1745g {
    /* renamed from: a */
    public static boolean m662a() {
        return m661b() || m660c() || m659d() || m658e();
    }

    /* renamed from: b */
    public static boolean m661b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    /* renamed from: c */
    public static boolean m660c() {
        try {
            if (new File("/system/app/Superuser.apk").exists()) {
                return true;
            }
        } catch (Exception unused) {
        }
        try {
            return new File("/system/app/Kinguser.apk").exists();
        } catch (Exception unused2) {
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m659d() {
        return new C1741d().m665a(C1741d.EnumC1742a.check_su_binary) != null;
    }

    /* renamed from: e */
    public static boolean m658e() {
        String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/", "/su/bin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        for (int i = 0; i < 12; i++) {
            if (new File(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr[i], "su")).exists()) {
                return true;
            }
        }
        return false;
    }
}

package com.efs.sdk.base.core.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.UUID;

/* renamed from: com.efs.sdk.base.core.util.e */
/* loaded from: classes3.dex */
public class C0779e {

    /* renamed from: a */
    public static volatile String f337a = "";

    /* renamed from: a */
    public static String m4001a(Context context) {
        if (TextUtils.isEmpty(f337a)) {
            synchronized (C0779e.class) {
                if (TextUtils.isEmpty(f337a)) {
                    String m4000b = m4000b(context);
                    f337a = m4000b;
                    if (TextUtils.isEmpty(m4000b)) {
                        f337a = m3999c(context);
                    }
                }
            }
        }
        return f337a;
    }

    /* renamed from: b */
    public static String m4000b(Context context) {
        try {
            File file = new File(C0763a.m4051a(context), "efsid");
            if (!file.exists()) {
                return null;
            }
            return C0769b.m4036a(file);
        } catch (Exception e) {
            Log.m4065e("efs.base", "get uuid error", e);
            return null;
        }
    }

    /* renamed from: c */
    public static String m3999c(Context context) {
        String str = "";
        for (int i = 0; i < 3; i++) {
            try {
                str = UUID.randomUUID().toString();
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(str)) {
            }
        }
        try {
            File m4051a = C0763a.m4051a(context);
            File file = new File(m4051a, "efsid" + Process.myPid());
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            C0769b.m4034a(file, str);
            if (file.renameTo(new File(m4051a, "efsid"))) {
                file.delete();
            }
        } catch (Exception e) {
            Log.m4065e("efs.base", "save uuid '" + str + "' error", e);
        }
        return str;
    }
}

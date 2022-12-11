package com.umeng.p048vt.diff.util;

import android.text.TextUtils;

/* renamed from: com.umeng.vt.diff.util.ClassLoadUtil */
/* loaded from: classes4.dex */
public class ClassLoadUtil {
    public static Class<?> findClass(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Class.forName(str);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}

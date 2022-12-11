package com.efs.sdk.base.core.util;

import android.content.Context;
import com.arialyy.aria.core.inf.ReceiverType;
import java.io.File;

/* renamed from: com.efs.sdk.base.core.util.a */
/* loaded from: classes3.dex */
public class C0763a {

    /* renamed from: a */
    public static String f315a = "efs";

    /* renamed from: b */
    public static File f316b;

    /* renamed from: a */
    public static File m4051a(Context context) {
        File dir = context.getDir(f315a, 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    /* renamed from: a */
    public static File m4050a(Context context, String str) {
        return new File(m4043g(context, str), "efs_cst");
    }

    /* renamed from: a */
    public static void m4049a(String str) {
        f315a = str;
    }

    /* renamed from: b */
    public static File m4048b(Context context, String str) {
        return new File(m4043g(context, str), "efs_config");
    }

    /* renamed from: c */
    public static File m4047c(Context context, String str) {
        return new File(m4043g(context, str), "efs_flow");
    }

    /* renamed from: d */
    public static File m4046d(Context context, String str) {
        File file = new File(m4043g(context, str), "ready");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: e */
    public static File m4045e(Context context, String str) {
        File file = new File(m4046d(context, str), String.valueOf(C0778d.m4005a()));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: f */
    public static File m4044f(Context context, String str) {
        File file = new File(m4043g(context, str), ReceiverType.UPLOAD);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: g */
    public static File m4043g(Context context, String str) {
        if (f316b == null) {
            synchronized (C0763a.class) {
                if (f316b == null) {
                    f316b = m4051a(context);
                }
            }
        }
        File file = new File(f316b, str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}

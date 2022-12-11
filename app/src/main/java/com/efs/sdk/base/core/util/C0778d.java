package com.efs.sdk.base.core.util;

import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

/* renamed from: com.efs.sdk.base.core.util.d */
/* loaded from: classes3.dex */
public final class C0778d {

    /* renamed from: a */
    public static String f334a = null;

    /* renamed from: b */
    public static List<Integer> f335b = null;

    /* renamed from: c */
    public static long f336c = -1;

    /* renamed from: a */
    public static int m4005a() {
        return Process.myPid();
    }

    /* renamed from: a */
    public static String m4004a(int i) {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + i + "/cmdline")));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader2.read();
                    if (read <= 0) {
                        sb.trimToSize();
                        String sb2 = sb.toString();
                        try {
                            bufferedReader2.close();
                            return sb2;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return sb2;
                        }
                    }
                    sb.append((char) read);
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                try {
                    Log.m4065e("efs.base", "get process name error", th);
                    return "";
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (com.efs.sdk.base.core.util.C0778d.f335b == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
        com.efs.sdk.base.core.util.C0778d.f335b.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
        if (android.text.TextUtils.isEmpty(m4004a(android.os.Process.myPid())) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
        com.efs.sdk.base.core.util.C0778d.f335b.add(java.lang.Integer.valueOf(android.os.Process.myPid()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
        if (android.text.TextUtils.isEmpty(m4004a(r7)) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
        com.efs.sdk.base.core.util.C0778d.f335b.add(java.lang.Integer.valueOf(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006c, code lost:
        com.efs.sdk.base.core.util.C0778d.f336c = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0037, code lost:
        com.efs.sdk.base.core.util.C0778d.f335b = new java.util.ArrayList();
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m4003a(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            boolean z = false;
            if (f335b != null && !f335b.isEmpty() && f336c > 0 && System.currentTimeMillis() - f336c <= 600000) {
                z = true;
            }
            return f335b.contains(Integer.valueOf(parseInt));
        } catch (Throwable th) {
            Log.m4065e("efs.base", "Process exist judge error", th);
            return true;
        }
    }

    /* renamed from: b */
    public static String m4002b() {
        String str = f334a;
        if (TextUtils.isEmpty(str)) {
            String m4004a = m4004a(Process.myPid());
            f334a = m4004a;
            return m4004a;
        }
        return str;
    }
}

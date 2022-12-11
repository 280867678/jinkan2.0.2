package com.umeng.commonsdk.internal.crash;

import java.io.PrintWriter;
import java.io.StringWriter;

/* renamed from: com.umeng.commonsdk.internal.crash.a */
/* loaded from: classes4.dex */
public class C1732a {
    /* renamed from: a */
    public static String m712a(Throwable th) {
        String str = null;
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            while (true) {
                th.printStackTrace(printWriter);
                th = th.getCause();
                if (th == null) {
                    str = stringWriter.toString();
                    printWriter.close();
                    stringWriter.close();
                    return str;
                }
            }
        } catch (Exception unused) {
            return str;
        }
    }
}

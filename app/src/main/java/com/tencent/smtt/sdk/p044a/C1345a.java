package com.tencent.smtt.sdk.p044a;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.tencent.smtt.sdk.a.a */
/* loaded from: classes4.dex */
public class C1345a {
    /* renamed from: a */
    public static String m2661a(long j) {
        return String.format(Locale.getDefault(), "%d(%s)", Long.valueOf(j), new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(j)));
    }
}

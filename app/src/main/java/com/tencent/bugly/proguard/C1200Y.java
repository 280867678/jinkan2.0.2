package com.tencent.bugly.proguard;

import android.text.TextUtils;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* renamed from: com.tencent.bugly.proguard.Y */
/* loaded from: classes3.dex */
public class C1200Y {

    /* renamed from: a */
    public static Proxy f1451a;

    /* renamed from: a */
    public static Proxy m3074a() {
        return f1451a;
    }

    /* renamed from: a */
    public static void m3073a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            f1451a = null;
        } else {
            f1451a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i));
        }
    }

    /* renamed from: a */
    public static void m3072a(InetAddress inetAddress, int i) {
        if (inetAddress == null) {
            f1451a = null;
        } else {
            f1451a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i));
        }
    }
}

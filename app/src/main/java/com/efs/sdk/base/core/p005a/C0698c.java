package com.efs.sdk.base.core.p005a;

import android.text.TextUtils;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.EfsConstant;
import com.efs.sdk.base.core.config.p008a.C0729c;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.PackageUtil;
import com.efs.sdk.base.core.util.p016c.C0776a;
import com.efs.sdk.base.core.util.p016c.C0777b;
import com.umeng.analytics.pro.C1543ak;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import me.tvspark.outline;

/* renamed from: com.efs.sdk.base.core.a.c */
/* loaded from: classes3.dex */
public final class C0698c {

    /* renamed from: a */
    public String f171a;

    /* renamed from: b */
    public String f172b;

    /* renamed from: c */
    public String f173c;

    /* renamed from: d */
    public String f174d;

    /* renamed from: e */
    public int f175e;

    /* renamed from: f */
    public String f176f;

    /* renamed from: g */
    public byte f177g;

    /* renamed from: h */
    public String f178h;

    /* renamed from: i */
    public String f179i;

    /* renamed from: j */
    public String f180j;

    /* renamed from: k */
    public String f181k;

    /* renamed from: l */
    public String f182l;

    /* renamed from: m */
    public long f183m = 0;

    /* renamed from: a */
    public static C0698c m4175a() {
        C0698c c0698c = new C0698c();
        c0698c.f171a = ControllerCenter.getGlobalEnvStruct().getAppid();
        c0698c.f172b = ControllerCenter.getGlobalEnvStruct().getSecret();
        c0698c.f182l = ControllerCenter.getGlobalEnvStruct().getUid();
        c0698c.f180j = BuildConfig.VERSION_NAME;
        c0698c.f173c = PackageUtil.getAppVersionName(ControllerCenter.getGlobalEnvStruct().mAppContext);
        c0698c.f179i = String.valueOf(C0729c.m4127a().f248d.f238a);
        c0698c.f181k = EfsConstant.UM_SDK_VERSION;
        return c0698c;
    }

    /* renamed from: b */
    public final String m4174b() {
        C0694a.m4184a();
        String valueOf = String.valueOf(C0694a.m4180b() / 1000);
        String m4008a = C0777b.m4008a(C0776a.m4012a(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this.f182l, valueOf), this.f172b));
        TreeMap treeMap = new TreeMap();
        treeMap.put("app", this.f171a);
        treeMap.put("sd", m4008a);
        if (!TextUtils.isEmpty(this.f174d)) {
            treeMap.put("cp", this.f174d);
        }
        if (this.f177g != 0) {
            treeMap.put("de", String.valueOf(this.f175e));
            treeMap.put("type", this.f178h);
            String str = this.f176f;
            if (TextUtils.isEmpty(str)) {
                C0694a.m4184a();
                long m4180b = C0694a.m4180b();
                str = String.format(Locale.SIMPLIFIED_CHINESE, "%d%04d", Long.valueOf(m4180b), Integer.valueOf(new Random(m4180b).nextInt(10000)));
            }
            treeMap.put("seq", str);
        }
        treeMap.put("cver", this.f179i);
        treeMap.put(C1543ak.f3053x, "android");
        treeMap.put("sver", this.f179i);
        treeMap.put("tm", valueOf);
        treeMap.put("ver", this.f173c);
        treeMap.put("um_sdk_ver", this.f181k);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            String str2 = ((String) entry.getKey()) + "=" + ((String) entry.getValue());
            sb2.append(str2);
            sb.append(str2);
            sb.append("&");
        }
        String m4009a = C0777b.m4009a(sb2.toString() + this.f172b);
        sb.append("sign=");
        sb.append(m4009a);
        Log.m4070d("efs.config", sb.toString());
        return C0777b.m4007b(sb.toString());
    }
}

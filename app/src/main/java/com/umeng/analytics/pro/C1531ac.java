package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* renamed from: com.umeng.analytics.pro.ac */
/* loaded from: classes4.dex */
public class C1531ac {
    /* renamed from: a */
    public static AbstractC1671z m1389a(Context context) {
        String str = Build.BRAND;
        C1542aj.m1380a("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("huawei") || str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("华为")) {
            return new C1532ad();
        }
        if (str.equalsIgnoreCase("xiaomi") || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米")) {
            return new C1541ai();
        }
        if (str.equalsIgnoreCase("vivo")) {
            return new C1540ah();
        }
        if (str.equalsIgnoreCase("oppo") || str.equalsIgnoreCase("oneplus")) {
            return new C1537af();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new C1536ae();
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG")) {
            return new C1538ag();
        }
        if (!UMUtils.isAppInstalled(context, C1529ab.f2913b)) {
            return null;
        }
        return new C1529ab();
    }
}

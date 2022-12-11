package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import me.tvspark.r40;
import me.tvspark.z51;

/* renamed from: com.umeng.analytics.pro.ah */
/* loaded from: classes4.dex */
public class C1540ah implements AbstractC1671z {
    @Override // com.umeng.analytics.pro.AbstractC1671z
    /* renamed from: a */
    public String mo850a(Context context) {
        try {
            if (z51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context) != null) {
                if (z51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
                }
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
                return null;
            }
            throw null;
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}

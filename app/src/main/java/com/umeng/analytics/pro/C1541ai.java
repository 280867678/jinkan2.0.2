package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import java.lang.reflect.Method;
import me.tvspark.w51;

/* renamed from: com.umeng.analytics.pro.ai */
/* loaded from: classes4.dex */
public class C1541ai implements AbstractC1671z {
    @Override // com.umeng.analytics.pro.AbstractC1671z
    /* renamed from: a */
    public String mo850a(Context context) {
        try {
            if (!((w51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || w51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) ? false : true)) {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
                return null;
            }
            Method method = w51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Object obj = w51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (obj == null || method == null) {
                return null;
            }
            try {
                Object invoke = method.invoke(obj, context);
                if (invoke == null) {
                    return null;
                }
                return (String) invoke;
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception unused2) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}

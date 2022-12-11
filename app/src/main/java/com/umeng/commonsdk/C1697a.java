package com.umeng.commonsdk;

import android.content.Context;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;

/* renamed from: com.umeng.commonsdk.a */
/* loaded from: classes4.dex */
public class C1697a {

    /* renamed from: a */
    public static Class<?> f3739a;

    /* renamed from: b */
    public static Method f3740b;

    static {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.UMInnerImpl");
            f3739a = cls;
            Method declaredMethod = cls.getDeclaredMethod("initAndSendInternal", Context.class);
            if (declaredMethod == null) {
                return;
            }
            f3740b = declaredMethod;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m795a(Context context) {
        Method method;
        if (context == null || !UMUtils.isMainProgress(context)) {
            return;
        }
        if (SdkVersion.SDK_TYPE == 1) {
            UMConfigureInternation.sendInternal(context);
            return;
        }
        Class<?> cls = f3739a;
        if (cls == null || (method = f3740b) == null) {
            return;
        }
        try {
            method.invoke(cls, context);
        } catch (Throwable unused) {
        }
    }
}

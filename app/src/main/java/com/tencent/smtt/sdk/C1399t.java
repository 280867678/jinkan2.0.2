package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;

/* renamed from: com.tencent.smtt.sdk.t */
/* loaded from: classes4.dex */
public class C1399t {

    /* renamed from: a */
    public DexLoader f2238a;

    public C1399t(DexLoader dexLoader) {
        this.f2238a = null;
        this.f2238a = dexLoader;
    }

    /* renamed from: a */
    public String m2374a(Context context) {
        Object newInstance;
        Object invokeMethod;
        DexLoader dexLoader = this.f2238a;
        return (dexLoader == null || (newInstance = dexLoader.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0])) == null || (invokeMethod = this.f2238a.invokeMethod(newInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "getCurWDPDecodeType", new Class[]{Context.class}, context)) == null) ? "" : String.valueOf(invokeMethod);
    }

    /* renamed from: a */
    public void m2373a(Context context, String str) {
        Object newInstance;
        DexLoader dexLoader = this.f2238a;
        if (dexLoader == null || (newInstance = dexLoader.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0])) == null) {
            return;
        }
        this.f2238a.invokeMethod(newInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "deleteVideoCache", new Class[]{Context.class, String.class}, context, str);
    }
}

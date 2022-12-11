package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.DexLoader;
import dalvik.system.DexClassLoader;

/* renamed from: com.tencent.smtt.sdk.w */
/* loaded from: classes4.dex */
public class C1415w {

    /* renamed from: a */
    public DexLoader f2336a;

    public C1415w(DexLoader dexLoader) {
        this.f2336a = null;
        this.f2336a = dexLoader;
    }

    /* renamed from: a */
    public Object m2298a(Context context) {
        DexLoader dexLoader = this.f2336a;
        return dexLoader.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new Class[]{Context.class, DexClassLoader.class}, context, dexLoader.getClassLoader());
    }

    /* renamed from: a */
    public void m2297a(Object obj) {
        this.f2336a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onUserStateChanged", new Class[0], new Object[0]);
    }

    /* renamed from: a */
    public void m2296a(Object obj, Activity activity, int i) {
        this.f2336a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[]{Activity.class, Integer.TYPE}, activity, Integer.valueOf(i));
    }

    /* renamed from: a */
    public boolean m2295a(Object obj, Bundle bundle, FrameLayout frameLayout, Object obj2) {
        DexLoader dexLoader = this.f2336a;
        Object invokeMethod = obj2 != null ? dexLoader.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[]{Bundle.class, FrameLayout.class, Object.class}, bundle, frameLayout, obj2) : dexLoader.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[]{Bundle.class, FrameLayout.class}, bundle, frameLayout);
        if (invokeMethod instanceof Boolean) {
            return ((Boolean) invokeMethod).booleanValue();
        }
        return false;
    }
}

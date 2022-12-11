package com.lzf.easyfloat.widget.appfloat;

import android.content.Context;
import com.lzf.easyfloat.EasyFloatMessageKt;
import com.lzf.easyfloat.data.FloatConfig;
import com.lzf.easyfloat.interfaces.OnFloatCallbacks;
import com.lzf.easyfloat.utils.Logger;
import com.stub.StubApp;
import com.umeng.analytics.pro.C1615d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.ni0;
import me.tvspark.of0;
import me.tvspark.pi0;

@ef0
/* loaded from: classes3.dex */
public final class FloatManager {
    public static final String DEFAULT_TAG = "default";
    public static final FloatManager INSTANCE = new FloatManager();
    public static final Map<String, AppFloatManager> floatMap = new LinkedHashMap();

    private final boolean checkTag(FloatConfig floatConfig) {
        floatConfig.setFloatTag(getTag(floatConfig.getFloatTag()));
        Map<String, AppFloatManager> map = floatMap;
        String floatTag = floatConfig.getFloatTag();
        if (floatTag != null) {
            return !map.containsKey(floatTag);
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    public static /* synthetic */ of0 dismiss$default(FloatManager floatManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return floatManager.dismiss(str);
    }

    public static /* synthetic */ of0 visible$default(FloatManager floatManager, boolean z, String str, boolean z2, int i, Object obj) {
        FloatConfig config;
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            AppFloatManager appFloatManager = floatMap.get(str);
            z2 = (appFloatManager == null || (config = appFloatManager.getConfig()) == null) ? true : config.getNeedShow$easyfloat_release();
        }
        return floatManager.visible(z, str, z2);
    }

    public final void create(Context context, FloatConfig floatConfig) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatConfig, "config");
        if (!checkTag(floatConfig)) {
            OnFloatCallbacks callbacks = floatConfig.getCallbacks();
            if (callbacks != null) {
                callbacks.createdResult(false, EasyFloatMessageKt.WARN_REPEATED_TAG, null);
            }
            Logger.INSTANCE.m3691w(EasyFloatMessageKt.WARN_REPEATED_TAG);
            return;
        }
        Map<String, AppFloatManager> map = floatMap;
        String floatTag = floatConfig.getFloatTag();
        if (floatTag == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) origApplicationContext, "context.applicationContext");
        AppFloatManager appFloatManager = new AppFloatManager(origApplicationContext, floatConfig);
        appFloatManager.createFloat();
        map.put(floatTag, appFloatManager);
    }

    public final of0 dismiss(String str) {
        AppFloatManager appFloatManager = floatMap.get(getTag(str));
        if (appFloatManager != null) {
            appFloatManager.exitAnim();
            return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    public final AppFloatManager getAppFloatManager(String str) {
        return floatMap.get(getTag(str));
    }

    public final Map<String, AppFloatManager> getFloatMap() {
        return floatMap;
    }

    public final String getTag(String str) {
        return str != null ? str : "default";
    }

    public final AppFloatManager remove(String str) {
        Map<String, AppFloatManager> map = floatMap;
        if (map != null) {
            if (!(map instanceof pi0)) {
                return map.remove(str);
            }
            ni0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map, "kotlin.collections.MutableMap");
            throw null;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    public final of0 visible(boolean z, String str, boolean z2) {
        AppFloatManager appFloatManager = floatMap.get(getTag(str));
        if (appFloatManager != null) {
            appFloatManager.setVisible(z ? 0 : 8, z2);
            return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return null;
    }
}

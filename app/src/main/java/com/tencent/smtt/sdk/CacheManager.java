package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.C1460i;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

@Deprecated
/* loaded from: classes4.dex */
public final class CacheManager {
    @Deprecated
    public static boolean cacheDisabled() {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            Object m2048a = C1460i.m2048a("android.webkit.CacheManager", "cacheDisabled");
            if (m2048a != null) {
                return ((Boolean) m2048a).booleanValue();
            }
            return false;
        }
        return ((Boolean) m2294a.m2289c().m2265c()).booleanValue();
    }

    public static InputStream getCacheFile(String str, boolean z) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            return null;
        }
        return m2294a.m2289c().m2275a(str, z);
    }

    public static Object getCacheFile(String str, Map<String, String> map) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            try {
                return C1460i.m2052a(Class.forName("android.webkit.CacheManager"), "getCacheFile", (Class<?>[]) new Class[]{String.class, Map.class}, str, map);
            } catch (Exception unused) {
                return null;
            }
        }
        return m2294a.m2289c().m2252g();
    }

    @Deprecated
    public static File getCacheFileBaseDir() {
        C1416x m2294a = C1416x.m2294a();
        return (File) ((m2294a == null || !m2294a.m2291b()) ? C1460i.m2048a("android.webkit.CacheManager", "getCacheFileBaseDir") : m2294a.m2289c().m2252g());
    }
}

package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;

/* loaded from: classes4.dex */
public class TbsVideoUtils {

    /* renamed from: a */
    public static C1399t f1966a;

    /* renamed from: a */
    public static void m2715a(Context context) {
        synchronized (TbsVideoUtils.class) {
            if (f1966a == null) {
                C1363g.m2597a(true).m2599a(context, false, false);
                C1414v m2601a = C1363g.m2597a(true).m2601a();
                DexLoader dexLoader = null;
                if (m2601a != null) {
                    dexLoader = m2601a.m2302b();
                }
                if (dexLoader != null) {
                    f1966a = new C1399t(dexLoader);
                }
            }
        }
    }

    public static void deleteVideoCache(Context context, String str) {
        m2715a(context);
        C1399t c1399t = f1966a;
        if (c1399t != null) {
            c1399t.m2373a(context, str);
        }
    }

    public static String getCurWDPDecodeType(Context context) {
        m2715a(context);
        C1399t c1399t = f1966a;
        return c1399t != null ? c1399t.m2374a(context) : "";
    }
}

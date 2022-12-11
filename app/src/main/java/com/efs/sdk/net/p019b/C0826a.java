package com.efs.sdk.net.p019b;

import java.util.Map;

/* renamed from: com.efs.sdk.net.b.a */
/* loaded from: classes3.dex */
public final class C0826a {
    /* renamed from: a */
    public static long m3940a(Map<String, Long> map, String str, String str2) {
        if (!map.containsKey(str) || !map.containsKey(str2)) {
            return 0L;
        }
        return map.get(str2).longValue() - map.get(str).longValue();
    }
}

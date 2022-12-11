package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.umeng.commonsdk.config.C1705d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class FieldManager {

    /* renamed from: a */
    public static final String f3741a = "cfgfd";

    /* renamed from: b */
    public static C1701b f3742b = C1701b.m780b();

    /* renamed from: c */
    public static boolean f3743c = false;

    /* renamed from: d */
    public static Object f3744d = new Object();

    /* renamed from: com.umeng.commonsdk.config.FieldManager$a */
    /* loaded from: classes4.dex */
    public static class C1699a {

        /* renamed from: a */
        public static final FieldManager f3745a = new FieldManager();
    }

    public FieldManager() {
    }

    /* renamed from: a */
    public static Pair<Long, String> m791a(String str) {
        Pair<Long, String> pair = new Pair<>(-1L, null);
        if (str != null && str.length() >= 2) {
            String[] split = str.split("@");
            if (split.length < 2) {
                return pair;
            }
            try {
                long parseLong = Long.parseLong(split[0]);
                return new Pair<>(Long.valueOf(parseLong), split[1]);
            } catch (Throwable unused) {
            }
        }
        return pair;
    }

    /* renamed from: a */
    public static FieldManager m794a() {
        return C1699a.f3745a;
    }

    public static boolean allow(String str) {
        synchronized (f3744d) {
            if (!f3743c) {
                return false;
            }
            return C1701b.m781a(str);
        }
    }

    /* renamed from: b */
    public static boolean m790b() {
        boolean z;
        synchronized (f3744d) {
            z = f3743c;
        }
        return z;
    }

    /* renamed from: a */
    public void m793a(Context context) {
        String str;
        String[] strArr = {C1705d.EnumC1706a.class.getName(), C1705d.EnumC1707b.class.getName(), C1705d.EnumC1708c.class.getName(), C1705d.EnumC1709d.class.getName()};
        String str2 = "1001@3758096383,2147483647,262143,2047";
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "cfgfd", str2);
        synchronized (f3744d) {
            Pair<Long, String> m791a = m791a(imprintProperty);
            if (((Long) m791a.first).longValue() > 1000 && (str = (String) m791a.second) != null && str.length() > 0) {
                str2 = str;
            }
            String[] split = str2.split(",");
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                C1712g c1712g = new C1712g();
                for (int i = 0; i < length; i++) {
                    arrayList.add(c1712g);
                    ((AbstractC1710e) arrayList.get(i)).mo775a(split[i], f3742b, C1705d.m777b(strArr[i]));
                }
            }
            f3743c = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004d, code lost:
        if (r12.length() > 0) goto L12;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m792a(Context context, String str) {
        String str2;
        String[] strArr = {C1705d.EnumC1706a.class.getName(), C1705d.EnumC1707b.class.getName(), C1705d.EnumC1708c.class.getName(), C1705d.EnumC1709d.class.getName()};
        synchronized (f3744d) {
            f3742b.m782a();
            if (str != null) {
                Pair<Long, String> m791a = m791a(str);
                if (((Long) m791a.first).longValue() > 1000) {
                    str2 = (String) m791a.second;
                    if (str2 != null) {
                    }
                }
            }
            str2 = "1001@3758096383,2147483647,262143,2047";
            String[] split = str2.split(",");
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                C1712g c1712g = new C1712g();
                for (int i = 0; i < length; i++) {
                    arrayList.add(c1712g);
                    ((AbstractC1710e) arrayList.get(i)).mo775a(split[i], f3742b, C1705d.m777b(strArr[i]));
                }
            }
            f3743c = true;
        }
    }
}

package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import me.tvspark.outline;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* renamed from: com.tencent.smtt.sdk.c */
/* loaded from: classes4.dex */
public class C1356c {

    /* renamed from: e */
    public static C1356c f2084e;

    /* renamed from: g */
    public static boolean f2085g;

    /* renamed from: a */
    public String f2086a = "EmergenceMsgPublisher";

    /* renamed from: b */
    public String f2087b = "tbs_emergence";

    /* renamed from: c */
    public String f2088c = "emergence_executed_ids";

    /* renamed from: d */
    public String f2089d = "emergence_ids";

    /* renamed from: f */
    public final Map<Integer, AbstractC1357a> f2090f = new LinkedHashMap();

    /* renamed from: com.tencent.smtt.sdk.c$a */
    /* loaded from: classes4.dex */
    public interface AbstractC1357a {
        /* renamed from: a */
        void mo1965a(String str);
    }

    /* renamed from: com.tencent.smtt.sdk.c$b */
    /* loaded from: classes4.dex */
    public static class C1358b {

        /* renamed from: a */
        public int f2091a = -1;

        /* renamed from: b */
        public int f2092b = -1;

        /* renamed from: c */
        public String f2093c = "";

        /* renamed from: d */
        public long f2094d = -1;

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("{seqId=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2091a);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", code=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2092b);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", extra='");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2093c);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", expired=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2094d);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* renamed from: a */
    public static C1356c m2620a() {
        if (f2084e == null) {
            f2084e = new C1356c();
        }
        return f2084e;
    }

    /* renamed from: a */
    private void m2618a(Context context, C1358b c1358b, AbstractC1357a abstractC1357a) {
        String[] split;
        if (abstractC1357a != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Executed command: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(c1358b.f2092b);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", extra: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(c1358b.f2093c);
            m2616a(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            abstractC1357a.mo1965a(c1358b.f2093c);
            SharedPreferences sharedPreferences = context.getSharedPreferences(this.f2087b, 4);
            String string = sharedPreferences.getString(this.f2088c, "");
            HashSet hashSet = new HashSet();
            if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null && split.length > 0) {
                try {
                    for (String str : split) {
                        hashSet.add(Integer.valueOf(Integer.parseInt(str)));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            hashSet.add(Integer.valueOf(c1358b.f2091a));
            StringBuilder sb = new StringBuilder();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                sb.append((Integer) it.next());
                sb.append(",");
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(this.f2088c, sb.toString());
            edit.commit();
        }
    }

    /* renamed from: a */
    private void m2616a(String str) {
    }

    /* renamed from: a */
    public Map<Integer, C1358b> m2619a(Context context) {
        String[] split;
        HashMap hashMap = new HashMap();
        SharedPreferences sharedPreferences = context.getSharedPreferences(this.f2087b, 0);
        String string = sharedPreferences.getString(this.f2089d, "");
        if (TextUtils.isEmpty(string)) {
            m2616a("Empty local emergence ids!");
            return hashMap;
        }
        m2616a(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Local emergence ids: ", string));
        String[] split2 = string.split(";");
        if (split2 != null) {
            for (String str : split2) {
                if (!TextUtils.isEmpty(str) && (split = str.split(",")) != null && split.length == 4) {
                    C1358b c1358b = new C1358b();
                    try {
                        c1358b.f2091a = Integer.parseInt(split[0]);
                        c1358b.f2092b = Integer.parseInt(split[1]);
                        c1358b.f2093c = String.valueOf(split[2]);
                        c1358b.f2094d = Long.parseLong(split[3]);
                    } catch (Throwable unused) {
                    }
                    if (System.currentTimeMillis() < c1358b.f2094d) {
                        hashMap.put(Integer.valueOf(c1358b.f2091a), c1358b);
                    }
                }
            }
        }
        String string2 = sharedPreferences.getString(this.f2088c, "");
        m2616a(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Executed ids: ", string2));
        String[] split3 = string2.split(",");
        if (split3 != null) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : split3) {
                if (!TextUtils.isEmpty(str2)) {
                    int i = -1;
                    try {
                        i = Integer.parseInt(str2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (i > 0) {
                        arrayList.add(Integer.valueOf(i));
                    }
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                hashMap.remove(arrayList.get(i2));
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public void m2617a(Context context, Integer num, AbstractC1357a abstractC1357a) {
        Map<Integer, C1358b> m2619a = m2619a(context);
        for (Integer num2 : m2619a.keySet()) {
            C1358b c1358b = m2619a.get(num2);
            if (c1358b == null) {
                m2616a("Unexpected null command!");
            } else if (c1358b.f2092b == num.intValue()) {
                m2618a(context, c1358b, abstractC1357a);
                return;
            }
        }
        if (!f2085g) {
            this.f2090f.put(num, abstractC1357a);
            m2616a("Emergence config did not arrived yet, code[" + num + "] has been suspended");
        }
    }

    /* renamed from: b */
    public void m2615b(Context context) {
        Map<Integer, C1358b> m2619a = m2619a(context);
        m2616a("On notify emergence, validate commands: " + m2619a);
        f2085g = true;
        for (Integer num : this.f2090f.keySet()) {
            for (Integer num2 : m2619a.keySet()) {
                if (m2619a.get(num2).f2092b == num.intValue()) {
                    m2618a(context, m2619a.get(num2), this.f2090f.get(num));
                }
            }
        }
        if (!this.f2090f.isEmpty()) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Emergency code[");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2090f.keySet());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("] did not happen, clear suspended queries");
            m2616a(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            this.f2090f.clear();
        }
    }
}

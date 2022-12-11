package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.C1082b;
import com.tencent.bugly.crashreport.AbstractC1129b;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.crashreport.common.info.a */
/* loaded from: classes3.dex */
public class C1140a {

    /* renamed from: a */
    public static C1140a f1003a;

    /* renamed from: F */
    public int f1009F;

    /* renamed from: G */
    public String f1010G;

    /* renamed from: b */
    public final Context f1031b;

    /* renamed from: c */
    public String f1033c;

    /* renamed from: e */
    public final String f1037e;

    /* renamed from: g */
    public String f1041g;

    /* renamed from: h */
    public final String f1043h;

    /* renamed from: ha */
    public boolean f1044ha;

    /* renamed from: i */
    public String f1045i;

    /* renamed from: p */
    public final String f1059p;

    /* renamed from: q */
    public String f1061q;

    /* renamed from: qa */
    public SharedPreferences f1062qa;

    /* renamed from: j */
    public boolean f1047j = true;

    /* renamed from: k */
    public final String f1049k = "com.tencent.bugly";

    /* renamed from: l */
    public String f1051l = "3.2.41(1.5.0)";

    /* renamed from: m */
    public final String f1053m = "";

    /* renamed from: r */
    public String f1063r = "unknown";

    /* renamed from: s */
    public String f1065s = "unknown";

    /* renamed from: t */
    public String f1067t = "";

    /* renamed from: u */
    public long f1069u = 0;

    /* renamed from: v */
    public String f1071v = null;

    /* renamed from: w */
    public long f1073w = -1;

    /* renamed from: x */
    public long f1075x = -1;

    /* renamed from: y */
    public long f1077y = -1;

    /* renamed from: z */
    public String f1078z = null;

    /* renamed from: A */
    public String f1004A = null;

    /* renamed from: B */
    public Map<String, PlugInBean> f1005B = null;

    /* renamed from: C */
    public boolean f1006C = true;

    /* renamed from: D */
    public String f1007D = null;

    /* renamed from: E */
    public String f1008E = null;

    /* renamed from: H */
    public String f1011H = null;

    /* renamed from: I */
    public String f1012I = null;

    /* renamed from: J */
    public Boolean f1013J = null;

    /* renamed from: K */
    public String f1014K = null;

    /* renamed from: L */
    public String f1015L = null;

    /* renamed from: M */
    public String f1016M = null;

    /* renamed from: N */
    public Map<String, PlugInBean> f1017N = null;

    /* renamed from: O */
    public Map<String, PlugInBean> f1018O = null;

    /* renamed from: P */
    public List<String> f1019P = null;

    /* renamed from: Q */
    public int f1020Q = -1;

    /* renamed from: R */
    public int f1021R = -1;

    /* renamed from: S */
    public Map<String, String> f1022S = new HashMap();

    /* renamed from: T */
    public Map<String, String> f1023T = new HashMap();

    /* renamed from: U */
    public Map<String, String> f1024U = new HashMap();

    /* renamed from: V */
    public boolean f1025V = true;

    /* renamed from: W */
    public String f1026W = "unknown";

    /* renamed from: X */
    public long f1027X = 0;

    /* renamed from: Y */
    public long f1028Y = 0;

    /* renamed from: Z */
    public long f1029Z = 0;

    /* renamed from: aa */
    public long f1030aa = 0;

    /* renamed from: ba */
    public boolean f1032ba = false;

    /* renamed from: ca */
    public String f1034ca = null;

    /* renamed from: da */
    public String f1036da = null;

    /* renamed from: ea */
    public String f1038ea = null;

    /* renamed from: fa */
    public String f1040fa = "";

    /* renamed from: ga */
    public boolean f1042ga = false;

    /* renamed from: ia */
    public Boolean f1046ia = null;

    /* renamed from: ja */
    public Boolean f1048ja = null;

    /* renamed from: ka */
    public HashMap<String, String> f1050ka = new HashMap<>();

    /* renamed from: la */
    public String f1052la = null;

    /* renamed from: ma */
    public String f1054ma = null;

    /* renamed from: na */
    public List<String> f1056na = new ArrayList();

    /* renamed from: oa */
    public boolean f1058oa = false;

    /* renamed from: pa */
    public AbstractC1129b f1060pa = null;

    /* renamed from: ra */
    public final Object f1064ra = new Object();

    /* renamed from: sa */
    public final Object f1066sa = new Object();

    /* renamed from: ta */
    public final Object f1068ta = new Object();

    /* renamed from: ua */
    public final Object f1070ua = new Object();

    /* renamed from: va */
    public final Object f1072va = new Object();

    /* renamed from: wa */
    public final Object f1074wa = new Object();

    /* renamed from: xa */
    public final Object f1076xa = new Object();

    /* renamed from: d */
    public final long f1035d = System.currentTimeMillis();

    /* renamed from: f */
    public final byte f1039f = 1;

    /* renamed from: n */
    public final String f1055n = C1141b.m3373d();

    /* renamed from: o */
    public final String f1057o = C1141b.m3369f();

    public C1140a(Context context) {
        this.f1010G = null;
        this.f1044ha = false;
        this.f1031b = C1208ca.m3044a(context);
        m3410c(context);
        this.f1041g = AppInfo.m3431d(context);
        this.f1043h = AppInfo.m3436a(context, Process.myPid());
        this.f1010G = AppInfo.m3437a(context);
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Android ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C1141b.m3358m());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",level ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C1141b.m3375c());
        this.f1059p = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        this.f1037e = this.f1057o + ";" + this.f1059p;
        m3415b(context);
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.f1044ha = true;
                C1199X.m3084a("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th) {
            if (C1082b.f703c) {
                th.printStackTrace();
            }
        }
        this.f1062qa = C1208ca.m3026a("BUGLY_COMMON_VALUES", context);
        C1199X.m3084a("com info create end", new Object[0]);
    }

    /* renamed from: a */
    public static synchronized C1140a m3421a(Context context) {
        C1140a c1140a;
        synchronized (C1140a.class) {
            if (f1003a == null) {
                f1003a = new C1140a(context);
            }
            c1140a = f1003a;
        }
        return c1140a;
    }

    /* renamed from: b */
    private void m3415b(Context context) {
        Map<String, String> m3433b = AppInfo.m3433b(context);
        if (m3433b == null) {
            return;
        }
        try {
            this.f1019P = AppInfo.m3434a(m3433b);
            String str = m3433b.get("BUGLY_APPID");
            if (str != null) {
                this.f1011H = str;
                m3419a("APP_ID", str);
            }
            String str2 = m3433b.get("BUGLY_APP_VERSION");
            if (str2 != null) {
                this.f1008E = str2;
            }
            String str3 = m3433b.get("BUGLY_APP_CHANNEL");
            if (str3 != null) {
                this.f1012I = str3;
            }
            String str4 = m3433b.get("BUGLY_ENABLE_DEBUG");
            if (str4 != null) {
                this.f1032ba = str4.equalsIgnoreCase("true");
            }
            String str5 = m3433b.get("com.tencent.rdm.uuid");
            if (str5 != null) {
                this.f1038ea = str5;
            }
            String str6 = m3433b.get("BUGLY_APP_BUILD_NO");
            if (!TextUtils.isEmpty(str6)) {
                this.f1009F = Integer.parseInt(str6);
            }
            String str7 = m3433b.get("BUGLY_AREA");
            if (str7 == null) {
                return;
            }
            this.f1040fa = str7;
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m3410c(Context context) {
        PackageInfo m3432c = AppInfo.m3432c(context);
        if (m3432c == null) {
            return;
        }
        try {
            String str = m3432c.versionName;
            this.f1008E = str;
            this.f1034ca = str;
            this.f1036da = Integer.toString(m3432c.versionCode);
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: m */
    public static synchronized C1140a m3394m() {
        C1140a c1140a;
        synchronized (C1140a.class) {
            c1140a = f1003a;
        }
        return c1140a;
    }

    /* renamed from: A */
    public int m3429A() {
        int i;
        synchronized (this.f1072va) {
            i = this.f1020Q;
        }
        return i;
    }

    /* renamed from: B */
    public boolean m3428B() {
        if (this.f1048ja == null) {
            this.f1048ja = Boolean.valueOf(C1141b.m3368f(this.f1031b));
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Does it has hook frame? ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f1048ja);
            C1199X.m3078c(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
        }
        return this.f1048ja.booleanValue();
    }

    /* renamed from: C */
    public boolean m3427C() {
        return this.f1025V;
    }

    /* renamed from: D */
    public boolean m3426D() {
        if (this.f1046ia == null) {
            this.f1046ia = Boolean.valueOf(C1141b.m3364h(this.f1031b));
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Is it a virtual machine? ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f1046ia);
            C1199X.m3078c(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
        }
        return this.f1046ia.booleanValue();
    }

    /* renamed from: E */
    public String m3425E() {
        try {
            Map<String, ?> all = this.f1031b.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.f1066sa) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        this.f1050ka.put(entry.getKey(), entry.getValue().toString());
                    }
                }
            }
        } catch (Throwable th) {
            C1199X.m3080b(th);
        }
        if (this.f1050ka.isEmpty()) {
            C1199X.m3084a("SDK_INFO is empty", new Object[0]);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry2 : this.f1050ka.entrySet()) {
            sb.append("[");
            sb.append(entry2.getKey());
            sb.append(",");
            sb.append(entry2.getValue());
            sb.append("] ");
        }
        C1199X.m3084a("SDK_INFO = %s", sb.toString());
        m3419a("SDK_INFO", sb.toString());
        return sb.toString();
    }

    /* renamed from: F */
    public void m3424F() {
        synchronized (this.f1064ra) {
            this.f1033c = UUID.randomUUID().toString();
        }
    }

    /* renamed from: a */
    public String m3420a(String str) {
        String str2;
        if (C1208ca.m3012b(str)) {
            C1199X.m3076e("key should not be empty %s", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", str));
            return null;
        }
        synchronized (this.f1068ta) {
            str2 = this.f1022S.get(str);
        }
        return str2;
    }

    /* renamed from: a */
    public void m3423a() {
        synchronized (this.f1068ta) {
            this.f1022S.clear();
        }
    }

    /* renamed from: a */
    public void m3422a(int i) {
        int i2 = this.f1021R;
        if (i2 != i) {
            this.f1021R = i;
            C1199X.m3078c("server scene tag %d changed to tag %d", Integer.valueOf(i2), Integer.valueOf(this.f1021R));
        }
    }

    /* renamed from: a */
    public void m3419a(String str, String str2) {
        if (C1208ca.m3012b(str) || C1208ca.m3012b(str2)) {
            C1199X.m3076e("server key&value should not be empty %s %s", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", str), outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", str2));
            return;
        }
        synchronized (this.f1070ua) {
            this.f1024U.put(str, str2);
        }
    }

    /* renamed from: a */
    public void m3418a(boolean z) {
        this.f1025V = z;
        AbstractC1129b abstractC1129b = this.f1060pa;
        if (abstractC1129b != null) {
            abstractC1129b.setNativeIsAppForeground(z);
        }
    }

    /* renamed from: b */
    public String m3414b(String str) {
        String remove;
        if (C1208ca.m3012b(str)) {
            C1199X.m3076e("key should not be empty %s", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", str));
            return null;
        }
        synchronized (this.f1068ta) {
            remove = this.f1022S.remove(str);
        }
        return remove;
    }

    /* renamed from: b */
    public Set<String> m3417b() {
        Set<String> keySet;
        synchronized (this.f1068ta) {
            keySet = this.f1022S.keySet();
        }
        return keySet;
    }

    /* renamed from: b */
    public void m3416b(int i) {
        synchronized (this.f1072va) {
            int i2 = this.f1020Q;
            if (i2 != i) {
                this.f1020Q = i;
                C1199X.m3078c("user scene tag %d changed to tag %d", Integer.valueOf(i2), Integer.valueOf(this.f1020Q));
            }
        }
    }

    /* renamed from: b */
    public void m3413b(String str, String str2) {
        if (C1208ca.m3012b(str) || C1208ca.m3012b(str2)) {
            C1199X.m3076e("key&value should not be empty %s %s", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", str), outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", str2));
            return;
        }
        synchronized (this.f1068ta) {
            this.f1022S.put(str, str2);
        }
    }

    /* renamed from: b */
    public void m3412b(boolean z) {
        this.f1006C = z;
    }

    /* renamed from: c */
    public String m3411c() {
        if (!this.f1006C) {
            return "";
        }
        if (this.f1071v == null) {
            this.f1071v = C1141b.m3379a(this.f1031b);
        }
        return this.f1071v;
    }

    /* renamed from: c */
    public void m3409c(String str) {
        this.f1011H = str;
        m3419a("APP_ID", str);
    }

    /* renamed from: c */
    public void m3408c(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        synchronized (this.f1066sa) {
            this.f1050ka.put(str, str2);
        }
    }

    /* renamed from: d */
    public int m3407d() {
        return C1141b.m3375c();
    }

    /* renamed from: d */
    public void m3406d(String str) {
        this.f1061q = str;
        synchronized (this.f1076xa) {
            this.f1023T.put("E8", str);
        }
    }

    /* renamed from: e */
    public String m3405e() {
        return !C1208ca.m3012b(this.f1045i) ? this.f1045i : this.f1011H;
    }

    /* renamed from: e */
    public synchronized void m3404e(String str) {
        this.f1065s = "" + str;
    }

    /* renamed from: f */
    public Map<String, String> m3403f() {
        synchronized (this.f1076xa) {
            if (this.f1023T.size() <= 0) {
                return null;
            }
            return new HashMap(this.f1023T);
        }
    }

    /* renamed from: f */
    public synchronized void m3402f(String str) {
        this.f1067t = "" + str;
    }

    /* renamed from: g */
    public Map<String, String> m3401g() {
        synchronized (this.f1070ua) {
            if (this.f1024U.size() <= 0) {
                return null;
            }
            return new HashMap(this.f1024U);
        }
    }

    /* renamed from: g */
    public void m3400g(String str) {
        synchronized (this.f1074wa) {
            if (str == null) {
                str = "10000";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(str);
            this.f1063r = sb.toString();
        }
    }

    /* renamed from: h */
    public Map<String, String> m3399h() {
        synchronized (this.f1068ta) {
            if (this.f1022S.size() <= 0) {
                return null;
            }
            return new HashMap(this.f1022S);
        }
    }

    /* renamed from: i */
    public String m3398i() {
        if (this.f1007D == null) {
            this.f1007D = C1141b.m3371e();
        }
        return this.f1007D;
    }

    /* renamed from: j */
    public String m3397j() {
        if (this.f1004A == null) {
            this.f1004A = C1141b.m3376b(this.f1031b);
        }
        return this.f1004A;
    }

    /* renamed from: k */
    public String m3396k() {
        if (this.f1078z == null) {
            this.f1078z = C1141b.m3378a(this.f1031b, true);
        }
        return this.f1078z;
    }

    /* renamed from: l */
    public String m3395l() {
        String str = this.f1061q;
        if (str != null) {
            return str;
        }
        String m3411c = m3411c();
        this.f1061q = m3411c;
        return m3411c;
    }

    /* renamed from: n */
    public Boolean m3393n() {
        if (this.f1013J == null) {
            this.f1013J = Boolean.valueOf(C1141b.m3354q());
        }
        return this.f1013J;
    }

    /* renamed from: o */
    public synchronized Map<String, PlugInBean> m3392o() {
        Map<String, PlugInBean> map;
        map = this.f1017N;
        Map<String, PlugInBean> map2 = this.f1018O;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    /* renamed from: p */
    public synchronized Map<String, PlugInBean> m3391p() {
        Map<String, PlugInBean> map = this.f1005B;
        if (map != null && map.size() > 0) {
            HashMap hashMap = new HashMap(this.f1005B.size());
            hashMap.putAll(this.f1005B);
            return hashMap;
        }
        return null;
    }

    /* renamed from: q */
    public synchronized String m3390q() {
        return this.f1067t;
    }

    /* renamed from: r */
    public String m3389r() {
        if (this.f1014K == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C1141b.m3372d(this.f1031b));
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            this.f1014K = sb;
            C1199X.m3078c("ROM ID: %s", sb);
        }
        return this.f1014K;
    }

    /* renamed from: s */
    public String m3388s() {
        return this.f1051l;
    }

    /* renamed from: t */
    public int m3387t() {
        return this.f1021R;
    }

    /* renamed from: u */
    public String m3386u() {
        String str;
        synchronized (this.f1064ra) {
            if (this.f1033c == null) {
                m3424F();
            }
            str = this.f1033c;
        }
        return str;
    }

    /* renamed from: v */
    public long m3385v() {
        if (this.f1075x <= 0) {
            this.f1075x = C1141b.m3363i();
        }
        return this.f1075x;
    }

    /* renamed from: w */
    public long m3384w() {
        if (this.f1073w <= 0) {
            this.f1073w = C1141b.m3360k();
        }
        return this.f1073w;
    }

    /* renamed from: x */
    public long m3383x() {
        if (this.f1077y <= 0) {
            this.f1077y = C1141b.m3359l();
        }
        return this.f1077y;
    }

    /* renamed from: y */
    public String m3382y() {
        String str;
        synchronized (this.f1074wa) {
            str = this.f1063r;
        }
        return str;
    }

    /* renamed from: z */
    public int m3381z() {
        int size;
        synchronized (this.f1068ta) {
            size = this.f1022S.size();
        }
        return size;
    }
}

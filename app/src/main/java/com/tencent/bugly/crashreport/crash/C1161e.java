package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.C1082b;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.C1145c;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.AbstractC1184I;
import com.tencent.bugly.proguard.AbstractC1228m;
import com.tencent.bugly.proguard.C1185J;
import com.tencent.bugly.proguard.C1188L;
import com.tencent.bugly.proguard.C1189M;
import com.tencent.bugly.proguard.C1195T;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import com.tencent.bugly.proguard.C1225ka;
import com.tencent.bugly.proguard.C1229ma;
import com.tencent.bugly.proguard.C1231na;
import com.tencent.bugly.proguard.C1233oa;
import com.tencent.bugly.proguard.C1235pa;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.crashreport.crash.e */
/* loaded from: classes3.dex */
public class C1161e {

    /* renamed from: a */
    public static int f1216a;

    /* renamed from: b */
    public final Context f1217b;

    /* renamed from: c */
    public final C1195T f1218c;

    /* renamed from: d */
    public final C1185J f1219d;

    /* renamed from: e */
    public final C1145c f1220e;

    /* renamed from: f */
    public AbstractC1174m f1221f;

    /* renamed from: g */
    public BuglyStrategy.C1080a f1222g;

    public C1161e(int i, Context context, C1195T c1195t, C1185J c1185j, C1145c c1145c, BuglyStrategy.C1080a c1080a, AbstractC1174m abstractC1174m) {
        f1216a = i;
        this.f1217b = context;
        this.f1218c = c1195t;
        this.f1219d = c1185j;
        this.f1220e = c1145c;
        this.f1222g = c1080a;
        this.f1221f = abstractC1174m;
    }

    /* renamed from: a */
    public static C1229ma m3294a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 == null || context == null) {
            C1199X.m3076e("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
            return null;
        }
        C1199X.m3084a("zip %s", str2);
        File file = new File(str2);
        File file2 = new File(context.getCacheDir(), str);
        if (!C1208ca.m3033a(file, file2, 5000)) {
            C1199X.m3076e("zip fail!", new Object[0]);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file2);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    byteArrayOutputStream.flush();
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                C1199X.m3084a("read bytes :%d", Integer.valueOf(byteArray.length));
                C1229ma c1229ma = new C1229ma((byte) 2, file2.getName(), byteArray);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    if (!C1199X.m3080b(e)) {
                        e.printStackTrace();
                    }
                }
                if (file2.exists()) {
                    C1199X.m3084a("del tmp", new Object[0]);
                    file2.delete();
                }
                return c1229ma;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!C1199X.m3080b(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            if (!C1199X.m3080b(e2)) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        C1199X.m3084a("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return null;
                } catch (Throwable th2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            if (!C1199X.m3080b(e3)) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        C1199X.m3084a("del tmp", new Object[0]);
                        file2.delete();
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    /* renamed from: a */
    public static C1231na m3300a(Context context, CrashDetailBean crashDetailBean, C1140a c1140a) {
        String str;
        C1229ma m3294a;
        C1229ma m3294a2;
        C1229ma c1229ma;
        boolean z = false;
        if (context == null || crashDetailBean == null || c1140a == null) {
            C1199X.m3076e("enExp args == null", new Object[0]);
            return null;
        }
        C1231na c1231na = new C1231na();
        int i = crashDetailBean.f1146b;
        switch (i) {
            case 0:
                str = crashDetailBean.f1154j ? "200" : "100";
                c1231na.f1552i = str;
                break;
            case 1:
                str = crashDetailBean.f1154j ? "201" : "101";
                c1231na.f1552i = str;
                break;
            case 2:
                str = crashDetailBean.f1154j ? "202" : "102";
                c1231na.f1552i = str;
                break;
            case 3:
                str = crashDetailBean.f1154j ? "203" : "103";
                c1231na.f1552i = str;
                break;
            case 4:
                str = crashDetailBean.f1154j ? "204" : "104";
                c1231na.f1552i = str;
                break;
            case 5:
                str = crashDetailBean.f1154j ? "207" : "107";
                c1231na.f1552i = str;
                break;
            case 6:
                str = crashDetailBean.f1154j ? "206" : "106";
                c1231na.f1552i = str;
                break;
            case 7:
                str = crashDetailBean.f1154j ? "208" : "108";
                c1231na.f1552i = str;
                break;
            default:
                C1199X.m3081b("crash type error! %d", Integer.valueOf(i));
                break;
        }
        c1231na.f1553j = crashDetailBean.f1162r;
        c1231na.f1554k = crashDetailBean.f1158n;
        c1231na.f1555l = crashDetailBean.f1159o;
        c1231na.f1556m = crashDetailBean.f1160p;
        c1231na.f1558o = crashDetailBean.f1161q;
        c1231na.f1559p = crashDetailBean.f1170z;
        c1231na.f1560q = crashDetailBean.f1147c;
        c1231na.f1561r = null;
        c1231na.f1563t = crashDetailBean.f1157m;
        c1231na.f1564u = crashDetailBean.f1149e;
        c1231na.f1557n = crashDetailBean.f1122B;
        c1231na.f1565v = null;
        C1199X.m3084a("libInfo %s", c1231na.f1566w);
        Map<String, PlugInBean> map = crashDetailBean.f1152h;
        if (map != null && map.size() > 0) {
            c1231na.f1567x = new ArrayList<>();
            for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f1152h.entrySet()) {
                C1225ka c1225ka = new C1225ka();
                c1225ka.f1525a = entry.getValue().f1000a;
                c1225ka.f1527c = entry.getValue().f1002c;
                c1225ka.f1529e = entry.getValue().f1001b;
                c1231na.f1567x.add(c1225ka);
            }
        }
        if (crashDetailBean.f1154j) {
            c1231na.f1562s = crashDetailBean.f1164t;
            String str2 = crashDetailBean.f1163s;
            if (str2 != null && str2.length() > 0) {
                if (c1231na.f1568y == null) {
                    c1231na.f1568y = new ArrayList<>();
                }
                try {
                    c1231na.f1568y.add(new C1229ma((byte) 1, "alltimes.txt", crashDetailBean.f1163s.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    c1231na.f1568y = null;
                }
            }
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(c1231na.f1562s);
            ArrayList<C1229ma> arrayList = c1231na.f1568y;
            objArr[1] = Integer.valueOf(arrayList != null ? arrayList.size() : 0);
            C1199X.m3084a("crashcount:%d sz:%d", objArr);
        }
        if (crashDetailBean.f1167w != null) {
            if (c1231na.f1568y == null) {
                c1231na.f1568y = new ArrayList<>();
            }
            try {
                c1231na.f1568y.add(new C1229ma((byte) 1, "log.txt", crashDetailBean.f1167w.getBytes("utf-8")));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                c1231na.f1568y = null;
            }
        }
        if (crashDetailBean.f1168x != null) {
            if (c1231na.f1568y == null) {
                c1231na.f1568y = new ArrayList<>();
            }
            try {
                c1231na.f1568y.add(new C1229ma((byte) 1, "jniLog.txt", crashDetailBean.f1168x.getBytes("utf-8")));
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                c1231na.f1568y = null;
            }
        }
        if (!C1208ca.m3012b(crashDetailBean.f1143W)) {
            if (c1231na.f1568y == null) {
                c1231na.f1568y = new ArrayList<>();
            }
            try {
                c1229ma = new C1229ma((byte) 1, "crashInfos.txt", crashDetailBean.f1143W.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
                c1229ma = null;
            }
            if (c1229ma != null) {
                C1199X.m3084a("attach crash infos", new Object[0]);
                c1231na.f1568y.add(c1229ma);
            }
        }
        if (crashDetailBean.f1144X != null) {
            if (c1231na.f1568y == null) {
                c1231na.f1568y = new ArrayList<>();
            }
            C1229ma m3294a3 = m3294a("backupRecord.zip", context, crashDetailBean.f1144X);
            if (m3294a3 != null) {
                C1199X.m3084a("attach backup record", new Object[0]);
                c1231na.f1568y.add(m3294a3);
            }
        }
        byte[] bArr = crashDetailBean.f1169y;
        if (bArr != null && bArr.length > 0) {
            C1229ma c1229ma2 = new C1229ma((byte) 2, "buglylog.zip", bArr);
            C1199X.m3084a("attach user log", new Object[0]);
            if (c1231na.f1568y == null) {
                c1231na.f1568y = new ArrayList<>();
            }
            c1231na.f1568y.add(c1229ma2);
        }
        if (crashDetailBean.f1146b == 3) {
            if (c1231na.f1568y == null) {
                c1231na.f1568y = new ArrayList<>();
            }
            C1199X.m3084a("crashBean.anrMessages:%s", crashDetailBean.f1137Q);
            Map<String, String> map2 = crashDetailBean.f1137Q;
            if (map2 != null && map2.containsKey("BUGLY_CR_01")) {
                try {
                    if (!TextUtils.isEmpty(crashDetailBean.f1137Q.get("BUGLY_CR_01"))) {
                        c1231na.f1568y.add(new C1229ma((byte) 1, "anrMessage.txt", crashDetailBean.f1137Q.get("BUGLY_CR_01").getBytes("utf-8")));
                        C1199X.m3084a("attach anr message", new Object[0]);
                    }
                } catch (UnsupportedEncodingException e5) {
                    e5.printStackTrace();
                    c1231na.f1568y = null;
                }
                crashDetailBean.f1137Q.remove("BUGLY_CR_01");
            }
            if (crashDetailBean.f1166v != null && NativeCrashHandler.getInstance().isEnableCatchAnrTrace() && (m3294a2 = m3294a("trace.zip", context, crashDetailBean.f1166v)) != null) {
                C1199X.m3084a("attach traces", new Object[0]);
                c1231na.f1568y.add(m3294a2);
            }
        }
        if (crashDetailBean.f1146b == 1) {
            if (c1231na.f1568y == null) {
                c1231na.f1568y = new ArrayList<>();
            }
            String str3 = crashDetailBean.f1166v;
            if (str3 != null && (m3294a = m3294a("tomb.zip", context, str3)) != null) {
                C1199X.m3084a("attach tombs", new Object[0]);
                c1231na.f1568y.add(m3294a);
            }
        }
        List<String> list = c1140a.f1056na;
        if (list != null && !list.isEmpty()) {
            if (c1231na.f1568y == null) {
                c1231na.f1568y = new ArrayList<>();
            }
            StringBuilder sb = new StringBuilder();
            for (String str4 : c1140a.f1056na) {
                sb.append(str4);
            }
            try {
                c1231na.f1568y.add(new C1229ma((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
                C1199X.m3084a("attach pageTracingList", new Object[0]);
            } catch (UnsupportedEncodingException e6) {
                e6.printStackTrace();
            }
        }
        byte[] bArr2 = crashDetailBean.f1142V;
        if (bArr2 != null && bArr2.length > 0) {
            if (c1231na.f1568y == null) {
                c1231na.f1568y = new ArrayList<>();
            }
            c1231na.f1568y.add(new C1229ma((byte) 1, "userExtraByteData", crashDetailBean.f1142V));
            C1199X.m3084a("attach extraData", new Object[0]);
        }
        HashMap hashMap = new HashMap();
        c1231na.f1569z = hashMap;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(crashDetailBean.f1123C);
        hashMap.put("A9", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        Map<String, String> map3 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(crashDetailBean.f1124D);
        map3.put("A11", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        Map<String, String> map4 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(crashDetailBean.f1125E);
        map4.put("A10", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
        Map<String, String> map5 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(crashDetailBean.f1150f);
        map5.put("A23", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
        Map<String, String> map6 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(c1140a.f1055n);
        map6.put("A7", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
        Map<String, String> map7 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append(c1140a.m3397j());
        map7.put("A6", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.toString());
        Map<String, String> map8 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.append(c1140a.m3396k());
        map8.put("A5", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.toString());
        Map<String, String> map9 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.append(c1140a.m3395l());
        map9.put("A22", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.toString());
        Map<String, String> map10 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.append(crashDetailBean.f1127G);
        map10.put("A2", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.toString());
        Map<String, String> map11 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10.append(crashDetailBean.f1126F);
        map11.put("A1", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10.toString());
        Map<String, String> map12 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11.append(c1140a.f1059p);
        map12.put("A24", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11.toString());
        Map<String, String> map13 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12.append(crashDetailBean.f1128H);
        map13.put("A17", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12.toString());
        Map<String, String> map14 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13.append(c1140a.m3395l());
        map14.put("A25", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13.toString());
        Map<String, String> map15 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14.append(c1140a.m3398i());
        map15.put("A15", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14.toString());
        Map<String, String> map16 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15.append(c1140a.m3393n());
        map16.put("A13", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15.toString());
        Map<String, String> map17 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16.append(crashDetailBean.f1121A);
        map17.put("A34", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16.toString());
        if (c1140a.f1038ea != null) {
            Map<String, String> map18 = c1231na.f1569z;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17.append(c1140a.f1038ea);
            map18.put("productIdentify", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17.toString());
        }
        try {
            c1231na.f1569z.put("A26", "" + URLEncoder.encode(crashDetailBean.f1129I, "utf-8"));
        } catch (UnsupportedEncodingException e7) {
            e7.printStackTrace();
        }
        if (crashDetailBean.f1146b == 1) {
            Map<String, String> map19 = c1231na.f1569z;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18.append(crashDetailBean.f1132L);
            map19.put("A27", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww18.toString());
            Map<String, String> map20 = c1231na.f1569z;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19.append(crashDetailBean.f1131K);
            map20.put("A28", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww19.toString());
            Map<String, String> map21 = c1231na.f1569z;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20.append(crashDetailBean.f1155k);
            map21.put("A29", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww20.toString());
        }
        Map<String, String> map22 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww21 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww21.append(crashDetailBean.f1133M);
        map22.put("A30", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww21.toString());
        Map<String, String> map23 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.append(crashDetailBean.f1134N);
        map23.put("A18", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww22.toString());
        Map<String, String> map24 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23.append(!crashDetailBean.f1135O);
        map24.put("A36", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww23.toString());
        Map<String, String> map25 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww24 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww24.append(c1140a.f1027X);
        map25.put("F02", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww24.toString());
        Map<String, String> map26 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww25 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww25.append(c1140a.f1028Y);
        map26.put("F03", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww25.toString());
        Map<String, String> map27 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww26 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww26.append(c1140a.m3386u());
        map27.put("F04", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww26.toString());
        Map<String, String> map28 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww27 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww27.append(c1140a.f1029Z);
        map28.put("F05", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww27.toString());
        Map<String, String> map29 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww28 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww28.append(c1140a.f1026W);
        map29.put("F06", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww28.toString());
        Map<String, String> map30 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww29 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww29.append(c1140a.f1034ca);
        map30.put("F08", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww29.toString());
        Map<String, String> map31 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww30 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww30.append(c1140a.f1036da);
        map31.put("F09", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww30.toString());
        Map<String, String> map32 = c1231na.f1569z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww31 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww31.append(c1140a.f1030aa);
        map32.put("F10", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww31.toString());
        if (crashDetailBean.f1138R >= 0) {
            Map<String, String> map33 = c1231na.f1569z;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.append(crashDetailBean.f1138R);
            map33.put("C01", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.toString());
        }
        if (crashDetailBean.f1139S >= 0) {
            Map<String, String> map34 = c1231na.f1569z;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww33 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww33.append(crashDetailBean.f1139S);
            map34.put("C02", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww33.toString());
        }
        Map<String, String> map35 = crashDetailBean.f1140T;
        if (map35 != null && map35.size() > 0) {
            for (Map.Entry<String, String> entry2 : crashDetailBean.f1140T.entrySet()) {
                Map<String, String> map36 = c1231na.f1569z;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww34 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("C03_");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww34.append(entry2.getKey());
                map36.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww34.toString(), entry2.getValue());
            }
        }
        Map<String, String> map37 = crashDetailBean.f1141U;
        if (map37 != null && map37.size() > 0) {
            for (Map.Entry<String, String> entry3 : crashDetailBean.f1141U.entrySet()) {
                Map<String, String> map38 = c1231na.f1569z;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww35 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("C04_");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww35.append(entry3.getKey());
                map38.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww35.toString(), entry3.getValue());
            }
        }
        c1231na.f1549A = null;
        Map<String, String> map39 = crashDetailBean.f1136P;
        if (map39 != null && map39.size() > 0) {
            Map<String, String> map40 = crashDetailBean.f1136P;
            c1231na.f1549A = map40;
            C1199X.m3078c("setted message size %d", Integer.valueOf(map40.size()));
        }
        Object[] objArr2 = new Object[12];
        objArr2[0] = crashDetailBean.f1158n;
        objArr2[1] = crashDetailBean.f1147c;
        objArr2[2] = c1140a.m3386u();
        objArr2[3] = Long.valueOf((crashDetailBean.f1162r - crashDetailBean.f1134N) / 1000);
        objArr2[4] = Boolean.valueOf(crashDetailBean.f1155k);
        objArr2[5] = Boolean.valueOf(crashDetailBean.f1135O);
        objArr2[6] = Boolean.valueOf(crashDetailBean.f1154j);
        if (crashDetailBean.f1146b == 1) {
            z = true;
        }
        objArr2[7] = Boolean.valueOf(z);
        objArr2[8] = Integer.valueOf(crashDetailBean.f1164t);
        objArr2[9] = crashDetailBean.f1163s;
        objArr2[10] = Boolean.valueOf(crashDetailBean.f1148d);
        objArr2[11] = Integer.valueOf(c1231na.f1569z.size());
        C1199X.m3084a("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr2);
        return c1231na;
    }

    /* renamed from: a */
    public static C1233oa m3299a(Context context, List<CrashDetailBean> list, C1140a c1140a) {
        if (context == null || list == null || list.size() == 0 || c1140a == null) {
            C1199X.m3076e("enEXPPkg args == null!", new Object[0]);
            return null;
        }
        C1233oa c1233oa = new C1233oa();
        c1233oa.f1571b = new ArrayList<>();
        for (CrashDetailBean crashDetailBean : list) {
            c1233oa.f1571b.add(m3300a(context, crashDetailBean, c1140a));
        }
        return c1233oa;
    }

    /* renamed from: a */
    public static void m3293a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String sb;
        C1140a m3394m = C1140a.m3394m();
        if (m3394m == null) {
            return;
        }
        C1199X.m3081b("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        C1199X.m3081b("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        C1199X.m3081b("# PKG NAME: %s", m3394m.f1041g);
        C1199X.m3081b("# APP VER: %s", m3394m.f1008E);
        C1199X.m3081b("# SDK VER: %s", m3394m.f1051l);
        C1199X.m3081b("# LAUNCH TIME: %s", C1208ca.m3022a(new Date(C1140a.m3394m().f1035d)));
        C1199X.m3081b("# CRASH TYPE: %s", str);
        C1199X.m3081b("# CRASH TIME: %s", str2);
        C1199X.m3081b("# CRASH PROCESS: %s", str3);
        C1199X.m3081b("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            C1199X.m3081b("# REPORT ID: %s", crashDetailBean.f1147c);
            Object[] objArr = new Object[2];
            objArr[0] = m3394m.f1057o;
            objArr[1] = m3394m.m3393n().booleanValue() ? "ROOTED" : "UNROOT";
            C1199X.m3081b("# CRASH DEVICE: %s %s", objArr);
            C1199X.m3081b("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f1123C), Long.valueOf(crashDetailBean.f1124D), Long.valueOf(crashDetailBean.f1125E));
            C1199X.m3081b("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f1126F), Long.valueOf(crashDetailBean.f1127G), Long.valueOf(crashDetailBean.f1128H));
            if (!C1208ca.m3012b(crashDetailBean.f1132L)) {
                C1199X.m3081b("# EXCEPTION FIRED BY %s %s", crashDetailBean.f1132L, crashDetailBean.f1131K);
            } else if (crashDetailBean.f1146b == 3) {
                Object[] objArr2 = new Object[1];
                if (crashDetailBean.f1137Q == null) {
                    sb = "null";
                } else {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(crashDetailBean.f1137Q.get("BUGLY_CR_01"));
                    sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                }
                objArr2[0] = sb;
                C1199X.m3081b("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!C1208ca.m3012b(str5)) {
            C1199X.m3081b("# CRASH STACK: ", new Object[0]);
            C1199X.m3081b(str5, new Object[0]);
        }
        C1199X.m3081b("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }

    /* renamed from: f */
    private boolean m3279f(CrashDetailBean crashDetailBean) {
        try {
            C1199X.m3084a("save eup logs", new Object[0]);
            C1140a m3394m = C1140a.m3394m();
            String m3405e = m3394m.m3405e();
            String str = m3394m.f1008E;
            String str2 = crashDetailBean.f1121A;
            String format = String.format(Locale.US, "#--------\npackage:%s\nversion:%s\nsdk:%s\nprocess:%s\ndate:%s\ntype:%s\nmessage:%s\nstack:\n%s\neupID:%s\n", m3405e, str, m3394m.f1051l, str2, C1208ca.m3022a(new Date(crashDetailBean.f1162r)), crashDetailBean.f1158n, crashDetailBean.f1159o, crashDetailBean.f1161q, crashDetailBean.f1147c);
            String str3 = null;
            if (C1164h.f1240j != null) {
                File file = new File(C1164h.f1240j);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                str3 = file.getAbsolutePath();
            } else if (Environment.getExternalStorageState().equals("mounted")) {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                StringBuilder sb = new StringBuilder();
                sb.append(absolutePath);
                sb.append("/Tencent/");
                sb.append(this.f1217b.getPackageName());
                str3 = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append("/euplog.txt");
            C1208ca.m3040a(this.f1217b, sb2.toString(), format, C1164h.f1241k);
            return true;
        } catch (Throwable th) {
            C1199X.m3076e("rqdp{  save error} %s", th.toString());
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: a */
    public ContentValues m3297a(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.f1145a > 0) {
                contentValues.put("_id", Long.valueOf(crashDetailBean.f1145a));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f1162r));
            contentValues.put("_s1", crashDetailBean.f1165u);
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f1148d ? 1 : 0));
            contentValues.put("_me", Integer.valueOf(crashDetailBean.f1154j ? 1 : 0));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f1156l));
            contentValues.put("_dt", C1208ca.m3036a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public CrashDetailBean m3290a(List<C1158b> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> m3292a;
        String[] split;
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (C1158b c1158b : list) {
            if (c1158b.f1212e) {
                arrayList.add(c1158b);
            }
        }
        if (arrayList.size() > 0 && (m3292a = m3292a(arrayList)) != null && m3292a.size() > 0) {
            Collections.sort(m3292a);
            for (int i = 0; i < m3292a.size(); i++) {
                CrashDetailBean crashDetailBean3 = m3292a.get(i);
                if (i == 0) {
                    crashDetailBean2 = crashDetailBean3;
                } else {
                    String str = crashDetailBean3.f1163s;
                    if (str != null && (split = str.split("\n")) != null) {
                        for (String str2 : split) {
                            if (!crashDetailBean2.f1163s.contains("" + str2)) {
                                crashDetailBean2.f1164t++;
                                crashDetailBean2.f1163s = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), crashDetailBean2.f1163s, str2, "\n");
                            }
                        }
                    }
                }
            }
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f1154j = true;
            crashDetailBean.f1164t = 0;
            crashDetailBean.f1163s = "";
            crashDetailBean2 = crashDetailBean;
        }
        for (C1158b c1158b2 : list) {
            if (!c1158b2.f1212e && !c1158b2.f1211d) {
                String str3 = crashDetailBean2.f1163s;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(c1158b2.f1209b);
                if (!str3.contains(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString())) {
                    crashDetailBean2.f1164t++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(crashDetailBean2.f1163s);
                    crashDetailBean2.f1163s = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, c1158b2.f1209b, "\n");
                }
            }
        }
        if (crashDetailBean2.f1162r != crashDetailBean.f1162r) {
            String str4 = crashDetailBean2.f1163s;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(crashDetailBean.f1162r);
            if (!str4.contains(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString())) {
                crashDetailBean2.f1164t++;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(crashDetailBean2.f1163s);
                crashDetailBean2.f1163s = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, crashDetailBean.f1162r, "\n");
            }
        }
        return crashDetailBean2;
    }

    /* renamed from: a */
    public C1158b m3298a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C1158b c1158b = new C1158b();
            c1158b.f1208a = cursor.getLong(cursor.getColumnIndex("_id"));
            c1158b.f1209b = cursor.getLong(cursor.getColumnIndex("_tm"));
            c1158b.f1210c = cursor.getString(cursor.getColumnIndex("_s1"));
            boolean z = false;
            c1158b.f1211d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            if (cursor.getInt(cursor.getColumnIndex("_me")) == 1) {
                z = true;
            }
            c1158b.f1212e = z;
            c1158b.f1213f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return c1158b;
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public List<C1158b> m3302a() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = C1185J.m3172a().m3152a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                if (cursor.getCount() < 1) {
                    cursor.close();
                    return arrayList;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("_id");
                sb.append(" in ");
                sb.append("(");
                int i = 0;
                while (cursor.moveToNext()) {
                    try {
                        C1158b m3298a = m3298a(cursor);
                        if (m3298a != null) {
                            arrayList.add(m3298a);
                        } else {
                            sb.append(cursor.getLong(cursor.getColumnIndex("_id")));
                            sb.append(",");
                            i++;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor;
                        try {
                            if (!C1199X.m3080b(th)) {
                                th.printStackTrace();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return arrayList;
                        } finally {
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    }
                }
                if (sb.toString().contains(",")) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(")");
                String sb2 = sb.toString();
                sb.setLength(0);
                if (i > 0) {
                    int m3153a = C1185J.m3172a().m3153a("t_cr", sb2, (String[]) null, (AbstractC1184I) null, true);
                    Object[] objArr = new Object[2];
                    objArr[0] = "t_cr";
                    objArr[1] = Integer.valueOf(m3153a);
                    C1199X.m3076e("deleted %s illegal data %d", objArr);
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: a */
    public List<CrashDetailBean> m3292a(List<C1158b> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("_id", " in ", "(");
        for (C1158b c1158b : list) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(c1158b.f1208a);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().contains(",")) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new StringBuilder(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.substring(0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.lastIndexOf(",")));
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setLength(0);
        try {
            cursor = C1185J.m3172a().m3152a("t_cr", null, sb, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("_id");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" in ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("(");
                int i = 0;
                while (cursor.moveToNext()) {
                    try {
                        CrashDetailBean m3287b = m3287b(cursor);
                        if (m3287b != null) {
                            arrayList.add(m3287b);
                        } else {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cursor.getLong(cursor.getColumnIndex("_id")));
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
                            i++;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            if (!C1199X.m3080b(th)) {
                                th.printStackTrace();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        } finally {
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    }
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().contains(",")) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new StringBuilder(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.substring(0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.lastIndexOf(",")));
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
                String sb2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                if (i > 0) {
                    int m3153a = C1185J.m3172a().m3153a("t_cr", sb2, (String[]) null, (AbstractC1184I) null, true);
                    Object[] objArr = new Object[2];
                    objArr[0] = "t_cr";
                    objArr[1] = Integer.valueOf(m3153a);
                    C1199X.m3076e("deleted %s illegal data %d", objArr);
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* renamed from: a */
    public void m3301a(int i) {
        if (i <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id");
        sb.append(" in ");
        sb.append("(");
        sb.append("SELECT ");
        sb.append("_id");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, " FROM ", "t_cr", " order by ", "_id");
        sb.append(" limit ");
        sb.append(i);
        sb.append(")");
        String sb2 = sb.toString();
        sb.setLength(0);
        try {
            C1199X.m3084a("deleted first record %s data %d", "t_cr", Integer.valueOf(C1185J.m3172a().m3153a("t_cr", sb2, (String[]) null, (AbstractC1184I) null, true)));
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m3295a(CrashDetailBean crashDetailBean, long j, boolean z) {
        if (C1164h.f1242l) {
            C1199X.m3078c("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            m3291a(arrayList, j, z, crashDetailBean.f1146b == 7, z);
        }
    }

    /* renamed from: a */
    public void m3291a(List<CrashDetailBean> list, long j, boolean z, boolean z2, boolean z3) {
        C1195T c1195t;
        if (C1140a.m3421a(this.f1217b).f1047j && (c1195t = this.f1218c) != null) {
            if (!z3 && !c1195t.m3118a(C1164h.f1231a)) {
                return;
            }
            StrategyBean m3342c = this.f1220e.m3342c();
            if (!m3342c.f1089f) {
                C1199X.m3076e("remote report is disable!", new Object[0]);
                C1199X.m3077d("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
            } else if (list == null || list.size() == 0) {
            } else {
                try {
                    String str = m3342c.f1101r;
                    String str2 = StrategyBean.f1085b;
                    C1233oa m3299a = m3299a(this.f1217b, list, C1140a.m3394m());
                    if (m3299a == null) {
                        C1199X.m3076e("create eupPkg fail!", new Object[0]);
                        return;
                    }
                    byte[] m3134a = C1189M.m3134a((AbstractC1228m) m3299a);
                    if (m3134a == null) {
                        C1199X.m3076e("send encode fail!", new Object[0]);
                        return;
                    }
                    C1235pa m3136a = C1189M.m3136a(this.f1217b, 830, m3134a);
                    if (m3136a == null) {
                        C1199X.m3076e("request package is null.", new Object[0]);
                        return;
                    }
                    C1160d c1160d = new C1160d(this, list);
                    if (z) {
                        this.f1218c.m3113a(f1216a, m3136a, str, str2, c1160d, j, z2);
                    } else {
                        this.f1218c.m3112a(f1216a, m3136a, str, str2, c1160d, false);
                    }
                } catch (Throwable th) {
                    C1199X.m3081b("req cr error %s", th.toString());
                    if (C1199X.m3083a(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public void m3289a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            C1199X.m3084a("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                C1199X.m3084a("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f1147c, Integer.valueOf(crashDetailBean.f1156l), Boolean.valueOf(crashDetailBean.f1148d), Boolean.valueOf(crashDetailBean.f1154j));
                int i = crashDetailBean.f1156l + 1;
                crashDetailBean.f1156l = i;
                crashDetailBean.f1148d = z;
                C1199X.m3084a("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f1147c, Integer.valueOf(i), Boolean.valueOf(crashDetailBean.f1148d), Boolean.valueOf(crashDetailBean.f1154j));
            }
            for (CrashDetailBean crashDetailBean2 : list) {
                C1164h.m3262g().m3273a(crashDetailBean2);
            }
            C1199X.m3084a("update state size %d", Integer.valueOf(list.size()));
        }
        if (!z) {
            C1199X.m3077d("[crash] upload fail.", new Object[0]);
        }
    }

    /* renamed from: a */
    public boolean m3296a(CrashDetailBean crashDetailBean, int i) {
        if (crashDetailBean == null) {
            return true;
        }
        String str = C1164h.f1244n;
        if (str != null && !str.isEmpty()) {
            C1199X.m3084a("Crash filter for crash stack is: %s", C1164h.f1244n);
            if (crashDetailBean.f1161q.contains(C1164h.f1244n)) {
                C1199X.m3076e("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        String str2 = C1164h.f1245o;
        if (str2 != null && !str2.isEmpty()) {
            C1199X.m3084a("Crash regular filter for crash stack is: %s", C1164h.f1245o);
            if (Pattern.compile(C1164h.f1245o).matcher(crashDetailBean.f1161q).find()) {
                C1199X.m3076e("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (crashDetailBean.f1146b != 2) {
            C1188L c1188l = new C1188L();
            c1188l.f1399b = 1;
            c1188l.f1400c = crashDetailBean.f1121A;
            c1188l.f1401d = crashDetailBean.f1122B;
            c1188l.f1402e = crashDetailBean.f1162r;
            this.f1219d.m3148b(1);
            this.f1219d.m3144c(c1188l);
            C1199X.m3077d("[crash] a crash occur, handling...", new Object[0]);
        } else {
            C1199X.m3077d("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<C1158b> m3302a = m3302a();
        ArrayList arrayList = null;
        if (m3302a != null && m3302a.size() > 0) {
            arrayList = new ArrayList(10);
            ArrayList arrayList2 = new ArrayList(10);
            arrayList.addAll(m3285b(m3302a));
            m3302a.removeAll(arrayList);
            if (m3302a.size() > 20) {
                m3301a(5);
            }
            if (!C1082b.f703c && C1164h.f1234d) {
                boolean z = false;
                for (C1158b c1158b : m3302a) {
                    if (crashDetailBean.f1165u.equals(c1158b.f1210c)) {
                        if (c1158b.f1212e) {
                            z = true;
                        }
                        arrayList2.add(c1158b);
                    }
                }
                if (z || arrayList2.size() >= C1164h.f1233c) {
                    C1199X.m3078c("same crash occur too much do merged!", new Object[0]);
                    CrashDetailBean m3290a = m3290a(arrayList2, crashDetailBean);
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        C1158b c1158b2 = (C1158b) it.next();
                        if (c1158b2.f1208a != m3290a.f1145a) {
                            arrayList.add(c1158b2);
                        }
                    }
                    m3280e(m3290a);
                    m3283c(arrayList);
                    C1199X.m3077d("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
                    return true;
                }
            }
        }
        m3280e(crashDetailBean);
        if (arrayList != null && !arrayList.isEmpty()) {
            m3283c(arrayList);
        }
        C1199X.m3077d("[crash] save crash success", new Object[0]);
        return false;
    }

    /* renamed from: b */
    public CrashDetailBean m3287b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) C1208ca.m3019a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f1145a = j;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: b */
    public List<CrashDetailBean> m3288b() {
        StrategyBean m3342c = C1145c.m3344b().m3342c();
        if (m3342c == null) {
            C1199X.m3076e("have not synced remote!", new Object[0]);
            return null;
        } else if (!m3342c.f1089f) {
            C1199X.m3076e("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            C1199X.m3077d("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long m3018b = C1208ca.m3018b();
            List<C1158b> m3302a = m3302a();
            C1199X.m3084a("Size of crash list loaded from DB: %s", Integer.valueOf(m3302a.size()));
            if (m3302a.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(m3285b(m3302a));
            m3302a.removeAll(arrayList);
            Iterator<C1158b> it = m3302a.iterator();
            while (it.hasNext()) {
                C1158b next = it.next();
                long j = next.f1209b;
                if (j >= m3018b - C1164h.f1237g) {
                    if (next.f1211d) {
                        if (j >= currentTimeMillis - 86400000) {
                            it.remove();
                        } else if (!next.f1212e) {
                        }
                    } else if (next.f1213f >= 3 && j < currentTimeMillis - 86400000) {
                    }
                }
                it.remove();
                arrayList.add(next);
            }
            if (arrayList.size() > 0) {
                m3283c(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            List<CrashDetailBean> m3292a = m3292a(m3302a);
            if (m3292a != null && m3292a.size() > 0) {
                String str = C1140a.m3394m().f1008E;
                Iterator<CrashDetailBean> it2 = m3292a.iterator();
                while (it2.hasNext()) {
                    CrashDetailBean next2 = it2.next();
                    if (!str.equals(next2.f1150f)) {
                        it2.remove();
                        arrayList2.add(next2);
                    }
                }
            }
            if (arrayList2.size() > 0) {
                m3281d(arrayList2);
            }
            return m3292a;
        }
    }

    /* renamed from: b */
    public List<C1158b> m3285b(List<C1158b> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (C1158b c1158b : list) {
            if (c1158b.f1211d && c1158b.f1209b <= currentTimeMillis - 86400000) {
                arrayList.add(c1158b);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public boolean m3286b(CrashDetailBean crashDetailBean) {
        return m3296a(crashDetailBean, -123456789);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d9 A[Catch: all -> 0x024a, TryCatch #0 {all -> 0x024a, blocks: (B:12:0x0012, B:13:0x0015, B:16:0x0066, B:19:0x006d, B:23:0x0080, B:25:0x008c, B:27:0x00aa, B:29:0x00b1, B:32:0x00d9, B:34:0x00df, B:35:0x00f2, B:37:0x00f8, B:40:0x010b, B:42:0x0119, B:44:0x011f, B:45:0x012c, B:47:0x0138, B:49:0x0144, B:51:0x015b, B:52:0x0180, B:54:0x0187, B:57:0x0169, B:59:0x0170, B:65:0x019c, B:68:0x01a7, B:69:0x01df, B:71:0x01e3, B:74:0x01e8, B:76:0x0202, B:77:0x020e, B:80:0x0214, B:83:0x0244, B:88:0x01c4, B:91:0x01cc, B:94:0x00b5, B:97:0x00c1, B:99:0x001b, B:102:0x0027, B:105:0x0033, B:108:0x003f, B:112:0x004d, B:116:0x005a), top: B:11:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f8 A[Catch: all -> 0x024a, TryCatch #0 {all -> 0x024a, blocks: (B:12:0x0012, B:13:0x0015, B:16:0x0066, B:19:0x006d, B:23:0x0080, B:25:0x008c, B:27:0x00aa, B:29:0x00b1, B:32:0x00d9, B:34:0x00df, B:35:0x00f2, B:37:0x00f8, B:40:0x010b, B:42:0x0119, B:44:0x011f, B:45:0x012c, B:47:0x0138, B:49:0x0144, B:51:0x015b, B:52:0x0180, B:54:0x0187, B:57:0x0169, B:59:0x0170, B:65:0x019c, B:68:0x01a7, B:69:0x01df, B:71:0x01e3, B:74:0x01e8, B:76:0x0202, B:77:0x020e, B:80:0x0214, B:83:0x0244, B:88:0x01c4, B:91:0x01cc, B:94:0x00b5, B:97:0x00c1, B:99:0x001b, B:102:0x0027, B:105:0x0033, B:108:0x003f, B:112:0x004d, B:116:0x005a), top: B:11:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e3 A[Catch: all -> 0x024a, TRY_LEAVE, TryCatch #0 {all -> 0x024a, blocks: (B:12:0x0012, B:13:0x0015, B:16:0x0066, B:19:0x006d, B:23:0x0080, B:25:0x008c, B:27:0x00aa, B:29:0x00b1, B:32:0x00d9, B:34:0x00df, B:35:0x00f2, B:37:0x00f8, B:40:0x010b, B:42:0x0119, B:44:0x011f, B:45:0x012c, B:47:0x0138, B:49:0x0144, B:51:0x015b, B:52:0x0180, B:54:0x0187, B:57:0x0169, B:59:0x0170, B:65:0x019c, B:68:0x01a7, B:69:0x01df, B:71:0x01e3, B:74:0x01e8, B:76:0x0202, B:77:0x020e, B:80:0x0214, B:83:0x0244, B:88:0x01c4, B:91:0x01cc, B:94:0x00b5, B:97:0x00c1, B:99:0x001b, B:102:0x0027, B:105:0x0033, B:108:0x003f, B:112:0x004d, B:116:0x005a), top: B:11:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c4 A[Catch: all -> 0x024a, TRY_LEAVE, TryCatch #0 {all -> 0x024a, blocks: (B:12:0x0012, B:13:0x0015, B:16:0x0066, B:19:0x006d, B:23:0x0080, B:25:0x008c, B:27:0x00aa, B:29:0x00b1, B:32:0x00d9, B:34:0x00df, B:35:0x00f2, B:37:0x00f8, B:40:0x010b, B:42:0x0119, B:44:0x011f, B:45:0x012c, B:47:0x0138, B:49:0x0144, B:51:0x015b, B:52:0x0180, B:54:0x0187, B:57:0x0169, B:59:0x0170, B:65:0x019c, B:68:0x01a7, B:69:0x01df, B:71:0x01e3, B:74:0x01e8, B:76:0x0202, B:77:0x020e, B:80:0x0214, B:83:0x0244, B:88:0x01c4, B:91:0x01cc, B:94:0x00b5, B:97:0x00c1, B:99:0x001b, B:102:0x0027, B:105:0x0033, B:108:0x003f, B:112:0x004d, B:116:0x005a), top: B:11:0x0012 }] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m3284c(CrashDetailBean crashDetailBean) {
        int i;
        long j;
        String str;
        String str2;
        HashMap hashMap;
        int i2;
        byte[] bArr;
        String sb;
        if (crashDetailBean == null) {
            return;
        }
        if (this.f1222g == null && this.f1221f == null) {
            return;
        }
        try {
            switch (crashDetailBean.f1146b) {
                case 0:
                    if (!C1164h.m3262g().m3258k()) {
                        return;
                    }
                    i = 0;
                    break;
                case 1:
                    if (!C1164h.m3262g().m3258k()) {
                        return;
                    }
                    i = 2;
                    break;
                case 2:
                    i = 1;
                    break;
                case 3:
                    i = 4;
                    if (!C1164h.m3262g().m3259j()) {
                        return;
                    }
                    break;
                case 4:
                    i = 3;
                    if (!C1164h.m3262g().m3255n()) {
                        return;
                    }
                    break;
                case 5:
                    i = 5;
                    if (!C1164h.m3262g().m3257l()) {
                        return;
                    }
                    break;
                case 6:
                    i = 6;
                    if (!C1164h.m3262g().m3256m()) {
                        return;
                    }
                    break;
                case 7:
                    i = 7;
                    break;
                default:
                    return;
            }
            boolean z = crashDetailBean.f1146b == 1;
            String str3 = crashDetailBean.f1158n;
            String str4 = crashDetailBean.f1160p;
            String str5 = crashDetailBean.f1161q;
            long j2 = crashDetailBean.f1162r;
            byte[] bArr2 = null;
            if (this.f1221f != null) {
                C1199X.m3084a("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
                this.f1221f.m3193b(z);
                C1199X.m3084a("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
                j = j2;
                str = str4;
                str2 = str5;
                String m3195a = this.f1221f.m3195a(z, str3, str4, str5, -1234567890, j);
                if (m3195a != null) {
                    HashMap hashMap2 = new HashMap(1);
                    hashMap2.put("userData", m3195a);
                    hashMap = hashMap2;
                    if (hashMap != null && hashMap.size() > 0) {
                        crashDetailBean.f1136P = new LinkedHashMap(hashMap.size());
                        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                            if (!C1208ca.m3012b(entry.getKey())) {
                                String key = entry.getKey();
                                if (key.length() > 100) {
                                    key = key.substring(0, 100);
                                    C1199X.m3076e("setted key length is over limit %d substring to %s", 100, key);
                                }
                                if (C1208ca.m3012b(entry.getValue()) || entry.getValue().length() <= 30000) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("");
                                    sb2.append(entry.getValue());
                                    sb = sb2.toString();
                                } else {
                                    sb = entry.getValue().substring(entry.getValue().length() - BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH);
                                    C1199X.m3076e("setted %s value length is over limit %d substring", key, Integer.valueOf((int) BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH));
                                }
                                crashDetailBean.f1136P.put(key, sb);
                                C1199X.m3078c("add setted key %s value size:%d", key, Integer.valueOf(sb.length()));
                            }
                        }
                    }
                    C1199X.m3078c("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                    if (this.f1221f == null) {
                        C1199X.m3084a("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
                        bArr = this.f1221f.m3192b(z, str3, str, str2, -1234567890, j);
                        i2 = BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH;
                    } else {
                        i2 = BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH;
                        if (this.f1222g != null) {
                            C1199X.m3084a("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new Object[0]);
                            bArr2 = this.f1222g.onCrashHandleStart2GetExtraDatas(i, crashDetailBean.f1158n, crashDetailBean.f1159o, crashDetailBean.f1161q);
                        }
                        bArr = bArr2;
                    }
                    crashDetailBean.f1142V = bArr;
                    if (bArr != null) {
                        if (bArr.length > i2) {
                            C1199X.m3076e("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(bArr.length), Integer.valueOf(i2));
                            crashDetailBean.f1142V = Arrays.copyOf(bArr, i2);
                        }
                        C1199X.m3078c("add extra bytes %d ", Integer.valueOf(bArr.length));
                    }
                    if (this.f1221f != null) {
                        return;
                    }
                    C1199X.m3084a("Calling 'onCrashSaving' of RQD crash listener.", new Object[0]);
                    if (this.f1221f.m3194a(z, str3, crashDetailBean.f1159o, str, str2, -1234567890, j, crashDetailBean.f1157m, crashDetailBean.f1149e, crashDetailBean.f1147c, crashDetailBean.f1121A, crashDetailBean.f1122B)) {
                        return;
                    }
                    C1199X.m3076e("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
                    return;
                }
                hashMap = null;
                if (hashMap != null) {
                    crashDetailBean.f1136P = new LinkedHashMap(hashMap.size());
                    while (r7.hasNext()) {
                    }
                }
                C1199X.m3078c("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                if (this.f1221f == null) {
                }
                crashDetailBean.f1142V = bArr;
                if (bArr != null) {
                }
                if (this.f1221f != null) {
                }
            } else {
                j = j2;
                str = str4;
                str2 = str5;
                if (this.f1222g != null) {
                    C1199X.m3084a("Calling 'onCrashHandleStart' of Bugly crash listener.", new Object[0]);
                    hashMap = this.f1222g.onCrashHandleStart(i, crashDetailBean.f1158n, crashDetailBean.f1159o, crashDetailBean.f1161q);
                    if (hashMap != null) {
                    }
                    C1199X.m3078c("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                    if (this.f1221f == null) {
                    }
                    crashDetailBean.f1142V = bArr;
                    if (bArr != null) {
                    }
                    if (this.f1221f != null) {
                    }
                }
                hashMap = null;
                if (hashMap != null) {
                }
                C1199X.m3078c("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                if (this.f1221f == null) {
                }
                crashDetailBean.f1142V = bArr;
                if (bArr != null) {
                }
                if (this.f1221f != null) {
                }
            }
        } catch (Throwable th) {
            C1199X.m3076e("crash handle callback something wrong! %s", th.getClass().getName());
            if (C1199X.m3080b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    public void m3283c(List<C1158b> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("_id", " in ", "(");
        for (C1158b c1158b : list) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(c1158b.f1208a);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
        }
        StringBuilder sb = new StringBuilder(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.substring(0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.lastIndexOf(",")));
        sb.append(")");
        String sb2 = sb.toString();
        sb.setLength(0);
        try {
            int m3153a = C1185J.m3172a().m3153a("t_cr", sb2, (String[]) null, (AbstractC1184I) null, true);
            Object[] objArr = new Object[2];
            objArr[0] = "t_cr";
            objArr[1] = Integer.valueOf(m3153a);
            C1199X.m3084a("deleted %s data %d", objArr);
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: d */
    public void m3282d(CrashDetailBean crashDetailBean) {
        int i = crashDetailBean.f1146b;
        boolean z = true;
        if (i != 0) {
            if (i != 1) {
                if (i == 3 && !C1164h.m3262g().m3259j()) {
                    return;
                }
            } else if (!C1164h.m3262g().m3258k()) {
                return;
            }
        } else if (!C1164h.m3262g().m3258k()) {
            return;
        }
        if (this.f1221f != null) {
            C1199X.m3084a("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
            AbstractC1174m abstractC1174m = this.f1221f;
            if (crashDetailBean.f1146b != 1) {
                z = false;
            }
            abstractC1174m.m3196a(z);
        }
    }

    /* renamed from: d */
    public void m3281d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb.append(" or ");
                    sb.append("_id");
                    sb.append(" = ");
                    sb.append(crashDetailBean.f1145a);
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    sb2 = sb2.substring(4);
                }
                String str = sb2;
                sb.setLength(0);
                int m3153a = C1185J.m3172a().m3153a("t_cr", str, (String[]) null, (AbstractC1184I) null, true);
                Object[] objArr = new Object[2];
                objArr[0] = "t_cr";
                objArr[1] = Integer.valueOf(m3153a);
                C1199X.m3084a("deleted %s data %d", objArr);
            } catch (Throwable th) {
                if (C1199X.m3080b(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* renamed from: e */
    public void m3280e(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues m3297a = m3297a(crashDetailBean);
        if (m3297a != null) {
            long m3155a = C1185J.m3172a().m3155a("t_cr", m3297a, (AbstractC1184I) null, true);
            if (m3155a >= 0) {
                C1199X.m3084a("insert %s success!", "t_cr");
                crashDetailBean.f1145a = m3155a;
            }
        }
        if (!C1164h.f1239i) {
            return;
        }
        m3279f(crashDetailBean);
    }
}

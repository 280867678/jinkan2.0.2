package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.info.C1141b;
import com.tencent.bugly.crashreport.common.strategy.C1145c;
import com.tencent.bugly.crashreport.crash.C1161e;
import com.tencent.bugly.crashreport.crash.C1164h;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1205ba;
import com.tencent.bugly.proguard.C1208ca;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.crashreport.crash.jni.b */
/* loaded from: classes3.dex */
public class C1170b implements NativeExceptionHandler {

    /* renamed from: a */
    public final Context f1300a;

    /* renamed from: b */
    public final C1161e f1301b;

    /* renamed from: c */
    public final C1140a f1302c;

    /* renamed from: d */
    public final C1145c f1303d;

    public C1170b(Context context, C1140a c1140a, C1161e c1161e, C1145c c1145c) {
        this.f1300a = context;
        this.f1301b = c1161e;
        this.f1302c = c1140a;
        this.f1303d = c1145c;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7) {
        C1199X.m3078c("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, i3, str5, i4, i5, i6, str6, str7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0246  */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleNativeException2(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7, String[] strArr) {
        String str8;
        String str9;
        String str10;
        boolean z;
        String str11;
        String str12;
        long j3;
        String str13;
        String str14;
        CrashDetailBean packageCrashDatas;
        String str15;
        boolean z2;
        Thread next;
        C1199X.m3078c("Native Crash Happen v2", new Object[0]);
        try {
            String m3223a = C1171c.m3223a(str3);
            String str16 = "UNKNOWN";
            if (i3 > 0) {
                str9 = str + "(" + str5 + ")";
                str8 = str16;
                str10 = "KERNEL";
            } else {
                if (i4 > 0) {
                    str16 = AppInfo.m3436a(this.f1300a, i4);
                }
                str8 = !str16.equals(String.valueOf(i4)) ? str16 + "(" + i4 + ")" : str16;
                str9 = str;
                str10 = str5;
            }
            HashMap hashMap = new HashMap();
            if (strArr != null) {
                for (int i7 = 0; i7 < strArr.length; i7++) {
                    String str17 = strArr[i7];
                    if (str17 != null) {
                        C1199X.m3078c("Extra message[%d]: %s", Integer.valueOf(i7), str17);
                        String[] split = str17.split("=");
                        if (split.length == 2) {
                            hashMap.put(split[0], split[1]);
                        } else {
                            C1199X.m3076e("bad extraMsg %s", str17);
                        }
                    }
                }
            } else {
                C1199X.m3084a("not found extraMsg", new Object[0]);
            }
            String str18 = (String) hashMap.get("HasPendingException");
            if (str18 == null || !str18.equals("true")) {
                z = false;
            } else {
                C1199X.m3078c("Native crash happened with a Java pending exception.", new Object[0]);
                z = true;
            }
            String str19 = (String) hashMap.get("ExceptionProcessName");
            if (str19 == null || str19.length() == 0) {
                str19 = this.f1302c.f1043h;
            } else {
                C1199X.m3084a("Name of crash process: %s", str19);
            }
            String str20 = str19;
            String str21 = (String) hashMap.get("ExceptionThreadName");
            try {
                if (str21 == null || str21.length() == 0) {
                    Thread currentThread = Thread.currentThread();
                    str11 = currentThread.getName() + "(" + currentThread.getId() + ")";
                } else {
                    C1199X.m3084a("Name of crash thread: %s", str21);
                    Iterator<Thread> it = Thread.getAllStackTraces().keySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str15 = str21;
                            z2 = false;
                            break;
                        }
                        if (it.next().getName().equals(str21)) {
                            str15 = str21 + "(" + next.getId() + ")";
                            z2 = true;
                            break;
                        }
                    }
                    if (z2) {
                        str12 = str15;
                        j3 = (j * 1000) + (j2 / 1000);
                        str13 = (String) hashMap.get("SysLogPath");
                        str14 = (String) hashMap.get("JniLogPath");
                        if (!this.f1303d.m3341d()) {
                            C1199X.m3076e("no remote but still store!", new Object[0]);
                        }
                        if (this.f1303d.m3342c().f1089f && this.f1303d.m3341d()) {
                            C1199X.m3081b("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                            C1161e.m3293a("NATIVE_CRASH", C1208ca.m3047a(), str20, str12, str9 + "\n" + str2 + "\n" + m3223a, null);
                            C1208ca.m3027a(str4);
                            return;
                        }
                        String str22 = str9;
                        packageCrashDatas = packageCrashDatas(str20, str12, j3, str9, str2, m3223a, str10, str8, str4, str13, str14, str7, null, null, true, z);
                        if (packageCrashDatas != null) {
                            C1199X.m3081b("pkg crash datas fail!", new Object[0]);
                            return;
                        }
                        C1161e.m3293a("NATIVE_CRASH", C1208ca.m3047a(), str20, str12, str22 + "\n" + str2 + "\n" + m3223a, packageCrashDatas);
                        try {
                            boolean z3 = !this.f1301b.m3296a(packageCrashDatas, i3);
                            String str23 = null;
                            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                            if (nativeCrashHandler != null) {
                                str23 = nativeCrashHandler.getDumpFilePath();
                            }
                            C1171c.m3220a(true, str23);
                            if (z3) {
                                this.f1301b.m3295a(packageCrashDatas, 3000L, true);
                            }
                            this.f1301b.m3282d(packageCrashDatas);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            if (C1199X.m3080b(th)) {
                                return;
                            }
                            th.printStackTrace();
                            return;
                        }
                    }
                    str11 = str15 + "(" + i2 + ")";
                }
                packageCrashDatas = packageCrashDatas(str20, str12, j3, str9, str2, m3223a, str10, str8, str4, str13, str14, str7, null, null, true, z);
                if (packageCrashDatas != null) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
            str12 = str11;
            j3 = (j * 1000) + (j2 / 1000);
            str13 = (String) hashMap.get("SysLogPath");
            str14 = (String) hashMap.get("JniLogPath");
            if (!this.f1303d.m3341d()) {
            }
            if (this.f1303d.m3342c().f1089f) {
            }
            String str222 = str9;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i;
        String str12;
        int indexOf;
        boolean m3260i = C1164h.m3262g().m3260i();
        if (m3260i) {
            C1199X.m3081b("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f1146b = 1;
        crashDetailBean.f1149e = this.f1302c.m3395l();
        C1140a c1140a = this.f1302c;
        crashDetailBean.f1150f = c1140a.f1008E;
        crashDetailBean.f1151g = c1140a.m3398i();
        crashDetailBean.f1157m = this.f1302c.m3382y();
        crashDetailBean.f1158n = str3;
        String str13 = "";
        crashDetailBean.f1159o = m3260i ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : str13;
        crashDetailBean.f1160p = str4;
        if (str5 != null) {
            str13 = str5;
        }
        crashDetailBean.f1161q = str13;
        crashDetailBean.f1162r = j;
        crashDetailBean.f1165u = C1208ca.m3004c(str13.getBytes());
        crashDetailBean.f1121A = str;
        crashDetailBean.f1122B = str2;
        crashDetailBean.f1129I = this.f1302c.m3389r();
        crashDetailBean.f1152h = this.f1302c.m3391p();
        crashDetailBean.f1153i = this.f1302c.m3392o();
        crashDetailBean.f1166v = str8;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        String m3221a = C1171c.m3221a(dumpFilePath, str8);
        if (!C1208ca.m3012b(m3221a)) {
            crashDetailBean.f1143W = m3221a;
        }
        crashDetailBean.f1144X = C1171c.m3217c(dumpFilePath);
        crashDetailBean.f1167w = C1171c.m3222a(str9, C1164h.f1235e, C1164h.f1238h, C1164h.f1243m);
        crashDetailBean.f1168x = C1171c.m3222a(str10, C1164h.f1235e, null, true);
        crashDetailBean.f1131K = str7;
        crashDetailBean.f1132L = str6;
        crashDetailBean.f1133M = str11;
        crashDetailBean.f1126F = this.f1302c.m3385v();
        crashDetailBean.f1127G = this.f1302c.m3384w();
        crashDetailBean.f1128H = this.f1302c.m3383x();
        if (z) {
            crashDetailBean.f1123C = C1141b.m3365h();
            crashDetailBean.f1124D = C1141b.m3361j();
            crashDetailBean.f1125E = C1141b.m3367g();
            if (crashDetailBean.f1167w == null) {
                crashDetailBean.f1167w = C1208ca.m3043a(this.f1300a, C1164h.f1235e, C1164h.f1238h);
            }
            crashDetailBean.f1169y = C1205ba.m3063b();
            C1140a c1140a2 = this.f1302c;
            crashDetailBean.f1134N = c1140a2.f1035d;
            crashDetailBean.f1135O = c1140a2.m3427C();
            crashDetailBean.f1170z = C1208ca.m3046a(C1164h.f1236f, false);
            int indexOf2 = crashDetailBean.f1161q.indexOf("java:\n");
            if (indexOf2 > 0 && (i = indexOf2 + 6) < crashDetailBean.f1161q.length()) {
                String str14 = crashDetailBean.f1161q;
                String substring = str14.substring(i, str14.length() - 1);
                if (substring.length() > 0 && crashDetailBean.f1170z.containsKey(crashDetailBean.f1122B) && (indexOf = (str12 = crashDetailBean.f1170z.get(crashDetailBean.f1122B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.f1170z.put(crashDetailBean.f1122B, substring2);
                    crashDetailBean.f1161q = crashDetailBean.f1161q.substring(0, i);
                    crashDetailBean.f1161q = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), crashDetailBean.f1161q, substring2);
                }
            }
            if (str == null) {
                crashDetailBean.f1121A = this.f1302c.f1043h;
            }
            this.f1301b.m3284c(crashDetailBean);
            crashDetailBean.f1138R = this.f1302c.m3429A();
            crashDetailBean.f1139S = this.f1302c.m3387t();
            crashDetailBean.f1140T = this.f1302c.m3399h();
            crashDetailBean.f1141U = this.f1302c.m3401g();
        } else {
            crashDetailBean.f1123C = -1L;
            crashDetailBean.f1124D = -1L;
            crashDetailBean.f1125E = -1L;
            if (crashDetailBean.f1167w == null) {
                crashDetailBean.f1167w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.f1134N = -1L;
            crashDetailBean.f1138R = -1;
            crashDetailBean.f1139S = -1;
            crashDetailBean.f1140T = map;
            crashDetailBean.f1141U = this.f1302c.m3401g();
            crashDetailBean.f1170z = null;
            if (str == null) {
                crashDetailBean.f1121A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.f1169y = bArr;
            }
        }
        return crashDetailBean;
    }
}

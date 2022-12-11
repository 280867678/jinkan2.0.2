package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.info.C1141b;
import com.tencent.bugly.crashreport.common.strategy.C1145c;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.C1161e;
import com.tencent.bugly.crashreport.crash.C1164h;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.proguard.AbstractC1214fa;
import com.tencent.bugly.proguard.C1185J;
import com.tencent.bugly.proguard.C1198W;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1205ba;
import com.tencent.bugly.proguard.C1208ca;
import com.tencent.bugly.proguard.C1212ea;
import com.tencent.bugly.proguard.RunnableC1210da;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.crashreport.crash.anr.g */
/* loaded from: classes3.dex */
public class C1155g implements AbstractC1214fa {

    /* renamed from: a */
    public static C1155g f1189a;

    /* renamed from: d */
    public final Context f1192d;

    /* renamed from: e */
    public final C1140a f1193e;

    /* renamed from: f */
    public final C1198W f1194f;

    /* renamed from: g */
    public final C1145c f1195g;

    /* renamed from: h */
    public String f1196h;

    /* renamed from: i */
    public final C1161e f1197i;

    /* renamed from: j */
    public FileObserver f1198j;

    /* renamed from: l */
    public C1212ea f1200l;

    /* renamed from: m */
    public int f1201m;

    /* renamed from: b */
    public AtomicInteger f1190b = new AtomicInteger(0);

    /* renamed from: c */
    public long f1191c = -1;

    /* renamed from: k */
    public boolean f1199k = true;

    /* renamed from: n */
    public ActivityManager.ProcessErrorStateInfo f1202n = new ActivityManager.ProcessErrorStateInfo();

    public C1155g(Context context, C1145c c1145c, C1140a c1140a, C1198W c1198w, C1185J c1185j, C1161e c1161e, BuglyStrategy.C1080a c1080a) {
        this.f1192d = C1208ca.m3044a(context);
        this.f1196h = context.getDir("bugly", 0).getAbsolutePath();
        this.f1193e = c1140a;
        this.f1194f = c1198w;
        this.f1195g = c1145c;
        this.f1197i = c1161e;
    }

    /* renamed from: a */
    public static C1155g m3328a(Context context, C1145c c1145c, C1140a c1140a, C1198W c1198w, C1185J c1185j, C1161e c1161e, BuglyStrategy.C1080a c1080a) {
        if (f1189a == null) {
            f1189a = new C1155g(context, c1145c, c1140a, c1198w, c1185j, c1161e, c1080a);
        }
        return f1189a;
    }

    /* renamed from: c */
    private synchronized void m3317c(boolean z) {
        if (this.f1199k != z) {
            C1199X.m3078c("user change anr %b", Boolean.valueOf(z));
            this.f1199k = z;
        }
    }

    /* renamed from: h */
    private boolean m3312h() {
        C1212ea c1212ea = this.f1200l;
        if (c1212ea == null || !c1212ea.isAlive()) {
            C1212ea c1212ea2 = new C1212ea();
            this.f1200l = c1212ea2;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bugly-ThreadMonitor");
            int i = this.f1201m;
            this.f1201m = i + 1;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i);
            c1212ea2.setName(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            this.f1200l.m2982a();
            this.f1200l.m2979a(this);
            boolean m2975c = this.f1200l.m2975c();
            C1198W c1198w = this.f1194f;
            if (c1198w != null) {
                c1198w.m3092a(new RunnableC1152d(this));
            }
            return m2975c;
        }
        return false;
    }

    /* renamed from: i */
    private synchronized void m3311i() {
        if (m3331a()) {
            C1199X.m3076e("start when started!", new Object[0]);
        } else if (TextUtils.isEmpty(this.f1196h)) {
        } else {
            m3312h();
            FileObserverC1153e fileObserverC1153e = new FileObserverC1153e(this, this.f1196h, 256);
            this.f1198j = fileObserverC1153e;
            fileObserverC1153e.startWatching();
            C1199X.m3078c("startWatchingPrivateAnrDir! dumFilePath is %s", this.f1196h);
            this.f1194f.m3092a(new RunnableC1154f(this));
        }
    }

    /* renamed from: j */
    private boolean m3310j() {
        C1212ea c1212ea = this.f1200l;
        if (c1212ea != null) {
            boolean m2974d = c1212ea.m2974d();
            this.f1200l.m2977b();
            this.f1200l.m2976b(this);
            this.f1200l = null;
            return m2974d;
        }
        return false;
    }

    /* renamed from: k */
    private synchronized void m3309k() {
        if (!m3331a()) {
            C1199X.m3076e("close when closed!", new Object[0]);
            return;
        }
        m3310j();
        C1199X.m3078c("stopWatchingPrivateAnrDir", new Object[0]);
        this.f1198j.stopWatching();
        this.f1198j = null;
        C1199X.m3076e("close anr monitor!", new Object[0]);
    }

    /* renamed from: l */
    private File m3308l() {
        int indexOf;
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(this.f1196h);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    return null;
                }
                int i = 12;
                int length = listFiles.length;
                int i2 = 0;
                while (i2 < length) {
                    File file2 = listFiles[i2];
                    String name = file2.getName();
                    if (name.startsWith("bugly_trace_") && (indexOf = name.indexOf(".txt")) > 0) {
                        long parseLong = Long.parseLong(name.substring(i, indexOf));
                        long j = (currentTimeMillis - parseLong) / 1000;
                        C1199X.m3084a("current time %d trace time is %d s", Long.valueOf(currentTimeMillis), Long.valueOf(parseLong));
                        C1199X.m3084a("current time minus trace time is %d s", Long.valueOf(j));
                        if (j < 30) {
                            return file2;
                        }
                    }
                    i2++;
                    i = 12;
                }
            } catch (Throwable th) {
                C1199X.m3080b(th);
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public ActivityManager.ProcessErrorStateInfo m3330a(Context context, long j) {
        if (j < 0) {
            j = 0;
        }
        try {
            C1199X.m3084a("to find!", new Object[0]);
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            long j2 = j / 500;
            int i = 0;
            while (true) {
                C1199X.m3084a("waiting!", new Object[0]);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2) {
                            C1199X.m3084a("found!", new Object[0]);
                            return processErrorStateInfo;
                        }
                    }
                }
                C1208ca.m3007c(500L);
                int i2 = i + 1;
                if (i >= j2) {
                    C1199X.m3084a("end!", new Object[0]);
                    return null;
                }
                i = i2;
            }
        } catch (Exception e) {
            C1199X.m3083a(e);
            return null;
        } catch (OutOfMemoryError e2) {
            this.f1202n.pid = Process.myPid();
            ActivityManager.ProcessErrorStateInfo processErrorStateInfo2 = this.f1202n;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("bugly sdk waitForAnrProcessStateChanged encount error:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e2.getMessage());
            processErrorStateInfo2.shortMsg = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            return this.f1202n;
        }
    }

    /* renamed from: a */
    public CrashDetailBean m3325a(C1149a c1149a) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.f1123C = C1141b.m3365h();
            crashDetailBean.f1124D = C1141b.m3361j();
            crashDetailBean.f1125E = C1141b.m3367g();
            crashDetailBean.f1126F = this.f1193e.m3385v();
            crashDetailBean.f1127G = this.f1193e.m3384w();
            crashDetailBean.f1128H = this.f1193e.m3383x();
            if (!C1141b.m3362i(this.f1192d)) {
                crashDetailBean.f1167w = C1208ca.m3043a(this.f1192d, C1164h.f1235e, C1164h.f1238h);
            }
            crashDetailBean.f1146b = 3;
            crashDetailBean.f1149e = this.f1193e.m3395l();
            crashDetailBean.f1150f = this.f1193e.f1008E;
            crashDetailBean.f1151g = this.f1193e.m3398i();
            crashDetailBean.f1157m = this.f1193e.m3382y();
            crashDetailBean.f1158n = "ANR_EXCEPTION";
            crashDetailBean.f1159o = c1149a.f1182f;
            crashDetailBean.f1161q = c1149a.f1183g;
            HashMap hashMap = new HashMap();
            crashDetailBean.f1137Q = hashMap;
            hashMap.put("BUGLY_CR_01", c1149a.f1181e);
            int i = -1;
            if (crashDetailBean.f1161q != null) {
                i = crashDetailBean.f1161q.indexOf("\n");
            }
            crashDetailBean.f1160p = i > 0 ? crashDetailBean.f1161q.substring(0, i) : "GET_FAIL";
            crashDetailBean.f1162r = c1149a.f1179c;
            if (crashDetailBean.f1161q != null) {
                crashDetailBean.f1165u = C1208ca.m3004c(crashDetailBean.f1161q.getBytes());
            }
            crashDetailBean.f1170z = c1149a.f1178b;
            crashDetailBean.f1121A = c1149a.f1177a;
            crashDetailBean.f1122B = "main(1)";
            crashDetailBean.f1129I = this.f1193e.m3389r();
            crashDetailBean.f1152h = this.f1193e.m3391p();
            crashDetailBean.f1153i = this.f1193e.m3392o();
            crashDetailBean.f1166v = c1149a.f1180d;
            crashDetailBean.f1133M = this.f1193e.f1016M;
            crashDetailBean.f1134N = this.f1193e.f1035d;
            crashDetailBean.f1135O = this.f1193e.m3427C();
            if (!C1141b.m3362i(this.f1192d)) {
                this.f1197i.m3284c(crashDetailBean);
            }
            crashDetailBean.f1138R = this.f1193e.m3429A();
            crashDetailBean.f1139S = this.f1193e.m3387t();
            crashDetailBean.f1140T = this.f1193e.m3399h();
            crashDetailBean.f1141U = this.f1193e.m3401g();
            crashDetailBean.f1169y = C1205ba.m3063b();
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    /* renamed from: a */
    public C1149a m3329a(Context context, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j, Map<String, String> map) {
        C1149a c1149a = new C1149a();
        c1149a.f1179c = j;
        c1149a.f1177a = processErrorStateInfo != null ? processErrorStateInfo.processName : AppInfo.m3436a(context, Process.myPid());
        String str = "";
        c1149a.f1182f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : str;
        if (processErrorStateInfo != null) {
            str = processErrorStateInfo.longMsg;
        }
        c1149a.f1181e = str;
        c1149a.f1178b = map;
        Thread thread = Looper.getMainLooper().getThread();
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next.startsWith(thread.getName())) {
                    c1149a.f1183g = map.get(next);
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(c1149a.f1183g)) {
            c1149a.f1183g = "main stack is null , some error may be encountered.";
        }
        Object[] objArr = new Object[7];
        int i = 0;
        objArr[0] = Long.valueOf(c1149a.f1179c);
        objArr[1] = c1149a.f1180d;
        objArr[2] = c1149a.f1177a;
        objArr[3] = c1149a.f1183g;
        objArr[4] = c1149a.f1182f;
        objArr[5] = c1149a.f1181e;
        Map<String, String> map2 = c1149a.f1178b;
        if (map2 != null) {
            i = map2.size();
        }
        objArr[6] = Integer.valueOf(i);
        C1199X.m3084a("anr tm:%d\ntr:%s\nproc:%s\nmain stack:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
        return c1149a;
    }

    /* renamed from: a */
    public synchronized void m3326a(StrategyBean strategyBean) {
        C1199X.m3076e("customer decides whether to open or close.", new Object[0]);
    }

    /* renamed from: a */
    public final void m3323a(String str) {
        synchronized (this) {
            if (this.f1190b.get() != 0) {
                C1199X.m3084a("trace started return ", new Object[0]);
                return;
            }
            this.f1190b.set(1);
            try {
                C1199X.m3084a("read trace first dump for create time!", new Object[0]);
                TraceFileHelper.C1147a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                long j = readFirstDumpInfo != null ? readFirstDumpInfo.f1175c : -1L;
                if (j == -1) {
                    C1199X.m3076e("trace dump fail could not get time!", new Object[0]);
                    j = System.currentTimeMillis();
                }
                long j2 = j;
                if (Math.abs(j2 - this.f1191c) < 10000) {
                    C1199X.m3076e("should not process ANR too Fre in %d", 10000);
                } else {
                    this.f1191c = j2;
                    this.f1190b.set(1);
                    Map<String, String> m3046a = C1208ca.m3046a(C1164h.f1236f, false);
                    if (m3046a != null && m3046a.size() > 0) {
                        ActivityManager.ProcessErrorStateInfo m3330a = m3330a(this.f1192d, 10000L);
                        this.f1202n = m3330a;
                        if (m3330a == null) {
                            C1199X.m3084a("proc state is unvisiable!", new Object[0]);
                        } else if (m3330a.pid != Process.myPid()) {
                            C1199X.m3084a("not mind proc!", this.f1202n.processName);
                        } else {
                            C1199X.m3078c("found visiable anr , start to process!", new Object[0]);
                            m3327a(this.f1192d, str, this.f1202n, j2, m3046a);
                        }
                    }
                    C1199X.m3076e("can't get all thread skip this anr", new Object[0]);
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized void m3321a(boolean z) {
        if (z) {
            m3311i();
        } else {
            m3309k();
        }
    }

    /* renamed from: a */
    public synchronized boolean m3331a() {
        return this.f1198j != null;
    }

    /* renamed from: a */
    public boolean m3327a(Context context, String str, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j, Map<String, String> map) {
        C1149a m3329a = m3329a(context, processErrorStateInfo, j, map);
        C1199X.m3078c("found visiable anr , start to upload!", new Object[0]);
        CrashDetailBean m3325a = m3325a(m3329a);
        if (m3325a == null) {
            C1199X.m3081b("pack anr fail!", new Object[0]);
            return false;
        }
        C1164h.m3262g().m3273a(m3325a);
        Object[] objArr = new Object[0];
        if (m3325a.f1145a >= 0) {
            C1199X.m3078c("backup anr record success!", objArr);
        } else {
            C1199X.m3076e("backup anr record fail!", objArr);
        }
        if (str == null || !new File(str).exists()) {
            File m3308l = m3308l();
            C1199X.m3078c("traceFile is %s", m3308l);
            if (m3308l != null) {
                m3325a.f1166v = m3308l.getAbsolutePath();
            }
        } else {
            String str2 = this.f1196h;
            m3329a.f1180d = new File(str2, "bugly_trace_" + j + ".txt").getAbsolutePath();
            this.f1190b.set(3);
            if (m3322a(str, m3329a.f1180d, m3329a.f1177a)) {
                C1199X.m3078c("backup trace success", new Object[0]);
            }
        }
        C1161e.m3293a("ANR", C1208ca.m3047a(), m3329a.f1177a, "main", m3329a.f1183g, m3325a);
        if (!this.f1197i.m3286b(m3325a)) {
            this.f1197i.m3295a(m3325a, 3000L, true);
        }
        this.f1197i.m3282d(m3325a);
        return true;
    }

    @Override // com.tencent.bugly.proguard.AbstractC1214fa
    /* renamed from: a */
    public boolean mo2971a(RunnableC1210da runnableC1210da) {
        HashMap hashMap;
        HashMap hashMap2 = new HashMap();
        if (runnableC1210da.m2996b().equals(Looper.getMainLooper())) {
            try {
                hashMap = C1208ca.m3046a(200000, false);
            } catch (Throwable th) {
                C1199X.m3083a(th);
                hashMap2.put("main", th.getMessage());
                hashMap = hashMap2;
            }
            Map<String, String> map = hashMap;
            C1199X.m3084a("onThreadBlock found visiable anr , start to process!", new Object[0]);
            m3327a(this.f1192d, "", null, System.currentTimeMillis(), map);
        } else {
            C1199X.m3084a("anr handler onThreadBlock only care main thread ,current thread is: %s", runnableC1210da.m2995c());
        }
        return true;
    }

    /* renamed from: a */
    public boolean m3322a(String str, String str2, String str3) {
        Map<String, String[]> map;
        BufferedWriter bufferedWriter;
        TraceFileHelper.C1147a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo == null || (map = readTargetDumpInfo.f1176d) == null || map.size() <= 0) {
            C1199X.m3081b("not found trace dump for %s", str3);
            return false;
        }
        File file = new File(str2);
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            if (!file.exists() || !file.canWrite()) {
                C1199X.m3081b("backup file create fail %s", str2);
                return false;
            }
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                String[] strArr = readTargetDumpInfo.f1176d.get("main");
                int i = 3;
                if (strArr != null && strArr.length >= 3) {
                    String str4 = strArr[0];
                    String str5 = strArr[1];
                    String str6 = strArr[2];
                    StringBuilder sb = new StringBuilder();
                    sb.append("\"main\" tid=");
                    sb.append(str6);
                    sb.append(" :\n");
                    sb.append(str4);
                    sb.append("\n");
                    sb.append(str5);
                    sb.append("\n\n");
                    bufferedWriter.write(sb.toString());
                    bufferedWriter.flush();
                }
                for (Map.Entry<String, String[]> entry : readTargetDumpInfo.f1176d.entrySet()) {
                    if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= i) {
                        String str7 = entry.getValue()[0];
                        String str8 = entry.getValue()[1];
                        String str9 = entry.getValue()[2];
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("\"");
                        sb2.append(entry.getKey());
                        sb2.append("\" tid=");
                        sb2.append(str9);
                        sb2.append(" :\n");
                        sb2.append(str7);
                        sb2.append("\n");
                        sb2.append(str8);
                        sb2.append("\n\n");
                        bufferedWriter.write(sb2.toString());
                        bufferedWriter.flush();
                        i = 3;
                    }
                }
                try {
                    bufferedWriter.close();
                } catch (IOException e2) {
                    if (!C1199X.m3080b(e2)) {
                        e2.printStackTrace();
                    }
                }
                return true;
            } catch (IOException e3) {
                e = e3;
                bufferedWriter2 = bufferedWriter;
                if (!C1199X.m3080b(e)) {
                    e.printStackTrace();
                }
                C1199X.m3081b("dump trace fail %s", e.getClass().getName() + ":" + e.getMessage());
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e4) {
                        if (!C1199X.m3080b(e4)) {
                            e4.printStackTrace();
                        }
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter2 = bufferedWriter;
                BufferedWriter bufferedWriter3 = bufferedWriter2;
                Throwable th3 = th;
                if (bufferedWriter3 != null) {
                    try {
                        bufferedWriter3.close();
                    } catch (IOException e5) {
                        if (!C1199X.m3080b(e5)) {
                            e5.printStackTrace();
                        }
                    }
                }
                throw th3;
            }
        } catch (Exception e6) {
            if (!C1199X.m3080b(e6)) {
                e6.printStackTrace();
            }
            C1199X.m3081b("backup file create error! %s  %s", e6.getClass().getName() + ":" + e6.getMessage(), str2);
            return false;
        }
    }

    /* renamed from: b */
    public void m3319b(boolean z) {
        m3317c(z);
        boolean m3318c = m3318c();
        C1145c m3344b = C1145c.m3344b();
        if (m3344b != null) {
            m3318c = m3318c && m3344b.m3342c().f1089f;
        }
        if (m3318c != m3331a()) {
            C1199X.m3078c("anr changed to %b", Boolean.valueOf(m3318c));
            m3321a(m3318c);
        }
    }

    /* renamed from: b */
    public boolean m3320b() {
        return this.f1190b.get() != 0;
    }

    /* renamed from: c */
    public synchronized boolean m3318c() {
        return this.f1199k;
    }

    /* renamed from: d */
    public void m3316d() {
        int indexOf;
        long m3018b = C1208ca.m3018b() - C1164h.f1237g;
        File file = new File(this.f1196h);
        if (!file.exists() || !file.isDirectory()) {
            return;
        }
        try {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return;
            }
            int i = 0;
            for (File file2 : listFiles) {
                String name = file2.getName();
                StringBuilder sb = new StringBuilder();
                sb.append("Number Trace file : ");
                sb.append(name);
                C1199X.m3084a(sb.toString(), new Object[0]);
                if (name.startsWith("bugly_trace_") && (((indexOf = name.indexOf(".txt")) <= 0 || Long.parseLong(name.substring(12, indexOf)) < m3018b) && file2.delete())) {
                    i++;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Number of overdue trace files that has deleted: ");
            sb2.append(i);
            C1199X.m3084a(sb2.toString(), new Object[0]);
        } catch (Throwable th) {
            C1199X.m3080b(th);
        }
    }

    /* renamed from: e */
    public synchronized void m3315e() {
        if (m3331a()) {
            C1199X.m3076e("start when started!", new Object[0]);
            return;
        }
        FileObserverC1150b fileObserverC1150b = new FileObserverC1150b(this, "/data/anr/", 8);
        this.f1198j = fileObserverC1150b;
        fileObserverC1150b.startWatching();
        C1199X.m3078c("start anr monitor!", new Object[0]);
        this.f1194f.m3092a(new RunnableC1151c(this));
    }

    /* renamed from: f */
    public synchronized void m3314f() {
        if (!m3331a()) {
            C1199X.m3076e("close when closed!", new Object[0]);
            return;
        }
        this.f1198j.stopWatching();
        this.f1198j = null;
        C1199X.m3076e("close anr monitor!", new Object[0]);
    }

    /* renamed from: g */
    public void m3313g() {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i < 30) {
                try {
                    C1199X.m3078c("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i2));
                    C1208ca.m3007c(5000L);
                    i = i2;
                } catch (Throwable th) {
                    if (C1199X.m3080b(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

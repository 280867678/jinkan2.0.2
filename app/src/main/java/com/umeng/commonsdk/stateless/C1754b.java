package com.umeng.commonsdk.stateless;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.C1724a;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.vchannel.C1848a;
import java.io.File;
import java.util.LinkedList;

/* renamed from: com.umeng.commonsdk.stateless.b */
/* loaded from: classes4.dex */
public class C1754b {

    /* renamed from: a */
    public static final int f3996a = 273;

    /* renamed from: b */
    public static Context f3997b = null;

    /* renamed from: c */
    public static HandlerThread f3998c = null;

    /* renamed from: d */
    public static Handler f3999d = null;

    /* renamed from: f */
    public static final int f4001f = 274;

    /* renamed from: g */
    public static final int f4002g = 275;

    /* renamed from: h */
    public static final int f4003h = 512;

    /* renamed from: i */
    public static FileObserverC1757a f4004i;

    /* renamed from: j */
    public static IntentFilter f4005j;

    /* renamed from: k */
    public static boolean f4006k;

    /* renamed from: e */
    public static Object f4000e = new Object();

    /* renamed from: l */
    public static LinkedList<String> f4007l = new LinkedList<>();

    /* renamed from: m */
    public static BroadcastReceiver f4008m = new BroadcastReceiver() { // from class: com.umeng.commonsdk.stateless.b.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager;
            if (context == null || intent == null) {
                return;
            }
            try {
                if (intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    Context unused = C1754b.f3997b = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    if (C1754b.f3997b != null && (connectivityManager = (ConnectivityManager) C1754b.f3997b.getSystemService("connectivity")) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
                            boolean unused2 = C1754b.f4006k = false;
                        } else {
                            boolean unused3 = C1754b.f4006k = true;
                            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
                            C1754b.m640b(274);
                        }
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
    };

    /* renamed from: com.umeng.commonsdk.stateless.b$a */
    /* loaded from: classes4.dex */
    public static class FileObserverC1757a extends FileObserver {
        public FileObserverC1757a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if ((i & 8) != 8) {
                return;
            }
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            C1754b.m644a(274);
        }
    }

    public C1754b(Context context) {
        synchronized (f4000e) {
            if (context != null) {
                try {
                    Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    f3997b = origApplicationContext;
                    if (origApplicationContext != null && f3998c == null) {
                        HandlerThread handlerThread = new HandlerThread("SL-NetWorkSender");
                        f3998c = handlerThread;
                        handlerThread.start();
                        if (f4004i == null) {
                            String str = f3997b.getFilesDir() + File.separator + C1753a.f3990f;
                            File file = new File(str);
                            if (!file.exists()) {
                                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                file.mkdir();
                            }
                            FileObserverC1757a fileObserverC1757a = new FileObserverC1757a(str);
                            f4004i = fileObserverC1757a;
                            fileObserverC1757a.startWatching();
                            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                        }
                        if (f3999d == null) {
                            f3999d = new Handler(f3998c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.2
                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    int i = message.what;
                                    if (i != 512) {
                                        switch (i) {
                                            case 273:
                                                C1754b.m629m();
                                                return;
                                            case 274:
                                                C1754b.m627o();
                                                return;
                                            case C1754b.f4002g /* 275 */:
                                                C1754b.m625q();
                                                break;
                                            default:
                                                return;
                                        }
                                    }
                                    C1754b.m624r();
                                }
                            };
                        }
                        if (DeviceConfig.checkPermission(f3997b, "android.permission.ACCESS_NETWORK_STATE")) {
                            ULog.m535i("walle", "[stateless] begin register receiver");
                            if (f4005j == null) {
                                IntentFilter intentFilter = new IntentFilter();
                                f4005j = intentFilter;
                                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                                if (f4008m != null) {
                                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：注册网络状态监听器。");
                                    f3997b.registerReceiver(f4008m, f4005j);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m644a(int i) {
        Handler handler;
        if (!f4006k || (handler = f3999d) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i;
        f3999d.sendMessage(obtainMessage);
    }

    /* renamed from: a */
    public static boolean m645a() {
        synchronized (f4000e) {
            return f4004i != null;
        }
    }

    /* renamed from: b */
    public static void m641b() {
        UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        m640b(274);
    }

    /* renamed from: b */
    public static void m640b(int i) {
        try {
            if (!f4006k || f3999d == null || f3999d.hasMessages(i)) {
                return;
            }
            Message obtainMessage = f3999d.obtainMessage();
            obtainMessage.what = i;
            f3999d.sendMessage(obtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f3997b, th);
        }
    }

    /* renamed from: c */
    public static void m639c() {
        m640b(f4002g);
    }

    /* renamed from: d */
    public static void m638d() {
        m640b(512);
    }

    /* renamed from: j */
    public static void m632j() {
        File[] m605c = C1759d.m605c(f3997b);
        if (m605c != null) {
            if (f4007l.size() > 0) {
                f4007l.clear();
            }
            for (File file : m605c) {
                f4007l.add(file.getAbsolutePath());
            }
        }
    }

    /* renamed from: k */
    public static String m631k() {
        String str = null;
        try {
            String peek = f4007l.peek();
            if (peek == null) {
                return peek;
            }
            try {
                f4007l.removeFirst();
                return peek;
            } catch (Throwable unused) {
                str = peek;
                return str;
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: l */
    public static void m630l() {
        String pollFirst;
        if (f4007l.size() <= 0) {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            pollFirst = f4007l.pollFirst();
            if (!TextUtils.isEmpty(pollFirst)) {
                File file = new File(pollFirst);
                if (!file.exists()) {
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                    continue;
                } else {
                    C1758c c1758c = new C1758c(f3997b);
                    byte[] bArr = null;
                    try {
                        bArr = C1759d.m612a(pollFirst);
                    } catch (Exception unused) {
                    }
                    String name = file.getName();
                    String substring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : C1543ak.f2970aG;
                    String m602d = C1759d.m602d(name);
                    String str = C1753a.f3994j;
                    String m604c = C1759d.m604c(m602d);
                    if (C1848a.f4317c.equalsIgnoreCase(m604c)) {
                        str = C1848a.f4315a;
                    }
                    if (c1758c.m622a(bArr, m604c, str, substring) && !file.delete()) {
                        file.delete();
                        continue;
                    }
                }
            }
        } while (pollFirst != null);
        f4007l.clear();
    }

    /* renamed from: m */
    public static void m629m() {
        File m618a;
        File file;
        if (!f4006k || f3997b == null) {
            return;
        }
        do {
            try {
                m618a = C1759d.m618a(f3997b);
                if (m618a != null && m618a.getParentFile() != null && !TextUtils.isEmpty(m618a.getParentFile().getName())) {
                    C1758c c1758c = new C1758c(f3997b);
                    String str = new String(Base64.decode(m618a.getParentFile().getName(), 0));
                    if (!C1724a.f3899a.equalsIgnoreCase(str) && !C1724a.f3900b.equalsIgnoreCase(str) && !C1724a.f3893D.equalsIgnoreCase(str)) {
                        ULog.m535i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                        byte[] bArr = null;
                        try {
                            bArr = C1759d.m612a(m618a.getAbsolutePath());
                        } catch (Exception unused) {
                        }
                        String str2 = "";
                        if (C1848a.f4317c.equalsIgnoreCase(str)) {
                            str2 = C1848a.f4315a;
                        }
                        String str3 = C1543ak.f2970aG;
                        if (UMServerURL.PATH_SHARE.equalsIgnoreCase(str)) {
                            str3 = C1543ak.f2965aB;
                        }
                        if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) {
                            str3 = C1543ak.f3013ax;
                        }
                        if (!c1758c.m622a(bArr, str, str2, str3)) {
                            ULog.m535i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        ULog.m535i("walle", "[stateless] Send envelope file success, delete it.");
                        file = new File(m618a.getAbsolutePath());
                        if (!file.delete()) {
                            ULog.m535i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                            file.delete();
                            continue;
                        } else {
                            continue;
                        }
                    }
                    file = new File(m618a.getAbsolutePath());
                    file.delete();
                    continue;
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f3997b, th);
            }
        } while (m618a != null);
        m628n();
    }

    /* renamed from: n */
    public static void m628n() {
        try {
            File file = new File(f3997b.getFilesDir() + File.separator + C1753a.f3989e);
            if (!file.exists() || !file.isDirectory()) {
                return;
            }
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
            C1759d.m613a(file);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: o */
    public static void m627o() {
        if (!f4006k || f3997b == null) {
            return;
        }
        m632j();
        m630l();
        m639c();
    }

    /* renamed from: p */
    public static void m626p() {
        try {
            File file = new File(f3997b.getFilesDir() + File.separator + C1753a.f3989e);
            if (!file.exists() || !file.isDirectory()) {
                return;
            }
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
            m640b(273);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: q */
    public static void m625q() {
        m626p();
    }

    /* renamed from: r */
    public static void m624r() {
    }
}

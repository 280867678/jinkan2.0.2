package com.umeng.commonsdk.framework;

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
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.C1724a;
import com.umeng.commonsdk.internal.C1725b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.C1768c;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.umeng.commonsdk.framework.a */
/* loaded from: classes4.dex */
public class C1720a implements UMImprintChangeCallback {

    /* renamed from: a */
    public static HandlerThread f3864a = null;

    /* renamed from: b */
    public static Handler f3865b = null;

    /* renamed from: c */
    public static Handler f3866c = null;

    /* renamed from: d */
    public static final int f3867d = 200;

    /* renamed from: e */
    public static final int f3868e = 273;

    /* renamed from: f */
    public static final int f3869f = 274;

    /* renamed from: g */
    public static final int f3870g = 512;

    /* renamed from: h */
    public static final int f3871h = 769;

    /* renamed from: i */
    public static FileObserverC1723a f3872i = null;

    /* renamed from: j */
    public static ConnectivityManager f3873j = null;

    /* renamed from: k */
    public static NetworkInfo f3874k = null;

    /* renamed from: l */
    public static IntentFilter f3875l = null;

    /* renamed from: m */
    public static boolean f3876m = false;

    /* renamed from: n */
    public static ArrayList<UMSenderStateNotify> f3877n = null;

    /* renamed from: q */
    public static final String f3880q = "report_policy";

    /* renamed from: r */
    public static final String f3881r = "report_interval";

    /* renamed from: t */
    public static final int f3883t = 15;

    /* renamed from: u */
    public static final int f3884u = 3;

    /* renamed from: v */
    public static final int f3885v = 90;

    /* renamed from: o */
    public static Object f3878o = new Object();

    /* renamed from: p */
    public static ReentrantLock f3879p = new ReentrantLock();

    /* renamed from: s */
    public static boolean f3882s = false;

    /* renamed from: w */
    public static int f3886w = 15;

    /* renamed from: x */
    public static Object f3887x = new Object();

    /* renamed from: y */
    public static BroadcastReceiver f3888y = new BroadcastReceiver() { // from class: com.umeng.commonsdk.framework.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int size;
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                Context appContext = UMModuleRegister.getAppContext();
                try {
                    if (C1720a.f3873j == null) {
                        return;
                    }
                    NetworkInfo unused = C1720a.f3874k = C1720a.f3873j.getActiveNetworkInfo();
                    if (C1720a.f3874k == null || !C1720a.f3874k.isAvailable()) {
                        ULog.m538i("--->>> network disconnected.");
                        boolean unused2 = C1720a.f3876m = false;
                        return;
                    }
                    ULog.m538i("--->>> network isAvailable, check if there are any files to send.");
                    boolean unused3 = C1720a.f3876m = true;
                    synchronized (C1720a.f3878o) {
                        if (C1720a.f3877n != null && (size = C1720a.f3877n.size()) > 0) {
                            for (int i = 0; i < size; i++) {
                                ((UMSenderStateNotify) C1720a.f3877n.get(i)).onConnectionAvailable();
                            }
                        }
                    }
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "网络状态通知：尝试发送 MSG_PROCESS_NEXT");
                    C1720a.m745d();
                    if (C1720a.f3874k.getType() != 1 || context == null) {
                        return;
                    }
                    try {
                        if (UMWorkDispatch.eventHasExist(C1724a.f3909k)) {
                            return;
                        }
                        UMWorkDispatch.sendEvent(context, C1724a.f3909k, C1725b.m729a(context).m730a(), null);
                    } catch (Throwable unused4) {
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(appContext, th);
                }
            }
        }
    };

    /* renamed from: com.umeng.commonsdk.framework.a$a */
    /* loaded from: classes4.dex */
    public static class FileObserverC1723a extends FileObserver {
        public FileObserverC1723a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if ((i & 8) != 8) {
                return;
            }
            ULog.m550d("--->>> envelope file created >>> " + str);
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            C1720a.m746c(273);
        }
    }

    public C1720a(Context context, Handler handler) {
        Context appContext = UMModuleRegister.getAppContext();
        f3873j = (ConnectivityManager) appContext.getSystemService("connectivity");
        f3866c = handler;
        try {
            if (f3864a != null) {
                return;
            }
            HandlerThread handlerThread = new HandlerThread("NetWorkSender");
            f3864a = handlerThread;
            handlerThread.start();
            if (f3872i == null) {
                FileObserverC1723a fileObserverC1723a = new FileObserverC1723a(UMFrUtils.getEnvelopeDirPath(context));
                f3872i = fileObserverC1723a;
                fileObserverC1723a.startWatching();
                ULog.m550d("--->>> FileMonitor has already started!");
            }
            if (DeviceConfig.checkPermission(appContext, "android.permission.ACCESS_NETWORK_STATE") && f3873j != null && f3875l == null) {
                IntentFilter intentFilter = new IntentFilter();
                f3875l = intentFilter;
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                if (f3888y != null) {
                    appContext.registerReceiver(f3888y, f3875l);
                }
            }
            m735n();
            if (f3865b == null) {
                f3865b = new Handler(f3864a.getLooper()) { // from class: com.umeng.commonsdk.framework.a.2
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        int i = message.what;
                        if (i == 273) {
                            ULog.m550d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                            try {
                                C1720a.f3879p.tryLock(1L, TimeUnit.SECONDS);
                                try {
                                    C1720a.m731r();
                                } catch (Throwable unused) {
                                }
                                C1720a.f3879p.unlock();
                            } catch (Throwable unused2) {
                            }
                        } else if (i == 274) {
                            C1720a.m733p();
                        } else if (i != 512) {
                        } else {
                            C1720a.m732q();
                        }
                    }
                };
            }
            ImprintHandler.getImprintService(context).registImprintCallback(f3880q, this);
            ImprintHandler.getImprintService(context).registImprintCallback(f3881r, this);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    /* renamed from: a */
    public static void m754a(int i, int i2) {
        Handler handler;
        if (!f3876m || (handler = f3865b) == null) {
            return;
        }
        handler.removeMessages(i);
        Message obtainMessage = f3865b.obtainMessage();
        obtainMessage.what = i;
        f3865b.sendMessageDelayed(obtainMessage, i2);
    }

    /* renamed from: a */
    public static void m753a(int i, long j) {
        Handler handler;
        if (!f3876m || (handler = f3865b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i;
        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> sendMsgDelayed: " + j);
        f3865b.sendMessageDelayed(obtainMessage, j);
    }

    /* renamed from: a */
    public static void m751a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (f3878o) {
            if (f3877n == null) {
                f3877n = new ArrayList<>();
            }
            if (uMSenderStateNotify != null) {
                for (int i = 0; i < f3877n.size(); i++) {
                    if (uMSenderStateNotify == f3877n.get(i)) {
                        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> addConnStateObserver: input item has exist.");
                        return;
                    }
                }
                f3877n.add(uMSenderStateNotify);
            }
        }
    }

    /* renamed from: a */
    public static boolean m756a() {
        boolean z;
        synchronized (f3887x) {
            z = f3882s;
        }
        return z;
    }

    /* renamed from: b */
    public static int m749b() {
        int i;
        synchronized (f3887x) {
            i = f3886w;
        }
        return i;
    }

    /* renamed from: b */
    public static void m748b(int i) {
        Handler handler;
        if (!f3876m || (handler = f3865b) == null || handler.hasMessages(i)) {
            return;
        }
        Message obtainMessage = f3865b.obtainMessage();
        obtainMessage.what = i;
        f3865b.sendMessage(obtainMessage);
    }

    /* renamed from: c */
    public static void m747c() {
    }

    /* renamed from: c */
    public static void m746c(int i) {
        Handler handler;
        if (!f3876m || (handler = f3865b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i;
        f3865b.sendMessage(obtainMessage);
    }

    /* renamed from: d */
    public static void m745d() {
        if (f3879p.tryLock()) {
            try {
                m748b(273);
            } finally {
                f3879p.unlock();
            }
        }
    }

    /* renamed from: e */
    public static void m744e() {
        m754a(274, 3000);
    }

    /* renamed from: n */
    private void m735n() {
        synchronized (f3887x) {
            if ("11".equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f3880q, ""))) {
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                f3882s = true;
                f3886w = 15;
                int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f3881r, "15")).intValue();
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3 && intValue <= 90) {
                    f3886w = intValue * 1000;
                }
                f3886w = 15;
            } else {
                f3882s = false;
            }
        }
    }

    /* renamed from: o */
    public static void m734o() {
        if (f3864a != null) {
            f3864a = null;
        }
        if (f3865b != null) {
            f3865b = null;
        }
        if (f3866c != null) {
            f3866c = null;
        }
    }

    /* renamed from: p */
    public static void m733p() {
        int size;
        synchronized (f3878o) {
            if (f3877n != null && (size = f3877n.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    f3877n.get(i).onSenderIdle();
                }
            }
        }
    }

    /* renamed from: q */
    public static void m732q() {
    }

    /* renamed from: r */
    public static void m731r() {
        ULog.m550d("--->>> handleProcessNext: Enter...");
        if (!f3876m) {
            return;
        }
        Context appContext = UMModuleRegister.getAppContext();
        try {
            if (UMFrUtils.envelopeFileNumber(appContext) > 0) {
                ULog.m550d("--->>> The envelope file exists.");
                if (UMFrUtils.envelopeFileNumber(appContext) > 200) {
                    ULog.m550d("--->>> Number of envelope files is greater than 200, remove old files first.");
                    UMFrUtils.removeRedundantEnvelopeFiles(appContext, 200);
                }
                File envelopeFile = UMFrUtils.getEnvelopeFile(appContext);
                if (envelopeFile != null) {
                    String path = envelopeFile.getPath();
                    ULog.m550d("--->>> Ready to send envelope file [" + path + "].");
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> send envelope file [ " + path + "].");
                    if (!new C1768c(appContext).m583a(envelopeFile)) {
                        ULog.m550d("--->>> Send envelope file failed, abandon and wait next trigger!");
                        return;
                    }
                    ULog.m550d("--->>> Send envelope file success, delete it.");
                    if (!UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                        ULog.m550d("--->>> Failed to delete already processed file. We try again after delete failed.");
                        UMFrUtils.removeEnvelopeFile(envelopeFile);
                    }
                    m746c(273);
                    return;
                }
            }
            m744e();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(appContext, th);
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        synchronized (f3887x) {
            if (f3880q.equals(str)) {
                if ("11".equals(str2)) {
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                    f3882s = true;
                } else {
                    f3882s = false;
                }
            }
            if (f3881r.equals(str)) {
                int intValue = Integer.valueOf(str2).intValue();
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3 && intValue <= 90) {
                    f3886w = intValue * 1000;
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + f3886w);
                }
                f3886w = 15000;
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + f3886w);
            }
        }
    }
}

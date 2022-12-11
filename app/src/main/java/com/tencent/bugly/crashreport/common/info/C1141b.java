package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.just.agentweb.RomUtils;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import com.umeng.commonsdk.statistics.idtracking.C1783b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.tencent.bugly.crashreport.common.info.b */
/* loaded from: classes3.dex */
public class C1141b {

    /* renamed from: a */
    public static final String[] f1079a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* renamed from: b */
    public static final String[] f1080b = {"com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};

    /* renamed from: c */
    public static final String[] f1081c = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    /* renamed from: d */
    public static String f1082d;

    /* renamed from: e */
    public static String f1083e;

    /* renamed from: a */
    public static String m3379a(Context context) {
        if (context == null) {
            return "fail";
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), C1783b.f4089a);
            return string == null ? "null" : string.toLowerCase();
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                C1199X.m3078c("Failed to get Android ID.", new Object[0]);
            }
            return "fail";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
        r0 = java.lang.System.getProperty("os.arch");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m3378a(Context context, boolean z) {
        String str = null;
        if (z) {
            try {
                String m3042a = C1208ca.m3042a(context, "ro.product.cpu.abilist");
                if (C1208ca.m3012b(m3042a) || m3042a.equals("fail")) {
                    m3042a = C1208ca.m3042a(context, "ro.product.cpu.abi");
                }
                if (!C1208ca.m3012b(m3042a) && !m3042a.equals("fail")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ABI list: ");
                    sb.append(m3042a);
                    C1199X.m3085a(C1141b.class, sb.toString(), new Object[0]);
                    str = m3042a.split(",")[0];
                }
            } catch (Throwable th) {
                if (!C1199X.m3080b(th)) {
                    th.printStackTrace();
                }
                return "fail";
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: a */
    public static boolean m3380a() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static int m3377b() {
        StackTraceElement[] stackTrace;
        try {
            throw new Exception("detect hook");
        } catch (Exception e) {
            int i = 0;
            int i2 = 0;
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("main")) {
                    i |= 4;
                }
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    i |= 8;
                }
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2") && stackTraceElement.getMethodName().equals("invoked")) {
                    i |= 16;
                }
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") && (i2 = i2 + 1) == 2) {
                    i |= 32;
                }
            }
            return i;
        }
    }

    /* renamed from: b */
    public static String m3376b(Context context) {
        return C1208ca.m3042a(context, "ro.board.platform");
    }

    /* renamed from: c */
    public static int m3375c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: c */
    public static String m3374c(Context context) {
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            if (!C1199X.m3080b(e)) {
                e.printStackTrace();
            }
        }
        if (activeNetworkInfo == null) {
            return null;
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            int networkType = telephonyManager.getNetworkType();
            switch (networkType) {
                case 1:
                    return "GPRS";
                case 2:
                    return "EDGE";
                case 3:
                    return "UMTS";
                case 4:
                    return "CDMA";
                case 5:
                    return "EVDO_0";
                case 6:
                    return "EVDO_A";
                case 7:
                    return "1xRTT";
                case 8:
                    return "HSDPA";
                case 9:
                    return "HSUPA";
                case 10:
                    return "HSPA";
                case 11:
                    return "iDen";
                case 12:
                    return "EVDO_B";
                case 13:
                    return "LTE";
                case 14:
                    return "eHRPD";
                case 15:
                    return "HSPA+";
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("MOBILE(");
                    sb.append(networkType);
                    sb.append(")");
                    return sb.toString();
            }
        }
        return "unknown";
    }

    /* renamed from: d */
    public static String m3373d() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: d */
    public static String m3372d(Context context) {
        String m3042a = C1208ca.m3042a(context, "ro.miui.ui.version.name");
        if (C1208ca.m3012b(m3042a) || m3042a.equals("fail")) {
            String m3042a2 = C1208ca.m3042a(context, RomUtils.VERSION_PROPERTY_HUAWEI);
            if (!C1208ca.m3012b(m3042a2) && !m3042a2.equals("fail")) {
                return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("HuaWei/EMOTION/", m3042a2);
            }
            String m3042a3 = C1208ca.m3042a(context, "ro.lenovo.series");
            if (!C1208ca.m3012b(m3042a3) && !m3042a3.equals("fail")) {
                return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Lenovo/VIBE/", C1208ca.m3042a(context, "ro.build.version.incremental"));
            }
            String m3042a4 = C1208ca.m3042a(context, "ro.build.nubia.rom.name");
            if (!C1208ca.m3012b(m3042a4) && !m3042a4.equals("fail")) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Zte/NUBIA/", m3042a4, "_");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C1208ca.m3042a(context, "ro.build.nubia.rom.code"));
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
            String m3042a5 = C1208ca.m3042a(context, "ro.meizu.product.model");
            if (!C1208ca.m3012b(m3042a5) && !m3042a5.equals("fail")) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Meizu/FLYME/");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C1208ca.m3042a(context, "ro.build.display.id"));
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
            String m3042a6 = C1208ca.m3042a(context, "ro.build.version.opporom");
            if (!C1208ca.m3012b(m3042a6) && !m3042a6.equals("fail")) {
                return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Oppo/COLOROS/", m3042a6);
            }
            String m3042a7 = C1208ca.m3042a(context, "ro.vivo.os.build.display.id");
            if (!C1208ca.m3012b(m3042a7) && !m3042a7.equals("fail")) {
                return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("vivo/FUNTOUCH/", m3042a7);
            }
            String m3042a8 = C1208ca.m3042a(context, "ro.aa.romver");
            if (!C1208ca.m3012b(m3042a8) && !m3042a8.equals("fail")) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("htc/", m3042a8, "/");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(C1208ca.m3042a(context, "ro.build.description"));
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            }
            String m3042a9 = C1208ca.m3042a(context, "ro.lewa.version");
            if (!C1208ca.m3012b(m3042a9) && !m3042a9.equals("fail")) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("tcl/", m3042a9, "/");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(C1208ca.m3042a(context, "ro.build.display.id"));
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString();
            }
            String m3042a10 = C1208ca.m3042a(context, "ro.gn.gnromvernumber");
            if (!C1208ca.m3012b(m3042a10) && !m3042a10.equals("fail")) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("amigo/", m3042a10, "/");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(C1208ca.m3042a(context, "ro.build.display.id"));
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString();
            }
            String m3042a11 = C1208ca.m3042a(context, "ro.build.tyd.kbstyle_version");
            if (!C1208ca.m3012b(m3042a11) && !m3042a11.equals("fail")) {
                return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("dido/", m3042a11);
            }
            return C1208ca.m3042a(context, "ro.build.fingerprint") + "/" + C1208ca.m3042a(context, "ro.build.rom.id");
        }
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("XiaoMi/MIUI/", m3042a);
    }

    /* renamed from: e */
    public static String m3371e() {
        return "";
    }

    /* renamed from: e */
    public static String m3370e(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = f1080b;
            if (i >= strArr.length) {
                break;
            }
            try {
                packageManager.getPackageInfo(strArr[i], 1);
                arrayList.add(Integer.valueOf(i));
            } catch (PackageManager.NameNotFoundException unused) {
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    /* renamed from: f */
    public static String m3369f() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    /* renamed from: f */
    public static boolean m3368f(Context context) {
        return (((m3366g(context) | m3377b()) | m3355p()) | m3356o()) > 0;
    }

    /* renamed from: g */
    public static int m3366g(Context context) {
        int i;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getInstallerPackageName("de.robv.android.xposed.installer");
            i = 1;
        } catch (Exception unused) {
            i = 0;
        }
        try {
            packageManager.getInstallerPackageName("com.saurik.substrate");
            return i | 2;
        } catch (Exception unused2) {
            return i;
        }
    }

    /* renamed from: g */
    public static long m3367g() {
        if (!m3380a()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    /* renamed from: h */
    public static long m3365h() {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 2048);
                try {
                    bufferedReader2.readLine();
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e) {
                            if (!C1199X.m3080b(e)) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e2) {
                            if (!C1199X.m3080b(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long parseLong = (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024) + 0;
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e3) {
                            if (!C1199X.m3080b(e3)) {
                                e3.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e4) {
                            if (!C1199X.m3080b(e4)) {
                                e4.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long parseLong2 = Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
                    Long.signum(parseLong2);
                    long j = (parseLong2 * 1024) + parseLong;
                    String readLine3 = bufferedReader2.readLine();
                    if (readLine3 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e5) {
                            if (!C1199X.m3080b(e5)) {
                                e5.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e6) {
                            if (!C1199X.m3080b(e6)) {
                                e6.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long parseLong3 = (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024) + j;
                    try {
                        bufferedReader2.close();
                    } catch (IOException e7) {
                        if (!C1199X.m3080b(e7)) {
                            e7.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e8) {
                        if (!C1199X.m3080b(e8)) {
                            e8.printStackTrace();
                        }
                    }
                    return parseLong3;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        if (!C1199X.m3080b(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e9) {
                                if (!C1199X.m3080b(e9)) {
                                    e9.printStackTrace();
                                }
                            }
                        }
                        if (fileReader == null) {
                            return -2L;
                        }
                        try {
                            fileReader.close();
                            return -2L;
                        } catch (IOException e10) {
                            if (C1199X.m3080b(e10)) {
                                return -2L;
                            }
                            e10.printStackTrace();
                            return -2L;
                        }
                    } catch (Throwable th2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e11) {
                                if (!C1199X.m3080b(e11)) {
                                    e11.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e12) {
                                if (!C1199X.m3080b(e12)) {
                                    e12.printStackTrace();
                                }
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
    }

    /* renamed from: h */
    public static boolean m3364h(Context context) {
        return (m3370e(context) == null && m3357n() == null) ? false : true;
    }

    /* renamed from: i */
    public static long m3363i() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            if (!C1199X.m3080b(e)) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e2) {
                            if (!C1199X.m3080b(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        if (!C1199X.m3080b(e3)) {
                            e3.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e4) {
                        if (!C1199X.m3080b(e4)) {
                            e4.printStackTrace();
                        }
                    }
                    return parseLong;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!C1199X.m3080b(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                                if (!C1199X.m3080b(e5)) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                        if (fileReader == null) {
                            return -2L;
                        }
                        try {
                            fileReader.close();
                            return -2L;
                        } catch (IOException e6) {
                            if (C1199X.m3080b(e6)) {
                                return -2L;
                            }
                            e6.printStackTrace();
                            return -2L;
                        }
                    } catch (Throwable th3) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e7) {
                                if (!C1199X.m3080b(e7)) {
                                    e7.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e8) {
                                if (!C1199X.m3080b(e8)) {
                                    e8.printStackTrace();
                                }
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            fileReader = null;
            th = th5;
            bufferedReader = null;
        }
    }

    /* renamed from: i */
    public static boolean m3362i(Context context) {
        float maxMemory = (float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
        float f = (float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
        float f2 = maxMemory - f;
        C1199X.m3084a("maxMemory : %f", Float.valueOf(maxMemory));
        C1199X.m3084a("totalMemory : %f", Float.valueOf(f));
        C1199X.m3084a("freeMemory : %f", Float.valueOf(f2));
        return f2 < 10.0f;
    }

    /* renamed from: j */
    public static long m3361j() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    /* renamed from: k */
    public static long m3360k() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    /* renamed from: l */
    public static long m3359l() {
        if (!m3380a()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    /* renamed from: m */
    public static String m3358m() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    /* renamed from: n */
    public static String m3357n() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = f1081c;
            if (i >= strArr.length) {
                break;
            } else if (i == 0) {
                if (new File(strArr[i]).exists()) {
                    i++;
                }
                arrayList.add(Integer.valueOf(i));
                i++;
            } else {
                if (!new File(strArr[i]).exists()) {
                    i++;
                }
                arrayList.add(Integer.valueOf(i));
                i++;
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    /* renamed from: o */
    public static int m3356o() {
        Method method;
        try {
            method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
            method.setAccessible(true);
        } catch (Exception unused) {
        }
        return method.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy") ? 256 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a8, code lost:
        if (r3 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0093, code lost:
        if (r3 == null) goto L46;
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00b1: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:64:0x00b1 */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m3355p() {
        BufferedReader bufferedReader;
        IOException e;
        UnsupportedEncodingException e2;
        FileNotFoundException e3;
        BufferedReader bufferedReader2;
        int i = 0;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                HashSet hashSet = new HashSet();
                StringBuilder sb = new StringBuilder();
                sb.append("/proc/");
                sb.append(Process.myPid());
                sb.append("/maps");
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(sb.toString()), "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                            hashSet.add(readLine.substring(readLine.lastIndexOf(StringUtils.SPACE) + 1));
                        }
                    } catch (FileNotFoundException e4) {
                        e3 = e4;
                        e3.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return i;
                    } catch (UnsupportedEncodingException e5) {
                        e2 = e5;
                        e2.printStackTrace();
                    } catch (IOException e6) {
                        e = e6;
                        e.printStackTrace();
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (((String) next).toLowerCase().contains("xposed")) {
                        i |= 64;
                    }
                    if (((String) next).contains("com.saurik.substrate")) {
                        i |= 128;
                    }
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader3 = bufferedReader2;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e8) {
            bufferedReader = null;
            e3 = e8;
        } catch (UnsupportedEncodingException e9) {
            bufferedReader = null;
            e2 = e9;
        } catch (IOException e10) {
            bufferedReader = null;
            e = e10;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader3 != null) {
            }
            throw th;
        }
        try {
            bufferedReader.close();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        return i;
    }

    /* renamed from: q */
    public static boolean m3354q() {
        boolean z;
        String[] strArr = f1079a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (new File(strArr[i]).exists()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || z;
    }
}

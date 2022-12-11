package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.stub.StubApp;
import com.tencent.smtt.sdk.C1356c;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsPrivacyAccess;
import com.umeng.commonsdk.statistics.idtracking.C1783b;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import me.tvspark.outline;
import org.apache.commons.p056io.input.Tailer;

/* renamed from: com.tencent.smtt.utils.b */
/* loaded from: classes4.dex */
public class C1429b {

    /* renamed from: a */
    public static String f2389a = "";

    /* renamed from: b */
    public static String f2390b = "";

    /* renamed from: c */
    public static String f2391c = "";

    /* renamed from: d */
    public static String f2392d = "";

    /* renamed from: e */
    public static String f2393e = "";

    /* renamed from: f */
    public static String f2394f = "";

    /* renamed from: g */
    public static String f2395g = "";

    /* renamed from: h */
    public static boolean f2396h;

    /* renamed from: i */
    public static boolean f2397i;

    /* renamed from: j */
    public static boolean f2398j;

    /* renamed from: k */
    public static boolean f2399k;

    /* renamed from: l */
    public static boolean f2400l;

    /* renamed from: a */
    public static String m2130a() {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        String str = "os.arch";
        if (!f2398j) {
            String str2 = null;
            try {
                inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream());
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        str = m2124a(bufferedReader.readLine().contains("x86") ? "i686" : System.getProperty(str));
                        if (TextUtils.isEmpty(str)) {
                            f2391c = str;
                        }
                        try {
                            bufferedReader.close();
                        } catch (IOException unused) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            str2 = m2124a(System.getProperty(str));
                            th.printStackTrace();
                        } finally {
                            if (TextUtils.isEmpty(str2)) {
                                f2391c = str2;
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused2) {
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException unused3) {
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                inputStreamReader = null;
            }
            try {
                inputStreamReader.close();
            } catch (IOException unused4) {
                f2398j = true;
                return f2391c;
            }
        }
        return f2391c;
    }

    /* renamed from: a */
    public static String m2129a(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a A[Catch: Exception -> 0x002f, TRY_LEAVE, TryCatch #0 {Exception -> 0x002f, blocks: (B:3:0x0003, B:5:0x0013, B:7:0x0017, B:9:0x001c, B:11:0x002a, B:16:0x0022), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m2128a(Context context, File file) {
        Signature signature;
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 65);
            if (packageArchiveInfo != null) {
                if (packageArchiveInfo.signatures != null && packageArchiveInfo.signatures.length > 0) {
                    signature = packageArchiveInfo.signatures[0];
                    if (signature != null) {
                        return null;
                    }
                    return signature.toCharsString();
                }
                TbsLog.m2148w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
            }
            signature = null;
            if (signature != null) {
            }
        } catch (Exception unused) {
            TbsLog.m2155i("AppUtil", "getSign " + file + "failed");
            return null;
        }
    }

    /* renamed from: a */
    public static String m2127a(Context context, String str) {
        String str2;
        try {
            try {
                return String.valueOf(Integer.toHexString(Integer.parseInt(String.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str)))));
            } catch (Exception unused) {
                return str2;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x006a A[Catch: all -> 0x007b, TryCatch #6 {all -> 0x007b, blocks: (B:42:0x0056, B:44:0x006a, B:46:0x0075), top: B:41:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m2126a(Context context, boolean z, File file) {
        String m2128a;
        RandomAccessFile randomAccessFile;
        Exception e;
        byte[] bArr;
        if (file == null || !file.exists()) {
            return "";
        }
        if (z) {
            RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    bArr = new byte[2];
                    randomAccessFile = new RandomAccessFile(file, Tailer.RAF_MODE);
                    try {
                        try {
                            randomAccessFile.read(bArr);
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            randomAccessFile.close();
                            if (StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName().contains("com.jd.jrapp")) {
                            }
                            TbsLog.m2155i("AppUtil", "[AppUtil.getSignatureFromApk]  #4");
                            m2128a = m2128a(context, file);
                            TbsLog.m2155i("AppUtil", "[AppUtil.getSignatureFromApk]  android api signature=" + m2128a);
                            if (m2128a == null) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        randomAccessFile2 = randomAccessFile;
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                randomAccessFile = null;
                e = e5;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2.close();
                throw th;
            }
            if (!new String(bArr).equalsIgnoreCase("PK")) {
                try {
                    randomAccessFile.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                return "";
            }
            randomAccessFile.close();
        }
        try {
            if (StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName().contains("com.jd.jrapp")) {
                TbsLog.m2155i("AppUtil", "[AppUtil.getSignatureFromApk]  #1");
                String m2125a = m2125a(file);
                if (m2125a != null) {
                    TbsLog.m2155i("AppUtil", "[AppUtil.getSignatureFromApk]  #2");
                    return m2125a;
                }
            }
        } catch (Throwable unused) {
            TbsLog.m2155i("AppUtil", "[AppUtil.getSignatureFromApk]  #3");
        }
        TbsLog.m2155i("AppUtil", "[AppUtil.getSignatureFromApk]  #4");
        m2128a = m2128a(context, file);
        TbsLog.m2155i("AppUtil", "[AppUtil.getSignatureFromApk]  android api signature=" + m2128a);
        if (m2128a == null) {
            return m2128a;
        }
        String m2125a2 = m2125a(file);
        TbsLog.m2155i("AppUtil", "[AppUtil.getSignatureFromApk]  java get signature=" + m2125a2);
        return m2125a2;
    }

    /* renamed from: a */
    public static String m2125a(File file) {
        try {
            JarFile jarFile = new JarFile(file);
            byte[] bArr = new byte[8192];
            String m2122a = m2122a(m2123a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), bArr)[0].getEncoded());
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (name != null) {
                    Certificate[] m2123a = m2123a(jarFile, nextElement, bArr);
                    String m2122a2 = m2123a != null ? m2122a(m2123a[0].getEncoded()) : null;
                    if (m2122a2 == null) {
                        if (!name.startsWith("META-INF/")) {
                            return null;
                        }
                    } else if (!m2122a2.equals(m2122a)) {
                        return null;
                    }
                }
            }
            return m2122a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m2124a(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: a */
    public static String m2122a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = (b >> 4) & 15;
            int i3 = i * 2;
            cArr[i3] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            int i4 = b & 15;
            cArr[i3 + 1] = (char) (i4 >= 10 ? (i4 + 97) - 10 : i4 + 48);
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static Certificate[] m2123a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) throws Exception {
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        do {
        } while (inputStream.read(bArr, 0, bArr.length) != -1);
        inputStream.close();
        if (jarEntry != null) {
            return jarEntry.getCertificates();
        }
        return null;
    }

    /* renamed from: b */
    public static int m2120b(Context context) {
        if (TbsPrivacyAccess.AndroidVersion.isDisabled()) {
            return 0;
        }
        return Build.VERSION.SDK_INT;
    }

    /* renamed from: b */
    public static void m2119b(Context context, String str) {
        try {
            TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_GUID, str);
            tbsDownloadConfig.commit();
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static boolean m2121b() {
        Class<?> cls;
        Method declaredMethod;
        Object invoke;
        Method declaredMethod2;
        try {
            cls = Class.forName("dalvik.system.VMRuntime");
            declaredMethod = cls.getDeclaredMethod("getRuntime", new Class[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (declaredMethod == null || (invoke = declaredMethod.invoke(null, new Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("is64Bit", new Class[0])) == null) {
            return false;
        }
        Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
        if (invoke2 instanceof Boolean) {
            return ((Boolean) invoke2).booleanValue();
        }
        return false;
    }

    /* renamed from: c */
    public static String m2118c(Context context) {
        if (TbsPrivacyAccess.DeviceModel.isDisabled()) {
            return "";
        }
        if (!f2400l) {
            String m1976d = C1472q.m1976d(context);
            try {
                f2394f = new String(m1976d.getBytes("UTF-8"), "ISO8859-1");
            } catch (Exception unused) {
                f2394f = m1976d;
            }
            f2400l = true;
        }
        return f2394f;
    }

    /* renamed from: d */
    public static String m2117d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: e */
    public static int m2116e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: f */
    public static String m2115f(Context context) {
        try {
            return TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_GUID, "");
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: g */
    public static boolean m2114g(final Context context) {
        boolean z = false;
        try {
            z = context.getSharedPreferences("sai", 0).getBoolean("gi", false);
            TbsLog.m2155i("AppUtil", "getImeiEnable is " + z);
            C1356c.m2620a().m2617a(context, (Integer) 1001, new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.b.1
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = context.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("gi", true);
                    edit.commit();
                    TbsLog.m2158e("TBSEmergency", "Execute command [1001](" + str + ")");
                }
            });
            return z;
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "AppUtil");
            return z;
        }
    }

    /* renamed from: h */
    public static String m2113h(Context context) {
        if (!QbSdk.isEnableSensitiveApi()) {
            TbsLog.m2155i("AppUtil", "getImei isEnableSensitiveApi = false");
            return "";
        }
        if (!f2396h) {
            try {
                String m2108m = m2108m(context);
                f2389a = m2108m;
                if (TextUtils.isEmpty(m2108m)) {
                    f2389a = C1461j.m2046a(context);
                }
            } catch (Exception e) {
                TbsLog.m2152i(e);
            }
            f2396h = true;
        }
        return f2389a;
    }

    /* renamed from: i */
    public static String m2112i(Context context) {
        String str;
        if (!QbSdk.isEnableSensitiveApi()) {
            str = "getImsi isEnableSensitiveApi = false";
        } else if (QbSdk.isEnableCanGetSubscriberId()) {
            if (!f2397i) {
                try {
                } catch (Exception e) {
                    TbsLog.m2152i(e);
                }
                if (context.getApplicationInfo().packageName.contains(TbsConfig.APP_QQ)) {
                    return "";
                }
                f2390b = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                f2397i = true;
            }
            return f2390b;
        } else {
            str = "getImsi isEnableCanGetSubscriberId is false";
        }
        TbsLog.m2155i("AppUtil", str);
        return "";
    }

    /* renamed from: j */
    public static String m2111j(Context context) {
        return Envelope.dummyID2;
    }

    /* renamed from: k */
    public static String m2110k(Context context) {
        String str;
        if (!QbSdk.isEnableSensitiveApi()) {
            str = "getAndroidID isEnableSensitiveApi = false";
        } else if (!QbSdk.isEnableGetAndroidID()) {
            str = "getAndroidID isEnableGetAndroidID is false";
        } else if (m2106o(context)) {
            if (!f2399k) {
                try {
                    f2393e = Settings.Secure.getString(context.getContentResolver(), C1783b.f4089a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                f2399k = true;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getAndroidID mAndroidID is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f2393e);
            TbsLog.m2155i("AppUtil", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return f2393e;
        } else {
            str = "getAndroidID isAndroidIDEnable is false";
        }
        TbsLog.m2155i("AppUtil", str);
        return "";
    }

    /* renamed from: l */
    public static boolean m2109l(Context context) {
        return context != null && context.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    /* renamed from: m */
    public static String m2108m(Context context) {
        try {
        } catch (Exception e) {
            TbsLog.m2152i(e);
        }
        if (!QbSdk.isEnableGetDeviceID()) {
            TbsLog.m2155i("AppUtil", "getDeviceID isEnableGetDeviceID is false");
            return "";
        } else if (!m2107n(context)) {
            TbsLog.m2155i("AppUtil", "getDeviceID isDeviceIDEnable is false");
            return "";
        } else {
            f2395g = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getDeviceID mDeviceID is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f2395g);
            TbsLog.m2155i("AppUtil", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return f2395g;
        }
    }

    /* renamed from: n */
    public static boolean m2107n(final Context context) {
        boolean z = false;
        try {
            z = context.getSharedPreferences("sai", 0).getBoolean("pdi", false);
            TbsLog.m2155i("AppUtil", "isDeviceIDEnable is " + z);
            C1356c m2620a = C1356c.m2620a();
            m2620a.m2617a(context, (Integer) 1004, new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.b.2
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = context.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("pdi", false);
                    edit.commit();
                    TbsLog.m2158e("TBSEmergency", "Execute command [1004](" + str + ")");
                }
            });
            m2620a.m2617a(context, Integer.valueOf((int) PointerIconCompat.TYPE_ALIAS), new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.b.3
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = context.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("pdi", true);
                    edit.commit();
                    TbsLog.m2158e("TBSEmergency", "Execute command [1010](+extra+)");
                }
            });
            return z;
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "AppUtil");
            return z;
        }
    }

    /* renamed from: o */
    public static boolean m2106o(final Context context) {
        boolean z = false;
        try {
            z = context.getSharedPreferences("sai", 0).getBoolean("gpai", false);
            TbsLog.m2155i("AppUtil", "isAndroidIDEnable is " + z);
            C1356c m2620a = C1356c.m2620a();
            m2620a.m2617a(context, Integer.valueOf((int) PointerIconCompat.TYPE_NO_DROP), new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.b.4
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = context.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("gpai", false);
                    edit.commit();
                    TbsLog.m2158e("TBSEmergency", "Execute command [1012](+extra+)");
                }
            });
            m2620a.m2617a(context, Integer.valueOf((int) PointerIconCompat.TYPE_COPY), new C1356c.AbstractC1357a() { // from class: com.tencent.smtt.utils.b.5
                @Override // com.tencent.smtt.sdk.C1356c.AbstractC1357a
                /* renamed from: a */
                public void mo1965a(String str) {
                    SharedPreferences.Editor edit = context.getSharedPreferences("sai", 0).edit();
                    edit.putBoolean("gpai", true);
                    edit.commit();
                    TbsLog.m2158e("TBSEmergency", "Execute command [1011](+extra+)");
                }
            });
            return z;
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "AppUtil");
            return z;
        }
    }
}

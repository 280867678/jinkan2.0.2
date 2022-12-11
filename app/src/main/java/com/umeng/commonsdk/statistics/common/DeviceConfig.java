package com.umeng.commonsdk.statistics.common;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.appcompat.widget.ActivityChooserModel;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.idtracking.C1783b;
import com.umeng.commonsdk.statistics.idtracking.C1790h;
import com.umeng.commonsdk.utils.C1847b;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import javax.microedition.khronos.opengles.GL10;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.litepal.crud.LitePalSupport;
import org.mozilla.javascript.tools.idswitch.Main;

/* loaded from: classes4.dex */
public class DeviceConfig {
    public static final int DEFAULT_TIMEZONE = 8;
    public static final String KEY_EMUI_VERSION_CODE = "ro.build.hw_emui_api_level";
    public static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    public static final String LOG_TAG = "com.umeng.commonsdk.statistics.common.DeviceConfig";
    public static final String MOBILE_NETWORK = "2G/3G";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";
    public static DeviceTypeEnum deviceTypeEnum = DeviceTypeEnum.DEFAULT;
    public static volatile String sWifiMac = "";
    public static volatile String sImei = "";
    public static volatile String sMeid = "";
    public static volatile String sImsi = "";
    public static volatile String sSerialNo = "";
    public static volatile String sAndroidID = "";
    public static volatile String sIDFA = "";
    public static volatile String sOAID = "";
    public static volatile String sSecondImei = "";
    public static volatile String sSimSerialNumber = "";
    public static volatile boolean sImeiOrMeidFlag = false;
    public static volatile boolean sSerialFlag = false;
    public static volatile boolean sSimSerialNumberFlag = false;
    public static volatile boolean sImsiFlag = false;
    public static volatile boolean sSecondImeiFlag = false;

    public static String byte2HexFormatted(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("0", hexString);
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase(Locale.getDefault()));
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    public static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable unused) {
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static String getAndroidId(Context context) {
        if (!TextUtils.isEmpty(sAndroidID)) {
            return sAndroidID;
        }
        String str = null;
        if (!FieldManager.allow(C1847b.f4297i) || context == null) {
            return null;
        }
        try {
            str = Settings.Secure.getString(context.getContentResolver(), C1783b.f4089a);
            sAndroidID = str;
            return str;
        } catch (Exception unused) {
            if (!AnalyticsConstants.UM_DEBUG) {
                return str;
            }
            MLog.m556w("can't read android id");
            return str;
        }
    }

    public static String getAppHashKey(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures;
            if (signatureArr.length <= 0) {
                return null;
            }
            Signature signature = signatureArr[0];
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(signature.toByteArray());
            return Base64.encodeToString(messageDigest.digest(), 0).trim();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getAppMD5Signature(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return byte2HexFormatted(MessageDigest.getInstance(LitePalSupport.MD5).digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getAppName(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
            if (!AnalyticsConstants.UM_DEBUG) {
                return null;
            }
            MLog.m566i(LOG_TAG, th);
            return null;
        }
    }

    public static String getAppSHA1Key(Context context) {
        try {
            return byte2HexFormatted(MessageDigest.getInstance("SHA1").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getAppVersionCode(Context context) {
        return UMUtils.getAppVersionCode(context);
    }

    public static String getAppVersionName(Context context) {
        return UMUtils.getAppVersionName(context);
    }

    public static String getApplicationLable(Context context) {
        return context == null ? "" : context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    public static Properties getBuildProp() {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            } catch (Throwable unused) {
            }
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
            } catch (Throwable unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return properties;
            }
        } catch (Throwable unused3) {
        }
        return properties;
    }

    public static String getCPU() {
        String str = null;
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
            str = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            MLog.m573e(LOG_TAG, "Could not open file /proc/cpuinfo", e);
        }
        return str != null ? str.substring(str.indexOf(58) + 1).trim() : "";
    }

    public static String getDBencryptID(Context context) {
        return UMUtils.genId();
    }

    public static String getDeviceId(Context context) {
        return AnalyticsConstants.getDeviceType() == 2 ? getDeviceIdForBox(context) : getDeviceIdForGeneral(context);
    }

    public static String getDeviceIdForBox(Context context) {
        DeviceTypeEnum deviceTypeEnum2;
        String str = "";
        if (context == null) {
            return str;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (FieldManager.allow(C1847b.f4297i)) {
                str = getAndroidId(context);
                deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                if (AnalyticsConstants.UM_DEBUG) {
                    String str2 = LOG_TAG;
                    MLog.m565i(str2, "getDeviceId, ANDROID_ID: " + str);
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = getMacBySystemInterface(context);
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (AnalyticsConstants.UM_DEBUG) {
                    String str3 = LOG_TAG;
                    MLog.m565i(str3, "getDeviceId, MAC: " + str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = getSerialNo();
                    deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                    if (TextUtils.isEmpty(str)) {
                        str = getIMEI(context);
                    }
                }
            }
            return str;
        }
        if (Build.VERSION.SDK_INT == 23) {
            if (FieldManager.allow(C1847b.f4297i)) {
                str = getAndroidId(context);
                deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                if (AnalyticsConstants.UM_DEBUG) {
                    String str4 = LOG_TAG;
                    MLog.m565i(str4, "getDeviceId, ANDROID_ID: " + str);
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = getMacByJavaAPI();
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (TextUtils.isEmpty(str)) {
                    str = AnalyticsConstants.CHECK_DEVICE ? getMacShell() : getMacBySystemInterface(context);
                    deviceTypeEnum = DeviceTypeEnum.MAC;
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    String str5 = LOG_TAG;
                    MLog.m565i(str5, "getDeviceId, MAC: " + str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = getSerialNo();
                    deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                    if (TextUtils.isEmpty(str)) {
                        str = getIMEI(context);
                    }
                }
            }
        } else if (Build.VERSION.SDK_INT >= 29) {
            str = getOaid(context);
            deviceTypeEnum = DeviceTypeEnum.OAID;
            if (TextUtils.isEmpty(str)) {
                str = getIdfa(context);
                deviceTypeEnum = DeviceTypeEnum.IDFA;
                if (TextUtils.isEmpty(str)) {
                    str = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (TextUtils.isEmpty(str)) {
                        str = getSerialNo();
                        deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                        if (TextUtils.isEmpty(str)) {
                            str = getMacByJavaAPI();
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                            if (TextUtils.isEmpty(str)) {
                                str = getMacBySystemInterface(context);
                                deviceTypeEnum2 = DeviceTypeEnum.MAC;
                                deviceTypeEnum = deviceTypeEnum2;
                            }
                        }
                    }
                }
            }
        } else {
            if (FieldManager.allow(C1847b.f4297i)) {
                str = getAndroidId(context);
                deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                if (AnalyticsConstants.UM_DEBUG) {
                    String str6 = LOG_TAG;
                    MLog.m565i(str6, "getDeviceId: ANDROID_ID: " + str);
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (TextUtils.isEmpty(str)) {
                    str = getIMEI(context);
                    deviceTypeEnum = DeviceTypeEnum.IMEI;
                    if (TextUtils.isEmpty(str)) {
                        str = getMacByJavaAPI();
                        deviceTypeEnum = DeviceTypeEnum.MAC;
                        if (TextUtils.isEmpty(str)) {
                            str = getMacBySystemInterface(context);
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                            if (AnalyticsConstants.UM_DEBUG) {
                                String str7 = LOG_TAG;
                                MLog.m565i(str7, "getDeviceId, MAC: " + str);
                            }
                        }
                    }
                }
            }
        }
        return str;
        deviceTypeEnum2 = DeviceTypeEnum.IMEI;
        deviceTypeEnum = deviceTypeEnum2;
        return str;
    }

    public static String getDeviceIdForGeneral(Context context) {
        DeviceTypeEnum deviceTypeEnum2;
        String str = "";
        if (context == null) {
            return str;
        }
        if (Build.VERSION.SDK_INT < 23) {
            str = getIMEI(context);
            deviceTypeEnum = DeviceTypeEnum.IMEI;
            if (TextUtils.isEmpty(str)) {
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.m553w(LOG_TAG, "No IMEI.");
                }
                str = getMacBySystemInterface(context);
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (TextUtils.isEmpty(str)) {
                    if (FieldManager.allow(C1847b.f4297i)) {
                        str = getAndroidId(context);
                        deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                        if (AnalyticsConstants.UM_DEBUG) {
                            String str2 = LOG_TAG;
                            MLog.m565i(str2, "getDeviceId, ANDROID_ID: " + str);
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = getSerialNo();
                    }
                }
            }
            return str;
        }
        if (Build.VERSION.SDK_INT == 23) {
            str = getIMEI(context);
            deviceTypeEnum = DeviceTypeEnum.IMEI;
            if (TextUtils.isEmpty(str)) {
                str = getMacByJavaAPI();
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (TextUtils.isEmpty(str)) {
                    str = AnalyticsConstants.CHECK_DEVICE ? getMacShell() : getMacBySystemInterface(context);
                    deviceTypeEnum = DeviceTypeEnum.MAC;
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    String str3 = LOG_TAG;
                    MLog.m565i(str3, "getDeviceId, MAC: " + str);
                }
                if (TextUtils.isEmpty(str)) {
                    if (FieldManager.allow(C1847b.f4297i)) {
                        str = getAndroidId(context);
                        deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                        if (AnalyticsConstants.UM_DEBUG) {
                            String str4 = LOG_TAG;
                            MLog.m565i(str4, "getDeviceId, ANDROID_ID: " + str);
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = getSerialNo();
                    }
                }
            }
        } else if (Build.VERSION.SDK_INT >= 29) {
            str = getOaid(context);
            deviceTypeEnum = DeviceTypeEnum.OAID;
            if (TextUtils.isEmpty(str)) {
                str = getIdfa(context);
                deviceTypeEnum = DeviceTypeEnum.IDFA;
                if (TextUtils.isEmpty(str)) {
                    str = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (TextUtils.isEmpty(str)) {
                        str = getSerialNo();
                        deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                        if (TextUtils.isEmpty(str)) {
                            str = getMacByJavaAPI();
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                            if (TextUtils.isEmpty(str)) {
                                str = getMacBySystemInterface(context);
                                deviceTypeEnum2 = DeviceTypeEnum.MAC;
                                deviceTypeEnum = deviceTypeEnum2;
                            }
                        }
                    }
                }
            }
        } else {
            str = getIMEI(context);
            deviceTypeEnum = DeviceTypeEnum.IMEI;
            if (TextUtils.isEmpty(str)) {
                str = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (TextUtils.isEmpty(str)) {
                    if (FieldManager.allow(C1847b.f4297i)) {
                        str = getAndroidId(context);
                        deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                        if (AnalyticsConstants.UM_DEBUG) {
                            String str5 = LOG_TAG;
                            MLog.m565i(str5, "getDeviceId, ANDROID_ID: " + str);
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = getMacByJavaAPI();
                        deviceTypeEnum = DeviceTypeEnum.MAC;
                        if (TextUtils.isEmpty(str)) {
                            str = getMacBySystemInterface(context);
                            deviceTypeEnum = DeviceTypeEnum.MAC;
                            if (AnalyticsConstants.UM_DEBUG) {
                                String str6 = LOG_TAG;
                                MLog.m565i(str6, "getDeviceId, MAC: " + str);
                            }
                        }
                    }
                }
            }
        }
        return str;
        deviceTypeEnum2 = DeviceTypeEnum.SERIALNO;
        deviceTypeEnum = deviceTypeEnum2;
        return str;
    }

    public static String getDeviceIdType() {
        return deviceTypeEnum.getDeviceIdType();
    }

    public static String getDeviceIdUmengMD5(Context context) {
        return HelperUtils.getUmengMD5(getDeviceId(context));
    }

    public static String getDeviceType(Context context) {
        if (context == null) {
            return "Phone";
        }
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3 ? "Tablet" : "Phone";
        } catch (Throwable unused) {
            return "Phone";
        }
    }

    public static String getDisplayResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                int i = displayMetrics.widthPixels;
                int i2 = displayMetrics.heightPixels;
                return String.valueOf(i2) + "*" + String.valueOf(i);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String getEmuiVersion(Properties properties) {
        try {
            return properties.getProperty(KEY_EMUI_VERSION_CODE, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getFlymeVersion(Properties properties) {
        try {
            String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (!lowerCase.contains("flyme os")) {
                return null;
            }
            return lowerCase.split(StringUtils.SPACE)[2];
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.m573e(LOG_TAG, "Could not read gpu infor:", th);
            }
            return new String[0];
        }
    }

    public static Activity getGlobleActivity(Context context) {
        Activity activity = null;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(invoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                    declaredField3.setAccessible(true);
                    activity = (Activity) declaredField3.get(obj);
                }
            }
        } catch (Throwable unused) {
        }
        return activity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0073, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getIMEI(Context context) {
        if (!TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        String str = "";
        if (Build.VERSION.SDK_INT >= 29 && sImeiOrMeidFlag) {
            return str;
        }
        if (FieldManager.allow(C1847b.f4295g)) {
            if (context == null) {
                return str;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                try {
                    if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                        String deviceId = telephonyManager.getDeviceId();
                        try {
                            if (AnalyticsConstants.UM_DEBUG) {
                                String str2 = LOG_TAG;
                                MLog.m565i(str2, "getDeviceId, IMEI: " + deviceId);
                            }
                            str = deviceId;
                        } catch (Throwable th) {
                            th = th;
                            str = deviceId;
                            try {
                                if (AnalyticsConstants.UM_DEBUG) {
                                    MLog.m555w(LOG_TAG, "No IMEI.", th);
                                }
                            } finally {
                                if (Build.VERSION.SDK_INT >= 29) {
                                    sImeiOrMeidFlag = true;
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        sImei = str;
        return sImei;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014 A[Catch: SocketException -> 0x0069, TryCatch #0 {SocketException -> 0x0069, blocks: (B:6:0x000e, B:8:0x0014, B:9:0x0026, B:11:0x002c, B:14:0x003a, B:16:0x003e, B:19:0x004a, B:20:0x004e, B:23:0x0054, B:26:0x0058, B:31:0x0064), top: B:5:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getIPAddress(Context context) {
        String str;
        String str2 = null;
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            str = null;
            while (!it.hasNext()) {
                try {
                    NetworkInterface networkInterface = (NetworkInterface) it.next();
                    Iterator it2 = Collections.list(networkInterface.getInetAddresses()).iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            InetAddress inetAddress = (InetAddress) it2.next();
                            if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address) && !networkInterface.getDisplayName().contains("dummy") && str2 == null) {
                                str2 = inetAddress.getHostAddress();
                            }
                            if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet6Address) && !networkInterface.getDisplayName().contains("dummy") && str == null) {
                                str = inetAddress.getHostAddress();
                            }
                        }
                    }
                    if (!it.hasNext()) {
                    }
                } catch (SocketException unused) {
                    str2 = str;
                    str = str2;
                    str2 = "SocketException";
                    if (str2 == null) {
                    }
                }
            }
        } catch (SocketException unused2) {
        }
        return str2 == null ? str2 : str == null ? "null" : str;
    }

    public static String getIdfa(Context context) {
        if (!TextUtils.isEmpty(sIDFA)) {
            return sIDFA;
        }
        String str = "";
        try {
            if (!FieldManager.allow(C1847b.f4311w)) {
                return str;
            }
            str = C1770a.m520a(context);
            sIDFA = str;
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 29) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0043, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sImei = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0052, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getImei(Context context) {
        TelephonyManager telephonyManager;
        if (!TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 29 && sImeiOrMeidFlag) {
                return null;
            }
            if (FieldManager.allow(C1847b.f4295g) && context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null && checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                str = telephonyManager.getDeviceId();
            }
        } catch (Throwable th) {
            try {
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.m554w("No IMEI.", th);
                }
            } finally {
                if (Build.VERSION.SDK_INT >= 29) {
                    sImeiOrMeidFlag = true;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 29) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0067, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0079, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sImei = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007b, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0076, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getImeiNew(Context context) {
        TelephonyManager telephonyManager;
        if (!TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 29 && sImeiOrMeidFlag) {
                return null;
            }
            if (FieldManager.allow(C1847b.f4295g) && context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null && checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        Method method = telephonyManager.getClass().getMethod("getImei", new Class[0]);
                        method.setAccessible(true);
                        str = (String) method.invoke(telephonyManager, new Object[0]);
                    } catch (Throwable unused) {
                    }
                }
                str = telephonyManager.getDeviceId();
            }
        } catch (Throwable th) {
            try {
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.m554w("No IMEI.", th);
                }
            } finally {
                if (Build.VERSION.SDK_INT >= 29) {
                    sImeiOrMeidFlag = true;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 29) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sImsiFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getImsi(Context context) {
        if (!TextUtils.isEmpty(sImsi)) {
            return sImsi;
        }
        String str = null;
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 29 && sImsiFlag) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (FieldManager.allow(C1847b.f4285ai)) {
            try {
                if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                    str = telephonyManager.getSubscriberId();
                }
            } catch (Throwable unused) {
            }
        }
        sImsi = str;
        return sImsi;
    }

    public static Locale getLocale(Context context) {
        Locale locale;
        if (context == null) {
            return Locale.getDefault();
        }
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            locale = configuration.locale;
        } catch (Throwable unused) {
            MLog.m571e(LOG_TAG, "fail to read user config locale");
            locale = null;
        }
        return locale == null ? Locale.getDefault() : locale;
    }

    public static String[] getLocaleInfo(Context context) {
        String[] strArr = {"Unknown", "Unknown"};
        if (context == null) {
            return strArr;
        }
        try {
            Locale locale = getLocale(context);
            if (locale != null) {
                strArr[0] = locale.getCountry();
                strArr[1] = locale.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
            return strArr;
        } catch (Throwable th) {
            MLog.m573e(LOG_TAG, "error in getLocaleInfo", th);
            return strArr;
        }
    }

    public static String getMCCMNC(Context context) {
        if (context == null) {
            return null;
        }
        if (getImsi(context) == null) {
            return null;
        }
        int i = context.getResources().getConfiguration().mcc;
        int i2 = context.getResources().getConfiguration().mnc;
        if (i != 0) {
            String valueOf = String.valueOf(i2);
            if (i2 < 10) {
                valueOf = String.format("%02d", Integer.valueOf(i2));
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.valueOf(i));
            stringBuffer.append(valueOf);
            return stringBuffer.toString();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getMac(Context context) {
        if (!TextUtils.isEmpty(sWifiMac)) {
            return sWifiMac;
        }
        String str = "";
        if (FieldManager.allow(C1847b.f4296h)) {
            if (context == null) {
                return str;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                if (i == 23) {
                    str = getMacByJavaAPI();
                    if (TextUtils.isEmpty(str)) {
                        if (AnalyticsConstants.CHECK_DEVICE) {
                            str = getMacShell();
                        }
                    }
                } else {
                    str = getMacByJavaAPI();
                }
            }
            str = getMacBySystemInterface(context);
        }
        sWifiMac = str;
        return sWifiMac;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0013 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:3:0x0001, B:5:0x0009, B:6:0x000d, B:8:0x0013, B:10:0x0025, B:13:0x0031, B:15:0x0037, B:20:0x003b, B:23:0x0046, B:25:0x005c, B:27:0x0062, B:28:0x006a), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getMacByJavaAPI() {
        try {
            if (!FieldManager.allow(C1847b.f4296h)) {
                return null;
            }
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if ("wlan0".equals(nextElement.getName()) || "eth0".equals(nextElement.getName())) {
                    byte[] hardwareAddress = nextElement.getHardwareAddress();
                    if (hardwareAddress != null && hardwareAddress.length != 0) {
                        StringBuilder sb = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString().toLowerCase(Locale.getDefault());
                    }
                    return null;
                }
                while (networkInterfaces.hasMoreElements()) {
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getMacBySystemInterface(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (FieldManager.allow(C1847b.f4296h)) {
                WifiManager wifiManager = (WifiManager) context.getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
                if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                    return wifiManager != null ? wifiManager.getConnectionInfo().getMacAddress() : "";
                } else if (AnalyticsConstants.UM_DEBUG) {
                    MLog.m553w(LOG_TAG, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
                }
            }
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str = LOG_TAG;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not get mac address.");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.toString());
                MLog.m553w(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            return "";
        }
    }

    public static String getMacShell() {
        try {
            if (!FieldManager.allow(C1847b.f4296h)) {
                return null;
            }
            String[] strArr = {"/sys/class/net/wlan0/address", "/sys/class/net/eth0/address", "/sys/devices/virtual/net/wlan0/address"};
            for (int i = 0; i < 3; i++) {
                String reaMac = reaMac(strArr[i]);
                if (reaMac != null) {
                    return reaMac;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getMeid(Context context) {
        String str = null;
        if (context == null || ((TelephonyManager) context.getSystemService("phone")) == null) {
            return null;
        }
        if (FieldManager.allow(C1847b.f4286aj)) {
            try {
                if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                    if (Build.VERSION.SDK_INT < 26) {
                        str = getIMEI(context);
                    } else {
                        str = meid(context);
                        if (TextUtils.isEmpty(str)) {
                            str = getIMEI(context);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return str;
    }

    public static String[] getNetworkAccessMode(Context context) {
        String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            strArr[0] = "";
            return strArr;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            strArr[0] = "";
            return strArr;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "Wi-Fi";
            return strArr;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "2G/3G";
            strArr[1] = networkInfo2.getSubtypeName();
        }
        return strArr;
    }

    public static String getNetworkOperatorName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static int getNetworkType(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (!checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return 0;
            }
            return telephonyManager.getNetworkType();
        } catch (Exception unused) {
            return -100;
        }
    }

    public static String getOaid(Context context) {
        if (!TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        if (!FieldManager.allow(C1847b.f4256G)) {
            return "";
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(C1790h.f4111a, 0);
            if (sharedPreferences == null) {
                return "";
            }
            String string = sharedPreferences.getString(C1790h.f4112b, "");
            try {
                sOAID = string;
            } catch (Throwable unused) {
            }
            return string;
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String getPackageName(Context context) {
        if (context == null) {
            return null;
        }
        return context.getPackageName();
    }

    public static String getRegisteredOperator(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                return telephonyManager.getNetworkOperator();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int[] getResolutionArray(Context context) {
        if (context == null) {
            return null;
        }
        int[] iArr = new int[2];
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            try {
                Method method = Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class);
                if (method != null) {
                    method.invoke(defaultDisplay, displayMetrics);
                    int i = displayMetrics.widthPixels;
                    int i2 = displayMetrics.heightPixels;
                    if (i > i2) {
                        iArr[0] = i2;
                        iArr[1] = i;
                    } else {
                        iArr[0] = i;
                        iArr[1] = i2;
                    }
                    iArr[0] = displayMetrics.widthPixels;
                    iArr[1] = displayMetrics.heightPixels;
                    return iArr;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x007b, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 29) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sSecondImeiFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getSecondSimIMEi(Context context) {
        if (!TextUtils.isEmpty(sSecondImei)) {
            return sSecondImei;
        }
        if (Build.VERSION.SDK_INT >= 29 && sSecondImeiFlag) {
            return null;
        }
        if (context != null && FieldManager.allow(C1847b.f4288al) && Build.VERSION.SDK_INT >= 23 && UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        sSecondImeiFlag = true;
                    }
                    return null;
                }
                Class<?> cls = telephonyManager.getClass();
                if (((Integer) cls.getMethod("getPhoneCount", new Class[0]).invoke(telephonyManager, new Object[0])).intValue() == 2) {
                    sSecondImei = (String) cls.getMethod("getDeviceId", Integer.TYPE).invoke(telephonyManager, 2);
                }
            } catch (Throwable unused) {
            }
        }
        return sSecondImei;
    }

    public static String getSerial() {
        return getSerialNo();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0046, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 29) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sSerialFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004c, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getSerialNo() {
        String str;
        if (!TextUtils.isEmpty(sSerialNo)) {
            return sSerialNo;
        }
        String str2 = "";
        if (Build.VERSION.SDK_INT >= 29 && sSerialFlag) {
            return str2;
        }
        if (FieldManager.allow(C1847b.f4298j)) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        Class<?> cls = Class.forName("android.os.Build");
                        str = (String) cls.getMethod("getSerial", new Class[0]).invoke(cls, new Object[0]);
                    } catch (Throwable unused) {
                    }
                } else {
                    str = Build.SERIAL;
                }
                str2 = str;
                sSerialNo = str2;
            } catch (Throwable unused2) {
            }
        }
        if (AnalyticsConstants.UM_DEBUG) {
            MLog.m565i(LOG_TAG, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getDeviceId, serial no: ", str2));
        }
        return sSerialNo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 29) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sSimSerialNumberFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0045, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getSimICCID(Context context) {
        if (!TextUtils.isEmpty(sSimSerialNumber)) {
            return sSimSerialNumber;
        }
        if (Build.VERSION.SDK_INT >= 29 && sSimSerialNumberFlag) {
            return null;
        }
        if (FieldManager.allow(C1847b.f4289am)) {
            if (context != null) {
                try {
                    if (UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager == null) {
                            if (Build.VERSION.SDK_INT >= 29) {
                                sSimSerialNumberFlag = true;
                            }
                            return null;
                        }
                        sSimSerialNumber = telephonyManager.getSimSerialNumber();
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return sSimSerialNumber;
    }

    public static String getSubOSName(Context context) {
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty("ro.miui.ui.version.name");
            return TextUtils.isEmpty(property) ? isFlyMe() ? "Flyme" : isEmui(buildProp) ? "Emui" : !TextUtils.isEmpty(getYunOSVersion(buildProp)) ? "YunOS" : property : "MIUI";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getSubOSVersion(Context context) {
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty("ro.miui.ui.version.name");
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
            try {
                property = isFlyMe() ? getFlymeVersion(buildProp) : isEmui(buildProp) ? getEmuiVersion(buildProp) : getYunOSVersion(buildProp);
                return property;
            } catch (Throwable unused) {
                return property;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int getTimeZone(Context context) {
        if (context == null) {
            return 8;
        }
        try {
            Calendar calendar = Calendar.getInstance(getLocale(context));
            if (calendar != null) {
                return calendar.getTimeZone().getRawOffset() / 3600000;
            }
        } catch (Throwable th) {
            MLog.m567i(LOG_TAG, "error in getTimeZone", th);
        }
        return 8;
    }

    public static String getYunOSVersion(Properties properties) {
        try {
            String property = properties.getProperty("ro.yunos.version");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return property;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isChineseAera(Context context) {
        String imprintProperty;
        if (context == null) {
            return false;
        }
        try {
            imprintProperty = UMEnvelopeBuild.imprintProperty(context, C1543ak.f2951O, "");
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(imprintProperty)) {
            return imprintProperty.equals("cn");
        }
        if (getImsi(context) != null) {
            int i = context.getResources().getConfiguration().mcc;
            if (i != 460 && i != 461) {
                if (i == 0) {
                    String str = getLocaleInfo(context)[0];
                    if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("cn")) {
                    }
                }
            }
            return true;
        }
        String str2 = getLocaleInfo(context)[0];
        if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase("cn")) {
            return true;
        }
        return false;
    }

    public static boolean isEmui(Properties properties) {
        return properties.getProperty(KEY_EMUI_VERSION_CODE, null) != null;
    }

    public static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isHarmony(Context context) {
        try {
            return context.getString(Resources.getSystem().getIdentifier("config_os_brand", Main.STRING_TAG_STR, "android")).equals("harmony");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            if (checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean isWiFiAvailable(Context context) {
        if (context == null) {
            return false;
        }
        return "Wi-Fi".equals(getNetworkAccessMode(context)[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
        com.umeng.commonsdk.statistics.common.DeviceConfig.sMeid = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
        return com.umeng.commonsdk.statistics.common.DeviceConfig.sMeid;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005b, code lost:
        if (android.os.Build.VERSION.SDK_INT < 29) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String meid(Context context) {
        if (TextUtils.isEmpty(sMeid)) {
            return sMeid;
        }
        String str = null;
        if ((Build.VERSION.SDK_INT >= 29 && sImeiOrMeidFlag) || context == null) {
            return null;
        }
        try {
            Object invoke = Class.forName("android.telephony.TelephonyManager").getMethod("getMeid", new Class[0]).invoke(null, new Object[0]);
            if (invoke != null && (invoke instanceof String)) {
                str = (String) invoke;
            }
        } catch (Throwable th) {
            try {
                ULog.m544e("meid:" + th.getMessage());
            } finally {
                if (Build.VERSION.SDK_INT >= 29) {
                    sImeiOrMeidFlag = true;
                }
            }
        }
    }

    public static String reaMac(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String str2 = null;
        try {
            fileReader = new FileReader(str);
        } catch (Throwable unused) {
        }
        try {
            bufferedReader = new BufferedReader(fileReader, 1024);
            try {
                str2 = bufferedReader.readLine();
                try {
                    fileReader.close();
                } catch (Throwable unused2) {
                }
                bufferedReader.close();
                return str2;
            } catch (Throwable th) {
                th = th;
                try {
                    fileReader.close();
                } catch (Throwable unused3) {
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static int reflectMetrics(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Throwable unused) {
            return -1;
        }
    }
}

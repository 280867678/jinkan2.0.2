package com.umeng.commonsdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.stub.StubApp;
import com.umeng.analytics.C1520c;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.C1725b;
import com.umeng.commonsdk.internal.C1726c;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.C1767b;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.C1790h;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class UMUtils {
    public static final int DEFAULT_TIMEZONE = 8;
    public static final String KEY_APP_KEY = "appkey";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_LAST_APP_KEY = "last_appkey";
    public static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    public static final String KEY_SESSION_ID = "session_id";
    public static final String KEY_SHARED_PREFERENCES_NAME = "umeng_common_config";
    public static final String MOBILE_NETWORK = "2G/3G";
    public static final String SD_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String SP_FILE_NAME = "um_session_id";
    public static final String TAG = "UMUtils";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";
    public static final Pattern pattern = Pattern.compile("UTDID\">([^<]+)");
    public static Object spLock = new Object();
    public static String VALUE_ANALYTICS_VERSION = "";
    public static String VALUE_GAME_VERSION = "";
    public static String VALUE_PUSH_VERSION = "";
    public static String VALUE_SHARE_VERSION = "";
    public static String VALUE_APM_VERSION = "";
    public static String VALUE_VERIFY_VERSION = "";
    public static String VALUE_SMS_VERSION = "";
    public static String VALUE_REC_VERSION_NAME = "";
    public static String VALUE_VISUAL_VERSION = "";
    public static String VALUE_ASMS_VERSION = "";
    public static String VALUE_LINK_VERSION = "";
    public static String VALUE_ABTEST_VERSION = "";

    public static String MD5(String str) {
        try {
            if (str == null) {
                return null;
            }
            try {
                try {
                    byte[] bytes = str.getBytes();
                    MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
                    messageDigest.reset();
                    messageDigest.update(bytes);
                    byte[] digest = messageDigest.digest();
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i = 0; i < digest.length; i++) {
                        stringBuffer.append(String.format("%02X", Byte.valueOf(digest[i])));
                    }
                    return stringBuffer.toString();
                } catch (Exception e) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str2 = "MD5 e is " + e;
                    }
                    return null;
                }
            } catch (Exception unused) {
                return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
            }
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MD5 e is ", th);
            }
            return null;
        }
    }

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
            sb.append(hexString.toUpperCase());
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    public static String bytes2Hex(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "0");
            }
            str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, hexString);
        }
        return str;
    }

    public static boolean checkAndroidManifest(Context context, String str) {
        try {
            StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getActivityInfo(new ComponentName(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName(), str), 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkIntentFilterData(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse("tencent" + str + ":"));
            List<ResolveInfo> queryIntentActivities = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().queryIntentActivities(intent, 64);
            if (queryIntentActivities.size() > 0) {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName())) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean checkMetaData(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getApplicationInfo(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName(), 128);
            if (applicationInfo != null) {
                if (applicationInfo.metaData.get(str) != null) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean checkPath(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
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
            } catch (Exception e) {
                UMCrashManager.reportCrash(context, e);
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static boolean checkResource(Context context, String str, String str2) {
        try {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getIdentifier(str, str2, StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName()) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String encryptBySHA1(String str) {
        try {
            try {
                byte[] bytes = str.getBytes();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    messageDigest.update(bytes);
                    return bytes2Hex(messageDigest.digest());
                } catch (Exception unused) {
                    return null;
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("encrypt by SHA1 e is ", th);
                }
                return null;
            }
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str2 = "encrypt by SHA1 e is " + e;
            }
            return null;
        }
    }

    public static String genId() {
        return "1234567890";
    }

    public static byte[] genIv() {
        byte[] miniArray = getMiniArray();
        byte[] bArr = {10, 1, (byte) (bArr[0] + 1), 5, 4, (byte) (bArr[0] + bArr[3]), 7, 9, 23, 3, miniArray[0], miniArray[1], miniArray[2], miniArray[3], miniArray[4], (byte) (100 - bArr[7])};
        return bArr;
    }

    public static String[] getActiveUser(Context context) {
        return C1520c.m1415a(context);
    }

    public static String getApmFlag() {
        Method declaredMethod;
        try {
            Class<?> cls = getClass("com.umeng.umcrash.UMCrash");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("getUMAPMFlag", new Class[0])) == null) {
                return "";
            }
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getAppHashKey(Context context) {
        return DeviceConfig.getAppHashKey(context);
    }

    public static String getAppMD5Signature(Context context) {
        try {
            String appMD5Signature = DeviceConfig.getAppMD5Signature(context);
            try {
                return !TextUtils.isEmpty(appMD5Signature) ? appMD5Signature.replace(":", "").toLowerCase() : appMD5Signature;
            } catch (Throwable unused) {
                return appMD5Signature;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String getAppName(Context context) {
        StringBuilder sb;
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Exception e) {
            e = e;
            if (AnalyticsConstants.UM_DEBUG) {
                sb = new StringBuilder();
                sb.append("get app name e is ");
                sb.append(e);
                sb.toString();
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            e = th;
            if (AnalyticsConstants.UM_DEBUG) {
                sb = new StringBuilder();
                sb.append("get app name e is ");
                sb.append(e);
                sb.toString();
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        }
    }

    public static String getAppSHA1Key(Context context) {
        return DeviceConfig.getAppSHA1Key(context);
    }

    public static String getAppVersinoCode(Context context, String str) {
        if (context != null && str != null) {
            try {
                return String.valueOf(context.getPackageManager().getPackageInfo(str, 0).versionCode);
            } catch (Exception e) {
                if (AnalyticsConstants.UM_DEBUG) {
                    String str2 = "get app version code e is " + e;
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get app version code e is ", th);
                }
                return "";
            }
        }
        return "";
    }

    public static String getAppVersionCode(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str = "get app version code e is " + e;
            }
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get app version code e is ", th);
            }
            return "";
        }
    }

    public static String getAppVersionName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str = "get app version name e is " + e;
            }
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get app version name e is ", th);
            }
            return "";
        }
    }

    public static String getAppVersionName(Context context, String str) {
        if (context != null && str != null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                if (AnalyticsConstants.UM_DEBUG) {
                    String str2 = "get app version name e is " + e;
                }
                UMCrashManager.reportCrash(context, e);
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get app version name e is ", th);
                }
                UMCrashManager.reportCrash(context, th);
                return "";
            }
        }
        return "";
    }

    public static String getAppkey(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return !TextUtils.isEmpty(UMConfigure.sAppkey) ? UMConfigure.sAppkey : getMultiProcessSP(context, "appkey");
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str = "get app key e is " + e;
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get app key e is ", th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getAppkeyByXML(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("UMENG_APPKEY");
            if (string != null) {
                return string.trim();
            }
            if (!AnalyticsConstants.UM_DEBUG) {
                return null;
            }
            MLog.m565i(AnalyticsConstants.LOG_TAG, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Properties getBuildProp() {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            } catch (IOException unused) {
            }
        } catch (IOException unused2) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException unused3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return properties;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
        return properties;
    }

    public static String getCPU() {
        String str = null;
        try {
            try {
                FileReader fileReader = new FileReader("/proc/cpuinfo");
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                    fileReader.close();
                } catch (IOException e) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str2 = "Could not read from file /proc/cpuinfo, e is " + e;
                    }
                }
            } catch (FileNotFoundException e2) {
                if (AnalyticsConstants.UM_DEBUG) {
                    String str3 = "Could not read from file /proc/cpuinfo, e is " + e2;
                }
            }
            return str != null ? str.substring(str.indexOf(58) + 1).trim() : "";
        } catch (Exception e3) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str4 = "get cpu e is " + e3;
            }
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get cpu e is ", th);
            }
            return "";
        }
    }

    public static String getChannel(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return !TextUtils.isEmpty(UMConfigure.sChannel) ? UMConfigure.sChannel : getMultiProcessSP(context, "channel");
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str = "get channel e is " + e;
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get channel e is ", th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getChannelByXML(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("UMENG_CHANNEL")) == null) {
                return null;
            }
            String obj2 = obj.toString();
            if (obj2 != null) {
                return obj2.trim();
            }
            if (!AnalyticsConstants.UM_DEBUG) {
                return null;
            }
            MLog.m565i(AnalyticsConstants.LOG_TAG, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getDeviceToken(Context context) {
        Object invoke;
        Method method;
        Object invoke2;
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            try {
                Class<?> cls = Class.forName("com.umeng.message.MessageSharedPrefs");
                Method method2 = cls.getMethod("getInstance", Context.class);
                if (method2 != null && (invoke = method2.invoke(cls, origApplicationContext)) != null && (method = cls.getMethod("getDeviceToken", new Class[0])) != null && (invoke2 = method.invoke(invoke, new Object[0])) != null && (invoke2 instanceof String)) {
                    return (String) invoke2;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static String getDeviceType(Context context) {
        if (context == null) {
            return "Phone";
        }
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3 ? "Tablet" : "Phone";
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str = "get device type e is " + e;
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get device type e is ", th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getDisplayResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            return String.valueOf(i2) + "*" + String.valueOf(i);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str = "get display resolution e is " + e;
            }
            UMCrashManager.reportCrash(context, e);
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get display resolution e is ", th);
            }
            UMCrashManager.reportCrash(context, th);
            return "";
        }
    }

    public static String getFileMD5(File file) {
        try {
            try {
                byte[] bArr = new byte[1024];
                try {
                    if (!file.isFile()) {
                        return "";
                    }
                    MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            fileInputStream.close();
                            return String.format("%1$032x", new BigInteger(1, messageDigest.digest()));
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                } catch (Exception unused) {
                    return null;
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get file MD5 e is ", th);
                }
                return null;
            }
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str = "get file MD5 e is " + e;
            }
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
        } catch (Exception unused) {
            return null;
        }
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str = "Could not read gpu infor, e is " + e;
            }
            return new String[0];
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not read gpu infor, e is ", th);
            }
            return new String[0];
        }
    }

    public static String getLastAppkey(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return getMultiProcessSP(context, KEY_LAST_APP_KEY);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str = "get last app key e is " + e;
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get last app key e is ", th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static Locale getLocale(Context context) {
        Locale locale;
        if (context == null) {
            return null;
        }
        try {
            try {
                Configuration configuration = new Configuration();
                configuration.setToDefaults();
                Settings.System.getConfiguration(context.getContentResolver(), configuration);
                locale = configuration.locale;
            } catch (Exception e) {
                try {
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str = "fail to read user config locale, e is " + e;
                    }
                    locale = null;
                } catch (Exception e2) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        String str2 = "get locale e is " + e2;
                    }
                    UMCrashManager.reportCrash(context, e2);
                    return null;
                }
            }
            return locale == null ? Locale.getDefault() : locale;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get locale e is ", th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getMac(Context context) {
        if (context == null) {
            return null;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
            if (wifiManager == null) {
                return null;
            }
            if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            boolean z = AnalyticsConstants.UM_DEBUG;
            return "";
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str = "get mac e is " + e;
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get mac e is ", th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static byte[] getMiniArray() {
        return new byte[]{1, 6, 8, 12, 13};
    }

    public static String getMultiProcessSP(Context context, String str) {
        Context origApplicationContext;
        String str2;
        try {
            synchronized (spLock) {
                if (context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        if (isMainProgress(context)) {
                            origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                            str2 = "umeng_common_config";
                        } else {
                            String subProcessName = UMFrUtils.getSubProcessName(context);
                            origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                            str2 = subProcessName + "_umeng_common_config";
                        }
                        SharedPreferences sharedPreferences = origApplicationContext.getSharedPreferences(str2, 0);
                        if (sharedPreferences == null) {
                            return null;
                        }
                        return sharedPreferences.getString(str, null);
                    }
                }
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String[] getNetworkAccessMode(Context context) {
        StringBuilder sb;
        String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        try {
        } catch (Exception e) {
            e = e;
            if (AnalyticsConstants.UM_DEBUG) {
                sb = new StringBuilder();
                sb.append("get network access mode e is ");
                sb.append(e);
                sb.toString();
            }
            UMCrashManager.reportCrash(context, e);
            return strArr;
        } catch (Throwable th) {
            e = th;
            if (AnalyticsConstants.UM_DEBUG) {
                sb = new StringBuilder();
                sb.append("get network access mode e is ");
                sb.append(e);
                sb.toString();
            }
            UMCrashManager.reportCrash(context, e);
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
            return strArr;
        }
        return strArr;
    }

    public static String getNetworkOperatorName(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) ? telephonyManager.getNetworkOperatorName() : "";
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str = "get network operator e is " + e;
            }
            UMCrashManager.reportCrash(context, e);
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get network operator e is ", th);
            }
            UMCrashManager.reportCrash(context, th);
            return "";
        }
    }

    public static String getOaidRequiredTime(Context context) {
        if (!FieldManager.allow(C1847b.f4256G) || Build.VERSION.SDK_INT <= 28) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(C1790h.f4111a, 0);
            if (sharedPreferences == null) {
                return null;
            }
            return sharedPreferences.getString(C1790h.f4113c, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getOperator(Context context) {
        StringBuilder sb;
        if (context == null) {
            return "Unknown";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? "Unknown" : telephonyManager.getNetworkOperator();
        } catch (Exception e) {
            e = e;
            if (AnalyticsConstants.UM_DEBUG) {
                sb = new StringBuilder();
                sb.append("get get operator e is ");
                sb.append(e);
                sb.toString();
            }
            UMCrashManager.reportCrash(context, e);
            return "Unknown";
        } catch (Throwable th) {
            e = th;
            if (AnalyticsConstants.UM_DEBUG) {
                sb = new StringBuilder();
                sb.append("get get operator e is ");
                sb.append(e);
                sb.toString();
            }
            UMCrashManager.reportCrash(context, e);
            return "Unknown";
        }
    }

    public static String getRegisteredOperator(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || !checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return null;
            }
            return telephonyManager.getNetworkOperator();
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str = "get registered operator e is " + e;
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get registered operator e is ", th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getSubOSName(Context context) {
        String str;
        if (context == null) {
            return null;
        }
        try {
            try {
                Properties buildProp = getBuildProp();
                try {
                    String property = buildProp.getProperty("ro.miui.ui.version.name");
                    if (!TextUtils.isEmpty(property)) {
                        str = "MIUI";
                    } else if (isFlyMe()) {
                        str = "Flyme";
                    } else if (TextUtils.isEmpty(getYunOSVersion(buildProp))) {
                        return property;
                    } else {
                        str = "YunOS";
                    }
                    return str;
                } catch (Exception e) {
                    UMCrashManager.reportCrash(context, e);
                    return null;
                }
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get sub os name e is ", th);
                }
                UMCrashManager.reportCrash(context, th);
                return null;
            }
        } catch (Exception e2) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str2 = "get sub os name e is " + e2;
            }
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    public static String getSubOSVersion(Context context) {
        if (context == null) {
            return null;
        }
        try {
            try {
                Properties buildProp = getBuildProp();
                try {
                    String property = buildProp.getProperty("ro.miui.ui.version.name");
                    if (TextUtils.isEmpty(property)) {
                        try {
                            return isFlyMe() ? getFlymeVersion(buildProp) : getYunOSVersion(buildProp);
                        } catch (Exception unused) {
                        }
                    }
                    return property;
                } catch (Exception e) {
                    UMCrashManager.reportCrash(context, e);
                    return null;
                }
            } catch (Exception e2) {
                if (AnalyticsConstants.UM_DEBUG) {
                    String str = "get sub os version e is " + e2;
                }
                UMCrashManager.reportCrash(context, e2);
                return null;
            }
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get sub os version e is ", th);
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static int getTargetSdkVersion(Context context) {
        try {
            return context.getApplicationInfo().targetSdkVersion;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String getUMId(Context context) {
        if (context != null) {
            try {
                return UMEnvelopeBuild.imprintProperty(StubApp.getOrigApplicationContext(context.getApplicationContext()), C1543ak.f3036g, null);
            } catch (Exception e) {
                UMCrashManager.reportCrash(context, e);
                return null;
            }
        }
        return null;
    }

    public static String getUUIDForZid(Context context) {
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(SP_FILE_NAME, 0);
        return sharedPreferences != null ? sharedPreferences.getString("session_id", "") : "";
    }

    public static String getUmengToken(Context context) {
        if (context != null) {
            try {
                return UMEnvelopeBuild.imprintProperty(StubApp.getOrigApplicationContext(context.getApplicationContext()), "ztoken", null);
            } catch (Exception e) {
                UMCrashManager.reportCrash(context, e);
                return null;
            }
        }
        return null;
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

    public static String getZid(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (!UMConfigure.needSendZcfgEnv(origApplicationContext)) {
            return C1725b.m729a(origApplicationContext).m730a().m728a();
        }
        return null;
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isApplication(Context context) {
        try {
            String name = StubApp.getOrigApplicationContext(context.getApplicationContext()).getClass().getSuperclass().getName();
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            return name.equals("android.app.Application");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isDebug(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            return false;
        }
    }

    public static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isMainProgress(Context context) {
        try {
            String currentProcessName = UMFrUtils.getCurrentProcessName(context);
            String packageName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
            if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName)) {
                return false;
            }
            return currentProcessName.equals(packageName);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isSdCardWrittenable() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String parseId(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[1024];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (-1 != read) {
                stringWriter.write(cArr, 0, read);
            } else {
                return stringWriter.toString();
            }
        }
    }

    public static void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void saveSDKComponent() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        if (UMConfigure.isDebugLog()) {
            UMLog.mutlInfo(2, "统计SDK版本号: 9.4.4");
        }
        VALUE_ANALYTICS_VERSION = "9.4.4";
        String m723b = C1726c.m723b();
        if (!TextUtils.isEmpty(m723b)) {
            VALUE_ASMS_VERSION = m723b;
            if (UMConfigure.isDebugLog()) {
                UMLog.mutlInfo(2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ZID SDK版本号: ", m723b));
            }
        }
        Class<?> cls = getClass("com.umeng.analytics.game.GameSdkVersion");
        if (cls != null) {
            stringBuffer.append("g");
            try {
                String str = (String) cls.getDeclaredField("SDK_VERSION").get(cls);
                if (!TextUtils.isEmpty(str)) {
                    VALUE_GAME_VERSION = str;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "游戏统计SDK版本号: " + str);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        Class<?> cls2 = getClass("com.umeng.vt.V");
        if (cls2 != null) {
            stringBuffer.append(C1543ak.f2968aE);
            try {
                String str2 = (String) cls2.getDeclaredField("VERSION").get(cls2);
                if (!TextUtils.isEmpty(str2)) {
                    VALUE_VISUAL_VERSION = str2;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "可视化埋点SDK版本号: " + str2);
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        if (getClass("com.umeng.message.PushAgent") != null) {
            stringBuffer.append(C1543ak.f3013ax);
            Class<?> cls3 = getClass("com.umeng.message.MsgConstant");
            if (cls3 != null) {
                try {
                    String str3 = (String) cls3.getDeclaredField("SDK_VERSION").get(cls3);
                    if (!TextUtils.isEmpty(str3)) {
                        VALUE_PUSH_VERSION = str3;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "推送SDK版本号: " + str3);
                        }
                    }
                } catch (Throwable unused3) {
                }
            }
        }
        if (getClass("com.umeng.socialize.UMShareAPI") != null) {
            stringBuffer.append(C1543ak.f2965aB);
            Class<?> cls4 = getClass("com.umeng.a");
            if (cls4 != null) {
                try {
                    String str4 = (String) cls4.getDeclaredField("g").get(cls4);
                    if (!TextUtils.isEmpty(str4) && UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "分享SDK版本号: " + str4);
                    }
                } catch (Throwable unused4) {
                }
            }
        }
        if (getClass("com.umeng.error.UMError") != null) {
            stringBuffer.append("e");
        }
        if (getClass("com.umeng.umzid.ZIDManager") != null) {
            stringBuffer.append(C1543ak.f2967aD);
        }
        stringBuffer.append(C1543ak.f2966aC);
        if (SdkVersion.SDK_TYPE != 1 && getClass("com.umeng.commonsdk.internal.UMOplus") != null) {
            stringBuffer.append("o");
        }
        if (getClass("com.umeng.airec.RecAgent") != null) {
            stringBuffer.append(C1543ak.f2970aG);
            Class<?> cls5 = getClass("com.umeng.airec.BuildConfig");
            if (cls5 != null) {
                try {
                    String str5 = (String) cls5.getDeclaredField("VERSION_NAME").get(cls5);
                    if (!TextUtils.isEmpty(str5)) {
                        VALUE_REC_VERSION_NAME = str5;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "智能推荐SDK版本号: " + str5);
                        }
                    }
                } catch (Throwable unused5) {
                }
            }
        }
        if (getClass("com.umeng.umverify.UMVerifyHelper") != null) {
            stringBuffer.append("n");
        }
        Class<?> cls6 = getClass("com.umeng.sms.UMSMS");
        if (cls6 != null) {
            stringBuffer.append("m");
            try {
                Method declaredMethod = cls6.getDeclaredMethod("getVersion", new Class[0]);
                if (declaredMethod != null) {
                    String str6 = (String) declaredMethod.invoke(cls6, new Object[0]);
                    if (!TextUtils.isEmpty(str6)) {
                        VALUE_SMS_VERSION = str6;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "短信验证码SDK版本号: " + str6);
                        }
                    }
                }
            } catch (Throwable unused6) {
            }
        }
        try {
            Class<?> cls7 = getClass("com.umeng.umcrash.UMCrash");
            if (cls7 != null) {
                stringBuffer.append(C1543ak.f2969aF);
                Field declaredField = cls7.getDeclaredField("crashSdkVersion");
                declaredField.setAccessible(true);
                String str7 = (String) declaredField.get(cls7);
                if (!TextUtils.isEmpty(str7)) {
                    VALUE_APM_VERSION = str7;
                    if (UMConfigure.isDebugLog()) {
                        UMLog.mutlInfo(2, "APM SDK版本号: " + str7);
                    }
                }
            }
        } catch (Throwable unused7) {
        }
        Class<?> cls8 = getClass("com.umeng.umlink.MobclickLink");
        if (cls8 != null) {
            stringBuffer.append("l");
            try {
                Method declaredMethod2 = cls8.getDeclaredMethod("getVersion", new Class[0]);
                if (declaredMethod2 != null) {
                    String str8 = (String) declaredMethod2.invoke(cls8, new Object[0]);
                    if (!TextUtils.isEmpty(str8)) {
                        VALUE_LINK_VERSION = str8;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "ULink SDK版本号: " + str8);
                        }
                    }
                }
            } catch (Throwable unused8) {
            }
        }
        Class<?> cls9 = getClass("com.umeng.cconfig.UMRemoteConfig");
        if (cls9 != null) {
            try {
                Method declaredMethod3 = cls9.getDeclaredMethod("getVersion", new Class[0]);
                if (declaredMethod3 != null) {
                    stringBuffer.append(C1543ak.f2971aH);
                    String str9 = (String) declaredMethod3.invoke(cls9, new Object[0]);
                    if (!TextUtils.isEmpty(str9)) {
                        VALUE_ABTEST_VERSION = str9;
                        if (UMConfigure.isDebugLog()) {
                            UMLog.mutlInfo(2, "UABTEST SDK版本号: " + str9);
                        }
                    }
                }
            } catch (Throwable unused9) {
            }
        }
        if (!TextUtils.isEmpty(stringBuffer)) {
            C1767b.f4020a = stringBuffer.toString();
        }
    }

    public static void setAppkey(Context context, String str) {
        StringBuilder sb;
        if (context == null || str == null) {
            return;
        }
        try {
            setMultiProcessSP(context, "appkey", str);
        } catch (Exception e) {
            e = e;
            if (AnalyticsConstants.UM_DEBUG) {
                sb = new StringBuilder();
                sb.append("set app key e is ");
                sb.append(e);
                sb.toString();
            }
            UMCrashManager.reportCrash(context, e);
        } catch (Throwable th) {
            e = th;
            if (AnalyticsConstants.UM_DEBUG) {
                sb = new StringBuilder();
                sb.append("set app key e is ");
                sb.append(e);
                sb.toString();
            }
            UMCrashManager.reportCrash(context, e);
        }
    }

    public static void setChannel(Context context, String str) {
        StringBuilder sb;
        if (context == null || str == null) {
            return;
        }
        try {
            setMultiProcessSP(context, "channel", str);
        } catch (Exception e) {
            e = e;
            if (AnalyticsConstants.UM_DEBUG) {
                sb = new StringBuilder();
                sb.append("set channel e is ");
                sb.append(e);
                sb.toString();
            }
            UMCrashManager.reportCrash(context, e);
        } catch (Throwable th) {
            e = th;
            if (AnalyticsConstants.UM_DEBUG) {
                sb = new StringBuilder();
                sb.append("set channel e is ");
                sb.append(e);
                sb.toString();
            }
            UMCrashManager.reportCrash(context, e);
        }
    }

    public static void setLastAppkey(Context context, String str) {
        StringBuilder sb;
        if (context == null || str == null) {
            return;
        }
        try {
            setMultiProcessSP(context, KEY_LAST_APP_KEY, str);
        } catch (Exception e) {
            e = e;
            if (AnalyticsConstants.UM_DEBUG) {
                sb = new StringBuilder();
                sb.append("set last app key e is ");
                sb.append(e);
                sb.toString();
            }
            UMCrashManager.reportCrash(context, e);
        } catch (Throwable th) {
            e = th;
            if (AnalyticsConstants.UM_DEBUG) {
                sb = new StringBuilder();
                sb.append("set last app key e is ");
                sb.append(e);
                sb.toString();
            }
            UMCrashManager.reportCrash(context, e);
        }
    }

    public static void setMultiProcessSP(Context context, String str, String str2) {
        Context origApplicationContext;
        String str3;
        try {
            synchronized (spLock) {
                if (context != null) {
                    if (!TextUtils.isEmpty(str) && str2 != null) {
                        if (isMainProgress(context)) {
                            origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                            str3 = "umeng_common_config";
                        } else {
                            String subProcessName = UMFrUtils.getSubProcessName(context);
                            origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                            str3 = subProcessName + "_umeng_common_config";
                        }
                        SharedPreferences sharedPreferences = origApplicationContext.getSharedPreferences(str3, 0);
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putString(str, str2).commit();
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void setUUIDForZid(Context context) {
        String str;
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(SP_FILE_NAME, 0);
        try {
            str = UUID.randomUUID().toString();
        } catch (Throwable unused) {
            str = "";
        }
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("session_id", str).commit();
        }
    }
}

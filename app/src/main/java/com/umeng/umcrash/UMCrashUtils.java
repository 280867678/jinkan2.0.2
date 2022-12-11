package com.umeng.umcrash;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.p046uc.crashsdk.export.CrashApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.mozilla.javascript.tools.idswitch.Main;

/* loaded from: classes4.dex */
public class UMCrashUtils {
    public static final String UNKNOW = "";

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

    public static String[] getActiveUser(Context context) {
        Class<?> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.umeng.commonsdk.utils.UMUtils");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getActiveUser", Context.class);
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(null, context);
            if (invoke == null) {
                return null;
            }
            return (String[]) invoke;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }

    public static int getInnerConfig(Context context, String str, int i) {
        SharedPreferences sharedPreferences;
        if (context != null) {
            try {
                return (TextUtils.isEmpty(str) || (sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0)) == null) ? i : sharedPreferences.getInt(str, i);
            } catch (Throwable th) {
                th.printStackTrace();
                return i;
            }
        }
        return i;
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

    public static boolean isHarmony(Context context) {
        try {
            return context.getString(Resources.getSystem().getIdentifier("config_os_brand", Main.STRING_TAG_STR, "android")).equals("harmony");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void saveInnerConfig(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || obj == null || (sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0)) == null || (edit = sharedPreferences.edit()) == null) {
                    return;
                }
                edit.putInt(str, Integer.parseInt(obj.toString()));
                edit.commit();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setCommonTag(String str, String str2) {
        Enum[] enumArr;
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.UMConfigure");
            Class<?> cls2 = Class.forName("com.umeng.commonsdk.UMConfigure$BS_TYPE");
            Method declaredMethod = cls.getDeclaredMethod("setModuleTag", cls2, String.class, String.class);
            if (declaredMethod == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            for (Enum r9 : (Enum[]) cls2.getEnumConstants()) {
                if (r9 != null && r9.name().equals("APM")) {
                    declaredMethod.invoke(cls, r9, str, str2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setIntegrationTesingParams(String str) {
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo("um_dk", str);
        }
        if (UMCrash.getReporter() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("um_dk", str);
            UMCrash.getReporter().addPublicParams(hashMap);
        }
    }

    public static void setPuidAndProvider(String str, String str2) {
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo(UMCrash.KEY_HEADER_PUID, str);
            CrashApi.getInstance().addHeaderInfo(UMCrash.KEY_HEADER_PROVIDER, str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(UMCrash.KEY_HEADER_PUID, str);
        hashMap.put(UMCrash.KEY_HEADER_PROVIDER, str2);
        if (UMCrash.getReporter() != null) {
            UMCrash.getReporter().addPublicParams(hashMap);
        }
    }

    public static String splitByByte(String str, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        try {
            int length = str.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                String valueOf = String.valueOf(str.charAt(i3));
                i2 += valueOf.getBytes().length;
                if (i < i2) {
                    break;
                }
                stringBuffer.append(valueOf);
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }
}

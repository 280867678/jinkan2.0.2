package com.umeng.commonsdk;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.C1528aa;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.analytics.pro.C1553ao;
import com.umeng.analytics.pro.C1642l;
import com.umeng.common.C1687b;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMLogCommon;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.C1724a;
import com.umeng.commonsdk.internal.C1725b;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.stateless.C1753a;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.C1766a;
import com.umeng.commonsdk.statistics.C1767b;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.TagHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.utils.C1847b;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import me.tvspark.outline;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class UMConfigure {
    public static final int DEVICE_TYPE_BOX = 2;
    public static final int DEVICE_TYPE_PHONE = 1;
    public static final String KEY_FILE_NAME_APPKEY = "APPKEY";
    public static final String KEY_FILE_NAME_LOG = "LOG";
    public static final String KEY_METHOD_NAME_PUSH_SETCHANNEL = "setMessageChannel";
    public static final String KEY_METHOD_NAME_PUSH_SET_SECRET = "setSecret";
    public static final String KEY_METHOD_NAME_SETAPPKEY = "setAppkey";
    public static final String KEY_METHOD_NAME_SETCHANNEL = "setChannel";
    public static final String KEY_METHOD_NAME_SETDEBUGMODE = "setDebugMode";
    public static final String TAG = "UMConfigure";
    public static final String WRAPER_TYPE_COCOS2DX_X = "Cocos2d-x";
    public static final String WRAPER_TYPE_COCOS2DX_XLUA = "Cocos2d-x_lua";
    public static final String WRAPER_TYPE_FLUTTER = "flutter";
    public static final String WRAPER_TYPE_HYBRID = "hybrid";
    public static final String WRAPER_TYPE_NATIVE = "native";
    public static final String WRAPER_TYPE_PHONEGAP = "phonegap";
    public static final String WRAPER_TYPE_REACTNATIVE = "react-native";
    public static final String WRAPER_TYPE_UNITY = "Unity";
    public static final String WRAPER_TYPE_WEEX = "weex";
    public static boolean debugLog;
    public static OnGetOaidListener mOnGetOaidListener;
    public static UMLog umDebugLog = new UMLog();
    public static boolean preInitComplete = false;
    public static Object PreInitLock = new Object();
    public static String sAppkey = "";
    public static String sChannel = "";
    public static boolean isInit = false;
    public static Object lock = new Object();
    public static int preInitInvokedFlag = 0;
    public static int policyGrantInvokedFlag = 0;
    public static int policyGrantResult = 0;
    public static boolean shouldCheckShareSdk = true;
    public static MobclickAgent.PageMode AUTO_ACTIVITY_PAGE_COLLECTION = MobclickAgent.PageMode.AUTO;
    public static final String[] BUSINESS_TYPE = {"apm", "push", "share", "ulink", "uverify", "usms", "urec", "abtest", "game", C1543ak.f3001al};
    public static boolean isFinish = false;
    public static Object lockObject = new Object();

    /* loaded from: classes4.dex */
    public enum BS_TYPE {
        APM,
        PUSH,
        SHARE,
        ULINK,
        UVERIFY,
        USMS,
        UREC,
        ABTEST,
        GAME,
        ZID
    }

    public static boolean checkShareSdk(Class<?> cls) {
        try {
            return cls.getDeclaredField("isZyb") != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void deleteModuleTag(BS_TYPE bs_type, String str) {
        if (bs_type != null && !TextUtils.isEmpty(str)) {
            try {
                if (str.trim().getBytes().length > 64) {
                    return;
                }
                int ordinal = bs_type.ordinal();
                String str2 = "";
                if (ordinal < BUSINESS_TYPE.length) {
                    str2 = BUSINESS_TYPE[ordinal];
                }
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                TagHelper.deleteModuleTag(str2 + "_" + str);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void enterRTDModeIfNeeded(Context context) {
        long longValue;
        long longValue2;
        if (context == null) {
            return;
        }
        String m816a = C1687b.m816a(context, AnalyticsConfig.RTD_SP_FILE, "debugkey");
        if (TextUtils.isEmpty(m816a)) {
            return;
        }
        String m816a2 = C1687b.m816a(context, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_START_TIME);
        String m816a3 = C1687b.m816a(context, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_PERIOD);
        if (!TextUtils.isEmpty(m816a2)) {
            try {
                longValue = Long.valueOf(m816a2).longValue();
            } catch (Throwable unused) {
            }
            if (!TextUtils.isEmpty(m816a3)) {
                try {
                    longValue2 = Long.valueOf(m816a3).longValue();
                } catch (Throwable unused2) {
                }
                if (longValue != 0 || longValue2 == 0) {
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据");
                    C1687b.m817a(context, AnalyticsConfig.RTD_SP_FILE);
                } else if (System.currentTimeMillis() - longValue > longValue2 * 60 * 1000) {
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存dk值已经超时，清除缓存数据。");
                    C1687b.m817a(context, AnalyticsConfig.RTD_SP_FILE);
                    if (!AnalyticsConfig.isRealTimeDebugMode()) {
                        return;
                    }
                    AnalyticsConfig.turnOffRealTimeDebug();
                    return;
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("debugkey", m816a);
                    if (AnalyticsConfig.isRealTimeDebugMode()) {
                        return;
                    }
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存dk值在有效期内，切换到埋点验证模式。");
                    AnalyticsConfig.turnOnRealTimeDebug(hashMap);
                    return;
                }
            }
            longValue2 = 0;
            if (longValue != 0) {
            }
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据");
            C1687b.m817a(context, AnalyticsConfig.RTD_SP_FILE);
        }
        longValue = 0;
        if (!TextUtils.isEmpty(m816a3)) {
        }
        longValue2 = 0;
        if (longValue != 0) {
        }
        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据");
        C1687b.m817a(context, AnalyticsConfig.RTD_SP_FILE);
    }

    public static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Object getDecInstanceObject(Class<?> cls) {
        Constructor<?> constructor;
        if (cls != null) {
            try {
                constructor = cls.getDeclaredConstructor(new Class[0]);
            } catch (NoSuchMethodException unused) {
                constructor = null;
            }
            if (constructor == null) {
                return null;
            }
            constructor.setAccessible(true);
            try {
                return constructor.newInstance(new Object[0]);
            } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused2) {
                return null;
            }
        }
        return null;
    }

    public static Method getDecMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        Method method = null;
        if (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (method != null) {
                method.setAccessible(true);
            }
        }
        return method;
    }

    public static boolean getInitStatus() {
        boolean z;
        synchronized (lockObject) {
            z = isFinish;
        }
        return z;
    }

    public static Map<String, String> getModuleTags() {
        try {
            return TagHelper.getModuleTags();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void getOaid(Context context, OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            boolean z = debugLog;
            return;
        }
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        mOnGetOaidListener = onGetOaidListener;
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMConfigure.4
            @Override // java.lang.Runnable
            public void run() {
                String m1399a = C1528aa.m1399a(origApplicationContext);
                if (UMConfigure.mOnGetOaidListener != null) {
                    UMConfigure.mOnGetOaidListener.onGetOaid(m1399a);
                }
            }
        }).start();
    }

    public static String[] getTestDeviceInfo(Context context) {
        String[] strArr = new String[2];
        if (context != null) {
            try {
                strArr[0] = DeviceConfig.getDeviceIdForGeneral(context);
                strArr[1] = DeviceConfig.getMac(context);
            } catch (Exception unused) {
            }
        }
        return strArr;
    }

    public static String getUMIDString(Context context) {
        if (context != null) {
            return UMUtils.getUMId(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        return null;
    }

    public static String getUmengZID(Context context) {
        if (context != null) {
            return UMUtils.getZid(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        return null;
    }

    public static void ignoreSdkCheck(Context context) {
        shouldCheckShareSdk = false;
    }

    public static void init(Context context, int i, String str) {
        init(context, null, null, i, str);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(41:9|10|11|(2:13|14)|(3:16|17|(1:23))|(3:25|26|(1:32))|34|(2:36|(1:38))|39|(3:43|(1:47)|48)|49|(2:51|(1:57))|58|(7:59|60|(4:62|(1:64)(1:68)|65|(1:67))|69|(1:71)|72|(1:76))|(3:78|79|(6:83|(2:85|(1:87))|88|(2:90|(1:92))|93|(2:98|(1:100))))|(3:102|103|(2:107|(1:109)))|111|112|113|(2:115|(1:117))|(5:119|120|(1:124)|125|(2:127|(1:129)))|131|(3:132|133|(1:135))|137|138|(1:140)|142|308|147|(3:149|314|155)|163|(1:165)(9:186|(1:188)|168|(1:170)|171|172|(1:178)|180|(2:182|183)(1:184))|166|167|168|(0)|171|172|(3:174|176|178)|180|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:170:0x037a A[Catch: all -> 0x0381, Exception -> 0x038c, TRY_LEAVE, TryCatch #1 {all -> 0x0381, blocks: (B:6:0x0007, B:9:0x000c, B:34:0x0059, B:36:0x005f, B:39:0x0069, B:41:0x007b, B:43:0x0083, B:45:0x0089, B:47:0x008d, B:48:0x0094, B:49:0x0099, B:51:0x009e, B:53:0x00aa, B:55:0x00b0, B:57:0x00b8, B:58:0x00cf, B:79:0x015a, B:81:0x016e, B:83:0x0178, B:85:0x0184, B:87:0x0194, B:88:0x019b, B:90:0x01a7, B:92:0x01b7, B:93:0x01be, B:96:0x01c5, B:98:0x01d1, B:100:0x01df, B:111:0x021e, B:142:0x0306, B:143:0x0308, B:147:0x030c, B:149:0x0312, B:150:0x0314, B:160:0x0340, B:163:0x0343, B:165:0x0349, B:166:0x0357, B:167:0x0371, B:168:0x0374, B:170:0x037a, B:186:0x035c, B:188:0x0369, B:192:0x0380), top: B:5:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:184:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void init(Context context, String str, String str2, int i, String str3) {
        StringBuilder sb;
        Context origApplicationContext;
        Method declaredMethod;
        Object invoke;
        Method declaredMethod2;
        int i2;
        C1725b m729a;
        Method declaredMethod3;
        Method declaredMethod4;
        Object invoke2;
        Method declaredMethod5;
        Class<?> cls;
        Method declaredMethod6;
        if (context == null) {
            return;
        }
        try {
            try {
            } catch (Throwable th) {
                th = th;
                if (debugLog) {
                    sb = new StringBuilder();
                    sb.append("init e is ");
                    sb.append(th);
                    sb.toString();
                }
            }
        } catch (Exception e) {
            th = e;
            if (debugLog) {
                sb = new StringBuilder();
                sb.append("init e is ");
                sb.append(th);
                sb.toString();
            }
        }
        if (isInit) {
            return;
        }
        final Context origApplicationContext2 = StubApp.getOrigApplicationContext(context.getApplicationContext());
        try {
            if (getClass("com.umeng.umzid.ZIDManager") == null) {
                new Thread() { // from class: com.umeng.commonsdk.UMConfigure.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Looper.prepare();
                            Toast.makeText(origApplicationContext2, "SDK 初始化失败，请检查是否集成umeng-asms-1.2.X.aar库。", 1).show();
                            Looper.loop();
                        } catch (Throwable unused) {
                        }
                    }
                }.start();
                return;
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> cls2 = getClass("com.umeng.message.PushAgent");
            if (cls2 != null && !checkShareSdk(cls2) && shouldCheckShareSdk) {
                new Thread() { // from class: com.umeng.commonsdk.UMConfigure.2
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Looper.prepare();
                            Toast.makeText(origApplicationContext2, UMLogCommon.SC_10015, 1).show();
                            Looper.loop();
                        } catch (Throwable unused2) {
                        }
                    }
                }.start();
            }
        } catch (Throwable unused2) {
        }
        try {
            Class<?> cls3 = getClass("com.umeng.socialize.UMShareAPI");
            if (cls3 != null && !checkShareSdk(cls3) && shouldCheckShareSdk) {
                new Thread() { // from class: com.umeng.commonsdk.UMConfigure.3
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Looper.prepare();
                            Toast.makeText(origApplicationContext2, UMLogCommon.SC_10015, 1).show();
                            Looper.loop();
                        } catch (Throwable unused3) {
                        }
                    }
                }.start();
            }
        } catch (Throwable unused3) {
        }
        if (!isPreInit()) {
            preInitInternal(origApplicationContext2, str, str2);
            if (!isPreInit()) {
                return;
            }
        }
        UMUtils.setAppkey(origApplicationContext2, sAppkey);
        String lastAppkey = UMUtils.getLastAppkey(origApplicationContext2);
        if (!TextUtils.isEmpty(sAppkey) && !sAppkey.equals(lastAppkey)) {
            if (!TextUtils.isEmpty(lastAppkey) && debugLog) {
                UMLog.mutlInfo(UMLogCommon.SC_10008, 2, "");
            }
            UMUtils.setLastAppkey(origApplicationContext2, sAppkey);
        }
        if (debugLog) {
            String appkeyByXML = UMUtils.getAppkeyByXML(origApplicationContext2);
            if (!TextUtils.isEmpty(sAppkey) && !TextUtils.isEmpty(appkeyByXML) && !sAppkey.equals(appkeyByXML)) {
                UMLog.mutlInfo(UMLogCommon.SC_10011, 3, "", new String[]{"@", "#"}, new String[]{sAppkey, appkeyByXML});
            }
        }
        UMUtils.setChannel(origApplicationContext2, sChannel);
        try {
            Class<?> cls4 = Class.forName("com.umeng.analytics.MobclickAgent");
            Method declaredMethod7 = cls4.getDeclaredMethod("init", Context.class);
            if (declaredMethod7 != null) {
                declaredMethod7.setAccessible(true);
                declaredMethod7.invoke(cls4, origApplicationContext2);
                if (FieldManager.allow(C1847b.f4255F)) {
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger enabled.");
                    C1642l.m1019a(origApplicationContext2).m1012b(origApplicationContext2);
                } else {
                    UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> FirstResumeTrigger disabled.");
                }
                if (debugLog) {
                    UMLog.mutlInfo(UMLogCommon.SC_10003, 2, "");
                }
            }
            Class.forName("com.umeng.analytics.game.UMGameAgent");
            Method declaredMethod8 = cls4.getDeclaredMethod("setGameScenarioType", Context.class);
            if (declaredMethod8 != null) {
                declaredMethod8.setAccessible(true);
                declaredMethod8.invoke(cls4, origApplicationContext2);
            }
            if (C1767b.f4020a.indexOf("e") >= 0 && (declaredMethod6 = (cls = Class.forName("com.umeng.analytics.MobclickAgent")).getDeclaredMethod("disableExceptionCatch", new Class[0])) != null) {
                declaredMethod6.setAccessible(true);
                declaredMethod6.invoke(cls, new Object[0]);
            }
        } catch (Throwable unused4) {
        }
        try {
            Class<?> cls5 = Class.forName("com.umeng.message.MessageSharedPrefs");
            Method declaredMethod9 = cls5.getDeclaredMethod("getInstance", Context.class);
            if (declaredMethod9 != null && (invoke2 = declaredMethod9.invoke(cls5, origApplicationContext2)) != null) {
                Method declaredMethod10 = cls5.getDeclaredMethod("setMessageAppKey", String.class);
                if (declaredMethod10 != null) {
                    declaredMethod10.setAccessible(true);
                    declaredMethod10.invoke(invoke2, sAppkey);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10004, 2, "");
                    }
                }
                Method declaredMethod11 = cls5.getDeclaredMethod(KEY_METHOD_NAME_PUSH_SETCHANNEL, String.class);
                if (declaredMethod11 != null) {
                    declaredMethod11.setAccessible(true);
                    declaredMethod11.invoke(invoke2, sChannel);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10005, 2, "");
                    }
                }
                if (!TextUtils.isEmpty(str3) && (declaredMethod5 = cls5.getDeclaredMethod("setMessageAppSecret", String.class)) != null) {
                    declaredMethod5.setAccessible(true);
                    declaredMethod5.invoke(invoke2, str3);
                    if (debugLog) {
                        UMLog.mutlInfo(UMLogCommon.SC_10009, 2, "");
                    }
                }
            }
        } catch (Exception unused5) {
        }
        try {
            Class<?> cls6 = getClass("com.umeng.socialize.UMShareAPI");
            setFile(cls6, KEY_FILE_NAME_APPKEY, sAppkey);
            if (cls6 != null && (declaredMethod4 = cls6.getDeclaredMethod("init", Context.class, String.class)) != null) {
                declaredMethod4.setAccessible(true);
                declaredMethod4.invoke(cls6, origApplicationContext2, sAppkey);
                if (debugLog) {
                    UMLog.mutlInfo(UMLogCommon.SC_10006, 2, "");
                }
            }
        } catch (Throwable unused6) {
        }
        AnalyticsConstants.setDeviceType(i);
        try {
            Class<?> cls7 = Class.forName("com.umeng.error.UMError");
            Method declaredMethod12 = cls7.getDeclaredMethod("init", Context.class);
            if (declaredMethod12 != null) {
                declaredMethod12.setAccessible(true);
                declaredMethod12.invoke(cls7, origApplicationContext2);
                if (debugLog) {
                    UMLog.mutlInfo(UMLogCommon.SC_10010, 2, "");
                }
            }
        } catch (Throwable unused7) {
        }
        try {
            Class<?> cls8 = Class.forName("com.umeng.umcrash.UMCrash");
            if (SdkVersion.SDK_TYPE == 1 && (declaredMethod3 = cls8.getDeclaredMethod("useIntlServices", Boolean.TYPE)) != null) {
                declaredMethod3.setAccessible(true);
                declaredMethod3.invoke(cls8, true);
            }
            Method declaredMethod13 = cls8.getDeclaredMethod("init", Context.class, String.class, String.class);
            if (declaredMethod13 != null) {
                declaredMethod13.setAccessible(true);
                declaredMethod13.invoke(cls8, origApplicationContext2, sAppkey, sChannel);
                if (debugLog) {
                    UMLog.mutlInfo(UMLogCommon.SC_10014, 2, "");
                }
            }
        } catch (Throwable unused8) {
        }
        try {
            Method declaredMethod14 = Class.forName("com.umeng.vt.facade.EventFacade").getDeclaredMethod("init", Application.class, String.class, String.class, Integer.TYPE, String.class);
            if (declaredMethod14 != null) {
                declaredMethod14.invoke(null, origApplicationContext2, sAppkey, sChannel, Integer.valueOf(i), str3);
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>>初始化 EventFacade 成功.");
            }
        } catch (Throwable unused9) {
        }
        try {
            Method declaredMethod15 = Class.forName("com.umeng.vt.common.VTTracker").getDeclaredMethod("init", Application.class, String.class);
            if (declaredMethod15 != null) {
                declaredMethod15.invoke(null, origApplicationContext2, sAppkey);
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>>初始化 VTTracker 成功.");
            }
        } catch (Throwable unused10) {
        }
        synchronized (lockObject) {
            isFinish = true;
        }
        if (needCheckPolicyResult(origApplicationContext2)) {
            synchronized (lock) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(C1724a.f3896G, preInitInvokedFlag);
                    jSONObject.put(C1724a.f3897H, policyGrantInvokedFlag);
                    jSONObject.put("policyGrantResult", policyGrantResult);
                    UMWorkDispatch.sendEvent(origApplicationContext2, C1724a.f3890A, C1725b.m729a(origApplicationContext2).m730a(), jSONObject);
                } catch (Throwable unused11) {
                }
                try {
                } finally {
                }
            }
        }
        if (!needSendZcfgEnv(origApplicationContext2)) {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 走正常逻辑.");
            if (FieldManager.m790b()) {
                i2 = C1724a.f3923y;
                m729a = C1725b.m729a(origApplicationContext2);
            }
            if (isDebugLog()) {
                UMConfigureInternation.doSelfCheck(origApplicationContext2);
            }
            origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            Class<?> cls9 = Class.forName("com.umeng.cconfig.UMRemoteConfig");
            declaredMethod = cls9.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod != null && (invoke = declaredMethod.invoke(cls9, new Object[0])) != null && (declaredMethod2 = cls9.getDeclaredMethod("init", Context.class)) != null) {
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(invoke, origApplicationContext);
            }
            enterRTDModeIfNeeded(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            if (!isInit) {
                return;
            }
            isInit = true;
            return;
        }
        UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 走零号报文发送逻辑");
        i2 = C1724a.f3914p;
        m729a = C1725b.m729a(origApplicationContext2);
        UMWorkDispatch.sendEvent(origApplicationContext2, i2, m729a.m730a(), null);
        if (isDebugLog()) {
        }
        origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        Class<?> cls92 = Class.forName("com.umeng.cconfig.UMRemoteConfig");
        declaredMethod = cls92.getDeclaredMethod("getInstance", new Class[0]);
        if (declaredMethod != null) {
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(invoke, origApplicationContext);
        }
        enterRTDModeIfNeeded(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        if (!isInit) {
        }
    }

    public static void invoke(Method method, Object obj, Object[] objArr) {
        if (method == null || obj == null) {
            return;
        }
        try {
            method.invoke(obj, objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
        }
    }

    public static void invoke(Method method, Object[] objArr) {
        if (method != null) {
            try {
                method.invoke(null, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    public static boolean isDebugLog() {
        return debugLog;
    }

    public static boolean isPreInit() {
        boolean z;
        synchronized (PreInitLock) {
            z = preInitComplete;
        }
        return z;
    }

    public static boolean needCheckPolicyResult(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append(filesDir.getAbsolutePath());
        return !new File(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, File.separator, C1553ao.f3124m)).exists();
    }

    public static boolean needSendZcfgEnv(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append(filesDir.getAbsolutePath());
        return !new File(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, File.separator, C1553ao.f3123l)).exists();
    }

    public static void preInit(Context context, String str, String str2) {
        synchronized (lock) {
            preInitInvokedFlag = 1;
        }
        preInitInternal(context, str, str2);
    }

    public static void preInitInternal(Context context, String str, String str2) {
        if (context == null) {
            boolean z = debugLog;
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (TextUtils.isEmpty(str)) {
            str = UMUtils.getAppkeyByXML(origApplicationContext);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = UMUtils.getChannelByXML(origApplicationContext);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "Unknown";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sAppkey = str;
        sChannel = str2;
        UMGlobalContext.getInstance(origApplicationContext);
        C1642l.m1019a(origApplicationContext);
        if (!needSendZcfgEnv(origApplicationContext)) {
            FieldManager.m794a().m793a(origApplicationContext);
        }
        synchronized (PreInitLock) {
            preInitComplete = true;
        }
    }

    public static void setCheckDevice(boolean z) {
        AnalyticsConstants.CHECK_DEVICE = z;
    }

    public static void setEncryptEnabled(boolean z) {
        C1767b.m587a(z);
    }

    public static void setFile(Class<?> cls, String str, String str2) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    public static void setFile(Class<?> cls, String str, boolean z) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, Boolean.valueOf(z));
            } catch (Exception unused) {
            }
        }
    }

    public static void setLatencyWindow(long j) {
        C1766a.f4019c = ((int) j) * 1000;
    }

    public static void setLogEnabled(boolean z) {
        StringBuilder sb;
        try {
            debugLog = z;
            MLog.DEBUG = z;
            Class<?> cls = getClass("com.umeng.message.PushAgent");
            invoke(getDecMethod(cls, KEY_METHOD_NAME_SETDEBUGMODE, new Class[]{Boolean.TYPE}), getDecInstanceObject(cls), new Object[]{Boolean.valueOf(z)});
            setFile(getClass("com.umeng.socialize.Config"), "DEBUG", z);
            invoke(getDecMethod(getClass("com.umeng.umcrash.UMCrash"), "setDebug", new Class[]{Boolean.TYPE}), new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            e = e;
            if (!debugLog) {
                return;
            }
            sb = new StringBuilder();
            sb.append("set log enabled e is ");
            sb.append(e);
            sb.toString();
        } catch (Throwable th) {
            e = th;
            if (!debugLog) {
                return;
            }
            sb = new StringBuilder();
            sb.append("set log enabled e is ");
            sb.append(e);
            sb.toString();
        }
    }

    public static void setModuleTag(BS_TYPE bs_type, String str, String str2) {
        if (bs_type == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.trim().getBytes().length > 64 || str2.trim().getBytes().length > 128) {
                return;
            }
            int ordinal = bs_type.ordinal();
            String str3 = "";
            if (ordinal < BUSINESS_TYPE.length) {
                str3 = BUSINESS_TYPE[ordinal];
            }
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            TagHelper.setModuleTag(str3 + "_" + str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void setProcessEvent(boolean z) {
        AnalyticsConstants.SUB_PROCESS_EVENT = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
        if (r2.equals(r0) != false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void setWraperType(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String str3 = WRAPER_TYPE_NATIVE;
            if (!str.equals(str3)) {
                str3 = WRAPER_TYPE_COCOS2DX_X;
                if (!str.equals(str3)) {
                    str3 = WRAPER_TYPE_COCOS2DX_XLUA;
                    if (!str.equals(str3)) {
                        str3 = WRAPER_TYPE_UNITY;
                        if (!str.equals(str3)) {
                            str3 = WRAPER_TYPE_REACTNATIVE;
                            if (!str.equals(str3)) {
                                str3 = WRAPER_TYPE_PHONEGAP;
                                if (!str.equals(str3)) {
                                    str3 = WRAPER_TYPE_WEEX;
                                    if (!str.equals(str3)) {
                                        str3 = WRAPER_TYPE_HYBRID;
                                        if (!str.equals(str3)) {
                                            str3 = WRAPER_TYPE_FLUTTER;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            C1753a.f3985a = str3;
            C1766a.f4017a = str3;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        C1753a.f3986b = str2;
        C1766a.f4018b = str2;
    }

    public static void submitPolicyGrantResult(Context context, boolean z) {
        UMWorkDispatch.sendEvent(context, C1724a.f3891B, C1725b.m729a(context).m730a(), null);
        synchronized (lock) {
            policyGrantInvokedFlag = 1;
            if (z) {
                policyGrantResult = 1;
            } else {
                policyGrantResult = 2;
            }
        }
        UMWorkDispatch.sendEvent(context, C1724a.f3924z, C1725b.m729a(context).m730a(), Integer.valueOf(policyGrantResult));
    }
}

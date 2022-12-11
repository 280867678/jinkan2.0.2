package com.umeng.umcrash;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.launch.LaunchManager;
import com.efs.sdk.memoryinfo.UMMemoryMonitor;
import com.efs.sdk.net.NetManager;
import com.efs.sdk.p020pa.PAFactory;
import com.efs.sdk.p020pa.config.IEfsReporter;
import com.efs.sdk.p020pa.config.PackageLevel;
import com.p046uc.crashsdk.export.CrashApi;
import com.p046uc.crashsdk.export.CustomLogInfo;
import com.p046uc.crashsdk.export.ICrashClient;
import com.p046uc.crashsdk.export.LogType;
import com.stub.StubApp;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import me.tvspark.outline;
import org.json.JSONArray;
import org.json.JSONObject;
import org.litepal.parser.LitePalParser;

/* loaded from: classes4.dex */
public class UMCrash {
    public static final boolean DEFAULT_VALUE_CRASH_ANR = true;
    public static final boolean DEFAULT_VALUE_CRASH_JAVA = true;
    public static final boolean DEFAULT_VALUE_CRASH_NATIVE = true;
    public static final boolean DEFAULT_VALUE_CRASH_UNEXP = false;
    public static final boolean DEFAULT_VALUE_LAUNCH = true;
    public static final boolean DEFAULT_VALUE_MEM = true;
    public static final boolean DEFAULT_VALUE_NET = true;
    public static final boolean DEFAULT_VALUE_PA = true;
    public static final String INTEGRATIONTESTING_SP = "itconfig";
    public static final String IT_DEBUGKEY = "apm_debugkey";
    public static final String IT_SENDAGING = "apm_sendaging";
    public static final String KEY_ACTIITY_ON_CREATED = "onCreated";
    public static final String KEY_ACTIITY_ON_DESTROYED = "onDestroyed";
    public static final String KEY_ACTIITY_ON_PAUSED = "onPaused";
    public static final String KEY_ACTIITY_ON_RESUMED = "onResumed";
    public static final String KEY_ACTIITY_ON_STARTED = "onStarted";
    public static final String KEY_ACTIITY_ON_STOPPED = "onStopped";
    public static final String KEY_APM_DEFAULT_SECRET = "NEej8y@anWa*8hep";
    public static final String KEY_APM_ROOT_NAME = "UApm";
    public static final String KEY_CALLBACK_PAGE_ACTION = "um_action_log";
    public static final String KEY_CALLBACK_UMID = "um_umid";
    public static final String KEY_CALLBACK_USER_STRING = "um_user_string";
    public static final String KEY_DEBUGKEY = "um_dk";
    public static final String KEY_ENABLE_ANR = "enableANRLog";
    public static final String KEY_ENABLE_CRASH_JAVA = "enableJavaLog";
    public static final String KEY_ENABLE_CRASH_NATIVE = "enableNativeLog";
    public static final String KEY_ENABLE_CRASH_UNEXP = "enableUnexpLog";
    public static final String KEY_ENABLE_LAUNCH = "enableLaunchLog";
    public static final String KEY_ENABLE_MEM = "enableMemLog";
    public static final String KEY_ENABLE_NET = "enableNetLog";
    public static final String KEY_ENABLE_PA = "enablePaLog";
    public static final String KEY_HEADER_ACCESS = "um_access";
    public static final String KEY_HEADER_ACCESS_SUBTYPE = "um_access_subtype";
    public static final String KEY_HEADER_APPKEY = "um_app_key";
    public static final String KEY_HEADER_BESRIAL = "um_bserial";
    public static final String KEY_HEADER_BSVER = "um_bsver";
    public static final String KEY_HEADER_BVER = "um_bver";
    public static final String KEY_HEADER_CARRIER = "um_app_carrier";
    public static final String KEY_HEADER_CHANNEL = "um_app_channel";
    public static final String KEY_HEADER_CRASH_VERSION = "um_crash_sdk_version";
    public static final String KEY_HEADER_DEBUGKEY = "um_dk";
    public static final String KEY_HEADER_NETWORK_TYPE = "um_network_type";
    public static final String KEY_HEADER_OS = "um_os";
    public static final String KEY_HEADER_PROVIDER = "um_app_provider";
    public static final String KEY_HEADER_PUID = "um_app_puid";
    public static final String KEY_HEADER_START_TIME = "um_app_start_time";
    public static final String KEY_HEADER_UMID = "um_umid_header";
    public static final int KEY_MAX_LENGTH = 256;
    public static final int KEY_MAX_LENGTH_128 = 128;
    public static final String SP_KEY_DEBUG = "debugkey";
    public static final String SP_KEY_TIMESTAMP = "timestamp";
    public static final String TAG = "UMCrash";
    public static String crashSdkVersion = "1.5.2";
    public static boolean isDebug = true;
    public static boolean isEncrypt = false;
    public static boolean isIntl = false;
    public static boolean isZip = true;
    public static Context mContext;
    public static UMCrashCallback mUMCrashCallback;
    public static EfsReporter sReporter;
    public static String userBesrial;
    public static String userBsver;
    public static String userBver;
    public static Object pageArrayLock = new Object();
    public static ArrayList<String> mArrayList = new ArrayList<>(10);
    public static boolean isPA = false;
    public static boolean isLa = false;
    public static boolean isNet = false;
    public static boolean enableJavaLog = true;
    public static boolean enableNativeLog = true;
    public static boolean enableANRLog = true;
    public static boolean enablePaLog = true;
    public static boolean enableLaunchLog = true;
    public static boolean enableMemLog = true;
    public static boolean enableNetLog = true;
    public static int index = 0;

    /* loaded from: classes4.dex */
    public static class CrashClientImpl implements ICrashClient {
        public CrashClientImpl() {
        }

        @Override // com.p046uc.crashsdk.export.ICrashClient
        public void onAddCrashStats(String str, int i, int i2) {
        }

        @Override // com.p046uc.crashsdk.export.ICrashClient
        public File onBeforeUploadLog(File file) {
            return file;
        }

        @Override // com.p046uc.crashsdk.export.ICrashClient
        public void onClientProcessLogGenerated(String str, File file, String str2) {
        }

        @Override // com.p046uc.crashsdk.export.ICrashClient
        public void onCrashRestarting(boolean z) {
        }

        @Override // com.p046uc.crashsdk.export.ICrashClient
        public String onGetCallbackInfo(String str, boolean z) {
            String onCallback;
            String str2 = null;
            if (!UMCrash.KEY_CALLBACK_PAGE_ACTION.equals(str)) {
                if (UMCrash.KEY_CALLBACK_UMID.equals(str)) {
                    return UMCrash.getUMID(UMCrash.mContext);
                }
                if (!UMCrash.KEY_CALLBACK_USER_STRING.equals(str) || UMCrash.mUMCrashCallback == null || (onCallback = UMCrash.mUMCrashCallback.onCallback()) == null) {
                    return null;
                }
                return onCallback.trim().getBytes().length > 256 ? UMCrashUtils.splitByByte(onCallback, 256) : onCallback;
            }
            try {
                if (UMCrash.mArrayList != null && UMCrash.mArrayList.size() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("source", 0);
                    jSONObject.put("action_name", "page_view");
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < UMCrash.mArrayList.size(); i++) {
                        String str3 = (String) UMCrash.mArrayList.get(i);
                        if (str3 != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("name", str3);
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put("action_parameter", jSONArray);
                    str2 = jSONObject.toString();
                    if (UMCrash.isDebug) {
                        String unused = UMCrash.TAG;
                    }
                }
            } catch (Throwable unused2) {
            }
            return str2;
        }

        @Override // com.p046uc.crashsdk.export.ICrashClient
        public void onLogGenerated(File file, String str) {
        }
    }

    public static /* synthetic */ int access$808() {
        int i = index;
        index = i + 1;
        return i;
    }

    public static /* synthetic */ int access$810() {
        int i = index;
        index = i - 1;
        return i;
    }

    public static void enableANRLog(boolean z) {
        enableANRLog = z;
    }

    public static void enableMemoryMonitor(boolean z) {
        UMMemoryMonitor.get().setEnable(z);
    }

    public static void enableNativeLog(boolean z) {
        enableNativeLog = z;
    }

    public static void generateCustomLog(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                CustomLogInfo customLogInfo = new CustomLogInfo(null, "exception");
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(KEY_CALLBACK_UMID);
                arrayList.add(KEY_CALLBACK_PAGE_ACTION);
                customLogInfo.mCallbacks = arrayList;
                HashMap hashMap = new HashMap(20);
                hashMap.put(UMCustomLogInfoBuilder.LOG_KEY_CT, "exception");
                hashMap.put(UMCustomLogInfoBuilder.LOG_KEY_AC, str2);
                StringBuffer stringBuffer = new StringBuffer();
                for (Map.Entry entry : hashMap.entrySet()) {
                    stringBuffer.append((String) entry.getKey());
                    stringBuffer.append(":");
                    stringBuffer.append((String) entry.getValue());
                    stringBuffer.append("\n");
                }
                String str3 = "Exception message:\nBack traces starts.\n" + str + "\nBack traces ends.";
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append(str3);
                    stringBuffer.append("\n");
                }
                customLogInfo.mData = stringBuffer;
                CrashApi crashApi = CrashApi.getInstance();
                if (crashApi == null) {
                    return;
                }
                crashApi.generateCustomLog(customLogInfo);
            } catch (Throwable unused) {
            }
        }
    }

    public static void generateCustomLog(Throwable th, String str) {
        if (th != null && !TextUtils.isEmpty(str)) {
            try {
                CustomLogInfo build = new UMCustomLogInfoBuilder(str).stack(th).build();
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(KEY_CALLBACK_UMID);
                arrayList.add(KEY_CALLBACK_PAGE_ACTION);
                build.mCallbacks = arrayList;
                CrashApi crashApi = CrashApi.getInstance();
                if (crashApi == null) {
                    return;
                }
                crashApi.generateCustomLog(build);
            } catch (Throwable unused) {
            }
        }
    }

    public static EfsReporter getReporter() {
        return sReporter;
    }

    public static String getUMAPMFlag() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LitePalParser.NODE_VERSION, 0);
            jSONObject.put("crash", 1);
            if (enableNativeLog) {
                jSONObject.put("crashNative", 1);
            } else {
                jSONObject.put("crashNative", 0);
            }
            if (enableANRLog) {
                jSONObject.put(LogType.ANR_TYPE, 1);
            } else {
                jSONObject.put(LogType.ANR_TYPE, 0);
            }
            if (isPA) {
                jSONObject.put("pa", 1);
            } else {
                jSONObject.put("pa", 0);
            }
            if (isLa) {
                jSONObject.put("la", 1);
            } else {
                jSONObject.put("la", 0);
            }
            if (UMMemoryMonitor.get().isEnable()) {
                jSONObject.put("mem", 1);
            } else {
                jSONObject.put("mem", 0);
            }
            if (isNet) {
                jSONObject.put("net", 1);
            } else {
                jSONObject.put("net", 0);
            }
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public static synchronized String getUMID(Context context) {
        Class<?> cls;
        Method method;
        synchronized (UMCrash.class) {
            String str = null;
            if (context == null) {
                return null;
            }
            try {
                cls = Class.forName("com.umeng.commonsdk.UMConfigure");
            } catch (ClassNotFoundException unused) {
                cls = null;
            }
            if (cls != null) {
                try {
                    method = cls.getMethod("getUMIDString", Context.class);
                } catch (NoSuchMethodException unused2) {
                    method = null;
                }
                if (method != null) {
                    try {
                        Object invoke = method.invoke(null, context);
                        if (invoke != null) {
                            str = invoke.toString();
                        }
                    } catch (IllegalAccessException | InvocationTargetException unused3) {
                    }
                }
            }
            return str;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x025c -> B:77:0x025f). Please submit an issue!!! */
    public static void init(final Context context, final String str, String str2) {
        int innerConfig;
        String str3 = "2G/3G";
        if (context == null || str == null) {
            return;
        }
        mContext = context;
        final SharedPreferences sharedPreferences = SharedPreferencesUtils.getSharedPreferences(context, INTEGRATIONTESTING_SP);
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("mDebug", isDebug);
            bundle.putBoolean("mEncryptLog", isEncrypt);
            bundle.putBoolean("mZipLog", isZip);
            bundle.putBoolean(KEY_ENABLE_CRASH_JAVA, enableJavaLog);
            bundle.putBoolean(KEY_ENABLE_CRASH_NATIVE, enableNativeLog);
            bundle.putBoolean(KEY_ENABLE_ANR, enableANRLog);
            bundle.putBoolean(KEY_ENABLE_CRASH_UNEXP, false);
            bundle.putBoolean("mIsInternational", isIntl);
            CrashApi createInstanceEx = CrashApi.createInstanceEx(context, str, isDebug, bundle, new CrashClientImpl());
            if (createInstanceEx != null) {
                createInstanceEx.addHeaderInfo(KEY_HEADER_APPKEY, str);
                createInstanceEx.addHeaderInfo(KEY_HEADER_CHANNEL, str2);
                createInstanceEx.addHeaderInfo(KEY_HEADER_OS, "android");
                createInstanceEx.addHeaderInfo(KEY_HEADER_CRASH_VERSION, crashSdkVersion);
                createInstanceEx.addHeaderInfo(KEY_HEADER_UMID, getUMID(context));
                String[] activeUser = UMCrashUtils.getActiveUser(context);
                if (activeUser != null && activeUser.length == 2) {
                    createInstanceEx.addHeaderInfo(KEY_HEADER_PUID, activeUser[1]);
                    createInstanceEx.addHeaderInfo(KEY_HEADER_PROVIDER, activeUser[0]);
                }
                createInstanceEx.addHeaderInfo(KEY_HEADER_CARRIER, UMCrashUtils.getNetworkOperatorName(context));
                if (!TextUtils.isEmpty(userBver)) {
                    createInstanceEx.addHeaderInfo(KEY_HEADER_BVER, userBver);
                }
                if (!TextUtils.isEmpty(userBsver)) {
                    createInstanceEx.addHeaderInfo(KEY_HEADER_BSVER, userBsver);
                }
                if (!TextUtils.isEmpty(userBesrial)) {
                    createInstanceEx.addHeaderInfo(KEY_HEADER_BESRIAL, userBesrial);
                }
                String[] networkAccessMode = NetworkUtil.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    str3 = NetworkUtil.NETWORK_TYPE_WIFI;
                } else if (!str3.equals(networkAccessMode[0])) {
                    str3 = "unknow";
                }
                createInstanceEx.addHeaderInfo(KEY_HEADER_ACCESS, str3);
                if (!"".equals(networkAccessMode[1])) {
                    createInstanceEx.addHeaderInfo(KEY_HEADER_ACCESS_SUBTYPE, networkAccessMode[1]);
                }
                int networkTypeUmeng = NetworkUtil.getNetworkTypeUmeng(context);
                createInstanceEx.addHeaderInfo(KEY_HEADER_NETWORK_TYPE, "" + networkTypeUmeng);
                createInstanceEx.addHeaderInfo("others_OS", UMCrashUtils.isHarmony(context) ? "harmony" : "Android");
                if (context instanceof Application) {
                    ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.umcrash.UMCrash.1
                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityCreated(Activity activity, Bundle bundle2) {
                            Intent intent;
                            Uri data;
                            String scheme;
                            long j;
                            boolean z;
                            UMCrash.saveActivityState(activity.getLocalClassName(), UMCrash.KEY_ACTIITY_ON_CREATED);
                            if (UMCrash.index != 0 || (intent = activity.getIntent()) == null || (data = intent.getData()) == null || (scheme = data.getScheme()) == null || scheme.isEmpty()) {
                                return;
                            }
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("um.");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
                            if (!scheme.contains(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString())) {
                                return;
                            }
                            Set<String> queryParameterNames = data.getQueryParameterNames();
                            if (!queryParameterNames.contains(UMCrash.IT_DEBUGKEY) || !queryParameterNames.contains(UMCrash.IT_SENDAGING)) {
                                return;
                            }
                            String queryParameter = data.getQueryParameter(UMCrash.IT_DEBUGKEY);
                            try {
                                j = Long.parseLong(data.getQueryParameter(UMCrash.IT_SENDAGING));
                            } catch (NumberFormatException unused) {
                                j = 0;
                            }
                            if (j < 0) {
                                sharedPreferences.edit().clear().apply();
                                z = false;
                            } else {
                                if (j > 6) {
                                    j = 6;
                                }
                                sharedPreferences.edit().putString("debugkey", queryParameter).apply();
                                sharedPreferences.edit().putLong("timestamp", (j * 60 * 60 * 1000) + System.currentTimeMillis()).apply();
                                UMCrashUtils.setIntegrationTesingParams(queryParameter);
                                z = true;
                            }
                            IntegrationTestingUtil.setIntegrationTestingInPeriod(z);
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityDestroyed(Activity activity) {
                            UMCrash.saveActivityState(activity.getLocalClassName(), UMCrash.KEY_ACTIITY_ON_DESTROYED);
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityPaused(Activity activity) {
                            UMCrash.saveActivityState(activity.getLocalClassName(), UMCrash.KEY_ACTIITY_ON_PAUSED);
                            UMCrash.access$810();
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityResumed(Activity activity) {
                            UMCrash.saveActivityState(activity.getLocalClassName(), UMCrash.KEY_ACTIITY_ON_RESUMED);
                            UMMemoryMonitor.get().onActivityResumed(activity);
                            UMCrash.access$808();
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityStarted(Activity activity) {
                            UMCrash.saveActivityState(activity.getLocalClassName(), UMCrash.KEY_ACTIITY_ON_STARTED);
                            UMMemoryMonitor.get().onActivityStarted(activity);
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityStopped(Activity activity) {
                            UMCrash.saveActivityState(activity.getLocalClassName(), UMCrash.KEY_ACTIITY_ON_STOPPED);
                            UMMemoryMonitor.get().onActivityStopped(activity);
                        }
                    });
                    createInstanceEx.registerInfoCallback(KEY_CALLBACK_UMID, 1048593);
                    createInstanceEx.registerInfoCallback(KEY_CALLBACK_PAGE_ACTION, 1048593);
                }
            }
        } catch (Throwable unused) {
        }
        try {
            initReporter(context, str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            String string = sharedPreferences.getString("debugkey", "");
            if (sharedPreferences.getLong("timestamp", 0L) - System.currentTimeMillis() < 0 || TextUtils.isEmpty(string)) {
                sharedPreferences.edit().clear().apply();
                IntegrationTestingUtil.setIntegrationTestingInPeriod(false);
            } else {
                IntegrationTestingUtil.setIntegrationTestingInPeriod(true);
                UMCrashUtils.setIntegrationTesingParams(string);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            if (enablePaLog) {
                PAFactory.Builder builder = new PAFactory.Builder(StubApp.getOrigApplicationContext(context.getApplicationContext()), new IEfsReporter() { // from class: com.umeng.umcrash.UMCrash.2
                    @Override // com.efs.sdk.p020pa.config.IEfsReporter
                    public EfsReporter getReporter() {
                        return UMCrash.sReporter;
                    }
                });
                builder.packageLevel(PackageLevel.RELEASE);
                PAFactory build = builder.build();
                build.getPaInstance().start();
                isPA = build.getConfigManager().enableTracer();
            } else {
                boolean z = isDebug;
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        try {
            if (enableLaunchLog) {
                LaunchManager.init(context, sReporter);
                if (LaunchManager.getLaunchConfigManager() != null) {
                    isLa = LaunchManager.getLaunchConfigManager().enableTracer();
                }
                String uMId = UMUtils.getUMId(context);
                if (uMId == null || TextUtils.isEmpty(uMId)) {
                    boolean z2 = isDebug;
                    ImprintHandler.getImprintService(context).registImprintCallback(C1543ak.f3036g, new UMImprintChangeCallback() { // from class: com.umeng.umcrash.UMCrash.3
                        @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                        public void onImprintValueChanged(String str4, String str5) {
                            if (UMCrash.isDebug) {
                                String unused2 = UMCrash.TAG;
                            }
                            try {
                                if (!C1543ak.f3036g.equals(str4)) {
                                    return;
                                }
                                LaunchManager.sendLaunchCache(context, str5);
                                ImprintHandler.getImprintService(context).unregistImprintCallback(C1543ak.f3036g, this);
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                            }
                        }
                    });
                }
            } else {
                boolean z3 = isDebug;
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        try {
            if (enableMemLog) {
                UMMemoryMonitor.get().start(context, sReporter);
            } else {
                boolean z4 = isDebug;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        try {
            innerConfig = UMCrashUtils.getInnerConfig(StubApp.getOrigApplicationContext(context.getApplicationContext()), UMCrashContent.APM_STATE_NET, -1);
            boolean z5 = isDebug;
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
        if (innerConfig != 0) {
            if (innerConfig == 100) {
                boolean z6 = isDebug;
                if (enableNetLog) {
                    NetManager.init(context, sReporter);
                    if (NetManager.getNetConfigManager() != null) {
                        isNet = NetManager.getNetConfigManager().enableTracer();
                    }
                }
            }
        }
        boolean z7 = isDebug;
    }

    public static void initConfig(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getBoolean(KEY_ENABLE_CRASH_JAVA, true)) {
                enableJavaLog = true;
            } else {
                enableJavaLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_CRASH_NATIVE, true)) {
                enableNativeLog = true;
            } else {
                enableNativeLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_ANR, true)) {
                enableANRLog = true;
            } else {
                enableANRLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_PA, true)) {
                enablePaLog = true;
            } else {
                enablePaLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_LAUNCH, true)) {
                enableLaunchLog = true;
            } else {
                enableLaunchLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_MEM, true)) {
                enableMemLog = true;
            } else {
                enableMemLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_NET, true)) {
                enableNetLog = true;
            } else {
                enableNetLog = false;
            }
        }
    }

    public static void initReporter(final Context context, String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put(KEY_HEADER_UMID, getUMID(context));
        hashMap.put(KEY_HEADER_CHANNEL, str2);
        hashMap.put(KEY_HEADER_CARRIER, UMCrashUtils.getNetworkOperatorName(context));
        hashMap.put(KEY_HEADER_OS, "android");
        hashMap.put(KEY_HEADER_CRASH_VERSION, crashSdkVersion);
        try {
            String[] activeUser = UMCrashUtils.getActiveUser(context);
            if (activeUser != null && activeUser.length == 2) {
                hashMap.put(KEY_HEADER_PUID, activeUser[1]);
                hashMap.put(KEY_HEADER_PROVIDER, activeUser[0]);
            }
        } catch (Throwable unused) {
            hashMap.put(KEY_HEADER_PUID, "");
            hashMap.put(KEY_HEADER_PROVIDER, "");
        }
        if (!TextUtils.isEmpty(userBver)) {
            hashMap.put(KEY_HEADER_BVER, userBver);
        }
        if (!TextUtils.isEmpty(userBsver)) {
            hashMap.put(KEY_HEADER_BSVER, userBsver);
        }
        if (!TextUtils.isEmpty(userBesrial)) {
            hashMap.put(KEY_HEADER_BESRIAL, userBesrial);
        }
        try {
            hashMap.put("others_OS", UMCrashUtils.isHarmony(context) ? "harmony" : "Android");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        EfsReporter build = new EfsReporter.Builder(StubApp.getOrigApplicationContext(context.getApplicationContext()), str, KEY_APM_DEFAULT_SECRET).debug(isDebug).efsDirRootName(KEY_APM_ROOT_NAME).printLogDetail(isDebug).intl(isIntl).enableWaStat(false).build();
        sReporter = build;
        build.addPublicParams(hashMap);
        try {
            sReporter.getAllSdkConfig(new String[]{UMCrashContent.APM_STATE_NET}, new IConfigCallback() { // from class: com.umeng.umcrash.UMCrash.4
                @Override // com.efs.sdk.base.observer.IConfigCallback
                public void onChange(Map<String, Object> map) {
                    try {
                        Object obj = map.get(UMCrashContent.APM_STATE_NET);
                        if (obj == null) {
                            return;
                        }
                        if (UMCrash.isDebug) {
                            obj.toString();
                        }
                        UMCrashUtils.saveInnerConfig(StubApp.getOrigApplicationContext(context.getApplicationContext()), UMCrashContent.APM_STATE_NET, obj);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            });
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void registerUMCrashCallback(UMCrashCallback uMCrashCallback) {
        if (uMCrashCallback != null) {
            mUMCrashCallback = uMCrashCallback;
            if (CrashApi.getInstance() == null) {
                return;
            }
            CrashApi.getInstance().registerInfoCallback(KEY_CALLBACK_USER_STRING, 1048593);
        }
    }

    public static void saveActivityState(String str, String str2) {
        try {
            if (mArrayList == null) {
                return;
            }
            if (mArrayList.size() >= 20) {
                mArrayList.remove(0);
            }
            ArrayList<String> arrayList = mArrayList;
            arrayList.add(str + "-" + System.currentTimeMillis() + "-" + str2);
        } catch (Throwable unused) {
        }
    }

    public static void setAppVersion(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.trim().getBytes().length > 128) {
                    str = UMCrashUtils.splitByByte(str, 128);
                }
                userBver = str;
            } else {
                boolean z = isDebug;
            }
            if (!TextUtils.isEmpty(str2)) {
                if (str2.trim().getBytes().length > 128) {
                    str2 = UMCrashUtils.splitByByte(str2, 128);
                }
                userBsver = str2;
            } else {
                boolean z2 = isDebug;
            }
            if (!TextUtils.isEmpty(str3)) {
                if (str3.trim().getBytes().length > 128) {
                    str3 = UMCrashUtils.splitByByte(str3, 128);
                }
                userBesrial = str3;
            } else {
                boolean z3 = isDebug;
            }
            CrashApi crashApi = CrashApi.getInstance();
            if (crashApi != null) {
                if (!TextUtils.isEmpty(userBver)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BVER, userBver);
                }
                if (!TextUtils.isEmpty(userBsver)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BSVER, userBsver);
                }
                if (!TextUtils.isEmpty(userBesrial)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BESRIAL, userBesrial);
                }
            } else {
                boolean z4 = isDebug;
            }
            HashMap hashMap = new HashMap(1);
            if (!TextUtils.isEmpty(userBver)) {
                hashMap.put(KEY_HEADER_BVER, userBver);
            }
            if (!TextUtils.isEmpty(userBsver)) {
                hashMap.put(KEY_HEADER_BSVER, userBsver);
            }
            if (!TextUtils.isEmpty(userBesrial)) {
                hashMap.put(KEY_HEADER_BESRIAL, userBesrial);
            }
            if (sReporter != null) {
                sReporter.addPublicParams(hashMap);
            } else {
                boolean z5 = isDebug;
            }
            if (!TextUtils.isEmpty(userBver)) {
                UMCrashUtils.setCommonTag(KEY_HEADER_BVER, userBver);
            }
            if (!TextUtils.isEmpty(userBsver)) {
                UMCrashUtils.setCommonTag(KEY_HEADER_BSVER, userBsver);
            }
            if (TextUtils.isEmpty(userBesrial)) {
                return;
            }
            UMCrashUtils.setCommonTag(KEY_HEADER_BESRIAL, userBesrial);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setDebug(boolean z) {
        isDebug = z;
        LaunchManager.isDebug = z;
    }

    public static void useIntlServices(boolean z) {
        isIntl = z;
        boolean z2 = isDebug;
    }
}

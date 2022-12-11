package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.provider.FontsContractCompat;
import com.stub.StubApp;
import com.tencent.smtt.export.external.DexClassLoaderProvider;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsPrivacyAccess;
import com.tencent.smtt.sdk.p045ui.dialog.C1410e;
import com.tencent.smtt.sdk.p045ui.dialog.DialogC1406d;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.C1428a;
import com.tencent.smtt.utils.C1429b;
import com.tencent.smtt.utils.C1460i;
import com.tencent.smtt.utils.C1465m;
import com.tencent.smtt.utils.C1472q;
import com.tencent.smtt.utils.FileProvider;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;
import me.tvspark.outline;
import org.json.JSONArray;
import org.json.JSONObject;
import org.simpleframework.xml.stream.DocumentReader;

@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class QbSdk {

    /* renamed from: A */
    public static String f1732A = null;

    /* renamed from: B */
    public static String f1733B = null;

    /* renamed from: C */
    public static boolean f1734C = false;

    /* renamed from: D */
    public static boolean f1735D = true;

    /* renamed from: E */
    public static TbsListener f1736E = null;
    public static final int EXTENSION_INIT_FAILURE = -99999;

    /* renamed from: F */
    public static TbsListener f1737F = null;
    public static final String FILERADER_MENUDATA = "menuData";

    /* renamed from: G */
    public static boolean f1738G = false;

    /* renamed from: H */
    public static boolean f1739H = false;
    public static final String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
    public static final String KEY_THIRD_PARTY_TURING = "turing";
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
    public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
    public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
    public static final int QBMODE = 2;
    public static final String SHARE_PREFERENCES_NAME = "tbs_file_open_dialog_config";
    public static final String SVNVERSION = "jnizz";
    public static final int TBSMODE = 1;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;

    /* renamed from: b */
    public static boolean f1741b = false;

    /* renamed from: c */
    public static boolean f1742c = true;

    /* renamed from: d */
    public static String f1743d = null;

    /* renamed from: e */
    public static boolean f1744e = false;

    /* renamed from: f */
    public static long f1745f = 0;

    /* renamed from: g */
    public static long f1746g = 0;

    /* renamed from: i */
    public static boolean f1748i = true;
    public static boolean isDefaultDialog = false;

    /* renamed from: j */
    public static boolean f1749j = true;

    /* renamed from: k */
    public static boolean f1750k = false;

    /* renamed from: l */
    public static boolean f1751l = false;
    public static boolean mDisableUseHostBackupCore = false;

    /* renamed from: p */
    public static int f1755p = 0;

    /* renamed from: q */
    public static String f1756q = "";

    /* renamed from: r */
    public static Class<?> f1757r = null;

    /* renamed from: s */
    public static Object f1758s = null;
    public static boolean sIsVersionPrinted = false;

    /* renamed from: t */
    public static boolean f1759t = false;

    /* renamed from: u */
    public static String[] f1760u = null;

    /* renamed from: v */
    public static String f1761v = "NULL";

    /* renamed from: w */
    public static String f1762w = "UNKNOWN";

    /* renamed from: x */
    public static boolean f1763x = false;

    /* renamed from: y */
    public static int f1764y = 0;

    /* renamed from: z */
    public static int f1765z = 170;

    /* renamed from: h */
    public static Object f1747h = new Object();

    /* renamed from: a */
    public static boolean f1740a = false;

    /* renamed from: m */
    public static volatile boolean f1752m = f1740a;

    /* renamed from: n */
    public static TbsListener f1753n = new TbsListener() { // from class: com.tencent.smtt.sdk.QbSdk.7
        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadFinish(int i) {
            if (TbsDownloader.needDownloadDecoupleCore()) {
                TbsLog.m2153i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
                TbsDownloader.f1858a = true;
                return;
            }
            TbsLog.m2153i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
            TbsDownloader.f1858a = false;
            if (QbSdk.f1736E != null) {
                QbSdk.f1736E.onDownloadFinish(i);
            }
            if (QbSdk.f1737F == null) {
                return;
            }
            QbSdk.f1737F.onDownloadFinish(i);
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadProgress(int i) {
            if (QbSdk.f1737F != null) {
                QbSdk.f1737F.onDownloadProgress(i);
            }
            if (QbSdk.f1736E != null) {
                QbSdk.f1736E.onDownloadProgress(i);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onInstallFinish(int i) {
            if (i == 243 && QbSdk.f1737F != null) {
                QbSdk.f1737F.onInstallFinish(i);
                return;
            }
            if (i != 200) {
            }
            TbsLog.m2153i("QbSdk", "onInstallFinish errCode is " + i, true);
            QbSdk.setTBSInstallingStatus(false);
            TbsDownloader.f1858a = false;
            if (TbsDownloader.startDecoupleCoreIfNeeded()) {
                TbsDownloader.f1858a = true;
            } else {
                TbsDownloader.f1858a = false;
            }
            if (QbSdk.f1736E != null) {
                QbSdk.f1736E.onInstallFinish(i);
            }
            if (QbSdk.f1737F == null) {
                return;
            }
            QbSdk.f1737F.onInstallFinish(i);
        }
    };

    /* renamed from: o */
    public static Map<String, Object> f1754o = null;
    @Deprecated
    public static final String USER_ID_FROM_APP_IMSI = TbsPrivacyAccess.ConfigurablePrivacy.IMSI.f1926a;
    @Deprecated
    public static final String USER_ID_FROM_APP_ANDROID_ID = TbsPrivacyAccess.ConfigurablePrivacy.ANDROID_ID.f1926a;
    @Deprecated
    public static final String USER_ID_FROM_APP_MAC = TbsPrivacyAccess.ConfigurablePrivacy.MAC.f1926a;
    @Deprecated
    public static final String USER_ID_FROM_APP_ANDROID_VERSION = TbsPrivacyAccess.ConfigurablePrivacy.ANDROID_VERSION.f1926a;
    @Deprecated
    public static final String USER_ID_FROM_APP_DEVICE_MODEL = TbsPrivacyAccess.ConfigurablePrivacy.DEVICE_MODEL.f1926a;
    public static final String USER_ID_FROM_APP_QIMEI36 = TbsPrivacyAccess.ConfigurablePrivacy.QIMEI36.f1926a;

    /* loaded from: classes4.dex */
    public interface PreInitCallback {
        void onCoreInitFinished();

        void onViewInitFinished(boolean z);
    }

    /* renamed from: a */
    public static Bundle m2835a(Context context, Bundle bundle) throws Exception {
        TbsLogReport tbsLogReport;
        String str;
        if (!m2838a(context)) {
            tbsLogReport = TbsLogReport.getInstance(context);
            str = "initForPatch return false!";
        } else {
            Object m2049a = C1460i.m2049a(f1758s, "incrUpdate", new Class[]{Context.class, Bundle.class}, context, bundle);
            if (m2049a != null) {
                return (Bundle) m2049a;
            }
            tbsLogReport = TbsLogReport.getInstance(context);
            str = "incrUpdate return null!";
        }
        tbsLogReport.setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_ERROR, str);
        return null;
    }

    /* renamed from: a */
    public static Bundle m2831a(Context context, Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("style", map.get("style") == null ? "0" : map.get("style"));
            try {
                bundle.putInt("topBarBgColor", Color.parseColor(map.get("topBarBgColor")));
            } catch (Exception unused) {
            }
            if (map.containsKey(FILERADER_MENUDATA)) {
                JSONObject jSONObject = new JSONObject(map.get(FILERADER_MENUDATA));
                JSONArray jSONArray = jSONObject.getJSONArray("menuItems");
                if (jSONArray != null) {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    for (int i = 0; i < jSONArray.length() && i < 5; i++) {
                        try {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                            arrayList.add(i, BitmapFactory.decodeResource(context.getResources(), jSONObject2.getInt("iconResId")));
                            jSONObject2.put("iconResId", i);
                        } catch (Exception unused2) {
                        }
                    }
                    bundle.putParcelableArrayList("resArray", arrayList);
                }
                bundle.putString(FILERADER_MENUDATA, jSONObject.toString());
            }
            return bundle;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static Object m2832a(Context context, String str, Bundle bundle) {
        if (!m2838a(context)) {
            return Integer.valueOf((int) EXTENSION_INIT_FAILURE);
        }
        Object m2049a = C1460i.m2049a(f1758s, "miscCall", new Class[]{String.class, Bundle.class}, str, bundle);
        if (m2049a == null) {
            return null;
        }
        return m2049a;
    }

    /* renamed from: a */
    public static String m2839a() {
        return f1756q;
    }

    /* renamed from: a */
    public static void m2834a(Context context, Integer num, Map<Integer, String> map) {
        if (!m2838a(context)) {
            return;
        }
        C1460i.m2049a(f1758s, "dispatchEmergencyCommand", new Class[]{Integer.class, Map.class}, num, map);
    }

    /* renamed from: a */
    public static synchronized void m2833a(Context context, String str) {
        synchronized (QbSdk.class) {
            if (f1740a) {
                return;
            }
            f1740a = true;
            f1762w = "forceSysWebViewInner: " + str;
            TbsLog.m2157e("QbSdk", "forceSysWebViewInner", "Reason:" + f1762w);
            TbsLog.m2157e("QbSdk", "forceSysWebViewInner", Log.getStackTraceString(new Throwable("#")));
            TbsCoreLoadStat.getInstance().m2815a(context, 401);
        }
    }

    /* renamed from: a */
    public static boolean m2838a(Context context) {
        try {
            if (f1757r != null) {
                return true;
            }
            File m2437r = C1381p.m2503a().m2437r(context);
            if (m2437r == null) {
                TbsLog.m2158e("QbSdk", "QbSdk initExtension (false) optDir == null");
                return false;
            }
            File file = new File(m2437r, "tbs_sdk_extension_dex.jar");
            if (!file.exists()) {
                TbsLog.m2156e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
                return false;
            }
            TbsLog.m2155i("QbSdk", "new DexLoader #3 dexFile is " + file.getAbsolutePath());
            C1416x.m2294a().m2290b(context);
            C1465m.m2023a(context);
            f1757r = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, m2437r.getAbsolutePath(), getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            if (isEnableSensitiveApi() || C1460i.m2052a(f1757r, "isSuiteableGetSensitative", (Class<?>[]) new Class[0], new Object[0]) != null) {
                loadTBSSDKExtension(context, file.getParent());
                return true;
            }
            TbsLog.m2158e("QbSdk", "isSuiteableGetSensitative check failed,can not use x5");
            return false;
        } catch (Throwable th) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("initExtension sys WebView: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(th));
            TbsLog.m2158e("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m2837a(Context context, int i) {
        return m2836a(context, i, 20000);
    }

    /* renamed from: a */
    public static boolean m2836a(Context context, int i, int i2) {
        Map<String, Object> map = f1754o;
        if (map != null && map.containsKey(KEY_SET_SENDREQUEST_AND_UPLOAD) && f1754o.get(KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.m2155i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return true;
        } else if (!isEnableSensitiveApi() && C1460i.m2052a(f1757r, "isSuiteableGetSensitative", (Class<?>[]) new Class[0], new Object[0]) == null) {
            TbsLog.m2158e("QbSdk", "isSuiteableGetSensitative check failed,can not use x5");
            return false;
        } else {
            C1381p.m2503a().m2473b(context, C1363g.f2113a == 0);
            if (!m2824c(context)) {
                return true;
            }
            Object obj = f1758s;
            Class cls = Integer.TYPE;
            Object m2049a = C1460i.m2049a(obj, "isX5Disabled", new Class[]{cls, cls, cls}, Integer.valueOf(i), 44115, Integer.valueOf(i2));
            if (m2049a == null) {
                Object obj2 = f1758s;
                Class cls2 = Integer.TYPE;
                m2049a = C1460i.m2049a(obj2, "isX5Disabled", new Class[]{cls2, cls2}, Integer.valueOf(i), 44115);
                if (m2049a == null) {
                    return true;
                }
            }
            return ((Boolean) m2049a).booleanValue();
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static boolean m2830a(Context context, boolean z) {
        int i;
        File file;
        TbsLog.initIfNeed(context);
        if (!sIsVersionPrinted) {
            TbsLog.m2155i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 44115; SDK_VERSION_NAME: 4.3.0.215");
            sIsVersionPrinted = true;
        }
        if (f1740a && !z) {
            TbsCoreLoadStat.getInstance().m2815a(context, 414);
            TbsLog.m2157e("QbSdk", "init", "Force WebView Inner, " + f1762w);
            return false;
        } else if (f1741b) {
            TbsCoreLoadStat.getInstance().m2815a(context, 402);
            TbsLog.m2157e("QbSdk", "init", "QbSdk init mIsSysWebViewForcedByOuter = true, " + f1761v);
            return false;
        } else {
            if (!f1735D) {
                m2822d(context);
            }
            try {
                File m2437r = C1381p.m2503a().m2437r(context);
                if (m2437r == null) {
                    TbsCoreLoadStat.getInstance().m2814a(context, TbsListener.ErrorCode.ERROR_TBSCORE_SHARE_DIR, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                    return false;
                }
                if (TbsShareManager.isThirdPartyApp(context)) {
                    if (f1755p != 0 && f1755p != TbsShareManager.m2728d(context)) {
                        f1757r = null;
                        f1758s = null;
                        TbsCoreLoadStat.getInstance().m2815a(context, 302);
                        TbsLog.m2147w("QbSdk", "init", "return false, thirdParty not match TBS core ver, details:sTbsVersion: " + f1755p + "; AvailableTbsCoreVersion: " + TbsShareManager.m2728d(context));
                        return false;
                    }
                    i = TbsShareManager.m2728d(context);
                } else if (f1755p != 0) {
                    i = C1381p.m2503a().m2483a(true, context);
                    if (f1755p != i) {
                        f1757r = null;
                        f1758s = null;
                        TbsCoreLoadStat tbsCoreLoadStat = TbsCoreLoadStat.getInstance();
                        tbsCoreLoadStat.m2814a(context, 303, new Throwable("sTbsVersion: " + f1755p + "; tbsCoreInstalledVer: " + i));
                        return false;
                    }
                } else {
                    i = 0;
                }
                f1755p = i;
                if (TbsDownloader.m2808a(context, f1755p)) {
                    TbsLog.m2154i("QbSdk", "init", "version " + f1755p + " is in blacklist,can not load! return");
                    return false;
                } else if (f1757r != null && f1758s != null) {
                    return true;
                } else {
                    if (!TbsShareManager.isThirdPartyApp(context)) {
                        file = new File(C1381p.m2503a().m2437r(context), "tbs_sdk_extension_dex.jar");
                    } else if (!TbsShareManager.m2721j(context)) {
                        TbsCoreLoadStat.getInstance().m2814a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                        return false;
                    } else {
                        file = new File(TbsShareManager.m2730c(context), "tbs_sdk_extension_dex.jar");
                    }
                    if (!file.exists()) {
                        int m2446j = C1381p.m2503a().m2446j(context);
                        File file2 = new File(file.getParentFile(), DexClassLoaderProvider.LAST_DEX_NAME);
                        TbsCoreLoadStat.getInstance().m2815a(context, 403);
                        TbsLog.m2147w("QbSdk", "init", "[loadMsg] extension is miss, fusion exist is " + file2.exists() + ", core is " + m2446j + ", dexPath is " + file.getPath());
                        return false;
                    }
                    String hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : m2437r.getAbsolutePath();
                    TbsLog.m2154i("QbSdk", "init", "optDirExtension #1 is " + hostCorePathAppDefined);
                    TbsLog.m2154i("QbSdk", "init", "new DexLoader #1 dexFile is " + file.getAbsolutePath());
                    C1416x.m2294a().m2290b(context);
                    C1465m.m2023a(context);
                    f1757r = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hostCorePathAppDefined, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    if (!isEnableSensitiveApi() && C1460i.m2052a(f1757r, "isSuiteableGetSensitative", (Class<?>[]) new Class[0], new Object[0]) == null) {
                        TbsLog.m2157e("QbSdk", "init", "isSuiteableGetSensitative check failed, can not use x5");
                        return false;
                    }
                    loadTBSSDKExtension(context, file.getParent());
                    C1460i.m2049a(f1758s, "setClientVersion", new Class[]{Integer.TYPE}, 1);
                    return true;
                }
            } catch (Throwable th) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("QbSdk init Throwable: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(th));
                TbsLog.m2158e("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                TbsCoreLoadStat.getInstance().m2814a(context, 306, th);
                return false;
            }
        }
    }

    /* renamed from: a */
    public static boolean m2829a(Context context, boolean z, boolean z2) {
        int i;
        TbsCoreLoadStat tbsCoreLoadStat;
        int i2;
        Throwable th;
        TbsLog.m2154i("QbSdk", "canLoadX5", "#1# installTbsCoreIfNeeded");
        boolean z3 = true;
        boolean z4 = false;
        C1381p.m2503a().m2473b(context, C1363g.f2113a == 0);
        int disabledCoreVersion = TbsPVConfig.getInstance(context).getDisabledCoreVersion();
        if (disabledCoreVersion != 0 && disabledCoreVersion == C1381p.m2503a().m2446j(context)) {
            TbsLog.m2157e("QbSdk", "canLoadX5", "#2-1# force use sys by remote switch");
            return false;
        }
        if (TbsShareManager.isThirdPartyApp(context)) {
            TbsLog.m2154i("QbSdk", "canLoadX5", "#2# isThirdPartyApp");
            if (!TbsShareManager.m2722i(context)) {
                TbsLog.m2147w("QbSdk", "canLoadX5", "#2-3# thirdParty no core available before init");
                TbsCoreLoadStat.getInstance().m2815a(context, 302);
                return false;
            }
        }
        if (!m2830a(context, z)) {
            TbsLog.m2157e("QbSdk", "canLoadX5", "#2-4# QbSdk.init failure!");
            return false;
        }
        Object m2049a = C1460i.m2049a(f1758s, "canLoadX5Core", new Class[]{Integer.TYPE}, 44115);
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("#3# invoke sExtensionObj canLoadX5Core and ret is ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(m2049a != null);
        TbsLog.m2154i("QbSdk", "canLoadX5", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        if (m2049a == null) {
            Object m2049a2 = C1460i.m2049a(f1758s, "canLoadX5", new Class[]{Integer.TYPE}, Integer.valueOf(C1344a.m2662a()));
            if (m2049a2 == null) {
                TbsCoreLoadStat.getInstance().m2815a(context, 308);
            } else if ((m2049a2 instanceof String) && ((String) m2049a2).equalsIgnoreCase("AuthenticationFail")) {
                return false;
            } else {
                if (m2049a2 instanceof Boolean) {
                    f1755p = C1363g.m2592d();
                    boolean m2837a = m2837a(context, C1363g.m2592d());
                    Boolean bool = (Boolean) m2049a2;
                    if (!bool.booleanValue() || m2837a) {
                        z3 = false;
                    }
                    if (!z3) {
                        TbsLog.m2158e(TbsListener.tag_load_error, "318");
                        TbsLog.m2148w(TbsListener.tag_load_error, "isX5Disable:" + m2837a);
                        TbsLog.m2148w(TbsListener.tag_load_error, "(Boolean) ret:" + bool);
                    }
                    return z3;
                }
            }
        } else if ((m2049a instanceof String) && ((String) m2049a).equalsIgnoreCase("AuthenticationFail")) {
            TbsLog.m2157e("QbSdk", "canLoadX5", "[LoadError] authenticationFail");
            return false;
        } else if (!(m2049a instanceof Bundle)) {
            TbsCoreLoadStat.getInstance().m2814a(context, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, new Throwable(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", m2049a)));
            TbsLog.m2157e("QbSdk", "canLoadX5", "[LoadError] ret not instance of bundle, ret:" + m2049a);
            return false;
        } else {
            Bundle bundle = (Bundle) m2049a;
            if (bundle.isEmpty()) {
                TbsCoreLoadStat.getInstance().m2814a(context, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, new Throwable(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", m2049a)));
                TbsLog.m2157e("QbSdk", "canLoadX5", "[LoadError] empty bundle" + m2049a);
                return false;
            }
            try {
                i = bundle.getInt(FontsContractCompat.Columns.RESULT_CODE, -1);
            } catch (Exception e) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("bundle.getInt(KEY_RESULT_CODE) error : ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e.toString());
                TbsLog.m2158e("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                i = -1;
            }
            boolean z5 = i == 0;
            if (TbsShareManager.isThirdPartyApp(context)) {
                C1363g.m2600a(TbsShareManager.m2728d(context));
                String valueOf = String.valueOf(TbsShareManager.m2728d(context));
                f1756q = valueOf;
                if (valueOf.length() == 5) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("0");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(f1756q);
                    f1756q = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString();
                }
                if (f1756q.length() != 6) {
                    f1756q = "";
                }
            } else {
                try {
                    f1756q = bundle.getString("tbs_core_version", "0");
                } catch (Exception unused) {
                    f1756q = "0";
                }
                try {
                    f1755p = Integer.parseInt(f1756q);
                } catch (NumberFormatException unused2) {
                    f1755p = 0;
                }
                C1363g.m2600a(f1755p);
                int i3 = f1755p;
                if (i3 == 0) {
                    TbsCoreLoadStat.getInstance().m2814a(context, 307, new Throwable("sTbsVersion is 0"));
                    TbsLog.m2157e("QbSdk", "canLoadX5", "[LoadError] sTbsVersion is 0");
                    return false;
                }
                if ((i3 <= 0 || i3 > 25442) && f1755p != 25472) {
                    z3 = false;
                }
                if (z3) {
                    FileUtil.m2175b(C1381p.m2503a().m2437r(context));
                    TbsCoreLoadStat tbsCoreLoadStat2 = TbsCoreLoadStat.getInstance();
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("is_obsolete --> delete old core:");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(f1755p);
                    tbsCoreLoadStat2.m2814a(context, 307, new Throwable(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString()));
                    TbsLog.m2157e("QbSdk", "canLoadX5", "is_obsolete --> delete old core:" + f1755p);
                    return false;
                }
            }
            try {
                String[] stringArray = bundle.getStringArray("tbs_jarfiles");
                f1760u = stringArray;
                if (!(stringArray instanceof String[])) {
                    TbsCoreLoadStat tbsCoreLoadStat3 = TbsCoreLoadStat.getInstance();
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("sJarFiles not instanceof String[]: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(f1760u);
                    tbsCoreLoadStat3.m2814a(context, 307, new Throwable(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString()));
                    TbsLog.m2157e("QbSdk", "canLoadX5", "sJarFiles not instanceof String[]: " + f1760u);
                    return false;
                }
                try {
                    f1743d = bundle.getString("tbs_librarypath");
                    Object obj = null;
                    if (i != 0) {
                        try {
                            obj = C1460i.m2049a(f1758s, "getErrorCodeForLogReport", new Class[0], new Object[0]);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (i != -2) {
                        if (i != -1) {
                            if (i != 0) {
                                tbsCoreLoadStat = TbsCoreLoadStat.getInstance();
                                i2 = 415;
                                th = new Throwable("detail: " + obj + "errcode" + i);
                            }
                            z4 = z5;
                        } else if (obj instanceof Integer) {
                            tbsCoreLoadStat = TbsCoreLoadStat.getInstance();
                            i2 = ((Integer) obj).intValue();
                            th = new Throwable(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("detail: ", obj));
                        } else {
                            TbsCoreLoadStat.getInstance().m2814a(context, 307, new Throwable(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("detail: ", obj)));
                            z4 = z5;
                        }
                    } else if (obj instanceof Integer) {
                        tbsCoreLoadStat = TbsCoreLoadStat.getInstance();
                        i2 = ((Integer) obj).intValue();
                        th = new Throwable(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("detail: ", obj));
                    } else {
                        tbsCoreLoadStat = TbsCoreLoadStat.getInstance();
                        i2 = 404;
                        th = new Throwable(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("detail: ", obj));
                    }
                    tbsCoreLoadStat.m2814a(context, i2, th);
                    z4 = z5;
                } catch (Exception unused3) {
                    return false;
                }
            } catch (Throwable th2) {
                TbsCoreLoadStat.getInstance().m2814a(context, TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, th2);
                return false;
            }
        }
        if (!z4) {
            TbsLog.m2147w("QbSdk", "canLoadX5", "#4# error code: 319");
        }
        return z4;
    }

    /* renamed from: b */
    public static String m2827b() {
        Object invokeStaticMethod;
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b() || (invokeStaticMethod = m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0])) == null || !(invokeStaticMethod instanceof String)) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    /* renamed from: b */
    public static boolean m2826b(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null) {
            return false;
        }
        try {
            if (!context.getApplicationInfo().packageName.contains("com.tencent.portfolio")) {
                return true;
            }
            TbsLog.m2155i("QbSdk", "clearPluginConfigFile #1");
            String string = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null);
            String str = context.getPackageManager().getPackageInfo("com.tencent.portfolio", 0).versionName;
            TbsLog.m2155i("QbSdk", "clearPluginConfigFile oldAppVersionName is " + string + " newAppVersionName is " + str);
            if (string == null || string.contains(str) || (sharedPreferences = context.getSharedPreferences("plugin_setting", 0)) == null) {
                return true;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.clear();
            edit.commit();
            TbsLog.m2155i("QbSdk", "clearPluginConfigFile done");
            return true;
        } catch (Throwable th) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("clearPluginConfigFile error is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.getMessage());
            TbsLog.m2155i("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m2824c(Context context) {
        File file;
        try {
            if (f1757r != null) {
                return true;
            }
            File m2437r = C1381p.m2503a().m2437r(context);
            if (m2437r == null) {
                TbsLog.m2158e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
                return false;
            }
            if (!TbsShareManager.isThirdPartyApp(context)) {
                file = new File(C1381p.m2503a().m2437r(context), "tbs_sdk_extension_dex.jar");
            } else if (!TbsShareManager.m2721j(context)) {
                TbsCoreLoadStat.getInstance().m2815a(context, 304);
                return false;
            } else {
                file = new File(TbsShareManager.m2730c(context), "tbs_sdk_extension_dex.jar");
            }
            if (!file.exists()) {
                TbsCoreLoadStat.getInstance().m2814a(context, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
                return false;
            }
            String hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : m2437r.getAbsolutePath();
            TbsLog.m2155i("QbSdk", "QbSdk init optDirExtension #3 is " + hostCorePathAppDefined);
            TbsLog.m2155i("QbSdk", "new DexLoader #4 dexFile is " + file.getAbsolutePath());
            C1416x.m2294a().m2290b(context);
            C1465m.m2023a(context);
            f1757r = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hostCorePathAppDefined, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            if (!isEnableSensitiveApi() && C1460i.m2052a(f1757r, "isSuiteableGetSensitative", (Class<?>[]) new Class[0], new Object[0]) == null) {
                TbsLog.m2158e("QbSdk", "isSuiteableGetSensitative check failed,can not use x5");
                return false;
            }
            loadTBSSDKExtension(context, file.getParent());
            C1460i.m2049a(f1758s, "setClientVersion", new Class[]{Integer.TYPE}, 1);
            return true;
        } catch (Throwable th) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("initForX5DisableConfig sys WebView: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(th));
            TbsLog.m2158e("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return false;
        }
    }

    @Deprecated
    public static void canGetAndroidId(boolean z) {
        TbsPrivacyAccess.AndroidId.setEnabled(z);
    }

    @Deprecated
    public static void canGetDeviceId(boolean z) {
        TbsPrivacyAccess.DeviceId.setEnabled(z);
    }

    @Deprecated
    public static void canGetSubscriberId(boolean z) {
        TbsPrivacyAccess.Imsi.setEnabled(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean canLoadVideo(Context context) {
        TbsCoreLoadStat tbsCoreLoadStat;
        int i;
        Object m2049a = C1460i.m2049a(f1758s, "canLoadVideo", new Class[]{Integer.TYPE}, 0);
        if (m2049a != null) {
            if (!((Boolean) m2049a).booleanValue()) {
                tbsCoreLoadStat = TbsCoreLoadStat.getInstance();
                i = TbsListener.ErrorCode.ERROR_CANLOADVIDEO_RETURN_FALSE;
            }
            if (m2049a == null) {
                return ((Boolean) m2049a).booleanValue();
            }
            return false;
        }
        tbsCoreLoadStat = TbsCoreLoadStat.getInstance();
        i = TbsListener.ErrorCode.ERROR_CANLOADVIDEO_RETURN_NULL;
        tbsCoreLoadStat.m2815a(context, i);
        if (m2049a == null) {
        }
    }

    public static boolean canLoadX5(Context context) {
        return m2829a(context, false, false);
    }

    public static boolean canLoadX5FirstTimeThirdApp(Context context) {
        try {
            context.getApplicationInfo().packageName.contains("com.moji.mjweather");
            if (f1757r == null) {
                File m2437r = C1381p.m2503a().m2437r(context);
                if (m2437r == null) {
                    TbsLog.m2158e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
                    return false;
                }
                File file = new File(TbsShareManager.m2730c(context), "tbs_sdk_extension_dex.jar");
                if (!file.exists()) {
                    TbsLog.m2156e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
                    return false;
                }
                String hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : m2437r.getAbsolutePath();
                TbsLog.m2155i("QbSdk", "QbSdk init optDirExtension #2 is " + hostCorePathAppDefined);
                TbsLog.m2155i("QbSdk", "new DexLoader #2 dexFile is " + file.getAbsolutePath());
                C1416x.m2294a().m2290b(context);
                C1465m.m2023a(context);
                f1757r = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hostCorePathAppDefined, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                if (f1758s == null) {
                    if (TbsShareManager.m2726e(context) == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                        TbsLogReport.getInstance(StubApp.getOrigApplicationContext(context.getApplicationContext())).setLoadErrorCode(TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL, "host context is null!");
                        return false;
                    } else if (!isEnableSensitiveApi() && C1460i.m2052a(f1757r, "isSuiteableGetSensitative", (Class<?>[]) new Class[0], new Object[0]) == null) {
                        TbsLog.m2158e("QbSdk", "isSuiteableGetSensitative check failed,can not use x5");
                        return false;
                    } else {
                        loadTBSSDKExtension(context, file.getParent());
                    }
                }
            }
            Object m2049a = C1460i.m2049a(f1758s, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
            if (m2049a != null && (m2049a instanceof Boolean)) {
                return ((Boolean) m2049a).booleanValue();
            }
            return false;
        } catch (Throwable th) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("canLoadX5FirstTimeThirdApp sys WebView: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(th));
            TbsLog.m2158e("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return false;
        }
    }

    public static void canOpenFile(final Context context, final String str, final ValueCallback<Boolean> valueCallback) {
        new Thread() { // from class: com.tencent.smtt.sdk.QbSdk.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                C1416x m2294a = C1416x.m2294a();
                m2294a.m2293a(context);
                final boolean m2284a = m2294a.m2291b() ? m2294a.m2289c().m2284a(context, str) : false;
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.smtt.sdk.QbSdk.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        valueCallback.onReceiveValue(Boolean.valueOf(m2284a));
                    }
                });
            }
        }.start();
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        m2830a(context, false);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.Properties] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.FileInputStream, java.io.InputStream] */
    public static boolean canOpenWebPlus(Context context) {
        BufferedInputStream bufferedInputStream;
        ?? fileInputStream;
        if (f1764y == 0) {
            f1764y = C1344a.m2662a();
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("canOpenWebPlus - totalRAM: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f1764y);
        TbsLog.m2155i("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        boolean z = false;
        if (f1764y >= f1765z && context != null) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(C1381p.m2503a().m2437r(context), "tbs.conf")));
            } catch (Throwable th) {
                th = th;
            }
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                String property = properties.getProperty("android_sdk_max_supported");
                String property2 = properties.getProperty("android_sdk_min_supported");
                int parseInt = Integer.parseInt(property);
                int parseInt2 = Integer.parseInt(property2);
                int parseInt3 = Integer.parseInt(Build.VERSION.SDK);
                if (parseInt3 <= parseInt && parseInt3 >= parseInt2) {
                    int parseInt4 = Integer.parseInt(properties.getProperty("tbs_core_version"));
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused) {
                    }
                    try {
                        fileInputStream = new FileInputStream(new File(C1381p.m2435t(context), "tbs_extension.conf"));
                        try {
                            ?? properties2 = new Properties();
                            properties2.load(fileInputStream);
                            int parseInt5 = Integer.parseInt(properties2.getProperty("tbs_local_version"));
                            int parseInt6 = Integer.parseInt(properties2.getProperty(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE_FOR_SWITCH));
                            if (parseInt4 != 88888888 && parseInt5 != 88888888 && parseInt4 <= parseInt5 && parseInt4 == parseInt5 && ((parseInt6 <= 0 || parseInt6 == C1429b.m2116e(context)) && Boolean.parseBoolean(properties2.getProperty("x5_disabled")))) {
                                if (!TbsDownloadConfig.getInstance(StubApp.getOrigApplicationContext(context.getApplicationContext())).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_SWITCH_BACKUPCORE_ENABLE, false)) {
                                    z = true;
                                }
                            }
                        } catch (Throwable unused2) {
                            bufferedInputStream2 = fileInputStream;
                            try {
                                TbsLog.m2155i("QbSdk", "canOpenWebPlus - isX5Disabled Exception");
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (Exception unused3) {
                                    }
                                }
                                z = true;
                                return !z;
                            } catch (Throwable th2) {
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (Exception unused4) {
                                    }
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable unused5) {
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception unused6) {
                        return !z;
                    }
                }
                TbsLog.m2155i("QbSdk", "canOpenWebPlus - sdkVersion: " + parseInt3);
                try {
                    bufferedInputStream.close();
                } catch (Exception unused7) {
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream2 = bufferedInputStream;
                try {
                    th.printStackTrace();
                    TbsLog.m2155i("QbSdk", "canOpenWebPlus - canLoadX5 Exception");
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception unused8) {
                        }
                    }
                    return false;
                } catch (Throwable th4) {
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception unused9) {
                        }
                    }
                    throw th4;
                }
            }
        }
        return false;
    }

    public static boolean canUseVideoFeatrue(Context context, int i) {
        Object m2049a = C1460i.m2049a(f1758s, "canUseVideoFeatrue", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        if (m2049a == null || !(m2049a instanceof Boolean)) {
            return false;
        }
        return ((Boolean) m2049a).booleanValue();
    }

    public static boolean checkApkExist(Context context, String str) {
        if (str != null && !"".equals(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static boolean checkContentProviderPrivilage(Context context) {
        if (context == null || context.getApplicationInfo().targetSdkVersion < 24 || Build.VERSION.SDK_INT < 24 || TbsConfig.APP_QQ.equals(context.getApplicationInfo().packageName)) {
            return true;
        }
        try {
            if (!TextUtils.isEmpty(context.getPackageManager().getProviderInfo(new ComponentName(context.getPackageName(), "androidx.core.content.FileProvider"), 0).authority)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PackageManager packageManager = context.getPackageManager();
        StringBuilder sb = new StringBuilder();
        sb.append(context.getApplicationInfo().packageName);
        sb.append(".provider");
        return packageManager.resolveContentProvider(sb.toString(), 128) != null;
    }

    public static void checkTbsValidity(Context context) {
        if (context != null && !C1465m.m2021b(context)) {
            TbsLog.m2158e("QbSdk", "sys WebView: SysWebViewForcedBy checkTbsValidity");
            TbsCoreLoadStat.getInstance().m2815a(context, 419);
            forceSysWebView();
        }
    }

    public static void clear(Context context) {
    }

    public static void clearAllDefaultBrowser(Context context) {
        context.getSharedPreferences(SHARE_PREFERENCES_NAME, 0).edit().clear().commit();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void clearAllWebViewCache(Context context, boolean z) {
        boolean z2;
        TbsLog.m2155i("QbSdk", "clearAllWebViewCache(" + context + ", " + z + ")");
        boolean z3 = false;
        try {
            if (new WebView(context).getWebViewClientExtension() != null) {
                try {
                    C1416x m2294a = C1416x.m2294a();
                    if (m2294a != null && m2294a.m2291b()) {
                        m2294a.m2289c().m2282a(context, z);
                    }
                    z3 = true;
                } catch (Throwable th) {
                    th = th;
                    z2 = true;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("clearAllWebViewCache exception 2 -- ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(th));
                    TbsLog.m2158e("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    z3 = z2;
                    if (!z3) {
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
        if (!z3) {
            TbsLog.m2155i("QbSdk", "is_in_x5_mode --> no need to clear system webview!");
            return;
        }
        try {
            android.webkit.WebView webView = new android.webkit.WebView(context);
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
            webView.clearCache(true);
            if (z) {
                android.webkit.CookieSyncManager.createInstance(context);
                android.webkit.CookieManager.getInstance().removeAllCookie();
            }
            android.webkit.WebViewDatabase.getInstance(context).clearUsernamePassword();
            android.webkit.WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
            android.webkit.WebViewDatabase.getInstance(context).clearFormData();
            android.webkit.WebStorage.getInstance().deleteAllData();
            android.webkit.WebIconDatabase.getInstance().removeAllIcons();
        } catch (Throwable th3) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("clearAllWebViewCache exception 1 -- ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Log.getStackTraceString(th3));
            TbsLog.m2158e("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
    }

    public static void clearDefaultBrowser(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PREFERENCES_NAME, 0);
        String m2315d = C1410e.m2315d(str);
        if (TextUtils.isEmpty(m2315d)) {
            m2315d = "*/*";
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove("key_tbs_picked_default_browser_" + m2315d).commit();
    }

    public static void closeFileReader(Context context) {
        C1416x m2294a = C1416x.m2294a();
        m2294a.m2293a(context);
        if (m2294a.m2291b()) {
            m2294a.m2289c().m2231p();
        }
    }

    public static String closeNetLogAndSavaToLocal() {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a != null && m2294a.m2291b()) {
            try {
                Object invokeStaticMethod = m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "closeNetLogAndSavaToLocal", new Class[0], new Object[0]);
                if (invokeStaticMethod != null && (invokeStaticMethod instanceof String)) {
                    return (String) invokeStaticMethod;
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static void configurePrivacy(Context context, TbsPrivacyAccess.ConfigurablePrivacy configurablePrivacy, String str) {
        TbsPrivacyAccess.configurePrivacy(context, configurablePrivacy, str);
    }

    public static void continueLoadSo(Context context) {
        if (!TbsConfig.APP_WX.equals(getCurrentProcessName(context)) || !WebView.mWebViewCreated) {
            return;
        }
        C1460i.m2049a(f1758s, "continueLoadSo", new Class[0], new Object[0]);
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        C1416x m2294a;
        if (context != null && !TbsDownloader.getOverSea(context) && !isMiniQBShortCutExist(context, str, str2) && (m2294a = C1416x.m2294a()) != null && m2294a.m2291b()) {
            Bitmap bitmap = null;
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            }
            DexLoader m2271b = m2294a.m2289c().m2271b();
            TbsLog.m2158e("QbSdk", "qbsdk createMiniQBShortCut");
            Object invokeStaticMethod = m2271b.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, context, str, str2, bitmap);
            TbsLog.m2158e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + invokeStaticMethod);
            if (invokeStaticMethod != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m2822d(Context context) {
        int i;
        int i2;
        int i3;
        StringBuilder sb;
        int i4;
        f1735D = true;
        SharedPreferences sharedPreferences = null;
        try {
            sharedPreferences = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
            i4 = sharedPreferences.getInt("tbs_preload_x5_recorder", -1);
            if (i4 >= 0) {
                i4++;
                if (i4 > 4) {
                    return;
                }
                i = i4;
            } else {
                i = -1;
            }
            try {
                i2 = C1381p.m2503a().m2446j(context);
            } catch (Throwable th) {
                th = th;
                i2 = -1;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("tbs_preload_x5_counter Inc exception:");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(th));
                TbsLog.m2158e("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                i3 = -1;
                int i5 = 0;
                if (i3 > 3) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            i = -1;
        }
        if (i2 <= 0) {
            return;
        }
        if (i4 <= 4) {
            try {
                sharedPreferences.edit().putInt("tbs_preload_x5_recorder", i4).commit();
            } catch (Throwable th3) {
                th = th3;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("tbs_preload_x5_counter Inc exception:");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Log.getStackTraceString(th));
                TbsLog.m2158e("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                i3 = -1;
                int i52 = 0;
                if (i3 > 3) {
                }
            }
        }
        int i6 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
        if (i6 >= 0) {
            i3 = i6 + 1;
            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i3).commit();
            int i522 = 0;
            if (i3 > 3) {
                if (i <= 0 || i > 3) {
                    i522 = -1;
                } else {
                    TbsLog.m2155i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                    C1416x.m2294a().m2293a(context);
                    TbsLog.m2155i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                }
                try {
                    int i7 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                    if (i7 > 0) {
                        sharedPreferences.edit().putInt("tbs_preload_x5_counter", i7 - 1).commit();
                    }
                } catch (Throwable th4) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("tbs_preload_x5_counter Dec exception:");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(Log.getStackTraceString(th4));
                    TbsLog.m2158e("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                }
                TbsLog.m2155i("QbSdk", "QbSdk -- preload_x5_check result:" + i522);
                return;
            }
            try {
                int i8 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (i8 == i2) {
                    FileUtil.m2188a(C1381p.m2503a().m2437r(context), false);
                    File m2529a = C1379n.m2526a(context).m2529a();
                    if (m2529a != null) {
                        FileUtil.m2188a(m2529a, false);
                    }
                    sb = new StringBuilder();
                    sb.append("QbSdk - preload_x5_check: tbs core ");
                    sb.append(i2);
                    sb.append(" is deleted!");
                } else {
                    sb = new StringBuilder();
                    sb.append("QbSdk - preload_x5_check -- reset exception core_ver:");
                    sb.append(i2);
                    sb.append("; value:");
                    sb.append(i8);
                }
                TbsLog.m2158e("QbSdk", sb.toString());
                edit.putInt("tbs_precheck_disable_version", i8);
                edit.commit();
                return;
            } catch (Throwable th5) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("tbs_preload_x5_counter disable version exception:");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(Log.getStackTraceString(th5));
                TbsLog.m2158e("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
                return;
            }
        }
        i3 = -1;
        int i5222 = 0;
        if (i3 > 3) {
        }
    }

    public static boolean deleteMiniQBShortCut(Context context, String str, String str2) {
        C1416x m2294a;
        return (context == null || TbsDownloader.getOverSea(context) || (m2294a = C1416x.m2294a()) == null || !m2294a.m2291b() || m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[]{Context.class, String.class, String.class}, context, str, str2) == null) ? false : true;
    }

    public static void disAllowThirdAppDownload() {
        f1742c = false;
    }

    public static void disableAutoCreateX5Webview() {
        f1749j = false;
    }

    @Deprecated
    public static void disableSensitiveApi() {
        TbsPrivacyAccess.disableSensitiveApi();
    }

    public static void fileInfoDetect(Context context, String str, android.webkit.ValueCallback<String> valueCallback) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            return;
        }
        try {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[]{Context.class, String.class, android.webkit.ValueCallback.class}, context, str, valueCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void forceSysWebView() {
        f1741b = true;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("SysWebViewForcedByOuter: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(new Throwable()));
        f1761v = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        TbsLog.m2158e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    }

    public static long getApkFileSize(Context context) {
        if (context != null) {
            return TbsDownloadConfig.getInstance(StubApp.getOrigApplicationContext(context.getApplicationContext())).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0L);
        }
        return 0L;
    }

    public static String getCurrentProcessName(Context context) {
        FileInputStream fileInputStream;
        byte[] bArr;
        int i;
        try {
            try {
                fileInputStream = new FileInputStream("/proc/self/cmdline");
                try {
                    bArr = new byte[256];
                    i = 0;
                    while (true) {
                        int read = fileInputStream.read();
                        if (read <= 0 || i >= 256) {
                            break;
                        }
                        bArr[i] = (byte) read;
                        i++;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (i <= 0) {
            fileInputStream.close();
            return null;
        }
        String str = new String(bArr, 0, i, "UTF-8");
        try {
            fileInputStream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return str;
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        String[] strArr = f1760u;
        if (!(strArr instanceof String[])) {
            Object m2049a = C1460i.m2049a(f1758s, "getJarFiles", new Class[]{Context.class, Context.class, String.class}, context, context2, str);
            if (!(m2049a instanceof String[])) {
                m2049a = new String[]{""};
            }
            return (String[]) m2049a;
        }
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f1760u[i]);
            strArr2[i] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return strArr2;
    }

    public static boolean getDownloadWithoutWifi() {
        return f1738G;
    }

    public static boolean getIsInitX5Environment() {
        return f1750k;
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return f1741b;
    }

    public static boolean getJarFilesAndLibraryPath(Context context) {
        String sb;
        Object obj = f1758s;
        if (obj == null) {
            sb = "getJarFilesAndLibraryPath sExtensionObj is null";
        } else {
            Bundle bundle = (Bundle) C1460i.m2049a(obj, "canLoadX5CoreAndNotLoadSo", new Class[]{Integer.TYPE}, 44115);
            if (bundle != null) {
                f1760u = bundle.getStringArray("tbs_jarfiles");
                f1743d = bundle.getString("tbs_librarypath");
                return true;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getJarFilesAndLibraryPath bundle is null and coreverison is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C1381p.m2503a().m2483a(true, context));
            sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        TbsLog.m2155i("QbSdk", sb);
        return false;
    }

    public static String getMiniQBVersion(Context context) {
        C1416x m2294a = C1416x.m2294a();
        m2294a.m2293a(context);
        if (m2294a.m2291b()) {
            return m2294a.m2289c().m2255f();
        }
        return null;
    }

    public static boolean getOnlyDownload() {
        return f1751l;
    }

    public static String getQQBuildNumber() {
        return f1733B;
    }

    public static Map<String, Object> getSettings() {
        return f1754o;
    }

    public static boolean getTBSInstalling() {
        return f1739H;
    }

    public static String getTID() {
        return f1732A;
    }

    public static File getTbsFolderDir(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (C1429b.m2121b()) {
                return context.getDir("tbs_64", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return context.getDir("tbs", 0);
    }

    public static String getTbsResourcesPath(Context context) {
        return TbsShareManager.m2724g(context);
    }

    public static int getTbsSdkVersion() {
        return 44115;
    }

    public static int getTbsVersion(Context context) {
        return TbsShareManager.isThirdPartyApp(context) ? TbsShareManager.m2733a(context, false) : C1381p.m2503a().m2446j(context);
    }

    public static int getTbsVersionForCrash(Context context) {
        if (TbsShareManager.isThirdPartyApp(context)) {
            return TbsShareManager.m2733a(context, false);
        }
        int m2444k = C1381p.m2503a().m2444k(context);
        if (m2444k == 0 && C1379n.m2526a(context).m2518c() == 3) {
            reset(context);
        }
        return m2444k;
    }

    public static int getTmpDirTbsVersion(Context context) {
        if (C1379n.m2526a(context).m2518c() == 2) {
            return C1381p.m2503a().m2459e(context, 0);
        }
        if (C1379n.m2526a(context).m2519b("copy_status") != 1) {
            return 0;
        }
        return C1381p.m2503a().m2459e(context, 1);
    }

    public static void initBuglyAsync(boolean z) {
        f1748i = z;
    }

    public static void initForinitAndNotLoadSo(Context context) {
        File m2437r;
        if (f1757r != null || (m2437r = C1381p.m2503a().m2437r(context)) == null) {
            return;
        }
        File file = new File(m2437r, "tbs_sdk_extension_dex.jar");
        if (!file.exists()) {
            return;
        }
        String absolutePath = m2437r.getAbsolutePath();
        C1416x.m2294a().m2290b(context);
        C1465m.m2023a(context);
        f1757r = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, absolutePath, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
    }

    public static void initTbsSettings(Map<String, Object> map) {
        Map<String, Object> map2 = f1754o;
        if (map2 == null) {
            f1754o = map;
            return;
        }
        try {
            map2.putAll(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initX5Environment(final Context context, final PreInitCallback preInitCallback) {
        TbsLog.initIfNeed(context);
        if (context == null) {
            TbsLog.m2158e("QbSdk", "initX5Environment,context=null");
            return;
        }
        m2826b(context);
        f1737F = new TbsListener() { // from class: com.tencent.smtt.sdk.QbSdk.5
            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadFinish(int i) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadProgress(int i) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onInstallFinish(int i) {
                QbSdk.preInit(context, preInitCallback);
            }
        };
        if (TbsShareManager.isThirdPartyApp(context)) {
            C1381p.m2503a().m2473b(context, C1363g.f2113a == 0);
        }
        TbsDownloader.needDownload(context, false, false, true, new TbsDownloader.TbsDownloaderCallback() { // from class: com.tencent.smtt.sdk.QbSdk.6
            @Override // com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback
            public void onNeedDownloadFinish(boolean z, int i) {
                if (TbsShareManager.findCoreForThirdPartyApp(context) == 0 && !TbsShareManager.getCoreDisabled()) {
                    TbsShareManager.forceToLoadX5ForThirdApp(context, false);
                }
                if (QbSdk.f1748i && TbsShareManager.isThirdPartyApp(context)) {
                    TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(context);
                }
                QbSdk.preInit(context, preInitCallback);
            }
        });
        f1750k = true;
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        C1363g m2597a = C1363g.m2597a(true);
        m2597a.m2599a(context, false, false);
        if (m2597a.m2596b()) {
            return m2597a.m2601a().m2303a(context, str, str2, bundle);
        }
        return false;
    }

    public static void installLocalTbsCore(Context context, int i, String str) {
        C1381p.m2503a().m2491a(context, str, i);
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        String str3;
        if (webView == null) {
            return false;
        }
        if (str.startsWith("mttbrowser://miniqb/ch=icon?")) {
            Context context = webView.getContext();
            int indexOf = str.indexOf("url=");
            str = indexOf > 0 ? str.substring(indexOf + 4) : null;
            HashMap hashMap = new HashMap();
            try {
                str3 = context.getApplicationInfo().packageName;
            } catch (Exception e) {
                e.printStackTrace();
                str3 = "unknown";
            }
            hashMap.put("ChannelID", str3);
            hashMap.put("PosID", "14004");
            if (MttLoader.loadUrl(context, "miniqb://home".equals(str) ? "qb://navicard/addCard?cardId=168&cardName=168" : str, hashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
                C1416x m2294a = C1416x.m2294a();
                if (m2294a != null && m2294a.m2291b() && m2294a.m2289c().m2283a(context, str, null, str2, null) == 0) {
                    return true;
                }
            }
            return false;
        }
        webView.loadUrl(str);
        return false;
    }

    @Deprecated
    public static boolean isEnableCanGetSubscriberId() {
        return TbsPrivacyAccess.Imsi.isEnabled();
    }

    @Deprecated
    public static boolean isEnableGetAndroidID() {
        return TbsPrivacyAccess.AndroidId.isEnabled();
    }

    @Deprecated
    public static boolean isEnableGetDeviceID() {
        return TbsPrivacyAccess.DeviceId.isEnabled();
    }

    @Deprecated
    public static boolean isEnableSensitiveApi() {
        return TbsPrivacyAccess.isEnableSensitiveApi();
    }

    public static boolean isInDefaultBrowser(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PREFERENCES_NAME, 0);
        String m2315d = C1410e.m2315d(str);
        if (TextUtils.isEmpty(m2315d)) {
            m2315d = "*/*";
        }
        return sharedPreferences.contains("key_tbs_picked_default_browser_" + m2315d);
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        C1416x m2294a;
        Object invokeStaticMethod;
        if (context == null || TbsDownloader.getOverSea(context) || (m2294a = C1416x.m2294a()) == null || !m2294a.m2291b() || (invokeStaticMethod = m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, context, str)) == null) {
            return false;
        }
        Boolean bool = false;
        if (invokeStaticMethod instanceof Boolean) {
            bool = (Boolean) invokeStaticMethod;
        }
        return bool.booleanValue();
    }

    public static boolean isNeedInitX5FirstTime() {
        return f1763x;
    }

    public static boolean isSuportOpenFile(String str, int i) {
        List asList;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = {"rar", "zip", "tar", "bz2", "gz", "7z", "doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub", "chm", "html", "htm", DocumentReader.RESERVED, "mht", "url", "ini", "log", "bat", "php", "js", "lrc", "jpg", "jpeg", "png", "gif", "bmp", "tiff", "webp", "mp3", "m4a", "aac", "amr", "wav", "ogg", "mid", "ra", "wma", "mpga", "ape", "flac", "RTSP", "RTP", "SDP", "RTMP", "mp4", "flv", "avi", "3gp", "3gpp", "webm", "ts", "ogv", "m3u8", "asf", "wmv", "rmvb", "rm", "f4v", "dat", "mov", "mpg", "mkv", "mpeg", "mpeg1", "mpeg2", "xvid", "dvd", "vcd", "vob", "divx"};
        String[] strArr2 = {"doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub"};
        if (i == 1) {
            asList = Arrays.asList(strArr2);
        } else if (i != 2) {
            return false;
        } else {
            asList = Arrays.asList(strArr);
        }
        return asList.contains(str.toLowerCase());
    }

    public static boolean isTbsCoreInited() {
        C1363g m2597a = C1363g.m2597a(false);
        return m2597a != null && m2597a.m2589g();
    }

    public static boolean isX5DisabledSync(Context context) {
        if (C1379n.m2526a(context).m2518c() == 2) {
            return false;
        }
        if (!m2824c(context)) {
            return true;
        }
        int m2446j = C1381p.m2503a().m2446j(context);
        Object obj = f1758s;
        Class cls = Integer.TYPE;
        Object m2049a = C1460i.m2049a(obj, "isX5DisabledSync", new Class[]{cls, cls}, Integer.valueOf(m2446j), 44115);
        if (m2049a == null) {
            return true;
        }
        return ((Boolean) m2049a).booleanValue();
    }

    public static void loadTBSSDKExtension(Context context, String str) {
        Constructor<?> constructor;
        boolean z;
        Object newInstance;
        if (f1758s != null) {
            return;
        }
        synchronized (QbSdk.class) {
            if (f1758s != null) {
                return;
            }
            if (f1757r == null) {
                TbsLog.m2155i("QbSdk", "QbSdk loadTBSSDKExtension sExtensionClass is null");
            }
            try {
                constructor = f1757r.getConstructor(Context.class, Context.class, String.class, String.class, String.class);
                z = true;
            } catch (Throwable unused) {
                constructor = null;
                z = false;
            }
            if (TbsShareManager.isThirdPartyApp(context)) {
                Context m2726e = TbsShareManager.m2726e(context);
                if (m2726e == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                    TbsCoreLoadStat.getInstance().m2815a(context, TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL);
                    TbsLog.m2147w("QbSdk", "loadTBSSDKExtension", "[LoadWarn] host is context is null.");
                    return;
                }
                if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                    context = StubApp.getOrigApplicationContext(context.getApplicationContext());
                }
                newInstance = !z ? m2726e == null ? f1757r.getConstructor(Context.class, Context.class, String.class).newInstance(context, m2726e, TbsShareManager.getHostCorePathAppDefined(), str, null) : f1757r.getConstructor(Context.class, Context.class).newInstance(context, m2726e) : constructor.newInstance(context, m2726e, TbsShareManager.getHostCorePathAppDefined(), str, null);
            } else if (!z) {
                Constructor<?> constructor2 = f1757r.getConstructor(Context.class, Context.class);
                if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                    context = StubApp.getOrigApplicationContext(context.getApplicationContext());
                }
                newInstance = constructor2.newInstance(context, context);
            } else {
                String str2 = (!TbsConfig.APP_WX.equals(getCurrentProcessName(context)) || WebView.mWebViewCreated) ? null : "notLoadSo";
                if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                    context = StubApp.getOrigApplicationContext(context.getApplicationContext());
                }
                newInstance = constructor.newInstance(context, context, null, str, str2);
            }
            f1758s = newInstance;
        }
    }

    public static void openBrowserList(Context context, String str, Bundle bundle, final ValueCallback<String> valueCallback) {
        String str2;
        if (context == null) {
            return;
        }
        String string = bundle != null ? bundle.getString("ChannelId") : "";
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse(str));
        String m2315d = C1410e.m2315d(str);
        isDefaultDialog = false;
        DialogC1406d dialogC1406d = new DialogC1406d(context, "选择其它应用打开", intent, bundle, valueCallback, m2315d, string);
        String m2335a = dialogC1406d.m2335a();
        if (m2335a != null && !TextUtils.isEmpty(m2335a)) {
            if (TbsConfig.APP_QB.equals(m2335a)) {
                intent.putExtra("ChannelID", StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName());
                intent.putExtra("PosID", "4");
            }
            intent.setPackage(m2335a);
            intent.putExtra("big_brother_source_key", string);
            context.startActivity(intent);
            if (valueCallback == null) {
                return;
            }
            str2 = "default browser:" + m2335a;
        } else if (!isDefaultDialog) {
            dialogC1406d.show();
            dialogC1406d.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.smtt.sdk.QbSdk.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    ValueCallback valueCallback2 = ValueCallback.this;
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue("TbsReaderDialogClosed");
                    }
                }
            });
            return;
        } else {
            new AlertDialog.Builder(context).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.tencent.smtt.sdk.QbSdk.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).show();
            if (valueCallback == null) {
                return;
            }
            str2 = "can not open";
        }
        valueCallback.onReceiveValue(str2);
    }

    public static void openBrowserList(Context context, String str, ValueCallback<String> valueCallback) {
        openBrowserList(context, str, null, valueCallback);
    }

    public static int openFileReader(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        TbsCoreLoadStat.getInstance().m2815a(context, 505);
        if (!checkContentProviderPrivilage(context)) {
            TbsLog.m2158e("QbSdk", "Got an unexpected result when check content provider privilege above api 24");
            return -5;
        } else if (TextUtils.isEmpty(str)) {
            if (valueCallback != null) {
                valueCallback.onReceiveValue("filepath error");
            }
            TbsCoreLoadStat.getInstance().m2815a(context, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_FILEPATHISNULL);
            TbsLog.m2158e("QbSdk", "open openFileReader filepath error ret -1");
            return -1;
        } else {
            String lowerCase = str.substring(str.lastIndexOf(".") + 1).toLowerCase();
            String str2 = hashMap.get("fileext");
            String str3 = !TextUtils.isEmpty(str2) ? str2 : lowerCase;
            if (str3 == null) {
                TbsLog.m2158e("QbSdk", "open openFileReader null file type");
            }
            if ("apk".equalsIgnoreCase(str3)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(1);
                }
                Uri m2210a = FileProvider.m2210a(context, str);
                if (m2210a == null) {
                    valueCallback.onReceiveValue("uri failed");
                    return -6;
                }
                intent.setDataAndType(m2210a, "application/vnd.android.package-archive");
                context.startActivity(intent);
                TbsCoreLoadStat.getInstance().m2815a(context, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_APKFILE);
                TbsLog.m2158e("QbSdk", "open openFileReader ret = 4");
                return 4;
            }
            if (MttLoader.isBrowserInstalled(context)) {
                if (!isSuportOpenFile(str3, 2)) {
                    TbsLog.m2158e("QbSdk", "Open file reader in qq browser, isQBSupport: false  ret = 3");
                    openFileReaderListWithQBDownload(context, str, valueCallback);
                    TbsCoreLoadStat.getInstance().m2815a(context, 507);
                    return 3;
                } else if (startQBForDoc(context, str, 4, 0, str3, m2831a(context, hashMap))) {
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue("open QB");
                    }
                    TbsCoreLoadStat.getInstance().m2815a(context, 507);
                    TbsLog.m2158e("QbSdk", "open openFileReader open QB ret = 1");
                    return 1;
                }
            }
            hashMap.put("local", "true");
            TbsLog.setWriteLogJIT(true);
            int startMiniQBToLoadUrl = startMiniQBToLoadUrl(context, str, hashMap, valueCallback);
            if (startMiniQBToLoadUrl == 0) {
                TbsCoreLoadStat.getInstance().m2815a(context, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBSUCCESS);
                return 2;
            }
            openFileReaderListWithQBDownload(context, str, valueCallback);
            TbsLogReport tbsLogReport = TbsLogReport.getInstance(context);
            tbsLogReport.setLoadErrorCode(511, "" + startMiniQBToLoadUrl);
            return 3;
        }
    }

    public static void openFileReaderListWithQBDownload(Context context, String str, Bundle bundle, final ValueCallback<String> valueCallback) {
        String str2;
        if (context == null || context.getApplicationInfo().packageName.equals("com.tencent.qim") || context.getApplicationInfo().packageName.equals("com.tencent.androidqqmail")) {
            return;
        }
        String string = bundle != null ? bundle.getString("ChannelId") : "";
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        String m2315d = C1410e.m2315d(str);
        if (context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        Uri m2210a = FileProvider.m2210a(context, str);
        if (m2210a == null) {
            TbsLog.m2155i("QbSdk", "openFileReaderListWithQBDownload,uri failed");
            valueCallback.onReceiveValue("uri failed");
            return;
        }
        TbsLog.m2155i("QbSdk", "openFileReaderListWithQBDownload,fileUri:" + str + ",mimeType:" + m2315d);
        intent.setDataAndType(m2210a, m2315d);
        isDefaultDialog = false;
        DialogC1406d dialogC1406d = new DialogC1406d(context, "选择其它应用打开", intent, bundle, valueCallback, m2315d, string);
        String m2335a = dialogC1406d.m2335a();
        TbsLog.m2155i("QbSdk", "openFileReaderListWithQBDownload,defaultBrowser:" + m2335a);
        if (m2335a != null && !TextUtils.isEmpty(m2335a) && m2335a.startsWith("extraMenuEvent:")) {
            TbsLog.m2155i("QbSdk", "openFileReaderListWithQBDownload, is default extra menu action");
            valueCallback.onReceiveValue(m2335a);
        } else if (m2335a != null && !TextUtils.isEmpty(m2335a) && checkApkExist(context, m2335a)) {
            TbsLog.m2155i("QbSdk", "openFileReaderListWithQBDownload, is default normal menu action");
            if (TbsConfig.APP_QB.equals(m2335a)) {
                intent.putExtra("ChannelID", StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName());
                intent.putExtra("PosID", "4");
            }
            if (!TextUtils.isEmpty(string)) {
                intent.putExtra("big_brother_source_key", string);
            }
            intent.setPackage(m2335a);
            context.startActivity(intent);
            if (valueCallback == null) {
                return;
            }
            valueCallback.onReceiveValue("default browser:" + m2335a);
        } else if ("com.tencent.rtxlite".equalsIgnoreCase(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName()) && isDefaultDialog) {
            new AlertDialog.Builder(context).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.tencent.smtt.sdk.QbSdk.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).show();
        } else {
            if (isDefaultDialog) {
                TbsLog.m2155i("QbSdk", "isDefaultDialog=true");
                if (valueCallback != null) {
                    TbsLog.m2155i("QbSdk", "isDefaultDialog=true, can not open");
                    str2 = "can not open";
                    valueCallback.onReceiveValue(str2);
                }
            } else {
                try {
                    TbsLog.m2155i("QbSdk", "isDefaultDialog=false,try to open dialog");
                    dialogC1406d.show();
                    dialogC1406d.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.smtt.sdk.QbSdk.9
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            ValueCallback valueCallback2 = ValueCallback.this;
                            if (valueCallback2 != null) {
                                valueCallback2.onReceiveValue("TbsReaderDialogClosed");
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    TbsLog.m2155i("QbSdk", "isDefaultDialog=false,try to open dialog, but failed");
                    str2 = "TbsReaderDialogClosed";
                }
            }
            TbsLog.m2155i("QbSdk", "unexpected return, dialogBuilder not show!");
        }
    }

    public static void openFileReaderListWithQBDownload(Context context, String str, ValueCallback<String> valueCallback) {
        openFileReaderListWithQBDownload(context, str, null, valueCallback);
    }

    public static int openFileWithQB(Context context, String str, String str2) {
        TbsLog.m2155i("QbSdk", "open openFileReader startMiniQBToLoadUrl filepath = " + str);
        if (!checkContentProviderPrivilage(context)) {
            return -1;
        }
        if (str == null) {
            TbsLog.m2155i("QbSdk", "open openFileReader filepath error");
            return -5;
        }
        String lowerCase = str.substring(str.lastIndexOf(".") + 1).toLowerCase();
        if (!MttLoader.isBrowserInstalled(context)) {
            TbsLog.m2155i("QbSdk", "openFileReader QQ browser not installed");
            return -4;
        } else if (!isSuportOpenFile(lowerCase, 2)) {
            TbsLog.m2155i("QbSdk", "openFileReader open in QB isQBSupport: false");
            return -2;
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("ChannelID", StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().processName);
            hashMap.put("PosID", Integer.toString(4));
            if (MttLoader.openDocWithQb(context, str, 0, lowerCase, str2, hashMap, null)) {
                return 0;
            }
            TbsLog.m2155i("QbSdk", "openFileReader startQBForDoc return false");
            return -3;
        }
    }

    public static void openNetLog(String str) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            return;
        }
        try {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "openNetLog", new Class[]{String.class}, str);
        } catch (Exception unused) {
        }
    }

    public static void pauseDownload() {
        TbsDownloader.pauseDownload();
    }

    public static synchronized void preInit(Context context) {
        synchronized (QbSdk.class) {
            preInit(context, null);
        }
    }

    public static synchronized void preInit(final Context context, final PreInitCallback preInitCallback) {
        synchronized (QbSdk.class) {
            TbsLog.initIfNeed(context);
            TbsLog.m2154i("QbSdk", "preInit", "processName: " + getCurrentProcessName(context));
            TbsLog.m2154i("QbSdk", "preInit", "stack trace: " + Log.getStackTraceString(new Throwable("PreInit Detect:")));
            f1752m = f1740a;
            if (!f1759t) {
                TbsLog.m2154i("QbSdk", "preInit", "#1# Start new thread to preInit");
                final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.smtt.sdk.QbSdk.3
                    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
                        if (r4 != null) goto L17;
                     */
                    @Override // android.os.Handler
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void handleMessage(Message message) {
                        PreInitCallback preInitCallback2;
                        C1417y m2289c;
                        PreInitCallback preInitCallback3;
                        int i = message.what;
                        boolean z = true;
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3 || (preInitCallback3 = preInitCallback) == null) {
                                    return;
                                }
                                preInitCallback3.onCoreInitFinished();
                                return;
                            }
                            preInitCallback2 = preInitCallback;
                            if (preInitCallback2 != null) {
                                z = false;
                                preInitCallback2.onViewInitFinished(z);
                            }
                            TbsLog.writeLogToDisk();
                            return;
                        }
                        boolean unused = QbSdk.f1734C = TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.DISABLE_UNPREINIT);
                        if (QbSdk.f1749j && (m2289c = C1416x.m2294a().m2289c()) != null) {
                            m2289c.m2285a(context);
                        }
                        preInitCallback2 = preInitCallback;
                    }
                };
                Thread thread = new Thread() { // from class: com.tencent.smtt.sdk.QbSdk.4
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        int m2483a = C1381p.m2503a().m2483a(true, context);
                        TbsDownloader.setAppContext(context);
                        TbsLog.m2155i("QbSdk", "QbSdk preinit ver is " + m2483a);
                        C1381p.m2503a().m2473b(context, C1363g.f2113a == 0);
                        TbsLog.m2154i("QbSdk", "preInit", "#2-1# prepare initAndLoadSo");
                        C1363g.m2597a(true).m2599a(context, false, false);
                        TbsLog.m2154i("QbSdk", "preInit", "#2-2# SDKEngine init finish");
                        C1416x m2294a = C1416x.m2294a();
                        m2294a.m2293a(context);
                        TbsLog.m2154i("QbSdk", "preInit", "#2-3# X5CoreEngine init finish");
                        boolean m2291b = m2294a.m2291b();
                        handler.sendEmptyMessage(3);
                        if (!m2291b) {
                            handler.sendEmptyMessage(2);
                        } else {
                            handler.sendEmptyMessage(1);
                        }
                    }
                };
                thread.setName("tbs_preinit");
                thread.setPriority(10);
                thread.start();
                f1759t = true;
            }
        }
    }

    public static void reset(Context context) {
        reset(context, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0059 A[Catch: all -> 0x0079, TryCatch #0 {all -> 0x0079, blocks: (B:3:0x0008, B:5:0x000e, B:7:0x0014, B:11:0x002e, B:13:0x0059, B:15:0x005e), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005e A[Catch: all -> 0x0079, TRY_LEAVE, TryCatch #0 {all -> 0x0079, blocks: (B:3:0x0008, B:5:0x000e, B:7:0x0014, B:11:0x002e, B:13:0x0059, B:15:0x005e), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void reset(Context context, boolean z) {
        boolean z2;
        File file;
        TbsLog.m2156e("QbSdk", "QbSdk reset!", true);
        try {
            TbsDownloader.stopDownload();
            if (z && !TbsShareManager.isThirdPartyApp(context)) {
                int m2448i = C1381p.m2503a().m2448i(context);
                int m2446j = C1381p.m2503a().m2446j(context);
                if (m2448i > 43300 && m2448i != m2446j) {
                    z2 = true;
                    TbsDownloader.m2791c(context);
                    FileUtil.m2187a(getTbsFolderDir(context), false, "core_share_decouple");
                    TbsLog.m2153i("QbSdk", "delete downloaded apk success", true);
                    C1381p.f2182a.set(0);
                    file = new File(context.getFilesDir(), TbsExtensionFunctionManager.BUGLY_SWITCH_FILE_NAME);
                    if (file.exists()) {
                        file.delete();
                    }
                    if (z2) {
                        return;
                    }
                    FileUtil.m2174b(C1381p.m2503a().m2438q(context), C1381p.m2503a().m2455f(context, 0));
                    C1381p.m2503a().m2472c(context);
                    return;
                }
            }
            z2 = false;
            TbsDownloader.m2791c(context);
            FileUtil.m2187a(getTbsFolderDir(context), false, "core_share_decouple");
            TbsLog.m2153i("QbSdk", "delete downloaded apk success", true);
            C1381p.f2182a.set(0);
            file = new File(context.getFilesDir(), TbsExtensionFunctionManager.BUGLY_SWITCH_FILE_NAME);
            if (file.exists()) {
            }
            if (z2) {
            }
        } catch (Throwable th) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("QbSdk reset exception:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(th));
            TbsLog.m2158e("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    public static void resetDecoupleCore(Context context) {
        TbsLog.m2156e("QbSdk", "QbSdk resetDecoupleCore!", true);
        try {
            if (!C1472q.m1982b(context)) {
                FileUtil.m2175b(C1381p.m2503a().m2438q(context));
                return;
            }
            Context packageContext = TbsShareManager.getPackageContext(context, TbsConfig.APP_WX, false);
            File file = packageContext == null ? new File(FileUtil.m2195a(context, TbsConfig.APP_WX, 4, true)) : new File(FileUtil.m2198a(packageContext, 4));
            TbsLog.m2156e("QbSdk", "QbSdk resetDecoupleCore! mFilePathStable is " + file.getAbsolutePath(), true);
            File[] listFiles = file.listFiles();
            Pattern compile = Pattern.compile(C1428a.m2134a(false));
            for (File file2 : listFiles) {
                if (compile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                    TbsLog.m2153i(TbsDownloader.LOGTAG, "QbSdk resetDecoupleCore file is " + file2.getAbsolutePath(), true);
                    file2.delete();
                }
            }
            File file3 = new File(file, TbsDownloader.getBackupFileName(false));
            TbsLog.m2153i(TbsDownloader.LOGTAG, "QbSdk resetDecoupleCore file is " + file3.getAbsolutePath(), true);
            file3.delete();
        } catch (Throwable th) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("QbSdk resetDecoupleCore exception:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(th));
            TbsLog.m2158e("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    public static void resumeDownload() {
        TbsDownloader.resumeDownload();
    }

    public static void setAppList(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        TbsPrivacyAccess.configureAllPrivacy(context, TextUtils.join(",", list));
    }

    public static void setCurrentID(String str) {
        if (str != null && str.startsWith(TID_QQNumber_Prefix)) {
            String substring = str.substring(3);
            f1732A = "0000000000000000".substring(substring.length()) + substring;
        }
    }

    public static void setDisableUnpreinitBySwitch(boolean z) {
        f1734C = z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("setDisableUnpreinitBySwitch -- mDisableUnpreinitBySwitch is ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(f1734C);
        TbsLog.m2155i("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public static void setDisableUseHostBackupCoreBySwitch(boolean z) {
        mDisableUseHostBackupCore = z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(mDisableUseHostBackupCore);
        TbsLog.m2155i("QbSdk", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public static void setDownloadWithoutWifi(boolean z) {
        f1738G = z;
    }

    public static void setEnableForThirdParty(Context context, Bundle bundle) {
        C1472q.m1988a(context, bundle);
    }

    public static void setNeedInitX5FirstTime(boolean z) {
        f1763x = z;
    }

    public static void setNetLogEncryptionKey(String str) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            return;
        }
        try {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "setNetLogEncryptionKey", new Class[]{String.class}, str);
        } catch (Exception unused) {
        }
    }

    public static void setNewDnsHostList(String str) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            return;
        }
        try {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setNewDnsHostList", new Class[]{String.class}, str);
        } catch (Exception unused) {
        }
    }

    public static void setOnlyDownload(boolean z) {
        f1751l = z;
    }

    public static void setQQBuildNumber(String str) {
        f1733B = str;
    }

    public static void setTBSInstallingStatus(boolean z) {
        f1739H = z;
    }

    public static void setTbsListener(TbsListener tbsListener) {
        f1736E = tbsListener;
    }

    public static void setTbsLogClient(TbsLogClient tbsLogClient) {
        TbsLog.setTbsLogClient(tbsLogClient);
    }

    public static void setUploadCode(Context context, int i) {
        TbsDownloadUpload tbsDownloadUpload;
        Map<String, Object> map;
        Integer valueOf;
        String str;
        if (i >= 130 && i <= 139) {
            tbsDownloadUpload = TbsDownloadUpload.getInstance(context);
            map = tbsDownloadUpload.f1850a;
            valueOf = Integer.valueOf(i);
            str = TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE;
        } else if (i < 150 || i > 159) {
            return;
        } else {
            tbsDownloadUpload = TbsDownloadUpload.getInstance(context);
            map = tbsDownloadUpload.f1850a;
            valueOf = Integer.valueOf(i);
            str = TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE;
        }
        map.put(str, valueOf);
        tbsDownloadUpload.commit();
    }

    public static void setUserID(Context context, Bundle bundle) {
        TbsPrivacyAccess.configureAllPrivacy(context, bundle);
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, android.webkit.ValueCallback<String> valueCallback) {
        TbsCoreLoadStat.getInstance().m2815a(context, 501);
        if (context == null) {
            return -100;
        }
        C1416x m2294a = C1416x.m2294a();
        m2294a.m2293a(context);
        if (!m2294a.m2291b()) {
            TbsCoreLoadStat.getInstance().m2815a(context, 502);
            return -102;
        } else if (context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
            return -101;
        } else {
            int m2283a = m2294a.m2289c().m2283a(context, str, hashMap, null, valueCallback);
            if (m2283a == 0) {
                TbsCoreLoadStat.getInstance().m2815a(context, 503);
            } else {
                TbsLogReport tbsLogReport = TbsLogReport.getInstance(context);
                tbsLogReport.setLoadErrorCode(504, "" + m2283a);
            }
            return m2283a;
        }
    }

    public static boolean startQBForDoc(Context context, String str, int i, int i2, String str2, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("ChannelID", StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().processName);
        hashMap.put("PosID", Integer.toString(i));
        return MttLoader.openDocWithQb(context, str, i2, str2, hashMap, bundle);
    }

    public static boolean startQBForVideo(Context context, String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("ChannelID", context.getApplicationInfo().processName);
        hashMap.put("PosID", Integer.toString(i));
        return MttLoader.openVideoWithQb(context, str, hashMap);
    }

    public static boolean startQBToLoadurl(Context context, String str, int i, WebView webView) {
        C1416x m2294a;
        Object invokeStaticMethod;
        HashMap hashMap = new HashMap();
        hashMap.put("ChannelID", context.getApplicationInfo().processName);
        hashMap.put("PosID", Integer.toString(i));
        if (webView == null) {
            try {
                String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                if ((str2 == TbsConfig.APP_WX || str2 == TbsConfig.APP_QQ) && (m2294a = C1416x.m2294a()) != null && m2294a.m2291b() && (invokeStaticMethod = m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0])) != null) {
                    webView = (WebView) ((IX5WebViewBase) invokeStaticMethod).getView().getParent();
                }
            } catch (Exception unused) {
            }
        }
        return MttLoader.loadUrl(context, str, hashMap, "QbSdk.startQBToLoadurl", webView) == 0;
    }

    public static boolean startQBWithBrowserlist(Context context, String str, int i) {
        boolean startQBToLoadurl = startQBToLoadurl(context, str, i, null);
        if (!startQBToLoadurl) {
            openBrowserList(context, str, null);
        }
        return startQBToLoadurl;
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        if (context == null) {
            return false;
        }
        C1416x m2294a = C1416x.m2294a();
        m2294a.m2293a(context);
        if (hashMap != null && "5".equals(hashMap.get("PosID")) && m2294a.m2291b()) {
            Bundle bundle = (Bundle) m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
        }
        if (MttLoader.loadUrl(context, str, hashMap, "QbSdk.startMiniQBToLoadUrl", null) == 0) {
            return true;
        }
        return m2294a.m2291b() && (!context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") || getTbsVersion(context) >= 25487) && m2294a.m2289c().m2283a(context, str, hashMap, null, valueCallback) == 0;
    }

    public static void unForceSysWebView() {
        f1741b = false;
        TbsLog.m2158e("QbSdk", "sys WebView: unForceSysWebView called");
    }

    public static synchronized boolean unPreInit(Context context) {
        synchronized (QbSdk.class) {
        }
        return true;
    }

    public static void uploadNetLog(String str) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            return;
        }
        try {
            m2294a.m2289c().m2271b().invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "uploadNetLog", new Class[]{String.class}, str);
        } catch (Exception unused) {
        }
    }

    public static boolean useSoftWare() {
        Object obj = f1758s;
        if (obj == null) {
            return false;
        }
        Object m2049a = C1460i.m2049a(obj, "useSoftWare", new Class[0], new Object[0]);
        if (m2049a == null) {
            m2049a = C1460i.m2049a(f1758s, "useSoftWare", new Class[]{Integer.TYPE}, Integer.valueOf(C1344a.m2662a()));
        }
        if (m2049a != null) {
            return ((Boolean) m2049a).booleanValue();
        }
        return false;
    }
}

package com.tencent.bugly.beta;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.bugly.AbstractC1081a;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C1089a;
import com.tencent.bugly.beta.global.C1093e;
import com.tencent.bugly.beta.global.C1094f;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.RunnableC1092d;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.p041ui.C1115l;
import com.tencent.bugly.beta.p041ui.UILifecycleListener;
import com.tencent.bugly.beta.tinker.TinkerApplicationLike;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.ActiveListener;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.C1118c;
import com.tencent.bugly.beta.upgrade.UpgradeListener;
import com.tencent.bugly.beta.upgrade.UpgradeStateListener;
import com.tencent.bugly.beta.utils.C1125e;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.proguard.C1177B;
import com.tencent.bugly.proguard.C1183H;
import com.tencent.bugly.proguard.C1198W;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import com.tencent.bugly.proguard.C1234p;
import com.tencent.bugly.proguard.C1238r;
import com.tencent.bugly.proguard.C1242t;
import com.tencent.bugly.proguard.C1246v;
import com.tencent.bugly.proguard.C1248x;
import com.tencent.bugly.proguard.C1249y;
import com.tencent.bugly.proguard.C1250z;
import com.umeng.analytics.pro.C1553ao;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes3.dex */
public class Beta extends AbstractC1081a {
    public static final String TAG_CANCEL_BUTTON = "beta_cancel_button";
    public static final String TAG_CONFIRM_BUTTON = "beta_confirm_button";
    public static final String TAG_IMG_BANNER = "beta_upgrade_banner";
    public static final String TAG_TIP_MESSAGE = "beta_tip_message";
    public static final String TAG_TITLE = "beta_title";
    public static final String TAG_UPGRADE_FEATURE = "beta_upgrade_feature";
    public static final String TAG_UPGRADE_INFO = "beta_upgrade_info";
    public static ActiveListener activeListener = null;
    public static boolean autoCheckAppUpgrade = false;
    public static boolean autoCheckHotfix = false;
    public static boolean autoCheckUpgrade = true;
    public static boolean autoInit = true;
    public static BetaPatchListener betaPatchListener = null;
    public static int defaultBannerId = 0;
    public static DownloadListener downloadListener = null;
    public static long initDelay = 3000;
    public static String initProcessName = null;
    public static int largeIconId = 0;
    public static boolean showInterruptedStrategy = true;
    public static int smallIconId = 0;
    public static File storageDir = null;
    public static String strNetworkTipsCancelBtn = "取消";
    public static String strNetworkTipsConfirmBtn = "继续下载";
    public static String strNetworkTipsMessage = "你已切换到移动网络，是否继续当前下载？";
    public static String strNetworkTipsTitle = "网络提示";
    public static String strNotificationClickToContinue = "继续下载";
    public static String strNotificationClickToInstall = "点击安装";
    public static String strNotificationClickToRetry = "点击重试";
    public static String strNotificationClickToView = "点击查看";
    public static String strNotificationDownloadError = "下载失败";
    public static String strNotificationDownloadSucc = "下载完成";
    public static String strNotificationDownloading = "正在下载";
    public static String strNotificationHaveNewVersion = "有新版本";
    public static String strToastCheckUpgradeError = "检查新版本失败，请稍后重试";
    public static String strToastCheckingUpgrade = "正在检查，请稍候...";
    public static String strToastYourAreTheLatestVersion = "你已经是最新版了";
    public static String strUpgradeDialogCancelBtn = "下次再说";
    public static String strUpgradeDialogContinueBtn = "继续";
    public static String strUpgradeDialogFeatureLabel = "更新说明";
    public static String strUpgradeDialogFileSizeLabel = "包大小";
    public static String strUpgradeDialogInstallBtn = "安装";
    public static String strUpgradeDialogRetryBtn = "重试";
    public static String strUpgradeDialogUpdateTimeLabel = "更新时间";
    public static String strUpgradeDialogUpgradeBtn = "立即更新";
    public static String strUpgradeDialogVersionLabel = "版本";
    public static int tipsDialogLayoutId;
    public static long upgradeCheckPeriod;
    public static int upgradeDialogLayoutId;
    public static UILifecycleListener<UpgradeInfo> upgradeDialogLifecycleListener;
    public static UpgradeListener upgradeListener;
    public static UpgradeStateListener upgradeStateListener;
    public static List<Class<? extends Activity>> canShowUpgradeActs = Collections.synchronizedList(new ArrayList());
    public static List<Class<? extends Activity>> canNotShowUpgradeActs = Collections.synchronizedList(new ArrayList());
    public static boolean enableHotfix = false;
    public static boolean enableNotification = true;
    public static boolean autoDownloadOnWifi = false;
    public static boolean canShowApkInfo = true;
    public static boolean canAutoDownloadPatch = true;
    public static boolean canAutoPatch = true;
    public static String appVersionName = null;
    public static int appVersionCode = Integer.MIN_VALUE;
    public static String appChannel = null;
    public static boolean canNotifyUserRestart = false;
    public static List<String> soBlackList = Collections.synchronizedList(new ArrayList());
    public static boolean dialogFullScreen = false;
    public static boolean autoInstallApk = true;
    public static boolean autoDownloadOn4g = false;
    public static boolean setPatchRestartOnScreenOff = true;
    public static boolean enableActiveH5Alert = true;
    public static Beta instance = new Beta();

    /* renamed from: a */
    public static DownloadTask f706a = null;

    /* renamed from: a */
    public static void m3630a(boolean z, boolean z2, int i) {
        try {
            if (z) {
                C1118c.f870a.m3571a(z, z2, i);
                if (upgradeStateListener != null) {
                    C1125e.m3490a(new RunnableC1092d(18, upgradeStateListener, 2, Boolean.valueOf(z)));
                } else {
                    C1125e.m3490a(new RunnableC1092d(5, strToastCheckingUpgrade));
                }
            } else if (i == 0 || i == 1) {
                BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) C1089a.m3615a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
                if (betaGrayStrategy != null && betaGrayStrategy.f858a != null && System.currentTimeMillis() - betaGrayStrategy.f862e <= C1093e.f737b.f768d) {
                    C1118c.f870a.m3570a(z, z2, 0, null, "");
                }
                C1118c.f870a.m3571a(z, z2, i);
            } else if (i != 3) {
            } else {
                C1238r.f1611a.m2866a(z, z2, 3);
            }
        } catch (Exception e) {
            if (C1199X.m3083a(e)) {
                return;
            }
            e.printStackTrace();
        }
    }

    public static void applyDownloadedPatch() {
        if (new File(C1093e.f737b.f747J.getAbsolutePath()).exists()) {
            TinkerManager.getInstance().applyPatch(C1093e.f737b.f747J.getAbsolutePath(), true);
        } else {
            C1199X.m3082b(Beta.class, "[applyDownloadedPatch] patch file not exist", new Object[0]);
        }
    }

    public static void applyTinkerPatch(Context context, String str) {
        TinkerManager.getInstance().applyPatch(context, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
        if (((java.lang.Boolean) r1[2]).booleanValue() == com.tencent.bugly.beta.upgrade.C1118c.f870a.f876g) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void cancelDownload() {
        C1118c c1118c = C1118c.f870a;
        RunnableC1092d runnableC1092d = c1118c.f879j;
        if (runnableC1092d != null) {
            Object[] objArr = runnableC1092d.f735b;
            if (objArr[0] == c1118c.f872c) {
                if (objArr[1] == c1118c.f871b) {
                }
            }
        }
        C1118c c1118c2 = C1118c.f870a;
        c1118c2.f879j = new RunnableC1092d(14, c1118c2.f872c, c1118c2.f871b, Boolean.valueOf(c1118c2.f876g));
        C1118c.f870a.f879j.run();
    }

    public static void checkAppUpgrade() {
        m3630a(true, false, 1);
    }

    public static void checkAppUpgrade(boolean z, boolean z2) {
        m3630a(z, z2, 1);
    }

    public static void checkHotFix() {
        m3630a(false, false, 3);
    }

    public static void checkUpgrade() {
        checkUpgrade(true, false);
    }

    public static void checkUpgrade(boolean z, boolean z2) {
        m3630a(z, z2, 0);
    }

    public static void cleanTinkerPatch(boolean z) {
        C1089a.m3609b("IS_PATCH_ROLL_BACK", false);
        TinkerManager.getInstance().cleanPatch(z);
    }

    public static void downloadPatch() {
        C1238r c1238r = C1238r.f1611a;
        c1238r.f1612b = c1238r.m2867a((C1177B) null);
        try {
            if (C1238r.f1611a.f1612b == null) {
                return;
            }
            C1238r.f1611a.m2869a(0, C1238r.f1611a.f1612b.f858a, true);
        } catch (Exception unused) {
        }
    }

    public static UpgradeInfo getAppUpgradeInfo() {
        try {
            C1118c.f870a.f871b = (BetaGrayStrategy) C1089a.m3615a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            if (C1118c.f870a.f871b == null) {
                return null;
            }
            return new UpgradeInfo(C1118c.f870a.f871b.f858a);
        } catch (Exception unused) {
            return null;
        }
    }

    public static UpgradeInfo getHotfixUpgradeInfo() {
        try {
            C1238r.f1611a.f1612b = (BetaGrayStrategy) C1089a.m3615a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            if (C1238r.f1611a.f1612b == null) {
                return null;
            }
            return new UpgradeInfo(C1238r.f1611a.f1612b.f858a);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Beta getInstance() {
        Beta beta = instance;
        beta.f700id = 1002;
        beta.version = "1.5.0";
        beta.versionKey = "G10";
        return beta;
    }

    public static DownloadTask getStrategyTask() {
        if (f706a == null) {
            C1118c.f870a.f871b = (BetaGrayStrategy) C1089a.m3615a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            if (C1118c.f870a.f871b != null) {
                DownloadTask mo2863a = C1093e.f737b.f786s.mo2863a(C1118c.f870a.f871b.f858a.f1333k.f1663c, C1093e.f737b.f790w.getAbsolutePath(), null, C1118c.f870a.f871b.f858a.f1333k.f1662b);
                f706a = mo2863a;
                mo2863a.setDownloadType(1);
                C1118c.f870a.f872c = f706a;
            }
        }
        return C1118c.f870a.f872c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        return new com.tencent.bugly.beta.UpgradeInfo(r0.f858a);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static UpgradeInfo getUpgradeInfo() {
        BetaGrayStrategy betaGrayStrategy;
        BetaGrayStrategy betaGrayStrategy2;
        try {
            betaGrayStrategy = (BetaGrayStrategy) C1089a.m3615a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            betaGrayStrategy2 = (BetaGrayStrategy) C1089a.m3615a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
        } catch (Exception unused) {
        }
        if (betaGrayStrategy != null && betaGrayStrategy.f858a != null && betaGrayStrategy2 != null && betaGrayStrategy2.f858a != null) {
            if (betaGrayStrategy.f862e > betaGrayStrategy2.f862e) {
                return null;
            }
            betaGrayStrategy = betaGrayStrategy2;
            return null;
        }
        if (betaGrayStrategy != null && betaGrayStrategy.f858a != null) {
            if (betaGrayStrategy2 != null && betaGrayStrategy2.f858a != null) {
                betaGrayStrategy = null;
            }
            return null;
        }
        betaGrayStrategy = betaGrayStrategy2;
        return null;
    }

    public static synchronized C1177B getUpgradeStrategy() {
        synchronized (Beta.class) {
            C1118c.f870a.f871b = (BetaGrayStrategy) C1089a.m3615a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            try {
                if (C1118c.f870a.f871b != null) {
                    return (C1177B) C1118c.f870a.f871b.f858a.clone();
                }
            } catch (Exception unused) {
            }
            return null;
        }
    }

    public static synchronized void init(Context context, boolean z) {
        synchronized (Beta.class) {
            C1199X.m3078c("Beta init start....", new Object[0]);
            C1183H m3186a = C1183H.m3186a();
            int i = instance.f700id;
            int i2 = C1093e.f736a + 1;
            C1093e.f736a = i2;
            m3186a.m3184a(i, i2);
            if (TextUtils.isEmpty(initProcessName)) {
                initProcessName = context.getPackageName();
            }
            C1199X.m3078c("Beta will init at: %s", initProcessName);
            String str = C1140a.m3394m().f1043h;
            C1199X.m3078c("current process: %s", str);
            if (!TextUtils.equals(initProcessName, str)) {
                return;
            }
            C1093e c1093e = C1093e.f737b;
            if (!TextUtils.isEmpty(c1093e.f792y)) {
                C1199X.m3076e("Beta has been initialized [apkMD5 : %s]", c1093e.f792y);
                return;
            }
            C1199X.m3078c("current upgrade sdk version:1.5.0", new Object[0]);
            c1093e.f744G = z;
            long j = upgradeCheckPeriod;
            if (j < 0) {
                C1199X.m3076e("upgradeCheckPeriod cannot be negative", new Object[0]);
            } else {
                c1093e.f768d = j;
                C1199X.m3078c("setted upgradeCheckPeriod: %d", Long.valueOf(j));
            }
            long j2 = initDelay;
            if (j2 < 0) {
                C1199X.m3076e("initDelay cannot be negative", new Object[0]);
            } else {
                c1093e.f766c = j2;
                C1199X.m3078c("setted initDelay: %d", Long.valueOf(j2));
            }
            if (smallIconId != 0) {
                try {
                    if (context.getResources().getDrawable(smallIconId) != null) {
                        c1093e.f776i = smallIconId;
                        C1199X.m3078c("setted smallIconId: %d", Integer.valueOf(smallIconId));
                    }
                } catch (Exception e) {
                    C1199X.m3081b("smallIconId is not available:\n %s", e.toString());
                }
            }
            if (largeIconId != 0) {
                try {
                    if (context.getResources().getDrawable(largeIconId) != null) {
                        c1093e.f777j = largeIconId;
                        C1199X.m3078c("setted largeIconId: %d", Integer.valueOf(largeIconId));
                    }
                } catch (Exception e2) {
                    C1199X.m3081b("largeIconId is not available:\n %s", e2.toString());
                }
            }
            if (defaultBannerId != 0) {
                try {
                    if (context.getResources().getDrawable(defaultBannerId) != null) {
                        c1093e.f778k = defaultBannerId;
                        C1199X.m3078c("setted defaultBannerId: %d", Integer.valueOf(defaultBannerId));
                    }
                } catch (Exception e3) {
                    C1199X.m3081b("defaultBannerId is not available:\n %s", e3.toString());
                }
            }
            if (upgradeDialogLayoutId != 0) {
                try {
                    XmlResourceParser layout = context.getResources().getLayout(upgradeDialogLayoutId);
                    if (layout != null) {
                        c1093e.f779l = upgradeDialogLayoutId;
                        C1199X.m3078c("setted upgradeDialogLayoutId: %d", Integer.valueOf(upgradeDialogLayoutId));
                        layout.close();
                    }
                } catch (Exception e4) {
                    C1199X.m3081b("upgradeDialogLayoutId is not available:\n %s", e4.toString());
                }
            }
            if (tipsDialogLayoutId != 0) {
                try {
                    XmlResourceParser layout2 = context.getResources().getLayout(tipsDialogLayoutId);
                    if (layout2 != null) {
                        c1093e.f780m = tipsDialogLayoutId;
                        C1199X.m3078c("setted tipsDialogLayoutId: %d", Integer.valueOf(tipsDialogLayoutId));
                        layout2.close();
                    }
                } catch (Exception e5) {
                    C1199X.m3081b("tipsDialogLayoutId is not available:\n %s", e5.toString());
                }
            }
            UILifecycleListener<UpgradeInfo> uILifecycleListener = upgradeDialogLifecycleListener;
            if (uILifecycleListener != null) {
                try {
                    c1093e.f781n = uILifecycleListener;
                    StringBuilder sb = new StringBuilder();
                    sb.append("setted upgradeDialogLifecycleListener:%s");
                    sb.append(upgradeDialogLifecycleListener);
                    C1199X.m3078c(sb.toString(), new Object[0]);
                } catch (Exception e6) {
                    C1199X.m3081b("upgradeDialogLifecycleListener is not available:\n %", e6.toString());
                }
            }
            List<Class<? extends Activity>> list = canShowUpgradeActs;
            if (list != null && !list.isEmpty()) {
                for (Class<? extends Activity> cls : canShowUpgradeActs) {
                    if (cls != null) {
                        c1093e.f783p.add(cls);
                    }
                }
                C1199X.m3078c("setted canShowUpgradeActs: %s", c1093e.f783p);
            }
            List<Class<? extends Activity>> list2 = canNotShowUpgradeActs;
            if (list2 != null && !list2.isEmpty()) {
                for (Class<? extends Activity> cls2 : canNotShowUpgradeActs) {
                    if (cls2 != null) {
                        c1093e.f784q.add(cls2);
                    }
                }
                C1199X.m3078c("setted canNotShowUpgradeActs: %s", c1093e.f784q);
            }
            boolean z2 = autoCheckUpgrade;
            c1093e.f770e = z2;
            c1093e.f772f = autoCheckAppUpgrade;
            c1093e.f774g = autoCheckHotfix;
            Object[] objArr = new Object[1];
            objArr[0] = z2 ? "is opened" : "is closed";
            C1199X.m3078c("autoCheckUpgrade %s", objArr);
            Object[] objArr2 = new Object[1];
            objArr2[0] = c1093e.f772f ? "is opened" : "is closed";
            C1199X.m3078c("autoCheckAppUpgrade %s", objArr2);
            Object[] objArr3 = new Object[1];
            objArr3[0] = c1093e.f774g ? "is opened" : "is closed";
            C1199X.m3078c("autoCheckHotfix %s", objArr3);
            boolean z3 = autoInstallApk;
            c1093e.f773fa = z3;
            Object[] objArr4 = new Object[1];
            objArr4[0] = z3 ? "is opened" : "is closed";
            C1199X.m3078c("autoInstallApk %s", objArr4);
            boolean z4 = autoDownloadOn4g;
            c1093e.f759V = z4;
            Object[] objArr5 = new Object[1];
            objArr5[0] = z4 ? "is opened" : "is closed";
            C1199X.m3078c("autoDownloadOn4g %s", objArr5);
            boolean z5 = showInterruptedStrategy;
            c1093e.f775h = z5;
            Object[] objArr6 = new Object[1];
            objArr6[0] = z5 ? "is opened" : "is closed";
            C1199X.m3078c("showInterruptedStrategy %s", objArr6);
            Object[] objArr7 = new Object[1];
            objArr7[0] = upgradeListener != null ? "is opened" : "is closed";
            C1199X.m3078c("isDIY %s", objArr7);
            File file = storageDir;
            if (file != null) {
                if (file.exists() || storageDir.mkdirs()) {
                    File file2 = storageDir;
                    c1093e.f782o = file2;
                    C1199X.m3078c("setted storageDir: %s", file2.getAbsolutePath());
                } else {
                    C1199X.m3078c("storageDir is not exists: %s", storageDir.getAbsolutePath());
                }
            }
            if (c1093e.f786s == null) {
                c1093e.f786s = C1246v.f1655a;
            }
            if (TextUtils.isEmpty(c1093e.f791x)) {
                c1093e.f791x = C1140a.m3394m().m3405e();
            }
            c1093e.f757T = enableNotification;
            C1199X.m3078c("enableNotification %s", enableNotification + "");
            c1093e.f758U = autoDownloadOnWifi;
            C1199X.m3078c("autoDownloadOnWifi %s", autoDownloadOnWifi + "");
            c1093e.f760W = canShowApkInfo;
            C1199X.m3078c("canShowApkInfo %s", canShowApkInfo + "");
            c1093e.f761X = canAutoPatch;
            C1199X.m3078c("canAutoPatch %s", canAutoPatch + "");
            c1093e.f762Y = betaPatchListener;
            c1093e.f738A = appVersionName;
            c1093e.f793z = appVersionCode;
            c1093e.f763Z = canNotifyUserRestart;
            C1199X.m3078c("canNotifyUserRestart %s", canNotifyUserRestart + "");
            c1093e.f764aa = canAutoDownloadPatch;
            C1199X.m3078c("canAutoDownloadPatch %s", canAutoDownloadPatch + "");
            c1093e.f765ba = enableHotfix;
            C1199X.m3078c("enableHotfix %s", enableHotfix + "");
            List<String> list3 = soBlackList;
            if (list3 != null && !list3.isEmpty()) {
                for (String str2 : soBlackList) {
                    if (str2 != null) {
                        c1093e.f767ca.add(str2);
                    }
                }
                C1199X.m3078c("setted soBlackList: %s", c1093e.f767ca);
            }
            String str3 = appChannel;
            if (str3 != null) {
                c1093e.f755R = str3;
                C1199X.m3078c("Beta channel %s", str3);
            }
            c1093e.m3608a(context);
            ResBean resBean = (ResBean) C1089a.m3615a("rb.bch", ResBean.CREATOR);
            ResBean.f725a = resBean;
            if (resBean == null) {
                ResBean.f725a = new ResBean();
            }
            C1118c c1118c = C1118c.f870a;
            c1118c.f874e = upgradeListener;
            c1118c.f875f = upgradeStateListener;
            c1118c.f873d = downloadListener;
            if (getStrategyTask() != null && downloadListener != null) {
                getStrategyTask().addListener(C1118c.f870a.f873d);
            }
            if (enableHotfix) {
                C1199X.m3078c("enableHotfix %s", "1");
                C1208ca.m3005c("D4", "1");
                C1242t.m2865a(context);
            }
            Resources resources = context.getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Configuration configuration = resources.getConfiguration();
            Locale locale = Locale.getDefault();
            configuration.locale = locale;
            if (locale.equals(Locale.US) || configuration.locale.equals(Locale.ENGLISH)) {
                strToastYourAreTheLatestVersion = context.getResources().getString(C1083R.string.strToastYourAreTheLatestVersion);
                strToastCheckUpgradeError = context.getResources().getString(C1083R.string.strToastCheckUpgradeError);
                strToastCheckingUpgrade = context.getResources().getString(C1083R.string.strToastCheckingUpgrade);
                strNotificationDownloading = context.getResources().getString(C1083R.string.strNotificationDownloading);
                strNotificationClickToView = context.getResources().getString(C1083R.string.strNotificationClickToView);
                strNotificationClickToInstall = context.getResources().getString(C1083R.string.strNotificationClickToInstall);
                strNotificationClickToContinue = context.getResources().getString(C1083R.string.strNotificationClickToContinue);
                strNotificationClickToRetry = context.getResources().getString(C1083R.string.strNotificationClickToRetry);
                strNotificationDownloadSucc = context.getResources().getString(C1083R.string.strNotificationDownloadSucc);
                strNotificationDownloadError = context.getResources().getString(C1083R.string.strNotificationDownloadError);
                strNotificationHaveNewVersion = context.getResources().getString(C1083R.string.strNotificationHaveNewVersion);
                strNetworkTipsMessage = context.getResources().getString(C1083R.string.strNetworkTipsMessage);
                strNetworkTipsTitle = context.getResources().getString(C1083R.string.strNetworkTipsTitle);
                strNetworkTipsConfirmBtn = context.getResources().getString(C1083R.string.strNetworkTipsConfirmBtn);
                strNetworkTipsCancelBtn = context.getResources().getString(C1083R.string.strNetworkTipsCancelBtn);
                strUpgradeDialogVersionLabel = context.getResources().getString(C1083R.string.strUpgradeDialogVersionLabel);
                strUpgradeDialogFileSizeLabel = context.getResources().getString(C1083R.string.strUpgradeDialogFileSizeLabel);
                strUpgradeDialogUpdateTimeLabel = context.getResources().getString(C1083R.string.strUpgradeDialogUpdateTimeLabel);
                strUpgradeDialogFeatureLabel = context.getResources().getString(C1083R.string.strUpgradeDialogFeatureLabel);
                strUpgradeDialogUpgradeBtn = context.getResources().getString(C1083R.string.strUpgradeDialogUpgradeBtn);
                strUpgradeDialogInstallBtn = context.getResources().getString(C1083R.string.strUpgradeDialogInstallBtn);
                strUpgradeDialogRetryBtn = context.getResources().getString(C1083R.string.strUpgradeDialogRetryBtn);
                strUpgradeDialogContinueBtn = context.getResources().getString(C1083R.string.strUpgradeDialogContinueBtn);
                strUpgradeDialogCancelBtn = context.getResources().getString(C1083R.string.strUpgradeDialogCancelBtn);
            }
            resources.updateConfiguration(configuration, displayMetrics);
            C1198W.m3089c().m3091a(new RunnableC1092d(1, new Object[0]), c1093e.f766c);
            C1183H m3186a2 = C1183H.m3186a();
            int i3 = instance.f700id;
            int i4 = C1093e.f736a - 1;
            C1093e.f736a = i4;
            m3186a2.m3184a(i3, i4);
            C1199X.m3078c("Beta init finished...", new Object[0]);
        }
    }

    public static synchronized void installApk(File file) {
        synchronized (Beta.class) {
            try {
                C1177B upgradeStrategy = getUpgradeStrategy();
                if (upgradeStrategy != null && C1089a.m3623a(C1093e.f737b.f789v, file, upgradeStrategy.f1333k.f1662b)) {
                    C1234p.f1572a.m2877a(new C1250z("install", System.currentTimeMillis(), (byte) 0, 0L, upgradeStrategy.f1332j, upgradeStrategy.f1340r, upgradeStrategy.f1343u, null));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void installTinker() {
        enableHotfix = true;
        installTinker(TinkerApplicationLike.getTinkerPatchApplicationLike());
    }

    public static void installTinker(Object obj) {
        enableHotfix = true;
        TinkerManager.setPatchRestartOnScreenOff(setPatchRestartOnScreenOff);
        C1199X.m3078c("setPatchRestartOnScreenOff %s", setPatchRestartOnScreenOff + "");
        TinkerManager.installTinker(obj);
    }

    public static void installTinker(Object obj, Object obj2, Object obj3, Object obj4, TinkerManager.TinkerPatchResultListener tinkerPatchResultListener, Object obj5) {
        enableHotfix = true;
        TinkerManager.installTinker(obj, obj2, obj3, obj4, tinkerPatchResultListener, obj5);
    }

    public static void loadArmLibrary(Context context, String str) {
        TinkerManager.loadArmLibrary(context, str);
    }

    public static void loadArmV7Library(Context context, String str) {
        TinkerManager.loadArmV7Library(context, str);
    }

    public static void loadLibrary(String str) {
        boolean z;
        C1093e c1093e = C1093e.f737b;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    if (!C1089a.m3612a("LoadSoFileResult", true)) {
                        System.loadLibrary(str);
                        C1089a.m3609b("IS_PATCH_ROLL_BACK", true);
                        cleanTinkerPatch(true);
                        return;
                    }
                    C1089a.m3609b("LoadSoFileResult", false);
                    String m3613a = C1089a.m3613a(str, "");
                    boolean m3612a = C1089a.m3612a("PatchResult", false);
                    if (TextUtils.isEmpty(m3613a) || !m3612a) {
                        z = false;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("lib/");
                        sb.append(m3613a);
                        z = TinkerManager.loadLibraryFromTinker(c1093e.f789v, sb.toString(), str);
                    }
                    if (!z) {
                        System.loadLibrary(str);
                    }
                    C1089a.m3609b("LoadSoFileResult", true);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                C1089a.m3609b("LoadSoFileResult", false);
                return;
            }
        }
        C1199X.m3081b("libName is invalid", new Object[0]);
    }

    public static void loadLibraryFromTinker(Context context, String str, String str2) {
        TinkerManager.loadLibraryFromTinker(context, str, str2);
    }

    public static synchronized void onUpgradeReceived(String str, int i, String str2, long j, int i2, int i3, String str3, String str4, long j2, String str5, String str6, int i4, int i5, long j3, String str7, boolean z, boolean z2, int i6, String str8, long j4) {
        synchronized (Beta.class) {
            HashMap hashMap = new HashMap();
            hashMap.put("IMG_title", str6);
            hashMap.put("VAL_style", String.valueOf(i4));
            C1118c.f870a.m3570a(z, z2, i6, new C1177B(str, str2, j, 0, new C1249y(C1093e.f737b.f791x, (byte) 1, i3, str3, i2, "", 1L, "", str5, "", ""), new C1248x(str5, str4, "", j2, ""), (byte) i, i5, j3, null, "", hashMap, str7, 1, j4, 1), str8 == null ? "" : str8);
        }
    }

    public static void registerDownloadListener(DownloadListener downloadListener2) {
        DownloadTask downloadTask;
        C1093e.f737b.f787t = downloadListener2;
        if (downloadListener2 == null || (downloadTask = C1118c.f870a.f872c) == null) {
            return;
        }
        downloadTask.addListener(downloadListener2);
    }

    public static synchronized void saveInstallEvent(boolean z) {
        synchronized (Beta.class) {
            try {
                C1177B upgradeStrategy = getUpgradeStrategy();
                if (upgradeStrategy != null && z) {
                    C1234p.f1572a.m2877a(new C1250z("install", System.currentTimeMillis(), (byte) 0, 0L, upgradeStrategy.f1332j, upgradeStrategy.f1340r, upgradeStrategy.f1343u, null));
                    C1199X.m3078c("安装事件保存成功", new Object[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void showUpgradeDialog(String str, int i, String str2, long j, int i2, int i3, String str3, String str4, long j2, String str5, String str6, int i4, DownloadListener downloadListener2, Runnable runnable, Runnable runnable2, boolean z) {
        C1177B c1177b;
        synchronized (Beta.class) {
            HashMap hashMap = new HashMap();
            hashMap.put("IMG_title", str6);
            hashMap.put("VAL_style", String.valueOf(i4));
            C1177B c1177b2 = new C1177B(str, str2, j, 0, new C1249y(C1093e.f737b.f791x, (byte) 1, i3, str3, i2, "", 1L, "", str5, "1.5.0", ""), new C1248x(str5, str4, "", j2, ""), (byte) i, 0, 0L, null, "", hashMap, null, 1, System.currentTimeMillis(), 1);
            DownloadTask downloadTask = f706a;
            if (downloadTask != null && !downloadTask.getDownloadUrl().equals(str4)) {
                f706a.delete(true);
                f706a = null;
            }
            if (f706a == null) {
                C1093e c1093e = C1093e.f737b;
                c1177b = c1177b2;
                DownloadTask mo2863a = c1093e.f786s.mo2863a(c1177b.f1333k.f1663c, c1093e.f790w.getAbsolutePath(), null, c1177b.f1333k.f1662b);
                f706a = mo2863a;
                mo2863a.setDownloadType(1);
            } else {
                c1177b = c1177b2;
            }
            f706a.addListener(downloadListener2);
            C1115l.f842n.m3581a(c1177b, f706a);
            C1115l c1115l = C1115l.f842n;
            c1115l.f851t = runnable;
            c1115l.f852u = runnable2;
            C1094f.f794a.m3606a(C1093e.f737b.f786s, c1177b.f1339q);
            boolean z2 = false;
            if (z) {
                C1094f c1094f = C1094f.f794a;
                Object[] objArr = new Object[2];
                objArr[0] = C1115l.f842n;
                if (c1177b.f1334l == 2) {
                    z2 = true;
                }
                objArr[1] = Boolean.valueOf(z2);
                c1094f.m3604a(new RunnableC1092d(2, objArr), 3000);
            } else {
                C1094f c1094f2 = C1094f.f794a;
                Object[] objArr2 = new Object[2];
                objArr2[0] = C1115l.f842n;
                if (c1177b.f1334l == 2) {
                    z2 = true;
                }
                objArr2[1] = Boolean.valueOf(z2);
                c1094f2.m3605a(new RunnableC1092d(2, objArr2));
            }
        }
    }

    public static DownloadTask startDownload() {
        C1118c c1118c = C1118c.f870a;
        RunnableC1092d runnableC1092d = c1118c.f878i;
        if (runnableC1092d == null || runnableC1092d.f735b[0] != c1118c.f872c) {
            C1118c c1118c2 = C1118c.f870a;
            c1118c2.f878i = new RunnableC1092d(13, c1118c2.f872c, c1118c2.f871b);
        }
        C1118c.f870a.f878i.run();
        return C1118c.f870a.f872c;
    }

    public static void unInit() {
        if (C1089a.m3612a("IS_PATCH_ROLL_BACK", false)) {
            C1089a.m3609b("IS_PATCH_ROLL_BACK", false);
            TinkerManager.getInstance().cleanPatch(true);
        }
    }

    public static void unregisterDownloadListener() {
        DownloadTask downloadTask = C1118c.f870a.f872c;
        if (downloadTask != null) {
            downloadTask.removeListener(C1093e.f737b.f787t);
        }
        C1093e.f737b.f787t = null;
    }

    @Override // com.tencent.bugly.AbstractC1081a
    public String[] getTables() {
        return new String[]{"dl_1002", "ge_1002", "st_1002"};
    }

    @Override // com.tencent.bugly.AbstractC1081a
    public synchronized void init(Context context, boolean z, BuglyStrategy buglyStrategy) {
        C1140a.m3394m().m3419a("G10", "1.5.0");
        if (autoInit) {
            init(context, z);
        }
    }

    @Override // com.tencent.bugly.AbstractC1081a
    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // com.tencent.bugly.AbstractC1081a
    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3;
        String str;
        String str2;
        Cursor cursor;
        String str3 = " , ";
        String str4 = "_id";
        int i4 = i;
        int i5 = i2;
        while (i4 < i5) {
            if (i4 != 10) {
                i3 = i4;
                str = str3;
                str2 = str4;
            } else {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.setLength(0);
                    sb.append(" CREATE TABLE  IF NOT EXISTS ");
                    sb.append("st_1002");
                    sb.append(" ( ");
                    sb.append(str4);
                    sb.append(StringUtils.SPACE);
                    sb.append("integer");
                    sb.append(str3);
                    sb.append(C1553ao.f3116e);
                    sb.append(StringUtils.SPACE);
                    sb.append("text");
                    sb.append(str3);
                    sb.append("_tm");
                    sb.append(StringUtils.SPACE);
                    sb.append(ClassTransform.INTEGER);
                    sb.append(str3);
                    sb.append("_dt");
                    sb.append(StringUtils.SPACE);
                    sb.append("blob");
                    sb.append(",primary key(");
                    sb.append(str4);
                    sb.append(",");
                    sb.append(C1553ao.f3116e);
                    sb.append(" )) ");
                    C1199X.m3084a("create %s", sb.toString());
                    sQLiteDatabase.execSQL(sb.toString());
                } catch (Throwable th) {
                    if (!C1199X.m3083a(th)) {
                        th.printStackTrace();
                    }
                }
                i3 = i4;
                str = str3;
                str2 = str4;
                try {
                    cursor = sQLiteDatabase.query("t_pf", null, "_id = 1002", null, null, null, null);
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                }
                if (cursor == null) {
                    if (cursor == null) {
                        return;
                    }
                    return;
                }
                while (cursor.moveToNext()) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        if (cursor.getLong(cursor.getColumnIndex(str2)) > 0) {
                            contentValues.put(str2, Long.valueOf(cursor.getLong(cursor.getColumnIndex(str2))));
                        }
                        contentValues.put("_tm", Long.valueOf(cursor.getLong(cursor.getColumnIndex("_tm"))));
                        contentValues.put(C1553ao.f3116e, cursor.getString(cursor.getColumnIndex(C1553ao.f3116e)));
                        contentValues.put("_dt", cursor.getBlob(cursor.getColumnIndex("_dt")));
                        sQLiteDatabase.replace("st_1002", null, contentValues);
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            if (!C1199X.m3083a(th)) {
                                th.printStackTrace();
                            }
                            if (cursor == null) {
                                i4 = i3 + 1;
                                i5 = i2;
                                str4 = str2;
                                str3 = str;
                            }
                            cursor.close();
                            i4 = i3 + 1;
                            i5 = i2;
                            str4 = str2;
                            str3 = str;
                        } finally {
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    }
                }
                cursor.close();
            }
            i4 = i3 + 1;
            i5 = i2;
            str4 = str2;
            str3 = str;
        }
    }
}

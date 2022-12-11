package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.C1460i;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.IOException;

/* loaded from: classes4.dex */
public class TbsExtensionFunctionManager {
    public static final String BUGLY_SWITCH_FILE_NAME = "bugly_switch.txt";
    public static final String COOKIE_SWITCH_FILE_NAME = "cookie_switch.txt";
    public static final String DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME = "disable_get_apk_version_switch.txt";
    public static final String DISABLE_UNPREINIT = "disable_unpreinit.txt";
    public static final String DISABLE_USE_HOST_BACKUP_CORE = "disable_use_host_backup_core.txt";
    public static final String SP_KEY_COOKIE_DB_VERSION = "cookie_db_version";
    public static final String SP_NAME_FOR_COOKIE = "cookie_compatiable";
    public static final int SWITCH_BYTE_COOKIE = 1;
    public static final int SWITCH_BYTE_DISABLE_GET_APK_VERSION = 2;
    public static final int SWITCH_BYTE_DISABLE_UNPREINIT = 4;
    public static final int SWITCH_BYTE_DISABLE_USE_HOST_BACKUPCORE = 8;
    public static final String USEX5_FILE_NAME = "usex5.txt";

    /* renamed from: b */
    public static TbsExtensionFunctionManager f1885b;

    /* renamed from: a */
    public boolean f1886a;

    public static TbsExtensionFunctionManager getInstance() {
        if (f1885b == null) {
            synchronized (TbsExtensionFunctionManager.class) {
                if (f1885b == null) {
                    f1885b = new TbsExtensionFunctionManager();
                }
            }
        }
        return f1885b;
    }

    public synchronized boolean canUseFunction(Context context, String str) {
        boolean z;
        File file = new File(context.getFilesDir(), str);
        if (file.exists()) {
            if (file.isFile()) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized int getRomCookieDBVersion(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME_FOR_COOKIE, 4);
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt(SP_KEY_COOKIE_DB_VERSION, -1);
    }

    public synchronized void initTbsBuglyIfNeed(Context context) {
        String absolutePath;
        if (this.f1886a) {
            return;
        }
        if (!canUseFunction(context, BUGLY_SWITCH_FILE_NAME)) {
            TbsLog.m2155i("TbsExtensionFunMana", "bugly is forbiden!!");
            return;
        }
        if (!TbsShareManager.isThirdPartyApp(context)) {
            File m2437r = C1381p.m2503a().m2437r(context);
            if (m2437r == null) {
                TbsLog.m2155i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
            }
            if (m2437r.listFiles() != null && m2437r.listFiles().length > 0) {
                absolutePath = m2437r.getAbsolutePath();
            }
            TbsLog.m2155i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
            return;
        }
        absolutePath = TbsShareManager.m2730c(context);
        if (TextUtils.isEmpty(absolutePath)) {
            TbsLog.m2155i("TbsExtensionFunMana", "bugly init ,corePath is null");
            return;
        }
        File m2437r2 = C1381p.m2503a().m2437r(context);
        if (m2437r2 == null) {
            TbsLog.m2155i("TbsExtensionFunMana", "bugly init ,optDir is null");
            return;
        }
        File file = new File(absolutePath, "tbs_bugly_dex.jar");
        C1460i.m2052a(new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, m2437r2.getAbsolutePath(), QbSdk.getSettings()).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager"), "initBugly", (Class<?>[]) new Class[]{Context.class, String.class, String.class, String.class}, context, absolutePath, String.valueOf(WebView.getTbsSDKVersion(context)), String.valueOf(WebView.getTbsCoreVersion(context)));
        this.f1886a = true;
        TbsLog.m2155i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
    }

    public synchronized boolean setFunctionEnable(Context context, String str, boolean z) {
        if (context == null) {
            return false;
        }
        File file = new File(context.getFilesDir(), str);
        if (z) {
            if (!file.exists()) {
                try {
                    if (file.createNewFile()) {
                        return true;
                    }
                } catch (IOException e) {
                    TbsLog.m2158e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:" + str);
                    e.printStackTrace();
                    return false;
                }
            }
        } else if (file.exists()) {
            if (file.delete()) {
                return true;
            }
            TbsLog.m2158e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:" + str);
            return false;
        }
        return true;
    }
}

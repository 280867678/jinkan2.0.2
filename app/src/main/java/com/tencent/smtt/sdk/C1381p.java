package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.multidex.MultiDexExtractor;
import com.stub.StubApp;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.C1428a;
import com.tencent.smtt.utils.C1429b;
import com.tencent.smtt.utils.C1469p;
import com.tencent.smtt.utils.C1472q;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.tencent.smtt.sdk.p */
/* loaded from: classes4.dex */
public class C1381p {

    /* renamed from: d */
    public static C1381p f2185d;

    /* renamed from: f */
    public FileLock f2194f;

    /* renamed from: g */
    public FileOutputStream f2195g;

    /* renamed from: i */
    public static final ReentrantLock f2186i = new ReentrantLock();

    /* renamed from: j */
    public static final Lock f2187j = new ReentrantLock();

    /* renamed from: l */
    public static FileLock f2188l = null;

    /* renamed from: a */
    public static ThreadLocal<Integer> f2182a = new ThreadLocal<Integer>() { // from class: com.tencent.smtt.sdk.p.1
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Integer initialValue() {
            return 0;
        }
    };

    /* renamed from: m */
    public static Handler f2189m = null;

    /* renamed from: n */
    public static final Long[][] f2190n = {new Long[]{44006L, 39094008L}, new Long[]{44005L, 39094008L}, new Long[]{43910L, 38917816L}, new Long[]{44027L, 39094008L}, new Long[]{44028L, 39094008L}, new Long[]{44029L, 39094008L}, new Long[]{44030L, 39094008L}, new Long[]{44032L, 39094008L}, new Long[]{44033L, 39094008L}, new Long[]{44034L, 39094008L}, new Long[]{43909L, 38917816L}};

    /* renamed from: b */
    public static boolean f2183b = false;

    /* renamed from: c */
    public static final FileFilter f2184c = new FileFilter() { // from class: com.tencent.smtt.sdk.p.2
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (name != null && !name.endsWith(".jar_is_first_load_dex_flag_file") && !name.endsWith(MultiDexExtractor.DEX_SUFFIX)) {
                if (Build.VERSION.SDK_INT >= 26 && name.endsWith(".prof")) {
                    return false;
                }
                return Build.VERSION.SDK_INT < 26 || !name.equals("oat");
            }
            return false;
        }
    };

    /* renamed from: o */
    public static int f2191o = 0;

    /* renamed from: p */
    public static boolean f2192p = false;

    /* renamed from: e */
    public int f2193e = 0;

    /* renamed from: h */
    public boolean f2196h = false;

    /* renamed from: k */
    public boolean f2197k = false;

    public C1381p() {
        if (f2189m == null) {
            f2189m = new Handler(HandlerThreadC1380o.m2510a().getLooper()) { // from class: com.tencent.smtt.sdk.p.3
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    QbSdk.setTBSInstallingStatus(true);
                    int i = message.what;
                    if (i == 1) {
                        TbsLog.m2155i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
                        Object[] objArr = (Object[]) message.obj;
                        C1381p.this.m2474b((Context) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                    } else if (i == 2) {
                        TbsLog.m2155i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
                        Object[] objArr2 = (Object[]) message.obj;
                        C1381p.this.m2497a((Context) objArr2[0], (Context) objArr2[1], ((Integer) objArr2[2]).intValue());
                    } else if (i == 3) {
                        TbsLog.m2155i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
                        Object[] objArr3 = (Object[]) message.obj;
                        C1381p.this.m2478b((Context) objArr3[0], (Bundle) objArr3[1]);
                    } else if (i != 4) {
                    } else {
                        TbsLog.m2155i("TbsInstaller", "TbsInstaller--handleMessage--MSG_UNZIP_TBS_CORE");
                        Object[] objArr4 = (Object[]) message.obj;
                        C1381p.this.m2476b((Context) objArr4[0], (File) objArr4[1], ((Integer) objArr4[2]).intValue());
                        QbSdk.setTBSInstallingStatus(false);
                        super.handleMessage(message);
                    }
                }
            };
        }
    }

    /* renamed from: A */
    private void m2509A(Context context) {
        TbsLog.m2155i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
        if (!m2431x(context)) {
            TbsLog.m2155i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            m2508B(context);
            m2506D(context);
            if (TbsShareManager.isThirdPartyApp(context)) {
                TbsShareManager.writeCoreInfoForThirdPartyApp(context, m2441n(context), true);
            } else {
                TbsShareManager.m2737a(context);
            }
            C1379n.m2526a(context).m2527a(0, 3);
            C1379n.m2526a(context).m2524a("tpatch_num", 0);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                int i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i <= 0 || i == m2503a().m2448i(context) || i != m2503a().m2446j(context)) {
                    TbsLog.m2155i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is " + i + " getTbsCoreShareDecoupleCoreVersion is " + m2503a().m2448i(context) + " getTbsCoreInstalledVerInNolock is " + m2503a().m2446j(context));
                } else {
                    m2440o(context);
                }
            }
            f2182a.set(0);
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport tbsLogReport = TbsLogReport.getInstance(context);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("exception when renameing from copy:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.toString());
            tbsLogReport.setInstallErrorCode(TbsListener.ErrorCode.RENAME_EXCEPTION, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        m2450h(context);
    }

    /* renamed from: B */
    private void m2508B(Context context) {
        TbsLog.m2155i("TbsInstaller", "TbsInstaller--deleteOldCore");
        FileUtil.m2188a(m2437r(context), false);
    }

    /* renamed from: C */
    private void m2507C(Context context) {
        TbsLogReport tbsLogReport;
        int i;
        TbsLog.m2155i("TbsInstaller", "TbsInstaller--renameShareDir");
        File m2455f = m2455f(context, 0);
        File m2437r = m2437r(context);
        if (m2455f == null || m2437r == null) {
            TbsLog.m2155i("TbsInstaller", "renameTbsCoreShareDir return,tmpTbsCoreUnzipDir=" + m2455f + "tbsSharePath=" + m2437r);
            return;
        }
        boolean renameTo = m2455f.renameTo(m2437r);
        TbsLog.m2155i("TbsInstaller", "renameTbsCoreShareDir rename success=" + renameTo);
        C1472q.m1985a("8is" + renameTo);
        if (context != null && TbsConfig.APP_WX.equals(StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().packageName)) {
            if (renameTo) {
                tbsLogReport = TbsLogReport.getInstance(context);
                i = TbsListener.ErrorCode.RENAME_SUCCESS;
            } else {
                tbsLogReport = TbsLogReport.getInstance(context);
                i = TbsListener.ErrorCode.RENAME_FAIL;
            }
            tbsLogReport.setInstallErrorCode(i, StringUtils.SPACE);
        }
        TbsLog.m2155i("TbsInstaller", "setTmpFolderCoreToRead call #07");
        m2451g(context, false);
    }

    /* renamed from: D */
    private void m2506D(Context context) {
        TbsLog.m2155i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
        File m2455f = m2455f(context, 1);
        File m2437r = m2437r(context);
        if (m2455f == null || m2437r == null) {
            return;
        }
        m2455f.renameTo(m2437r);
        TbsLog.m2155i("TbsInstaller", "setTmpFolderCoreToRead call #08");
        m2451g(context, false);
    }

    /* renamed from: E */
    private void m2505E(Context context) {
        TbsLog.m2155i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
        File m2455f = m2455f(context, 5);
        File m2437r = m2437r(context);
        if (m2455f == null || m2437r == null) {
            return;
        }
        m2455f.renameTo(m2437r);
        TbsLog.m2155i("TbsInstaller", "setTmpFolderCoreToRead call #09");
        m2451g(context, false);
    }

    /* renamed from: F */
    private void m2504F(Context context) {
        TbsLog.m2155i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        File m2455f = m2455f(context, 0);
        if (m2455f != null) {
            FileUtil.m2188a(m2455f, false);
        }
        C1379n.m2526a(context).m2516c(0, 5);
        C1379n.m2526a(context).m2517c(-1);
        QbSdk.m2833a(context, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    }

    /* renamed from: a */
    public static synchronized C1381p m2503a() {
        C1381p c1381p;
        synchronized (C1381p.class) {
            if (f2185d == null) {
                synchronized (C1381p.class) {
                    if (f2185d == null) {
                        f2185d = new C1381p();
                    }
                }
            }
            c1381p = f2185d;
        }
        return c1381p;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x008f -> B:15:0x00a9). Please submit an issue!!! */
    /* renamed from: a */
    private void m2502a(int i, String str, Context context) {
        BufferedInputStream bufferedInputStream;
        new File(str).delete();
        TbsLog.m2153i("TbsInstaller", "Local tbs apk(" + str + ") is deleted!", true);
        File file = new File(QbSdk.getTbsFolderDir(context), "core_unzip_tmp");
        if (file.canRead()) {
            File file2 = new File(file, "tbs.conf");
            Properties properties = new Properties();
            BufferedOutputStream bufferedOutputStream = null;
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                    try {
                        properties.load(bufferedInputStream);
                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                        try {
                            properties.setProperty("tbs_local_installation", "true");
                            properties.store(bufferedOutputStream2, (String) null);
                            TbsLog.m2153i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            bufferedInputStream.close();
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream = bufferedOutputStream2;
                            try {
                                th.printStackTrace();
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (bufferedInputStream == null) {
                                    return;
                                }
                                bufferedInputStream.close();
                            } catch (Throwable th2) {
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
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
                    bufferedInputStream = null;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m2501a(Context context) {
        String str;
        if (!m2432w(context)) {
            if (m2492a(context, "core_unzip_tmp")) {
                TbsCoreLoadStat.getInstance().m2814a(context, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
                str = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME";
            } else if (m2492a(context, "core_share_backup_tmp")) {
                TbsCoreLoadStat.getInstance().m2814a(context, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
                str = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME";
            } else if (!m2492a(context, "core_copy_tmp")) {
                return;
            } else {
                TbsCoreLoadStat.getInstance().m2814a(context, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
                str = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME";
            }
            TbsLog.m2158e("TbsInstaller", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x043b, code lost:
        if (r4 == r10) goto L134;
     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03a0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03e1 A[Catch: Exception -> 0x0504, all -> 0x051e, TryCatch #11 {Exception -> 0x0504, blocks: (B:70:0x0206, B:72:0x022f, B:73:0x0232, B:75:0x024e, B:77:0x0257, B:156:0x02ad, B:92:0x02d4, B:93:0x02e2, B:95:0x02e5, B:97:0x02f1, B:99:0x02fd, B:101:0x0309, B:103:0x030f, B:106:0x031c, B:109:0x0332, B:111:0x0338, B:113:0x0383, B:115:0x0354, B:116:0x038a, B:119:0x03a2, B:122:0x03cd, B:124:0x03e1, B:126:0x03e7, B:129:0x03f7, B:131:0x0400, B:134:0x043d, B:135:0x03f2, B:136:0x0440, B:138:0x044c, B:139:0x0459, B:142:0x04b2, B:148:0x049a, B:149:0x0453, B:160:0x02b3, B:180:0x04bc, B:178:0x04c5, B:184:0x04c2, B:169:0x02c8, B:173:0x02ce, B:196:0x04c6, B:198:0x04ef, B:200:0x0509), top: B:67:0x0202 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0400 A[Catch: Exception -> 0x0504, all -> 0x051e, TryCatch #11 {Exception -> 0x0504, blocks: (B:70:0x0206, B:72:0x022f, B:73:0x0232, B:75:0x024e, B:77:0x0257, B:156:0x02ad, B:92:0x02d4, B:93:0x02e2, B:95:0x02e5, B:97:0x02f1, B:99:0x02fd, B:101:0x0309, B:103:0x030f, B:106:0x031c, B:109:0x0332, B:111:0x0338, B:113:0x0383, B:115:0x0354, B:116:0x038a, B:119:0x03a2, B:122:0x03cd, B:124:0x03e1, B:126:0x03e7, B:129:0x03f7, B:131:0x0400, B:134:0x043d, B:135:0x03f2, B:136:0x0440, B:138:0x044c, B:139:0x0459, B:142:0x04b2, B:148:0x049a, B:149:0x0453, B:160:0x02b3, B:180:0x04bc, B:178:0x04c5, B:184:0x04c2, B:169:0x02c8, B:173:0x02ce, B:196:0x04c6, B:198:0x04ef, B:200:0x0509), top: B:67:0x0202 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03f2 A[Catch: Exception -> 0x0504, all -> 0x051e, TryCatch #11 {Exception -> 0x0504, blocks: (B:70:0x0206, B:72:0x022f, B:73:0x0232, B:75:0x024e, B:77:0x0257, B:156:0x02ad, B:92:0x02d4, B:93:0x02e2, B:95:0x02e5, B:97:0x02f1, B:99:0x02fd, B:101:0x0309, B:103:0x030f, B:106:0x031c, B:109:0x0332, B:111:0x0338, B:113:0x0383, B:115:0x0354, B:116:0x038a, B:119:0x03a2, B:122:0x03cd, B:124:0x03e1, B:126:0x03e7, B:129:0x03f7, B:131:0x0400, B:134:0x043d, B:135:0x03f2, B:136:0x0440, B:138:0x044c, B:139:0x0459, B:142:0x04b2, B:148:0x049a, B:149:0x0453, B:160:0x02b3, B:180:0x04bc, B:178:0x04c5, B:184:0x04c2, B:169:0x02c8, B:173:0x02ce, B:196:0x04c6, B:198:0x04ef, B:200:0x0509), top: B:67:0x0202 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x044c A[Catch: Exception -> 0x0504, all -> 0x051e, TryCatch #11 {Exception -> 0x0504, blocks: (B:70:0x0206, B:72:0x022f, B:73:0x0232, B:75:0x024e, B:77:0x0257, B:156:0x02ad, B:92:0x02d4, B:93:0x02e2, B:95:0x02e5, B:97:0x02f1, B:99:0x02fd, B:101:0x0309, B:103:0x030f, B:106:0x031c, B:109:0x0332, B:111:0x0338, B:113:0x0383, B:115:0x0354, B:116:0x038a, B:119:0x03a2, B:122:0x03cd, B:124:0x03e1, B:126:0x03e7, B:129:0x03f7, B:131:0x0400, B:134:0x043d, B:135:0x03f2, B:136:0x0440, B:138:0x044c, B:139:0x0459, B:142:0x04b2, B:148:0x049a, B:149:0x0453, B:160:0x02b3, B:180:0x04bc, B:178:0x04c5, B:184:0x04c2, B:169:0x02c8, B:173:0x02ce, B:196:0x04c6, B:198:0x04ef, B:200:0x0509), top: B:67:0x0202 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0453 A[Catch: Exception -> 0x0504, all -> 0x051e, TryCatch #11 {Exception -> 0x0504, blocks: (B:70:0x0206, B:72:0x022f, B:73:0x0232, B:75:0x024e, B:77:0x0257, B:156:0x02ad, B:92:0x02d4, B:93:0x02e2, B:95:0x02e5, B:97:0x02f1, B:99:0x02fd, B:101:0x0309, B:103:0x030f, B:106:0x031c, B:109:0x0332, B:111:0x0338, B:113:0x0383, B:115:0x0354, B:116:0x038a, B:119:0x03a2, B:122:0x03cd, B:124:0x03e1, B:126:0x03e7, B:129:0x03f7, B:131:0x0400, B:134:0x043d, B:135:0x03f2, B:136:0x0440, B:138:0x044c, B:139:0x0459, B:142:0x04b2, B:148:0x049a, B:149:0x0453, B:160:0x02b3, B:180:0x04bc, B:178:0x04c5, B:184:0x04c2, B:169:0x02c8, B:173:0x02ce, B:196:0x04c6, B:198:0x04ef, B:200:0x0509), top: B:67:0x0202 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02d4 A[Catch: Exception -> 0x0504, all -> 0x051e, TryCatch #11 {Exception -> 0x0504, blocks: (B:70:0x0206, B:72:0x022f, B:73:0x0232, B:75:0x024e, B:77:0x0257, B:156:0x02ad, B:92:0x02d4, B:93:0x02e2, B:95:0x02e5, B:97:0x02f1, B:99:0x02fd, B:101:0x0309, B:103:0x030f, B:106:0x031c, B:109:0x0332, B:111:0x0338, B:113:0x0383, B:115:0x0354, B:116:0x038a, B:119:0x03a2, B:122:0x03cd, B:124:0x03e1, B:126:0x03e7, B:129:0x03f7, B:131:0x0400, B:134:0x043d, B:135:0x03f2, B:136:0x0440, B:138:0x044c, B:139:0x0459, B:142:0x04b2, B:148:0x049a, B:149:0x0453, B:160:0x02b3, B:180:0x04bc, B:178:0x04c5, B:184:0x04c2, B:169:0x02c8, B:173:0x02ce, B:196:0x04c6, B:198:0x04ef, B:200:0x0509), top: B:67:0x0202 }] */
    @TargetApi(11)
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m2497a(Context context, Context context2, int i) {
        Exception exc;
        File file;
        int m2515c;
        int m2519b;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        Exception exc2;
        Properties properties;
        BufferedInputStream bufferedInputStream2;
        boolean z;
        boolean z2;
        File m2545d;
        TbsLogReport tbsLogReport;
        String str;
        String str2;
        String str3 = "";
        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-524);
        if (m2465d(context2)) {
            return;
        }
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread start!  tbsCoreTargetVer is " + i);
        if (context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4).getInt("tbs_precheck_disable_version", -1) == i) {
            TbsLog.m2158e("TbsInstaller", "TbsInstaller-copyTbsCoreInThread -- version:" + i + " is disabled by preload_x5_check!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-525);
        } else if (!m2434u(context2)) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-526);
        } else {
            boolean tryLock = f2187j.tryLock();
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller-copyTbsCoreInThread #1 locked is ", tryLock, "TbsInstaller");
            if (!tryLock) {
                m2482b();
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-538);
                return;
            }
            f2186i.lock();
            try {
                try {
                    m2515c = C1379n.m2526a(context2).m2515c("copy_core_ver");
                    m2519b = C1379n.m2526a(context2).m2519b("copy_status");
                } catch (Throwable th2) {
                    f2186i.unlock();
                    f2187j.unlock();
                    m2482b();
                    throw th2;
                }
            } catch (Exception e) {
                exc = e;
                file = null;
            }
            if (m2515c == i) {
                QbSdk.f1753n.onInstallFinish(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-528);
                f2186i.unlock();
                f2187j.unlock();
                m2482b();
                return;
            }
            int m2446j = m2446j(context2);
            TbsLog.m2155i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread tbsCoreInstalledVer=" + m2446j);
            if (m2446j == i) {
                QbSdk.f1753n.onInstallFinish(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-528);
                TbsLog.m2155i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread return have same version is " + m2446j);
                f2186i.unlock();
                f2187j.unlock();
                m2482b();
                return;
            }
            int m2522b = C1379n.m2526a(context2).m2522b();
            if ((m2522b > 0 && i > m2522b) || (m2515c > 0 && i > m2515c)) {
                m2439p(context2);
            }
            if (m2519b == 3 && m2446j > 0 && (i > m2446j || i == 88888888)) {
                m2439p(context2);
                TbsLog.m2153i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread -- update TBS.....", true);
                m2519b = -1;
            }
            if (!FileUtil.m2178b(context2)) {
                long m1991a = C1472q.m1991a();
                long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context2).getDownloadMinFreeSpace();
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-529);
                TbsLogReport tbsLogReport2 = TbsLogReport.getInstance(context2);
                tbsLogReport2.setInstallErrorCode(210, "rom is not enough when copying tbs core! curAvailROM=" + m1991a + ",minReqRom=" + downloadMinFreeSpace);
                f2186i.unlock();
                f2187j.unlock();
                m2482b();
                return;
            }
            if (m2519b > 0 && (TbsShareManager.isThirdPartyApp(context2) || !TbsDownloader.m2809a(context2) || i == m2448i(context2))) {
                TbsLog.m2155i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread return have copied is " + m2448i(context2));
                f2186i.unlock();
                f2187j.unlock();
                m2482b();
                return;
            }
            if (m2519b == 0) {
                int m2515c2 = C1379n.m2526a(context2).m2515c("copy_retry_num");
                if (m2515c2 > 2) {
                    TbsLogReport.getInstance(context2).setInstallErrorCode(211, "exceed copy retry num!");
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-530);
                    f2186i.unlock();
                    f2187j.unlock();
                    m2482b();
                    return;
                }
                C1379n.m2526a(context2).m2524a("copy_retry_num", m2515c2 + 1);
            }
            File m2437r = m2437r(context);
            file = (TbsShareManager.isThirdPartyApp(context2) || !TbsDownloader.m2809a(context2)) ? m2455f(context2, 1) : m2438q(context2);
            try {
                if (m2437r == null || file == null) {
                    if (m2437r == null) {
                        TbsLogReport.getInstance(context2).setInstallErrorCode(213, "src-dir is null when copying tbs core!");
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-535);
                    }
                    if (file == null) {
                        TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.COPY_TMPDIR_ERROR, "dst-dir is null when copying tbs core!");
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-536);
                    }
                } else {
                    C1379n.m2526a(context2).m2527a(i, 0);
                    C1469p c1469p = new C1469p();
                    c1469p.m1998a(m2437r);
                    long currentTimeMillis = System.currentTimeMillis();
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-551);
                    boolean m2190a = FileUtil.m2190a(m2437r, file, f2184c);
                    if (TbsDownloader.m2809a(context2)) {
                        TbsShareManager.m2732b(context2);
                    }
                    TbsLog.m2155i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread time=" + (System.currentTimeMillis() - currentTimeMillis));
                    if (m2190a) {
                        c1469p.m1997b(m2437r);
                        if (!c1469p.m2000a()) {
                            TbsLog.m2155i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread copy-verify fail!");
                            FileUtil.m2188a(file, true);
                            TbsLogReport.getInstance(context2).setInstallErrorCode(213, "TbsCopy-Verify fail after copying tbs core!");
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-531);
                            f2186i.unlock();
                            f2187j.unlock();
                            m2482b();
                            return;
                        }
                        try {
                            try {
                                File file2 = new File(file, "1");
                                properties = new Properties();
                                try {
                                    if (file2.exists()) {
                                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                                        try {
                                            properties.load(bufferedInputStream);
                                            z = true;
                                        } catch (Exception e2) {
                                            bufferedInputStream2 = bufferedInputStream;
                                            exc2 = e2;
                                            try {
                                                exc2.printStackTrace();
                                                if (bufferedInputStream2 != null) {
                                                }
                                                z = true;
                                                if (z) {
                                                }
                                                z2 = true;
                                                TbsLog.m2155i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:" + z2);
                                                if (!z) {
                                                }
                                                TbsLog.m2155i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                                TbsLog.m2155i("TbsInstaller", "setTmpFolderCoreToRead call #04");
                                                m2451g(context2, true);
                                                m2545d = C1377m.m2545d(context);
                                                if (m2545d != null) {
                                                }
                                                C1379n.m2526a(context2).m2527a(i, 1);
                                                if (this.f2197k) {
                                                }
                                                tbsLogReport.setInstallErrorCode(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, str);
                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-533);
                                                TbsLog.m2155i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:" + i);
                                                try {
                                                    SharedPreferences.Editor edit = context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4).edit();
                                                    edit.putInt("tbs_preload_x5_counter", 0);
                                                    edit.putInt("tbs_preload_x5_recorder", 0);
                                                    edit.putInt("tbs_preload_x5_version", i);
                                                    edit.commit();
                                                } catch (Throwable th3) {
                                                    TbsLog.m2158e("TbsInstaller", "Init tbs_preload_x5_counter#2 exception:" + Log.getStackTraceString(th3));
                                                }
                                                C1472q.m1989a(context2);
                                                f2186i.unlock();
                                                f2187j.unlock();
                                                m2482b();
                                            } catch (Throwable th4) {
                                                th = th4;
                                                bufferedInputStream = bufferedInputStream2;
                                                if (bufferedInputStream != null) {
                                                    try {
                                                        bufferedInputStream.close();
                                                    } catch (IOException e3) {
                                                        e3.printStackTrace();
                                                    }
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            if (bufferedInputStream != null) {
                                            }
                                            throw th;
                                        }
                                    } else {
                                        z = false;
                                        bufferedInputStream = null;
                                    }
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                } catch (Exception e5) {
                                    exc2 = e5;
                                    bufferedInputStream2 = null;
                                    exc2.printStackTrace();
                                    if (bufferedInputStream2 != null) {
                                        try {
                                            bufferedInputStream2.close();
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                    z = true;
                                    if (z) {
                                    }
                                    z2 = true;
                                    TbsLog.m2155i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:" + z2);
                                    if (!z) {
                                    }
                                    TbsLog.m2155i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                    TbsLog.m2155i("TbsInstaller", "setTmpFolderCoreToRead call #04");
                                    m2451g(context2, true);
                                    m2545d = C1377m.m2545d(context);
                                    if (m2545d != null) {
                                        File file3 = new File(m2545d, !TbsDownloader.getOverSea(context2) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
                                        if (C1472q.m1982b(context2)) {
                                        }
                                        C1377m.m2562a(file3, context2);
                                    }
                                    C1379n.m2526a(context2).m2527a(i, 1);
                                    if (this.f2197k) {
                                    }
                                    tbsLogReport.setInstallErrorCode(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, str);
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-533);
                                    TbsLog.m2155i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:" + i);
                                    SharedPreferences.Editor edit2 = context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4).edit();
                                    edit2.putInt("tbs_preload_x5_counter", 0);
                                    edit2.putInt("tbs_preload_x5_recorder", 0);
                                    edit2.putInt("tbs_preload_x5_version", i);
                                    edit2.commit();
                                    C1472q.m1989a(context2);
                                    f2186i.unlock();
                                    f2187j.unlock();
                                    m2482b();
                                }
                            } catch (Exception e7) {
                                exc2 = e7;
                                properties = null;
                            }
                            if (z) {
                                File[] listFiles = file.listFiles();
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-552);
                                int i2 = 0;
                                while (i2 < listFiles.length) {
                                    File file4 = listFiles[i2];
                                    if (!"1".equals(file4.getName()) && !file4.getName().endsWith(MultiDexExtractor.DEX_SUFFIX) && !"tbs.conf".equals(file4.getName()) && !file4.isDirectory() && !file4.getName().endsWith(".prof")) {
                                        String m2135a = C1428a.m2135a(file4);
                                        String property = properties.getProperty(file4.getName(), str3);
                                        str2 = str3;
                                        if (property.equals(str3) || !m2135a.equals(property)) {
                                            TbsLog.m2158e("TbsInstaller", "md5_check_failure for (" + file4.getName() + ") targetMd5:" + property + ", realMd5:" + m2135a);
                                            z2 = false;
                                            break;
                                        }
                                        TbsLog.m2155i("TbsInstaller", "md5_check_success for (" + file4.getName() + ")");
                                        i2++;
                                        str3 = str2;
                                    }
                                    str2 = str3;
                                    i2++;
                                    str3 = str2;
                                }
                            }
                            z2 = true;
                            TbsLog.m2155i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:" + z2);
                            if (!z && !z2) {
                                TbsLog.m2158e("TbsInstaller", "copyTbsCoreInThread - md5 incorrect -> delete destTmpDir!");
                                FileUtil.m2188a(file, true);
                                TbsLogReport.getInstance(context2).setInstallErrorCode(213, "TbsCopy-Verify md5 fail after copying tbs core!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-532);
                                f2186i.unlock();
                                f2187j.unlock();
                                m2482b();
                                return;
                            }
                            TbsLog.m2155i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                            TbsLog.m2155i("TbsInstaller", "setTmpFolderCoreToRead call #04");
                            m2451g(context2, true);
                            m2545d = C1377m.m2545d(context);
                            if (m2545d != null && m2545d.exists()) {
                                File file32 = new File(m2545d, !TbsDownloader.getOverSea(context2) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
                                if (C1472q.m1982b(context2)) {
                                    int i3 = TbsDownloadConfig.getInstance(context2).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                                    int tbsStableCoreVersion = TbsShareManager.getTbsStableCoreVersion(context2, 0);
                                    int m2131b = C1428a.m2131b(file32);
                                    TbsLog.m2155i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread decoupleCoreVersion is " + i3 + " localStableCoreVersionMyCpu is " + tbsStableCoreVersion + " srcBackupFileCoreVersion is " + m2131b);
                                    if (tbsStableCoreVersion < i3) {
                                    }
                                }
                                C1377m.m2562a(file32, context2);
                            }
                            C1379n.m2526a(context2).m2527a(i, 1);
                            if (this.f2197k) {
                                tbsLogReport = TbsLogReport.getInstance(context2);
                                str = "continueInstallWithout core success";
                            } else {
                                tbsLogReport = TbsLogReport.getInstance(context2);
                                str = "success";
                            }
                            tbsLogReport.setInstallErrorCode(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, str);
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-533);
                            TbsLog.m2155i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:" + i);
                            SharedPreferences.Editor edit22 = context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4).edit();
                            edit22.putInt("tbs_preload_x5_counter", 0);
                            edit22.putInt("tbs_preload_x5_recorder", 0);
                            edit22.putInt("tbs_preload_x5_version", i);
                            edit22.commit();
                            C1472q.m1989a(context2);
                        } catch (Throwable th6) {
                            th = th6;
                            bufferedInputStream = null;
                        }
                    } else {
                        TbsLog.m2155i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread fail!");
                        C1379n.m2526a(context2).m2527a(i, 2);
                        FileUtil.m2188a(file, false);
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-534);
                        TbsLogReport.getInstance(context2).setInstallErrorCode(212, "copy fail!");
                    }
                }
            } catch (Exception e8) {
                exc = e8;
                TbsLogReport.getInstance(context2).setInstallErrorCode(TbsListener.ErrorCode.COPY_EXCEPTION, exc.toString());
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-537);
                try {
                    FileUtil.m2188a(file, false);
                    C1379n.m2526a(context2).m2527a(0, -1);
                } catch (Exception e9) {
                    TbsLog.m2158e("TbsInstaller", "[TbsInstaller-copyTbsCoreInThread] delete dstTmpDir throws exception:" + e9.getMessage() + "," + e9.getCause());
                }
                f2186i.unlock();
                f2187j.unlock();
                m2482b();
            }
            f2186i.unlock();
            f2187j.unlock();
            m2482b();
        }
    }

    /* renamed from: a */
    private boolean m2493a(Context context, File file, boolean z) {
        StringBuilder sb;
        TbsDownloadConfig tbsDownloadConfig;
        int i;
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-unzipTbs start isDecoupleCore is " + z);
        if (!FileUtil.m2170c(file)) {
            TbsLogReport.getInstance(context).setInstallErrorCode(204, "apk is invalid!");
            tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
            i = -520;
        } else {
            try {
                File tbsFolderDir = QbSdk.getTbsFolderDir(context);
                File file2 = z ? new File(tbsFolderDir, "core_share_decouple") : new File(tbsFolderDir, "core_unzip_tmp");
                if (file2.exists() && !TbsDownloader.m2809a(context)) {
                    FileUtil.m2175b(file2);
                }
            } catch (Throwable th) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller-unzipTbs -- delete unzip folder if exists exception");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(th));
                TbsLog.m2158e("TbsInstaller", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            File m2455f = z ? m2455f(context, 2) : m2455f(context, 0);
            if (m2455f != null) {
                boolean z2 = true;
                try {
                    try {
                        FileUtil.m2192a(m2455f);
                        if (z) {
                            FileUtil.m2188a(m2455f, true);
                        }
                        boolean m2191a = FileUtil.m2191a(file, m2455f);
                        if (m2191a) {
                            m2191a = m2485a(m2455f, context);
                        }
                        if (z) {
                            for (String str : m2455f.list()) {
                                File file3 = new File(m2455f, str);
                                if (file3.getName().endsWith(MultiDexExtractor.DEX_SUFFIX)) {
                                    file3.delete();
                                }
                            }
                            try {
                                new File(m2435t(context), "x5.tbs").delete();
                            } catch (Exception unused) {
                            }
                        }
                        if (!m2191a) {
                            FileUtil.m2175b(m2455f);
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-522);
                            TbsLog.m2158e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#1! exist:" + m2455f.exists());
                        } else {
                            TbsLog.m2155i("TbsInstaller", "setTmpFolderCoreToRead call #05");
                            m2451g(context, true);
                            if (z) {
                                File m2438q = m2438q(context);
                                FileUtil.m2188a(m2438q, true);
                                m2455f.renameTo(m2438q);
                                TbsShareManager.m2732b(context);
                            }
                        }
                        return m2191a;
                    } catch (IOException e) {
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-523);
                        TbsLogReport.getInstance(context).setInstallErrorCode(206, e);
                        if (!m2455f.exists()) {
                            z2 = false;
                        }
                        if (z2) {
                            try {
                                FileUtil.m2175b(m2455f);
                                TbsLog.m2158e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + m2455f.exists());
                            } catch (Throwable th2) {
                                th = th2;
                                sb = new StringBuilder();
                                sb.append("copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:");
                                sb.append(Log.getStackTraceString(th));
                                TbsLog.m2158e("TbsInstaller", sb.toString());
                                TbsLog.m2155i("TbsInstaller", "TbsInstaller-unzipTbs done");
                                C1472q.m1985a("11");
                                return false;
                            }
                        }
                        TbsLog.m2155i("TbsInstaller", "TbsInstaller-unzipTbs done");
                        C1472q.m1985a("11");
                        return false;
                    } catch (Exception e2) {
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-523);
                        TbsLogReport.getInstance(context).setInstallErrorCode(207, e2);
                        if (!m2455f.exists()) {
                            z2 = false;
                        }
                        if (z2) {
                            try {
                                FileUtil.m2175b(m2455f);
                                TbsLog.m2158e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + m2455f.exists());
                            } catch (Throwable th3) {
                                th = th3;
                                sb = new StringBuilder();
                                sb.append("copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:");
                                sb.append(Log.getStackTraceString(th));
                                TbsLog.m2158e("TbsInstaller", sb.toString());
                                TbsLog.m2155i("TbsInstaller", "TbsInstaller-unzipTbs done");
                                C1472q.m1985a("11");
                                return false;
                            }
                        }
                        TbsLog.m2155i("TbsInstaller", "TbsInstaller-unzipTbs done");
                        C1472q.m1985a("11");
                        return false;
                    }
                } finally {
                    TbsLog.m2155i("TbsInstaller", "TbsInstaller-unzipTbs done");
                    C1472q.m1985a("11");
                }
            }
            TbsLogReport.getInstance(context).setInstallErrorCode(205, "tmp unzip dir is null!");
            tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
            i = -521;
        }
        tbsDownloadConfig.setInstallInterruptCode(i);
        return false;
    }

    /* renamed from: a */
    public static boolean m2492a(Context context, String str) {
        StringBuilder sb;
        String str2;
        File file = new File(QbSdk.getTbsFolderDir(context), str);
        if (!file.exists()) {
            sb = new StringBuilder();
            str2 = "#1# ";
        } else if (new File(file, "tbs.conf").exists()) {
            TbsLog.m2154i("TbsInstaller", "isPrepareTbsCore", "#3# " + str);
            return true;
        } else {
            sb = new StringBuilder();
            str2 = "#2# ";
        }
        sb.append(str2);
        sb.append(str);
        TbsLog.m2154i("TbsInstaller", "isPrepareTbsCore", sb.toString());
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x012a: MOVE  (r14 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:84:0x012a */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean m2485a(File file, Context context) {
        BufferedInputStream bufferedInputStream;
        Properties properties;
        Exception e;
        BufferedInputStream bufferedInputStream2;
        boolean z;
        boolean z2;
        File[] listFiles;
        TbsLog.m2155i("TbsInstaller", "finalCheckForTbsCoreValidity - " + file + ", " + context);
        BufferedInputStream bufferedInputStream3 = null;
        try {
            try {
                try {
                    File file2 = new File(file, "1");
                    properties = new Properties();
                    try {
                        if (file2.exists()) {
                            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
                            try {
                                properties.load(bufferedInputStream2);
                                bufferedInputStream3 = bufferedInputStream2;
                                z = true;
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                z = true;
                                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("finalCheckForTbsCoreValidity - need_check:", z, "TbsInstaller");
                                if (z) {
                                }
                                z2 = true;
                                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("finalCheckForTbsCoreValidity - md5_check_success:", z2, "TbsInstaller");
                                if (z) {
                                }
                                TbsLog.m2155i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
                                return true;
                            }
                        } else {
                            z = false;
                        }
                        if (bufferedInputStream3 != null) {
                            try {
                                bufferedInputStream3.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                    } catch (Exception e5) {
                        bufferedInputStream2 = null;
                        e = e5;
                    }
                } catch (Exception e6) {
                    properties = null;
                    e = e6;
                    bufferedInputStream2 = null;
                }
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("finalCheckForTbsCoreValidity - need_check:", z, "TbsInstaller");
                if (z) {
                    for (File file3 : file.listFiles()) {
                        if (!"1".equals(file3.getName()) && !file3.getName().endsWith(MultiDexExtractor.DEX_SUFFIX) && !"tbs.conf".equals(file3.getName()) && !file3.isDirectory() && !file3.getName().endsWith(".prof")) {
                            String m2135a = C1428a.m2135a(file3);
                            String property = properties.getProperty(file3.getName(), "");
                            if (property.equals("") || !property.equals(m2135a)) {
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("md5_check_failure for (");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(file3.getName());
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" targetMd5:");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(property);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", realMd5:");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(m2135a);
                                TbsLog.m2158e("TbsInstaller", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                                z2 = false;
                                break;
                            }
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("md5_check_success for (");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(file3.getName());
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(")");
                            TbsLog.m2155i("TbsInstaller", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                        }
                    }
                }
                z2 = true;
                outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("finalCheckForTbsCoreValidity - md5_check_success:", z2, "TbsInstaller");
                if (z || z2) {
                    TbsLog.m2155i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
                    return true;
                }
                TbsLog.m2158e("TbsInstaller", "finalCheckForTbsCoreValidity - Verify failed after unzipping!");
                return false;
            } catch (Throwable th) {
                th = th;
                if (bufferedInputStream3 != null) {
                    try {
                        bufferedInputStream3.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream3 = bufferedInputStream;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0493 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @TargetApi(11)
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m2474b(Context context, String str, int i) {
        boolean z;
        int i2;
        int i3;
        String str2;
        TbsLogReport tbsLogReport;
        int m2433v;
        String str3;
        String str4;
        boolean z2;
        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-501);
        if (m2465d(context)) {
            TbsLog.m2153i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-502);
            QbSdk.f1753n.onInstallFinish(-502);
            return;
        }
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=" + str);
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=" + i);
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + Process.myPid());
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + Thread.currentThread().getName());
        if (context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4).getInt("tbs_precheck_disable_version", -1) == i) {
            TbsLog.m2158e("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- version:" + i + " is disabled by preload_x5_check!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-503);
            QbSdk.f1753n.onInstallFinish(-503);
        } else if (!FileUtil.m2178b(context)) {
            long m1991a = C1472q.m1991a();
            long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-504);
            String str5 = "rom is not enough when installing tbs core! curAvailROM=" + m1991a + ",minReqRom=" + downloadMinFreeSpace;
            TbsLogReport.getInstance(context).setInstallErrorCode(210, str5);
            TbsLog.m2155i("TbsInstaller", str5);
            QbSdk.f1753n.onInstallFinish(210);
        } else if (!m2434u(context)) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-505);
            TbsLog.m2155i("TbsInstaller", "getInstalling file lock failed,return!");
            QbSdk.f1753n.onInstallFinish(-505);
        } else {
            boolean tryLock = f2187j.tryLock();
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller-installTbsCoreInThread locked =", tryLock, "TbsInstaller");
            if (!tryLock) {
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-519);
                m2482b();
                return;
            }
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-507);
            f2186i.lock();
            try {
                int m2515c = C1379n.m2526a(context).m2515c("copy_core_ver");
                int m2522b = C1379n.m2526a(context).m2522b();
                TbsLog.m2155i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =" + m2515c);
                TbsLog.m2155i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =" + m2522b);
                TbsLog.m2155i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =" + i);
                if ((m2522b > 0 && i > m2522b) || (m2515c > 0 && i > m2515c)) {
                    m2439p(context);
                }
                int m2518c = C1379n.m2526a(context).m2518c();
                int m2446j = m2446j(context);
                TbsLog.m2155i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=" + m2518c);
                TbsLog.m2155i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=" + m2446j);
                if (m2518c >= 0 && m2518c < 2) {
                    TbsLog.m2153i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
                    z = true;
                } else if (m2518c != 3 || m2446j < 0 || (i <= m2446j && i != 88888888)) {
                    z = false;
                } else {
                    m2439p(context);
                    TbsLog.m2153i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
                    z = false;
                    m2518c = -1;
                }
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-508);
                TbsLog.m2155i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=" + m2518c);
                if (m2518c < 1) {
                    TbsLog.m2153i("TbsInstaller", "STEP 2/2 begin installation.....", true);
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-509);
                    if (z) {
                        int m2515c2 = C1379n.m2526a(context).m2515c("unzip_retry_num");
                        if (m2515c2 > 10) {
                            TbsLogReport.getInstance(context).setInstallErrorCode(201, "exceed unzip retry num!");
                            m2504F(context);
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-510);
                            try {
                                f2186i.unlock();
                                f2187j.unlock();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {
                                m2482b();
                                return;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                        C1379n.m2526a(context).m2521b(m2515c2 + 1);
                    }
                    if (str == null) {
                        str4 = C1379n.m2526a(context).m2512d("install_apk_path");
                        if (str4 == null) {
                            TbsLogReport.getInstance(context).setInstallErrorCode(202, "apk path is null!");
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                            try {
                                f2186i.unlock();
                                f2187j.unlock();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            try {
                                m2482b();
                                return;
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                return;
                            }
                        }
                    } else {
                        str4 = str;
                    }
                    TbsLog.m2155i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =" + str4);
                    i3 = m2467c(context, str4);
                    if (i3 == 0) {
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-512);
                        TbsLogReport.getInstance(context).setInstallErrorCode(203, "apk version is 0!");
                        try {
                            f2186i.unlock();
                            f2187j.unlock();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        try {
                            m2482b();
                            return;
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            return;
                        }
                    }
                    C1379n.m2526a(context).m2523a("install_apk_path", str4);
                    C1379n.m2526a(context).m2516c(i3, 0);
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-548);
                    if (TbsDownloader.m2809a(context)) {
                        if (!m2493a(context, new File(str4), true)) {
                            TbsLogReport.getInstance(context).setInstallErrorCode(207, "unzipTbsApk failed", TbsLogReport.EventType.TYPE_INSTALL_DECOUPLE);
                            try {
                                f2186i.unlock();
                                f2187j.unlock();
                            } catch (Exception e7) {
                                e7.printStackTrace();
                            }
                            try {
                                m2482b();
                                return;
                            } catch (Exception e8) {
                                e8.printStackTrace();
                                return;
                            }
                        }
                    } else if (!m2477b(context, new File(str4))) {
                        TbsLogReport.getInstance(context).setInstallErrorCode(207, "unzipTbsApk failed");
                        try {
                            f2186i.unlock();
                            f2187j.unlock();
                        } catch (Exception e9) {
                            e9.printStackTrace();
                        }
                        try {
                            m2482b();
                            return;
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            return;
                        }
                    }
                    if (z) {
                        int m2519b = C1379n.m2526a(context).m2519b("unlzma_status");
                        if (m2519b > 5) {
                            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, "exceed unlzma retry num!");
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-553);
                            m2504F(context);
                            C1377m.m2542e(context);
                            TbsDownloadConfig.getInstance(context).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, true);
                            TbsDownloadConfig.getInstance(context).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, true);
                            TbsDownloadConfig.getInstance(context).commit();
                            try {
                                f2186i.unlock();
                                f2187j.unlock();
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                            try {
                                m2482b();
                                return;
                            } catch (Exception e12) {
                                e12.printStackTrace();
                                return;
                            }
                        }
                        C1379n.m2526a(context).m2513d(m2519b + 1);
                    }
                    TbsLog.m2155i("TbsInstaller", "unlzma begin");
                    int i4 = TbsDownloadConfig.getInstance().mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
                    if (m2446j(context) != 0) {
                        Object m2832a = QbSdk.m2832a(context, "can_unlzma", (Bundle) null);
                        if ((m2832a == null || !(m2832a instanceof Boolean)) ? false : ((Boolean) m2832a).booleanValue()) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("responseCode", i4);
                            bundle.putString("unzip_temp_path", (TbsDownloader.m2809a(context) ? m2438q(context) : m2455f(context, 0)).getAbsolutePath());
                            Object m2832a2 = QbSdk.m2832a(context, "unlzma", bundle);
                            if (m2832a2 == null) {
                                TbsLog.m2155i("TbsInstaller", "unlzma return null");
                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNLZMA_FAIURE, "unlzma is null");
                            } else {
                                if (!(m2832a2 instanceof Boolean)) {
                                    if (!(m2832a2 instanceof Bundle)) {
                                        if (m2832a2 instanceof Throwable) {
                                            TbsLog.m2155i("TbsInstaller", "unlzma failure because Throwable" + Log.getStackTraceString((Throwable) m2832a2));
                                            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNLZMA_FAIURE, (Throwable) m2832a2);
                                        }
                                    }
                                    z2 = true;
                                } else if (((Boolean) m2832a2).booleanValue()) {
                                    TbsLog.m2155i("TbsInstaller", "unlzma success");
                                    z2 = true;
                                } else {
                                    TbsLog.m2155i("TbsInstaller", "unlzma return false");
                                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNLZMA_FAIURE, "unlzma return false");
                                }
                                if (!z2) {
                                    try {
                                        f2186i.unlock();
                                        f2187j.unlock();
                                    } catch (Exception e13) {
                                        e13.printStackTrace();
                                    }
                                    try {
                                        m2482b();
                                        return;
                                    } catch (Exception e14) {
                                        e14.printStackTrace();
                                        return;
                                    }
                                }
                            }
                            z2 = false;
                            if (!z2) {
                            }
                        }
                    }
                    TbsLog.m2155i("TbsInstaller", "unlzma finished");
                    C1379n.m2526a(context).m2516c(i3, 1);
                    i2 = 2;
                } else {
                    if (TbsDownloader.m2809a(context)) {
                        if (str == null) {
                            str2 = C1379n.m2526a(context).m2512d("install_apk_path");
                            if (str2 == null) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(202, "apk path is null!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                                try {
                                    f2186i.unlock();
                                    f2187j.unlock();
                                } catch (Exception e15) {
                                    e15.printStackTrace();
                                }
                                try {
                                    m2482b();
                                    return;
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                    return;
                                }
                            }
                        } else {
                            str2 = str;
                        }
                        m2493a(context, new File(str2), true);
                    }
                    i2 = 2;
                    i3 = 0;
                }
                if (m2518c < i2) {
                    if (z) {
                        int m2515c3 = C1379n.m2526a(context).m2515c("dexopt_retry_num");
                        if (m2515c3 > 10) {
                            TbsLogReport.getInstance(context).setInstallErrorCode(208, "exceed dexopt retry num!");
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-514);
                            m2504F(context);
                            try {
                                f2186i.unlock();
                                f2187j.unlock();
                            } catch (Exception e17) {
                                e17.printStackTrace();
                            }
                            try {
                                m2482b();
                                return;
                            } catch (Exception e18) {
                                e18.printStackTrace();
                                return;
                            }
                        }
                        C1379n.m2526a(context).m2528a(m2515c3 + 1);
                    }
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-549);
                    if (!m2445j(context, 0)) {
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-515);
                        try {
                            f2186i.unlock();
                            f2187j.unlock();
                        } catch (Exception e19) {
                            e19.printStackTrace();
                        }
                        try {
                            m2482b();
                            return;
                        } catch (Exception e20) {
                            e20.printStackTrace();
                            return;
                        }
                    }
                    C1379n.m2526a(context).m2516c(i3, 2);
                    TbsLog.m2153i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
                    C1377m.m2567a(context);
                    C1377m.m2553b(context);
                    TbsLog.m2155i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:" + i);
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-516);
                    SharedPreferences.Editor edit = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4).edit();
                    edit.putInt("tbs_preload_x5_counter", 0);
                    edit.putInt("tbs_preload_x5_recorder", 0);
                    edit.putInt("tbs_preload_x5_version", i);
                    edit.commit();
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-517);
                    if (i == 88888888) {
                        m2502a(i, str, context);
                    }
                    if (this.f2197k) {
                        tbsLogReport = TbsLogReport.getInstance(context);
                        m2433v = m2433v(context);
                        str3 = "continueInstallWithout core success";
                    } else {
                        tbsLogReport = TbsLogReport.getInstance(context);
                        m2433v = m2433v(context);
                        str3 = "success";
                    }
                    tbsLogReport.setInstallErrorCode(m2433v, str3);
                } else if (m2518c == i2) {
                    QbSdk.f1753n.onInstallFinish(200);
                }
                try {
                    f2186i.unlock();
                    f2187j.unlock();
                } catch (Exception e21) {
                    e21.printStackTrace();
                }
                try {
                    m2482b();
                } catch (Exception e22) {
                    e22.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    f2186i.unlock();
                    f2187j.unlock();
                } catch (Exception e23) {
                    e23.printStackTrace();
                }
                try {
                    m2482b();
                } catch (Exception e24) {
                    e24.printStackTrace();
                }
                throw th;
            }
        }
    }

    /* renamed from: b */
    private boolean m2477b(Context context, File file) {
        return m2493a(context, file, false);
    }

    /* renamed from: c */
    private int m2469c(Context context, Bundle bundle) {
        int i;
        int i2;
        int m2486a;
        TbsLogReport tbsLogReport;
        int i3;
        TbsDownloadConfig tbsDownloadConfig;
        try {
            Bundle m2835a = QbSdk.m2835a(context, bundle);
            TbsLog.m2155i("TbsInstaller", "tpatch finished,ret is" + m2835a);
            i = m2835a.getInt("patch_result");
            try {
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                TbsLogReport tbsLogReport2 = TbsLogReport.getInstance(context);
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("patch exception");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(e));
                tbsLogReport2.setInstallErrorCode(TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                return 1;
            }
        } catch (Exception e2) {
            e = e2;
        }
        if (i != 0) {
            String string = bundle.getString("new_apk_location");
            if (!TextUtils.isEmpty(string)) {
                FileUtil.m2175b(new File(string));
            }
            TbsLogReport.getInstance(context).setInstallErrorCode(i, "tpatch fail,patch error_code=" + i);
            return 1;
        }
        String string2 = bundle.getString("new_apk_location");
        int i4 = bundle.getInt("new_core_ver");
        try {
            i2 = bundle.getInt("for_stable_core");
        } catch (Throwable unused) {
            i2 = 0;
        }
        if (i2 == 1) {
            File file = new File(FileUtil.m2195a(context, TbsConfig.APP_WX, 4, true));
            int i5 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_CPUTYPE_OTHER_STABLE_CORE, 0);
            File[] listFiles = file.listFiles();
            Pattern compile = Pattern.compile(C1428a.m2133a(false, i5));
            int length = listFiles.length;
            int i6 = 0;
            while (i6 < length) {
                File file2 = listFiles[i6];
                File[] fileArr = listFiles;
                if (compile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                    file2.delete();
                }
                i6++;
                listFiles = fileArr;
            }
            File file3 = new File(file, C1428a.m2133a(false, i5) + "." + tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
            if (!file3.exists()) {
                file3.createNewFile();
            }
            m2486a = TbsShareManager.getTbsStableCoreVersion(context, i5);
            C1472q.m1981b(context, "tpatch_mid_bundle_ok", ("patchVersion=is=" + m2486a) + "_targetVersion=is=" + i4);
        } else {
            m2486a = m2486a(new File(string2));
            if (TbsShareManager.isThirdPartyApp(context)) {
                C1472q.m1986a(context, "tpatch_mid_bundle_ok", ("patchVersion=is=" + m2486a) + "_targetVersion=is=" + i4);
            }
        }
        TbsLog.m2155i("TbsInstaller", "doTpatch wholeFile is " + i2 + " version is " + i4 + " patchVersion is " + m2486a);
        if (i4 != m2486a) {
            TbsLog.m2155i("TbsInstaller", "version not equals!!!" + i4 + "patchVersion:" + m2486a);
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.TPATCH_VERSION_FAILED, "version=" + i4 + ",patchVersion=" + m2486a);
            return 1;
        }
        if (i2 == 1) {
            C1472q.m1981b(context, "tpatch_last_bundle_ok", "coreversion=is=" + m2486a);
        }
        if (TbsShareManager.isThirdPartyApp(context)) {
            C1472q.m1986a(context, "tpatch_last_bundle_ok", "coreversion=is=" + m2486a);
        }
        if (TbsDownloader.m2809a(context)) {
            TbsLog.m2155i("TbsInstaller", "Tpatch decouple success!");
            tbsLogReport = TbsLogReport.getInstance(context);
            i3 = TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS;
        } else {
            TbsLog.m2155i("TbsInstaller", "Tpatch success!");
            tbsLogReport = TbsLogReport.getInstance(context);
            i3 = TbsListener.ErrorCode.TPATCH_INSTALL_SUCCESS;
        }
        tbsLogReport.setInstallErrorCode(i3, "");
        return 0;
    }

    /* renamed from: c */
    private boolean m2468c(Context context, File file) {
        try {
            File[] listFiles = file.listFiles(new FileFilter() { // from class: com.tencent.smtt.sdk.p.5
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    return file2.getName().endsWith(".jar");
                }
            });
            int length = listFiles.length;
            ClassLoader classLoader = context.getClassLoader();
            for (int i = 0; i < length; i++) {
                TbsLog.m2155i("TbsInstaller", "jarFile: " + listFiles[i].getAbsolutePath());
                new DexClassLoader(listFiles[i].getAbsolutePath(), file.getAbsolutePath(), null, classLoader);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(209, e.toString());
            TbsLog.m2155i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return false;
        }
    }

    /* renamed from: c */
    private synchronized boolean m2466c(Context context, boolean z) {
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch");
        boolean z2 = false;
        if (!m2434u(context)) {
            return false;
        }
        boolean tryLock = f2186i.tryLock();
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch Locked =" + tryLock);
        if (tryLock) {
            int m2519b = C1379n.m2526a(context).m2519b("tpatch_status");
            int m2483a = m2483a(false, context);
            TbsLog.m2155i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch copyStatus =" + m2519b);
            TbsLog.m2155i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer =" + m2483a);
            if (m2519b == 1) {
                if (m2483a == 0) {
                    TbsLog.m2153i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer = 0", true);
                } else if (z) {
                    TbsLog.m2153i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer != 0", true);
                }
                m2429z(context);
                z2 = true;
            }
            f2186i.unlock();
        }
        m2482b();
        return z2;
    }

    /* renamed from: d */
    private boolean m2463d(Context context, File file) {
        File[] listFiles;
        try {
            File file2 = new File(file, "tbs_sdk_extension_dex.jar");
            File file3 = new File(file, "tbs_sdk_extension_dex.dex");
            new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            String m2604a = C1362f.m2604a(context, file3.getAbsolutePath());
            if (TextUtils.isEmpty(m2604a)) {
                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DEXOAT_EXCEPTION, "can not find oat command");
                return false;
            }
            for (File file4 : file.listFiles(new FileFilter() { // from class: com.tencent.smtt.sdk.p.6
                @Override // java.io.FileFilter
                public boolean accept(File file5) {
                    return file5.getName().endsWith(".jar");
                }
            })) {
                String substring = file4.getName().substring(0, file4.getName().length() - 4);
                Runtime.getRuntime().exec("/system/bin/dex2oat " + m2604a.replaceAll("tbs_sdk_extension_dex", substring) + " --dex-location=" + m2503a().m2437r(context) + File.separator + substring + ".jar").waitFor();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DEXOAT_EXCEPTION, e);
            return false;
        }
    }

    /* renamed from: d */
    private synchronized boolean m2461d(Context context, boolean z) {
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy");
        boolean z2 = false;
        if (!m2434u(context)) {
            return false;
        }
        boolean tryLock = f2186i.tryLock();
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy Locked =" + tryLock);
        if (tryLock) {
            int m2519b = C1379n.m2526a(context).m2519b("copy_status");
            int m2483a = m2483a(false, context);
            TbsLog.m2155i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy copyStatus =" + m2519b);
            TbsLog.m2155i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer =" + m2483a);
            if (m2519b == 1) {
                if (m2483a == 0) {
                    TbsLog.m2153i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer = 0", true);
                } else if (z) {
                    TbsLog.m2153i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer != 0", true);
                }
                m2509A(context);
                z2 = true;
            }
            f2186i.unlock();
        }
        m2482b();
        return z2;
    }

    /* renamed from: e */
    private boolean m2458e(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    /* renamed from: e */
    private synchronized boolean m2457e(Context context, boolean z) {
        if (context != null) {
            if (TbsConfig.APP_WX.equals(StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().packageName)) {
                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INSTALL_FROM_UNZIP, StringUtils.SPACE);
            }
        }
        TbsLog.m2154i("TbsInstaller", "enableTbsCoreFromUnzip", "canRenameTmpDir =" + z);
        TbsLog.m2154i("TbsInstaller", "enableTbsCoreFromUnzip", "#1#");
        boolean z2 = false;
        try {
        } catch (Exception e) {
            QbSdk.m2833a(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + e);
            e.printStackTrace();
        }
        if (!m2434u(context)) {
            return false;
        }
        TbsLog.m2154i("TbsInstaller", "enableTbsCoreFromUnzip", "#2# getInstallFileLock Success!!");
        boolean tryLock = f2186i.tryLock();
        TbsLog.m2154i("TbsInstaller", "enableTbsCoreFromUnzip", "locked=" + tryLock);
        if (tryLock) {
            try {
                int m2518c = C1379n.m2526a(context).m2518c();
                TbsLog.m2155i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + m2518c);
                int m2483a = m2483a(false, context);
                if (m2518c == 2) {
                    TbsLog.m2154i("TbsInstaller", "enableTbsCoreFromUnzip", "#4# In Rename Logic");
                    if (m2483a == 0) {
                        TbsLog.m2153i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
                    } else if (z) {
                        TbsLog.m2153i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
                    }
                    m2430y(context);
                    z2 = true;
                }
                f2186i.unlock();
            } catch (Throwable th) {
                f2186i.unlock();
                throw th;
            }
        }
        m2482b();
        return z2;
    }

    /* renamed from: f */
    private synchronized boolean m2454f(Context context, boolean z) {
        return false;
    }

    /* renamed from: g */
    private void m2451g(Context context, boolean z) {
        if (context == null) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, "setTmpFolderCoreToRead context is null");
            TbsLog.m2155i("TbsInstaller", "setTmpFolderCoreToRead inner return #01");
            return;
        }
        try {
            File file = new File(QbSdk.getTbsFolderDir(context), "tmp_folder_core_to_read.conf");
            if (!z) {
                TbsLog.m2155i("TbsInstaller", "setTmpFolderCoreToRead inner tmp file delete #01");
                FileUtil.m2175b(file);
            } else if (file.exists()) {
                TbsLog.m2155i("TbsInstaller", "setTmpFolderCoreToRead inner tmp file already exist #01");
            } else {
                TbsLog.m2155i("TbsInstaller", "setTmpFolderCoreToRead inner tmp file create #01");
                file.createNewFile();
            }
        } catch (Exception e) {
            TbsLogReport tbsLogReport = TbsLogReport.getInstance(context);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("setTmpFolderCoreToRead Exception message is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" Exception cause is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getCause());
            tbsLogReport.setInstallErrorCode(TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            TbsLog.m2155i("TbsInstaller", "setTmpFolderCoreToRead inner exception #01");
        }
    }

    /* renamed from: h */
    private void m2449h(Context context, int i) {
        TbsLog.m2155i("TbsInstaller", "proceedTpatchStatus,result=" + i);
        if (i == 0) {
            if (TbsDownloader.m2809a(context)) {
                m2447i(context, 6);
            } else {
                TbsLog.m2155i("TbsInstaller", "setTmpFolderCoreToRead call #03");
                m2451g(context, true);
                C1379n.m2526a(context).m2520b(TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0), 1);
            }
        }
        QbSdk.setTBSInstallingStatus(false);
    }

    /* renamed from: i */
    private void m2447i(Context context, int i) {
        File m2455f = m2503a().m2455f(context, i);
        TbsLog.m2155i("TbsInstaller", "setTmpFolderCoreToRead call #06");
        m2503a().m2451g(context, true);
        File m2438q = m2438q(context);
        FileUtil.m2188a(m2438q, true);
        m2455f.renameTo(m2438q);
        TbsShareManager.m2732b(context);
    }

    /* renamed from: j */
    private boolean m2445j(Context context, int i) {
        File m2455f;
        boolean z;
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-doTbsDexOpt start - dirMode: " + i);
        boolean z2 = false;
        try {
            if (i != 0) {
                if (i == 1) {
                    m2455f = m2455f(context, 1);
                } else if (i != 2) {
                    TbsLog.m2158e("TbsInstaller", "doDexoptOrDexoat mode error: " + i);
                    return false;
                } else {
                    m2455f = m2437r(context);
                }
            } else if (TbsDownloader.m2809a(context)) {
                return true;
            } else {
                m2455f = m2455f(context, 0);
            }
            String property = System.getProperty("java.vm.version");
            z = property != null && property.startsWith(ExifInterface.GPS_MEASUREMENT_2D);
            boolean z3 = Build.VERSION.SDK_INT == 23;
            boolean z4 = TbsDownloadConfig.getInstance(context).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_STOP_PRE_OAT, false);
            if (z && z3 && !z4) {
                z2 = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport.getInstance(context).setInstallErrorCode(209, e.toString());
        }
        if (z2 && m2463d(context, m2455f)) {
            TbsLog.m2155i("TbsInstaller", "doTbsDexOpt -- doDexoatForArtVm");
            return true;
        } else if (!z) {
            TbsLog.m2155i("TbsInstaller", "doTbsDexOpt -- doDexoptForDavlikVM");
            return m2468c(context, m2455f);
        } else {
            TbsLog.m2155i("TbsInstaller", "doTbsDexOpt -- is ART mode, skip!");
            TbsLog.m2155i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return true;
        }
    }

    /* renamed from: t */
    public static File m2435t(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    /* renamed from: v */
    private int m2433v(Context context) {
        boolean z = true;
        if (C1379n.m2526a(context).m2514d() != 1) {
            z = false;
        }
        boolean m2809a = TbsDownloader.m2809a(context);
        if (z) {
            return m2809a ? TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS : TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS;
        } else if (!m2809a) {
            return 200;
        } else {
            return TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS;
        }
    }

    /* renamed from: w */
    public static boolean m2432w(Context context) {
        String str;
        if (context == null) {
            str = "#1#";
        } else {
            try {
                if (new File(QbSdk.getTbsFolderDir(context), "tmp_folder_core_to_read.conf").exists()) {
                    TbsLog.m2154i("TbsInstaller", "getTmpFolderCoreToRead", "#2#");
                    return true;
                }
                TbsLog.m2154i("TbsInstaller", "getTmpFolderCoreToRead", "#3#");
                return false;
            } catch (Exception unused) {
                str = "#4#";
            }
        }
        TbsLog.m2154i("TbsInstaller", "getTmpFolderCoreToRead", str);
        return true;
    }

    /* renamed from: x */
    private boolean m2431x(Context context) {
        TbsLog.m2155i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
        FileLock m2166f = FileUtil.m2166f(context);
        f2188l = m2166f;
        if (m2166f == null) {
            TbsLog.m2155i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
            return false;
        }
        TbsLog.m2155i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
        return true;
    }

    /* renamed from: y */
    private void m2430y(Context context) {
        TbsLog.m2155i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        if (!m2431x(context)) {
            TbsLog.m2155i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            m2508B(context);
            m2507C(context);
            TbsLog.m2155i("TbsInstaller", "after renameTbsCoreShareDir");
            if (!TbsShareManager.isThirdPartyApp(context)) {
                TbsLog.m2155i("TbsInstaller", "prepare to shareTbsCore");
                TbsShareManager.m2737a(context);
            } else {
                TbsLog.m2155i("TbsInstaller", "is thirdapp and not chmod");
            }
            C1379n.m2526a(context).m2528a(0);
            C1379n.m2526a(context).m2521b(0);
            C1379n.m2526a(context).m2513d(0);
            C1379n.m2526a(context).m2524a("incrupdate_retry_num", 0);
            C1379n.m2526a(context).m2516c(0, 3);
            C1379n.m2526a(context).m2525a("");
            C1379n.m2526a(context).m2524a("tpatch_num", 0);
            C1379n.m2526a(context).m2517c(-1);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                int i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i <= 0 || i == m2503a().m2448i(context) || i != m2503a().m2446j(context)) {
                    TbsLog.m2155i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is " + i + " getTbsCoreShareDecoupleCoreVersion is " + m2503a().m2448i(context) + " getTbsCoreInstalledVerInNolock is " + m2503a().m2446j(context));
                } else {
                    m2440o(context);
                }
            }
            if (TbsShareManager.isThirdPartyApp(context)) {
                TbsShareManager.writeCoreInfoForThirdPartyApp(context, m2441n(context), true);
            }
            f2182a.set(0);
            f2191o = 0;
        } catch (Throwable th) {
            th.printStackTrace();
            TbsLogReport tbsLogReport = TbsLogReport.getInstance(context);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("exception when renameing from unzip:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.toString());
            tbsLogReport.setInstallErrorCode(TbsListener.ErrorCode.RENAME_EXCEPTION, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            TbsLog.m2156e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        }
        m2450h(context);
    }

    /* renamed from: z */
    private void m2429z(Context context) {
        TbsLog.m2155i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromTpatch");
        if (!m2431x(context)) {
            TbsLog.m2155i("TbsInstaller", "get rename fileLock#4 ## failed!");
            return;
        }
        try {
            m2508B(context);
            m2505E(context);
            if (TbsShareManager.isThirdPartyApp(context)) {
                TbsShareManager.writeCoreInfoForThirdPartyApp(context, m2441n(context), true);
            } else {
                TbsShareManager.m2737a(context);
            }
            C1379n.m2526a(context).m2520b(0, -1);
            C1379n.m2526a(context).m2524a("tpatch_num", 0);
            f2182a.set(0);
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport tbsLogReport = TbsLogReport.getInstance(context);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("exception when renameing from tpatch:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.toString());
            tbsLogReport.setInstallErrorCode(TbsListener.ErrorCode.TPATCH_ENABLE_EXCEPTION, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        m2450h(context);
    }

    /* renamed from: a */
    public int m2486a(File file) {
        BufferedInputStream bufferedInputStream = null;
        try {
            TbsLog.m2155i("TbsInstaller", "TbsInstaller--getTbsVersion  tbsShareDir is " + file);
            File file2 = new File(file, "tbs.conf");
            if (!file2.exists()) {
                return 0;
            }
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
            try {
                properties.load(bufferedInputStream2);
                bufferedInputStream2.close();
                String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return 0;
                }
                int parseInt = Integer.parseInt(property);
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
                return parseInt;
            } catch (Exception unused3) {
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return 0;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        } catch (Exception unused6) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public int m2484a(String str) {
        if (str == null) {
            return 0;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            File file = new File(new File(str), "tbs.conf");
            if (!file.exists()) {
                return 0;
            }
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream2);
                bufferedInputStream2.close();
                String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return 0;
                }
                int parseInt = Integer.parseInt(property);
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
                return parseInt;
            } catch (Exception unused3) {
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return 0;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        } catch (Exception unused6) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public int m2483a(boolean z, Context context) {
        if (z || f2182a.get().intValue() <= 0) {
            f2182a.set(Integer.valueOf(m2446j(context)));
        }
        return f2182a.get().intValue();
    }

    /* renamed from: a */
    public File m2499a(Context context, int i, boolean z) {
        String str;
        String str2;
        File tbsFolderDir = QbSdk.getTbsFolderDir(context);
        switch (i) {
            case 0:
                str = "core_unzip_tmp";
                break;
            case 1:
                str = "core_copy_tmp";
                break;
            case 2:
                str = "core_unzip_tmp_decouple";
                break;
            case 3:
                str = "core_share_backup";
                break;
            case 4:
                str = "core_share_backup_tmp";
                break;
            case 5:
                str = "tpatch_tmp";
                break;
            case 6:
                str = "tpatch_decouple_tmp";
                break;
            default:
                str = "";
                break;
        }
        TbsLog.m2155i("TbsInstaller", "type=" + i + "needMakeDir=" + z + "folder=" + str);
        File file = new File(tbsFolderDir, str);
        if (!file.isDirectory()) {
            if (!z) {
                str2 = "getCoreDir,no need mkdir";
            } else if (!file.mkdir()) {
                str2 = "getCoreDir,mkdir false";
            }
            TbsLog.m2155i("TbsInstaller", str2);
            return null;
        }
        return file;
    }

    /* renamed from: a */
    public File m2495a(Context context, File file) {
        File file2 = new File(file, "core_share_decouple");
        if (file2.isDirectory() || file2.mkdir()) {
            return file2;
        }
        return null;
    }

    /* renamed from: a */
    public void m2500a(Context context, int i) {
        TbsLog.m2155i("TbsInstaller", "setTmpFolderCoreToRead call #01 ");
        m2451g(context, true);
        C1379n.m2526a(context).m2516c(i, 2);
    }

    /* renamed from: a */
    public void m2496a(Context context, Bundle bundle) {
        if (bundle == null || context == null) {
            return;
        }
        Object[] objArr = {context, bundle};
        Message message = new Message();
        message.what = 3;
        message.obj = objArr;
        f2189m.sendMessage(message);
    }

    /* renamed from: a */
    public void m2494a(Context context, File file, int i) {
        TbsLog.m2155i("TbsInstaller", "unzipTbsCoreToThirdAppTmp,ctx=" + context + "File=" + file + "coreVersion=" + i);
        if (file == null || context == null) {
            return;
        }
        Object[] objArr = {context, file, Integer.valueOf(i)};
        Message message = new Message();
        message.what = 4;
        message.obj = objArr;
        f2189m.sendMessage(message);
    }

    /* renamed from: a */
    public void m2491a(Context context, String str, int i) {
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + str);
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + i);
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + Process.myPid());
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
        Object[] objArr = {context, str, Integer.valueOf(i)};
        Message message = new Message();
        message.what = 1;
        message.obj = objArr;
        f2189m.sendMessage(message);
    }

    /* renamed from: a */
    public void m2490a(Context context, boolean z) {
        int m2518c;
        int m2522b;
        String m2512d;
        int m2515c;
        int m2519b;
        boolean z2 = true;
        if (z) {
            this.f2197k = true;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller-continueInstallTbsCore currentProcessName=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(context.getApplicationInfo().processName);
        TbsLog.m2155i("TbsInstaller", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (!m2434u(context)) {
            return;
        }
        if (f2186i.tryLock()) {
            try {
                m2518c = C1379n.m2526a(context).m2518c();
                m2522b = C1379n.m2526a(context).m2522b();
                m2512d = C1379n.m2526a(context).m2512d("install_apk_path");
                m2515c = C1379n.m2526a(context).m2515c("copy_core_ver");
                m2519b = C1379n.m2526a(context).m2519b("copy_status");
            } finally {
                f2186i.unlock();
            }
        } else {
            m2515c = 0;
            m2519b = -1;
            m2512d = null;
            m2518c = -1;
            m2522b = 0;
        }
        m2482b();
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + m2518c);
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + m2522b);
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + m2512d);
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + m2515c);
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + m2519b);
        if (TbsShareManager.isThirdPartyApp(context)) {
            m2471c(context, TbsShareManager.m2733a(context, false));
            return;
        }
        int i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
        if (i != 1 && i != 2 && i != 4) {
            z2 = false;
        }
        if (!z2 && i != 0 && i != 5) {
            Bundle bundle = new Bundle();
            bundle.putInt("operation", 10001);
            m2496a(context, bundle);
        }
        if (m2518c > -1 && m2518c < 2) {
            m2491a(context, m2512d, m2522b);
        }
        if (m2519b != 0) {
            return;
        }
        m2480b(context, m2515c);
    }

    /* renamed from: a */
    public synchronized boolean m2498a(final Context context, final Context context2) {
        TbsLog.m2155i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp");
        if (f2192p) {
            return true;
        }
        f2192p = true;
        new Thread() { // from class: com.tencent.smtt.sdk.p.4

            /* renamed from: com.tencent.smtt.sdk.p$4$1 */
            /* loaded from: classes4.dex */
            public class C13861 implements FileFilter {
                public C13861() {
                }

                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.getName().endsWith(MultiDexExtractor.DEX_SUFFIX);
                }
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                C1381p c1381p;
                Context context3;
                File m2437r;
                TbsLog.m2155i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
                try {
                    if (context2 == null) {
                        m2437r = new File(TbsShareManager.getHostCorePathAppDefined());
                    } else {
                        if (!TbsShareManager.isThirdPartyApp(context)) {
                            c1381p = C1381p.this;
                            context3 = context2;
                        } else if (TbsShareManager.m2730c(context) == null || !TbsShareManager.m2730c(context).contains("decouple")) {
                            c1381p = C1381p.this;
                            context3 = context2;
                        } else {
                            m2437r = C1381p.this.m2438q(context2);
                        }
                        m2437r = c1381p.m2437r(context3);
                    }
                    FileUtil.m2190a(m2437r, C1381p.this.m2437r(context), new FileFilter() { // from class: com.tencent.smtt.sdk.p.4.2
                        @Override // java.io.FileFilter
                        public boolean accept(File file) {
                            return file.getName().endsWith("tbs.conf");
                        }
                    });
                    TbsLog.m2155i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return true;
    }

    /* renamed from: a */
    public boolean m2489a(Context context, File[] fileArr) {
        return false;
    }

    /* renamed from: b */
    public int m2481b(Context context) {
        if (m2432w(context)) {
            if (m2492a(context, "core_unzip_tmp")) {
                return -1;
            }
            if (m2492a(context, "core_share_backup_tmp")) {
                return -2;
            }
            if (m2492a(context, "core_copy_tmp")) {
                return -3;
            }
            return m2492a(context, "tpatch_tmp") ? -4 : 1;
        }
        return 0;
    }

    /* renamed from: b */
    public Context m2475b(Context context, String str) {
        try {
            if (context.getPackageName() != str && TbsPVConfig.getInstance(context).isEnableNoCoreGray()) {
                return null;
            }
            return context.createPackageContext(str, 2);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public File m2479b(Context context, Context context2) {
        File file = new File(QbSdk.getTbsFolderDir(context2), "core_share");
        if (file.isDirectory() || ((context != null && TbsShareManager.isThirdPartyApp(context)) || file.mkdir())) {
            return file;
        }
        TbsLog.m2155i("TbsInstaller", "getTbsCoreShareDir,mkdir false");
        return null;
    }

    /* renamed from: b */
    public synchronized void m2482b() {
        if (this.f2193e <= 0) {
            TbsLog.m2155i("TbsInstaller", "releaseTbsInstallingFileLock currentTbsFileLockStackCount=" + this.f2193e + "call stack:" + Log.getStackTraceString(new Throwable()));
        } else if (this.f2193e > 1) {
            TbsLog.m2155i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
            this.f2193e--;
        } else {
            if (this.f2193e == 1) {
                TbsLog.m2155i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
                FileUtil.m2179a(this.f2194f, this.f2195g);
                this.f2193e = 0;
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 18, insn: 0x024f: MOVE  (r7 I:??[OBJECT, ARRAY]) = (r18 I:??[OBJECT, ARRAY]), block:B:189:0x0241 */
    /* JADX WARN: Removed duplicated region for block: B:116:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x057f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0656  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x030f  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m2478b(Context context, Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Bundle bundle2;
        int i;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2;
        String str9;
        File file;
        TbsLogReport tbsLogReport;
        String str10;
        int i3;
        String str11;
        TbsLogReport tbsLogReport2;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i4;
        Bundle bundle3;
        int i5;
        int i6;
        Bundle bundle4;
        String str12;
        String str13;
        int i7;
        Bundle bundle5;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        int i8;
        File file2;
        int i9;
        int i10;
        int m2515c;
        String str14;
        TbsLogReport tbsLogReport3;
        StringBuilder sb;
        Bundle bundle6;
        TbsLogReport tbsLogReport4;
        StringBuilder sb2;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller installLocalTbsCoreExInThreadthread ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(Thread.currentThread().getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(Log.getStackTraceString(new Throwable()));
        TbsLog.m2155i("TbsInstaller", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
        if (m2465d(context)) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-539);
            return;
        }
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread");
        if (bundle == null || context == null) {
            return;
        }
        if (!FileUtil.m2178b(context)) {
            long m1991a = C1472q.m1991a();
            long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
            TbsLogReport.getInstance(context).setInstallErrorCode(210, "rom is not enough when patching tbs core! curAvailROM=" + m1991a + ",minReqRom=" + downloadMinFreeSpace);
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-540);
        } else if (!m2434u(context)) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-541);
        } else {
            boolean tryLock = f2187j.tryLock();
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller-installLocalTesCoreExInThread locked=", tryLock, "TbsInstaller");
            if (!tryLock) {
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-547);
                m2482b();
                return;
            }
            int i11 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
            try {
                QbSdk.setTBSInstallingStatus(true);
            } catch (Exception e) {
                e = e;
                str = TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION;
                str2 = "apk_path";
                str3 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                str4 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                str5 = "incrUpdate fail! patch ret=";
                str6 = "decouple incrUpdate fail! patch ret=";
                str7 = "PATCH_SUCCESS tbsCorVer is ";
            } catch (Throwable th) {
                th = th;
                str = TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION;
                str2 = "apk_path";
                str3 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                str4 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                str5 = "incrUpdate fail! patch ret=";
                str6 = "decouple incrUpdate fail! patch ret=";
                str7 = "PATCH_SUCCESS tbsCorVer is ";
            }
            if (i11 == 5 || i11 == 3) {
                str3 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                str4 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                str5 = "incrUpdate fail! patch ret=";
                str6 = "decouple incrUpdate fail! patch ret=";
                str7 = "PATCH_SUCCESS tbsCorVer is ";
                try {
                    i = m2469c(context, bundle);
                    str8 = "tbs_core_ver";
                    try {
                        StringBuilder sb3 = new StringBuilder();
                        str = TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION;
                        try {
                            try {
                                sb3.append("TbsInstaller-installLocalTesCoreExInThread doTpatch result is ");
                                sb3.append(i);
                                TbsLog.m2155i("TbsInstaller", sb3.toString());
                                if (i == 1) {
                                    try {
                                        str2 = "apk_path";
                                    } catch (Exception e2) {
                                        e = e2;
                                        str2 = "apk_path";
                                        bundle2 = null;
                                        try {
                                            TbsLog.m2155i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + Log.getStackTraceString(e));
                                            e.printStackTrace();
                                            try {
                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e.toString());
                                                f2187j.unlock();
                                                m2482b();
                                                if (i11 == 5) {
                                                    m2449h(context, 1);
                                                    return;
                                                }
                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                                TbsLog.m2155i("TbsInstaller", str3);
                                                TbsDownloadConfig.getInstance(context).mSyncMap.put(str4, true);
                                                TbsDownloadConfig.getInstance(context).commit();
                                                if (TbsDownloader.m2809a(context)) {
                                                    tbsLogReport = TbsLogReport.getInstance(context);
                                                    str10 = "decouple incrUpdate fail! patch ret=1";
                                                    i3 = TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL;
                                                } else {
                                                    tbsLogReport = TbsLogReport.getInstance(context);
                                                    str10 = "incrUpdate fail! patch ret=1";
                                                    i3 = TbsListener.ErrorCode.INCR_UPDATE_FAIL;
                                                }
                                                tbsLogReport.setInstallErrorCode(i3, str10);
                                                QbSdk.setTBSInstallingStatus(false);
                                                return;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                i = 1;
                                                f2187j.unlock();
                                                m2482b();
                                                if (i11 != 5) {
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                    }
                                    try {
                                        C1379n.m2526a(context).m2524a("tpatch_num", C1379n.m2526a(context).m2515c("tpatch_num") + 1);
                                        String string = bundle.getString("core_type_tpatch");
                                        if (string.equals("stable_core_0")) {
                                            if (C1429b.m2121b()) {
                                                C1379n.m2526a(context).m2524a("stable_64_tpatch_fail", 1);
                                                str11 = "TbsInstaller-installLocalTesCoreExInThread doTpatch set result TBS_CORE_STABLE_TPATCH_FAIL_64 is 1";
                                            } else {
                                                C1379n.m2526a(context).m2524a("stable_32_tpatch_fail", 1);
                                                str11 = "TbsInstaller-installLocalTesCoreExInThread doTpatch set result TBS_CORE_STABLE_TPATCH_FAIL_32 is 1";
                                            }
                                        } else if (string.equals("stable_core_32")) {
                                            C1379n.m2526a(context).m2524a("stable_32_tpatch_fail", 1);
                                            str11 = "TbsInstaller-installLocalTesCoreExInThread doTpatch set result TBS_CORE_STABLE_TPATCH_FAIL_32 is 1";
                                        } else if (string.equals("stable_core_64")) {
                                            C1379n.m2526a(context).m2524a("stable_64_tpatch_fail", 1);
                                            str11 = "TbsInstaller-installLocalTesCoreExInThread doTpatch set result TBS_CORE_STABLE_TPATCH_FAIL_64 is 1";
                                        }
                                        TbsLog.m2155i("TbsInstaller", str11);
                                    } catch (Exception e3) {
                                        e = e3;
                                        bundle2 = null;
                                        TbsLog.m2155i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + Log.getStackTraceString(e));
                                        e.printStackTrace();
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e.toString());
                                        f2187j.unlock();
                                        m2482b();
                                        if (i11 == 5) {
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        bundle2 = null;
                                        f2187j.unlock();
                                        m2482b();
                                        if (i11 != 5) {
                                        }
                                    }
                                }
                                f2187j.unlock();
                                m2482b();
                                if (i11 == 5) {
                                    m2449h(context, i);
                                } else if (i == 0) {
                                    TbsLog.m2155i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                    C1379n.m2526a(context).m2524a("incrupdate_retry_num", 0);
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                    C1379n.m2526a(context).m2516c(0, -1);
                                    C1379n.m2526a(context).m2517c(1);
                                    throw null;
                                } else {
                                    if (i == 2) {
                                        TbsLog.m2155i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                    } else {
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                        TbsLog.m2155i("TbsInstaller", str3);
                                        TbsDownloadConfig.getInstance(context).mSyncMap.put(str4, true);
                                        TbsDownloadConfig.getInstance(context).commit();
                                        if (TbsDownloader.m2809a(context)) {
                                            tbsLogReport2 = TbsLogReport.getInstance(context);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str6, i);
                                            i4 = TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL;
                                        } else {
                                            tbsLogReport2 = TbsLogReport.getInstance(context);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str5, i);
                                            i4 = TbsListener.ErrorCode.INCR_UPDATE_FAIL;
                                        }
                                        tbsLogReport2.setInstallErrorCode(i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                    }
                                    QbSdk.setTBSInstallingStatus(false);
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                str2 = "apk_path";
                                bundle2 = null;
                                f2187j.unlock();
                                m2482b();
                                if (i11 != 5) {
                                    m2449h(context, i);
                                    return;
                                }
                                if (i == 0) {
                                    TbsLog.m2155i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                    C1379n.m2526a(context).m2524a("incrupdate_retry_num", 0);
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                    C1379n.m2526a(context).m2516c(0, -1);
                                    C1379n.m2526a(context).m2517c(1);
                                    String string2 = bundle2.getString(str2);
                                    if (C1472q.m1982b(context)) {
                                        int i12 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(str, 0);
                                        str9 = str8;
                                        int i13 = bundle2.getInt(str9);
                                        TbsLog.m2155i("TbsInstaller", str7 + i13 + " stableCoreVersionServer is " + i12);
                                        if (i13 == i12) {
                                            TbsLog.m2155i(TbsDownloader.LOGTAG, "PATCH_SUCCESS backup");
                                            file = new File(string2);
                                        }
                                        m2474b(context, string2, bundle2.getInt(str9));
                                        if (TbsDownloader.m2809a(context)) {
                                            C1379n.m2526a(context).m2517c(-1);
                                        }
                                    } else {
                                        str9 = str8;
                                        file = new File(string2);
                                    }
                                    C1377m.m2562a(file, context);
                                    m2474b(context, string2, bundle2.getInt(str9));
                                    if (TbsDownloader.m2809a(context)) {
                                    }
                                } else if (i != 2) {
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                    TbsLog.m2155i("TbsInstaller", str3);
                                    TbsDownloadConfig.getInstance(context).mSyncMap.put(str4, true);
                                    TbsDownloadConfig.getInstance(context).commit();
                                    boolean m2809a = TbsDownloader.m2809a(context);
                                    TbsLogReport tbsLogReport5 = TbsLogReport.getInstance(context);
                                    if (m2809a) {
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str6, i);
                                        i2 = TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL;
                                    } else {
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str5, i);
                                        i2 = TbsListener.ErrorCode.INCR_UPDATE_FAIL;
                                    }
                                    tbsLogReport5.setInstallErrorCode(i2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                } else {
                                    TbsLog.m2155i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                }
                                QbSdk.setTBSInstallingStatus(false);
                                throw th;
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        str = TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION;
                    } catch (Throwable th6) {
                        th = th6;
                        str = TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION;
                    }
                } catch (Exception e6) {
                    e = e6;
                    str = TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION;
                    str2 = "apk_path";
                    str8 = "tbs_core_ver";
                    bundle2 = null;
                    i = 2;
                    TbsLog.m2155i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + Log.getStackTraceString(e));
                    e.printStackTrace();
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e.toString());
                    f2187j.unlock();
                    m2482b();
                    if (i11 == 5) {
                    }
                } catch (Throwable th7) {
                    th = th7;
                    str = TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION;
                    str2 = "apk_path";
                    str8 = "tbs_core_ver";
                    bundle2 = null;
                    i = 2;
                    f2187j.unlock();
                    m2482b();
                    if (i11 != 5) {
                    }
                }
            } else {
                try {
                } catch (Exception e7) {
                    e = e7;
                    str3 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                    str4 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                    str5 = "incrUpdate fail! patch ret=";
                    str6 = "decouple incrUpdate fail! patch ret=";
                    i6 = 2;
                    bundle4 = null;
                } catch (Throwable th8) {
                    th = th8;
                    str3 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                    str4 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                    str5 = "incrUpdate fail! patch ret=";
                    str6 = "decouple incrUpdate fail! patch ret=";
                    bundle3 = null;
                    i5 = 2;
                }
                if (m2446j(context) > 0) {
                    if (C1379n.m2526a(context).m2514d() != 1) {
                        if ((i11 == 1 || i11 == 2 || i11 == 4) || i11 == 0) {
                            str12 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                        } else {
                            try {
                                m2515c = C1379n.m2526a(context).m2515c("incrupdate_retry_num");
                            } catch (Exception e8) {
                                e = e8;
                                str12 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                            } catch (Throwable th9) {
                                th = th9;
                                str12 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                                str13 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                bundle5 = null;
                                i9 = 2;
                            }
                            try {
                            } catch (Exception e9) {
                                e = e9;
                                str13 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                i10 = 2;
                                bundle5 = null;
                                str5 = "incrUpdate fail! patch ret=";
                                str6 = "decouple incrUpdate fail! patch ret=";
                                bundle4 = bundle5;
                                i6 = i10;
                                str3 = str12;
                                str4 = str13;
                                str = TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION;
                                str2 = "apk_path";
                                bundle2 = bundle4;
                                str8 = "tbs_core_ver";
                                int i14 = i6;
                                str7 = "PATCH_SUCCESS tbsCorVer is ";
                                i = i14;
                                TbsLog.m2155i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + Log.getStackTraceString(e));
                                e.printStackTrace();
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e.toString());
                                f2187j.unlock();
                                m2482b();
                                if (i11 == 5) {
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                str5 = "incrUpdate fail! patch ret=";
                                str6 = "decouple incrUpdate fail! patch ret=";
                                str4 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                i5 = 2;
                                bundle3 = null;
                                str3 = str14;
                                str = TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION;
                                str2 = "apk_path";
                                bundle2 = bundle3;
                                str7 = "PATCH_SUCCESS tbsCorVer is ";
                                i = i5;
                                str8 = "tbs_core_ver";
                                f2187j.unlock();
                                m2482b();
                                if (i11 != 5) {
                                }
                            }
                            if (m2515c > 5) {
                                TbsLog.m2155i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread exceed incrupdate num");
                                String string3 = bundle.getString("old_apk_location");
                                String string4 = bundle.getString("new_apk_location");
                                String string5 = bundle.getString("diff_file_location");
                                if (!TextUtils.isEmpty(string3)) {
                                    FileUtil.m2175b(new File(string3));
                                }
                                if (!TextUtils.isEmpty(string4)) {
                                    FileUtil.m2175b(new File(string4));
                                }
                                if (!TextUtils.isEmpty(string5)) {
                                    FileUtil.m2175b(new File(string5));
                                }
                                TbsDownloadConfig.getInstance(context).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, true);
                                TbsDownloadConfig.getInstance(context).commit();
                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.EXCEED_INCR_UPDATE, "incrUpdate exceed retry max num");
                                f2187j.unlock();
                                m2482b();
                                if (i11 == 5) {
                                    m2449h(context, 2);
                                    return;
                                }
                                TbsLog.m2155i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                QbSdk.setTBSInstallingStatus(false);
                                return;
                            }
                            str12 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                            C1379n.m2526a(context).m2524a("incrupdate_retry_num", m2515c + 1);
                            File m2435t = m2435t(context);
                            if (m2435t != null && new File(m2435t, "x5.tbs").exists()) {
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-550);
                                bundle5 = QbSdk.m2835a(context, bundle);
                                if (bundle5 == null) {
                                    try {
                                        tbsLogReport3 = TbsLogReport.getInstance(context);
                                        sb = new StringBuilder();
                                        str13 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                    } catch (Exception e10) {
                                        e = e10;
                                        str13 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                    } catch (Throwable th11) {
                                        th = th11;
                                        str13 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                    }
                                    try {
                                        sb.append("result null : ");
                                        sb.append(bundle.getInt("new_core_ver"));
                                        tbsLogReport3.setInstallErrorCode(TbsListener.ErrorCode.INCR_ERROR_DETAIL, sb.toString());
                                        i7 = 1;
                                        f2187j.unlock();
                                        m2482b();
                                        if (i11 == 5) {
                                            m2449h(context, i7);
                                            return;
                                        } else if (i7 == 0) {
                                            TbsLog.m2155i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                            C1379n.m2526a(context).m2524a("incrupdate_retry_num", 0);
                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                            C1379n.m2526a(context).m2516c(0, -1);
                                            C1379n.m2526a(context).m2517c(1);
                                            String string6 = bundle5.getString("apk_path");
                                            if (C1472q.m1982b(context)) {
                                                int i15 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                                                int i16 = bundle5.getInt("tbs_core_ver");
                                                TbsLog.m2155i("TbsInstaller", "PATCH_SUCCESS tbsCorVer is " + i16 + " stableCoreVersionServer is " + i15);
                                                if (i16 == i15) {
                                                    TbsLog.m2155i(TbsDownloader.LOGTAG, "PATCH_SUCCESS backup");
                                                    file2 = new File(string6);
                                                }
                                                m2474b(context, string6, bundle5.getInt("tbs_core_ver"));
                                                if (TbsDownloader.m2809a(context)) {
                                                    C1379n.m2526a(context).m2517c(-1);
                                                }
                                            } else {
                                                file2 = new File(string6);
                                            }
                                            C1377m.m2562a(file2, context);
                                            m2474b(context, string6, bundle5.getInt("tbs_core_ver"));
                                            if (TbsDownloader.m2809a(context)) {
                                            }
                                        } else if (i7 == 2) {
                                            TbsLog.m2155i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                        } else {
                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                            TbsLog.m2155i("TbsInstaller", str12);
                                            TbsDownloadConfig.getInstance(context).mSyncMap.put(str13, true);
                                            TbsDownloadConfig.getInstance(context).commit();
                                            boolean m2809a2 = TbsDownloader.m2809a(context);
                                            TbsLogReport tbsLogReport6 = TbsLogReport.getInstance(context);
                                            if (m2809a2) {
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("decouple incrUpdate fail! patch ret=", i7);
                                                i8 = TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL;
                                            } else {
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("incrUpdate fail! patch ret=", i7);
                                                i8 = TbsListener.ErrorCode.INCR_UPDATE_FAIL;
                                            }
                                            tbsLogReport6.setInstallErrorCode(i8, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                                        }
                                    } catch (Exception e11) {
                                        e = e11;
                                        i10 = 1;
                                        str5 = "incrUpdate fail! patch ret=";
                                        str6 = "decouple incrUpdate fail! patch ret=";
                                        bundle4 = bundle5;
                                        i6 = i10;
                                        str3 = str12;
                                        str4 = str13;
                                        str = TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION;
                                        str2 = "apk_path";
                                        bundle2 = bundle4;
                                        str8 = "tbs_core_ver";
                                        int i142 = i6;
                                        str7 = "PATCH_SUCCESS tbsCorVer is ";
                                        i = i142;
                                        TbsLog.m2155i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + Log.getStackTraceString(e));
                                        e.printStackTrace();
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e.toString());
                                        f2187j.unlock();
                                        m2482b();
                                        if (i11 == 5) {
                                        }
                                    } catch (Throwable th12) {
                                        th = th12;
                                        i9 = 1;
                                        str5 = "incrUpdate fail! patch ret=";
                                        str6 = "decouple incrUpdate fail! patch ret=";
                                        bundle3 = bundle5;
                                        i5 = i9;
                                        str3 = str12;
                                        str4 = str13;
                                        str = TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION;
                                        str2 = "apk_path";
                                        bundle2 = bundle3;
                                        str7 = "PATCH_SUCCESS tbsCorVer is ";
                                        i = i5;
                                        str8 = "tbs_core_ver";
                                        f2187j.unlock();
                                        m2482b();
                                        if (i11 != 5) {
                                        }
                                    }
                                } else {
                                    str13 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                                    try {
                                        i10 = bundle5.getInt("patch_result");
                                        if (i10 != 0) {
                                            try {
                                                tbsLogReport4 = TbsLogReport.getInstance(context);
                                                sb2 = new StringBuilder();
                                                bundle6 = bundle5;
                                            } catch (Exception e12) {
                                                e = e12;
                                                bundle6 = bundle5;
                                            } catch (Throwable th13) {
                                                th = th13;
                                                bundle6 = bundle5;
                                            }
                                            try {
                                                sb2.append("result ");
                                                sb2.append(i10);
                                                sb2.append(" : ");
                                                sb2.append(bundle.getInt("new_core_ver"));
                                                tbsLogReport4.setInstallErrorCode(TbsListener.ErrorCode.INCR_ERROR_DETAIL, sb2.toString());
                                            } catch (Exception e13) {
                                                e = e13;
                                                bundle5 = bundle6;
                                                str5 = "incrUpdate fail! patch ret=";
                                                str6 = "decouple incrUpdate fail! patch ret=";
                                                bundle4 = bundle5;
                                                i6 = i10;
                                                str3 = str12;
                                                str4 = str13;
                                                str = TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION;
                                                str2 = "apk_path";
                                                bundle2 = bundle4;
                                                str8 = "tbs_core_ver";
                                                int i1422 = i6;
                                                str7 = "PATCH_SUCCESS tbsCorVer is ";
                                                i = i1422;
                                                TbsLog.m2155i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + Log.getStackTraceString(e));
                                                e.printStackTrace();
                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                                TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e.toString());
                                                f2187j.unlock();
                                                m2482b();
                                                if (i11 == 5) {
                                                }
                                            } catch (Throwable th14) {
                                                th = th14;
                                                str5 = "incrUpdate fail! patch ret=";
                                                str6 = "decouple incrUpdate fail! patch ret=";
                                                str3 = str12;
                                                bundle3 = bundle6;
                                                i5 = i10;
                                                str4 = str13;
                                                str = TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION;
                                                str2 = "apk_path";
                                                bundle2 = bundle3;
                                                str7 = "PATCH_SUCCESS tbsCorVer is ";
                                                i = i5;
                                                str8 = "tbs_core_ver";
                                                f2187j.unlock();
                                                m2482b();
                                                if (i11 != 5) {
                                                }
                                            }
                                        } else {
                                            bundle6 = bundle5;
                                        }
                                        i7 = i10;
                                        bundle5 = bundle6;
                                        f2187j.unlock();
                                        m2482b();
                                        if (i11 == 5) {
                                        }
                                    } catch (Exception e14) {
                                        e = e14;
                                        bundle6 = bundle5;
                                        i10 = 2;
                                    } catch (Throwable th15) {
                                        th = th15;
                                        bundle6 = bundle5;
                                        i10 = 2;
                                    }
                                }
                                QbSdk.setTBSInstallingStatus(false);
                                return;
                            }
                        }
                        str13 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                        i7 = 2;
                        bundle5 = null;
                        f2187j.unlock();
                        m2482b();
                        if (i11 == 5) {
                        }
                    }
                }
                str3 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
                str4 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
                str5 = "incrUpdate fail! patch ret=";
                str6 = "decouple incrUpdate fail! patch ret=";
                try {
                    QbSdk.setTBSInstallingStatus(false);
                    f2187j.unlock();
                    m2482b();
                    if (i11 == 5) {
                        m2449h(context, 2);
                        return;
                    }
                    TbsLog.m2155i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                    QbSdk.setTBSInstallingStatus(false);
                } catch (Exception e15) {
                    e = e15;
                    str7 = "PATCH_SUCCESS tbsCorVer is ";
                    str = TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION;
                    str2 = "apk_path";
                    str8 = "tbs_core_ver";
                    i = 2;
                    bundle2 = null;
                    TbsLog.m2155i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + Log.getStackTraceString(e));
                    e.printStackTrace();
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, e.toString());
                    f2187j.unlock();
                    m2482b();
                    if (i11 == 5) {
                    }
                } catch (Throwable th16) {
                    th = th16;
                    str7 = "PATCH_SUCCESS tbsCorVer is ";
                    str = TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION;
                    str2 = "apk_path";
                    str8 = "tbs_core_ver";
                    bundle2 = null;
                    i = 2;
                    f2187j.unlock();
                    m2482b();
                    if (i11 != 5) {
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void m2476b(Context context, File file, int i) {
        FileOutputStream m2176b = FileUtil.m2176b(context, true, "core_unzip.lock");
        FileLock m2197a = FileUtil.m2197a(context, m2176b);
        if (m2197a == null) {
            TbsLog.m2155i("TbsInstaller", "can not get Core unzip FileLock,skip!!!");
            return;
        }
        TbsLog.m2155i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
        boolean m2493a = m2493a(context, file, false);
        TbsLog.m2155i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread result is " + m2493a);
        C1472q.m1986a(context, "copy_host_core_v3", ("coreVersionIs" + i) + "_ret=is=" + m2493a);
        if (m2493a) {
            m2503a().m2500a(context, i);
        }
        FileUtil.m2179a(m2197a, m2176b);
    }

    /* renamed from: b */
    public void m2473b(Context context, boolean z) {
        String str;
        if (QbSdk.f1741b) {
            return;
        }
        TbsLog.m2154i("TbsInstaller", "installTbsCoreIfNeeded", "#1# check local x5core prepared to install");
        if (TbsShareManager.isThirdPartyApp(context) && C1379n.m2526a(context).m2519b("remove_old_core") == 1 && z) {
            try {
                FileUtil.m2175b(m2503a().m2437r(context));
                TbsLog.m2154i("TbsInstaller", "installTbsCoreIfNeeded", "thirdAPP success--> delete old core_share Directory");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            C1379n.m2526a(context).m2524a("remove_old_core", 0);
        }
        if (!m2432w(context)) {
            return;
        }
        if (TbsShareManager.isThirdPartyApp(context)) {
            C1472q.m1986a(context, "has_tmpfile_torename", "");
        }
        TbsLog.m2154i("TbsInstaller", "installTbsCoreIfNeeded", "#2# try to install tbs core from tmp dir");
        if (m2492a(context, "core_unzip_tmp") && m2457e(context, z)) {
            TbsLog.m2153i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip !!", true);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                return;
            }
            str = "enableTbsCoreFromUnzip";
        } else if (m2492a(context, "core_share_backup_tmp") && m2454f(context, z)) {
            TbsLog.m2153i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup !!", true);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                return;
            }
            str = "enableTbsCoreFromBackup";
        } else if (m2492a(context, "core_copy_tmp") && m2461d(context, z)) {
            TbsLog.m2153i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy !!", true);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                return;
            }
            str = "enableTbsCoreFromCopy";
        } else if (!m2492a(context, "tpatch_tmp") || !m2466c(context, z)) {
            TbsLog.m2153i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
            return;
        } else {
            TbsLog.m2153i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromTpatch !!", true);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                return;
            }
            str = "enableTbsCoreFromTpatch";
        }
        C1472q.m1986a(context, "rename_ok", str);
    }

    /* renamed from: b */
    public boolean m2480b(Context context, int i) {
        if (TbsDownloader.getOverSea(context)) {
            return false;
        }
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + i);
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
        Context m2464d = m2464d(context, i);
        if (m2464d == null) {
            TbsLog.m2155i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
            return false;
        }
        Object[] objArr = {m2464d, context, Integer.valueOf(i)};
        Message message = new Message();
        message.what = 2;
        message.obj = objArr;
        f2189m.sendMessage(message);
        return true;
    }

    /* renamed from: c */
    public int m2467c(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            return packageArchiveInfo.versionCode;
        }
        return 0;
    }

    /* renamed from: c */
    public File m2470c(Context context, Context context2) {
        File file = new File(QbSdk.getTbsFolderDir(context2), "core_share_decouple");
        if (file.isDirectory() || ((context != null && TbsShareManager.isThirdPartyApp(context)) || file.mkdir())) {
            return file;
        }
        return null;
    }

    /* renamed from: c */
    public void m2472c(Context context) {
        TbsLog.m2155i("TbsInstaller", "setTmpFolderCoreToRead call #02");
        m2451g(context, true);
        C1379n.m2526a(context).m2516c(m2448i(context), 2);
    }

    /* renamed from: c */
    public void m2471c(Context context, int i) {
        int m2446j;
        TbsLog.m2155i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
        if (i > 0 && (m2446j = m2446j(context)) < i) {
            Context m2726e = TbsShareManager.m2726e(context);
            if (m2726e != null || TbsShareManager.getHostCorePathAppDefined() != null) {
                TbsLog.m2155i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
                m2498a(context, m2726e);
            } else if (m2446j > 0) {
            } else {
                TbsLog.m2155i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
                QbSdk.m2833a(context, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
            }
        }
    }

    /* renamed from: d */
    public Context m2464d(Context context, int i) {
        Context m2475b;
        TbsLog.m2155i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=" + i);
        if (i <= 0) {
            return null;
        }
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        for (int i2 = 0; i2 < coreProviderAppList.length; i2++) {
            if (!context.getPackageName().equalsIgnoreCase(coreProviderAppList[i2]) && m2458e(context, coreProviderAppList[i2]) && (m2475b = m2475b(context, coreProviderAppList[i2])) != null) {
                if (!m2453g(m2475b)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller--getTbsCoreHostContext ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(coreProviderAppList[i2]);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" illegal signature go on next");
                    TbsLog.m2158e("TbsInstaller", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                } else {
                    int m2446j = m2446j(m2475b);
                    TbsLog.m2155i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=" + m2446j);
                    if (m2446j != 0 && m2446j == i) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller-getTbsCoreHostContext targetApp=");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(coreProviderAppList[i2]);
                        TbsLog.m2155i("TbsInstaller", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                        return m2475b;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: d */
    public String m2462d(Context context, String str) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file = new File(m2437r(context), "tbs.conf");
            if (!file.exists()) {
                return null;
            }
            Properties properties = new Properties();
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream);
                bufferedInputStream.close();
                String property = properties.getProperty(str);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused) {
                }
                return property;
            } catch (Exception unused2) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: d */
    public boolean m2465d(Context context) {
        File file = new File(m2437r(context), "tbs.conf");
        boolean z = false;
        if (!file.exists()) {
            return false;
        }
        Properties properties = new Properties();
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream2);
                boolean booleanValue = Boolean.valueOf(properties.getProperty("tbs_local_installation", "false")).booleanValue();
                if (booleanValue) {
                    try {
                        if (System.currentTimeMillis() - file.lastModified() > 259200000) {
                            z = true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        z = booleanValue;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            th.printStackTrace();
                            return z;
                        } finally {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
                TbsLog.m2155i("TbsInstaller", "TBS_LOCAL_INSTALLATION is:" + booleanValue + " expired=" + z);
                boolean z2 = booleanValue & (!z);
                try {
                    bufferedInputStream2.close();
                    return z2;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: e */
    public int m2459e(Context context, int i) {
        return m2486a(m2455f(context, i));
    }

    /* renamed from: e */
    public void m2460e(Context context) {
        BufferedInputStream bufferedInputStream;
        try {
            File file = new File(m2437r(context), "tbs.conf");
            Properties properties = new Properties();
            BufferedOutputStream bufferedOutputStream = null;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        properties.setProperty("tbs_local_installation", "false");
                        properties.store(bufferedOutputStream2, (String) null);
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException unused) {
                        }
                    } catch (Throwable unused2) {
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (bufferedInputStream == null) {
                            return;
                        }
                        bufferedInputStream.close();
                    }
                } catch (Throwable unused4) {
                }
            } catch (Throwable unused5) {
                bufferedInputStream = null;
            }
            bufferedInputStream.close();
        } catch (Throwable unused6) {
        }
    }

    /* renamed from: f */
    public File m2455f(Context context, int i) {
        return m2499a(context, i, true);
    }

    /* renamed from: f */
    public boolean m2456f(Context context) {
        try {
            File file = new File(FileUtil.m2198a(context, 4), TbsDownloader.getBackupFileName(true));
            File m2455f = m2503a().m2455f(context, 2);
            FileUtil.m2192a(m2455f);
            FileUtil.m2188a(m2455f, true);
            FileUtil.m2191a(file, m2455f);
            for (String str : m2455f.list()) {
                File file2 = new File(m2455f, str);
                if (file2.getName().endsWith(MultiDexExtractor.DEX_SUFFIX)) {
                    file2.delete();
                }
            }
            m2447i(context, 2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: g */
    public boolean m2453g(Context context) {
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
            return true;
        }
        try {
            Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            if (context.getPackageName().equals(TbsConfig.APP_QB)) {
                if (!signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_WX)) {
                if (!signature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_QQ)) {
                if (!signature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049")) {
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_DEMO)) {
                if (!signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_QZONE)) {
                if (!signature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677")) {
                    return false;
                }
            } else if (context.getPackageName().equals("com.tencent.qqpimsecure") && !signature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8")) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            TbsLog.m2155i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
            return false;
        }
    }

    /* renamed from: g */
    public boolean m2452g(Context context, int i) {
        File m2437r;
        String str;
        try {
            boolean isThirdPartyApp = TbsShareManager.isThirdPartyApp(context);
            if (!isThirdPartyApp) {
                m2437r = m2437r(context);
            } else if (!TbsShareManager.m2721j(context)) {
                TbsLog.m2158e("TbsInstaller", "321");
                return false;
            } else {
                m2437r = new File(TbsShareManager.m2730c(context));
                if (m2437r.getAbsolutePath().contains(TbsConfig.APP_DEMO)) {
                    return true;
                }
            }
            if (m2437r != null) {
                Long[][] lArr = f2190n;
                int length = lArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Long[] lArr2 = lArr[i2];
                    if (i == lArr2[0].intValue()) {
                        File file = new File(m2437r, "libmttwebview.so");
                        if (!file.exists() || file.length() != lArr2[1].longValue()) {
                            if (!isThirdPartyApp) {
                                FileUtil.m2175b(QbSdk.getTbsFolderDir(context));
                            }
                            f2182a.set(0);
                            str = "322";
                        } else {
                            TbsLog.m2161d("TbsInstaller", "check so success: " + i + "; file: " + file);
                        }
                    } else {
                        i2++;
                    }
                }
                return true;
            }
            str = "323";
            TbsLog.m2158e("TbsInstaller", str);
            return false;
        } catch (Throwable th) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ISTBSCORELEGAL exception getMessage is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.getMessage());
            TbsLog.m2158e("TbsInstaller", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            TbsLog.m2158e("TbsInstaller", "ISTBSCORELEGAL exception getCause is " + th.getCause());
            return false;
        }
    }

    /* renamed from: h */
    public void m2450h(Context context) {
        FileLock fileLock = f2188l;
        if (fileLock != null) {
            FileUtil.m2194a(context, fileLock);
        }
    }

    /* renamed from: i */
    public int m2448i(Context context) {
        BufferedInputStream bufferedInputStream = null;
        try {
            File file = new File(m2438q(context), "tbs.conf");
            if (!file.exists()) {
                return 0;
            }
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream2);
                bufferedInputStream2.close();
                String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return 0;
                }
                int parseInt = Integer.parseInt(property);
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
                return parseInt;
            } catch (Exception unused3) {
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return 0;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        } catch (Exception unused6) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: j */
    public int m2446j(Context context) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                File file = new File(m2437r(context), "tbs.conf");
                if (!file.exists()) {
                    return 0;
                }
                TbsLog.m2155i("TbsInstaller", "getTbsCoreInstalledVerInNolock tbsPropFile is " + file.getAbsolutePath());
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller--getTbsCoreInstalledVerInNolock IOException=");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.toString());
                            TbsLog.m2155i("TbsInstaller", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                        }
                        return 0;
                    }
                    int parseInt = Integer.parseInt(property);
                    if (f2191o == 0) {
                        f2191o = parseInt;
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller--getTbsCoreInstalledVerInNolock IOException=");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e2.toString());
                        TbsLog.m2155i("TbsInstaller", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                    }
                    return parseInt;
                } catch (Exception e3) {
                    e = e3;
                    bufferedInputStream2 = bufferedInputStream;
                    TbsLog.m2155i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e4) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller--getTbsCoreInstalledVerInNolock IOException=");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(e4.toString());
                            TbsLog.m2155i("TbsInstaller", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller--getTbsCoreInstalledVerInNolock IOException=");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(e5.toString());
                            TbsLog.m2155i("TbsInstaller", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = bufferedInputStream2;
        }
    }

    /* renamed from: k */
    public int m2444k(Context context) {
        int i = f2191o;
        return i != 0 ? i : m2446j(context);
    }

    /* renamed from: l */
    public void m2443l(Context context) {
        if (f2191o != 0) {
            return;
        }
        f2191o = m2446j(context);
    }

    /* renamed from: m */
    public boolean m2442m(Context context) {
        return new File(m2437r(context), "tbs.conf").exists();
    }

    /* renamed from: n */
    public int m2441n(Context context) {
        BufferedInputStream bufferedInputStream;
        if (!m2434u(context)) {
            return -1;
        }
        boolean tryLock = f2186i.tryLock();
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller--getTbsCoreInstalledVerWithLock locked=", tryLock, "TbsInstaller");
        if (!tryLock) {
            m2482b();
            return 0;
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                File file = new File(m2437r(context), "tbs.conf");
                if (!file.exists()) {
                    try {
                        if (f2186i.isHeldByCurrentThread()) {
                            f2186i.unlock();
                        }
                    } catch (Throwable th) {
                        TbsLog.m2158e("TbsInstaller", "TbsRenameLock.unlock exception: " + th);
                    }
                    m2482b();
                    return 0;
                }
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller--getTbsCoreInstalledVerWithLock IOException=");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.toString());
                            TbsLog.m2155i("TbsInstaller", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                        }
                        try {
                            if (f2186i.isHeldByCurrentThread()) {
                                f2186i.unlock();
                            }
                        } catch (Throwable th2) {
                            TbsLog.m2158e("TbsInstaller", "TbsRenameLock.unlock exception: " + th2);
                        }
                        m2482b();
                        return 0;
                    }
                    f2182a.set(Integer.valueOf(Integer.parseInt(property)));
                    int intValue = f2182a.get().intValue();
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller--getTbsCoreInstalledVerWithLock IOException=");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e2.toString());
                        TbsLog.m2155i("TbsInstaller", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                    }
                    try {
                        if (f2186i.isHeldByCurrentThread()) {
                            f2186i.unlock();
                        }
                    } catch (Throwable th3) {
                        TbsLog.m2158e("TbsInstaller", "TbsRenameLock.unlock exception: " + th3);
                    }
                    m2482b();
                    return intValue;
                } catch (Exception e3) {
                    e = e3;
                    bufferedInputStream2 = bufferedInputStream;
                    TbsLog.m2155i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerWithLock Exception=" + e.toString());
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e4) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller--getTbsCoreInstalledVerWithLock IOException=");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(e4.toString());
                            TbsLog.m2155i("TbsInstaller", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                        }
                    }
                    try {
                        if (f2186i.isHeldByCurrentThread()) {
                            f2186i.unlock();
                        }
                    } catch (Throwable th4) {
                        TbsLog.m2158e("TbsInstaller", "TbsRenameLock.unlock exception: " + th4);
                    }
                    m2482b();
                    return 0;
                } catch (Throwable th5) {
                    th = th5;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsInstaller--getTbsCoreInstalledVerWithLock IOException=");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(e5.toString());
                            TbsLog.m2155i("TbsInstaller", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
                        }
                    }
                    try {
                        if (f2186i.isHeldByCurrentThread()) {
                            f2186i.unlock();
                        }
                    } catch (Throwable th6) {
                        TbsLog.m2158e("TbsInstaller", "TbsRenameLock.unlock exception: " + th6);
                    }
                    m2482b();
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedInputStream = null;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    /* renamed from: o */
    public boolean m2440o(Context context) {
        return true;
    }

    /* renamed from: p */
    public void m2439p(Context context) {
        TbsLog.m2155i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        C1379n.m2526a(context).m2528a(0);
        C1379n.m2526a(context).m2521b(0);
        C1379n.m2526a(context).m2513d(0);
        C1379n.m2526a(context).m2524a("incrupdate_retry_num", 0);
        if (!TbsDownloader.m2809a(context)) {
            C1379n.m2526a(context).m2516c(0, -1);
            C1379n.m2526a(context).m2525a("");
            C1379n.m2526a(context).m2524a("copy_retry_num", 0);
            C1379n.m2526a(context).m2517c(-1);
            C1379n.m2526a(context).m2527a(0, -1);
            FileUtil.m2188a(m2455f(context, 0), true);
            FileUtil.m2188a(m2455f(context, 1), true);
        }
    }

    /* renamed from: q */
    public File m2438q(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_share_decouple");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    /* renamed from: r */
    public File m2437r(Context context) {
        return m2479b((Context) null, context);
    }

    /* renamed from: s */
    public File m2436s(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "share");
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    /* renamed from: u */
    public synchronized boolean m2434u(Context context) {
        if (this.f2193e > 0) {
            TbsLog.m2155i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
            this.f2193e++;
            return true;
        }
        FileOutputStream m2176b = FileUtil.m2176b(context, true, "tbslock.txt");
        this.f2195g = m2176b;
        if (m2176b == null) {
            TbsLog.m2155i("TbsInstaller", "getTbsInstallingFileLock get install fos failed");
            return false;
        }
        FileLock m2197a = FileUtil.m2197a(context, m2176b);
        this.f2194f = m2197a;
        if (m2197a == null) {
            TbsLog.m2155i("TbsInstaller", "getTbsInstallingFileLock tbsFileLockFileLock == null");
            return false;
        }
        TbsLog.m2155i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
        this.f2193e++;
        return true;
    }
}

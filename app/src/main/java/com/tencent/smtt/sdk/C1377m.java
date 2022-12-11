package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.Constants;
import com.stub.StubApp;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.C1428a;
import com.tencent.smtt.utils.C1429b;
import com.tencent.smtt.utils.C1472q;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.SSLHandshakeException;
import me.tvspark.outline;
import org.fourthline.cling.model.types.BytesRange;
import org.mozilla.javascript.v8dtoa.FastDtoa;

/* renamed from: com.tencent.smtt.sdk.m */
/* loaded from: classes4.dex */
public class C1377m {

    /* renamed from: e */
    public static int f2147e = 5;

    /* renamed from: f */
    public static int f2148f = 1;

    /* renamed from: g */
    public static final String[] f2149g = {"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone"};

    /* renamed from: A */
    public boolean f2150A;

    /* renamed from: B */
    public Handler f2151B;

    /* renamed from: E */
    public boolean f2154E;

    /* renamed from: a */
    public String f2155a;

    /* renamed from: h */
    public Context f2159h;

    /* renamed from: i */
    public String f2160i;

    /* renamed from: j */
    public String f2161j;

    /* renamed from: k */
    public String f2162k;

    /* renamed from: l */
    public File f2163l;

    /* renamed from: m */
    public File f2164m;

    /* renamed from: n */
    public long f2165n;

    /* renamed from: q */
    public boolean f2168q;

    /* renamed from: r */
    public int f2169r;

    /* renamed from: s */
    public int f2170s;

    /* renamed from: t */
    public boolean f2171t;

    /* renamed from: u */
    public boolean f2172u;

    /* renamed from: v */
    public HttpURLConnection f2173v;

    /* renamed from: w */
    public String f2174w;

    /* renamed from: x */
    public TbsLogReport.TbsLogInfo f2175x;

    /* renamed from: y */
    public String f2176y;

    /* renamed from: z */
    public int f2177z;

    /* renamed from: d */
    public boolean f2158d = false;

    /* renamed from: o */
    public int f2166o = BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH;

    /* renamed from: p */
    public int f2167p = 20000;

    /* renamed from: D */
    public int f2153D = f2147e;

    /* renamed from: b */
    public String[] f2156b = null;

    /* renamed from: c */
    public int f2157c = 0;

    /* renamed from: C */
    public Set<String> f2152C = new HashSet();

    public C1377m(Context context) throws NullPointerException {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f2159h = origApplicationContext;
        this.f2175x = TbsLogReport.getInstance(origApplicationContext).tbsLogInfo();
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("tbs_downloading_");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2159h.getPackageName());
        this.f2174w = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        C1381p.m2503a();
        File m2435t = C1381p.m2435t(this.f2159h);
        this.f2163l = m2435t;
        if (m2435t != null) {
            try {
                Context packageContext = TbsShareManager.getPackageContext(context, TbsConfig.APP_WX, false);
                if (packageContext == null) {
                    this.f2164m = new File(FileUtil.m2195a(context, TbsConfig.APP_WX, 4, true));
                } else {
                    this.f2164m = new File(FileUtil.m2198a(packageContext, 4));
                }
            } catch (Throwable unused) {
            }
            m2539g();
            this.f2176y = null;
            this.f2177z = -1;
            return;
        }
        throw new NullPointerException("TbsCorePrivateDir is null!");
    }

    /* renamed from: a */
    private long m2568a(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f2175x.setDownConsumeTime(currentTimeMillis - j);
        this.f2175x.setDownloadSize(j2);
        return currentTimeMillis;
    }

    /* renamed from: a */
    public static File m2566a(Context context, int i) {
        File file = new File(FileUtil.m2198a(context, i));
        if (file.exists() && file.isDirectory()) {
            if (new File(file, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false)).exists()) {
                return file;
            }
        }
        return null;
    }

    /* renamed from: a */
    private String m2560a(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return stackTraceString.length() > 1024 ? stackTraceString.substring(0, 1024) : stackTraceString;
    }

    /* renamed from: a */
    private String m2559a(URL url) {
        try {
            return InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Error e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private void m2571a(int i, String str, boolean z) {
        if (z || this.f2169r > this.f2153D) {
            this.f2175x.setErrorCode(i);
            this.f2175x.setFailDetail(str);
        }
    }

    /* renamed from: a */
    private void m2569a(long j) {
        this.f2169r++;
        if (j <= 0) {
            try {
                j = m2532n();
            } catch (Exception unused) {
                return;
            }
        }
        Thread.sleep(j);
    }

    /* renamed from: a */
    public static void m2567a(Context context) {
        try {
            TbsLog.m2155i(TbsDownloader.LOGTAG, "clearDecoupleDirOld #00");
            File m2495a = C1381p.m2503a().m2495a(context, context.getDir("tbs_64", 0));
            FileUtil.m2175b(m2495a);
            if (m2495a != null) {
                TbsLog.m2155i(TbsDownloader.LOGTAG, "clearDecoupleDirOld dir is " + m2495a.getAbsolutePath());
            }
            File m2495a2 = C1381p.m2503a().m2495a(context, context.getDir("tbs", 0));
            FileUtil.m2175b(m2495a2);
            if (m2495a2 == null) {
                return;
            }
            TbsLog.m2155i(TbsDownloader.LOGTAG, "clearDecoupleDirOld dir is " + m2495a2.getAbsolutePath());
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("clearDecoupleDirOld stack is "), TbsDownloader.LOGTAG);
        }
    }

    /* renamed from: a */
    private void m2564a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m2562a(File file, Context context) {
        boolean contains;
        synchronized (C1428a.class) {
            if (file != null) {
                if (file.exists()) {
                    if (TbsShareManager.isThirdPartyApp(context)) {
                        return;
                    }
                    try {
                        File m2549c = m2549c(context);
                        if (m2549c != null) {
                            File file2 = new File(m2549c, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
                            file2.delete();
                            FileUtil.m2174b(file, file2);
                            TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupTbsApk]tbsApk is " + file.getAbsolutePath());
                            TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupTbsApk]backUpApk is " + file2.getAbsolutePath());
                            boolean contains2 = file2.getName().contains("tbs.org");
                            if (file2.getName().contains("x5.tbs.decouple") || contains2) {
                                File[] listFiles = m2549c.listFiles();
                                Pattern compile = Pattern.compile(C1428a.m2134a(contains) + "(.*)");
                                for (File file3 : listFiles) {
                                    if (compile.matcher(file3.getName()).find() && file3.isFile() && file3.exists()) {
                                        file3.delete();
                                    }
                                }
                                File file4 = new File(m2549c, C1428a.m2134a(contains) + "." + TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                if (file4.exists()) {
                                    TbsLog.m2158e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupTbsApk]delete bacup config file error ");
                                    return;
                                }
                                file4.createNewFile();
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m2561a(String str) throws Exception {
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = this.f2173v;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[initHttpRequest] mHttpRequest.disconnect() Throwable:");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.toString());
                TbsLog.m2158e(TbsDownloader.LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }
        HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
        this.f2173v = httpURLConnection2;
        httpURLConnection2.setRequestProperty("User-Agent", TbsDownloader.m2796b(this.f2159h));
        this.f2173v.setRequestProperty("Accept-Encoding", "identity");
        this.f2173v.setRequestMethod("GET");
        this.f2173v.setInstanceFollowRedirects(false);
        this.f2173v.setConnectTimeout(this.f2167p);
        this.f2173v.setReadTimeout(this.f2166o);
    }

    /* renamed from: a */
    private boolean m2563a(File file) {
        int i = TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        if (i == 0) {
            i = TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        }
        return C1428a.m2137a(this.f2159h, file, 0L, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x008f, code lost:
        if (r10 != r8) goto L26;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean m2556a(boolean z, boolean z2, File file) {
        boolean z3;
        int i;
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[TbsApkDownloader.verifyTbsApk] isTempFile=", z, TbsDownloader.LOGTAG);
        if (file != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[TbsApkDownloader.verifyTbsApk]  verifyFile is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(file.getAbsolutePath());
            TbsLog.m2155i(TbsDownloader.LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        File file2 = new File(this.f2163l, !z ? "x5.tbs" : "x5.tbs.temp");
        if (file != null) {
            file2 = file;
        }
        boolean z4 = false;
        if (!file2.exists()) {
            return false;
        }
        Exception exc = null;
        String string = TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, null);
        String m2135a = C1428a.m2135a(file2);
        if (string == null || !string.equals(m2135a)) {
            TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " md5 failed");
            if (z) {
                this.f2175x.setCheckErrorDetail("fileMd5 not match");
            }
            return false;
        }
        TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] md5(" + m2135a + ") successful!");
        long j = 0;
        if (z) {
            long j2 = TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0L);
            if (file2.exists()) {
                if (j2 > 0) {
                    j = file2.length();
                }
            }
            TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " filelength failed");
            TbsLogReport.TbsLogInfo tbsLogInfo = this.f2175x;
            tbsLogInfo.setCheckErrorDetail("fileLength:" + j + ",contentLength:" + j2);
            return false;
        }
        TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] length(" + j + ") successful!");
        int i2 = -1;
        if (z2 && !z && (i = TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0)) != (i2 = C1428a.m2139a(this.f2159h, file2))) {
            TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " versionCode failed");
            if (z) {
                TbsLogReport.TbsLogInfo tbsLogInfo2 = this.f2175x;
                tbsLogInfo2.setCheckErrorDetail("fileVersion:" + i2 + ",configVersion:" + i);
            }
            return false;
        }
        TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i2 + ") successful!");
        if (z2 && !z) {
            String m2126a = C1429b.m2126a(this.f2159h, false, file2);
            if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(m2126a)) {
                TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " signature failed");
                if (z) {
                    TbsLogReport.TbsLogInfo tbsLogInfo3 = this.f2175x;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("signature:");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(m2126a == null ? "null" : Integer.valueOf(m2126a.length()));
                    tbsLogInfo3.setCheckErrorDetail(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                }
                return false;
            }
        }
        TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] signature successful!");
        if (z && file == null) {
            try {
                z3 = file2.renameTo(new File(this.f2163l, "x5.tbs"));
            } catch (Exception e) {
                exc = e;
                z3 = false;
            }
            if (!z3) {
                m2571a(109, m2560a(exc), true);
                return false;
            }
            z4 = z3;
        }
        TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] rename(" + z4 + ") successful!");
        return true;
    }

    /* renamed from: b */
    public static void m2553b(Context context) {
        try {
            if (!TbsShareManager.isThirdPartyApp(context) && !C1472q.m1973g(context)) {
                return;
            }
            TbsLog.m2155i(TbsDownloader.LOGTAG, "clearOldBackup #00");
            File file = new File(FileUtil.m2198a(context, 3));
            FileUtil.m2175b(file);
            TbsLog.m2155i(TbsDownloader.LOGTAG, "clearOldBackup dir is " + file.getAbsolutePath());
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("clearOldBackup stack is "), TbsDownloader.LOGTAG);
        }
    }

    /* renamed from: b */
    private boolean m2554b(int i) {
        try {
            File file = new File(this.f2163l, "x5.tbs");
            File m2549c = m2549c(this.f2159h);
            if (m2549c == null) {
                return false;
            }
            File file2 = new File(m2549c, TbsDownloader.getOverSea(this.f2159h) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
            file.delete();
            FileUtil.m2174b(file2, file);
            if (C1428a.m2137a(this.f2159h, file, 0L, i)) {
                return true;
            }
            TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLog.m2158e(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + e.getMessage());
            return false;
        }
    }

    @TargetApi(8)
    /* renamed from: c */
    public static File m2549c(Context context) {
        try {
            File file = new File(FileUtil.m2198a(context, 4));
            if (file != null && !file.exists() && !file.isDirectory()) {
                file.mkdirs();
            }
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLog.m2158e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    private boolean m2547c(boolean z, boolean z2) {
        return m2556a(z, z2, (File) null);
    }

    @TargetApi(8)
    /* renamed from: d */
    public static File m2545d(Context context) {
        try {
            File m2566a = m2566a(context, 4);
            if (m2566a == null) {
                m2566a = m2566a(context, 3);
            }
            if (m2566a == null) {
                m2566a = m2566a(context, 2);
            }
            return m2566a == null ? m2566a(context, 1) : m2566a;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLog.m2158e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:1|(1:3)(1:107)|4|(1:6)(2:104|(12:106|8|9|10|11|12|13|(1:97)(15:18|(3:20|(2:26|27)|28)|32|33|34|35|36|(1:38)(1:91)|39|40|41|(3:43|(2:45|46)|85)(3:86|(1:88)|85)|47|48|49)|50|(2:74|(2:76|68)(4:77|(1:79)(2:81|(1:83))|80|72))(1:(2:69|(2:71|72)(1:73))(3:57|(1:59)(2:64|(1:66)(2:67|68))|60))|61|62))|7|8|9|10|11|12|13|(1:15)|97|50|(1:52)|74|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x026f, code lost:
        r17 = com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0272, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0273, code lost:
        r7 = r20;
        r8 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01da, code lost:
        if (r3 == 64) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x026c, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x026d, code lost:
        r7 = r20;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x032d  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m2544d(boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Bundle m2570a;
        String str6;
        File file;
        C1472q.m1989a(this.f2159h);
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(this.f2159h);
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, false);
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -123);
        tbsDownloadConfig.commit();
        QbSdk.f1753n.onDownloadFinish(z ? 100 : 120);
        int i = tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
        boolean m2809a = TbsDownloader.m2809a(this.f2159h);
        if (m2809a) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("downloadVersion=is=");
            SharedPreferences sharedPreferences = TbsDownloadConfig.getInstance(this.f2159h).mPreferences;
            str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(sharedPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), "_", "apkSize=is=");
            SharedPreferences sharedPreferences2 = TbsDownloadConfig.getInstance(this.f2159h).mPreferences;
            str = "downloadSuccess stack is ";
            str2 = TbsDownloader.LOGTAG;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(sharedPreferences2.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0L));
            C1472q.m1981b(this.f2159h, "download_ok", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else {
            str = "downloadSuccess stack is ";
            str2 = TbsDownloader.LOGTAG;
            str3 = TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD;
            if (TbsShareManager.isThirdPartyApp(this.f2159h)) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("downloadVersion=is=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), "_", "apkSize=is=");
                str4 = str;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0L));
                C1472q.m1986a(this.f2159h, "download_ok", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                int i2 = tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_CPUTYPE_OTHER_STABLE_CORE, 0);
                String str7 = str2;
                TbsLog.m2155i(str7, "downloadSuccess #1  cpuTypeForOtherStableCore is " + i2 + " isDownloadDecoupleCore is " + m2809a);
                TbsLog.m2155i(str7, "downloadSuccess #1  responseCode is " + i);
                if (m2809a || !C1472q.m1982b(this.f2159h) || i == 3) {
                    str5 = TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE;
                } else {
                    File[] listFiles = this.f2164m.listFiles();
                    Pattern compile = Pattern.compile(C1428a.m2133a(false, i2));
                    int length = listFiles.length;
                    int i3 = 0;
                    while (i3 < length) {
                        File file2 = listFiles[i3];
                        File[] fileArr = listFiles;
                        if (compile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                            file2.delete();
                        }
                        i3++;
                        listFiles = fileArr;
                    }
                    File file3 = this.f2164m;
                    StringBuilder sb = new StringBuilder();
                    str5 = TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE;
                    try {
                        sb.append(C1428a.m2133a(false, i2));
                        sb.append(".");
                        sb.append(tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                        File file4 = new File(file3, sb.toString());
                        if (!file4.exists()) {
                            file4.createNewFile();
                        }
                        try {
                            File file5 = this.f2164m;
                            boolean renameTo = new File(file5, TbsDownloader.getBackupFileName(false) + ".tmp").renameTo(new File(this.f2164m, TbsDownloader.getBackupFileName(false, i2)));
                            String str8 = Constants.CP_NONE;
                            if (i2 == 0) {
                                if (C1429b.m2121b()) {
                                    str8 = "stable_64_tpatch_fail";
                                }
                                str8 = "stable_32_tpatch_fail";
                            } else {
                                if (i2 != 32) {
                                }
                                str8 = "stable_32_tpatch_fail";
                            }
                            C1379n.m2526a(this.f2159h).m2524a(str8, 0);
                            TbsLog.m2155i(str7, "downloadSuccess setStatus " + str8 + " is 0");
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("downloadSuccess renameResult is ");
                            sb2.append(renameTo);
                            TbsLog.m2155i(str7, sb2.toString());
                            TbsLog.m2155i(str7, "downloadSuccess getTbsStableCoreVersion is " + TbsShareManager.getTbsStableCoreVersion(this.f2159h, i2));
                            C1472q.m1981b(this.f2159h, "rename_whole_file_ok", "cpu=is=" + i2);
                        }
                    } catch (Throwable th) {
                        th = th;
                        String str9 = str4;
                        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str9), str7);
                        if (i != 5) {
                        }
                        m2570a = m2570a(i, m2809a);
                        if (m2570a != null) {
                        }
                    }
                }
                if (i != 5 || i == 3) {
                    m2570a = m2570a(i, m2809a);
                    if (m2570a != null) {
                        str6 = "downloadSuccess RESPONSECODE_TPATCH bundle is null ";
                        TbsLog.m2155i(str7, str6);
                    } else {
                        if (m2809a) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("downloadVersion=is=");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), "_", "apkSize=is=");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getLong(str5, 0L));
                            String sb3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString();
                            C1472q.m1981b(this.f2159h, "tpatch_pre_bundle_ok", sb3 + "_responseCode=is=" + i);
                        } else {
                            String str10 = str5;
                            if (TbsShareManager.isThirdPartyApp(this.f2159h)) {
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("downloadVersion=is=");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString(), "_", "apkSize=is=");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getLong(str10, 0L));
                                String sb4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString();
                                C1472q.m1986a(this.f2159h, "tpatch_pre_bundle_ok", sb4 + "_responseCode=is=" + i);
                            }
                        }
                        TbsLog.m2155i(str7, "downloadSuccess RESPONSECODE_TPATCH bundle is " + m2570a);
                        C1381p.m2503a().m2478b(this.f2159h, m2570a);
                    }
                } else if (i == 3 || i > 10000) {
                    File m2549c = m2549c(this.f2159h);
                    if (m2549c != null) {
                        m2570a = m2572a(i, m2549c, m2809a);
                        C1381p.m2503a().m2478b(this.f2159h, m2570a);
                    } else {
                        m2550c();
                        tbsDownloadConfig.mSyncMap.put(str3, true);
                        tbsDownloadConfig.commit();
                    }
                } else {
                    int i4 = tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                    C1381p.m2503a().m2491a(this.f2159h, new File(this.f2163l, "x5.tbs").getAbsolutePath(), i4);
                    if (!C1472q.m1982b(this.f2159h)) {
                        file = new File(this.f2163l, "x5.tbs");
                    } else {
                        int i5 = TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                        TbsLog.m2155i(str7, "downloadSuccess tbsCorVer is " + i4 + " stableCoreVersionServer is " + i5);
                        if (i4 == i5) {
                            TbsLog.m2155i(str7, "downloadSuccess backup");
                            file = new File(this.f2163l, "x5.tbs");
                        } else {
                            str6 = "downloadSuccess not backup";
                            TbsLog.m2155i(str7, str6);
                        }
                    }
                    m2562a(file, this.f2159h);
                }
                m2567a(this.f2159h);
                m2553b(this.f2159h);
                return;
            }
        }
        str4 = str;
        int i22 = tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_CPUTYPE_OTHER_STABLE_CORE, 0);
        String str72 = str2;
        TbsLog.m2155i(str72, "downloadSuccess #1  cpuTypeForOtherStableCore is " + i22 + " isDownloadDecoupleCore is " + m2809a);
        TbsLog.m2155i(str72, "downloadSuccess #1  responseCode is " + i);
        if (m2809a) {
        }
        str5 = TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE;
        if (i != 5) {
        }
        m2570a = m2570a(i, m2809a);
        if (m2570a != null) {
        }
    }

    /* renamed from: e */
    public static void m2542e(Context context) {
        try {
            C1381p.m2503a();
            File m2435t = C1381p.m2435t(context);
            new File(m2435t, "x5.tbs").delete();
            new File(m2435t, "x5.tbs.temp").delete();
            File m2549c = m2549c(context);
            if (m2549c == null) {
                return;
            }
            new File(m2549c, TbsDownloader.getBackupFileName(false)).delete();
            new File(m2549c, "x5.oversea.tbs.org").delete();
            File[] listFiles = m2549c.listFiles();
            Pattern compile = Pattern.compile(C1428a.m2134a(true) + "(.*)");
            for (File file : listFiles) {
                if (compile.matcher(file.getName()).find() && file.isFile() && file.exists()) {
                    file.delete();
                }
            }
            Pattern compile2 = Pattern.compile(C1428a.m2134a(false) + "(.*)");
            for (File file2 : listFiles) {
                if (compile2.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                    file2.delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    private boolean m2541e(boolean z) {
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[TbsApkDownloader.deleteFile] isApk=", z, TbsDownloader.LOGTAG);
        File file = z ? new File(this.f2163l, "x5.tbs") : new File(this.f2163l, "x5.tbs.temp");
        if (file.exists()) {
            FileUtil.m2175b(file);
        }
        return true;
    }

    /* renamed from: g */
    private void m2539g() {
        this.f2169r = 0;
        this.f2170s = 0;
        this.f2165n = -1L;
        this.f2162k = null;
        this.f2168q = false;
        this.f2171t = false;
        this.f2172u = false;
        this.f2150A = false;
    }

    /* renamed from: h */
    private void m2538h() {
        TbsLogReport tbsLogReport;
        TbsLogReport.EventType eventType;
        TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest]");
        HttpURLConnection httpURLConnection = this.f2173v;
        if (httpURLConnection != null) {
            if (!this.f2171t) {
                this.f2175x.setResolveIp(m2559a(httpURLConnection.getURL()));
            }
            try {
                this.f2173v.disconnect();
            } catch (Throwable th) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[closeHttpRequest] mHttpRequest.disconnect() Throwable:");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.toString());
                TbsLog.m2158e(TbsDownloader.LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            this.f2173v = null;
            TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest] mHttpRequest set null");
        }
        TbsLogReport.TbsLogInfo tbsLogInfo = this.f2175x;
        int i = tbsLogInfo.f1898a;
        if (this.f2171t || !this.f2150A) {
            if (this.f2158d) {
                return;
            }
            TbsDownloader.f1858a = false;
            return;
        }
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        String apnInfo = Apn.getApnInfo(this.f2159h);
        if (apnInfo == null) {
            apnInfo = "";
        }
        int apnType = Apn.getApnType(this.f2159h);
        this.f2175x.setApn(apnInfo);
        this.f2175x.setNetworkType(apnType);
        if (apnType != this.f2177z || !apnInfo.equals(this.f2176y)) {
            this.f2175x.setNetworkChange(0);
        }
        int i2 = this.f2175x.f1898a;
        if ((i2 == 0 || i2 == 107) && this.f2175x.getDownFinalFlag() == 0 && (!Apn.isNetworkAvailable(this.f2159h) || !m2533m())) {
            m2571a(101, (String) null, true);
        }
        if (TbsDownloader.m2809a(this.f2159h)) {
            tbsLogReport = TbsLogReport.getInstance(this.f2159h);
            eventType = TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
        } else {
            tbsLogReport = TbsLogReport.getInstance(this.f2159h);
            eventType = TbsLogReport.EventType.TYPE_DOWNLOAD;
        }
        tbsLogReport.eventReport(eventType, this.f2175x);
        this.f2175x.resetArgs();
        if (i == 100) {
            return;
        }
        QbSdk.f1753n.onDownloadFinish(i);
    }

    /* renamed from: i */
    private File m2537i() {
        return TbsDownloader.m2809a(this.f2159h) ? new File(FileUtil.m2198a(this.f2159h, 4), TbsDownloader.getBackupFileName(true)) : new File(FileUtil.m2198a(this.f2159h, 4), TbsDownloader.getOverSea(this.f2159h) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
    }

    /* renamed from: j */
    private void m2536j() {
        try {
            File m2537i = m2537i();
            if (m2537i == null || !m2537i.exists()) {
                return;
            }
            FileUtil.m2175b(m2537i);
            File[] listFiles = m2537i.getParentFile().listFiles();
            Pattern compile = Pattern.compile(C1428a.m2134a(TbsDownloader.m2809a(this.f2159h)) + "(.*)");
            for (File file : listFiles) {
                if (compile.matcher(file.getName()).find() && file.isFile() && file.exists()) {
                    FileUtil.m2175b(file);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    private boolean m2535k() {
        return new File(this.f2163l, "x5.tbs.temp").exists();
    }

    /* renamed from: l */
    private long m2534l() {
        File file = new File(this.f2163l, "x5.tbs.temp");
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    /* renamed from: m */
    private boolean m2533m() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        boolean z = false;
        try {
            inputStream = Runtime.getRuntime().exec("ping www.qq.com").getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    int i = 0;
                    do {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.contains("TTL") || readLine.contains("ttl")) {
                                z = true;
                                break;
                            } else {
                                i++;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                th.printStackTrace();
                                return z;
                            } finally {
                                m2564a(inputStream);
                                m2564a(inputStreamReader);
                                m2564a(bufferedReader);
                            }
                        }
                    } while (i < 5);
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                }
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
                inputStreamReader = null;
            }
        } catch (Throwable th5) {
            inputStreamReader = null;
            bufferedReader = null;
            th = th5;
            inputStream = null;
        }
        return z;
    }

    /* renamed from: n */
    private long m2532n() {
        int i = this.f2169r;
        return (i == 1 || i == 2) ? this.f2169r * 20000 : (i == 3 || i == 4) ? 100000L : 200000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public boolean m2531o() {
        boolean z = true;
        boolean z2 = false;
        boolean z3 = Apn.getApnType(this.f2159h) == 3;
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=", z3, TbsDownloader.LOGTAG);
        String str = null;
        HttpURLConnection httpURLConnection = null;
        if (z3) {
            String wifiSSID = Apn.getWifiSSID(this.f2159h);
            TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] localBSSID=" + wifiSSID);
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL("https://pms.mb.qq.com/rsp204").openConnection();
                try {
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setReadTimeout(10000);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.getInputStream();
                    int responseCode = httpURLConnection2.getResponseCode();
                    TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=" + responseCode);
                    if (responseCode != 204) {
                        z = false;
                    }
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception unused) {
                    }
                    str = wifiSSID;
                    z2 = z;
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = httpURLConnection2;
                    try {
                        th.printStackTrace();
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused2) {
                            }
                        }
                        str = wifiSSID;
                        if (!z2) {
                            this.f2152C.add(str);
                            m2530p();
                            this.f2151B.sendMessageDelayed(this.f2151B.obtainMessage(150, str), 120000L);
                        }
                        if (z2) {
                            this.f2152C.remove(str);
                        }
                        return z2;
                    } catch (Throwable th2) {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        if (!z2 && !TextUtils.isEmpty(str) && !this.f2152C.contains(str)) {
            this.f2152C.add(str);
            m2530p();
            this.f2151B.sendMessageDelayed(this.f2151B.obtainMessage(150, str), 120000L);
        }
        if (z2 && this.f2152C.contains(str)) {
            this.f2152C.remove(str);
        }
        return z2;
    }

    /* renamed from: p */
    private void m2530p() {
        if (this.f2151B == null) {
            this.f2151B = new Handler(HandlerThreadC1380o.m2510a().getLooper()) { // from class: com.tencent.smtt.sdk.m.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 150) {
                        C1377m.this.m2531o();
                    }
                }
            };
        }
    }

    /* renamed from: a */
    public Bundle m2572a(int i, File file, boolean z) {
        File file2;
        if (z) {
            file2 = new File(file, TbsDownloader.getBackupFileName(true));
        } else {
            file2 = new File(file, TbsDownloader.getOverSea(this.f2159h) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
        }
        int m2139a = C1428a.m2139a(this.f2159h, file2);
        File file3 = new File(this.f2163l, "x5.tbs");
        String absolutePath = file3.exists() ? file3.getAbsolutePath() : null;
        int i2 = TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        Bundle bundle = new Bundle();
        bundle.putInt("operation", i);
        bundle.putInt("old_core_ver", m2139a);
        bundle.putInt("new_core_ver", i2);
        bundle.putString("old_apk_location", file2.getAbsolutePath());
        bundle.putString("new_apk_location", absolutePath);
        bundle.putString("diff_file_location", absolutePath);
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0189  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bundle m2570a(int i, boolean z) {
        File m2437r;
        int m2446j;
        C1381p m2503a;
        Context context;
        int i2;
        File m2455f;
        Bundle bundle;
        File file;
        String str = "not_stable";
        if (!z) {
            m2437r = C1381p.m2503a().m2437r(this.f2159h);
            m2446j = C1381p.m2503a().m2446j(this.f2159h);
        } else if (C1472q.m1982b(this.f2159h)) {
            int i3 = TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_CPUTYPE_OTHER_STABLE_CORE, 0);
            m2437r = new File(this.f2164m, TbsDownloader.getBackupFileName(false, i3));
            m2446j = TbsShareManager.getTbsStableCoreVersion(this.f2159h, i3);
            str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stable_core_", i3);
        } else {
            m2437r = C1381p.m2503a().m2438q(this.f2159h);
            m2446j = C1381p.m2503a().m2448i(this.f2159h);
        }
        File file2 = new File(this.f2163l, "x5.tbs");
        String absolutePath = file2.exists() ? file2.getAbsolutePath() : null;
        if (z && C1472q.m1982b(this.f2159h)) {
            File file3 = this.f2164m;
            file2 = new File(file3, TbsDownloader.getBackupFileName(false) + ".tmp");
            absolutePath = file2.exists() ? file2.getAbsolutePath() : null;
        }
        if (absolutePath == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("gettpatchBundle tbsApkFile is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(file2.getAbsolutePath());
            TbsLog.m2155i(TbsDownloader.LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return null;
        }
        int i4 = TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        if (!z) {
            m2503a = C1381p.m2503a();
            context = this.f2159h;
            i2 = 5;
        } else if (C1472q.m1982b(this.f2159h)) {
            File file4 = this.f2164m;
            m2455f = new File(file4, TbsDownloader.getBackupFileName(false) + ".tpatch.tmp");
            bundle = new Bundle();
            bundle.putInt("operation", i);
            bundle.putInt("old_core_ver", m2446j);
            bundle.putInt("new_core_ver", i4);
            bundle.putString("old_apk_location", m2437r.getAbsolutePath());
            bundle.putString("new_apk_location", m2455f.getAbsolutePath());
            bundle.putString("diff_file_location", absolutePath);
            bundle.putString("core_type_tpatch", str);
            String m2198a = FileUtil.m2198a(this.f2159h, 7);
            file = new File(m2198a);
            if (!file.exists()) {
                file.mkdirs();
            }
            bundle.putString("backup_apk", new File(m2198a, i4 + ".tbs").getAbsolutePath());
            if (z && C1472q.m1982b(this.f2159h)) {
                bundle.putInt("for_stable_core", 1);
            }
            if (!z) {
                bundle.putInt("for_self_core", 1);
            }
            return bundle;
        } else {
            m2503a = C1381p.m2503a();
            context = this.f2159h;
            i2 = 6;
        }
        m2455f = m2503a.m2455f(context, i2);
        bundle = new Bundle();
        bundle.putInt("operation", i);
        bundle.putInt("old_core_ver", m2446j);
        bundle.putInt("new_core_ver", i4);
        bundle.putString("old_apk_location", m2437r.getAbsolutePath());
        bundle.putString("new_apk_location", m2455f.getAbsolutePath());
        bundle.putString("diff_file_location", absolutePath);
        bundle.putString("core_type_tpatch", str);
        String m2198a2 = FileUtil.m2198a(this.f2159h, 7);
        file = new File(m2198a2);
        if (!file.exists()) {
        }
        bundle.putString("backup_apk", new File(m2198a2, i4 + ".tbs").getAbsolutePath());
        if (z) {
            bundle.putInt("for_stable_core", 1);
        }
        if (!z) {
        }
        return bundle;
    }

    /* renamed from: a */
    public void m2573a(int i) {
        if (C1381p.m2503a().m2434u(this.f2159h)) {
            C1381p.m2503a().m2482b();
            try {
                File file = new File(this.f2163l, "x5.tbs");
                int m2139a = C1428a.m2139a(this.f2159h, file);
                if (-1 != m2139a && (i <= 0 || i != m2139a)) {
                    return;
                }
                FileUtil.m2175b(file);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public void m2558a(boolean z) {
        m2551b(z, false);
    }

    /* renamed from: a */
    public boolean m2574a() {
        StringBuilder sb;
        TbsLog.m2155i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
        try {
            File file = C1472q.m1982b(this.f2159h) ? new File(FileUtil.m2195a(this.f2159h, TbsConfig.APP_WX, 4, true), TbsDownloader.getBackupFileName(false)) : new File(FileUtil.m2198a(this.f2159h, 4), TbsDownloader.getBackupFileName(true));
            TbsLog.m2155i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup backupFile is " + file.getAbsolutePath());
            if (file.exists()) {
                TbsLog.m2155i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
            } else {
                File m2797b = TbsDownloader.m2797b(TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, -1));
                if (m2797b != null) {
                    TbsLog.m2155i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup getExistBackupCoreForDecouple is " + m2797b.getAbsolutePath());
                }
                if (m2797b != null && m2797b.exists()) {
                    FileUtil.m2174b(m2797b, file);
                }
                String name = m2797b.getName();
                TbsLog.m2155i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup fileNameSource is " + name);
                int i = 32;
                if (name.contains("64")) {
                    i = 64;
                }
                if (C1472q.m1982b(this.f2159h)) {
                    File[] listFiles = this.f2164m.listFiles();
                    Pattern compile = Pattern.compile(C1428a.m2133a(false, i));
                    for (File file2 : listFiles) {
                        if (compile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                            file2.delete();
                            TbsLog.m2155i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup delete file " + file2.getAbsolutePath());
                        }
                    }
                    File file3 = new File(this.f2164m, C1428a.m2133a(false, i) + "." + TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, -1));
                    if (file3.exists()) {
                        sb = new StringBuilder();
                        sb.append("verifyAndInstallDecoupleCoreFromBackup  file already exist ");
                        sb.append(file3.getAbsolutePath());
                    } else {
                        file3.createNewFile();
                        sb = new StringBuilder();
                        sb.append("verifyAndInstallDecoupleCoreFromBackup create file ");
                        sb.append(file3.getAbsolutePath());
                    }
                    TbsLog.m2155i("TbsApkDownloader", sb.toString());
                }
            }
            if (C1428a.m2137a(this.f2159h, file, 0L, TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, -1))) {
                TbsLog.m2155i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
                if (C1472q.m1982b(this.f2159h)) {
                    TbsLog.m2155i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup isStableCoreForHostEnable and return true");
                    return true;
                }
                TbsLog.m2155i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup goto installDecoupleCoreFromBackup");
                return C1381p.m2503a().m2456f(this.f2159h);
            }
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(e));
            TbsLog.m2155i("TbsApkDownloader", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00fa  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m2557a(boolean z, boolean z2) {
        String str;
        boolean z3;
        File m2537i;
        TbsLogReport tbsLogReport;
        TbsLogReport.EventType eventType;
        if (Build.VERSION.SDK_INT == 23) {
            return false;
        }
        int i = TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        int m2446j = C1381p.m2503a().m2446j(this.f2159h);
        if (i == 0) {
            i = TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            str = "by default key";
        } else {
            str = "by new key";
        }
        this.f2155a = str;
        if (i != 0 && i != m2446j) {
            if (z2) {
                File m2811a = TbsDownloader.m2811a(i);
                if (m2811a != null && m2811a.exists()) {
                    File file = new File(FileUtil.m2198a(this.f2159h, 4), TbsDownloader.getOverSea(this.f2159h) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
                    try {
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1) {
                        FileUtil.m2174b(m2811a, file);
                        z3 = true;
                        m2537i = m2537i();
                        if (m2537i != null || !m2537i.exists() || !m2563a(m2537i)) {
                            if (!C1472q.m1982b(this.f2159h)) {
                                m2536j();
                            }
                            if (m2811a != null && m2811a.exists() && !C1428a.m2137a(this.f2159h, m2811a, 0L, i) && m2811a.exists()) {
                                FileUtil.m2175b(m2811a);
                            }
                        } else if (m2554b(i)) {
                            TbsDownloadConfig.getInstance(this.f2159h).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -214);
                            TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-214);
                            m2544d(false);
                            if (z3) {
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("use local backup apk in startDownload");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2155a);
                                m2571a(100, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), true);
                                if (TbsDownloader.m2809a(this.f2159h)) {
                                    tbsLogReport = TbsLogReport.getInstance(this.f2159h);
                                    eventType = TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
                                } else {
                                    tbsLogReport = TbsLogReport.getInstance(this.f2159h);
                                    eventType = TbsLogReport.EventType.TYPE_DOWNLOAD;
                                }
                                tbsLogReport.eventReport(eventType, this.f2175x);
                                this.f2175x.resetArgs();
                            }
                            return true;
                        }
                    }
                }
                z3 = false;
                m2537i = m2537i();
                if (m2537i != null) {
                }
                if (!C1472q.m1982b(this.f2159h)) {
                }
                if (m2811a != null) {
                    FileUtil.m2175b(m2811a);
                }
            }
            if (m2547c(false, z2)) {
                TbsDownloadConfig.getInstance(this.f2159h).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -214);
                TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-214);
                m2544d(false);
                return true;
            } else if (!m2541e(true) && !m2541e(true)) {
                TbsLog.m2158e(TbsDownloader.LOGTAG, "[TbsApkDownloader] delete file failed!");
                TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-301);
            }
        }
        return false;
    }

    /* renamed from: b */
    public void m2555b() {
        TbsLogReport tbsLogReport;
        TbsLogReport.EventType eventType;
        this.f2171t = true;
        if (TbsShareManager.isThirdPartyApp(this.f2159h)) {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(this.f2159h).tbsLogInfo();
            tbsLogInfo.setErrorCode(-309);
            tbsLogInfo.setFailDetail(new Exception());
            if (TbsDownloader.m2809a(this.f2159h)) {
                tbsLogReport = TbsLogReport.getInstance(this.f2159h);
                eventType = TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
            } else {
                tbsLogReport = TbsLogReport.getInstance(this.f2159h);
                eventType = TbsLogReport.EventType.TYPE_DOWNLOAD;
            }
            tbsLogReport.eventReport(eventType, tbsLogInfo);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:97|(5:102|(5:155|156|157|158|(5:160|161|162|163|(5:165|166|168|(1:170)|171)(4:202|203|204|(1:206)))(3:212|213|(3:268|269|(1:271))(2:217|(1:(3:220|221|222))(2:223|(2:235|(2:253|(1:1)(1:259))(2:245|(3:249|250|(1:252))(1:(3:248|221|222))))(2:227|(3:231|232|(1:234))(1:(3:230|221|222)))))))(3:106|107|(3:109|(1:111)|112)(3:116|117|118))|113|114|115)|275|276|277|278|279|280|281|(7:286|287|288|(18:302|303|(3:558|559|(15:561|309|310|311|(3:521|522|(15:524|525|526|527|528|529|530|(1:532)|316|317|318|319|(3:320|321|(1:496)(4:323|324|325|(1:471)(9:327|328|(2:330|(1:399)(4:332|333|334|(2:336|337)))|417|418|419|420|(6:425|426|(2:428|429)(1:451)|(1:450)(2:433|(1:447)(4:442|443|(1:445)|446))|448|449)(2:422|423)|424)))|338|(8:341|342|(1:344)(1:347)|345|346|187|188|115)(1:340)))|313|314|315|316|317|318|319|(4:320|321|(0)(0)|424)|338|(0)(0)))|(1:557)(1:308)|309|310|311|(0)|313|314|315|316|317|318|319|(4:320|321|(0)(0)|424)|338|(0)(0))(1:290)|291|292|(2:294|296)(1:298))(3:581|582|(1:1)(2:594|(1:1)(0)))) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:(2:302|303)|(3:558|559|(15:561|309|310|311|(3:521|522|(15:524|525|526|527|528|529|530|(1:532)|316|317|318|319|(3:320|321|(1:496)(4:323|324|325|(1:471)(9:327|328|(2:330|(1:399)(4:332|333|334|(2:336|337)))|417|418|419|420|(6:425|426|(2:428|429)(1:451)|(1:450)(2:433|(1:447)(4:442|443|(1:445)|446))|448|449)(2:422|423)|424)))|338|(8:341|342|(1:344)(1:347)|345|346|187|188|115)(1:340)))|313|314|315|316|317|318|319|(4:320|321|(0)(0)|424)|338|(0)(0)))|(1:557)(1:308)|309|310|311|(0)|313|314|315|316|317|318|319|(4:320|321|(0)(0)|424)|338|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(18:302|303|(3:558|559|(15:561|309|310|311|(3:521|522|(15:524|525|526|527|528|529|530|(1:532)|316|317|318|319|(3:320|321|(1:496)(4:323|324|325|(1:471)(9:327|328|(2:330|(1:399)(4:332|333|334|(2:336|337)))|417|418|419|420|(6:425|426|(2:428|429)(1:451)|(1:450)(2:433|(1:447)(4:442|443|(1:445)|446))|448|449)(2:422|423)|424)))|338|(8:341|342|(1:344)(1:347)|345|346|187|188|115)(1:340)))|313|314|315|316|317|318|319|(4:320|321|(0)(0)|424)|338|(0)(0)))|(1:557)(1:308)|309|310|311|(0)|313|314|315|316|317|318|319|(4:320|321|(0)(0)|424)|338|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x04e6, code lost:
        if (r35 == false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x04ea, code lost:
        r6 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x070f, code lost:
        r3 = r6;
        r4 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02b2, code lost:
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r34.f2159h).mSyncMap.put(r11, java.lang.Long.valueOf(r8));
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r34.f2159h).commit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0cf9, code lost:
        if (r35 == false) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x06f7, code lost:
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r34.f2159h).mSyncMap.put(r11, java.lang.Long.valueOf(r8));
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r34.f2159h).commit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x05eb, code lost:
        if (r35 == false) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x05fa, code lost:
        if (r35 != false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0b3d, code lost:
        if (r35 != false) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x0c0c, code lost:
        if (r35 != false) goto L380;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x0c46, code lost:
        r4 = r19;
        r8 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x0c2e, code lost:
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r34.f2159h).mSyncMap.put(r14, java.lang.Long.valueOf(r24));
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r34.f2159h).commit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x0c2c, code lost:
        if (r35 != false) goto L380;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x08a6, code lost:
        com.tencent.smtt.utils.TbsLog.m2153i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...failed because you exceeded max flow!", true);
        r9 = new java.lang.StringBuilder();
        r9.append("downloadFlow=");
        r9.append(r5);
        r9.append(" downloadMaxflow=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x08c0, code lost:
        r11 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x08c2, code lost:
        r9.append(r11);
        m2571a(112, r9.toString(), true);
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r34.f2159h).setDownloadInterruptCode(-307);
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x08d8, code lost:
        r24 = r5;
        r16 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x08e4, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x08e5, code lost:
        r8 = r0;
        r16 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x08de, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x08df, code lost:
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x084b, code lost:
        if (r34.f2156b == null) goto L481;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x0852, code lost:
        if (m2547c(true, r6) != false) goto L481;
     */
    /* JADX WARN: Code restructure failed: missing block: B:476:0x0854, code lost:
        if (r35 != false) goto L480;
     */
    /* JADX WARN: Code restructure failed: missing block: B:478:0x085a, code lost:
        if (m2552b(false) == false) goto L480;
     */
    /* JADX WARN: Code restructure failed: missing block: B:479:0x085c, code lost:
        r3 = r6;
        r8 = r24;
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:480:0x0863, code lost:
        r34.f2172u = true;
        r3 = r6;
        r19 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:481:0x086c, code lost:
        r34.f2172u = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:482:0x0871, code lost:
        if (r34.f2156b == null) goto L484;
     */
    /* JADX WARN: Code restructure failed: missing block: B:483:0x0873, code lost:
        r19 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:484:0x0876, code lost:
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r34.f2159h).setDownloadInterruptCode(-311);
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x0881, code lost:
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:497:0x0816, code lost:
        com.tencent.smtt.utils.TbsLog.m2153i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...Canceled!", true);
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r34.f2159h).setDownloadInterruptCode(-309);
     */
    /* JADX WARN: Code restructure failed: missing block: B:498:0x0827, code lost:
        r26 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:510:0x0ab1, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:511:0x0ab2, code lost:
        r20 = r14;
        r19 = r15;
        r14 = r11;
        r11 = r3;
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:512:0x0aa6, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:513:0x0aa7, code lost:
        r11 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:515:0x0ac7, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:516:0x0ac8, code lost:
        r20 = r14;
        r19 = r15;
        r14 = r11;
        r11 = r3;
        r3 = r6;
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:517:0x0aef, code lost:
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:518:0x0abc, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:519:0x0abd, code lost:
        r11 = r3;
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:520:0x0adf, code lost:
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:553:0x0ae2, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:554:0x0ae3, code lost:
        r18 = r7;
        r24 = r8;
        r20 = r14;
        r19 = r15;
        r14 = r11;
        r11 = r3;
        r3 = r6;
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:555:0x0ad2, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:556:0x0ad3, code lost:
        r11 = r3;
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:592:0x06f5, code lost:
        if (r35 == false) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:598:0x0693, code lost:
        if (r35 == false) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:601:0x06b7, code lost:
        m2571a(113, "tbsApkFileSize=" + r3 + "  but contentLength=" + r34.f2165n, true);
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r34.f2159h).setDownloadInterruptCode(-310);
     */
    /* JADX WARN: Code restructure failed: missing block: B:606:0x0c68, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:607:0x0c69, code lost:
        r3 = r6;
        r18 = r7;
        r24 = r8;
        r20 = r14;
        r19 = r15;
        r14 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:608:0x0c7f, code lost:
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:610:0x0c74, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:611:0x0c75, code lost:
        r3 = r6;
        r18 = r7;
        r24 = r8;
        r20 = r14;
        r19 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:612:0x0c7e, code lost:
        r14 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:667:0x02b0, code lost:
        if (r35 == false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:682:0x01f2, code lost:
        r15 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0d03  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0db4  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0dc8  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0ca0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0e00  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0cee A[EDGE_INSN: B:191:0x0cee->B:192:0x0cee ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:323:0x083e  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0a3d  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0a09 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0b74 A[Catch: all -> 0x0c51, TryCatch #23 {all -> 0x0c51, blocks: (B:358:0x0b6d, B:360:0x0b74, B:364:0x0b7c, B:367:0x0b84, B:373:0x0be5, B:375:0x0bee, B:376:0x0bff, B:384:0x0bf5, B:386:0x0c12), top: B:357:0x0b6d }] */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0bee A[Catch: all -> 0x0c51, TryCatch #23 {all -> 0x0c51, blocks: (B:358:0x0b6d, B:360:0x0b74, B:364:0x0b7c, B:367:0x0b84, B:373:0x0be5, B:375:0x0bee, B:376:0x0bff, B:384:0x0bf5, B:386:0x0c12), top: B:357:0x0b6d }] */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0bf5 A[Catch: all -> 0x0c51, TryCatch #23 {all -> 0x0c51, blocks: (B:358:0x0b6d, B:360:0x0b74, B:364:0x0b7c, B:367:0x0b84, B:373:0x0be5, B:375:0x0bee, B:376:0x0bff, B:384:0x0bf5, B:386:0x0c12), top: B:357:0x0b6d }] */
    /* JADX WARN: Removed duplicated region for block: B:496:0x0816 A[EDGE_INSN: B:496:0x0816->B:497:0x0816 ?: BREAK  , EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:521:0x0769 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:613:0x0480 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x041f A[Catch: all -> 0x0402, TRY_ENTER, TRY_LEAVE, TryCatch #42 {all -> 0x0402, blocks: (B:619:0x03f8, B:621:0x03fd, B:80:0x041f, B:83:0x0449, B:85:0x0451, B:87:0x045a, B:89:0x0462, B:91:0x0468, B:93:0x046f, B:94:0x0476, B:614:0x0480, B:107:0x04a0, B:109:0x04ae, B:118:0x04d8, B:75:0x0408, B:638:0x03bb), top: B:618:0x03f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x046f A[Catch: all -> 0x0402, TryCatch #42 {all -> 0x0402, blocks: (B:619:0x03f8, B:621:0x03fd, B:80:0x041f, B:83:0x0449, B:85:0x0451, B:87:0x045a, B:89:0x0462, B:91:0x0468, B:93:0x046f, B:94:0x0476, B:614:0x0480, B:107:0x04a0, B:109:0x04ae, B:118:0x04d8, B:75:0x0408, B:638:0x03bb), top: B:618:0x03f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x048e  */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.tencent.smtt.sdk.TbsLogReport$TbsLogInfo] */
    /* JADX WARN: Type inference failed for: r34v0, types: [com.tencent.smtt.sdk.m] */
    /* JADX WARN: Type inference failed for: r4v18, types: [int] */
    /* JADX WARN: Type inference failed for: r4v192 */
    /* JADX WARN: Type inference failed for: r4v193 */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m2551b(boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        ?? r4;
        boolean z7;
        long j;
        Throwable th;
        String str;
        String str2;
        boolean z8;
        String str3;
        long j2;
        String str4;
        long j3;
        long j4;
        long j5;
        Throwable th2;
        int apnType;
        String apnInfo;
        InputStream inputStream;
        Throwable th3;
        FileOutputStream fileOutputStream;
        long j6;
        InputStream inputStream2;
        IOException iOException;
        InputStream inputStream3;
        InputStream inputStream4;
        Throwable th4;
        Throwable th5;
        String m2560a;
        int i2;
        Throwable th6;
        boolean z9;
        InputStream inputStream5;
        String contentEncoding;
        Throwable th7;
        FileOutputStream fileOutputStream2;
        InputStream inputStream6;
        IOException iOException2;
        FileOutputStream fileOutputStream3;
        InputStream inputStream7;
        InputStream inputStream8;
        String str5;
        byte[] bArr;
        File file;
        long j7;
        IOException iOException3;
        boolean z10;
        InputStream inputStream9;
        long j8;
        long j9;
        long j10;
        byte[] bArr2;
        long j11;
        String str6;
        InputStream inputStream10;
        String str7 = TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME;
        if (C1381p.m2503a().m2465d(this.f2159h) && !z) {
            TbsDownloader.f1858a = false;
            TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-322);
            QbSdk.f1753n.onDownloadFinish(-322);
            return;
        }
        int i3 = TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
        boolean z11 = i3 == 1 || i3 == 2 || i3 == 4;
        if (!z2 && m2557a(z, z11)) {
            TbsDownloader.f1858a = false;
            QbSdk.f1753n.onDownloadFinish(130);
            return;
        }
        this.f2154E = z;
        this.f2160i = TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, null);
        String string = TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADURL_LIST, null);
        TbsLog.m2153i(TbsDownloader.LOGTAG, "backupUrlStrings:" + string, true);
        this.f2156b = null;
        this.f2157c = 0;
        if (!z && string != null && !"".equals(string.trim())) {
            this.f2156b = string.trim().split(";");
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[TbsApkDownloader.startDownload] mDownloadUrl=");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.f2160i, " backupUrlStrings=", string, " mLocation=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2162k);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" mCanceled=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2171t);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" mHttpRequest=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2173v);
        TbsLog.m2155i(TbsDownloader.LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        if (this.f2160i == null && this.f2162k == null) {
            QbSdk.f1753n.onDownloadFinish(110);
            TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-302);
        } else if (this.f2173v != null && !this.f2171t) {
            QbSdk.f1753n.onDownloadFinish(110);
            TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-303);
        } else if (!z && this.f2152C.contains(Apn.getWifiSSID(this.f2159h))) {
            TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] WIFI Unavailable");
            QbSdk.f1753n.onDownloadFinish(110);
            TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-304);
        } else {
            m2539g();
            TbsLog.m2153i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...", true);
            long downloadMaxflow = TbsDownloadConfig.getInstance(this.f2159h).getDownloadMaxflow();
            SharedPreferences sharedPreferences = TbsDownloadConfig.getInstance(this.f2159h).mPreferences;
            String str8 = TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW;
            long j12 = sharedPreferences.getLong(str8, 0L);
            this.f2153D = z ? f2148f : f2147e;
            String str9 = TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE;
            if (z2) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("downloadVersion=is=");
                z3 = z11;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), "_", "apkSize=is=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getLong(str9, 0L));
                C1472q.m1981b(this.f2159h, "start_download", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            } else {
                z3 = z11;
                if (TbsShareManager.isThirdPartyApp(this.f2159h)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("downloadVersion=is=");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), "_", "apkSize=is=");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getLong(str9, 0L));
                    C1472q.m1986a(this.f2159h, "start_download", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                }
            }
            boolean z12 = false;
            long j13 = j12;
            while (true) {
                if (this.f2169r > this.f2153D) {
                    break;
                } else if (this.f2170s > 8) {
                    m2571a(123, null, true);
                    TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-306);
                    break;
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!z) {
                        try {
                            z4 = z12;
                            j = downloadMaxflow;
                            try {
                                if (currentTimeMillis - TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getLong(str7, 0L) > 86400000) {
                                    TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] OVER DOWNLOAD_PERIOD");
                                    TbsDownloadConfig.getInstance(this.f2159h).mSyncMap.put(str7, Long.valueOf(currentTimeMillis));
                                    TbsDownloadConfig.getInstance(this.f2159h).mSyncMap.put(str8, 0L);
                                    TbsDownloadConfig.getInstance(this.f2159h).commit();
                                    j13 = 0;
                                } else {
                                    TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] downloadFlow=" + j13);
                                    if (j13 >= j) {
                                        TbsLog.m2153i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...failed because you exceeded max flow!", true);
                                        m2571a(112, null, true);
                                        TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-307);
                                        if (!z) {
                                        }
                                    }
                                }
                                if (!FileUtil.m2178b(this.f2159h)) {
                                    TbsLog.m2153i(TbsDownloader.LOGTAG, "DownloadBegin FreeSpace too small", true);
                                    m2571a(105, null, true);
                                    TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-308);
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                th = th;
                                str = str7;
                                str2 = str8;
                                z8 = z4;
                                z6 = z3;
                                str3 = str9;
                                try {
                                    if (th instanceof SSLHandshakeException) {
                                    }
                                    th.printStackTrace();
                                    m2569a(0L);
                                    m2571a(107, m2560a(th), false);
                                    if (this.f2171t) {
                                    }
                                    TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-316);
                                    if (!z) {
                                    }
                                    str8 = str2;
                                    downloadMaxflow = j;
                                    str9 = str3;
                                    z12 = z8;
                                    z3 = z6;
                                    str7 = str;
                                } finally {
                                    if (!z) {
                                        TbsDownloadConfig.getInstance(this.f2159h).mSyncMap.put(str2, Long.valueOf(j13));
                                        TbsDownloadConfig.getInstance(this.f2159h).commit();
                                    }
                                }
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            z4 = z12;
                            j = downloadMaxflow;
                        }
                    } else {
                        z4 = z12;
                        j = downloadMaxflow;
                    }
                    try {
                        this.f2150A = true;
                        String str10 = this.f2162k != null ? this.f2162k : this.f2160i;
                        TbsLog.m2153i(TbsDownloader.LOGTAG, "try url:" + str10 + ",mRetryTimes:" + this.f2169r, true);
                        if (!str10.equals(this.f2161j)) {
                            this.f2175x.setDownloadUrl(str10);
                        }
                        this.f2161j = str10;
                        m2561a(str10);
                        if (!this.f2168q) {
                            try {
                                long m2534l = m2534l();
                                TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] range=" + m2534l);
                                j3 = currentTimeMillis;
                                try {
                                    if (this.f2165n <= 0) {
                                        try {
                                            TbsLog.m2153i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...current" + m2534l, true);
                                            this.f2173v.setRequestProperty("Range", BytesRange.PREFIX + m2534l + "-");
                                            str4 = str7;
                                            j4 = m2534l;
                                        } catch (Throwable th10) {
                                            th = th10;
                                            str4 = str7;
                                            z7 = z3;
                                            th2 = th;
                                            th = th2;
                                            z6 = z7;
                                            str3 = str9;
                                            j2 = j13;
                                            str = str4;
                                            z8 = z4;
                                            str2 = str8;
                                            j13 = j2;
                                            if (th instanceof SSLHandshakeException) {
                                            }
                                            th.printStackTrace();
                                            m2569a(0L);
                                            m2571a(107, m2560a(th), false);
                                            if (this.f2171t) {
                                            }
                                            TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-316);
                                            if (!z) {
                                            }
                                            str8 = str2;
                                            downloadMaxflow = j;
                                            str9 = str3;
                                            z12 = z8;
                                            z3 = z6;
                                            str7 = str;
                                        }
                                    } else {
                                        TbsLog.m2153i(TbsDownloader.LOGTAG, "#1 STEP 1/2 begin downloading...current/total=" + m2534l + "/" + this.f2165n, true);
                                        HttpURLConnection httpURLConnection = this.f2173v;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(BytesRange.PREFIX);
                                        sb.append(m2534l);
                                        sb.append("-");
                                        str4 = str7;
                                        j4 = m2534l;
                                        sb.append(this.f2165n);
                                        httpURLConnection.setRequestProperty("Range", sb.toString());
                                    }
                                    j5 = j4;
                                } catch (Throwable th11) {
                                    th = th11;
                                    str4 = str7;
                                    th2 = th;
                                    z7 = z3;
                                    th = th2;
                                    z6 = z7;
                                    str3 = str9;
                                    j2 = j13;
                                    str = str4;
                                    z8 = z4;
                                    str2 = str8;
                                    j13 = j2;
                                    if (th instanceof SSLHandshakeException) {
                                    }
                                    th.printStackTrace();
                                    m2569a(0L);
                                    m2571a(107, m2560a(th), false);
                                    if (this.f2171t) {
                                    }
                                    TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-316);
                                    if (!z) {
                                    }
                                    str8 = str2;
                                    downloadMaxflow = j;
                                    str9 = str3;
                                    z12 = z8;
                                    z3 = z6;
                                    str7 = str;
                                }
                            } catch (Throwable th12) {
                                th = th12;
                                str4 = str7;
                            }
                        } else {
                            str4 = str7;
                            j3 = currentTimeMillis;
                            j5 = 0;
                        }
                        try {
                            this.f2175x.setDownloadCancel(j5 == 0 ? 0 : 1);
                            apnType = Apn.getApnType(this.f2159h);
                            apnInfo = Apn.getApnInfo(this.f2159h);
                        } catch (Throwable th13) {
                            th = th13;
                            j2 = j13;
                            str = str4;
                            z8 = z4;
                            z6 = z3;
                            str3 = str9;
                        }
                    } catch (Throwable th14) {
                        th = th14;
                        str = str7;
                        j2 = j13;
                        str2 = str8;
                        z8 = z4;
                        z6 = z3;
                        str3 = str9;
                    }
                    if (this.f2176y == null) {
                        try {
                        } catch (Throwable th15) {
                            th = th15;
                            th2 = th;
                            z7 = z3;
                            th = th2;
                            z6 = z7;
                            str3 = str9;
                            j2 = j13;
                            str = str4;
                            z8 = z4;
                            str2 = str8;
                            j13 = j2;
                            if (th instanceof SSLHandshakeException) {
                            }
                            th.printStackTrace();
                            m2569a(0L);
                            m2571a(107, m2560a(th), false);
                            if (this.f2171t) {
                            }
                            TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-316);
                            if (!z) {
                            }
                            str8 = str2;
                            downloadMaxflow = j;
                            str9 = str3;
                            z12 = z8;
                            z3 = z6;
                            str7 = str;
                        }
                        if (this.f2177z == -1) {
                            this.f2176y = apnInfo;
                            this.f2177z = apnType;
                            if (this.f2169r >= 1) {
                                this.f2173v.addRequestProperty("Referer", this.f2160i);
                            }
                            int responseCode = this.f2173v.getResponseCode();
                            TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] responseCode=" + responseCode);
                            this.f2175x.setHttpCode(responseCode);
                            if (!z && !TbsDownloader.getOverSea(this.f2159h) && ((Apn.getApnType(this.f2159h) != 3 || Apn.getApnType(this.f2159h) == 0) && !QbSdk.getDownloadWithoutWifi())) {
                                m2555b();
                                if (QbSdk.f1753n != null) {
                                    QbSdk.f1753n.onDownloadFinish(111);
                                }
                                TbsLog.m2153i(TbsDownloader.LOGTAG, "Download is canceled due to NOT_WIFI error!", false);
                            }
                            if (!this.f2171t) {
                                TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-309);
                                if (!z) {
                                }
                            } else {
                                if (responseCode != 200 && responseCode != 206) {
                                    if (responseCode < 300 || responseCode > 307) {
                                        try {
                                            m2571a(102, String.valueOf(responseCode), false);
                                            if (responseCode == 416) {
                                                z7 = z3;
                                                try {
                                                    if (m2547c(true, z7)) {
                                                        try {
                                                            TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-214);
                                                            if (!z) {
                                                                TbsDownloadConfig.getInstance(this.f2159h).mSyncMap.put(str8, Long.valueOf(j13));
                                                                TbsDownloadConfig.getInstance(this.f2159h).commit();
                                                            }
                                                            z5 = true;
                                                            z6 = z7;
                                                        } catch (Throwable th16) {
                                                            th = th16;
                                                            z6 = z7;
                                                            str3 = str9;
                                                            str = str4;
                                                            z8 = true;
                                                            str2 = str8;
                                                            if ((th instanceof SSLHandshakeException) || z || this.f2156b == null || !m2552b(false)) {
                                                                th.printStackTrace();
                                                                m2569a(0L);
                                                                m2571a(107, m2560a(th), false);
                                                                if (this.f2171t) {
                                                                    TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-309);
                                                                }
                                                            } else {
                                                                TbsLog.m2158e(TbsDownloader.LOGTAG, "[startdownload]url:" + this.f2162k + " download exception：" + th.toString());
                                                                m2571a(125, null, true);
                                                            }
                                                            TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-316);
                                                            if (!z) {
                                                                TbsDownloadConfig.getInstance(this.f2159h).mSyncMap.put(str2, Long.valueOf(j13));
                                                                TbsDownloadConfig.getInstance(this.f2159h).commit();
                                                            }
                                                            str8 = str2;
                                                            downloadMaxflow = j;
                                                            str9 = str3;
                                                            z12 = z8;
                                                            z3 = z6;
                                                            str7 = str;
                                                        }
                                                    } else {
                                                        m2541e(false);
                                                        TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-313);
                                                        if (!z) {
                                                        }
                                                    }
                                                } catch (Throwable th17) {
                                                    th2 = th17;
                                                    th = th2;
                                                    z6 = z7;
                                                    str3 = str9;
                                                    j2 = j13;
                                                    str = str4;
                                                    z8 = z4;
                                                    str2 = str8;
                                                    j13 = j2;
                                                    if (th instanceof SSLHandshakeException) {
                                                    }
                                                    th.printStackTrace();
                                                    m2569a(0L);
                                                    m2571a(107, m2560a(th), false);
                                                    if (this.f2171t) {
                                                    }
                                                    TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-316);
                                                    if (!z) {
                                                    }
                                                    str8 = str2;
                                                    downloadMaxflow = j;
                                                    str9 = str3;
                                                    z12 = z8;
                                                    z3 = z6;
                                                    str7 = str;
                                                }
                                            } else {
                                                z7 = z3;
                                                if ((responseCode == 403 || responseCode == 406) && this.f2165n == -1) {
                                                    TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-314);
                                                    if (!z) {
                                                    }
                                                } else if (responseCode == 202) {
                                                    if (!z) {
                                                        TbsDownloadConfig.getInstance(this.f2159h).mSyncMap.put(str8, Long.valueOf(j13));
                                                        TbsDownloadConfig.getInstance(this.f2159h).commit();
                                                    }
                                                } else if (this.f2169r < this.f2153D && responseCode == 503) {
                                                    m2569a(Long.parseLong(this.f2173v.getHeaderField("Retry-After")));
                                                    if (this.f2171t) {
                                                        TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-309);
                                                        if (!z) {
                                                        }
                                                    } else if (!z) {
                                                        TbsDownloadConfig.getInstance(this.f2159h).mSyncMap.put(str8, Long.valueOf(j13));
                                                        TbsDownloadConfig.getInstance(this.f2159h).commit();
                                                    }
                                                } else if (this.f2169r < this.f2153D && (responseCode == 408 || responseCode == 504 || responseCode == 502 || responseCode == 408)) {
                                                    m2569a(0L);
                                                    if (this.f2171t) {
                                                        TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-309);
                                                        if (!z) {
                                                        }
                                                    } else if (!z) {
                                                        TbsDownloadConfig.getInstance(this.f2159h).mSyncMap.put(str8, Long.valueOf(j13));
                                                        TbsDownloadConfig.getInstance(this.f2159h).commit();
                                                    }
                                                } else if (m2534l() > 0 || this.f2168q || responseCode == 410) {
                                                    break;
                                                } else {
                                                    this.f2168q = true;
                                                }
                                            }
                                        } catch (Throwable th18) {
                                            th = th18;
                                            z7 = z3;
                                            th2 = th;
                                            th = th2;
                                            z6 = z7;
                                            str3 = str9;
                                            j2 = j13;
                                            str = str4;
                                            z8 = z4;
                                            str2 = str8;
                                            j13 = j2;
                                            if (th instanceof SSLHandshakeException) {
                                            }
                                            th.printStackTrace();
                                            m2569a(0L);
                                            m2571a(107, m2560a(th), false);
                                            if (this.f2171t) {
                                            }
                                            TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-316);
                                            if (!z) {
                                            }
                                            str8 = str2;
                                            downloadMaxflow = j;
                                            str9 = str3;
                                            z12 = z8;
                                            z3 = z6;
                                            str7 = str;
                                        }
                                    } else {
                                        String headerField = this.f2173v.getHeaderField("Location");
                                        if (!TextUtils.isEmpty(headerField)) {
                                            this.f2162k = headerField;
                                            this.f2170s++;
                                            z7 = z3;
                                        } else {
                                            m2571a(124, null, true);
                                            TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-312);
                                        }
                                    }
                                    z3 = z7;
                                    str7 = str4;
                                    z12 = z4;
                                    downloadMaxflow = j;
                                }
                                z7 = z3;
                                this.f2165n = this.f2173v.getContentLength() + j5;
                                TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] mContentLength=" + this.f2165n);
                                this.f2175x.setPkgSize(this.f2165n);
                                long j14 = j5;
                                long j15 = TbsDownloadConfig.getInstance(this.f2159h).mPreferences.getLong(str9, 0L);
                                if (j15 == 0 || this.f2165n == j15) {
                                    TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] begin readResponse");
                                    try {
                                        inputStream5 = this.f2173v.getInputStream();
                                    } catch (IOException e) {
                                        z6 = z7;
                                        str3 = str9;
                                        j6 = j13;
                                        str = str4;
                                        z8 = z4;
                                        str2 = str8;
                                        inputStream2 = null;
                                        iOException = e;
                                        fileOutputStream = null;
                                    } catch (Throwable th19) {
                                        inputStream = null;
                                        th3 = th19;
                                        fileOutputStream = null;
                                    }
                                    if (inputStream5 != null) {
                                        try {
                                            contentEncoding = this.f2173v.getContentEncoding();
                                        } catch (IOException e2) {
                                            str3 = str9;
                                            j6 = j13;
                                            str = str4;
                                            z8 = z4;
                                            str2 = str8;
                                            z6 = z7;
                                            iOException = e2;
                                            fileOutputStream = null;
                                            inputStream2 = inputStream5;
                                            inputStream3 = null;
                                            inputStream4 = inputStream2;
                                            try {
                                                iOException.printStackTrace();
                                                if (!(iOException instanceof SocketTimeoutException)) {
                                                }
                                                this.f2166o = FastDtoa.kTen5;
                                                m2569a(0L);
                                                m2571a(103, m2560a(iOException), false);
                                                m2564a(fileOutputStream);
                                                m2564a(inputStream3);
                                                m2564a(inputStream4);
                                            } catch (Throwable th20) {
                                                th5 = th20;
                                                th4 = th5;
                                                th3 = th4;
                                                m2564a(fileOutputStream);
                                                m2564a(inputStream3);
                                                m2564a(inputStream4);
                                                throw th3;
                                            }
                                        } catch (Throwable th21) {
                                            th3 = th21;
                                            fileOutputStream = null;
                                            inputStream = inputStream5;
                                            inputStream3 = null;
                                            inputStream4 = inputStream;
                                            m2564a(fileOutputStream);
                                            m2564a(inputStream3);
                                            m2564a(inputStream4);
                                            throw th3;
                                        }
                                        if (contentEncoding != null) {
                                            try {
                                            } catch (IOException e3) {
                                                iOException2 = e3;
                                                fileOutputStream3 = null;
                                                inputStream7 = null;
                                                str3 = str9;
                                                j6 = j13;
                                                inputStream8 = inputStream5;
                                                iOException = iOException2;
                                                z6 = z7;
                                                str5 = str8;
                                                inputStream3 = inputStream7;
                                                str = str4;
                                                fileOutputStream = fileOutputStream3;
                                                z8 = z4;
                                                str2 = str5;
                                                inputStream4 = inputStream8;
                                                iOException.printStackTrace();
                                                if (!(iOException instanceof SocketTimeoutException)) {
                                                }
                                                this.f2166o = FastDtoa.kTen5;
                                                m2569a(0L);
                                                m2571a(103, m2560a(iOException), false);
                                                m2564a(fileOutputStream);
                                                m2564a(inputStream3);
                                                m2564a(inputStream4);
                                            } catch (Throwable th22) {
                                                th7 = th22;
                                                fileOutputStream2 = null;
                                                inputStream6 = null;
                                                inputStream8 = inputStream5;
                                                th3 = th7;
                                                str5 = str8;
                                                inputStream3 = inputStream6;
                                                fileOutputStream = fileOutputStream2;
                                                inputStream4 = inputStream8;
                                                m2564a(fileOutputStream);
                                                m2564a(inputStream3);
                                                m2564a(inputStream4);
                                                throw th3;
                                            }
                                            if (contentEncoding.contains("gzip")) {
                                                inputStream3 = new GZIPInputStream(inputStream5);
                                                bArr = new byte[8192];
                                                if (z2) {
                                                    try {
                                                    } catch (IOException e4) {
                                                        e = e4;
                                                        str3 = str9;
                                                    } catch (Throwable th23) {
                                                        th = th23;
                                                    }
                                                    if (C1472q.m1982b(this.f2159h)) {
                                                        File file2 = this.f2164m;
                                                        str3 = str9;
                                                        try {
                                                            StringBuilder sb2 = new StringBuilder();
                                                            j6 = j13;
                                                            try {
                                                                sb2.append(TbsDownloader.getBackupFileName(false));
                                                                sb2.append(".");
                                                                sb2.append("tmp");
                                                                file = new File(file2, sb2.toString());
                                                                if (file.exists()) {
                                                                    file.delete();
                                                                }
                                                                TbsLog.m2153i(TbsDownloader.LOGTAG, "fileDownloadApk is " + file.getAbsolutePath(), true);
                                                                fileOutputStream = new FileOutputStream(file, true);
                                                                long currentTimeMillis2 = System.currentTimeMillis();
                                                                str5 = str8;
                                                                long j16 = j14;
                                                                long j17 = j3;
                                                                str = str4;
                                                                z8 = z4;
                                                                j7 = j17;
                                                                while (true) {
                                                                    try {
                                                                        if (this.f2171t) {
                                                                            try {
                                                                                break;
                                                                            } catch (IOException e5) {
                                                                                iOException3 = e5;
                                                                                inputStream4 = inputStream5;
                                                                                z6 = z7;
                                                                                str2 = str5;
                                                                                j6 = j6;
                                                                                iOException = iOException3;
                                                                                iOException.printStackTrace();
                                                                                if (!(iOException instanceof SocketTimeoutException)) {
                                                                                }
                                                                                this.f2166o = FastDtoa.kTen5;
                                                                                m2569a(0L);
                                                                                m2571a(103, m2560a(iOException), false);
                                                                                m2564a(fileOutputStream);
                                                                                m2564a(inputStream3);
                                                                                m2564a(inputStream4);
                                                                            } catch (Throwable th24) {
                                                                                th4 = th24;
                                                                                inputStream4 = inputStream5;
                                                                                th3 = th4;
                                                                                m2564a(fileOutputStream);
                                                                                m2564a(inputStream3);
                                                                                m2564a(inputStream4);
                                                                                throw th3;
                                                                            }
                                                                        } else {
                                                                            inputStream8 = inputStream5;
                                                                            try {
                                                                                int read = inputStream3.read(bArr, 0, 8192);
                                                                                if (read <= 0) {
                                                                                    try {
                                                                                        break;
                                                                                    } catch (IOException e6) {
                                                                                        iOException = e6;
                                                                                        z6 = z7;
                                                                                        j9 = j;
                                                                                        j = j9;
                                                                                        j10 = j6;
                                                                                        j6 = j10;
                                                                                        fileOutputStream3 = fileOutputStream;
                                                                                        z4 = z8;
                                                                                        fileOutputStream = fileOutputStream3;
                                                                                        z8 = z4;
                                                                                        str2 = str5;
                                                                                        inputStream4 = inputStream8;
                                                                                        iOException.printStackTrace();
                                                                                        if (!(iOException instanceof SocketTimeoutException)) {
                                                                                        }
                                                                                        this.f2166o = FastDtoa.kTen5;
                                                                                        m2569a(0L);
                                                                                        m2571a(103, m2560a(iOException), false);
                                                                                        m2564a(fileOutputStream);
                                                                                        m2564a(inputStream3);
                                                                                        m2564a(inputStream4);
                                                                                    } catch (Throwable th25) {
                                                                                        th3 = th25;
                                                                                        j8 = j;
                                                                                        j10 = j6;
                                                                                        fileOutputStream2 = fileOutputStream;
                                                                                        z4 = z8;
                                                                                        fileOutputStream = fileOutputStream2;
                                                                                        inputStream4 = inputStream8;
                                                                                        m2564a(fileOutputStream);
                                                                                        m2564a(inputStream3);
                                                                                        m2564a(inputStream4);
                                                                                        throw th3;
                                                                                    }
                                                                                } else {
                                                                                    fileOutputStream.write(bArr, 0, read);
                                                                                    fileOutputStream.flush();
                                                                                    bArr2 = bArr;
                                                                                    z6 = z7;
                                                                                    if (!z) {
                                                                                        j10 = j6 + read;
                                                                                        if (j10 >= j) {
                                                                                            try {
                                                                                                break;
                                                                                            } catch (IOException e7) {
                                                                                                j9 = j;
                                                                                                iOException = e7;
                                                                                                j6 = j10;
                                                                                                j = j9;
                                                                                                j10 = j6;
                                                                                                j6 = j10;
                                                                                                fileOutputStream3 = fileOutputStream;
                                                                                                z4 = z8;
                                                                                                fileOutputStream = fileOutputStream3;
                                                                                                z8 = z4;
                                                                                                str2 = str5;
                                                                                                inputStream4 = inputStream8;
                                                                                                iOException.printStackTrace();
                                                                                                if (!(iOException instanceof SocketTimeoutException)) {
                                                                                                    if (z) {
                                                                                                    }
                                                                                                    m2569a(0L);
                                                                                                    if (m2535k()) {
                                                                                                    }
                                                                                                    m2571a(i2, m2560a, false);
                                                                                                    try {
                                                                                                        m2564a(fileOutputStream);
                                                                                                        m2564a(inputStream3);
                                                                                                        m2564a(inputStream4);
                                                                                                    } catch (Throwable th26) {
                                                                                                        th6 = th26;
                                                                                                        z9 = z8;
                                                                                                        j13 = j6;
                                                                                                        z8 = z9;
                                                                                                        th = th6;
                                                                                                        if (th instanceof SSLHandshakeException) {
                                                                                                        }
                                                                                                        th.printStackTrace();
                                                                                                        m2569a(0L);
                                                                                                        m2571a(107, m2560a(th), false);
                                                                                                        if (this.f2171t) {
                                                                                                        }
                                                                                                        TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-316);
                                                                                                        if (!z) {
                                                                                                        }
                                                                                                        str8 = str2;
                                                                                                        downloadMaxflow = j;
                                                                                                        str9 = str3;
                                                                                                        z12 = z8;
                                                                                                        z3 = z6;
                                                                                                        str7 = str;
                                                                                                    }
                                                                                                }
                                                                                                this.f2166o = FastDtoa.kTen5;
                                                                                                m2569a(0L);
                                                                                                m2571a(103, m2560a(iOException), false);
                                                                                                m2564a(fileOutputStream);
                                                                                                m2564a(inputStream3);
                                                                                                m2564a(inputStream4);
                                                                                            } catch (Throwable th27) {
                                                                                                j8 = j;
                                                                                                th3 = th27;
                                                                                                j6 = j10;
                                                                                                j10 = j6;
                                                                                                fileOutputStream2 = fileOutputStream;
                                                                                                z4 = z8;
                                                                                                fileOutputStream = fileOutputStream2;
                                                                                                inputStream4 = inputStream8;
                                                                                                m2564a(fileOutputStream);
                                                                                                m2564a(inputStream3);
                                                                                                m2564a(inputStream4);
                                                                                                throw th3;
                                                                                            }
                                                                                        } else {
                                                                                            j6 = j10;
                                                                                            try {
                                                                                                if (!FileUtil.m2178b(this.f2159h)) {
                                                                                                    TbsLog.m2153i(TbsDownloader.LOGTAG, "DownloadEnd FreeSpace too small ", true);
                                                                                                    m2571a(105, "freespace=" + C1472q.m1991a() + ",and minFreeSpace=" + TbsDownloadConfig.getInstance(this.f2159h).getDownloadMinFreeSpace(), true);
                                                                                                    TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-308);
                                                                                                    break;
                                                                                                }
                                                                                            } catch (IOException e8) {
                                                                                                iOException = e8;
                                                                                                j10 = j6;
                                                                                                j6 = j10;
                                                                                                fileOutputStream3 = fileOutputStream;
                                                                                                z4 = z8;
                                                                                                fileOutputStream = fileOutputStream3;
                                                                                                z8 = z4;
                                                                                                str2 = str5;
                                                                                                inputStream4 = inputStream8;
                                                                                                iOException.printStackTrace();
                                                                                                if (!(iOException instanceof SocketTimeoutException)) {
                                                                                                }
                                                                                                this.f2166o = FastDtoa.kTen5;
                                                                                                m2569a(0L);
                                                                                                m2571a(103, m2560a(iOException), false);
                                                                                                m2564a(fileOutputStream);
                                                                                                m2564a(inputStream3);
                                                                                                m2564a(inputStream4);
                                                                                            } catch (Throwable th28) {
                                                                                                th3 = th28;
                                                                                                j10 = j6;
                                                                                                fileOutputStream2 = fileOutputStream;
                                                                                                z4 = z8;
                                                                                                fileOutputStream = fileOutputStream2;
                                                                                                inputStream4 = inputStream8;
                                                                                                m2564a(fileOutputStream);
                                                                                                m2564a(inputStream3);
                                                                                                m2564a(inputStream4);
                                                                                                throw th3;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    long j18 = read;
                                                                                    try {
                                                                                        long m2568a = m2568a(j7, j18);
                                                                                        long currentTimeMillis3 = System.currentTimeMillis();
                                                                                        long j19 = j14 + j18;
                                                                                        if (currentTimeMillis3 - currentTimeMillis2 > 1000) {
                                                                                            try {
                                                                                                TbsLog.m2153i(TbsDownloader.LOGTAG, "#2 STEP 1/2 begin downloading...current/total=" + j19 + "/" + this.f2165n, true);
                                                                                                if (QbSdk.f1753n != null) {
                                                                                                    j11 = m2568a;
                                                                                                    QbSdk.f1753n.onDownloadProgress((int) ((j19 / this.f2165n) * 100.0d));
                                                                                                } else {
                                                                                                    j11 = m2568a;
                                                                                                }
                                                                                                if (z || j19 - j16 <= 1048576) {
                                                                                                    str6 = str5;
                                                                                                    inputStream10 = inputStream8;
                                                                                                } else if (TbsDownloader.getOverSea(this.f2159h) || ((Apn.getApnType(this.f2159h) == 3 && Apn.getApnType(this.f2159h) != 0) || QbSdk.getDownloadWithoutWifi())) {
                                                                                                    str6 = str5;
                                                                                                    inputStream10 = inputStream8;
                                                                                                    j16 = j19;
                                                                                                } else {
                                                                                                    m2555b();
                                                                                                    if (QbSdk.f1753n != null) {
                                                                                                        QbSdk.f1753n.onDownloadFinish(111);
                                                                                                    }
                                                                                                    TbsLog.m2153i(TbsDownloader.LOGTAG, "Download is paused due to NOT_WIFI error!", false);
                                                                                                    TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-304);
                                                                                                }
                                                                                                currentTimeMillis2 = currentTimeMillis3;
                                                                                            } catch (IOException e9) {
                                                                                                str2 = str5;
                                                                                                inputStream4 = inputStream8;
                                                                                                iOException3 = e9;
                                                                                                j6 = j6;
                                                                                                iOException = iOException3;
                                                                                                iOException.printStackTrace();
                                                                                                if (!(iOException instanceof SocketTimeoutException)) {
                                                                                                }
                                                                                                this.f2166o = FastDtoa.kTen5;
                                                                                                m2569a(0L);
                                                                                                m2571a(103, m2560a(iOException), false);
                                                                                                m2564a(fileOutputStream);
                                                                                                m2564a(inputStream3);
                                                                                                m2564a(inputStream4);
                                                                                            } catch (Throwable th29) {
                                                                                                inputStream4 = inputStream8;
                                                                                                th4 = th29;
                                                                                                th3 = th4;
                                                                                                m2564a(fileOutputStream);
                                                                                                m2564a(inputStream3);
                                                                                                m2564a(inputStream4);
                                                                                                throw th3;
                                                                                            }
                                                                                        } else {
                                                                                            j11 = m2568a;
                                                                                            str6 = str5;
                                                                                            inputStream10 = inputStream8;
                                                                                        }
                                                                                        str5 = str6;
                                                                                        j7 = j11;
                                                                                        j14 = j19;
                                                                                        bArr = bArr2;
                                                                                        z7 = z6;
                                                                                        inputStream5 = inputStream10;
                                                                                    } catch (IOException e10) {
                                                                                        e = e10;
                                                                                        str2 = str5;
                                                                                        inputStream4 = inputStream8;
                                                                                        iOException = e;
                                                                                        iOException.printStackTrace();
                                                                                        if (!(iOException instanceof SocketTimeoutException)) {
                                                                                        }
                                                                                        this.f2166o = FastDtoa.kTen5;
                                                                                        m2569a(0L);
                                                                                        m2571a(103, m2560a(iOException), false);
                                                                                        m2564a(fileOutputStream);
                                                                                        m2564a(inputStream3);
                                                                                        m2564a(inputStream4);
                                                                                    } catch (Throwable th30) {
                                                                                        th = th30;
                                                                                        inputStream4 = inputStream8;
                                                                                        th3 = th;
                                                                                        m2564a(fileOutputStream);
                                                                                        m2564a(inputStream3);
                                                                                        m2564a(inputStream4);
                                                                                        throw th3;
                                                                                    }
                                                                                }
                                                                            } catch (IOException e11) {
                                                                                z6 = z7;
                                                                                str2 = str5;
                                                                                inputStream4 = inputStream8;
                                                                                iOException3 = e11;
                                                                                iOException = iOException3;
                                                                                iOException.printStackTrace();
                                                                                if (!(iOException instanceof SocketTimeoutException)) {
                                                                                }
                                                                                this.f2166o = FastDtoa.kTen5;
                                                                                m2569a(0L);
                                                                                m2571a(103, m2560a(iOException), false);
                                                                                m2564a(fileOutputStream);
                                                                                m2564a(inputStream3);
                                                                                m2564a(inputStream4);
                                                                            } catch (Throwable th31) {
                                                                                th5 = th31;
                                                                                inputStream4 = inputStream8;
                                                                                th4 = th5;
                                                                                th3 = th4;
                                                                                m2564a(fileOutputStream);
                                                                                m2564a(inputStream3);
                                                                                m2564a(inputStream4);
                                                                                throw th3;
                                                                            }
                                                                        }
                                                                    } catch (IOException e12) {
                                                                        e = e12;
                                                                        inputStream4 = inputStream5;
                                                                        z6 = z7;
                                                                        str2 = str5;
                                                                    } catch (Throwable th32) {
                                                                        th = th32;
                                                                        inputStream4 = inputStream5;
                                                                    }
                                                                }
                                                                z10 = false;
                                                                j13 = j6;
                                                            } catch (IOException e13) {
                                                                e = e13;
                                                                inputStream7 = inputStream3;
                                                                iOException2 = e;
                                                                fileOutputStream3 = null;
                                                                inputStream8 = inputStream5;
                                                                iOException = iOException2;
                                                                z6 = z7;
                                                                str5 = str8;
                                                                inputStream3 = inputStream7;
                                                                str = str4;
                                                                fileOutputStream = fileOutputStream3;
                                                                z8 = z4;
                                                                str2 = str5;
                                                                inputStream4 = inputStream8;
                                                                iOException.printStackTrace();
                                                                if (!(iOException instanceof SocketTimeoutException) && !(iOException instanceof SocketException)) {
                                                                    if (z && !FileUtil.m2178b(this.f2159h)) {
                                                                        m2571a(105, "freespace=" + C1472q.m1991a() + ",and minFreeSpace=" + TbsDownloadConfig.getInstance(this.f2159h).getDownloadMinFreeSpace(), true);
                                                                        TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-308);
                                                                        m2564a(fileOutputStream);
                                                                        m2564a(inputStream3);
                                                                        m2564a(inputStream4);
                                                                        if (!z) {
                                                                            j13 = j6;
                                                                            TbsDownloadConfig.getInstance(this.f2159h).mSyncMap.put(str2, Long.valueOf(j13));
                                                                            TbsDownloadConfig.getInstance(this.f2159h).commit();
                                                                        }
                                                                        z5 = z8;
                                                                        if (!this.f2171t) {
                                                                        }
                                                                        m2538h();
                                                                    }
                                                                    m2569a(0L);
                                                                    if (m2535k()) {
                                                                        i2 = 106;
                                                                        m2560a = m2560a(iOException);
                                                                    } else {
                                                                        m2560a = m2560a(iOException);
                                                                        i2 = 104;
                                                                    }
                                                                    m2571a(i2, m2560a, false);
                                                                    m2564a(fileOutputStream);
                                                                    m2564a(inputStream3);
                                                                    m2564a(inputStream4);
                                                                }
                                                                this.f2166o = FastDtoa.kTen5;
                                                                m2569a(0L);
                                                                m2571a(103, m2560a(iOException), false);
                                                                m2564a(fileOutputStream);
                                                                m2564a(inputStream3);
                                                                m2564a(inputStream4);
                                                            } catch (Throwable th33) {
                                                                th = th33;
                                                                inputStream6 = inputStream3;
                                                                th7 = th;
                                                                fileOutputStream2 = null;
                                                                inputStream8 = inputStream5;
                                                                th3 = th7;
                                                                str5 = str8;
                                                                inputStream3 = inputStream6;
                                                                fileOutputStream = fileOutputStream2;
                                                                inputStream4 = inputStream8;
                                                                m2564a(fileOutputStream);
                                                                m2564a(inputStream3);
                                                                m2564a(inputStream4);
                                                                throw th3;
                                                            }
                                                        } catch (IOException e14) {
                                                            e = e14;
                                                            j6 = j13;
                                                            inputStream7 = inputStream3;
                                                            iOException2 = e;
                                                            fileOutputStream3 = null;
                                                            inputStream8 = inputStream5;
                                                            iOException = iOException2;
                                                            z6 = z7;
                                                            str5 = str8;
                                                            inputStream3 = inputStream7;
                                                            str = str4;
                                                            fileOutputStream = fileOutputStream3;
                                                            z8 = z4;
                                                            str2 = str5;
                                                            inputStream4 = inputStream8;
                                                            iOException.printStackTrace();
                                                            if (!(iOException instanceof SocketTimeoutException)) {
                                                            }
                                                            this.f2166o = FastDtoa.kTen5;
                                                            m2569a(0L);
                                                            m2571a(103, m2560a(iOException), false);
                                                            m2564a(fileOutputStream);
                                                            m2564a(inputStream3);
                                                            m2564a(inputStream4);
                                                        } catch (Throwable th34) {
                                                            th = th34;
                                                            inputStream6 = inputStream3;
                                                            th7 = th;
                                                            fileOutputStream2 = null;
                                                            inputStream8 = inputStream5;
                                                            th3 = th7;
                                                            str5 = str8;
                                                            inputStream3 = inputStream6;
                                                            fileOutputStream = fileOutputStream2;
                                                            inputStream4 = inputStream8;
                                                            m2564a(fileOutputStream);
                                                            m2564a(inputStream3);
                                                            m2564a(inputStream4);
                                                            throw th3;
                                                        }
                                                        if (z10) {
                                                            try {
                                                                m2564a(fileOutputStream);
                                                                m2564a(inputStream3);
                                                                m2564a(inputStream8);
                                                                if (!z) {
                                                                    str2 = str5;
                                                                    TbsDownloadConfig.getInstance(this.f2159h).mSyncMap.put(str2, Long.valueOf(j13));
                                                                    TbsDownloadConfig.getInstance(this.f2159h).commit();
                                                                } else {
                                                                    str2 = str5;
                                                                }
                                                                z12 = z8;
                                                                str8 = str2;
                                                                downloadMaxflow = j;
                                                                str9 = str3;
                                                            } catch (Throwable th35) {
                                                                str2 = str5;
                                                                th = th35;
                                                                if (th instanceof SSLHandshakeException) {
                                                                }
                                                                th.printStackTrace();
                                                                m2569a(0L);
                                                                m2571a(107, m2560a(th), false);
                                                                if (this.f2171t) {
                                                                }
                                                                TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-316);
                                                                if (!z) {
                                                                }
                                                                str8 = str2;
                                                                downloadMaxflow = j;
                                                                str9 = str3;
                                                                z12 = z8;
                                                                z3 = z6;
                                                                str7 = str;
                                                            }
                                                            z3 = z6;
                                                            str7 = str;
                                                        } else {
                                                            str2 = str5;
                                                            inputStream9 = inputStream8;
                                                        }
                                                    }
                                                }
                                                str3 = str9;
                                                j6 = j13;
                                                file = new File(this.f2163l, "x5.tbs.temp");
                                                TbsLog.m2153i(TbsDownloader.LOGTAG, "fileDownloadApk is " + file.getAbsolutePath(), true);
                                                fileOutputStream = new FileOutputStream(file, true);
                                                long currentTimeMillis22 = System.currentTimeMillis();
                                                str5 = str8;
                                                long j162 = j14;
                                                long j172 = j3;
                                                str = str4;
                                                z8 = z4;
                                                j7 = j172;
                                                while (true) {
                                                    if (this.f2171t) {
                                                    }
                                                    str5 = str6;
                                                    j7 = j11;
                                                    j14 = j19;
                                                    bArr = bArr2;
                                                    z7 = z6;
                                                    inputStream5 = inputStream10;
                                                }
                                                z10 = false;
                                                j13 = j6;
                                                if (z10) {
                                                }
                                            }
                                        }
                                        inputStream3 = (contentEncoding == null || !contentEncoding.contains("deflate")) ? inputStream5 : new InflaterInputStream(inputStream5, new Inflater(true));
                                        bArr = new byte[8192];
                                        if (z2) {
                                        }
                                        str3 = str9;
                                        j6 = j13;
                                        file = new File(this.f2163l, "x5.tbs.temp");
                                        TbsLog.m2153i(TbsDownloader.LOGTAG, "fileDownloadApk is " + file.getAbsolutePath(), true);
                                        fileOutputStream = new FileOutputStream(file, true);
                                        long currentTimeMillis222 = System.currentTimeMillis();
                                        str5 = str8;
                                        long j1622 = j14;
                                        long j1722 = j3;
                                        str = str4;
                                        z8 = z4;
                                        j7 = j1722;
                                        while (true) {
                                            if (this.f2171t) {
                                            }
                                            str5 = str6;
                                            j7 = j11;
                                            j14 = j19;
                                            bArr = bArr2;
                                            z7 = z6;
                                            inputStream5 = inputStream10;
                                        }
                                        z10 = false;
                                        j13 = j6;
                                        if (z10) {
                                        }
                                    } else {
                                        str3 = str9;
                                        str = str4;
                                        z8 = z4;
                                        str2 = str8;
                                        inputStream9 = inputStream5;
                                        z6 = z7;
                                        fileOutputStream = null;
                                        inputStream3 = null;
                                    }
                                    try {
                                        m2564a(fileOutputStream);
                                        m2564a(inputStream3);
                                        m2564a(inputStream9);
                                        if (this.f2172u) {
                                            break;
                                        }
                                        TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-319);
                                        break;
                                    } catch (Throwable th36) {
                                        th6 = th36;
                                        z9 = z8;
                                        z8 = z9;
                                        th = th6;
                                        if (th instanceof SSLHandshakeException) {
                                        }
                                        th.printStackTrace();
                                        m2569a(0L);
                                        m2571a(107, m2560a(th), false);
                                        if (this.f2171t) {
                                        }
                                        TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-316);
                                        if (!z) {
                                        }
                                        str8 = str2;
                                        downloadMaxflow = j;
                                        str9 = str3;
                                        z12 = z8;
                                        z3 = z6;
                                        str7 = str;
                                    }
                                } else {
                                    TbsLog.m2153i(TbsDownloader.LOGTAG, "DownloadBegin tbsApkFileSize=" + j15 + "  but contentLength=" + this.f2165n, true);
                                    if (z || (!m2531o() && (!QbSdk.getDownloadWithoutWifi() || !Apn.isNetworkAvailable(this.f2159h)))) {
                                        break;
                                    } else if (this.f2156b == null || !m2552b(false)) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (apnType != this.f2177z || !apnInfo.equals(this.f2176y)) {
                        this.f2175x.setNetworkChange(0);
                        this.f2176y = apnInfo;
                        this.f2177z = apnType;
                    }
                    if (this.f2169r >= 1) {
                    }
                    int responseCode2 = this.f2173v.getResponseCode();
                    TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] responseCode=" + responseCode2);
                    this.f2175x.setHttpCode(responseCode2);
                    if (!z) {
                        m2555b();
                        if (QbSdk.f1753n != null) {
                        }
                        TbsLog.m2153i(TbsDownloader.LOGTAG, "Download is canceled due to NOT_WIFI error!", false);
                    }
                    if (!this.f2171t) {
                    }
                }
            }
            TbsDownloadConfig.getInstance(this.f2159h).mSyncMap.put(str2, Long.valueOf(j13));
            TbsDownloadConfig.getInstance(this.f2159h).commit();
            z5 = z8;
            if (!this.f2171t) {
                boolean z13 = z5;
                if (this.f2172u) {
                    boolean z14 = z5;
                    z14 = z5;
                    if (this.f2156b == null && !z5) {
                        if (!z2 || !C1472q.m1982b(this.f2159h)) {
                            z14 = m2547c(true, z6);
                        } else {
                            z14 = m2556a(true, z6, new File(this.f2164m, TbsDownloader.getBackupFileName(false) + ".tmp"));
                        }
                    }
                    TbsLogReport.TbsLogInfo tbsLogInfo = this.f2175x;
                    int i4 = z14 ? 1 : 0;
                    int i5 = z14 ? 1 : 0;
                    int i6 = z14 ? 1 : 0;
                    int i7 = z14 ? 1 : 0;
                    int i8 = z14 ? 1 : 0;
                    int i9 = z14 ? 1 : 0;
                    int i10 = z14 ? 1 : 0;
                    tbsLogInfo.setUnpkgFlag(i4);
                    C1472q.m1985a("10is" + z14);
                    this.f2175x.setPatchUpdateFlag(!z6 ? z14 ? 1 : 2 : 0);
                    TbsLog.m2155i(TbsDownloader.LOGTAG, "downloadSuccess is " + z14);
                    if (z14) {
                        m2538h();
                        m2544d(true);
                        TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-317);
                        m2571a(100, "success", true);
                        z13 = z14;
                    } else {
                        TbsDownloadConfig.getInstance(this.f2159h).setDownloadInterruptCode(-318);
                        i = 0;
                        m2541e(false);
                        r4 = z14;
                        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(this.f2159h);
                        if (r4 == 0) {
                            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, Integer.valueOf(tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, i) + 1));
                        } else {
                            int i11 = tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, i) + 1;
                            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, Integer.valueOf(i11));
                            if (i11 == tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
                                this.f2175x.setDownloadCancel(2);
                            }
                        }
                        tbsDownloadConfig.commit();
                        this.f2175x.setDownFinalFlag(r4);
                    }
                }
                i = 0;
                r4 = z13;
                TbsDownloadConfig tbsDownloadConfig2 = TbsDownloadConfig.getInstance(this.f2159h);
                if (r4 == 0) {
                }
                tbsDownloadConfig2.commit();
                this.f2175x.setDownFinalFlag(r4);
            }
            m2538h();
        }
    }

    /* renamed from: b */
    public boolean m2552b(boolean z) {
        String[] strArr;
        int i;
        if ((!z || m2531o() || (QbSdk.getDownloadWithoutWifi() && Apn.isNetworkAvailable(this.f2159h))) && (strArr = this.f2156b) != null && (i = this.f2157c) >= 0 && i < strArr.length) {
            this.f2157c = i + 1;
            this.f2162k = strArr[i];
            this.f2169r = 0;
            this.f2170s = 0;
            this.f2165n = -1L;
            this.f2168q = false;
            this.f2171t = false;
            this.f2172u = false;
            this.f2150A = false;
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public int m2548c(boolean z) {
        File m2549c = m2549c(this.f2159h);
        if (z) {
            if (m2549c != null) {
                return C1428a.m2139a(this.f2159h, new File(m2549c, TbsDownloader.getBackupFileName(true)));
            }
            return 0;
        } else if (m2549c == null) {
            return 0;
        } else {
            return C1428a.m2139a(this.f2159h, new File(m2549c, TbsDownloader.getOverSea(this.f2159h) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false)));
        }
    }

    /* renamed from: c */
    public void m2550c() {
        m2555b();
        m2541e(false);
        m2541e(true);
    }

    /* renamed from: d */
    public boolean m2546d() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2154E);
        TbsLog.m2155i(TbsDownloader.LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        return this.f2154E;
    }

    /* renamed from: e */
    public void m2543e() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("pauseDownload,isPause=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2158d);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("isDownloading=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(TbsDownloader.isDownloading());
        TbsLog.m2155i(TbsDownloader.LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        if (this.f2158d || !TbsDownloader.isDownloading()) {
            return;
        }
        m2555b();
        this.f2158d = true;
        this.f2150A = false;
    }

    /* renamed from: f */
    public void m2540f() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("resumeDownload,isPause=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2158d);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("isDownloading=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(TbsDownloader.isDownloading());
        TbsLog.m2155i(TbsDownloader.LOGTAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        if (!this.f2158d || !TbsDownloader.isDownloading()) {
            return;
        }
        this.f2158d = false;
        m2558a(false);
    }
}

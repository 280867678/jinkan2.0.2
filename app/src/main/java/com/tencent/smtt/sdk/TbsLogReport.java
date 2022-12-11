package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.arialyy.aria.core.inf.ReceiverType;
import com.stub.StubApp;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.Base64;
import com.tencent.smtt.utils.C1429b;
import com.tencent.smtt.utils.C1456f;
import com.tencent.smtt.utils.C1458g;
import com.tencent.smtt.utils.C1463k;
import com.tencent.smtt.utils.C1467n;
import com.tencent.smtt.utils.C1472q;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import me.tvspark.outline;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public class TbsLogReport {

    /* renamed from: a */
    public static TbsLogReport f1889a;

    /* renamed from: b */
    public Handler f1890b;

    /* renamed from: c */
    public Context f1891c;

    /* renamed from: d */
    public boolean f1892d = false;

    /* loaded from: classes4.dex */
    public enum EventType {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2),
        TYPE_DOWNLOAD_DECOUPLE(3),
        TYPE_INSTALL_DECOUPLE(4),
        TYPE_COOKIE_DB_SWITCH(5),
        TYPE_SDK_REPORT_INFO(6);
        

        /* renamed from: a */
        public int f1897a;

        EventType(int i) {
            this.f1897a = i;
        }
    }

    /* loaded from: classes4.dex */
    public static class TbsLogInfo implements Cloneable {

        /* renamed from: a */
        public int f1898a;

        /* renamed from: b */
        public long f1899b;

        /* renamed from: c */
        public String f1900c;

        /* renamed from: d */
        public String f1901d;

        /* renamed from: e */
        public int f1902e;

        /* renamed from: f */
        public int f1903f;

        /* renamed from: g */
        public int f1904g;

        /* renamed from: h */
        public int f1905h;

        /* renamed from: i */
        public String f1906i;

        /* renamed from: j */
        public int f1907j;

        /* renamed from: k */
        public int f1908k;

        /* renamed from: l */
        public long f1909l;

        /* renamed from: m */
        public long f1910m;

        /* renamed from: n */
        public int f1911n;

        /* renamed from: o */
        public String f1912o;

        /* renamed from: p */
        public String f1913p;

        /* renamed from: q */
        public long f1914q;

        public TbsLogInfo() {
            resetArgs();
        }

        public Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException unused) {
                return this;
            }
        }

        public int getDownFinalFlag() {
            return this.f1908k;
        }

        public void resetArgs() {
            this.f1899b = 0L;
            this.f1900c = null;
            this.f1901d = null;
            this.f1902e = 0;
            this.f1903f = 0;
            this.f1904g = 0;
            this.f1905h = 2;
            this.f1906i = "unknown";
            this.f1907j = 0;
            this.f1908k = 2;
            this.f1909l = 0L;
            this.f1910m = 0L;
            this.f1911n = 1;
            this.f1898a = 0;
            this.f1912o = null;
            this.f1913p = null;
            this.f1914q = 0L;
        }

        public void setApn(String str) {
            this.f1906i = str;
        }

        public void setCheckErrorDetail(String str) {
            setErrorCode(108);
            this.f1912o = str;
        }

        public void setDownConsumeTime(long j) {
            this.f1910m += j;
        }

        public void setDownFinalFlag(int i) {
            this.f1908k = i;
        }

        public void setDownloadCancel(int i) {
            this.f1904g = i;
        }

        public void setDownloadSize(long j) {
            this.f1914q += j;
        }

        public void setDownloadUrl(String str) {
            if (this.f1900c != null) {
                str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this.f1900c, ";", str);
            }
            this.f1900c = str;
        }

        public void setErrorCode(int i) {
            if (i != 100 && i != 110 && i != 120 && i != 111 && i < 400) {
                TbsLog.m2153i(TbsDownloader.LOGTAG, "error occured, errorCode:" + i, true);
            }
            if (i == 111) {
                TbsLog.m2153i(TbsDownloader.LOGTAG, "you are not in wifi, downloading stoped", true);
            }
            this.f1898a = i;
        }

        public void setEventTime(long j) {
            this.f1899b = j;
        }

        public void setFailDetail(String str) {
            if (str == null) {
                return;
            }
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
            this.f1913p = str;
        }

        public void setFailDetail(Throwable th) {
            if (th == null) {
                this.f1913p = "";
                return;
            }
            String stackTraceString = Log.getStackTraceString(th);
            if (stackTraceString.length() > 1024) {
                stackTraceString = stackTraceString.substring(0, 1024);
            }
            this.f1913p = stackTraceString;
        }

        public void setHttpCode(int i) {
            this.f1902e = i;
        }

        public void setNetworkChange(int i) {
            this.f1911n = i;
        }

        public void setNetworkType(int i) {
            this.f1907j = i;
        }

        public void setPatchUpdateFlag(int i) {
            this.f1903f = i;
        }

        public void setPkgSize(long j) {
            this.f1909l = j;
        }

        public void setResolveIp(String str) {
            this.f1901d = str;
        }

        public void setUnpkgFlag(int i) {
            this.f1905h = i;
        }
    }

    /* renamed from: com.tencent.smtt.sdk.TbsLogReport$a */
    /* loaded from: classes4.dex */
    public static class C1326a {

        /* renamed from: a */
        public final String f1915a;

        /* renamed from: b */
        public final String f1916b;

        public C1326a(String str, String str2) {
            this.f1915a = str;
            this.f1916b = str2;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x003d -> B:12:0x0040). Please submit an issue!!! */
        /* renamed from: a */
        public static void m2750a(File file) throws IOException {
            RandomAccessFile randomAccessFile;
            RandomAccessFile randomAccessFile2 = null;
            RandomAccessFile randomAccessFile3 = null;
            randomAccessFile2 = null;
            try {
                try {
                    try {
                        randomAccessFile = new RandomAccessFile(file, "rw");
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e) {
                    e = e;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                randomAccessFile2 = randomAccessFile2;
            }
            try {
                int parseInt = Integer.parseInt("00001000", 2);
                randomAccessFile.seek(7L);
                int read = randomAccessFile.read();
                if ((read & parseInt) > 0) {
                    randomAccessFile.seek(7L);
                    randomAccessFile.write((~parseInt) & 255 & read);
                }
                randomAccessFile.close();
                randomAccessFile2 = read;
            } catch (Exception e3) {
                e = e3;
                randomAccessFile3 = randomAccessFile;
                e.printStackTrace();
                if (randomAccessFile3 == null) {
                    return;
                }
                randomAccessFile3.close();
                randomAccessFile2 = randomAccessFile3;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(8:3|4|(7:5|6|7|8|9|10|11)|(10:13|14|15|16|(2:17|(1:19)(1:20))|21|22|23|24|25)|26|27|28|29) */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x008d, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x008e, code lost:
            r0.printStackTrace();
         */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x00d4 -> B:29:0x00d7). Please submit an issue!!! */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void m2751a() {
            ZipOutputStream zipOutputStream;
            FileOutputStream fileOutputStream;
            ZipOutputStream zipOutputStream2;
            Exception e;
            byte[] bArr;
            String str;
            FileInputStream fileInputStream;
            BufferedInputStream bufferedInputStream;
            BufferedInputStream bufferedInputStream2;
            Exception e2;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(this.f1916b);
                        try {
                            zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
                            try {
                                try {
                                    bArr = new byte[2048];
                                    str = this.f1915a;
                                    try {
                                        fileInputStream = new FileInputStream(str);
                                    } catch (Exception e3) {
                                        e = e3;
                                        fileInputStream = null;
                                        bufferedInputStream2 = null;
                                    } catch (Throwable th) {
                                        th = th;
                                        fileInputStream = null;
                                        bufferedInputStream = null;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    e.printStackTrace();
                                    if (zipOutputStream2 != null) {
                                        try {
                                            zipOutputStream2.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream == null) {
                                        return;
                                    }
                                    fileOutputStream.close();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Exception e6) {
                            zipOutputStream2 = null;
                            e = e6;
                        } catch (Throwable th3) {
                            zipOutputStream = null;
                            th = th3;
                            if (zipOutputStream != null) {
                                try {
                                    zipOutputStream.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                    try {
                        bufferedInputStream2 = new BufferedInputStream(fileInputStream, 2048);
                        try {
                            zipOutputStream2.putNextEntry(new ZipEntry(str.substring(str.lastIndexOf("/") + 1)));
                            while (true) {
                                int read = bufferedInputStream2.read(bArr, 0, 2048);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream2.write(bArr, 0, read);
                            }
                            zipOutputStream2.flush();
                            zipOutputStream2.closeEntry();
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                            try {
                                fileInputStream.close();
                            } catch (IOException e11) {
                                e = e11;
                                e.printStackTrace();
                                m2750a(new File(this.f1916b));
                                zipOutputStream2.close();
                                fileOutputStream.close();
                            }
                        } catch (Exception e12) {
                            e2 = e12;
                            e2.printStackTrace();
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e14) {
                                    e = e14;
                                    e.printStackTrace();
                                    m2750a(new File(this.f1916b));
                                    zipOutputStream2.close();
                                    fileOutputStream.close();
                                }
                            }
                            m2750a(new File(this.f1916b));
                            zipOutputStream2.close();
                            fileOutputStream.close();
                        }
                    } catch (Exception e15) {
                        e = e15;
                        bufferedInputStream2 = null;
                        e2 = e;
                        e2.printStackTrace();
                        if (bufferedInputStream2 != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        m2750a(new File(this.f1916b));
                        zipOutputStream2.close();
                        fileOutputStream.close();
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedInputStream = null;
                        th = th;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    m2750a(new File(this.f1916b));
                    zipOutputStream2.close();
                    fileOutputStream.close();
                } catch (Exception e18) {
                    zipOutputStream2 = null;
                    e = e18;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    zipOutputStream = null;
                    th = th5;
                    fileOutputStream = null;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    public TbsLogReport(Context context) {
        this.f1890b = null;
        this.f1891c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        HandlerThread handlerThread = new HandlerThread("TbsLogReportThread");
        handlerThread.start();
        this.f1890b = new Handler(handlerThread.getLooper()) { // from class: com.tencent.smtt.sdk.TbsLogReport.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i != 600) {
                    if (i != 601) {
                        return;
                    }
                    TbsLogReport.this.m2772b();
                    return;
                }
                Object obj = message.obj;
                if (!(obj instanceof TbsLogInfo)) {
                    return;
                }
                try {
                    int i2 = message.arg1;
                    TbsLogReport.this.m2778a(i2, (TbsLogInfo) obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /* renamed from: a */
    private String m2779a(int i) {
        return i + "|";
    }

    /* renamed from: a */
    private String m2776a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private String m2773a(String str) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, str, "|");
    }

    /* renamed from: a */
    private JSONArray m2780a() {
        String string = m2768d().getString("tbs_download_upload", null);
        if (string != null) {
            try {
                string = new String(Base64.m2219a(string, 2));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (string == null) {
            return new JSONArray();
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() > 5) {
                JSONArray jSONArray2 = new JSONArray();
                int length = jSONArray.length() - 1;
                if (length >= jSONArray.length() - 5) {
                    jSONArray2.put(jSONArray.get(length));
                    return jSONArray2;
                }
            }
            return jSONArray;
        } catch (Exception unused) {
            return new JSONArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2778a(int i, TbsLogInfo tbsLogInfo) {
        Map<String, Object> map = QbSdk.f1754o;
        if (map != null && map.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.f1754o.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.m2155i(ReceiverType.UPLOAD, "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m2779a(i));
        sb.append(m2773a((String) null));
        sb.append(m2773a(C1463k.m2039a(this.f1891c)));
        sb.append(m2779a(C1381p.m2503a().m2446j(this.f1891c)));
        String m1976d = C1472q.m1976d(this.f1891c);
        try {
            m1976d = new String(m1976d.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception unused) {
        }
        sb.append(m2773a(m1976d));
        String packageName = this.f1891c.getPackageName();
        sb.append(m2773a(packageName));
        sb.append(TbsConfig.APP_WX.equals(packageName) ? m2773a(C1429b.m2127a(this.f1891c, TbsDownloader.TBS_METADATA)) : m2779a(C1429b.m2116e(this.f1891c)));
        sb.append(m2773a(m2776a(tbsLogInfo.f1899b)));
        sb.append(m2773a(tbsLogInfo.f1900c));
        sb.append(m2773a(tbsLogInfo.f1901d));
        sb.append(m2779a(tbsLogInfo.f1902e));
        sb.append(m2779a(tbsLogInfo.f1903f));
        sb.append(m2779a(tbsLogInfo.f1904g));
        sb.append(m2779a(tbsLogInfo.f1905h));
        sb.append(m2773a(tbsLogInfo.f1906i));
        sb.append(m2779a(tbsLogInfo.f1907j));
        sb.append(m2779a(tbsLogInfo.f1908k));
        sb.append(m2771b(tbsLogInfo.f1914q));
        sb.append(m2771b(tbsLogInfo.f1909l));
        sb.append(m2771b(tbsLogInfo.f1910m));
        sb.append(m2779a(tbsLogInfo.f1911n));
        sb.append(m2779a(tbsLogInfo.f1898a));
        sb.append(m2773a(tbsLogInfo.f1912o));
        sb.append(m2773a(tbsLogInfo.f1913p));
        sb.append(m2779a(TbsDownloadConfig.getInstance(this.f1891c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0)));
        sb.append(m2773a(C1429b.m2110k(this.f1891c)));
        sb.append(m2773a("4.3.0.215_44115"));
        sb.append(false);
        SharedPreferences m2768d = m2768d();
        JSONArray m2780a = m2780a();
        m2780a.put(sb.toString());
        SharedPreferences.Editor edit = m2768d.edit();
        String jSONArray = m2780a.toString();
        try {
            jSONArray = Base64.encodeToString(jSONArray.getBytes(), 2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        edit.putString("tbs_download_upload", jSONArray);
        edit.commit();
        if (!this.f1892d && i == EventType.TYPE_LOAD.f1897a) {
            return;
        }
        m2772b();
    }

    /* renamed from: a */
    private void m2777a(int i, TbsLogInfo tbsLogInfo, EventType eventType) {
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        QbSdk.f1753n.onInstallFinish(i);
        eventReport(eventType, tbsLogInfo);
    }

    /* renamed from: b */
    private String m2771b(long j) {
        return j + "|";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2772b() {
        String str;
        String str2;
        Map<String, Object> map = QbSdk.f1754o;
        if (map == null || !map.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) || !QbSdk.f1754o.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            str = TbsDownloader.LOGTAG;
            TbsLog.m2155i(str, "[TbsApkDownloadStat.reportDownloadStat]");
            JSONArray m2780a = m2780a();
            if (m2780a != null && m2780a.length() != 0) {
                TbsLog.m2155i(str, "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + m2780a);
                try {
                    String m2072a = C1456f.m2072a(C1467n.m2018a(this.f1891c).m2016c(), m2780a.toString().getBytes("utf-8"), new C1456f.AbstractC1457a() { // from class: com.tencent.smtt.sdk.TbsLogReport.3
                        @Override // com.tencent.smtt.utils.C1456f.AbstractC1457a
                        /* renamed from: a */
                        public void mo2068a(int i) {
                            TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + i);
                            if (i < 300) {
                                TbsLogReport.this.m2769c();
                            }
                        }
                    }, true);
                    TbsLog.m2155i(str, "[TbsApkDownloadStat.reportDownloadStat] response:" + m2072a + " testcase: -1");
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            str2 = "[TbsApkDownloadStat.reportDownloadStat] no data";
        } else {
            str = ReceiverType.UPLOAD;
            str2 = "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false";
        }
        TbsLog.m2155i(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m2769c() {
        SharedPreferences.Editor edit = m2768d().edit();
        edit.remove("tbs_download_upload");
        edit.commit();
    }

    /* renamed from: d */
    private SharedPreferences m2768d() {
        return this.f1891c.getSharedPreferences("tbs_download_stat", 4);
    }

    public static TbsLogReport getInstance(Context context) {
        if (f1889a == null) {
            synchronized (TbsLogReport.class) {
                if (f1889a == null) {
                    f1889a = new TbsLogReport(context);
                }
            }
        }
        return f1889a;
    }

    public void clear() {
        try {
            SharedPreferences.Editor edit = m2768d().edit();
            edit.clear();
            edit.commit();
        } catch (Exception unused) {
        }
    }

    public void dailyReport() {
        this.f1890b.sendEmptyMessage(601);
    }

    public void eventReport(EventType eventType, TbsLogInfo tbsLogInfo) {
        try {
            Message obtainMessage = this.f1890b.obtainMessage();
            obtainMessage.what = 600;
            obtainMessage.arg1 = eventType.f1897a;
            obtainMessage.obj = (TbsLogInfo) tbsLogInfo.clone();
            this.f1890b.sendMessage(obtainMessage);
        } catch (Throwable th) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[TbsLogReport.eventReport] error, message=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.getMessage());
            TbsLog.m2148w(ReceiverType.UPLOAD, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    public boolean getShouldUploadEventReport() {
        return this.f1892d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0136, code lost:
        if (r0 != null) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void reportTbsLog() {
        String tbsLogFilePath;
        Throwable th;
        File file;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        FileInputStream fileInputStream;
        Map<String, Object> map = QbSdk.f1754o;
        if (map != null && map.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.f1754o.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.m2155i(ReceiverType.UPLOAD, "[TbsLogReport.reportTbsLog] -- SET_SENDREQUEST_AND_UPLOAD is false");
        } else if (Apn.getApnType(this.f1891c) != 3 || (tbsLogFilePath = TbsLog.getTbsLogFilePath()) == null) {
        } else {
            String m2064b = C1458g.m2067a().m2064b();
            String m2113h = C1429b.m2114g(this.f1891c) ? C1429b.m2113h(this.f1891c) : "";
            String m2110k = C1429b.m2110k(this.f1891c);
            byte[] bytes = m2113h.getBytes();
            byte[] bytes2 = m2110k.getBytes();
            try {
                bytes = C1458g.m2067a().m2066a(bytes);
                bytes2 = C1458g.m2067a().m2066a(bytes2);
            } catch (Exception unused) {
            }
            String str = C1467n.m2018a(this.f1891c).m2011h() + C1458g.m2063b(bytes) + "&aid=" + C1458g.m2063b(bytes2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/octet-stream");
            hashMap.put("Charset", "UTF-8");
            hashMap.put("QUA2", C1463k.m2039a(this.f1891c));
            FileInputStream fileInputStream2 = null;
            r5 = null;
            byte[] bArr = null;
            fileInputStream2 = null;
            try {
                new File(FileUtil.f2367a);
                new C1326a(tbsLogFilePath, FileUtil.f2367a + "/tbslog_temp.zip").m2751a();
                file = new File(FileUtil.f2367a, "tbslog_temp.zip");
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = null;
                    byteArrayOutputStream = null;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                    if (fileInputStream2 != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    if (file != null) {
                    }
                    throw th;
                }
                try {
                    byte[] bArr2 = new byte[8192];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            try {
                                int read = fileInputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            } catch (Exception e3) {
                                e = e3;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused3) {
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception unused4) {
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception unused5) {
                                }
                            }
                            if (file != null) {
                                file.delete();
                            }
                            throw th;
                        }
                    }
                    byteArrayOutputStream.flush();
                    bArr = C1458g.m2067a().m2066a(byteArrayOutputStream.toByteArray());
                    try {
                        fileInputStream.close();
                    } catch (Exception unused6) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused7) {
                        file.delete();
                        C1456f.m2073a(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "&ek=", m2064b), hashMap, bArr, new C1456f.AbstractC1457a() { // from class: com.tencent.smtt.sdk.TbsLogReport.2
                            @Override // com.tencent.smtt.utils.C1456f.AbstractC1457a
                            /* renamed from: a */
                            public void mo2068a(int i) {
                                TbsLog.m2155i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportTbsLog] httpResponseCode=" + i);
                            }
                        }, false);
                    }
                } catch (Exception e4) {
                    e = e4;
                    byteArrayOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    if (file != null) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                file = null;
            } catch (Throwable th5) {
                th = th5;
                file = null;
                byteArrayOutputStream = null;
            }
        }
    }

    public void setInstallErrorCode(int i, String str) {
        setInstallErrorCode(i, str, EventType.TYPE_INSTALL);
    }

    public void setInstallErrorCode(int i, String str, EventType eventType) {
        if (i != 200 && i != 220 && i != 221) {
            TbsLog.m2153i(TbsDownloader.LOGTAG, "error occured in installation, errorCode:" + i, true);
        }
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(str);
        m2777a(i, tbsLogInfo, eventType);
    }

    public void setInstallErrorCode(int i, Throwable th) {
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setFailDetail(th);
        m2777a(i, tbsLogInfo, EventType.TYPE_INSTALL);
    }

    public void setLoadErrorCode(int i, String str) {
        TbsLogInfo tbsLogInfo = tbsLogInfo();
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        tbsLogInfo.setFailDetail(str);
        eventReport(EventType.TYPE_LOAD, tbsLogInfo);
    }

    public void setLoadErrorCode(int i, Throwable th) {
        String str;
        if (th != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("msg: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.getMessage());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("; err: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("; cause: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(th.getCause()));
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
        } else {
            str = "NULL";
        }
        setLoadErrorCode(i, str);
    }

    public void setShouldUploadEventReport(boolean z) {
        this.f1892d = z;
    }

    public TbsLogInfo tbsLogInfo() {
        return new TbsLogInfo();
    }
}

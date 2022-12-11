package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.stub.StubApp;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes4.dex */
public class TbsDownloadUpload {

    /* renamed from: b */
    public static TbsDownloadUpload f1849b;

    /* renamed from: a */
    public Map<String, Object> f1850a = new HashMap();

    /* renamed from: c */
    public Context f1851c;

    /* renamed from: d */
    public int f1852d;

    /* renamed from: e */
    public int f1853e;

    /* renamed from: f */
    public int f1854f;

    /* renamed from: g */
    public int f1855g;

    /* renamed from: h */
    public int f1856h;

    /* renamed from: i */
    public int f1857i;
    public SharedPreferences mPreferences;

    /* loaded from: classes4.dex */
    public interface TbsUploadKey {
        public static final String KEY_LOCAL_CORE_VERSION = "tbs_local_core_version";
        public static final String KEY_NEEDDOWNLOAD_CODE = "tbs_needdownload_code";
        public static final String KEY_NEEDDOWNLOAD_RETURN = "tbs_needdownload_return";
        public static final String KEY_NEEDDOWNLOAD_SENT = "tbs_needdownload_sent";
        public static final String KEY_STARTDOWNLOAD_CODE = "tbs_startdownload_code";
        public static final String KEY_STARTDOWNLOAD_SENT = "tbs_startdownload_sent";
    }

    public TbsDownloadUpload(Context context) {
        this.mPreferences = context.getSharedPreferences("tbs_download_upload", 4);
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f1851c = origApplicationContext;
        if (origApplicationContext == null) {
            this.f1851c = context;
        }
    }

    /* renamed from: a */
    public static File m2813a(Context context, String str) {
        C1381p.m2503a();
        File m2435t = C1381p.m2435t(context);
        if (m2435t == null) {
            return null;
        }
        File file = new File(m2435t, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized void clear() {
        synchronized (TbsDownloadUpload.class) {
            f1849b = null;
        }
    }

    public static synchronized TbsDownloadUpload getInstance() {
        TbsDownloadUpload tbsDownloadUpload;
        synchronized (TbsDownloadUpload.class) {
            tbsDownloadUpload = f1849b;
        }
        return tbsDownloadUpload;
    }

    public static synchronized TbsDownloadUpload getInstance(Context context) {
        TbsDownloadUpload tbsDownloadUpload;
        synchronized (TbsDownloadUpload.class) {
            if (f1849b == null) {
                f1849b = new TbsDownloadUpload(context);
            }
            tbsDownloadUpload = f1849b;
        }
        return tbsDownloadUpload;
    }

    public void clearUploadCode() {
        this.f1850a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 0);
        this.f1850a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 0);
        this.f1850a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, 0);
        this.f1850a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, 0);
        this.f1850a.put(TbsUploadKey.KEY_STARTDOWNLOAD_SENT, 0);
        this.f1850a.put(TbsUploadKey.KEY_LOCAL_CORE_VERSION, 0);
        writeTbsDownloadInfo();
    }

    public synchronized void commit() {
        writeTbsDownloadInfo();
    }

    public synchronized int getLocalCoreVersion() {
        return this.f1857i;
    }

    public synchronized int getNeedDownloadCode() {
        if (this.f1855g == 1) {
            return 148;
        }
        return this.f1852d;
    }

    public synchronized int getNeedDownloadReturn() {
        return this.f1854f;
    }

    public synchronized int getStartDownloadCode() {
        if (this.f1856h == 1) {
            return TbsListener.ErrorCode.STARTDOWNLOAD_9;
        }
        return this.f1853e;
    }

    public synchronized void readTbsDownloadInfo(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        File m2813a;
        try {
            m2813a = m2813a(this.f1851c, "download_upload");
        } catch (Throwable th2) {
            bufferedInputStream = null;
            th = th2;
        }
        if (m2813a == null) {
            return;
        }
        bufferedInputStream = new BufferedInputStream(new FileInputStream(m2813a));
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream);
            String property = properties.getProperty(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, "");
            if (!"".equals(property)) {
                this.f1852d = Math.max(Integer.parseInt(property), 0);
            }
            String property2 = properties.getProperty(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, "");
            if (!"".equals(property2)) {
                this.f1853e = Math.max(Integer.parseInt(property2), 0);
            }
            String property3 = properties.getProperty(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, "");
            if (!"".equals(property3)) {
                this.f1854f = Math.max(Integer.parseInt(property3), 0);
            }
            String property4 = properties.getProperty(TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, "");
            if (!"".equals(property4)) {
                this.f1855g = Math.max(Integer.parseInt(property4), 0);
            }
            String property5 = properties.getProperty(TbsUploadKey.KEY_STARTDOWNLOAD_SENT, "");
            if (!"".equals(property5)) {
                this.f1856h = Math.max(Integer.parseInt(property5), 0);
            }
            String property6 = properties.getProperty(TbsUploadKey.KEY_LOCAL_CORE_VERSION, "");
            if (!"".equals(property6)) {
                this.f1857i = Math.max(Integer.parseInt(property6), 0);
            }
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                }
            }
        }
        try {
            bufferedInputStream.close();
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
        }
    }

    public synchronized void writeTbsDownloadInfo() {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        File m2813a;
        TbsLog.m2155i("TbsDownloadUpload", "writeTbsDownloadInfo #1");
        BufferedInputStream bufferedInputStream = null;
        try {
            m2813a = m2813a(this.f1851c, "download_upload");
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
        if (m2813a == null) {
            return;
        }
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(m2813a));
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream2);
            for (String str : this.f1850a.keySet()) {
                Object obj = this.f1850a.get(str);
                properties.setProperty(str, "" + obj);
                TbsLog.m2155i("TbsDownloadUpload", "writeTbsDownloadInfo key is " + str + " value is " + obj);
            }
            this.f1850a.clear();
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(m2813a));
            try {
                properties.store(bufferedOutputStream, (String) null);
                try {
                    bufferedInputStream2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                th.printStackTrace();
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                    }
                }
            }
            try {
                bufferedOutputStream.close();
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
        }
    }
}

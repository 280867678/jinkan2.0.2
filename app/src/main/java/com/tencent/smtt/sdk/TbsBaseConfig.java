package com.tencent.smtt.sdk;

import android.content.Context;
import com.stub.StubApp;
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
public abstract class TbsBaseConfig {
    public static final String TAG = "TbsBaseConfig";

    /* renamed from: a */
    public Map<String, String> f1835a;

    /* renamed from: b */
    public Context f1836b;

    /* renamed from: a */
    public static File m2816a(Context context, String str) {
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

    public void clear() {
        this.f1835a.clear();
        commit();
    }

    public synchronized void commit() {
        writeTbsDownloadInfo();
    }

    public abstract String getConfigFileName();

    public void init(Context context) {
        this.f1835a = new HashMap();
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f1836b = origApplicationContext;
        if (origApplicationContext == null) {
            this.f1836b = context;
        }
        refreshSyncMap(context);
    }

    public synchronized void refreshSyncMap(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        File m2816a;
        try {
            m2816a = m2816a(this.f1836b, getConfigFileName());
        } catch (Throwable th2) {
            bufferedInputStream = null;
            th = th2;
        }
        if (m2816a == null) {
            return;
        }
        this.f1835a.clear();
        bufferedInputStream = new BufferedInputStream(new FileInputStream(m2816a));
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream);
            for (String str : properties.stringPropertyNames()) {
                this.f1835a.put(str, properties.getProperty(str));
            }
            try {
                bufferedInputStream.close();
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void writeTbsDownloadInfo() {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        File m2816a;
        Properties properties;
        TbsLog.m2155i(TAG, "writeTbsDownloadInfo #1");
        BufferedInputStream bufferedInputStream = null;
        try {
            m2816a = m2816a(this.f1836b, getConfigFileName());
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
        if (m2816a == null) {
            return;
        }
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(m2816a));
        try {
            properties = new Properties();
            properties.load(bufferedInputStream2);
            properties.clear();
            for (String str : this.f1835a.keySet()) {
                String str2 = this.f1835a.get(str);
                properties.setProperty(str, "" + ((Object) str2));
                TbsLog.m2155i(TAG, "writeTbsDownloadInfo key is " + str + " value is " + ((Object) str2));
            }
            this.f1835a.clear();
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(m2816a));
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
        try {
            properties.store(bufferedOutputStream, (String) null);
            try {
                bufferedInputStream2.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                bufferedOutputStream.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = bufferedInputStream2;
            th.printStackTrace();
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace();
                }
            }
        }
    }
}

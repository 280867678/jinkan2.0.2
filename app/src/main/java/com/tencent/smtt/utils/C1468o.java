package com.tencent.smtt.utils;

import android.content.Context;
import com.stub.StubApp;
import com.tencent.smtt.sdk.QbSdk;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/* renamed from: com.tencent.smtt.utils.o */
/* loaded from: classes4.dex */
public class C1468o {

    /* renamed from: e */
    public static C1468o f2537e;

    /* renamed from: b */
    public Context f2539b;

    /* renamed from: c */
    public File f2540c = null;

    /* renamed from: a */
    public boolean f2538a = false;

    /* renamed from: d */
    public boolean f2541d = false;

    /* renamed from: f */
    public File f2542f = null;

    public C1468o(Context context) {
        this.f2539b = null;
        this.f2539b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        m2003b();
    }

    /* renamed from: a */
    public static synchronized C1468o m2006a() {
        C1468o c1468o;
        synchronized (C1468o.class) {
            c1468o = f2537e;
        }
        return c1468o;
    }

    /* renamed from: a */
    public static synchronized C1468o m2005a(Context context) {
        C1468o c1468o;
        synchronized (C1468o.class) {
            if (f2537e == null) {
                f2537e = new C1468o(context);
            }
            c1468o = f2537e;
        }
        return c1468o;
    }

    /* renamed from: d */
    private File m2001d() {
        try {
            if (this.f2540c == null) {
                File file = new File(QbSdk.getTbsFolderDir(this.f2539b), "core_private");
                this.f2540c = file;
                if (file == null || !file.isDirectory()) {
                    return null;
                }
            }
            File file2 = new File(this.f2540c, "debug.conf");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void m2004a(boolean z) {
        this.f2541d = z;
        m2002c();
    }

    /* renamed from: b */
    public synchronized void m2003b() {
        BufferedInputStream bufferedInputStream = null;
        try {
            if (this.f2542f == null) {
                this.f2542f = m2001d();
            }
        } catch (Throwable th) {
            th = th;
        }
        if (this.f2542f == null) {
            return;
        }
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(this.f2542f));
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream2);
            String property = properties.getProperty("setting_forceUseSystemWebview", "");
            if (!"".equals(property)) {
                this.f2538a = Boolean.parseBoolean(property);
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = bufferedInputStream2;
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
            bufferedInputStream2.close();
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x006e -> B:13:0x0071). Please submit an issue!!! */
    /* renamed from: c */
    public void m2002c() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        try {
            try {
                File m2001d = m2001d();
                if (m2001d == null) {
                    try {
                        throw null;
                    } catch (Exception e) {
                        e.printStackTrace();
                        try {
                            throw null;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(m2001d));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.f2538a));
                    properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.f2541d));
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(m2001d));
                    try {
                        properties.store(bufferedOutputStream, (String) null);
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        bufferedOutputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                            bufferedOutputStream.close();
                        } catch (Throwable th3) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    bufferedOutputStream = null;
                    th = th4;
                }
            } catch (Exception e7) {
                while (true) {
                    e7.printStackTrace();
                    return;
                }
            }
        } catch (Throwable th5) {
            bufferedInputStream = null;
            th = th5;
            bufferedOutputStream = null;
        }
    }
}

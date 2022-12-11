package com.tencent.smtt.sdk;

import android.content.Context;
import com.stub.StubApp;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* renamed from: com.tencent.smtt.sdk.n */
/* loaded from: classes4.dex */
public class C1379n {

    /* renamed from: a */
    public static C1379n f2179a;

    /* renamed from: b */
    public static Context f2180b;

    /* renamed from: a */
    public static C1379n m2526a(Context context) {
        if (f2179a == null) {
            synchronized (C1379n.class) {
                if (f2179a == null) {
                    f2179a = new C1379n();
                }
            }
        }
        f2180b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        return f2179a;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Properties m2511e() {
        Properties properties;
        Exception e;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                try {
                    File m2529a = m2529a();
                    properties = new Properties();
                    if (m2529a != null) {
                        try {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(m2529a));
                        } catch (Exception e2) {
                            bufferedInputStream = null;
                            e = e2;
                        }
                        try {
                            properties.load(bufferedInputStream);
                            bufferedInputStream2 = bufferedInputStream;
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            return properties;
                        }
                    }
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return properties;
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                }
                throw th;
            }
        } catch (Exception e7) {
            properties = null;
            e = e7;
            bufferedInputStream = null;
        }
    }

    /* renamed from: a */
    public File m2529a() {
        C1381p.m2503a();
        File file = new File(C1381p.m2435t(f2180b), "tbscoreinstall.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return file;
    }

    /* renamed from: a */
    public void m2528a(int i) {
        m2524a("dexopt_retry_num", i);
    }

    /* renamed from: a */
    public void m2527a(int i, int i2) {
        m2524a("copy_core_ver", i);
        m2524a("copy_status", i2);
    }

    /* renamed from: a */
    public void m2525a(String str) {
        m2523a("install_apk_path", str);
    }

    /* renamed from: a */
    public void m2524a(String str, int i) {
        m2523a(str, String.valueOf(i));
    }

    /* renamed from: a */
    public void m2523a(String str, String str2) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    Properties m2511e = m2511e();
                    if (m2511e != null) {
                        m2511e.setProperty(str, str2);
                        File m2529a = m2529a();
                        if (m2529a != null) {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(m2529a);
                            try {
                                m2511e.store(fileOutputStream2, "update " + str + " and status!");
                                fileOutputStream = fileOutputStream2;
                            } catch (Exception e) {
                                e = e;
                                fileOutputStream = fileOutputStream2;
                                e.printStackTrace();
                                if (fileOutputStream == null) {
                                    return;
                                }
                                fileOutputStream.close();
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
            if (fileOutputStream == null) {
                return;
            }
            fileOutputStream.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    /* renamed from: b */
    public int m2522b() {
        return m2515c("install_core_ver");
    }

    /* renamed from: b */
    public int m2519b(String str) {
        Properties m2511e = m2511e();
        if (m2511e == null || m2511e.getProperty(str) == null) {
            return -1;
        }
        return Integer.parseInt(m2511e.getProperty(str));
    }

    /* renamed from: b */
    public void m2521b(int i) {
        m2524a("unzip_retry_num", i);
    }

    /* renamed from: b */
    public void m2520b(int i, int i2) {
        m2524a("tpatch_ver", i);
        m2524a("tpatch_status", i2);
    }

    /* renamed from: c */
    public int m2518c() {
        return m2519b("install_status");
    }

    /* renamed from: c */
    public int m2515c(String str) {
        Properties m2511e = m2511e();
        if (m2511e == null || m2511e.getProperty(str) == null) {
            return 0;
        }
        return Integer.parseInt(m2511e.getProperty(str));
    }

    /* renamed from: c */
    public void m2517c(int i) {
        m2524a("incrupdate_status", i);
    }

    /* renamed from: c */
    public void m2516c(int i, int i2) {
        m2524a("install_core_ver", i);
        m2524a("install_status", i2);
    }

    /* renamed from: d */
    public int m2514d() {
        return m2519b("incrupdate_status");
    }

    /* renamed from: d */
    public String m2512d(String str) {
        Properties m2511e = m2511e();
        if (m2511e == null || m2511e.getProperty(str) == null) {
            return null;
        }
        return m2511e.getProperty(str);
    }

    /* renamed from: d */
    public void m2513d(int i) {
        m2524a("unlzma_status", i);
    }
}

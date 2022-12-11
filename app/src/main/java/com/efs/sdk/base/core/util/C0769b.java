package com.efs.sdk.base.core.util;

import com.efs.sdk.base.core.p005a.C0694a;
import com.efs.sdk.base.core.p010d.C0739b;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* renamed from: com.efs.sdk.base.core.util.b */
/* loaded from: classes3.dex */
public final class C0769b {

    /* renamed from: a */
    public static final Random f321a = new Random();

    /* renamed from: a */
    public static String m4038a(C0739b c0739b) {
        StringBuilder sb = new StringBuilder();
        sb.append(c0739b.f278a.f271a);
        sb.append("_");
        sb.append(c0739b.f278a.f274d);
        sb.append("_");
        sb.append(c0739b.f278a.f275e);
        sb.append("_");
        sb.append((int) c0739b.f278a.f272b);
        sb.append("_");
        sb.append(C0778d.m4005a());
        sb.append("_");
        sb.append(f321a.nextInt(10000));
        sb.append("_");
        C0694a.m4184a();
        sb.append(C0694a.m4180b());
        return sb.toString();
    }

    /* renamed from: a */
    public static String m4036a(File file) {
        return m4027e(file);
    }

    /* renamed from: a */
    public static void m4037a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                Log.m4065e("efs.util.file", "safe close error", th);
            }
        }
    }

    /* renamed from: a */
    public static void m4035a(File file, File file2) {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[524288];
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new File(file2, file.getName());
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        try {
                            Log.m4065e("efs.util.file", "error when copy", e);
                            m4037a(fileInputStream);
                            m4037a(fileOutputStream);
                            m4031b(file);
                        } catch (Throwable th) {
                            th = th;
                            m4037a(fileInputStream);
                            m4037a(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        m4037a(fileInputStream);
                        m4037a(fileOutputStream);
                        throw th;
                    }
                }
                m4037a(fileInputStream2);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        m4037a(fileOutputStream);
        m4031b(file);
    }

    /* renamed from: a */
    public static boolean m4034a(File file, String str) {
        return m4033a(file, str.getBytes());
    }

    /* renamed from: a */
    public static boolean m4033a(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                return true;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream;
                try {
                    Log.m4065e("efs.util.file", "write file error, filename is " + file.getName(), th);
                    m4037a(fileOutputStream);
                    return false;
                } finally {
                    m4037a(fileOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static byte[] m4032a(String str) {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[0];
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            m4037a(fileInputStream);
        } catch (Exception e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            Log.m4065e("efs.util.file", "read data error", e);
            m4037a(fileInputStream2);
            return bArr;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            m4037a(fileInputStream2);
            throw th;
        }
        return bArr;
    }

    /* renamed from: b */
    public static C0739b m4030b(String str) {
        String[] split = str.split("_");
        if (split.length != 7) {
            Log.m4054w("efs.util.file", "File name error, name is ".concat(str));
            return null;
        }
        String str2 = split[0];
        String str3 = split[1];
        byte byteValue = Byte.valueOf(split[2]).byteValue();
        C0739b c0739b = new C0739b(str2, Byte.valueOf(split[3]).byteValue());
        c0739b.m4096a(str3);
        c0739b.m4098a(byteValue);
        return c0739b;
    }

    /* renamed from: b */
    public static void m4031b(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                m4031b(file2);
            }
        }
        file.delete();
    }

    /* renamed from: c */
    public static long m4029c(File file) {
        long j = 0;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return 0L;
            }
            for (File file2 : listFiles) {
                j += m4029c(file2);
            }
            return j;
        }
        return 0 + file.length();
    }

    /* renamed from: d */
    public static List<File> m4028d(File file) {
        if (file.isFile()) {
            return Collections.emptyList();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                arrayList.add(file2);
            } else {
                arrayList.addAll(m4028d(file2));
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public static String m4027e(File file) {
        String str = "";
        if (!file.exists()) {
            return str;
        }
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
                str = sb.toString();
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream;
                try {
                    Log.m4065e("efs.util.file", "read file error", th);
                    return str;
                } finally {
                    m4037a(fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return str;
    }
}

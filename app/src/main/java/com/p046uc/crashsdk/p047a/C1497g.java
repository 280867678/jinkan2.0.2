package com.p046uc.crashsdk.p047a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.p046uc.crashsdk.C1500b;
import com.p046uc.crashsdk.C1509g;
import com.p046uc.crashsdk.JNIBridge;
import com.umeng.analytics.pro.C1543ak;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.ArrayList;
import org.litepal.crud.LitePalSupport;

/* renamed from: com.uc.crashsdk.a.g */
/* loaded from: classes4.dex */
public class C1497g {

    /* renamed from: b */
    public static Context f2647b;

    /* renamed from: a */
    public static final /* synthetic */ boolean f2646a = !C1497g.class.desiredAssertionStatus();

    /* renamed from: c */
    public static String f2648c = null;

    /* renamed from: d */
    public static String f2649d = null;

    /* renamed from: e */
    public static String f2650e = null;

    /* renamed from: f */
    public static String f2651f = null;

    /* renamed from: g */
    public static String f2652g = null;

    /* renamed from: h */
    public static boolean f2653h = false;

    /* renamed from: i */
    public static final Object f2654i = new Object();

    /* renamed from: j */
    public static final char[] f2655j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a */
    public static long m1870a(String str, boolean z) {
        if (!m1872a(str)) {
            try {
                long parseLong = Long.parseLong(str.trim());
                if (parseLong >= 0) {
                    return parseLong;
                }
                return 0L;
            } catch (NumberFormatException e) {
                if (z) {
                    m1867a((Throwable) e, false);
                }
            }
        }
        return 0L;
    }

    /* renamed from: a */
    public static Context m1882a() {
        return f2647b;
    }

    /* renamed from: a */
    public static String m1876a(File file, int i, boolean z) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[i];
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    return new String(bArr, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                if (z) {
                    try {
                        m1867a(th, false);
                    } finally {
                        m1879a(fileInputStream);
                    }
                }
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0027, code lost:
        if (r2.toLowerCase().startsWith("http") != false) goto L8;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m1871a(String str, String str2, boolean z) {
        String str3 = null;
        if (new File(str).exists()) {
            String m1919a = C1492b.m1919a(str);
            if (!m1872a(m1919a)) {
                if (z) {
                    m1919a = m1919a.trim();
                }
                str3 = m1919a;
            }
        }
        return str3 == null ? str2 : str3;
    }

    /* renamed from: a */
    public static String m1866a(String[] strArr) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream());
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 512);
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            return sb.toString().trim();
                        }
                        sb.append(readLine);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        m1867a(th, false);
                        return null;
                    } finally {
                        m1879a(bufferedReader);
                        m1879a(inputStreamReader);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            inputStreamReader = null;
        }
    }

    /* renamed from: a */
    public static ArrayList<String> m1877a(File file, int i) {
        BufferedReader bufferedReader;
        ArrayList<String> arrayList = new ArrayList<>();
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader2, 512);
                int i2 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                        i2++;
                        if (i > 0 && i2 >= i) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileReader = fileReader2;
                        try {
                            m1867a(th, false);
                            m1879a(fileReader);
                            m1879a(bufferedReader);
                            return arrayList;
                        } catch (Throwable th2) {
                            m1879a(fileReader);
                            m1879a(bufferedReader);
                            throw th2;
                        }
                    }
                }
                m1879a(fileReader2);
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
        m1879a(bufferedReader);
        return arrayList;
    }

    /* renamed from: a */
    public static void m1881a(int i) {
        if (i == 800) {
            m1848l();
        } else if (!f2646a) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public static void m1880a(Context context) {
        if (f2647b != null) {
            C1491a.m1923b("mContext is existed");
        }
        f2647b = context;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        f2648c = applicationInfo.dataDir;
        f2649d = applicationInfo.sourceDir;
        try {
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(applicationInfo);
            if (obj == null || !(obj instanceof String)) {
                return;
            }
            f2650e = (String) obj;
        } catch (Throwable th) {
            m1867a(th, false);
        }
    }

    /* renamed from: a */
    public static void m1879a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                m1867a(th, true);
            }
        }
    }

    /* renamed from: a */
    public static void m1875a(File file, File file2) {
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
                            m1879a(fileInputStream2);
                            m1879a(fileOutputStream);
                            return;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        m1879a(fileInputStream);
                        m1879a(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    /* renamed from: a */
    public static void m1868a(Throwable th) {
        m1867a(th, false);
    }

    /* renamed from: a */
    public static void m1867a(Throwable th, boolean z) {
        if (!z) {
            try {
                if (!C1509g.m1524M()) {
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        th.printStackTrace();
    }

    /* renamed from: a */
    public static boolean m1878a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!m1878a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* renamed from: a */
    public static boolean m1874a(File file, String str) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            try {
                fileWriter.write(str, 0, str.length());
                return true;
            } catch (Throwable th) {
                th = th;
                fileWriter = fileWriter;
                try {
                    m1867a(th, false);
                    return false;
                } finally {
                    m1879a(fileWriter);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static boolean m1873a(File file, byte[] bArr) {
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
                    m1867a(th, false);
                    return false;
                } finally {
                    m1879a(fileOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static boolean m1872a(String str) {
        return str == null || str.trim().length() == 0;
    }

    /* renamed from: a */
    public static boolean m1869a(StringBuffer stringBuffer) {
        return stringBuffer == null || stringBuffer.length() == 0;
    }

    /* renamed from: b */
    public static String m1865b() {
        return f2648c;
    }

    /* renamed from: b */
    public static void m1864b(File file) {
        m1874a(file, "");
    }

    /* renamed from: b */
    public static void m1862b(Throwable th) {
        m1867a(th, true);
    }

    /* renamed from: b */
    public static boolean m1863b(String str) {
        return !m1872a(str);
    }

    /* renamed from: c */
    public static String m1861c() {
        return f2649d;
    }

    /* renamed from: c */
    public static String m1860c(File file) {
        String str = "";
        if (!file.exists()) {
            return str;
        }
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[256];
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
                    m1867a(th, false);
                    return str;
                } finally {
                    m1879a(fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return str;
    }

    /* renamed from: c */
    public static String m1859c(String str) {
        try {
            byte[] bytes = str.getBytes("utf-8");
            MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            StringBuilder sb = new StringBuilder(length * 2);
            int i = length + 0;
            for (int i2 = 0; i2 < i; i2++) {
                byte b = digest[i2];
                char c = f2655j[(b & 240) >> 4];
                char c2 = f2655j[b & 15];
                sb.append(c);
                sb.append(c2);
            }
            return sb.toString();
        } catch (Exception e) {
            C1491a.m1924a("crashsdk", "getMD5: ", e);
            return null;
        }
    }

    /* renamed from: d */
    public static String m1858d() {
        String str = f2650e;
        return str != null ? str : "";
    }

    /* renamed from: d */
    public static String m1857d(File file) {
        return m1876a(file, 64, true);
    }

    /* renamed from: e */
    public static boolean m1856e() {
        if (m1853g()) {
            return true;
        }
        return m1854f();
    }

    /* renamed from: e */
    public static byte[] m1855e(File file) {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            return null;
        }
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.read(bArr);
                return bArr;
            } catch (Throwable th) {
                th = th;
                try {
                    m1867a(th, false);
                    return null;
                } finally {
                    m1879a(fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    /* renamed from: f */
    public static boolean m1854f() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    /* renamed from: g */
    public static boolean m1853g() {
        int indexOf;
        String m1851i = m1851i();
        if (!m1872a(m1851i) && (indexOf = m1851i.indexOf(" root ")) > 0) {
            String substring = m1851i.substring(0, indexOf);
            if (substring.contains("x") || substring.contains(C1543ak.f2965aB)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    public static String m1852h() {
        m1848l();
        return m1872a(f2651f) ? "" : f2651f;
    }

    /* renamed from: i */
    public static String m1851i() {
        m1848l();
        return m1872a(f2652g) ? "" : f2652g;
    }

    /* renamed from: j */
    public static void m1850j() {
        C1496f.m1888a(0, new RunnableC1495e(800), TooltipCompatHandler.HOVER_HIDE_TIMEOUT_MS);
    }

    /* renamed from: k */
    public static void m1849k() {
        if (!C1500b.f2714d || !f2653h) {
            return;
        }
        JNIBridge.set(123, f2651f);
        JNIBridge.set(124, f2652g);
    }

    /* renamed from: l */
    public static void m1848l() {
        String trim;
        int indexOf;
        int indexOf2;
        if (f2653h) {
            return;
        }
        synchronized (f2654i) {
            if (f2653h) {
                return;
            }
            String m1866a = m1866a(new String[]{"sh", "-c", "type su"});
            if (!m1872a(m1866a) && (indexOf = (trim = m1866a.trim()).indexOf(32)) > 0 && trim.contains("/su") && (indexOf2 = trim.indexOf(47, indexOf + 1)) > 0) {
                String substring = trim.substring(indexOf2);
                f2651f = substring;
                String m1866a2 = m1866a(new String[]{"ls", "-l", substring});
                if (!m1872a(m1866a2)) {
                    f2652g = m1866a2.trim();
                }
            }
            f2653h = true;
            m1849k();
        }
    }
}

package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import androidx.lifecycle.SavedStateHandle;
import com.stub.StubApp;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.proguard.ca */
/* loaded from: classes3.dex */
public class C1208ca {

    /* renamed from: a */
    public static Map<String, String> f1485a;

    /* renamed from: a */
    public static Context m3044a(Context context) {
        Context origApplicationContext;
        return (context == null || (origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())) == null) ? context : origApplicationContext;
    }

    /* renamed from: a */
    public static SharedPreferences m3026a(String str, Context context) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }

    /* renamed from: a */
    public static BufferedReader m3035a(File file) {
        if (file != null && file.exists() && file.canRead()) {
            try {
                return new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            } catch (Throwable th) {
                C1199X.m3080b(th);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static BufferedReader m3025a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str, str2);
            if (file.exists() && file.canRead()) {
                return m3035a(file);
            }
            return null;
        } catch (NullPointerException e) {
            C1199X.m3080b(e);
            return null;
        }
    }

    /* renamed from: a */
    public static Object m3024a(String str, String str2, Object obj, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m3019a(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel m3003d = m3003d(bArr);
        try {
            return creator.createFromParcel(m3003d);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                if (m3003d != null) {
                    m3003d.recycle();
                }
                return null;
            } finally {
                if (m3003d != null) {
                    m3003d.recycle();
                }
            }
        }
    }

    /* renamed from: a */
    public static String m3047a() {
        return m3045a(System.currentTimeMillis());
    }

    /* renamed from: a */
    public static String m3045a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j));
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    /* renamed from: a */
    public static String m3043a(Context context, int i, String str) {
        Process process = null;
        if (!AppInfo.m3435a(context, "android.permission.READ_LOGS")) {
            C1199X.m3076e("no read_log permission!", new Object[0]);
            return null;
        }
        String[] strArr = str == null ? new String[]{"logcat", "-d", "-v", "threadtime"} : new String[]{"logcat", "-d", "-v", "threadtime", "-s", str};
        StringBuilder sb = new StringBuilder();
        try {
            process = Runtime.getRuntime().exec(strArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
                if (i > 0 && sb.length() > i) {
                    sb.delete(0, sb.length() - i);
                }
            }
            String sb2 = sb.toString();
            try {
                process.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                process.getInputStream().close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                process.getErrorStream().close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return sb2;
        } catch (Throwable th) {
            try {
                if (!C1199X.m3080b(th)) {
                    th.printStackTrace();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("\n[error:");
                sb3.append(th.toString());
                sb3.append("]");
                sb.append(sb3.toString());
                return sb.toString();
            } finally {
                if (process != null) {
                    try {
                        process.getOutputStream().close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    try {
                        process.getInputStream().close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    try {
                        process.getErrorStream().close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static String m3042a(Context context, String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        if (f1485a == null) {
            f1485a = new HashMap();
            String str2 = "/system/bin/sh";
            if (!new File(str2).exists() || !new File(str2).canExecute()) {
                str2 = "sh";
            }
            ArrayList<String> m3039a = m3039a(context, new String[]{str2, "-c", "getprop"});
            if (m3039a != null && m3039a.size() > 0) {
                C1199X.m3085a(C1208ca.class, "Successfully get 'getprop' list.", new Object[0]);
                Pattern compile = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                for (String str3 : m3039a) {
                    Matcher matcher = compile.matcher(str3);
                    if (matcher.find()) {
                        f1485a.put(matcher.group(1), matcher.group(2));
                    }
                }
                C1199X.m3085a(C1208ca.class, "Systems properties number: %d.", Integer.valueOf(f1485a.size()));
            }
        }
        return f1485a.containsKey(str) ? f1485a.get(str) : "fail";
    }

    /* renamed from: a */
    public static String m3034a(File file, int i, boolean z) {
        BufferedReader bufferedReader;
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                    if (i > 0 && sb.length() > i) {
                        if (z) {
                            sb.delete(i, sb.length());
                            break;
                        }
                        sb.delete(0, sb.length() - i);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        C1199X.m3080b(th);
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e) {
                                C1199X.m3080b(e);
                            }
                        }
                    }
                }
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Exception e2) {
                C1199X.m3080b(e2);
            }
            return sb2;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
        if (r1 != null) goto L32;
     */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m3032a(File file, String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file != null && file.exists()) {
            ?? canRead = file.canRead();
            try {
                if (canRead != 0) {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (IOException e) {
                        e = e;
                        fileInputStream = null;
                    } catch (NoSuchAlgorithmException e2) {
                        e = e2;
                        fileInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance(str);
                        byte[] bArr = new byte[102400];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            messageDigest.update(bArr, 0, read);
                        }
                        String m3021a = m3021a(messageDigest.digest());
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        return m3021a;
                    } catch (IOException e5) {
                        e = e5;
                        if (!C1199X.m3080b(e)) {
                            e.printStackTrace();
                        }
                    } catch (NoSuchAlgorithmException e6) {
                        e = e6;
                        if (!C1199X.m3080b(e)) {
                            e.printStackTrace();
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = canRead;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m3023a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    /* renamed from: a */
    public static String m3022a(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    /* renamed from: a */
    public static String m3021a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }

    /* renamed from: a */
    public static Thread m3028a(Runnable runnable, String str) {
        try {
            Thread thread = new Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (Throwable th) {
            C1199X.m3081b("[Util] Failed to start a thread to execute task with message: %s", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static ArrayList<String> m3039a(Context context, String[] strArr) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        if (AppInfo.m3430e(context)) {
            return new ArrayList<>(Arrays.asList("unknown(low memory)"));
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = null;
                }
            }
            bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            while (true) {
                try {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 != null) {
                        arrayList.add(readLine2);
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!C1199X.m3080b(th)) {
                            th.printStackTrace();
                        }
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
            }
            bufferedReader.close();
            try {
                bufferedReader2.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            bufferedReader2 = null;
        }
    }

    /* renamed from: a */
    public static Map<String, String> m3046a(int i, boolean z) {
        HashMap hashMap = new HashMap(12);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread thread = Looper.getMainLooper().getThread();
        if (!allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        long id = Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            if (!z || id != entry.getKey().getId()) {
                int i2 = 0;
                sb.setLength(0);
                if (entry.getValue() != null && entry.getValue().length != 0) {
                    StackTraceElement[] value = entry.getValue();
                    int length = value.length;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        StackTraceElement stackTraceElement = value[i2];
                        if (i > 0 && sb.length() >= i) {
                            sb.append("\n[Stack over limit size :" + i + " , has been cut!]");
                            break;
                        }
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                        i2++;
                    }
                    hashMap.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb.toString());
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static Map<String, PlugInBean> m3038a(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int intValue = ((Integer) readBundle.get("pluginNum")).intValue();
        for (int i = 0; i < intValue; i++) {
            arrayList.add(readBundle.getString("pluginKey" + i));
        }
        for (int i2 = 0; i2 < intValue; i2++) {
            String string = readBundle.getString("pluginVal" + i2 + "plugInId");
            String string2 = readBundle.getString("pluginVal" + i2 + "plugInUUID");
            arrayList2.add(new PlugInBean(string, readBundle.getString("pluginVal" + i2 + "plugInVersion"), string2));
        }
        if (arrayList.size() == arrayList2.size()) {
            hashMap = new HashMap(arrayList.size());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                hashMap.put(arrayList.get(i3), PlugInBean.class.cast(arrayList2.get(i3)));
            }
        } else {
            C1199X.m3081b("map plugin parcel error!", new Object[0]);
        }
        return hashMap;
    }

    /* renamed from: a */
    public static void m3040a(Context context, String str, String str2, int i) {
        C1199X.m3084a("rqdp{  sv sd start} %s", str);
        if (str2 == null || str2.trim().length() <= 0) {
            return;
        }
        File file = new File(str);
        try {
            if (!file.exists()) {
                if (file.getParentFile() != null) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = file.length() >= ((long) i) ? new FileOutputStream(file, false) : new FileOutputStream(file, true);
            fileOutputStream.write(str2.getBytes("UTF-8"));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
        }
        C1199X.m3084a("rqdp{  sv sd end}", new Object[0]);
    }

    /* renamed from: a */
    public static void m3037a(Parcel parcel, Map<String, PlugInBean> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle(null);
            return;
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Map.Entry<String, PlugInBean> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pluginNum", arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            bundle.putString(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("pluginKey", i), (String) arrayList.get(i));
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            bundle.putString(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("pluginVal", i2, "plugInId"), ((PlugInBean) arrayList2.get(i2)).f1000a);
            bundle.putString("pluginVal" + i2 + "plugInUUID", ((PlugInBean) arrayList2.get(i2)).f1002c);
            bundle.putString("pluginVal" + i2 + "plugInVersion", ((PlugInBean) arrayList2.get(i2)).f1001b);
        }
        parcel.writeBundle(bundle);
    }

    /* renamed from: a */
    public static void m3030a(Class<?> cls, String str, Object obj, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj2, obj);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m3027a(String str) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (!file.isFile() || !file.exists() || !file.canWrite()) {
            return;
        }
        file.delete();
    }

    /* renamed from: a */
    public static boolean m3041a(Context context, String str, long j) {
        C1199X.m3084a("[Util] Try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < j) {
                    return false;
                }
                C1199X.m3084a("[Util] Lock file (%s) is expired, unlock it.", str);
                m3015b(context, str);
            }
            if (file.createNewFile()) {
                C1199X.m3084a("[Util] Successfully locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                return true;
            }
            C1199X.m3084a("[Util] Failed to locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return false;
        } catch (Throwable th) {
            C1199X.m3080b(th);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m3033a(File file, File file2, int i) {
        ZipOutputStream zipOutputStream;
        C1199X.m3084a("rqdp{  ZF start}", new Object[0]);
        if (file == null || file2 == null || file.equals(file2)) {
            C1199X.m3076e("rqdp{  err ZF 1R!}", new Object[0]);
            return false;
        } else if (!file.exists() || !file.canRead()) {
            C1199X.m3076e("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
            return false;
        } else {
            try {
                if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                if (!file2.exists()) {
                    file2.createNewFile();
                }
            } catch (Throwable th) {
                if (!C1199X.m3080b(th)) {
                    th.printStackTrace();
                }
            }
            if (!file2.exists() || !file2.canRead()) {
                return false;
            }
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
                    try {
                        zipOutputStream.setMethod(8);
                        zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                        if (i <= 1000) {
                            i = 1000;
                        }
                        byte[] bArr = new byte[i];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, read);
                        }
                        zipOutputStream.flush();
                        zipOutputStream.closeEntry();
                        try {
                            fileInputStream2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            zipOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        C1199X.m3084a("rqdp{  ZF end}", new Object[0]);
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        try {
                            if (!C1199X.m3080b(th)) {
                                th.printStackTrace();
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (zipOutputStream != null) {
                                try {
                                    zipOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            C1199X.m3084a("rqdp{  ZF end}", new Object[0]);
                            return false;
                        } catch (Throwable th3) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (zipOutputStream != null) {
                                try {
                                    zipOutputStream.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            C1199X.m3084a("rqdp{  ZF end}", new Object[0]);
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    zipOutputStream = null;
                }
            } catch (Throwable th5) {
                th = th5;
                zipOutputStream = null;
            }
        }
    }

    /* renamed from: a */
    public static boolean m3029a(Runnable runnable) {
        if (runnable != null) {
            C1198W m3089c = C1198W.m3089c();
            if (m3089c != null) {
                return m3089c.m3092a(runnable);
            }
            String[] split = runnable.getClass().getName().split("\\.");
            return m3028a(runnable, split[split.length - 1]) != null;
        }
        return false;
    }

    /* renamed from: a */
    public static byte[] m3036a(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:(3:77|78|(17:82|83|84|8|9|10|11|12|(1:(2:14|(1:16)(1:17)))(0)|18|(2:19|(1:21)(1:22))|23|(2:33|34)|25|26|27|28))|11|12|(0)(0)|18|(3:19|(0)(0)|21)|23|(0)|25|26|27|28) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008b, code lost:
        r7.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b A[Catch: all -> 0x0094, LOOP:0: B:14:0x005b->B:16:0x0061, LOOP_START, TryCatch #2 {all -> 0x0094, blocks: (B:12:0x004a, B:14:0x005b, B:16:0x0061, B:19:0x0065, B:21:0x006b, B:23:0x006f), top: B:11:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b A[Catch: all -> 0x0094, LOOP:1: B:19:0x0065->B:21:0x006b, LOOP_END, TryCatch #2 {all -> 0x0094, blocks: (B:12:0x004a, B:14:0x005b, B:16:0x0061, B:19:0x0065, B:21:0x006b, B:23:0x006f), top: B:11:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f A[EDGE_INSN: B:22:0x006f->B:23:0x006f ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009e A[Catch: all -> 0x00bb, TRY_LEAVE, TryCatch #7 {all -> 0x00bb, blocks: (B:41:0x0098, B:43:0x009e), top: B:40:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] m3031a(File file, String str, String str2) {
        FileInputStream fileInputStream;
        ZipOutputStream zipOutputStream;
        String name;
        ByteArrayInputStream byteArrayInputStream;
        byte[] bArr;
        int read;
        if (str == null || str.length() == 0) {
            return null;
        }
        C1199X.m3084a("rqdp{  ZF start}", new Object[0]);
        try {
            if (file != null) {
                try {
                    if (file.exists() && file.canRead()) {
                        fileInputStream = new FileInputStream(file);
                        try {
                            name = file.getName();
                            byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
                            zipOutputStream.setMethod(8);
                            zipOutputStream.putNextEntry(new ZipEntry(name));
                            bArr = new byte[1024];
                            if (fileInputStream != null) {
                                while (true) {
                                    int read2 = fileInputStream.read(bArr);
                                    if (read2 <= 0) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read2);
                                }
                            }
                            while (true) {
                                read = byteArrayInputStream.read(bArr);
                                if (read > 0) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            zipOutputStream.closeEntry();
                            zipOutputStream.flush();
                            zipOutputStream.finish();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            zipOutputStream.close();
                            C1199X.m3084a("rqdp{  ZF end}", new Object[0]);
                            return byteArray;
                        } catch (Throwable th) {
                            th = th;
                            zipOutputStream = null;
                            try {
                                if (!C1199X.m3080b(th)) {
                                }
                                if (fileInputStream != null) {
                                }
                                if (zipOutputStream != null) {
                                }
                                C1199X.m3084a("rqdp{  ZF end}", new Object[0]);
                                return null;
                            } catch (Throwable th2) {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (zipOutputStream != null) {
                                    try {
                                        zipOutputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                C1199X.m3084a("rqdp{  ZF end}", new Object[0]);
                                throw th2;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    zipOutputStream = null;
                    if (!C1199X.m3080b(th)) {
                    }
                    if (fileInputStream != null) {
                    }
                    if (zipOutputStream != null) {
                    }
                    C1199X.m3084a("rqdp{  ZF end}", new Object[0]);
                    return null;
                }
            }
            zipOutputStream.setMethod(8);
            zipOutputStream.putNextEntry(new ZipEntry(name));
            bArr = new byte[1024];
            if (fileInputStream != null) {
            }
            while (true) {
                read = byteArrayInputStream.read(bArr);
                if (read > 0) {
                }
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.flush();
            zipOutputStream.finish();
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            if (fileInputStream != null) {
            }
            zipOutputStream.close();
            C1199X.m3084a("rqdp{  ZF end}", new Object[0]);
            return byteArray2;
        } catch (Throwable th4) {
            th = th4;
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            if (zipOutputStream != null) {
                try {
                    zipOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            C1199X.m3084a("rqdp{  ZF end}", new Object[0]);
            return null;
        }
        name = str2;
        fileInputStream = null;
        byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        zipOutputStream = new ZipOutputStream(byteArrayOutputStream2);
    }

    /* renamed from: a */
    public static byte[] m3020a(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr.length);
        objArr[1] = i == 2 ? "Gzip" : "zip";
        C1199X.m3084a("[Util] Unzip %d bytes data with type %s", objArr);
        try {
            AbstractC1218ha m2969a = C1216ga.m2969a(i);
            if (m2969a != null) {
                return m2969a.mo2945b(bArr);
            }
            return null;
        } catch (Throwable th) {
            if (th.getMessage() != null && th.getMessage().contains("Not in GZIP format")) {
                C1199X.m3076e(th.getMessage(), new Object[0]);
            } else if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: b */
    public static long m3018b() {
        try {
            return (((System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 86400000) * 86400000) - TimeZone.getDefault().getRawOffset();
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return -1L;
            }
            th.printStackTrace();
            return -1L;
        }
    }

    /* renamed from: b */
    public static long m3009b(byte[] bArr) {
        if (bArr == null) {
            return -1L;
        }
        try {
            return Long.parseLong(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    /* renamed from: b */
    public static String m3011b(String str, String str2) {
        return (C1140a.m3394m() == null || C1140a.m3394m().f1062qa == null) ? "" : C1140a.m3394m().f1062qa.getString(str, str2);
    }

    /* renamed from: b */
    public static String m3010b(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (C1199X.m3080b(th2)) {
                return "fail";
            }
            th2.printStackTrace();
            return "fail";
        }
    }

    /* renamed from: b */
    public static Map<String, String> m3014b(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = readBundle.getStringArrayList(SavedStateHandle.KEYS);
        ArrayList<String> stringArrayList2 = readBundle.getStringArrayList(SavedStateHandle.VALUES);
        if (stringArrayList == null || stringArrayList2 == null || stringArrayList.size() != stringArrayList2.size()) {
            C1199X.m3081b("map parcel error!", new Object[0]);
        } else {
            hashMap = new HashMap(stringArrayList.size());
            for (int i = 0; i < stringArrayList.size(); i++) {
                hashMap.put(stringArrayList.get(i), stringArrayList2.get(i));
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    public static void m3013b(Parcel parcel, Map<String, String> map) {
        Bundle bundle;
        if (map == null || map.size() <= 0) {
            bundle = null;
        } else {
            int size = map.size();
            ArrayList<String> arrayList = new ArrayList<>(size);
            ArrayList<String> arrayList2 = new ArrayList<>(size);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(entry.getKey());
                arrayList2.add(entry.getValue());
            }
            bundle = new Bundle();
            bundle.putStringArrayList(SavedStateHandle.KEYS, arrayList);
            bundle.putStringArrayList(SavedStateHandle.VALUES, arrayList2);
        }
        parcel.writeBundle(bundle);
    }

    /* renamed from: b */
    public static boolean m3016b(Context context) {
        try {
            return C1140a.m3394m().m3427C();
        } catch (SecurityException unused) {
            C1199X.m3081b("无法获取GET_TASK权限，将在通知栏提醒升级，如需弹窗提醒，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
            return true;
        } catch (Exception e) {
            if (C1199X.m3083a(e)) {
                return true;
            }
            e.printStackTrace();
            return true;
        }
    }

    /* renamed from: b */
    public static boolean m3015b(Context context, String str) {
        C1199X.m3084a("[Util] Try to unlock file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            C1199X.m3084a("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            C1199X.m3080b(th);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m3012b(String str) {
        return str == null || str.trim().length() <= 0;
    }

    /* renamed from: b */
    public static byte[] m3017b(long j) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(j);
            return sb.toString().getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m3008b(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr.length);
        objArr[1] = i == 2 ? "Gzip" : "zip";
        C1199X.m3084a("[Util] Zip %d bytes data with type %s", objArr);
        try {
            AbstractC1218ha m2969a = C1216ga.m2969a(i);
            if (m2969a != null) {
                return m2969a.mo2946a(bArr);
            }
            return null;
        } catch (Throwable th) {
            if (!C1199X.m3080b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: c */
    public static String m3004c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "NULL";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr);
            return m3021a(messageDigest.digest());
        } catch (Throwable th) {
            if (C1199X.m3080b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static void m3007c(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static void m3005c(String str, String str2) {
        if (C1140a.m3394m() == null || C1140a.m3394m().f1062qa == null) {
            return;
        }
        C1140a.m3394m().f1062qa.edit().putString(str, str2).apply();
    }

    /* renamed from: c */
    public static boolean m3006c(String str) {
        if (m3012b(str)) {
            return false;
        }
        if (str.length() > 255) {
            C1199X.m3078c("URL(%s)'s length is larger than 255.", str);
            return false;
        } else if (str.toLowerCase().startsWith("http")) {
            return true;
        } else {
            C1199X.m3078c("URL(%s) is not start with \"http\".", str);
            return false;
        }
    }

    /* renamed from: d */
    public static Parcel m3003d(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        return obtain;
    }
}

package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.tencent.bugly.crashreport.crash.jni.c */
/* loaded from: classes3.dex */
public class C1171c {

    /* renamed from: a */
    public static List<File> f1304a = new ArrayList();

    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    /* renamed from: a */
    public static CrashDetailBean m3226a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        BufferedInputStream bufferedInputStream;
        String str2;
        String m3224a;
        BufferedInputStream bufferedInputStream2 = null;
        if (context == null || str == null || nativeExceptionHandler == null) {
            C1199X.m3081b("get eup record file args error", new Object[0]);
            return null;
        }
        File file = new File(str, "rqd_record.eup");
        if (file.exists()) {
            ?? canRead = file.canRead();
            try {
                if (canRead != 0) {
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        try {
                            String m3224a2 = m3224a(bufferedInputStream);
                            if (m3224a2 != null && m3224a2.equals("NATIVE_RQD_REPORT")) {
                                HashMap hashMap = new HashMap();
                                loop0: while (true) {
                                    str2 = null;
                                    while (true) {
                                        m3224a = m3224a(bufferedInputStream);
                                        if (m3224a == null) {
                                            break loop0;
                                        } else if (str2 == null) {
                                            str2 = m3224a;
                                        }
                                    }
                                    hashMap.put(str2, m3224a);
                                }
                                if (str2 != null) {
                                    C1199X.m3081b("record not pair! drop! %s", str2);
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    return null;
                                }
                                CrashDetailBean m3225a = m3225a(context, hashMap, nativeExceptionHandler);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                return m3225a;
                            }
                            C1199X.m3081b("record read fail! %s", m3224a2);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            return null;
                        } catch (IOException e4) {
                            e = e4;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            return null;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        bufferedInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = canRead;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static CrashDetailBean m3225a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        String str;
        String str2;
        HashMap hashMap;
        if (map == null) {
            return null;
        }
        if (C1140a.m3421a(context) == null) {
            C1199X.m3081b("abnormal com info not created", new Object[0]);
            return null;
        }
        String str3 = map.get("intStateStr");
        if (str3 == null || str3.trim().length() <= 0) {
            C1199X.m3081b("no intStateStr", new Object[0]);
            return null;
        }
        Map<String, Integer> m3215d = m3215d(str3);
        if (m3215d == null) {
            C1199X.m3081b("parse intSateMap fail", Integer.valueOf(map.size()));
            return null;
        }
        try {
            m3215d.get("sino").intValue();
            m3215d.get("sud").intValue();
            String str4 = map.get("soVersion");
            if (TextUtils.isEmpty(str4)) {
                C1199X.m3081b("error format at version", new Object[0]);
                return null;
            }
            String str5 = map.get("errorAddr");
            String str6 = "unknown";
            String str7 = str5 == null ? str6 : str5;
            String str8 = map.get("codeMsg");
            if (str8 == null) {
                str8 = str6;
            }
            String str9 = map.get("tombPath");
            String str10 = str9 == null ? str6 : str9;
            String str11 = map.get("signalName");
            if (str11 == null) {
                str11 = str6;
            }
            map.get("errnoMsg");
            String str12 = map.get("stack");
            if (str12 == null) {
                str12 = str6;
            }
            String str13 = map.get("jstack");
            if (str13 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str12);
                sb.append("java:\n");
                sb.append(str13);
                str12 = sb.toString();
            }
            Integer num = m3215d.get("sico");
            if (num == null || num.intValue() <= 0) {
                str = str8;
                str2 = str11;
            } else {
                str2 = str11 + "(" + str8 + ")";
                str = "KERNEL";
            }
            String str14 = map.get("nativeLog");
            byte[] m3031a = (str14 == null || str14.isEmpty()) ? null : C1208ca.m3031a((File) null, str14, "BuglyNativeLog.txt");
            String str15 = map.get("sendingProcess");
            if (str15 == null) {
                str15 = str6;
            }
            Integer num2 = m3215d.get("spd");
            if (num2 != null) {
                str15 = str15 + "(" + num2 + ")";
            }
            String str16 = str15;
            String str17 = map.get("threadName");
            if (str17 == null) {
                str17 = str6;
            }
            Integer num3 = m3215d.get("et");
            if (num3 != null) {
                str17 = str17 + "(" + num3 + ")";
            }
            String str18 = str17;
            String str19 = map.get("processName");
            if (str19 != null) {
                str6 = str19;
            }
            Integer num4 = m3215d.get("ep");
            if (num4 != null) {
                str6 = str6 + "(" + num4 + ")";
            }
            String str20 = str6;
            String str21 = map.get("key-value");
            if (str21 != null) {
                HashMap hashMap2 = new HashMap();
                for (String str22 : str21.split("\n")) {
                    String[] split = str22.split("=");
                    if (split.length == 2) {
                        hashMap2.put(split[0], split[1]);
                    }
                }
                hashMap = hashMap2;
            } else {
                hashMap = null;
            }
            CrashDetailBean packageCrashDatas = nativeExceptionHandler.packageCrashDatas(str20, str18, (m3215d.get("etms").intValue() / 1000) + (m3215d.get("ets").intValue() * 1000), str2, str7, m3223a(str12), str, str16, str10, map.get("sysLogPath"), map.get("jniLogPath"), str4, m3031a, hashMap, false, false);
            if (packageCrashDatas != null) {
                String str23 = map.get("userId");
                if (str23 != null) {
                    C1199X.m3084a("[Native record info] userId: %s", str23);
                    packageCrashDatas.f1157m = str23;
                }
                String str24 = map.get("sysLog");
                if (str24 != null) {
                    packageCrashDatas.f1167w = str24;
                }
                String str25 = map.get("appVersion");
                if (str25 != null) {
                    C1199X.m3084a("[Native record info] appVersion: %s", str25);
                    packageCrashDatas.f1150f = str25;
                }
                String str26 = map.get("isAppForeground");
                if (str26 != null) {
                    C1199X.m3084a("[Native record info] isAppForeground: %s", str26);
                    packageCrashDatas.f1135O = str26.equalsIgnoreCase("true");
                }
                String str27 = map.get("launchTime");
                if (str27 != null) {
                    C1199X.m3084a("[Native record info] launchTime: %s", str27);
                    try {
                        packageCrashDatas.f1134N = Long.parseLong(str27);
                    } catch (NumberFormatException e) {
                        if (!C1199X.m3080b(e)) {
                            e.printStackTrace();
                        }
                    }
                }
                packageCrashDatas.f1170z = null;
                packageCrashDatas.f1155k = true;
            }
            return packageCrashDatas;
        } catch (Throwable th) {
            C1199X.m3081b("error format", new Object[0]);
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
        return null;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m3224a(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bufferedInputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int read = bufferedInputStream.read();
                    if (read == -1) {
                        break;
                    } else if (read == 0) {
                        String str = new String(byteArrayOutputStream.toByteArray(), "UTf-8");
                        byteArrayOutputStream.close();
                        return str;
                    } else {
                        byteArrayOutputStream.write(read);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        C1199X.m3080b(th);
                    } finally {
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    /* renamed from: a */
    public static String m3223a(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.String] */
    /* renamed from: a */
    public static String m3222a(String str, int i, String str2, boolean z) {
        BufferedReader bufferedReader = null;
        if (str != null && i > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                C1199X.m3078c("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                f1304a.add(file);
                C1199X.m3084a("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return C1208ca.m3034a(new File(str), i, z);
                }
                String sb = new StringBuilder();
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str2);
                                sb2.append("[ ]*:");
                                if (Pattern.compile(sb2.toString()).matcher(readLine).find()) {
                                    sb.append(readLine);
                                    sb.append("\n");
                                }
                                if (i > 0 && sb.length() > i) {
                                    if (z) {
                                        sb.delete(i, sb.length());
                                        break;
                                    }
                                    sb.delete(0, sb.length() - i);
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                try {
                                    C1199X.m3080b(th);
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("\n[error:");
                                    sb3.append(th.toString());
                                    sb3.append("]");
                                    sb.append(sb3.toString());
                                    String sb4 = sb.toString();
                                    if (bufferedReader == null) {
                                        return sb4;
                                    }
                                    bufferedReader.close();
                                    sb = sb4;
                                    return sb;
                                } catch (Throwable th2) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e) {
                                            C1199X.m3080b(e);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        String sb5 = sb.toString();
                        bufferedReader2.close();
                        sb = sb5;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    return sb;
                } catch (Exception e2) {
                    C1199X.m3080b(e2);
                    return sb;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m3221a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String m3216c = m3216c(str, str2);
        if (m3216c != null && !m3216c.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(m3216c);
        }
        String m3218b = m3218b(str, str2);
        if (m3218b != null && !m3218b.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(m3218b);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static void m3220a(boolean z, String str) {
        if (str != null) {
            f1304a.add(new File(str, "rqd_record.eup"));
            f1304a.add(new File(str, "reg_record.txt"));
            f1304a.add(new File(str, "map_record.txt"));
            f1304a.add(new File(str, "backup_record.txt"));
            if (z) {
                m3219b(str);
            }
        }
        List<File> list = f1304a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f1304a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                C1199X.m3084a("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    /* renamed from: b */
    public static String m3218b(String str, String str2) {
        BufferedReader m3025a = C1208ca.m3025a(str, "map_record.txt");
        if (m3025a == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = m3025a.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                while (true) {
                    String readLine2 = m3025a.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    sb.append("  ");
                    sb.append(readLine2);
                    sb.append("\n");
                }
                return sb.toString();
            }
            try {
                m3025a.close();
            } catch (Exception e) {
                C1199X.m3080b(e);
            }
            return null;
        } catch (Throwable th) {
            try {
                C1199X.m3080b(th);
                try {
                    m3025a.close();
                } catch (Exception e2) {
                    C1199X.m3080b(e2);
                }
                return null;
            } finally {
                try {
                    m3025a.close();
                } catch (Exception e3) {
                    C1199X.m3080b(e3);
                }
            }
        }
    }

    /* renamed from: b */
    public static void m3219b(String str) {
        File[] listFiles;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (!file.canRead() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
                return;
            }
            for (File file2 : listFiles) {
                if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                    file2.delete();
                    C1199X.m3084a("Delete empty record file %s", file2.getAbsoluteFile());
                }
            }
        } catch (Throwable th) {
            C1199X.m3080b(th);
        }
    }

    /* renamed from: c */
    public static String m3217c(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (!file.exists()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    /* renamed from: c */
    public static String m3216c(String str, String str2) {
        String substring;
        BufferedReader m3025a = C1208ca.m3025a(str, "reg_record.txt");
        if (m3025a == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = m3025a.readLine();
            if (readLine == null || !readLine.startsWith(str2)) {
                try {
                    m3025a.close();
                } catch (Exception e) {
                    C1199X.m3080b(e);
                }
                return null;
            }
            int i = 18;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                String readLine2 = m3025a.readLine();
                if (readLine2 == null) {
                    break;
                }
                if (i2 % 4 == 0) {
                    if (i2 > 0) {
                        sb.append("\n");
                    }
                    substring = "  ";
                } else {
                    if (readLine2.length() > 16) {
                        i = 28;
                    }
                    substring = "                ".substring(0, i - i3);
                }
                sb.append(substring);
                i3 = readLine2.length();
                sb.append(readLine2);
                i2++;
            }
            sb.append("\n");
            return sb.toString();
        } catch (Throwable th) {
            try {
                C1199X.m3080b(th);
                try {
                    m3025a.close();
                } catch (Exception e2) {
                    C1199X.m3080b(e2);
                }
                return null;
            } finally {
                try {
                    m3025a.close();
                } catch (Exception e3) {
                    C1199X.m3080b(e3);
                }
            }
        }
    }

    /* renamed from: d */
    public static Map<String, Integer> m3215d(String str) {
        String[] split;
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(",")) {
                String[] split2 = str2.split(":");
                if (split2.length != 2) {
                    C1199X.m3081b("error format at %s", str2);
                    return null;
                }
                hashMap.put(split2[0], Integer.valueOf(Integer.parseInt(split2[1])));
            }
            return hashMap;
        } catch (Exception e) {
            C1199X.m3081b("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }
}

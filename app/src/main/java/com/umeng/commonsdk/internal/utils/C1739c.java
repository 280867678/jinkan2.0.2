package com.umeng.commonsdk.internal.utils;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.umeng.commonsdk.internal.utils.c */
/* loaded from: classes4.dex */
public class C1739c {

    /* renamed from: com.umeng.commonsdk.internal.utils.c$a */
    /* loaded from: classes4.dex */
    public static class C1740a {

        /* renamed from: a */
        public String f3955a;

        /* renamed from: b */
        public String f3956b;

        /* renamed from: c */
        public int f3957c;

        /* renamed from: d */
        public String f3958d;

        /* renamed from: e */
        public String f3959e;

        /* renamed from: f */
        public String f3960f;

        /* renamed from: g */
        public String f3961g;

        /* renamed from: h */
        public String f3962h;

        /* renamed from: i */
        public String f3963i;

        /* renamed from: j */
        public String f3964j;

        /* renamed from: k */
        public String f3965k;

        /* renamed from: l */
        public String f3966l;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C1740a m669a() {
        C1740a c1740a;
        BufferedReader bufferedReader;
        FileReader fileReader;
        Throwable th;
        int i;
        FileReader fileReader2 = null;
        int i2 = 0;
        try {
            try {
                c1740a = new C1740a();
            } catch (Throwable th2) {
                th = th2;
                fileReader = null;
                bufferedReader = null;
            }
            try {
                fileReader = new FileReader("/proc/cpuinfo");
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    try {
                        try {
                            int i3 = 0;
                            boolean z = true;
                            i = 0;
                            for (String readLine = bufferedReader.readLine(); !TextUtils.isEmpty(readLine) && (i3 = i3 + 1) < 30; readLine = bufferedReader.readLine()) {
                                try {
                                    String[] split = readLine.split(":\\s+", 2);
                                    if (z && split != null && split.length > 1) {
                                        c1740a.f3955a = split[1];
                                        z = false;
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("processor")) {
                                        i++;
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("Features")) {
                                        c1740a.f3958d = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("implementer")) {
                                        c1740a.f3959e = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("architecture")) {
                                        c1740a.f3960f = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("variant")) {
                                        c1740a.f3961g = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("part")) {
                                        c1740a.f3962h = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("revision")) {
                                        c1740a.f3963i = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("Hardware")) {
                                        c1740a.f3964j = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("Revision")) {
                                        c1740a.f3965k = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("Serial")) {
                                        c1740a.f3966l = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("implementer")) {
                                        c1740a.f3959e = split[1];
                                    }
                                } catch (Exception unused) {
                                    fileReader2 = fileReader;
                                    i2 = i;
                                    if (fileReader2 != null) {
                                        try {
                                            fileReader2.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException unused3) {
                                        }
                                    }
                                    i = i2;
                                    c1740a.f3957c = i;
                                    return c1740a;
                                }
                            }
                            try {
                                fileReader.close();
                            } catch (IOException unused4) {
                            }
                            try {
                                bufferedReader.close();
                            } catch (IOException unused5) {
                            }
                        } catch (Exception unused6) {
                            fileReader2 = fileReader;
                            if (fileReader2 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            i = i2;
                            c1740a.f3957c = i;
                            return c1740a;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused8) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused9) {
                    bufferedReader = null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    th = th;
                    if (fileReader != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            } catch (Exception unused10) {
                bufferedReader = null;
            }
        } catch (Exception unused11) {
            c1740a = null;
            bufferedReader = null;
        }
        c1740a.f3957c = i;
        return c1740a;
    }

    /* renamed from: b */
    public static String m668b() {
        byte[] bArr;
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            while (inputStream.read(new byte[24]) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    /* renamed from: c */
    public static String m667c() {
        byte[] bArr;
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            while (inputStream.read(new byte[24]) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    /* renamed from: d */
    public static String m666d() {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
            try {
                String trim = bufferedReader.readLine().trim();
                try {
                    bufferedReader.close();
                    return trim;
                } catch (Throwable unused) {
                    return trim;
                }
            } catch (Exception unused2) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Throwable unused3) {
                    }
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }
}

package com.efs.sdk.memoryinfo;

import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.efs.sdk.memoryinfo.f */
/* loaded from: classes3.dex */
public final class C0803f {
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
        r5 = java.lang.Long.parseLong(r8.group());
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long m3975a() {
        BufferedReader bufferedReader;
        long j;
        long j2 = -1;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/status")));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append('\n');
                }
                String[] split = sb.toString().trim().split("\n");
                int length = split.length;
                int length2 = split.length;
                int i = 0;
                while (true) {
                    if (i >= length2) {
                        j = -1;
                        break;
                    }
                    String str = split[i];
                    if (str.startsWith("VmSize")) {
                        Matcher matcher = Pattern.compile("\\d+").matcher(str);
                        if (matcher.find()) {
                            break;
                        }
                    }
                    i++;
                }
                if (j == -1 && length > 12) {
                    try {
                        Matcher matcher2 = Pattern.compile("\\d+").matcher(split[12]);
                        if (matcher2.find()) {
                            j = Long.parseLong(matcher2.group());
                        }
                    } catch (Throwable unused) {
                        j2 = j;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        return j2;
                    }
                }
                try {
                    bufferedReader.close();
                } catch (Throwable unused3) {
                    return j;
                }
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
        }
    }

    /* renamed from: a */
    public static long m3974a(Debug.MemoryInfo memoryInfo) {
        if (Build.VERSION.SDK_INT >= 23) {
            String memoryStat = memoryInfo.getMemoryStat("summary.graphics");
            try {
                if (TextUtils.isEmpty(memoryStat)) {
                    return 0L;
                }
                return Long.parseLong(memoryStat);
            } catch (Exception unused) {
                return 0L;
            }
        }
        return 0L;
    }

    /* renamed from: a */
    public static void m3973a(String str, Throwable th) {
        boolean z = C0793a.DEBUG;
    }
}

package com.tencent.smtt.sdk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* renamed from: com.tencent.smtt.sdk.a */
/* loaded from: classes4.dex */
public class C1344a {

    /* renamed from: a */
    public static int f2047a = 600;

    /* renamed from: b */
    public static int f2048b;

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
        r2 = r2.substring(r4 + 9).trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
        if (r2 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
        if (r2.length() == 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
        if (r2.contains("k") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
        r3 = java.lang.Integer.parseInt(r2.substring(0, r2.indexOf("k")).trim()) / 1024;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0056 -> B:25:0x0073). Please submit an issue!!! */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m2662a() {
        String readLine;
        int i = f2048b;
        if (i > 0) {
            return i;
        }
        BufferedReader bufferedReader = null;
        int i2 = 0;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                    while (true) {
                        try {
                            readLine = bufferedReader2.readLine();
                            if (readLine != null) {
                                int indexOf = readLine.indexOf("MemTotal:");
                                if (-1 != indexOf) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } catch (IOException e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                                bufferedReader = bufferedReader;
                            }
                            f2048b = i2;
                            return i2;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            th.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                                bufferedReader = bufferedReader;
                            }
                            f2048b = i2;
                            return i2;
                        }
                    }
                    bufferedReader2.close();
                    bufferedReader = readLine;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    bufferedReader = bufferedReader;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
            }
            f2048b = i2;
            return i2;
        } catch (Throwable th3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th3;
        }
    }
}

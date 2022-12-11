package com.p038qq.p039e.comm.managers.plugin;

import android.text.TextUtils;
import com.p038qq.p039e.comm.managers.plugin.C1067c;
import com.p038qq.p039e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* renamed from: com.qq.e.comm.managers.plugin.g */
/* loaded from: classes3.dex */
public class C1073g {
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C1073g(File file, File file2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = file;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = file2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file) throws IOException {
        Throwable th;
        ?? r1 = 0;
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            String sb2 = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                                GDTLogger.m3647d("Exception while close bufferreader");
                            }
                            return sb2;
                        } catch (IOException e) {
                            throw e;
                        }
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (Exception unused2) {
                                GDTLogger.m3647d("Exception while close bufferreader");
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                r1 = file;
                th = th3;
            }
        }
        return null;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        try {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.exists() && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.exists()) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return false;
                }
                String[] split = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.split("#####");
                if (split.length == 2) {
                    String str = split[1];
                    try {
                        i = Integer.parseInt(split[0]);
                    } catch (Throwable unused) {
                        i = 0;
                    }
                    if (C1067c.C1069b.f665a.m3656a(str, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable unused2) {
            GDTLogger.m3647d("Exception while checking plugin");
            return false;
        }
    }

    /* renamed from: d */
    public String m3651d() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}

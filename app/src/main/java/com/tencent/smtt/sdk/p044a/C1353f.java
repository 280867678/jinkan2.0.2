package com.tencent.smtt.sdk.p044a;

import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import me.tvspark.outline;

/* renamed from: com.tencent.smtt.sdk.a.f */
/* loaded from: classes4.dex */
public class C1353f {

    /* renamed from: a */
    public static String f2076a = "EmergencyManager";

    /* renamed from: b */
    public final File f2077b;

    /* renamed from: c */
    public final FileOutputStream f2078c;

    /* renamed from: d */
    public final FileLock f2079d;

    public C1353f(File file, FileOutputStream fileOutputStream, FileLock fileLock) {
        this.f2077b = file;
        this.f2078c = fileOutputStream;
        this.f2079d = fileLock;
    }

    /* renamed from: a */
    public static C1353f m2634a(File file) {
        Throwable th;
        FileOutputStream fileOutputStream;
        String str;
        StringBuilder sb;
        FileLock tryLock;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                tryLock = fileOutputStream.getChannel().tryLock();
            } catch (Throwable th2) {
                th = th2;
                try {
                    TbsLog.m2158e(f2076a, "Failed to try to acquire lock: " + file.getAbsolutePath() + " error: " + th.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e = e;
                            str = f2076a;
                            sb = new StringBuilder();
                            sb.append("Failed to close: ");
                            sb.append(e.getMessage());
                            TbsLog.m2158e(str, sb.toString());
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th3) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            String str2 = f2076a;
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to close: ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e2.getMessage());
                            TbsLog.m2158e(str2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        if (tryLock == null) {
            try {
                fileOutputStream.close();
            } catch (IOException e3) {
                e = e3;
                str = f2076a;
                sb = new StringBuilder();
                sb.append("Failed to close: ");
                sb.append(e.getMessage());
                TbsLog.m2158e(str, sb.toString());
                return null;
            }
            return null;
        }
        TbsLog.m2155i(f2076a, "Created lock file: " + file.getAbsolutePath());
        C1353f c1353f = new C1353f(file, fileOutputStream, tryLock);
        try {
            fileOutputStream.close();
        } catch (IOException e4) {
            String str3 = f2076a;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to close: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e4.getMessage());
            TbsLog.m2158e(str3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        return c1353f;
    }

    /* renamed from: a */
    public void m2635a() throws IOException {
        String str = f2076a;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Deleting lock file: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2077b.getAbsolutePath());
        TbsLog.m2155i(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        this.f2079d.release();
        this.f2078c.close();
        if (this.f2077b.delete()) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to delete lock file: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.f2077b.getAbsolutePath());
        throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
    }

    /* renamed from: b */
    public void m2633b() {
        try {
            m2635a();
        } catch (IOException unused) {
        }
    }
}

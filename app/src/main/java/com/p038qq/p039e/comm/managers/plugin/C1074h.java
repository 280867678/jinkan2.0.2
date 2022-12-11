package com.p038qq.p039e.comm.managers.plugin;

import android.content.Context;
import com.p038qq.p039e.comm.util.GDTLogger;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

/* renamed from: com.qq.e.comm.managers.plugin.h */
/* loaded from: classes3.dex */
public class C1074h {
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1066b.m3657a("e_qq_com_plugin");
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1066b.m3657a("e_qq_com_dex");

    public static File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        return new File(context.getDir(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0), "gdt_plugin.jar.sig");
    }

    public static File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        return new File(context.getDir(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0), "gdt_plugin.jar");
    }

    public static File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        return new File(context.getDir(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0), "gdt_plugin.next");
    }

    public static File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        return new File(context.getDir(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0), "update_lc");
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return "gdt_plugin";
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, File file) throws IOException {
        if (file != null) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
                try {
                    outputStreamWriter2.write(str);
                    m3650a(outputStreamWriter2);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    m3650a(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new IOException("Target File Can not be null in StringUtil.writeTo");
        }
    }

    /* renamed from: a */
    public static void m3650a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m3649a(File file, File file2) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.renameTo(file2)) {
            return true;
        }
        return m3648a((InputStream) null, file2);
    }

    /* renamed from: a */
    public static boolean m3648a(InputStream inputStream, File file) {
        if (inputStream == null || file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            File parentFile = file.getParentFile();
            if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (Throwable unused) {
                    fileOutputStream = fileOutputStream;
                    try {
                        GDTLogger.m3647d(String.format("Exception while copy from InputStream to File %s", file.getAbsolutePath()));
                        return false;
                    } finally {
                        m3650a(inputStream);
                        m3650a(fileOutputStream);
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return false;
    }
}

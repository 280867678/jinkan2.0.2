package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import com.stub.StubApp;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsLogReport;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import me.tvspark.outline;
import org.apache.commons.p056io.input.Tailer;

@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class FileUtil {

    /* renamed from: a */
    public static String f2367a = null;

    /* renamed from: b */
    public static final AbstractC1425a f2368b = new AbstractC1425a() { // from class: com.tencent.smtt.utils.FileUtil.2
        @Override // com.tencent.smtt.utils.FileUtil.AbstractC1425a
        /* renamed from: a */
        public boolean mo2164a(File file, File file2) {
            return file.length() == file2.length() && file.lastModified() == file2.lastModified();
        }
    };

    /* renamed from: c */
    public static final int f2369c = 4;

    /* renamed from: d */
    public static RandomAccessFile f2370d;

    /* renamed from: com.tencent.smtt.utils.FileUtil$a */
    /* loaded from: classes4.dex */
    public interface AbstractC1425a {
        /* renamed from: a */
        boolean mo2164a(File file, File file2);
    }

    /* renamed from: com.tencent.smtt.utils.FileUtil$b */
    /* loaded from: classes4.dex */
    public interface AbstractC1426b {
        /* renamed from: a */
        boolean mo2163a(InputStream inputStream, ZipEntry zipEntry, String str) throws Exception;
    }

    /* renamed from: a */
    public static long m2185a(InputStream inputStream, OutputStream outputStream) throws IOException, OutOfMemoryError {
        if (inputStream == null) {
            return -1L;
        }
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    /* renamed from: a */
    public static File m2196a(Context context, String str) {
        String str2;
        File file = new File(context.getFilesDir(), "tbs");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.canWrite()) {
            File file2 = new File(file, str);
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (IOException e) {
                    str2 = "getPermanentTbsFile -- exception: " + e;
                }
            }
            return file2;
        }
        str2 = "getPermanentTbsFile -- no permission!";
        TbsLog.m2158e("FileHelper", str2);
        return null;
    }

    /* renamed from: a */
    public static File m2193a(Context context, boolean z, String str) {
        String m2169d = z ? m2169d(context) : m2171c(context);
        if (m2169d == null) {
            return null;
        }
        File file = new File(m2169d);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canWrite()) {
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return file2;
    }

    /* renamed from: a */
    public static String m2198a(Context context, int i) {
        return m2195a(context, context.getApplicationInfo().packageName, i, true);
    }

    /* renamed from: a */
    public static String m2195a(Context context, String str, int i, boolean z) {
        String str2;
        if (context == null) {
            return "";
        }
        try {
            str2 = Environment.getExternalStorageDirectory() + File.separator;
        } catch (Exception e) {
            TbsLog.m2152i(e);
            str2 = "";
        }
        switch (i) {
            case 1:
                if (str2.equals("")) {
                    return str2;
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "tencent");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(File.separator);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("tbs");
                return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, File.separator, str);
            case 2:
                if (str2.equals("")) {
                    return str2;
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "tbs");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(File.separator);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("backup");
                return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, File.separator, str);
            case 3:
                if (str2.equals("")) {
                    return str2;
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "tencent");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(File.separator);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("tbs");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(File.separator);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("backup");
                return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, File.separator, str);
            case 4:
                if (str2.equals("")) {
                    return m2177b(context, "stable");
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "tencent");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(File.separator);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append("tbs");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(File.separator);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append("stable");
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, File.separator, str);
                if (!z) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                File file = new File(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (file.exists() && file.canWrite()) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                if (!file.exists()) {
                    try {
                        file.mkdirs();
                    } catch (SecurityException e2) {
                        TbsLog.m2152i(e2);
                    }
                    if (file.canWrite()) {
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                }
                return m2177b(context, "stable");
            case 5:
                if (str2.equals("")) {
                    return str2;
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "tencent");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(File.separator);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append("tbs");
                return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, File.separator, str);
            case 6:
                String str3 = f2367a;
                if (str3 != null) {
                    return str3;
                }
                String m2177b = m2177b(context, "tbslog");
                f2367a = m2177b;
                return m2177b;
            case 7:
                if (str2.equals("")) {
                    return str2;
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "tencent");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append(File.separator);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append("tbs");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append(File.separator);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append("backup");
                return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, File.separator, "core");
            case 8:
                return m2177b(context, "env");
            default:
                return "";
        }
    }

    /* renamed from: a */
    public static FileLock m2197a(Context context, FileOutputStream fileOutputStream) {
        FileLock tryLock;
        if (fileOutputStream == null) {
            return null;
        }
        try {
            tryLock = fileOutputStream.getChannel().tryLock();
        } catch (OverlappingFileLockException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!tryLock.isValid()) {
            return null;
        }
        return tryLock;
    }

    /* renamed from: a */
    public static synchronized void m2194a(Context context, FileLock fileLock) {
        synchronized (FileUtil.class) {
            TbsLog.m2155i("FileHelper", "releaseTbsCoreRenameFileLock -- lock: " + fileLock);
            FileChannel channel = fileLock.channel();
            if (channel != null && channel.isOpen()) {
                try {
                    fileLock.release();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2188a(File file, boolean z) {
        m2186a(file, z, false);
    }

    /* renamed from: a */
    public static void m2187a(File file, boolean z, String str) {
        try {
            if (file.getAbsolutePath().contains("stable")) {
                C1472q.m1984a("delete_file", "path_" + file.getAbsolutePath() + "_stack_" + Log.getStackTraceString(new Throwable()));
            }
        } catch (Throwable th) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is "), "FileUtils");
        }
        TbsLog.m2155i("FileUtils", "delete file,ignore=" + z + "except" + str + file + Log.getStackTraceString(new Throwable()));
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (!file2.getName().equals(str)) {
                m2188a(file2, z);
            }
        }
        if (z) {
            return;
        }
        file.delete();
    }

    /* renamed from: a */
    public static void m2186a(File file, boolean z, boolean z2) {
        try {
            if (file.getAbsolutePath().contains("stable")) {
                C1472q.m1984a("delete_file", "path_" + file.getAbsolutePath() + "_stack_" + Log.getStackTraceString(new Throwable()));
            }
        } catch (Throwable unused) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("stack is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Log.getStackTraceString(new Throwable()));
            TbsLog.m2155i("FileUtils", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        TbsLog.m2155i("FileUtils", "delete file,ignore=" + z + "isSoftLink=" + z2);
        if (file == null) {
            return;
        }
        if (!z2 && !file.exists()) {
            return;
        }
        if ((z2 && !file.isDirectory()) || file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            m2186a(file2, z, z2);
        }
        if (z) {
            return;
        }
        file.delete();
    }

    /* renamed from: a */
    public static void m2179a(FileLock fileLock, FileOutputStream fileOutputStream) {
        if (fileLock != null) {
            try {
                FileChannel channel = fileLock.channel();
                if (channel != null && channel.isOpen()) {
                    fileLock.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static boolean m2199a(Context context) {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (context == null) {
            return false;
        }
        if (StubApp.getOrigApplicationContext(context.getApplicationContext()).checkSelfPermission(UMUtils.SD_PERMISSION) != 0) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m2192a(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        m2175b(file);
        return file.mkdirs();
    }

    /* renamed from: a */
    public static boolean m2191a(File file, File file2) throws Exception {
        return m2182a(file.getPath(), file2.getPath());
    }

    /* renamed from: a */
    public static boolean m2190a(File file, File file2, FileFilter fileFilter) throws Exception {
        return m2189a(file, file2, fileFilter, f2368b);
    }

    /* renamed from: a */
    public static boolean m2189a(File file, File file2, FileFilter fileFilter, AbstractC1425a abstractC1425a) throws Exception {
        boolean z = false;
        if (file != null && file2 != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("copyFiles src is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(file.getAbsolutePath());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" dst is ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(file2.getAbsolutePath());
            TbsLog.m2158e("FileHelper", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            if (!file.exists()) {
                return false;
            }
            if (file.isFile()) {
                return m2173b(file, file2, fileFilter, abstractC1425a);
            }
            File[] listFiles = file.listFiles(fileFilter);
            if (listFiles == null) {
                return false;
            }
            z = true;
            for (File file3 : listFiles) {
                if (!m2190a(file3, new File(file2, file3.getName()), fileFilter)) {
                    z = false;
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m2183a(String str, long j, long j2, long j3) throws Exception {
        File file = new File(str);
        if (file.length() != j) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("file size doesn't match: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(file.length());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" vs ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(j);
            TbsLog.m2158e("FileHelper", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return true;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                CRC32 crc32 = new CRC32();
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    crc32.update(bArr, 0, read);
                }
                long value = crc32.getValue();
                TbsLog.m2155i("FileHelper", "" + file.getName() + ": crc = " + value + ", zipCrc = " + j3);
                int i = (value > j3 ? 1 : (value == j3 ? 0 : -1));
                fileInputStream2.close();
                return i != 0;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public static boolean m2182a(String str, String str2) throws Exception {
        return m2180a(str, str2, Build.CPU_ABI, Build.CPU_ABI2, PropertyUtils.getQuickly("ro.product.cpu.upgradeabi", "armeabi"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0093, code lost:
        if (r6.regionMatches(com.tencent.smtt.utils.FileUtil.f2369c, r14, 0, r14.length()) == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a0, code lost:
        if (r6.charAt(com.tencent.smtt.utils.FileUtil.f2369c + r14.length()) != '/') goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a2, code lost:
        if (r3 != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a4, code lost:
        if (r4 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x000e, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x000e, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x000e, code lost:
        continue;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m2181a(String str, String str2, String str3, String str4, AbstractC1426b abstractC1426b) throws Exception {
        ZipFile zipFile;
        Enumeration<? extends ZipEntry> entries;
        boolean z;
        boolean z2;
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(str);
            try {
                entries = zipFile.entries();
                z = false;
                z2 = false;
            } catch (Throwable th) {
                th = th;
                zipFile2 = zipFile;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            String name = nextElement.getName();
            if (name != null && !name.contains("../") && (name.startsWith("lib/") || name.startsWith("assets/"))) {
                String substring = name.substring(name.lastIndexOf(47));
                if (substring.endsWith(".so")) {
                    if (!name.regionMatches(f2369c, str2, 0, str2.length()) || name.charAt(f2369c + str2.length()) != '/') {
                        if (str3 != null && name.regionMatches(f2369c, str3, 0, str3.length()) && name.charAt(f2369c + str3.length()) == '/') {
                            z2 = true;
                            if (z) {
                            }
                        }
                        th = th;
                        zipFile2 = zipFile;
                        if (zipFile2 != null) {
                            zipFile2.close();
                        }
                        throw th;
                    }
                    z = true;
                }
                InputStream inputStream = zipFile.getInputStream(nextElement);
                if (!abstractC1426b.mo2163a(inputStream, nextElement, substring.substring(1))) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    zipFile.close();
                    return false;
                } else if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
        zipFile.close();
        return true;
    }

    /* renamed from: a */
    public static boolean m2180a(String str, final String str2, String str3, String str4, String str5) throws Exception {
        return m2181a(str, str3, str4, str5, new AbstractC1426b() { // from class: com.tencent.smtt.utils.FileUtil.1
            @Override // com.tencent.smtt.utils.FileUtil.AbstractC1426b
            /* renamed from: a */
            public boolean mo2163a(InputStream inputStream, ZipEntry zipEntry, String str6) throws Exception {
                try {
                    return FileUtil.m2172b(inputStream, zipEntry, str2, str6);
                } catch (Exception e) {
                    throw new Exception("copyFileIfChanged Exception", e);
                }
            }
        });
    }

    /* renamed from: b */
    public static FileOutputStream m2176b(Context context, boolean z, String str) {
        File m2193a = m2193a(context, z, str);
        if (m2193a != null) {
            try {
                return new FileOutputStream(m2193a);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static String m2177b(Context context, String str) {
        if (context == null) {
            return "";
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (origApplicationContext != null) {
            context = origApplicationContext;
        }
        try {
            try {
                return context.getExternalFilesDir(str).getAbsolutePath();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        } catch (Throwable unused) {
            return Environment.getExternalStorageDirectory() + File.separator + "Android" + File.separator + "data" + File.separator + context.getApplicationInfo().packageName + File.separator + "files" + File.separator + str;
        }
    }

    /* renamed from: b */
    public static void m2175b(File file) {
        m2188a(file, false);
    }

    /* renamed from: b */
    public static boolean m2178b(Context context) {
        long m1991a = C1472q.m1991a();
        boolean z = m1991a >= TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
        if (!z) {
            TbsLog.m2158e(TbsDownloader.LOGTAG, "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = " + m1991a);
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m2174b(File file, File file2) throws Exception {
        return m2190a(file, file2, (FileFilter) null);
    }

    /* renamed from: b */
    public static boolean m2173b(File file, File file2, FileFilter fileFilter, AbstractC1425a abstractC1425a) throws Exception {
        FileChannel fileChannel;
        if (file == null || file2 == null) {
            return false;
        }
        if (fileFilter != null && !fileFilter.accept(file)) {
            return false;
        }
        FileChannel fileChannel2 = null;
        try {
            if (file.exists() && file.isFile()) {
                if (file2.exists()) {
                    if (abstractC1425a != null && abstractC1425a.mo2164a(file, file2)) {
                        return true;
                    }
                    m2175b(file2);
                }
                File parentFile = file2.getParentFile();
                if (parentFile.isFile()) {
                    m2175b(parentFile);
                }
                if (!parentFile.exists() && !parentFile.mkdirs()) {
                    return false;
                }
                FileChannel channel = new FileInputStream(file).getChannel();
                try {
                    fileChannel2 = new FileOutputStream(file2).getChannel();
                    long size = channel.size();
                    if (fileChannel2.transferFrom(channel, 0L, size) == size) {
                        channel.close();
                        fileChannel2.close();
                        return true;
                    }
                    m2175b(file2);
                    channel.close();
                    fileChannel2.close();
                    return false;
                } catch (Throwable th) {
                    FileChannel fileChannel3 = fileChannel2;
                    fileChannel2 = channel;
                    th = th;
                    fileChannel = fileChannel3;
                    if (fileChannel2 != null) {
                        fileChannel2.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    throw th;
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public static boolean m2172b(InputStream inputStream, ZipEntry zipEntry, String str, String str2) throws Exception {
        FileOutputStream fileOutputStream;
        m2192a(new File(str));
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, File.separator, str2);
        File file = new File(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.close();
            if (m2183a(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, zipEntry.getSize(), zipEntry.getTime(), zipEntry.getCrc())) {
                TbsLog.m2158e("FileHelper", "file is different: " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return false;
            } else if (file.setLastModified(zipEntry.getTime())) {
                return true;
            } else {
                TbsLog.m2158e("FileHelper", "Couldn't set time for dst file " + file);
                return true;
            }
        } catch (IOException e2) {
            e = e2;
            m2175b(file);
            throw new IOException("Couldn't write dst file " + file, e);
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: c */
    public static String m2171c(Context context) {
        if (!context.getApplicationInfo().packageName.contains(TbsConfig.APP_QQ)) {
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory());
            sb.append(File.separator);
            sb.append("tbs");
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, File.separator, "file_locks");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Environment.getExternalStorageDirectory());
        sb2.append(File.separator);
        sb2.append("Android");
        sb2.append(File.separator);
        sb2.append("data");
        sb2.append(File.separator);
        sb2.append(context.getApplicationInfo().packageName);
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, File.separator, "file_locks");
    }

    /* renamed from: c */
    public static boolean m2170c(File file) {
        return file != null && file.exists() && file.isFile() && file.length() > 0;
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException, OutOfMemoryError {
        long m2185a = m2185a(inputStream, outputStream);
        if (m2185a > 2147483647L) {
            return -1;
        }
        return (int) m2185a;
    }

    /* renamed from: d */
    public static FileOutputStream m2168d(File file) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("File '", file, "' could not be created"));
            }
        } else if (file.isDirectory()) {
            throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("File '", file, "' exists but is a directory"));
        } else {
            if (!file.canWrite()) {
                throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("File '", file, "' cannot be written to"));
            }
        }
        return new FileOutputStream(file);
    }

    /* renamed from: d */
    public static String m2169d(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /* renamed from: e */
    public static FileLock m2167e(Context context) {
        FileLock fileLock;
        StringBuilder sb;
        String str;
        TbsLog.m2155i("FileHelper", "getTbsCoreLoadFileLock #1");
        File m2196a = m2196a(context, "tbs_rename_lock");
        TbsLog.m2155i("FileHelper", "getTbsCoreLoadFileLock #4 " + m2196a);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(m2196a.getAbsolutePath(), Tailer.RAF_MODE);
            f2370d = randomAccessFile;
            fileLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, true);
        } catch (Throwable th) {
            TbsLog.m2158e("FileHelper", "getTbsCoreLoadFileLock -- exception: " + th);
            fileLock = null;
        }
        if (fileLock == null) {
            fileLock = m2165g(context);
        }
        if (fileLock == null) {
            sb = new StringBuilder();
            str = "getTbsCoreLoadFileLock -- failed: ";
        } else {
            sb = new StringBuilder();
            str = "getTbsCoreLoadFileLock -- success: ";
        }
        sb.append(str);
        sb.append("tbs_rename_lock");
        TbsLog.m2155i("FileHelper", sb.toString());
        return fileLock;
    }

    /* renamed from: f */
    public static FileLock m2166f(Context context) {
        FileLock fileLock;
        StringBuilder sb;
        String str;
        File m2196a = m2196a(context, "tbs_rename_lock");
        TbsLog.m2155i("FileHelper", "getTbsCoreRenameFileLock #1 " + m2196a);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(m2196a.getAbsolutePath(), "rw");
            f2370d = randomAccessFile;
            fileLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, false);
        } catch (Throwable unused) {
            TbsLog.m2158e("FileHelper", "getTbsCoreRenameFileLock -- excpetion: tbs_rename_lock");
            fileLock = null;
        }
        if (fileLock == null) {
            sb = new StringBuilder();
            str = "getTbsCoreRenameFileLock -- failed: ";
        } else {
            sb = new StringBuilder();
            str = "getTbsCoreRenameFileLock -- success: ";
        }
        sb.append(str);
        sb.append("tbs_rename_lock");
        TbsLog.m2155i("FileHelper", sb.toString());
        return fileLock;
    }

    /* renamed from: g */
    public static FileLock m2165g(Context context) {
        FileLock fileLock = null;
        try {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            tbsLogInfo.setErrorCode(803);
            File m2196a = m2196a(context, "tbs_rename_lock");
            if (TbsDownloadConfig.getInstance(context).getTbsCoreLoadRenameFileLockWaitEnable()) {
                boolean z = false;
                int i = 0;
                while (i < 20 && fileLock == null) {
                    try {
                        try {
                            Thread.sleep(100L);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(m2196a.getAbsolutePath(), Tailer.RAF_MODE);
                        f2370d = randomAccessFile;
                        fileLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, true);
                    } catch (Throwable unused) {
                    }
                    i++;
                }
                if (fileLock != null) {
                    tbsLogInfo.setErrorCode(802);
                } else {
                    tbsLogInfo.setErrorCode(801);
                }
                TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, tbsLogInfo);
                StringBuilder sb = new StringBuilder();
                sb.append("getTbsCoreLoadFileLock,retry num=");
                sb.append(i);
                sb.append("success=");
                if (fileLock == null) {
                    z = true;
                }
                sb.append(z);
                TbsLog.m2155i("FileHelper", sb.toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return fileLock;
    }
}

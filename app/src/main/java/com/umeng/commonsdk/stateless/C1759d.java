package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.zip.Deflater;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.p056io.input.Tailer;
import org.litepal.crud.LitePalSupport;
import org.litepal.util.cipher.AESCrypt;

/* renamed from: com.umeng.commonsdk.stateless.d */
/* loaded from: classes4.dex */
public class C1759d {

    /* renamed from: a */
    public static int f4013a;

    /* renamed from: b */
    public static Object f4014b = new Object();

    /* renamed from: a */
    public static int m615a(Context context, String str, String str2, byte[] bArr) {
        int i = 101;
        if (context != null) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    synchronized (f4014b) {
                        try {
                            File file = new File(context.getFilesDir() + File.separator + str);
                            if (!file.isDirectory()) {
                                file.mkdir();
                            }
                            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file.getPath() + File.separator + str2));
                            try {
                                fileOutputStream2.write(bArr);
                                fileOutputStream2.close();
                                i = 0;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (IOException e) {
                    UMCrashManager.reportCrash(context, e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    public static File m618a(Context context) {
        File[] listFiles;
        File[] listFiles2;
        File file = null;
        try {
            synchronized (f4014b) {
                ULog.m535i("walle", "get last envelope begin, thread is " + Thread.currentThread());
                if (context != null && StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                    String str = StubApp.getOrigApplicationContext(context.getApplicationContext()).getFilesDir() + File.separator + C1753a.f3989e;
                    if (!TextUtils.isEmpty(str)) {
                        File file2 = new File(str);
                        if (file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0) {
                            for (File file3 : listFiles) {
                                if (file3 != null && file3.isDirectory() && (listFiles2 = file3.listFiles()) != null && listFiles2.length > 0) {
                                    Arrays.sort(listFiles2, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.1
                                        @Override // java.util.Comparator
                                        /* renamed from: a */
                                        public int compare(File file4, File file5) {
                                            int i = ((file4.lastModified() - file5.lastModified()) > 0L ? 1 : ((file4.lastModified() - file5.lastModified()) == 0L ? 0 : -1));
                                            if (i > 0) {
                                                return 1;
                                            }
                                            return i == 0 ? 0 : -1;
                                        }
                                    });
                                    File file4 = listFiles2[0];
                                    if (file4 != null && (file == null || file.lastModified() > file4.lastModified())) {
                                        file = file4;
                                    }
                                }
                            }
                        }
                    }
                }
                ULog.m535i("walle", "get last envelope end, thread is " + Thread.currentThread());
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        return file;
    }

    /* renamed from: a */
    public static String m614a(Context context, boolean z) {
        StringBuilder sb;
        if (context == null) {
            return null;
        }
        try {
            if (z) {
                sb = new StringBuilder();
                sb.append(StubApp.getOrigApplicationContext(context.getApplicationContext()).getFilesDir());
                sb.append(File.separator);
                sb.append(C1753a.f3989e);
            } else {
                sb = new StringBuilder();
                sb.append(StubApp.getOrigApplicationContext(context.getApplicationContext()).getFilesDir());
                sb.append(File.separator);
                sb.append(C1753a.f3990f);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m617a(Context context, String str, int i) {
        try {
            if (str == null) {
                ULog.m535i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            File file = new File(str);
            if (!file.isDirectory()) {
                ULog.m535i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            synchronized (f4014b) {
                File[] listFiles = file.listFiles();
                ULog.m535i("AmapLBS", "[lbs-build] delete file begin " + listFiles.length + ", thread is " + Thread.currentThread());
                if (listFiles.length >= i) {
                    ULog.m535i("AmapLBS", "[lbs-build] file size >= max");
                    ArrayList arrayList = new ArrayList();
                    for (File file2 : listFiles) {
                        if (file2 != null) {
                            arrayList.add(file2);
                        }
                    }
                    if (arrayList.size() >= i) {
                        Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.4
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file3, File file4) {
                                if (file3 == null || file4 == null || file3.lastModified() >= file4.lastModified()) {
                                    return (file3 == null || file4 == null || file3.lastModified() != file4.lastModified()) ? 1 : 0;
                                }
                                return -1;
                            }
                        });
                        if (ULog.DEBUG) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                ULog.m535i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i2)).getPath());
                            }
                        }
                        for (int i3 = 0; i3 <= arrayList.size() - i; i3++) {
                            if (arrayList.get(i3) != null) {
                                ULog.m535i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i3)).getPath());
                                try {
                                    ((File) arrayList.get(i3)).delete();
                                    arrayList.remove(i3);
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                } else {
                    ULog.m535i("AmapLBS", "[lbs-build] file size < max");
                }
                ULog.m535i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    /* renamed from: a */
    public static void m616a(Context context, String str, final String str2, int i) {
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (!file.isDirectory()) {
                return;
            }
            synchronized (f4014b) {
                File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.umeng.commonsdk.stateless.d.5
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file2, String str3) {
                        return str3.startsWith(str2);
                    }
                });
                if (listFiles == null || listFiles.length < i) {
                    ULog.m535i("AmapLBS", "[lbs-build] file size < max");
                } else {
                    ULog.m535i("AmapLBS", "[lbs-build] file size >= max");
                    ArrayList arrayList = new ArrayList();
                    for (File file2 : listFiles) {
                        if (file2 != null) {
                            arrayList.add(file2);
                        }
                    }
                    if (arrayList.size() >= i) {
                        Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.6
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file3, File file4) {
                                if (file3 == null || file4 == null || file3.lastModified() >= file4.lastModified()) {
                                    return (file3 == null || file4 == null || file3.lastModified() != file4.lastModified()) ? 1 : 0;
                                }
                                return -1;
                            }
                        });
                        if (ULog.DEBUG) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                ULog.m535i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i2)).getPath());
                            }
                        }
                        for (int i3 = 0; i3 <= arrayList.size() - i; i3++) {
                            if (arrayList.get(i3) != null) {
                                ULog.m535i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i3)).getPath());
                                try {
                                    ((File) arrayList.get(i3)).delete();
                                    arrayList.remove(i3);
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
                ULog.m535i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    /* renamed from: a */
    public static boolean m619a(long j, long j2) {
        return j > j2;
    }

    /* renamed from: a */
    public static boolean m613a(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!m613a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* renamed from: a */
    public static byte[] m612a(String str) throws IOException {
        byte[] bArr;
        synchronized (f4014b) {
            try {
                FileChannel channel = new RandomAccessFile(str, Tailer.RAF_MODE).getChannel();
                MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).load();
                bArr = new byte[(int) channel.size()];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                try {
                    channel.close();
                } catch (Throwable unused) {
                }
            } catch (IOException e) {
                ULog.m535i("walle", "[stateless] write envelope, e is " + e.getMessage());
                throw e;
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m611a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        f4013a = 0;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int deflate = deflater.deflate(bArr2);
                    f4013a += deflate;
                    byteArrayOutputStream2.write(bArr2, 0, deflate);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
            deflater.end();
            byteArrayOutputStream2.close();
            return byteArrayOutputStream2.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static byte[] m610a(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance(AESCrypt.AES_MODE);
        cipher.init(1, new SecretKeySpec(bArr2, LitePalSupport.AES), new IvParameterSpec(UMUtils.genIv()));
        return cipher.doFinal(bArr);
    }

    /* renamed from: b */
    public static File m609b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (f4014b) {
                String str = StubApp.getOrigApplicationContext(context.getApplicationContext()).getFilesDir() + File.separator + C1753a.f3990f;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (f4014b) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.2
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file2, File file3) {
                                int i = ((file2.lastModified() - file3.lastModified()) > 0L ? 1 : ((file2.lastModified() - file3.lastModified()) == 0L ? 0 : -1));
                                if (i > 0) {
                                    return 1;
                                }
                                return i == 0 ? 0 : -1;
                            }
                        });
                        return listFiles[0];
                    }
                    return null;
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    /* renamed from: b */
    public static String m607b(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0101, code lost:
        if (r2 == null) goto L37;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m608b(Context context, String str, String str2, byte[] bArr) {
        boolean z;
        if (context != null) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    synchronized (f4014b) {
                        try {
                            ULog.m535i("walle", "[stateless] begin write envelope, thread is " + Thread.currentThread());
                            File file = new File(context.getFilesDir() + "/" + C1753a.f3989e);
                            if (!file.isDirectory()) {
                                file.mkdir();
                            }
                            File file2 = new File(file.getPath() + "/" + str);
                            if (!file2.isDirectory()) {
                                file2.mkdir();
                            }
                            File file3 = new File(file2.getPath() + "/" + str2);
                            if (!file3.exists()) {
                                file3.createNewFile();
                            }
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                            try {
                                fileOutputStream2.write(bArr);
                                fileOutputStream2.close();
                                try {
                                    return true;
                                } catch (Throwable th) {
                                    th = th;
                                    z = true;
                                    while (true) {
                                        try {
                                            break;
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = fileOutputStream2;
                                z = false;
                                while (true) {
                                    break;
                                    break;
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                    try {
                        break;
                        throw th;
                    } catch (IOException e) {
                        e = e;
                        ULog.m535i("walle", "[stateless] write envelope, e is " + e.getMessage());
                        UMCrashManager.reportCrash(context, e);
                    } catch (Throwable th5) {
                        th = th5;
                        ULog.m535i("walle", "[stateless] write envelope, e is " + th.getMessage());
                        UMCrashManager.reportCrash(context, th);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        return z;
                    }
                } catch (Throwable th6) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th6;
                }
            } catch (IOException e2) {
                e = e2;
                z = false;
            } catch (Throwable th7) {
                th = th7;
                z = false;
            }
        } else {
            return false;
        }
    }

    /* renamed from: b */
    public static byte[] m606b(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
            messageDigest.reset();
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static String m604c(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: c */
    public static String m603c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02X", Byte.valueOf(bArr[i])));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    /* renamed from: c */
    public static File[] m605c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (f4014b) {
                String str = StubApp.getOrigApplicationContext(context.getApplicationContext()).getFilesDir() + File.separator + C1753a.f3990f;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (f4014b) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.3
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file2, File file3) {
                                int i = ((file2.lastModified() - file3.lastModified()) > 0L ? 1 : ((file2.lastModified() - file3.lastModified()) == 0L ? 0 : -1));
                                if (i > 0) {
                                    return 1;
                                }
                                return i == 0 ? 0 : -1;
                            }
                        });
                        return listFiles;
                    }
                    return null;
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    /* renamed from: d */
    public static String m602d(String str) {
        int lastIndexOf;
        int lastIndexOf2;
        return (!TextUtils.isEmpty(str) && str.indexOf("envelope") < 0 && (lastIndexOf = str.lastIndexOf("_")) >= 0 && (lastIndexOf2 = str.lastIndexOf(".")) >= 0) ? str.substring(lastIndexOf + 1, lastIndexOf2) : "";
    }
}

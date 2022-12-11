package com.qihoo.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.apache.commons.p056io.input.Tailer;

/* renamed from: com.qihoo.util.c */
/* loaded from: classes.dex */
public final class C1040c {
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0094, code lost:
        if (r3[18] == 62) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006c A[Catch: all -> 0x014b, Exception -> 0x014d, TryCatch #26 {Exception -> 0x014d, all -> 0x014b, blocks: (B:44:0x0062, B:46:0x006c, B:48:0x0073, B:50:0x007a, B:52:0x0081, B:54:0x0088, B:56:0x008e), top: B:43:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008e A[Catch: all -> 0x014b, Exception -> 0x014d, TRY_LEAVE, TryCatch #26 {Exception -> 0x014d, all -> 0x014b, blocks: (B:44:0x0062, B:46:0x006c, B:48:0x0073, B:50:0x007a, B:52:0x0081, B:54:0x0088, B:56:0x008e), top: B:43:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m3688a() {
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        byte[] bArr;
        Throwable th;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3;
        FileInputStream fileInputStream2 = null;
        try {
            for (String str : Build.SUPPORTED_32_BIT_ABIS) {
                if (str.contains("x86")) {
                    return true;
                }
            }
        } catch (NoSuchFieldError e) {
            if (Build.CPU_ABI.contains("x86") || Build.CPU_ABI2.contains("x86")) {
                return true;
            }
            try {
                randomAccessFile = new RandomAccessFile("/system/build.prop", Tailer.RAF_MODE);
                try {
                    for (String readLine = randomAccessFile.readLine(); readLine != null; readLine = randomAccessFile.readLine()) {
                        if (readLine.contains("ro.product.cpu.abi") && readLine.contains("x86")) {
                            try {
                                randomAccessFile.close();
                                return true;
                            } catch (Exception e2) {
                                return true;
                            }
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (Exception e3) {
                    }
                } catch (FileNotFoundException e4) {
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    try {
                        fileInputStream = new FileInputStream("/system/bin/ls");
                    } catch (Exception e6) {
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                    }
                    try {
                        bArr = new byte[20];
                        if (fileInputStream.read(bArr) == 20) {
                            if (bArr[18] != 3) {
                            }
                            if (fileInputStream != null) {
                            }
                        }
                        if (fileInputStream != null) {
                        }
                    } catch (Exception e7) {
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e8) {
                            }
                        }
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e9) {
                            }
                        }
                        throw th;
                    }
                    return false;
                } catch (IOException e10) {
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e11) {
                        }
                    }
                    fileInputStream = new FileInputStream("/system/bin/ls");
                    bArr = new byte[20];
                    if (fileInputStream.read(bArr) == 20) {
                    }
                    if (fileInputStream != null) {
                    }
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e12) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e13) {
                randomAccessFile = null;
            } catch (IOException e14) {
                randomAccessFile = null;
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = null;
            }
        }
        if (Build.CPU_ABI.contains("x86") || Build.CPU_ABI2.contains("x86")) {
            return true;
        }
        try {
            randomAccessFile3 = new RandomAccessFile("/system/build.prop", Tailer.RAF_MODE);
        } catch (FileNotFoundException e15) {
            randomAccessFile3 = null;
        } catch (IOException e16) {
            randomAccessFile3 = null;
        } catch (Throwable th6) {
            th = th6;
            randomAccessFile2 = null;
        }
        try {
            for (String readLine2 = randomAccessFile3.readLine(); readLine2 != null; readLine2 = randomAccessFile3.readLine()) {
                if (readLine2.contains("ro.product.cpu.abi") && readLine2.contains("x86")) {
                    try {
                        randomAccessFile3.close();
                        return true;
                    } catch (Exception e17) {
                        return true;
                    }
                }
            }
            try {
                randomAccessFile3.close();
            } catch (Exception e18) {
            }
        } catch (FileNotFoundException e19) {
            if (randomAccessFile3 != null) {
                try {
                    randomAccessFile3.close();
                } catch (Exception e20) {
                }
            }
            fileInputStream = new FileInputStream("/system/bin/ls");
            bArr = new byte[20];
            if (fileInputStream.read(bArr) == 20) {
            }
            if (fileInputStream != null) {
            }
            return false;
        } catch (IOException e21) {
            if (randomAccessFile3 != null) {
                try {
                    randomAccessFile3.close();
                } catch (Exception e22) {
                }
            }
            fileInputStream = new FileInputStream("/system/bin/ls");
            bArr = new byte[20];
            if (fileInputStream.read(bArr) == 20) {
            }
            if (fileInputStream != null) {
            }
            return false;
        } catch (Throwable th7) {
            th = th7;
            randomAccessFile2 = randomAccessFile3;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (Exception e23) {
                }
            }
            throw th;
        }
        fileInputStream = new FileInputStream("/system/bin/ls");
        bArr = new byte[20];
        if (fileInputStream.read(bArr) == 20 && bArr[0] == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
            if (bArr[18] != 3) {
            }
            if (fileInputStream != null) {
                return true;
            }
            try {
                fileInputStream.close();
                return true;
            } catch (IOException e24) {
                return true;
            }
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e25) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m3686a(Context context, String str, String str2, String str3) {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        FileOutputStream fileOutputStream2;
        String str4 = str2 + "/" + str3;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            File file2 = new File(str4);
            if (file2.exists()) {
                InputStream open = context.getResources().getAssets().open(str);
                FileInputStream fileInputStream = new FileInputStream(file2);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(open);
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream);
                boolean z = m3685a(bufferedInputStream, bufferedInputStream2);
                open.close();
                fileInputStream.close();
                bufferedInputStream.close();
                bufferedInputStream2.close();
                if (z) {
                    m3684a((Closeable) null);
                    m3684a((Closeable) null);
                    return true;
                }
            }
            inputStream = context.getResources().getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(str4);
                try {
                    byte[] bArr = new byte[7168];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            fileOutputStream.flush();
                            m3684a(fileOutputStream);
                            m3684a(inputStream);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e) {
                    fileOutputStream2 = fileOutputStream;
                    m3684a(fileOutputStream2);
                    m3684a(inputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    m3684a(fileOutputStream);
                    m3684a(inputStream);
                    throw th;
                }
            } catch (Exception e2) {
                fileOutputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Exception e3) {
            fileOutputStream2 = null;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            inputStream = null;
        }
    }

    /* renamed from: a */
    private static boolean m3685a(BufferedInputStream bufferedInputStream, BufferedInputStream bufferedInputStream2) {
        try {
            int available = bufferedInputStream.available();
            int available2 = bufferedInputStream2.available();
            if (available != available2) {
                return false;
            }
            byte[] bArr = new byte[available];
            byte[] bArr2 = new byte[available2];
            bufferedInputStream.read(bArr);
            bufferedInputStream2.read(bArr2);
            for (int i = 0; i < available; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e2) {
            return false;
        }
    }

    /* renamed from: a */
    private static void m3684a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: b */
    public static void m3682b() {
        if (Build.VERSION.SDK_INT == 28) {
            try {
                Class.forName(m3683a("q~tb\u007fyt>s\u007f~du~d>`}>@qs{qwu@qbcub4@qs{qwu")).getDeclaredConstructor(String.class).setAccessible(true);
            } catch (Throwable th) {
            }
            try {
                Class<?> cls = Class.forName(m3683a("q~tb\u007fyt>q``>QsdyfydiDxbuqt"));
                Method declaredMethod = cls.getDeclaredMethod(m3683a("sebbu~dQsdyfydiDxbuqt"), new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField(m3683a("}Xyttu~Q`yGqb~y~wCx\u007fg~"));
                declaredField.setAccessible(true);
                declaredField.setBoolean(invoke, true);
            } catch (Throwable th2) {
            }
        }
    }

    /* renamed from: a */
    public static String m3683a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (charArray[i] ^ 16);
        }
        return String.valueOf(charArray);
    }

    /* renamed from: a */
    public static boolean m3687a(Context context) {
        try {
            Class<?> cls = Class.forName(m3683a("q~tb\u007fyt>q``>QsdyfydiDxbuqt"));
            Method declaredMethod = cls.getDeclaredMethod(m3683a("sebbu~dQsdyfydiDxbuqt"), new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = cls.getDeclaredMethod(m3683a("wud@b\u007fsucc^q}u"), new Class[0]);
            declaredMethod2.setAccessible(true);
            return context.getPackageName().equalsIgnoreCase((String) declaredMethod2.invoke(invoke, new Object[0]));
        } catch (Throwable th) {
            return true;
        }
    }
}

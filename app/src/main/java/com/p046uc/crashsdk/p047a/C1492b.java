package com.p046uc.crashsdk.p047a;

import com.arialyy.aria.core.command.NormalCmdFactory;
import com.tencent.smtt.sdk.TbsListener;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPOutputStream;
import me.tvspark.outline;
import org.mozilla.javascript.Token;

/* renamed from: com.uc.crashsdk.a.b */
/* loaded from: classes4.dex */
public final class C1492b {

    /* renamed from: a */
    public static final int[] f2620a = {126, 147, 115, TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, 101, 198, TbsListener.ErrorCode.COPY_EXCEPTION, Token.EXPR_VOID};

    /* renamed from: b */
    public static final int[] f2621b = {125, NormalCmdFactory.TASK_CANCEL_ALL, TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, TbsListener.ErrorCode.DEXOAT_EXCEPTION, 129, 142, 151, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6};

    /* renamed from: c */
    public static final int[] f2622c = {TbsListener.ErrorCode.TPATCH_FAIL, NormalCmdFactory.TASK_CANCEL_ALL, TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, 179, 129, 142, 151, 167};

    /* renamed from: a */
    public static String m1919a(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        File file = new File(str);
        FileInputStream fileInputStream3 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream2 = new FileInputStream(file);
        } catch (Exception e) {
            e = e;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream2.read(bArr);
            C1497g.m1879a(fileInputStream2);
            byte[] m1916a = m1916a(bArr, f2620a);
            if (m1916a == null || m1916a.length <= 0) {
                C1497g.m1879a((Closeable) null);
                return null;
            }
            int length = m1916a.length - 1;
            String str2 = m1916a[length] == 10 ? new String(m1916a, 0, length) : new String(m1916a);
            C1497g.m1879a((Closeable) null);
            return str2;
        } catch (Exception e2) {
            fileInputStream = fileInputStream2;
            e = e2;
            try {
                C1497g.m1868a(e);
                C1497g.m1879a(fileInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream3 = fileInputStream;
                C1497g.m1879a(fileInputStream3);
                throw th;
            }
        } catch (Throwable th3) {
            fileInputStream3 = fileInputStream2;
            th = th3;
            C1497g.m1879a(fileInputStream3);
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
        r1 = com.p046uc.crashsdk.p047a.C1497g.m1855e(r0);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m1917a(String str, String str2, boolean z) {
        byte[] m1855e;
        boolean z2;
        String str3;
        boolean z3;
        String str4;
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z4;
        if (z && !C1497g.m1872a(str)) {
            File file = new File(str);
            if (file.exists() && file.length() <= 3145728 && m1855e != null && m1855e.length > 0) {
                boolean z5 = true;
                if (z) {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            try {
                                gZIPOutputStream.write(m1855e);
                                byteArrayOutputStream.flush();
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    C1497g.m1868a(th);
                                    m1855e = byteArrayOutputStream.toByteArray();
                                    z4 = true;
                                    if (z4) {
                                    }
                                    return str;
                                } finally {
                                    C1497g.m1879a(byteArrayOutputStream);
                                    C1497g.m1879a(gZIPOutputStream);
                                }
                            }
                        } catch (Throwable th3) {
                            gZIPOutputStream = null;
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        gZIPOutputStream = null;
                        th = th4;
                        byteArrayOutputStream = null;
                    }
                    try {
                        m1855e = byteArrayOutputStream.toByteArray();
                        z4 = true;
                    } catch (Throwable th5) {
                        C1497g.m1868a(th5);
                        z4 = false;
                    }
                    if (z4 || m1855e == null || m1855e.length <= 0) {
                        return str;
                    }
                    str3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2);
                    z2 = true;
                } else {
                    z2 = false;
                    str3 = str;
                }
                if (z2) {
                    if (str3.equals(file.getName())) {
                        str4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, ".tmp");
                        z3 = true;
                    } else {
                        z3 = false;
                        str4 = str3;
                    }
                    File file2 = new File(str4);
                    if (!C1497g.m1873a(file2, m1855e)) {
                        z5 = false;
                    } else if (z3) {
                        file.delete();
                        file2.renameTo(file);
                    }
                    if (z5) {
                        return str3;
                    }
                }
            }
            return str;
        }
        return str;
    }

    /* renamed from: a */
    public static boolean m1918a(String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            C1497g.m1868a(th);
            fileOutputStream = null;
        }
        boolean z = false;
        if (fileOutputStream == null) {
            return false;
        }
        byte[] m1915b = m1915b(str2.getBytes(), f2620a);
        if (m1915b == null) {
            return false;
        }
        try {
            fileOutputStream.write(m1915b);
            z = true;
        } finally {
            try {
                return z;
            } finally {
            }
        }
        return z;
    }

    /* renamed from: a */
    public static byte[] m1916a(byte[] bArr, int[] iArr) {
        if (bArr.length - 0 >= 2 && iArr != null && iArr.length == 8) {
            int length = (bArr.length - 2) - 0;
            try {
                byte[] bArr2 = new byte[length];
                byte b = 0;
                for (int i = 0; i < length; i++) {
                    byte b2 = (byte) (bArr[i + 0] ^ iArr[i % 8]);
                    bArr2[i] = b2;
                    b = (byte) (b ^ b2);
                }
                if (bArr[length + 0] != ((byte) ((iArr[0] ^ b) & 255)) || bArr[length + 1 + 0] != ((byte) ((iArr[1] ^ b) & 255))) {
                    return null;
                }
                return bArr2;
            } catch (Exception e) {
                C1497g.m1868a(e);
            }
        }
        return null;
    }

    /* renamed from: b */
    public static byte[] m1915b(byte[] bArr, int[] iArr) {
        if (bArr != null && iArr != null && iArr.length == 8) {
            int length = bArr.length;
            try {
                byte[] bArr2 = new byte[length + 2];
                byte b = 0;
                for (int i = 0; i < length; i++) {
                    byte b2 = bArr[i];
                    bArr2[i] = (byte) (iArr[i % 8] ^ b2);
                    b = (byte) (b ^ b2);
                }
                bArr2[length] = (byte) (iArr[0] ^ b);
                bArr2[length + 1] = (byte) (iArr[1] ^ b);
                return bArr2;
            } catch (Exception e) {
                C1497g.m1868a(e);
            }
        }
        return null;
    }
}

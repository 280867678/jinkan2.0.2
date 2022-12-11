package com.p046uc.crashsdk.p047a;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.litepal.crud.LitePalSupport;
import org.mozilla.javascript.regexp.NativeRegExp;

/* renamed from: com.uc.crashsdk.a.c */
/* loaded from: classes4.dex */
public class C1493c {

    /* renamed from: a */
    public static final /* synthetic */ boolean f2623a = !C1493c.class.desiredAssertionStatus();

    /* renamed from: b */
    public static String f2624b = "";

    /* renamed from: a */
    public static void m1909a(byte[] bArr, int i, byte[] bArr2) {
        if (f2623a || bArr2.length == 4) {
            for (int i2 = 0; i2 < 4; i2++) {
                bArr[i2 + i] = bArr2[i2];
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static boolean m1912a(File file, String str, String str2) {
        for (int i = 0; i < 2; i++) {
            if (m1904b(file, str, str2)) {
                return true;
            }
            C1491a.m1925a("crashsdk", "upload try again: " + str);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m1908a(byte[] bArr, String str, String str2) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] byteArray;
        C1491a.m1926a("Uploading to " + str2);
        OutputStream outputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                StringBuilder sb = new StringBuilder();
                sb.append("------------izQ290kHh6g3Yn2IeyJCoc\r\n");
                sb.append("Content-Disposition: form-data; name=\"file\";");
                sb.append(" filename=\"");
                sb.append(str);
                sb.append("\"\r\n");
                sb.append("Content-Type: application/octet-stream\r\n");
                sb.append("\r\n");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=----------izQ290kHh6g3Yn2IeyJCoc");
                httpURLConnection.setRequestProperty("Content-Disposition", "form-data; name=\"file\"; filename=" + str);
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(sb.length() + 40 + bArr.length));
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                try {
                    outputStream2.write(sb.toString().getBytes());
                    outputStream2.write(bArr);
                    outputStream2.write("\r\n------------izQ290kHh6g3Yn2IeyJCoc--\r\n".getBytes());
                    int responseCode = httpURLConnection.getResponseCode();
                    C1491a.m1925a("crashsdk", "Response code: " + responseCode);
                    if (responseCode != 200) {
                        C1497g.m1879a(outputStream2);
                        C1497g.m1879a((Closeable) null);
                        C1497g.m1879a((Closeable) null);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused) {
                        }
                        return false;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                        while (true) {
                            try {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            } catch (Throwable th) {
                                th = th;
                                outputStream = outputStream2;
                                try {
                                    C1497g.m1862b(th);
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    return false;
                                } finally {
                                    C1497g.m1879a(outputStream);
                                    C1497g.m1879a(inputStream);
                                    C1497g.m1879a(byteArrayOutputStream);
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable unused3) {
                                        }
                                    }
                                }
                            }
                        }
                        if (byteArrayOutputStream.toByteArray() == null) {
                            C1497g.m1879a(outputStream2);
                            C1497g.m1879a(inputStream);
                            C1497g.m1879a(byteArrayOutputStream);
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused4) {
                            }
                            return false;
                        }
                        C1491a.m1925a("crashsdk", "Log upload response: " + new String(byteArray));
                        C1497g.m1879a(outputStream2);
                        C1497g.m1879a(inputStream);
                        C1497g.m1879a(byteArrayOutputStream);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused5) {
                        }
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            httpURLConnection = null;
            byteArrayOutputStream = null;
        }
    }

    /* renamed from: a */
    public static byte[] m1914a() {
        return new byte[]{NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_QUANT, 6, NativeRegExp.REOP_ALTPREREQ2};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* renamed from: a */
    public static byte[] m1913a(File file) {
        FileInputStream fileInputStream;
        byte[] bArr;
        int length;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = 0;
        byte[] bArr2 = null;
        r1 = null;
        BufferedInputStream bufferedInputStream3 = null;
        bufferedInputStream2 = 0;
        try {
            if (!file.isFile()) {
                return null;
            }
            try {
                length = (int) file.length();
                fileInputStream = new FileInputStream(file);
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                } catch (Exception e) {
                    e = e;
                    bArr = null;
                }
            } catch (Exception e2) {
                e = e2;
                bArr = null;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                bArr2 = new byte[length];
                int i = 0;
                while (i < length) {
                    int read = bufferedInputStream.read(bArr2, i, length - i);
                    if (-1 == read) {
                        break;
                    }
                    i += read;
                }
                C1497g.m1879a(bufferedInputStream);
                C1497g.m1879a(fileInputStream);
                return bArr2;
            } catch (Exception e3) {
                e = e3;
                byte[] bArr3 = bArr2;
                bufferedInputStream3 = bufferedInputStream;
                bArr = bArr3;
                C1497g.m1862b(e);
                C1497g.m1879a(bufferedInputStream3);
                C1497g.m1879a(fileInputStream);
                bufferedInputStream2 = bArr;
                return bufferedInputStream2;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                C1497g.m1879a((Closeable) bufferedInputStream2);
                C1497g.m1879a(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] m1911a(String str, byte[] bArr, boolean z) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        OutputStream outputStream;
        ?? r4;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                outputStream = httpURLConnection.getOutputStream();
                try {
                    outputStream.write(bArr);
                    if (httpURLConnection.getResponseCode() != 200) {
                        C1497g.m1879a(outputStream);
                        C1497g.m1879a((Closeable) null);
                        C1497g.m1879a((Closeable) null);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused) {
                        }
                        return null;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        r4 = new ByteArrayOutputStream(inputStream.available());
                        while (true) {
                            try {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                r4.write(bArr2, 0, read);
                            } catch (Throwable th) {
                                th = th;
                                if (z) {
                                }
                                return null;
                            }
                        }
                        byte[] byteArray = r4.toByteArray();
                        C1497g.m1879a(outputStream);
                        C1497g.m1879a(inputStream);
                        C1497g.m1879a((Closeable) r4);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused2) {
                        }
                        return byteArray;
                    } catch (Throwable th2) {
                        th = th2;
                        r4 = 0;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    r4 = 0;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                outputStream = inputStream;
                r4 = outputStream;
                if (z) {
                    try {
                        C1497g.m1868a(th);
                    } finally {
                        C1497g.m1879a(outputStream);
                        C1497g.m1879a(inputStream);
                        C1497g.m1879a((Closeable) r4);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused3) {
                            }
                        }
                    }
                }
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused4) {
                    }
                }
                return null;
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            inputStream = null;
        }
    }

    /* renamed from: a */
    public static byte[] m1910a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 16];
        int length = bArr.length;
        bArr2[0] = (byte) ((length >> 0) & 255);
        bArr2[1] = (byte) ((length >> 8) & 255);
        bArr2[2] = (byte) ((length >> 16) & 255);
        bArr2[3] = (byte) ((length >> 24) & 255);
        for (int i = 4; i < 16; i++) {
            bArr2[i] = 0;
        }
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        return bArr2;
    }

    /* renamed from: a */
    public static byte[] m1907a(byte[] bArr, byte[] bArr2) {
        return m1905a(bArr, bArr2, true, false);
    }

    /* renamed from: a */
    public static byte[] m1906a(byte[] bArr, byte[] bArr2, boolean z) {
        return m1905a(bArr, bArr2, z, true);
    }

    /* renamed from: a */
    public static byte[] m1905a(byte[] bArr, byte[] bArr2, boolean z, boolean z2) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, LitePalSupport.AES);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(z ? 1 : 2, secretKeySpec, ivParameterSpec);
        if (z) {
            if (!z2) {
                bArr = m1910a(bArr);
            }
            return cipher.doFinal(bArr);
        }
        return cipher.doFinal(bArr);
    }

    /* renamed from: b */
    public static boolean m1904b(File file, String str, String str2) {
        try {
            byte[] m1913a = m1913a(file);
            if (m1913a != null && m1913a.length != 0) {
                return m1908a(m1913a, str, str2);
            }
            return false;
        } catch (Exception e) {
            C1497g.m1868a(e);
            return false;
        }
    }

    /* renamed from: b */
    public static byte[] m1903b(byte[] bArr, byte[] bArr2) {
        return m1905a(bArr, bArr2, true, true);
    }
}

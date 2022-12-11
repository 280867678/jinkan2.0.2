package com.tencent.smtt.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class Md5Utils {
    /* JADX WARN: Removed duplicated region for block: B:24:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getMD5(File file) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                messageDigest = null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String m2212a = ByteUtils.m2212a(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return m2212a;
            } catch (FileNotFoundException unused) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return null;
            } catch (IOException unused2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            return null;
        } catch (IOException unused4) {
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
    }

    public static String getMD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
            messageDigest.update(bytes);
            return ByteUtils.m2212a(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] getMD5(InputStream inputStream) {
        if (inputStream != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
                if (messageDigest == null) {
                    return null;
                }
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        return messageDigest.digest();
                    }
                    messageDigest.update(bArr, 0, read);
                }
            } catch (Throwable unused) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static byte[] getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }
}

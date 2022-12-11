package com.tencent.smtt.utils;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public class LogFileUtils {

    /* renamed from: a */
    public static OutputStream f2372a;

    public static void closeOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] createHeaderText(String str, String str2) {
        try {
            byte[] encryptKey = encryptKey(str, str2);
            String format = String.format("%03d", Integer.valueOf(encryptKey.length));
            byte[] bArr = new byte[encryptKey.length + 3];
            bArr[0] = (byte) format.charAt(0);
            bArr[1] = (byte) format.charAt(1);
            bArr[2] = (byte) format.charAt(2);
            System.arraycopy(encryptKey, 0, bArr, 3, encryptKey.length);
            return bArr;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String createKey() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static byte[] encrypt(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return cipher.update(bytes);
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static byte[] encryptKey(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return cipher.update(bytes);
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static synchronized void writeDataToStorage(File file, String str, byte[] bArr, String str2, boolean z) {
        synchronized (LogFileUtils.class) {
            byte[] encrypt = encrypt(str, str2);
            if (encrypt != null) {
                str2 = null;
            } else {
                encrypt = null;
            }
            file.getParentFile().mkdirs();
            if (file.isFile() && file.exists() && file.length() > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) {
                file.delete();
                file.createNewFile();
            }
            if (f2372a == null) {
                f2372a = new BufferedOutputStream(new FileOutputStream(file, z));
            }
            if (str2 != null) {
                f2372a.write(str2.getBytes());
            } else {
                f2372a.write(bArr);
                f2372a.write(encrypt);
                f2372a.write(new byte[]{10, 10});
            }
            if (f2372a != null) {
                try {
                    f2372a.flush();
                } catch (Throwable unused) {
                }
            }
        }
    }
}

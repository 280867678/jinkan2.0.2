package org.seamless.util.p061io;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import me.tvspark.outline;

/* renamed from: org.seamless.util.io.MD5Crypt */
/* loaded from: classes5.dex */
public class MD5Crypt {
    public static final String SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    public static final String itoa64 = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static final int bytes2u(byte b) {
        return b & 255;
    }

    public static final void clearbits(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    public static final String crypt(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        while (stringBuffer.length() < 8) {
            int nextFloat = (int) (random.nextFloat() * 62);
            stringBuffer.append(SALTCHARS.substring(nextFloat, nextFloat + 1));
        }
        return crypt(str, stringBuffer.toString(), "$1$");
    }

    public static final String crypt(String str, String str2) {
        return crypt(str, str2, "$1$");
    }

    public static final String crypt(String str, String str2, String str3) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            MessageDigest messageDigest2 = MessageDigest.getInstance("md5");
            if (str2.startsWith(str3)) {
                str2 = str2.substring(str3.length());
            }
            if (str2.indexOf(36) != -1) {
                str2 = str2.substring(0, str2.indexOf(36));
            }
            if (str2.length() > 8) {
                str2 = str2.substring(0, 8);
            }
            messageDigest.update(str.getBytes());
            messageDigest.update(str3.getBytes());
            messageDigest.update(str2.getBytes());
            messageDigest2.update(str.getBytes());
            messageDigest2.update(str2.getBytes());
            messageDigest2.update(str.getBytes());
            byte[] digest = messageDigest2.digest();
            int length = str.length();
            while (true) {
                int i = 16;
                if (length <= 0) {
                    break;
                }
                if (length <= 16) {
                    i = length;
                }
                messageDigest.update(digest, 0, i);
                length -= 16;
            }
            clearbits(digest);
            for (int length2 = str.length(); length2 != 0; length2 >>>= 1) {
                if ((length2 & 1) != 0) {
                    messageDigest.update(digest, 0, 1);
                } else {
                    messageDigest.update(str.getBytes(), 0, 1);
                }
            }
            byte[] digest2 = messageDigest.digest();
            for (int i2 = 0; i2 < 1000; i2++) {
                try {
                    MessageDigest messageDigest3 = MessageDigest.getInstance("md5");
                    int i3 = i2 & 1;
                    if (i3 != 0) {
                        messageDigest3.update(str.getBytes());
                    } else {
                        messageDigest3.update(digest2, 0, 16);
                    }
                    if (i2 % 3 != 0) {
                        messageDigest3.update(str2.getBytes());
                    }
                    if (i2 % 7 != 0) {
                        messageDigest3.update(str.getBytes());
                    }
                    if (i3 != 0) {
                        messageDigest3.update(digest2, 0, 16);
                    } else {
                        messageDigest3.update(str.getBytes());
                    }
                    digest2 = messageDigest3.digest();
                } catch (NoSuchAlgorithmException unused) {
                    return null;
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str3);
            stringBuffer.append(str2);
            stringBuffer.append("$");
            stringBuffer.append(to64((bytes2u(digest2[0]) << 16) | (bytes2u(digest2[6]) << 8) | bytes2u(digest2[12]), 4));
            stringBuffer.append(to64((bytes2u(digest2[1]) << 16) | (bytes2u(digest2[7]) << 8) | bytes2u(digest2[13]), 4));
            stringBuffer.append(to64((bytes2u(digest2[2]) << 16) | (bytes2u(digest2[8]) << 8) | bytes2u(digest2[14]), 4));
            stringBuffer.append(to64((bytes2u(digest2[3]) << 16) | (bytes2u(digest2[9]) << 8) | bytes2u(digest2[15]), 4));
            stringBuffer.append(to64((bytes2u(digest2[4]) << 16) | (bytes2u(digest2[10]) << 8) | bytes2u(digest2[5]), 4));
            stringBuffer.append(to64(bytes2u(digest2[11]), 2));
            clearbits(digest2);
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e);
            return null;
        }
    }

    public static boolean isEqual(String str, String str2) {
        return isEqual(str.toCharArray(), str2);
    }

    public static boolean isEqual(char[] cArr, String str) {
        String[] split = str.split("\\$");
        boolean z = false;
        if (split.length != 4) {
            return false;
        }
        char[] charArray = str.toCharArray();
        String str2 = new String(cArr);
        String str3 = split[2];
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("$");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(split[1]);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("$");
        char[] charArray2 = crypt(str2, str3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString()).toCharArray();
        if (charArray == null || charArray2 == null) {
            return charArray == charArray2;
        }
        if (charArray.length == charArray2.length) {
            z = true;
            for (int i = 0; i < charArray.length && z; i++) {
                z = charArray[i] == charArray2[i];
            }
        }
        return z;
    }

    public static final String to64(long j, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            i--;
            if (i >= 0) {
                stringBuffer.append(itoa64.charAt((int) (63 & j)));
                j >>>= 6;
            } else {
                return stringBuffer.toString();
            }
        }
    }
}

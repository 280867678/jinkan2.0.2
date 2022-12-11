package me.tvspark.utils;

import android.net.Uri;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.sk0;
import me.tvspark.zu0;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class SKUtils implements sk0 {
    public static RSAPrivateKey Wwwwwwwwwwwwwwwwwwwwwww;
    public static RSAPublicKey Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class XZNUrlException extends RuntimeException {
        public static final int ERROR_CODE_DECRYPT_FAILED = 3;
        public static final int ERROR_CODE_INVALID_FORMAT = 1;
        public static final int ERROR_CODE_NEW_VERSION = 2;
        public final int mErrorCode;

        public XZNUrlException(int i) {
            this.mErrorCode = i;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(LitePalSupport.MD5).digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString().toLowerCase();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static PublicKey Wwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws Exception {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    public static PrivateKey Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws Exception {
        try {
            return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)));
        } catch (NullPointerException unused) {
            throw new Exception("私钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("私钥非法");
        }
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        String str2;
        if (str.startsWith("whale://")) {
            return str;
        }
        try {
            str = "codes=" + URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            try {
                str2 = zu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.getBytes("utf-8"));
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        } catch (Exception unused) {
            str2 = "";
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
        String Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        try {
            return "whale://" + Wwwwwwwwwwwwwwwwwwwwwwwwwww.substring(4, 6) + URLEncoder.encode(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "UTF-8") + Wwwwwwwwwwwwwwwwwwwwwwwwwww.substring(0, 1);
        } catch (UnsupportedEncodingException unused2) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("whale://");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Wwwwwwwwwwwwwwwwwwwwwwwwwww.substring(4, 6));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Wwwwwwwwwwwwwwwwwwwwwwwwwww.substring(0, 1));
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cf A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws XZNUrlException {
        boolean z;
        String str2 = "";
        if (Wwwwwwwwwwwwwwwwwwwwwwww == null || Wwwwwwwwwwwwwwwwwwwwwww == null) {
            try {
                Wwwwwwwwwwwwwwwwwwwwwwww = (RSAPublicKey) Wwwwwwwwwwwwwwwwwwwwwwwwwwww("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNUHuOnUckC9MGeyx1eT0b2+jaF57ApJZVi5PKrj1IFa4whaunrEOBBFuFZyoNT58OF/CnYLU4wkXwxZE4Gw8X1wFZq0p9ecid/kVo9whHkJSmulT/hBrtdTRgf+0Nizh23VYuqiaGY9I8e+ydWUHzhcW1g13C7AayUg7jF/S0PQIDAQAB");
                Wwwwwwwwwwwwwwwwwwwwwww = (RSAPrivateKey) Wwwwwwwwwwwwwwwwwwwwwwwwwwwww("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM1Qe46dRyQL0wZ7LHV5PRvb6NoXnsCkllWLk8quPUgVrjCFq6esQ4EEW4VnKg1Pnw4X8KdgtTjCRfDFkTgbDxfXAVmrSn15yJ3+RWj3CEeQlKa6VP+EGu11NGB/7Q2LOHbdVi6qJoZj0jx77J1ZQfOFxbWDXcLsBrJSDuMX9LQ9AgMBAAECgYASyy40NMNhUk/DxRyhuDJWzX94Dzdx7N7x/6/MmrxzT8C9Ik8/Lu6S7cIu6O2ZgFNP5/MYbyrHgkkCrCMJ3rg3zW7iJ1tdXRX1YR3S/Ivg6A1Sx2tU5By8klqoHphaZl6NB3bhPOaoVJ4spIzRRxapdc6+OjkteKR5lpCW/iT+YQJBAO4yNIUt/IfFus4jMOAgW3edOViAzp+bd8HgHp5n0HgYjqo64uaPD7zywuo1y06wipGaQv1bV7ZcaYXp3Ax9bFUCQQDcqRkE7oNmtddoJ9j/GYhURfRI8gG4FyLIDxAc0RzeKyfpMxP0wZ2EEoBopG94B2EqyJIafzW/P2tci4x/PZBJAkBp8HJjeVyDlnHLFOO8CygjPw4uSrubSS4uUFvN4CZcA7AQDji0ipRZWS9Ps7VEvkgjEhURUfrk5J0aLjTsaSwxAkA3YFx+B1mEqjfv1Kg5hO/YrmGa+NkDmRLKgDU79iK3gr8WYBIvB3P/VCFToYiz564z7Xf1HF2hrEnGROMyf4G5AkEAtNhfSXba8bkVuvz8PzHzvuqxXHMXRc8/H4MRqdAlfEei/QBziq0IRyvQUqeiKAphjzxlGPoDwXofWWjU35lthw==");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (!parse.isOpaque() && !TextUtils.isEmpty(parse.getQueryParameter("xyz"))) {
                z = true;
                if (z) {
                    return str;
                }
                String queryParameter = Uri.parse(str).getQueryParameter("xyz");
                if (TextUtils.isEmpty(queryParameter)) {
                    return str;
                }
                int indexOf = queryParameter.indexOf(45);
                if (indexOf == -1) {
                    throw new XZNUrlException(1);
                }
                String substring = queryParameter.substring(0, indexOf);
                String substring2 = queryParameter.substring(indexOf + 1);
                boolean equals = substring.equals("v2");
                if (!equals) {
                    throw new XZNUrlException(2);
                }
                String substring3 = substring2.substring(0, substring2.length() - 32);
                String substring4 = substring2.substring(substring2.length() - 32);
                try {
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring3, equals);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("url=")) {
                        try {
                            str2 = URLDecoder.decode(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.substring(4), "UTF-8");
                        } catch (UnsupportedEncodingException unused2) {
                            str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.substring(4);
                        }
                    }
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    return (Wwwwwwwwwwwwwwwwwwwwwwwwwww == null || !Wwwwwwwwwwwwwwwwwwwwwwwwwww.toLowerCase().equals(substring4.toLowerCase())) ? str : str2;
                } catch (Exception unused3) {
                    throw new XZNUrlException(2);
                }
            }
        }
        z = false;
        if (z) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws XZNUrlException {
        String replace;
        String str2;
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
        } catch (Exception unused) {
        }
        String Wwwwwwwwwwwwwwwwwwwwwwww2 = r40.Wwwwwwwwwwwwwwwwwwwwwwww(str);
        String str3 = "tita://";
        if (!Wwwwwwwwwwwwwwwwwwwwwwww2.startsWith(str3)) {
            str3 = "whale://";
            if (!Wwwwwwwwwwwwwwwwwwwwwwww2.startsWith(str3)) {
                replace = "";
                if (!TextUtils.isEmpty(replace)) {
                    return Wwwwwwwwwwwwwwwwwwwwwwww2;
                }
                try {
                    try {
                        try {
                            str2 = new String(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(URLDecoder.decode(replace.substring(2, replace.length() - 1), "UTF-8"))), "utf-8");
                        } catch (Exception unused2) {
                            str2 = "";
                        }
                        if (!str2.startsWith("codes=")) {
                            return "";
                        }
                        try {
                            return URLDecoder.decode(str2.substring(6), "UTF-8");
                        } catch (UnsupportedEncodingException unused3) {
                            return str2.substring(6);
                        }
                    } catch (Exception unused4) {
                        throw new XZNUrlException(2);
                    }
                } catch (UnsupportedEncodingException unused5) {
                    throw new XZNUrlException(2);
                }
            }
        }
        replace = Wwwwwwwwwwwwwwwwwwwwwwww2.replace(str3, "");
        if (!TextUtils.isEmpty(replace)) {
        }
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        int i;
        int i2;
        byte[] bytes = str.getBytes();
        char[] cArr = new char[bytes.length];
        int length = bytes.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = bytes[i3];
            int i5 = 48;
            if (i4 < 48 || i4 > 57) {
                i5 = 65;
                if (i4 < 65 || i4 > 90) {
                    i5 = 97;
                    if (i4 >= 97 && i4 <= 122) {
                        i = i4 - 97;
                    }
                    cArr[i3] = (char) i4;
                } else {
                    i = i4 - 65;
                }
                i2 = (i + 13) % 26;
            } else {
                i2 = ((i4 - 48) + 5) % 10;
            }
            i4 = i2 + i5;
            cArr[i3] = (char) i4;
        }
        return String.valueOf(cArr);
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        try {
            char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(charArray[random.nextInt(charArray.length)]);
            }
            return sb.toString();
        } catch (Exception unused) {
            return "uKCMpDUabgudKDkhbvpKDJSqeFhJYksMppLDJAfhCxSW".substring(0, i);
        }
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, boolean z) throws Exception {
        byte[] bArr;
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, Wwwwwwwwwwwwwwwwwwwwwwww);
        if (z) {
            try {
                bArr = zu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.getBytes("utf-8"));
            } catch (Exception unused) {
                bArr = new byte[0];
            }
        } else {
            bArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        }
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i;
            if (i3 <= 0) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return new String(byteArray);
            }
            byte[] doFinal = i3 > 128 ? cipher.doFinal(bArr, i, 128) : cipher.doFinal(bArr, i, i3);
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i2++;
            i = i2 * 128;
        }
    }

    public static byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        try {
            return zu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.getBytes("utf-8"));
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}

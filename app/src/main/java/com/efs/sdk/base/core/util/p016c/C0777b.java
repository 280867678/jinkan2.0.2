package com.efs.sdk.base.core.util.p016c;

import android.util.Base64;
import com.efs.sdk.base.core.util.Log;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import org.litepal.crud.LitePalSupport;

/* renamed from: com.efs.sdk.base.core.util.c.b */
/* loaded from: classes3.dex */
public final class C0777b {
    /* renamed from: a */
    public static String m4009a(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        try {
            return String.format(Locale.CHINA, "%032x", new BigInteger(1, MessageDigest.getInstance(LitePalSupport.MD5).digest(str.getBytes())));
        } catch (NoSuchAlgorithmException e) {
            Log.m4065e("efs.base", "md5 error", e);
            return "";
        }
    }

    /* renamed from: a */
    public static String m4008a(byte[] bArr) {
        return new String(Base64.encode(bArr, 11));
    }

    /* renamed from: b */
    public static String m4007b(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.m4065e("efs.base", "urlEncode error", e);
            return "";
        }
    }

    /* renamed from: b */
    public static String m4006b(byte[] bArr) {
        try {
            return new String(Base64.decode(bArr, 11));
        } catch (Throwable th) {
            Log.m4065e("efs.base", "decode error", th);
            return "";
        }
    }
}

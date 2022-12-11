package com.efs.sdk.base.core.util.p016c;

import com.efs.sdk.base.core.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.litepal.crud.LitePalSupport;

/* renamed from: com.efs.sdk.base.core.util.c.a */
/* loaded from: classes3.dex */
public final class C0776a {

    /* renamed from: a */
    public static final IvParameterSpec f333a = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* renamed from: a */
    public static SecretKeySpec m4013a(String str) {
        return new SecretKeySpec(str.getBytes(), LitePalSupport.AES);
    }

    /* renamed from: a */
    public static byte[] m4012a(String str, String str2) {
        try {
            return m4010b(str.getBytes("UTF-8"), str2);
        } catch (UnsupportedEncodingException e) {
            Log.m4065e("efs.base", "getBytes error", e);
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m4011a(byte[] bArr, String str) {
        try {
            SecretKeySpec m4013a = m4013a(str);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, m4013a, f333a);
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            Log.m4065e("efs.base", "aes decrypt error", e);
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m4010b(byte[] bArr, String str) {
        try {
            SecretKeySpec m4013a = m4013a(str);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, m4013a, f333a);
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            Log.m4065e("efs.base", "aes encrypt error", e);
            return null;
        }
    }
}

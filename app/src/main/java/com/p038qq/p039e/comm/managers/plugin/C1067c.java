package com.p038qq.p039e.comm.managers.plugin;

import android.text.TextUtils;
import android.util.Base64;
import com.p038qq.p039e.comm.util.GDTLogger;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.litepal.crud.LitePalSupport;
import org.mozilla.javascript.regexp.NativeRegExp;

/* renamed from: com.qq.e.comm.managers.plugin.c */
/* loaded from: classes3.dex */
public class C1067c {
    public static final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {82, 83, 65, NativeRegExp.REOP_MINIMALOPT, 69, 67, 66, NativeRegExp.REOP_MINIMALOPT, 80, 75, 67, 83, NativeRegExp.REOP_ENDCHILD, 80, 97, 100, 100, 105, 110, 103};
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public PublicKey Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: com.qq.e.comm.managers.plugin.c$b */
    /* loaded from: classes3.dex */
    public static final class C1069b {

        /* renamed from: a */
        public static final C1067c f665a = new C1067c(null);
    }

    public C1067c() {
        boolean z;
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    public /* synthetic */ C1067c(C1068a c1068a) {
        boolean z;
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    public final PublicKey Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws Exception {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    /* renamed from: a */
    public boolean m3656a(String str, File file) {
        String str2;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    str2 = C1070d.m3654a(messageDigest.digest());
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    str2 = "";
                    return m3655a(str, str2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
            return m3655a(str, str2);
        }
        str2 = "";
        return m3655a(str, str2);
    }

    /* renamed from: a */
    public boolean m3655a(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return true;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            byte[] decode = Base64.decode(str, 0);
            try {
                Cipher cipher = Cipher.getInstance(new String(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "UTF-8"));
                cipher.init(2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                str3 = new String(cipher.doFinal(decode), "UTF-8").trim();
            } catch (Throwable unused) {
                GDTLogger.m3647d("ErrorWhileVerifySigNature");
            }
            boolean equals = str2.equals(str3);
            GDTLogger.m3647d("Verify Result" + equals + "src=" + str2 + " & target=" + str3);
            return equals;
        }
        str3 = null;
        boolean equals2 = str2.equals(str3);
        GDTLogger.m3647d("Verify Result" + equals2 + "src=" + str2 + " & target=" + str3);
        return equals2;
    }
}

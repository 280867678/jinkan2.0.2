package me.tvspark;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.litepal.crud.LitePalSupport;
import org.litepal.util.cipher.AESCrypt;

/* renamed from: me.tvspark.wf */
/* loaded from: classes4.dex */
public class C2748wf implements AbstractC2863zj {
    @Nullable
    public CipherInputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2748wf(AbstractC2863zj abstractC2863zj, byte[] bArr, byte[] bArr2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2863zj;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr2;
    }

    @Override // me.tvspark.AbstractC2863zj
    public final Map<String, List<String>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2863zj
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2410nk abstractC2410nk) {
        if (abstractC2410nk != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2410nk);
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2863zj
    public void close() throws IOException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.close();
        }
    }

    @Override // me.tvspark.AbstractC2863zj
    @Nullable
    public final Uri getUri() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getUri();
    }

    @Override // me.tvspark.AbstractC2752wj
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int read = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.read(bArr, i, i2);
        if (read < 0) {
            return -1;
        }
        return read;
    }

    @Override // me.tvspark.AbstractC2863zj
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1949bk c1949bk) throws IOException {
        try {
            Cipher cipher = Cipher.getInstance(AESCrypt.AES_MODE);
            try {
                cipher.init(2, new SecretKeySpec(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, LitePalSupport.AES), new IvParameterSpec(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                C1912ak c1912ak = new C1912ak(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c1949bk);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new CipherInputStream(c1912ak, cipher);
                if (c1912ak.Wwwwwwwwwwwwwwwwwwwww) {
                    return -1L;
                }
                c1912ak.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1912ak.Wwwwwwwwwwwwwwwwwwwwwww);
                c1912ak.Wwwwwwwwwwwwwwwwwwwww = true;
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }
}

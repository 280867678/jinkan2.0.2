package me.tvspark;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.DataSourceException;
import java.io.IOException;
import java.net.URLDecoder;

/* renamed from: me.tvspark.xj */
/* loaded from: classes4.dex */
public final class C2789xj extends AbstractC2715vj {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C1949bk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2789xj() {
        super(false);
    }

    @Override // me.tvspark.AbstractC2863zj
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1949bk c1949bk) throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1949bk;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = (int) c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Uri uri = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String scheme = uri.getScheme();
        if (!"data".equals(scheme)) {
            String valueOf = String.valueOf(scheme);
            throw new ParserException(valueOf.length() != 0 ? "Unsupported scheme: ".concat(valueOf) : new String("Unsupported scheme: "));
        }
        String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri.getSchemeSpecificPart(), ",");
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length != 2) {
            String valueOf2 = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(valueOf2.length() + 23);
            sb.append("Unexpected URI format: ");
            sb.append(valueOf2);
            throw new ParserException(sb.toString());
        }
        String str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[1];
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0].contains(";base64")) {
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                String valueOf3 = String.valueOf(str);
                throw new ParserException(valueOf3.length() != 0 ? "Error while parsing Base64 encoded string: ".concat(valueOf3) : new String("Error while parsing Base64 encoded string: "), e);
            }
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(URLDecoder.decode(str, C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.name()));
        }
        long j = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int length = j != -1 ? ((int) j) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = length;
        if (length > this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.length || this.Wwwwwwwwwwwwwwwwwwwwwwwwwww > length) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            throw new DataSourceException(0);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2863zj
    public void close() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }

    @Override // me.tvspark.AbstractC2863zj
    @Nullable
    public Uri getUri() {
        C1949bk c1949bk = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c1949bk != null) {
            return c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    @Override // me.tvspark.AbstractC2752wj
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2);
        System.arraycopy(bArr2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, i, min);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww += min;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(min);
        return min;
    }
}

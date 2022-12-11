package me.tvspark;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: me.tvspark.mk */
/* loaded from: classes4.dex */
public final class C2373mk implements AbstractC2863zj {
    public Map<String, List<String>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2373mk(AbstractC2863zj abstractC2863zj) {
        if (abstractC2863zj != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2863zj;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Uri.EMPTY;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.emptyMap();
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2863zj
    public Map<String, List<String>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2863zj
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1949bk c1949bk) throws IOException {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.emptyMap();
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
        Uri uri = getUri();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uri;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2863zj
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2410nk abstractC2410nk) {
        if (abstractC2410nk != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2410nk);
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2863zj
    public void close() throws IOException {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.close();
    }

    @Override // me.tvspark.AbstractC2863zj
    @Nullable
    public Uri getUri() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getUri();
    }

    @Override // me.tvspark.AbstractC2752wj
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.read(bArr, i, i2);
        if (read != -1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += read;
        }
        return read;
    }
}

package me.tvspark;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import me.tvspark.C2035df;

/* renamed from: me.tvspark.se */
/* loaded from: classes4.dex */
public final class C2595se implements AbstractC2863zj {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.se$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public C2595se(AbstractC2863zj abstractC2863zj, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i > 0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2863zj;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[1];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.AbstractC2863zj
    public Map<String, List<String>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2863zj
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1949bk c1949bk) {
        throw new UnsupportedOperationException();
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
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2863zj
    @Nullable
    public Uri getUri() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getUri();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0076 A[RETURN] */
    @Override // me.tvspark.AbstractC2752wj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long Wwwwwwwwwwwwwwwwwwwwwwww;
        long max;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            boolean z = true;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.read(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 1) != -1) {
                int i3 = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0] & 255) << 4;
                if (i3 != 0) {
                    byte[] bArr2 = new byte[i3];
                    int i4 = i3;
                    int i5 = 0;
                    while (i4 > 0) {
                        int read = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.read(bArr2, i5, i4);
                        if (read != -1) {
                            i5 += read;
                            i4 -= read;
                        }
                    }
                    while (i3 > 0) {
                        int i6 = i3 - 1;
                        if (bArr2[i6] != 0) {
                            break;
                        }
                        i3 = i6;
                    }
                    if (i3 > 0) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        C2078el c2078el = new C2078el(bArr2, i3);
                        C2035df.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (C2035df.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww) {
                            max = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwww;
                        } else {
                            Wwwwwwwwwwwwwwwwwwwwwwww = C2035df.this.Wwwwwwwwwwwwwwwwwwwwwwww();
                            max = Math.max(Wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        AbstractC2740w7 abstractC2740w7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww;
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2740w7);
                        abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(max, 1, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0, null);
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww = true;
                    }
                }
                if (z) {
                    return -1;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            z = false;
            if (z) {
            }
        }
        int read2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.read(bArr, i, Math.min(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i2));
        if (read2 != -1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= read2;
        }
        return read2;
    }
}

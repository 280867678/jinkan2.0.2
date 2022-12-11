package me.tvspark;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import me.tvspark.C2218id;

/* renamed from: me.tvspark.q7 */
/* loaded from: classes4.dex */
public final class C2514q7 {
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(10);

    @Nullable
    public C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, @Nullable C2218id.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws IOException {
        C2254jc c2254jc = null;
        int i = 0;
        while (true) {
            try {
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 10);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww() != 4801587) {
                    break;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                int Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww();
                int i2 = Wwwwwwwwwwwwwwwwwwwwwww + 10;
                if (c2254jc == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, bArr, 0, 10);
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 10, Wwwwwwwwwwwwwwwwwwwwwww);
                    c2254jc = new C2218id(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i2);
                } else {
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwww);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        return c2254jc;
    }
}

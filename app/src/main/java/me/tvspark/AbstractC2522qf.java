package me.tvspark;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;
import me.tvspark.C1908ag;

/* renamed from: me.tvspark.qf */
/* loaded from: classes4.dex */
public abstract class AbstractC2522qf extends AbstractC2479pf {
    public volatile boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwww;

    public AbstractC2522qf(AbstractC2863zj abstractC2863zj, C1949bk c1949bk, int i, C2245j3 c2245j3, int i2, @Nullable Object obj, @Nullable byte[] bArr) {
        super(abstractC2863zj, c1949bk, i, c2245j3, i2, obj, -9223372036854775807L, -9223372036854775807L);
        AbstractC2522qf abstractC2522qf;
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            abstractC2522qf = this;
        } else {
            abstractC2522qf = this;
            bArr2 = bArr;
        }
        abstractC2522qf.Wwwwwwwwwwwwwwwwwwwwwwwww = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int i = 0;
            int i2 = 0;
            while (i != -1 && !this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                if (bArr.length < i2 + 16384) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(bArr, bArr.length + 16384);
                }
                i = this.Wwwwwwwwwwwwwwwwwwwwwwwwww.read(this.Wwwwwwwwwwwwwwwwwwwwwwwww, i2, 16384);
                if (i != -1) {
                    i2 += i;
                }
            }
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                ((C1908ag.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this).Wwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(this.Wwwwwwwwwwwwwwwwwwwwwwwww, i2);
            }
        } finally {
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2863zj) this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }
}

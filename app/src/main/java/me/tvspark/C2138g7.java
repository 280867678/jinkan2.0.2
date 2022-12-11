package me.tvspark;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import me.tvspark.AbstractC2740w7;

/* renamed from: me.tvspark.g7 */
/* loaded from: classes4.dex */
public final class C2138g7 implements AbstractC2740w7 {
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[4096];

    @Override // me.tvspark.AbstractC2740w7
    public /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2752wj abstractC2752wj, int i, boolean z) throws IOException {
        return C2700v7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, abstractC2752wj, i, z);
    }

    @Override // me.tvspark.AbstractC2740w7
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2752wj abstractC2752wj, int i, boolean z, int i2) throws IOException {
        int read = abstractC2752wj.read(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, Math.min(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length, i));
        if (read == -1) {
            if (!z) {
                throw new EOFException();
            }
            return -1;
        }
        return read;
    }

    @Override // me.tvspark.AbstractC2740w7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i, int i2, int i3, @Nullable AbstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
    }

    @Override // me.tvspark.AbstractC2740w7
    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i) {
        C2700v7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, c2078el, i);
    }

    @Override // me.tvspark.AbstractC2740w7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i, int i2) {
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i);
    }

    @Override // me.tvspark.AbstractC2740w7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
    }
}

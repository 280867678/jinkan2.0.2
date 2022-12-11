package me.tvspark;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: me.tvspark.dj */
/* loaded from: classes4.dex */
public final class C2039dj {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC1985cj[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2039dj(AbstractC1985cj... abstractC1985cjArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC1985cjArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC1985cjArr.length;
    }

    public AbstractC1985cj[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return (AbstractC1985cj[]) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clone();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C2039dj.class == obj.getClass()) {
            return Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ((C2039dj) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    public int hashCode() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 527 + Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}

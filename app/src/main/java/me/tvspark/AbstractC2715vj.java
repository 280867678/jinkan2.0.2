package me.tvspark;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: me.tvspark.vj */
/* loaded from: classes4.dex */
public abstract class AbstractC2715vj implements AbstractC2863zj {
    @Nullable
    public C1949bk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ArrayList<AbstractC2410nk> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList<>(1);
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public AbstractC2715vj(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C1949bk c1949bk = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
        C1949bk c1949bk2 = c1949bk;
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, c1949bk2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        C1949bk c1949bk = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
        C1949bk c1949bk2 = c1949bk;
        for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i2++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, c1949bk2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1949bk c1949bk) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1949bk;
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, c1949bk, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    @Override // me.tvspark.AbstractC2863zj
    public /* synthetic */ Map<String, List<String>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return C2826yj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1949bk c1949bk) {
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, c1949bk, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    @Override // me.tvspark.AbstractC2863zj
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2410nk abstractC2410nk) {
        if (abstractC2410nk != null) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(abstractC2410nk)) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(abstractC2410nk);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
            return;
        }
        throw null;
    }
}

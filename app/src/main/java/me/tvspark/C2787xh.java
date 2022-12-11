package me.tvspark;

import java.util.Collections;
import java.util.List;

/* renamed from: me.tvspark.xh */
/* loaded from: classes4.dex */
public final class C2787xh implements AbstractC1909ah {
    public final List<Long> Wwwwwwwwwwwwwwwwwwwwwww;
    public final List<List<C2786xg>> Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2787xh(List<List<C2786xg>> list, List<Long> list2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwww = list2;
    }

    @Override // me.tvspark.AbstractC1909ah
    public List<C2786xg> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((List<? extends Comparable<? super Long>>) this.Wwwwwwwwwwwwwwwwwwwwwww, Long.valueOf(j), true, false);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1 ? Collections.emptyList() : this.Wwwwwwwwwwwwwwwwwwwwwwww.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC1909ah
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.size();
    }

    @Override // me.tvspark.AbstractC1909ah
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((List<? extends Comparable<? super Long>>) this.Wwwwwwwwwwwwwwwwwwwwwww, Long.valueOf(j), false, false);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwww.size()) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return -1;
    }

    @Override // me.tvspark.AbstractC1909ah
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        boolean z = true;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 0);
        if (i >= this.Wwwwwwwwwwwwwwwwwwwwwww.size()) {
            z = false;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        return this.Wwwwwwwwwwwwwwwwwwwwwww.get(i).longValue();
    }
}

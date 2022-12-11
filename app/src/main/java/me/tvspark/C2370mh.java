package me.tvspark;

import java.util.Collections;
import java.util.List;

/* renamed from: me.tvspark.mh */
/* loaded from: classes4.dex */
public final class C2370mh implements AbstractC1909ah {
    public final List<C2786xg> Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2370mh(List<C2786xg> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = list;
    }

    @Override // me.tvspark.AbstractC1909ah
    public List<C2786xg> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return j >= 0 ? this.Wwwwwwwwwwwwwwwwwwwwwwww : Collections.emptyList();
    }

    @Override // me.tvspark.AbstractC1909ah
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return 1;
    }

    @Override // me.tvspark.AbstractC1909ah
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // me.tvspark.AbstractC1909ah
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i == 0);
        return 0L;
    }
}

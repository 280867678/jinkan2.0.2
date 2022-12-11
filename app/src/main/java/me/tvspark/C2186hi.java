package me.tvspark;

import java.util.Collections;
import java.util.List;

/* renamed from: me.tvspark.hi */
/* loaded from: classes4.dex */
public final class C2186hi implements AbstractC1909ah {
    public static final C2186hi Wwwwwwwwwwwwwwwwwwwwwww = new C2186hi();
    public final List<C2786xg> Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2186hi() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = Collections.emptyList();
    }

    public C2186hi(C2786xg c2786xg) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = Collections.singletonList(c2786xg);
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

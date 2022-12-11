package me.tvspark;

import java.util.Collections;
import java.util.List;

/* renamed from: me.tvspark.zh */
/* loaded from: classes4.dex */
public final class C2861zh implements AbstractC1909ah {
    public final long[] Wwwwwwwwwwwwwwwwwwwwwww;
    public final C2786xg[] Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2861zh(C2786xg[] c2786xgArr, long[] jArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = c2786xgArr;
        this.Wwwwwwwwwwwwwwwwwwwwwww = jArr;
    }

    @Override // me.tvspark.AbstractC1909ah
    public List<C2786xg> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, j, true, false);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
            C2786xg[] c2786xgArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (c2786xgArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] != C2786xg.Wwwwwwwwwwwwwwwwwww) {
                return Collections.singletonList(c2786xgArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww]);
            }
        }
        return Collections.emptyList();
    }

    @Override // me.tvspark.AbstractC1909ah
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.length;
    }

    @Override // me.tvspark.AbstractC1909ah
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, j, false, false);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwww.length) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return -1;
    }

    @Override // me.tvspark.AbstractC1909ah
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        boolean z = true;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 0);
        if (i >= this.Wwwwwwwwwwwwwwwwwwwwwww.length) {
            z = false;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        return this.Wwwwwwwwwwwwwwwwwwwwwww[i];
    }
}

package me.tvspark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import me.tvspark.C2786xg;

/* renamed from: me.tvspark.si */
/* loaded from: classes4.dex */
public final class C2599si implements AbstractC1909ah {
    public final long[] Wwwwwwwwwwwwwwwwwwwwww;
    public final long[] Wwwwwwwwwwwwwwwwwwwwwww;
    public final List<C2445oi> Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2599si(List<C2445oi> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableList(new ArrayList(list));
        this.Wwwwwwwwwwwwwwwwwwwwwww = new long[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            C2445oi c2445oi = list.get(i);
            int i2 = i * 2;
            long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
            jArr[i2] = c2445oi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            jArr[i2 + 1] = c2445oi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        long[] jArr2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.Wwwwwwwwwwwwwwwwwwwwww = copyOf;
        Arrays.sort(copyOf);
    }

    @Override // me.tvspark.AbstractC1909ah
    public List<C2786xg> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwww.size(); i++) {
            long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                C2445oi c2445oi = this.Wwwwwwwwwwwwwwwwwwwwwwww.get(i);
                C2786xg c2786xg = c2445oi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -3.4028235E38f) {
                    arrayList2.add(c2445oi);
                } else {
                    arrayList.add(c2786xg);
                }
            }
        }
        Collections.sort(arrayList2, C2260ji.Wwwwwwwwwwwwwwwwwwwwwwww);
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((C2445oi) arrayList2.get(i3)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (-1) - i3;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
            arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
        return arrayList;
    }

    @Override // me.tvspark.AbstractC1909ah
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwww.length;
    }

    @Override // me.tvspark.AbstractC1909ah
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, j, false, false);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwww.length) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return -1;
    }

    @Override // me.tvspark.AbstractC1909ah
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        boolean z = true;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 0);
        if (i >= this.Wwwwwwwwwwwwwwwwwwwwww.length) {
            z = false;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        return this.Wwwwwwwwwwwwwwwwwwwwww[i];
    }
}

package me.tvspark;

import android.util.Pair;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import me.tvspark.AbstractC2625t7;

/* renamed from: me.tvspark.x8 */
/* loaded from: classes4.dex */
public final class C2778x8 implements AbstractC2852z8 {
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2778x8(long[] jArr, long[] jArr2, long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j == -9223372036854775807L ? C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr2[jArr2.length - 1]) : j;
    }

    public static Pair<Long, Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long[] jArr, long[] jArr2) {
        Long valueOf;
        Long valueOf2;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr, j, true, true);
        long j2 = jArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        long j3 = jArr2[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
        if (i == jArr.length) {
            valueOf = Long.valueOf(j2);
            valueOf2 = Long.valueOf(j3);
        } else {
            long j4 = jArr[i];
            long j5 = jArr2[i];
            double d = j4 == j2 ? RoundRectDrawableWithShadow.COS_45 : (j - j2) / (j4 - j2);
            valueOf = Long.valueOf(j);
            valueOf2 = Long.valueOf(((long) (d * (j5 - j3))) + j3);
        }
        return Pair.create(valueOf, valueOf2);
    }

    @Override // me.tvspark.AbstractC2625t7
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2625t7
    public AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        Pair<Long, Long> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, 0L, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2662u7(C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Long) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.first).longValue()), ((Long) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.second).longValue()));
    }

    @Override // me.tvspark.AbstractC2625t7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return true;
    }

    @Override // me.tvspark.AbstractC2852z8
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return -1L;
    }

    @Override // me.tvspark.AbstractC2852z8
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Long) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).second).longValue());
    }
}

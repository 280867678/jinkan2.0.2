package me.tvspark;

import java.util.Arrays;
import me.tvspark.AbstractC2625t7;

/* renamed from: me.tvspark.c7 */
/* loaded from: classes4.dex */
public final class C1973c7 implements AbstractC2625t7 {
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C1973c7(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr3;
        int length = iArr.length;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = length;
        if (length > 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
        }
    }

    @Override // me.tvspark.AbstractC2625t7
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2625t7
    public AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j, true, true);
        C2662u7 c2662u7 = new C2662u7(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww], this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww]);
        if (c2662u7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= j || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1) {
            return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2662u7);
        }
        int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
        return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2662u7, new C2662u7(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i], this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i]));
    }

    @Override // me.tvspark.AbstractC2625t7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return true;
    }

    public String toString() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String arrays = Arrays.toString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        String arrays2 = Arrays.toString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        String arrays3 = Arrays.toString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        String arrays4 = Arrays.toString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrays4, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrays3, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrays2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrays, 71)))));
        sb.append("ChunkIndex(length=");
        sb.append(i);
        sb.append(", sizes=");
        sb.append(arrays);
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, ", offsets=", arrays2, ", timeUs=", arrays3);
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, ", durationsUs=", arrays4, ")");
    }
}

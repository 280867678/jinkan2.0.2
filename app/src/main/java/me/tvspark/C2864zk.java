package me.tvspark;

import java.util.Arrays;

/* renamed from: me.tvspark.zk */
/* loaded from: classes4.dex */
public final class C2864zk {
    public long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new long[32];
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i < 0 || i >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Invalid index ");
            sb.append(i);
            sb.append(", size is ");
            sb.append(i2);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long[] jArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i == jArr.length) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
        jArr2[i2] = j;
    }
}

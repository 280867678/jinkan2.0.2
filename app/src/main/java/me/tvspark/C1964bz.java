package me.tvspark;

import java.math.BigInteger;

/* renamed from: me.tvspark.bz */
/* loaded from: classes4.dex */
public final class C1964bz {
    public static final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new long[37];
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[37];
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[37];

    static {
        BigInteger bigInteger = new BigInteger("10000000000000000", 16);
        for (int i = 2; i <= 36; i++) {
            long j = i;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1L, j);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = (int) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1L, j);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = bigInteger.toString(i).length() - 1;
        }
    }
}

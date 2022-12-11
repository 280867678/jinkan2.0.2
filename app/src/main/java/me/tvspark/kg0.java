package me.tvspark;

import java.util.Comparator;

/* loaded from: classes4.dex */
public final class kg0 implements Comparator<Comparable<? super Object>> {
    public static final kg0 Wwwwwwwwwwwwwwwwwwwwwwww = new kg0();

    @Override // java.util.Comparator
    public int compare(Comparable<? super Object> comparable, Comparable<? super Object> comparable2) {
        Comparable<? super Object> comparable3 = comparable;
        Comparable<? super Object> comparable4 = comparable2;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparable3, "a");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparable4, "b");
        return comparable3.compareTo(comparable4);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return lg0.Wwwwwwwwwwwwwwwwwwwwwwww;
    }
}

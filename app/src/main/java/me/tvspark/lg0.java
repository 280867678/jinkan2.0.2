package me.tvspark;

import java.util.Comparator;

/* loaded from: classes4.dex */
public final class lg0 implements Comparator<Comparable<? super Object>> {
    public static final lg0 Wwwwwwwwwwwwwwwwwwwwwwww = new lg0();

    @Override // java.util.Comparator
    public int compare(Comparable<? super Object> comparable, Comparable<? super Object> comparable2) {
        Comparable<? super Object> comparable3 = comparable;
        Comparable<? super Object> comparable4 = comparable2;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparable3, "a");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(comparable4, "b");
        return comparable4.compareTo(comparable3);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return kg0.Wwwwwwwwwwwwwwwwwwwwwwww;
    }
}

package me.tvspark;

import java.util.List;

/* renamed from: me.tvspark.zf */
/* loaded from: classes4.dex */
public final class C2859zf implements AbstractC1982cg {
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {8, 13, 11, 2, 0, 1, 7};
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, List<Integer> list) {
        if (i == -1 || list.contains(Integer.valueOf(i))) {
            return;
        }
        list.add(Integer.valueOf(i));
    }
}

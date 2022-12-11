package me.tvspark;

import java.util.Collection;
import java.util.HashMap;

/* renamed from: me.tvspark.y3 */
/* loaded from: classes4.dex */
public final class C2810y3 extends AbstractC2695v2 {
    public final HashMap<Object, Integer> Wwwwwwwwwwwwwwwwwwwwwwww = new HashMap<>();
    public final Object[] Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2209i4[] Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2810y3(Collection<? extends AbstractC2547r3> collection, AbstractC2257jf abstractC2257jf) {
        super(false, abstractC2257jf);
        int i = 0;
        int size = collection.size();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[size];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new int[size];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2209i4[size];
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = new Object[size];
        int i2 = 0;
        int i3 = 0;
        for (AbstractC2547r3 abstractC2547r3 : collection) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww[i3] = abstractC2547r3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww[i3] = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[i3] = i2;
            i += this.Wwwwwwwwwwwwwwwwwwwwwwwwww[i3].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            i2 += this.Wwwwwwwwwwwwwwwwwwwwwwwwww[i3].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwww[i3] = abstractC2547r3.getUid();
            this.Wwwwwwwwwwwwwwwwwwwwwwww.put(this.Wwwwwwwwwwwwwwwwwwwwwwwww[i3], Integer.valueOf(i3));
            i3++;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
    }

    @Override // me.tvspark.AbstractC2209i4
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2209i4
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}

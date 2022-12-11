package me.tvspark;

import com.google.common.collect.EnumMultiset;

/* renamed from: me.tvspark.av */
/* loaded from: classes4.dex */
public class C1923av extends AbstractC2164gx<E> {
    public final /* synthetic */ EnumMultiset.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwww;

    public C1923av(EnumMultiset.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public int getCount() {
        return EnumMultiset.this.counts[this.Wwwwwwwwwwwwwwwwwwwwwwww];
    }

    @Override // me.tvspark.AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public Object getElement() {
        return EnumMultiset.this.enumConstants[this.Wwwwwwwwwwwwwwwwwwwwwwww];
    }
}

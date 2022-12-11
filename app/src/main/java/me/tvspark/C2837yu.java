package me.tvspark;

import java.util.Iterator;
import me.tvspark.AbstractC2090ex;

/* renamed from: me.tvspark.yu */
/* loaded from: classes4.dex */
public class C2837yu extends AbstractC2238ix<E> {
    public final /* synthetic */ AbstractC2874zu Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2837yu(AbstractC2874zu abstractC2874zu) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2874zu;
    }

    @Override // me.tvspark.AbstractC2238ix
    public AbstractC2090ex<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> iterator() {
        return AbstractC2500pu.this.descendingEntryIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return AbstractC2500pu.this.mo4575entrySet().size();
    }
}

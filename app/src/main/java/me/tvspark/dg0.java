package me.tvspark;

import java.util.Iterator;

/* loaded from: classes4.dex */
public abstract class dg0 implements Iterator<Long>, pi0 {
    public abstract long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @Override // java.util.Iterator
    public Long next() {
        return Long.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

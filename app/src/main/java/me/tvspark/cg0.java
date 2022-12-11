package me.tvspark;

import java.util.Iterator;

/* loaded from: classes4.dex */
public abstract class cg0 implements Iterator<Integer>, pi0 {
    public abstract int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @Override // java.util.Iterator
    public Integer next() {
        return Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

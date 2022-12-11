package me.tvspark;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public abstract class ig0 implements Iterator<jf0>, pi0 {
    @Override // java.util.Iterator
    public jf0 next() {
        kf0 kf0Var = (kf0) this;
        int i = kf0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
        long[] jArr = kf0Var.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i < jArr.length) {
            kf0Var.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            return new jf0(jArr[i]);
        }
        throw new NoSuchElementException(String.valueOf(kf0Var.Wwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

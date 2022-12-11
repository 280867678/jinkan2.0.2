package me.tvspark;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public abstract class jg0 implements Iterator<mf0>, pi0 {
    @Override // java.util.Iterator
    public mf0 next() {
        nf0 nf0Var = (nf0) this;
        int i = nf0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
        short[] sArr = nf0Var.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i < sArr.length) {
            nf0Var.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            return new mf0(sArr[i]);
        }
        throw new NoSuchElementException(String.valueOf(nf0Var.Wwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

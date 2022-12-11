package me.tvspark;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public abstract class hg0 implements Iterator<hf0>, pi0 {
    @Override // java.util.Iterator
    public hf0 next() {
        if0 if0Var = (if0) this;
        int i = if0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
        int[] iArr = if0Var.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i < iArr.length) {
            if0Var.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            return new hf0(iArr[i]);
        }
        throw new NoSuchElementException(String.valueOf(if0Var.Wwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

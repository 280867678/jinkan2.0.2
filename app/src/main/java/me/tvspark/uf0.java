package me.tvspark;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public abstract class uf0 implements Iterator<Boolean>, pi0 {
    @Override // java.util.Iterator
    public Boolean next() {
        uh0 uh0Var = (uh0) this;
        try {
            boolean[] zArr = uh0Var.Wwwwwwwwwwwwwwwwwwwwwww;
            int i = uh0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
            uh0Var.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            return Boolean.valueOf(zArr[i]);
        } catch (ArrayIndexOutOfBoundsException e) {
            uh0Var.Wwwwwwwwwwwwwwwwwwwwwwww--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

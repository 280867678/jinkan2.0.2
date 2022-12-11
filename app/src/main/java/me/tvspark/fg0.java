package me.tvspark;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public abstract class fg0 implements Iterator<Short>, pi0 {
    @Override // java.util.Iterator
    public Short next() {
        ci0 ci0Var = (ci0) this;
        try {
            short[] sArr = ci0Var.Wwwwwwwwwwwwwwwwwwwwwww;
            int i = ci0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
            ci0Var.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            return Short.valueOf(sArr[i]);
        } catch (ArrayIndexOutOfBoundsException e) {
            ci0Var.Wwwwwwwwwwwwwwwwwwwwwwww--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

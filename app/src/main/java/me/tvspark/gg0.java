package me.tvspark;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public abstract class gg0 implements Iterator<ff0>, pi0 {
    @Override // java.util.Iterator
    public ff0 next() {
        gf0 gf0Var = (gf0) this;
        int i = gf0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
        byte[] bArr = gf0Var.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i < bArr.length) {
            gf0Var.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            return new ff0(bArr[i]);
        }
        throw new NoSuchElementException(String.valueOf(gf0Var.Wwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

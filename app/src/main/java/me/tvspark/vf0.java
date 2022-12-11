package me.tvspark;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public abstract class vf0 implements Iterator<Byte>, pi0 {
    @Override // java.util.Iterator
    public Byte next() {
        vh0 vh0Var = (vh0) this;
        try {
            byte[] bArr = vh0Var.Wwwwwwwwwwwwwwwwwwwwwww;
            int i = vh0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
            vh0Var.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            return Byte.valueOf(bArr[i]);
        } catch (ArrayIndexOutOfBoundsException e) {
            vh0Var.Wwwwwwwwwwwwwwwwwwwwwwww--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

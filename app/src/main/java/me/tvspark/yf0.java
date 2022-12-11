package me.tvspark;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public abstract class yf0 implements Iterator<Double>, pi0 {
    @Override // java.util.Iterator
    public Double next() {
        xh0 xh0Var = (xh0) this;
        try {
            double[] dArr = xh0Var.Wwwwwwwwwwwwwwwwwwwwwww;
            int i = xh0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
            xh0Var.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            return Double.valueOf(dArr[i]);
        } catch (ArrayIndexOutOfBoundsException e) {
            xh0Var.Wwwwwwwwwwwwwwwwwwwwwwww--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

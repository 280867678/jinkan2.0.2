package me.tvspark;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public abstract class ag0 implements Iterator<Float>, pi0 {
    @Override // java.util.Iterator
    public Float next() {
        yh0 yh0Var = (yh0) this;
        try {
            float[] fArr = yh0Var.Wwwwwwwwwwwwwwwwwwwwwww;
            int i = yh0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
            yh0Var.Wwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            return Float.valueOf(fArr[i]);
        } catch (ArrayIndexOutOfBoundsException e) {
            yh0Var.Wwwwwwwwwwwwwwwwwwwwwwww--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

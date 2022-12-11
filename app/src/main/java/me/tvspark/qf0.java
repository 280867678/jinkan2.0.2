package me.tvspark;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.State;
import me.tvspark.eg0;

/* loaded from: classes4.dex */
public abstract class qf0<T> implements Iterator<T>, pi0 {
    public T Wwwwwwwwwwwwwwwwwwwwwww;
    public State Wwwwwwwwwwwwwwwwwwwwwwww = State.NotReady;

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww != State.Failed) {
            int ordinal = this.Wwwwwwwwwwwwwwwwwwwwwwww.ordinal();
            if (ordinal == 0) {
                return true;
            }
            if (ordinal != 2) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = State.Failed;
                eg0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (eg0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this;
                int i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
                if (i == 0) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = State.Done;
                } else {
                    eg0 eg0Var = eg0.this;
                    Object[] objArr = eg0Var.Wwwwwwwwwwwwwwwwwwwww;
                    int i2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = (T) objArr[i2];
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = State.Ready;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = (i2 + 1) % eg0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = i - 1;
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww == State.Ready) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = State.NotReady;
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

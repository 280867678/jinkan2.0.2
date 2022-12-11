package com.google.common.collect;

import java.util.NoSuchElementException;
import me.tvspark.AbstractC2239iy;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class AbstractIterator<T> extends AbstractC2239iy<T> {
    public T Wwwwwwwwwwwwwwwwwwwwwww;
    public State Wwwwwwwwwwwwwwwwwwwwwwww = State.NOT_READY;

    /* loaded from: classes3.dex */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public final T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = State.DONE;
        return null;
    }

    public abstract T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww != State.FAILED);
        int ordinal = this.Wwwwwwwwwwwwwwwwwwwwwwww.ordinal();
        if (ordinal != 0) {
            if (ordinal == 2) {
                return false;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = State.FAILED;
            this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww == State.DONE) {
                return false;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = State.READY;
            return true;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = State.NOT_READY;
            T t = this.Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}

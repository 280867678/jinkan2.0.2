package com.google.common.base;

import com.google.common.base.Optional;
import java.util.Iterator;
import java.util.NoSuchElementException;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class AbstractIterator<T> implements Iterator<T> {
    public T Wwwwwwwwwwwwwwwwwwwwwww;
    public State Wwwwwwwwwwwwwwwwwwwwwwww = State.NOT_READY;

    /* loaded from: classes3.dex */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        T t;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww != State.FAILED);
        int ordinal = this.Wwwwwwwwwwwwwwwwwwwwwwww.ordinal();
        if (ordinal != 0) {
            if (ordinal == 2) {
                return false;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = State.FAILED;
            Optional.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.C3453Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww c3453Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Optional.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.C3453Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this;
            while (true) {
                if (!c3453Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                    c3453Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = State.DONE;
                    t = null;
                    break;
                }
                Optional<? extends T> next = c3453Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.next();
                if (next.isPresent()) {
                    t = next.get();
                    break;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = t;
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

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

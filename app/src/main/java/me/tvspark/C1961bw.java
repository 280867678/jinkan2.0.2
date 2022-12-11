package me.tvspark;

import java.util.Iterator;

/* renamed from: me.tvspark.bw */
/* loaded from: classes4.dex */
public class C1961bw<E> implements AbstractC2386mx<E> {
    public E Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final Iterator<? extends E> Wwwwwwwwwwwwwwwwwwwwwwww;

    public C1961bw(Iterator<? extends E> it) {
        if (it != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = it;
            return;
        }
        throw null;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwwww.hasNext();
    }

    @Override // me.tvspark.AbstractC2386mx, java.util.Iterator
    public E next() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.next();
        }
        E e = this.Wwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwww = null;
        return e;
    }

    @Override // me.tvspark.AbstractC2386mx
    public E peek() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.next();
            this.Wwwwwwwwwwwwwwwwwwwwwww = true;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.Iterator
    public void remove() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!this.Wwwwwwwwwwwwwwwwwwwwwww, "Can't remove after you've peeked at next");
        this.Wwwwwwwwwwwwwwwwwwwwwwww.remove();
    }
}

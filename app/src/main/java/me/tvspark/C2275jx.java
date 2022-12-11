package me.tvspark;

import java.util.Iterator;
import java.util.NoSuchElementException;
import me.tvspark.AbstractC2090ex;

/* renamed from: me.tvspark.jx */
/* loaded from: classes4.dex */
public final class C2275jx<E> implements Iterator<E> {
    public boolean Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwww;
    public final Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> Wwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2090ex<E> Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2275jx(AbstractC2090ex<E> abstractC2090ex, Iterator<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> it) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2090ex;
        this.Wwwwwwwwwwwwwwwwwwwwwww = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.Wwwwwwwwwwwwwwwwwwwww > 0 || this.Wwwwwwwwwwwwwwwwwwwwwww.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        if (hasNext()) {
            if (this.Wwwwwwwwwwwwwwwwwwwww == 0) {
                AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> next = this.Wwwwwwwwwwwwwwwwwwwwwww.next();
                this.Wwwwwwwwwwwwwwwwwwwwww = next;
                int count = next.getCount();
                this.Wwwwwwwwwwwwwwwwwwwww = count;
                this.Wwwwwwwwwwwwwwwwwwww = count;
            }
            this.Wwwwwwwwwwwwwwwwwwwww--;
            this.Wwwwwwwwwwwwwwwwwww = true;
            return this.Wwwwwwwwwwwwwwwwwwwwww.getElement();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww, "no calls to next() since the last call to remove()");
        if (this.Wwwwwwwwwwwwwwwwwwww == 1) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.remove();
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.remove(this.Wwwwwwwwwwwwwwwwwwwwww.getElement());
        }
        this.Wwwwwwwwwwwwwwwwwwww--;
        this.Wwwwwwwwwwwwwwwwwww = false;
    }
}

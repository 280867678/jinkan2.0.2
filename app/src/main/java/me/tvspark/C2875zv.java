package me.tvspark;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: me.tvspark.zv */
/* loaded from: classes4.dex */
public class C2875zv<T> implements Iterator<T> {
    public Deque<Iterator<? extends Iterator<? extends T>>> Wwwwwwwwwwwwwwwwwwwww;
    public Iterator<? extends Iterator<? extends T>> Wwwwwwwwwwwwwwwwwwwwww;
    public Iterator<? extends T> Wwwwwwwwwwwwwwwwwwwwwww = C2838yv.Wwwwwwwwwwwwwwwwwwww;
    public Iterator<? extends T> Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2875zv(Iterator<? extends Iterator<? extends T>> it) {
        if (it != null) {
            this.Wwwwwwwwwwwwwwwwwwwwww = it;
            return;
        }
        throw null;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        Iterator<? extends Iterator<? extends T>> it;
        while (true) {
            Iterator<? extends T> it2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it2);
            if (!it2.hasNext()) {
                while (true) {
                    Iterator<? extends Iterator<? extends T>> it3 = this.Wwwwwwwwwwwwwwwwwwwwww;
                    if (it3 != null && it3.hasNext()) {
                        it = this.Wwwwwwwwwwwwwwwwwwwwww;
                        break;
                    }
                    Deque<Iterator<? extends Iterator<? extends T>>> deque = this.Wwwwwwwwwwwwwwwwwwwww;
                    if (deque == null || deque.isEmpty()) {
                        break;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww.removeFirst();
                }
                it = null;
                this.Wwwwwwwwwwwwwwwwwwwwww = it;
                if (it == null) {
                    return false;
                }
                Iterator<? extends T> next = it.next();
                this.Wwwwwwwwwwwwwwwwwwwwwww = next;
                if (next instanceof C2875zv) {
                    C2875zv c2875zv = (C2875zv) next;
                    this.Wwwwwwwwwwwwwwwwwwwwwww = c2875zv.Wwwwwwwwwwwwwwwwwwwwwww;
                    if (this.Wwwwwwwwwwwwwwwwwwwww == null) {
                        this.Wwwwwwwwwwwwwwwwwwwww = new ArrayDeque();
                    }
                    this.Wwwwwwwwwwwwwwwwwwwww.addFirst(this.Wwwwwwwwwwwwwwwwwwwwww);
                    if (c2875zv.Wwwwwwwwwwwwwwwwwwwww != null) {
                        while (!c2875zv.Wwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                            this.Wwwwwwwwwwwwwwwwwwwww.addFirst(c2875zv.Wwwwwwwwwwwwwwwwwwwww.removeLast());
                        }
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwww = c2875zv.Wwwwwwwwwwwwwwwwwwwwww;
                }
            } else {
                return true;
            }
        }
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            Iterator<? extends T> it = this.Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = it;
            return it.next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww != null, "no calls to next() since the last call to remove()");
        this.Wwwwwwwwwwwwwwwwwwwwwwww.remove();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
    }
}

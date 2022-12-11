package me.tvspark;

import java.util.Iterator;
import java.util.List;

/* renamed from: me.tvspark.tv */
/* loaded from: classes4.dex */
public final class C2649tv extends AbstractC1960bv<T> {
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Iterable Wwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.tv$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<T> {
        public final /* synthetic */ Iterator Wwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwww = true;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2649tv c2649tv, Iterator it) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.hasNext();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // java.util.Iterator
        public T next() {
            ?? next = this.Wwwwwwwwwwwwwwwwwwwwwww.next();
            this.Wwwwwwwwwwwwwwwwwwwwwwww = false;
            return next;
        }

        @Override // java.util.Iterator
        public void remove() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!this.Wwwwwwwwwwwwwwwwwwwwwwww, "no calls to next() since the last call to remove()");
            this.Wwwwwwwwwwwwwwwwwwwwwww.remove();
        }
    }

    public C2649tv(Iterable iterable, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = iterable;
        this.Wwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        Iterable iterable = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (iterable instanceof List) {
            List list = (List) iterable;
            return list.subList(Math.min(list.size(), this.Wwwwwwwwwwwwwwwwwwwwww), list.size()).iterator();
        }
        Iterator it = iterable.iterator();
        int i = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (it != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >= 0, "numberToAdvance must be nonnegative");
            for (int i2 = 0; i2 < i && it.hasNext(); i2++) {
                it.next();
            }
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, it);
        }
        throw null;
    }
}

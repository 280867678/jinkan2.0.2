package me.tvspark;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/* renamed from: me.tvspark.aw */
/* loaded from: classes4.dex */
public class C1924aw<T> extends AbstractC2239iy<T> {
    public final Queue<AbstractC2386mx<T>> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.aw$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Comparator<AbstractC2386mx<T>> {
        public final /* synthetic */ Comparator Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1924aw c1924aw, Comparator comparator) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.compare(((AbstractC2386mx) obj).peek(), ((AbstractC2386mx) obj2).peek());
        }
    }

    public C1924aw(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new PriorityQueue(2, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, comparator));
        for (Iterator<? extends T> it : iterable) {
            if (it.hasNext()) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.add(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator) it));
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty();
    }

    @Override // java.util.Iterator
    public T next() {
        AbstractC2386mx<T> remove = this.Wwwwwwwwwwwwwwwwwwwwwwww.remove();
        T next = remove.next();
        if (remove.hasNext()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.add(remove);
        }
        return next;
    }
}

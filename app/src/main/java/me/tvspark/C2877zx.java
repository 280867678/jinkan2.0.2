package me.tvspark;

import com.google.common.collect.BoundType;
import java.util.Iterator;
import java.util.NavigableSet;
import me.tvspark.AbstractC2090ex;

/* renamed from: me.tvspark.zx */
/* loaded from: classes4.dex */
public class C2877zx<E> extends C2840yx<E> implements NavigableSet<E> {
    public C2877zx(AbstractC2766wx<E> abstractC2766wx) {
        super(abstractC2766wx);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e) {
        return (E) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4722tailMultiset(e, BoundType.CLOSED).firstEntry());
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return ((C2840yx) descendingSet()).iterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return new C2877zx(this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4619descendingMultiset());
    }

    @Override // java.util.NavigableSet
    public E floor(E e) {
        return (E) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4721headMultiset(e, BoundType.CLOSED).lastEntry());
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e, boolean z) {
        return new C2877zx(this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4721headMultiset(e, BoundType.forBoolean(z)));
    }

    @Override // java.util.NavigableSet
    public E higher(E e) {
        return (E) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4722tailMultiset(e, BoundType.OPEN).firstEntry());
    }

    @Override // java.util.NavigableSet
    public E lower(E e) {
        return (E) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4721headMultiset(e, BoundType.OPEN).lastEntry());
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        return (E) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwww.pollFirstEntry());
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        return (E) Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwww.pollLastEntry());
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        return new C2877zx(this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4623subMultiset(e, BoundType.forBoolean(z), e2, BoundType.forBoolean(z2)));
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e, boolean z) {
        return new C2877zx(this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4722tailMultiset(e, BoundType.forBoolean(z)));
    }
}

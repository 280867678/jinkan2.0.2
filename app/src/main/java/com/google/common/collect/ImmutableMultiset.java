package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import me.tvspark.AbstractC2090ex;
import me.tvspark.AbstractC2239iy;
import me.tvspark.C2312kx;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements AbstractC2090ex<E> {
    public transient ImmutableList<E> asList;
    public transient ImmutableSet<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> entrySet;

    /* loaded from: classes3.dex */
    public final class EntrySet extends IndexedImmutableSet<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> {
        public static final long serialVersionUID = 0;

        public EntrySet() {
        }

        public /* synthetic */ EntrySet(ImmutableMultiset immutableMultiset, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount() > 0 && ImmutableMultiset.this.count(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getElement()) == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount();
            }
            return false;
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        /* renamed from: get  reason: collision with other method in class */
        public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> mo4727get(int i) {
            return ImmutableMultiset.this.getEntry(i);
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.mo4975elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }
    }

    /* loaded from: classes3.dex */
    public static class EntrySetSerializedForm<E> implements Serializable {
        public final ImmutableMultiset<E> multiset;

        public EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        public Object readResolve() {
            return this.multiset.mo4575entrySet();
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> extends ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> {
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public C2312kx<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2312kx<>(i);
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public /* bridge */ /* synthetic */ ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            return mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableCollection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(E e) {
            return mo4626Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) e, 1);
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(E... eArr) {
            for (E e : eArr) {
                mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) e);
            }
            return this;
        }

        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> mo4626Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(E e, int i) {
            if (i == 0) {
                return this;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2312kx<>((C2312kx<? extends E>) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            if (e == null) {
                throw null;
            }
            C2312kx<E> c2312kx = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2312kx<E>) e, c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e) + i);
            return this;
        }

        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        public ImmutableMultiset<E> mo4627Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            C2312kx<E> c2312kx = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                return ImmutableMultiset.m3888of();
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2312kx<>((C2312kx<? extends E>) c2312kx);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            return new RegularImmutableMultiset(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2239iy<E> {
        public final /* synthetic */ Iterator Wwwwwwwwwwwwwwwwwwwwww;
        public E Wwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ImmutableMultiset immutableMultiset, Iterator it) {
            this.Wwwwwwwwwwwwwwwwwwwwww = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww > 0 || this.Wwwwwwwwwwwwwwwwwwwwww.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww <= 0) {
                AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwww.next();
                this.Wwwwwwwwwwwwwwwwwwwwwww = (E) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getElement();
                this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww--;
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    public static <E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> builder() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(4);
    }

    public static <E> ImmutableMultiset<E> copyFromElements(E... eArr) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        for (E e : eArr) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) e);
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4627Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? extends E>> collection) {
        C2312kx c2312kx = new C2312kx(collection.size());
        boolean z = false;
        while (true) {
            for (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? extends E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : collection) {
                E element = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getElement();
                int count = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount();
                if (count != 0) {
                    if (0 != 0) {
                        c2312kx = new C2312kx(c2312kx);
                        z = false;
                    }
                    if (element == null) {
                        throw null;
                    }
                    c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2312kx) element, c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(element) + count);
                }
            }
            if (c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                return m3888of();
            }
            if (z) {
                c2312kx = new C2312kx(c2312kx);
            }
            return new RegularImmutableMultiset(c2312kx);
        }
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable));
        if (iterable instanceof AbstractC2090ex) {
            AbstractC2090ex abstractC2090ex = (AbstractC2090ex) iterable;
            C2312kx<E> c2312kx = abstractC2090ex instanceof RegularImmutableMultiset ? ((RegularImmutableMultiset) abstractC2090ex).contents : abstractC2090ex instanceof AbstractMapBasedMultiset ? ((AbstractMapBasedMultiset) abstractC2090ex).backingMap : null;
            if (c2312kx != null) {
                C2312kx<E> c2312kx2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2312kx2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Math.max(c2312kx2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                for (int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 >= 0; Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4626Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2), c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
                }
            } else {
                Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> mo4575entrySet = abstractC2090ex.mo4575entrySet();
                C2312kx<E> c2312kx3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2312kx3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Math.max(c2312kx3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, mo4575entrySet.size()));
                for (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : abstractC2090ex.mo4575entrySet()) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4626Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getElement(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount());
                }
            }
        } else {
            for (E e : iterable) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) e);
            }
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4627Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return copyFromElements(eArr);
    }

    private ImmutableSet<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> createEntrySet() {
        return isEmpty() ? ImmutableSet.m3877of() : new EntrySet(this, null);
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m3888of() {
        return RegularImmutableMultiset.EMPTY;
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m3887of(E e) {
        return copyFromElements(e);
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m3886of(E e, E e2) {
        return copyFromElements(e, e2);
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m3885of(E e, E e2, E e3) {
        return copyFromElements(e, e2, e3);
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m3884of(E e, E e2, E e3, E e4) {
        return copyFromElements(e, e2, e3, e4);
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m3883of(E e, E e2, E e3, E e4, E e5) {
        return copyFromElements(e, e2, e3, e4, e5);
    }

    /* renamed from: of */
    public static <E> ImmutableMultiset<E> m3882of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4626Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) e, 1);
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) e2).mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) e3).mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) e4).mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) e5).mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>) e6).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) eArr).mo4627Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2090ex
    @Deprecated
    public final int add(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList == null) {
            ImmutableList<E> asList = super.asList();
            this.asList = asList;
            return asList;
        }
        return immutableList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i) {
        AbstractC2239iy<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> mo4735iterator = mo4575entrySet().mo4735iterator();
        while (mo4735iterator.hasNext()) {
            AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> next = mo4735iterator.next();
            Arrays.fill(objArr, i, next.getCount() + i, next.getElement());
            i += next.getCount();
        }
        return i;
    }

    @Override // me.tvspark.AbstractC2090ex
    /* renamed from: elementSet */
    public abstract ImmutableSet<E> mo4975elementSet();

    @Override // me.tvspark.AbstractC2090ex
    /* renamed from: entrySet */
    public ImmutableSet<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> mo4575entrySet() {
        ImmutableSet<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> immutableSet = this.entrySet;
        if (immutableSet == null) {
            ImmutableSet<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }
        return immutableSet;
    }

    @Override // java.util.Collection, me.tvspark.AbstractC2090ex
    public boolean equals(Object obj) {
        return C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2090ex<?>) this, obj);
    }

    public abstract AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> getEntry(int i);

    @Override // java.util.Collection, me.tvspark.AbstractC2090ex
    public int hashCode() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Set<?>) mo4575entrySet());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* renamed from: iterator  reason: collision with other method in class */
    public AbstractC2239iy<E> mo4735iterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, mo4575entrySet().mo4735iterator());
    }

    @Override // me.tvspark.AbstractC2090ex
    @Deprecated
    public final int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2090ex
    @Deprecated
    public final int setCount(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.AbstractC2090ex
    @Deprecated
    public final boolean setCount(E e, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return mo4575entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public abstract Object writeReplace();

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        while (it.hasNext()) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4629Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) it.next());
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4627Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}

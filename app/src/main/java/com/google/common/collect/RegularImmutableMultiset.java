package com.google.common.collect;

import java.io.Serializable;
import me.tvspark.AbstractC2090ex;
import me.tvspark.C2312kx;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    public static final RegularImmutableMultiset<Object> EMPTY = new RegularImmutableMultiset<>(new C2312kx());
    public final transient C2312kx<E> contents;
    public transient ImmutableSet<E> elementSet;
    public final transient int size;

    /* loaded from: classes3.dex */
    public final class ElementSet extends IndexedImmutableSet<E> {
        public ElementSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        /* renamed from: get */
        public E mo4727get(int i) {
            C2312kx<E> c2312kx = RegularImmutableMultiset.this.contents;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return (E) c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableMultiset.this.contents.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public static class SerializedForm implements Serializable {
        public static final long serialVersionUID = 0;
        public final int[] counts;
        public final Object[] elements;

        public SerializedForm(AbstractC2090ex<?> abstractC2090ex) {
            int size = abstractC2090ex.mo4575entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i = 0;
            for (AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : abstractC2090ex.mo4575entrySet()) {
                this.elements[i] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getElement();
                this.counts[i] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCount();
                i++;
            }
        }

        public Object readResolve() {
            C2312kx c2312kx = new C2312kx(this.elements.length);
            int i = 0;
            boolean z = false;
            boolean z2 = false;
            while (true) {
                Object[] objArr = this.elements;
                if (i >= objArr.length) {
                    if (c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                        return ImmutableMultiset.m3888of();
                    }
                    if (z) {
                        c2312kx = new C2312kx(c2312kx);
                    }
                    return new RegularImmutableMultiset(c2312kx);
                }
                Object obj = objArr[i];
                int i2 = this.counts[i];
                if (i2 != 0) {
                    if (z2) {
                        c2312kx = new C2312kx(c2312kx);
                        z = false;
                    }
                    if (obj == null) {
                        throw null;
                    }
                    c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2312kx) obj, c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj) + i2);
                    z2 = false;
                }
                i++;
            }
        }
    }

    public RegularImmutableMultiset(C2312kx<E> c2312kx) {
        this.contents = c2312kx;
        long j = 0;
        for (int i = 0; i < c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i++) {
            j += c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
        this.size = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
    }

    @Override // me.tvspark.AbstractC2090ex
    public int count(Object obj) {
        return this.contents.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
    }

    @Override // com.google.common.collect.ImmutableMultiset, me.tvspark.AbstractC2090ex
    /* renamed from: elementSet */
    public ImmutableSet<E> mo4975elementSet() {
        ImmutableSet<E> immutableSet = this.elementSet;
        if (immutableSet == null) {
            ElementSet elementSet = new ElementSet();
            this.elementSet = elementSet;
            return elementSet;
        }
        return immutableSet;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> getEntry(int i) {
        C2312kx<E> c2312kx = this.contents;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, c2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return new C2312kx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, me.tvspark.AbstractC2090ex
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }
}

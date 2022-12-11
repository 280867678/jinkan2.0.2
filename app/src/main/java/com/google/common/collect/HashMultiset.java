package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import me.tvspark.C2312kx;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class HashMultiset<E> extends AbstractMapBasedMultiset<E> {
    public static final long serialVersionUID = 0;

    public HashMultiset(int i) {
        super(i);
    }

    public static <E> HashMultiset<E> create() {
        return create(3);
    }

    public static <E> HashMultiset<E> create(int i) {
        return new HashMultiset<>(i);
    }

    public static <E> HashMultiset<E> create(Iterable<? extends E> iterable) {
        HashMultiset<E> create = create(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable));
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) create, (Iterable) iterable);
        return create;
    }

    @Override // me.tvspark.AbstractC2346lu, java.util.AbstractCollection, java.util.Collection, me.tvspark.AbstractC2090ex
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    /* renamed from: elementSet */
    public /* bridge */ /* synthetic */ Set mo4975elementSet() {
        return super.mo4975elementSet();
    }

    @Override // me.tvspark.AbstractC2346lu, me.tvspark.AbstractC2090ex
    /* renamed from: entrySet */
    public /* bridge */ /* synthetic */ Set mo4575entrySet() {
        return super.mo4575entrySet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset
    public void init(int i) {
        this.backingMap = new C2312kx<>(i);
    }

    @Override // me.tvspark.AbstractC2346lu, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }
}

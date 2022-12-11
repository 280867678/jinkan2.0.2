package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import me.tvspark.C2349lx;
import me.tvspark.C2763wu;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class LinkedHashMultiset<E> extends AbstractMapBasedMultiset<E> {
    public LinkedHashMultiset(int i) {
        super(i);
    }

    public static <E> LinkedHashMultiset<E> create() {
        return create(3);
    }

    public static <E> LinkedHashMultiset<E> create(int i) {
        return new LinkedHashMultiset<>(i);
    }

    public static <E> LinkedHashMultiset<E> create(Iterable<? extends E> iterable) {
        LinkedHashMultiset<E> create = create(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable));
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
        this.backingMap = new C2349lx(i);
    }

    @Override // me.tvspark.AbstractC2346lu, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }
}

package me.tvspark;

import com.google.common.collect.BoundType;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import me.tvspark.AbstractC2090ex;

/* renamed from: me.tvspark.wx */
/* loaded from: classes4.dex */
public interface AbstractC2766wx<E> extends AbstractC2803xx<E>, AbstractC2689ux<E> {
    Comparator<? super E> comparator();

    /* renamed from: descendingMultiset */
    AbstractC2766wx<E> mo4619descendingMultiset();

    @Override // me.tvspark.AbstractC2090ex
    /* renamed from: elementSet */
    NavigableSet<E> mo4975elementSet();

    @Override // me.tvspark.AbstractC2090ex
    /* renamed from: entrySet */
    Set<AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E>> mo4575entrySet();

    AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> firstEntry();

    /* renamed from: headMultiset */
    AbstractC2766wx<E> mo4721headMultiset(E e, BoundType boundType);

    AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> lastEntry();

    AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> pollFirstEntry();

    AbstractC2090ex.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<E> pollLastEntry();

    /* renamed from: subMultiset */
    AbstractC2766wx<E> mo4623subMultiset(E e, BoundType boundType, E e2, BoundType boundType2);

    /* renamed from: tailMultiset */
    AbstractC2766wx<E> mo4722tailMultiset(E e, BoundType boundType);
}

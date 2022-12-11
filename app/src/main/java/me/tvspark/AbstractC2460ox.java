package me.tvspark;

import com.google.common.collect.Range;
import java.lang.Comparable;
import java.util.Set;

/* renamed from: me.tvspark.ox */
/* loaded from: classes4.dex */
public interface AbstractC2460ox<C extends Comparable> {
    /* renamed from: asRanges */
    Set<Range<C>> mo4585asRanges();

    /* renamed from: complement */
    AbstractC2460ox<C> mo4586complement();

    boolean encloses(Range<C> range);

    boolean isEmpty();

    void removeAll(AbstractC2460ox<C> abstractC2460ox);
}

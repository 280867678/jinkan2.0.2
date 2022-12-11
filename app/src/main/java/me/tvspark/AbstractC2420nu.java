package me.tvspark;

import com.google.common.collect.Range;
import java.lang.Comparable;

/* renamed from: me.tvspark.nu */
/* loaded from: classes4.dex */
public abstract class AbstractC2420nu<C extends Comparable> implements AbstractC2460ox<C> {
    public abstract void add(Range<C> range);

    public void addAll(Iterable<Range<C>> iterable) {
        for (Range<C> range : iterable) {
            add(range);
        }
    }

    public void addAll(AbstractC2460ox<C> abstractC2460ox) {
        addAll(abstractC2460ox.mo4585asRanges());
    }

    public void clear() {
        remove(Range.all());
    }

    public boolean contains(C c) {
        return rangeContaining(c) != null;
    }

    @Override // me.tvspark.AbstractC2460ox
    public abstract boolean encloses(Range<C> range);

    public boolean enclosesAll(Iterable<Range<C>> iterable) {
        for (Range<C> range : iterable) {
            if (!encloses(range)) {
                return false;
            }
        }
        return true;
    }

    public boolean enclosesAll(AbstractC2460ox<C> abstractC2460ox) {
        return enclosesAll(abstractC2460ox.mo4585asRanges());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2460ox)) {
            return false;
        }
        return mo4585asRanges().equals(((AbstractC2460ox) obj).mo4585asRanges());
    }

    public final int hashCode() {
        return mo4585asRanges().hashCode();
    }

    public abstract boolean intersects(Range<C> range);

    @Override // me.tvspark.AbstractC2460ox
    public boolean isEmpty() {
        return mo4585asRanges().isEmpty();
    }

    public abstract Range<C> rangeContaining(C c);

    public abstract void remove(Range<C> range);

    public void removeAll(Iterable<Range<C>> iterable) {
        for (Range<C> range : iterable) {
            remove(range);
        }
    }

    @Override // me.tvspark.AbstractC2460ox
    public void removeAll(AbstractC2460ox<C> abstractC2460ox) {
        removeAll(abstractC2460ox.mo4585asRanges());
    }

    public final String toString() {
        return mo4585asRanges().toString();
    }
}

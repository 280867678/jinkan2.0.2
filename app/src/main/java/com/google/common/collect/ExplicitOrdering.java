package com.google.common.collect;

import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import me.tvspark.C2763wu;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    public static final long serialVersionUID = 0;
    public final ImmutableMap<T, Integer> rankMap;

    public ExplicitOrdering(ImmutableMap<T, Integer> immutableMap) {
        this.rankMap = immutableMap;
    }

    public ExplicitOrdering(List<T> list) {
        this(C2763wu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) list));
    }

    private int rank(T t) {
        Integer mo4554get = this.rankMap.mo4554get(t);
        if (mo4554get != null) {
            return mo4554get.intValue();
        }
        throw new Ordering.IncomparableValueException(t);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t, T t2) {
        return rank(t) - rank(t2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj instanceof ExplicitOrdering) {
            return this.rankMap.equals(((ExplicitOrdering) obj).rankMap);
        }
        return false;
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Ordering.explicit(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.rankMap.mo4552keySet());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

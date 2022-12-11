package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import me.tvspark.AbstractC2271jt;

/* loaded from: classes3.dex */
public final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    public static final long serialVersionUID = 0;
    public final AbstractC2271jt<F, ? extends T> function;
    public final Ordering<T> ordering;

    public ByFunctionOrdering(AbstractC2271jt<F, ? extends T> abstractC2271jt, Ordering<T> ordering) {
        if (abstractC2271jt != null) {
            this.function = abstractC2271jt;
            if (ordering == null) {
                throw null;
            }
            this.ordering = ordering;
            return;
        }
        throw null;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(F f, F f2) {
        return this.ordering.compare(this.function.mo4462apply(f), this.function.mo4462apply(f2));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByFunctionOrdering)) {
            return false;
        }
        ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
        return this.function.equals(byFunctionOrdering.function) && this.ordering.equals(byFunctionOrdering.ordering);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.function, this.ordering});
    }

    public String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }
}

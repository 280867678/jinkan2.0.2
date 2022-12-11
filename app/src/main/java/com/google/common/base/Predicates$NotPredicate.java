package com.google.common.base;

import java.io.Serializable;
import me.tvspark.AbstractC2573rt;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Predicates$NotPredicate<T> implements AbstractC2573rt<T>, Serializable {
    public static final long serialVersionUID = 0;
    public final AbstractC2573rt<T> predicate;

    public Predicates$NotPredicate(AbstractC2573rt<T> abstractC2573rt) {
        if (abstractC2573rt != null) {
            this.predicate = abstractC2573rt;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean apply(T t) {
        return !this.predicate.apply(t);
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean equals(Object obj) {
        if (obj instanceof Predicates$NotPredicate) {
            return this.predicate.equals(((Predicates$NotPredicate) obj).predicate);
        }
        return false;
    }

    public int hashCode() {
        return ~this.predicate.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Predicates.not(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.predicate);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

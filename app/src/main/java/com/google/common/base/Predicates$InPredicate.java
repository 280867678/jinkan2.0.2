package com.google.common.base;

import java.io.Serializable;
import java.util.Collection;
import me.tvspark.AbstractC2573rt;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Predicates$InPredicate<T> implements AbstractC2573rt<T>, Serializable {
    public static final long serialVersionUID = 0;
    public final Collection<?> target;

    public Predicates$InPredicate(Collection<?> collection) {
        if (collection != null) {
            this.target = collection;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean apply(T t) {
        try {
            return this.target.contains(t);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean equals(Object obj) {
        if (obj instanceof Predicates$InPredicate) {
            return this.target.equals(((Predicates$InPredicate) obj).target);
        }
        return false;
    }

    public int hashCode() {
        return this.target.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Predicates.in(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.target);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

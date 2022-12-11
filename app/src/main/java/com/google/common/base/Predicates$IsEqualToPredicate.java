package com.google.common.base;

import java.io.Serializable;
import me.tvspark.AbstractC2573rt;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Predicates$IsEqualToPredicate<T> implements AbstractC2573rt<T>, Serializable {
    public static final long serialVersionUID = 0;
    public final T target;

    public Predicates$IsEqualToPredicate(T t) {
        this.target = t;
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean apply(T t) {
        return this.target.equals(t);
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean equals(Object obj) {
        if (obj instanceof Predicates$IsEqualToPredicate) {
            return this.target.equals(((Predicates$IsEqualToPredicate) obj).target);
        }
        return false;
    }

    public int hashCode() {
        return this.target.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Predicates.equalTo(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.target);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

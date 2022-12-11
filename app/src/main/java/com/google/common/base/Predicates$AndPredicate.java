package com.google.common.base;

import java.io.Serializable;
import java.util.List;
import me.tvspark.AbstractC2573rt;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class Predicates$AndPredicate<T> implements AbstractC2573rt<T>, Serializable {
    public static final long serialVersionUID = 0;
    public final List<? extends AbstractC2573rt<? super T>> components;

    public Predicates$AndPredicate(List<? extends AbstractC2573rt<? super T>> list) {
        this.components = list;
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean apply(T t) {
        for (int i = 0; i < this.components.size(); i++) {
            if (!this.components.get(i).apply(t)) {
                return false;
            }
        }
        return true;
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean equals(Object obj) {
        if (obj instanceof Predicates$AndPredicate) {
            return this.components.equals(((Predicates$AndPredicate) obj).components);
        }
        return false;
    }

    public int hashCode() {
        return this.components.hashCode() + 306654252;
    }

    public String toString() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("and", (Iterable) this.components);
    }
}

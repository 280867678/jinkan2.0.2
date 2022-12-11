package com.google.common.base;

import java.io.Serializable;
import me.tvspark.AbstractC2573rt;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Predicates$SubtypeOfPredicate implements AbstractC2573rt<Class<?>>, Serializable {
    public static final long serialVersionUID = 0;
    public final Class<?> clazz;

    public Predicates$SubtypeOfPredicate(Class<?> cls) {
        if (cls != null) {
            this.clazz = cls;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean apply(Class<?> cls) {
        return this.clazz.isAssignableFrom(cls);
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean equals(Object obj) {
        return (obj instanceof Predicates$SubtypeOfPredicate) && this.clazz == ((Predicates$SubtypeOfPredicate) obj).clazz;
    }

    public int hashCode() {
        return this.clazz.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Predicates.subtypeOf(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.clazz.getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

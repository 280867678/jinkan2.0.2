package com.google.common.base;

import java.io.Serializable;
import me.tvspark.AbstractC2573rt;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Predicates$InstanceOfPredicate implements AbstractC2573rt<Object>, Serializable {
    public static final long serialVersionUID = 0;
    public final Class<?> clazz;

    public Predicates$InstanceOfPredicate(Class<?> cls) {
        if (cls != null) {
            this.clazz = cls;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean apply(Object obj) {
        return this.clazz.isInstance(obj);
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean equals(Object obj) {
        return (obj instanceof Predicates$InstanceOfPredicate) && this.clazz == ((Predicates$InstanceOfPredicate) obj).clazz;
    }

    public int hashCode() {
        return this.clazz.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Predicates.instanceOf(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.clazz.getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

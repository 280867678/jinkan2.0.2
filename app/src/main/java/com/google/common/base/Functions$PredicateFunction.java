package com.google.common.base;

import java.io.Serializable;
import me.tvspark.AbstractC2271jt;
import me.tvspark.AbstractC2573rt;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Functions$PredicateFunction<T> implements AbstractC2271jt<T, Boolean>, Serializable {
    public static final long serialVersionUID = 0;
    public final AbstractC2573rt<T> predicate;

    public Functions$PredicateFunction(AbstractC2573rt<T> abstractC2573rt) {
        if (abstractC2573rt != null) {
            this.predicate = abstractC2573rt;
            return;
        }
        throw null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.tvspark.AbstractC2271jt
    /* renamed from: apply */
    public Boolean mo4462apply(T t) {
        return Boolean.valueOf(this.predicate.apply(t));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2271jt
    /* renamed from: apply  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Boolean mo4462apply(Object obj) {
        return mo4462apply((Functions$PredicateFunction<T>) obj);
    }

    @Override // me.tvspark.AbstractC2271jt
    public boolean equals(Object obj) {
        if (obj instanceof Functions$PredicateFunction) {
            return this.predicate.equals(((Functions$PredicateFunction) obj).predicate);
        }
        return false;
    }

    public int hashCode() {
        return this.predicate.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Functions.forPredicate(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.predicate);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

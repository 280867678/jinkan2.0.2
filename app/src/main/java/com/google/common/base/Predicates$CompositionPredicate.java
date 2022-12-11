package com.google.common.base;

import java.io.Serializable;
import me.tvspark.AbstractC2271jt;
import me.tvspark.AbstractC2573rt;

/* loaded from: classes3.dex */
public class Predicates$CompositionPredicate<A, B> implements AbstractC2573rt<A>, Serializable {
    public static final long serialVersionUID = 0;

    /* renamed from: f */
    public final AbstractC2271jt<A, ? extends B> f583f;

    /* renamed from: p */
    public final AbstractC2573rt<B> f584p;

    public Predicates$CompositionPredicate(AbstractC2573rt<B> abstractC2573rt, AbstractC2271jt<A, ? extends B> abstractC2271jt) {
        if (abstractC2573rt != null) {
            this.f584p = abstractC2573rt;
            if (abstractC2271jt == null) {
                throw null;
            }
            this.f583f = abstractC2271jt;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean apply(A a) {
        return this.f584p.apply(this.f583f.mo4462apply(a));
    }

    @Override // me.tvspark.AbstractC2573rt
    public boolean equals(Object obj) {
        if (obj instanceof Predicates$CompositionPredicate) {
            Predicates$CompositionPredicate predicates$CompositionPredicate = (Predicates$CompositionPredicate) obj;
            return this.f583f.equals(predicates$CompositionPredicate.f583f) && this.f584p.equals(predicates$CompositionPredicate.f584p);
        }
        return false;
    }

    public int hashCode() {
        return this.f583f.hashCode() ^ this.f584p.hashCode();
    }

    public String toString() {
        return this.f584p + "(" + this.f583f + ")";
    }
}

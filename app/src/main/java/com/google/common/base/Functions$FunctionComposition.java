package com.google.common.base;

import java.io.Serializable;
import me.tvspark.AbstractC2271jt;

/* loaded from: classes3.dex */
public class Functions$FunctionComposition<A, B, C> implements AbstractC2271jt<A, C>, Serializable {
    public static final long serialVersionUID = 0;

    /* renamed from: f */
    public final AbstractC2271jt<A, ? extends B> f581f;

    /* renamed from: g */
    public final AbstractC2271jt<B, C> f582g;

    public Functions$FunctionComposition(AbstractC2271jt<B, C> abstractC2271jt, AbstractC2271jt<A, ? extends B> abstractC2271jt2) {
        if (abstractC2271jt != null) {
            this.f582g = abstractC2271jt;
            if (abstractC2271jt2 == null) {
                throw null;
            }
            this.f581f = abstractC2271jt2;
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2271jt
    /* renamed from: apply */
    public C mo4462apply(A a) {
        return this.f582g.mo4462apply(this.f581f.mo4462apply(a));
    }

    @Override // me.tvspark.AbstractC2271jt
    public boolean equals(Object obj) {
        if (obj instanceof Functions$FunctionComposition) {
            Functions$FunctionComposition functions$FunctionComposition = (Functions$FunctionComposition) obj;
            return this.f581f.equals(functions$FunctionComposition.f581f) && this.f582g.equals(functions$FunctionComposition.f582g);
        }
        return false;
    }

    public int hashCode() {
        return this.f581f.hashCode() ^ this.f582g.hashCode();
    }

    public String toString() {
        return this.f582g + "(" + this.f581f + ")";
    }
}

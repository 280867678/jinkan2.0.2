package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;
import me.tvspark.AbstractC2271jt;

/* loaded from: classes3.dex */
public final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    public static final long serialVersionUID = 0;
    public final AbstractC2271jt<F, ? extends T> function;
    public final Equivalence<T> resultEquivalence;

    public FunctionalEquivalence(AbstractC2271jt<F, ? extends T> abstractC2271jt, Equivalence<T> equivalence) {
        if (abstractC2271jt != null) {
            this.function = abstractC2271jt;
            if (equivalence == null) {
                throw null;
            }
            this.resultEquivalence = equivalence;
            return;
        }
        throw null;
    }

    @Override // com.google.common.base.Equivalence
    public boolean doEquivalent(F f, F f2) {
        return this.resultEquivalence.equivalent(this.function.mo4462apply(f), this.function.mo4462apply(f2));
    }

    @Override // com.google.common.base.Equivalence
    public int doHash(F f) {
        return this.resultEquivalence.hash(this.function.mo4462apply(f));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FunctionalEquivalence)) {
            return false;
        }
        FunctionalEquivalence functionalEquivalence = (FunctionalEquivalence) obj;
        return this.function.equals(functionalEquivalence.function) && this.resultEquivalence.equals(functionalEquivalence.resultEquivalence);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.function, this.resultEquivalence});
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }
}

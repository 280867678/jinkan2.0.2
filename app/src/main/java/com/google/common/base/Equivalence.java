package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;
import me.tvspark.AbstractC2271jt;
import me.tvspark.AbstractC2573rt;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class Equivalence<T> {

    /* loaded from: classes3.dex */
    public static final class Equals extends Equivalence<Object> implements Serializable {
        public static final Equals INSTANCE = new Equals();
        public static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object obj) {
            return obj.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    public static final class EquivalentToPredicate<T> implements AbstractC2573rt<T>, Serializable {
        public static final long serialVersionUID = 0;
        public final Equivalence<T> equivalence;
        public final T target;

        public EquivalentToPredicate(Equivalence<T> equivalence, T t) {
            if (equivalence != null) {
                this.equivalence = equivalence;
                this.target = t;
                return;
            }
            throw null;
        }

        @Override // me.tvspark.AbstractC2573rt
        public boolean apply(T t) {
            return this.equivalence.equivalent(t, this.target);
        }

        @Override // me.tvspark.AbstractC2573rt
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EquivalentToPredicate)) {
                return false;
            }
            EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate) obj;
            return this.equivalence.equals(equivalentToPredicate.equivalence) && Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.target, equivalentToPredicate.target);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.equivalence, this.target});
        }

        public String toString() {
            return this.equivalence + ".equivalentTo(" + this.target + ")";
        }
    }

    /* loaded from: classes3.dex */
    public static final class Identity extends Equivalence<Object> implements Serializable {
        public static final Identity INSTANCE = new Identity();
        public static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wrapper<T> implements Serializable {
        public static final long serialVersionUID = 0;
        public final Equivalence<? super T> equivalence;
        public final T reference;

        public Wrapper(Equivalence<? super T> equivalence, T t) {
            if (equivalence != null) {
                this.equivalence = equivalence;
                this.reference = t;
                return;
            }
            throw null;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wrapper)) {
                return false;
            }
            Wrapper wrapper = (Wrapper) obj;
            if (!this.equivalence.equals(wrapper.equivalence)) {
                return false;
            }
            return this.equivalence.equivalent((T) this.reference, (T) wrapper.reference);
        }

        public T get() {
            return this.reference;
        }

        public int hashCode() {
            return this.equivalence.hash((T) this.reference);
        }

        public String toString() {
            return this.equivalence + ".wrap(" + this.reference + ")";
        }
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    public abstract boolean doEquivalent(T t, T t2);

    public abstract int doHash(T t);

    public final boolean equivalent(T t, T t2) {
        if (t == t2) {
            return true;
        }
        if (t != null && t2 != null) {
            return doEquivalent(t, t2);
        }
        return false;
    }

    public final AbstractC2573rt<T> equivalentTo(T t) {
        return new EquivalentToPredicate(this, t);
    }

    public final int hash(T t) {
        if (t == null) {
            return 0;
        }
        return doHash(t);
    }

    public final <F> Equivalence<F> onResultOf(AbstractC2271jt<F, ? extends T> abstractC2271jt) {
        return new FunctionalEquivalence(abstractC2271jt, this);
    }

    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    public final <S extends T> Wrapper<S> wrap(S s) {
        return new Wrapper<>(s);
    }
}

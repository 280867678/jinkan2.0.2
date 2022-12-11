package com.google.common.base;

import java.util.Collections;
import java.util.Set;
import me.tvspark.AbstractC2271jt;
import me.tvspark.AbstractC2684ut;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class Absent<T> extends Optional<T> {
    public static final Absent<Object> INSTANCE = new Absent<>();
    public static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    public static <T> Optional<T> withType() {
        return INSTANCE;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.emptySet();
    }

    @Override // com.google.common.base.Optional
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return 2040732332;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Optional
    /* renamed from: or */
    public Optional<T> mo3932or(Optional<? extends T> optional) {
        if (optional != 0) {
            return optional;
        }
        throw null;
    }

    @Override // com.google.common.base.Optional
    /* renamed from: or */
    public T mo3931or(T t) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, "use Optional.orNull() instead of Optional.or(null)");
        return t;
    }

    @Override // com.google.common.base.Optional
    /* renamed from: or */
    public T mo3930or(AbstractC2684ut<? extends T> abstractC2684ut) {
        T mo4804get = abstractC2684ut.mo4804get();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4804get, "use Optional.orNull() instead of a Supplier that returns null");
        return mo4804get;
    }

    @Override // com.google.common.base.Optional
    public T orNull() {
        return null;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(AbstractC2271jt<? super T, V> abstractC2271jt) {
        if (abstractC2271jt != null) {
            return Optional.absent();
        }
        throw null;
    }
}

package com.google.common.base;

import java.util.Collections;
import java.util.Set;
import me.tvspark.AbstractC2271jt;
import me.tvspark.AbstractC2684ut;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class Present<T> extends Optional<T> {
    public static final long serialVersionUID = 0;
    public final T reference;

    public Present(T t) {
        this.reference = t;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.singleton(this.reference);
    }

    @Override // com.google.common.base.Optional
    public boolean equals(Object obj) {
        if (obj instanceof Present) {
            return this.reference.equals(((Present) obj).reference);
        }
        return false;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // com.google.common.base.Optional
    /* renamed from: or */
    public Optional<T> mo3932or(Optional<? extends T> optional) {
        if (optional != null) {
            return this;
        }
        throw null;
    }

    @Override // com.google.common.base.Optional
    /* renamed from: or */
    public T mo3931or(T t) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public T orNull() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Optional.of(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.reference);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(AbstractC2271jt<? super T, V> abstractC2271jt) {
        V mo4462apply = abstractC2271jt.mo4462apply((T) this.reference);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4462apply, "the Function passed to Optional.transform() must not return null.");
        return new Present(mo4462apply);
    }

    @Override // com.google.common.base.Optional
    /* renamed from: or */
    public T mo3930or(AbstractC2684ut<? extends T> abstractC2684ut) {
        if (abstractC2684ut != null) {
            return this.reference;
        }
        throw null;
    }
}

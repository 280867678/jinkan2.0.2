package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import me.tvspark.AbstractC2271jt;
import me.tvspark.AbstractC2684ut;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class Optional<T> implements Serializable {
    public static final long serialVersionUID = 0;

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterable<T> {
        public final /* synthetic */ Iterable Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: com.google.common.base.Optional$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C3453Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractIterator<T> {
            public final Iterator<? extends Optional<? extends T>> Wwwwwwwwwwwwwwwwwwwwww;

            public C3453Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                Iterator it = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it);
                this.Wwwwwwwwwwwwwwwwwwwwww = (Iterator<T>) it;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable iterable) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new C3453Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromNullable(T t) {
        return t == null ? absent() : new Present(t);
    }

    /* renamed from: of */
    public static <T> Optional<T> m3933of(T t) {
        if (t != null) {
            return new Present(t);
        }
        throw null;
    }

    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        if (iterable != null) {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable);
        }
        throw null;
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    /* renamed from: or */
    public abstract Optional<T> mo3932or(Optional<? extends T> optional);

    /* renamed from: or */
    public abstract T mo3931or(T t);

    /* renamed from: or */
    public abstract T mo3930or(AbstractC2684ut<? extends T> abstractC2684ut);

    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(AbstractC2271jt<? super T, V> abstractC2271jt);
}

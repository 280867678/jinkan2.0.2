package me.tvspark;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;

/* renamed from: me.tvspark.bv */
/* loaded from: classes4.dex */
public abstract class AbstractC1960bv<E> implements Iterable<E> {
    public final Optional<Iterable<E>> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.bv$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC1960bv<E> {
        public final /* synthetic */ Iterable Wwwwwwwwwwwwwwwwwwwwwww;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable iterable, Iterable iterable2) {
            super(iterable);
            this.Wwwwwwwwwwwwwwwwwwwwwww = iterable2;
        }

        @Override // java.lang.Iterable
        public Iterator<E> iterator() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.iterator();
        }
    }

    public AbstractC1960bv() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = Optional.absent();
    }

    public AbstractC1960bv(Iterable<E> iterable) {
        if (iterable != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = Optional.fromNullable(this == iterable ? null : iterable);
            return;
        }
        throw null;
    }

    public static <E> AbstractC1960bv<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Iterable<E> iterable) {
        return iterable instanceof AbstractC1960bv ? (AbstractC1960bv) iterable : new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iterable, iterable);
    }

    public final ImmutableSet<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return ImmutableSet.copyOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public final Iterable<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.mo3931or((Optional<Iterable<E>>) this);
    }

    public final AbstractC1960bv<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2573rt<? super E> abstractC2573rt) {
        Iterable<E> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            if (abstractC2573rt != null) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2575rv(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, abstractC2573rt));
            }
            throw null;
        }
        throw null;
    }

    public String toString() {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterable<?>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }
}

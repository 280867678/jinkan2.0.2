package me.tvspark;

import java.util.Iterator;

@ef0
/* loaded from: classes4.dex */
public final class dk0<T, R> implements zj0<R> {
    public final ih0<T, R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final zj0<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<R>, pi0 {
        public final Iterator<T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = dk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return dk0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4916invoke(this.Wwwwwwwwwwwwwwwwwwwwwwww.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public dk0(zj0<? extends T> zj0Var, ih0<? super T, ? extends R> ih0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zj0Var, "sequence");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ih0Var, "transformer");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = zj0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ih0Var;
    }

    @Override // me.tvspark.zj0
    public Iterator<R> iterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}

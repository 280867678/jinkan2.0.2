package me.tvspark;

import java.util.Iterator;
import java.util.NoSuchElementException;

@ef0
/* loaded from: classes4.dex */
public final class yj0<T> implements zj0<T> {
    public final ih0<T, T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final xg0<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Iterator<T>, pi0 {
        public int Wwwwwwwwwwwwwwwwwwwwwww = -2;
        public T Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            T mo4916invoke;
            if (this.Wwwwwwwwwwwwwwwwwwwwwww == -2) {
                mo4916invoke = yj0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4969invoke();
            } else {
                ih0<T, T> ih0Var = yj0.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                T t = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t);
                mo4916invoke = ih0Var.mo4916invoke(t);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = mo4916invoke;
            this.Wwwwwwwwwwwwwwwwwwwwwww = mo4916invoke == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww < 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwww == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww < 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwww != 0) {
                T t = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (t == null) {
                    throw new NullPointerException("null cannot be cast to non-null type T");
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww = -1;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public yj0(xg0<? extends T> xg0Var, ih0<? super T, ? extends T> ih0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xg0Var, "getInitialValue");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ih0Var, "getNextValue");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = xg0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ih0Var;
    }

    @Override // me.tvspark.zj0
    public Iterator<T> iterator() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}

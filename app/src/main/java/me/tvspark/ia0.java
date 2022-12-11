package me.tvspark;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class ia0<T> extends d60<T> {
    public final Iterable<? extends T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> extends v70<T> {
        public boolean Wwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwww;
        public volatile boolean Wwwwwwwwwwwwwwwwwwwwww;
        public final Iterator<? extends T> Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var, Iterator<? extends T> it) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = it;
        }

        @Override // me.tvspark.t70
        public void clear() {
            this.Wwwwwwwwwwwwwwwwwwww = true;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwwwww = true;
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.t70
        public boolean isEmpty() {
            return this.Wwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.t70
        /* renamed from: poll */
        public T mo4868poll() {
            if (this.Wwwwwwwwwwwwwwwwwwww) {
                return null;
            }
            if (!this.Wwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwww = true;
            } else if (!this.Wwwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                this.Wwwwwwwwwwwwwwwwwwww = true;
                return null;
            }
            T next = this.Wwwwwwwwwwwwwwwwwwwwwww.next();
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) next, "The iterator returned a null value");
            return next;
        }

        @Override // me.tvspark.p70
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                this.Wwwwwwwwwwwwwwwwwwwww = true;
                return 1;
            }
            return 0;
        }
    }

    public ia0(Iterable<? extends T> iterable) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = iterable;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        try {
            Iterator<? extends T> it = this.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
            if (!it.hasNext()) {
                EmptyDisposable.complete(j60Var);
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, it);
            j60Var.onSubscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            while (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww) {
                try {
                    T next = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.next();
                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) next, "The iterator returned a null value");
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(next);
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww) {
                        return;
                    }
                    if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww) {
                            return;
                        }
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
                        return;
                    }
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
                    return;
                }
            }
        } catch (Throwable th2) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            EmptyDisposable.error(th2, j60Var);
        }
    }
}

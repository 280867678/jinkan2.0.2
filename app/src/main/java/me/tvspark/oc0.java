package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class oc0<T, U, V> extends d60<V> {
    public final t60<? super T, ? super U, ? extends V> Wwwwwwwwwwwwwwwwwwwwww;
    public final Iterable<U> Wwwwwwwwwwwwwwwwwwwwwww;
    public final d60<? extends T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U, V> implements j60<T>, p60 {
        public boolean Wwwwwwwwwwwwwwwwwwww;
        public p60 Wwwwwwwwwwwwwwwwwwwww;
        public final t60<? super T, ? super U, ? extends V> Wwwwwwwwwwwwwwwwwwwwww;
        public final Iterator<U> Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super V> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super V> j60Var, Iterator<U> it, t60<? super T, ? super U, ? extends V> t60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = it;
            this.Wwwwwwwwwwwwwwwwwwwwww = t60Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwwww.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwww.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.Wwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.Wwwwwwwwwwwwwwwwwwww) {
                return;
            }
            try {
                U next = this.Wwwwwwwwwwwwwwwwwwwwwww.next();
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next, "The iterator returned a null value");
                try {
                    V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, next);
                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "The zipper function returned a null value");
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    try {
                        if (this.Wwwwwwwwwwwwwwwwwwwwwww.hasNext()) {
                            return;
                        }
                        this.Wwwwwwwwwwwwwwwwwwww = true;
                        this.Wwwwwwwwwwwwwwwwwwwww.dispose();
                        this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
                    } catch (Throwable th) {
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                        this.Wwwwwwwwwwwwwwwwwwww = true;
                        this.Wwwwwwwwwwwwwwwwwwwww.dispose();
                        this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
                    }
                } catch (Throwable th2) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                    this.Wwwwwwwwwwwwwwwwwwww = true;
                    this.Wwwwwwwwwwwwwwwwwwwww.dispose();
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th2);
                }
            } catch (Throwable th3) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th3);
                this.Wwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwww.dispose();
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th3);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
            }
        }
    }

    public oc0(d60<? extends T> d60Var, Iterable<U> iterable, t60<? super T, ? super U, ? extends V> t60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = d60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = iterable;
        this.Wwwwwwwwwwwwwwwwwwwwww = t60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super V> j60Var) {
        try {
            Iterator<U> it = this.Wwwwwwwwwwwwwwwwwwwwwww.iterator();
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it, "The iterator returned by other is null");
            Iterator<U> it2 = it;
            try {
                if (!it2.hasNext()) {
                    EmptyDisposable.complete(j60Var);
                } else {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, it2, this.Wwwwwwwwwwwwwwwwwwwwww));
                }
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                EmptyDisposable.error(th, j60Var);
            }
        } catch (Throwable th2) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            EmptyDisposable.error(th2, j60Var);
        }
    }
}

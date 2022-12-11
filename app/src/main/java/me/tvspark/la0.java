package me.tvspark;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class la0<T, S> extends d60<T> {
    public final x60<? super S> Wwwwwwwwwwwwwwwwwwwwww;
    public final t60<S, w50<T>, S> Wwwwwwwwwwwwwwwwwwwwwww;
    public final Callable<S> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, S> implements w50<T>, p60 {
        public boolean Wwwwwwwwwwwwwwwwwww;
        public volatile boolean Wwwwwwwwwwwwwwwwwwww;
        public S Wwwwwwwwwwwwwwwwwwwww;
        public final x60<? super S> Wwwwwwwwwwwwwwwwwwwwww;
        public final t60<S, ? super w50<T>, S> Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var, t60<S, ? super w50<T>, S> t60Var, x60<? super S> x60Var, S s) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = t60Var;
            this.Wwwwwwwwwwwwwwwwwwwwww = x60Var;
            this.Wwwwwwwwwwwwwwwwwwwww = s;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(S s) {
            try {
                this.Wwwwwwwwwwwwwwwwwwwwww.accept(s);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            }
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwww = true;
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.w50
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.w50
        public void onError(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.Wwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.w50
        public void onNext(T t) {
            if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                this.Wwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(nullPointerException);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
        }
    }

    public la0(Callable<S> callable, t60<S, w50<T>, S> t60Var, x60<? super S> x60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = callable;
        this.Wwwwwwwwwwwwwwwwwwwwwww = t60Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = x60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.call());
            j60Var.onSubscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            S s = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
            if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww) {
                t60<S, ? super w50<T>, S> t60Var = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
                while (true) {
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww) {
                        break;
                    }
                    try {
                        s = t60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = true;
                            break;
                        }
                    } catch (Throwable th) {
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = null;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = true;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
                        return;
                    }
                }
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = null;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s);
        } catch (Throwable th2) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            EmptyDisposable.error(th2, j60Var);
        }
    }
}

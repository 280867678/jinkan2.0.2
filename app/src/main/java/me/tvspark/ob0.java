package me.tvspark;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;

/* loaded from: classes4.dex */
public final class ob0<T> extends x80<T, T> {
    public final boolean Wwwwwwwwwwwwwwwwwwwwww;
    public final f70<? super Throwable, ? extends h60<? extends T>> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<T> {
        public boolean Wwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwww;
        public final SequentialDisposable Wwwwwwwwwwwwwwwwwwwww = new SequentialDisposable();
        public final boolean Wwwwwwwwwwwwwwwwwwwwww;
        public final f70<? super Throwable, ? extends h60<? extends T>> Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var, f70<? super Throwable, ? extends h60<? extends T>> f70Var, boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
            this.Wwwwwwwwwwwwwwwwwwwwww = z;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.Wwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwwwww) {
                if (this.Wwwwwwwwwwwwwwwwwww) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    return;
                } else {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
                    return;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwww = true;
            if (this.Wwwwwwwwwwwwwwwwwwwwww && !(th instanceof Exception)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
                return;
            }
            try {
                h60<? extends T> apply = this.Wwwwwwwwwwwwwwwwwwwwwww.apply(th);
                if (apply != null) {
                    apply.subscribe(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Observable is null");
                nullPointerException.initCause(th);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(nullPointerException);
            } catch (Throwable th2) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(new CompositeException(th, th2));
            }
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.Wwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            this.Wwwwwwwwwwwwwwwwwwwww.replace(p60Var);
        }
    }

    public ob0(h60<T> h60Var, f70<? super Throwable, ? extends h60<? extends T>> f70Var, boolean z) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww);
        j60Var.onSubscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}

package me.tvspark;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes4.dex */
public final class w90<T> extends x80<T, T> {
    public final r60 Wwwwwwwwwwwwwwwwwwww;
    public final r60 Wwwwwwwwwwwwwwwwwwwww;
    public final x60<? super Throwable> Wwwwwwwwwwwwwwwwwwwwww;
    public final x60<? super T> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<T>, p60 {
        public boolean Wwwwwwwwwwwwwwwwww;
        public p60 Wwwwwwwwwwwwwwwwwww;
        public final r60 Wwwwwwwwwwwwwwwwwwww;
        public final r60 Wwwwwwwwwwwwwwwwwwwww;
        public final x60<? super Throwable> Wwwwwwwwwwwwwwwwwwwwww;
        public final x60<? super T> Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var, x60<? super T> x60Var, x60<? super Throwable> x60Var2, r60 r60Var, r60 r60Var2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = x60Var;
            this.Wwwwwwwwwwwwwwwwwwwwww = x60Var2;
            this.Wwwwwwwwwwwwwwwwwwwww = r60Var;
            this.Wwwwwwwwwwwwwwwwwwww = r60Var2;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwww.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwww.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.Wwwwwwwwwwwwwwwwww) {
                return;
            }
            try {
                this.Wwwwwwwwwwwwwwwwwwwww.run();
                this.Wwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
                try {
                    this.Wwwwwwwwwwwwwwwwwwww.run();
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                }
            } catch (Throwable th2) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                onError(th2);
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwwww = true;
            try {
                this.Wwwwwwwwwwwwwwwwwwwwww.accept(th);
            } catch (Throwable th2) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                th = new CompositeException(th, th2);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
            try {
                this.Wwwwwwwwwwwwwwwwwwww.run();
            } catch (Throwable th3) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th3);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th3);
            }
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.Wwwwwwwwwwwwwwwwww) {
                return;
            }
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwww.accept(t);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.Wwwwwwwwwwwwwwwwwww.dispose();
                onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
            }
        }
    }

    public w90(h60<T> h60Var, x60<? super T> x60Var, x60<? super Throwable> x60Var2, r60 r60Var, r60 r60Var2) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = x60Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = x60Var2;
        this.Wwwwwwwwwwwwwwwwwwwww = r60Var;
        this.Wwwwwwwwwwwwwwwwwwww = r60Var2;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww));
    }
}

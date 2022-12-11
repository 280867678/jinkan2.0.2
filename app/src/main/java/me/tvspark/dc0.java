package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes4.dex */
public final class dc0<T> extends x80<T, T> {
    public final long Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<T>, p60 {
        public long Wwwwwwwwwwwwwwwwwwwww;
        public p60 Wwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var, long j) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwww = j;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwwwww.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwwww.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwww.dispose();
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwww.dispose();
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
                long j = this.Wwwwwwwwwwwwwwwwwwwww;
                long j2 = j - 1;
                this.Wwwwwwwwwwwwwwwwwwwww = j2;
                if (j <= 0) {
                    return;
                }
                boolean z = j2 == 0;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
                if (!z) {
                    return;
                }
                onComplete();
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwwwwww = p60Var;
                if (this.Wwwwwwwwwwwwwwwwwwwww != 0) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwww = true;
                p60Var.dispose();
                EmptyDisposable.complete(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    public dc0(h60<T> h60Var, long j) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww));
    }
}

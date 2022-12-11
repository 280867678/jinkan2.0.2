package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

/* loaded from: classes4.dex */
public final class t90<T> extends x80<T, T> {

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<T>, p60 {
        public p60 Wwwwwwwwwwwwwwwwwwwwwww;
        public j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            p60 p60Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = EmptyComponent.INSTANCE;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = EmptyComponent.asObserver();
            p60Var.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            j60<? super T> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = EmptyComponent.INSTANCE;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = EmptyComponent.asObserver();
            j60Var.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            j60<? super T> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = EmptyComponent.INSTANCE;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = EmptyComponent.asObserver();
            j60Var.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
            }
        }
    }

    public t90(h60<T> h60Var) {
        super(h60Var);
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var));
    }
}

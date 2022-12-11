package me.tvspark;

import io.reactivex.internal.disposables.SequentialDisposable;

/* loaded from: classes4.dex */
public final class r90<T, U> extends d60<T> {
    public final h60<U> Wwwwwwwwwwwwwwwwwwwwwww;
    public final h60<? extends T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements j60<U> {
        public final /* synthetic */ j60 Wwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ SequentialDisposable Wwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.r90$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3489Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements j60<T> {
            public C3489Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // me.tvspark.j60
            public void onComplete() {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwww.onComplete();
            }

            @Override // me.tvspark.j60
            public void onError(Throwable th) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwww.onError(th);
            }

            @Override // me.tvspark.j60
            public void onNext(T t) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwww.onNext(t);
            }

            @Override // me.tvspark.j60
            public void onSubscribe(p60 p60Var) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwww.update(p60Var);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SequentialDisposable sequentialDisposable, j60 j60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = sequentialDisposable;
            this.Wwwwwwwwwwwwwwwwwwwwww = j60Var;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = true;
            r90.this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new C3489Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(U u) {
            onComplete();
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.update(p60Var);
        }
    }

    public r90(h60<? extends T> h60Var, h60<U> h60Var2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = h60Var2;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        j60Var.onSubscribe(sequentialDisposable);
        this.Wwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sequentialDisposable, j60Var));
    }
}

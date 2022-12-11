package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class o90<T, U> extends x80<T, T> {
    public final f70<? super T, ? extends h60<U>> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U> implements j60<T>, p60 {
        public boolean Wwwwwwwwwwwwwwwwwww;
        public volatile long Wwwwwwwwwwwwwwwwwwww;
        public final AtomicReference<p60> Wwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();
        public p60 Wwwwwwwwwwwwwwwwwwwwww;
        public final f70<? super T, ? extends h60<U>> Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.o90$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C3487Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U> extends kd0<U> {
            public final AtomicBoolean Wwwwwwwwwwwwwwwwwww = new AtomicBoolean();
            public boolean Wwwwwwwwwwwwwwwwwwww;
            public final T Wwwwwwwwwwwwwwwwwwwww;
            public final long Wwwwwwwwwwwwwwwwwwwwww;
            public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U> Wwwwwwwwwwwwwwwwwwwwwww;

            public C3487Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j, T t) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwww = j;
                this.Wwwwwwwwwwwwwwwwwwwww = t;
            }

            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                if (this.Wwwwwwwwwwwwwwwwwww.compareAndSet(false, true)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    long j = this.Wwwwwwwwwwwwwwwwwwwwww;
                    T t = this.Wwwwwwwwwwwwwwwwwwwww;
                    if (j != wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww) {
                        return;
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
                }
            }

            @Override // me.tvspark.j60
            public void onComplete() {
                if (this.Wwwwwwwwwwwwwwwwwwww) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwww = true;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }

            @Override // me.tvspark.j60
            public void onError(Throwable th) {
                if (this.Wwwwwwwwwwwwwwwwwwww) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwww = true;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
                DisposableHelper.dispose(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
            }

            @Override // me.tvspark.j60
            public void onNext(U u) {
                if (this.Wwwwwwwwwwwwwwwwwwww) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwww = true;
                DisposableHelper.dispose(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var, f70<? super T, ? extends h60<U>> f70Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwwwww.dispose();
            DisposableHelper.dispose(this.Wwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwwww.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.Wwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwww = true;
            p60 p60Var = this.Wwwwwwwwwwwwwwwwwwwww.get();
            if (p60Var == DisposableHelper.DISPOSED) {
                return;
            }
            ((C3487Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) p60Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            DisposableHelper.dispose(this.Wwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.Wwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.Wwwwwwwwwwwwwwwwwww) {
                return;
            }
            long j = this.Wwwwwwwwwwwwwwwwwwww + 1;
            this.Wwwwwwwwwwwwwwwwwwww = j;
            p60 p60Var = this.Wwwwwwwwwwwwwwwwwwwww.get();
            if (p60Var != null) {
                p60Var.dispose();
            }
            try {
                h60<U> apply = this.Wwwwwwwwwwwwwwwwwwwwwww.apply(t);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The publisher supplied is null");
                h60<U> h60Var = apply;
                C3487Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww c3487Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C3487Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j, t);
                if (!this.Wwwwwwwwwwwwwwwwwwwww.compareAndSet(p60Var, c3487Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return;
                }
                h60Var.subscribe(c3487Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                dispose();
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwwwwww = p60Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
            }
        }
    }

    public o90(h60<T> h60Var, f70<? super T, ? extends h60<U>> f70Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwwwwwww));
    }
}

package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class h90<T, U extends Collection<? super T>, B> extends x80<T, U> {
    public final Callable<U> Wwwwwwwwwwwwwwwwwwwwww;
    public final Callable<? extends h60<B>> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U extends Collection<? super T>, B> extends e80<T, U, U> implements j60<T>, p60 {
        public U Wwwwwwwwwwwwww;
        public final AtomicReference<p60> Wwwwwwwwwwwwwww = new AtomicReference<>();
        public p60 Wwwwwwwwwwwwwwww;
        public final Callable<? extends h60<B>> Wwwwwwwwwwwwwwwww;
        public final Callable<U> Wwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super U> j60Var, Callable<U> callable, Callable<? extends h60<B>> callable2) {
            super(j60Var, new MpscLinkedQueue());
            this.Wwwwwwwwwwwwwwwwww = callable;
            this.Wwwwwwwwwwwwwwwww = callable2;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            try {
                U call = this.Wwwwwwwwwwwwwwwwww.call();
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The buffer supplied is null");
                U u = call;
                try {
                    h60<B> call2 = this.Wwwwwwwwwwwwwwwww.call();
                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call2, "The boundary publisher supplied is null");
                    h60<B> h60Var = call2;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                    if (!this.Wwwwwwwwwwwwwww.compareAndSet(this.Wwwwwwwwwwwwwww.get(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        return;
                    }
                    synchronized (this) {
                        U u2 = this.Wwwwwwwwwwwwww;
                        if (u2 == null) {
                            return;
                        }
                        this.Wwwwwwwwwwwwww = u;
                        h60Var.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u2, false, this);
                    }
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    this.Wwwwwwwwwwwwwwwwwwwww = true;
                    this.Wwwwwwwwwwwwwwww.dispose();
                    this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
                }
            } catch (Throwable th2) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                dispose();
                this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th2);
            }
        }

        @Override // me.tvspark.e80
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60 j60Var, Object obj) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.onNext((Collection) obj);
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.Wwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwww.dispose();
                DisposableHelper.dispose(this.Wwwwwwwwwwwwwww);
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwww.clear();
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            synchronized (this) {
                U u = this.Wwwwwwwwwwwwww;
                if (u == null) {
                    return;
                }
                this.Wwwwwwwwwwwwww = null;
                this.Wwwwwwwwwwwwwwwwwwwwww.offer(u);
                this.Wwwwwwwwwwwwwwwwwwww = true;
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return;
                }
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((t70) this.Wwwwwwwwwwwwwwwwwwwwww, (j60) this.Wwwwwwwwwwwwwwwwwwwwwww, false, (p60) this, (e80) this);
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            dispose();
            this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            synchronized (this) {
                U u = this.Wwwwwwwwwwwwww;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwww = p60Var;
                j60<? super V> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
                try {
                    U call = this.Wwwwwwwwwwwwwwwwww.call();
                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The buffer supplied is null");
                    this.Wwwwwwwwwwwwww = call;
                    h60<B> call2 = this.Wwwwwwwwwwwwwwwww.call();
                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call2, "The boundary publisher supplied is null");
                    h60<B> h60Var = call2;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                    this.Wwwwwwwwwwwwwww.set(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    j60Var.onSubscribe(this);
                    if (this.Wwwwwwwwwwwwwwwwwwwww) {
                        return;
                    }
                    h60Var.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    this.Wwwwwwwwwwwwwwwwwwwww = true;
                    p60Var.dispose();
                    EmptyDisposable.error(th, j60Var);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U extends Collection<? super T>, B> extends kd0<B> {
        public boolean Wwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U, B> Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U, B> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.Wwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U, B> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.dispose();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(B b) {
            if (this.Wwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = true;
            DisposableHelper.dispose(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public h90(h60<T> h60Var, Callable<? extends h60<B>> callable, Callable<U> callable2) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = callable;
        this.Wwwwwwwwwwwwwwwwwwwwww = callable2;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super U> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww));
    }
}

package me.tvspark;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class i90<T, U extends Collection<? super T>, B> extends x80<T, U> {
    public final Callable<U> Wwwwwwwwwwwwwwwwwwwwww;
    public final h60<B> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U extends Collection<? super T>, B> extends e80<T, U, U> implements j60<T>, p60 {
        public U Wwwwwwwwwwwwww;
        public p60 Wwwwwwwwwwwwwww;
        public p60 Wwwwwwwwwwwwwwww;
        public final h60<B> Wwwwwwwwwwwwwwwww;
        public final Callable<U> Wwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super U> j60Var, Callable<U> callable, h60<B> h60Var) {
            super(j60Var, new MpscLinkedQueue());
            this.Wwwwwwwwwwwwwwwwww = callable;
            this.Wwwwwwwwwwwwwwwww = h60Var;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            try {
                U call = this.Wwwwwwwwwwwwwwwwww.call();
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The buffer supplied is null");
                U u = call;
                synchronized (this) {
                    U u2 = this.Wwwwwwwwwwwwww;
                    if (u2 == null) {
                        return;
                    }
                    this.Wwwwwwwwwwwwww = u;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u2, false, this);
                }
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                dispose();
                this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
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
                this.Wwwwwwwwwwwwwww.dispose();
                this.Wwwwwwwwwwwwwwww.dispose();
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
                try {
                    U call = this.Wwwwwwwwwwwwwwwwww.call();
                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The buffer supplied is null");
                    this.Wwwwwwwwwwwwww = call;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                    this.Wwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
                    if (this.Wwwwwwwwwwwwwwwwwwwww) {
                        return;
                    }
                    this.Wwwwwwwwwwwwwwwww.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    this.Wwwwwwwwwwwwwwwwwwwww = true;
                    p60Var.dispose();
                    EmptyDisposable.error(th, this.Wwwwwwwwwwwwwwwwwwwwwww);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U extends Collection<? super T>, B> extends kd0<B> {
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U, B> Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U, B> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U, B> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.dispose();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(B b) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public i90(h60<T> h60Var, h60<B> h60Var2, Callable<U> callable) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = h60Var2;
        this.Wwwwwwwwwwwwwwwwwwwwww = callable;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super U> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww));
    }
}

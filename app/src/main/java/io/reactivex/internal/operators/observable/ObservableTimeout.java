package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.b80;
import me.tvspark.f70;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.k70;
import me.tvspark.kd0;
import me.tvspark.l70;
import me.tvspark.md0;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableTimeout<T, U, V> extends x80<T, T> {
    public final h60<? extends T> Wwwwwwwwwwwwwwwwwwwww;
    public final f70<? super T, ? extends h60<V>> Wwwwwwwwwwwwwwwwwwwwww;
    public final h60<U> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class TimeoutObserver<T, U, V> extends AtomicReference<p60> implements j60<T>, p60, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final long serialVersionUID = 2672739326310051084L;
        public final j60<? super T> actual;
        public final h60<U> firstTimeoutIndicator;
        public volatile long index;
        public final f70<? super T, ? extends h60<V>> itemTimeoutIndicator;

        /* renamed from: s */
        public p60 f4454s;

        public TimeoutObserver(j60<? super T> j60Var, h60<U> h60Var, f70<? super T, ? extends h60<V>> f70Var) {
            this.actual = j60Var;
            this.firstTimeoutIndicator = h60Var;
            this.itemTimeoutIndicator = f70Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (DisposableHelper.dispose(this)) {
                this.f4454s.dispose();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void innerError(Throwable th) {
            this.f4454s.dispose();
            this.actual.onError(th);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.f4454s.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            DisposableHelper.dispose(this);
            this.actual.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            DisposableHelper.dispose(this);
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            long j = this.index + 1;
            this.index = j;
            this.actual.onNext(t);
            p60 p60Var = (p60) get();
            if (p60Var != null) {
                p60Var.dispose();
            }
            try {
                h60<V> apply = this.itemTimeoutIndicator.apply(t);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The ObservableSource returned is null");
                h60<V> h60Var = apply;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j);
                if (!compareAndSet(p60Var, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return;
                }
                h60Var.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                dispose();
                this.actual.onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4454s, p60Var)) {
                this.f4454s = p60Var;
                j60<? super T> j60Var = this.actual;
                h60<U> h60Var = this.firstTimeoutIndicator;
                if (h60Var == null) {
                    j60Var.onSubscribe(this);
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, 0L);
                if (!compareAndSet(null, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return;
                }
                j60Var.onSubscribe(this);
                h60Var.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void timeout(long j) {
            if (j == this.index) {
                dispose();
                this.actual.onError(new TimeoutException());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class TimeoutOtherObserver<T, U, V> extends AtomicReference<p60> implements j60<T>, p60, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final long serialVersionUID = -1957813281749686898L;
        public final j60<? super T> actual;
        public final k70<T> arbiter;
        public boolean done;
        public final h60<U> firstTimeoutIndicator;
        public volatile long index;
        public final f70<? super T, ? extends h60<V>> itemTimeoutIndicator;
        public final h60<? extends T> other;

        /* renamed from: s */
        public p60 f4455s;

        public TimeoutOtherObserver(j60<? super T> j60Var, h60<U> h60Var, f70<? super T, ? extends h60<V>> f70Var, h60<? extends T> h60Var2) {
            this.actual = j60Var;
            this.firstTimeoutIndicator = h60Var;
            this.itemTimeoutIndicator = f70Var;
            this.other = h60Var2;
            this.arbiter = new k70<>(j60Var, this, 8);
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (DisposableHelper.dispose(this)) {
                this.f4455s.dispose();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void innerError(Throwable th) {
            this.f4455s.dispose();
            this.actual.onError(th);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.f4455s.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            dispose();
            this.arbiter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.f4455s);
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.done) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.done = true;
            dispose();
            this.arbiter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, this.f4455s);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.index + 1;
            this.index = j;
            if (!this.arbiter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((k70<T>) t, this.f4455s)) {
                return;
            }
            p60 p60Var = (p60) get();
            if (p60Var != null) {
                p60Var.dispose();
            }
            try {
                h60<V> apply = this.itemTimeoutIndicator.apply(t);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The ObservableSource returned is null");
                h60<V> h60Var = apply;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j);
                if (!compareAndSet(p60Var, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return;
                }
                h60Var.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.actual.onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4455s, p60Var)) {
                this.f4455s = p60Var;
                this.arbiter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var);
                j60<? super T> j60Var = this.actual;
                h60<U> h60Var = this.firstTimeoutIndicator;
                if (h60Var == null) {
                    j60Var.onSubscribe(this.arbiter);
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, 0L);
                if (!compareAndSet(null, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return;
                }
                j60Var.onSubscribe(this.arbiter);
                h60Var.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void timeout(long j) {
            if (j == this.index) {
                dispose();
                this.other.subscribe(new b80(this.arbiter));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U, V> extends kd0<Object> {
        public boolean Wwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = j;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwww.timeout(this.Wwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwww.innerError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(Object obj) {
            if (this.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = true;
            DisposableHelper.dispose(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww.timeout(this.Wwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void innerError(Throwable th);

        void timeout(long j);
    }

    public ObservableTimeout(h60<T> h60Var, h60<U> h60Var2, f70<? super T, ? extends h60<V>> f70Var, h60<? extends T> h60Var3) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = h60Var2;
        this.Wwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwww = h60Var3;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        h60<T> h60Var;
        j60<? super T> timeoutOtherObserver;
        if (this.Wwwwwwwwwwwwwwwwwwwww == null) {
            h60Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            timeoutOtherObserver = new TimeoutObserver<>(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww);
        } else {
            h60Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            timeoutOtherObserver = new TimeoutOtherObserver<>(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww);
        }
        h60Var.subscribe(timeoutOtherObserver);
    }
}

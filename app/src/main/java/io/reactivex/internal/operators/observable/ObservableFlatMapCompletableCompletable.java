package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.d60;
import me.tvspark.f70;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.n70;
import me.tvspark.o60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.t50;
import me.tvspark.u50;
import me.tvspark.v50;

/* loaded from: classes4.dex */
public final class ObservableFlatMapCompletableCompletable<T> extends t50 implements n70<T> {
    public final boolean Wwwwwwwwwwwwwwwwwwwwww;
    public final f70<? super T, ? extends v50> Wwwwwwwwwwwwwwwwwwwwwww;
    public final h60<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements p60, j60<T> {
        public static final long serialVersionUID = 8443155186132538303L;
        public final u50 actual;

        /* renamed from: d */
        public p60 f4430d;
        public final boolean delayErrors;
        public final f70<? super T, ? extends v50> mapper;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final o60 set = new o60();

        /* loaded from: classes4.dex */
        public final class InnerObserver extends AtomicReference<p60> implements u50, p60 {
            public static final long serialVersionUID = 8606673141535671828L;

            public InnerObserver() {
            }

            @Override // me.tvspark.p60
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // me.tvspark.p60
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // me.tvspark.u50
            public void onComplete() {
                FlatMapCompletableMainObserver.this.innerComplete(this);
            }

            @Override // me.tvspark.u50
            public void onError(Throwable th) {
                FlatMapCompletableMainObserver.this.innerError(this, th);
            }

            @Override // me.tvspark.u50
            public void onSubscribe(p60 p60Var) {
                DisposableHelper.setOnce(this, p60Var);
            }
        }

        public FlatMapCompletableMainObserver(u50 u50Var, f70<? super T, ? extends v50> f70Var, boolean z) {
            this.actual = u50Var;
            this.mapper = f70Var;
            this.delayErrors = z;
            lazySet(1);
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.f4430d.dispose();
            this.set.dispose();
        }

        public void innerComplete(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerObserver);
            onComplete();
        }

        public void innerError(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th) {
            this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerObserver);
            onError(th);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.f4430d.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.errors.terminate();
                if (terminate != null) {
                    this.actual.onError(terminate);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            if (!this.delayErrors) {
                dispose();
                if (getAndSet(0) <= 0) {
                    return;
                }
            } else if (decrementAndGet() != 0) {
                return;
            }
            this.actual.onError(this.errors.terminate());
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            try {
                v50 apply = this.mapper.apply(t);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper returned a null CompletableSource");
                v50 v50Var = apply;
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerObserver);
                v50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerObserver);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.f4430d.dispose();
                onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4430d, p60Var)) {
                this.f4430d = p60Var;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapCompletableCompletable(h60<T> h60Var, f70<? super T, ? extends v50> f70Var, boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // me.tvspark.t50
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u50 u50Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new FlatMapCompletableMainObserver(u50Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // me.tvspark.n70
    public d60<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new ObservableFlatMapCompletable(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww);
    }
}

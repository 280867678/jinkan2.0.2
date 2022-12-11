package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.md0;
import me.tvspark.p60;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableSampleWithObservable<T> extends x80<T, T> {
    public final h60<?> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class SampleMainObserver<T> extends AtomicReference<T> implements j60<T>, p60 {
        public static final long serialVersionUID = -3517602651313910099L;
        public final j60<? super T> actual;
        public final AtomicReference<p60> other = new AtomicReference<>();

        /* renamed from: s */
        public p60 f4441s;
        public final h60<?> sampler;

        public SampleMainObserver(j60<? super T> j60Var, h60<?> h60Var) {
            this.actual = j60Var;
            this.sampler = h60Var;
        }

        public void complete() {
            this.f4441s.dispose();
            this.actual.onComplete();
        }

        @Override // me.tvspark.p60
        public void dispose() {
            DisposableHelper.dispose(this.other);
            this.f4441s.dispose();
        }

        public void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.actual.onNext(andSet);
            }
        }

        public void error(Throwable th) {
            this.f4441s.dispose();
            this.actual.onError(th);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.other.get() == DisposableHelper.DISPOSED;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            this.actual.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.other);
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4441s, p60Var)) {
                this.f4441s = p60Var;
                this.actual.onSubscribe(this);
                if (this.other.get() != null) {
                    return;
                }
                this.sampler.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
            }
        }

        public boolean setOther(p60 p60Var) {
            return DisposableHelper.setOnce(this.other, p60Var);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<Object> {
        public final SampleMainObserver<T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SampleMainObserver<T> sampleMainObserver) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = sampleMainObserver;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.complete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.error(th);
        }

        @Override // me.tvspark.j60
        public void onNext(Object obj) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.emit();
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.setOther(p60Var);
        }
    }

    public ObservableSampleWithObservable(h60<T> h60Var, h60<?> h60Var2) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = h60Var2;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new SampleMainObserver(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwwwwwww));
    }
}

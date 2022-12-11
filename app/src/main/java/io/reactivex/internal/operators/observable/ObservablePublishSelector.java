package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.d60;
import me.tvspark.f70;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservablePublishSelector<T, R> extends x80<T, R> {
    public final f70<? super d60<T>, ? extends h60<R>> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class TargetObserver<T, R> extends AtomicReference<p60> implements j60<R>, p60 {
        public static final long serialVersionUID = 854110278590336484L;
        public final j60<? super R> actual;

        /* renamed from: d */
        public p60 f4435d;

        public TargetObserver(j60<? super R> j60Var) {
            this.actual = j60Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.f4435d.dispose();
            DisposableHelper.dispose(this);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.f4435d.isDisposed();
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
        public void onNext(R r) {
            this.actual.onNext(r);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4435d, p60Var)) {
                this.f4435d = p60Var;
                this.actual.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R> implements j60<T> {
        public final AtomicReference<p60> Wwwwwwwwwwwwwwwwwwwwwww;
        public final PublishSubject<T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(PublishSubject<T> publishSubject, AtomicReference<p60> atomicReference) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = publishSubject;
            this.Wwwwwwwwwwwwwwwwwwwwwww = atomicReference;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this.Wwwwwwwwwwwwwwwwwwwwwww, p60Var);
        }
    }

    public ObservablePublishSelector(h60<T> h60Var, f70<? super d60<T>, ? extends h60<R>> f70Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super R> j60Var) {
        PublishSubject publishSubject = new PublishSubject();
        try {
            h60<R> apply = this.Wwwwwwwwwwwwwwwwwwwwwww.apply(publishSubject);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The selector returned a null ObservableSource");
            h60<R> h60Var = apply;
            TargetObserver targetObserver = new TargetObserver(j60Var);
            h60Var.subscribe(targetObserver);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(publishSubject, targetObserver));
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            EmptyDisposable.error(th, j60Var);
        }
    }
}

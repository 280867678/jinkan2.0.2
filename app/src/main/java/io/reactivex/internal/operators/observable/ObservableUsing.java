package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import me.tvspark.d60;
import me.tvspark.f70;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.x60;

/* loaded from: classes4.dex */
public final class ObservableUsing<T, D> extends d60<T> {
    public final boolean Wwwwwwwwwwwwwwwwwwwww;
    public final x60<? super D> Wwwwwwwwwwwwwwwwwwwwww;
    public final f70<? super D, ? extends h60<? extends T>> Wwwwwwwwwwwwwwwwwwwwwww;
    public final Callable<? extends D> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class UsingObserver<T, D> extends AtomicBoolean implements j60<T>, p60 {
        public static final long serialVersionUID = 5904473792286235046L;
        public final j60<? super T> actual;
        public final x60<? super D> disposer;
        public final boolean eager;
        public final D resource;

        /* renamed from: s */
        public p60 f4459s;

        public UsingObserver(j60<? super T> j60Var, D d, x60<? super D> x60Var, boolean z) {
            this.actual = j60Var;
            this.resource = d;
            this.disposer = x60Var;
            this.eager = z;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            disposeAfter();
            this.f4459s.dispose();
        }

        public void disposeAfter() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept((D) this.resource);
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                }
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return get();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (!this.eager) {
                this.actual.onComplete();
                this.f4459s.dispose();
                disposeAfter();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept((D) this.resource);
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    this.actual.onError(th);
                    return;
                }
            }
            this.f4459s.dispose();
            this.actual.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (!this.eager) {
                this.actual.onError(th);
                this.f4459s.dispose();
                disposeAfter();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept((D) this.resource);
                } catch (Throwable th2) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.f4459s.dispose();
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4459s, p60Var)) {
                this.f4459s = p60Var;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableUsing(Callable<? extends D> callable, f70<? super D, ? extends h60<? extends T>> f70Var, x60<? super D> x60Var, boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = callable;
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = x60Var;
        this.Wwwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        try {
            D call = this.Wwwwwwwwwwwwwwwwwwwwwwww.call();
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwww.apply(call).subscribe(new UsingObserver(j60Var, call, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww));
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                try {
                    this.Wwwwwwwwwwwwwwwwwwwwww.accept(call);
                    EmptyDisposable.error(th, j60Var);
                } catch (Throwable th2) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                    EmptyDisposable.error(new CompositeException(th, th2), j60Var);
                }
            }
        } catch (Throwable th3) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th3);
            EmptyDisposable.error(th3, j60Var);
        }
    }
}

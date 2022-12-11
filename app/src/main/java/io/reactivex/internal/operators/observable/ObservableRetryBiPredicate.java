package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.d60;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.u60;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableRetryBiPredicate<T> extends x80<T, T> {
    public final u60<? super Integer, ? super Throwable> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class RetryBiObserver<T> extends AtomicInteger implements j60<T> {
        public static final long serialVersionUID = -7098360935104053232L;
        public final j60<? super T> actual;
        public final u60<? super Integer, ? super Throwable> predicate;
        public int retries;

        /* renamed from: sa */
        public final SequentialDisposable f4438sa;
        public final h60<? extends T> source;

        public RetryBiObserver(j60<? super T> j60Var, u60<? super Integer, ? super Throwable> u60Var, SequentialDisposable sequentialDisposable, h60<? extends T> h60Var) {
            this.actual = j60Var;
            this.f4438sa = sequentialDisposable;
            this.source = h60Var;
            this.predicate = u60Var;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            try {
                u60<? super Integer, ? super Throwable> u60Var = this.predicate;
                int i = this.retries + 1;
                this.retries = i;
                Integer valueOf = Integer.valueOf(i);
                if (((l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) u60Var) != null) {
                    if (!l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(valueOf, th)) {
                        this.actual.onError(th);
                        return;
                    } else {
                        subscribeNext();
                        return;
                    }
                }
                throw null;
            } catch (Throwable th2) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            this.f4438sa.update(p60Var);
        }

        public void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f4438sa.isDisposed()) {
                    this.source.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRetryBiPredicate(d60<T> d60Var, u60<? super Integer, ? super Throwable> u60Var) {
        super(d60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = u60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        j60Var.onSubscribe(sequentialDisposable);
        new RetryBiObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, sequentialDisposable, this.Wwwwwwwwwwwwwwwwwwwwwwww).subscribeNext();
    }
}

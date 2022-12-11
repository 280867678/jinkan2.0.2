package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.d60;
import me.tvspark.g70;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableRetryPredicate<T> extends x80<T, T> {
    public final long Wwwwwwwwwwwwwwwwwwwwww;
    public final g70<? super Throwable> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class RepeatObserver<T> extends AtomicInteger implements j60<T> {
        public static final long serialVersionUID = -7098360935104053232L;
        public final j60<? super T> actual;
        public final g70<? super Throwable> predicate;
        public long remaining;

        /* renamed from: sa */
        public final SequentialDisposable f4439sa;
        public final h60<? extends T> source;

        public RepeatObserver(j60<? super T> j60Var, long j, g70<? super Throwable> g70Var, SequentialDisposable sequentialDisposable, h60<? extends T> h60Var) {
            this.actual = j60Var;
            this.f4439sa = sequentialDisposable;
            this.source = h60Var;
            this.predicate = g70Var;
            this.remaining = j;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            long j = this.remaining;
            if (j != Long.MAX_VALUE) {
                this.remaining = j - 1;
            }
            if (j == 0) {
                this.actual.onError(th);
                return;
            }
            try {
                if (!this.predicate.test(th)) {
                    this.actual.onError(th);
                } else {
                    subscribeNext();
                }
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
            this.f4439sa.update(p60Var);
        }

        public void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f4439sa.isDisposed()) {
                    this.source.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRetryPredicate(d60<T> d60Var, long j, g70<? super Throwable> g70Var) {
        super(d60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = g70Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = j;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        j60Var.onSubscribe(sequentialDisposable);
        new RepeatObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, sequentialDisposable, this.Wwwwwwwwwwwwwwwwwwwwwwww).subscribeNext();
    }
}

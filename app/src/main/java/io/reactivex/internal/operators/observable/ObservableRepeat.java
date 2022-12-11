package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.d60;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableRepeat<T> extends x80<T, T> {
    public final long Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class RepeatObserver<T> extends AtomicInteger implements j60<T> {
        public static final long serialVersionUID = -7098360935104053232L;
        public final j60<? super T> actual;
        public long remaining;

        /* renamed from: sd */
        public final SequentialDisposable f4436sd;
        public final h60<? extends T> source;

        public RepeatObserver(j60<? super T> j60Var, long j, SequentialDisposable sequentialDisposable, h60<? extends T> h60Var) {
            this.actual = j60Var;
            this.f4436sd = sequentialDisposable;
            this.source = h60Var;
            this.remaining = j;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            long j = this.remaining;
            if (j != Long.MAX_VALUE) {
                this.remaining = j - 1;
            }
            if (j != 0) {
                subscribeNext();
            } else {
                this.actual.onComplete();
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            this.f4436sd.replace(p60Var);
        }

        public void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f4436sd.isDisposed()) {
                    this.source.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRepeat(d60<T> d60Var, long j) {
        super(d60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        j60Var.onSubscribe(sequentialDisposable);
        long j = this.Wwwwwwwwwwwwwwwwwwwwwww;
        long j2 = Long.MAX_VALUE;
        if (j != Long.MAX_VALUE) {
            j2 = j - 1;
        }
        new RepeatObserver(j60Var, j2, sequentialDisposable, this.Wwwwwwwwwwwwwwwwwwwwwwww).subscribeNext();
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.d60;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.v60;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableRepeatUntil<T> extends x80<T, T> {
    public final v60 Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class RepeatUntilObserver<T> extends AtomicInteger implements j60<T> {
        public static final long serialVersionUID = -7098360935104053232L;
        public final j60<? super T> actual;

        /* renamed from: sd */
        public final SequentialDisposable f4437sd;
        public final h60<? extends T> source;
        public final v60 stop;

        public RepeatUntilObserver(j60<? super T> j60Var, v60 v60Var, SequentialDisposable sequentialDisposable, h60<? extends T> h60Var) {
            this.actual = j60Var;
            this.f4437sd = sequentialDisposable;
            this.source = h60Var;
            this.stop = v60Var;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            try {
                if (this.stop.getAsBoolean()) {
                    this.actual.onComplete();
                } else {
                    subscribeNext();
                }
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.actual.onError(th);
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
            this.f4437sd.replace(p60Var);
        }

        public void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i = 1;
                do {
                    this.source.subscribe(this);
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }
    }

    public ObservableRepeatUntil(d60<T> d60Var, v60 v60Var) {
        super(d60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = v60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        j60Var.onSubscribe(sequentialDisposable);
        new RepeatUntilObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, sequentialDisposable, this.Wwwwwwwwwwwwwwwwwwwwwwww).subscribeNext();
    }
}

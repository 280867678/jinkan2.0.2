package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.k60;
import me.tvspark.md0;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableThrottleFirstTimed<T> extends x80<T, T> {
    public final k60 Wwwwwwwwwwwwwwwwwwwww;
    public final TimeUnit Wwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class DebounceTimedObserver<T> extends AtomicReference<p60> implements j60<T>, p60, Runnable {
        public static final long serialVersionUID = 786994795061867455L;
        public final j60<? super T> actual;
        public boolean done;
        public volatile boolean gate;

        /* renamed from: s */
        public p60 f4453s;
        public final long timeout;
        public final TimeUnit unit;
        public final k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww worker;

        public DebounceTimedObserver(j60<? super T> j60Var, long j, TimeUnit timeUnit, k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.actual = j60Var;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            DisposableHelper.dispose(this);
            this.worker.dispose();
            this.f4453s.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                DisposableHelper.dispose(this);
                this.worker.dispose();
                this.actual.onComplete();
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.done) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.done = true;
            DisposableHelper.dispose(this);
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.gate || this.done) {
                return;
            }
            this.gate = true;
            this.actual.onNext(t);
            p60 p60Var = get();
            if (p60Var != null) {
                p60Var.dispose();
            }
            DisposableHelper.replace(this, this.worker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, this.timeout, this.unit));
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4453s, p60Var)) {
                this.f4453s = p60Var;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.gate = false;
        }
    }

    public ObservableThrottleFirstTimed(h60<T> h60Var, long j, TimeUnit timeUnit, k60 k60Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwww = timeUnit;
        this.Wwwwwwwwwwwwwwwwwwwww = k60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new DebounceTimedObserver(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
    }
}

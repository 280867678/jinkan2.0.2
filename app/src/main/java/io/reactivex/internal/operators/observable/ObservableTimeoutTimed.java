package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.b80;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.k60;
import me.tvspark.k70;
import me.tvspark.md0;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableTimeoutTimed<T> extends x80<T, T> {
    public static final p60 Wwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final h60<? extends T> Wwwwwwwwwwwwwwwwwwww;
    public final k60 Wwwwwwwwwwwwwwwwwwwww;
    public final TimeUnit Wwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class TimeoutTimedObserver<T> extends AtomicReference<p60> implements j60<T>, p60 {
        public static final long serialVersionUID = -8387234228317808253L;
        public final j60<? super T> actual;
        public volatile boolean done;
        public volatile long index;

        /* renamed from: s */
        public p60 f4456s;
        public final long timeout;
        public final TimeUnit unit;
        public final k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww worker;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ long Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww == TimeoutTimedObserver.this.index) {
                    TimeoutTimedObserver.this.done = true;
                    DisposableHelper.dispose(TimeoutTimedObserver.this);
                    TimeoutTimedObserver.this.f4456s.dispose();
                    TimeoutTimedObserver.this.actual.onError(new TimeoutException());
                    TimeoutTimedObserver.this.worker.dispose();
                }
            }
        }

        public TimeoutTimedObserver(j60<? super T> j60Var, long j, TimeUnit timeUnit, k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.actual = j60Var;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.worker.dispose();
            DisposableHelper.dispose(this);
            this.f4456s.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            dispose();
            this.actual.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.done) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.done = true;
            dispose();
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.index + 1;
            this.index = j;
            this.actual.onNext(t);
            scheduleTimeout(j);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4456s, p60Var)) {
                this.f4456s = p60Var;
                this.actual.onSubscribe(this);
                scheduleTimeout(0L);
            }
        }

        public void scheduleTimeout(long j) {
            p60 p60Var = get();
            if (p60Var != null) {
                p60Var.dispose();
            }
            if (compareAndSet(p60Var, ObservableTimeoutTimed.Wwwwwwwwwwwwwwwwwww)) {
                DisposableHelper.replace(this, this.worker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j), this.timeout, this.unit));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class TimeoutTimedOtherObserver<T> extends AtomicReference<p60> implements j60<T>, p60 {
        public static final long serialVersionUID = -4619702551964128179L;
        public final j60<? super T> actual;
        public final k70<T> arbiter;
        public volatile boolean done;
        public volatile long index;
        public final h60<? extends T> other;

        /* renamed from: s */
        public p60 f4457s;
        public final long timeout;
        public final TimeUnit unit;
        public final k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww worker;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ long Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww == TimeoutTimedOtherObserver.this.index) {
                    TimeoutTimedOtherObserver.this.done = true;
                    TimeoutTimedOtherObserver.this.f4457s.dispose();
                    DisposableHelper.dispose(TimeoutTimedOtherObserver.this);
                    TimeoutTimedOtherObserver.this.subscribeNext();
                    TimeoutTimedOtherObserver.this.worker.dispose();
                }
            }
        }

        public TimeoutTimedOtherObserver(j60<? super T> j60Var, long j, TimeUnit timeUnit, k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, h60<? extends T> h60Var) {
            this.actual = j60Var;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.other = h60Var;
            this.arbiter = new k70<>(j60Var, this, 8);
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.worker.dispose();
            DisposableHelper.dispose(this);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.worker.dispose();
            DisposableHelper.dispose(this);
            this.arbiter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.f4457s);
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.done) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.done = true;
            this.worker.dispose();
            DisposableHelper.dispose(this);
            this.arbiter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, this.f4457s);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.index + 1;
            this.index = j;
            if (!this.arbiter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((k70<T>) t, this.f4457s)) {
                return;
            }
            scheduleTimeout(j);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4457s, p60Var)) {
                this.f4457s = p60Var;
                if (!this.arbiter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var)) {
                    return;
                }
                this.actual.onSubscribe(this.arbiter);
                scheduleTimeout(0L);
            }
        }

        public void scheduleTimeout(long j) {
            p60 p60Var = get();
            if (p60Var != null) {
                p60Var.dispose();
            }
            if (compareAndSet(p60Var, ObservableTimeoutTimed.Wwwwwwwwwwwwwwwwwww)) {
                DisposableHelper.replace(this, this.worker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j), this.timeout, this.unit));
            }
        }

        public void subscribeNext() {
            this.other.subscribe(new b80(this.arbiter));
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements p60 {
        @Override // me.tvspark.p60
        public void dispose() {
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return true;
        }
    }

    public ObservableTimeoutTimed(h60<T> h60Var, long j, TimeUnit timeUnit, k60 k60Var, h60<? extends T> h60Var2) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwww = timeUnit;
        this.Wwwwwwwwwwwwwwwwwwwww = k60Var;
        this.Wwwwwwwwwwwwwwwwwwww = h60Var2;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        if (this.Wwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new TimeoutTimedObserver(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new TimeoutTimedOtherObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwwww));
        }
    }
}

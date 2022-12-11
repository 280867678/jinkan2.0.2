package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.k60;
import me.tvspark.p60;
import me.tvspark.sc0;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableSkipLastTimed<T> extends x80<T, T> {
    public final boolean Wwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwww;
    public final k60 Wwwwwwwwwwwwwwwwwwwww;
    public final TimeUnit Wwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class SkipLastTimedObserver<T> extends AtomicInteger implements j60<T>, p60 {
        public static final long serialVersionUID = -5677354903406201275L;
        public final j60<? super T> actual;
        public volatile boolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final sc0<Object> queue;

        /* renamed from: s */
        public p60 f4447s;
        public final k60 scheduler;
        public final long time;
        public final TimeUnit unit;

        public SkipLastTimedObserver(j60<? super T> j60Var, long j, TimeUnit timeUnit, k60 k60Var, int i, boolean z) {
            this.actual = j60Var;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = k60Var;
            this.queue = new sc0<>(i);
            this.delayError = z;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f4447s.dispose();
                if (getAndIncrement() != 0) {
                    return;
                }
                this.queue.clear();
            }
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            j60<? super T> j60Var = this.actual;
            sc0<Object> sc0Var = this.queue;
            boolean z = this.delayError;
            TimeUnit timeUnit = this.unit;
            k60 k60Var = this.scheduler;
            long j = this.time;
            int i = 1;
            while (!this.cancelled) {
                boolean z2 = this.done;
                Long l = (Long) sc0Var.peek();
                boolean z3 = l == null;
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit);
                if (!z3 && l.longValue() > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - j) {
                    z3 = true;
                }
                if (z2) {
                    if (!z) {
                        Throwable th = this.error;
                        if (th != null) {
                            this.queue.clear();
                            j60Var.onError(th);
                            return;
                        } else if (z3) {
                            j60Var.onComplete();
                            return;
                        }
                    } else if (z3) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            j60Var.onError(th2);
                            return;
                        } else {
                            j60Var.onComplete();
                            return;
                        }
                    }
                }
                if (z3) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    sc0Var.mo4868poll();
                    j60Var.onNext(sc0Var.mo4868poll());
                }
            }
            this.queue.clear();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.queue.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Long.valueOf(this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit)), t);
            drain();
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4447s, p60Var)) {
                this.f4447s = p60Var;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLastTimed(h60<T> h60Var, long j, TimeUnit timeUnit, k60 k60Var, int i, boolean z) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwww = timeUnit;
        this.Wwwwwwwwwwwwwwwwwwwww = k60Var;
        this.Wwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwww = z;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new SkipLastTimedObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww));
    }
}

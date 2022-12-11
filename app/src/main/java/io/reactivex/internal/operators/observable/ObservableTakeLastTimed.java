package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.k60;
import me.tvspark.p60;
import me.tvspark.sc0;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableTakeLastTimed<T> extends x80<T, T> {
    public final boolean Wwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwww;
    public final k60 Wwwwwwwwwwwwwwwwwwww;
    public final TimeUnit Wwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class TakeLastTimedObserver<T> extends AtomicBoolean implements j60<T>, p60 {
        public static final long serialVersionUID = -5677354903406201275L;
        public final j60<? super T> actual;
        public volatile boolean cancelled;
        public final long count;

        /* renamed from: d */
        public p60 f4451d;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final sc0<Object> queue;
        public final k60 scheduler;
        public final long time;
        public final TimeUnit unit;

        public TakeLastTimedObserver(j60<? super T> j60Var, long j, long j2, TimeUnit timeUnit, k60 k60Var, int i, boolean z) {
            this.actual = j60Var;
            this.count = j;
            this.time = j2;
            this.unit = timeUnit;
            this.scheduler = k60Var;
            this.queue = new sc0<>(i);
            this.delayError = z;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f4451d.dispose();
                if (!compareAndSet(false, true)) {
                    return;
                }
                this.queue.clear();
            }
        }

        public void drain() {
            Throwable th;
            if (!compareAndSet(false, true)) {
                return;
            }
            j60<? super T> j60Var = this.actual;
            sc0<Object> sc0Var = this.queue;
            boolean z = this.delayError;
            while (!this.cancelled) {
                if (!z && (th = this.error) != null) {
                    sc0Var.clear();
                    j60Var.onError(th);
                    return;
                }
                Object mo4868poll = sc0Var.mo4868poll();
                if (mo4868poll == null) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        j60Var.onError(th2);
                        return;
                    } else {
                        j60Var.onComplete();
                        return;
                    }
                }
                Object mo4868poll2 = sc0Var.mo4868poll();
                if (((Long) mo4868poll).longValue() >= this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit) - this.time) {
                    j60Var.onNext(mo4868poll2);
                }
            }
            sc0Var.clear();
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
            sc0<Object> sc0Var = this.queue;
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit);
            long j = this.time;
            long j2 = this.count;
            boolean z = j2 == Long.MAX_VALUE;
            sc0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Long.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), t);
            while (!sc0Var.isEmpty()) {
                if (((Long) sc0Var.peek()).longValue() > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - j && (z || (sc0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >> 1) <= j2)) {
                    return;
                }
                sc0Var.mo4868poll();
                sc0Var.mo4868poll();
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4451d, p60Var)) {
                this.f4451d = p60Var;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLastTimed(h60<T> h60Var, long j, long j2, TimeUnit timeUnit, k60 k60Var, int i, boolean z) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwww = j2;
        this.Wwwwwwwwwwwwwwwwwwwww = timeUnit;
        this.Wwwwwwwwwwwwwwwwwwww = k60Var;
        this.Wwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwww = z;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new TakeLastTimedObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww));
    }
}

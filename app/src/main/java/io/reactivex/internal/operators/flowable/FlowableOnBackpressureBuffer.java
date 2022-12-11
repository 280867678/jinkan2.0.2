package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.i80;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.r60;
import me.tvspark.s51;
import me.tvspark.s70;
import me.tvspark.sc0;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableOnBackpressureBuffer<T> extends i80<T, T> {
    public final r60 Wwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements s51<T> {
        public static final long serialVersionUID = -2514538129242366402L;
        public final s51<? super T> actual;
        public volatile boolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final r60 onOverflow;
        public boolean outputFused;
        public final s70<T> queue;
        public final AtomicLong requested = new AtomicLong();

        /* renamed from: s */
        public t51 f4378s;

        public BackpressureBufferSubscriber(s51<? super T> s51Var, int i, boolean z, boolean z2, r60 r60Var) {
            this.actual = s51Var;
            this.onOverflow = r60Var;
            this.delayError = z2;
            this.queue = z ? new sc0<>(i) : new SpscArrayQueue<>(i);
        }

        @Override // me.tvspark.t51
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f4378s.cancel();
                if (getAndIncrement() != 0) {
                    return;
                }
                this.queue.clear();
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, s51<? super T> s51Var) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (this.delayError) {
                    if (!z2) {
                        return false;
                    }
                    Throwable th = this.error;
                    if (th != null) {
                        s51Var.onError(th);
                    } else {
                        s51Var.onComplete();
                    }
                    return true;
                }
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    s51Var.onError(th2);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    s51Var.onComplete();
                    return true;
                }
            }
        }

        @Override // me.tvspark.t70
        public void clear() {
            this.queue.clear();
        }

        public void drain() {
            int i;
            if (getAndIncrement() == 0) {
                s70<T> s70Var = this.queue;
                s51<? super T> s51Var = this.actual;
                int i2 = 1;
                while (!checkTerminated(this.done, s70Var.isEmpty(), s51Var)) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        }
                        boolean z = this.done;
                        Object obj = (T) s70Var.mo4868poll();
                        boolean z2 = obj == null;
                        if (checkTerminated(z, z2, s51Var)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        s51Var.onNext(obj);
                        j2++;
                    }
                    if (i == 0 && checkTerminated(this.done, s70Var.isEmpty(), s51Var)) {
                        return;
                    }
                    if (j2 != 0 && j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // me.tvspark.t70
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // me.tvspark.s51
        public void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.actual.onComplete();
            } else {
                drain();
            }
        }

        @Override // me.tvspark.s51
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (this.outputFused) {
                this.actual.onError(th);
            } else {
                drain();
            }
        }

        @Override // me.tvspark.s51
        public void onNext(T t) {
            if (this.queue.offer(t)) {
                if (this.outputFused) {
                    this.actual.onNext(null);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            this.f4378s.cancel();
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
            try {
                this.onOverflow.run();
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                missingBackpressureException.initCause(th);
            }
            onError(missingBackpressureException);
        }

        @Override // me.tvspark.s51
        public void onSubscribe(t51 t51Var) {
            if (SubscriptionHelper.validate(this.f4378s, t51Var)) {
                this.f4378s = t51Var;
                this.actual.onSubscribe(this);
                t51Var.request(Long.MAX_VALUE);
            }
        }

        @Override // me.tvspark.t70
        /* renamed from: poll */
        public T mo4868poll() throws Exception {
            return this.queue.mo4868poll();
        }

        @Override // me.tvspark.t51
        public void request(long j) {
            if (this.outputFused || !SubscriptionHelper.validate(j)) {
                return;
            }
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
            drain();
        }

        @Override // me.tvspark.p70
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }
    }

    public FlowableOnBackpressureBuffer(r51<T> r51Var, int i, boolean z, boolean z2, r60 r60Var) {
        super(r51Var);
        this.Wwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwww = z2;
        this.Wwwwwwwwwwwwwwwwwww = r60Var;
    }

    @Override // me.tvspark.x50
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51<? super T> s51Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.subscribe(new BackpressureBufferSubscriber(s51Var, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww));
    }
}

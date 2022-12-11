package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.f70;
import me.tvspark.q70;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.t70;

/* loaded from: classes4.dex */
public final class FlowableFlattenIterable$FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements s51<T> {
    public static final long serialVersionUID = -3096000382929934955L;
    public final s51<? super R> actual;
    public volatile boolean cancelled;
    public int consumed;
    public Iterator<? extends R> current;
    public volatile boolean done;
    public int fusionMode;
    public final int limit;
    public final f70<? super T, ? extends Iterable<? extends R>> mapper;
    public final int prefetch;
    public t70<T> queue;

    /* renamed from: s */
    public t51 f4374s;
    public final AtomicReference<Throwable> error = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();

    public FlowableFlattenIterable$FlattenIterableSubscriber(s51<? super R> s51Var, f70<? super T, ? extends Iterable<? extends R>> f70Var, int i) {
        this.actual = s51Var;
        this.mapper = f70Var;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    @Override // me.tvspark.t51
    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.f4374s.cancel();
            if (getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, s51<?> s51Var, t70<?> t70Var) {
        if (this.cancelled) {
            this.current = null;
            t70Var.clear();
            return true;
        } else if (!z) {
            return false;
        } else {
            if (this.error.get() == null) {
                if (!z2) {
                    return false;
                }
                s51Var.onComplete();
                return true;
            }
            Throwable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error);
            this.current = null;
            t70Var.clear();
            s51Var.onError(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return true;
        }
    }

    @Override // me.tvspark.t70
    public void clear() {
        this.current = null;
        this.queue.clear();
    }

    public void consumedOne(boolean z) {
        if (z) {
            int i = this.consumed + 1;
            if (i != this.limit) {
                this.consumed = i;
                return;
            }
            this.consumed = 0;
            this.f4374s.request(i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f0, code lost:
        if (r6 == null) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        Throwable th;
        if (getAndIncrement() != 0) {
            return;
        }
        s51<?> s51Var = this.actual;
        t70<T> t70Var = this.queue;
        boolean z = false;
        boolean z2 = this.fusionMode != 1;
        Iterator<? extends R> it = this.current;
        int i = 1;
        while (true) {
            if (it == null) {
                boolean z3 = this.done;
                try {
                    T mo4868poll = t70Var.mo4868poll();
                    if (checkTerminated(z3, mo4868poll == null, s51Var, t70Var)) {
                        return;
                    }
                    if (mo4868poll != null) {
                        try {
                            it = this.mapper.apply(mo4868poll).iterator();
                            if (!it.hasNext()) {
                                consumedOne(z2);
                                it = null;
                            } else {
                                this.current = it;
                            }
                        } catch (Throwable th2) {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                            this.f4374s.cancel();
                            ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error, th2);
                            th = ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error);
                            s51Var.onError(th);
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th3);
                    this.f4374s.cancel();
                    ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error, th3);
                    th = ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error);
                    this.current = null;
                    t70Var.clear();
                    s51Var.onError(th);
                    return;
                }
            }
            if (it != null) {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        break;
                    } else if (checkTerminated(this.done, z, s51Var, t70Var)) {
                        return;
                    } else {
                        try {
                            s51Var.onNext((R) it.next());
                            if (!checkTerminated(this.done, z, s51Var, t70Var)) {
                                j2++;
                                if (!it.hasNext()) {
                                    consumedOne(z2);
                                    this.current = null;
                                    it = null;
                                    break;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th4) {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th4);
                            this.current = null;
                            this.f4374s.cancel();
                            ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error, th4);
                            th = ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error);
                            s51Var.onError(th);
                            return;
                        }
                    }
                }
                if (j2 == j) {
                    boolean z4 = this.done;
                    if (t70Var.isEmpty() && it == null) {
                        z = true;
                    }
                    if (checkTerminated(z4, z, s51Var, t70Var)) {
                        return;
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            z = false;
        }
    }

    @Override // me.tvspark.t70
    public boolean isEmpty() {
        Iterator<? extends R> it = this.current;
        return (it != null && !it.hasNext()) || this.queue.isEmpty();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.done || !ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error, th)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.fusionMode != 0 || this.queue.offer(t)) {
            drain();
        } else {
            onError(new MissingBackpressureException("Queue is full?!"));
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4374s, t51Var)) {
            this.f4374s = t51Var;
            if (t51Var instanceof q70) {
                q70 q70Var = (q70) t51Var;
                int requestFusion = q70Var.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = q70Var;
                    this.done = true;
                    this.actual.onSubscribe(this);
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = q70Var;
                    this.actual.onSubscribe(this);
                    t51Var.request(this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            this.actual.onSubscribe(this);
            t51Var.request(this.prefetch);
        }
    }

    @Override // me.tvspark.t70
    /* renamed from: poll */
    public R mo4868poll() throws Exception {
        Iterator<? extends R> it = this.current;
        while (true) {
            if (it == null) {
                T mo4868poll = this.queue.mo4868poll();
                if (mo4868poll != null) {
                    it = this.mapper.apply(mo4868poll).iterator();
                    if (it.hasNext()) {
                        this.current = it;
                        break;
                    }
                    it = null;
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        R next = it.next();
        if (!it.hasNext()) {
            this.current = null;
        }
        return next;
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
            drain();
        }
    }

    @Override // me.tvspark.p70
    public int requestFusion(int i) {
        return ((i & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
    }
}

package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.r40;
import me.tvspark.r60;
import me.tvspark.s51;
import me.tvspark.t51;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber */
/* loaded from: classes4.dex */
public final class C1871x31a081c4<T> extends AtomicInteger implements s51<T>, t51 {
    public static final long serialVersionUID = 3240706908776709697L;
    public final s51<? super T> actual;
    public final long bufferSize;
    public volatile boolean cancelled;
    public volatile boolean done;
    public Throwable error;
    public final r60 onOverflow;

    /* renamed from: s */
    public t51 f4379s;
    public final BackpressureOverflowStrategy strategy;
    public final AtomicLong requested = new AtomicLong();
    public final Deque<T> deque = new ArrayDeque();

    public C1871x31a081c4(s51<? super T> s51Var, r60 r60Var, BackpressureOverflowStrategy backpressureOverflowStrategy, long j) {
        this.actual = s51Var;
        this.onOverflow = r60Var;
        this.strategy = backpressureOverflowStrategy;
        this.bufferSize = j;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        this.cancelled = true;
        this.f4379s.cancel();
        if (getAndIncrement() == 0) {
            clear(this.deque);
        }
    }

    public void clear(Deque<T> deque) {
        synchronized (deque) {
            deque.clear();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x004f, code lost:
        if (r10 != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0053, code lost:
        if (r14.cancelled == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
        r4 = r14.done;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005b, code lost:
        monitor-enter(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005c, code lost:
        r5 = r0.isEmpty();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0060, code lost:
        monitor-exit(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0061, code lost:
        if (r4 == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0063, code lost:
        r4 = r14.error;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0065, code lost:
        if (r4 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006e, code lost:
        if (r5 == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0070, code lost:
        r1.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0073, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0067, code lost:
        clear(r0);
        r1.onError(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x006d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0055, code lost:
        clear(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0058, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0079, code lost:
        if (r8 == 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x007b, code lost:
        me.tvspark.r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r14.requested, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0080, code lost:
        r3 = addAndGet(-r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        T poll;
        if (getAndIncrement() != 0) {
            return;
        }
        Deque<T> deque = this.deque;
        s51<? super T> s51Var = this.actual;
        int i = 1;
        do {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i2 == 0) {
                    break;
                } else if (this.cancelled) {
                    clear(deque);
                    return;
                } else {
                    boolean z = this.done;
                    synchronized (deque) {
                        poll = deque.poll();
                    }
                    boolean z2 = poll == null;
                    if (z) {
                        Throwable th = this.error;
                        if (th != null) {
                            clear(deque);
                            s51Var.onError(th);
                            return;
                        } else if (z2) {
                            s51Var.onComplete();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    s51Var.onNext(poll);
                    j2++;
                }
            }
        } while (i != 0);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.done) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        boolean z;
        boolean z2;
        MissingBackpressureException th;
        if (this.done) {
            return;
        }
        Deque<T> deque = this.deque;
        synchronized (deque) {
            z = false;
            z2 = true;
            if (deque.size() == this.bufferSize) {
                int ordinal = this.strategy.ordinal();
                if (ordinal == 1) {
                    deque.poll();
                } else if (ordinal == 2) {
                    deque.pollLast();
                }
                deque.offer(t);
                z = true;
            } else {
                deque.offer(t);
            }
            z2 = false;
        }
        if (z) {
            r60 r60Var = this.onOverflow;
            if (r60Var == null) {
                return;
            }
            try {
                r60Var.run();
                return;
            } catch (Throwable th2) {
                th = th2;
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.f4379s.cancel();
            }
        } else if (!z2) {
            drain();
            return;
        } else {
            this.f4379s.cancel();
            th = new MissingBackpressureException();
        }
        onError(th);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4379s, t51Var)) {
            this.f4379s = t51Var;
            this.actual.onSubscribe(this);
            t51Var.request(Long.MAX_VALUE);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
            drain();
        }
    }
}

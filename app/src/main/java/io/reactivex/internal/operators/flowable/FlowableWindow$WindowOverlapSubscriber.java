package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.sc0;
import me.tvspark.t51;
import me.tvspark.x50;

/* loaded from: classes4.dex */
public final class FlowableWindow$WindowOverlapSubscriber<T> extends AtomicInteger implements s51<T>, t51, Runnable {
    public static final long serialVersionUID = 2428527070996323976L;
    public final s51<? super x50<T>> actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public volatile boolean done;
    public Throwable error;
    public long index;
    public long produced;
    public final sc0<UnicastProcessor<T>> queue;

    /* renamed from: s */
    public t51 f4410s;
    public final long size;
    public final long skip;
    public final ArrayDeque<UnicastProcessor<T>> windows = new ArrayDeque<>();
    public final AtomicBoolean once = new AtomicBoolean();
    public final AtomicBoolean firstRequest = new AtomicBoolean();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableWindow$WindowOverlapSubscriber(s51<? super x50<T>> s51Var, long j, long j2, int i) {
        super(1);
        this.actual = s51Var;
        this.size = j;
        this.skip = j2;
        this.queue = new sc0<>(i);
        this.bufferSize = i;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        this.cancelled = true;
        if (this.once.compareAndSet(false, true)) {
            run();
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, s51<?> s51Var, sc0<?> sc0Var) {
        if (this.cancelled) {
            sc0Var.clear();
            return true;
        } else if (!z) {
            return false;
        } else {
            Throwable th = this.error;
            if (th != null) {
                sc0Var.clear();
                s51Var.onError(th);
                return true;
            } else if (!z2) {
                return false;
            } else {
                s51Var.onComplete();
                return true;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003a, code lost:
        if (r10 != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
        if (checkTerminated(r14.done, r1.isEmpty(), r0, r1) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
        if (r8 == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
        if (r4 == Long.MAX_VALUE) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
        r14.requested.addAndGet(-r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
        r3 = r14.wip.addAndGet(-r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        s51<? super x50<T>> s51Var = this.actual;
        sc0<UnicastProcessor<T>> sc0Var = this.queue;
        int i = 1;
        do {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i2 == 0) {
                    break;
                }
                boolean z = this.done;
                UnicastProcessor<T> mo4868poll = sc0Var.mo4868poll();
                boolean z2 = mo4868poll == null;
                if (checkTerminated(z, z2, s51Var, sc0Var)) {
                    return;
                }
                if (z2) {
                    break;
                }
                s51Var.onNext(mo4868poll);
                j2++;
            }
        } while (i != 0);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.done) {
            return;
        }
        Iterator<UnicastProcessor<T>> it = this.windows.iterator();
        while (it.hasNext()) {
            it.next().onComplete();
        }
        this.windows.clear();
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.done) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        Iterator<UnicastProcessor<T>> it = this.windows.iterator();
        while (it.hasNext()) {
            it.next().onError(th);
        }
        this.windows.clear();
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        long j = this.index;
        if (j == 0 && !this.cancelled) {
            getAndIncrement();
            UnicastProcessor<T> unicastProcessor = new UnicastProcessor<>(this.bufferSize, this);
            this.windows.offer(unicastProcessor);
            this.queue.offer(unicastProcessor);
            drain();
        }
        long j2 = j + 1;
        Iterator<UnicastProcessor<T>> it = this.windows.iterator();
        while (it.hasNext()) {
            it.next().onNext(t);
        }
        long j3 = this.produced + 1;
        if (j3 == this.size) {
            this.produced = j3 - this.skip;
            UnicastProcessor<T> poll = this.windows.poll();
            if (poll != null) {
                poll.onComplete();
            }
        } else {
            this.produced = j3;
        }
        if (j2 == this.skip) {
            this.index = 0L;
        } else {
            this.index = j2;
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4410s, t51Var)) {
            this.f4410s = t51Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
            if (this.firstRequest.get() || !this.firstRequest.compareAndSet(false, true)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.skip, j);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.size, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.skip, j - 1));
            }
            this.f4410s.request(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            drain();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (decrementAndGet() == 0) {
            this.f4410s.cancel();
        }
    }
}

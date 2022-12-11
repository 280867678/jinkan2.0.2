package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.a60;
import me.tvspark.o60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.w80;

/* loaded from: classes4.dex */
public final class MaybeMergeArray$MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements a60<T> {
    public static final long serialVersionUID = -660395290758764731L;
    public final s51<? super T> actual;
    public volatile boolean cancelled;
    public long consumed;
    public boolean outputFused;
    public final w80<Object> queue;
    public final int sourceCount;
    public final o60 set = new o60();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicThrowable error = new AtomicThrowable();

    public MaybeMergeArray$MergeMaybeObserver(s51<? super T> s51Var, int i, w80<Object> w80Var) {
        this.actual = s51Var;
        this.sourceCount = i;
        this.queue = w80Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.set.dispose();
            if (getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
        }
    }

    @Override // me.tvspark.t70
    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        if (this.outputFused) {
            drainFused();
        } else {
            drainNormal();
        }
    }

    public void drainFused() {
        s51<? super T> s51Var = this.actual;
        w80<Object> w80Var = this.queue;
        int i = 1;
        while (!this.cancelled) {
            Throwable th = this.error.get();
            if (th != null) {
                w80Var.clear();
                s51Var.onError(th);
                return;
            }
            boolean z = w80Var.producerIndex() == this.sourceCount;
            if (!w80Var.isEmpty()) {
                s51Var.onNext(null);
            }
            if (z) {
                s51Var.onComplete();
                return;
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        w80Var.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
        if (r7 != 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (r10.error.get() == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
        if (r1.peek() != io.reactivex.internal.util.NotificationLite.COMPLETE) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
        r1.drop();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
        if (r1.consumerIndex() != r10.sourceCount) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006f, code lost:
        r0.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0072, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0023, code lost:
        r1.clear();
        r0.onError(r10.error.terminate());
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x002f, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0073, code lost:
        r10.consumed = r2;
        r4 = addAndGet(-r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drainNormal() {
        s51<? super T> s51Var = this.actual;
        w80<Object> w80Var = this.queue;
        long j = this.consumed;
        int i = 1;
        loop0: do {
            long j2 = this.requested.get();
            while (true) {
                int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                if (i2 != 0) {
                    if (!this.cancelled) {
                        if (this.error.get() != null) {
                            break loop0;
                        } else if (w80Var.consumerIndex() == this.sourceCount) {
                            s51Var.onComplete();
                            return;
                        } else {
                            Object mo4868poll = w80Var.mo4868poll();
                            if (mo4868poll == null) {
                                break;
                            } else if (mo4868poll != NotificationLite.COMPLETE) {
                                s51Var.onNext(mo4868poll);
                                j++;
                            }
                        }
                    } else {
                        w80Var.clear();
                        return;
                    }
                } else {
                    break;
                }
            }
        } while (i != 0);
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // me.tvspark.t70
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // me.tvspark.a60
    public void onComplete() {
        this.queue.offer(NotificationLite.COMPLETE);
        drain();
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        if (!this.error.addThrowable(th)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.set.dispose();
        this.queue.offer(NotificationLite.COMPLETE);
        drain();
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var);
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        this.queue.offer(t);
        drain();
    }

    @Override // me.tvspark.t70
    /* renamed from: poll */
    public T mo4868poll() throws Exception {
        T t;
        do {
            t = (T) this.queue.mo4868poll();
        } while (t == NotificationLite.COMPLETE);
        return t;
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
        if ((i & 2) != 0) {
            this.outputFused = true;
            return 2;
        }
        return 0;
    }
}

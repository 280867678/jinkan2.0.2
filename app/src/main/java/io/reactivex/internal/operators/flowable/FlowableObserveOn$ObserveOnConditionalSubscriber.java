package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import me.tvspark.k60;
import me.tvspark.m70;
import me.tvspark.q70;
import me.tvspark.r40;
import me.tvspark.t51;
import me.tvspark.t70;

/* loaded from: classes4.dex */
public final class FlowableObserveOn$ObserveOnConditionalSubscriber<T> extends FlowableObserveOn$BaseObserveOnSubscriber<T> {
    public static final long serialVersionUID = 644624475404284533L;
    public final m70<? super T> actual;
    public long consumed;

    public FlowableObserveOn$ObserveOnConditionalSubscriber(m70<? super T> m70Var, k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z, int i) {
        super(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z, i);
        this.actual = m70Var;
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4377s, t51Var)) {
            this.f4377s = t51Var;
            if (t51Var instanceof q70) {
                q70 q70Var = (q70) t51Var;
                int requestFusion = q70Var.requestFusion(7);
                if (requestFusion == 1) {
                    this.sourceMode = 1;
                    this.queue = q70Var;
                    this.done = true;
                    this.actual.onSubscribe(this);
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = 2;
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
    public T mo4868poll() throws Exception {
        T mo4868poll = this.queue.mo4868poll();
        if (mo4868poll != null && this.sourceMode != 1) {
            long j = this.consumed + 1;
            if (j == this.limit) {
                this.consumed = 0L;
                this.f4377s.request(j);
            } else {
                this.consumed = j;
            }
        }
        return mo4868poll;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runAsync() {
        int i;
        m70<? super T> m70Var = this.actual;
        t70<T> t70Var = this.queue;
        long j = this.produced;
        long j2 = this.consumed;
        int i2 = 1;
        while (true) {
            long j3 = this.requested.get();
            while (true) {
                i = (j > j3 ? 1 : (j == j3 ? 0 : -1));
                if (i == 0) {
                    break;
                }
                boolean z = this.done;
                try {
                    Object obj = (T) t70Var.mo4868poll();
                    boolean z2 = obj == null;
                    if (checkTerminated(z, z2, m70Var)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    if (m70Var.tryOnNext(obj)) {
                        j++;
                    }
                    j2++;
                    if (j2 == this.limit) {
                        this.f4377s.request(j2);
                        j2 = 0;
                    }
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    this.f4377s.cancel();
                    t70Var.clear();
                    m70Var.onError(th);
                    this.worker.dispose();
                    return;
                }
            }
            if (i != 0 || !checkTerminated(this.done, t70Var.isEmpty(), m70Var)) {
                int i3 = get();
                if (i2 == i3) {
                    this.produced = j;
                    this.consumed = j2;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    i2 = i3;
                }
            } else {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runBackfused() {
        int i = 1;
        while (!this.cancelled) {
            boolean z = this.done;
            this.actual.onNext(null);
            if (z) {
                Throwable th = this.error;
                if (th != null) {
                    this.actual.onError(th);
                } else {
                    this.actual.onComplete();
                }
                this.worker.dispose();
                return;
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x001c, code lost:
        r0.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003e, code lost:
        if (r9.cancelled == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0045, code lost:
        if (r1.isEmpty() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0048, code lost:
        r5 = get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004c, code lost:
        if (r4 != r5) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004e, code lost:
        r9.produced = r2;
        r4 = addAndGet(-r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0055, code lost:
        if (r4 != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0057, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0040, code lost:
        return;
     */
    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void runSync() {
        m70<? super T> m70Var = this.actual;
        t70<T> t70Var = this.queue;
        long j = this.produced;
        int i = 1;
        loop0: while (true) {
            long j2 = this.requested.get();
            while (true) {
                if (j == j2) {
                    break;
                }
                try {
                    Object obj = (T) t70Var.mo4868poll();
                    if (this.cancelled) {
                        return;
                    }
                    if (obj == null) {
                        break loop0;
                    } else if (m70Var.tryOnNext(obj)) {
                        j++;
                    }
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    this.f4377s.cancel();
                    m70Var.onError(th);
                    this.worker.dispose();
                    return;
                }
            }
        }
    }
}

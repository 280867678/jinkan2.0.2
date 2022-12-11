package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import me.tvspark.k60;
import me.tvspark.q70;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.t70;

/* loaded from: classes4.dex */
public final class FlowableObserveOn$ObserveOnSubscriber<T> extends FlowableObserveOn$BaseObserveOnSubscriber<T> implements s51<T> {
    public static final long serialVersionUID = -4547113800637756442L;
    public final s51<? super T> actual;

    public FlowableObserveOn$ObserveOnSubscriber(s51<? super T> s51Var, k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z, int i) {
        super(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z, i);
        this.actual = s51Var;
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
            long j = this.produced + 1;
            if (j == this.limit) {
                this.produced = 0L;
                this.f4377s.request(j);
            } else {
                this.produced = j;
            }
        }
        return mo4868poll;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    public void runAsync() {
        int i;
        s51<? super T> s51Var = this.actual;
        t70<T> t70Var = this.queue;
        long j = this.produced;
        int i2 = 1;
        while (true) {
            long j2 = this.requested.get();
            while (true) {
                i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                if (i == 0) {
                    break;
                }
                boolean z = this.done;
                try {
                    Object obj = (T) t70Var.mo4868poll();
                    boolean z2 = obj == null;
                    if (checkTerminated(z, z2, s51Var)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    s51Var.onNext(obj);
                    j++;
                    if (j == this.limit) {
                        if (j2 != Long.MAX_VALUE) {
                            j2 = this.requested.addAndGet(-j);
                        }
                        this.f4377s.request(j);
                        j = 0;
                    }
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    this.f4377s.cancel();
                    t70Var.clear();
                    s51Var.onError(th);
                    this.worker.dispose();
                    return;
                }
            }
            if (i != 0 || !checkTerminated(this.done, t70Var.isEmpty(), s51Var)) {
                int i3 = get();
                if (i2 == i3) {
                    this.produced = j;
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

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
        r0.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
        if (r9.cancelled == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
        if (r1.isEmpty() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
        r5 = get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
        if (r4 != r5) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004b, code lost:
        r9.produced = r2;
        r4 = addAndGet(-r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0052, code lost:
        if (r4 != 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0054, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x003d, code lost:
        return;
     */
    @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn$BaseObserveOnSubscriber
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void runSync() {
        s51<? super T> s51Var = this.actual;
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
                    }
                    s51Var.onNext(obj);
                    j++;
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    this.f4377s.cancel();
                    s51Var.onError(th);
                    this.worker.dispose();
                    return;
                }
            }
        }
    }
}

package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.t70;

/* loaded from: classes4.dex */
public final class FlowableZip$ZipCoordinator<T, R> extends AtomicInteger implements t51 {
    public static final long serialVersionUID = -2434867452883857743L;
    public final s51<? super R> actual;
    public volatile boolean cancelled;
    public final Object[] current;
    public final boolean delayErrors;
    public volatile boolean done;
    public final AtomicThrowable errors;
    public final AtomicLong requested;
    public final FlowableZip$ZipSubscriber<T, R>[] subscribers;
    public final f70<? super Object[], ? extends R> zipper;

    public FlowableZip$ZipCoordinator(s51<? super R> s51Var, f70<? super Object[], ? extends R> f70Var, int i, int i2, boolean z) {
        this.actual = s51Var;
        this.zipper = f70Var;
        this.delayErrors = z;
        FlowableZip$ZipSubscriber<T, R>[] flowableZip$ZipSubscriberArr = new FlowableZip$ZipSubscriber[i];
        for (int i3 = 0; i3 < i; i3++) {
            flowableZip$ZipSubscriberArr[i3] = new FlowableZip$ZipSubscriber<>(this, i2, i3);
        }
        this.current = new Object[i];
        this.subscribers = flowableZip$ZipSubscriberArr;
        this.requested = new AtomicLong();
        this.errors = new AtomicThrowable();
    }

    @Override // me.tvspark.t51
    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            cancelAll();
        }
    }

    public void cancelAll() {
        for (FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber : this.subscribers) {
            flowableZip$ZipSubscriber.cancel();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x00be, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0121, code lost:
        if (r12 == 0) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0123, code lost:
        r0 = r3.length;
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0125, code lost:
        if (r15 >= r0) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0127, code lost:
        r3[r15].request(r12);
        r15 = r15 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0136, code lost:
        if (r8 == Long.MAX_VALUE) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0138, code lost:
        r18.requested.addAndGet(-r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x013e, code lost:
        r7 = addAndGet(-r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b8, code lost:
        if (r16 != 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00bc, code lost:
        if (r18.cancelled == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c1, code lost:
        if (r18.delayErrors != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c9, code lost:
        if (r18.errors.get() == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00cd, code lost:
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ce, code lost:
        if (r6 >= r4) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00d0, code lost:
        r0 = r3[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00d4, code lost:
        if (r5[r6] != null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00d6, code lost:
        r10 = r0.done;
        r0 = r0.queue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00da, code lost:
        if (r0 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00dc, code lost:
        r0 = r0.mo4868poll();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00e2, code lost:
        if (r0 != null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00e4, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00e7, code lost:
        if (r10 == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00e9, code lost:
        if (r11 == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00eb, code lost:
        cancelAll();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00f6, code lost:
        if (r18.errors.get() == null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00f8, code lost:
        r2.onError(r18.errors.terminate());
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0102, code lost:
        r2.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0105, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0106, code lost:
        if (r11 != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0108, code lost:
        r5[r6] = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x011a, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00e6, code lost:
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00e1, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x010b, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x010c, code lost:
        me.tvspark.r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r0);
        r18.errors.addThrowable(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0116, code lost:
        if (r18.delayErrors == false) goto L97;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        boolean z;
        T mo4868poll;
        boolean z2;
        if (getAndIncrement() != 0) {
            return;
        }
        s51<? super R> s51Var = this.actual;
        FlowableZip$ZipSubscriber<T, R>[] flowableZip$ZipSubscriberArr = this.subscribers;
        int length = flowableZip$ZipSubscriberArr.length;
        Object[] objArr = this.current;
        int i = 1;
        loop0: do {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                if (i2 == 0) {
                    break;
                } else if (this.cancelled) {
                    return;
                } else {
                    if (!this.delayErrors && this.errors.get() != null) {
                        break loop0;
                    }
                    boolean z3 = false;
                    for (int i3 = 0; i3 < length; i3++) {
                        FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber = flowableZip$ZipSubscriberArr[i3];
                        if (objArr[i3] == null) {
                            try {
                                z = flowableZip$ZipSubscriber.done;
                                t70<T> t70Var = flowableZip$ZipSubscriber.queue;
                                mo4868poll = t70Var != null ? t70Var.mo4868poll() : null;
                                z2 = mo4868poll == null;
                            } catch (Throwable th) {
                                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                                this.errors.addThrowable(th);
                                if (!this.delayErrors) {
                                    break loop0;
                                }
                            }
                            if (z && z2) {
                                cancelAll();
                                if (this.errors.get() != null) {
                                    s51Var.onError(this.errors.terminate());
                                    return;
                                } else {
                                    s51Var.onComplete();
                                    return;
                                }
                            }
                            if (!z2) {
                                objArr[i3] = mo4868poll;
                            }
                            z3 = true;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    try {
                        Object obj = (R) this.zipper.apply(objArr.clone());
                        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "The zipper returned a null value");
                        s51Var.onNext(obj);
                        j2++;
                        Arrays.fill(objArr, (Object) null);
                    } catch (Throwable th2) {
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                        cancelAll();
                        this.errors.addThrowable(th2);
                    }
                }
            }
            cancelAll();
            s51Var.onError(this.errors.terminate());
            return;
        } while (i != 0);
    }

    public void error(FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber, Throwable th) {
        if (!this.errors.addThrowable(th)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        flowableZip$ZipSubscriber.done = true;
        drain();
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
            drain();
        }
    }

    public void subscribe(r51<? extends T>[] r51VarArr, int i) {
        FlowableZip$ZipSubscriber<T, R>[] flowableZip$ZipSubscriberArr = this.subscribers;
        for (int i2 = 0; i2 < i && !this.done && !this.cancelled; i2++) {
            if (!this.delayErrors && this.errors.get() != null) {
                return;
            }
            r51VarArr[i2].subscribe(flowableZip$ZipSubscriberArr[i2]);
        }
    }
}

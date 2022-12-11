package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.q70;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.t70;

/* loaded from: classes4.dex */
public final class FlowablePublish$PublishSubscriber<T> extends AtomicInteger implements s51<T>, p60 {
    public static final FlowablePublish$InnerSubscriber[] EMPTY = new FlowablePublish$InnerSubscriber[0];
    public static final FlowablePublish$InnerSubscriber[] TERMINATED = new FlowablePublish$InnerSubscriber[0];
    public static final long serialVersionUID = -202316842419149694L;
    public final int bufferSize;
    public final AtomicReference<FlowablePublish$PublishSubscriber<T>> current;
    public volatile t70<T> queue;
    public int sourceMode;
    public volatile Object terminalEvent;

    /* renamed from: s */
    public final AtomicReference<t51> f4383s = new AtomicReference<>();
    public final AtomicReference<FlowablePublish$InnerSubscriber[]> subscribers = new AtomicReference<>(EMPTY);
    public final AtomicBoolean shouldConnect = new AtomicBoolean();

    public FlowablePublish$PublishSubscriber(AtomicReference<FlowablePublish$PublishSubscriber<T>> atomicReference, int i) {
        this.current = atomicReference;
        this.bufferSize = i;
    }

    public boolean add(FlowablePublish$InnerSubscriber<T> flowablePublish$InnerSubscriber) {
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr;
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr2;
        do {
            flowablePublish$InnerSubscriberArr = this.subscribers.get();
            if (flowablePublish$InnerSubscriberArr == TERMINATED) {
                return false;
            }
            int length = flowablePublish$InnerSubscriberArr.length;
            flowablePublish$InnerSubscriberArr2 = new FlowablePublish$InnerSubscriber[length + 1];
            System.arraycopy(flowablePublish$InnerSubscriberArr, 0, flowablePublish$InnerSubscriberArr2, 0, length);
            flowablePublish$InnerSubscriberArr2[length] = flowablePublish$InnerSubscriber;
        } while (!this.subscribers.compareAndSet(flowablePublish$InnerSubscriberArr, flowablePublish$InnerSubscriberArr2));
        return true;
    }

    public boolean checkTerminated(Object obj, boolean z) {
        int i = 0;
        if (obj != null) {
            if (!NotificationLite.isComplete(obj)) {
                Throwable error = NotificationLite.getError(obj);
                this.current.compareAndSet(this, null);
                FlowablePublish$InnerSubscriber[] andSet = this.subscribers.getAndSet(TERMINATED);
                if (andSet.length != 0) {
                    int length = andSet.length;
                    while (i < length) {
                        andSet[i].child.onError(error);
                        i++;
                    }
                } else {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(error);
                }
                return true;
            } else if (z) {
                this.current.compareAndSet(this, null);
                FlowablePublish$InnerSubscriber[] andSet2 = this.subscribers.getAndSet(TERMINATED);
                int length2 = andSet2.length;
                while (i < length2) {
                    andSet2[i].child.onComplete();
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0114, code lost:
        if (r16 == false) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatch() {
        int i;
        long j;
        long j2;
        T t;
        T t2;
        if (getAndIncrement() != 0) {
            return;
        }
        int i2 = 1;
        int i3 = 1;
        while (true) {
            Object obj = this.terminalEvent;
            t70<T> t70Var = this.queue;
            boolean z = t70Var == null || t70Var.isEmpty();
            if (checkTerminated(obj, z)) {
                return;
            }
            if (!z) {
                FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr = this.subscribers.get();
                int length = flowablePublish$InnerSubscriberArr.length;
                long j3 = Long.MAX_VALUE;
                int length2 = flowablePublish$InnerSubscriberArr.length;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    j = 0;
                    if (i4 >= length2) {
                        break;
                    }
                    boolean z2 = z;
                    long j4 = flowablePublish$InnerSubscriberArr[i4].get();
                    if (j4 >= 0) {
                        j3 = Math.min(j3, j4);
                    } else if (j4 == Long.MIN_VALUE) {
                        i5++;
                    }
                    i4++;
                    z = z2;
                }
                boolean z3 = z;
                if (length == i5) {
                    Object obj2 = this.terminalEvent;
                    try {
                        t2 = t70Var.mo4868poll();
                    } catch (Throwable th) {
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                        this.f4383s.get().cancel();
                        obj2 = NotificationLite.error(th);
                        this.terminalEvent = obj2;
                        t2 = null;
                    }
                    if (checkTerminated(obj2, t2 == null)) {
                        return;
                    }
                    if (this.sourceMode != i2) {
                        this.f4383s.get().request(1L);
                    }
                    i = i3;
                } else {
                    i = i3;
                    int i6 = 0;
                    while (true) {
                        j2 = i6;
                        if (j2 >= j3) {
                            break;
                        }
                        Object obj3 = this.terminalEvent;
                        try {
                            t = t70Var.mo4868poll();
                        } catch (Throwable th2) {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                            this.f4383s.get().cancel();
                            obj3 = NotificationLite.error(th2);
                            this.terminalEvent = obj3;
                            t = null;
                        }
                        boolean z4 = t == null;
                        if (checkTerminated(obj3, z4)) {
                            return;
                        }
                        if (z4) {
                            z3 = z4;
                            break;
                        }
                        Object value = NotificationLite.getValue(t);
                        int length3 = flowablePublish$InnerSubscriberArr.length;
                        int i7 = 0;
                        while (i7 < length3) {
                            FlowablePublish$InnerSubscriber flowablePublish$InnerSubscriber = flowablePublish$InnerSubscriberArr[i7];
                            if (flowablePublish$InnerSubscriber.get() > j) {
                                flowablePublish$InnerSubscriber.child.onNext(value);
                                flowablePublish$InnerSubscriber.produced(1L);
                            }
                            i7++;
                            j = 0;
                        }
                        i6++;
                        z3 = z4;
                        j = 0;
                    }
                    if (i6 > 0 && this.sourceMode != 1) {
                        this.f4383s.get().request(j2);
                    }
                    if (j3 != 0) {
                    }
                }
                i3 = i;
                i2 = 1;
            } else {
                i = i3;
            }
            i3 = addAndGet(-i);
            if (i3 == 0) {
                return;
            }
            i2 = 1;
        }
    }

    @Override // me.tvspark.p60
    public void dispose() {
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr = this.subscribers.get();
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr2 = TERMINATED;
        if (flowablePublish$InnerSubscriberArr == flowablePublish$InnerSubscriberArr2 || this.subscribers.getAndSet(flowablePublish$InnerSubscriberArr2) == TERMINATED) {
            return;
        }
        this.current.compareAndSet(this, null);
        SubscriptionHelper.cancel(this.f4383s);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return this.subscribers.get() == TERMINATED;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.terminalEvent == null) {
            this.terminalEvent = NotificationLite.complete();
            dispatch();
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.terminalEvent != null) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.terminalEvent = NotificationLite.error(th);
        dispatch();
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.sourceMode != 0 || this.queue.offer(t)) {
            dispatch();
        } else {
            onError(new MissingBackpressureException("Prefetch queue is full?!"));
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this.f4383s, t51Var)) {
            if (t51Var instanceof q70) {
                q70 q70Var = (q70) t51Var;
                int requestFusion = q70Var.requestFusion(3);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = q70Var;
                    this.terminalEvent = NotificationLite.complete();
                    dispatch();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = q70Var;
                    t51Var.request(this.bufferSize);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.bufferSize);
            t51Var.request(this.bufferSize);
        }
    }

    public void remove(FlowablePublish$InnerSubscriber<T> flowablePublish$InnerSubscriber) {
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr;
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr2;
        do {
            flowablePublish$InnerSubscriberArr = this.subscribers.get();
            int length = flowablePublish$InnerSubscriberArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (flowablePublish$InnerSubscriberArr[i2].equals(flowablePublish$InnerSubscriber)) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                flowablePublish$InnerSubscriberArr2 = EMPTY;
            } else {
                FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr3 = new FlowablePublish$InnerSubscriber[length - 1];
                System.arraycopy(flowablePublish$InnerSubscriberArr, 0, flowablePublish$InnerSubscriberArr3, 0, i);
                System.arraycopy(flowablePublish$InnerSubscriberArr, i + 1, flowablePublish$InnerSubscriberArr3, i, (length - i) - 1);
                flowablePublish$InnerSubscriberArr2 = flowablePublish$InnerSubscriberArr3;
            }
        } while (!this.subscribers.compareAndSet(flowablePublish$InnerSubscriberArr, flowablePublish$InnerSubscriberArr2));
    }
}

package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.o60;
import me.tvspark.p80;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.sc0;
import me.tvspark.t51;
import me.tvspark.t60;
import me.tvspark.t70;
import me.tvspark.x50;

/* loaded from: classes4.dex */
public final class FlowableJoin$JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements t51, p80 {
    public static final long serialVersionUID = -6071216598687999801L;
    public final s51<? super R> actual;
    public volatile boolean cancelled;
    public final f70<? super TLeft, ? extends r51<TLeftEnd>> leftEnd;
    public int leftIndex;
    public final t60<? super TLeft, ? super TRight, ? extends R> resultSelector;
    public final f70<? super TRight, ? extends r51<TRightEnd>> rightEnd;
    public int rightIndex;
    public static final Integer LEFT_VALUE = 1;
    public static final Integer RIGHT_VALUE = 2;
    public static final Integer LEFT_CLOSE = 3;
    public static final Integer RIGHT_CLOSE = 4;
    public final AtomicLong requested = new AtomicLong();
    public final o60 disposables = new o60();
    public final sc0<Object> queue = new sc0<>(x50.Wwwwwwwwwwwwwwwwwwwwwwww);
    public final Map<Integer, TLeft> lefts = new LinkedHashMap();
    public final Map<Integer, TRight> rights = new LinkedHashMap();
    public final AtomicReference<Throwable> error = new AtomicReference<>();
    public final AtomicInteger active = new AtomicInteger(2);

    public FlowableJoin$JoinSubscription(s51<? super R> s51Var, f70<? super TLeft, ? extends r51<TLeftEnd>> f70Var, f70<? super TRight, ? extends r51<TRightEnd>> f70Var2, t60<? super TLeft, ? super TRight, ? extends R> t60Var) {
        this.actual = s51Var;
        this.leftEnd = f70Var;
        this.rightEnd = f70Var2;
        this.resultSelector = t60Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        cancelAll();
        if (getAndIncrement() != 0) {
            return;
        }
        this.queue.clear();
    }

    public void cancelAll() {
        this.disposables.dispose();
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fa, code lost:
        if (r13 != 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fc, code lost:
        me.tvspark.r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r17.requested, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0194, code lost:
        if (r13 != 0) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber;
        Map map;
        long j;
        if (getAndIncrement() != 0) {
            return;
        }
        sc0<Object> sc0Var = this.queue;
        s51<? super R> s51Var = this.actual;
        boolean z = true;
        int i = 1;
        while (!this.cancelled) {
            if (this.error.get() != null) {
                sc0Var.clear();
                cancelAll();
                errorAll(s51Var);
                return;
            }
            boolean z2 = this.active.get() == 0;
            Integer num = (Integer) sc0Var.mo4868poll();
            boolean z3 = num == null;
            if (z2 && z3) {
                this.lefts.clear();
                this.rights.clear();
                this.disposables.dispose();
                s51Var.onComplete();
                return;
            } else if (z3) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                Object mo4868poll = sc0Var.mo4868poll();
                if (num == LEFT_VALUE) {
                    int i2 = this.leftIndex;
                    this.leftIndex = i2 + 1;
                    this.lefts.put(Integer.valueOf(i2), mo4868poll);
                    try {
                        r51 apply = this.leftEnd.apply(mo4868poll);
                        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The leftEnd returned a null Publisher");
                        r51 r51Var = apply;
                        FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber2 = new FlowableGroupJoin$LeftRightEndSubscriber(this, z, i2);
                        this.disposables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(flowableGroupJoin$LeftRightEndSubscriber2);
                        r51Var.subscribe(flowableGroupJoin$LeftRightEndSubscriber2);
                        if (this.error.get() != null) {
                            sc0Var.clear();
                            cancelAll();
                            errorAll(s51Var);
                            return;
                        }
                        long j2 = this.requested.get();
                        j = 0;
                        for (TRight tright : this.rights.values()) {
                            try {
                                Object obj = (R) this.resultSelector.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4868poll, tright);
                                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "The resultSelector returned a null value");
                                if (j == j2) {
                                    ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                    sc0Var.clear();
                                    cancelAll();
                                    errorAll(s51Var);
                                    return;
                                }
                                s51Var.onNext(obj);
                                j++;
                            } catch (Throwable th) {
                                fail(th, s51Var, sc0Var);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        fail(th2, s51Var, sc0Var);
                        return;
                    }
                } else {
                    if (num == RIGHT_VALUE) {
                        int i3 = this.rightIndex;
                        this.rightIndex = i3 + 1;
                        this.rights.put(Integer.valueOf(i3), mo4868poll);
                        try {
                            r51 apply2 = this.rightEnd.apply(mo4868poll);
                            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply2, "The rightEnd returned a null Publisher");
                            r51 r51Var2 = apply2;
                            FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber3 = new FlowableGroupJoin$LeftRightEndSubscriber(this, false, i3);
                            this.disposables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(flowableGroupJoin$LeftRightEndSubscriber3);
                            r51Var2.subscribe(flowableGroupJoin$LeftRightEndSubscriber3);
                            if (this.error.get() != null) {
                                sc0Var.clear();
                                cancelAll();
                                errorAll(s51Var);
                                return;
                            }
                            long j3 = this.requested.get();
                            j = 0;
                            for (TLeft tleft : this.lefts.values()) {
                                try {
                                    Object obj2 = (R) this.resultSelector.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tleft, mo4868poll);
                                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj2, "The resultSelector returned a null value");
                                    if (j == j3) {
                                        ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                        sc0Var.clear();
                                        cancelAll();
                                        errorAll(s51Var);
                                        return;
                                    }
                                    s51Var.onNext(obj2);
                                    j++;
                                } catch (Throwable th3) {
                                    fail(th3, s51Var, sc0Var);
                                    return;
                                }
                            }
                        } catch (Throwable th4) {
                            fail(th4, s51Var, sc0Var);
                            return;
                        }
                    } else {
                        if (num == LEFT_CLOSE) {
                            flowableGroupJoin$LeftRightEndSubscriber = (FlowableGroupJoin$LeftRightEndSubscriber) mo4868poll;
                            map = this.lefts;
                        } else if (num == RIGHT_CLOSE) {
                            flowableGroupJoin$LeftRightEndSubscriber = (FlowableGroupJoin$LeftRightEndSubscriber) mo4868poll;
                            map = this.rights;
                        }
                        map.remove(Integer.valueOf(flowableGroupJoin$LeftRightEndSubscriber.index));
                        this.disposables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(flowableGroupJoin$LeftRightEndSubscriber);
                    }
                    z = true;
                }
            }
        }
        sc0Var.clear();
    }

    public void errorAll(s51<?> s51Var) {
        Throwable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error);
        this.lefts.clear();
        this.rights.clear();
        s51Var.onError(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public void fail(Throwable th, s51<?> s51Var, t70<?> t70Var) {
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error, th);
        t70Var.clear();
        cancelAll();
        errorAll(s51Var);
    }

    @Override // me.tvspark.p80
    public void innerClose(boolean z, FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber) {
        synchronized (this) {
            this.queue.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z ? LEFT_CLOSE : RIGHT_CLOSE, flowableGroupJoin$LeftRightEndSubscriber);
        }
        drain();
    }

    @Override // me.tvspark.p80
    public void innerCloseError(Throwable th) {
        if (ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error, th)) {
            drain();
        } else {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }

    @Override // me.tvspark.p80
    public void innerComplete(FlowableGroupJoin$LeftRightSubscriber flowableGroupJoin$LeftRightSubscriber) {
        this.disposables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(flowableGroupJoin$LeftRightSubscriber);
        this.active.decrementAndGet();
        drain();
    }

    @Override // me.tvspark.p80
    public void innerError(Throwable th) {
        if (!ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error, th)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.active.decrementAndGet();
        drain();
    }

    @Override // me.tvspark.p80
    public void innerValue(boolean z, Object obj) {
        synchronized (this) {
            this.queue.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z ? LEFT_VALUE : RIGHT_VALUE, obj);
        }
        drain();
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
        }
    }
}

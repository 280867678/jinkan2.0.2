package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.m60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.s51;

/* loaded from: classes4.dex */
public final class SingleFlatMapIterableFlowable$FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements m60<T> {
    public static final long serialVersionUID = -8938804753851907758L;
    public final s51<? super R> actual;
    public volatile boolean cancelled;

    /* renamed from: d */
    public p60 f4467d;

    /* renamed from: it */
    public volatile Iterator<? extends R> f4468it;
    public final f70<? super T, ? extends Iterable<? extends R>> mapper;
    public boolean outputFused;
    public final AtomicLong requested = new AtomicLong();

    public SingleFlatMapIterableFlowable$FlatMapIterableObserver(s51<? super R> s51Var, f70<? super T, ? extends Iterable<? extends R>> f70Var) {
        this.actual = s51Var;
        this.mapper = f70Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        this.cancelled = true;
        this.f4467d.dispose();
        this.f4467d = DisposableHelper.DISPOSED;
    }

    @Override // me.tvspark.t70
    public void clear() {
        this.f4468it = null;
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        s51<? super R> s51Var = this.actual;
        Iterator<? extends R> it = this.f4468it;
        if (this.outputFused && it != null) {
            s51Var.onNext(null);
            s51Var.onComplete();
            return;
        }
        int i = 1;
        while (true) {
            if (it != null) {
                long j = this.requested.get();
                if (j == Long.MAX_VALUE) {
                    slowPath(s51Var, it);
                    return;
                }
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        Object obj = (R) it.next();
                        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "The iterator returned a null value");
                        s51Var.onNext(obj);
                        if (this.cancelled) {
                            return;
                        }
                        j2++;
                        try {
                            if (!it.hasNext()) {
                                s51Var.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                            s51Var.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                        s51Var.onError(th2);
                        return;
                    }
                }
                if (j2 != 0) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j2);
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (it == null) {
                it = this.f4468it;
            }
        }
    }

    @Override // me.tvspark.t70
    public boolean isEmpty() {
        return this.f4468it == null;
    }

    @Override // me.tvspark.m60
    public void onError(Throwable th) {
        this.f4467d = DisposableHelper.DISPOSED;
        this.actual.onError(th);
    }

    @Override // me.tvspark.m60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.validate(this.f4467d, p60Var)) {
            this.f4467d = p60Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.m60
    public void onSuccess(T t) {
        try {
            Iterator<? extends R> it = this.mapper.apply(t).iterator();
            if (!it.hasNext()) {
                this.actual.onComplete();
                return;
            }
            this.f4468it = it;
            drain();
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            this.actual.onError(th);
        }
    }

    @Override // me.tvspark.t70
    /* renamed from: poll */
    public R mo4868poll() throws Exception {
        Iterator<? extends R> it = this.f4468it;
        if (it != null) {
            R next = it.next();
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f4468it = null;
            }
            return next;
        }
        return null;
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

    public void slowPath(s51<? super R> s51Var, Iterator<? extends R> it) {
        while (!this.cancelled) {
            try {
                s51Var.onNext((R) it.next());
                if (this.cancelled) {
                    return;
                }
                if (!it.hasNext()) {
                    s51Var.onComplete();
                    return;
                }
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                s51Var.onError(th);
                return;
            }
        }
    }
}

package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.b60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class MaybeConcatArray$ConcatMaybeObserver<T> extends AtomicInteger implements a60<T>, t51 {
    public static final long serialVersionUID = 3520831347801429610L;
    public final s51<? super T> actual;
    public int index;
    public long produced;
    public final b60<? extends T>[] sources;
    public final AtomicLong requested = new AtomicLong();
    public final SequentialDisposable disposables = new SequentialDisposable();
    public final AtomicReference<Object> current = new AtomicReference<>(NotificationLite.COMPLETE);

    public MaybeConcatArray$ConcatMaybeObserver(s51<? super T> s51Var, b60<? extends T>[] b60VarArr) {
        this.actual = s51Var;
        this.sources = b60VarArr;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        this.disposables.dispose();
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        AtomicReference<Object> atomicReference = this.current;
        s51<? super T> s51Var = this.actual;
        while (!this.disposables.isDisposed()) {
            Object obj = atomicReference.get();
            if (obj != null) {
                boolean z = true;
                if (obj != NotificationLite.COMPLETE) {
                    long j = this.produced;
                    if (j != this.requested.get()) {
                        this.produced = j + 1;
                        atomicReference.lazySet(null);
                        s51Var.onNext(obj);
                    } else {
                        z = false;
                    }
                } else {
                    atomicReference.lazySet(null);
                }
                if (z) {
                    int i = this.index;
                    b60<? extends T>[] b60VarArr = this.sources;
                    if (i == b60VarArr.length) {
                        s51Var.onComplete();
                        return;
                    } else {
                        this.index = i + 1;
                        b60VarArr[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                    }
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        atomicReference.lazySet(null);
    }

    @Override // me.tvspark.a60
    public void onComplete() {
        this.current.lazySet(NotificationLite.COMPLETE);
        drain();
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        this.disposables.replace(p60Var);
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        this.current.lazySet(t);
        drain();
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
            drain();
        }
    }
}

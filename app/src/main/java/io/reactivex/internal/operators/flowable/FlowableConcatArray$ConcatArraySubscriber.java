package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableConcatArray$ConcatArraySubscriber<T> extends SubscriptionArbiter implements s51<T> {
    public static final long serialVersionUID = -8158322871608889516L;
    public final s51<? super T> actual;
    public final boolean delayError;
    public List<Throwable> errors;
    public int index;
    public long produced;
    public final r51<? extends T>[] sources;
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableConcatArray$ConcatArraySubscriber(r51<? extends T>[] r51VarArr, boolean z, s51<? super T> s51Var) {
        this.actual = s51Var;
        this.sources = r51VarArr;
        this.delayError = z;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.wip.getAndIncrement() == 0) {
            r51<? extends T>[] r51VarArr = this.sources;
            int length = r51VarArr.length;
            int i = this.index;
            while (i != length) {
                r51<? extends T> r51Var = r51VarArr[i];
                if (r51Var == null) {
                    NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                    if (!this.delayError) {
                        this.actual.onError(nullPointerException);
                        return;
                    }
                    List list = this.errors;
                    if (list == null) {
                        list = new ArrayList((length - i) + 1);
                        this.errors = list;
                    }
                    list.add(nullPointerException);
                    i++;
                } else {
                    long j = this.produced;
                    if (j != 0) {
                        this.produced = 0L;
                        produced(j);
                    }
                    r51Var.subscribe(this);
                    i++;
                    this.index = i;
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
            List<Throwable> list2 = this.errors;
            if (list2 == null) {
                this.actual.onComplete();
            } else if (list2.size() == 1) {
                this.actual.onError(list2.get(0));
            } else {
                this.actual.onError(new CompositeException(list2));
            }
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (!this.delayError) {
            this.actual.onError(th);
            return;
        }
        List list = this.errors;
        if (list == null) {
            list = new ArrayList((this.sources.length - this.index) + 1);
            this.errors = list;
        }
        list.add(th);
        onComplete();
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        this.produced++;
        this.actual.onNext(t);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        setSubscription(t51Var);
    }
}

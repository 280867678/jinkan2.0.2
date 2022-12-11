package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.l70;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableBuffer$PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements s51<T>, t51 {
    public static final long serialVersionUID = -5616169793639412593L;
    public final s51<? super C> actual;
    public C buffer;
    public final Callable<C> bufferSupplier;
    public boolean done;
    public int index;

    /* renamed from: s */
    public t51 f4359s;
    public final int size;
    public final int skip;

    public FlowableBuffer$PublisherBufferSkipSubscriber(s51<? super C> s51Var, int i, int i2, Callable<C> callable) {
        this.actual = s51Var;
        this.size = i;
        this.skip = i2;
        this.bufferSupplier = callable;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        this.f4359s.cancel();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        C c = this.buffer;
        this.buffer = null;
        if (c != null) {
            this.actual.onNext(c);
        }
        this.actual.onComplete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.done) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.done = true;
        this.buffer = null;
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        C c = this.buffer;
        int i = this.index;
        int i2 = i + 1;
        if (i == 0) {
            try {
                C call = this.bufferSupplier.call();
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The bufferSupplier returned a null buffer");
                c = call;
                this.buffer = c;
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                cancel();
                onError(th);
                return;
            }
        }
        if (c != null) {
            c.add(t);
            if (c.size() == this.size) {
                this.buffer = null;
                this.actual.onNext(c);
            }
        }
        if (i2 == this.skip) {
            i2 = 0;
        }
        this.index = i2;
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4359s, t51Var)) {
            this.f4359s = t51Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                this.f4359s.request(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.skip, j));
                return;
            }
            this.f4359s.request(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, this.size), r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.skip - this.size, j - 1)));
        }
    }
}

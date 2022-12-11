package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements s51<T>, t51 {
    public static final long COMPLETE_MASK = Long.MIN_VALUE;
    public static final long REQUEST_MASK = Long.MAX_VALUE;
    public static final long serialVersionUID = 7917814472626990048L;
    public final s51<? super R> actual;
    public long produced;

    /* renamed from: s */
    public t51 f4474s;
    public R value;

    public SinglePostCompleteSubscriber(s51<? super R> s51Var) {
        this.actual = s51Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        this.f4474s.cancel();
    }

    public final void complete(R r) {
        long j = this.produced;
        if (j != 0) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j);
        }
        while (true) {
            long j2 = get();
            if ((j2 & Long.MIN_VALUE) != 0) {
                onDrop(r);
                return;
            } else if ((j2 & Long.MAX_VALUE) != 0) {
                lazySet(-9223372036854775807L);
                this.actual.onNext(r);
                this.actual.onComplete();
                return;
            } else {
                this.value = r;
                if (compareAndSet(0L, Long.MIN_VALUE)) {
                    return;
                }
                this.value = null;
            }
        }
    }

    public void onDrop(R r) {
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4474s, t51Var)) {
            this.f4474s = t51Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.t51
    public final void request(long j) {
        long j2;
        if (SubscriptionHelper.validate(j)) {
            do {
                j2 = get();
                if ((j2 & Long.MIN_VALUE) != 0) {
                    if (!compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
                        return;
                    }
                    this.actual.onNext((R) this.value);
                    this.actual.onComplete();
                    return;
                }
            } while (!compareAndSet(j2, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, j)));
            this.f4474s.request(j);
        }
    }
}

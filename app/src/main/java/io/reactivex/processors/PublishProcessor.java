package io.reactivex.processors;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.nd0;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class PublishProcessor<T> extends nd0<T> {

    /* loaded from: classes4.dex */
    public static final class PublishSubscription<T> extends AtomicLong implements t51 {
        public static final long serialVersionUID = 3562861878281475070L;
        public final s51<? super T> actual;
        public final PublishProcessor<T> parent;

        public PublishSubscription(s51<? super T> s51Var, PublishProcessor<T> publishProcessor) {
            this.actual = s51Var;
            this.parent = publishProcessor;
        }

        @Override // me.tvspark.t51
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                throw null;
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.actual.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.actual.onError(th);
            } else {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            }
        }

        public void onNext(T t) {
            long j = get();
            if (j == Long.MIN_VALUE) {
                return;
            }
            if (j == 0) {
                cancel();
                this.actual.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
                return;
            }
            this.actual.onNext(t);
            if (j == Long.MAX_VALUE) {
                return;
            }
            decrementAndGet();
        }

        @Override // me.tvspark.t51
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j);
            }
        }
    }
}

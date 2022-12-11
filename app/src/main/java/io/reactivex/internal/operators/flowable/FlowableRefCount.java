package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.i80;
import me.tvspark.o60;
import me.tvspark.p60;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableRefCount<T> extends i80<T, T> {

    /* loaded from: classes4.dex */
    public final class ConnectionSubscriber extends AtomicReference<t51> implements s51<T>, t51 {
        public static final long serialVersionUID = 152064694420235350L;
        public final o60 currentBase;
        public final AtomicLong requested = new AtomicLong();
        public final p60 resource;
        public final s51<? super T> subscriber;

        public ConnectionSubscriber(s51<? super T> s51Var, o60 o60Var, p60 p60Var) {
            this.subscriber = s51Var;
            this.currentBase = o60Var;
            this.resource = p60Var;
        }

        @Override // me.tvspark.t51
        public void cancel() {
            SubscriptionHelper.cancel(this);
            this.resource.dispose();
        }

        public void cleanup() {
            throw null;
        }

        @Override // me.tvspark.s51
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // me.tvspark.s51
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // me.tvspark.s51
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // me.tvspark.s51
        public void onSubscribe(t51 t51Var) {
            SubscriptionHelper.deferredSetOnce(this, this.requested, t51Var);
        }

        @Override // me.tvspark.t51
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.requested, j);
        }
    }
}

package io.reactivex.processors;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import me.tvspark.nd0;
import me.tvspark.r40;
import me.tvspark.s51;

/* loaded from: classes4.dex */
public final class AsyncProcessor<T> extends nd0<T> {

    /* loaded from: classes4.dex */
    public static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        public static final long serialVersionUID = 5629876084736248016L;
        public final AsyncProcessor<T> parent;

        public AsyncSubscription(s51<? super T> s51Var, AsyncProcessor<T> asyncProcessor) {
            super(s51Var);
            this.parent = asyncProcessor;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, me.tvspark.t51
        public void cancel() {
            if (super.tryCancel()) {
                throw null;
            }
        }

        public void onComplete() {
            if (!isCancelled()) {
                this.actual.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (isCancelled()) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            } else {
                this.actual.onError(th);
            }
        }
    }
}

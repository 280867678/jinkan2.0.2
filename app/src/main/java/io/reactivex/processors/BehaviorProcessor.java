package io.reactivex.processors;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.cd0;
import me.tvspark.nd0;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class BehaviorProcessor<T> extends nd0<T> {
    public static final Object[] Wwwwwwwwwwwwwwwwwwwwwww = new Object[0];

    /* loaded from: classes4.dex */
    public static final class BehaviorSubscription<T> extends AtomicLong implements t51, cd0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Object> {
        public static final long serialVersionUID = 3293175281126227086L;
        public final s51<? super T> actual;
        public volatile boolean cancelled;
        public boolean emitting;
        public boolean fastPath;
        public long index;
        public boolean next;
        public cd0<Object> queue;
        public final BehaviorProcessor<T> state;

        public BehaviorSubscription(s51<? super T> s51Var, BehaviorProcessor<T> behaviorProcessor) {
            this.actual = s51Var;
            this.state = behaviorProcessor;
        }

        @Override // me.tvspark.t51
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                throw null;
            }
        }

        public void emitFirst() {
            if (this.cancelled) {
                return;
            }
            synchronized (this) {
                if (this.cancelled) {
                    return;
                }
                if (!this.next) {
                    throw null;
                }
            }
        }

        public void emitLoop() {
            cd0<Object> cd0Var;
            while (!this.cancelled) {
                synchronized (this) {
                    cd0Var = this.queue;
                    if (cd0Var == null) {
                        this.emitting = false;
                        return;
                    }
                    this.queue = null;
                }
                cd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((cd0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super Object>) this);
            }
        }

        public void emitNext(Object obj, long j) {
            if (this.cancelled) {
                return;
            }
            if (!this.fastPath) {
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    if (this.index == j) {
                        return;
                    }
                    if (this.emitting) {
                        cd0<Object> cd0Var = this.queue;
                        if (cd0Var == null) {
                            cd0Var = new cd0<>(4);
                            this.queue = cd0Var;
                        }
                        cd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((cd0<Object>) obj);
                        return;
                    }
                    this.next = true;
                    this.fastPath = true;
                }
            }
            test(obj);
        }

        @Override // me.tvspark.t51
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j);
            }
        }

        @Override // me.tvspark.cd0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, me.tvspark.g70
        public boolean test(Object obj) {
            if (this.cancelled) {
                return true;
            }
            if (NotificationLite.isComplete(obj)) {
                this.actual.onComplete();
                return true;
            } else if (NotificationLite.isError(obj)) {
                this.actual.onError(NotificationLite.getError(obj));
                return true;
            } else {
                long j = get();
                if (j == 0) {
                    cancel();
                    this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                    return true;
                }
                this.actual.onNext((Object) NotificationLite.getValue(obj));
                if (j == Long.MAX_VALUE) {
                    return false;
                }
                decrementAndGet();
                return false;
            }
        }
    }
}

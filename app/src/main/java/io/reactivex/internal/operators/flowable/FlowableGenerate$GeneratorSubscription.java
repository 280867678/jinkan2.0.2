package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.t60;
import me.tvspark.w50;
import me.tvspark.x60;

/* loaded from: classes4.dex */
public final class FlowableGenerate$GeneratorSubscription<T, S> extends AtomicLong implements w50<T>, t51 {
    public static final long serialVersionUID = 7565982551505011832L;
    public final s51<? super T> actual;
    public volatile boolean cancelled;
    public final x60<? super S> disposeState;
    public final t60<S, ? super w50<T>, S> generator;
    public S state;
    public boolean terminate;

    public FlowableGenerate$GeneratorSubscription(s51<? super T> s51Var, t60<S, ? super w50<T>, S> t60Var, x60<? super S> x60Var, S s) {
        this.actual = s51Var;
        this.generator = t60Var;
        this.disposeState = x60Var;
        this.state = s;
    }

    private void dispose(S s) {
        try {
            this.disposeState.accept(s);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }

    @Override // me.tvspark.t51
    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            if (r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, 1L) != 0) {
                return;
            }
            dispose(this.state);
        }
    }

    @Override // me.tvspark.w50
    public void onComplete() {
        this.terminate = true;
        this.actual.onComplete();
    }

    @Override // me.tvspark.w50
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.terminate = true;
        this.actual.onError(th);
    }

    @Override // me.tvspark.w50
    public void onNext(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            this.actual.onNext(t);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j) && r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j) == 0) {
            S s = this.state;
            t60<S, ? super w50<T>, S> t60Var = this.generator;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        j = get();
                        if (j2 == j) {
                            this.state = s;
                            j = addAndGet(-j2);
                        }
                    } else if (this.cancelled) {
                        dispose(s);
                        return;
                    } else {
                        try {
                            s = t60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s, this);
                            if (this.terminate) {
                                this.cancelled = true;
                                dispose(s);
                                return;
                            }
                            j2++;
                        } catch (Throwable th) {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                            this.cancelled = true;
                            this.actual.onError(th);
                            return;
                        }
                    }
                }
            } while (j != 0);
        }
    }
}

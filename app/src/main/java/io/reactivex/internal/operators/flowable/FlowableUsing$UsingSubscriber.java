package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.x60;

/* loaded from: classes4.dex */
public final class FlowableUsing$UsingSubscriber<T, D> extends AtomicBoolean implements s51<T>, t51 {
    public static final long serialVersionUID = 5904473792286235046L;
    public final s51<? super T> actual;
    public final x60<? super D> disposer;
    public final boolean eager;
    public final D resource;

    /* renamed from: s */
    public t51 f4408s;

    public FlowableUsing$UsingSubscriber(s51<? super T> s51Var, D d, x60<? super D> x60Var, boolean z) {
        this.actual = s51Var;
        this.resource = d;
        this.disposer = x60Var;
        this.eager = z;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        disposeAfter();
        this.f4408s.cancel();
    }

    public void disposeAfter() {
        if (compareAndSet(false, true)) {
            try {
                this.disposer.accept((D) this.resource);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            }
        }
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (!this.eager) {
            this.actual.onComplete();
            this.f4408s.cancel();
            disposeAfter();
            return;
        }
        if (compareAndSet(false, true)) {
            try {
                this.disposer.accept((D) this.resource);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.actual.onError(th);
                return;
            }
        }
        this.f4408s.cancel();
        this.actual.onComplete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (!this.eager) {
            this.actual.onError(th);
            this.f4408s.cancel();
            disposeAfter();
            return;
        }
        Throwable th2 = null;
        if (compareAndSet(false, true)) {
            try {
                this.disposer.accept((D) this.resource);
            } catch (Throwable th3) {
                th2 = th3;
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            }
        }
        this.f4408s.cancel();
        if (th2 != null) {
            this.actual.onError(new CompositeException(th, th2));
        } else {
            this.actual.onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4408s, t51Var)) {
            this.f4408s = t51Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        this.f4408s.request(j);
    }
}

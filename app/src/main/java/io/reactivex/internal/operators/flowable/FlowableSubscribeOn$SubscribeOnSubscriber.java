package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.k60;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableSubscribeOn$SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements s51<T>, t51, Runnable {
    public static final long serialVersionUID = 8094547886072529208L;
    public final s51<? super T> actual;
    public final boolean nonScheduledRequests;
    public r51<T> source;
    public final k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww worker;

    /* renamed from: s */
    public final AtomicReference<t51> f4399s = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final /* synthetic */ long Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ t51 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(FlowableSubscribeOn$SubscribeOnSubscriber flowableSubscribeOn$SubscribeOnSubscriber, t51 t51Var, long j) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = t51Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.request(this.Wwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public FlowableSubscribeOn$SubscribeOnSubscriber(s51<? super T> s51Var, k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, r51<T> r51Var, boolean z) {
        this.actual = s51Var;
        this.worker = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.source = r51Var;
        this.nonScheduledRequests = z;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        SubscriptionHelper.cancel(this.f4399s);
        this.worker.dispose();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.actual.onComplete();
        this.worker.dispose();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.actual.onError(th);
        this.worker.dispose();
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this.f4399s, t51Var)) {
            long andSet = this.requested.getAndSet(0L);
            if (andSet == 0) {
                return;
            }
            requestUpstream(andSet, t51Var);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            t51 t51Var = this.f4399s.get();
            if (t51Var != null) {
                requestUpstream(j, t51Var);
                return;
            }
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
            t51 t51Var2 = this.f4399s.get();
            if (t51Var2 == null) {
                return;
            }
            long andSet = this.requested.getAndSet(0L);
            if (andSet == 0) {
                return;
            }
            requestUpstream(andSet, t51Var2);
        }
    }

    public void requestUpstream(long j, t51 t51Var) {
        if (this.nonScheduledRequests || Thread.currentThread() == get()) {
            t51Var.request(j);
        } else {
            this.worker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, t51Var, j));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        lazySet(Thread.currentThread());
        r51<T> r51Var = this.source;
        this.source = null;
        r51Var.subscribe(this);
    }
}

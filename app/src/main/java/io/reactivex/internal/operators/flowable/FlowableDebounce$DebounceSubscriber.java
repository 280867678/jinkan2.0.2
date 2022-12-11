package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.td0;

/* loaded from: classes4.dex */
public final class FlowableDebounce$DebounceSubscriber<T, U> extends AtomicLong implements s51<T>, t51 {
    public static final long serialVersionUID = 6725975399620862591L;
    public final s51<? super T> actual;
    public final f70<? super T, ? extends r51<U>> debounceSelector;
    public final AtomicReference<p60> debouncer = new AtomicReference<>();
    public boolean done;
    public volatile long index;

    /* renamed from: s */
    public t51 f4365s;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, U> extends td0<U> {
        public final AtomicBoolean Wwwwwwwwwwwwwwwwwww = new AtomicBoolean();
        public boolean Wwwwwwwwwwwwwwwwwwww;
        public final T Wwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwww;
        public final FlowableDebounce$DebounceSubscriber<T, U> Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(FlowableDebounce$DebounceSubscriber<T, U> flowableDebounce$DebounceSubscriber, long j, T t) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = flowableDebounce$DebounceSubscriber;
            this.Wwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwww = t;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (this.Wwwwwwwwwwwwwwwwwww.compareAndSet(false, true)) {
                this.Wwwwwwwwwwwwwwwwwwwwwww.emit(this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww);
            }
        }

        @Override // me.tvspark.s51
        public void onComplete() {
            if (this.Wwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwww = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.s51
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.s51
        public void onNext(U u) {
            if (this.Wwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwww = true;
            SubscriptionHelper.cancel(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public FlowableDebounce$DebounceSubscriber(s51<? super T> s51Var, f70<? super T, ? extends r51<U>> f70Var) {
        this.actual = s51Var;
        this.debounceSelector = f70Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        this.f4365s.cancel();
        DisposableHelper.dispose(this.debouncer);
    }

    public void emit(long j, T t) {
        if (j == this.index) {
            if (get() != 0) {
                this.actual.onNext(t);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, 1L);
                return;
            }
            cancel();
            this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        p60 p60Var = this.debouncer.get();
        if (DisposableHelper.isDisposed(p60Var)) {
            return;
        }
        ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) p60Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        DisposableHelper.dispose(this.debouncer);
        this.actual.onComplete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        DisposableHelper.dispose(this.debouncer);
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        long j = this.index + 1;
        this.index = j;
        p60 p60Var = this.debouncer.get();
        if (p60Var != null) {
            p60Var.dispose();
        }
        try {
            r51<U> apply = this.debounceSelector.apply(t);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The publisher supplied is null");
            r51<U> r51Var = apply;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j, t);
            if (!this.debouncer.compareAndSet(p60Var, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return;
            }
            r51Var.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            cancel();
            this.actual.onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4365s, t51Var)) {
            this.f4365s = t51Var;
            this.actual.onSubscribe(this);
            t51Var.request(Long.MAX_VALUE);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j);
        }
    }
}

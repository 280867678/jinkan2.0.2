package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.i80;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableOnBackpressureLatest<T> extends i80<T, T> {

    /* loaded from: classes4.dex */
    public static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements s51<T>, t51 {
        public static final long serialVersionUID = 163080509307634843L;
        public final s51<? super T> actual;
        public volatile boolean cancelled;
        public volatile boolean done;
        public Throwable error;

        /* renamed from: s */
        public t51 f4382s;
        public final AtomicLong requested = new AtomicLong();
        public final AtomicReference<T> current = new AtomicReference<>();

        public BackpressureLatestSubscriber(s51<? super T> s51Var) {
            this.actual = s51Var;
        }

        @Override // me.tvspark.t51
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f4382s.cancel();
                if (getAndIncrement() != 0) {
                    return;
                }
                this.current.lazySet(null);
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, s51<?> s51Var, AtomicReference<T> atomicReference) {
            if (this.cancelled) {
                atomicReference.lazySet(null);
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.error;
                if (th != null) {
                    atomicReference.lazySet(null);
                    s51Var.onError(th);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    s51Var.onComplete();
                    return true;
                }
            }
        }

        public void drain() {
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            s51<? super T> s51Var = this.actual;
            AtomicLong atomicLong = this.requested;
            AtomicReference<T> atomicReference = this.current;
            int i = 1;
            do {
                long j = 0;
                while (true) {
                    z = false;
                    if (j == atomicLong.get()) {
                        break;
                    }
                    boolean z2 = this.done;
                    Object obj = (T) atomicReference.getAndSet(null);
                    boolean z3 = obj == null;
                    if (checkTerminated(z2, z3, s51Var, atomicReference)) {
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    s51Var.onNext(obj);
                    j++;
                }
                if (j == atomicLong.get()) {
                    boolean z4 = this.done;
                    if (atomicReference.get() == null) {
                        z = true;
                    }
                    if (checkTerminated(z4, z, s51Var, atomicReference)) {
                        return;
                    }
                }
                if (j != 0) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(atomicLong, j);
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        @Override // me.tvspark.s51
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // me.tvspark.s51
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // me.tvspark.s51
        public void onNext(T t) {
            this.current.lazySet(t);
            drain();
        }

        @Override // me.tvspark.s51
        public void onSubscribe(t51 t51Var) {
            if (SubscriptionHelper.validate(this.f4382s, t51Var)) {
                this.f4382s = t51Var;
                this.actual.onSubscribe(this);
                t51Var.request(Long.MAX_VALUE);
            }
        }

        @Override // me.tvspark.t51
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
                drain();
            }
        }
    }

    public FlowableOnBackpressureLatest(r51<T> r51Var) {
        super(r51Var);
    }

    @Override // me.tvspark.x50
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51<? super T> s51Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.subscribe(new BackpressureLatestSubscriber(s51Var));
    }
}

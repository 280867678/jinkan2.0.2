package io.reactivex.processors;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.l70;
import me.tvspark.nd0;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.sc0;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class UnicastProcessor<T> extends nd0<T> {
    public boolean Wwwwwwwwwwwwww;
    public final AtomicLong Wwwwwwwwwwwwwww;
    public final BasicIntQueueSubscription<T> Wwwwwwwwwwwwwwww;
    public final AtomicBoolean Wwwwwwwwwwwwwwwww;
    public volatile boolean Wwwwwwwwwwwwwwwwww;
    public final AtomicReference<s51<? super T>> Wwwwwwwwwwwwwwwwwww;
    public Throwable Wwwwwwwwwwwwwwwwwwww;
    public volatile boolean Wwwwwwwwwwwwwwwwwwwww;
    public final AtomicReference<Runnable> Wwwwwwwwwwwwwwwwwwwwww;
    public final sc0<T> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        public static final long serialVersionUID = -4896760517184205454L;

        public UnicastQueueSubscription() {
        }

        @Override // me.tvspark.t51
        public void cancel() {
            if (UnicastProcessor.this.Wwwwwwwwwwwwwwwwww) {
                return;
            }
            UnicastProcessor.this.Wwwwwwwwwwwwwwwwww = true;
            UnicastProcessor.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            UnicastProcessor unicastProcessor = UnicastProcessor.this;
            if (unicastProcessor.Wwwwwwwwwwwwww || unicastProcessor.Wwwwwwwwwwwwwwww.getAndIncrement() != 0) {
                return;
            }
            UnicastProcessor.this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
            UnicastProcessor.this.Wwwwwwwwwwwwwwwwwww.lazySet(null);
        }

        @Override // me.tvspark.t70
        public void clear() {
            UnicastProcessor.this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
        }

        @Override // me.tvspark.t70
        public boolean isEmpty() {
            return UnicastProcessor.this.Wwwwwwwwwwwwwwwwwwwwwww.isEmpty();
        }

        @Override // me.tvspark.t70
        /* renamed from: poll */
        public T mo4868poll() {
            return UnicastProcessor.this.Wwwwwwwwwwwwwwwwwwwwwww.mo4868poll();
        }

        @Override // me.tvspark.t51
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UnicastProcessor.this.Wwwwwwwwwwwwwww, j);
                UnicastProcessor.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // me.tvspark.p70
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                UnicastProcessor.this.Wwwwwwwwwwwwww = true;
                return 2;
            }
            return 0;
        }
    }

    public UnicastProcessor(int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "capacityHint");
        this.Wwwwwwwwwwwwwwwwwwwwwww = new sc0<>(i);
        this.Wwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();
        this.Wwwwwwwwwwwwwwwwwww = new AtomicReference<>();
        this.Wwwwwwwwwwwwwwwww = new AtomicBoolean();
        this.Wwwwwwwwwwwwwwww = new UnicastQueueSubscription();
        this.Wwwwwwwwwwwwwww = new AtomicLong();
    }

    public UnicastProcessor(int i, Runnable runnable) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "capacityHint");
        this.Wwwwwwwwwwwwwwwwwwwwwww = new sc0<>(i);
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, "onTerminate");
        this.Wwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>(runnable);
        this.Wwwwwwwwwwwwwwwwwww = new AtomicReference<>();
        this.Wwwwwwwwwwwwwwwww = new AtomicBoolean();
        this.Wwwwwwwwwwwwwwww = new UnicastQueueSubscription();
        this.Wwwwwwwwwwwwwww = new AtomicLong();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        if (this.Wwwwwwwwwwwwwwww.getAndIncrement() != 0) {
            return;
        }
        s51<? super T> s51Var = this.Wwwwwwwwwwwwwwwwwww.get();
        int i2 = 1;
        int i3 = 1;
        while (s51Var == null) {
            i3 = this.Wwwwwwwwwwwwwwww.addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
            s51Var = this.Wwwwwwwwwwwwwwwwwww.get();
        }
        if (this.Wwwwwwwwwwwwww) {
            sc0<T> sc0Var = this.Wwwwwwwwwwwwwwwwwwwwwww;
            while (!this.Wwwwwwwwwwwwwwwwww) {
                boolean z = this.Wwwwwwwwwwwwwwwwwwwww;
                s51Var.onNext(null);
                if (z) {
                    this.Wwwwwwwwwwwwwwwwwww.lazySet(null);
                    Throwable th = this.Wwwwwwwwwwwwwwwwwwww;
                    if (th != null) {
                        s51Var.onError(th);
                        return;
                    } else {
                        s51Var.onComplete();
                        return;
                    }
                }
                i2 = this.Wwwwwwwwwwwwwwww.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
            sc0Var.clear();
            this.Wwwwwwwwwwwwwwwwwww.lazySet(null);
            return;
        }
        sc0<T> sc0Var2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i4 = 1;
        do {
            long j = this.Wwwwwwwwwwwwwww.get();
            long j2 = 0;
            while (true) {
                i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                if (i == 0) {
                    break;
                }
                boolean z2 = this.Wwwwwwwwwwwwwwwwwwwww;
                Object obj = (T) sc0Var2.mo4868poll();
                boolean z3 = obj == null;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, z3, s51Var, sc0Var2)) {
                    return;
                }
                if (z3) {
                    break;
                }
                s51Var.onNext(obj);
                j2++;
            }
            if (i == 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, sc0Var2.isEmpty(), s51Var, sc0Var2)) {
                return;
            }
            if (j2 != 0 && j != Long.MAX_VALUE) {
                this.Wwwwwwwwwwwwwww.addAndGet(-j2);
            }
            i4 = this.Wwwwwwwwwwwwwwww.addAndGet(-i4);
        } while (i4 != 0);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Runnable runnable = this.Wwwwwwwwwwwwwwwwwwwwww.get();
        if (runnable == null || !this.Wwwwwwwwwwwwwwwwwwwwww.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    @Override // me.tvspark.x50
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51<? super T> s51Var) {
        if (this.Wwwwwwwwwwwwwwwww.get() || !this.Wwwwwwwwwwwwwwwww.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), s51Var);
            return;
        }
        s51Var.onSubscribe(this.Wwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwww.set(s51Var);
        if (this.Wwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwww.lazySet(null);
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2, s51<? super T> s51Var, sc0<T> sc0Var) {
        if (this.Wwwwwwwwwwwwwwwwww) {
            sc0Var.clear();
            this.Wwwwwwwwwwwwwwwwwww.lazySet(null);
            return true;
        } else if (!z || !z2) {
            return false;
        } else {
            Throwable th = this.Wwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwww.lazySet(null);
            if (th != null) {
                s51Var.onError(th);
            } else {
                s51Var.onComplete();
            }
            return true;
        }
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.Wwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwww) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwww = true;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.Wwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwww) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.Wwwwwwwwwwwwwwwwwwww = th;
        this.Wwwwwwwwwwwwwwwwwwwww = true;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.Wwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwww) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.offer(t);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (this.Wwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwww) {
            t51Var.cancel();
        } else {
            t51Var.request(Long.MAX_VALUE);
        }
    }
}

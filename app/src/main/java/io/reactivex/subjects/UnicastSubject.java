package io.reactivex.subjects;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.sc0;
import me.tvspark.sd0;

/* loaded from: classes4.dex */
public final class UnicastSubject<T> extends sd0<T> {
    public boolean Wwwwwwwwwwwwwwww;
    public final BasicIntQueueDisposable<T> Wwwwwwwwwwwwwwwww;
    public final AtomicBoolean Wwwwwwwwwwwwwwwwww;
    public Throwable Wwwwwwwwwwwwwwwwwww;
    public volatile boolean Wwwwwwwwwwwwwwwwwwww;
    public volatile boolean Wwwwwwwwwwwwwwwwwwwww;
    public final AtomicReference<Runnable> Wwwwwwwwwwwwwwwwwwwwww;
    public final AtomicReference<j60<? super T>> Wwwwwwwwwwwwwwwwwwwwwww;
    public final sc0<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        public static final long serialVersionUID = 7926949470189395511L;

        public UnicastQueueDisposable() {
        }

        @Override // me.tvspark.t70
        public void clear() {
            UnicastSubject.this.Wwwwwwwwwwwwwwwwwwwwwwww.clear();
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!UnicastSubject.this.Wwwwwwwwwwwwwwwwwwwww) {
                UnicastSubject.this.Wwwwwwwwwwwwwwwwwwwww = true;
                UnicastSubject.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                UnicastSubject.this.Wwwwwwwwwwwwwwwwwwwwwww.lazySet(null);
                if (UnicastSubject.this.Wwwwwwwwwwwwwwwww.getAndIncrement() != 0) {
                    return;
                }
                UnicastSubject.this.Wwwwwwwwwwwwwwwwwwwwwww.lazySet(null);
                UnicastSubject.this.Wwwwwwwwwwwwwwwwwwwwwwww.clear();
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return UnicastSubject.this.Wwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.t70
        public boolean isEmpty() {
            return UnicastSubject.this.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty();
        }

        @Override // me.tvspark.t70
        /* renamed from: poll */
        public T mo4868poll() throws Exception {
            return UnicastSubject.this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4868poll();
        }

        @Override // me.tvspark.p70
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                UnicastSubject.this.Wwwwwwwwwwwwwwww = true;
                return 2;
            }
            return 0;
        }
    }

    public UnicastSubject(int i) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "capacityHint");
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new sc0<>(i);
        this.Wwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();
        this.Wwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();
        this.Wwwwwwwwwwwwwwwwww = new AtomicBoolean();
        this.Wwwwwwwwwwwwwwwww = new UnicastQueueDisposable();
    }

    public UnicastSubject(int i, Runnable runnable) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "capacityHint");
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new sc0<>(i);
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, "onTerminate");
        this.Wwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>(runnable);
        this.Wwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();
        this.Wwwwwwwwwwwwwwwwww = new AtomicBoolean();
        this.Wwwwwwwwwwwwwwwww = new UnicastQueueDisposable();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwww.getAndIncrement() != 0) {
            return;
        }
        j60<? super T> j60Var = this.Wwwwwwwwwwwwwwwwwwwwwww.get();
        int i = 1;
        int i2 = 1;
        while (j60Var == null) {
            i2 = this.Wwwwwwwwwwwwwwwww.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
            j60Var = this.Wwwwwwwwwwwwwwwwwwwwwww.get();
        }
        if (this.Wwwwwwwwwwwwwwww) {
            sc0<T> sc0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            while (!this.Wwwwwwwwwwwwwwwwwwwww) {
                boolean z = this.Wwwwwwwwwwwwwwwwwwww;
                j60Var.onNext(null);
                if (z) {
                    this.Wwwwwwwwwwwwwwwwwwwwwww.lazySet(null);
                    Throwable th = this.Wwwwwwwwwwwwwwwwwww;
                    if (th != null) {
                        j60Var.onError(th);
                        return;
                    } else {
                        j60Var.onComplete();
                        return;
                    }
                }
                i = this.Wwwwwwwwwwwwwwwww.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww.lazySet(null);
            sc0Var.clear();
            return;
        }
        sc0<T> sc0Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = 1;
        while (!this.Wwwwwwwwwwwwwwwwwwwww) {
            boolean z2 = this.Wwwwwwwwwwwwwwwwwwww;
            Object obj = (T) this.Wwwwwwwwwwwwwwwwwwwwwwww.mo4868poll();
            boolean z3 = obj == null;
            if (z2 && z3) {
                this.Wwwwwwwwwwwwwwwwwwwwwww.lazySet(null);
                Throwable th2 = this.Wwwwwwwwwwwwwwwwwww;
                if (th2 != null) {
                    j60Var.onError(th2);
                    return;
                } else {
                    j60Var.onComplete();
                    return;
                }
            } else if (z3) {
                i3 = this.Wwwwwwwwwwwwwwwww.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else {
                j60Var.onNext(obj);
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.lazySet(null);
        sc0Var2.clear();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Runnable runnable = this.Wwwwwwwwwwwwwwwwwwwwww.get();
        if (runnable == null || !this.Wwwwwwwwwwwwwwwwwwwwww.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        if (this.Wwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwww = true;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        if (this.Wwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwww) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.Wwwwwwwwwwwwwwwwwww = th;
        this.Wwwwwwwwwwwwwwwwwwww = true;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.j60
    public void onNext(T t) {
        if (this.Wwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.offer(t);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        if (this.Wwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwww) {
            p60Var.dispose();
        }
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        if (this.Wwwwwwwwwwwwwwwwww.get() || !this.Wwwwwwwwwwwwwwwwww.compareAndSet(false, true)) {
            EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), j60Var);
            return;
        }
        j60Var.onSubscribe(this.Wwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwww.lazySet(j60Var);
        if (this.Wwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.lazySet(null);
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.d60;
import me.tvspark.f70;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.sc0;

/* loaded from: classes4.dex */
public final class ObservableCombineLatest<T, R> extends d60<R> {
    public final boolean Wwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public final f70<? super Object[], ? extends R> Wwwwwwwwwwwwwwwwwwwwww;
    public final Iterable<? extends h60<? extends T>> Wwwwwwwwwwwwwwwwwwwwwww;
    public final h60<? extends T>[] Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class LatestCoordinator<T, R> extends AtomicInteger implements p60 {
        public static final long serialVersionUID = 8567835998786448817L;
        public int active;
        public final j60<? super R> actual;
        public volatile boolean cancelled;
        public final f70<? super Object[], ? extends R> combiner;
        public int complete;
        public final boolean delayError;
        public volatile boolean done;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final T[] latest;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R>[] observers;
        public final sc0<Object> queue;

        public LatestCoordinator(j60<? super R> j60Var, f70<? super Object[], ? extends R> f70Var, int i, int i2, boolean z) {
            this.actual = j60Var;
            this.combiner = f70Var;
            this.delayError = z;
            this.latest = (T[]) new Object[i];
            this.observers = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            this.queue = new sc0<>(i2);
        }

        public void cancel(sc0<?> sc0Var) {
            clear(sc0Var);
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.observers) {
                DisposableHelper.dispose(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, j60<?> j60Var, sc0<?> sc0Var, boolean z3) {
            if (this.cancelled) {
                cancel(sc0Var);
                return true;
            } else if (!z) {
                return false;
            } else {
                if (z3) {
                    if (!z2) {
                        return false;
                    }
                    clear(this.queue);
                    Throwable terminate = this.errors.terminate();
                    if (terminate != null) {
                        j60Var.onError(terminate);
                    } else {
                        j60Var.onComplete();
                    }
                    return true;
                } else if (this.errors.get() != null) {
                    cancel(sc0Var);
                    j60Var.onError(this.errors.terminate());
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    clear(this.queue);
                    j60Var.onComplete();
                    return true;
                }
            }
        }

        public void clear(sc0<?> sc0Var) {
            synchronized (this) {
                Arrays.fill(this.latest, (Object) null);
            }
            sc0Var.clear();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x004f, code lost:
            if (r6.errors.get() != null) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void combine(T t, int i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.observers[i];
            synchronized (this) {
                if (this.cancelled) {
                    return;
                }
                int length = this.latest.length;
                T t2 = this.latest[i];
                int i2 = this.active;
                if (t2 == null) {
                    i2++;
                    this.active = i2;
                }
                int i3 = this.complete;
                if (t == null) {
                    i3++;
                    this.complete = i3;
                } else {
                    this.latest[i] = t;
                }
                boolean z = false;
                boolean z2 = i2 == length;
                if (i3 == length || (t == null && t2 == null)) {
                    z = true;
                }
                if (!z) {
                    if (t != null && z2) {
                        this.queue.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.latest.clone());
                    } else if (t == null) {
                    }
                    if (z2 && t != null) {
                        return;
                    }
                    drain();
                }
                this.done = true;
                if (z2) {
                }
                drain();
            }
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (getAndIncrement() != 0) {
                    return;
                }
                cancel(this.queue);
            }
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            sc0<?> sc0Var = this.queue;
            j60<? super R> j60Var = this.actual;
            boolean z = this.delayError;
            int i = 1;
            while (!checkTerminated(this.done, sc0Var.isEmpty(), j60Var, sc0Var, z)) {
                while (true) {
                    boolean z2 = this.done;
                    boolean z3 = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) sc0Var.mo4868poll()) == null;
                    if (checkTerminated(z2, z3, j60Var, sc0Var, z)) {
                        return;
                    }
                    if (z3) {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        try {
                            Object obj = (R) this.combiner.apply((Object[]) sc0Var.mo4868poll());
                            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "The combiner returned a null");
                            j60Var.onNext(obj);
                        } catch (Throwable th) {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                            this.cancelled = true;
                            cancel(sc0Var);
                            j60Var.onError(th);
                            return;
                        }
                    }
                }
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            }
        }

        public void subscribe(h60<? extends T>[] h60VarArr) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.observers;
            int length = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length;
            for (int i = 0; i < length; i++) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i] = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(this, i);
            }
            lazySet(0);
            this.actual.onSubscribe(this);
            for (int i2 = 0; i2 < length && !this.cancelled; i2++) {
                h60VarArr[i2].subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i2]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R> implements j60<T> {
        public final AtomicReference<p60> Wwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();
        public final int Wwwwwwwwwwwwwwwwwwwwwww;
        public final LatestCoordinator<T, R> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LatestCoordinator<T, R> latestCoordinator, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = latestCoordinator;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.combine(null, this.Wwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.combine(null, this.Wwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.combine(t, this.Wwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this.Wwwwwwwwwwwwwwwwwwwwww, p60Var);
        }
    }

    public ObservableCombineLatest(h60<? extends T>[] h60VarArr, Iterable<? extends h60<? extends T>> iterable, f70<? super Object[], ? extends R> f70Var, int i, boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60VarArr;
        this.Wwwwwwwwwwwwwwwwwwwwwww = iterable;
        this.Wwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super R> j60Var) {
        int length;
        h60<? extends T>[] h60VarArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (h60VarArr == null) {
            h60VarArr = new d60[8];
            length = 0;
            for (h60<? extends T> h60Var : this.Wwwwwwwwwwwwwwwwwwwwwww) {
                if (length == h60VarArr.length) {
                    h60<? extends T>[] h60VarArr2 = new h60[(length >> 2) + length];
                    System.arraycopy(h60VarArr, 0, h60VarArr2, 0, length);
                    h60VarArr = h60VarArr2;
                }
                h60VarArr[length] = h60Var;
                length++;
            }
        } else {
            length = h60VarArr.length;
        }
        int i = length;
        if (i == 0) {
            EmptyDisposable.complete(j60Var);
        } else {
            new LatestCoordinator(j60Var, this.Wwwwwwwwwwwwwwwwwwwwww, i, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww).subscribe(h60VarArr);
        }
    }
}

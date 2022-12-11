package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
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
public final class ObservableZip<T, R> extends d60<R> {
    public final boolean Wwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public final f70<? super Object[], ? extends R> Wwwwwwwwwwwwwwwwwwwwww;
    public final Iterable<? extends h60<? extends T>> Wwwwwwwwwwwwwwwwwwwwwww;
    public final h60<? extends T>[] Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R> implements j60<T> {
        public final AtomicReference<p60> Wwwwwwwwwwwwwwwwwwww = new AtomicReference<>();
        public Throwable Wwwwwwwwwwwwwwwwwwwww;
        public volatile boolean Wwwwwwwwwwwwwwwwwwwwww;
        public final sc0<T> Wwwwwwwwwwwwwwwwwwwwwww;
        public final ZipCoordinator<T, R> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ZipCoordinator<T, R> zipCoordinator, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = zipCoordinator;
            this.Wwwwwwwwwwwwwwwwwwwwwww = new sc0<>(i);
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.drain();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwww = th;
            this.Wwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.drain();
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.offer(t);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.drain();
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this.Wwwwwwwwwwwwwwwwwwww, p60Var);
        }
    }

    /* loaded from: classes4.dex */
    public static final class ZipCoordinator<T, R> extends AtomicInteger implements p60 {
        public static final long serialVersionUID = 2983708048395377667L;
        public final j60<? super R> actual;
        public volatile boolean cancelled;
        public final boolean delayError;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R>[] observers;
        public final T[] row;
        public final f70<? super Object[], ? extends R> zipper;

        public ZipCoordinator(j60<? super R> j60Var, f70<? super Object[], ? extends R> f70Var, int i, boolean z) {
            this.actual = j60Var;
            this.zipper = f70Var;
            this.observers = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            this.row = (T[]) new Object[i];
            this.delayError = z;
        }

        public boolean checkTerminated(boolean z, boolean z2, j60<? super R> j60Var, boolean z3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?, ?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (this.cancelled) {
                clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (z3) {
                    if (!z2) {
                        return false;
                    }
                    Throwable th = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
                    clear();
                    if (th != null) {
                        j60Var.onError(th);
                    } else {
                        j60Var.onComplete();
                    }
                    return true;
                }
                Throwable th2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
                if (th2 != null) {
                    clear();
                    j60Var.onError(th2);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    clear();
                    j60Var.onComplete();
                    return true;
                }
            }
        }

        public void clear() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr;
            for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.observers) {
                DisposableHelper.dispose(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.clear();
            }
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (getAndIncrement() != 0) {
                    return;
                }
                clear();
            }
        }

        public void drain() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.observers;
            j60<? super R> j60Var = this.actual;
            T[] tArr = this.row;
            boolean z = this.delayError;
            int i = 1;
            while (true) {
                int i2 = 0;
                int i3 = 0;
                for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr) {
                    if (tArr[i3] == null) {
                        boolean z2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
                        T mo4868poll = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.mo4868poll();
                        boolean z3 = mo4868poll == null;
                        if (checkTerminated(z2, z3, j60Var, z, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            return;
                        }
                        if (!z3) {
                            tArr[i3] = mo4868poll;
                        } else {
                            i2++;
                        }
                    } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww && !z && (th = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww) != null) {
                        clear();
                        j60Var.onError(th);
                        return;
                    }
                    i3++;
                }
                if (i2 != 0) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    try {
                        Object obj = (R) this.zipper.apply(tArr.clone());
                        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "The zipper returned a null value");
                        j60Var.onNext(obj);
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th2) {
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                        clear();
                        j60Var.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(h60<? extends T>[] h60VarArr, int i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T, R>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.observers;
            int length = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i2] = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(this, i);
            }
            lazySet(0);
            this.actual.onSubscribe(this);
            for (int i3 = 0; i3 < length && !this.cancelled; i3++) {
                h60VarArr[i3].subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i3]);
            }
        }
    }

    public ObservableZip(h60<? extends T>[] h60VarArr, Iterable<? extends h60<? extends T>> iterable, f70<? super Object[], ? extends R> f70Var, int i, boolean z) {
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
        if (length == 0) {
            EmptyDisposable.complete(j60Var);
        } else {
            new ZipCoordinator(j60Var, this.Wwwwwwwwwwwwwwwwwwwwww, length, this.Wwwwwwwwwwwwwwwwwwww).subscribe(h60VarArr, this.Wwwwwwwwwwwwwwwwwwwww);
        }
    }
}

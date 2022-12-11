package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.d60;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.sc0;
import me.tvspark.u60;

/* loaded from: classes4.dex */
public final class ObservableSequenceEqual<T> extends d60<Boolean> {
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public final u60<? super T, ? super T> Wwwwwwwwwwwwwwwwwwwwww;
    public final h60<? extends T> Wwwwwwwwwwwwwwwwwwwwwww;
    public final h60<? extends T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class EqualCoordinator<T> extends AtomicInteger implements p60 {
        public static final long serialVersionUID = -6178010334400373240L;
        public final j60<? super Boolean> actual;
        public volatile boolean cancelled;
        public final u60<? super T, ? super T> comparer;
        public final h60<? extends T> first;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T>[] observers;
        public final ArrayCompositeDisposable resources = new ArrayCompositeDisposable(2);
        public final h60<? extends T> second;

        /* renamed from: v1 */
        public T f4442v1;

        /* renamed from: v2 */
        public T f4443v2;

        public EqualCoordinator(j60<? super Boolean> j60Var, int i, h60<? extends T> h60Var, h60<? extends T> h60Var2, u60<? super T, ? super T> u60Var) {
            this.actual = j60Var;
            this.first = h60Var;
            this.second = h60Var2;
            this.comparer = u60Var;
            this.observers = r3;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = {new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(this, 0, i), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(this, 1, i)};
        }

        public void cancel(sc0<T> sc0Var, sc0<T> sc0Var2) {
            this.cancelled = true;
            sc0Var.clear();
            sc0Var2.clear();
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.resources.dispose();
                if (getAndIncrement() != 0) {
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.observers;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[0].Wwwwwwwwwwwwwwwwwwwwwww.clear();
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[1].Wwwwwwwwwwwwwwwwwwwwwww.clear();
            }
        }

        public void drain() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.observers;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[0];
            sc0<T> sc0Var = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[1];
            sc0<T> sc0Var2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww;
            int i = 1;
            while (!this.cancelled) {
                boolean z = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
                if (z && (th2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww) != null) {
                    cancel(sc0Var, sc0Var2);
                    this.actual.onError(th2);
                    return;
                }
                boolean z2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww;
                if (z2 && (th = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwww) != null) {
                    cancel(sc0Var, sc0Var2);
                    this.actual.onError(th);
                    return;
                }
                if (this.f4442v1 == null) {
                    this.f4442v1 = sc0Var.mo4868poll();
                }
                boolean z3 = this.f4442v1 == null;
                if (this.f4443v2 == null) {
                    this.f4443v2 = sc0Var2.mo4868poll();
                }
                boolean z4 = this.f4443v2 == null;
                if (z && z2 && z3 && z4) {
                    this.actual.onNext(true);
                    this.actual.onComplete();
                    return;
                } else if (z && z2 && z3 != z4) {
                    cancel(sc0Var, sc0Var2);
                    this.actual.onNext(false);
                    this.actual.onComplete();
                    return;
                } else {
                    if (!z3 && !z4) {
                        try {
                            u60<? super T, ? super T> u60Var = this.comparer;
                            T t = this.f4442v1;
                            T t2 = this.f4443v2;
                            if (((l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) u60Var) != null) {
                                if (!l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, t2)) {
                                    cancel(sc0Var, sc0Var2);
                                    this.actual.onNext(false);
                                    this.actual.onComplete();
                                    return;
                                }
                                this.f4442v1 = null;
                                this.f4443v2 = null;
                            } else {
                                throw null;
                            }
                        } catch (Throwable th3) {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th3);
                            cancel(sc0Var, sc0Var2);
                            this.actual.onError(th3);
                            return;
                        }
                    }
                    if (z3 || z4) {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                }
            }
            sc0Var.clear();
            sc0Var2.clear();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled;
        }

        public boolean setDisposable(p60 p60Var, int i) {
            return this.resources.setResource(i, p60Var);
        }

        public void subscribe() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T>[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.observers;
            this.first.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[0]);
            this.second.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[1]);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<T> {
        public Throwable Wwwwwwwwwwwwwwwwwwww;
        public volatile boolean Wwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwww;
        public final sc0<T> Wwwwwwwwwwwwwwwwwwwwwww;
        public final EqualCoordinator<T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EqualCoordinator<T> equalCoordinator, int i, int i2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = equalCoordinator;
            this.Wwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwww = new sc0<>(i2);
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.drain();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwww = th;
            this.Wwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.drain();
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.offer(t);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.drain();
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.setDisposable(p60Var, this.Wwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public ObservableSequenceEqual(h60<? extends T> h60Var, h60<? extends T> h60Var2, u60<? super T, ? super T> u60Var, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = h60Var2;
        this.Wwwwwwwwwwwwwwwwwwwwww = u60Var;
        this.Wwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super Boolean> j60Var) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(j60Var, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww);
        j60Var.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe();
    }
}

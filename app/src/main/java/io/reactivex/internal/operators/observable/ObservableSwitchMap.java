package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.f70;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.sc0;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableSwitchMap<T, R> extends x80<T, R> {
    public final boolean Wwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwww;
    public final f70<? super T, ? extends h60<? extends R>> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class SwitchMapInnerObserver<T, R> extends AtomicReference<p60> implements j60<R> {
        public static final long serialVersionUID = 3837284832786408377L;
        public volatile boolean done;
        public final long index;
        public final SwitchMapObserver<T, R> parent;
        public final sc0<R> queue;

        public SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j, int i) {
            this.parent = switchMapObserver;
            this.index = j;
            this.queue = new sc0<>(i);
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.parent.innerError(this, th);
        }

        @Override // me.tvspark.j60
        public void onNext(R r) {
            if (this.index == this.parent.unique) {
                this.queue.offer(r);
                this.parent.drain();
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this, p60Var);
        }
    }

    /* loaded from: classes4.dex */
    public static final class SwitchMapObserver<T, R> extends AtomicInteger implements j60<T>, p60 {
        public static final SwitchMapInnerObserver<Object, Object> CANCELLED;
        public static final long serialVersionUID = -3491074160481096299L;
        public final j60<? super R> actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final f70<? super T, ? extends h60<? extends R>> mapper;

        /* renamed from: s */
        public p60 f4449s;
        public volatile long unique;
        public final AtomicReference<SwitchMapInnerObserver<T, R>> active = new AtomicReference<>();
        public final AtomicThrowable errors = new AtomicThrowable();

        static {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = new SwitchMapInnerObserver<>(null, -1L, 1);
            CANCELLED = switchMapInnerObserver;
            switchMapInnerObserver.cancel();
        }

        public SwitchMapObserver(j60<? super R> j60Var, f70<? super T, ? extends h60<? extends R>> f70Var, int i, boolean z) {
            this.actual = j60Var;
            this.mapper = f70Var;
            this.bufferSize = i;
            this.delayErrors = z;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f4449s.dispose();
                disposeInner();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void disposeInner() {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.active.get();
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver3 = CANCELLED;
            if (switchMapInnerObserver2 == switchMapInnerObserver3 || (switchMapInnerObserver = (SwitchMapInnerObserver) this.active.getAndSet(switchMapInnerObserver3)) == CANCELLED || switchMapInnerObserver == null) {
                return;
            }
            switchMapInnerObserver.cancel();
        }

        /* JADX WARN: Removed duplicated region for block: B:60:0x00be A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x000b A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            j60<? super R> j60Var = this.actual;
            int i = 1;
            while (!this.cancelled) {
                boolean z = false;
                if (this.done) {
                    boolean z2 = this.active.get() == null;
                    if (this.delayErrors) {
                        if (z2) {
                            Throwable th = this.errors.get();
                            if (th != null) {
                                j60Var.onError(th);
                                return;
                            } else {
                                j60Var.onComplete();
                                return;
                            }
                        }
                    } else if (this.errors.get() != null) {
                        j60Var.onError(this.errors.terminate());
                        return;
                    } else if (z2) {
                        j60Var.onComplete();
                        return;
                    }
                }
                SwitchMapInnerObserver<T, R> switchMapInnerObserver = this.active.get();
                if (switchMapInnerObserver != null) {
                    sc0<R> sc0Var = switchMapInnerObserver.queue;
                    if (switchMapInnerObserver.done) {
                        boolean isEmpty = sc0Var.isEmpty();
                        if (this.delayErrors) {
                            if (isEmpty) {
                                this.active.compareAndSet(switchMapInnerObserver, null);
                            }
                        } else if (this.errors.get() != null) {
                            j60Var.onError(this.errors.terminate());
                            return;
                        } else if (isEmpty) {
                            this.active.compareAndSet(switchMapInnerObserver, null);
                        }
                    }
                    while (!this.cancelled) {
                        if (switchMapInnerObserver == this.active.get()) {
                            if (!this.delayErrors && this.errors.get() != null) {
                                j60Var.onError(this.errors.terminate());
                                return;
                            }
                            boolean z3 = switchMapInnerObserver.done;
                            Object obj = (R) sc0Var.mo4868poll();
                            boolean z4 = obj == null;
                            if (z3 && z4) {
                                this.active.compareAndSet(switchMapInnerObserver, null);
                            } else if (!z4) {
                                j60Var.onNext(obj);
                            } else if (!z) {
                                continue;
                            }
                        }
                        z = true;
                        if (!z) {
                        }
                    }
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        public void innerError(SwitchMapInnerObserver<T, R> switchMapInnerObserver, Throwable th) {
            if (switchMapInnerObserver.index != this.unique || !this.errors.addThrowable(th)) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            if (!this.delayErrors) {
                this.f4449s.dispose();
            }
            switchMapInnerObserver.done = true;
            drain();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (!this.done && this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            if (!this.delayErrors) {
                disposeInner();
            }
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            SwitchMapInnerObserver<T, R> switchMapInnerObserver;
            long j = this.unique + 1;
            this.unique = j;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.active.get();
            if (switchMapInnerObserver2 != null) {
                switchMapInnerObserver2.cancel();
            }
            try {
                h60<? extends R> apply = this.mapper.apply(t);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The ObservableSource returned is null");
                h60<? extends R> h60Var = apply;
                SwitchMapInnerObserver<T, R> switchMapInnerObserver3 = new SwitchMapInnerObserver<>(this, j, this.bufferSize);
                do {
                    switchMapInnerObserver = this.active.get();
                    if (switchMapInnerObserver == CANCELLED) {
                        return;
                    }
                } while (!this.active.compareAndSet(switchMapInnerObserver, switchMapInnerObserver3));
                h60Var.subscribe(switchMapInnerObserver3);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.f4449s.dispose();
                onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4449s, p60Var)) {
                this.f4449s = p60Var;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMap(h60<T> h60Var, f70<? super T, ? extends h60<? extends R>> f70Var, int i, boolean z) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super R> j60Var) {
        if (r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww)) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new SwitchMapObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww));
    }
}

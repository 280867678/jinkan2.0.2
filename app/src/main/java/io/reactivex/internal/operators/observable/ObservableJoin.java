package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.d60;
import me.tvspark.f70;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.o60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.sc0;
import me.tvspark.t60;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends x80<TLeft, R> {
    public final t60<? super TLeft, ? super TRight, ? extends R> Wwwwwwwwwwwwwwwwwwww;
    public final f70<? super TRight, ? extends h60<TRightEnd>> Wwwwwwwwwwwwwwwwwwwww;
    public final f70<? super TLeft, ? extends h60<TLeftEnd>> Wwwwwwwwwwwwwwwwwwwwww;
    public final h60<? extends TRight> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements p60, ObservableGroupJoin.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final long serialVersionUID = -6071216598687999801L;
        public final j60<? super R> actual;
        public volatile boolean cancelled;
        public final f70<? super TLeft, ? extends h60<TLeftEnd>> leftEnd;
        public int leftIndex;
        public final t60<? super TLeft, ? super TRight, ? extends R> resultSelector;
        public final f70<? super TRight, ? extends h60<TRightEnd>> rightEnd;
        public int rightIndex;
        public static final Integer LEFT_VALUE = 1;
        public static final Integer RIGHT_VALUE = 2;
        public static final Integer LEFT_CLOSE = 3;
        public static final Integer RIGHT_CLOSE = 4;
        public final o60 disposables = new o60();
        public final sc0<Object> queue = new sc0<>(d60.bufferSize());
        public final Map<Integer, TLeft> lefts = new LinkedHashMap();
        public final Map<Integer, TRight> rights = new LinkedHashMap();
        public final AtomicReference<Throwable> error = new AtomicReference<>();
        public final AtomicInteger active = new AtomicInteger(2);

        public JoinDisposable(j60<? super R> j60Var, f70<? super TLeft, ? extends h60<TLeftEnd>> f70Var, f70<? super TRight, ? extends h60<TRightEnd>> f70Var2, t60<? super TLeft, ? super TRight, ? extends R> t60Var) {
            this.actual = j60Var;
            this.leftEnd = f70Var;
            this.rightEnd = f70Var2;
            this.resultSelector = t60Var;
        }

        public void cancelAll() {
            this.disposables.dispose();
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() != 0) {
                    return;
                }
                this.queue.clear();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            sc0<?> sc0Var = this.queue;
            j60<? super R> j60Var = this.actual;
            int i = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    sc0Var.clear();
                    cancelAll();
                    errorAll(j60Var);
                    return;
                }
                boolean z = this.active.get() == 0;
                Integer num = (Integer) sc0Var.mo4868poll();
                boolean z2 = num == null;
                if (z && z2) {
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    j60Var.onComplete();
                    return;
                } else if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    Object mo4868poll = sc0Var.mo4868poll();
                    if (num == LEFT_VALUE) {
                        int i2 = this.leftIndex;
                        this.leftIndex = i2 + 1;
                        this.lefts.put(Integer.valueOf(i2), mo4868poll);
                        try {
                            h60 apply = this.leftEnd.apply(mo4868poll);
                            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The leftEnd returned a null ObservableSource");
                            h60 h60Var = apply;
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver = new ObservableGroupJoin.LeftRightEndObserver(this, true, i2);
                            this.disposables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(leftRightEndObserver);
                            h60Var.subscribe(leftRightEndObserver);
                            if (this.error.get() != null) {
                                sc0Var.clear();
                                cancelAll();
                                errorAll(j60Var);
                                return;
                            }
                            for (TRight tright : this.rights.values()) {
                                try {
                                    Object obj = (R) this.resultSelector.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4868poll, tright);
                                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "The resultSelector returned a null value");
                                    j60Var.onNext(obj);
                                } catch (Throwable th) {
                                    fail(th, j60Var, sc0Var);
                                    return;
                                }
                            }
                            continue;
                        } catch (Throwable th2) {
                            fail(th2, j60Var, sc0Var);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i3 = this.rightIndex;
                        this.rightIndex = i3 + 1;
                        this.rights.put(Integer.valueOf(i3), mo4868poll);
                        try {
                            h60 apply2 = this.rightEnd.apply(mo4868poll);
                            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply2, "The rightEnd returned a null ObservableSource");
                            h60 h60Var2 = apply2;
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, i3);
                            this.disposables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(leftRightEndObserver2);
                            h60Var2.subscribe(leftRightEndObserver2);
                            if (this.error.get() != null) {
                                sc0Var.clear();
                                cancelAll();
                                errorAll(j60Var);
                                return;
                            }
                            for (TLeft tleft : this.lefts.values()) {
                                try {
                                    Object obj2 = (R) this.resultSelector.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tleft, mo4868poll);
                                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj2, "The resultSelector returned a null value");
                                    j60Var.onNext(obj2);
                                } catch (Throwable th3) {
                                    fail(th3, j60Var, sc0Var);
                                    return;
                                }
                            }
                            continue;
                        } catch (Throwable th4) {
                            fail(th4, j60Var, sc0Var);
                            return;
                        }
                    } else {
                        ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver3 = (ObservableGroupJoin.LeftRightEndObserver) mo4868poll;
                        (num == LEFT_CLOSE ? this.lefts : this.rights).remove(Integer.valueOf(leftRightEndObserver3.index));
                        this.disposables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(leftRightEndObserver3);
                    }
                }
            }
            sc0Var.clear();
        }

        public void errorAll(j60<?> j60Var) {
            Throwable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error);
            this.lefts.clear();
            this.rights.clear();
            j60Var.onError(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public void fail(Throwable th, j60<?> j60Var, sc0<?> sc0Var) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error, th);
            sc0Var.clear();
            cancelAll();
            errorAll(j60Var);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void innerClose(boolean z, ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.queue.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z ? LEFT_CLOSE : RIGHT_CLOSE, leftRightEndObserver);
            }
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void innerCloseError(Throwable th) {
            if (ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error, th)) {
                drain();
            } else {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void innerComplete(ObservableGroupJoin.LeftRightObserver leftRightObserver) {
            this.disposables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(leftRightObserver);
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void innerError(Throwable th) {
            if (!ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error, th)) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.queue.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public ObservableJoin(h60<TLeft> h60Var, h60<? extends TRight> h60Var2, f70<? super TLeft, ? extends h60<TLeftEnd>> f70Var, f70<? super TRight, ? extends h60<TRightEnd>> f70Var2, t60<? super TLeft, ? super TRight, ? extends R> t60Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = h60Var2;
        this.Wwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwww = f70Var2;
        this.Wwwwwwwwwwwwwwwwwwww = t60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super R> j60Var) {
        JoinDisposable joinDisposable = new JoinDisposable(j60Var, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww);
        j60Var.onSubscribe(joinDisposable);
        ObservableGroupJoin.LeftRightObserver leftRightObserver = new ObservableGroupJoin.LeftRightObserver(joinDisposable, true);
        joinDisposable.disposables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(leftRightObserver);
        ObservableGroupJoin.LeftRightObserver leftRightObserver2 = new ObservableGroupJoin.LeftRightObserver(joinDisposable, false);
        joinDisposable.disposables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(leftRightObserver2);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(leftRightObserver);
        this.Wwwwwwwwwwwwwwwwwwwwwww.subscribe(leftRightObserver2);
    }
}

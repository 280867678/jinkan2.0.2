package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.subjects.UnicastSubject;
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
public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends x80<TLeft, R> {
    public final t60<? super TLeft, ? super d60<TRight>, ? extends R> Wwwwwwwwwwwwwwwwwwww;
    public final f70<? super TRight, ? extends h60<TRightEnd>> Wwwwwwwwwwwwwwwwwwwww;
    public final f70<? super TLeft, ? extends h60<TLeftEnd>> Wwwwwwwwwwwwwwwwwwwwww;
    public final h60<? extends TRight> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements p60, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final long serialVersionUID = -6071216598687999801L;
        public final j60<? super R> actual;
        public volatile boolean cancelled;
        public final f70<? super TLeft, ? extends h60<TLeftEnd>> leftEnd;
        public int leftIndex;
        public final t60<? super TLeft, ? super d60<TRight>, ? extends R> resultSelector;
        public final f70<? super TRight, ? extends h60<TRightEnd>> rightEnd;
        public int rightIndex;
        public static final Integer LEFT_VALUE = 1;
        public static final Integer RIGHT_VALUE = 2;
        public static final Integer LEFT_CLOSE = 3;
        public static final Integer RIGHT_CLOSE = 4;
        public final o60 disposables = new o60();
        public final sc0<Object> queue = new sc0<>(d60.bufferSize());
        public final Map<Integer, UnicastSubject<TRight>> lefts = new LinkedHashMap();
        public final Map<Integer, TRight> rights = new LinkedHashMap();
        public final AtomicReference<Throwable> error = new AtomicReference<>();
        public final AtomicInteger active = new AtomicInteger(2);

        public GroupJoinDisposable(j60<? super R> j60Var, f70<? super TLeft, ? extends h60<TLeftEnd>> f70Var, f70<? super TRight, ? extends h60<TRightEnd>> f70Var2, t60<? super TLeft, ? super d60<TRight>, ? extends R> t60Var) {
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
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
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
                    for (UnicastSubject<TRight> unicastSubject : this.lefts.values()) {
                        unicastSubject.onComplete();
                    }
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
                        UnicastSubject<TRight> unicastSubject2 = new UnicastSubject<>(d60.bufferSize());
                        int i2 = this.leftIndex;
                        this.leftIndex = i2 + 1;
                        this.lefts.put(Integer.valueOf(i2), unicastSubject2);
                        try {
                            h60 apply = this.leftEnd.apply(mo4868poll);
                            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The leftEnd returned a null ObservableSource");
                            h60 h60Var = apply;
                            LeftRightEndObserver leftRightEndObserver = new LeftRightEndObserver(this, true, i2);
                            this.disposables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(leftRightEndObserver);
                            h60Var.subscribe(leftRightEndObserver);
                            if (this.error.get() != null) {
                                sc0Var.clear();
                                cancelAll();
                                errorAll(j60Var);
                                return;
                            }
                            try {
                                Object obj = (R) this.resultSelector.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mo4868poll, unicastSubject2);
                                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "The resultSelector returned a null value");
                                j60Var.onNext(obj);
                                for (TRight tright : this.rights.values()) {
                                    unicastSubject2.onNext(tright);
                                }
                            } catch (Throwable th) {
                                fail(th, j60Var, sc0Var);
                                return;
                            }
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
                            LeftRightEndObserver leftRightEndObserver2 = new LeftRightEndObserver(this, false, i3);
                            this.disposables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(leftRightEndObserver2);
                            h60Var2.subscribe(leftRightEndObserver2);
                            if (this.error.get() != null) {
                                sc0Var.clear();
                                cancelAll();
                                errorAll(j60Var);
                                return;
                            }
                            for (UnicastSubject<TRight> unicastSubject3 : this.lefts.values()) {
                                unicastSubject3.onNext(mo4868poll);
                            }
                        } catch (Throwable th3) {
                            fail(th3, j60Var, sc0Var);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        LeftRightEndObserver leftRightEndObserver3 = (LeftRightEndObserver) mo4868poll;
                        UnicastSubject<TRight> remove = this.lefts.remove(Integer.valueOf(leftRightEndObserver3.index));
                        this.disposables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(leftRightEndObserver3);
                        if (remove != null) {
                            remove.onComplete();
                        }
                    } else if (num == RIGHT_CLOSE) {
                        LeftRightEndObserver leftRightEndObserver4 = (LeftRightEndObserver) mo4868poll;
                        this.rights.remove(Integer.valueOf(leftRightEndObserver4.index));
                        this.disposables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(leftRightEndObserver4);
                    }
                }
            }
            sc0Var.clear();
        }

        public void errorAll(j60<?> j60Var) {
            Throwable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error);
            for (UnicastSubject<TRight> unicastSubject : this.lefts.values()) {
                unicastSubject.onError(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
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
        public void innerClose(boolean z, LeftRightEndObserver leftRightEndObserver) {
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
        public void innerComplete(LeftRightObserver leftRightObserver) {
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

    /* loaded from: classes4.dex */
    public static final class LeftRightEndObserver extends AtomicReference<p60> implements j60<Object>, p60 {
        public static final long serialVersionUID = 1883890389173668373L;
        public final int index;
        public final boolean isLeft;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww parent;

        public LeftRightEndObserver(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z, int i) {
            this.parent = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.isLeft = z;
            this.index = i;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.parent.innerCloseError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(Object obj) {
            if (DisposableHelper.dispose(this)) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this, p60Var);
        }
    }

    /* loaded from: classes4.dex */
    public static final class LeftRightObserver extends AtomicReference<p60> implements j60<Object>, p60 {
        public static final long serialVersionUID = 1883890389173668373L;
        public final boolean isLeft;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww parent;

        public LeftRightObserver(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z) {
            this.parent = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.isLeft = z;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(Object obj) {
            this.parent.innerValue(this.isLeft, obj);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this, p60Var);
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void innerClose(boolean z, LeftRightEndObserver leftRightEndObserver);

        void innerCloseError(Throwable th);

        void innerComplete(LeftRightObserver leftRightObserver);

        void innerError(Throwable th);

        void innerValue(boolean z, Object obj);
    }

    public ObservableGroupJoin(h60<TLeft> h60Var, h60<? extends TRight> h60Var2, f70<? super TLeft, ? extends h60<TLeftEnd>> f70Var, f70<? super TRight, ? extends h60<TRightEnd>> f70Var2, t60<? super TLeft, ? super d60<TRight>, ? extends R> t60Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = h60Var2;
        this.Wwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwww = f70Var2;
        this.Wwwwwwwwwwwwwwwwwwww = t60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super R> j60Var) {
        GroupJoinDisposable groupJoinDisposable = new GroupJoinDisposable(j60Var, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww);
        j60Var.onSubscribe(groupJoinDisposable);
        LeftRightObserver leftRightObserver = new LeftRightObserver(groupJoinDisposable, true);
        groupJoinDisposable.disposables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(leftRightObserver);
        LeftRightObserver leftRightObserver2 = new LeftRightObserver(groupJoinDisposable, false);
        groupJoinDisposable.disposables.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(leftRightObserver2);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(leftRightObserver);
        this.Wwwwwwwwwwwwwwwwwwwwwww.subscribe(leftRightObserver2);
    }
}

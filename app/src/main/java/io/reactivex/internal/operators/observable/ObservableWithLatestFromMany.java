package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import me.tvspark.f70;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.kb0;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableWithLatestFromMany<T, R> extends x80<T, R> {
    public final f70<? super Object[], R> Wwwwwwwwwwwwwwwwwwwww;
    public final Iterable<? extends h60<?>> Wwwwwwwwwwwwwwwwwwwwww;
    public final h60<?>[] Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class WithLatestFromObserver<T, R> extends AtomicInteger implements j60<T>, p60 {
        public static final long serialVersionUID = 1577321883966341961L;
        public final j60<? super R> actual;
        public final f70<? super Object[], R> combiner;

        /* renamed from: d */
        public final AtomicReference<p60> f4463d;
        public volatile boolean done;
        public final AtomicThrowable error;
        public final WithLatestInnerObserver[] observers;
        public final AtomicReferenceArray<Object> values;

        public WithLatestFromObserver(j60<? super R> j60Var, f70<? super Object[], R> f70Var, int i) {
            this.actual = j60Var;
            this.combiner = f70Var;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i];
            for (int i2 = 0; i2 < i; i2++) {
                withLatestInnerObserverArr[i2] = new WithLatestInnerObserver(this, i2);
            }
            this.observers = withLatestInnerObserverArr;
            this.values = new AtomicReferenceArray<>(i);
            this.f4463d = new AtomicReference<>();
            this.error = new AtomicThrowable();
        }

        public void cancelAllBut(int i) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            for (int i2 = 0; i2 < withLatestInnerObserverArr.length; i2++) {
                if (i2 != i) {
                    withLatestInnerObserverArr[i2].dispose();
                }
            }
        }

        @Override // me.tvspark.p60
        public void dispose() {
            DisposableHelper.dispose(this.f4463d);
            for (WithLatestInnerObserver withLatestInnerObserver : this.observers) {
                withLatestInnerObserver.dispose();
            }
        }

        public void innerComplete(int i, boolean z) {
            if (!z) {
                this.done = true;
                cancelAllBut(i);
                j60<? super R> j60Var = this.actual;
                AtomicThrowable atomicThrowable = this.error;
                if (getAndIncrement() != 0) {
                    return;
                }
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    j60Var.onError(terminate);
                } else {
                    j60Var.onComplete();
                }
            }
        }

        public void innerError(int i, Throwable th) {
            this.done = true;
            DisposableHelper.dispose(this.f4463d);
            cancelAllBut(i);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.actual, th, this, this.error);
        }

        public void innerNext(int i, Object obj) {
            this.values.set(i, obj);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f4463d.get());
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                cancelAllBut(-1);
                j60<? super R> j60Var = this.actual;
                AtomicThrowable atomicThrowable = this.error;
                if (getAndIncrement() != 0) {
                    return;
                }
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    j60Var.onError(terminate);
                } else {
                    j60Var.onComplete();
                }
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.done) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.actual, th, this, this.error);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            objArr[0] = t;
            int i = 0;
            while (i < length) {
                Object obj = atomicReferenceArray.get(i);
                if (obj == null) {
                    return;
                }
                i++;
                objArr[i] = obj;
            }
            try {
                R apply = this.combiner.apply(objArr);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "combiner returned a null value");
                j60<? super R> j60Var = this.actual;
                AtomicThrowable atomicThrowable = this.error;
                if (get() != 0 || !compareAndSet(0, 1)) {
                    return;
                }
                j60Var.onNext(apply);
                if (decrementAndGet() == 0) {
                    return;
                }
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    j60Var.onError(terminate);
                } else {
                    j60Var.onComplete();
                }
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                dispose();
                onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this.f4463d, p60Var);
        }

        public void subscribe(h60<?>[] h60VarArr, int i) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            AtomicReference<p60> atomicReference = this.f4463d;
            for (int i2 = 0; i2 < i && !DisposableHelper.isDisposed(atomicReference.get()) && !this.done; i2++) {
                h60VarArr[i2].subscribe(withLatestInnerObserverArr[i2]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class WithLatestInnerObserver extends AtomicReference<p60> implements j60<Object> {
        public static final long serialVersionUID = 3256684027868224024L;
        public boolean hasValue;
        public final int index;
        public final WithLatestFromObserver<?, ?> parent;

        public WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i) {
            this.parent = withLatestFromObserver;
            this.index = i;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // me.tvspark.j60
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this, p60Var);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements f70<T, R> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // me.tvspark.f70
        public R apply(T t) throws Exception {
            return ObservableWithLatestFromMany.this.Wwwwwwwwwwwwwwwwwwwww.apply(new Object[]{t});
        }
    }

    public ObservableWithLatestFromMany(h60<T> h60Var, Iterable<? extends h60<?>> iterable, f70<? super Object[], R> f70Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwww = iterable;
        this.Wwwwwwwwwwwwwwwwwwwww = f70Var;
    }

    public ObservableWithLatestFromMany(h60<T> h60Var, h60<?>[] h60VarArr, f70<? super Object[], R> f70Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = h60VarArr;
        this.Wwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwww = f70Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super R> j60Var) {
        int length;
        h60<?>[] h60VarArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (h60VarArr == null) {
            h60VarArr = new h60[8];
            try {
                length = 0;
                for (h60<?> h60Var : this.Wwwwwwwwwwwwwwwwwwwwww) {
                    if (length == h60VarArr.length) {
                        h60VarArr = (h60[]) Arrays.copyOf(h60VarArr, (length >> 1) + length);
                    }
                    int i = length + 1;
                    h60VarArr[length] = h60Var;
                    length = i;
                }
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                EmptyDisposable.error(th, j60Var);
                return;
            }
        } else {
            length = h60VarArr.length;
        }
        if (length == 0) {
            kb0 kb0Var = new kb0(this.Wwwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            kb0Var.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new kb0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, kb0Var.Wwwwwwwwwwwwwwwwwwwwwww));
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwww, length);
        j60Var.onSubscribe(withLatestFromObserver);
        withLatestFromObserver.subscribe(h60VarArr, length);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(withLatestFromObserver);
    }
}

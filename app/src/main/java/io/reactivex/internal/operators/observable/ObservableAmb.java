package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.d60;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public final class ObservableAmb<T> extends d60<T> {
    public final Iterable<? extends h60<? extends T>> Wwwwwwwwwwwwwwwwwwwwwww;
    public final h60<? extends T>[] Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class AmbInnerObserver<T> extends AtomicReference<p60> implements j60<T> {
        public static final long serialVersionUID = -1185974347409665484L;
        public final j60<? super T> actual;
        public final int index;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> parent;
        public boolean won;

        public AmbInnerObserver(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i, j60<? super T> j60Var) {
            this.parent = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.index = i;
            this.actual = j60Var;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (!this.won) {
                if (!this.parent.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.index)) {
                    return;
                }
                this.won = true;
            }
            this.actual.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (!this.won) {
                if (!this.parent.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.index)) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    return;
                }
                this.won = true;
            }
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (!this.won) {
                if (!this.parent.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.index)) {
                    get().dispose();
                    return;
                }
                this.won = true;
            }
            this.actual.onNext(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this, p60Var);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements p60 {
        public final AtomicInteger Wwwwwwwwwwwwwwwwwwwwww = new AtomicInteger();
        public final AmbInnerObserver<T>[] Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = new AmbInnerObserver[i];
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwww.get();
            int i3 = 0;
            if (i2 != 0) {
                return i2 == i;
            } else if (!this.Wwwwwwwwwwwwwwwwwwwwww.compareAndSet(0, i)) {
                return false;
            } else {
                AmbInnerObserver<T>[] ambInnerObserverArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
                int length = ambInnerObserverArr.length;
                while (i3 < length) {
                    int i4 = i3 + 1;
                    if (i4 != i) {
                        ambInnerObserverArr[i3].dispose();
                    }
                    i3 = i4;
                }
                return true;
            }
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (this.Wwwwwwwwwwwwwwwwwwwwww.get() != -1) {
                this.Wwwwwwwwwwwwwwwwwwwwww.lazySet(-1);
                for (AmbInnerObserver<T> ambInnerObserver : this.Wwwwwwwwwwwwwwwwwwwwwww) {
                    ambInnerObserver.dispose();
                }
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwwww.get() == -1;
        }
    }

    public ObservableAmb(h60<? extends T>[] h60VarArr, Iterable<? extends h60<? extends T>> iterable) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60VarArr;
        this.Wwwwwwwwwwwwwwwwwwwwwww = iterable;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        int length;
        h60<? extends T>[] h60VarArr = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (h60VarArr == null) {
            h60VarArr = new d60[8];
            try {
                length = 0;
                for (h60<? extends T> h60Var : this.Wwwwwwwwwwwwwwwwwwwwwww) {
                    if (h60Var == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), j60Var);
                        return;
                    }
                    if (length == h60VarArr.length) {
                        h60<? extends T>[] h60VarArr2 = new h60[(length >> 2) + length];
                        System.arraycopy(h60VarArr, 0, h60VarArr2, 0, length);
                        h60VarArr = h60VarArr2;
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
            EmptyDisposable.complete(j60Var);
        } else if (length == 1) {
            h60VarArr[0].subscribe(j60Var);
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var, length);
            AmbInnerObserver<T>[] ambInnerObserverArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
            int length2 = ambInnerObserverArr.length;
            int i2 = 0;
            while (i2 < length2) {
                int i3 = i2 + 1;
                ambInnerObserverArr[i2] = new AmbInnerObserver<>(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
                i2 = i3;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.lazySet(0);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            for (int i4 = 0; i4 < length2 && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.get() == 0; i4++) {
                h60VarArr[i4].subscribe(ambInnerObserverArr[i4]);
            }
        }
    }
}

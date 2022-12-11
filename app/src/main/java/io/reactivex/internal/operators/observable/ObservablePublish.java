package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.gd0;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.x60;

/* loaded from: classes4.dex */
public final class ObservablePublish<T> extends gd0<T> {
    public final h60<T> Wwwwwwwwwwwwwwwwwwwwww;
    public final AtomicReference<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T>> Wwwwwwwwwwwwwwwwwwwwwww;
    public final h60<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class InnerDisposable<T> extends AtomicReference<Object> implements p60 {
        public static final long serialVersionUID = -1100270633763673112L;
        public final j60<? super T> child;

        public InnerDisposable(j60<? super T> j60Var) {
            this.child = j60Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) andSet).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return get() == this;
        }

        public void setParent(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (!compareAndSet(null, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<T>, p60 {
        public final AtomicReference<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T>> Wwwwwwwwwwwwwwwwwwwwwwww;
        public static final InnerDisposable[] Wwwwwwwwwwwwwwwwwwww = new InnerDisposable[0];
        public static final InnerDisposable[] Wwwwwwwwwwwwwwwwwww = new InnerDisposable[0];
        public final AtomicReference<p60> Wwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();
        public final AtomicReference<InnerDisposable<T>[]> Wwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>(Wwwwwwwwwwwwwwwwwwww);
        public final AtomicBoolean Wwwwwwwwwwwwwwwwwwwwww = new AtomicBoolean();

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AtomicReference<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T>> atomicReference) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = atomicReference;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.Wwwwwwwwwwwwwwwwwwwwwww.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (innerDisposableArr[i2].equals(innerDisposable)) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = Wwwwwwwwwwwwwwwwwwww;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i);
                    System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr3, i, (length - i) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!this.Wwwwwwwwwwwwwwwwwwwwwww.compareAndSet(innerDisposableArr, innerDisposableArr2));
        }

        @Override // me.tvspark.p60
        public void dispose() {
            InnerDisposable<T>[] innerDisposableArr = this.Wwwwwwwwwwwwwwwwwwwwwww.get();
            InnerDisposable<T>[] innerDisposableArr2 = Wwwwwwwwwwwwwwwwwww;
            if (innerDisposableArr == innerDisposableArr2 || this.Wwwwwwwwwwwwwwwwwwwwwww.getAndSet(innerDisposableArr2) == Wwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(this, null);
            DisposableHelper.dispose(this.Wwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww.get() == Wwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(this, null);
            for (InnerDisposable<T> innerDisposable : this.Wwwwwwwwwwwwwwwwwwwwwww.getAndSet(Wwwwwwwwwwwwwwwwwww)) {
                innerDisposable.child.onComplete();
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(this, null);
            InnerDisposable<T>[] andSet = this.Wwwwwwwwwwwwwwwwwwwwwww.getAndSet(Wwwwwwwwwwwwwwwwwww);
            if (andSet.length == 0) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            for (InnerDisposable<T> innerDisposable : andSet) {
                innerDisposable.child.onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            for (InnerDisposable<T> innerDisposable : this.Wwwwwwwwwwwwwwwwwwwwwww.get()) {
                innerDisposable.child.onNext(t);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this.Wwwwwwwwwwwwwwwwwwwww, p60Var);
        }
    }

    public ObservablePublish(h60<T> h60Var, h60<T> h60Var2, AtomicReference<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T>> atomicReference) {
        this.Wwwwwwwwwwwwwwwwwwwwww = h60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var2;
        this.Wwwwwwwwwwwwwwwwwwwwwww = atomicReference;
    }

    @Override // me.tvspark.gd0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x60<? super p60> x60Var) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        while (true) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.get();
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && !wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isDisposed()) {
                break;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(this.Wwwwwwwwwwwwwwwwwwwwwww);
            if (this.Wwwwwwwwwwwwwwwwwwwwwww.compareAndSet(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                break;
            }
        }
        boolean z = true;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.get() || !wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.compareAndSet(false, true)) {
            z = false;
        }
        try {
            x60Var.accept(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (!z) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwww.subscribe(j60Var);
    }
}

package io.reactivex.internal.operators.maybe;

import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.a60;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public final class MaybeZipArray$ZipCoordinator<T, R> extends AtomicInteger implements p60 {
    public static final long serialVersionUID = -5556924161382950569L;
    public final a60<? super R> actual;
    public final MaybeZipArray$ZipMaybeObserver<T>[] observers;
    public final Object[] values;
    public final f70<? super Object[], ? extends R> zipper;

    public MaybeZipArray$ZipCoordinator(a60<? super R> a60Var, int i, f70<? super Object[], ? extends R> f70Var) {
        super(i);
        this.actual = a60Var;
        this.zipper = f70Var;
        MaybeZipArray$ZipMaybeObserver<T>[] maybeZipArray$ZipMaybeObserverArr = new MaybeZipArray$ZipMaybeObserver[i];
        for (int i2 = 0; i2 < i; i2++) {
            maybeZipArray$ZipMaybeObserverArr[i2] = new MaybeZipArray$ZipMaybeObserver<>(this, i2);
        }
        this.observers = maybeZipArray$ZipMaybeObserverArr;
        this.values = new Object[i];
    }

    @Override // me.tvspark.p60
    public void dispose() {
        if (getAndSet(0) > 0) {
            for (MaybeZipArray$ZipMaybeObserver<T> maybeZipArray$ZipMaybeObserver : this.observers) {
                maybeZipArray$ZipMaybeObserver.dispose();
            }
        }
    }

    public void disposeExcept(int i) {
        MaybeZipArray$ZipMaybeObserver<T>[] maybeZipArray$ZipMaybeObserverArr = this.observers;
        int length = maybeZipArray$ZipMaybeObserverArr.length;
        for (int i2 = 0; i2 < i; i2++) {
            maybeZipArray$ZipMaybeObserverArr[i2].dispose();
        }
        while (true) {
            i++;
            if (i < length) {
                maybeZipArray$ZipMaybeObserverArr[i].dispose();
            } else {
                return;
            }
        }
    }

    public void innerComplete(int i) {
        if (getAndSet(0) > 0) {
            disposeExcept(i);
            this.actual.onComplete();
        }
    }

    public void innerError(Throwable th, int i) {
        if (getAndSet(0) <= 0) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        disposeExcept(i);
        this.actual.onError(th);
    }

    public void innerSuccess(T t, int i) {
        this.values[i] = t;
        if (decrementAndGet() == 0) {
            try {
                R apply = this.zipper.apply(this.values);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The zipper returned a null value");
                this.actual.onSuccess(apply);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.actual.onError(th);
            }
        }
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get() <= 0;
    }
}

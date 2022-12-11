package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.b60;
import me.tvspark.l70;
import me.tvspark.m60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.u60;

/* loaded from: classes4.dex */
public final class MaybeEqualSingle$EqualCoordinator<T> extends AtomicInteger implements p60 {
    public final m60<? super Boolean> actual;
    public final u60<? super T, ? super T> isEqual;
    public final MaybeEqualSingle$EqualObserver<T> observer1 = new MaybeEqualSingle$EqualObserver<>(this);
    public final MaybeEqualSingle$EqualObserver<T> observer2 = new MaybeEqualSingle$EqualObserver<>(this);

    public MaybeEqualSingle$EqualCoordinator(m60<? super Boolean> m60Var, u60<? super T, ? super T> u60Var) {
        super(2);
        this.actual = m60Var;
        this.isEqual = u60Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        this.observer1.dispose();
        this.observer2.dispose();
    }

    public void done() {
        if (decrementAndGet() == 0) {
            Object obj = this.observer1.value;
            Object obj2 = this.observer2.value;
            if (obj == null || obj2 == null) {
                this.actual.onSuccess(Boolean.valueOf(obj == null && obj2 == null));
                return;
            }
            try {
                if (((l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.isEqual) != null) {
                    this.actual.onSuccess(Boolean.valueOf(l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, obj2)));
                    return;
                }
                throw null;
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.actual.onError(th);
            }
        }
    }

    public void error(MaybeEqualSingle$EqualObserver<T> maybeEqualSingle$EqualObserver, Throwable th) {
        if (getAndSet(0) <= 0) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        MaybeEqualSingle$EqualObserver<T> maybeEqualSingle$EqualObserver2 = this.observer1;
        if (maybeEqualSingle$EqualObserver == maybeEqualSingle$EqualObserver2) {
            this.observer2.dispose();
        } else {
            maybeEqualSingle$EqualObserver2.dispose();
        }
        this.actual.onError(th);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.observer1.get());
    }

    public void subscribe(b60<? extends T> b60Var, b60<? extends T> b60Var2) {
        b60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.observer1);
        b60Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.observer2);
    }
}

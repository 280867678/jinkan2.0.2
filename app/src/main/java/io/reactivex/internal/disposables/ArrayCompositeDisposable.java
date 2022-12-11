package io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReferenceArray;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<p60> implements p60 {
    public static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int i) {
        super(i);
    }

    @Override // me.tvspark.p60
    public void dispose() {
        p60 andSet;
        if (get(0) != DisposableHelper.DISPOSED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                p60 p60Var = get(i);
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (p60Var != disposableHelper && (andSet = getAndSet(i, disposableHelper)) != DisposableHelper.DISPOSED && andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get(0) == DisposableHelper.DISPOSED;
    }

    public p60 replaceResource(int i, p60 p60Var) {
        p60 p60Var2;
        do {
            p60Var2 = get(i);
            if (p60Var2 == DisposableHelper.DISPOSED) {
                p60Var.dispose();
                return null;
            }
        } while (!compareAndSet(i, p60Var2, p60Var));
        return p60Var2;
    }

    public boolean setResource(int i, p60 p60Var) {
        p60 p60Var2;
        do {
            p60Var2 = get(i);
            if (p60Var2 == DisposableHelper.DISPOSED) {
                p60Var.dispose();
                return false;
            }
        } while (!compareAndSet(i, p60Var2, p60Var));
        if (p60Var2 != null) {
            p60Var2.dispose();
            return true;
        }
        return true;
    }
}

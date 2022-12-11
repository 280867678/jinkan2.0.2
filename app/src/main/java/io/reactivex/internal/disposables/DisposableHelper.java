package io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public enum DisposableHelper implements p60 {
    DISPOSED;

    public static boolean dispose(AtomicReference<p60> atomicReference) {
        p60 andSet;
        p60 p60Var = atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (p60Var == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean isDisposed(p60 p60Var) {
        return p60Var == DISPOSED;
    }

    public static boolean replace(AtomicReference<p60> atomicReference, p60 p60Var) {
        p60 p60Var2;
        do {
            p60Var2 = atomicReference.get();
            if (p60Var2 == DISPOSED) {
                if (p60Var == null) {
                    return false;
                }
                p60Var.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(p60Var2, p60Var));
        return true;
    }

    public static void reportDisposableSet() {
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new IllegalStateException("Disposable already set!"));
    }

    public static boolean set(AtomicReference<p60> atomicReference, p60 p60Var) {
        p60 p60Var2;
        do {
            p60Var2 = atomicReference.get();
            if (p60Var2 == DISPOSED) {
                if (p60Var == null) {
                    return false;
                }
                p60Var.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(p60Var2, p60Var));
        if (p60Var2 != null) {
            p60Var2.dispose();
            return true;
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<p60> atomicReference, p60 p60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var, "d is null");
        if (!atomicReference.compareAndSet(null, p60Var)) {
            p60Var.dispose();
            if (atomicReference.get() == DISPOSED) {
                return false;
            }
            reportDisposableSet();
            return false;
        }
        return true;
    }

    public static boolean validate(p60 p60Var, p60 p60Var2) {
        if (p60Var2 == null) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new NullPointerException("next is null"));
            return false;
        } else if (p60Var == null) {
            return true;
        } else {
            p60Var2.dispose();
            reportDisposableSet();
            return false;
        }
    }

    @Override // me.tvspark.p60
    public void dispose() {
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return true;
    }
}

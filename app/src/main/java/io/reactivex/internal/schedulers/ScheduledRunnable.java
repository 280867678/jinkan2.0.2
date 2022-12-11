package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
import me.tvspark.h70;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, p60 {
    public static final Object DISPOSED = new Object();
    public static final Object DONE = new Object();
    public static final int FUTURE_INDEX = 1;
    public static final int PARENT_INDEX = 0;
    public static final long serialVersionUID = -6120223772001106981L;
    public final Runnable actual;

    public ScheduledRunnable(Runnable runnable, h70 h70Var) {
        super(2);
        this.actual = runnable;
        lazySet(0, h70Var);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        while (true) {
            Object obj4 = get(1);
            if (obj4 == DONE || obj4 == (obj3 = DISPOSED)) {
                break;
            } else if (compareAndSet(1, obj4, obj3)) {
                if (obj4 != null) {
                    ((Future) obj4).cancel(true);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == DONE || obj == (obj2 = DISPOSED) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((h70) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        Object obj = get(1);
        return obj == DISPOSED || obj == DONE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Object obj;
        Object obj2;
        boolean compareAndSet;
        Object obj3;
        Object obj4;
        try {
            this.actual.run();
        } finally {
            try {
                obj3 = get(0);
                if (obj3 != DISPOSED) {
                    ((h70) obj3).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                }
                do {
                    obj4 = get(1);
                    if (obj4 != DISPOSED) {
                    }
                } while (!compareAndSet(1, obj4, DONE));
            } catch (Throwable th) {
                do {
                    if (obj == obj2) {
                        break;
                    }
                } while (!compareAndSet);
            }
        }
        obj3 = get(0);
        if (obj3 != DISPOSED && obj3 != null && compareAndSet(0, obj3, DONE)) {
            ((h70) obj3).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
        do {
            obj4 = get(1);
            if (obj4 != DISPOSED) {
                return;
            }
        } while (!compareAndSet(1, obj4, DONE));
    }

    public void setFuture(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == DONE) {
                return;
            }
            if (obj == DISPOSED) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }
}

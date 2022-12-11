package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    public static final int MAX_BUSY_WAIT_SPINS = 1000;
    public static final Runnable DONE = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static final Runnable INTERRUPTING = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static final Runnable PARKED = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public abstract void afterRanInterruptibly(T t, Throwable th);

    public final void interruptTask() {
        Runnable runnable = get();
        if (!(runnable instanceof Thread) || !compareAndSet(runnable, INTERRUPTING)) {
            return;
        }
        try {
            ((Thread) runnable).interrupt();
        } finally {
            if (getAndSet(DONE) == PARKED) {
                LockSupport.unpark((Thread) runnable);
            }
        }
    }

    public abstract boolean isDone();

    @Override // java.lang.Runnable
    public final void run() {
        T mo4826runInterruptibly;
        Thread currentThread = Thread.currentThread();
        if (!compareAndSet(null, currentThread)) {
            return;
        }
        boolean z = !isDone();
        if (z) {
            try {
                mo4826runInterruptibly = mo4826runInterruptibly();
            } catch (Throwable th) {
                if (!compareAndSet(currentThread, DONE)) {
                    Runnable runnable = get();
                    boolean z2 = false;
                    int i = 0;
                    while (true) {
                        if (runnable != INTERRUPTING && runnable != PARKED) {
                            break;
                        }
                        i++;
                        if (i > 1000) {
                            Runnable runnable2 = PARKED;
                            if (runnable == runnable2 || compareAndSet(INTERRUPTING, runnable2)) {
                                z2 = Thread.interrupted() || z2;
                                LockSupport.park(this);
                            }
                        } else {
                            Thread.yield();
                        }
                        runnable = get();
                    }
                    if (z2) {
                        currentThread.interrupt();
                    }
                }
                if (!z) {
                    return;
                }
                afterRanInterruptibly(null, th);
                return;
            }
        } else {
            mo4826runInterruptibly = null;
        }
        if (!compareAndSet(currentThread, DONE)) {
            Runnable runnable3 = get();
            boolean z3 = false;
            int i2 = 0;
            while (true) {
                if (runnable3 != INTERRUPTING && runnable3 != PARKED) {
                    break;
                }
                i2++;
                if (i2 > 1000) {
                    Runnable runnable4 = PARKED;
                    if (runnable3 == runnable4 || compareAndSet(INTERRUPTING, runnable4)) {
                        z3 = Thread.interrupted() || z3;
                        LockSupport.park(this);
                    }
                } else {
                    Thread.yield();
                }
                runnable3 = get();
            }
            if (z3) {
                currentThread.interrupt();
            }
        }
        if (!z) {
            return;
        }
        afterRanInterruptibly(mo4826runInterruptibly, null);
    }

    /* renamed from: runInterruptibly */
    public abstract T mo4826runInterruptibly() throws Exception;

    public abstract String toPendingString();

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == DONE) {
            str = "running=[DONE]";
        } else if (runnable == INTERRUPTING) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("running=[RUNNING ON ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(((Thread) runnable).getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("]");
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ", ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(toPendingString());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }
}

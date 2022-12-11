package io.reactivex.internal.util;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class ExceptionHelper {
    public static final Throwable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Throwable("No further exceptions") { // from class: io.reactivex.internal.util.ExceptionHelper.1
        public static final long serialVersionUID = -4649703670690200604L;

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    };

    public static RuntimeException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th) {
        if (!(th instanceof Error)) {
            return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
        }
        throw ((Error) th);
    }

    public static <T> Throwable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }

    public static <T> boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        do {
            th2 = atomicReference.get();
            if (th2 == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return false;
            }
        } while (!atomicReference.compareAndSet(th2, th2 == null ? th : new CompositeException(th2, th)));
        return true;
    }
}

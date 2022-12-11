package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    public static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(Throwable th) {
        return ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, th);
    }

    public boolean isTerminated() {
        return get() == ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public Throwable terminate() {
        return ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }
}

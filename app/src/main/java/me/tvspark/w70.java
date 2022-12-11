package me.tvspark;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes4.dex */
public abstract class w70<T> extends CountDownLatch implements j60<T>, p60 {
    public volatile boolean Wwwwwwwwwwwwwwwwwwwww;
    public p60 Wwwwwwwwwwwwwwwwwwwwww;
    public Throwable Wwwwwwwwwwwwwwwwwwwwwww;
    public T Wwwwwwwwwwwwwwwwwwwwwwww;

    public w70() {
        super(1);
    }

    public final T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (getCount() != 0) {
            try {
                await();
            } catch (InterruptedException e) {
                dispose();
                throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
            }
        }
        Throwable th = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (th == null) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
    }

    @Override // me.tvspark.p60
    public final void dispose() {
        this.Wwwwwwwwwwwwwwwwwwwww = true;
        p60 p60Var = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (p60Var != null) {
            p60Var.dispose();
        }
    }

    @Override // me.tvspark.p60
    public final boolean isDisposed() {
        return this.Wwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.j60
    public final void onComplete() {
        countDown();
    }

    @Override // me.tvspark.j60
    public final void onSubscribe(p60 p60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwww = p60Var;
        if (this.Wwwwwwwwwwwwwwwwwwwww) {
            p60Var.dispose();
        }
    }
}

package me.tvspark;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes4.dex */
public final class z70<T> extends CountDownLatch implements m60<T>, u50, a60<T> {
    public volatile boolean Wwwwwwwwwwwwwwwwwwwww;
    public p60 Wwwwwwwwwwwwwwwwwwwwww;
    public Throwable Wwwwwwwwwwwwwwwwwwwwwww;
    public T Wwwwwwwwwwwwwwwwwwwwwwww;

    public z70() {
        super(1);
    }

    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (getCount() != 0) {
            try {
                await();
            } catch (InterruptedException e) {
                this.Wwwwwwwwwwwwwwwwwwwww = true;
                p60 p60Var = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (p60Var != null) {
                    p60Var.dispose();
                }
                throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
            }
        }
        Throwable th = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (th == null) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
    }

    @Override // me.tvspark.u50
    public void onComplete() {
        countDown();
    }

    @Override // me.tvspark.m60
    public void onError(Throwable th) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = th;
        countDown();
    }

    @Override // me.tvspark.m60
    public void onSubscribe(p60 p60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwww = p60Var;
        if (this.Wwwwwwwwwwwwwwwwwwwww) {
            p60Var.dispose();
        }
    }

    @Override // me.tvspark.m60
    public void onSuccess(T t) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = t;
        countDown();
    }
}

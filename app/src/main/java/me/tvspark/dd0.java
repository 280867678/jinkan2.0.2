package me.tvspark;

import java.util.concurrent.CountDownLatch;

/* loaded from: classes4.dex */
public final class dd0 extends CountDownLatch implements x60<Throwable>, r60 {
    public Throwable Wwwwwwwwwwwwwwwwwwwwwwww;

    public dd0() {
        super(1);
    }

    @Override // me.tvspark.x60
    public void accept(Throwable th) throws Exception {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = th;
        countDown();
    }

    @Override // me.tvspark.r60
    public void run() {
        countDown();
    }
}

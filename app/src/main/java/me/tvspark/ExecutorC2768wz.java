package me.tvspark;

import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: me.tvspark.wz */
/* loaded from: classes4.dex */
public final class ExecutorC2768wz implements Executor {
    public final /* synthetic */ AbstractFuture Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ Executor Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww = true;

    /* renamed from: me.tvspark.wz$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final /* synthetic */ Runnable Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            ExecutorC2768wz.this.Wwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.run();
        }
    }

    public ExecutorC2768wz(Executor executor, AbstractFuture abstractFuture) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = executor;
        this.Wwwwwwwwwwwwwwwwwwwwww = abstractFuture;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwww.execute(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable));
        } catch (RejectedExecutionException e) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) e);
        }
    }
}

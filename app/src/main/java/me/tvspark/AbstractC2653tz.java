package me.tvspark;

import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: me.tvspark.tz */
/* loaded from: classes4.dex */
public abstract class AbstractC2653tz<V> implements AbstractFutureC2691uz<V> {
    public static final Logger Wwwwwwwwwwwwwwwwwwwwwwww = Logger.getLogger(AbstractC2653tz.class.getName());

    /* renamed from: me.tvspark.tz$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<V> extends AbstractC2653tz<V> {
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Object> Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(null);
        public final V Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(V v) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = v;
        }

        @Override // java.util.concurrent.Future
        public V get() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.Wwwwwwwwwwwwwwwwwwwwwww + "]]";
        }
    }

    /* renamed from: me.tvspark.tz$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<V> extends AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwww<V> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }

    @Override // me.tvspark.AbstractFutureC2691uz
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, Executor executor) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, "Runnable was null.");
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = Wwwwwwwwwwwwwwwwwwwwwwww;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException {
        if (timeUnit != null) {
            return ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this).Wwwwwwwwwwwwwwwwwwwwwww;
        }
        throw null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }
}

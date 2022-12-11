package me.tvspark;

import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: me.tvspark.qz */
/* loaded from: classes4.dex */
public abstract class AbstractC2542qz<V> extends AbstractC2616sz<V> {

    /* renamed from: me.tvspark.qz$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<V> extends AbstractC2542qz<V> implements AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwww<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, me.tvspark.AbstractFutureC2691uz
        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, Executor executor) {
            super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(j, timeUnit);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww instanceof AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }
    }
}

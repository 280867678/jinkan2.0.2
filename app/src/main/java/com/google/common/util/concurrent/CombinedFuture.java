package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import me.tvspark.AbstractC2425nz;
import me.tvspark.AbstractC2462oz;
import me.tvspark.AbstractFutureC2691uz;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public final class CombinedFuture<V> extends AbstractC2425nz<Object, V> {

    /* loaded from: classes3.dex */
    public final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<AbstractFutureC2691uz<V>> {
        public final AbstractC2462oz<V> callable;

        public AsyncCallableInterruptibleTask(AbstractC2462oz<V> abstractC2462oz, Executor executor) {
            super(executor);
            if (abstractC2462oz != null) {
                this.callable = abstractC2462oz;
                return;
            }
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        /* renamed from: runInterruptibly  reason: collision with other method in class */
        public AbstractFutureC2691uz<V> mo4826runInterruptibly() throws Exception {
            this.thrownByExecute = false;
            AbstractFutureC2691uz<V> call = this.callable.call();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
            return call;
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public /* bridge */ /* synthetic */ void setValue(Object obj) {
            setValue((AbstractFutureC2691uz) ((AbstractFutureC2691uz) obj));
        }

        public void setValue(AbstractFutureC2691uz<V> abstractFutureC2691uz) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    /* loaded from: classes3.dex */
    public final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        public final Callable<V> callable;

        public CallableInterruptibleTask(Callable<V> callable, Executor executor) {
            super(executor);
            if (callable != null) {
                this.callable = callable;
                return;
            }
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        /* renamed from: runInterruptibly */
        public V mo4826runInterruptibly() throws Exception {
            this.thrownByExecute = false;
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(V v) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    /* loaded from: classes3.dex */
    public abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        public final Executor listenerExecutor;
        public boolean thrownByExecute = true;

        public CombinedFutureInterruptibleTask(Executor executor) {
            if (executor != null) {
                this.listenerExecutor = executor;
                return;
            }
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void afterRanInterruptibly(T t, Throwable th) {
            if (th == null) {
                setValue(t);
            } else if (!(th instanceof ExecutionException)) {
                boolean z = th instanceof CancellationException;
                throw null;
            } else {
                th.getCause();
                throw null;
            }
        }

        public final void execute() {
            try {
                this.listenerExecutor.execute(this);
            } catch (RejectedExecutionException unused) {
                if (this.thrownByExecute) {
                    throw null;
                }
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            throw null;
        }

        public abstract void setValue(T t);
    }
}

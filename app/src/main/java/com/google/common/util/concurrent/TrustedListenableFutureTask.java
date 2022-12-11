package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import me.tvspark.AbstractC2462oz;
import me.tvspark.AbstractC2542qz;
import me.tvspark.AbstractFutureC2691uz;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class TrustedListenableFutureTask<V> extends AbstractC2542qz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<V> implements RunnableFuture<V> {

    /* loaded from: classes3.dex */
    public final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<AbstractFutureC2691uz<V>> {
        public final AbstractC2462oz<V> callable;

        public TrustedFutureInterruptibleAsyncTask(AbstractC2462oz<V> abstractC2462oz) {
            if (abstractC2462oz != null) {
                this.callable = abstractC2462oz;
                return;
            }
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public /* bridge */ /* synthetic */ void afterRanInterruptibly(Object obj, Throwable th) {
            afterRanInterruptibly((AbstractFutureC2691uz) ((AbstractFutureC2691uz) obj), th);
        }

        public void afterRanInterruptibly(AbstractFutureC2691uz<V> abstractFutureC2691uz, Throwable th) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        /* renamed from: runInterruptibly  reason: collision with other method in class */
        public AbstractFutureC2691uz<V> mo4826runInterruptibly() throws Exception {
            AbstractFutureC2691uz<V> call = this.callable.call();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
            return call;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    /* loaded from: classes3.dex */
    public final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        public final Callable<V> callable;

        public TrustedFutureInterruptibleTask(Callable<V> callable) {
            if (callable != null) {
                this.callable = callable;
                return;
            }
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptibly(V v, Throwable th) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        /* renamed from: runInterruptibly */
        public V mo4826runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }
}

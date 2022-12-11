package com.google.common.util.concurrent;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.AbstractFutureC2691uz;
import me.tvspark.C2762wt;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.b00;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
public abstract class AbstractFuture<V> extends b00 implements AbstractFutureC2691uz<V> {
    public static final Object Wwwwwwwwwwwwwwwwww;
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwww;
    public volatile Wwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public volatile Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public volatile Object Wwwwwwwwwwwwwwwwwwwwwwww;
    public static final boolean Wwwwwwwwwwwwwwwwwwwww = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger Wwwwwwwwwwwwwwwwwwww = Logger.getLogger(AbstractFuture.class.getName());

    /* loaded from: classes3.dex */
    public static final class Failure {
        public static final Failure Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.common.util.concurrent.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        public final Throwable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Failure(Throwable th) {
            if (th != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = th;
                return;
            }
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwww {
        public static final Wwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwww(false);
        public volatile Wwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public volatile Thread Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwww() {
            AbstractFuture.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, Thread.currentThread());
        }

        public Wwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public static final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public static final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public static final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public static final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public static final Unsafe Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements PrivilegedExceptionAction<Unsafe> {
            @Override // java.security.PrivilegedExceptionAction
            public Unsafe run() throws Exception {
                Field[] declaredFields;
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e) {
                    throw new RuntimeException("Could not initialize intrinsics", e.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("Wwwwwwwwwwwwwwwwwwwwww"));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("Wwwwwwwwwwwwwwwwwwwwwww"));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("Wwwwwwwwwwwwwwwwwwwwwwww"));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = unsafe.objectFieldOffset(Wwwwwwwwwwwwwwwwwwwwwwww.class.getDeclaredField("Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = unsafe.objectFieldOffset(Wwwwwwwwwwwwwwwwwwwwwwww.class.getDeclaredField("Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = unsafe;
            } catch (Exception e2) {
                C2762wt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e2);
                throw new RuntimeException(e2);
            }
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            super(null);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putObject(wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwww2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww, Thread thread) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putObject(wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, thread);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFuture<?> abstractFuture, Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww2) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareAndSwapObject(abstractFuture, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwww2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFuture<?> abstractFuture, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareAndSwapObject(abstractFuture, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareAndSwapObject(abstractFuture, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, obj, obj2);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwww<V> extends AbstractFuture<V> implements Wwwwwwwwwwwwwwwwwwwwwwwwwww<V> {
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
            return this.Wwwwwwwwwwwwwwwwwwwwwwww instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwww<V> extends AbstractFutureC2691uz<V> {
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<V> implements Runnable {
        public final AbstractFutureC2691uz<? extends V> Wwwwwwwwwwwwwwwwwwwwwww;
        public final AbstractFuture<V> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFuture<V> abstractFuture, AbstractFutureC2691uz<? extends V> abstractFutureC2691uz) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractFuture;
            this.Wwwwwwwwwwwwwwwwwwwwwww = abstractFutureC2691uz;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww != this) {
                return;
            }
            if (!AbstractFuture.Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture<?>) this.Wwwwwwwwwwwwwwwwwwwwwwww, (Object) this, AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFutureC2691uz<?>) this.Wwwwwwwwwwwwwwwwwwwwwww))) {
                return;
            }
            AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture<?>) this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AtomicReferenceFieldUpdater<AbstractFuture, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AtomicReferenceFieldUpdater<AbstractFuture, Wwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AtomicReferenceFieldUpdater<Wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AtomicReferenceFieldUpdater<Wwwwwwwwwwwwwwwwwwwwwwww, Thread> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AtomicReferenceFieldUpdater<Wwwwwwwwwwwwwwwwwwwwwwww, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwww> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, Wwwwwwwwwwwwwwwwwwwwwwww> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = atomicReferenceFieldUpdater;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = atomicReferenceFieldUpdater2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = atomicReferenceFieldUpdater3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = atomicReferenceFieldUpdater4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.lazySet(wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwww2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww, Thread thread) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.lazySet(wwwwwwwwwwwwwwwwwwwwwwww, thread);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFuture<?> abstractFuture, Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww2) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(abstractFuture, wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwww2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFuture<?> abstractFuture, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(abstractFuture, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(abstractFuture, obj, obj2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null, null);
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Executor Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Runnable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, Executor executor) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = runnable;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = executor;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Throwable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        static {
            if (AbstractFuture.Wwwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, null);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, null);
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = th;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww2);

        public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww, Thread thread);

        public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFuture<?> abstractFuture, Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww2);

        public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFuture<?> abstractFuture, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);

        public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFuture<?> abstractFuture, Object obj, Object obj2);
    }

    static {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Throwable th = null;
        try {
            wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwww(null);
            th = null;
        } catch (Throwable th2) {
            th = th2;
            try {
                wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AtomicReferenceFieldUpdater.newUpdater(Wwwwwwwwwwwwwwwwwwwwwwww.class, Thread.class, "Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"), AtomicReferenceFieldUpdater.newUpdater(Wwwwwwwwwwwwwwwwwwwwwwww.class, Wwwwwwwwwwwwwwwwwwwwwwww.class, "Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Wwwwwwwwwwwwwwwwwwwwwwww.class, "Wwwwwwwwwwwwwwwwwwwwww"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class, "Wwwwwwwwwwwwwwwwwwwwwww"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "Wwwwwwwwwwwwwwwwwwwwwwww"));
            } catch (Throwable th3) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
                th = th3;
            }
        }
        Wwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (th != null) {
            Wwwwwwwwwwwwwwwwwwww.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", th);
            Wwwwwwwwwwwwwwwwwwww.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        Wwwwwwwwwwwwwwwwww = new Object();
    }

    public static Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFutureC2691uz<?> abstractFutureC2691uz) {
        if (abstractFutureC2691uz instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Object obj = ((AbstractFuture) abstractFutureC2691uz).Wwwwwwwwwwwwwwwwwwwwwwww;
            if (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return obj;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : obj;
        }
        if (abstractFutureC2691uz instanceof b00) {
            AbstractFuture abstractFuture = (AbstractFuture) ((b00) abstractFutureC2691uz);
            Throwable th = null;
            if (abstractFuture != null) {
                if (abstractFuture instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    Object obj2 = abstractFuture.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (obj2 instanceof Failure) {
                        th = ((Failure) obj2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                }
                if (th != null) {
                    return new Failure(th);
                }
            } else {
                throw null;
            }
        }
        boolean isCancelled = abstractFutureC2691uz.isCancelled();
        if ((!Wwwwwwwwwwwwwwwwwwwww) && isCancelled) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        try {
            Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Future<Object>) abstractFutureC2691uz);
            if (!isCancelled) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null ? Wwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + abstractFutureC2691uz));
        } catch (CancellationException e) {
            if (isCancelled) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, e);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + abstractFutureC2691uz, e));
        } catch (ExecutionException e2) {
            if (!isCancelled) {
                return new Failure(e2.getCause());
            }
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + abstractFutureC2691uz, e2));
        } catch (Throwable th2) {
            return new Failure(th2);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = Wwwwwwwwwwwwwwwwwwww;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    public static <V> V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(V v) {
        if (v == null) {
            v = (V) Wwwwwwwwwwwwwwwwww;
        }
        if (Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture<?>) this, (Object) null, (Object) v)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture<?>) this);
            return true;
        }
        return false;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww) {
        wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        while (true) {
            Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwww2 == Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww3 = null;
            while (wwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    wwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwww2;
                } else if (wwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                    wwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwww4;
                    if (wwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        break;
                    }
                } else if (!Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture<?>) this, wwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwww4)) {
                    break;
                }
                wwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwww4;
            }
            return;
        }
    }

    @Override // me.tvspark.AbstractFutureC2691uz
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, Executor executor) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, "Runnable was null.");
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(executor, "Executor was null.");
        if (isDone() || (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww) == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, executor);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, executor);
        do {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture<?>) this, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                return;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
        } while (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, executor);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringBuilder sb) {
        String str = "]";
        try {
            Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Future<Object>) this);
            sb.append("SUCCESS, result=[");
            sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == this ? "this future" : String.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
            sb.append(str);
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            str = " thrown from get()]";
            sb.append(str);
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append(str);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if ((obj == null) || (obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwww ? new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, new CancellationException("Future.cancel() was called.")) : z ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean z2 = false;
            AbstractFuture<V> abstractFuture = this;
            while (true) {
                if (Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture<?>) abstractFuture, obj, (Object) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture<?>) abstractFuture);
                    if (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        return true;
                    }
                    AbstractFutureC2691uz<? extends V> abstractFutureC2691uz = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwwwwww;
                    if (!(abstractFutureC2691uz instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        abstractFutureC2691uz.cancel(z);
                        return true;
                    }
                    abstractFuture = (AbstractFuture) abstractFutureC2691uz;
                    obj = abstractFuture.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (!(obj == null) && !(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    obj = abstractFuture.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        return z2;
                    }
                }
            }
        } else {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
        java.util.concurrent.locks.LockSupport.park(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
        if (java.lang.Thread.interrupted() != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
        r0 = r6.Wwwwwwwwwwwwwwwwwwwwwwww;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
        if (r0 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0046, code lost:
        if ((r4 & (!(r0 instanceof com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww))) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0041, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004d, code lost:
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0055, code lost:
        throw new java.lang.InterruptedException();
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public V get() throws InterruptedException, ExecutionException {
        if (!Thread.interrupted()) {
            Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if ((obj != null) && (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwww))) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            }
            Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
            Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwww();
            do {
                Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwww);
                if (Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture<?>) this, wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwww2)) {
                    break;
                }
                wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            } while (wwwwwwwwwwwwwwwwwwwwwwww != Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        return (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) & (obj != null);
    }

    public String toString() {
        String sb;
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (!isCancelled()) {
            if (!isDone()) {
                try {
                    sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                } catch (RuntimeException e) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Exception thrown from implementation: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(e.getClass());
                    sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                }
                if (sb != null && !sb.isEmpty()) {
                    outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, "PENDING, info=[", sb, "]");
                    sb2.append("]");
                    return sb2.toString();
                } else if (!isDone()) {
                    str = "PENDING";
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2);
            sb2.append("]");
            return sb2.toString();
        }
        str = "CANCELLED";
        sb2.append(str);
        sb2.append("]");
        return sb2.toString();
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            super(null);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww2) {
            wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwww2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww, Thread thread) {
            wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = thread;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFuture<?> abstractFuture, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            synchronized (abstractFuture) {
                if (abstractFuture.Wwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    abstractFuture.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.Wwwwwwwwwwwwwwwwwwwwwwww == obj) {
                    abstractFuture.Wwwwwwwwwwwwwwwwwwwwwwww = obj2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFuture<?> abstractFuture, Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww2) {
            synchronized (abstractFuture) {
                if (abstractFuture.Wwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwww) {
                    abstractFuture.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwww2;
                    return true;
                }
                return false;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.google.common.util.concurrent.AbstractFuture$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.common.util.concurrent.AbstractFuture<?>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.common.util.concurrent.AbstractFuture] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.google.common.util.concurrent.AbstractFuture<V>, com.google.common.util.concurrent.AbstractFuture] */
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFuture<?> abstractFuture) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = null;
        while (true) {
            Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww = ((AbstractFuture) abstractFuture).Wwwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture) abstractFuture, wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                while (wwwwwwwwwwwwwwwwwwwwwwww != null) {
                    Thread thread = wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (thread != null) {
                        wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                        LockSupport.unpark(thread);
                    }
                    wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                ((AbstractFuture) abstractFuture).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                do {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((AbstractFuture) abstractFuture).Wwwwwwwwwwwwwwwwwwwwwww;
                } while (!Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture) abstractFuture, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                while (true) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    }
                }
                while (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Runnable runnable = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (runnable instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) runnable;
                        abstractFuture = wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                        if (abstractFuture.Wwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            if (Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractFuture, wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFutureC2691uz<?>) wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                }
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
        java.util.concurrent.locks.LockSupport.parkNanos(r12, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
        if (java.lang.Thread.interrupted() != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
        r0 = r12.Wwwwwwwwwwwwwwwwwwwwwwww;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
        if (r0 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005d, code lost:
        if ((r1 & (!(r0 instanceof com.google.common.util.concurrent.AbstractFuture.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww))) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
        r0 = r4 - java.lang.System.nanoTime();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
        if (r0 >= 1000) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006e, code lost:
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0063, code lost:
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0057, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0072, code lost:
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007a, code lost:
        throw new java.lang.InterruptedException();
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if ((obj != null) && (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwww))) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                }
                Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwww();
                do {
                    Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwww2, wwwwwwwwwwwwwwwwwwwwwwww);
                    if (Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture<?>) this, wwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwww2)) {
                        break;
                    }
                    wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
                } while (wwwwwwwwwwwwwwwwwwwwwwww != Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
            while (nanos > 0) {
                Object obj2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if ((obj2 != null) && (!(obj2 instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwww))) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj2);
                }
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                nanos = nanoTime - System.nanoTime();
            }
            String abstractFuture = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String str = "Waited " + j + StringUtils.SPACE + timeUnit.toString().toLowerCase(Locale.ROOT);
            if (nanos + 1000 < 0) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " (plus ");
                long j2 = -nanos;
                long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(convert);
                int i = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
                boolean z = i == 0 || nanos2 > 1000;
                if (i > 0) {
                    String str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + convert + StringUtils.SPACE + lowerCase;
                    if (z) {
                        str2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, ",");
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, StringUtils.SPACE);
                }
                if (z) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + nanos2 + " nanoseconds ";
                }
                str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "delay)");
            }
            if (!isDone()) {
                throw new TimeoutException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " for ", abstractFuture));
            }
            throw new TimeoutException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " but future completed as timeout expired"));
        }
        throw new InterruptedException();
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("setFuture=[");
            AbstractFutureC2691uz<? extends V> abstractFutureC2691uz = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwwwwww;
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, abstractFutureC2691uz == this ? "this future" : String.valueOf(abstractFutureC2691uz), "]");
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("remaining delay=[");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" ms]");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) throws ExecutionException {
        if (obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Throwable th = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else {
            if (obj != Wwwwwwwwwwwwwwwwww) {
                return obj;
            }
            return null;
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th) {
        if (th != null) {
            if (!Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture<?>) this, (Object) null, (Object) new Failure(th))) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture<?>) this);
            return true;
        }
        throw null;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractFutureC2691uz<? extends V> abstractFutureC2691uz) {
        Failure failure;
        if (abstractFutureC2691uz != null) {
            Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (obj == null) {
                if (abstractFutureC2691uz.isDone()) {
                    if (!Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture<?>) this, (Object) null, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFutureC2691uz<?>) abstractFutureC2691uz))) {
                        return false;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture<?>) this);
                    return true;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, abstractFutureC2691uz);
                if (Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture<?>) this, (Object) null, (Object) wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    try {
                        abstractFutureC2691uz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwww, DirectExecutor.INSTANCE);
                    } catch (Throwable th) {
                        try {
                            failure = new Failure(th);
                        } catch (Throwable unused) {
                            failure = Failure.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractFuture<?>) this, (Object) wwwwwwwwwwwwwwwwwwwwwwwwwwwww, (Object) failure);
                    }
                    return true;
                }
                obj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            }
            if (obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                abstractFutureC2691uz.cancel(((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return false;
        }
        throw null;
    }
}

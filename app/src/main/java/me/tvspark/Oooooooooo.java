package me.tvspark;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
public final class Oooooooooo implements ExecutorService {
    public static volatile int Wwwwwwwwwwwwwwwwwwwwww;
    public static final long Wwwwwwwwwwwwwwwwwwwwwww = TimeUnit.SECONDS.toMillis(10);
    public final ExecutorService Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            @Override // me.tvspark.Oooooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th) {
                if (th != null) {
                    Log.isLoggable("GlideExecutor", 6);
                }
            }
        }

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th);
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ThreadFactory {
        public int Wwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
        public final String Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.Oooooooooo$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3463Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Thread {
            public C3463Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwww) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                }
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            C3463Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww c3463Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            c3463Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C3463Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, "glide-" + this.Wwwwwwwwwwwwwwwwwwwwwwww + "-thread-" + this.Wwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww + 1;
            return c3463Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    @VisibleForTesting
    public Oooooooooo(ExecutorService executorService) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = executorService;
    }

    public static Oooooooooo Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (!TextUtils.isEmpty("source")) {
            return new Oooooooooo(new ThreadPoolExecutor(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("source", wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false)));
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Name must be non-null and non-empty, but given: ", "source"));
    }

    public static Oooooooooo Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!TextUtils.isEmpty("disk-cache")) {
            return new Oooooooooo(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("disk-cache", wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true)));
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Name must be non-null and non-empty, but given: ", "disk-cache"));
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwww == 0) {
            Wwwwwwwwwwwwwwwwwwwwww = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        return Wwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.Wwwwwwwwwwwwwwwwwwwwwwww.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.Wwwwwwwwwwwwwwwwwwwwwwww.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.submit(callable);
    }

    public String toString() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

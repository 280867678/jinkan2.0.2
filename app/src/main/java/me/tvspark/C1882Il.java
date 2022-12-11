package me.tvspark;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import me.tvspark.O000000;

/* renamed from: me.tvspark.Il */
/* loaded from: classes4.dex */
public final class C1882Il {
    public O000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @VisibleForTesting
    public final Map<Illlllllllllllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap();
    public final ReferenceQueue<O000000<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ReferenceQueue<>();

    @VisibleForTesting
    /* renamed from: me.tvspark.Il$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends WeakReference<O000000<?>> {
        @Nullable
        public AbstractC1886O0<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Illlllllllllllllllllllllllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Illlllllllllllllllllllllllll illlllllllllllllllllllllllll, @NonNull O000000<?> o000000, @NonNull ReferenceQueue<? super O000000<?>> referenceQueue, boolean z) {
            super(o000000, referenceQueue);
            AbstractC1886O0<?> abstractC1886O0;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllllllllll, "Argument must not be null");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illlllllllllllllllllllllllll;
            if (!o000000.Wwwwwwwwwwwwwwwwwwwwwwww || !z) {
                abstractC1886O0 = null;
            } else {
                abstractC1886O0 = o000000.Wwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1886O0, "Argument must not be null");
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC1886O0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = o000000.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* renamed from: me.tvspark.Il$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ThreadFactory {

        /* renamed from: me.tvspark.Il$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC3460Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ Runnable Wwwwwwwwwwwwwwwwwwwwwwww;

            public RunnableC3460Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Runnable runnable) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC3460Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, runnable), "glide-active-resources");
        }
    }

    public C1882Il(boolean z) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        newSingleThreadExecutor.execute(new IIlllllllll(this));
    }

    @Nullable
    public synchronized O000000<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illlllllllllllllllllllllllll illlllllllllllllllllllllllll) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(illlllllllllllllllllllllllll);
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return null;
        }
        O000000<?> o000000 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get();
        if (o000000 == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return o000000;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        synchronized (this) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new O000000<>(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true, false, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
        }
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illlllllllllllllllllllllllll illlllllllllllllllllllllllll, O000000<?> o000000) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww put = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(illlllllllllllllllllllllllll, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllllllllll, o000000, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        if (put != null) {
            put.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            put.clear();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(O000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        synchronized (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            synchronized (this) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illlllllllllllllllllllllllll illlllllllllllllllllllllllll) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww remove = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(illlllllllllllllllllllllllll);
        if (remove != null) {
            remove.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            remove.clear();
        }
    }
}

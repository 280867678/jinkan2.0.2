package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.outline;

/* loaded from: classes4.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    public static final long serialVersionUID = -7789753024099756196L;
    public final String prefix;
    public final int priority;

    public RxThreadFactory(String str) {
        this(str, 5);
    }

    public RxThreadFactory(String str, int i) {
        this.prefix = str;
        this.priority = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.prefix + '-' + incrementAndGet());
        thread.setPriority(this.priority);
        thread.setDaemon(true);
        return thread;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RxThreadFactory["), this.prefix, "]");
    }
}

package org.apache.http.impl.bootstrap;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public class ThreadFactoryImpl implements ThreadFactory {
    public final AtomicLong count;
    public final ThreadGroup group;
    public final String namePrefix;

    public ThreadFactoryImpl(String str) {
        this(str, null);
    }

    public ThreadFactoryImpl(String str, ThreadGroup threadGroup) {
        this.namePrefix = str;
        this.group = threadGroup;
        this.count = new AtomicLong();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.group;
        return new Thread(threadGroup, runnable, this.namePrefix + "-" + this.count.incrementAndGet());
    }
}

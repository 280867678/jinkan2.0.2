package org.apache.commons.lang3.concurrent;

import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public class BasicThreadFactory implements ThreadFactory {
    public final Boolean daemonFlag;
    public final String namingPattern;
    public final Integer priority;
    public final AtomicLong threadCounter;
    public final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    public final ThreadFactory wrappedFactory;

    /* loaded from: classes4.dex */
    public static class Builder implements org.apache.commons.lang3.builder.Builder<BasicThreadFactory> {
        public Boolean daemonFlag;
        public Thread.UncaughtExceptionHandler exceptionHandler;
        public String namingPattern;
        public Integer priority;
        public ThreadFactory wrappedFactory;

        @Override // org.apache.commons.lang3.builder.Builder
        /* renamed from: build  reason: collision with other method in class */
        public BasicThreadFactory mo5184build() {
            BasicThreadFactory basicThreadFactory = new BasicThreadFactory(this);
            reset();
            return basicThreadFactory;
        }

        public Builder daemon(boolean z) {
            this.daemonFlag = Boolean.valueOf(z);
            return this;
        }

        public Builder namingPattern(String str) {
            if (str != null) {
                this.namingPattern = str;
                return this;
            }
            throw new NullPointerException("Naming pattern must not be null!");
        }

        public Builder priority(int i) {
            this.priority = Integer.valueOf(i);
            return this;
        }

        public void reset() {
            this.wrappedFactory = null;
            this.exceptionHandler = null;
            this.namingPattern = null;
            this.priority = null;
            this.daemonFlag = null;
        }

        public Builder uncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            if (uncaughtExceptionHandler != null) {
                this.exceptionHandler = uncaughtExceptionHandler;
                return this;
            }
            throw new NullPointerException("Uncaught exception handler must not be null!");
        }

        public Builder wrappedFactory(ThreadFactory threadFactory) {
            if (threadFactory != null) {
                this.wrappedFactory = threadFactory;
                return this;
            }
            throw new NullPointerException("Wrapped ThreadFactory must not be null!");
        }
    }

    public BasicThreadFactory(Builder builder) {
        this.wrappedFactory = builder.wrappedFactory == null ? Executors.defaultThreadFactory() : builder.wrappedFactory;
        this.namingPattern = builder.namingPattern;
        this.priority = builder.priority;
        this.daemonFlag = builder.daemonFlag;
        this.uncaughtExceptionHandler = builder.exceptionHandler;
        this.threadCounter = new AtomicLong();
    }

    private void initializeThread(Thread thread) {
        if (getNamingPattern() != null) {
            thread.setName(String.format(getNamingPattern(), Long.valueOf(this.threadCounter.incrementAndGet())));
        }
        if (getUncaughtExceptionHandler() != null) {
            thread.setUncaughtExceptionHandler(getUncaughtExceptionHandler());
        }
        if (getPriority() != null) {
            thread.setPriority(getPriority().intValue());
        }
        if (getDaemonFlag() != null) {
            thread.setDaemon(getDaemonFlag().booleanValue());
        }
    }

    public final Boolean getDaemonFlag() {
        return this.daemonFlag;
    }

    public final String getNamingPattern() {
        return this.namingPattern;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public long getThreadCount() {
        return this.threadCounter.get();
    }

    public final Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return this.uncaughtExceptionHandler;
    }

    public final ThreadFactory getWrappedFactory() {
        return this.wrappedFactory;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = getWrappedFactory().newThread(runnable);
        initializeThread(newThread);
        return newThread;
    }
}

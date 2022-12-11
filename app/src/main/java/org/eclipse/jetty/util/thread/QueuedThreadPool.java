package org.eclipse.jetty.util.thread;

import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.TokenParser;
import org.eclipse.jetty.util.BlockingArrayQueue;
import org.eclipse.jetty.util.ConcurrentHashSet;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.AggregateLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.ThreadPool;

/* loaded from: classes5.dex */
public class QueuedThreadPool extends AbstractLifeCycle implements ThreadPool.SizedThreadPool, Executor, Dumpable {
    public static final Logger LOG = Log.getLogger(QueuedThreadPool.class);
    public boolean _daemon;
    public boolean _detailedDump;
    public BlockingQueue<Runnable> _jobs;
    public final Object _joinLock;
    public final AtomicLong _lastShrink;
    public int _maxIdleTimeMs;
    public int _maxQueued;
    public int _maxStopTime;
    public int _maxThreads;
    public int _minThreads;
    public String _name;
    public int _priority;
    public Runnable _runnable;
    public final ConcurrentHashSet<Thread> _threads;
    public final AtomicInteger _threadsIdle;
    public final AtomicInteger _threadsStarted;

    public QueuedThreadPool() {
        this._threadsStarted = new AtomicInteger();
        this._threadsIdle = new AtomicInteger();
        this._lastShrink = new AtomicLong();
        this._threads = new ConcurrentHashSet<>();
        this._joinLock = new Object();
        this._maxIdleTimeMs = 60000;
        this._maxThreads = TinkerReport.KEY_LOADED_EXCEPTION_RESOURCE;
        this._minThreads = 8;
        this._maxQueued = -1;
        this._priority = 5;
        this._daemon = false;
        this._maxStopTime = 100;
        this._detailedDump = false;
        this._runnable = new Runnable() { // from class: org.eclipse.jetty.util.thread.QueuedThreadPool.3
            /* JADX WARN: Code restructure failed: missing block: B:44:0x0119, code lost:
                if (r2 != false) goto L46;
             */
            /* JADX WARN: Code restructure failed: missing block: B:75:0x00f7, code lost:
                if (r2 == false) goto L45;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Throwable th;
                boolean z;
                Exception e;
                boolean z2;
                InterruptedException e2;
                try {
                    try {
                        Runnable runnable = (Runnable) QueuedThreadPool.this._jobs.poll();
                        z2 = false;
                        while (QueuedThreadPool.this.isRunning()) {
                            try {
                                while (runnable != null && QueuedThreadPool.this.isRunning()) {
                                    QueuedThreadPool.this.runJob(runnable);
                                    runnable = (Runnable) QueuedThreadPool.this._jobs.poll();
                                }
                                try {
                                    QueuedThreadPool.this._threadsIdle.incrementAndGet();
                                    while (QueuedThreadPool.this.isRunning() && runnable == null) {
                                        if (QueuedThreadPool.this._maxIdleTimeMs <= 0) {
                                            runnable = (Runnable) QueuedThreadPool.this._jobs.take();
                                        } else {
                                            int i = QueuedThreadPool.this._threadsStarted.get();
                                            if (i > QueuedThreadPool.this._minThreads) {
                                                long j = QueuedThreadPool.this._lastShrink.get();
                                                long currentTimeMillis = System.currentTimeMillis();
                                                if (j == 0 || currentTimeMillis - j > QueuedThreadPool.this._maxIdleTimeMs) {
                                                    boolean z3 = QueuedThreadPool.this._lastShrink.compareAndSet(j, currentTimeMillis) && QueuedThreadPool.this._threadsStarted.compareAndSet(i, i + (-1));
                                                    if (z3) {
                                                        try {
                                                            if (!z3) {
                                                                QueuedThreadPool.this._threadsStarted.decrementAndGet();
                                                            }
                                                            QueuedThreadPool.this._threads.remove(Thread.currentThread());
                                                            return;
                                                        } catch (InterruptedException e3) {
                                                            e2 = e3;
                                                            z2 = z3;
                                                            QueuedThreadPool.LOG.ignore(e2);
                                                        } catch (Exception e4) {
                                                            e = e4;
                                                            z2 = z3;
                                                            QueuedThreadPool.LOG.warn(e);
                                                            if (!z2) {
                                                                QueuedThreadPool.this._threadsStarted.decrementAndGet();
                                                            }
                                                            QueuedThreadPool.this._threads.remove(Thread.currentThread());
                                                            return;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            z = z3;
                                                            if (!z) {
                                                                QueuedThreadPool.this._threadsStarted.decrementAndGet();
                                                            }
                                                            QueuedThreadPool.this._threads.remove(Thread.currentThread());
                                                            throw th;
                                                        }
                                                    } else {
                                                        z2 = z3;
                                                    }
                                                }
                                            }
                                            runnable = QueuedThreadPool.this.idleJobPoll();
                                        }
                                    }
                                    QueuedThreadPool.this._threadsIdle.decrementAndGet();
                                } finally {
                                }
                            } catch (InterruptedException e5) {
                                e2 = e5;
                            } catch (Exception e6) {
                                e = e6;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (InterruptedException e7) {
                    e2 = e7;
                    z2 = false;
                } catch (Exception e8) {
                    e = e8;
                    z2 = false;
                } catch (Throwable th4) {
                    th = th4;
                    z = false;
                }
            }
        };
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("qtp");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(super.hashCode());
        this._name = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public QueuedThreadPool(int i) {
        this();
        setMaxThreads(i);
    }

    public QueuedThreadPool(BlockingQueue<Runnable> blockingQueue) {
        this();
        this._jobs = blockingQueue;
        blockingQueue.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable idleJobPoll() throws InterruptedException {
        return this._jobs.poll(this._maxIdleTimeMs, TimeUnit.MILLISECONDS);
    }

    private boolean startThread(int i) {
        if (!this._threadsStarted.compareAndSet(i, i + 1)) {
            return false;
        }
        try {
            Thread newThread = newThread(this._runnable);
            newThread.setDaemon(this._daemon);
            newThread.setPriority(this._priority);
            newThread.setName(this._name + "-" + newThread.getId());
            this._threads.add(newThread);
            newThread.start();
            return true;
        } catch (Throwable th) {
            this._threadsStarted.decrementAndGet();
            throw th;
        }
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    public boolean dispatch(Runnable runnable) {
        int i;
        if (isRunning()) {
            int size = this._jobs.size();
            int idleThreads = getIdleThreads();
            if (this._jobs.offer(runnable)) {
                if ((idleThreads == 0 || size > idleThreads) && (i = this._threadsStarted.get()) < this._maxThreads) {
                    startThread(i);
                }
                return true;
            }
        }
        LOG.debug("Dispatched {} to stopped {}", runnable, this);
        return false;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        BlockingQueue<Runnable> blockingArrayQueue;
        super.doStart();
        this._threadsStarted.set(0);
        if (this._jobs == null) {
            if (this._maxQueued > 0) {
                blockingArrayQueue = new ArrayBlockingQueue<>(this._maxQueued);
            } else {
                int i = this._minThreads;
                blockingArrayQueue = new BlockingArrayQueue<>(i, i);
            }
            this._jobs = blockingArrayQueue;
        }
        while (true) {
            int i2 = this._threadsStarted.get();
            if (!isRunning() || i2 >= this._minThreads) {
                return;
            }
            startThread(i2);
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        StackTraceElement[] stackTrace;
        super.doStop();
        long currentTimeMillis = System.currentTimeMillis();
        while (this._threadsStarted.get() > 0 && System.currentTimeMillis() - currentTimeMillis < this._maxStopTime / 2) {
            Thread.sleep(1L);
        }
        this._jobs.clear();
        Runnable runnable = new Runnable() { // from class: org.eclipse.jetty.util.thread.QueuedThreadPool.1
            @Override // java.lang.Runnable
            public void run() {
            }
        };
        int i = this._threadsIdle.get();
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            this._jobs.offer(runnable);
            i = i2;
        }
        Thread.yield();
        if (this._threadsStarted.get() > 0) {
            Iterator<Thread> it = this._threads.iterator();
            while (it.hasNext()) {
                it.next().interrupt();
            }
        }
        while (this._threadsStarted.get() > 0 && System.currentTimeMillis() - currentTimeMillis < this._maxStopTime) {
            Thread.sleep(1L);
        }
        Thread.yield();
        int size = this._threads.size();
        if (size > 0) {
            LOG.warn(size + " threads could not be stopped", new Object[0]);
            if (size == 1 || LOG.isDebugEnabled()) {
                Iterator<Thread> it2 = this._threads.iterator();
                while (it2.hasNext()) {
                    Thread next = it2.next();
                    LOG.info("Couldn't stop " + next, new Object[0]);
                    for (StackTraceElement stackTraceElement : next.getStackTrace()) {
                        LOG.info(" at " + stackTraceElement, new Object[0]);
                    }
                }
            }
        }
        synchronized (this._joinLock) {
            this._joinLock.notifyAll();
        }
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return AggregateLifeCycle.dump(this);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable appendable, String str) throws IOException {
        ArrayList arrayList = new ArrayList(getMaxThreads());
        Iterator<Thread> it = this._threads.iterator();
        while (true) {
            final boolean z = true;
            if (!it.hasNext()) {
                AggregateLifeCycle.dumpObject(appendable, this);
                AggregateLifeCycle.dump(appendable, str, arrayList);
                return;
            }
            final Thread next = it.next();
            final StackTraceElement[] stackTrace = next.getStackTrace();
            if (stackTrace != null) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if ("idleJobPoll".equals(stackTraceElement.getMethodName())) {
                        break;
                    }
                }
            }
            z = false;
            if (this._detailedDump) {
                arrayList.add(new Dumpable() { // from class: org.eclipse.jetty.util.thread.QueuedThreadPool.2
                    @Override // org.eclipse.jetty.util.component.Dumpable
                    public String dump() {
                        return null;
                    }

                    @Override // org.eclipse.jetty.util.component.Dumpable
                    public void dump(Appendable appendable2, String str2) throws IOException {
                        appendable2.append(String.valueOf(next.getId())).append(TokenParser.f4579SP).append(next.getName()).append(TokenParser.f4579SP).append(next.getState().toString()).append(z ? " IDLE" : "").append('\n');
                        if (!z) {
                            AggregateLifeCycle.dump(appendable2, str2, Arrays.asList(stackTrace));
                        }
                    }
                });
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(next.getId());
                sb.append(StringUtils.SPACE);
                sb.append(next.getName());
                sb.append(StringUtils.SPACE);
                sb.append(next.getState());
                sb.append(" @ ");
                sb.append(stackTrace.length > 0 ? stackTrace[0] : "???");
                sb.append(z ? " IDLE" : "");
                arrayList.add(sb.toString());
            }
        }
    }

    public String dumpThread(long j) {
        Iterator<Thread> it = this._threads.iterator();
        while (it.hasNext()) {
            Thread next = it.next();
            if (next.getId() == j) {
                StringBuilder sb = new StringBuilder();
                sb.append(next.getId());
                sb.append(StringUtils.SPACE);
                sb.append(next.getName());
                sb.append(StringUtils.SPACE);
                sb.append(next.getState());
                sb.append(":\n");
                StackTraceElement[] stackTrace = next.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append("  at ");
                    sb.append(stackTraceElement.toString());
                    sb.append('\n');
                }
                return sb.toString();
            }
        }
        return null;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (dispatch(runnable)) {
            return;
        }
        throw new RejectedExecutionException();
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    public int getIdleThreads() {
        return this._threadsIdle.get();
    }

    public int getMaxIdleTimeMs() {
        return this._maxIdleTimeMs;
    }

    public int getMaxQueued() {
        return this._maxQueued;
    }

    public int getMaxStopTimeMs() {
        return this._maxStopTime;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool.SizedThreadPool
    public int getMaxThreads() {
        return this._maxThreads;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool.SizedThreadPool
    public int getMinThreads() {
        return this._minThreads;
    }

    public String getName() {
        return this._name;
    }

    public BlockingQueue<Runnable> getQueue() {
        return this._jobs;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    public int getThreads() {
        return this._threadsStarted.get();
    }

    public int getThreadsPriority() {
        return this._priority;
    }

    public boolean interruptThread(long j) {
        Iterator<Thread> it = this._threads.iterator();
        while (it.hasNext()) {
            Thread next = it.next();
            if (next.getId() == j) {
                next.interrupt();
                return true;
            }
        }
        return false;
    }

    public boolean isDaemon() {
        return this._daemon;
    }

    public boolean isDetailedDump() {
        return this._detailedDump;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    public boolean isLowOnThreads() {
        return this._threadsStarted.get() == this._maxThreads && this._jobs.size() >= this._threadsIdle.get();
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    public void join() throws InterruptedException {
        synchronized (this._joinLock) {
            while (isRunning()) {
                this._joinLock.wait();
            }
        }
        while (isStopping()) {
            Thread.sleep(1L);
        }
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable);
    }

    public void runJob(Runnable runnable) {
        runnable.run();
    }

    public void setDaemon(boolean z) {
        this._daemon = z;
    }

    public void setDetailedDump(boolean z) {
        this._detailedDump = z;
    }

    public void setMaxIdleTimeMs(int i) {
        this._maxIdleTimeMs = i;
    }

    public void setMaxQueued(int i) {
        if (!isRunning()) {
            this._maxQueued = i;
            return;
        }
        throw new IllegalStateException("started");
    }

    public void setMaxStopTimeMs(int i) {
        this._maxStopTime = i;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool.SizedThreadPool
    public void setMaxThreads(int i) {
        this._maxThreads = i;
        if (this._minThreads > i) {
            this._minThreads = i;
        }
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool.SizedThreadPool
    public void setMinThreads(int i) {
        this._minThreads = i;
        if (i > this._maxThreads) {
            this._maxThreads = i;
        }
        while (true) {
            int i2 = this._threadsStarted.get();
            if (!isStarted() || i2 >= this._minThreads) {
                return;
            }
            startThread(i2);
        }
    }

    public void setName(String str) {
        if (!isRunning()) {
            this._name = str;
            return;
        }
        throw new IllegalStateException("started");
    }

    public void setThreadsPriority(int i) {
        this._priority = i;
    }

    @Deprecated
    public boolean stopThread(long j) {
        Iterator<Thread> it = this._threads.iterator();
        while (it.hasNext()) {
            Thread next = it.next();
            if (next.getId() == j) {
                next.stop();
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._name);
        sb.append("{");
        sb.append(getMinThreads());
        sb.append("<=");
        sb.append(getIdleThreads());
        sb.append("<=");
        sb.append(getThreads());
        sb.append("/");
        sb.append(getMaxThreads());
        sb.append(",");
        BlockingQueue<Runnable> blockingQueue = this._jobs;
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, blockingQueue == null ? -1 : blockingQueue.size(), "}");
    }
}

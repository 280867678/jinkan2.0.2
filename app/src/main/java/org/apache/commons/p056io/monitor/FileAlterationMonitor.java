package org.apache.commons.p056io.monitor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadFactory;

/* renamed from: org.apache.commons.io.monitor.FileAlterationMonitor */
/* loaded from: classes4.dex */
public final class FileAlterationMonitor implements Runnable {
    public final long interval;
    public final List<FileAlterationObserver> observers;
    public volatile boolean running;
    public Thread thread;
    public ThreadFactory threadFactory;

    public FileAlterationMonitor() {
        this(10000L);
    }

    public FileAlterationMonitor(long j) {
        this.observers = new CopyOnWriteArrayList();
        this.thread = null;
        this.running = false;
        this.interval = j;
    }

    public FileAlterationMonitor(long j, FileAlterationObserver... fileAlterationObserverArr) {
        this(j);
        if (fileAlterationObserverArr != null) {
            for (FileAlterationObserver fileAlterationObserver : fileAlterationObserverArr) {
                addObserver(fileAlterationObserver);
            }
        }
    }

    public void addObserver(FileAlterationObserver fileAlterationObserver) {
        if (fileAlterationObserver != null) {
            this.observers.add(fileAlterationObserver);
        }
    }

    public long getInterval() {
        return this.interval;
    }

    public Iterable<FileAlterationObserver> getObservers() {
        return this.observers;
    }

    public void removeObserver(FileAlterationObserver fileAlterationObserver) {
        if (fileAlterationObserver != null) {
            do {
            } while (this.observers.remove(fileAlterationObserver));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.running) {
            for (FileAlterationObserver fileAlterationObserver : this.observers) {
                fileAlterationObserver.checkAndNotify();
            }
            if (!this.running) {
                return;
            }
            try {
                Thread.sleep(this.interval);
            } catch (InterruptedException unused) {
            }
        }
    }

    public synchronized void setThreadFactory(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public synchronized void start() throws Exception {
        if (this.running) {
            throw new IllegalStateException("Monitor is already running");
        }
        for (FileAlterationObserver fileAlterationObserver : this.observers) {
            fileAlterationObserver.initialize();
        }
        this.running = true;
        this.thread = this.threadFactory != null ? this.threadFactory.newThread(this) : new Thread(this);
        this.thread.start();
    }

    public synchronized void stop() throws Exception {
        stop(this.interval);
    }

    public synchronized void stop(long j) throws Exception {
        if (!this.running) {
            throw new IllegalStateException("Monitor is not running");
        }
        this.running = false;
        try {
            this.thread.join(j);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        for (FileAlterationObserver fileAlterationObserver : this.observers) {
            fileAlterationObserver.destroy();
        }
    }
}

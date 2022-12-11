package org.apache.commons.p056io;

/* renamed from: org.apache.commons.io.ThreadMonitor */
/* loaded from: classes4.dex */
public class ThreadMonitor implements Runnable {
    public final Thread thread;
    public final long timeout;

    public ThreadMonitor(Thread thread, long j) {
        this.thread = thread;
        this.timeout = j;
    }

    public static void sleep(long j) throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis() + j;
        do {
            Thread.sleep(j);
            j = currentTimeMillis - System.currentTimeMillis();
        } while (j > 0);
    }

    public static Thread start(long j) {
        return start(Thread.currentThread(), j);
    }

    public static Thread start(Thread thread, long j) {
        if (j > 0) {
            Thread thread2 = new Thread(new ThreadMonitor(thread, j), ThreadMonitor.class.getSimpleName());
            thread2.setDaemon(true);
            thread2.start();
            return thread2;
        }
        return null;
    }

    public static void stop(Thread thread) {
        if (thread != null) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            sleep(this.timeout);
            this.thread.interrupt();
        } catch (InterruptedException unused) {
        }
    }
}

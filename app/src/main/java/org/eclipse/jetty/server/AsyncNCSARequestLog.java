package org.eclipse.jetty.server;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import me.tvspark.outline;
import org.eclipse.jetty.util.BlockingArrayQueue;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class AsyncNCSARequestLog extends NCSARequestLog {
    public static final Logger LOG = Log.getLogger(AsyncNCSARequestLog.class);
    public final BlockingQueue<String> _queue;
    public transient WriterThread _thread;
    public boolean _warnedFull;

    /* loaded from: classes4.dex */
    public class WriterThread extends Thread {
        public WriterThread() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("AsyncNCSARequestLog@");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toString(AsyncNCSARequestLog.this.hashCode(), 16));
            setName(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (AsyncNCSARequestLog.this.isRunning()) {
                try {
                    String str = (String) AsyncNCSARequestLog.this._queue.poll(10L, TimeUnit.SECONDS);
                    if (str != null) {
                        AsyncNCSARequestLog.super.write(str);
                    }
                    while (!AsyncNCSARequestLog.this._queue.isEmpty()) {
                        String str2 = (String) AsyncNCSARequestLog.this._queue.poll();
                        if (str2 != null) {
                            AsyncNCSARequestLog.super.write(str2);
                        }
                    }
                } catch (IOException e) {
                    AsyncNCSARequestLog.LOG.warn(e);
                } catch (InterruptedException e2) {
                    AsyncNCSARequestLog.LOG.ignore(e2);
                }
            }
        }
    }

    public AsyncNCSARequestLog() {
        this(null, null);
    }

    public AsyncNCSARequestLog(String str) {
        this(str, null);
    }

    public AsyncNCSARequestLog(String str, BlockingQueue<String> blockingQueue) {
        super(str);
        this._queue = blockingQueue == null ? new BlockingArrayQueue<>(1024) : blockingQueue;
    }

    public AsyncNCSARequestLog(BlockingQueue<String> blockingQueue) {
        this(null, blockingQueue);
    }

    @Override // org.eclipse.jetty.server.NCSARequestLog, org.eclipse.jetty.util.component.AbstractLifeCycle
    public synchronized void doStart() throws Exception {
        super.doStart();
        WriterThread writerThread = new WriterThread();
        this._thread = writerThread;
        writerThread.start();
    }

    @Override // org.eclipse.jetty.server.NCSARequestLog, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this._thread.interrupt();
        this._thread.join();
        super.doStop();
        this._thread = null;
    }

    @Override // org.eclipse.jetty.server.NCSARequestLog
    public void write(String str) throws IOException {
        if (!this._queue.offer(str)) {
            if (this._warnedFull) {
                LOG.warn("Log Queue overflow", new Object[0]);
            }
            this._warnedFull = true;
        }
    }
}

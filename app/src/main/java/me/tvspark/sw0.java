package me.tvspark;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;

@ef0
/* loaded from: classes4.dex */
public class sw0 extends nx0 {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Companion = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    public static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    public static final int TIMEOUT_WRITE_SIZE = 65536;
    public static sw0 head;
    public boolean inQueue;
    public sw0 next;
    public long timeoutAt;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements mx0 {
        public final /* synthetic */ mx0 Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0 mx0Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = mx0Var;
        }

        @Override // me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            sw0.this.enter();
            try {
                try {
                    this.Wwwwwwwwwwwwwwwwwwwwwww.close();
                    sw0.this.exit$jvm(true);
                } catch (IOException e) {
                    throw sw0.this.exit$jvm(e);
                }
            } catch (Throwable th) {
                sw0.this.exit$jvm(false);
                throw th;
            }
        }

        @Override // me.tvspark.mx0
        public long read(uw0 uw0Var, long j) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
            sw0.this.enter();
            try {
                try {
                    long read = this.Wwwwwwwwwwwwwwwwwwwwwww.read(uw0Var, j);
                    sw0.this.exit$jvm(true);
                    return read;
                } catch (IOException e) {
                    throw sw0.this.exit$jvm(e);
                }
            } catch (Throwable th) {
                sw0.this.exit$jvm(false);
                throw th;
            }
        }

        @Override // me.tvspark.mx0
        public nx0 timeout() {
            return sw0.this;
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("AsyncTimeout.source(");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(')');
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements kx0 {
        public final /* synthetic */ kx0 Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kx0 kx0Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = kx0Var;
        }

        @Override // me.tvspark.kx0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            sw0.this.enter();
            try {
                try {
                    this.Wwwwwwwwwwwwwwwwwwwwwww.close();
                    sw0.this.exit$jvm(true);
                } catch (IOException e) {
                    throw sw0.this.exit$jvm(e);
                }
            } catch (Throwable th) {
                sw0.this.exit$jvm(false);
                throw th;
            }
        }

        @Override // me.tvspark.kx0, java.io.Flushable
        public void flush() {
            sw0.this.enter();
            try {
                try {
                    this.Wwwwwwwwwwwwwwwwwwwwwww.flush();
                    sw0.this.exit$jvm(true);
                } catch (IOException e) {
                    throw sw0.this.exit$jvm(e);
                }
            } catch (Throwable th) {
                sw0.this.exit$jvm(false);
                throw th;
            }
        }

        @Override // me.tvspark.kx0
        public nx0 timeout() {
            return sw0.this;
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("AsyncTimeout.sink(");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(')');
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
            r2 = false;
            r7.Wwwwwwwwwwwwwwwwwwwwwwww.enter();
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
            r7.Wwwwwwwwwwwwwwwwwwwwwww.write(r8, r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
            r8 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
            throw r7.Wwwwwwwwwwwwwwwwwwwwwwww.exit$jvm(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
            r8 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
            r7.Wwwwwwwwwwwwwwwwwwwwwwww.exit$jvm(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
            throw r8;
         */
        @Override // me.tvspark.kx0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void write(uw0 uw0Var, long j) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "source");
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var.Wwwwwwwwwwwwwwwwwwwwwww, 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                ix0 ix0Var = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                while (true) {
                    if (j2 >= 65536) {
                        break;
                    }
                    j2 += ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (ix0Var == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                }
                j -= j2;
                boolean z = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Thread {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            sw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            while (true) {
                try {
                    synchronized (sw0.class) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sw0.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == sw0.head) {
                            sw0.head = null;
                            return;
                        }
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.timedOut();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gi0 gi0Var) {
        }

        public final sw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws InterruptedException {
            sw0 sw0Var = sw0.head;
            if (sw0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            sw0 sw0Var2 = sw0Var.next;
            long nanoTime = System.nanoTime();
            if (sw0Var2 == null) {
                sw0.class.wait(sw0.IDLE_TIMEOUT_MILLIS);
                sw0 sw0Var3 = sw0.head;
                if (sw0Var3 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else if (sw0Var3.next == null && System.nanoTime() - nanoTime >= sw0.IDLE_TIMEOUT_NANOS) {
                    return sw0.head;
                } else {
                    return null;
                }
            }
            long remainingNanos = sw0Var2.remainingNanos(nanoTime);
            if (remainingNanos > 0) {
                long j = remainingNanos / StopWatch.NANO_2_MILLIS;
                sw0.class.wait(j, (int) (remainingNanos - (StopWatch.NANO_2_MILLIS * j)));
                return null;
            }
            sw0 sw0Var4 = sw0.head;
            if (sw0Var4 == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            sw0Var4.next = sw0Var2.next;
            sw0Var2.next = null;
            return sw0Var2;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x004a A[Catch: all -> 0x008d, LOOP:0: B:14:0x004a->B:22:0x0065, LOOP_START, PHI: r11 
          PHI: (r11v2 me.tvspark.sw0) = (r11v1 me.tvspark.sw0), (r11v3 me.tvspark.sw0) binds: [B:13:0x0048, B:22:0x0065] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:7:0x0019, B:10:0x0025, B:11:0x002e, B:12:0x003f, B:14:0x004a, B:16:0x0050, B:18:0x0056, B:20:0x005f, B:24:0x0066, B:35:0x006a, B:29:0x006e, B:31:0x007e, B:38:0x0083, B:43:0x0038, B:44:0x0087, B:45:0x008c), top: B:3:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0083 A[Catch: all -> 0x008d, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:7:0x0019, B:10:0x0025, B:11:0x002e, B:12:0x003f, B:14:0x004a, B:16:0x0050, B:18:0x0056, B:20:0x005f, B:24:0x0066, B:35:0x006a, B:29:0x006e, B:31:0x007e, B:38:0x0083, B:43:0x0038, B:44:0x0087, B:45:0x008c), top: B:3:0x0003 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sw0 sw0Var, long j, boolean z) {
            sw0 sw0Var2;
            synchronized (sw0.class) {
                if (sw0.head == null) {
                    sw0.head = new sw0();
                    new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().start();
                }
                long nanoTime = System.nanoTime();
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i != 0 && z) {
                    j = Math.min(j, sw0Var.deadlineNanoTime() - nanoTime);
                } else if (i == 0) {
                    if (!z) {
                        throw new AssertionError();
                    }
                    sw0Var.timeoutAt = sw0Var.deadlineNanoTime();
                    long remainingNanos = sw0Var.remainingNanos(nanoTime);
                    sw0Var2 = sw0.head;
                    if (sw0Var2 != null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    while (sw0Var2.next != null) {
                        sw0 sw0Var3 = sw0Var2.next;
                        if (sw0Var3 == null) {
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            throw null;
                        } else if (remainingNanos < sw0Var3.remainingNanos(nanoTime)) {
                            break;
                        } else {
                            sw0Var2 = sw0Var2.next;
                            if (sw0Var2 == null) {
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                throw null;
                            }
                        }
                    }
                    sw0Var.next = sw0Var2.next;
                    sw0Var2.next = sw0Var;
                    if (sw0Var2 == sw0.head) {
                        sw0.class.notify();
                    }
                }
                sw0Var.timeoutAt = j + nanoTime;
                long remainingNanos2 = sw0Var.remainingNanos(nanoTime);
                sw0Var2 = sw0.head;
                if (sw0Var2 != null) {
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x000f, code lost:
            r1.next = r4.next;
            r4.next = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
            r4 = false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sw0 sw0Var) {
            boolean z;
            synchronized (sw0.class) {
                sw0 sw0Var2 = sw0.head;
                while (true) {
                    if (sw0Var2 == null) {
                        z = true;
                        break;
                    } else if (sw0Var2.next == sw0Var) {
                        break;
                    } else {
                        sw0Var2 = sw0Var2.next;
                    }
                }
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    public final void enter() {
        if (!this.inQueue) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos == 0 && !hasDeadline) {
                return;
            }
            this.inQueue = true;
            Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, timeoutNanos, hasDeadline);
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit".toString());
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    public final IOException exit$jvm(IOException iOException) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iOException, "cause");
        return !exit() ? iOException : newTimeoutException(iOException);
    }

    public final void exit$jvm(boolean z) {
        if (!exit() || !z) {
            return;
        }
        throw newTimeoutException(null);
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final kx0 sink(kx0 kx0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kx0Var, "sink");
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kx0Var);
    }

    public final mx0 source(mx0 mx0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var, "source");
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var);
    }

    public void timedOut() {
    }
}

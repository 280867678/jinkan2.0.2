package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import me.tvspark.C2374ml;
import me.tvspark.C2827yk;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class Loader {
    @Nullable
    public IOException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ExecutorService Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2, -9223372036854775807L, null);
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3, -9223372036854775807L, null);

    /* loaded from: classes3.dex */
    public static final class UnexpectedLoaderException extends IOException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public UnexpectedLoaderException(Throwable th) {
            super(r3.toString(), th);
            String simpleName = th.getClass().getSimpleName();
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(message, simpleName.length() + 13));
            sb.append("Unexpected ");
            sb.append(simpleName);
            sb.append(": ");
            sb.append(message);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException;
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return i == 0 || i == 1;
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, long j, long j2, IOException iOException, int i);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, long j, long j2);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, long j, long j2, boolean z);
    }

    static {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, -9223372036854775807L);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, -9223372036854775807L);
    }

    public Loader(String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, long j) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z ? 1 : 0, j, null);
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null;
    }

    public <T extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i) {
        Looper myLooper = Looper.myLooper();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(myLooper);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(myLooper, t, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, elapsedRealtime).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L);
        return elapsedRealtime;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) throws IOException {
        IOException iOException = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (iOException == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return;
            }
            if (i == Integer.MIN_VALUE) {
                i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            }
            IOException iOException2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
            if (iOException2 != null && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww > i) {
                throw iOException2;
            }
            return;
        }
        throw iOException;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.execute(new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.shutdown();
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> extends Handler implements Runnable {
        public volatile boolean Wwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwww;
        @Nullable
        public Thread Wwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwww;
        @Nullable
        public IOException Wwwwwwwwwwwwwwwwwwww;
        @Nullable
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> Wwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwww;
        public final T Wwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Looper looper, T t, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, int i, long j) {
            super(looper);
            this.Wwwwwwwwwwwwwwwwwwwwwww = t;
            this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwww = j;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            this.Wwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwww = null;
            if (hasMessages(0)) {
                this.Wwwwwwwwwwwwwwwww = true;
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.Wwwwwwwwwwwwwwwww = true;
                    this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Thread thread = this.Wwwwwwwwwwwwwwwwww;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z) {
                Loader.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, elapsedRealtime, elapsedRealtime - this.Wwwwwwwwwwwwwwwwwwwwww, true);
                this.Wwwwwwwwwwwwwwwwwwwww = null;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Wwwwwwwwwwwwwwww) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                this.Wwwwwwwwwwwwwwwwwwww = null;
                Loader loader = Loader.this;
                ExecutorService executorService = loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                executorService.execute(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else if (i != 3) {
                Loader.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.Wwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (this.Wwwwwwwwwwwwwwwww) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, elapsedRealtime, j, false);
                    return;
                }
                int i2 = message.what;
                if (i2 == 1) {
                    try {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, elapsedRealtime, j);
                    } catch (RuntimeException e) {
                        C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected exception handling load completed", e);
                        Loader.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new UnexpectedLoaderException(e);
                    }
                } else if (i2 != 2) {
                } else {
                    IOException iOException = (IOException) message.obj;
                    this.Wwwwwwwwwwwwwwwwwwww = iOException;
                    int i3 = this.Wwwwwwwwwwwwwwwwwww + 1;
                    this.Wwwwwwwwwwwwwwwwwww = i3;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, elapsedRealtime, j, iOException, i3);
                    int i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i4 == 3) {
                        Loader.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwww;
                    } else if (i4 == 2) {
                    } else {
                        if (i4 == 1) {
                            this.Wwwwwwwwwwwwwwwwwww = 1;
                        }
                        long j2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (j2 == -9223372036854775807L) {
                            j2 = Math.min((this.Wwwwwwwwwwwwwwwwwww - 1) * 1000, 5000);
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2);
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            UnexpectedLoaderException unexpectedLoaderException;
            Message obtainMessage;
            boolean z;
            try {
                synchronized (this) {
                    z = !this.Wwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwww = Thread.currentThread();
                }
                if (z) {
                    String simpleName = this.Wwwwwwwwwwwwwwwwwwwwwww.getClass().getSimpleName();
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(simpleName.length() != 0 ? "load:".concat(simpleName) : new String("load:"));
                    try {
                        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    } catch (Throwable th) {
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.Wwwwwwwwwwwwwwwwww = null;
                    Thread.interrupted();
                }
                if (this.Wwwwwwwwwwwwwwww) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e) {
                if (this.Wwwwwwwwwwwwwwww) {
                    return;
                }
                obtainMessage = obtainMessage(2, e);
                obtainMessage.sendToTarget();
            } catch (Exception e2) {
                C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected exception loading stream", e2);
                if (this.Wwwwwwwwwwwwwwww) {
                    return;
                }
                unexpectedLoaderException = new UnexpectedLoaderException(e2);
                obtainMessage = obtainMessage(2, unexpectedLoaderException);
                obtainMessage.sendToTarget();
            } catch (OutOfMemoryError e3) {
                C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OutOfMemory error loading stream", e3);
                if (this.Wwwwwwwwwwwwwwww) {
                    return;
                }
                unexpectedLoaderException = new UnexpectedLoaderException(e3);
                obtainMessage = obtainMessage(2, unexpectedLoaderException);
                obtainMessage.sendToTarget();
            } catch (Error e4) {
                C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected error loading stream", e4);
                if (!this.Wwwwwwwwwwwwwwww) {
                    obtainMessage(3, e4).sendToTarget();
                }
                throw e4;
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Loader.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null);
            Loader loader = Loader.this;
            loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwww = null;
            loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.execute(this);
        }
    }
}

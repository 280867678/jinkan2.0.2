package me.tvspark;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.cache.DiskLruCache;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.TokenParser;

/* loaded from: classes4.dex */
public final class Kkkkkkkkkk implements Closeable {
    public int Wwwwwwwwwwwwww;
    public Writer Wwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwww;
    public final File Wwwwwwwwwwwwwwwwwwwww;
    public final File Wwwwwwwwwwwwwwwwwwwwww;
    public final File Wwwwwwwwwwwwwwwwwwwwwww;
    public final File Wwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwww = 0;
    public final LinkedHashMap<String, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwww = new LinkedHashMap<>(0, 0.75f, true);
    public long Wwwwwwwwwwwww = 0;
    public final ThreadPoolExecutor Wwwwwwwwwwww = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null));
    public final Callable<Void> Wwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final File[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, long j, File[] fileArr, long[] jArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = fileArr;
        }
    }

    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public File[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public File[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            int i = Kkkkkkkkkk.this.Wwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new long[i];
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new File[i];
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new File[i];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < Kkkkkkkkkk.this.Wwwwwwwwwwwwwwwwww; i2++) {
                sb.append(i2);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2] = new File(Kkkkkkkkkk.this.Wwwwwwwwwwwwwwwwwwwwwwww, sb.toString());
                sb.append(".tmp");
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2] = new File(Kkkkkkkkkk.this.Wwwwwwwwwwwwwwwwwwwwwwww, sb.toString());
                sb.setLength(length);
            }
        }

        public final IOException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String[] strArr) throws IOException {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unexpected journal line: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Arrays.toString(strArr));
            throw new IOException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }

        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                sb.append(TokenParser.f4579SP);
                sb.append(j);
            }
            return sb.toString();
        }
    }

    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? null : new boolean[Kkkkkkkkkk.this.Wwwwwwwwwwwwwwwwww];
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
            Kkkkkkkkkk.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, false);
        }

        public File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) throws IOException {
            File file;
            synchronized (Kkkkkkkkkk.this) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != this) {
                    throw new IllegalStateException();
                }
                if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = true;
                }
                file = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
                if (!Kkkkkkkkkk.this.Wwwwwwwwwwwwwwwwwwwwwwww.exists()) {
                    Kkkkkkkkkk.this.Wwwwwwwwwwwwwwwwwwwwwwww.mkdirs();
                }
            }
            return file;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ThreadFactory {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Callable<Void> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            call2();
            return null;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: call  reason: avoid collision after fix types in other method */
        public Void call2() throws Exception {
            synchronized (Kkkkkkkkkk.this) {
                if (Kkkkkkkkkk.this.Wwwwwwwwwwwwwwww == null) {
                    return null;
                }
                Kkkkkkkkkk.this.Wwwwwwwwwwwwwwwwwwwwww();
                if (Kkkkkkkkkk.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    Kkkkkkkkkk.this.Wwwwwwwwwwwwwwwwwwwwwww();
                    Kkkkkkkkkk.this.Wwwwwwwwwwwwww = 0;
                }
                return null;
            }
        }
    }

    public Kkkkkkkkkk(File file, int i, int i2, long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = file;
        this.Wwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwww = new File(file, DiskLruCache.JOURNAL_FILE);
        this.Wwwwwwwwwwwwwwwwwwwwww = new File(file, DiskLruCache.JOURNAL_FILE_TEMP);
        this.Wwwwwwwwwwwwwwwwwwwww = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
        this.Wwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwww = j;
    }

    @TargetApi(26)
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file) throws IOException {
        if (!file.exists() || file.delete()) {
            return;
        }
        throw new IOException();
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file, File file2, boolean z) throws IOException {
        if (z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file2);
        }
        if (file.renameTo(file2)) {
            return;
        }
        throw new IOException();
    }

    @TargetApi(26)
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwww() throws IOException {
        while (this.Wwwwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww.entrySet().iterator().next().getKey());
        }
    }

    public final synchronized void Wwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        if (this.Wwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwww);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.Wwwwwwwwwwwwwwwwwwwwww), Kkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        bufferedWriter.write(DiskLruCache.MAGIC);
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.Wwwwwwwwwwwwwwwwwwww));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.Wwwwwwwwwwwwwwwwww));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwww.values()) {
            bufferedWriter.write(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? "DIRTY " + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + '\n' : "CLEAN " + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + '\n');
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bufferedWriter);
        if (this.Wwwwwwwwwwwwwwwwwwwwwww.exists()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, true);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, false);
        this.Wwwwwwwwwwwwwwwwwwwww.delete();
        this.Wwwwwwwwwwwwwwww = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.Wwwwwwwwwwwwwwwwwwwwwww, true), Kkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        Kkkkkkkkk kkkkkkkkk = new Kkkkkkkkk(new FileInputStream(this.Wwwwwwwwwwwwwwwwwwwwwww), Kkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        try {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (!DiskLruCache.MAGIC.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) || !"1".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) || !Integer.toString(this.Wwwwwwwwwwwwwwwwwwww).equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4) || !Integer.toString(this.Wwwwwwwwwwwwwwwwww).equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5) || !"".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6)) {
                throw new IOException("unexpected journal header: [" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + ", " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 + ", " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 + ", " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 + "]");
            }
            boolean z = false;
            int i = 0;
            while (true) {
                try {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    i++;
                } catch (EOFException unused) {
                    this.Wwwwwwwwwwwwww = i - this.Wwwwwwwwwwwwwww.size();
                    if (kkkkkkkkk.Wwwwwwwwwwwwwwwwwwww == -1) {
                        z = true;
                    }
                    if (z) {
                        Wwwwwwwwwwwwwwwwwwwwwww();
                    } else {
                        this.Wwwwwwwwwwwwwwww = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.Wwwwwwwwwwwwwwwwwwwwwww, true), Kkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    }
                    try {
                        kkkkkkkkk.close();
                        return;
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                kkkkkkkkk.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
        Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwww.values().iterator();
        while (it.hasNext()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
            int i = 0;
            if (next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                while (i < this.Wwwwwwwwwwwwwwwwww) {
                    this.Wwwwwwwwwwwwwwwww += next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
                    i++;
                }
            } else {
                next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                while (i < this.Wwwwwwwwwwwwwwwwww) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i]);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwww;
        return i >= 2000 && i >= this.Wwwwwwwwwwwwwww.size();
    }

    public synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwww.get(str);
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            for (int i = 0; i < this.Wwwwwwwwwwwwwwwwww; i++) {
                File file = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
                if (file.exists() && !file.delete()) {
                    throw new IOException("failed to delete " + file);
                }
                this.Wwwwwwwwwwwwwwwww -= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = 0;
            }
            this.Wwwwwwwwwwwwww++;
            this.Wwwwwwwwwwwwwwww.append((CharSequence) DiskLruCache.REMOVE);
            this.Wwwwwwwwwwwwwwww.append(TokenParser.f4579SP);
            this.Wwwwwwwwwwwwwwww.append((CharSequence) str);
            this.Wwwwwwwwwwwwwwww.append('\n');
            this.Wwwwwwwwwwwwwww.remove(str);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                this.Wwwwwwwwwwww.submit(this.Wwwwwwwwwww);
            }
            return true;
        }
        return false;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                substring = str.substring(i);
                if (indexOf == 6 && str.startsWith(DiskLruCache.REMOVE)) {
                    this.Wwwwwwwwwwwwwww.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i, indexOf2);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwww.get(substring);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring, null);
                this.Wwwwwwwwwwwwwww.put(substring, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(DiskLruCache.CLEAN)) {
                String[] split = str.substring(indexOf2 + 1).split(StringUtils.SPACE);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                if (split.length != Kkkkkkkkkk.this.Wwwwwwwwwwwwwwwwww) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(split);
                    throw null;
                }
                for (int i2 = 0; i2 < split.length; i2++) {
                    try {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2] = Long.parseLong(split[i2]);
                    } catch (NumberFormatException unused) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(split);
                        throw null;
                    }
                }
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DiskLruCache.DIRTY)) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null);
                return;
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith(DiskLruCache.READ)) {
                throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unexpected journal line: ", str));
            } else {
                return;
            }
        }
        throw new IOException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unexpected journal line: ", str));
    }

    public synchronized Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwww.get(str);
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return null;
        }
        if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return null;
        }
        for (File file : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (!file.exists()) {
                return null;
            }
        }
        this.Wwwwwwwwwwwwww++;
        this.Wwwwwwwwwwwwwwww.append((CharSequence) DiskLruCache.READ);
        this.Wwwwwwwwwwwwwwww.append(TokenParser.f4579SP);
        this.Wwwwwwwwwwwwwwww.append((CharSequence) str);
        this.Wwwwwwwwwwwwwwww.append('\n');
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            this.Wwwwwwwwwwww.submit(this.Wwwwwwwwwww);
        }
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwww != null) {
            return;
        }
        throw new IllegalStateException("cache is closed");
    }

    public final synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z) throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (z && !wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                for (int i = 0; i < this.Wwwwwwwwwwwwwwwwww; i++) {
                    if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i]) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i].exists()) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwww; i2++) {
                File file = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
                if (!z) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file);
                } else if (file.exists()) {
                    File file2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
                    file.renameTo(file2);
                    long j = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
                    long length = file2.length();
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2] = length;
                    this.Wwwwwwwwwwwwwwwww = (this.Wwwwwwwwwwwwwwwww - j) + length;
                }
            }
            this.Wwwwwwwwwwwwww++;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww | z) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwww.append((CharSequence) DiskLruCache.CLEAN);
                this.Wwwwwwwwwwwwwwww.append(TokenParser.f4579SP);
                this.Wwwwwwwwwwwwwwww.append((CharSequence) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwww.append((CharSequence) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                this.Wwwwwwwwwwwwwwww.append('\n');
                if (z) {
                    long j2 = this.Wwwwwwwwwwwww;
                    this.Wwwwwwwwwwwww = 1 + j2;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
                }
            } else {
                this.Wwwwwwwwwwwwwww.remove(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwww.append((CharSequence) DiskLruCache.REMOVE);
                this.Wwwwwwwwwwwwwwww.append(TokenParser.f4579SP);
                this.Wwwwwwwwwwwwwwww.append((CharSequence) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwww.append('\n');
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwww);
            if (this.Wwwwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwwwwwww || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                this.Wwwwwwwwwwww.submit(this.Wwwwwwwwwww);
            }
            return;
        }
        throw new IllegalStateException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.Wwwwwwwwwwwwwwww == null) {
            return;
        }
        Iterator it = new ArrayList(this.Wwwwwwwwwwwwwww.values()).iterator();
        while (it.hasNext()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) it.next();
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
        Wwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwww = null;
    }

    public final synchronized Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, long j) throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwww.get(str);
        if (j == -1 || (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == j)) {
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, null);
                this.Wwwwwwwwwwwwwww.put(str, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                return null;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwww.append((CharSequence) DiskLruCache.DIRTY);
            this.Wwwwwwwwwwwwwwww.append(TokenParser.f4579SP);
            this.Wwwwwwwwwwwwwwww.append((CharSequence) str);
            this.Wwwwwwwwwwwwwwww.append('\n');
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwww);
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    public static Kkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File file, int i, int i2, long j) throws IOException {
        if (j > 0) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("valueCount <= 0");
            }
            File file2 = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
            if (file2.exists()) {
                File file3 = new File(file, DiskLruCache.JOURNAL_FILE);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file2, file3, false);
                }
            }
            Kkkkkkkkkk kkkkkkkkkk = new Kkkkkkkkkk(file, i, i2, j);
            if (kkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwww.exists()) {
                try {
                    kkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww();
                    kkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwww();
                    return kkkkkkkkkk;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    kkkkkkkkkk.close();
                    Kkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww);
                }
            }
            file.mkdirs();
            Kkkkkkkkkk kkkkkkkkkk2 = new Kkkkkkkkkk(file, i, i2, j);
            kkkkkkkkkk2.Wwwwwwwwwwwwwwwwwwwwwww();
            return kkkkkkkkkk2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }
}

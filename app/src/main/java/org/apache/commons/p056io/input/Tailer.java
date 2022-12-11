package org.apache.commons.p056io.input;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import org.apache.commons.p056io.FileUtils;
import org.apache.commons.p056io.IOUtils;

/* renamed from: org.apache.commons.io.input.Tailer */
/* loaded from: classes4.dex */
public class Tailer implements Runnable {
    public static final int DEFAULT_BUFSIZE = 4096;
    public static final Charset DEFAULT_CHARSET = Charset.defaultCharset();
    public static final int DEFAULT_DELAY_MILLIS = 1000;
    public static final String RAF_MODE = "r";
    public final Charset cset;
    public final long delayMillis;
    public final boolean end;
    public final File file;
    public final byte[] inbuf;
    public final TailerListener listener;
    public final boolean reOpen;
    public volatile boolean run;

    public Tailer(File file, Charset charset, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        this.run = true;
        this.file = file;
        this.delayMillis = j;
        this.end = z;
        this.inbuf = new byte[i];
        this.listener = tailerListener;
        tailerListener.init(this);
        this.reOpen = z2;
        this.cset = charset;
    }

    public Tailer(File file, TailerListener tailerListener) {
        this(file, tailerListener, 1000L);
    }

    public Tailer(File file, TailerListener tailerListener, long j) {
        this(file, tailerListener, j, false);
    }

    public Tailer(File file, TailerListener tailerListener, long j, boolean z) {
        this(file, tailerListener, j, z, 4096);
    }

    public Tailer(File file, TailerListener tailerListener, long j, boolean z, int i) {
        this(file, tailerListener, j, z, false, i);
    }

    public Tailer(File file, TailerListener tailerListener, long j, boolean z, boolean z2) {
        this(file, tailerListener, j, z, z2, 4096);
    }

    public Tailer(File file, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        this(file, DEFAULT_CHARSET, tailerListener, j, z, z2, i);
    }

    public static Tailer create(File file, Charset charset, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        Tailer tailer = new Tailer(file, charset, tailerListener, j, z, z2, i);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    public static Tailer create(File file, TailerListener tailerListener) {
        return create(file, tailerListener, 1000L, false);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j) {
        return create(file, tailerListener, j, false);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j, boolean z) {
        return create(file, tailerListener, j, z, 4096);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j, boolean z, int i) {
        return create(file, tailerListener, j, z, false, i);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j, boolean z, boolean z2) {
        return create(file, tailerListener, j, z, z2, 4096);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        return create(file, DEFAULT_CHARSET, tailerListener, j, z, z2, i);
    }

    private long readLines(RandomAccessFile randomAccessFile) throws IOException {
        int read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);
        long filePointer = randomAccessFile.getFilePointer();
        long j = filePointer;
        boolean z = false;
        while (getRun() && (read = randomAccessFile.read(this.inbuf)) != -1) {
            for (int i = 0; i < read; i++) {
                byte b = this.inbuf[i];
                if (b == 10) {
                    this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.cset));
                    byteArrayOutputStream.reset();
                    filePointer = i + j + 1;
                    z = false;
                } else if (b != 13) {
                    if (z) {
                        this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.cset));
                        byteArrayOutputStream.reset();
                        filePointer = i + j + 1;
                        z = false;
                    }
                    byteArrayOutputStream.write(b);
                } else {
                    if (z) {
                        byteArrayOutputStream.write(13);
                    }
                    z = true;
                }
            }
            j = randomAccessFile.getFilePointer();
        }
        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
        randomAccessFile.seek(filePointer);
        TailerListener tailerListener = this.listener;
        if (tailerListener instanceof TailerListenerAdapter) {
            ((TailerListenerAdapter) tailerListener).endOfFileReached();
        }
        return filePointer;
    }

    private void stop(Exception exc) {
        this.listener.handle(exc);
        stop();
    }

    public long getDelay() {
        return this.delayMillis;
    }

    public File getFile() {
        return this.file;
    }

    public boolean getRun() {
        return this.run;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1 A[Catch: all -> 0x00be, Exception -> 0x00c0, InterruptedException -> 0x00c8, TryCatch #9 {all -> 0x00be, blocks: (B:3:0x0005, B:8:0x000f, B:20:0x001f, B:12:0x0025, B:14:0x0029, B:15:0x0032, B:23:0x0018, B:26:0x003c, B:28:0x0042, B:53:0x0052, B:55:0x0057, B:76:0x00c1, B:75:0x00c9, B:65:0x007b, B:32:0x0083, B:33:0x0089, B:34:0x009d, B:36:0x00a1, B:37:0x00a4, B:40:0x00af, B:43:0x00b3, B:51:0x0093), top: B:2:0x0005 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        RandomAccessFile randomAccessFile;
        long readLines;
        File file;
        RandomAccessFile randomAccessFile2 = null;
        long j = 0;
        long j2 = 0;
        while (getRun() && randomAccessFile2 == null) {
            try {
                try {
                    try {
                        randomAccessFile2 = new RandomAccessFile(this.file, RAF_MODE);
                    } catch (FileNotFoundException unused) {
                        this.listener.fileNotFound();
                    }
                    if (randomAccessFile2 == null) {
                        Thread.sleep(this.delayMillis);
                    } else {
                        j2 = this.end ? this.file.length() : 0L;
                        j = this.file.lastModified();
                        randomAccessFile2.seek(j2);
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (InterruptedException e) {
                e = e;
            } catch (Exception e2) {
                e = e2;
            }
        }
        while (getRun()) {
            boolean isFileNewer = FileUtils.isFileNewer(this.file, j);
            int i = (this.file.length() > j2 ? 1 : (this.file.length() == j2 ? 0 : -1));
            if (i < 0) {
                this.listener.fileRotated();
                try {
                    randomAccessFile = new RandomAccessFile(this.file, RAF_MODE);
                } catch (FileNotFoundException unused2) {
                }
                try {
                    try {
                        readLines(randomAccessFile2);
                    } catch (IOException e3) {
                        try {
                            this.listener.handle(e3);
                        } catch (FileNotFoundException unused3) {
                            randomAccessFile2 = randomAccessFile;
                            this.listener.fileNotFound();
                        }
                    }
                    try {
                        IOUtils.closeQuietly(randomAccessFile2);
                        j2 = 0;
                        randomAccessFile2 = randomAccessFile;
                    } catch (FileNotFoundException unused4) {
                        j2 = 0;
                        randomAccessFile2 = randomAccessFile;
                        this.listener.fileNotFound();
                    }
                } catch (InterruptedException e4) {
                    e = e4;
                    randomAccessFile2 = randomAccessFile;
                    Thread.currentThread().interrupt();
                    stop(e);
                    IOUtils.closeQuietly(randomAccessFile2);
                } catch (Exception e5) {
                    e = e5;
                    randomAccessFile2 = randomAccessFile;
                    stop(e);
                    IOUtils.closeQuietly(randomAccessFile2);
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile2 = randomAccessFile;
                    IOUtils.closeQuietly(randomAccessFile2);
                    throw th;
                }
            } else {
                if (i > 0) {
                    readLines = readLines(randomAccessFile2);
                    file = this.file;
                } else {
                    if (isFileNewer) {
                        randomAccessFile2.seek(0L);
                        readLines = readLines(randomAccessFile2);
                        file = this.file;
                    }
                    if (this.reOpen) {
                        IOUtils.closeQuietly(randomAccessFile2);
                    }
                    Thread.sleep(this.delayMillis);
                    if (getRun() && this.reOpen) {
                        randomAccessFile = new RandomAccessFile(this.file, RAF_MODE);
                        randomAccessFile.seek(j2);
                        randomAccessFile2 = randomAccessFile;
                    }
                }
                long j3 = readLines;
                j = file.lastModified();
                j2 = j3;
                if (this.reOpen) {
                }
                Thread.sleep(this.delayMillis);
                if (getRun()) {
                    randomAccessFile = new RandomAccessFile(this.file, RAF_MODE);
                    randomAccessFile.seek(j2);
                    randomAccessFile2 = randomAccessFile;
                }
            }
        }
        IOUtils.closeQuietly(randomAccessFile2);
    }

    public void stop() {
        this.run = false;
    }
}

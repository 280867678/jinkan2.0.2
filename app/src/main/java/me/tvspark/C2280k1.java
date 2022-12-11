package me.tvspark;

import androidx.annotation.NonNull;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.p056io.input.Tailer;

/* renamed from: me.tvspark.k1 */
/* loaded from: classes4.dex */
public final class C2280k1 {
    public static final AtomicReference<byte[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();

    /* renamed from: me.tvspark.k1$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull byte[] bArr, int i, int i2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        }
    }

    /* renamed from: me.tvspark.k1$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends InputStream {
        public int Wwwwwwwwwwwwwwwwwwwwwww = -1;
        @NonNull
        public final ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ByteBuffer byteBuffer) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwww.hasRemaining()) {
                return -1;
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.get() & 255;
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwww.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i2, available());
            this.Wwwwwwwwwwwwwwwwwwwwwwww.get(bArr, i, min);
            return min;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.position(this.Wwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwww.hasRemaining()) {
                return -1L;
            }
            long min = Math.min(j, available());
            ByteBuffer byteBuffer = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            byteBuffer.position((int) (byteBuffer.position() + min));
            return min;
        }
    }

    @NonNull
    public static InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ByteBuffer byteBuffer) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer);
    }

    @NonNull
    public static ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull File file) throws IOException {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, Tailer.RAF_MODE);
            try {
                fileChannel = randomAccessFile.getChannel();
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                try {
                    fileChannel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
                return load;
            } catch (Throwable th) {
                th = th;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    @NonNull
    public static ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read < 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
            byteArrayOutputStream.write(andSet, 0, read);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ByteBuffer byteBuffer, @NonNull File file) throws IOException {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileChannel = randomAccessFile.getChannel();
                fileChannel.write(byteBuffer);
                fileChannel.force(false);
                fileChannel.close();
                randomAccessFile.close();
                try {
                    fileChannel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th) {
                th = th;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    @NonNull
    public static byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ByteBuffer byteBuffer) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) ? null : new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }
}

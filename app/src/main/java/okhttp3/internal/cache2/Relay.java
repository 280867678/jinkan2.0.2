package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.mx0;
import me.tvspark.nx0;
import me.tvspark.uw0;
import okhttp3.internal.Util;
import okio.ByteString;

@ef0
/* loaded from: classes4.dex */
public final class Relay {
    public static final long FILE_HEADER_SIZE = 32;
    public static final int SOURCE_FILE = 2;
    public static final int SOURCE_UPSTREAM = 1;
    public final uw0 buffer;
    public final long bufferMaxSize;
    public boolean complete;
    public RandomAccessFile file;
    public final ByteString metadata;
    public int sourceCount;
    public mx0 upstream;
    public final uw0 upstreamBuffer;
    public long upstreamPos;
    public Thread upstreamReader;
    public static final Companion Companion = new Companion(null);
    public static final ByteString PREFIX_CLEAN = ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OkHttp cache v1\n");
    public static final ByteString PREFIX_DIRTY = ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OkHttp DIRTY :(\n");

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final Relay edit(File file, mx0 mx0Var, ByteString byteString, long j) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "file");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var, "upstream");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, mx0Var, 0L, byteString, j, null);
            randomAccessFile.setLength(0L);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        public final Relay read(File file) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) channel, "randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(channel);
            uw0 uw0Var = new uw0();
            fileOperator.read(0L, uw0Var, 32L);
            if (!(!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Relay.PREFIX_CLEAN.size()), Relay.PREFIX_CLEAN))) {
                long readLong = uw0Var.readLong();
                long readLong2 = uw0Var.readLong();
                uw0 uw0Var2 = new uw0();
                fileOperator.read(readLong + 32, uw0Var2, readLong2);
                return new Relay(randomAccessFile, null, readLong, uw0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwww(), 0L, null);
            }
            throw new IOException("unreadable cache file");
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public final class RelaySource implements mx0 {
        public FileOperator fileOperator;
        public long sourcePos;
        public final nx0 timeout = new nx0();

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            if (file == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            FileChannel channel = file.getChannel();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) channel, "file!!.channel");
            this.fileOperator = new FileOperator(channel);
        }

        @Override // me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                Relay relay = Relay.this;
                relay.setSourceCount(relay.getSourceCount() - 1);
                if (Relay.this.getSourceCount() == 0) {
                    RandomAccessFile file = Relay.this.getFile();
                    Relay.this.setFile(null);
                    randomAccessFile = file;
                }
            }
            if (randomAccessFile == null) {
                return;
            }
            Util.closeQuietly(randomAccessFile);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x008a, code lost:
            if (r4 != 2) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x008c, code lost:
            r11 = java.lang.Math.min(r21, r19.this$0.getUpstreamPos() - r19.sourcePos);
            r2 = r19.fileOperator;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
            if (r2 == null) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x009d, code lost:
            r2.read(r19.sourcePos + 32, r20, r11);
            r19.sourcePos += r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00ab, code lost:
            return r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00ac, code lost:
            me.tvspark.ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00af, code lost:
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00b0, code lost:
            r0 = r19.this$0.getUpstream();
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00b6, code lost:
            if (r0 == null) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00b8, code lost:
            r14 = r0.read(r19.this$0.getUpstreamBuffer(), r19.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00ca, code lost:
            if (r14 != (-1)) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00cc, code lost:
            r19.this$0.commit(r19.this$0.getUpstreamPos());
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00d7, code lost:
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00d9, code lost:
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00da, code lost:
            r19.this$0.setUpstreamReader(null);
            r0 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00e1, code lost:
            if (r0 == null) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00e3, code lost:
            r0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00e6, code lost:
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00e7, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00ef, code lost:
            throw new kotlin.TypeCastException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00f3, code lost:
            r11 = java.lang.Math.min(r14, r21);
            r19.this$0.getUpstreamBuffer().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r20, 0, r11);
            r19.sourcePos += r11;
            r13 = r19.fileOperator;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x010d, code lost:
            if (r13 == null) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x010f, code lost:
            r13.write(r19.this$0.getUpstreamPos() + 32, r19.this$0.getUpstreamBuffer().clone(), r14);
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0129, code lost:
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x012a, code lost:
            r19.this$0.getBuffer().write(r19.this$0.getUpstreamBuffer(), r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0149, code lost:
            if (r19.this$0.getBuffer().Wwwwwwwwwwwwwwwwwwwwwww <= r19.this$0.getBufferMaxSize()) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x014b, code lost:
            r19.this$0.getBuffer().skip(r19.this$0.getBuffer().Wwwwwwwwwwwwwwwwwwwwwww - r19.this$0.getBufferMaxSize());
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0166, code lost:
            r0 = r19.this$0;
            r0.setUpstreamPos(r0.getUpstreamPos() + r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0170, code lost:
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0171, code lost:
            r2 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0173, code lost:
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0174, code lost:
            r19.this$0.setUpstreamReader(null);
            r0 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x017b, code lost:
            if (r0 == null) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x017d, code lost:
            r0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0180, code lost:
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0181, code lost:
            return r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0189, code lost:
            throw new kotlin.TypeCastException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x018f, code lost:
            me.tvspark.ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0192, code lost:
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0193, code lost:
            me.tvspark.ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x0196, code lost:
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0197, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x019a, code lost:
            monitor-enter(r19.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x019b, code lost:
            r19.this$0.setUpstreamReader(null);
            r3 = r19.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x01a2, code lost:
            if (r3 == null) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x01ab, code lost:
            throw new kotlin.TypeCastException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x01ac, code lost:
            r3.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x01b0, code lost:
            throw r0;
         */
        @Override // me.tvspark.mx0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long read(uw0 uw0Var, long j) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
            char c = 1;
            if (this.fileOperator != null) {
                synchronized (Relay.this) {
                    while (true) {
                        if (this.sourcePos == Relay.this.getUpstreamPos()) {
                            if (!Relay.this.getComplete()) {
                                if (Relay.this.getUpstreamReader() == null) {
                                    Relay.this.setUpstreamReader(Thread.currentThread());
                                    break;
                                }
                                this.timeout.waitUntilNotified(Relay.this);
                            } else {
                                return -1L;
                            }
                        } else {
                            long upstreamPos = Relay.this.getUpstreamPos() - Relay.this.getBuffer().Wwwwwwwwwwwwwwwwwwwwwww;
                            if (this.sourcePos >= upstreamPos) {
                                long min = Math.min(j, Relay.this.getUpstreamPos() - this.sourcePos);
                                Relay.this.getBuffer().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, this.sourcePos - upstreamPos, min);
                                this.sourcePos += min;
                                return min;
                            }
                            c = 2;
                        }
                    }
                }
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        @Override // me.tvspark.mx0
        public nx0 timeout() {
            return this.timeout;
        }
    }

    public Relay(RandomAccessFile randomAccessFile, mx0 mx0Var, long j, ByteString byteString, long j2) {
        this.file = randomAccessFile;
        this.upstream = mx0Var;
        this.upstreamPos = j;
        this.metadata = byteString;
        this.bufferMaxSize = j2;
        this.upstreamBuffer = new uw0();
        this.complete = this.upstream == null;
        this.buffer = new uw0();
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, mx0 mx0Var, long j, ByteString byteString, long j2, gi0 gi0Var) {
        this(randomAccessFile, mx0Var, j, byteString, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeHeader(ByteString byteString, long j, long j2) throws IOException {
        uw0 uw0Var = new uw0();
        uw0Var.mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString);
        uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwww(j);
        uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwww(j2);
        if (uw0Var.Wwwwwwwwwwwwwwwwwwwwwww == 32) {
            RandomAccessFile randomAccessFile = this.file;
            if (randomAccessFile == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            FileChannel channel = randomAccessFile.getChannel();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) channel, "file!!.channel");
            new FileOperator(channel).write(0L, uw0Var, 32L);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void writeMetadata(long j) throws IOException {
        uw0 uw0Var = new uw0();
        uw0Var.mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        if (randomAccessFile == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        FileChannel channel = randomAccessFile.getChannel();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) channel, "file!!.channel");
        new FileOperator(channel).write(32 + j, uw0Var, this.metadata.size());
    }

    public final void commit(long j) throws IOException {
        writeMetadata(j);
        RandomAccessFile randomAccessFile = this.file;
        if (randomAccessFile == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, this.metadata.size());
        RandomAccessFile randomAccessFile2 = this.file;
        if (randomAccessFile2 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        mx0 mx0Var = this.upstream;
        if (mx0Var != null) {
            Util.closeQuietly(mx0Var);
        }
        this.upstream = null;
    }

    public final uw0 getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final mx0 getUpstream() {
        return this.upstream;
    }

    public final uw0 getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    public final ByteString metadata() {
        return this.metadata;
    }

    public final mx0 newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z) {
        this.complete = z;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i) {
        this.sourceCount = i;
    }

    public final void setUpstream(mx0 mx0Var) {
        this.upstream = mx0Var;
    }

    public final void setUpstreamPos(long j) {
        this.upstreamPos = j;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }
}

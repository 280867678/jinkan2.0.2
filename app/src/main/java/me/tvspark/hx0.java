package me.tvspark;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.ByteString;

@ef0
/* loaded from: classes4.dex */
public final class hx0 implements ww0 {
    public final mx0 Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final uw0 Wwwwwwwwwwwwwwwwwwwwwwww = new uw0();

    public hx0(mx0 mx0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var, "source");
        this.Wwwwwwwwwwwwwwwwwwwwww = mx0Var;
    }

    @Override // me.tvspark.ww0
    public long Wwwwwwwwwwwwwwwwwwwww() {
        byte Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request(i2)) {
                break;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < ((byte) 48) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > ((byte) 57)) && ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < ((byte) 97) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > ((byte) 102)) && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < ((byte) 65) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > ((byte) 70)))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            String format = String.format("Expected leading [0-9a-fA-F] character but was %#x", Arrays.copyOf(new Object[]{Byte.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)}, 1));
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) format, "java.lang.String.format(format, *args)");
            throw new NumberFormatException(format);
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.ww0
    public String Wwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Long.MAX_VALUE);
    }

    @Override // me.tvspark.ww0
    public ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (r9 == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        r1 = java.lang.String.format("Expected leading [0-9] or '-' character but was %#x", java.util.Arrays.copyOf(new java.lang.Object[]{java.lang.Byte.valueOf(r8)}, 1));
        me.tvspark.ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((java.lang.Object) r1, "java.lang.String.format(format, *args)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
        throw new java.lang.NumberFormatException(r1);
     */
    @Override // me.tvspark.ww0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww(1L);
        long j = 0;
        while (true) {
            long j2 = j + 1;
            if (!request(j2)) {
                break;
            }
            byte Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
            if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < ((byte) 48) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > ((byte) 57)) && !(j == 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == ((byte) 45))) {
                break;
            }
            j = j2;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.ww0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        if (request(j)) {
            return;
        }
        throw new EOFException();
    }

    @Override // me.tvspark.ww0
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        if (request(j)) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        }
        throw new EOFException();
    }

    @Override // me.tvspark.ww0
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && this.Wwwwwwwwwwwwwwwwwwwwww.read(this.Wwwwwwwwwwwwwwwwwwwwwwww, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.ww0
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.ww0
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            byte b = (byte) 10;
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b, 0L, j2);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -1) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
            if (j2 < Long.MAX_VALUE && request(j2) && this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2 - 1) == ((byte) 13) && request(1 + j2) && this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2) == b) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww(j2);
            }
            uw0 uw0Var = new uw0();
            uw0 uw0Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            uw0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, 0L, Math.min(32, uw0Var2.Wwwwwwwwwwwwwwwwwwwwwww));
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\\n not found: limit=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(Math.min(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww, j));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" content=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww().hex());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("…");
            throw new EOFException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("limit < 0: ", j).toString());
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte b, long j, long j2) {
        boolean z = true;
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            if (0 > j || j2 < j) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
            }
            while (j < j2) {
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b, j, j2);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
                    uw0 uw0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    long j3 = uw0Var.Wwwwwwwwwwwwwwwwwwwwwww;
                    if (j3 >= j2 || this.Wwwwwwwwwwwwwwwwwwwwww.read(uw0Var, 8192) == -1) {
                        break;
                    }
                    j = Math.max(j, j3);
                } else {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
            }
            return -1L;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwww.close();
        uw0 uw0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        uw0Var.skip(uw0Var.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.ww0
    public uw0 getBuffer() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.ww0
    public InputStream inputStream() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.ww0
    public ww0 peek() {
        fx0 fx0Var = new fx0(this);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fx0Var, "$receiver");
        return new hx0(fx0Var);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer, "sink");
        uw0 uw0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (uw0Var.Wwwwwwwwwwwwwwwwwwwwwww == 0 && this.Wwwwwwwwwwwwwwwwwwwwww.read(uw0Var, 8192) == -1) {
            return -1;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.read(byteBuffer);
    }

    @Override // me.tvspark.ww0
    public byte readByte() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww(1L);
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.readByte();
    }

    @Override // me.tvspark.ww0
    public void readFully(byte[] bArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "sink");
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr.length);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                uw0 uw0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                long j = uw0Var.Wwwwwwwwwwwwwwwwwwwwwww;
                if (j <= 0) {
                    throw e;
                }
                int read = uw0Var.read(bArr, i, (int) j);
                if (read == -1) {
                    throw new AssertionError();
                }
                i += read;
            }
        }
    }

    @Override // me.tvspark.ww0
    public int readInt() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww(4L);
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.readInt();
    }

    @Override // me.tvspark.ww0
    public long readLong() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww(8L);
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.readLong();
    }

    @Override // me.tvspark.ww0
    public short readShort() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww(2L);
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.readShort();
    }

    @Override // me.tvspark.ww0
    public boolean request(long j) {
        uw0 uw0Var;
        if (j >= 0) {
            if (!(!this.Wwwwwwwwwwwwwwwwwwwwwww)) {
                throw new IllegalStateException("closed".toString());
            }
            do {
                uw0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (uw0Var.Wwwwwwwwwwwwwwwwwwwwwww >= j) {
                    return true;
                }
            } while (this.Wwwwwwwwwwwwwwwwwwwwww.read(uw0Var, 8192) != -1);
            return false;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("byteCount < 0: ", j).toString());
    }

    @Override // me.tvspark.ww0
    public void skip(long j) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            while (j > 0) {
                uw0 uw0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (uw0Var.Wwwwwwwwwwwwwwwwwwwwwww == 0 && this.Wwwwwwwwwwwwwwwwwwwwww.read(uw0Var, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.skip(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // me.tvspark.mx0
    public nx0 timeout() {
        return this.Wwwwwwwwwwwwwwwwwwwwww.timeout();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("buffer(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(')');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends InputStream {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.io.InputStream
        public int available() {
            hx0 hx0Var = hx0.this;
            if (!hx0Var.Wwwwwwwwwwwwwwwwwwwwwww) {
                return (int) Math.min(hx0Var.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww, Integer.MAX_VALUE);
            }
            throw new IOException("closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            hx0.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            hx0 hx0Var = hx0.this;
            if (!hx0Var.Wwwwwwwwwwwwwwwwwwwwwww) {
                uw0 uw0Var = hx0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (uw0Var.Wwwwwwwwwwwwwwwwwwwwwww != 0 || hx0Var.Wwwwwwwwwwwwwwwwwwwwww.read(uw0Var, 8192) != -1) {
                    return hx0.this.Wwwwwwwwwwwwwwwwwwwwwwww.readByte() & 255;
                }
                return -1;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return hx0.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "data");
            if (!hx0.this.Wwwwwwwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr.length, i, i2);
                hx0 hx0Var = hx0.this;
                uw0 uw0Var = hx0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (uw0Var.Wwwwwwwwwwwwwwwwwwwwwww != 0 || hx0Var.Wwwwwwwwwwwwwwwwwwwwww.read(uw0Var, 8192) != -1) {
                    return hx0.this.Wwwwwwwwwwwwwwwwwwwwwwww.read(bArr, i, i2);
                }
                return -1;
            }
            throw new IOException("closed");
        }
    }

    @Override // me.tvspark.ww0
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kx0 kx0Var) {
        uw0 uw0Var;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kx0Var, "sink");
        long j = 0;
        while (true) {
            int i = (this.Wwwwwwwwwwwwwwwwwwwwww.read(this.Wwwwwwwwwwwwwwwwwwwwwwww, 8192) > (-1L) ? 1 : (this.Wwwwwwwwwwwwwwwwwwwwww.read(this.Wwwwwwwwwwwwwwwwwwwwwwww, 8192) == (-1L) ? 0 : -1));
            uw0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (i == 0) {
                break;
            }
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 > 0) {
                j += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                kx0Var.write(this.Wwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
        }
        long j2 = uw0Var.Wwwwwwwwwwwwwwwwwwwwwww;
        if (j2 > 0) {
            long j3 = j + j2;
            kx0Var.write(uw0Var, j2);
            return j3;
        }
        return j;
    }

    @Override // me.tvspark.mx0
    public long read(uw0 uw0Var, long j) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
        if (j >= 0) {
            if (!(!this.Wwwwwwwwwwwwwwwwwwwwwww)) {
                throw new IllegalStateException("closed".toString());
            }
            uw0 uw0Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (uw0Var2.Wwwwwwwwwwwwwwwwwwwwwww == 0 && this.Wwwwwwwwwwwwwwwwwwwwww.read(uw0Var2, 8192) == -1) {
                return -1L;
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.read(uw0Var, Math.min(j, this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww));
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("byteCount < 0: ", j).toString());
    }

    @Override // me.tvspark.ww0
    public ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        if (request(j)) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        }
        throw new EOFException();
    }

    @Override // me.tvspark.ww0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0 uw0Var, long j) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
        try {
            if (request(j)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, j);
                return;
            }
            throw new EOFException();
        } catch (EOFException e) {
            uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((mx0) this.Wwwwwwwwwwwwwwwwwwwwwwww);
            throw e;
        }
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww(4L);
        int readInt = this.Wwwwwwwwwwwwwwwwwwwwwwww.readInt();
        return ((readInt & 255) << 24) | (((-16777216) & readInt) >>> 24) | ((16711680 & readInt) >>> 8) | ((65280 & readInt) << 8);
    }

    @Override // me.tvspark.ww0
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Charset charset) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset, "charset");
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
        uw0 uw0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (uw0Var != null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset, "charset");
            return uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var.Wwwwwwwwwwwwwwwwwwwwwww, charset);
        }
        throw null;
    }

    @Override // me.tvspark.ww0
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dx0 dx0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dx0Var, "options");
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            do {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dx0Var, true);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -2) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
                        return -1;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwww.skip(dx0Var.Wwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2].size());
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
            } while (this.Wwwwwwwwwwwwwwwwwwwwww.read(this.Wwwwwwwwwwwwwwwwwwwwwwww, 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }
}

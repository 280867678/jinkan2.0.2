package me.tvspark;

import com.google.gson.stream.JsonReader;
import com.tencent.smtt.sdk.TbsListener;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.ByteString;
import okio.SegmentedByteString;
import org.apache.commons.lang3.time.StopWatch;
import org.mozilla.javascript.tools.idswitch.Main;

@ef0
/* loaded from: classes4.dex */
public final class uw0 implements ww0, vw0, Cloneable, ByteChannel {
    public static final byte[] Wwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwww;
    public ix0 Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends InputStream {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(uw0.this.Wwwwwwwwwwwwwwwwwwwwwww, Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            uw0 uw0Var = uw0.this;
            if (uw0Var.Wwwwwwwwwwwwwwwwwwwwwww > 0) {
                return uw0Var.readByte() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "sink");
            return uw0.this.read(bArr, i, i2);
        }

        public String toString() {
            return uw0.this + ".inputStream()";
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Closeable {
        public byte[] Wwwwwwwwwwwwwwwwwwww;
        public ix0 Wwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwww;
        public uw0 Wwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwww = -1;
        public int Wwwwwwwwwwwwwwwwwww = -1;
        public int Wwwwwwwwwwwwwwwwww = -1;

        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            uw0 uw0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (uw0Var != null) {
                if (j >= -1) {
                    long j2 = uw0Var.Wwwwwwwwwwwwwwwwwwwwwww;
                    if (j <= j2) {
                        if (j == -1 || j == j2) {
                            this.Wwwwwwwwwwwwwwwwwwwwww = null;
                            this.Wwwwwwwwwwwwwwwwwwwww = j;
                            this.Wwwwwwwwwwwwwwwwwwww = null;
                            this.Wwwwwwwwwwwwwwwwwww = -1;
                            this.Wwwwwwwwwwwwwwwwww = -1;
                            return -1;
                        }
                        long j3 = 0;
                        ix0 ix0Var = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                        ix0 ix0Var2 = this.Wwwwwwwwwwwwwwwwwwwwww;
                        if (ix0Var2 != null) {
                            long j4 = this.Wwwwwwwwwwwwwwwwwwwww;
                            int i = this.Wwwwwwwwwwwwwwwwwww;
                            if (ix0Var2 == null) {
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                throw null;
                            }
                            long j5 = j4 - (i - ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            if (j5 > j) {
                                j2 = j5;
                                ix0Var2 = ix0Var;
                                ix0Var = ix0Var2;
                            } else {
                                j3 = j5;
                            }
                        } else {
                            ix0Var2 = ix0Var;
                        }
                        if (j2 - j > j - j3) {
                            while (ix0Var2 != null) {
                                int i2 = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i3 = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (j >= (i2 - i3) + j3) {
                                    j3 += i2 - i3;
                                    ix0Var2 = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                }
                            }
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            throw null;
                        }
                        while (j2 > j) {
                            if (ix0Var == null) {
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                throw null;
                            }
                            ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (ix0Var == null) {
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                throw null;
                            }
                            j2 -= ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        ix0Var2 = ix0Var;
                        j3 = j2;
                        if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                            if (ix0Var2 == null) {
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                throw null;
                            } else if (ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                byte[] bArr = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
                                ix0 ix0Var3 = new ix0(copyOf, ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false, true);
                                if (uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww == ix0Var2) {
                                    uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww = ix0Var3;
                                }
                                ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var3);
                                ix0 ix0Var4 = ix0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (ix0Var4 == null) {
                                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    throw null;
                                }
                                ix0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                ix0Var2 = ix0Var3;
                            }
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwww = ix0Var2;
                        this.Wwwwwwwwwwwwwwwwwwwww = j;
                        if (ix0Var2 == null) {
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            throw null;
                        }
                        this.Wwwwwwwwwwwwwwwwwwww = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i4 = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + ((int) (j - j3));
                        this.Wwwwwwwwwwwwwwwwwww = i4;
                        int i5 = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        this.Wwwwwwwwwwwwwwwwww = i5;
                        return i5 - i4;
                    }
                }
                String format = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(j), Long.valueOf(uw0Var.Wwwwwwwwwwwwwwwwwwwwwww)}, 2));
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) format, "java.lang.String.format(format, *args)");
                throw new ArrayIndexOutOfBoundsException(format);
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
                this.Wwwwwwwwwwwwwwwwwwwwww = null;
                this.Wwwwwwwwwwwwwwwwwwwww = -1L;
                this.Wwwwwwwwwwwwwwwwwwww = null;
                this.Wwwwwwwwwwwwwwwwwww = -1;
                this.Wwwwwwwwwwwwwwwwww = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }
    }

    static {
        byte[] bytes = "0123456789abcdef".getBytes(ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        Wwwwwwwwwwwwwwwwwwwwww = bytes;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a0 A[EDGE_INSN: B:40:0x00a0->B:38:0x00a0 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0098  */
    @Override // me.tvspark.ww0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long Wwwwwwwwwwwwwwwwwwwww() throws EOFException {
        int i;
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != 0) {
            int i2 = 0;
            boolean z = false;
            long j = 0;
            do {
                ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                byte[] bArr = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i3 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i4 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                while (i3 < i4) {
                    byte b = bArr[i3];
                    byte b2 = (byte) 48;
                    if (b < b2 || b > ((byte) 57)) {
                        byte b3 = (byte) 97;
                        if ((b >= b3 && b <= ((byte) 102)) || (b >= (b3 = (byte) 65) && b <= ((byte) 70))) {
                            i = (b - b3) + 10;
                        } else if (i2 == 0) {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected leading [0-9a-fA-F] character but was 0x");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Integer.toHexString(b));
                            throw new NumberFormatException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                        } else {
                            z = true;
                            if (i3 != i4) {
                                this.Wwwwwwwwwwwwwwwwwwwwwwww = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                jx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var);
                            } else {
                                ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                            }
                            if (!z) {
                                break;
                            }
                        }
                    } else {
                        i = b - b2;
                    }
                    if (((-1152921504606846976L) & j) != 0) {
                        uw0 uw0Var = new uw0();
                        uw0Var.mo4957Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                        uw0Var.mo4963writeByte((int) b);
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Number too large: ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwww());
                        throw new NumberFormatException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                    }
                    j = (j << 4) | i;
                    i3++;
                    i2++;
                }
                if (i3 != i4) {
                }
                if (!z) {
                }
            } while (this.Wwwwwwwwwwwwwwwwwwwwwwww != null);
            this.Wwwwwwwwwwwwwwwwwwwwwww -= i2;
            return j;
        }
        throw new EOFException();
    }

    @Override // me.tvspark.ww0
    public String Wwwwwwwwwwwwwwwwwwwwwwwww() throws EOFException {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Long.MAX_VALUE);
    }

    public uw0 Wwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
        byte[] bArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwww += 8;
        return this;
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final String Wwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws EOFException {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j2 = 1;
        if (j > 0) {
            long j3 = j - 1;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j3) == ((byte) 13)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(j3);
                j2 = 2;
                skip(j2);
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        skip(j2);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.vw0
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwww */
    public uw0 mo4956Wwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i == 0) {
            mo4963writeByte(48);
            return this;
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("-9223372036854775808");
                return this;
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < StopWatch.NANO_2_MILLIS ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        byte[] bArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i2;
        while (j != 0) {
            long j2 = 10;
            i3--;
            bArr[i3] = Wwwwwwwwwwwwwwwwwwwwww[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i3 - 1] = (byte) 45;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2;
        this.Wwwwwwwwwwwwwwwwwwwwwww += i2;
        return this;
    }

    @Override // me.tvspark.vw0
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ vw0 mo4956Wwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        mo4956Wwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        return this;
    }

    @Override // me.tvspark.ww0
    public ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new ByteString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a6 A[EDGE_INSN: B:47:0x00a6->B:42:0x00a6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009e  */
    @Override // me.tvspark.ww0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww() throws EOFException {
        long j = 0;
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != 0) {
            long j2 = -7;
            int i = 0;
            boolean z = false;
            boolean z2 = false;
            do {
                ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                byte[] bArr = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i3 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                while (i2 < i3) {
                    byte b = bArr[i2];
                    byte b2 = (byte) 48;
                    if (b >= b2 && b <= ((byte) 57)) {
                        int i4 = b2 - b;
                        int i5 = (j > JsonReader.MIN_INCOMPLETE_INTEGER ? 1 : (j == JsonReader.MIN_INCOMPLETE_INTEGER ? 0 : -1));
                        if (i5 < 0 || (i5 == 0 && i4 < j2)) {
                            uw0 uw0Var = new uw0();
                            uw0Var.mo4956Wwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                            uw0Var.mo4963writeByte((int) b);
                            if (!z) {
                                uw0Var.readByte();
                            }
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Number too large: ");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwww());
                            throw new NumberFormatException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                        }
                        j = (j * 10) + i4;
                    } else if (b == ((byte) 45) && i == 0) {
                        j2--;
                        z = true;
                    } else if (i == 0) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected leading [0-9] or '-' character but was 0x");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(Integer.toHexString(b));
                        throw new NumberFormatException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                    } else {
                        z2 = true;
                        if (i2 != i3) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwww = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            jx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var);
                        } else {
                            ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
                        }
                        if (!z2) {
                            break;
                        }
                    }
                    i2++;
                    i++;
                }
                if (i2 != i3) {
                }
                if (!z2) {
                }
            } while (this.Wwwwwwwwwwwwwwwwwwwwwwww != null);
            this.Wwwwwwwwwwwwwwwwwwwwwww -= i;
            return z ? j : -j;
        }
        throw new EOFException();
    }

    @Override // me.tvspark.ww0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws EOFException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww >= j) {
            return;
        }
        throw new EOFException();
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws EOFException {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.vw0
    public vw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this;
    }

    public short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws EOFException {
        int readShort = readShort() & 65535;
        return (short) (((readShort & 255) << 8) | ((65280 & readShort) >>> 8));
    }

    @Override // me.tvspark.ww0
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws EOFException {
        if (j >= 0 && j <= ((long) Integer.MAX_VALUE)) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww < j) {
                throw new EOFException();
            }
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("byteCount: ", j).toString());
    }

    public final byte Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, j, 1L);
        ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (ix0Var == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        long j2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (j2 - j < j) {
            while (j2 > j) {
                ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                j2 -= ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[(int) ((ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + j) - j2)];
        }
        long j3 = 0;
        while (true) {
            int i = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j4 = (i - i2) + j3;
            if (j4 > j) {
                return ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[(int) ((i2 + j) - j3)];
            }
            ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (ix0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            j3 = j4;
        }
    }

    @Override // me.tvspark.ww0
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww == 0;
    }

    @Override // me.tvspark.vw0
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public uw0 mo4957Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        if (j == 0) {
            mo4963writeByte(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(numberOfTrailingZeros);
        byte[] bArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = Wwwwwwwwwwwwwwwwwwwwww[(int) (15 & j)];
            j >>>= 4;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += numberOfTrailingZeros;
        this.Wwwwwwwwwwwwwwwwwwwwwww += numberOfTrailingZeros;
        return this;
    }

    @Override // me.tvspark.vw0
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ vw0 mo4957Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        mo4957Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        return this;
    }

    @Override // me.tvspark.ww0
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString) {
        int i;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "targetBytes");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "targetBytes");
        ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (ix0Var != null) {
            long j = this.Wwwwwwwwwwwwwwwwwwwwwww;
            long j2 = 0;
            if (j - 0 < 0) {
                while (j > 0) {
                    ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (ix0Var == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    j -= ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                if (byteString.size() == 2) {
                    byte b = byteString.getByte(0);
                    byte b2 = byteString.getByte(1);
                    while (j < this.Wwwwwwwwwwwwwwwwwwwwwww) {
                        byte[] bArr = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        i = (int) ((ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + j2) - j);
                        int i2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        while (i < i2) {
                            byte b3 = bArr[i];
                            if (b3 != b && b3 != b2) {
                                i++;
                            }
                        }
                        j2 = (ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + j;
                        ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (ix0Var == null) {
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            throw null;
                        }
                        j = j2;
                    }
                    return -1L;
                }
                byte[] internalArray$jvm = byteString.internalArray$jvm();
                while (j < this.Wwwwwwwwwwwwwwwwwwwwwww) {
                    byte[] bArr2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    i = (int) ((ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + j2) - j);
                    int i3 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    while (i < i3) {
                        byte b4 = bArr2[i];
                        for (byte b5 : internalArray$jvm) {
                            if (b4 != b5) {
                            }
                        }
                        i++;
                    }
                    j2 = (ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + j;
                    ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (ix0Var == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    j = j2;
                }
                return -1L;
            }
            j = 0;
            while (true) {
                long j3 = (ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + j;
                if (j3 > 0) {
                    if (byteString.size() == 2) {
                        byte b6 = byteString.getByte(0);
                        byte b7 = byteString.getByte(1);
                        while (j < this.Wwwwwwwwwwwwwwwwwwwwwww) {
                            byte[] bArr3 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            i = (int) ((ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + j2) - j);
                            int i4 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            while (i < i4) {
                                byte b8 = bArr3[i];
                                if (b8 != b6 && b8 != b7) {
                                    i++;
                                }
                            }
                            j2 = (ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + j;
                            ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (ix0Var == null) {
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                throw null;
                            }
                            j = j2;
                        }
                        return -1L;
                    }
                    byte[] internalArray$jvm2 = byteString.internalArray$jvm();
                    while (j < this.Wwwwwwwwwwwwwwwwwwwwwww) {
                        byte[] bArr4 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        i = (int) ((ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + j2) - j);
                        int i5 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        while (i < i5) {
                            byte b9 = bArr4[i];
                            for (byte b10 : internalArray$jvm2) {
                                if (b9 != b10) {
                                }
                            }
                            i++;
                        }
                        j2 = (ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + j;
                        ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (ix0Var == null) {
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            throw null;
                        }
                        j = j2;
                    }
                    return -1L;
                }
                ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                j = j3;
            }
            return (i - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + j;
        }
        return -1L;
    }

    @Override // me.tvspark.ww0
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            byte b = (byte) 10;
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b, 0L, j2);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -1) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
            if (j2 < this.Wwwwwwwwwwwwwwwwwwwwwww && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2 - 1) == ((byte) 13) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2) == b) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwww(j2);
            }
            uw0 uw0Var = new uw0();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, 0L, Math.min(32, this.Wwwwwwwwwwwwwwwwwwwwwww));
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\\n not found: limit=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(Math.min(this.Wwwwwwwwwwwwwwwwwwwwwww, j));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" content=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww().hex());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append((char) 8230);
            throw new EOFException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("limit < 0: ", j).toString());
    }

    public uw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        long j;
        long j2;
        if (i < 128) {
            mo4963writeByte(i);
        } else {
            if (i < 2048) {
                ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                byte[] bArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                bArr[i2] = (byte) ((i >> 6) | 192);
                bArr[i2 + 1] = (byte) ((i & 63) | 128);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 2;
                j = this.Wwwwwwwwwwwwwwwwwwwwwww;
                j2 = 2;
            } else if (55296 <= i && 57343 >= i) {
                mo4963writeByte(63);
            } else if (i < 65536) {
                ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                byte[] bArr2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                bArr2[i3] = (byte) ((i >> 12) | TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
                bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
                bArr2[i3 + 2] = (byte) ((i & 63) | 128);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 3;
                j = this.Wwwwwwwwwwwwwwwwwwwwwww;
                j2 = 3;
            } else if (i > 1114111) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected code point: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(Integer.toHexString(i));
                throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
            } else {
                ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                byte[] bArr3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                bArr3[i4] = (byte) ((i >> 18) | TbsListener.ErrorCode.TPATCH_VERSION_FAILED);
                bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
                bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
                bArr3[i4 + 3] = (byte) ((i & 63) | 128);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4 + 4;
                j = this.Wwwwwwwwwwwwwwwwwwwwwww;
                j2 = 4;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = j + j2;
        }
        return this;
    }

    @Override // me.tvspark.vw0
    public vw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this;
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        long j = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (j == 0) {
            return 0L;
        }
        ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (ix0Var == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        ix0 ix0Var2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (ix0Var2 != null) {
            int i = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return (i >= 8192 || !ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ? j : j - (i - ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0090, code lost:
        if (r6 >= r4) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0092, code lost:
        r8 = r10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        r9 = (int) java.lang.Math.min(r10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (r10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + r4) - r6);
        r2 = (int) ((r10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + r2) - r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a7, code lost:
        if (r2 >= r9) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ab, code lost:
        if (r8[r2] != r18) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b3, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b2, code lost:
        return (r2 - r10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b6, code lost:
        r6 = r6 + (r10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - r10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        r10 = r10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00bf, code lost:
        if (r10 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c1, code lost:
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00c3, code lost:
        me.tvspark.ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c6, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c7, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte b, long j, long j2) {
        ix0 ix0Var;
        long j3 = j;
        long j4 = j2;
        long j5 = 0;
        if (!(0 <= j3 && j4 >= j3)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("size=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" fromIndex=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(j3);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" toIndex=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(j4);
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString().toString());
        }
        long j6 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (j4 > j6) {
            j4 = j6;
        }
        long j7 = -1;
        if (j3 == j4 || (ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww) == null) {
            return -1L;
        }
        long j8 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (j8 - j3 < j3) {
            while (j8 > j3) {
                ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                j8 -= ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            while (j8 < j4) {
                byte[] bArr = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int min = (int) Math.min(ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + j4) - j8);
                for (int i = (int) ((ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + j3) - j8); i < min; i++) {
                    if (bArr[i] == b) {
                        return (i - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + j8;
                    }
                }
                j8 += ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                j7 = -1;
                j3 = j8;
            }
            return j7;
        }
        while (true) {
            long j9 = (ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + j5;
            if (j9 > j3) {
                break;
            }
            ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (ix0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            j5 = j9;
        }
    }

    @Override // me.tvspark.ww0
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kx0 kx0Var) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kx0Var, "sink");
        long j = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (j > 0) {
            kx0Var.write(this, j);
        }
        return j;
    }

    @Override // me.tvspark.vw0
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0 mx0Var) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var, "source");
        long j = 0;
        while (true) {
            long read = mx0Var.read(this, 8192);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, Charset charset) throws EOFException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset, "charset");
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0 && j <= ((long) Integer.MAX_VALUE)) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww < j) {
                throw new EOFException();
            }
            if (i == 0) {
                return "";
            }
            ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (ix0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            int i2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 + j > ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return new String(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j), charset);
            }
            int i3 = (int) j;
            String str = new String(ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i2, i3, charset);
            int i4 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i3;
            ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
            this.Wwwwwwwwwwwwwwwwwwwwwww -= j;
            if (i4 == ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                jx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var);
            }
            return str;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("byteCount: ", j).toString());
    }

    @Override // me.tvspark.ww0
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Charset charset) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset, "charset");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, charset);
    }

    public final ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        boolean z = true;
        if (i < 1 || i > 8192) {
            z = false;
        }
        if (z) {
            ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (ix0Var == null) {
                ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = jx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            } else if (ix0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            } else {
                ix0 ix0Var2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var2 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else if (ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i <= 8192 && ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    return ix0Var2;
                } else {
                    ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = jx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                }
            }
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "unsafeCursor");
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = this;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = true;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    @Override // me.tvspark.vw0
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public uw0 mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Main.STRING_TAG_STR);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 0, str.length());
        return this;
    }

    public uw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, int i2) {
        char charAt;
        long j;
        long j2;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Main.STRING_TAG_STR);
        if (i >= 0) {
            if (!(i2 >= i)) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("endIndex < beginIndex: ", i2, " < ", i).toString());
            }
            if (!(i2 <= str.length())) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("endIndex > string.length: ", i2, " > ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str.length());
                throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString().toString());
            }
            while (i < i2) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 128) {
                    ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    byte[] bArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt2;
                    while (true) {
                        i = i4;
                        if (i >= min || (charAt = str.charAt(i)) >= 128) {
                            break;
                        }
                        i4 = i + 1;
                        bArr[i + i3] = (byte) charAt;
                    }
                    int i5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i6 = (i3 + i) - i5;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5 + i6;
                    this.Wwwwwwwwwwwwwwwwwwwwwww += i6;
                } else {
                    if (charAt2 < 2048) {
                        ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                        byte[] bArr2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        bArr2[i7] = (byte) ((charAt2 >> 6) | 192);
                        bArr2[i7 + 1] = (byte) ((charAt2 & '?') | 128);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i7 + 2;
                        j = this.Wwwwwwwwwwwwwwwwwwwwwww;
                        j2 = 2;
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                        byte[] bArr3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        bArr3[i8] = (byte) ((charAt2 >> '\f') | TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
                        bArr3[i8 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                        bArr3[i8 + 2] = (byte) ((charAt2 & '?') | 128);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8 + 3;
                        j = this.Wwwwwwwwwwwwwwwwwwwwwww;
                        j2 = 3;
                    } else {
                        int i9 = i + 1;
                        char charAt3 = i9 < i2 ? str.charAt(i9) : (char) 0;
                        if (charAt2 > 56319 || 56320 > charAt3 || 57343 < charAt3) {
                            mo4963writeByte(63);
                            i = i9;
                        } else {
                            int i10 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                            ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                            byte[] bArr4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i11 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            bArr4[i11] = (byte) ((i10 >> 18) | TbsListener.ErrorCode.TPATCH_VERSION_FAILED);
                            bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                            bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                            bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i11 + 4;
                            this.Wwwwwwwwwwwwwwwwwwwwwww += 4;
                            i += 2;
                        }
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwww = j + j2;
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("beginIndex < 0: ", i).toString());
    }

    public uw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, int i2, Charset charset) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Main.STRING_TAG_STR);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset, "charset");
        boolean z = true;
        if (i >= 0) {
            if (!(i2 >= i)) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("endIndex < beginIndex: ", i2, " < ", i).toString());
            }
            if (i2 > str.length()) {
                z = false;
            }
            if (!z) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("endIndex > string.length: ", i2, " > ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str.length());
                throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString().toString());
            } else if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset, ek0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, i, i2);
                return this;
            } else {
                String substring = str.substring(i, i2);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                byte[] bytes = substring.getBytes(charset);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                mo4962write(bytes, 0, bytes.length);
                return this;
            }
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("beginIndex < 0: ", i).toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
        if (r13 <= 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r2 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
        r4 = r2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        r5 = r4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + ((int) r11);
        r4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r5;
        r4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = java.lang.Math.min(r5 + ((int) r13), r4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        r11 = r10.Wwwwwwwwwwwwwwwwwwwwwwww;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r11 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
        r4.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = r4;
        r4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = r4;
        r10.Wwwwwwwwwwwwwwwwwwwwwwww = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
        r13 = r13 - (r4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - r4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        r2 = r2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
        if (r11 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
        r11 = r11.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
        if (r11 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
        r11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
        me.tvspark.ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006b, code lost:
        me.tvspark.ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006f, code lost:
        me.tvspark.ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0072, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0073, code lost:
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final uw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0 uw0Var, long j, long j2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "out");
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, j, j2);
        if (j2 == 0) {
            return this;
        }
        uw0Var.Wwwwwwwwwwwwwwwwwwwwwww += j2;
        ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        while (ix0Var != null) {
            int i = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (j >= i - i2) {
                j -= i - i2;
                ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    @Override // me.tvspark.vw0
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public uw0 mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "byteString");
        byteString.write$jvm(this);
        return this;
    }

    @Override // me.tvspark.vw0
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ vw0 mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        mo4958Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        return this;
    }

    @Override // me.tvspark.vw0
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ vw0 mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteString byteString) {
        mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString);
        return this;
    }

    @Override // me.tvspark.ww0
    public ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws EOFException {
        return new ByteString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j));
    }

    @Override // me.tvspark.ww0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0 uw0Var, long j) throws EOFException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
        long j2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (j2 >= j) {
            uw0Var.write(this, j);
        } else {
            uw0Var.write(this, j2);
            throw new EOFException();
        }
    }

    public uw0 clone() {
        uw0 uw0Var = new uw0();
        if (this.Wwwwwwwwwwwwwwwwwwwwwww == 0) {
            return uw0Var;
        }
        ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (ix0Var == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            ix0 ix0Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (ix0Var2 == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            while (true) {
                ix0Var2 = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var2 == this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                    uw0Var.Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    return uw0Var;
                }
                ix0 ix0Var3 = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var3 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                ix0 ix0Var4 = ix0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var4 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else if (ix0Var2 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else {
                    ix0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                }
            }
        }
    }

    @Override // me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uw0)) {
            return false;
        }
        long j = this.Wwwwwwwwwwwwwwwwwwwwwww;
        uw0 uw0Var = (uw0) obj;
        if (j != uw0Var.Wwwwwwwwwwwwwwwwwwwwwww) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (ix0Var == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        ix0 ix0Var2 = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (ix0Var2 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        int i = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j3 = 0;
        while (j3 < this.Wwwwwwwwwwwwwwwwwwwwwww) {
            long min = Math.min(ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - i, ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - i2);
            long j4 = j2;
            while (j4 < min) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] != ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2]) {
                    return false;
                }
                j4++;
                i = i3;
                i2 = i4;
            }
            if (i == ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                i = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            if (i2 == ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                ix0Var2 = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var2 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                i2 = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            j3 += min;
            j2 = 0;
        }
        return true;
    }

    @Override // me.tvspark.vw0, me.tvspark.kx0, java.io.Flushable
    public void flush() {
    }

    @Override // me.tvspark.ww0
    public uw0 getBuffer() {
        return this;
    }

    public int hashCode() {
        ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (ix0Var != null) {
            int i = 1;
            do {
                int i2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                for (int i3 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i3 < i2; i3++) {
                    i = (i * 31) + ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3];
                }
                ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
            } while (ix0Var != this.Wwwwwwwwwwwwwwwwwwwwwwww);
            return i;
        }
        return 0;
    }

    @Override // me.tvspark.ww0
    public InputStream inputStream() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // me.tvspark.ww0
    public ww0 peek() {
        fx0 fx0Var = new fx0(this);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fx0Var, "$receiver");
        return new hx0(fx0Var);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer, "sink");
        ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (ix0Var != null) {
            int min = Math.min(byteBuffer.remaining(), ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            byteBuffer.put(ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, min);
            int i = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + min;
            ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwww -= min;
            if (i == ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                jx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var);
            }
            return min;
        }
        return -1;
    }

    public int read(byte[] bArr, int i, int i2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "sink");
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr.length, i, i2);
        ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (ix0Var != null) {
            int min = Math.min(i2, ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            System.arraycopy(ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, i, min);
            int i3 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + min;
            ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
            this.Wwwwwwwwwwwwwwwwwwwwwww -= min;
            if (i3 == ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                jx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var);
            }
            return min;
        }
        return -1;
    }

    @Override // me.tvspark.mx0
    public long read(uw0 uw0Var, long j) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
        if (j >= 0) {
            long j2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            uw0Var.write(this, j);
            return j;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("byteCount < 0: ", j).toString());
    }

    @Override // me.tvspark.ww0
    public byte readByte() throws EOFException {
        long j = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (j != 0) {
            ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (ix0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            int i = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = i + 1;
            byte b = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            this.Wwwwwwwwwwwwwwwwwwwwwww = j - 1;
            if (i3 == i2) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                jx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var);
            } else {
                ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
            }
            return b;
        }
        throw new EOFException();
    }

    @Override // me.tvspark.ww0
    public void readFully(byte[] bArr) throws EOFException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    @Override // me.tvspark.ww0
    public int readInt() throws EOFException {
        long j = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (j >= 4) {
            ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (ix0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            int i = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & 255);
            this.Wwwwwwwwwwwwwwwwwwwwwww = j - 4;
            if (i8 == i2) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                jx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var);
            } else {
                ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8;
            }
            return i9;
        }
        throw new EOFException();
    }

    @Override // me.tvspark.ww0
    public long readLong() throws EOFException {
        long j = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (j >= 8) {
            ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (ix0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            int i = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 - i < 8) {
                return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
            }
            byte[] bArr = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = i + 1;
            int i4 = i3 + 1;
            long j2 = (bArr[i3] & 255) << 48;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            long j3 = j2 | ((bArr[i] & 255) << 56) | ((bArr[i4] & 255) << 40) | ((bArr[i5] & 255) << 32);
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            long j4 = j3 | ((bArr[i6] & 255) << 24) | ((bArr[i7] & 255) << 16);
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j5 = j4 | ((bArr[i8] & 255) << 8) | (bArr[i9] & 255);
            this.Wwwwwwwwwwwwwwwwwwwwwww = j - 8;
            if (i10 == i2) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                jx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var);
            } else {
                ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i10;
            }
            return j5;
        }
        throw new EOFException();
    }

    @Override // me.tvspark.ww0
    public short readShort() throws EOFException {
        long j = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (j >= 2) {
            ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (ix0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            int i = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.Wwwwwwwwwwwwwwwwwwwwwww = j - 2;
            if (i4 == i2) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                jx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var);
            } else {
                ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
            }
            return (short) i5;
        }
        throw new EOFException();
    }

    @Override // me.tvspark.ww0
    public boolean request(long j) {
        return this.Wwwwwwwwwwwwwwwwwwwwwww >= j;
    }

    @Override // me.tvspark.ww0
    public void skip(long j) throws EOFException {
        while (j > 0) {
            ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (ix0Var == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            long j2 = min;
            this.Wwwwwwwwwwwwwwwwwwwwwww -= j2;
            j -= j2;
            int i = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + min;
            ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            if (i == ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                jx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var);
            }
        }
    }

    @Override // me.tvspark.mx0
    public nx0 timeout() {
        return nx0.NONE;
    }

    public String toString() {
        ByteString segmentedByteString;
        int i = 0;
        if (this.Wwwwwwwwwwwwwwwwwwwwwww <= ((long) Integer.MAX_VALUE)) {
            int i2 = (int) this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (i2 == 0) {
                segmentedByteString = ByteString.EMPTY;
            } else if (SegmentedByteString.Companion != null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, "buffer");
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, 0L, i2);
                ix0 ix0Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                int i3 = 0;
                int i4 = 0;
                while (i3 < i2) {
                    if (ix0Var == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    int i5 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i6 = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i5 == i6) {
                        throw new AssertionError("s.limit == s.pos");
                    }
                    i3 += i5 - i6;
                    i4++;
                    ix0Var = ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                byte[][] bArr = new byte[i4];
                int[] iArr = new int[i4 * 2];
                ix0 ix0Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                int i7 = 0;
                while (i < i2) {
                    if (ix0Var2 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    bArr[i7] = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    i += ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    iArr[i7] = Math.min(i, i2);
                    iArr[i7 + i4] = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                    i7++;
                    ix0Var2 = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                segmentedByteString = new SegmentedByteString(bArr, iArr, null);
            } else {
                throw null;
            }
            return segmentedByteString.toString();
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("size > Integer.MAX_VALUE: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwww);
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString().toString());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            int min = Math.min(i, 8192 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            byteBuffer.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, min);
            i -= min;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += min;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww += remaining;
        return remaining;
    }

    @Override // me.tvspark.vw0
    /* renamed from: write */
    public uw0 mo4961write(byte[] bArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "source");
        mo4962write(bArr, 0, bArr.length);
        return this;
    }

    @Override // me.tvspark.vw0
    /* renamed from: write */
    public uw0 mo4962write(byte[] bArr, int i, int i2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "source");
        long j = i2;
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            int min = Math.min(i3 - i, 8192 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            System.arraycopy(bArr, i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, min);
            i += min;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += min;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww += j;
        return this;
    }

    @Override // me.tvspark.vw0
    /* renamed from: write  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ vw0 mo4961write(byte[] bArr) {
        mo4961write(bArr);
        return this;
    }

    @Override // me.tvspark.vw0
    /* renamed from: write  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ vw0 mo4962write(byte[] bArr, int i, int i2) {
        mo4962write(bArr, i, i2);
        return this;
    }

    @Override // me.tvspark.kx0
    public void write(uw0 uw0Var, long j) {
        ix0 ix0Var;
        ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "source");
        if (uw0Var != this) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var.Wwwwwwwwwwwwwwwwwwwwwww, 0L, j);
            while (j > 0) {
                ix0 ix0Var2 = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var2 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                int i = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var2 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                if (j < i - ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    ix0 ix0Var3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (ix0Var3 == null) {
                        ix0Var = null;
                    } else if (ix0Var3 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    } else {
                        ix0Var = ix0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                    if (ix0Var != null && ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        if ((ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + j) - (ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 0 : ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) <= 8192) {
                            ix0 ix0Var4 = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                            if (ix0Var4 == null) {
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                throw null;
                            }
                            ix0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var, (int) j);
                            uw0Var.Wwwwwwwwwwwwwwwwwwwwwww -= j;
                            this.Wwwwwwwwwwwwwwwwwwwwwww += j;
                            return;
                        }
                    }
                    ix0 ix0Var5 = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (ix0Var5 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    int i2 = (int) j;
                    if (ix0Var5 == null) {
                        throw null;
                    }
                    if (!(i2 > 0 && i2 <= ix0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        throw new IllegalArgumentException("byteCount out of range".toString());
                    }
                    if (i2 >= 1024) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ix0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = jx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ix0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, i2);
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i2;
                    ix0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2;
                    ix0 ix0Var6 = ix0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (ix0Var6 != null) {
                        ix0Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    } else {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                }
                ix0 ix0Var7 = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var7 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                long j2 = ix0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww = ix0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                ix0 ix0Var8 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var8 == null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = ix0Var7;
                    ix0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = ix0Var7;
                    ix0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = ix0Var7;
                } else if (ix0Var8 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else {
                    ix0 ix0Var9 = ix0Var8.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (ix0Var9 != null) {
                        ix0Var9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var7);
                        if (!(ix0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != ix0Var7)) {
                            throw new IllegalStateException("cannot compact".toString());
                        }
                        ix0 ix0Var10 = ix0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (ix0Var10 == null) {
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            throw null;
                        } else if (!ix0Var10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            continue;
                        } else {
                            int i3 = ix0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ix0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (i3 <= (8192 - ix0Var10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + (ix0Var10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 0 : ix0Var10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                ix0 ix0Var11 = ix0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (ix0Var11 == null) {
                                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    throw null;
                                }
                                ix0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var11, i3);
                                ix0Var7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                jx0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var7);
                            } else {
                                continue;
                            }
                        }
                    } else {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                }
                uw0Var.Wwwwwwwwwwwwwwwwwwwwwww -= j2;
                this.Wwwwwwwwwwwwwwwwwwwwwww += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    @Override // me.tvspark.vw0
    /* renamed from: writeByte */
    public uw0 mo4963writeByte(int i) {
        ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        byte[] bArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
        bArr[i2] = (byte) i;
        this.Wwwwwwwwwwwwwwwwwwwwwww++;
        return this;
    }

    @Override // me.tvspark.vw0
    /* renamed from: writeByte  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ vw0 mo4963writeByte(int i) {
        mo4963writeByte(i);
        return this;
    }

    @Override // me.tvspark.vw0
    /* renamed from: writeInt */
    public uw0 mo4964writeInt(int i) {
        ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        byte[] bArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwww += 4;
        return this;
    }

    @Override // me.tvspark.vw0
    /* renamed from: writeInt  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ vw0 mo4964writeInt(int i) {
        mo4964writeInt(i);
        return this;
    }

    @Override // me.tvspark.vw0
    /* renamed from: writeShort */
    public uw0 mo4965writeShort(int i) {
        ix0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        byte[] bArr = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwww += 2;
        return this;
    }

    @Override // me.tvspark.vw0
    /* renamed from: writeShort  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ vw0 mo4965writeShort(int i) {
        mo4965writeShort(i);
        return this;
    }

    @Override // me.tvspark.ww0
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dx0 dx0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dx0Var, "options");
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dx0Var, false);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
            return -1;
        }
        skip(dx0Var.Wwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2].size());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0054, code lost:
        if (r19 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0056, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0057, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dx0 dx0Var, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        ix0 ix0Var;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dx0Var, "options");
        ix0 ix0Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i5 = -2;
        if (ix0Var2 == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i6 = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i7 = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int[] iArr = dx0Var.Wwwwwwwwwwwwwwwwwwwwwww;
        ix0 ix0Var3 = ix0Var2;
        int i8 = 0;
        int i9 = -1;
        loop0: while (true) {
            int i10 = i8 + 1;
            int i11 = iArr[i8];
            int i12 = i10 + 1;
            int i13 = iArr[i10];
            if (i13 != -1) {
                i9 = i13;
            }
            if (ix0Var3 == null) {
                break;
            }
            if (i11 >= 0) {
                int i14 = i6 + 1;
                int i15 = bArr[i6] & 255;
                int i16 = i12 + i11;
                while (i12 != i16) {
                    if (i15 == iArr[i12]) {
                        i = iArr[i12 + i11];
                        if (i14 == i7) {
                            ix0Var3 = ix0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (ix0Var3 == null) {
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                throw null;
                            }
                            i2 = ix0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            bArr = ix0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            i7 = ix0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (ix0Var3 == ix0Var2) {
                                ix0Var3 = null;
                            }
                        } else {
                            i2 = i14;
                        }
                    } else {
                        i12++;
                    }
                }
                return i9;
            }
            int i17 = (i11 * (-1)) + i12;
            while (true) {
                int i18 = i6 + 1;
                int i19 = i12 + 1;
                if ((bArr[i6] & 255) != iArr[i12]) {
                    return i9;
                }
                boolean z2 = i19 == i17;
                if (i18 != i7) {
                    ix0 ix0Var4 = ix0Var3;
                    i3 = i7;
                    i4 = i18;
                    ix0Var = ix0Var4;
                } else if (ix0Var3 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else {
                    ix0 ix0Var5 = ix0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (ix0Var5 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    i4 = ix0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    byte[] bArr2 = ix0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    i3 = ix0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (ix0Var5 != ix0Var2) {
                        ix0Var = ix0Var5;
                        bArr = bArr2;
                    } else if (!z2) {
                        break loop0;
                    } else {
                        bArr = bArr2;
                        ix0Var = null;
                    }
                }
                if (z2) {
                    i = iArr[i19];
                    i2 = i4;
                    i7 = i3;
                    ix0Var3 = ix0Var;
                    break;
                }
                i6 = i4;
                i7 = i3;
                i12 = i19;
                ix0Var3 = ix0Var;
            }
            if (i >= 0) {
                return i;
            }
            i8 = -i;
            i6 = i2;
            i5 = -2;
        }
    }
}

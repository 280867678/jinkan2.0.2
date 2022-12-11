package org.eclipse.jetty.p059io;

import org.eclipse.jetty.p059io.Buffers;
import org.eclipse.jetty.p059io.nio.DirectNIOBuffer;
import org.eclipse.jetty.p059io.nio.IndirectNIOBuffer;

/* renamed from: org.eclipse.jetty.io.AbstractBuffers */
/* loaded from: classes4.dex */
public abstract class AbstractBuffers implements Buffers {
    public final int _bufferSize;
    public final Buffers.Type _bufferType;
    public final int _headerSize;
    public final Buffers.Type _headerType;
    public final Buffers.Type _otherType;

    /* renamed from: org.eclipse.jetty.io.AbstractBuffers$1 */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C29521 {
        public static final /* synthetic */ int[] $SwitchMap$org$eclipse$jetty$io$Buffers$Type;

        static {
            int[] iArr = new int[Buffers.Type.values().length];
            $SwitchMap$org$eclipse$jetty$io$Buffers$Type = iArr;
            try {
                Buffers.Type type = Buffers.Type.BYTE_ARRAY;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$org$eclipse$jetty$io$Buffers$Type;
                Buffers.Type type2 = Buffers.Type.DIRECT;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$org$eclipse$jetty$io$Buffers$Type;
                Buffers.Type type3 = Buffers.Type.INDIRECT;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public AbstractBuffers(Buffers.Type type, int i, Buffers.Type type2, int i2, Buffers.Type type3) {
        this._headerType = type;
        this._headerSize = i;
        this._bufferType = type2;
        this._bufferSize = i2;
        this._otherType = type3;
    }

    public int getBufferSize() {
        return this._bufferSize;
    }

    public int getHeaderSize() {
        return this._headerSize;
    }

    public final boolean isBuffer(Buffer buffer) {
        if (buffer.capacity() == this._bufferSize) {
            int ordinal = this._bufferType.ordinal();
            if (ordinal == 0) {
                return (buffer instanceof ByteArrayBuffer) && !(buffer instanceof IndirectNIOBuffer);
            } else if (ordinal == 1) {
                return buffer instanceof DirectNIOBuffer;
            } else {
                if (ordinal == 2) {
                    return buffer instanceof IndirectNIOBuffer;
                }
                return false;
            }
        }
        return false;
    }

    public final boolean isHeader(Buffer buffer) {
        if (buffer.capacity() == this._headerSize) {
            int ordinal = this._headerType.ordinal();
            if (ordinal == 0) {
                return (buffer instanceof ByteArrayBuffer) && !(buffer instanceof IndirectNIOBuffer);
            } else if (ordinal == 1) {
                return buffer instanceof DirectNIOBuffer;
            } else {
                if (ordinal == 2) {
                    return buffer instanceof IndirectNIOBuffer;
                }
                return false;
            }
        }
        return false;
    }

    public final Buffer newBuffer() {
        int ordinal = this._bufferType.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                return new DirectNIOBuffer(this._bufferSize);
            }
            if (ordinal != 2) {
                throw new IllegalStateException();
            }
            return new IndirectNIOBuffer(this._bufferSize);
        }
        return new ByteArrayBuffer(this._bufferSize);
    }

    public final Buffer newBuffer(int i) {
        int ordinal = this._otherType.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                return new DirectNIOBuffer(i);
            }
            if (ordinal != 2) {
                throw new IllegalStateException();
            }
            return new IndirectNIOBuffer(i);
        }
        return new ByteArrayBuffer(i);
    }

    public final Buffer newHeader() {
        int ordinal = this._headerType.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                return new DirectNIOBuffer(this._headerSize);
            }
            if (ordinal != 2) {
                throw new IllegalStateException();
            }
            return new IndirectNIOBuffer(this._headerSize);
        }
        return new ByteArrayBuffer(this._headerSize);
    }

    public String toString() {
        return String.format("%s [%d,%d]", getClass().getSimpleName(), Integer.valueOf(this._headerSize), Integer.valueOf(this._bufferSize));
    }
}

package org.antlr.p055v4.runtime;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

/* renamed from: org.antlr.v4.runtime.CodePointBuffer */
/* loaded from: classes4.dex */
public class CodePointBuffer {
    public final IntBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final CharBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: org.antlr.v4.runtime.CodePointBuffer$Type */
    /* loaded from: classes4.dex */
    public enum Type {
        BYTE,
        CHAR,
        INT
    }

    /* renamed from: org.antlr.v4.runtime.CodePointBuffer$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Type Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Type.BYTE;
        public CharBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        public IntBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;

        public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return (int) Math.pow(2.0d, 32 - Integer.numberOfLeadingZeros(i - 1));
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharBuffer charBuffer) {
            char[] array = charBuffer.array();
            int position = charBuffer.position() + charBuffer.arrayOffset();
            int limit = charBuffer.limit() + charBuffer.arrayOffset();
            int[] array2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.array();
            int position2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.position() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.arrayOffset();
            while (true) {
                int i = -1;
                if (position >= limit) {
                    break;
                }
                char c = array[position];
                position++;
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
                    if (Character.isLowSurrogate(c)) {
                        array2[position2] = Character.toCodePoint((char) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c);
                    } else {
                        array2[position2] = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        position2++;
                        if (!Character.isHighSurrogate(c)) {
                            array2[position2] = 65535 & c;
                        }
                    }
                    position2++;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                } else if (!Character.isHighSurrogate(c)) {
                    array2[position2] = c & 65535;
                    position2++;
                }
                i = c & 65535;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            }
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 != -1) {
                array2[position2] = i2 & 65535;
                position2++;
            }
            charBuffer.position(position - charBuffer.arrayOffset());
            IntBuffer intBuffer = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            intBuffer.position(position2 - intBuffer.arrayOffset());
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharBuffer charBuffer) {
            char[] array = charBuffer.array();
            int position = charBuffer.position() + charBuffer.arrayOffset();
            int limit = charBuffer.limit() + charBuffer.arrayOffset();
            char[] array2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.array();
            int position2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.position() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.arrayOffset();
            while (position < limit) {
                char c = array[position];
                if (Character.isHighSurrogate(c)) {
                    charBuffer.position(position - charBuffer.arrayOffset());
                    CharBuffer charBuffer2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    charBuffer2.position(position2 - charBuffer2.arrayOffset());
                    int remaining = charBuffer.remaining();
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flip();
                    IntBuffer allocate = IntBuffer.allocate(Math.max(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining() + remaining, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.capacity() / 2));
                    while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hasRemaining()) {
                        allocate.put(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get() & 65535);
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Type.INT;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = allocate;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charBuffer);
                    return;
                }
                array2[position2] = c;
                position++;
                position2++;
            }
            charBuffer.position(position - charBuffer.arrayOffset());
            CharBuffer charBuffer3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            charBuffer3.position(position2 - charBuffer3.arrayOffset());
        }
    }

    /* renamed from: org.antlr.v4.runtime.CodePointBuffer$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final /* synthetic */ int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        static {
            int[] iArr = new int[Type.values().length];
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            try {
                Type type = Type.BYTE;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Type type2 = Type.CHAR;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Type type3 = Type.INT;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public /* synthetic */ CodePointBuffer(Type type, ByteBuffer byteBuffer, CharBuffer charBuffer, IntBuffer intBuffer, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = type;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = byteBuffer;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charBuffer;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = intBuffer;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int ordinal = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining();
            }
            if (ordinal != 2) {
                throw new UnsupportedOperationException("Not reached");
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining();
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining();
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int ordinal = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.position();
            }
            if (ordinal != 2) {
                throw new UnsupportedOperationException("Not reached");
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.position();
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.position();
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int ordinal = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.arrayOffset();
            }
            if (ordinal != 2) {
                throw new UnsupportedOperationException("Not reached");
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.arrayOffset();
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.arrayOffset();
    }
}

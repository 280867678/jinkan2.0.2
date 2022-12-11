package org.eclipse.jetty.p059io;

import org.apache.commons.lang3.time.StopWatch;
import org.eclipse.jetty.p059io.BufferCache;
import org.eclipse.jetty.util.StringUtil;
import org.mozilla.javascript.regexp.NativeRegExp;
import org.mozilla.javascript.v8dtoa.FastDtoa;

/* renamed from: org.eclipse.jetty.io.BufferUtil */
/* loaded from: classes4.dex */
public class BufferUtil {
    public static final byte MINUS = 45;
    public static final byte SPACE = 32;
    public static final byte[] DIGIT = {NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_ENDCHILD, 50, NativeRegExp.REOP_REPEAT, NativeRegExp.REOP_MINIMALREPEAT, NativeRegExp.REOP_ALTPREREQ, NativeRegExp.REOP_ALTPREREQi, NativeRegExp.REOP_ALTPREREQ2, 56, NativeRegExp.REOP_END, 65, 66, 67, 68, 69, 70};
    public static final int[] decDivisors = {FastDtoa.kTen9, FastDtoa.kTen8, FastDtoa.kTen7, 1000000, FastDtoa.kTen5, 10000, 1000, 100, 10, 1};
    public static final int[] hexDivisors = {268435456, 16777216, 1048576, 65536, 4096, 256, 16, 1};
    public static final long[] decDivisorsL = {1000000000000000000L, 100000000000000000L, 10000000000000000L, 1000000000000000L, 100000000000000L, 10000000000000L, 1000000000000L, 100000000000L, 10000000000L, 1000000000, 100000000, 10000000, StopWatch.NANO_2_MILLIS, 100000, 10000, 1000, 100, 10, 1};

    public static boolean isPrefix(Buffer buffer, Buffer buffer2) {
        if (buffer.length() > buffer2.length()) {
            return false;
        }
        int index = buffer2.getIndex();
        int index2 = buffer.getIndex();
        while (index2 < buffer.putIndex()) {
            int i = index + 1;
            if (buffer.peek(index2) != buffer2.peek(index)) {
                return false;
            }
            index2++;
            index = i;
        }
        return true;
    }

    public static void prependHexInt(Buffer buffer, int i) {
        if (i == 0) {
            int index = buffer.getIndex() - 1;
            buffer.poke(index, NativeRegExp.REOP_MINIMALQUANT);
            buffer.setGetIndex(index);
            return;
        }
        boolean z = false;
        if (i < 0) {
            z = true;
            i = -i;
        }
        int index2 = buffer.getIndex();
        while (i > 0) {
            int i2 = i & 15;
            i >>= 4;
            index2--;
            buffer.poke(index2, DIGIT[i2]);
        }
        if (z) {
            index2--;
            buffer.poke(index2, (byte) 45);
        }
        buffer.setGetIndex(index2);
    }

    public static void putCRLF(Buffer buffer) {
        buffer.put((byte) 13);
        buffer.put((byte) 10);
    }

    public static void putDecInt(Buffer buffer, int i) {
        if (i < 0) {
            buffer.put((byte) 45);
            if (i == Integer.MIN_VALUE) {
                buffer.put((byte) 50);
                i = 147483648;
            } else {
                i = -i;
            }
        }
        if (i < 10) {
            buffer.put(DIGIT[i]);
            return;
        }
        int i2 = 0;
        boolean z = false;
        while (true) {
            int[] iArr = decDivisors;
            if (i2 >= iArr.length) {
                return;
            }
            if (i >= iArr[i2]) {
                int i3 = i / iArr[i2];
                buffer.put(DIGIT[i3]);
                i -= i3 * decDivisors[i2];
                z = true;
            } else if (z) {
                buffer.put(NativeRegExp.REOP_MINIMALQUANT);
            }
            i2++;
        }
    }

    public static void putDecLong(Buffer buffer, long j) {
        if (j < 0) {
            buffer.put((byte) 45);
            if (j == Long.MIN_VALUE) {
                buffer.put(NativeRegExp.REOP_END);
                j = 223372036854775808L;
            } else {
                j = -j;
            }
        }
        if (j < 10) {
            buffer.put(DIGIT[(int) j]);
            return;
        }
        int i = 0;
        boolean z = false;
        while (true) {
            long[] jArr = decDivisorsL;
            if (i >= jArr.length) {
                return;
            }
            if (j >= jArr[i]) {
                long j2 = j / jArr[i];
                buffer.put(DIGIT[(int) j2]);
                j -= j2 * decDivisorsL[i];
                z = true;
            } else if (z) {
                buffer.put(NativeRegExp.REOP_MINIMALQUANT);
            }
            i++;
        }
    }

    public static void putHexInt(Buffer buffer, int i) {
        if (i < 0) {
            buffer.put((byte) 45);
            if (i == Integer.MIN_VALUE) {
                buffer.put((byte) 56);
                buffer.put(NativeRegExp.REOP_MINIMALQUANT);
                buffer.put(NativeRegExp.REOP_MINIMALQUANT);
                buffer.put(NativeRegExp.REOP_MINIMALQUANT);
                buffer.put(NativeRegExp.REOP_MINIMALQUANT);
                buffer.put(NativeRegExp.REOP_MINIMALQUANT);
                buffer.put(NativeRegExp.REOP_MINIMALQUANT);
                buffer.put(NativeRegExp.REOP_MINIMALQUANT);
                return;
            }
            i = -i;
        }
        if (i < 16) {
            buffer.put(DIGIT[i]);
            return;
        }
        int i2 = 0;
        boolean z = false;
        while (true) {
            int[] iArr = hexDivisors;
            if (i2 >= iArr.length) {
                return;
            }
            if (i >= iArr[i2]) {
                int i3 = i / iArr[i2];
                buffer.put(DIGIT[i3]);
                i -= i3 * hexDivisors[i2];
                z = true;
            } else if (z) {
                buffer.put(NativeRegExp.REOP_MINIMALQUANT);
            }
            i2++;
        }
    }

    public static String to8859_1_String(Buffer buffer) {
        return buffer instanceof BufferCache.CachedBuffer ? buffer.toString() : buffer.toString(StringUtil.__ISO_8859_1_CHARSET);
    }

    public static Buffer toBuffer(long j) {
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(32);
        putDecLong(byteArrayBuffer, j);
        return byteArrayBuffer;
    }

    public static int toInt(Buffer buffer) {
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        for (int index = buffer.getIndex(); index < buffer.putIndex(); index++) {
            byte peek = buffer.peek(index);
            if (peek > 32) {
                if (peek >= 48 && peek <= 57) {
                    i = (peek - 48) + (i * 10);
                    z = true;
                } else if (peek != 45 || z) {
                    break;
                } else {
                    z2 = true;
                }
            } else if (z) {
                break;
            }
        }
        if (z) {
            return z2 ? -i : i;
        }
        throw new NumberFormatException(buffer.toString());
    }

    public static long toLong(Buffer buffer) {
        boolean z = false;
        long j = 0;
        boolean z2 = false;
        for (int index = buffer.getIndex(); index < buffer.putIndex(); index++) {
            byte peek = buffer.peek(index);
            if (peek > 32) {
                if (peek >= 48 && peek <= 57) {
                    j = (j * 10) + (peek - 48);
                    z = true;
                } else if (peek != 45 || z) {
                    break;
                } else {
                    z2 = true;
                }
            } else if (z) {
                break;
            }
        }
        if (z) {
            return z2 ? -j : j;
        }
        throw new NumberFormatException(buffer.toString());
    }
}

package org.eclipse.jetty.server;

import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.eclipse.jetty.http.AbstractGenerator;
import org.eclipse.jetty.util.ByteArrayOutputStream2;

/* loaded from: classes4.dex */
public class HttpWriter extends Writer {
    public static final int MAX_OUTPUT_CHARS = 512;
    public static final int WRITE_CONV = 0;
    public static final int WRITE_ISO1 = 1;
    public static final int WRITE_UTF8 = 2;
    public final AbstractGenerator _generator;
    public final HttpOutput _out;
    public int _surrogate = 0;
    public int _writeMode;

    public HttpWriter(HttpOutput httpOutput) {
        this._out = httpOutput;
        this._generator = httpOutput._generator;
    }

    private Writer getConverter() throws IOException {
        HttpOutput httpOutput = this._out;
        if (httpOutput._converter == null) {
            HttpOutput httpOutput2 = this._out;
            httpOutput._converter = new OutputStreamWriter(httpOutput2._bytes, httpOutput2._characterEncoding);
        }
        return this._out._converter;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this._out.close();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this._out.flush();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setCharacterEncoding(String str) {
        int i;
        HttpOutput httpOutput;
        if (str == null || "ISO-8859-1".equalsIgnoreCase(str)) {
            i = 1;
        } else if (!"UTF-8".equalsIgnoreCase(str)) {
            this._writeMode = 0;
            String str2 = this._out._characterEncoding;
            if (str2 == null || !str2.equalsIgnoreCase(str)) {
                this._out._converter = null;
            }
            httpOutput = this._out;
            httpOutput._characterEncoding = str;
            if (httpOutput._bytes == null) {
                return;
            }
            httpOutput._bytes = new ByteArrayOutputStream2(512);
            return;
        } else {
            i = 2;
        }
        this._writeMode = i;
        httpOutput = this._out;
        httpOutput._characterEncoding = str;
        if (httpOutput._bytes == null) {
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        while (i2 > 512) {
            write(str, i, 512);
            i += 512;
            i2 -= 512;
        }
        HttpOutput httpOutput = this._out;
        if (httpOutput._chars == null) {
            httpOutput._chars = new char[512];
        }
        char[] cArr = this._out._chars;
        str.getChars(i, i + i2, cArr, 0);
        write(cArr, 0, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0175 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0178 A[SYNTHETIC] */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(char[] cArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        HttpOutput httpOutput = this._out;
        while (i2 > 0) {
            httpOutput._bytes.reset();
            int i5 = 512;
            if (i2 <= 512) {
                i5 = i2;
            }
            int i6 = this._writeMode;
            if (i6 != 0) {
                int i7 = 0;
                if (i6 == 1) {
                    byte[] buf = httpOutput._bytes.getBuf();
                    int count = httpOutput._bytes.getCount();
                    if (i5 > buf.length - count) {
                        i5 = buf.length - count;
                    }
                    while (i7 < i5) {
                        char c = cArr[i + i7];
                        int i8 = count + 1;
                        if (c >= 256) {
                            c = '?';
                        }
                        buf[count] = (byte) c;
                        i7++;
                        count = i8;
                    }
                    if (count >= 0) {
                        httpOutput._bytes.setCount(count);
                    }
                } else if (i6 != 2) {
                    throw new IllegalStateException();
                } else {
                    byte[] buf2 = httpOutput._bytes.getBuf();
                    int count2 = httpOutput._bytes.getCount();
                    if (count2 + i5 > buf2.length) {
                        i5 = buf2.length - count2;
                    }
                    int i9 = 0;
                    while (i9 < i5) {
                        char c2 = cArr[i + i9];
                        if (this._surrogate == 0) {
                            boolean isHighSurrogate = Character.isHighSurrogate(c2);
                            i3 = c2;
                            if (isHighSurrogate) {
                                this._surrogate = c2;
                                i9++;
                            }
                        } else {
                            char c3 = c2;
                            if (Character.isLowSurrogate(c3)) {
                                i3 = Character.toCodePoint((char) this._surrogate, c3);
                            } else {
                                int i10 = this._surrogate;
                                this._surrogate = 0;
                                i9--;
                                i3 = i10;
                            }
                        }
                        if ((i3 & (-128)) != 0) {
                            if ((i3 & (-2048)) != 0) {
                                if (((-65536) & i3) != 0) {
                                    if (((-14680064) & i3) != 0) {
                                        if (((-201326592) & i3) != 0) {
                                            if ((Integer.MIN_VALUE & i3) != 0) {
                                                buf2[count2] = 63;
                                                count2++;
                                            } else if (count2 + 6 <= buf2.length) {
                                                int i11 = count2 + 1;
                                                buf2[count2] = (byte) ((i3 >> 30) | TinkerReport.KEY_LOADED_EXCEPTION_DEX);
                                                int i12 = i11 + 1;
                                                buf2[i11] = (byte) (((i3 >> 24) & 63) | 128);
                                                int i13 = i12 + 1;
                                                buf2[i12] = (byte) (((i3 >> 18) & 63) | 128);
                                                int i14 = i13 + 1;
                                                buf2[i13] = (byte) (((i3 >> 12) & 63) | 128);
                                                int i15 = i14 + 1;
                                                buf2[i14] = (byte) (((i3 >> 6) & 63) | 128);
                                                count2 = i15 + 1;
                                                buf2[i15] = (byte) ((i3 & 63) | 128);
                                            }
                                            this._surrogate = 0;
                                            if (count2 == buf2.length) {
                                            }
                                        } else if (count2 + 5 <= buf2.length) {
                                            int i16 = count2 + 1;
                                            buf2[count2] = (byte) ((i3 >> 24) | 248);
                                            int i17 = i16 + 1;
                                            buf2[i16] = (byte) (((i3 >> 18) & 63) | 128);
                                            int i18 = i17 + 1;
                                            buf2[i17] = (byte) (((i3 >> 12) & 63) | 128);
                                            int i19 = i18 + 1;
                                            buf2[i18] = (byte) (((i3 >> 6) & 63) | 128);
                                            i4 = i19 + 1;
                                            buf2[i19] = (byte) ((i3 & 63) | 128);
                                            count2 = i4;
                                            this._surrogate = 0;
                                            if (count2 == buf2.length) {
                                            }
                                        }
                                        i5 = i9;
                                        break;
                                    } else if (count2 + 4 > buf2.length) {
                                        i5 = i9;
                                        break;
                                    } else {
                                        int i20 = count2 + 1;
                                        buf2[count2] = (byte) ((i3 >> 18) | TbsListener.ErrorCode.TPATCH_VERSION_FAILED);
                                        int i21 = i20 + 1;
                                        buf2[i20] = (byte) (((i3 >> 12) & 63) | 128);
                                        int i22 = i21 + 1;
                                        buf2[i21] = (byte) (((i3 >> 6) & 63) | 128);
                                        count2 = i22 + 1;
                                        buf2[i22] = (byte) ((i3 & 63) | 128);
                                        this._surrogate = 0;
                                        if (count2 == buf2.length) {
                                        }
                                    }
                                } else if (count2 + 3 > buf2.length) {
                                    i5 = i9;
                                    break;
                                } else {
                                    int i23 = count2 + 1;
                                    buf2[count2] = (byte) ((i3 >> 12) | TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
                                    int i24 = i23 + 1;
                                    buf2[i23] = (byte) (((i3 >> 6) & 63) | 128);
                                    i4 = i24 + 1;
                                    buf2[i24] = (byte) ((i3 & 63) | 128);
                                    count2 = i4;
                                    this._surrogate = 0;
                                    if (count2 == buf2.length) {
                                    }
                                }
                            } else if (count2 + 2 > buf2.length) {
                                i5 = i9;
                                break;
                            } else {
                                int i25 = count2 + 1;
                                buf2[count2] = (byte) ((i3 >> 6) | 192);
                                count2 = i25 + 1;
                                buf2[i25] = (byte) ((i3 & 63) | 128);
                                this._surrogate = 0;
                                if (count2 == buf2.length) {
                                    i9++;
                                    i5 = i9;
                                    break;
                                }
                                i9++;
                            }
                        } else if (count2 >= buf2.length) {
                            i5 = i9;
                            break;
                        } else {
                            buf2[count2] = (byte) i3;
                            count2++;
                            i9++;
                        }
                    }
                    httpOutput._bytes.setCount(count2);
                }
            } else {
                Writer converter = getConverter();
                converter.write(cArr, i, i5);
                converter.flush();
            }
            httpOutput._bytes.writeTo(httpOutput);
            i2 -= i5;
            i += i5;
        }
    }
}

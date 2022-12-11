package org.seamless.util.p061io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import me.tvspark.outline;
import org.eclipse.jetty.http.HttpTokens;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.regexp.NativeRegExp;

/* renamed from: org.seamless.util.io.Base64Coder */
/* loaded from: classes5.dex */
public class Base64Coder {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DECODE = 0;
    public static final int DONT_GUNZIP = 4;
    public static final int DO_BREAK_LINES = 8;
    public static final int ENCODE = 1;
    public static final byte EQUALS_SIGN_ENC = -1;
    public static final int GZIP = 2;
    public static final int MAX_LINE_LENGTH = 76;
    public static final byte NEW_LINE = 10;
    public static final int NO_OPTIONS = 0;
    public static final int ORDERED = 32;
    public static final String PREFERRED_ENCODING = "US-ASCII";
    public static final int URL_SAFE = 16;
    public static final byte WHITE_SPACE_ENC = -5;
    public static final byte[] _STANDARD_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, NativeJavaObject.CONVERSION_NONE, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_ENDCHILD, 50, NativeRegExp.REOP_REPEAT, NativeRegExp.REOP_MINIMALREPEAT, NativeRegExp.REOP_ALTPREREQ, NativeRegExp.REOP_ALTPREREQi, NativeRegExp.REOP_ALTPREREQ2, 56, NativeRegExp.REOP_END, NativeRegExp.REOP_ASSERTTEST, NativeRegExp.REOP_MINIMALOPT};
    public static final byte EQUALS_SIGN = 61;
    public static final byte[] _STANDARD_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, NativeRegExp.REOP_MINIMALREPEAT, NativeRegExp.REOP_ALTPREREQ, NativeRegExp.REOP_ALTPREREQi, NativeRegExp.REOP_ALTPREREQ2, 56, NativeRegExp.REOP_END, HttpTokens.COLON, HttpTokens.SEMI_COLON, 60, EQUALS_SIGN, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, NativeRegExp.REOP_FLAT1i, 18, NativeRegExp.REOP_UCFLAT1i, 20, 21, NativeRegExp.REOP_CLASS, 23, 24, NativeRegExp.REOP_QUANT, -9, -9, -9, -9, -9, -9, NativeRegExp.REOP_STAR, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_OPT, NativeRegExp.REOP_LPAREN, NativeRegExp.REOP_RPAREN, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, NativeRegExp.REOP_ASSERT, 42, NativeRegExp.REOP_ASSERTTEST, NativeRegExp.REOP_ASSERTNOTTEST, 45, NativeRegExp.REOP_MINIMALPLUS, NativeRegExp.REOP_MINIMALOPT, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_ENDCHILD, 50, NativeRegExp.REOP_REPEAT, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    public static final byte[] _URL_SAFE_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, NativeJavaObject.CONVERSION_NONE, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_ENDCHILD, 50, NativeRegExp.REOP_REPEAT, NativeRegExp.REOP_MINIMALREPEAT, NativeRegExp.REOP_ALTPREREQ, NativeRegExp.REOP_ALTPREREQi, NativeRegExp.REOP_ALTPREREQ2, 56, NativeRegExp.REOP_END, 45, 95};
    public static final byte[] _URL_SAFE_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, NativeRegExp.REOP_MINIMALREPEAT, NativeRegExp.REOP_ALTPREREQ, NativeRegExp.REOP_ALTPREREQi, NativeRegExp.REOP_ALTPREREQ2, 56, NativeRegExp.REOP_END, HttpTokens.COLON, HttpTokens.SEMI_COLON, 60, EQUALS_SIGN, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, NativeRegExp.REOP_FLAT1i, 18, NativeRegExp.REOP_UCFLAT1i, 20, 21, NativeRegExp.REOP_CLASS, 23, 24, NativeRegExp.REOP_QUANT, -9, -9, -9, -9, 63, -9, NativeRegExp.REOP_STAR, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_OPT, NativeRegExp.REOP_LPAREN, NativeRegExp.REOP_RPAREN, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, NativeRegExp.REOP_ASSERT, 42, NativeRegExp.REOP_ASSERTTEST, NativeRegExp.REOP_ASSERTNOTTEST, 45, NativeRegExp.REOP_MINIMALPLUS, NativeRegExp.REOP_MINIMALOPT, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_ENDCHILD, 50, NativeRegExp.REOP_REPEAT, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    public static final byte[] _ORDERED_ALPHABET = {45, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_ENDCHILD, 50, NativeRegExp.REOP_REPEAT, NativeRegExp.REOP_MINIMALREPEAT, NativeRegExp.REOP_ALTPREREQ, NativeRegExp.REOP_ALTPREREQi, NativeRegExp.REOP_ALTPREREQ2, 56, NativeRegExp.REOP_END, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, NativeJavaObject.CONVERSION_NONE, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    public static final byte[] _ORDERED_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, NativeRegExp.REOP_FLAT1i, 18, NativeRegExp.REOP_UCFLAT1i, 20, 21, NativeRegExp.REOP_CLASS, 23, 24, NativeRegExp.REOP_QUANT, NativeRegExp.REOP_STAR, NativeRegExp.REOP_PLUS, NativeRegExp.REOP_OPT, NativeRegExp.REOP_LPAREN, NativeRegExp.REOP_RPAREN, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, NativeRegExp.REOP_ASSERT, 42, NativeRegExp.REOP_ASSERTTEST, NativeRegExp.REOP_ASSERTNOTTEST, 45, NativeRegExp.REOP_MINIMALPLUS, NativeRegExp.REOP_MINIMALOPT, NativeRegExp.REOP_MINIMALQUANT, NativeRegExp.REOP_ENDCHILD, 50, NativeRegExp.REOP_REPEAT, NativeRegExp.REOP_MINIMALREPEAT, NativeRegExp.REOP_ALTPREREQ, NativeRegExp.REOP_ALTPREREQi, NativeRegExp.REOP_ALTPREREQ2, 56, NativeRegExp.REOP_END, HttpTokens.COLON, HttpTokens.SEMI_COLON, 60, EQUALS_SIGN, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: org.seamless.util.io.Base64Coder$InputStream */
    /* loaded from: classes5.dex */
    public static class InputStream extends FilterInputStream {
        public boolean breakLines;
        public byte[] buffer;
        public int bufferLength;
        public byte[] decodabet;
        public boolean encode;
        public int lineLength;
        public int numSigBytes;
        public int options;
        public int position;

        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, 0);
        }

        public InputStream(java.io.InputStream inputStream, int i) {
            super(inputStream);
            this.options = i;
            boolean z = true;
            this.breakLines = (i & 8) > 0;
            z = (i & 1) <= 0 ? false : z;
            this.encode = z;
            int i2 = z ? 4 : 3;
            this.bufferLength = i2;
            this.buffer = new byte[i2];
            this.position = -1;
            this.lineLength = 0;
            this.decodabet = Base64Coder.getDecodabet(i);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read;
            if (this.position < 0) {
                if (this.encode) {
                    byte[] bArr = new byte[3];
                    int i = 0;
                    for (int i2 = 0; i2 < 3; i2++) {
                        int read2 = ((FilterInputStream) this).in.read();
                        if (read2 < 0) {
                            break;
                        }
                        bArr[i2] = (byte) read2;
                        i++;
                    }
                    if (i <= 0) {
                        return -1;
                    }
                    Base64Coder.encode3to4(bArr, 0, i, this.buffer, 0, this.options);
                    this.position = 0;
                    this.numSigBytes = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i3 = 0;
                    while (i3 < 4) {
                        do {
                            read = ((FilterInputStream) this).in.read();
                            if (read < 0) {
                                break;
                            }
                        } while (this.decodabet[read & 127] <= -5);
                        if (read < 0) {
                            break;
                        }
                        bArr2[i3] = (byte) read;
                        i3++;
                    }
                    if (i3 != 4) {
                        if (i3 != 0) {
                            throw new IOException("Improperly padded Base64 input.");
                        }
                        return -1;
                    }
                    this.numSigBytes = Base64Coder.decode4to3(bArr2, 0, this.buffer, 0, this.options);
                    this.position = 0;
                }
            }
            int i4 = this.position;
            if (i4 >= 0) {
                if (i4 >= this.numSigBytes) {
                    return -1;
                }
                if (this.encode && this.breakLines && this.lineLength >= 76) {
                    this.lineLength = 0;
                    return 10;
                }
                this.lineLength++;
                byte[] bArr3 = this.buffer;
                int i5 = this.position;
                int i6 = i5 + 1;
                this.position = i6;
                byte b = bArr3[i5];
                if (i6 >= this.bufferLength) {
                    this.position = -1;
                }
                return b & 255;
            }
            throw new IOException("Error in Base64 code reading stream.");
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                int read = read();
                if (read >= 0) {
                    bArr[i + i3] = (byte) read;
                    i3++;
                } else if (i3 == 0) {
                    return -1;
                }
            }
            return i3;
        }
    }

    /* renamed from: org.seamless.util.io.Base64Coder$OutputStream */
    /* loaded from: classes5.dex */
    public static class OutputStream extends FilterOutputStream {

        /* renamed from: b4 */
        public byte[] f5003b4;
        public boolean breakLines;
        public byte[] buffer;
        public int bufferLength;
        public byte[] decodabet;
        public boolean encode;
        public int lineLength;
        public int options;
        public int position;
        public boolean suspendEncoding;

        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, 1);
        }

        public OutputStream(java.io.OutputStream outputStream, int i) {
            super(outputStream);
            boolean z = true;
            this.breakLines = (i & 8) != 0;
            z = (i & 1) == 0 ? false : z;
            this.encode = z;
            int i2 = z ? 3 : 4;
            this.bufferLength = i2;
            this.buffer = new byte[i2];
            this.position = 0;
            this.lineLength = 0;
            this.suspendEncoding = false;
            this.f5003b4 = new byte[4];
            this.options = i;
            this.decodabet = Base64Coder.getDecodabet(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            flushBase64();
            super.close();
            this.buffer = null;
            ((FilterOutputStream) this).out = null;
        }

        public void flushBase64() throws IOException {
            int i = this.position;
            if (i > 0) {
                if (!this.encode) {
                    throw new IOException("Base64 input not properly padded.");
                }
                ((FilterOutputStream) this).out.write(Base64Coder.encode3to4(this.f5003b4, this.buffer, i, this.options));
                this.position = 0;
            }
        }

        public void resumeEncoding() {
            this.suspendEncoding = false;
        }

        public void suspendEncoding() throws IOException {
            flushBase64();
            this.suspendEncoding = true;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.suspendEncoding) {
                ((FilterOutputStream) this).out.write(i);
                return;
            }
            if (this.encode) {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) i;
                int i4 = this.bufferLength;
                if (i3 < i4) {
                    return;
                }
                ((FilterOutputStream) this).out.write(Base64Coder.encode3to4(this.f5003b4, bArr, i4, this.options));
                int i5 = this.lineLength + 4;
                this.lineLength = i5;
                if (this.breakLines && i5 >= 76) {
                    ((FilterOutputStream) this).out.write(10);
                    this.lineLength = 0;
                }
            } else {
                byte[] bArr2 = this.decodabet;
                int i6 = i & 127;
                if (bArr2[i6] <= -5) {
                    if (bArr2[i6] != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr3 = this.buffer;
                int i7 = this.position;
                int i8 = i7 + 1;
                this.position = i8;
                bArr3[i7] = (byte) i;
                if (i8 < this.bufferLength) {
                    return;
                }
                ((FilterOutputStream) this).out.write(this.f5003b4, 0, Base64Coder.decode4to3(bArr3, 0, this.f5003b4, 0, this.options));
            }
            this.position = 0;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.suspendEncoding) {
                ((FilterOutputStream) this).out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }
    }

    public static byte[] decode(String str) throws IOException {
        return decode(str, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0059 -> B:30:0x0059). Please submit an issue!!! */
    public static byte[] decode(String str, int i) throws IOException {
        byte[] bytes;
        ?? length;
        GZIPInputStream gZIPInputStream;
        if (str != null) {
            try {
                bytes = str.getBytes("US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                bytes = str.getBytes();
            }
            byte[] decode = decode(bytes, 0, bytes.length, i);
            boolean z = (i & 4) != 0;
            if (decode != null && (length = decode.length) >= 4 && !z && 35615 == ((decode[0] & 255) | ((decode[1] << 8) & 65280))) {
                byte[] bArr = new byte[2048];
                ByteArrayOutputStream byteArrayOutputStream = null;
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            length = new ByteArrayInputStream(decode);
                            try {
                                gZIPInputStream = new GZIPInputStream(length);
                                while (true) {
                                    try {
                                        int read = gZIPInputStream.read(bArr);
                                        if (read < 0) {
                                            break;
                                        }
                                        byteArrayOutputStream2.write(bArr, 0, read);
                                    } catch (IOException e) {
                                        e = e;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        length = length;
                                        try {
                                            e.printStackTrace();
                                            byteArrayOutputStream.close();
                                            gZIPInputStream.close();
                                            length.close();
                                            return decode;
                                        } catch (Throwable th) {
                                            th = th;
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception unused2) {
                                            }
                                            try {
                                                gZIPInputStream.close();
                                            } catch (Exception unused3) {
                                            }
                                            try {
                                                length.close();
                                            } catch (Exception unused4) {
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        byteArrayOutputStream.close();
                                        gZIPInputStream.close();
                                        length.close();
                                        throw th;
                                    }
                                }
                                decode = byteArrayOutputStream2.toByteArray();
                                byteArrayOutputStream2.close();
                            } catch (IOException e2) {
                                e = e2;
                                gZIPInputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                gZIPInputStream = null;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            length = 0;
                            gZIPInputStream = null;
                        } catch (Throwable th4) {
                            th = th4;
                            length = 0;
                            gZIPInputStream = null;
                        }
                    } catch (Exception unused5) {
                    }
                } catch (IOException e4) {
                    e = e4;
                    length = 0;
                    gZIPInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    length = 0;
                    gZIPInputStream = null;
                }
                try {
                    gZIPInputStream.close();
                } catch (Exception unused6) {
                }
                try {
                    length.close();
                } catch (Exception unused7) {
                }
            }
            return decode;
        }
        throw new NullPointerException("Input string was null.");
    }

    public static byte[] decode(byte[] bArr) throws IOException {
        return decode(bArr, 0, bArr.length, 0);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) throws IOException {
        int i4;
        if (bArr != null) {
            if (i < 0 || (i4 = i + i2) > bArr.length) {
                throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            if (i2 == 0) {
                return new byte[0];
            }
            if (i2 < 4) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Base64-encoded string must have at least four characters, but length specified was ", i2));
            }
            byte[] decodabet = getDecodabet(i3);
            byte[] bArr2 = new byte[(i2 * 3) / 4];
            byte[] bArr3 = new byte[4];
            int i5 = 0;
            int i6 = 0;
            while (i < i4) {
                byte b = decodabet[bArr[i] & 255];
                if (b < -5) {
                    throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i] & 255), Integer.valueOf(i)));
                }
                if (b >= -1) {
                    int i7 = i5 + 1;
                    bArr3[i5] = bArr[i];
                    if (i7 > 3) {
                        i6 += decode4to3(bArr3, 0, bArr2, i6, i3);
                        if (bArr[i] == 61) {
                            break;
                        }
                        i5 = 0;
                    } else {
                        i5 = i7;
                    }
                }
                i++;
            }
            byte[] bArr4 = new byte[i6];
            System.arraycopy(bArr2, 0, bArr4, 0, i6);
            return bArr4;
        }
        throw new NullPointerException("Cannot decode null source array.");
    }

    public static int decode4to3(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4;
        int i5;
        if (bArr != null) {
            if (bArr2 == null) {
                throw new NullPointerException("Destination array was null.");
            }
            if (i < 0 || (i4 = i + 3) >= bArr.length) {
                throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
            }
            if (i2 < 0 || (i5 = i2 + 2) >= bArr2.length) {
                throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
            }
            byte[] decodabet = getDecodabet(i3);
            int i6 = i + 2;
            if (bArr[i6] == 61) {
                bArr2[i2] = (byte) ((((decodabet[bArr[i + 1]] & 255) << 12) | ((decodabet[bArr[i]] & 255) << 18)) >>> 16);
                return 1;
            } else if (bArr[i4] == 61) {
                int i7 = ((decodabet[bArr[i6]] & 255) << 6) | ((decodabet[bArr[i + 1]] & 255) << 12) | ((decodabet[bArr[i]] & 255) << 18);
                bArr2[i2] = (byte) (i7 >>> 16);
                bArr2[i2 + 1] = (byte) (i7 >>> 8);
                return 2;
            } else {
                int i8 = (decodabet[bArr[i4]] & 255) | ((decodabet[bArr[i + 1]] & 255) << 12) | ((decodabet[bArr[i]] & 255) << 18) | ((decodabet[bArr[i6]] & 255) << 6);
                bArr2[i2] = (byte) (i8 >> 16);
                bArr2[i2 + 1] = (byte) (i8 >> 8);
                bArr2[i5] = (byte) i8;
                return 3;
            }
        }
        throw new NullPointerException("Source array was null.");
    }

    public static void decodeFileToFile(String str, String str2) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        byte[] decodeFromFile = decodeFromFile(str);
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedOutputStream.write(decodeFromFile);
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused) {
                }
            } catch (IOException e) {
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e2) {
            throw e2;
        }
    }

    public static byte[] decodeFromFile(String str) throws IOException {
        InputStream inputStream = null;
        try {
            try {
                File file = new File(str);
                if (file.length() > 2147483647L) {
                    throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
                }
                byte[] bArr = new byte[(int) file.length()];
                InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 0);
                int i = 0;
                while (true) {
                    try {
                        int read = inputStream2.read(bArr, i, 4096);
                        if (read < 0) {
                            break;
                        }
                        i += read;
                    } catch (IOException e) {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                try {
                    inputStream2.close();
                } catch (Exception unused2) {
                }
                return bArr2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            throw e2;
        }
    }

    public static String decodeString(String str) {
        try {
            return new String(decode(str));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void decodeToFile(String str, String str2) throws IOException {
        OutputStream outputStream;
        OutputStream outputStream2 = null;
        try {
            try {
                outputStream = new OutputStream(new FileOutputStream(str2), 0);
            } catch (IOException e) {
                throw e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            outputStream.write(str.getBytes("US-ASCII"));
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        } catch (IOException e2) {
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            try {
                outputStream2.close();
            } catch (Exception unused2) {
            }
            throw th;
        }
    }

    public static Object decodeToObject(String str) throws IOException, ClassNotFoundException {
        return decodeToObject(str, 0, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.ClassLoader] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    public static Object decodeToObject(String str, int i, final ClassLoader classLoader) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream;
        byte[] decode = decode(str, i);
        ByteArrayInputStream byteArrayInputStream2 = null;
        r2 = null;
        r2 = null;
        ObjectInputStream objectInputStream = null;
        byteArrayInputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(decode);
            } catch (Throwable th) {
                th = th;
            }
            try {
                objectInputStream = classLoader == 0 ? new ObjectInputStream(byteArrayInputStream) : new ObjectInputStream(byteArrayInputStream) { // from class: org.seamless.util.io.Base64Coder.1
                    @Override // java.io.ObjectInputStream
                    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
                        Class<?> cls = Class.forName(objectStreamClass.getName(), false, classLoader);
                        return cls == null ? super.resolveClass(objectStreamClass) : cls;
                    }
                };
                Object readObject = objectInputStream.readObject();
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused) {
                }
                try {
                    objectInputStream.close();
                } catch (Exception unused2) {
                }
                return readObject;
            } catch (IOException e) {
                e = e;
                throw e;
            } catch (ClassNotFoundException e2) {
                e = e2;
                throw e;
            } catch (Throwable th2) {
                th = th2;
                classLoader = objectInputStream;
                byteArrayInputStream2 = byteArrayInputStream;
                try {
                    byteArrayInputStream2.close();
                } catch (Exception unused3) {
                }
                try {
                    classLoader.close();
                } catch (Exception unused4) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (ClassNotFoundException e4) {
            e = e4;
        } catch (Throwable th3) {
            th = th3;
            classLoader = 0;
        }
    }

    public static void encode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            encode3to4(bArr2, bArr, min, 0);
            byteBuffer2.put(bArr2);
        }
    }

    public static void encode(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            encode3to4(bArr2, bArr, min, 0);
            for (int i = 0; i < 4; i++) {
                charBuffer.put((char) (bArr2[i] & 255));
            }
        }
    }

    public static byte[] encode(byte[] bArr) {
        return encodeBytes(bArr).getBytes();
    }

    public static byte[] encode3to4(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] alphabet = getAlphabet(i4);
        int i5 = 0;
        int i6 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0);
        if (i2 > 2) {
            i5 = (bArr[i + 2] << 24) >>> 24;
        }
        int i7 = i6 | i5;
        if (i2 == 1) {
            bArr2[i3] = alphabet[i7 >>> 18];
            bArr2[i3 + 1] = alphabet[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = EQUALS_SIGN;
            bArr2[i3 + 3] = EQUALS_SIGN;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = alphabet[i7 >>> 18];
            bArr2[i3 + 1] = alphabet[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = alphabet[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = EQUALS_SIGN;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = alphabet[i7 >>> 18];
            bArr2[i3 + 1] = alphabet[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = alphabet[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = alphabet[i7 & 63];
            return bArr2;
        }
    }

    public static byte[] encode3to4(byte[] bArr, byte[] bArr2, int i, int i2) {
        encode3to4(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    public static String encodeBytes(byte[] bArr) {
        try {
            return encodeBytes(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String encodeBytes(byte[] bArr, int i) throws IOException {
        return encodeBytes(bArr, 0, bArr.length, i);
    }

    public static String encodeBytes(byte[] bArr, int i, int i2) {
        try {
            return encodeBytes(bArr, i, i2, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String encodeBytes(byte[] bArr, int i, int i2, int i3) throws IOException {
        byte[] encodeBytesToBytes = encodeBytesToBytes(bArr, i, i2, i3);
        try {
            return new String(encodeBytesToBytes, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(encodeBytesToBytes);
        }
    }

    public static byte[] encodeBytesToBytes(byte[] bArr) {
        try {
            return encodeBytesToBytes(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.OutputStream, org.seamless.util.io.Base64Coder$OutputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [org.seamless.util.io.Base64Coder$OutputStream] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static byte[] encodeBytesToBytes(byte[] bArr, int i, int i2, int i3) throws IOException {
        ?? r2;
        ?? r3;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2;
        if (bArr != null) {
            if (i < 0) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot have negative offset: ", i));
            }
            if (i2 < 0) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot have length offset: ", i2));
            }
            if (i + i2 > bArr.length) {
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
            }
            if ((i3 & 2) == 0) {
                boolean z = (i3 & 8) != 0;
                int i4 = ((i2 / 3) * 4) + (i2 % 3 > 0 ? 4 : 0);
                if (z) {
                    i4 += i4 / 76;
                }
                int i5 = i4;
                byte[] bArr2 = new byte[i5];
                int i6 = i2 - 2;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                while (i7 < i6) {
                    encode3to4(bArr, i7 + i, 3, bArr2, i8, i3);
                    int i10 = i9 + 4;
                    if (!z || i10 < 76) {
                        i9 = i10;
                    } else {
                        bArr2[i8 + 4] = 10;
                        i8++;
                        i9 = 0;
                    }
                    i7 += 3;
                    i8 += 4;
                }
                if (i7 < i2) {
                    encode3to4(bArr, i7 + i, i2 - i7, bArr2, i8, i3);
                    i8 += 4;
                }
                if (i8 > i5 - 1) {
                    return bArr2;
                }
                byte[] bArr3 = new byte[i8];
                System.arraycopy(bArr2, 0, bArr3, 0, i8);
                return bArr3;
            }
            GZIPOutputStream gZIPOutputStream3 = null;
            try {
                r2 = new ByteArrayOutputStream();
                try {
                    r3 = new OutputStream(r2, i3 | 1);
                    try {
                        gZIPOutputStream2 = new GZIPOutputStream(r3);
                    } catch (IOException e) {
                        e = e;
                        gZIPOutputStream2 = null;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            gZIPOutputStream3.close();
                        } catch (Exception unused) {
                        }
                        try {
                            r3.close();
                        } catch (Exception unused2) {
                        }
                        try {
                            r2.close();
                        } catch (Exception unused3) {
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    gZIPOutputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    r3 = 0;
                }
            } catch (IOException e3) {
                e = e3;
                gZIPOutputStream = null;
                gZIPOutputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                r2 = 0;
                r3 = 0;
            }
            try {
                gZIPOutputStream2.write(bArr, i, i2);
                gZIPOutputStream2.close();
                try {
                    gZIPOutputStream2.close();
                } catch (Exception unused4) {
                }
                try {
                    r3.close();
                } catch (Exception unused5) {
                }
                try {
                    r2.close();
                } catch (Exception unused6) {
                }
                return r2.toByteArray();
            } catch (IOException e4) {
                e = e4;
                gZIPOutputStream3 = r3;
                gZIPOutputStream = gZIPOutputStream3;
                gZIPOutputStream3 = r2;
                try {
                    throw e;
                } catch (Throwable th4) {
                    th = th4;
                    r3 = gZIPOutputStream;
                    r2 = gZIPOutputStream3;
                    gZIPOutputStream3 = gZIPOutputStream2;
                    gZIPOutputStream3.close();
                    r3.close();
                    r2.close();
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                gZIPOutputStream3 = gZIPOutputStream2;
                gZIPOutputStream3.close();
                r3.close();
                r2.close();
                throw th;
            }
        }
        throw new NullPointerException("Cannot serialize a null array.");
    }

    public static void encodeFileToFile(String str, String str2) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        String encodeFromFile = encodeFromFile(str);
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedOutputStream.write(encodeFromFile.getBytes("US-ASCII"));
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused) {
                }
            } catch (IOException e) {
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e2) {
            throw e2;
        }
    }

    public static String encodeFromFile(String str) throws IOException {
        InputStream inputStream = null;
        try {
            try {
                File file = new File(str);
                byte[] bArr = new byte[Math.max((int) ((file.length() * 1.4d) + 1.0d), 40)];
                InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 1);
                int i = 0;
                while (true) {
                    try {
                        int read = inputStream2.read(bArr, i, 4096);
                        if (read < 0) {
                            break;
                        }
                        i += read;
                    } catch (IOException e) {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                String str2 = new String(bArr, 0, i, "US-ASCII");
                try {
                    inputStream2.close();
                } catch (Exception unused2) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            throw e2;
        }
    }

    public static String encodeObject(Serializable serializable) throws IOException {
        return encodeObject(serializable, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v18, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static String encodeObject(Serializable serializable, int i) throws IOException {
        ?? r6;
        ?? r1;
        OutputStream outputStream;
        ObjectOutputStream objectOutputStream;
        if (serializable != null) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                r1 = new ByteArrayOutputStream();
                try {
                    outputStream = new OutputStream(r1, i | 1);
                    try {
                        if ((i & 2) != 0) {
                            r6 = new GZIPOutputStream(outputStream);
                            try {
                                objectOutputStream2 = new ObjectOutputStream(r6);
                                r6 = r6;
                            } catch (IOException e) {
                                e = e;
                                objectOutputStream = objectOutputStream2;
                                objectOutputStream2 = r1;
                                r6 = r6;
                                try {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    ObjectOutputStream objectOutputStream3 = objectOutputStream;
                                    r1 = objectOutputStream2;
                                    objectOutputStream2 = objectOutputStream3;
                                    try {
                                        objectOutputStream2.close();
                                    } catch (Exception unused) {
                                    }
                                    try {
                                        r6.close();
                                    } catch (Exception unused2) {
                                    }
                                    try {
                                        outputStream.close();
                                    } catch (Exception unused3) {
                                    }
                                    try {
                                        r1.close();
                                    } catch (Exception unused4) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                objectOutputStream2.close();
                                r6.close();
                                outputStream.close();
                                r1.close();
                                throw th;
                            }
                        } else {
                            objectOutputStream2 = new ObjectOutputStream(outputStream);
                            r6 = 0;
                        }
                        objectOutputStream2.writeObject(serializable);
                        try {
                            objectOutputStream2.close();
                        } catch (Exception unused5) {
                        }
                        try {
                            r6.close();
                        } catch (Exception unused6) {
                        }
                        try {
                            outputStream.close();
                        } catch (Exception unused7) {
                        }
                        try {
                            r1.close();
                        } catch (Exception unused8) {
                        }
                        try {
                            return new String(r1.toByteArray(), "US-ASCII");
                        } catch (UnsupportedEncodingException unused9) {
                            return new String(r1.toByteArray());
                        }
                    } catch (IOException e2) {
                        e = e2;
                        ObjectOutputStream objectOutputStream4 = objectOutputStream2;
                        objectOutputStream2 = r1;
                        objectOutputStream = objectOutputStream4;
                        r6 = objectOutputStream4;
                    } catch (Throwable th3) {
                        th = th3;
                        r6 = objectOutputStream2;
                    }
                } catch (IOException e3) {
                    e = e3;
                    r6 = 0;
                    outputStream = null;
                    objectOutputStream2 = r1;
                    objectOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    r6 = 0;
                    outputStream = null;
                }
            } catch (IOException e4) {
                e = e4;
                r6 = 0;
                objectOutputStream = null;
                outputStream = null;
            } catch (Throwable th5) {
                th = th5;
                r6 = 0;
                r1 = 0;
                outputStream = null;
            }
        } else {
            throw new NullPointerException("Cannot serialize a null object.");
        }
    }

    public static String encodeString(String str) {
        return encodeBytes(str.getBytes());
    }

    public static void encodeToFile(byte[] bArr, String str) throws IOException {
        OutputStream outputStream;
        if (bArr != null) {
            OutputStream outputStream2 = null;
            try {
                try {
                    outputStream = new OutputStream(new FileOutputStream(str), 1);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    outputStream.write(bArr);
                    try {
                        outputStream.close();
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (IOException e) {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    outputStream2 = outputStream;
                    try {
                        outputStream2.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e2) {
                throw e2;
            }
        }
        throw new NullPointerException("Data to encode was null.");
    }

    public static final byte[] getAlphabet(int i) {
        return (i & 16) == 16 ? _URL_SAFE_ALPHABET : (i & 32) == 32 ? _ORDERED_ALPHABET : _STANDARD_ALPHABET;
    }

    public static final byte[] getDecodabet(int i) {
        return (i & 16) == 16 ? _URL_SAFE_DECODABET : (i & 32) == 32 ? _ORDERED_DECODABET : _STANDARD_DECODABET;
    }
}

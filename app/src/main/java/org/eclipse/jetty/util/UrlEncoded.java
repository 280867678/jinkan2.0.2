package org.eclipse.jetty.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.message.TokenParser;
import org.eclipse.jetty.util.Utf8Appendable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.mozilla.javascript.regexp.NativeRegExp;

/* loaded from: classes5.dex */
public class UrlEncoded extends MultiMap implements Cloneable {
    public static final Logger LOG = Log.getLogger(UrlEncoded.class);
    public static final String ENCODING = System.getProperty("org.eclipse.jetty.util.UrlEncoding.charset", "UTF-8");

    public UrlEncoded() {
        super(6);
    }

    public UrlEncoded(String str) {
        super(6);
        decode(str, ENCODING);
    }

    public UrlEncoded(String str, String str2) {
        super(6);
        decode(str, str2);
    }

    public UrlEncoded(UrlEncoded urlEncoded) {
        super((MultiMap) urlEncoded);
    }

    public static void decode88591To(InputStream inputStream, MultiMap multiMap, int i, int i2) throws IOException {
        int read;
        int read2;
        int read3;
        synchronized (multiMap) {
            StringBuffer stringBuffer = new StringBuffer();
            String str = null;
            int i3 = 0;
            while (true) {
                int read4 = inputStream.read();
                if (read4 >= 0) {
                    char c = (char) read4;
                    if (c == '%') {
                        int read5 = inputStream.read();
                        if (117 == read5) {
                            int read6 = inputStream.read();
                            if (read6 >= 0 && (read2 = inputStream.read()) >= 0 && (read3 = inputStream.read()) >= 0) {
                                stringBuffer.append(Character.toChars((TypeUtil.convertHexDigit(read5) << 12) + (TypeUtil.convertHexDigit(read6) << 8) + (TypeUtil.convertHexDigit(read2) << 4) + TypeUtil.convertHexDigit(read3)));
                            }
                        } else if (read5 >= 0 && (read = inputStream.read()) >= 0) {
                            stringBuffer.append((char) ((TypeUtil.convertHexDigit(read5) << 4) + TypeUtil.convertHexDigit(read)));
                        }
                    } else if (c == '&') {
                        String stringBuffer2 = stringBuffer.length() == 0 ? "" : stringBuffer.toString();
                        stringBuffer.setLength(0);
                        if (str != null) {
                            multiMap.add(str, stringBuffer2);
                        } else if (stringBuffer2 != null && stringBuffer2.length() > 0) {
                            multiMap.add(stringBuffer2, "");
                        }
                        if (i2 > 0 && multiMap.size() > i2) {
                            throw new IllegalStateException(String.format("Form with too many keys [%d > %d]", Integer.valueOf(multiMap.size()), Integer.valueOf(i2)));
                        }
                        str = null;
                    } else if (c != '+') {
                        if (c == '=' && str == null) {
                            str = stringBuffer.toString();
                            stringBuffer.setLength(0);
                        }
                        stringBuffer.append(c);
                    } else {
                        stringBuffer.append(TokenParser.f4579SP);
                    }
                    if (i >= 0 && (i3 = i3 + 1) > i) {
                        throw new IllegalStateException("Form too large");
                    }
                } else if (str != null) {
                    String stringBuffer3 = stringBuffer.length() == 0 ? "" : stringBuffer.toString();
                    stringBuffer.setLength(0);
                    multiMap.add(str, stringBuffer3);
                } else if (stringBuffer.length() > 0) {
                    multiMap.add(stringBuffer.toString(), "");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x00e7, code lost:
        r0 = new java.lang.StringBuffer(r18);
        r0.append((java.lang.CharSequence) r16, r17, r15 + 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c7 A[Catch: UnsupportedEncodingException -> 0x00fd, LOOP:1: B:24:0x0051->B:41:0x00c7, LOOP_END, TryCatch #9 {UnsupportedEncodingException -> 0x00fd, blocks: (B:9:0x0026, B:15:0x0034, B:16:0x003c, B:18:0x00f1, B:21:0x0045, B:22:0x004d, B:31:0x0061, B:37:0x006d, B:41:0x00c7, B:49:0x00a2, B:53:0x008a, B:59:0x0095, B:63:0x00ac, B:64:0x00b3, B:66:0x00b9, B:67:0x00c1, B:68:0x00be, B:44:0x00d3, B:72:0x00e1, B:76:0x00e7, B:86:0x0103, B:89:0x010a, B:91:0x0111), top: B:8:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String decodeString(String str, int i, int i2, String str2) {
        int i3;
        int i4;
        Utf8StringBuffer utf8StringBuffer = null;
        StringBuffer stringBuffer = null;
        char c = TokenParser.f4579SP;
        char c2 = '%';
        char c3 = '+';
        char c4 = 255;
        if (str2 == null || StringUtil.isUTF8(str2)) {
            int i5 = 0;
            while (i5 < i2) {
                int i6 = i + i5;
                char charAt = str.charAt(i6);
                if (charAt < 0 || charAt > 255) {
                    if (utf8StringBuffer == null) {
                        utf8StringBuffer = new Utf8StringBuffer(i2);
                        utf8StringBuffer.getStringBuffer().append((CharSequence) str, i, i6 + 1);
                    }
                    utf8StringBuffer.getStringBuffer().append(charAt);
                } else if (charAt == '+') {
                    if (utf8StringBuffer == null) {
                        utf8StringBuffer = new Utf8StringBuffer(i2);
                        utf8StringBuffer.getStringBuffer().append((CharSequence) str, i, i6);
                    }
                    utf8StringBuffer.getStringBuffer().append(TokenParser.f4579SP);
                } else if (charAt == '%') {
                    if (utf8StringBuffer == null) {
                        utf8StringBuffer = new Utf8StringBuffer(i2);
                        utf8StringBuffer.getStringBuffer().append((CharSequence) str, i, i6);
                    }
                    Utf8StringBuffer utf8StringBuffer2 = utf8StringBuffer;
                    int i7 = i5 + 2;
                    if (i7 < i2) {
                        int i8 = i6 + 1;
                        try {
                            if ('u' == str.charAt(i8)) {
                                i5 += 5;
                                if (i5 < i2) {
                                    utf8StringBuffer2.getStringBuffer().append(new String(Character.toChars(TypeUtil.parseInt(str, i6 + 2, 4, 16))));
                                } else {
                                    try {
                                        utf8StringBuffer2.getStringBuffer().append((char) 65533);
                                        i5 = i2;
                                    } catch (NumberFormatException e) {
                                        e = e;
                                        i5 = i2;
                                        LOG.debug(e);
                                        utf8StringBuffer2.getStringBuffer().append((char) 65533);
                                        utf8StringBuffer = utf8StringBuffer2;
                                        i5++;
                                    } catch (Utf8Appendable.NotUtf8Exception e2) {
                                        e = e2;
                                        i5 = i2;
                                        LOG.warn(e.toString(), new Object[0]);
                                        LOG.debug(e);
                                        utf8StringBuffer = utf8StringBuffer2;
                                        i5++;
                                    }
                                }
                            } else {
                                try {
                                    utf8StringBuffer2.append((byte) TypeUtil.parseInt(str, i8, 2, 16));
                                    i5 = i7;
                                } catch (NumberFormatException e3) {
                                    e = e3;
                                    i5 = i7;
                                    LOG.debug(e);
                                    utf8StringBuffer2.getStringBuffer().append((char) 65533);
                                    utf8StringBuffer = utf8StringBuffer2;
                                    i5++;
                                } catch (Utf8Appendable.NotUtf8Exception e4) {
                                    e = e4;
                                    i5 = i7;
                                    LOG.warn(e.toString(), new Object[0]);
                                    LOG.debug(e);
                                    utf8StringBuffer = utf8StringBuffer2;
                                    i5++;
                                }
                            }
                        } catch (NumberFormatException e5) {
                            e = e5;
                        } catch (Utf8Appendable.NotUtf8Exception e6) {
                            e = e6;
                        }
                    } else {
                        utf8StringBuffer2.getStringBuffer().append((char) 65533);
                        i5 = i2;
                    }
                    utf8StringBuffer = utf8StringBuffer2;
                } else {
                    if (utf8StringBuffer == null) {
                    }
                    utf8StringBuffer.getStringBuffer().append(charAt);
                }
                i5++;
            }
            return utf8StringBuffer == null ? (i == 0 && str.length() == i2) ? str : str.substring(i, i + i2) : utf8StringBuffer.toReplacedString();
        }
        int i9 = 0;
        while (i9 < i2) {
            int i10 = i + i9;
            try {
                char charAt2 = str.charAt(i10);
                if (charAt2 >= 0 && charAt2 <= c4) {
                    if (charAt2 == c3) {
                        if (stringBuffer == null) {
                            stringBuffer = new StringBuffer(i2);
                            stringBuffer.append((CharSequence) str, i, i10);
                        }
                        stringBuffer.append(c);
                    } else if (charAt2 == c2) {
                        if (stringBuffer == null) {
                            stringBuffer = new StringBuffer(i2);
                            stringBuffer.append((CharSequence) str, i, i10);
                        }
                        StringBuffer stringBuffer2 = stringBuffer;
                        byte[] bArr = new byte[i2];
                        int i11 = 0;
                        while (charAt2 >= 0 && charAt2 <= c4) {
                            if (charAt2 == c2) {
                                if (i9 + 2 < i2) {
                                    int i12 = i + i9;
                                    int i13 = i12 + 1;
                                    try {
                                        if ('u' == str.charAt(i13)) {
                                            i4 = i9 + 6;
                                            if (i4 < i2) {
                                                try {
                                                    byte[] bytes = new String(Character.toChars(TypeUtil.parseInt(str, i12 + 2, 4, 16))).getBytes(str2);
                                                    System.arraycopy(bytes, 0, bArr, i11, bytes.length);
                                                    i11 += bytes.length;
                                                } catch (NumberFormatException e7) {
                                                    e = e7;
                                                    i9 = i4;
                                                    LOG.ignore(e);
                                                    i3 = i11 + 1;
                                                    bArr[i11] = 63;
                                                    i11 = i3;
                                                    if (i9 < i2) {
                                                    }
                                                }
                                            } else {
                                                int i14 = i11 + 1;
                                                try {
                                                    bArr[i11] = 63;
                                                    i11 = i14;
                                                    i4 = i2;
                                                } catch (NumberFormatException e8) {
                                                    e = e8;
                                                    i11 = i14;
                                                    LOG.ignore(e);
                                                    i3 = i11 + 1;
                                                    bArr[i11] = 63;
                                                    i11 = i3;
                                                    if (i9 < i2) {
                                                    }
                                                }
                                            }
                                        } else {
                                            int i15 = i9 + 3;
                                            bArr[i11] = (byte) TypeUtil.parseInt(str, i13, 2, 16);
                                            i11++;
                                            i4 = i15;
                                        }
                                        i9 = i4;
                                    } catch (NumberFormatException e9) {
                                        e = e9;
                                    }
                                } else {
                                    bArr[i11] = 63;
                                    i11++;
                                    i9 = i2;
                                }
                                if (i9 < i2) {
                                    break;
                                }
                                charAt2 = str.charAt(i + i9);
                                c2 = '%';
                                c4 = 255;
                            } else {
                                i3 = i11 + 1;
                                if (charAt2 == '+') {
                                    bArr[i11] = 32;
                                } else {
                                    bArr[i11] = (byte) charAt2;
                                }
                                i9++;
                            }
                            i11 = i3;
                            if (i9 < i2) {
                            }
                        }
                        i9--;
                        stringBuffer2.append(new String(bArr, 0, i11, str2));
                        stringBuffer = stringBuffer2;
                    } else {
                        if (stringBuffer == null) {
                        }
                        stringBuffer.append(charAt2);
                    }
                    i9++;
                    c = TokenParser.f4579SP;
                    c2 = '%';
                    c3 = '+';
                    c4 = 255;
                }
                stringBuffer.append(charAt2);
                i9++;
                c = TokenParser.f4579SP;
                c2 = '%';
                c3 = '+';
                c4 = 255;
            } catch (UnsupportedEncodingException e10) {
                throw new RuntimeException(e10);
            }
        }
        return stringBuffer == null ? (i == 0 && str.length() == i2) ? str : str.substring(i, i + i2) : stringBuffer.toString();
    }

    public static void decodeTo(InputStream inputStream, MultiMap multiMap, String str, int i, int i2) throws IOException {
        int read;
        int read2;
        int read3;
        if (str == null) {
            str = ENCODING;
        }
        if ("UTF-8".equalsIgnoreCase(str)) {
            decodeUtf8To(inputStream, multiMap, i, i2);
        } else if ("ISO-8859-1".equals(str)) {
            decode88591To(inputStream, multiMap, i, i2);
        } else if ("UTF-16".equalsIgnoreCase(str)) {
            decodeUtf16To(inputStream, multiMap, i, i2);
        } else {
            synchronized (multiMap) {
                ByteArrayOutputStream2 byteArrayOutputStream2 = new ByteArrayOutputStream2();
                String str2 = null;
                int i3 = 0;
                while (true) {
                    int read4 = inputStream.read();
                    if (read4 > 0) {
                        char c = (char) read4;
                        if (c == '%') {
                            int read5 = inputStream.read();
                            if (117 == read5) {
                                int read6 = inputStream.read();
                                if (read6 >= 0 && (read2 = inputStream.read()) >= 0 && (read3 = inputStream.read()) >= 0) {
                                    byteArrayOutputStream2.write(new String(Character.toChars((TypeUtil.convertHexDigit(read5) << 12) + (TypeUtil.convertHexDigit(read6) << 8) + (TypeUtil.convertHexDigit(read2) << 4) + TypeUtil.convertHexDigit(read3))).getBytes(str));
                                }
                            } else if (read5 >= 0 && (read = inputStream.read()) >= 0) {
                                byteArrayOutputStream2.write((TypeUtil.convertHexDigit(read5) << 4) + TypeUtil.convertHexDigit(read));
                            }
                        } else if (c == '&') {
                            String byteArrayOutputStream = byteArrayOutputStream2.size() == 0 ? "" : byteArrayOutputStream2.toString(str);
                            byteArrayOutputStream2.setCount(0);
                            if (str2 != null) {
                                multiMap.add(str2, byteArrayOutputStream);
                            } else if (byteArrayOutputStream != null && byteArrayOutputStream.length() > 0) {
                                multiMap.add(byteArrayOutputStream, "");
                            }
                            if (i2 > 0 && multiMap.size() > i2) {
                                throw new IllegalStateException(String.format("Form with too many keys [%d > %d]", Integer.valueOf(multiMap.size()), Integer.valueOf(i2)));
                            }
                            str2 = null;
                        } else if (c != '+') {
                            if (c == '=' && str2 == null) {
                                str2 = byteArrayOutputStream2.size() == 0 ? "" : byteArrayOutputStream2.toString(str);
                                byteArrayOutputStream2.setCount(0);
                            }
                            byteArrayOutputStream2.write(read4);
                        } else {
                            byteArrayOutputStream2.write(32);
                        }
                        i3++;
                        if (i >= 0 && i3 > i) {
                            throw new IllegalStateException("Form too large");
                        }
                    } else {
                        int size = byteArrayOutputStream2.size();
                        if (str2 != null) {
                            String byteArrayOutputStream3 = size == 0 ? "" : byteArrayOutputStream2.toString(str);
                            byteArrayOutputStream2.setCount(0);
                            multiMap.add(str2, byteArrayOutputStream3);
                        } else if (size > 0) {
                            multiMap.add(byteArrayOutputStream2.toString(str), "");
                        }
                    }
                }
            }
        }
    }

    public static void decodeTo(String str, MultiMap multiMap, String str2) {
        decodeTo(str, multiMap, str2, -1);
    }

    public static void decodeTo(String str, MultiMap multiMap, String str2, int i) {
        String decodeString;
        String decodeString2;
        if (str2 == null) {
            str2 = ENCODING;
        }
        synchronized (multiMap) {
            int i2 = -1;
            String str3 = null;
            boolean z = false;
            for (int i3 = 0; i3 < str.length(); i3++) {
                char charAt = str.charAt(i3);
                if (charAt != '%') {
                    if (charAt == '&') {
                        int i4 = (i3 - i2) - 1;
                        if (i4 == 0) {
                            decodeString2 = "";
                        } else {
                            int i5 = i2 + 1;
                            decodeString2 = z ? decodeString(str, i5, i4, str2) : str.substring(i5, i3);
                        }
                        if (str3 != null) {
                            multiMap.add(str3, decodeString2);
                        } else if (decodeString2 != null && decodeString2.length() > 0) {
                            multiMap.add(decodeString2, "");
                        }
                        if (i > 0 && multiMap.size() > i) {
                            throw new IllegalStateException(String.format("Form with too many keys [%d > %d]", Integer.valueOf(multiMap.size()), Integer.valueOf(i)));
                        }
                        str3 = null;
                    } else if (charAt != '+') {
                        if (charAt == '=' && str3 == null) {
                            str3 = z ? decodeString(str, i2 + 1, (i3 - i2) - 1, str2) : str.substring(i2 + 1, i3);
                        }
                    }
                    i2 = i3;
                    z = false;
                }
                z = true;
            }
            if (str3 != null) {
                int length = (str.length() - i2) - 1;
                if (length == 0) {
                    decodeString = "";
                } else {
                    int i6 = i2 + 1;
                    decodeString = z ? decodeString(str, i6, length, str2) : str.substring(i6);
                }
                multiMap.add(str3, decodeString);
            } else if (i2 < str.length()) {
                String decodeString3 = z ? decodeString(str, i2 + 1, (str.length() - i2) - 1, str2) : str.substring(i2 + 1);
                if (decodeString3 != null && decodeString3.length() > 0) {
                    multiMap.add(decodeString3, "");
                }
            }
        }
    }

    public static void decodeUtf16To(InputStream inputStream, MultiMap multiMap, int i, int i2) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-16");
        StringWriter stringWriter = new StringWriter(8192);
        C3009IO.copy(inputStreamReader, stringWriter, i);
        decodeTo(stringWriter.getBuffer().toString(), multiMap, "UTF-16", i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x000a A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void decodeUtf8To(InputStream inputStream, MultiMap multiMap, int i, int i2) throws IOException {
        int read;
        int read2;
        int read3;
        synchronized (multiMap) {
            Utf8StringBuilder utf8StringBuilder = new Utf8StringBuilder();
            String str = null;
            int i3 = 0;
            while (true) {
                int read4 = inputStream.read();
                if (read4 >= 0) {
                    char c = (char) read4;
                    if (c == '%') {
                        int read5 = inputStream.read();
                        if (117 == read5) {
                            int read6 = inputStream.read();
                            if (read6 >= 0 && (read2 = inputStream.read()) >= 0 && (read3 = inputStream.read()) >= 0) {
                                utf8StringBuilder.getStringBuilder().append(Character.toChars((TypeUtil.convertHexDigit(read5) << 12) + (TypeUtil.convertHexDigit(read6) << 8) + (TypeUtil.convertHexDigit(read2) << 4) + TypeUtil.convertHexDigit(read3)));
                            }
                        } else if (read5 >= 0 && (read = inputStream.read()) >= 0) {
                            utf8StringBuilder.append((byte) ((TypeUtil.convertHexDigit(read5) << 4) + TypeUtil.convertHexDigit(read)));
                        }
                    } else if (c == '&') {
                        String utf8StringBuilder2 = utf8StringBuilder.length() == 0 ? "" : utf8StringBuilder.toString();
                        utf8StringBuilder.reset();
                        if (str != null) {
                            multiMap.add(str, utf8StringBuilder2);
                        } else if (utf8StringBuilder2 != null && utf8StringBuilder2.length() > 0) {
                            multiMap.add(utf8StringBuilder2, "");
                        }
                        if (i2 > 0) {
                            try {
                                if (multiMap.size() > i2) {
                                    throw new IllegalStateException(String.format("Form with too many keys [%d > %d]", Integer.valueOf(multiMap.size()), Integer.valueOf(i2)));
                                    break;
                                }
                            } catch (Utf8Appendable.NotUtf8Exception e) {
                                e = e;
                                str = null;
                                LOG.warn(e.toString(), new Object[0]);
                                LOG.debug(e);
                                if (i < 0) {
                                }
                            }
                        }
                        str = null;
                    } else if (c != '+') {
                        if (c == '=' && str == null) {
                            str = utf8StringBuilder.toString();
                            utf8StringBuilder.reset();
                        }
                        try {
                            utf8StringBuilder.append((byte) read4);
                        } catch (Utf8Appendable.NotUtf8Exception e2) {
                            e = e2;
                            LOG.warn(e.toString(), new Object[0]);
                            LOG.debug(e);
                            if (i < 0) {
                                throw new IllegalStateException("Form too large");
                            }
                        }
                    } else {
                        utf8StringBuilder.append((byte) 32);
                    }
                    if (i < 0 && (i3 = i3 + 1) > i) {
                        throw new IllegalStateException("Form too large");
                    }
                } else if (str != null) {
                    String utf8StringBuilder3 = utf8StringBuilder.length() == 0 ? "" : utf8StringBuilder.toString();
                    utf8StringBuilder.reset();
                    multiMap.add(str, utf8StringBuilder3);
                } else if (utf8StringBuilder.length() > 0) {
                    multiMap.add(utf8StringBuilder.toString(), "");
                }
            }
        }
    }

    public static void decodeUtf8To(byte[] bArr, int i, int i2, MultiMap multiMap) {
        decodeUtf8To(bArr, i, i2, multiMap, new Utf8StringBuilder());
    }

    public static void decodeUtf8To(byte[] bArr, int i, int i2, MultiMap multiMap, Utf8StringBuilder utf8StringBuilder) {
        int i3;
        synchronized (multiMap) {
            int i4 = i2 + i;
            String str = null;
            while (i < i4) {
                try {
                    byte b = bArr[i];
                    char c = (char) (b & 255);
                    if (c == '%') {
                        if (i + 2 < i4) {
                            int i5 = i + 1;
                            if (117 != bArr[i5]) {
                                i3 = i5 + 1;
                                utf8StringBuilder.append((byte) ((TypeUtil.convertHexDigit(bArr[i5]) << 4) + TypeUtil.convertHexDigit(bArr[i3])));
                            } else if (i5 + 4 < i4) {
                                try {
                                    i3 = i5 + 1;
                                    try {
                                        int i6 = i3 + 1;
                                        int i7 = i6 + 1;
                                        i3 = i7 + 1;
                                        utf8StringBuilder.getStringBuilder().append(Character.toChars((TypeUtil.convertHexDigit(bArr[i3]) << 12) + (TypeUtil.convertHexDigit(bArr[i6]) << 8) + (TypeUtil.convertHexDigit(bArr[i7]) << 4) + TypeUtil.convertHexDigit(bArr[i3])));
                                    } catch (Utf8Appendable.NotUtf8Exception e) {
                                        int i8 = i3;
                                        e = e;
                                        i = i8;
                                        LOG.warn(e.toString(), new Object[0]);
                                        LOG.debug(e);
                                        i++;
                                    }
                                } catch (Utf8Appendable.NotUtf8Exception e2) {
                                    e = e2;
                                    i = i5;
                                }
                            } else {
                                utf8StringBuilder.getStringBuilder().append((char) 65533);
                            }
                            i = i3;
                        } else {
                            utf8StringBuilder.getStringBuilder().append((char) 65533);
                        }
                        i = i4;
                    } else if (c == '&') {
                        String utf8StringBuilder2 = utf8StringBuilder.length() == 0 ? "" : utf8StringBuilder.toString();
                        utf8StringBuilder.reset();
                        if (str != null) {
                            multiMap.add(str, utf8StringBuilder2);
                        } else if (utf8StringBuilder2 != null && utf8StringBuilder2.length() > 0) {
                            multiMap.add(utf8StringBuilder2, "");
                        }
                        str = null;
                    } else if (c != '+') {
                        if (c == '=' && str == null) {
                            str = utf8StringBuilder.toString();
                            utf8StringBuilder.reset();
                        }
                        try {
                            utf8StringBuilder.append(b);
                        } catch (Utf8Appendable.NotUtf8Exception e3) {
                            e = e3;
                            LOG.warn(e.toString(), new Object[0]);
                            LOG.debug(e);
                            i++;
                        }
                    } else {
                        utf8StringBuilder.append((byte) 32);
                    }
                    i++;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (str != null) {
                String replacedString = utf8StringBuilder.length() == 0 ? "" : utf8StringBuilder.toReplacedString();
                utf8StringBuilder.reset();
                multiMap.add(str, replacedString);
            } else if (utf8StringBuilder.length() > 0) {
                multiMap.add(utf8StringBuilder.toReplacedString(), "");
            }
        }
    }

    public static String encode(MultiMap multiMap, String str, boolean z) {
        if (str == null) {
            str = ENCODING;
        }
        StringBuilder sb = new StringBuilder(128);
        Iterator it = multiMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String obj = entry.getKey().toString();
            Object value = entry.getValue();
            int size = LazyList.size(value);
            if (size == 0) {
                sb.append(encodeString(obj, str));
                if (z) {
                    sb.append(B64Code.__pad);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (i > 0) {
                        sb.append('&');
                    }
                    Object obj2 = LazyList.get(value, i);
                    sb.append(encodeString(obj, str));
                    if (obj2 != null) {
                        String obj3 = obj2.toString();
                        if (obj3.length() > 0) {
                            sb.append(B64Code.__pad);
                            sb.append(encodeString(obj3, str));
                        } else {
                            if (!z) {
                            }
                            sb.append(B64Code.__pad);
                        }
                    } else {
                        if (!z) {
                        }
                        sb.append(B64Code.__pad);
                    }
                }
            }
            if (it.hasNext()) {
                sb.append('&');
            }
        }
        return sb.toString();
    }

    public static String encodeString(String str) {
        return encodeString(str, ENCODING);
    }

    public static String encodeString(String str, String str2) {
        byte[] bytes;
        if (str2 == null) {
            str2 = ENCODING;
        }
        try {
            bytes = str.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        byte[] bArr = new byte[bytes.length * 3];
        boolean z = true;
        int i = 0;
        for (byte b : bytes) {
            if (b == 32) {
                bArr[i] = NativeRegExp.REOP_ASSERTTEST;
                i++;
            } else if ((b < 97 || b > 122) && ((b < 65 || b > 90) && (b < 48 || b > 57))) {
                int i2 = i + 1;
                bArr[i] = 37;
                byte b2 = (byte) ((b & 240) >> 4);
                int i3 = i2 + 1;
                if (b2 >= 10) {
                    bArr[i2] = (byte) ((b2 + 65) - 10);
                } else {
                    bArr[i2] = (byte) (b2 + NativeRegExp.REOP_MINIMALQUANT);
                }
                byte b3 = (byte) (b & 15);
                i = i3 + 1;
                if (b3 >= 10) {
                    bArr[i3] = (byte) ((b3 + 65) - 10);
                } else {
                    bArr[i3] = (byte) (b3 + NativeRegExp.REOP_MINIMALQUANT);
                }
            } else {
                bArr[i] = b;
                i++;
            }
            z = false;
        }
        if (z) {
            return str;
        }
        try {
            return new String(bArr, 0, i, str2);
        } catch (UnsupportedEncodingException unused2) {
            return new String(bArr, 0, i);
        }
    }

    public Object clone() {
        return new UrlEncoded(this);
    }

    public void decode(String str) {
        decodeTo(str, this, ENCODING, -1);
    }

    public void decode(String str, String str2) {
        decodeTo(str, this, str2, -1);
    }

    public String encode() {
        return encode(ENCODING, false);
    }

    public String encode(String str) {
        return encode(str, false);
    }

    public synchronized String encode(String str, boolean z) {
        return encode(this, str, z);
    }
}

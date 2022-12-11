package com.google.gson.stream;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import me.tvspark.b20;
import me.tvspark.outline;
import me.tvspark.q10;
import me.tvspark.r00;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* loaded from: classes3.dex */
public class JsonReader implements Closeable {
    public static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    public static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    public static final int NUMBER_CHAR_DECIMAL = 3;
    public static final int NUMBER_CHAR_DIGIT = 2;
    public static final int NUMBER_CHAR_EXP_DIGIT = 7;
    public static final int NUMBER_CHAR_EXP_E = 5;
    public static final int NUMBER_CHAR_EXP_SIGN = 6;
    public static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    public static final int NUMBER_CHAR_NONE = 0;
    public static final int NUMBER_CHAR_SIGN = 1;
    public static final int PEEKED_BEGIN_ARRAY = 3;
    public static final int PEEKED_BEGIN_OBJECT = 1;
    public static final int PEEKED_BUFFERED = 11;
    public static final int PEEKED_DOUBLE_QUOTED = 9;
    public static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    public static final int PEEKED_END_ARRAY = 4;
    public static final int PEEKED_END_OBJECT = 2;
    public static final int PEEKED_EOF = 17;
    public static final int PEEKED_FALSE = 6;
    public static final int PEEKED_LONG = 15;
    public static final int PEEKED_NONE = 0;
    public static final int PEEKED_NULL = 7;
    public static final int PEEKED_NUMBER = 16;
    public static final int PEEKED_SINGLE_QUOTED = 8;
    public static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    public static final int PEEKED_TRUE = 5;
    public static final int PEEKED_UNQUOTED = 10;
    public static final int PEEKED_UNQUOTED_NAME = 14;

    /* renamed from: in */
    public final Reader f591in;
    public long peekedLong;
    public int peekedNumberLength;
    public String peekedString;
    public int[] stack;
    public int stackSize;
    public boolean lenient = false;
    public final char[] buffer = new char[1024];
    public int pos = 0;
    public int limit = 0;
    public int lineNumber = 0;
    public int lineStart = 0;
    public int peeked = 0;
    public String[] pathNames = new String[32];
    public int[] pathIndices = new int[32];

    static {
        q10.INSTANCE = new q10() { // from class: com.google.gson.stream.JsonReader.1
            @Override // me.tvspark.q10
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                int i;
                if (jsonReader instanceof b20) {
                    b20 b20Var = (b20) jsonReader;
                    if (b20Var == null) {
                        throw null;
                    }
                    b20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonToken.NAME);
                    Map.Entry entry = (Map.Entry) ((Iterator) b20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).next();
                    b20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(entry.getValue());
                    b20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new r00((String) entry.getKey()));
                    return;
                }
                int i2 = jsonReader.peeked;
                if (i2 == 0) {
                    i2 = jsonReader.doPeek();
                }
                if (i2 == 13) {
                    i = 9;
                } else if (i2 == 12) {
                    i = 8;
                } else if (i2 != 14) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected a name but was ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(jsonReader.peek());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(jsonReader.locationString());
                    throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                } else {
                    i = 10;
                }
                jsonReader.peeked = i;
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        this.stackSize = 0;
        this.stackSize = 0 + 1;
        iArr[0] = 6;
        if (reader != null) {
            this.f591in = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    private void checkLenient() throws IOException {
        if (this.lenient) {
            return;
        }
        throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int i = this.pos - 1;
        this.pos = i;
        char[] cArr = NON_EXECUTE_PREFIX;
        if (i + cArr.length <= this.limit || fillBuffer(cArr.length)) {
            int i2 = 0;
            while (true) {
                char[] cArr2 = NON_EXECUTE_PREFIX;
                if (i2 >= cArr2.length) {
                    this.pos += cArr2.length;
                    return;
                } else if (this.buffer[this.pos + i2] != cArr2[i2]) {
                    return;
                } else {
                    i2++;
                }
            }
        }
    }

    private boolean fillBuffer(int i) throws IOException {
        int i2;
        char[] cArr = this.buffer;
        int i3 = this.lineStart;
        int i4 = this.pos;
        this.lineStart = i3 - i4;
        int i5 = this.limit;
        if (i5 != i4) {
            int i6 = i5 - i4;
            this.limit = i6;
            System.arraycopy(cArr, i4, cArr, 0, i6);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.f591in;
            int i7 = this.limit;
            int read = reader.read(cArr, i7, cArr.length - i7);
            if (read == -1) {
                return false;
            }
            int i8 = this.limit + read;
            this.limit = i8;
            if (this.lineNumber == 0 && (i2 = this.lineStart) == 0 && i8 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i2 + 1;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private boolean isLiteral(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004f, code lost:
        if (r1 != '/') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
        r7.pos = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
        if (r4 != r2) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
        r7.pos = r4 - 1;
        r2 = fillBuffer(2);
        r7.pos++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:
        if (r2 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0066, code lost:
        checkLenient();
        r2 = r7.pos;
        r3 = r0[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006f, code lost:
        if (r3 == '*') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0079, code lost:
        r7.pos = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0083, code lost:
        if (skipTo("*\/") == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0090, code lost:
        throw syntaxError("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0071, code lost:
        if (r3 == '/') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0074, code lost:
        r7.pos = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0073, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0091, code lost:
        r7.pos = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0095, code lost:
        if (r1 != '#') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0097, code lost:
        checkLenient();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009f, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int nextNonWhitespace(boolean z) throws IOException {
        char[] cArr = this.buffer;
        while (true) {
            int i = this.pos;
            while (true) {
                int i2 = this.limit;
                while (true) {
                    if (i == i2) {
                        this.pos = i;
                        if (!fillBuffer(1)) {
                            if (!z) {
                                return -1;
                            }
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("End of input");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(locationString());
                            throw new EOFException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                        }
                        i = this.pos;
                        i2 = this.limit;
                    }
                    int i3 = i + 1;
                    char c = cArr[i];
                    if (c != '\n') {
                        if (c != ' ' && c != '\r' && c != '\t') {
                            break;
                        }
                    } else {
                        this.lineNumber++;
                        this.lineStart = i3;
                    }
                    i = i3;
                }
                i = this.pos + 2;
            }
            skipToEndOfLine();
        }
    }

    private String nextQuotedValue(char c) throws IOException {
        char[] cArr = this.buffer;
        StringBuilder sb = null;
        while (true) {
            int i = this.pos;
            int i2 = this.limit;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.pos = i3;
                        int i4 = (i3 - i) - 1;
                        if (sb == null) {
                            return new String(cArr, i, i4);
                        }
                        sb.append(cArr, i, i4);
                        return sb.toString();
                    } else if (c2 == '\\') {
                        this.pos = i3;
                        int i5 = (i3 - i) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i5 + 1) * 2, 16));
                        }
                        sb.append(cArr, i, i5);
                        sb.append(readEscapeCharacter());
                    } else {
                        if (c2 == '\n') {
                            this.lineNumber++;
                            this.lineStart = i3;
                        }
                        i = i3;
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i - i) * 2, 16));
                    }
                    sb.append(cArr, i, i - i);
                    this.pos = i;
                    if (!fillBuffer(1)) {
                        throw syntaxError("Unterminated string");
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x004a, code lost:
        checkLenient();
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String nextUnquotedValue() throws IOException {
        String sb;
        int i = 0;
        StringBuilder sb2 = null;
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.pos;
                if (i3 + i2 < this.limit) {
                    char c = this.buffer[i3 + i2];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i2 >= this.buffer.length) {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max(i2, 16));
                    }
                    sb2.append(this.buffer, this.pos, i2);
                    this.pos += i2;
                } else if (fillBuffer(i2 + 1)) {
                }
            }
            i = i2;
            if (sb2 != null) {
                sb = new String(this.buffer, this.pos, i);
            } else {
                sb2.append(this.buffer, this.pos, i);
                sb = sb2.toString();
            }
            this.pos += i;
            return sb;
        } while (fillBuffer(1));
        if (sb2 != null) {
        }
        this.pos += i;
        return sb;
    }

    private int peekKeyword() throws IOException {
        int i;
        String str;
        String str2;
        char c = this.buffer[this.pos];
        if (c == 't' || c == 'T') {
            i = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c == 'f' || c == 'F') {
            i = 6;
            str = "false";
            str2 = "FALSE";
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            i = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.pos + i2 >= this.limit && !fillBuffer(i2 + 1)) {
                return 0;
            }
            char c2 = this.buffer[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0097, code lost:
        if (r9 != 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0099, code lost:
        if (r10 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x009f, code lost:
        if (r11 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00a1, code lost:
        if (r13 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a7, code lost:
        if (r11 != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a9, code lost:
        if (r13 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ab, code lost:
        if (r13 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00ae, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00af, code lost:
        r18.peekedLong = r11;
        r18.pos += r8;
        r1 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b8, code lost:
        r18.peeked = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ba, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bb, code lost:
        if (r9 == 2) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00be, code lost:
        if (r9 == 4) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c1, code lost:
        if (r9 != 7) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c4, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c6, code lost:
        r18.peekedNumberLength = r8;
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0095, code lost:
        if (isLiteral(r14) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00cb, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int peekNumber() throws IOException {
        char[] cArr = this.buffer;
        int i = this.pos;
        int i2 = this.limit;
        int i3 = 0;
        int i4 = 0;
        char c = 0;
        boolean z = true;
        long j = 0;
        boolean z2 = false;
        while (true) {
            if (i + i4 == i2) {
                if (i4 == cArr.length) {
                    return i3;
                }
                if (!fillBuffer(i4 + 1)) {
                    break;
                }
                i = this.pos;
                i2 = this.limit;
            }
            char c2 = cArr[i + i4];
            if (c2 != '+') {
                if (c2 == 'E' || c2 == 'e') {
                    i3 = 0;
                    if (c != 2 && c != 4) {
                        return 0;
                    }
                    c = 5;
                } else if (c2 == '-') {
                    i3 = 0;
                    if (c == 0) {
                        c = 1;
                        z2 = true;
                    } else if (c != 5) {
                        return 0;
                    }
                } else if (c2 == '.') {
                    i3 = 0;
                    if (c != 2) {
                        return 0;
                    }
                    c = 3;
                } else if (c2 < '0' || c2 > '9') {
                    break;
                } else if (c == 1 || c == 0) {
                    j = -(c2 - '0');
                    i3 = 0;
                    c = 2;
                } else {
                    if (c == 2) {
                        if (j == 0) {
                            return 0;
                        }
                        long j2 = (10 * j) - (c2 - '0');
                        int i5 = (j > MIN_INCOMPLETE_INTEGER ? 1 : (j == MIN_INCOMPLETE_INTEGER ? 0 : -1));
                        z &= i5 > 0 || (i5 == 0 && j2 < j);
                        j = j2;
                    } else if (c == 3) {
                        i3 = 0;
                        c = 4;
                    } else if (c == 5 || c == 6) {
                        i3 = 0;
                        c = 7;
                    }
                    i3 = 0;
                }
                i4++;
            } else {
                i3 = 0;
                if (c != 5) {
                    return 0;
                }
            }
            c = 6;
            i4++;
        }
    }

    private void push(int i) {
        int i2 = this.stackSize;
        int[] iArr = this.stack;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.stack = Arrays.copyOf(iArr, i3);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i3);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i3);
        }
        int[] iArr2 = this.stack;
        int i4 = this.stackSize;
        this.stackSize = i4 + 1;
        iArr2[i4] = i;
    }

    private char readEscapeCharacter() throws IOException {
        int i;
        int i2;
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 + 1;
            this.pos = i4;
            char c = cArr[i3];
            if (c == '\n') {
                this.lineNumber++;
                this.lineStart = i4;
            } else if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
                if (c == 'b') {
                    return '\b';
                }
                if (c == 'f') {
                    return '\f';
                }
                if (c == 'n') {
                    return '\n';
                }
                if (c == 'r') {
                    return '\r';
                }
                if (c == 't') {
                    return '\t';
                }
                if (c != 'u') {
                    throw syntaxError("Invalid escape sequence");
                }
                if (i4 + 4 > this.limit && !fillBuffer(4)) {
                    throw syntaxError("Unterminated escape sequence");
                }
                char c2 = 0;
                int i5 = this.pos;
                int i6 = i5 + 4;
                while (i5 < i6) {
                    char c3 = this.buffer[i5];
                    char c4 = (char) (c2 << 4);
                    if (c3 < '0' || c3 > '9') {
                        if (c3 >= 'a' && c3 <= 'f') {
                            i = c3 - 'a';
                        } else if (c3 < 'A' || c3 > 'F') {
                            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\\u");
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(new String(this.buffer, this.pos, 4));
                            throw new NumberFormatException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                        } else {
                            i = c3 - 'A';
                        }
                        i2 = i + 10;
                    } else {
                        i2 = c3 - '0';
                    }
                    c2 = (char) (i2 + c4);
                    i5++;
                }
                this.pos += 4;
                return c2;
            }
            return c;
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipQuotedValue(char c) throws IOException {
        char[] cArr = this.buffer;
        while (true) {
            int i = this.pos;
            int i2 = this.limit;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.pos = i3;
                        return;
                    } else if (c2 == '\\') {
                        this.pos = i3;
                        readEscapeCharacter();
                        break;
                    } else {
                        if (c2 == '\n') {
                            this.lineNumber++;
                            this.lineStart = i3;
                        }
                        i = i3;
                    }
                } else {
                    this.pos = i;
                    if (!fillBuffer(1)) {
                        throw syntaxError("Unterminated string");
                    }
                }
            }
        }
    }

    private boolean skipTo(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.pos + length <= this.limit || fillBuffer(length)) {
                char[] cArr = this.buffer;
                int i = this.pos;
                if (cArr[i] != '\n') {
                    for (int i2 = 0; i2 < length; i2++) {
                        if (this.buffer[this.pos + i2] != str.charAt(i2)) {
                            break;
                        }
                    }
                    return true;
                }
                this.lineNumber++;
                this.lineStart = i + 1;
                this.pos++;
            } else {
                return false;
            }
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c;
        do {
            if (this.pos >= this.limit && !fillBuffer(1)) {
                return;
            }
            char[] cArr = this.buffer;
            int i = this.pos;
            int i2 = i + 1;
            this.pos = i2;
            c = cArr[i];
            if (c == '\n') {
                this.lineNumber++;
                this.lineStart = i2;
                return;
            }
        } while (c != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        checkLenient();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void skipUnquotedValue() throws IOException {
        do {
            int i = 0;
            while (true) {
                int i2 = this.pos;
                if (i2 + i < this.limit) {
                    char c = this.buffer[i2 + i];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.pos = i2 + i;
                }
            }
            this.pos += i;
            return;
        } while (fillBuffer(1));
    }

    private IOException syntaxError(String str) throws IOException {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(locationString());
        throw new MalformedJsonException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public void beginArray() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected BEGIN_ARRAY but was ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(peek());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(locationString());
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public void beginObject() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 1) {
            push(3);
            this.peeked = 0;
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected BEGIN_OBJECT but was ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(peek());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(locationString());
        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.f591in.close();
    }

    public int doPeek() throws IOException {
        int i;
        int nextNonWhitespace;
        int[] iArr = this.stack;
        int i2 = this.stackSize;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 != 2) {
            if (i3 == 3 || i3 == 5) {
                this.stack[this.stackSize - 1] = 4;
                if (i3 == 5 && (nextNonWhitespace = nextNonWhitespace(true)) != 44) {
                    if (nextNonWhitespace != 59) {
                        if (nextNonWhitespace != 125) {
                            throw syntaxError("Unterminated object");
                        }
                        this.peeked = 2;
                        return 2;
                    }
                    checkLenient();
                }
                int nextNonWhitespace2 = nextNonWhitespace(true);
                if (nextNonWhitespace2 == 34) {
                    i = 13;
                } else if (nextNonWhitespace2 == 39) {
                    checkLenient();
                    i = 12;
                } else if (nextNonWhitespace2 == 125) {
                    if (i3 == 5) {
                        throw syntaxError("Expected name");
                    }
                    this.peeked = 2;
                    return 2;
                } else {
                    checkLenient();
                    this.pos--;
                    if (!isLiteral((char) nextNonWhitespace2)) {
                        throw syntaxError("Expected name");
                    }
                    i = 14;
                }
            } else if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int nextNonWhitespace3 = nextNonWhitespace(true);
                if (nextNonWhitespace3 != 58) {
                    if (nextNonWhitespace3 != 61) {
                        throw syntaxError("Expected ':'");
                    }
                    checkLenient();
                    if (this.pos < this.limit || fillBuffer(1)) {
                        char[] cArr = this.buffer;
                        int i4 = this.pos;
                        if (cArr[i4] == '>') {
                            this.pos = i4 + 1;
                        }
                    }
                }
            } else if (i3 == 6) {
                if (this.lenient) {
                    consumeNonExecutePrefix();
                }
                this.stack[this.stackSize - 1] = 7;
            } else if (i3 == 7) {
                if (nextNonWhitespace(false) == -1) {
                    i = 17;
                } else {
                    checkLenient();
                    this.pos--;
                }
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
            this.peeked = i;
            return i;
        } else {
            int nextNonWhitespace4 = nextNonWhitespace(true);
            if (nextNonWhitespace4 != 44) {
                if (nextNonWhitespace4 != 59) {
                    if (nextNonWhitespace4 != 93) {
                        throw syntaxError("Unterminated array");
                    }
                    this.peeked = 4;
                    return 4;
                }
                checkLenient();
            }
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 != 34) {
            if (nextNonWhitespace5 == 39) {
                checkLenient();
                this.peeked = 8;
                return 8;
            }
            if (nextNonWhitespace5 != 44 && nextNonWhitespace5 != 59) {
                if (nextNonWhitespace5 == 91) {
                    this.peeked = 3;
                    return 3;
                } else if (nextNonWhitespace5 != 93) {
                    if (nextNonWhitespace5 == 123) {
                        this.peeked = 1;
                        return 1;
                    }
                    this.pos--;
                    int peekKeyword = peekKeyword();
                    if (peekKeyword != 0) {
                        return peekKeyword;
                    }
                    int peekNumber = peekNumber();
                    if (peekNumber != 0) {
                        return peekNumber;
                    }
                    if (!isLiteral(this.buffer[this.pos])) {
                        throw syntaxError("Expected value");
                    }
                    checkLenient();
                    i = 10;
                } else if (i3 == 1) {
                    this.peeked = 4;
                    return 4;
                }
            }
            if (i3 != 1 && i3 != 2) {
                throw syntaxError("Unexpected value");
            }
            checkLenient();
            this.pos--;
            this.peeked = 7;
            return 7;
        }
        i = 9;
        this.peeked = i;
        return i;
    }

    public void endArray() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i != 4) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected END_ARRAY but was ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(peek());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(locationString());
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        int i2 = this.stackSize - 1;
        this.stackSize = i2;
        int[] iArr = this.pathIndices;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.peeked = 0;
    }

    public void endObject() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i != 2) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected END_OBJECT but was ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(peek());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(locationString());
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        int i2 = this.stackSize - 1;
        this.stackSize = i2;
        this.pathNames[i2] = null;
        int[] iArr = this.pathIndices;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.peeked = 0;
    }

    public String getPath() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('$');
        int i = this.stackSize;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.stack[i2];
            if (i3 == 1 || i3 == 2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('[');
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.pathIndices[i2]);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('.');
                String[] strArr = this.pathNames;
                if (strArr[i2] != null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(strArr[i2]);
                }
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public boolean hasNext() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    public boolean nextBoolean() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i != 6) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected a boolean but was ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(peek());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(locationString());
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
    }

    public double nextDouble() throws IOException {
        String nextQuotedValue;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.peekedLong;
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (i == 8 || i == 9) {
                nextQuotedValue = nextQuotedValue(i == 8 ? ExtendedMessageFormat.QUOTE : '\"');
            } else if (i == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else if (i != 11) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected a double but was ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(peek());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(locationString());
                throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            this.peekedString = nextQuotedValue;
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr2 = this.pathIndices;
        int i3 = this.stackSize - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public int nextInt() throws IOException {
        String nextQuotedValue;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            long j = this.peekedLong;
            int i2 = (int) j;
            if (j != i2) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected an int but was ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.peekedLong);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(locationString());
                throw new NumberFormatException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i != 8 && i != 9 && i != 10) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected an int but was ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(peek());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(locationString());
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        } else {
            if (i == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else {
                nextQuotedValue = nextQuotedValue(i == 8 ? ExtendedMessageFormat.QUOTE : '\"');
            }
            this.peekedString = nextQuotedValue;
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected an int but was ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.peekedString);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(locationString());
            throw new NumberFormatException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr3 = this.pathIndices;
        int i6 = this.stackSize - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    public long nextLong() throws IOException {
        String nextQuotedValue;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.peekedLong;
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i != 8 && i != 9 && i != 10) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected a long but was ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(peek());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(locationString());
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else {
            if (i == 10) {
                nextQuotedValue = nextUnquotedValue();
            } else {
                nextQuotedValue = nextQuotedValue(i == 8 ? ExtendedMessageFormat.QUOTE : '\"');
            }
            this.peekedString = nextQuotedValue;
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected a long but was ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.peekedString);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(locationString());
            throw new NumberFormatException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr3 = this.pathIndices;
        int i4 = this.stackSize - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    public String nextName() throws IOException {
        char c;
        String nextQuotedValue;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 14) {
            nextQuotedValue = nextUnquotedValue();
        } else {
            if (i == 12) {
                c = ExtendedMessageFormat.QUOTE;
            } else if (i != 13) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected a name but was ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(peek());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(locationString());
                throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            } else {
                c = '\"';
            }
            nextQuotedValue = nextQuotedValue(c);
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = nextQuotedValue;
        return nextQuotedValue;
    }

    public void nextNull() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i != 7) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected null but was ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(peek());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(locationString());
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
    }

    public String nextString() throws IOException {
        String str;
        char c;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 10) {
            str = nextUnquotedValue();
        } else {
            if (i == 8) {
                c = ExtendedMessageFormat.QUOTE;
            } else if (i == 9) {
                c = '\"';
            } else if (i == 11) {
                str = this.peekedString;
                this.peekedString = null;
            } else if (i == 15) {
                str = Long.toString(this.peekedLong);
            } else if (i != 16) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected a string but was ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(peek());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(locationString());
                throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            } else {
                str = new String(this.buffer, this.pos, this.peekedNumberLength);
                this.pos += this.peekedNumberLength;
            }
            str = nextQuotedValue(c);
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public JsonToken peek() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        switch (i) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public void skipValue() throws IOException {
        char c;
        int i = 0;
        do {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 3) {
                push(1);
            } else if (i2 == 1) {
                push(3);
            } else {
                if (i2 == 4 || i2 == 2) {
                    this.stackSize--;
                    i--;
                } else if (i2 == 14 || i2 == 10) {
                    skipUnquotedValue();
                } else {
                    if (i2 == 8 || i2 == 12) {
                        c = ExtendedMessageFormat.QUOTE;
                    } else if (i2 == 9 || i2 == 13) {
                        c = '\"';
                    } else if (i2 == 16) {
                        this.pos += this.peekedNumberLength;
                    }
                    skipQuotedValue(c);
                }
                this.peeked = 0;
            }
            i++;
            this.peeked = 0;
        } while (i != 0);
        int[] iArr = this.pathIndices;
        int i3 = this.stackSize;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.pathNames[i3 - 1] = "null";
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }
}

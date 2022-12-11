package org.eclipse.jetty.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class QuotedStringTokenizer extends StringTokenizer {
    public static final String __delim = "\t\n\r";
    public static final char[] escapes;
    public String _delim;
    public boolean _double;
    public boolean _hasToken;

    /* renamed from: _i */
    public int f4594_i;
    public int _lastStart;
    public boolean _returnDelimiters;
    public boolean _returnQuotes;
    public boolean _single;
    public String _string;
    public StringBuffer _token;

    static {
        char[] cArr = new char[32];
        escapes = cArr;
        Arrays.fill(cArr, (char) 65535);
        char[] cArr2 = escapes;
        cArr2[8] = 'b';
        cArr2[9] = 't';
        cArr2[10] = 'n';
        cArr2[12] = 'f';
        cArr2[13] = 'r';
    }

    public QuotedStringTokenizer(String str) {
        this(str, null, false, false);
    }

    public QuotedStringTokenizer(String str, String str2) {
        this(str, str2, false, false);
    }

    public QuotedStringTokenizer(String str, String str2, boolean z) {
        this(str, str2, z, false);
    }

    public QuotedStringTokenizer(String str, String str2, boolean z, boolean z2) {
        super("");
        this._delim = __delim;
        this._returnQuotes = false;
        this._returnDelimiters = false;
        this._hasToken = false;
        this.f4594_i = 0;
        this._lastStart = 0;
        this._double = true;
        this._single = true;
        this._string = str;
        if (str2 != null) {
            this._delim = str2;
        }
        this._returnDelimiters = z;
        this._returnQuotes = z2;
        if (this._delim.indexOf(39) < 0 && this._delim.indexOf(34) < 0) {
            this._token = new StringBuffer(this._string.length() > 1024 ? 512 : this._string.length() / 2);
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't use quotes as delimiters: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._delim);
        throw new Error(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public static boolean isValidEscaping(char c) {
        return c == 'n' || c == 'r' || c == 't' || c == 'f' || c == 'b' || c == '\\' || c == '/' || c == '\"' || c == 'u';
    }

    public static String quote(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "\"\"";
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 8);
        quote(stringBuffer, str);
        return stringBuffer.toString();
    }

    public static void quote(Appendable appendable, String str) {
        try {
            appendable.append('\"');
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt >= ' ') {
                    if (charAt == '\"' || charAt == '\\') {
                        appendable.append('\\');
                    }
                    appendable.append(charAt);
                } else {
                    char c = escapes[charAt];
                    if (c == 65535) {
                        appendable.append('\\').append('u').append('0').append('0');
                        if (charAt < 16) {
                            appendable.append('0');
                        }
                        appendable.append(Integer.toString(charAt, 16));
                    } else {
                        appendable.append('\\').append(c);
                    }
                }
            }
            appendable.append('\"');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String quoteIfNeeded(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "\"\"";
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\\' || charAt == '\"' || charAt == '\'' || Character.isWhitespace(charAt) || str2.indexOf(charAt) >= 0) {
                StringBuffer stringBuffer = new StringBuffer(str.length() + 8);
                quote(stringBuffer, str);
                return stringBuffer.toString();
            }
        }
        return str;
    }

    public static boolean quoteIfNeeded(Appendable appendable, String str, String str2) {
        for (int i = 0; i < str.length(); i++) {
            if (str2.indexOf(str.charAt(i)) >= 0) {
                quote(appendable, str);
                return true;
            }
        }
        try {
            appendable.append(str);
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String unquote(String str) {
        return unquote(str, false);
    }

    public static String unquote(String str, boolean z) {
        char charAt;
        if (str == null) {
            return null;
        }
        if (str.length() < 2 || (charAt = str.charAt(0)) != str.charAt(str.length() - 1)) {
            return str;
        }
        if (charAt != '\"' && charAt != '\'') {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() - 2);
        int i = 1;
        boolean z2 = false;
        while (i < str.length() - 1) {
            char charAt2 = str.charAt(i);
            if (z2) {
                if (charAt2 != '\"') {
                    char c = '/';
                    if (charAt2 != '/') {
                        if (charAt2 == '\\') {
                            sb.append('\\');
                        } else if (charAt2 == 'b') {
                            sb.append('\b');
                        } else if (charAt2 == 'f') {
                            c = '\f';
                        } else if (charAt2 == 'n') {
                            c = '\n';
                        } else if (charAt2 == 'r') {
                            c = '\r';
                        } else if (charAt2 == 't') {
                            c = '\t';
                        } else if (charAt2 != 'u') {
                            if (z && !isValidEscaping(charAt2)) {
                                sb.append('\\');
                            }
                            sb.append(charAt2);
                        } else {
                            int i2 = i + 1;
                            int i3 = i2 + 1;
                            int convertHexDigit = (TypeUtil.convertHexDigit((byte) str.charAt(i)) << 24) + (TypeUtil.convertHexDigit((byte) str.charAt(i2)) << 16);
                            int i4 = i3 + 1;
                            sb.append((char) (TypeUtil.convertHexDigit((byte) str.charAt(i4)) + convertHexDigit + (TypeUtil.convertHexDigit((byte) str.charAt(i3)) << 8)));
                            i = i4 + 1;
                        }
                    }
                    sb.append(c);
                } else {
                    sb.append('\"');
                }
                z2 = false;
            } else if (charAt2 == '\\') {
                z2 = true;
            } else {
                sb.append(charAt2);
            }
            i++;
        }
        return sb.toString();
    }

    public static String unquoteOnly(String str) {
        return unquoteOnly(str, false);
    }

    public static String unquoteOnly(String str, boolean z) {
        char charAt;
        if (str == null) {
            return null;
        }
        if (str.length() < 2 || (charAt = str.charAt(0)) != str.charAt(str.length() - 1)) {
            return str;
        }
        if (charAt != '\"' && charAt != '\'') {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() - 2);
        boolean z2 = false;
        for (int i = 1; i < str.length() - 1; i++) {
            char charAt2 = str.charAt(i);
            if (z2) {
                if (z && !isValidEscaping(charAt2)) {
                    sb.append('\\');
                }
                sb.append(charAt2);
                z2 = false;
            } else if (charAt2 == '\\') {
                z2 = true;
            } else {
                sb.append(charAt2);
            }
        }
        return sb.toString();
    }

    @Override // java.util.StringTokenizer
    public int countTokens() {
        return -1;
    }

    public boolean getDouble() {
        return this._double;
    }

    public boolean getSingle() {
        return this._single;
    }

    @Override // java.util.StringTokenizer, java.util.Enumeration
    public boolean hasMoreElements() {
        return hasMoreTokens();
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0062, code lost:
        if (r10._returnQuotes != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x005b, code lost:
        if (r10._returnQuotes != false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ba, code lost:
        if (r10._returnQuotes != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bc, code lost:
        r10._token.append(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c1, code lost:
        r2 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cc, code lost:
        if (r10._returnQuotes != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ce, code lost:
        r10._token.append(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d3, code lost:
        r2 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0089, code lost:
        if (r10._returnQuotes != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0094, code lost:
        if (r10._returnQuotes != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x004a, code lost:
        if (r10._returnQuotes != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0069, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0064, code lost:
        r10._token.append(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x003d, code lost:
        if (r10._returnQuotes != false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x003f, code lost:
        r10._token.append(r4);
     */
    @Override // java.util.StringTokenizer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean hasMoreTokens() {
        char charAt;
        if (this._hasToken) {
            return true;
        }
        this._lastStart = this.f4594_i;
        char c = 0;
        while (true) {
            boolean z = false;
            while (this.f4594_i < this._string.length()) {
                String str = this._string;
                int i = this.f4594_i;
                this.f4594_i = i + 1;
                charAt = str.charAt(i);
                if (c != 0) {
                    if (c == 1) {
                        this._hasToken = true;
                        if (this._delim.indexOf(charAt) >= 0) {
                            if (this._returnDelimiters) {
                                this.f4594_i--;
                            }
                            return this._hasToken;
                        } else if (charAt != '\'' || !this._single) {
                            if (charAt == '\"' && this._double) {
                            }
                        }
                    } else if (c == 2) {
                        this._hasToken = true;
                        if (z) {
                            break;
                        } else if (charAt != '\'') {
                            if (charAt == '\\') {
                            }
                        }
                    } else if (c != 3) {
                        continue;
                    } else {
                        this._hasToken = true;
                        if (z) {
                            break;
                        } else if (charAt != '\"') {
                            if (charAt == '\\') {
                            }
                        }
                    }
                    this._token.append(charAt);
                } else if (this._delim.indexOf(charAt) >= 0) {
                    if (this._returnDelimiters) {
                        this._token.append(charAt);
                        this._hasToken = true;
                        return true;
                    }
                } else if (charAt != '\'' || !this._single) {
                    if (charAt != '\"' || !this._double) {
                        this._token.append(charAt);
                        this._hasToken = true;
                        c = 1;
                    }
                }
            }
            return this._hasToken;
            this._token.append(charAt);
        }
    }

    @Override // java.util.StringTokenizer, java.util.Enumeration
    public Object nextElement() throws NoSuchElementException {
        return nextToken();
    }

    @Override // java.util.StringTokenizer
    public String nextToken() throws NoSuchElementException {
        StringBuffer stringBuffer;
        if (!hasMoreTokens() || (stringBuffer = this._token) == null) {
            throw new NoSuchElementException();
        }
        String stringBuffer2 = stringBuffer.toString();
        this._token.setLength(0);
        this._hasToken = false;
        return stringBuffer2;
    }

    @Override // java.util.StringTokenizer
    public String nextToken(String str) throws NoSuchElementException {
        this._delim = str;
        this.f4594_i = this._lastStart;
        this._token.setLength(0);
        this._hasToken = false;
        return nextToken();
    }

    public void setDouble(boolean z) {
        this._double = z;
    }

    public void setSingle(boolean z) {
        this._single = z;
    }
}

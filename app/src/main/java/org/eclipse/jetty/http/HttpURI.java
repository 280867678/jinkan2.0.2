package org.eclipse.jetty.http;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import me.tvspark.outline;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.UrlEncoded;
import org.eclipse.jetty.util.Utf8StringBuilder;

/* loaded from: classes4.dex */
public class HttpURI {
    public static final int ASTERISK = 10;
    public static final int AUTH = 4;
    public static final int AUTH_OR_PATH = 1;
    public static final int IPV6 = 5;
    public static final int PARAM = 8;
    public static final int PATH = 7;
    public static final int PORT = 6;
    public static final int QUERY = 9;
    public static final int SCHEME_OR_PATH = 2;
    public static final int START = 0;
    public static final byte[] __empty = new byte[0];
    public int _authority;
    public boolean _encoded;
    public int _end;
    public int _fragment;
    public int _host;
    public int _param;
    public boolean _partial;
    public int _path;
    public int _port;
    public int _portValue;
    public int _query;
    public byte[] _raw;
    public String _rawString;
    public int _scheme;
    public final Utf8StringBuilder _utf8b;

    public HttpURI() {
        this._partial = false;
        this._raw = __empty;
        this._encoded = false;
        this._utf8b = new Utf8StringBuilder(64);
    }

    public HttpURI(String str) {
        this._partial = false;
        this._raw = __empty;
        this._encoded = false;
        this._utf8b = new Utf8StringBuilder(64);
        this._rawString = str;
        try {
            byte[] bytes = str.getBytes("UTF-8");
            parse(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public HttpURI(URI uri) {
        this._partial = false;
        this._raw = __empty;
        this._encoded = false;
        this._utf8b = new Utf8StringBuilder(64);
        parse(uri.toASCIIString());
    }

    public HttpURI(boolean z) {
        this._partial = false;
        this._raw = __empty;
        this._encoded = false;
        this._utf8b = new Utf8StringBuilder(64);
        this._partial = z;
    }

    public HttpURI(byte[] bArr, int i, int i2) {
        this._partial = false;
        this._raw = __empty;
        this._encoded = false;
        this._utf8b = new Utf8StringBuilder(64);
        parse2(bArr, i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
        if (r9 != '?') goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0049, code lost:
        if (r9 == '#') goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parse2(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        char c = 0;
        this._encoded = false;
        this._raw = bArr;
        int i6 = i + i2;
        this._end = i6;
        this._scheme = i;
        this._authority = i;
        this._host = i;
        this._port = i;
        this._portValue = -1;
        this._path = i;
        this._param = i6;
        this._query = i6;
        this._fragment = i6;
        boolean z = true;
        int i7 = i;
        int i8 = i7;
        while (i7 < i6) {
            byte[] bArr2 = this._raw;
            char c2 = (char) (bArr2[i7] & 255);
            int i9 = i7 + 1;
            switch (c) {
                case 0:
                    if (c2 == '#') {
                        this._param = i7;
                        this._query = i7;
                        this._fragment = i7;
                    } else if (c2 != '*') {
                        if (c2 != '/') {
                            if (c2 == ';') {
                                this._param = i7;
                                c = '\b';
                            } else if (c2 != '?') {
                                c = 2;
                            } else {
                                this._param = i7;
                                this._query = i7;
                                c = '\t';
                            }
                        }
                        c = 1;
                    } else {
                        this._path = i7;
                        c = '\n';
                    }
                    i8 = i7;
                    i7 = i9;
                    z = true;
                case 1:
                    if ((this._partial || this._scheme != this._authority) && c2 == '/') {
                        this._host = i9;
                        int i10 = this._end;
                        this._port = i10;
                        this._path = i10;
                        c = 4;
                        i7 = i9;
                        z = true;
                    } else {
                        if (c2 == ';' || c2 == '?' || c2 == '#') {
                            i9--;
                        } else {
                            this._host = i8;
                            this._port = i8;
                        }
                        c = 7;
                        i7 = i9;
                        z = true;
                    }
                    break;
                case 2:
                    if (i2 > 6 && c2 == 't') {
                        int i11 = i + 3;
                        if (bArr2[i11] == 58) {
                            i5 = i + 4;
                        } else {
                            i11 = i + 4;
                            if (bArr2[i11] == 58) {
                                i5 = i + 5;
                            } else {
                                i11 = i + 5;
                                if (bArr2[i11] == 58) {
                                    i5 = i + 6;
                                }
                            }
                        }
                        int i12 = i5;
                        i7 = i11;
                        i4 = i12;
                        c2 = ':';
                        if (c2 == '#') {
                            if (c2 == '/') {
                                i9 = i4;
                            } else if (c2 == '?') {
                                this._param = i7;
                                this._query = i7;
                                i9 = i4;
                                i7 = i8;
                                c = '\t';
                                i8 = i7;
                                i7 = i9;
                                z = true;
                            } else if (c2 == ':') {
                                i9 = i4 + 1;
                                this._authority = i4;
                                this._path = i4;
                                if (((char) (this._raw[i9] & 255)) == '/') {
                                    i7 = i4;
                                    c = 1;
                                    i8 = i7;
                                    i7 = i9;
                                    z = true;
                                } else {
                                    this._host = i4;
                                    this._port = i4;
                                    i8 = i4;
                                }
                            } else if (c2 == ';') {
                                this._param = i7;
                                i9 = i4;
                                i7 = i8;
                                c = '\b';
                                i8 = i7;
                                i7 = i9;
                                z = true;
                            }
                            c = 7;
                            i7 = i9;
                            z = true;
                        } else {
                            this._param = i7;
                            this._query = i7;
                            this._fragment = i7;
                        }
                        i9 = i4;
                        i7 = i8;
                        i8 = i7;
                        i7 = i9;
                        z = true;
                    }
                    i4 = i9;
                    if (c2 == '#') {
                    }
                    i9 = i4;
                    i7 = i8;
                    i8 = i7;
                    i7 = i9;
                    z = true;
                    break;
                case 3:
                default:
                    i7 = i8;
                    i8 = i7;
                    i7 = i9;
                    z = true;
                case 4:
                    if (c2 != '/') {
                        if (c2 == ':') {
                            this._port = i7;
                            c = 6;
                        } else if (c2 == '@') {
                            this._host = i9;
                        } else if (c2 == '[') {
                            c = 5;
                        }
                        i7 = i9;
                    } else {
                        this._path = i7;
                        this._port = i7;
                        c = 7;
                        i8 = i7;
                        i7 = i9;
                    }
                case 5:
                    if (c2 == '/') {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No closing ']' for ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtil.toString(this._raw, i, i2, URIUtil.__CHARSET));
                        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    }
                    if (c2 == ']') {
                        c = 4;
                    }
                    i7 = i9;
                case 6:
                    if (c2 == '/') {
                        this._path = i7;
                        if (this._port <= this._authority) {
                            this._port = i7;
                        }
                        c = 7;
                        i8 = i7;
                        i7 = i9;
                    } else {
                        i7 = i8;
                        i8 = i7;
                        i7 = i9;
                        z = true;
                    }
                case 7:
                    if (c2 != '#') {
                        if (c2 == '%') {
                            this._encoded = z;
                        } else if (c2 == ';') {
                            this._param = i7;
                            c = '\b';
                        } else if (c2 == '?') {
                            this._param = i7;
                            this._query = i7;
                            c = '\t';
                        }
                        i7 = i9;
                    } else {
                        this._param = i7;
                        this._query = i7;
                        this._fragment = i7;
                        i7 = i8;
                        i8 = i7;
                        i7 = i9;
                        z = true;
                    }
                case '\b':
                    if (c2 != '#') {
                        break;
                    } else {
                        this._query = i7;
                        this._fragment = i7;
                        i7 = i8;
                        i8 = i7;
                        i7 = i9;
                        z = true;
                    }
                case '\t':
                    break;
                case '\n':
                    throw new IllegalArgumentException("only '*'");
            }
        }
        int i13 = this._port;
        if (i13 < this._path) {
            this._portValue = TypeUtil.parseInt(this._raw, i13 + 1, (i3 - i13) - 1, 10);
        }
    }

    private String toUtf8String(int i, int i2) {
        this._utf8b.reset();
        this._utf8b.append(this._raw, i, i2);
        return this._utf8b.toString();
    }

    public void clear() {
        this._end = 0;
        this._fragment = 0;
        this._query = 0;
        this._param = 0;
        this._path = 0;
        this._port = 0;
        this._host = 0;
        this._authority = 0;
        this._scheme = 0;
        this._raw = __empty;
        this._rawString = "";
        this._encoded = false;
    }

    public void decodeQueryTo(MultiMap multiMap) {
        if (this._query == this._fragment) {
            return;
        }
        this._utf8b.reset();
        byte[] bArr = this._raw;
        int i = this._query;
        UrlEncoded.decodeUtf8To(bArr, i + 1, (this._fragment - i) - 1, multiMap, this._utf8b);
    }

    public void decodeQueryTo(MultiMap multiMap, String str) throws UnsupportedEncodingException {
        if (this._query == this._fragment) {
            return;
        }
        if (str == null || StringUtil.isUTF8(str)) {
            byte[] bArr = this._raw;
            int i = this._query;
            UrlEncoded.decodeUtf8To(bArr, i + 1, (this._fragment - i) - 1, multiMap);
            return;
        }
        byte[] bArr2 = this._raw;
        int i2 = this._query;
        UrlEncoded.decodeTo(StringUtil.toString(bArr2, i2 + 1, (this._fragment - i2) - 1, str), multiMap, str);
    }

    public String getAuthority() {
        int i = this._authority;
        int i2 = this._path;
        if (i == i2) {
            return null;
        }
        return toUtf8String(i, i2 - i);
    }

    public String getCompletePath() {
        int i = this._path;
        int i2 = this._end;
        if (i == i2) {
            return null;
        }
        return toUtf8String(i, i2 - i);
    }

    public String getDecodedPath() {
        int i = this._path;
        int i2 = this._param;
        if (i == i2) {
            return null;
        }
        int i3 = i2 - i;
        boolean z = false;
        while (i < this._param) {
            byte b = this._raw[i];
            if (b == 37) {
                if (!z) {
                    this._utf8b.reset();
                    Utf8StringBuilder utf8StringBuilder = this._utf8b;
                    byte[] bArr = this._raw;
                    int i4 = this._path;
                    utf8StringBuilder.append(bArr, i4, i - i4);
                    z = true;
                }
                int i5 = i + 2;
                int i6 = this._param;
                if (i5 >= i6) {
                    throw new IllegalArgumentException("Bad % encoding: " + this);
                }
                byte[] bArr2 = this._raw;
                int i7 = i + 1;
                if (bArr2[i7] == 117) {
                    i += 5;
                    if (i >= i6) {
                        throw new IllegalArgumentException("Bad %u encoding: " + this);
                    }
                    try {
                        this._utf8b.getStringBuilder().append(new String(Character.toChars(TypeUtil.parseInt(this._raw, i5, 4, 16))));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    this._utf8b.append((byte) (TypeUtil.parseInt(bArr2, i7, 2, 16) & 255));
                    i = i5;
                }
            } else if (z) {
                this._utf8b.append(b);
            }
            i++;
        }
        return !z ? toUtf8String(this._path, i3) : this._utf8b.toString();
    }

    public String getDecodedPath(String str) {
        int i = this._path;
        int i2 = this._param;
        byte[] bArr = null;
        if (i == i2) {
            return null;
        }
        int i3 = i2 - i;
        int i4 = 0;
        while (true) {
            int i5 = this._param;
            if (i >= i5) {
                if (bArr != null) {
                    return StringUtil.toString(bArr, 0, i4, str);
                }
                byte[] bArr2 = this._raw;
                int i6 = this._path;
                return StringUtil.toString(bArr2, i6, i5 - i6, str);
            }
            byte[] bArr3 = this._raw;
            byte b = bArr3[i];
            if (b == 37) {
                if (bArr == null) {
                    bArr = new byte[i3];
                    System.arraycopy(bArr3, this._path, bArr, 0, i4);
                }
                int i7 = i + 2;
                int i8 = this._param;
                if (i7 >= i8) {
                    throw new IllegalArgumentException("Bad % encoding: " + this);
                }
                byte[] bArr4 = this._raw;
                int i9 = i + 1;
                if (bArr4[i9] == 117) {
                    i += 5;
                    if (i >= i8) {
                        throw new IllegalArgumentException("Bad %u encoding: " + this);
                    }
                    try {
                        byte[] bytes = new String(Character.toChars(TypeUtil.parseInt(this._raw, i7, 4, 16))).getBytes(str);
                        System.arraycopy(bytes, 0, bArr, i4, bytes.length);
                        i4 += bytes.length;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    bArr[i4] = (byte) (TypeUtil.parseInt(bArr4, i9, 2, 16) & 255);
                    i = i7;
                    i4++;
                }
            } else if (bArr == null) {
                i4++;
            } else {
                bArr[i4] = b;
                i4++;
            }
            i++;
        }
    }

    public String getFragment() {
        int i = this._fragment;
        int i2 = this._end;
        if (i == i2) {
            return null;
        }
        return toUtf8String(i + 1, (i2 - i) - 1);
    }

    public String getHost() {
        int i = this._host;
        int i2 = this._port;
        if (i == i2) {
            return null;
        }
        return toUtf8String(i, i2 - i);
    }

    public String getParam() {
        int i = this._param;
        int i2 = this._query;
        if (i == i2) {
            return null;
        }
        return toUtf8String(i + 1, (i2 - i) - 1);
    }

    public String getPath() {
        int i = this._path;
        int i2 = this._param;
        if (i == i2) {
            return null;
        }
        return toUtf8String(i, i2 - i);
    }

    public String getPathAndParam() {
        int i = this._path;
        int i2 = this._query;
        if (i == i2) {
            return null;
        }
        return toUtf8String(i, i2 - i);
    }

    public int getPort() {
        return this._portValue;
    }

    public String getQuery() {
        int i = this._query;
        int i2 = this._fragment;
        if (i == i2) {
            return null;
        }
        return toUtf8String(i + 1, (i2 - i) - 1);
    }

    public String getQuery(String str) {
        int i = this._query;
        int i2 = this._fragment;
        if (i == i2) {
            return null;
        }
        return StringUtil.toString(this._raw, i + 1, (i2 - i) - 1, str);
    }

    public String getScheme() {
        int i = this._scheme;
        int i2 = this._authority;
        if (i == i2) {
            return null;
        }
        int i3 = i2 - i;
        if (i3 == 5) {
            byte[] bArr = this._raw;
            if (bArr[i] == 104 && bArr[i + 1] == 116 && bArr[i + 2] == 116 && bArr[i + 3] == 112) {
                return "http";
            }
        }
        if (i3 == 6) {
            byte[] bArr2 = this._raw;
            int i4 = this._scheme;
            if (bArr2[i4] == 104 && bArr2[i4 + 1] == 116 && bArr2[i4 + 2] == 116 && bArr2[i4 + 3] == 112 && bArr2[i4 + 4] == 115) {
                return "https";
            }
        }
        int i5 = this._scheme;
        return toUtf8String(i5, (this._authority - i5) - 1);
    }

    public boolean hasQuery() {
        return this._fragment > this._query;
    }

    public void parse(String str) {
        byte[] bytes = str.getBytes();
        parse2(bytes, 0, bytes.length);
        this._rawString = str;
    }

    public void parse(byte[] bArr, int i, int i2) {
        this._rawString = null;
        parse2(bArr, i, i2);
    }

    public void parseConnect(byte[] bArr, int i, int i2) {
        this._rawString = null;
        this._encoded = false;
        this._raw = bArr;
        int i3 = i + i2;
        this._end = i3;
        this._scheme = i;
        this._authority = i;
        this._host = i;
        this._port = i3;
        this._portValue = -1;
        this._path = i3;
        this._param = i3;
        this._query = i3;
        this._fragment = i3;
        char c = 4;
        int i4 = i;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            char c2 = (char) (this._raw[i4] & 255);
            int i5 = i4 + 1;
            if (c == 4) {
                if (c2 == ':') {
                    this._port = i4;
                    break;
                } else if (c2 == '[') {
                    c = 5;
                }
            } else if (c != 5) {
                continue;
            } else if (c2 == '/') {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No closing ']' for ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtil.toString(this._raw, i, i2, URIUtil.__CHARSET));
                throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            } else if (c2 == ']') {
                c = 4;
            }
            i4 = i5;
        }
        int i6 = this._port;
        int i7 = this._path;
        if (i6 < i7) {
            this._portValue = TypeUtil.parseInt(this._raw, i6 + 1, (i7 - i6) - 1, 10);
            this._path = i;
            return;
        }
        throw new IllegalArgumentException("No port");
    }

    public String toString() {
        if (this._rawString == null) {
            int i = this._scheme;
            this._rawString = toUtf8String(i, this._end - i);
        }
        return this._rawString;
    }

    public void writeTo(Utf8StringBuilder utf8StringBuilder) {
        byte[] bArr = this._raw;
        int i = this._scheme;
        utf8StringBuilder.append(bArr, i, this._end - i);
    }
}

package org.eclipse.jetty.server;

import java.util.Locale;
import javax.servlet.http.Cookie;
import org.eclipse.jetty.util.LazyList;
import org.eclipse.jetty.util.QuotedStringTokenizer;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class CookieCutter {
    public static final Logger LOG = Log.getLogger(CookieCutter.class);
    public Cookie[] _cookies;
    public int _fields;
    public Cookie[] _lastCookies;
    public Object _lazyFields;

    public void addCookieField(String str) {
        if (str == null) {
            return;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return;
        }
        int size = LazyList.size(this._lazyFields);
        int i = this._fields;
        if (size > i) {
            if (!trim.equals(LazyList.get(this._lazyFields, i))) {
                while (true) {
                    int size2 = LazyList.size(this._lazyFields);
                    int i2 = this._fields;
                    if (size2 <= i2) {
                        break;
                    }
                    this._lazyFields = LazyList.remove(this._lazyFields, i2);
                }
            } else {
                this._fields++;
                return;
            }
        }
        this._cookies = null;
        this._lastCookies = null;
        Object obj = this._lazyFields;
        int i3 = this._fields;
        this._fields = i3 + 1;
        this._lazyFields = LazyList.add(obj, i3, trim);
    }

    public Cookie[] getCookies() {
        Object obj;
        Cookie[] cookieArr = this._cookies;
        if (cookieArr != null) {
            return cookieArr;
        }
        if (this._lastCookies == null || (obj = this._lazyFields) == null || this._fields != LazyList.size(obj)) {
            parseFields();
        } else {
            this._cookies = this._lastCookies;
        }
        Cookie[] cookieArr2 = this._cookies;
        this._lastCookies = cookieArr2;
        return cookieArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x00bc, code lost:
        if (r11 == r8) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x00de, code lost:
        r3 = r0;
        r15 = r11;
        r17 = "";
        r16 = r6.substring(r14, r11 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x00dc, code lost:
        if (r11 == r8) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0085, code lost:
        if (r11 == r8) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0173, code lost:
        r15 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x009e, code lost:
        r3 = r0;
        r15 = r11;
        r16 = r16;
        r17 = r6.substring(r14, r11 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x009c, code lost:
        if (r11 == r8) goto L81;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ea A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r17v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parseFields() {
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        Cookie cookie = null;
        this._lastCookies = null;
        this._cookies = null;
        while (true) {
            int size = LazyList.size(this._lazyFields);
            int i = this._fields;
            if (size <= i) {
                break;
            }
            this._lazyFields = LazyList.remove(this._lazyFields, i);
        }
        Object obj = null;
        int i2 = 0;
        int i3 = 0;
        while (i2 < this._fields) {
            String str5 = (String) LazyList.get(this._lazyFields, i2);
            int length = str5.length();
            int i4 = length - 1;
            Cookie cookie2 = cookie;
            String str6 = cookie2;
            int i5 = i3;
            int i6 = 0;
            boolean z2 = false;
            boolean z3 = false;
            int i7 = -1;
            int i8 = -1;
            Object obj2 = obj;
            boolean z4 = false;
            String str7 = cookie2;
            while (i6 < length) {
                char charAt = str5.charAt(i6);
                String str8 = str6;
                if (z4) {
                    if (z3) {
                        z3 = false;
                    } else if (charAt == '\"') {
                        if (i6 == i4) {
                            int i9 = i6 + 1;
                            if (z2) {
                                str8 = str5.substring(i7, i9);
                            } else {
                                i8 = i6;
                                str3 = "";
                                str4 = str5.substring(i7, i9);
                                z = false;
                                str7 = str4;
                                str6 = str3;
                                if (str6 != null || str7 == 0) {
                                    z4 = z;
                                } else {
                                    String unquoteOnly = QuotedStringTokenizer.unquoteOnly(str7);
                                    String unquoteOnly2 = QuotedStringTokenizer.unquoteOnly(str6);
                                    boolean z5 = z;
                                    try {
                                        if (unquoteOnly.startsWith("$")) {
                                            String lowerCase = unquoteOnly.toLowerCase(Locale.ENGLISH);
                                            if ("$path".equals(lowerCase)) {
                                                if (cookie != null) {
                                                    cookie.setPath(unquoteOnly2);
                                                }
                                            } else if ("$domain".equals(lowerCase)) {
                                                if (cookie != null) {
                                                    cookie.setDomain(unquoteOnly2);
                                                }
                                            } else if ("$port".equals(lowerCase)) {
                                                if (cookie != null) {
                                                    cookie.setComment("$port=" + unquoteOnly2);
                                                }
                                            } else if ("$version".equals(lowerCase)) {
                                                i5 = Integer.parseInt(unquoteOnly2);
                                            }
                                        } else {
                                            Cookie cookie3 = new Cookie(unquoteOnly, unquoteOnly2);
                                            if (i5 > 0) {
                                                try {
                                                    cookie3.setVersion(i5);
                                                } catch (Exception e) {
                                                    e = e;
                                                    cookie = cookie3;
                                                    LOG.debug(e);
                                                    z4 = z5;
                                                    str7 = 0;
                                                    str6 = 0;
                                                    i6++;
                                                    str7 = str7;
                                                    str6 = str6;
                                                }
                                            }
                                            obj2 = LazyList.add(obj2, cookie3);
                                            cookie = cookie3;
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                    }
                                    z4 = z5;
                                    str7 = 0;
                                    str6 = 0;
                                }
                            }
                        }
                        i8 = i6;
                        str4 = str7;
                        str3 = str8;
                        z = false;
                        str7 = str4;
                        str6 = str3;
                        if (str6 != null) {
                        }
                        z4 = z;
                    } else if (charAt == '\\') {
                        z3 = true;
                    }
                } else if (z2) {
                    if (charAt != '\t' && charAt != ' ') {
                        if (charAt != '\"') {
                            if (charAt == ';') {
                                z = z4;
                                z2 = false;
                                str2 = str7;
                                str = i7 >= 0 ? str5.substring(i7, i8 + 1) : "";
                                i7 = -1;
                                str7 = str2;
                                str6 = str;
                                if (str6 != null) {
                                }
                                z4 = z;
                            } else if (i7 < 0) {
                                i7 = i6;
                            }
                        } else if (i7 < 0) {
                            i7 = i6;
                            z4 = true;
                        }
                    }
                } else if (charAt != '\t' && charAt != ' ') {
                    if (charAt != '\"') {
                        String str9 = str7;
                        String str10 = str6;
                        if (charAt != ';') {
                            str7 = str7;
                            if (charAt == '=') {
                                if (i7 >= 0) {
                                    str7 = str5.substring(i7, i8 + 1);
                                }
                                z2 = true;
                                i7 = -1;
                            } else if (i7 < 0) {
                                i7 = i6;
                            }
                        } else {
                            if (i7 >= 0) {
                                str10 = "";
                                str9 = str5.substring(i7, i8 + 1);
                            }
                            z = z4;
                            str2 = str9;
                            str = str10;
                            i7 = -1;
                            str7 = str2;
                            str6 = str;
                            if (str6 != null) {
                            }
                            z4 = z;
                        }
                    } else if (i7 < 0) {
                        i7 = i6;
                        z4 = true;
                    }
                }
                i6++;
                str7 = str7;
                str6 = str6;
            }
            i2++;
            obj = obj2;
            i3 = i5;
            cookie = null;
        }
        Cookie[] cookieArr = (Cookie[]) LazyList.toArray(obj, Cookie.class);
        this._cookies = cookieArr;
        this._lastCookies = cookieArr;
    }

    public void reset() {
        this._cookies = null;
        this._fields = 0;
    }

    public void setCookies(Cookie[] cookieArr) {
        this._cookies = cookieArr;
        this._lastCookies = null;
        this._lazyFields = null;
        this._fields = 0;
    }
}

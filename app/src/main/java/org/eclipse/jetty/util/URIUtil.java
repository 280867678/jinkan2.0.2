package org.eclipse.jetty.util;

import java.io.UnsupportedEncodingException;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class URIUtil implements Cloneable {
    public static final String HTTP = "http";
    public static final String HTTPS = "https";
    public static final String HTTPS_COLON = "https:";
    public static final String HTTP_COLON = "http:";
    public static final String SLASH = "/";
    public static final String __CHARSET = System.getProperty("org.eclipse.jetty.util.URI.charset", "UTF-8");

    public static String addPaths(String str, String str2) {
        if (str == null || str.length() == 0) {
            return (str == null || str2 != null) ? str2 : str;
        } else if (str2 == null || str2.length() == 0) {
            return str;
        } else {
            int indexOf = str.indexOf(59);
            if (indexOf < 0) {
                indexOf = str.indexOf(63);
            }
            if (indexOf == 0) {
                return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, str);
            }
            if (indexOf < 0) {
                indexOf = str.length();
            }
            StringBuilder sb = new StringBuilder(str2.length() + str.length() + 2);
            sb.append(str);
            int i = indexOf - 1;
            if (sb.charAt(i) == '/') {
                if (str2.startsWith("/")) {
                    sb.deleteCharAt(i);
                    sb.insert(i, str2);
                    return sb.toString();
                }
            } else if (!str2.startsWith("/")) {
                sb.insert(indexOf, '/');
                indexOf++;
            }
            sb.insert(indexOf, str2);
            return sb.toString();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b6, code lost:
        if (r6.charAt(r9 - 1) == '.') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0072, code lost:
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0070, code lost:
        if (r6.charAt(r9 - 1) == '.') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00da, code lost:
        if (r6.charAt(r9 - 1) == '.') goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0128 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String canonicalPath(String str) {
        int i;
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        int lastIndexOf = str.lastIndexOf(47, length);
        while (length > 0) {
            int i2 = length - lastIndexOf;
            if (i2 == 2) {
                if (str.charAt(lastIndexOf + 1) == '.') {
                    break;
                }
                int i3 = lastIndexOf;
                lastIndexOf = str.lastIndexOf(47, lastIndexOf - 1);
                length = i3;
            } else {
                if (i2 == 3 && str.charAt(lastIndexOf + 1) == '.' && str.charAt(lastIndexOf + 2) == '.') {
                    break;
                }
                int i32 = lastIndexOf;
                lastIndexOf = str.lastIndexOf(47, lastIndexOf - 1);
                length = i32;
            }
        }
        if (lastIndexOf >= length) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (length > 0) {
            int i7 = length - lastIndexOf;
            if (i7 == 2) {
                int i8 = lastIndexOf + 1;
                if (sb.charAt(i8) != '.') {
                    if (i4 > 0 && i4 - 1 == 0) {
                        i6 = lastIndexOf >= 0 ? lastIndexOf : 0;
                        if (i6 > 0) {
                            if (i5 == sb.length()) {
                            }
                        }
                    }
                } else if (lastIndexOf >= 0 || sb.length() <= 2 || sb.charAt(1) != '/' || sb.charAt(2) != '/') {
                    if (i5 < 0) {
                        i5 = length;
                    }
                    if (lastIndexOf < 0 || (lastIndexOf == 0 && sb.charAt(lastIndexOf) == '/')) {
                        if (i5 < sb.length() && sb.charAt(i5) == '/') {
                            i5++;
                        }
                        i6 = i8;
                    } else {
                        i6 = length == sb.length() ? i8 : lastIndexOf;
                        i = lastIndexOf - 1;
                        while (i >= 0 && sb.charAt(i) != '/') {
                            i--;
                        }
                    }
                }
                if (i4 <= 0) {
                }
                i = lastIndexOf - 1;
                while (i >= 0) {
                }
            } else if (i7 != 3) {
                if (i4 > 0 && i4 - 1 == 0) {
                    i6 = lastIndexOf >= 0 ? lastIndexOf : 0;
                    if (i5 == sb.length()) {
                    }
                }
                if (i4 <= 0 && i6 >= 0 && i5 >= i6) {
                    sb.delete(i6, i5);
                    i5 = i4 <= 0 ? length : -1;
                    i6 = -1;
                }
                i = lastIndexOf - 1;
                while (i >= 0 && sb.charAt(i) != '/') {
                    i--;
                }
            } else if (sb.charAt(lastIndexOf + 1) == '.' && sb.charAt(lastIndexOf + 2) == '.') {
                if (i5 < 0) {
                    i5 = length;
                }
                i4++;
                int i9 = lastIndexOf - 1;
                while (i9 >= 0 && sb.charAt(i9) != '/') {
                    i9--;
                }
                i6 = lastIndexOf;
                lastIndexOf = i9;
                length = i6;
            } else {
                if (i4 > 0 && i4 - 1 == 0) {
                    i6 = lastIndexOf >= 0 ? lastIndexOf : 0;
                    if (i6 > 0) {
                        if (i5 == sb.length()) {
                        }
                    }
                }
                if (i4 <= 0) {
                    sb.delete(i6, i5);
                    if (i4 <= 0) {
                    }
                    i6 = -1;
                }
                i = lastIndexOf - 1;
                while (i >= 0) {
                    i--;
                }
            }
            int i10 = lastIndexOf;
            lastIndexOf = i;
            length = i10;
        }
        if (i4 > 0) {
            return null;
        }
        if (i5 >= 0) {
            sb.delete(i6, i5);
        }
        return sb.toString();
    }

    public static String compactPath(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '/') {
                i2++;
                if (i2 == 2) {
                    break;
                }
            } else if (charAt == '?') {
                return str;
            } else {
                i2 = 0;
            }
            i++;
        }
        if (i2 < 2) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length());
        stringBuffer.append((CharSequence) str, 0, i);
        while (true) {
            if (i >= length) {
                break;
            }
            char charAt2 = str.charAt(i);
            if (charAt2 == '/') {
                int i3 = i2 + 1;
                if (i2 == 0) {
                    stringBuffer.append(charAt2);
                }
                i2 = i3;
            } else if (charAt2 == '?') {
                stringBuffer.append((CharSequence) str, i, length);
                break;
            } else {
                stringBuffer.append(charAt2);
                i2 = 0;
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static String decodePath(String str) {
        String str2;
        String str3;
        int i;
        char[] cArr = null;
        if (str == null) {
            return null;
        }
        int length = str.length();
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = str.charAt(i2);
            if (charAt == '%' && (i = i2 + 2) < length) {
                if (cArr == null) {
                    cArr = new char[length];
                    bArr = new byte[length];
                    str.getChars(0, i2, cArr, 0);
                }
                bArr[i3] = (byte) (TypeUtil.parseInt(str, i2 + 1, 2, 16) & 255);
                i3++;
                i2 = i;
            } else if (charAt == ';') {
                if (cArr == null) {
                    cArr = new char[length];
                    str.getChars(0, i2, cArr, 0);
                }
            } else if (bArr == null) {
                i4++;
            } else {
                if (i3 > 0) {
                    try {
                        str3 = new String(bArr, 0, i3, __CHARSET);
                    } catch (UnsupportedEncodingException unused) {
                        str3 = new String(bArr, 0, i3);
                    }
                    str3.getChars(0, str3.length(), cArr, i4);
                    i4 += str3.length();
                    i3 = 0;
                }
                cArr[i4] = charAt;
                i4++;
            }
            i2++;
        }
        i2 = i4;
        if (cArr == null) {
            return str;
        }
        if (i3 > 0) {
            try {
                str2 = new String(bArr, 0, i3, __CHARSET);
            } catch (UnsupportedEncodingException unused2) {
                str2 = new String(bArr, 0, i3);
            }
            str2.getChars(0, str2.length(), cArr, i2);
            i2 += str2.length();
        }
        return new String(cArr, 0, i2);
    }

    public static String decodePath(byte[] bArr, int i, int i2) {
        int i3;
        byte[] bArr2 = null;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= i2) {
                break;
            }
            int i6 = i4 + i;
            byte b = bArr[i6];
            if (b == 37 && (i3 = i4 + 2) < i2) {
                b = (byte) (TypeUtil.parseInt(bArr, i6 + 1, 2, 16) & 255);
                i4 = i3;
            } else if (b == 59) {
                i2 = i4;
                break;
            } else if (bArr2 == null) {
                i5++;
                i4++;
            }
            if (bArr2 == null) {
                bArr2 = new byte[i2];
                for (int i7 = 0; i7 < i5; i7++) {
                    bArr2[i7] = bArr[i7 + i];
                }
            }
            bArr2[i5] = b;
            i5++;
            i4++;
        }
        return bArr2 == null ? StringUtil.toString(bArr, i, i2, __CHARSET) : StringUtil.toString(bArr2, 0, i5, __CHARSET);
    }

    public static String encodePath(String str) {
        StringBuilder encodePath;
        return (str == null || str.length() == 0 || (encodePath = encodePath(null, str)) == null) ? str : encodePath.toString();
    }

    public static StringBuilder encodePath(StringBuilder sb, String str) {
        StringBuilder sb2;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2 = null;
        int i = 0;
        if (sb == null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt == ' ' || charAt == '%' || charAt == '\'' || charAt == '\"' || charAt == '#' || charAt == ';' || charAt == '<' || charAt == '>' || charAt == '?') {
                    sb2 = new StringBuilder(str.length() * 2);
                    break;
                } else if (charAt > 127) {
                    try {
                        bArr = str.getBytes(__CHARSET);
                        sb2 = new StringBuilder(str.length() * 2);
                        break;
                    } catch (UnsupportedEncodingException e) {
                        throw new IllegalStateException(e);
                    }
                }
            }
            sb2 = sb;
            bArr = null;
            if (sb2 == null) {
                return null;
            }
            bArr2 = bArr;
        } else {
            sb2 = sb;
        }
        synchronized (sb2) {
            if (bArr2 != null) {
                while (i < bArr2.length) {
                    byte b = bArr2[i];
                    if (b == 32) {
                        str3 = "%20";
                    } else if (b == 37) {
                        str3 = "%25";
                    } else if (b == 39) {
                        str3 = "%27";
                    } else if (b == 34) {
                        str3 = "%22";
                    } else if (b == 35) {
                        str3 = "%23";
                    } else if (b == 59) {
                        str3 = "%3B";
                    } else if (b == 60) {
                        str3 = "%3C";
                    } else if (b == 62) {
                        str3 = "%3E";
                    } else if (b != 63) {
                        if (b < 0) {
                            sb2.append('%');
                            TypeUtil.toHex(b, (Appendable) sb2);
                        } else {
                            sb2.append((char) b);
                        }
                        i++;
                    } else {
                        str3 = "%3F";
                    }
                    sb2.append(str3);
                    i++;
                }
            } else {
                while (i < str.length()) {
                    char charAt2 = str.charAt(i);
                    if (charAt2 == ' ') {
                        str2 = "%20";
                    } else if (charAt2 == '%') {
                        str2 = "%25";
                    } else if (charAt2 == '\'') {
                        str2 = "%27";
                    } else if (charAt2 == '\"') {
                        str2 = "%22";
                    } else if (charAt2 == '#') {
                        str2 = "%23";
                    } else if (charAt2 == ';') {
                        str2 = "%3B";
                    } else if (charAt2 == '<') {
                        str2 = "%3C";
                    } else if (charAt2 == '>') {
                        str2 = "%3E";
                    } else if (charAt2 != '?') {
                        sb2.append(charAt2);
                        i++;
                    } else {
                        str2 = "%3F";
                    }
                    sb2.append(str2);
                    i++;
                }
            }
        }
        return sb2;
    }

    public static StringBuilder encodeString(StringBuilder sb, String str, String str2) {
        if (sb == null) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt == '%' || str2.indexOf(charAt) >= 0) {
                    sb = new StringBuilder(str.length() << 1);
                    break;
                }
            }
            if (sb == null) {
                return null;
            }
        }
        synchronized (sb) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt2 = str.charAt(i2);
                if (charAt2 != '%' && str2.indexOf(charAt2) < 0) {
                    sb.append(charAt2);
                }
                sb.append('%');
                StringUtil.append(sb, (byte) (charAt2 & 255), 16);
            }
        }
        return sb;
    }

    public static boolean hasScheme(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == ':') {
                return true;
            }
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && (i <= 0 || ((charAt < '0' || charAt > '9') && charAt != '.' && charAt != '+' && charAt != '-')))) {
                break;
            }
        }
        return false;
    }

    public static String parentPath(String str) {
        int lastIndexOf;
        if (str == null || "/".equals(str) || (lastIndexOf = str.lastIndexOf(47, str.length() - 2)) < 0) {
            return null;
        }
        return str.substring(0, lastIndexOf + 1);
    }
}

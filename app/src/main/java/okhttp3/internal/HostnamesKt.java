package okhttp3.internal;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.uw0;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

@ef0
/* loaded from: classes4.dex */
public final class HostnamesKt {
    public static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) " #%/:?@[\\]", charAt, 0, false, 6) != -1) {
                return true;
            }
        }
        return false;
    }

    public static final boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = str.charAt(i5);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i5++;
                }
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0077, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final InetAddress decodeIpv6(String str, int i, int i2) {
        int i3;
        byte[] bArr = new byte[16];
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i < i2) {
                if (i4 != 16) {
                    int i7 = i + 2;
                    if (i7 <= i2 && nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "::", i, false, 4)) {
                        if (i5 == -1) {
                            i4 += 2;
                            i5 = i4;
                            if (i7 != i2) {
                                i6 = i7;
                                i = i6;
                                int i8 = 0;
                                while (i < i2) {
                                }
                                i3 = i - i6;
                                if (i3 == 0) {
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        return null;
                    }
                    if (i4 != 0) {
                        if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ":", i, false, 4)) {
                            i++;
                        } else if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ".", i, false, 4) || !decodeIpv4Suffix(str, i6, i2, bArr, i4 - 2)) {
                            return null;
                        } else {
                            i4 += 2;
                        }
                    }
                    i6 = i;
                    i = i6;
                    int i82 = 0;
                    while (i < i2) {
                        int parseHexDigit = Util.parseHexDigit(str.charAt(i));
                        if (parseHexDigit == -1) {
                            break;
                        }
                        i82 = (i82 << 4) + parseHexDigit;
                        i++;
                    }
                    i3 = i - i6;
                    if (i3 == 0 || i3 > 4) {
                        break;
                    }
                    int i9 = i4 + 1;
                    bArr[i4] = (byte) ((i82 >>> 8) & 255);
                    i4 = i9 + 1;
                    bArr[i9] = (byte) (i82 & 255);
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        if (i4 != 16) {
            if (i5 == -1) {
                return null;
            }
            int i10 = i4 - i5;
            System.arraycopy(bArr, i5, bArr, 16 - i10, i10);
            Arrays.fill(bArr, i5, (16 - i4) + i5, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    public static final String inet6AddressToAscii(byte[] bArr) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i2 = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        uw0 uw0Var = new uw0();
        while (i < bArr.length) {
            if (i == i2) {
                uw0Var.mo4963writeByte(58);
                i += i4;
                if (i == 16) {
                    uw0Var.mo4963writeByte(58);
                }
            } else {
                if (i > 0) {
                    uw0Var.mo4963writeByte(58);
                }
                uw0Var.mo4957Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Util.and(bArr[i], 255) << 8) | Util.and(bArr[i + 1], 255));
                i += 2;
            }
        }
        return uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static final String toCanonicalHost(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$this$toCanonicalHost");
        boolean z = false;
        if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str, (CharSequence) ":", false, 2)) {
            InetAddress decodeIpv6 = (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "[", false, 2) || !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "]", false, 2)) ? decodeIpv6(str, 0, str.length()) : decodeIpv6(str, 1, str.length() - 1);
            if (decodeIpv6 == null) {
                return null;
            }
            byte[] address = decodeIpv6.getAddress();
            if (address.length == 16) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) address, "address");
                return inet6AddressToAscii(address);
            } else if (address.length == 4) {
                return decodeIpv6.getHostAddress();
            } else {
                throw new AssertionError("Invalid IPv6 address: '" + str + ExtendedMessageFormat.QUOTE);
            }
        }
        try {
            String ascii = IDN.toASCII(str);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) ascii, "IDN.toASCII(host)");
            Locale locale = Locale.US;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) locale, "Locale.US");
            String lowerCase = ascii.toLowerCase(locale);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (lowerCase.length() == 0) {
                z = true;
            }
            if (z) {
                return null;
            }
            if (!containsInvalidHostnameAsciiCodes(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}

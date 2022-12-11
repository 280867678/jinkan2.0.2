package com.alibaba.fastjson.parser;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.core.util.TimeUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.google.gson.stream.JsonReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import me.tvspark.outline;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.http.message.TokenParser;

/* loaded from: classes3.dex */
public final class JSONLexer {

    /* renamed from: CA */
    public static final char[] f155CA;
    public static final int END = 4;
    public static final char EOI = 26;

    /* renamed from: IA */
    public static final int[] f156IA;
    public static final int NOT_MATCH = -1;
    public static final int NOT_MATCH_NAME = -2;
    public static final int UNKNOWN = 0;

    /* renamed from: V6 */
    public static boolean f157V6 = false;
    public static final int VALUE = 3;
    public static final int[] digits;
    public static final boolean[] firstIdentifierFlags;
    public static final boolean[] identifierFlags;
    public static final ThreadLocal<char[]> sbufLocal;

    /* renamed from: bp */
    public int f158bp;
    public Calendar calendar;

    /* renamed from: ch */
    public char f159ch;
    public boolean disableCircularReferenceDetect;
    public int eofPos;
    public boolean exp;
    public int features;
    public long fieldHash;
    public boolean hasSpecial;
    public boolean isDouble;
    public final int len;
    public Locale locale;
    public int matchStat;

    /* renamed from: np */
    public int f160np;
    public int pos;
    public char[] sbuf;

    /* renamed from: sp */
    public int f161sp;
    public String stringDefaultValue;
    public final String text;
    public TimeZone timeZone;
    public int token;

    static {
        int i;
        try {
            i = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt(null);
        } catch (Exception unused) {
            i = -1;
        }
        char c = 0;
        f157V6 = i >= 23;
        sbufLocal = new ThreadLocal<>();
        digits = new int[103];
        for (int i2 = 48; i2 <= 57; i2++) {
            digits[i2] = i2 - 48;
        }
        for (int i3 = 97; i3 <= 102; i3++) {
            digits[i3] = (i3 - 97) + 10;
        }
        for (int i4 = 65; i4 <= 70; i4++) {
            digits[i4] = (i4 - 65) + 10;
        }
        f155CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        int[] iArr = new int[256];
        f156IA = iArr;
        Arrays.fill(iArr, -1);
        int length = f155CA.length;
        for (int i5 = 0; i5 < length; i5++) {
            f156IA[f155CA[i5]] = i5;
        }
        f156IA[61] = 0;
        firstIdentifierFlags = new boolean[256];
        char c2 = 0;
        while (true) {
            boolean[] zArr = firstIdentifierFlags;
            if (c2 >= zArr.length) {
                break;
            }
            if (c2 >= 'A' && c2 <= 'Z') {
                zArr[c2] = true;
            } else if (c2 >= 'a' && c2 <= 'z') {
                firstIdentifierFlags[c2] = true;
            } else if (c2 == '_') {
                firstIdentifierFlags[c2] = true;
            }
            c2 = (char) (c2 + 1);
        }
        identifierFlags = new boolean[256];
        while (true) {
            boolean[] zArr2 = identifierFlags;
            if (c < zArr2.length) {
                if (c >= 'A' && c <= 'Z') {
                    zArr2[c] = true;
                } else if (c >= 'a' && c <= 'z') {
                    identifierFlags[c] = true;
                } else if (c == '_') {
                    identifierFlags[c] = true;
                } else if (c >= '0' && c <= '9') {
                    identifierFlags[c] = true;
                }
                c = (char) (c + 1);
            } else {
                return;
            }
        }
    }

    public JSONLexer(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONLexer(String str, int i) {
        this.features = JSON.DEFAULT_PARSER_FEATURE;
        boolean z = false;
        this.exp = false;
        this.isDouble = false;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        String str2 = null;
        this.calendar = null;
        this.matchStat = 0;
        char[] cArr = sbufLocal.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
        this.features = i;
        this.text = str;
        int length = str.length();
        this.len = length;
        this.f158bp = -1;
        int i2 = (-1) + 1;
        this.f158bp = i2;
        char charAt = i2 >= length ? EOI : this.text.charAt(i2);
        this.f159ch = charAt;
        if (charAt == 65279) {
            next();
        }
        this.stringDefaultValue = (Feature.InitStringFieldAsEmpty.mask & i) != 0 ? "" : str2;
        this.disableCircularReferenceDetect = (Feature.DisableCircularReferenceDetect.mask & i) != 0 ? true : z;
    }

    public JSONLexer(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONLexer(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    public static boolean checkDate(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if (c >= '1' && c <= '3' && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9') {
            if (c5 == '0') {
                if (c6 < '1' || c6 > '9') {
                    return false;
                }
            } else if (c5 != '1' || (c6 != '0' && c6 != '1' && c6 != '2')) {
                return false;
            }
            if (i == 48) {
                return i2 >= 49 && i2 <= 57;
            } else if (i != 49 && i != 50) {
                return i == 51 && (i2 == 48 || i2 == 49);
            } else if (i2 >= 48 && i2 <= 57) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x001d, code lost:
        if (r5 <= '4') goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkTime(char c, char c2, char c3, char c4, char c5, char c6) {
        if (c == '0') {
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        } else if (c != '1') {
            if (c == '2') {
                if (c2 >= '0') {
                }
            }
            return false;
        } else if (c2 < '0' || c2 > '9') {
            return false;
        }
        if (c3 < '0' || c3 > '5') {
            if (c3 != '6' || c4 != '0') {
                return false;
            }
        } else if (c4 < '0' || c4 > '9') {
            return false;
        }
        return (c5 < '0' || c5 > '5') ? c5 == '6' && c6 == '0' : c6 >= '0' && c6 <= '9';
    }

    public static final byte[] decodeFast(String str, int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 == 0) {
            return new byte[0];
        }
        int i5 = (i + i2) - 1;
        while (i < i5 && f156IA[str.charAt(i)] < 0) {
            i++;
        }
        while (i5 > 0 && f156IA[str.charAt(i5)] < 0) {
            i5--;
        }
        int i6 = str.charAt(i5) == '=' ? str.charAt(i5 + (-1)) == '=' ? 2 : 1 : 0;
        int i7 = (i5 - i) + 1;
        if (i2 > 76) {
            i3 = (str.charAt(76) == '\r' ? i7 / 78 : 0) << 1;
        } else {
            i3 = 0;
        }
        int i8 = (((i7 - i3) * 6) >> 3) - i6;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int i12 = i + 1;
            int i13 = i12 + 1;
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            int i16 = (f156IA[str.charAt(i)] << 18) | (f156IA[str.charAt(i12)] << 12) | (f156IA[str.charAt(i13)] << 6) | f156IA[str.charAt(i14)];
            int i17 = i10 + 1;
            bArr[i10] = (byte) (i16 >> 16);
            int i18 = i17 + 1;
            bArr[i17] = (byte) (i16 >> 8);
            int i19 = i18 + 1;
            bArr[i18] = (byte) i16;
            if (i3 <= 0 || (i11 = i11 + 1) != 19) {
                i = i15;
            } else {
                i = i15 + 2;
                i11 = 0;
            }
            i10 = i19;
        }
        if (i10 < i8) {
            int i20 = 0;
            while (i <= i5 - i6) {
                i4 |= f156IA[str.charAt(i)] << (18 - (i20 * 6));
                i20++;
                i++;
            }
            int i21 = 16;
            while (i10 < i8) {
                bArr[i10] = (byte) (i4 >> i21);
                i21 -= 8;
                i10++;
            }
        }
        return bArr;
    }

    private int matchFieldHash(long j) {
        char c = this.f159ch;
        int i = 1;
        while (c != '\"' && c != '\'') {
            if (c != ' ' && c != '\n' && c != '\r' && c != '\t' && c != '\f' && c != '\b') {
                this.fieldHash = 0L;
                break;
            }
            int i2 = i + 1;
            int i3 = this.f158bp + i;
            c = i3 >= this.len ? EOI : this.text.charAt(i3);
            i = i2;
        }
        long j2 = -3750763034362895579L;
        int i4 = this.f158bp + i;
        while (true) {
            if (i4 >= this.len) {
                break;
            }
            char charAt = this.text.charAt(i4);
            if (charAt == c) {
                i += (i4 - this.f158bp) - i;
                break;
            }
            j2 = 1099511628211L * (charAt ^ j2);
            i4++;
        }
        if (j2 != j) {
            this.fieldHash = j2;
            this.matchStat = -2;
            return 0;
        }
        int i5 = i + 1;
        int i6 = this.f158bp + i5;
        char charAt2 = i6 >= this.len ? EOI : this.text.charAt(i6);
        while (charAt2 != ':') {
            if (charAt2 > ' ' || !(charAt2 == ' ' || charAt2 == '\n' || charAt2 == '\r' || charAt2 == '\t' || charAt2 == '\f' || charAt2 == '\b')) {
                throw new JSONException("match feild error expect ':'");
            }
            int i7 = i5 + 1;
            int i8 = this.f158bp + i5;
            charAt2 = i8 >= this.len ? EOI : this.text.charAt(i8);
            i5 = i7;
        }
        return i5 + 1;
    }

    public static String readString(char[] cArr, int i) {
        int i2;
        char[] cArr2 = new char[i];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            char c = cArr[i3];
            if (c != '\\') {
                cArr2[i4] = c;
                i4++;
            } else {
                i3++;
                char c2 = cArr[i3];
                if (c2 == '\"') {
                    i2 = i4 + 1;
                    cArr2[i4] = '\"';
                } else if (c2 != '\'') {
                    if (c2 != 'F') {
                        if (c2 == '\\') {
                            i2 = i4 + 1;
                            cArr2[i4] = '\\';
                        } else if (c2 == 'b') {
                            i2 = i4 + 1;
                            cArr2[i4] = '\b';
                        } else if (c2 != 'f') {
                            if (c2 == 'n') {
                                i2 = i4 + 1;
                                cArr2[i4] = '\n';
                            } else if (c2 == 'r') {
                                i2 = i4 + 1;
                                cArr2[i4] = '\r';
                            } else if (c2 != 'x') {
                                switch (c2) {
                                    case '/':
                                        i2 = i4 + 1;
                                        cArr2[i4] = '/';
                                        break;
                                    case '0':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 0;
                                        break;
                                    case '1':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 1;
                                        break;
                                    case '2':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 2;
                                        break;
                                    case '3':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 3;
                                        break;
                                    case '4':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 4;
                                        break;
                                    case '5':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 5;
                                        break;
                                    case '6':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 6;
                                        break;
                                    case '7':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 7;
                                        break;
                                    default:
                                        switch (c2) {
                                            case 't':
                                                i2 = i4 + 1;
                                                cArr2[i4] = '\t';
                                                break;
                                            case 'u':
                                                i2 = i4 + 1;
                                                int i5 = i3 + 1;
                                                int i6 = i5 + 1;
                                                int i7 = i6 + 1;
                                                i3 = i7 + 1;
                                                cArr2[i4] = (char) Integer.parseInt(new String(new char[]{cArr[i5], cArr[i6], cArr[i7], cArr[i3]}), 16);
                                                break;
                                            case 'v':
                                                i2 = i4 + 1;
                                                cArr2[i4] = 11;
                                                break;
                                            default:
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                i2 = i4 + 1;
                                int[] iArr = digits;
                                int i8 = i3 + 1;
                                i3 = i8 + 1;
                                cArr2[i4] = (char) ((iArr[cArr[i8]] * 16) + iArr[cArr[i3]]);
                            }
                        }
                    }
                    i2 = i4 + 1;
                    cArr2[i4] = '\f';
                } else {
                    i2 = i4 + 1;
                    cArr2[i4] = ExtendedMessageFormat.QUOTE;
                }
                i4 = i2;
            }
            i3++;
        }
        return new String(cArr2, 0, i4);
    }

    private void scanIdent() {
        this.f160np = this.f158bp - 1;
        this.hasSpecial = false;
        do {
            this.f161sp++;
            next();
        } while (Character.isLetterOrDigit(this.f159ch));
        String stringVal = stringVal();
        this.token = stringVal.equals("null") ? 8 : stringVal.equals("true") ? 6 : stringVal.equals("false") ? 7 : stringVal.equals("new") ? 9 : stringVal.equals("undefined") ? 23 : stringVal.equals("Set") ? 21 : stringVal.equals("TreeSet") ? 22 : 18;
    }

    private void setCalendar(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        calendar.set(1, (c4 - '0') + outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) c3, -48, 10, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) c2, -48, 100, (c - '0') * 1000)));
        Calendar calendar2 = this.calendar;
        calendar2.set(2, ((c6 - '0') + ((c5 - '0') * 10)) - 1);
        Calendar calendar3 = this.calendar;
        calendar3.set(5, (c8 - '0') + ((c7 - '0') * 10));
    }

    private final String subString(int i, int i2) {
        char[] cArr = this.sbuf;
        if (i2 < cArr.length) {
            this.text.getChars(i, i + i2, cArr, 0);
            return new String(this.sbuf, 0, i2);
        }
        char[] cArr2 = new char[i2];
        this.text.getChars(i, i2 + i, cArr2, 0);
        return new String(cArr2);
    }

    public byte[] bytesValue() {
        return decodeFast(this.text, this.f160np + 1, this.f161sp);
    }

    public char charAt(int i) {
        return i >= this.len ? EOI : this.text.charAt(i);
    }

    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8196) {
            sbufLocal.set(cArr);
        }
        this.sbuf = null;
    }

    public final void config(Feature feature, boolean z) {
        int i = this.features;
        int i2 = feature.mask;
        this.features = z ? i | i2 : i & (~i2);
        if (feature == Feature.InitStringFieldAsEmpty) {
            this.stringDefaultValue = z ? "" : null;
        }
        this.disableCircularReferenceDetect = (this.features & Feature.DisableCircularReferenceDetect.mask) != 0;
    }

    public final Number decimalValue(boolean z) {
        char[] cArr;
        boolean z2;
        int i = (this.f160np + this.f161sp) - 1;
        char charAt = i >= this.len ? EOI : this.text.charAt(i);
        try {
            if (charAt == 'F') {
                return Float.valueOf(Float.parseFloat(numberString()));
            }
            if (charAt == 'D') {
                return Double.valueOf(Double.parseDouble(numberString()));
            }
            if (z) {
                return decimalValue();
            }
            char charAt2 = this.text.charAt((this.f160np + this.f161sp) - 1);
            int i2 = this.f161sp;
            if (charAt2 == 'L' || charAt2 == 'S' || charAt2 == 'B' || charAt2 == 'F' || charAt2 == 'D') {
                i2--;
            }
            int i3 = this.f160np;
            int i4 = 0;
            if (i2 < this.sbuf.length) {
                this.text.getChars(i3, i3 + i2, this.sbuf, 0);
                cArr = this.sbuf;
            } else {
                char[] cArr2 = new char[i2];
                this.text.getChars(i3, i3 + i2, cArr2, 0);
                cArr = cArr2;
            }
            if (i2 > 9 || this.exp) {
                return Double.valueOf(Double.parseDouble(new String(cArr, 0, i2)));
            }
            char c = cArr[0];
            int i5 = 2;
            if (c == '-') {
                c = cArr[1];
                z2 = true;
            } else if (c == '+') {
                c = cArr[1];
                z2 = false;
            } else {
                z2 = false;
                i5 = 1;
            }
            int i6 = c - '0';
            while (i5 < i2) {
                char c2 = cArr[i5];
                if (c2 == '.') {
                    i4 = 1;
                } else {
                    i6 = (i6 * 10) + (c2 - '0');
                    if (i4 != 0) {
                        i4 *= 10;
                    }
                }
                i5++;
            }
            double d = i6 / i4;
            if (z2) {
                d = -d;
            }
            return Double.valueOf(d);
        } catch (NumberFormatException e) {
            throw new JSONException(e.getMessage() + ", " + info());
        }
    }

    public final BigDecimal decimalValue() {
        char charAt = this.text.charAt((this.f160np + this.f161sp) - 1);
        int i = this.f161sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        int i2 = this.f160np;
        char[] cArr = this.sbuf;
        if (i < cArr.length) {
            this.text.getChars(i2, i2 + i, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i);
        }
        char[] cArr2 = new char[i];
        this.text.getChars(i2, i + i2, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    public String info() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("pos ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f158bp);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", json : ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.len < 65536 ? this.text : this.text.substring(0, 65536));
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public final int intValue() {
        int i;
        boolean z;
        int i2 = this.f160np;
        int i3 = this.f161sp + i2;
        int i4 = 0;
        if ((i2 >= this.len ? EOI : this.text.charAt(i2)) == '-') {
            i = Integer.MIN_VALUE;
            i2++;
            z = true;
        } else {
            i = -2147483647;
            z = false;
        }
        if (i2 < i3) {
            i4 = -((i2 >= this.len ? EOI : this.text.charAt(i2)) - '0');
            i2++;
        }
        while (i2 < i3) {
            int i5 = i2 + 1;
            char charAt = i2 >= this.len ? EOI : this.text.charAt(i2);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                i2 = i5;
                break;
            }
            int i6 = charAt - '0';
            if (i4 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i7 = i4 * 10;
            if (i7 < i + i6) {
                throw new NumberFormatException(numberString());
            }
            i4 = i7 - i6;
            i2 = i5;
        }
        if (z) {
            if (i2 <= this.f160np + 1) {
                throw new NumberFormatException(numberString());
            }
            return i4;
        }
        return -i4;
    }

    public final Number integerValue() throws NumberFormatException {
        char c;
        long j;
        boolean z;
        long j2;
        int i = this.f160np;
        int i2 = this.f161sp + i;
        int i3 = i2 - 1;
        char charAt = i3 >= this.len ? EOI : this.text.charAt(i3);
        if (charAt == 'B') {
            i2--;
            c = 'B';
        } else if (charAt == 'L') {
            i2--;
            c = 'L';
        } else if (charAt != 'S') {
            c = TokenParser.f4579SP;
        } else {
            i2--;
            c = 'S';
        }
        int i4 = this.f160np;
        if ((i4 >= this.len ? EOI : this.text.charAt(i4)) == '-') {
            j = Long.MIN_VALUE;
            i++;
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        if (i < i2) {
            j2 = -((i >= this.len ? EOI : this.text.charAt(i)) - '0');
            i++;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i5 = i + 1;
            int charAt2 = (i >= this.len ? EOI : this.text.charAt(i)) - '0';
            if (j2 < JsonReader.MIN_INCOMPLETE_INTEGER) {
                return new BigInteger(numberString());
            }
            long j3 = j2 * 10;
            long j4 = charAt2;
            if (j3 < j + j4) {
                return new BigInteger(numberString());
            }
            j2 = j3 - j4;
            i = i5;
        }
        if (!z) {
            long j5 = -j2;
            if (j5 > 2147483647L || c == 'L') {
                return Long.valueOf(j5);
            }
            int i6 = (int) j5;
            return c == 'S' ? Short.valueOf((short) i6) : c == 'B' ? Byte.valueOf((byte) i6) : Integer.valueOf(i6);
        } else if (i <= this.f160np + 1) {
            throw new NumberFormatException(numberString());
        } else {
            if (j2 < -2147483648L || c == 'L') {
                return Long.valueOf(j2);
            }
            if (c == 'S') {
                return Short.valueOf((short) j2);
            }
            int i7 = (int) j2;
            return c == 'B' ? Byte.valueOf((byte) i7) : Integer.valueOf(i7);
        }
    }

    public final boolean isBlankInput() {
        int i = 0;
        while (true) {
            char charAt = charAt(i);
            boolean z = true;
            if (charAt == 26) {
                return true;
            }
            if (charAt > ' ' || (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t' && charAt != '\f' && charAt != '\b')) {
                z = false;
            }
            if (!z) {
                return false;
            }
            i++;
        }
    }

    public final boolean isEnabled(Feature feature) {
        return (feature.mask & this.features) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005e -> B:6:0x0026). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long longValue() throws NumberFormatException {
        long j;
        boolean z;
        long j2;
        int i = this.f160np;
        int i2 = this.f161sp + i;
        if (charAt(i) == '-') {
            j = Long.MIN_VALUE;
            i++;
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        if (i < i2) {
            int i3 = i + 1;
            j2 = -(charAt(i) - '0');
            i = i3;
            if (i < i2) {
                i3 = i + 1;
                char charAt = i >= this.len ? EOI : this.text.charAt(i);
                if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                    i = i3;
                } else {
                    int i4 = charAt - '0';
                    if (j2 < JsonReader.MIN_INCOMPLETE_INTEGER) {
                        throw new NumberFormatException(numberString());
                    }
                    long j3 = j2 * 10;
                    long j4 = i4;
                    if (j3 < j + j4) {
                        throw new NumberFormatException(numberString());
                    }
                    j2 = j3 - j4;
                    i = i3;
                    if (i < i2) {
                    }
                }
            }
            if (z) {
                return -j2;
            }
            if (i <= this.f160np + 1) {
                throw new NumberFormatException(numberString());
            }
            return j2;
        }
        j2 = 0;
        if (i < i2) {
        }
        if (z) {
        }
    }

    public boolean matchField(long j) {
        char c = this.f159ch;
        int i = this.f158bp + 1;
        int i2 = 1;
        while (c != '\"' && c != '\'') {
            if (c > ' ' || !(c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b')) {
                this.fieldHash = 0L;
                this.matchStat = -2;
                return false;
            }
            int i3 = i2 + 1;
            int i4 = this.f158bp + i2;
            c = i4 >= this.len ? EOI : this.text.charAt(i4);
            i2 = i3;
        }
        int i5 = i;
        long j2 = -3750763034362895579L;
        while (true) {
            if (i5 >= this.len) {
                break;
            }
            char charAt = this.text.charAt(i5);
            if (charAt == c) {
                i2 += (i5 - i) + 1;
                break;
            }
            j2 = 1099511628211L * (j2 ^ charAt);
            i5++;
        }
        if (j2 != j) {
            this.matchStat = -2;
            this.fieldHash = j2;
            return false;
        }
        int i6 = i2 + 1;
        int i7 = this.f158bp + i2;
        char charAt2 = i7 >= this.len ? EOI : this.text.charAt(i7);
        while (charAt2 != ':') {
            if (charAt2 > ' ' || !(charAt2 == ' ' || charAt2 == '\n' || charAt2 == '\r' || charAt2 == '\t' || charAt2 == '\f' || charAt2 == '\b')) {
                throw new JSONException("match feild error expect ':'");
            }
            int i8 = i6 + 1;
            int i9 = this.f158bp + i6;
            charAt2 = i9 >= this.len ? EOI : this.text.charAt(i9);
            i6 = i8;
        }
        int i10 = this.f158bp + i6;
        char charAt3 = i10 >= this.len ? EOI : this.text.charAt(i10);
        if (charAt3 == '{') {
            int i11 = i10 + 1;
            this.f158bp = i11;
            this.f159ch = i11 >= this.len ? EOI : this.text.charAt(i11);
            this.token = 12;
        } else if (charAt3 == '[') {
            int i12 = i10 + 1;
            this.f158bp = i12;
            this.f159ch = i12 >= this.len ? EOI : this.text.charAt(i12);
            this.token = 14;
        } else {
            this.f158bp = i10;
            this.f159ch = i10 >= this.len ? EOI : this.text.charAt(i10);
            nextToken();
        }
        return true;
    }

    public char next() {
        int i = this.f158bp + 1;
        this.f158bp = i;
        char charAt = i >= this.len ? EOI : this.text.charAt(i);
        this.f159ch = charAt;
        return charAt;
    }

    public final void nextIdent() {
        while (true) {
            char c = this.f159ch;
            if (!(c <= ' ' && (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b'))) {
                break;
            }
            next();
        }
        char c2 = this.f159ch;
        if (c2 == '_' || Character.isLetter(c2)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
        scanNumber();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0105, code lost:
        scanIdent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0108, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void nextToken() {
        char c;
        int i = 0;
        this.f161sp = 0;
        while (true) {
            this.pos = this.f158bp;
            char c2 = this.f159ch;
            if (c2 == '/') {
                skipComment();
            } else if (c2 == '\"') {
                scanString();
                return;
            } else if ((c2 < '0' || c2 > '9') && (c = this.f159ch) != '-') {
                if (c == ',') {
                    next();
                    this.token = 16;
                    return;
                }
                if (c != '\f' && c != '\r' && c != ' ') {
                    if (c == ':') {
                        next();
                        this.token = 17;
                        return;
                    }
                    char c3 = EOI;
                    if (c == '[') {
                        int i2 = this.f158bp + 1;
                        this.f158bp = i2;
                        if (i2 < this.len) {
                            c3 = this.text.charAt(i2);
                        }
                        this.f159ch = c3;
                        this.token = 14;
                        return;
                    } else if (c == ']') {
                        next();
                        this.token = 15;
                        return;
                    } else if (c == 'f') {
                        if (this.text.startsWith("false", this.f158bp)) {
                            int i3 = this.f158bp + 5;
                            this.f158bp = i3;
                            char charAt = charAt(i3);
                            this.f159ch = charAt;
                            if (charAt == ' ' || charAt == ',' || charAt == '}' || charAt == ']' || charAt == '\n' || charAt == '\r' || charAt == '\t' || charAt == 26 || charAt == '\f' || charAt == '\b' || charAt == ':') {
                                this.token = 7;
                                return;
                            }
                        }
                        throw new JSONException("scan false error");
                    } else if (c == 'n') {
                        if (this.text.startsWith("null", this.f158bp)) {
                            this.f158bp += 4;
                            i = 8;
                        } else if (this.text.startsWith("new", this.f158bp)) {
                            this.f158bp += 3;
                            i = 9;
                        }
                        if (i != 0) {
                            char charAt2 = charAt(this.f158bp);
                            this.f159ch = charAt2;
                            if (charAt2 == ' ' || charAt2 == ',' || charAt2 == '}' || charAt2 == ']' || charAt2 == '\n' || charAt2 == '\r' || charAt2 == '\t' || charAt2 == 26 || charAt2 == '\f' || charAt2 == '\b') {
                                this.token = i;
                                return;
                            }
                        }
                        throw new JSONException("scan null/new error");
                    } else if (c == '{') {
                        int i4 = this.f158bp + 1;
                        this.f158bp = i4;
                        if (i4 < this.len) {
                            c3 = this.text.charAt(i4);
                        }
                        this.f159ch = c3;
                        this.token = 12;
                        return;
                    } else if (c == '}') {
                        int i5 = this.f158bp + 1;
                        this.f158bp = i5;
                        if (i5 < this.len) {
                            c3 = this.text.charAt(i5);
                        }
                        this.f159ch = c3;
                        this.token = 13;
                        return;
                    } else if (c != 'S' && c != 'T') {
                        if (c == 't') {
                            if (this.text.startsWith("true", this.f158bp)) {
                                int i6 = this.f158bp + 4;
                                this.f158bp = i6;
                                char charAt3 = charAt(i6);
                                this.f159ch = charAt3;
                                if (charAt3 == ' ' || charAt3 == ',' || charAt3 == '}' || charAt3 == ']' || charAt3 == '\n' || charAt3 == '\r' || charAt3 == '\t' || charAt3 == 26 || charAt3 == '\f' || charAt3 == '\b' || charAt3 == ':') {
                                    this.token = 6;
                                    return;
                                }
                            }
                            throw new JSONException("scan true error");
                        } else if (c != 'u') {
                            switch (c) {
                                case '\b':
                                case '\t':
                                case '\n':
                                    break;
                                default:
                                    switch (c) {
                                        case '\'':
                                            scanString();
                                            return;
                                        case '(':
                                            next();
                                            this.token = 10;
                                            return;
                                        case ')':
                                            next();
                                            this.token = 11;
                                            return;
                                        default:
                                            int i7 = this.f158bp;
                                            int i8 = this.len;
                                            if (i7 == i8 || (c == 26 && i7 + 1 == i8)) {
                                                if (this.token == 20) {
                                                    throw new JSONException("EOF error");
                                                }
                                                this.token = 20;
                                                int i9 = this.eofPos;
                                                this.f158bp = i9;
                                                this.pos = i9;
                                                return;
                                            }
                                            char c4 = this.f159ch;
                                            if (c4 > 31 && c4 != 127) {
                                                this.token = 1;
                                                next();
                                                return;
                                            }
                                            break;
                                    }
                            }
                        }
                    }
                }
                next();
            }
        }
    }

    public final void nextToken(int i) {
        this.f161sp = 0;
        while (true) {
            if (i != 2) {
                char c = EOI;
                if (i == 4) {
                    char c2 = this.f159ch;
                    if (c2 == '\"') {
                        this.pos = this.f158bp;
                        scanString();
                        return;
                    } else if (c2 >= '0' && c2 <= '9') {
                        this.pos = this.f158bp;
                        scanNumber();
                        return;
                    } else if (this.f159ch == '{') {
                        this.token = 12;
                        int i2 = this.f158bp + 1;
                        this.f158bp = i2;
                        if (i2 < this.len) {
                            c = this.text.charAt(i2);
                        }
                        this.f159ch = c;
                        return;
                    }
                } else if (i == 12) {
                    char c3 = this.f159ch;
                    if (c3 == '{') {
                        this.token = 12;
                        int i3 = this.f158bp + 1;
                        this.f158bp = i3;
                        if (i3 < this.len) {
                            c = this.text.charAt(i3);
                        }
                        this.f159ch = c;
                        return;
                    } else if (c3 == '[') {
                        this.token = 14;
                        int i4 = this.f158bp + 1;
                        this.f158bp = i4;
                        if (i4 < this.len) {
                            c = this.text.charAt(i4);
                        }
                        this.f159ch = c;
                        return;
                    }
                } else if (i == 18) {
                    nextIdent();
                    return;
                } else {
                    if (i != 20) {
                        switch (i) {
                            case 14:
                                char c4 = this.f159ch;
                                if (c4 == '[') {
                                    this.token = 14;
                                    next();
                                    return;
                                } else if (c4 == '{') {
                                    this.token = 12;
                                    next();
                                    return;
                                }
                                break;
                            case 15:
                                if (this.f159ch == ']') {
                                    this.token = 15;
                                    next();
                                    return;
                                }
                                break;
                            case 16:
                                char c5 = this.f159ch;
                                if (c5 == ',') {
                                    this.token = 16;
                                    int i5 = this.f158bp + 1;
                                    this.f158bp = i5;
                                    if (i5 < this.len) {
                                        c = this.text.charAt(i5);
                                    }
                                    this.f159ch = c;
                                    return;
                                } else if (c5 == '}') {
                                    this.token = 13;
                                    int i6 = this.f158bp + 1;
                                    this.f158bp = i6;
                                    if (i6 < this.len) {
                                        c = this.text.charAt(i6);
                                    }
                                    this.f159ch = c;
                                    return;
                                } else if (c5 == ']') {
                                    this.token = 15;
                                    int i7 = this.f158bp + 1;
                                    this.f158bp = i7;
                                    if (i7 < this.len) {
                                        c = this.text.charAt(i7);
                                    }
                                    this.f159ch = c;
                                    return;
                                } else if (c5 == 26) {
                                    this.token = 20;
                                    return;
                                }
                                break;
                        }
                    }
                    if (this.f159ch == 26) {
                        this.token = 20;
                        return;
                    }
                }
            } else {
                char c6 = this.f159ch;
                if (c6 >= '0' && c6 <= '9') {
                    this.pos = this.f158bp;
                    scanNumber();
                    return;
                }
                char c7 = this.f159ch;
                if (c7 == '\"') {
                    this.pos = this.f158bp;
                    scanString();
                    return;
                } else if (c7 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c7 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            }
            char c8 = this.f159ch;
            if (c8 != ' ' && c8 != '\n' && c8 != '\r' && c8 != '\t' && c8 != '\f' && c8 != '\b') {
                nextToken();
                return;
            }
            next();
        }
    }

    public final void nextTokenWithChar(char c) {
        this.f161sp = 0;
        while (true) {
            char c2 = this.f159ch;
            if (c2 == c) {
                int i = this.f158bp + 1;
                this.f158bp = i;
                this.f159ch = i >= this.len ? EOI : this.text.charAt(i);
                nextToken();
                return;
            } else if (c2 != ' ' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != '\f' && c2 != '\b') {
                throw new JSONException("not match " + c + " - " + this.f159ch);
            } else {
                next();
            }
        }
    }

    public final String numberString() {
        char charAt = this.text.charAt((this.f160np + this.f161sp) - 1);
        int i = this.f161sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        return subString(this.f160np, i);
    }

    public boolean scanBoolean() {
        boolean z = false;
        int i = 1;
        if (this.text.startsWith("false", this.f158bp)) {
            i = 5;
        } else if (this.text.startsWith("true", this.f158bp)) {
            z = true;
            i = 4;
        } else {
            char c = this.f159ch;
            if (c == '1') {
                z = true;
            } else if (c != '0') {
                this.matchStat = -1;
                return false;
            }
        }
        int i2 = this.f158bp + i;
        this.f158bp = i2;
        this.f159ch = charAt(i2);
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x010b, code lost:
        if (r3 >= r12.len) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x010e, code lost:
        r7 = r12.text.charAt(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012a, code lost:
        if (r3 >= r12.len) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x013c, code lost:
        if (r3 >= r12.len) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean scanFieldBoolean(long j) {
        int i;
        boolean z;
        char charAt;
        int i2;
        int i3;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return false;
        }
        if (!this.text.startsWith("false", this.f158bp + matchFieldHash)) {
            if (this.text.startsWith("true", this.f158bp + matchFieldHash)) {
                i = matchFieldHash + 4;
            } else if (this.text.startsWith("\"false\"", this.f158bp + matchFieldHash)) {
                i = matchFieldHash + 7;
            } else if (this.text.startsWith("\"true\"", this.f158bp + matchFieldHash)) {
                i = matchFieldHash + 6;
            } else if (this.text.charAt(this.f158bp + matchFieldHash) == '1') {
                i = matchFieldHash + 1;
            } else if (this.text.charAt(this.f158bp + matchFieldHash) == '0') {
                i = matchFieldHash + 1;
            } else if (this.text.startsWith("\"1\"", this.f158bp + matchFieldHash)) {
                i = matchFieldHash + 3;
            } else if (!this.text.startsWith("\"0\"", this.f158bp + matchFieldHash)) {
                this.matchStat = -1;
                return false;
            } else {
                i = matchFieldHash + 3;
            }
            z = true;
            int i4 = i + 1;
            int i5 = this.f158bp + i;
            int i6 = this.len;
            char c = EOI;
            charAt = i5 < i6 ? EOI : this.text.charAt(i5);
            while (charAt != ',') {
                if (charAt != '}' && (charAt == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t' || charAt == '\f' || charAt == '\b')) {
                    int i7 = i4 + 1;
                    int i8 = this.f158bp + i4;
                    charAt = i8 >= this.len ? EOI : this.text.charAt(i8);
                    i4 = i7;
                } else if (charAt != '}') {
                    this.matchStat = -1;
                    return false;
                } else {
                    int i9 = i4 + 1;
                    char charAt2 = charAt(this.f158bp + i4);
                    if (charAt2 == ',') {
                        this.token = 16;
                        int i10 = (i9 - 1) + this.f158bp;
                        this.f158bp = i10;
                        i3 = i10 + 1;
                        this.f158bp = i3;
                    } else if (charAt2 != ']') {
                        if (charAt2 == '}') {
                            this.token = 13;
                            int i11 = (i9 - 1) + this.f158bp;
                            this.f158bp = i11;
                            i3 = i11 + 1;
                            this.f158bp = i3;
                        } else if (charAt2 != 26) {
                            this.matchStat = -1;
                            return false;
                        } else {
                            this.token = 20;
                            this.f158bp = (i9 - 1) + this.f158bp;
                        }
                        this.f159ch = c;
                        this.matchStat = 4;
                        return z;
                    } else {
                        this.token = 15;
                        int i12 = (i9 - 1) + this.f158bp;
                        this.f158bp = i12;
                        i3 = i12 + 1;
                        this.f158bp = i3;
                    }
                }
            }
            int i13 = (i4 - 1) + this.f158bp;
            this.f158bp = i13;
            i2 = i13 + 1;
            this.f158bp = i2;
            if (i2 < this.len) {
                c = this.text.charAt(i2);
            }
            this.f159ch = c;
            this.matchStat = 3;
            this.token = 16;
            return z;
        }
        i = matchFieldHash + 5;
        z = false;
        int i42 = i + 1;
        int i52 = this.f158bp + i;
        int i62 = this.len;
        char c2 = EOI;
        if (i52 < i62) {
        }
        while (charAt != ',') {
        }
        int i132 = (i42 - 1) + this.f158bp;
        this.f158bp = i132;
        i2 = i132 + 1;
        this.f158bp = i2;
        if (i2 < this.len) {
        }
        this.f159ch = c2;
        this.matchStat = 3;
        this.token = 16;
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0104, code lost:
        if (r9 >= r13.len) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0107, code lost:
        r5 = r13.text.charAt(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0125, code lost:
        if (r9 >= r13.len) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x013b, code lost:
        if (r9 >= r13.len) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Date scanFieldDate(long j) {
        int i;
        char charAt;
        char c;
        int i2;
        Date date;
        int i3;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return null;
        }
        int i4 = this.f158bp;
        char c2 = this.f159ch;
        int i5 = matchFieldHash + 1;
        int i6 = matchFieldHash + i4;
        int i7 = this.len;
        char c3 = EOI;
        char charAt2 = i6 >= i7 ? EOI : this.text.charAt(i6);
        if (charAt2 == '\"') {
            int i8 = this.f158bp;
            int i9 = i8 + i5;
            int i10 = i5 + 1;
            int i11 = i8 + i5;
            if (i11 < this.len) {
                this.text.charAt(i11);
            }
            int indexOf = this.text.indexOf(34, this.f158bp + i10);
            if (indexOf == -1) {
                throw new JSONException("unclosed str");
            }
            int i12 = indexOf - i9;
            this.f158bp = i9;
            if (!scanISO8601DateIfMatch(false, i12)) {
                this.f158bp = i4;
                this.matchStat = -1;
                return null;
            }
            date = this.calendar.getTime();
            int i13 = i10 + i12;
            i2 = i13 + 1;
            c = charAt(i13 + i4);
            this.f158bp = i4;
        } else if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return null;
        } else {
            long j2 = charAt2 - '0';
            while (true) {
                i = i5 + 1;
                int i14 = this.f158bp + i5;
                charAt = i14 >= this.len ? EOI : this.text.charAt(i14);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j2 = (j2 * 10) + (charAt - '0');
                i5 = i;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return null;
            }
            if (charAt == '\"') {
                int i15 = i + 1;
                int i16 = this.f158bp + i;
                c = i16 >= this.len ? EOI : this.text.charAt(i16);
                i2 = i15;
            } else {
                c = charAt;
                i2 = i;
            }
            if (j2 < 0) {
                this.matchStat = -1;
                return null;
            }
            date = new Date(j2);
        }
        if (c == ',') {
            int i17 = (i2 - 1) + this.f158bp;
            this.f158bp = i17;
            int i18 = i17 + 1;
            this.f158bp = i18;
            if (i18 < this.len) {
                c3 = this.text.charAt(i18);
            }
            this.f159ch = c3;
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        if (c == '}') {
            int i19 = i2 + 1;
            char charAt3 = charAt(this.f158bp + i2);
            if (charAt3 == ',') {
                this.token = 16;
                int i20 = (i19 - 1) + this.f158bp;
                this.f158bp = i20;
                i3 = i20 + 1;
                this.f158bp = i3;
            } else if (charAt3 != ']') {
                if (charAt3 == '}') {
                    this.token = 13;
                    int i21 = (i19 - 1) + this.f158bp;
                    this.f158bp = i21;
                    i3 = i21 + 1;
                    this.f158bp = i3;
                } else if (charAt3 == 26) {
                    this.token = 20;
                    this.f158bp = (i19 - 1) + this.f158bp;
                }
                this.f159ch = c3;
                this.matchStat = 4;
                return date;
            } else {
                this.token = 15;
                int i22 = (i19 - 1) + this.f158bp;
                this.f158bp = i22;
                i3 = i22 + 1;
                this.f158bp = i3;
            }
        }
        this.f158bp = i4;
        this.f159ch = c2;
        this.matchStat = -1;
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00bd A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00b6 -> B:43:0x00bb). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final double scanFieldDouble(long j) {
        int i;
        char charAt;
        int i2;
        double parseDouble;
        int i3;
        int i4;
        char charAt2;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return RoundRectDrawableWithShadow.COS_45;
        }
        int i5 = matchFieldHash + 1;
        char charAt3 = charAt(this.f158bp + matchFieldHash);
        int i6 = (this.f158bp + i5) - 1;
        boolean z = charAt3 == '-';
        if (z) {
            charAt3 = charAt(this.f158bp + i5);
            i5++;
        }
        if (charAt3 < '0' || charAt3 > '9') {
            this.matchStat = -1;
            return RoundRectDrawableWithShadow.COS_45;
        }
        int i7 = charAt3 - '0';
        while (true) {
            i = i5 + 1;
            charAt = charAt(this.f158bp + i5);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i7 = (i7 * 10) + (charAt - '0');
            i5 = i;
        }
        if (charAt == '.') {
            int i8 = i + 1;
            char charAt4 = charAt(this.f158bp + i);
            if (charAt4 < '0' || charAt4 > '9') {
                this.matchStat = -1;
                return RoundRectDrawableWithShadow.COS_45;
            }
            i7 = (charAt4 - '0') + (i7 * 10);
            int i9 = 10;
            while (true) {
                i4 = i8 + 1;
                charAt2 = charAt(this.f158bp + i8);
                if (charAt2 < '0' || charAt2 > '9') {
                    break;
                }
                i7 = (i7 * 10) + (charAt2 - '0');
                i9 *= 10;
                i8 = i4;
            }
            i = i4;
            i2 = i9;
            charAt = charAt2;
        } else {
            i2 = 1;
        }
        boolean z2 = charAt == 'e' || charAt == 'E';
        if (z2) {
            int i10 = i + 1;
            charAt = charAt(this.f158bp + i);
            if (charAt == '+' || charAt == '-') {
                int i11 = i10 + 1;
                int i12 = this.f158bp + i10;
                charAt = charAt(i12);
                i = i11;
                if (charAt >= '0' && charAt <= '9') {
                    i11 = i + 1;
                    i12 = this.f158bp + i;
                    charAt = charAt(i12);
                    i = i11;
                    if (charAt >= '0') {
                        i11 = i + 1;
                        i12 = this.f158bp + i;
                        charAt = charAt(i12);
                        i = i11;
                        if (charAt >= '0') {
                        }
                    }
                }
            } else {
                i = i10;
                if (charAt >= '0') {
                }
            }
        }
        int i13 = ((this.f158bp + i) - i6) - 1;
        if (z2 || i13 >= 10) {
            parseDouble = Double.parseDouble(subString(i6, i13));
        } else {
            parseDouble = i7 / i2;
            if (z) {
                parseDouble = -parseDouble;
            }
        }
        if (charAt == ',') {
            this.f158bp = (i - 1) + this.f158bp;
            next();
            this.matchStat = 3;
            this.token = 16;
            return parseDouble;
        } else if (charAt != '}') {
            this.matchStat = -1;
            return RoundRectDrawableWithShadow.COS_45;
        } else {
            int i14 = i + 1;
            char charAt5 = charAt(this.f158bp + i);
            if (charAt5 == ',') {
                this.token = 16;
            } else {
                if (charAt5 == ']') {
                    i3 = 15;
                } else if (charAt5 != '}') {
                    if (charAt5 != 26) {
                        this.matchStat = -1;
                        return RoundRectDrawableWithShadow.COS_45;
                    }
                    this.f158bp = (i14 - 1) + this.f158bp;
                    this.token = 20;
                    this.f159ch = EOI;
                    this.matchStat = 4;
                    return parseDouble;
                } else {
                    i3 = 13;
                }
                this.token = i3;
            }
            this.f158bp = (i14 - 1) + this.f158bp;
            next();
            this.matchStat = 4;
            return parseDouble;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x00d1, code lost:
        r18.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x00d3, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01fd, code lost:
        r18.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01ff, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0123, code lost:
        if (r3 >= r18.len) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x010e, code lost:
        r3 = r18.text.charAt(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0114, code lost:
        r16 = r4;
        r4 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x010b, code lost:
        r3 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0109, code lost:
        if (r3 >= r18.len) goto L74;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0114 -> B:66:0x0117). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final double[] scanFieldDoubleArray(long j) {
        int i;
        char charAt;
        int i2;
        double parseDouble;
        int i3;
        int i4;
        int i5;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        double[] dArr = null;
        if (matchFieldHash == 0) {
            return null;
        }
        int i6 = matchFieldHash + 1;
        int i7 = this.f158bp + matchFieldHash;
        if ((i7 >= this.len ? EOI : this.text.charAt(i7)) != '[') {
            this.matchStat = -1;
            return null;
        }
        int i8 = i6 + 1;
        int i9 = this.f158bp + i6;
        char charAt2 = i9 >= this.len ? EOI : this.text.charAt(i9);
        double[] dArr2 = new double[16];
        int i10 = 0;
        while (true) {
            int i11 = (this.f158bp + i8) - 1;
            boolean z = charAt2 == '-';
            if (z) {
                int i12 = i8 + 1;
                int i13 = this.f158bp + i8;
                charAt2 = i13 >= this.len ? EOI : this.text.charAt(i13);
                i8 = i12;
            }
            if (charAt2 < '0' || charAt2 > '9') {
                break;
            }
            int i14 = charAt2 - '0';
            while (true) {
                i = i8 + 1;
                int i15 = this.f158bp + i8;
                charAt = i15 >= this.len ? EOI : this.text.charAt(i15);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i14 = (i14 * 10) + (charAt - '0');
                i8 = i;
            }
            if (charAt == '.') {
                int i16 = i + 1;
                int i17 = this.f158bp + i;
                char charAt3 = i17 >= this.len ? EOI : this.text.charAt(i17);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    i14 = (charAt3 - '0') + (i14 * 10);
                    i2 = 10;
                    while (true) {
                        i = i16 + 1;
                        int i18 = this.f158bp + i16;
                        charAt = i18 >= this.len ? EOI : this.text.charAt(i18);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i14 = (i14 * 10) + (charAt - '0');
                        i2 *= 10;
                        i16 = i;
                    }
                } else {
                    break;
                }
            } else {
                i2 = 1;
            }
            boolean z2 = charAt == 'e' || charAt == 'E';
            if (z2) {
                int i19 = i + 1;
                int i20 = this.f158bp + i;
                char charAt4 = i20 >= this.len ? EOI : this.text.charAt(i20);
                if (charAt4 == '+' || charAt4 == '-') {
                    i4 = i19 + 1;
                    i5 = this.f158bp + i19;
                } else {
                    charAt = charAt4;
                    i = i19;
                    if (charAt >= '0' && charAt <= '9') {
                        i4 = i + 1;
                        i5 = this.f158bp + i;
                    }
                }
            }
            int i21 = ((this.f158bp + i) - i11) - 1;
            if (z2 || i21 >= 10) {
                parseDouble = Double.parseDouble(subString(i11, i21));
            } else {
                parseDouble = i14 / i2;
                if (z) {
                    parseDouble = -parseDouble;
                }
            }
            if (i10 >= dArr2.length) {
                double[] dArr3 = new double[(dArr2.length * 3) / 2];
                System.arraycopy(dArr2, 0, dArr3, 0, i10);
                dArr2 = dArr3;
            }
            int i22 = i10 + 1;
            dArr2[i10] = parseDouble;
            if (charAt == ',') {
                int i23 = i + 1;
                int i24 = this.f158bp + i;
                charAt = i24 >= this.len ? EOI : this.text.charAt(i24);
                i = i23;
            } else if (charAt == ']') {
                int i25 = i + 1;
                int i26 = this.f158bp + i;
                char charAt5 = i26 >= this.len ? EOI : this.text.charAt(i26);
                if (i22 != dArr2.length) {
                    double[] dArr4 = new double[i22];
                    System.arraycopy(dArr2, 0, dArr4, 0, i22);
                    dArr2 = dArr4;
                }
                if (charAt5 == ',') {
                    this.f158bp = (i25 - 1) + this.f158bp;
                    next();
                    this.matchStat = 3;
                    this.token = 16;
                    return dArr2;
                } else if (charAt5 != '}') {
                    this.matchStat = -1;
                    return null;
                } else {
                    int i27 = i25 + 1;
                    int i28 = this.f158bp + i25;
                    char charAt6 = i28 >= this.len ? EOI : this.text.charAt(i28);
                    if (charAt6 == ',') {
                        i3 = 16;
                    } else if (charAt6 == ']') {
                        i3 = 15;
                    } else if (charAt6 != '}') {
                        if (charAt6 != 26) {
                            this.matchStat = -1;
                            return null;
                        }
                        this.f158bp = (i27 - 1) + this.f158bp;
                        this.token = 20;
                        this.f159ch = EOI;
                        this.matchStat = 4;
                        return dArr2;
                    } else {
                        i3 = 13;
                    }
                    this.token = i3;
                    this.f158bp = (i27 - 1) + this.f158bp;
                    next();
                    this.matchStat = 4;
                    return dArr2;
                }
            }
            dArr = null;
            charAt2 = charAt;
            i10 = i22;
            i8 = i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:168:0x00e4, code lost:
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x00e6, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0276, code lost:
        r4 = r3;
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0279, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0136, code lost:
        if (r3 >= r20.len) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0121, code lost:
        r3 = r20.text.charAt(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0127, code lost:
        r18 = r5;
        r5 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x011e, code lost:
        r3 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x011c, code lost:
        if (r3 >= r20.len) goto L81;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0127 -> B:68:0x012a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final double[][] scanFieldDoubleArray2(long j) {
        int i;
        char charAt;
        int i2;
        double parseDouble;
        int i3;
        int i4;
        int i5;
        int i6;
        double[][] dArr;
        double[][] dArr2;
        int i7;
        int i8;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        double[][] dArr3 = null;
        if (matchFieldHash == 0) {
            return null;
        }
        int i9 = matchFieldHash + 1;
        int i10 = this.f158bp + matchFieldHash;
        char charAt2 = i10 >= this.len ? EOI : this.text.charAt(i10);
        char c = '[';
        if (charAt2 != '[') {
            this.matchStat = -1;
            return null;
        }
        int i11 = i9 + 1;
        int i12 = this.f158bp + i9;
        char charAt3 = i12 >= this.len ? EOI : this.text.charAt(i12);
        int i13 = 16;
        double[][] dArr4 = new double[16];
        int i14 = 0;
        loop0: while (true) {
            if (charAt3 == c) {
                int i15 = i11 + 1;
                int i16 = this.f158bp + i11;
                char charAt4 = i16 >= this.len ? EOI : this.text.charAt(i16);
                double[] dArr5 = new double[i13];
                int i17 = 0;
                while (true) {
                    int i18 = (this.f158bp + i15) - 1;
                    boolean z = charAt4 == '-';
                    if (z) {
                        int i19 = i15 + 1;
                        int i20 = this.f158bp + i15;
                        charAt4 = i20 >= this.len ? EOI : this.text.charAt(i20);
                        i15 = i19;
                    }
                    if (charAt4 < '0' || charAt4 > '9') {
                        break loop0;
                    }
                    int i21 = charAt4 - '0';
                    while (true) {
                        i = i15 + 1;
                        int i22 = this.f158bp + i15;
                        charAt = i22 >= this.len ? EOI : this.text.charAt(i22);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i21 = (i21 * 10) + (charAt - '0');
                        i15 = i;
                    }
                    if (charAt == '.') {
                        int i23 = i + 1;
                        int i24 = this.f158bp + i;
                        char charAt5 = i24 >= this.len ? EOI : this.text.charAt(i24);
                        if (charAt5 >= '0' && charAt5 <= '9') {
                            i21 = (charAt5 - '0') + (i21 * 10);
                            i2 = 10;
                            while (true) {
                                i = i23 + 1;
                                int i25 = this.f158bp + i23;
                                charAt = i25 >= this.len ? EOI : this.text.charAt(i25);
                                if (charAt < '0' || charAt > '9') {
                                    break;
                                }
                                i21 = (i21 * 10) + (charAt - '0');
                                i2 *= 10;
                                i23 = i;
                            }
                        } else {
                            break loop0;
                        }
                    } else {
                        i2 = 1;
                    }
                    boolean z2 = charAt == 'e' || charAt == 'E';
                    if (z2) {
                        int i26 = i + 1;
                        int i27 = this.f158bp + i;
                        char charAt6 = i27 >= this.len ? EOI : this.text.charAt(i27);
                        if (charAt6 == '+' || charAt6 == '-') {
                            i7 = i26 + 1;
                            i8 = this.f158bp + i26;
                        } else {
                            charAt = charAt6;
                            i = i26;
                            if (charAt >= '0' && charAt <= '9') {
                                i7 = i + 1;
                                i8 = this.f158bp + i;
                            }
                        }
                    }
                    int i28 = ((this.f158bp + i) - i18) - 1;
                    if (z2 || i28 >= 10) {
                        parseDouble = Double.parseDouble(subString(i18, i28));
                    } else {
                        parseDouble = i21 / i2;
                        if (z) {
                            parseDouble = -parseDouble;
                        }
                    }
                    if (i17 >= dArr5.length) {
                        double[] dArr6 = new double[(dArr5.length * 3) / 2];
                        System.arraycopy(dArr5, 0, dArr6, 0, i17);
                        dArr5 = dArr6;
                    }
                    int i29 = i17 + 1;
                    dArr5[i17] = parseDouble;
                    if (charAt == ',') {
                        int i30 = i + 1;
                        int i31 = this.f158bp + i;
                        charAt4 = i31 >= this.len ? EOI : this.text.charAt(i31);
                        i15 = i30;
                        dArr2 = null;
                    } else if (charAt == ']') {
                        int i32 = i + 1;
                        int i33 = this.f158bp + i;
                        char charAt7 = i33 >= this.len ? EOI : this.text.charAt(i33);
                        if (i29 != dArr5.length) {
                            double[] dArr7 = new double[i29];
                            i3 = 0;
                            System.arraycopy(dArr5, 0, dArr7, 0, i29);
                            dArr5 = dArr7;
                        } else {
                            i3 = 0;
                        }
                        if (i14 >= dArr4.length) {
                            dArr4 = new double[(dArr4.length * 3) / 2];
                            System.arraycopy(dArr5, i3, dArr4, i3, i29);
                        }
                        int i34 = i14 + 1;
                        dArr4[i14] = dArr5;
                        if (charAt7 == ',') {
                            int i35 = i32 + 1;
                            int i36 = this.f158bp + i32;
                            charAt3 = i36 >= this.len ? EOI : this.text.charAt(i36);
                            i11 = i35;
                            dArr = null;
                        } else if (charAt7 == ']') {
                            int i37 = i32 + 1;
                            int i38 = this.f158bp + i32;
                            char charAt8 = i38 >= this.len ? EOI : this.text.charAt(i38);
                            if (i34 != dArr4.length) {
                                double[][] dArr8 = new double[i34];
                                System.arraycopy(dArr4, 0, dArr8, 0, i34);
                                dArr4 = dArr8;
                            }
                            if (charAt8 == ',') {
                                this.f158bp = (i37 - 1) + this.f158bp;
                                next();
                                this.matchStat = 3;
                                this.token = 16;
                                return dArr4;
                            } else if (charAt8 != '}') {
                                this.matchStat = -1;
                                return null;
                            } else {
                                int i39 = i37 + 1;
                                char charAt9 = charAt(this.f158bp + i37);
                                if (charAt9 == ',') {
                                    this.token = 16;
                                    i6 = this.f158bp;
                                    i4 = 1;
                                } else {
                                    i4 = 1;
                                    if (charAt9 == ']') {
                                        i5 = 15;
                                    } else if (charAt9 != '}') {
                                        if (charAt9 != 26) {
                                            this.matchStat = -1;
                                            return null;
                                        }
                                        this.f158bp = (i39 - 1) + this.f158bp;
                                        this.token = 20;
                                        this.f159ch = EOI;
                                        this.matchStat = 4;
                                        return dArr4;
                                    } else {
                                        i5 = 13;
                                    }
                                    this.token = i5;
                                    i6 = this.f158bp;
                                }
                                this.f158bp = (i39 - i4) + i6;
                                next();
                                this.matchStat = 4;
                                return dArr4;
                            }
                        } else {
                            dArr = null;
                            charAt3 = charAt7;
                            i11 = i32;
                        }
                        i14 = i34;
                        dArr3 = dArr;
                        c = '[';
                        i13 = 16;
                    } else {
                        dArr2 = null;
                        charAt4 = charAt;
                        i15 = i;
                    }
                    i17 = i29;
                    dArr3 = dArr2;
                }
            } else {
                c = '[';
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00ae -> B:42:0x00b3). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float scanFieldFloat(long j) {
        int i;
        char charAt;
        int i2;
        float parseFloat;
        int i3;
        char charAt2;
        boolean z = false;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return 0.0f;
        }
        int i4 = matchFieldHash + 1;
        char charAt3 = charAt(this.f158bp + matchFieldHash);
        int i5 = (this.f158bp + i4) - 1;
        boolean z2 = charAt3 == '-';
        if (z2) {
            charAt3 = charAt(this.f158bp + i4);
            i4++;
        }
        if (charAt3 < '0' || charAt3 > '9') {
            this.matchStat = -1;
            return 0.0f;
        }
        int i6 = charAt3 - '0';
        while (true) {
            i = i4 + 1;
            charAt = charAt(this.f158bp + i4);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i6 = (i6 * 10) + (charAt - '0');
            i4 = i;
        }
        if (charAt == '.') {
            int i7 = i + 1;
            char charAt4 = charAt(this.f158bp + i);
            if (charAt4 < '0' || charAt4 > '9') {
                this.matchStat = -1;
                return 0.0f;
            }
            i6 = (charAt4 - '0') + (i6 * 10);
            int i8 = 10;
            while (true) {
                i3 = i7 + 1;
                charAt2 = charAt(this.f158bp + i7);
                if (charAt2 < '0' || charAt2 > '9') {
                    break;
                }
                i6 = (i6 * 10) + (charAt2 - '0');
                i8 *= 10;
                i7 = i3;
            }
            i = i3;
            i2 = i8;
            charAt = charAt2;
        } else {
            i2 = 1;
        }
        if (charAt == 'e' || charAt == 'E') {
            z = true;
        }
        if (z) {
            int i9 = i + 1;
            charAt = charAt(this.f158bp + i);
            if (charAt == '+' || charAt == '-') {
                int i10 = i9 + 1;
                int i11 = this.f158bp + i9;
                charAt = charAt(i11);
                i = i10;
                if (charAt >= '0' && charAt <= '9') {
                    i10 = i + 1;
                    i11 = this.f158bp + i;
                    charAt = charAt(i11);
                    i = i10;
                    if (charAt >= '0') {
                        i10 = i + 1;
                        i11 = this.f158bp + i;
                        charAt = charAt(i11);
                        i = i10;
                        if (charAt >= '0') {
                        }
                    }
                }
            } else {
                i = i9;
                if (charAt >= '0') {
                }
            }
        }
        int i12 = ((this.f158bp + i) - i5) - 1;
        if (z || i12 >= 10) {
            parseFloat = Float.parseFloat(subString(i5, i12));
        } else {
            parseFloat = i6 / i2;
            if (z2) {
                parseFloat = -parseFloat;
            }
        }
        int i13 = 16;
        if (charAt == ',') {
            this.f158bp = (i - 1) + this.f158bp;
            next();
            this.matchStat = 3;
            this.token = 16;
            return parseFloat;
        } else if (charAt != '}') {
            this.matchStat = -1;
            return 0.0f;
        } else {
            int i14 = i + 1;
            char charAt5 = charAt(this.f158bp + i);
            if (charAt5 != ',') {
                if (charAt5 == ']') {
                    i13 = 15;
                } else if (charAt5 != '}') {
                    if (charAt5 != 26) {
                        this.matchStat = -1;
                        return 0.0f;
                    }
                    this.f158bp = (i14 - 1) + this.f158bp;
                    this.token = 20;
                    this.f159ch = EOI;
                    this.matchStat = 4;
                    return parseFloat;
                } else {
                    i13 = 13;
                }
            }
            this.token = i13;
            this.f158bp = (i14 - 1) + this.f158bp;
            next();
            this.matchStat = 4;
            return parseFloat;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x00d1, code lost:
        r18.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x00d3, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01fd, code lost:
        r18.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01ff, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0123, code lost:
        if (r3 >= r18.len) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x010e, code lost:
        r3 = r18.text.charAt(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0114, code lost:
        r16 = r4;
        r4 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x010b, code lost:
        r3 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0109, code lost:
        if (r3 >= r18.len) goto L74;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0114 -> B:66:0x0117). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float[] scanFieldFloatArray(long j) {
        int i;
        char charAt;
        int i2;
        float parseFloat;
        int i3;
        int i4;
        int i5;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        float[] fArr = null;
        if (matchFieldHash == 0) {
            return null;
        }
        int i6 = matchFieldHash + 1;
        int i7 = this.f158bp + matchFieldHash;
        if ((i7 >= this.len ? EOI : this.text.charAt(i7)) != '[') {
            this.matchStat = -1;
            return null;
        }
        int i8 = i6 + 1;
        int i9 = this.f158bp + i6;
        char charAt2 = i9 >= this.len ? EOI : this.text.charAt(i9);
        float[] fArr2 = new float[16];
        int i10 = 0;
        while (true) {
            int i11 = (this.f158bp + i8) - 1;
            boolean z = charAt2 == '-';
            if (z) {
                int i12 = i8 + 1;
                int i13 = this.f158bp + i8;
                charAt2 = i13 >= this.len ? EOI : this.text.charAt(i13);
                i8 = i12;
            }
            if (charAt2 < '0' || charAt2 > '9') {
                break;
            }
            int i14 = charAt2 - '0';
            while (true) {
                i = i8 + 1;
                int i15 = this.f158bp + i8;
                charAt = i15 >= this.len ? EOI : this.text.charAt(i15);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i14 = (i14 * 10) + (charAt - '0');
                i8 = i;
            }
            if (charAt == '.') {
                int i16 = i + 1;
                int i17 = this.f158bp + i;
                char charAt3 = i17 >= this.len ? EOI : this.text.charAt(i17);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    i14 = (charAt3 - '0') + (i14 * 10);
                    i2 = 10;
                    while (true) {
                        i = i16 + 1;
                        int i18 = this.f158bp + i16;
                        charAt = i18 >= this.len ? EOI : this.text.charAt(i18);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i14 = (i14 * 10) + (charAt - '0');
                        i2 *= 10;
                        i16 = i;
                    }
                } else {
                    break;
                }
            } else {
                i2 = 1;
            }
            boolean z2 = charAt == 'e' || charAt == 'E';
            if (z2) {
                int i19 = i + 1;
                int i20 = this.f158bp + i;
                char charAt4 = i20 >= this.len ? EOI : this.text.charAt(i20);
                if (charAt4 == '+' || charAt4 == '-') {
                    i4 = i19 + 1;
                    i5 = this.f158bp + i19;
                } else {
                    charAt = charAt4;
                    i = i19;
                    if (charAt >= '0' && charAt <= '9') {
                        i4 = i + 1;
                        i5 = this.f158bp + i;
                    }
                }
            }
            int i21 = ((this.f158bp + i) - i11) - 1;
            if (z2 || i21 >= 10) {
                parseFloat = Float.parseFloat(subString(i11, i21));
            } else {
                parseFloat = i14 / i2;
                if (z) {
                    parseFloat = -parseFloat;
                }
            }
            if (i10 >= fArr2.length) {
                float[] fArr3 = new float[(fArr2.length * 3) / 2];
                System.arraycopy(fArr2, 0, fArr3, 0, i10);
                fArr2 = fArr3;
            }
            int i22 = i10 + 1;
            fArr2[i10] = parseFloat;
            if (charAt == ',') {
                int i23 = i + 1;
                int i24 = this.f158bp + i;
                charAt = i24 >= this.len ? EOI : this.text.charAt(i24);
                i = i23;
            } else if (charAt == ']') {
                int i25 = i + 1;
                int i26 = this.f158bp + i;
                char charAt5 = i26 >= this.len ? EOI : this.text.charAt(i26);
                if (i22 != fArr2.length) {
                    float[] fArr4 = new float[i22];
                    System.arraycopy(fArr2, 0, fArr4, 0, i22);
                    fArr2 = fArr4;
                }
                if (charAt5 == ',') {
                    this.f158bp = (i25 - 1) + this.f158bp;
                    next();
                    this.matchStat = 3;
                    this.token = 16;
                    return fArr2;
                } else if (charAt5 != '}') {
                    this.matchStat = -1;
                    return null;
                } else {
                    int i27 = i25 + 1;
                    int i28 = this.f158bp + i25;
                    char charAt6 = i28 >= this.len ? EOI : this.text.charAt(i28);
                    if (charAt6 == ',') {
                        i3 = 16;
                    } else if (charAt6 == ']') {
                        i3 = 15;
                    } else if (charAt6 != '}') {
                        if (charAt6 != 26) {
                            this.matchStat = -1;
                            return null;
                        }
                        this.f158bp = (i27 - 1) + this.f158bp;
                        this.token = 20;
                        this.f159ch = EOI;
                        this.matchStat = 4;
                        return fArr2;
                    } else {
                        i3 = 13;
                    }
                    this.token = i3;
                    this.f158bp = (i27 - 1) + this.f158bp;
                    next();
                    this.matchStat = 4;
                    return fArr2;
                }
            }
            fArr = null;
            charAt2 = charAt;
            i10 = i22;
            i8 = i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:167:0x00e4, code lost:
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x00e6, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0272, code lost:
        r12 = r3;
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0275, code lost:
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0136, code lost:
        if (r3 >= r20.len) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0121, code lost:
        r3 = r20.text.charAt(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0127, code lost:
        r18 = r5;
        r5 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x011e, code lost:
        r3 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x011c, code lost:
        if (r3 >= r20.len) goto L81;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0127 -> B:68:0x012a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float[][] scanFieldFloatArray2(long j) {
        int i;
        char charAt;
        int i2;
        float parseFloat;
        int i3;
        int i4;
        float[][] fArr;
        float[][] fArr2;
        int i5;
        int i6;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        float[][] fArr3 = null;
        if (matchFieldHash == 0) {
            return null;
        }
        int i7 = matchFieldHash + 1;
        int i8 = this.f158bp + matchFieldHash;
        char charAt2 = i8 >= this.len ? EOI : this.text.charAt(i8);
        char c = '[';
        if (charAt2 != '[') {
            this.matchStat = -1;
            return null;
        }
        int i9 = i7 + 1;
        int i10 = this.f158bp + i7;
        char charAt3 = i10 >= this.len ? EOI : this.text.charAt(i10);
        int i11 = 16;
        float[][] fArr4 = new float[16];
        int i12 = 0;
        loop0: while (true) {
            if (charAt3 == c) {
                int i13 = i9 + 1;
                int i14 = this.f158bp + i9;
                char charAt4 = i14 >= this.len ? EOI : this.text.charAt(i14);
                float[] fArr5 = new float[i11];
                int i15 = 0;
                while (true) {
                    int i16 = (this.f158bp + i13) - 1;
                    boolean z = charAt4 == '-';
                    if (z) {
                        int i17 = i13 + 1;
                        int i18 = this.f158bp + i13;
                        charAt4 = i18 >= this.len ? EOI : this.text.charAt(i18);
                        i13 = i17;
                    }
                    if (charAt4 < '0' || charAt4 > '9') {
                        break loop0;
                    }
                    int i19 = charAt4 - '0';
                    while (true) {
                        i = i13 + 1;
                        int i20 = this.f158bp + i13;
                        charAt = i20 >= this.len ? EOI : this.text.charAt(i20);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i19 = (i19 * 10) + (charAt - '0');
                        i13 = i;
                    }
                    if (charAt == '.') {
                        int i21 = i + 1;
                        int i22 = this.f158bp + i;
                        char charAt5 = i22 >= this.len ? EOI : this.text.charAt(i22);
                        if (charAt5 >= '0' && charAt5 <= '9') {
                            i19 = (charAt5 - '0') + (i19 * 10);
                            i2 = 10;
                            while (true) {
                                i = i21 + 1;
                                int i23 = this.f158bp + i21;
                                charAt = i23 >= this.len ? EOI : this.text.charAt(i23);
                                if (charAt < '0' || charAt > '9') {
                                    break;
                                }
                                i19 = (i19 * 10) + (charAt - '0');
                                i2 *= 10;
                                i21 = i;
                            }
                        } else {
                            break loop0;
                        }
                    } else {
                        i2 = 1;
                    }
                    boolean z2 = charAt == 'e' || charAt == 'E';
                    if (z2) {
                        int i24 = i + 1;
                        int i25 = this.f158bp + i;
                        char charAt6 = i25 >= this.len ? EOI : this.text.charAt(i25);
                        if (charAt6 == '+' || charAt6 == '-') {
                            i5 = i24 + 1;
                            i6 = this.f158bp + i24;
                        } else {
                            charAt = charAt6;
                            i = i24;
                            if (charAt >= '0' && charAt <= '9') {
                                i5 = i + 1;
                                i6 = this.f158bp + i;
                            }
                        }
                    }
                    int i26 = ((this.f158bp + i) - i16) - 1;
                    if (z2 || i26 >= 10) {
                        parseFloat = Float.parseFloat(subString(i16, i26));
                    } else {
                        parseFloat = i19 / i2;
                        if (z) {
                            parseFloat = -parseFloat;
                        }
                    }
                    if (i15 >= fArr5.length) {
                        float[] fArr6 = new float[(fArr5.length * 3) / 2];
                        System.arraycopy(fArr5, 0, fArr6, 0, i15);
                        fArr5 = fArr6;
                    }
                    int i27 = i15 + 1;
                    fArr5[i15] = parseFloat;
                    if (charAt == ',') {
                        int i28 = i + 1;
                        int i29 = this.f158bp + i;
                        charAt4 = i29 >= this.len ? EOI : this.text.charAt(i29);
                        i = i28;
                        fArr2 = null;
                    } else if (charAt == ']') {
                        int i30 = i + 1;
                        int i31 = this.f158bp + i;
                        char charAt7 = i31 >= this.len ? EOI : this.text.charAt(i31);
                        if (i27 != fArr5.length) {
                            float[] fArr7 = new float[i27];
                            i3 = 0;
                            System.arraycopy(fArr5, 0, fArr7, 0, i27);
                            fArr5 = fArr7;
                        } else {
                            i3 = 0;
                        }
                        if (i12 >= fArr4.length) {
                            fArr4 = new float[(fArr4.length * 3) / 2];
                            System.arraycopy(fArr5, i3, fArr4, i3, i27);
                        }
                        int i32 = i12 + 1;
                        fArr4[i12] = fArr5;
                        if (charAt7 == ',') {
                            int i33 = i30 + 1;
                            int i34 = this.f158bp + i30;
                            charAt3 = i34 >= this.len ? EOI : this.text.charAt(i34);
                            i9 = i33;
                            fArr = null;
                        } else if (charAt7 == ']') {
                            int i35 = i30 + 1;
                            int i36 = this.f158bp + i30;
                            char charAt8 = i36 >= this.len ? EOI : this.text.charAt(i36);
                            if (i32 != fArr4.length) {
                                float[][] fArr8 = new float[i32];
                                System.arraycopy(fArr4, 0, fArr8, 0, i32);
                                fArr4 = fArr8;
                            }
                            if (charAt8 == ',') {
                                this.f158bp = (i35 - 1) + this.f158bp;
                                next();
                                this.matchStat = 3;
                                this.token = 16;
                                return fArr4;
                            } else if (charAt8 != '}') {
                                this.matchStat = -1;
                                return null;
                            } else {
                                int i37 = i35 + 1;
                                char charAt9 = charAt(this.f158bp + i35);
                                if (charAt9 == ',') {
                                    this.token = 16;
                                } else {
                                    if (charAt9 == ']') {
                                        i4 = 15;
                                    } else if (charAt9 != '}') {
                                        if (charAt9 != 26) {
                                            this.matchStat = -1;
                                            return null;
                                        }
                                        this.f158bp = (i37 - 1) + this.f158bp;
                                        this.token = 20;
                                        this.f159ch = EOI;
                                        this.matchStat = 4;
                                        return fArr4;
                                    } else {
                                        i4 = 13;
                                    }
                                    this.token = i4;
                                }
                                this.f158bp = (i37 - 1) + this.f158bp;
                                next();
                                this.matchStat = 4;
                                return fArr4;
                            }
                        } else {
                            fArr = null;
                            charAt3 = charAt7;
                            i9 = i30;
                        }
                        i12 = i32;
                        fArr3 = fArr;
                        c = '[';
                        i11 = 16;
                    } else {
                        fArr2 = null;
                        charAt4 = charAt;
                    }
                    fArr3 = fArr2;
                    i13 = i;
                    i15 = i27;
                }
            } else {
                c = '[';
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0116, code lost:
        if (r9 >= r11.len) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0119, code lost:
        r2 = r11.text.charAt(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0135, code lost:
        if (r9 >= r11.len) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0147, code lost:
        if (r9 >= r11.len) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int scanFieldInt(long j) {
        int i;
        char charAt;
        int i2;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return 0;
        }
        int i3 = matchFieldHash + 1;
        int i4 = this.f158bp + matchFieldHash;
        int i5 = this.len;
        char c = EOI;
        char charAt2 = i4 >= i5 ? EOI : this.text.charAt(i4);
        boolean z = charAt2 == '\"';
        if (z) {
            int i6 = i3 + 1;
            int i7 = this.f158bp + i3;
            charAt2 = i7 >= this.len ? EOI : this.text.charAt(i7);
            i3 = i6;
            z = true;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            int i8 = i3 + 1;
            int i9 = this.f158bp + i3;
            charAt2 = i9 >= this.len ? EOI : this.text.charAt(i9);
            i3 = i8;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i10 = charAt2 - '0';
        while (true) {
            i = i3 + 1;
            int i11 = this.f158bp + i3;
            charAt = i11 >= this.len ? EOI : this.text.charAt(i11);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i10 = (i10 * 10) + (charAt - '0');
            i3 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (charAt == '\"') {
            if (!z) {
                this.matchStat = -1;
                return 0;
            }
            int i12 = i + 1;
            int i13 = this.f158bp + i;
            i = i12;
            charAt = i13 >= this.len ? EOI : this.text.charAt(i13);
        }
        if (i10 < 0) {
            this.matchStat = -1;
            return 0;
        }
        while (charAt != ',') {
            if (charAt <= ' ' && (charAt == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t' || charAt == '\f' || charAt == '\b')) {
                int i14 = i + 1;
                int i15 = this.f158bp + i;
                i = i14;
                charAt = i15 >= this.len ? EOI : this.text.charAt(i15);
            } else if (charAt != '}') {
                this.matchStat = -1;
                return 0;
            } else {
                int i16 = i + 1;
                char charAt3 = charAt(this.f158bp + i);
                if (charAt3 == ',') {
                    this.token = 16;
                    int i17 = (i16 - 1) + this.f158bp;
                    this.f158bp = i17;
                    i2 = i17 + 1;
                    this.f158bp = i2;
                } else if (charAt3 != ']') {
                    if (charAt3 == '}') {
                        this.token = 13;
                        int i18 = (i16 - 1) + this.f158bp;
                        this.f158bp = i18;
                        i2 = i18 + 1;
                        this.f158bp = i2;
                    } else if (charAt3 != 26) {
                        this.matchStat = -1;
                        return 0;
                    } else {
                        this.token = 20;
                        this.f158bp = (i16 - 1) + this.f158bp;
                    }
                    this.f159ch = c;
                    this.matchStat = 4;
                    return z2 ? -i10 : i10;
                } else {
                    this.token = 15;
                    int i19 = (i16 - 1) + this.f158bp;
                    this.f158bp = i19;
                    i2 = i19 + 1;
                    this.f158bp = i2;
                }
            }
        }
        int i20 = (i - 1) + this.f158bp;
        this.f158bp = i20;
        int i21 = i20 + 1;
        this.f158bp = i21;
        if (i21 < this.len) {
            c = this.text.charAt(i21);
        }
        this.f159ch = c;
        this.matchStat = 3;
        this.token = 16;
        return z2 ? -i10 : i10;
    }

    public final int[] scanFieldIntArray(long j) {
        boolean z;
        int[] iArr;
        int i;
        int i2;
        char charAt;
        int i3;
        int i4;
        char charAt2;
        int[] iArr2;
        int i5;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        int[] iArr3 = null;
        if (matchFieldHash == 0) {
            return null;
        }
        int i6 = matchFieldHash + 1;
        int i7 = this.f158bp + matchFieldHash;
        if ((i7 >= this.len ? EOI : this.text.charAt(i7)) != '[') {
            this.matchStat = -1;
            return null;
        }
        int i8 = i6 + 1;
        int i9 = this.f158bp + i6;
        char charAt3 = i9 >= this.len ? EOI : this.text.charAt(i9);
        int[] iArr4 = new int[16];
        if (charAt3 != ']') {
            int i10 = 0;
            while (true) {
                if (charAt3 == '-') {
                    int i11 = i8 + 1;
                    int i12 = this.f158bp + i8;
                    charAt3 = i12 >= this.len ? EOI : this.text.charAt(i12);
                    i8 = i11;
                    z = true;
                } else {
                    z = false;
                }
                if (charAt3 < '0') {
                    iArr = iArr3;
                    i = -1;
                    break;
                } else if (charAt3 > '9') {
                    i = -1;
                    iArr = null;
                    break;
                } else {
                    int i13 = charAt3 - '0';
                    while (true) {
                        i2 = i8 + 1;
                        int i14 = this.f158bp + i8;
                        charAt = i14 >= this.len ? EOI : this.text.charAt(i14);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i13 = (i13 * 10) + (charAt - '0');
                        i8 = i2;
                    }
                    if (i10 >= iArr4.length) {
                        int[] iArr5 = new int[(iArr4.length * 3) / 2];
                        System.arraycopy(iArr4, 0, iArr5, 0, i10);
                        iArr4 = iArr5;
                    }
                    i3 = i10 + 1;
                    if (z) {
                        i13 = -i13;
                    }
                    iArr4[i10] = i13;
                    if (charAt == ',') {
                        int i15 = i2 + 1;
                        int i16 = this.f158bp + i2;
                        i2 = i15;
                        iArr2 = null;
                        charAt = i16 >= this.len ? EOI : this.text.charAt(i16);
                    } else if (charAt == ']') {
                        i4 = i2 + 1;
                        int i17 = this.f158bp + i2;
                        charAt2 = i17 >= this.len ? EOI : this.text.charAt(i17);
                    } else {
                        iArr2 = null;
                    }
                    i10 = i3;
                    charAt3 = charAt;
                    iArr3 = iArr2;
                    i8 = i2;
                }
            }
            this.matchStat = i;
            return iArr;
        }
        i4 = i8 + 1;
        int i18 = this.f158bp + i8;
        charAt2 = i18 >= this.len ? EOI : this.text.charAt(i18);
        i3 = 0;
        if (i3 != iArr4.length) {
            int[] iArr6 = new int[i3];
            System.arraycopy(iArr4, 0, iArr6, 0, i3);
            iArr4 = iArr6;
        }
        if (charAt2 == ',') {
            this.f158bp = (i4 - 1) + this.f158bp;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr4;
        } else if (charAt2 != '}') {
            this.matchStat = -1;
            return null;
        } else {
            int i19 = i4 + 1;
            char charAt4 = charAt(this.f158bp + i4);
            if (charAt4 == ',') {
                this.token = 16;
            } else {
                if (charAt4 == ']') {
                    i5 = 15;
                } else if (charAt4 != '}') {
                    if (charAt4 != 26) {
                        this.matchStat = -1;
                        return null;
                    }
                    this.f158bp = (i19 - 1) + this.f158bp;
                    this.token = 20;
                    this.f159ch = EOI;
                    this.matchStat = 4;
                    return iArr4;
                } else {
                    i5 = 13;
                }
                this.token = i5;
            }
            this.f158bp = (i19 - 1) + this.f158bp;
            next();
            this.matchStat = 4;
            return iArr4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ee, code lost:
        if (r8 >= r18.len) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f0, code lost:
        r7 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00f3, code lost:
        r7 = r18.text.charAt(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0110, code lost:
        if (r8 >= r18.len) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0125, code lost:
        if (r8 >= r18.len) goto L72;
     */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long scanFieldLong(long j) {
        int i;
        char charAt;
        int i2;
        char charAt2;
        boolean z = false;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return 0L;
        }
        int i3 = matchFieldHash + 1;
        int i4 = this.f158bp + matchFieldHash;
        char charAt3 = i4 >= this.len ? EOI : this.text.charAt(i4);
        boolean z2 = charAt3 == '\"';
        if (z2) {
            int i5 = i3 + 1;
            int i6 = this.f158bp + i3;
            charAt3 = i6 >= this.len ? EOI : this.text.charAt(i6);
            i3 = i5;
        }
        if (charAt3 == '-') {
            z = true;
        }
        if (z) {
            int i7 = i3 + 1;
            int i8 = this.f158bp + i3;
            charAt3 = i8 >= this.len ? EOI : this.text.charAt(i8);
            i3 = i7;
        }
        if (charAt3 < '0' || charAt3 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j2 = charAt3 - '0';
        while (true) {
            i = i3 + 1;
            int i9 = this.f158bp + i3;
            charAt = i9 >= this.len ? EOI : this.text.charAt(i9);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j2 = (j2 * 10) + (charAt - '0');
            i3 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (charAt == '\"') {
            if (!z2) {
                this.matchStat = -1;
                return 0L;
            }
            int i10 = i + 1;
            int i11 = this.f158bp + i;
            charAt = i11 >= this.len ? EOI : this.text.charAt(i11);
            i = i10;
        }
        if (j2 < 0) {
            this.matchStat = -1;
            return 0L;
        } else if (charAt == ',') {
            int i12 = (i - 1) + this.f158bp;
            this.f158bp = i12;
            int i13 = i12 + 1;
            this.f158bp = i13;
            this.f159ch = i13 >= this.len ? EOI : this.text.charAt(i13);
            this.matchStat = 3;
            this.token = 16;
            return z ? -j2 : j2;
        } else if (charAt != '}') {
            this.matchStat = -1;
            return 0L;
        } else {
            int i14 = i + 1;
            char charAt4 = charAt(this.f158bp + i);
            if (charAt4 == ',') {
                this.token = 16;
                int i15 = (i14 - 1) + this.f158bp;
                this.f158bp = i15;
                i2 = i15 + 1;
                this.f158bp = i2;
            } else if (charAt4 == ']') {
                this.token = 15;
                int i16 = (i14 - 1) + this.f158bp;
                this.f158bp = i16;
                i2 = i16 + 1;
                this.f158bp = i2;
            } else if (charAt4 != '}') {
                if (charAt4 != 26) {
                    this.matchStat = -1;
                    return 0L;
                }
                this.token = 20;
                this.f158bp = (i14 - 1) + this.f158bp;
                this.f159ch = EOI;
                this.matchStat = 4;
                return !z ? -j2 : j2;
            } else {
                this.token = 13;
                int i17 = (i14 - 1) + this.f158bp;
                this.f158bp = i17;
                i2 = i17 + 1;
                this.f158bp = i2;
            }
            this.f159ch = charAt2;
            this.matchStat = 4;
            if (!z) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
        if (r2.indexOf(92) != (-1)) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String scanFieldString(long j) {
        String str;
        int i;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return null;
        }
        int i2 = matchFieldHash + 1;
        int i3 = this.f158bp + matchFieldHash;
        if (i3 >= this.len) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unclosed str, ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(info());
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        if (this.text.charAt(i3) == '\"') {
            int i4 = this.f158bp + i2;
            int indexOf = this.text.indexOf(34, i4);
            if (indexOf == -1) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unclosed str, ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(info());
                throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            }
            if (f157V6) {
                str = this.text.substring(i4, indexOf);
            } else {
                int i5 = indexOf - i4;
                str = new String(sub_chars(this.f158bp + i2, i5), 0, i5);
            }
            if (str.indexOf(92) != -1) {
                boolean z = false;
                while (true) {
                    int i6 = indexOf - 1;
                    int i7 = 0;
                    while (i6 >= 0 && this.text.charAt(i6) == '\\') {
                        i7++;
                        i6--;
                        z = true;
                    }
                    if (i7 % 2 == 0) {
                        break;
                    }
                    indexOf = this.text.indexOf(34, indexOf + 1);
                }
                int i8 = indexOf - i4;
                char[] sub_chars = sub_chars(this.f158bp + i2, i8);
                if (!z) {
                    str = new String(sub_chars, 0, i8);
                }
                str = readString(sub_chars, i8);
            }
            int i9 = indexOf + 1;
            int i10 = this.len;
            char c = EOI;
            char charAt = i9 >= i10 ? EOI : this.text.charAt(i9);
            if (charAt == ',') {
                this.f158bp = i9;
                int i11 = i9 + 1;
                this.f158bp = i11;
                if (i11 < this.len) {
                    c = this.text.charAt(i11);
                }
                this.f159ch = c;
                this.matchStat = 3;
                this.token = 16;
                return str;
            } else if (charAt == '}') {
                int i12 = i9 + 1;
                char charAt2 = i12 >= this.len ? EOI : this.text.charAt(i12);
                if (charAt2 == ',') {
                    this.token = 16;
                } else {
                    if (charAt2 == ']') {
                        i = 15;
                    } else if (charAt2 == '}') {
                        i = 13;
                    } else if (charAt2 == 26) {
                        this.token = 20;
                        this.f158bp = i12;
                        this.f159ch = EOI;
                        this.matchStat = 4;
                        return str;
                    }
                    this.token = i;
                }
                this.f158bp = i12;
                next();
                this.matchStat = 4;
                return str;
            }
        }
        this.matchStat = -1;
        return this.stringDefaultValue;
    }

    public long scanFieldSymbol(long j) {
        int i;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return 0L;
        }
        int i2 = matchFieldHash + 1;
        int i3 = this.f158bp + matchFieldHash;
        int i4 = this.len;
        char c = EOI;
        if ((i3 >= i4 ? EOI : this.text.charAt(i3)) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j2 = -3750763034362895579L;
        while (true) {
            int i5 = i2 + 1;
            int i6 = this.f158bp + i2;
            char charAt = i6 >= this.len ? EOI : this.text.charAt(i6);
            if (charAt == '\"') {
                int i7 = i5 + 1;
                int i8 = this.f158bp + i5;
                char charAt2 = i8 >= this.len ? EOI : this.text.charAt(i8);
                if (charAt2 == ',') {
                    int i9 = (i7 - 1) + this.f158bp;
                    this.f158bp = i9;
                    int i10 = i9 + 1;
                    this.f158bp = i10;
                    if (i10 < this.len) {
                        c = this.text.charAt(i10);
                    }
                    this.f159ch = c;
                    this.matchStat = 3;
                    return j2;
                } else if (charAt2 != '}') {
                    this.matchStat = -1;
                    return 0L;
                } else {
                    int i11 = i7 + 1;
                    int i12 = this.f158bp + i7;
                    char charAt3 = i12 >= this.len ? EOI : this.text.charAt(i12);
                    if (charAt3 == ',') {
                        i = 16;
                    } else if (charAt3 == ']') {
                        i = 15;
                    } else if (charAt3 != '}') {
                        if (charAt3 != 26) {
                            this.matchStat = -1;
                            return 0L;
                        }
                        this.token = 20;
                        this.f158bp = (i11 - 1) + this.f158bp;
                        this.f159ch = EOI;
                        this.matchStat = 4;
                        return j2;
                    } else {
                        i = 13;
                    }
                    this.token = i;
                    this.f158bp = (i11 - 1) + this.f158bp;
                    next();
                    this.matchStat = 4;
                    return j2;
                }
            }
            j2 = (j2 ^ charAt) * 1099511628211L;
            if (charAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i2 = i5;
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        return scanISO8601DateIfMatch(z, this.len - this.f158bp);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x01ff A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean scanISO8601DateIfMatch(boolean z, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        char c;
        int i7;
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        int i8;
        char charAt;
        int i9;
        char charAt2;
        int i10;
        int i11;
        char charAt3;
        char charAt4;
        char charAt5;
        if (!z && i > 13) {
            char charAt6 = charAt(this.f158bp);
            char charAt7 = charAt(this.f158bp + 1);
            char charAt8 = charAt(this.f158bp + 2);
            char charAt9 = charAt(this.f158bp + 3);
            char charAt10 = charAt(this.f158bp + 4);
            char charAt11 = charAt(this.f158bp + 5);
            char charAt12 = charAt((this.f158bp + i) - 1);
            char charAt13 = charAt((this.f158bp + i) - 2);
            if (charAt6 == '/' && charAt7 == 'D' && charAt8 == 'a' && charAt9 == 't' && charAt10 == 'e' && charAt11 == '(' && charAt12 == '/' && charAt13 == ')') {
                int i12 = -1;
                for (int i13 = 6; i13 < i; i13++) {
                    char charAt14 = charAt(this.f158bp + i13);
                    if (charAt14 != '+') {
                        if (charAt14 < '0' || charAt14 > '9') {
                            break;
                        }
                    } else {
                        i12 = i13;
                    }
                }
                if (i12 == -1) {
                    return false;
                }
                int i14 = this.f158bp + 6;
                long parseLong = Long.parseLong(subString(i14, i12 - i14));
                Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
                this.calendar = calendar;
                calendar.setTimeInMillis(parseLong);
                this.token = 5;
                return true;
            }
        }
        if (i == 8 || i == 14 || ((i == 16 && ((charAt5 = charAt(this.f158bp + 10)) == 'T' || charAt5 == ' ')) || (i == 17 && charAt(this.f158bp + 6) != '-'))) {
            if (z) {
                return false;
            }
            char charAt15 = charAt(this.f158bp);
            char charAt16 = charAt(this.f158bp + 1);
            char charAt17 = charAt(this.f158bp + 2);
            char charAt18 = charAt(this.f158bp + 3);
            char charAt19 = charAt(this.f158bp + 4);
            char charAt20 = charAt(this.f158bp + 5);
            char charAt21 = charAt(this.f158bp + 6);
            char charAt22 = charAt(this.f158bp + 7);
            char charAt23 = charAt(this.f158bp + 8);
            boolean z2 = charAt19 == '-' && charAt22 == '-';
            boolean z3 = z2 && i == 16;
            boolean z4 = z2 && i == 17;
            if (z4 || z3) {
                charAt22 = charAt(this.f158bp + 9);
                charAt19 = charAt20;
                charAt20 = charAt21;
                charAt21 = charAt23;
            }
            if (!checkDate(charAt15, charAt16, charAt17, charAt18, charAt19, charAt20, charAt21, charAt22)) {
                return false;
            }
            setCalendar(charAt15, charAt16, charAt17, charAt18, charAt19, charAt20, charAt21, charAt22);
            if (i != 8) {
                char charAt24 = charAt(this.f158bp + 9);
                char charAt25 = charAt(this.f158bp + 10);
                char charAt26 = charAt(this.f158bp + 11);
                char charAt27 = charAt(this.f158bp + 12);
                char charAt28 = charAt(this.f158bp + 13);
                if ((z4 && charAt25 == 'T' && charAt28 == ':' && charAt(this.f158bp + 16) == 'Z') || (z3 && ((charAt25 == ' ' || charAt25 == 'T') && charAt28 == ':'))) {
                    charAt25 = charAt(this.f158bp + 14);
                    charAt28 = '0';
                    charAt23 = charAt26;
                    charAt26 = charAt(this.f158bp + 15);
                    charAt24 = charAt27;
                    charAt27 = '0';
                }
                if (!checkTime(charAt23, charAt24, charAt25, charAt26, charAt27, charAt28)) {
                    return false;
                }
                if (i != 17 || z4) {
                    c = '0';
                    i2 = 0;
                } else {
                    char charAt29 = charAt(this.f158bp + 14);
                    char charAt30 = charAt(this.f158bp + 15);
                    char charAt31 = charAt(this.f158bp + 16);
                    if (charAt29 < '0' || charAt29 > '9' || charAt30 < '0' || charAt30 > '9' || charAt31 < '0' || charAt31 > '9') {
                        return false;
                    }
                    i2 = (charAt31 - '0') + ((charAt30 - '0') * 10) + ((charAt29 - '0') * 100);
                    c = '0';
                }
                i5 = (charAt24 - c) + ((charAt23 - c) * 10);
                i3 = (charAt26 - c) + ((charAt25 - c) * 10);
                i4 = (charAt28 - c) + ((charAt27 - c) * 10);
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            this.calendar.set(11, i5);
            this.calendar.set(12, i3);
            this.calendar.set(13, i4);
            this.calendar.set(14, i2);
            i6 = 5;
        } else if (i < 9) {
            return false;
        } else {
            char charAt32 = charAt(this.f158bp);
            char charAt33 = charAt(this.f158bp + 1);
            char charAt34 = charAt(this.f158bp + 2);
            char charAt35 = charAt(this.f158bp + 3);
            char charAt36 = charAt(this.f158bp + 4);
            char charAt37 = charAt(this.f158bp + 5);
            char charAt38 = charAt(this.f158bp + 6);
            char charAt39 = charAt(this.f158bp + 7);
            char charAt40 = charAt(this.f158bp + 8);
            char charAt41 = charAt(this.f158bp + 9);
            if ((charAt36 == '-' && charAt39 == '-') || (charAt36 == '/' && charAt39 == '/')) {
                i7 = 10;
            } else {
                if (charAt36 == '-' && charAt38 == '-') {
                    if (charAt40 == ' ') {
                        charAt40 = charAt34;
                        c3 = charAt35;
                        c5 = charAt37;
                        c2 = charAt39;
                        c4 = '0';
                        c6 = '0';
                        i8 = 8;
                    } else {
                        c2 = charAt40;
                        charAt40 = charAt34;
                        c3 = charAt35;
                        c5 = charAt37;
                        c6 = charAt39;
                        c4 = '0';
                        i8 = 9;
                    }
                } else if ((charAt34 == '.' && charAt37 == '.') || (charAt34 == '-' && charAt37 == '-')) {
                    c6 = charAt32;
                    c3 = charAt41;
                    c4 = charAt35;
                    c5 = charAt36;
                    charAt32 = charAt38;
                    i8 = 10;
                    c2 = charAt33;
                    charAt33 = charAt39;
                } else if (charAt36 != 24180 && charAt36 != 45380) {
                    return false;
                } else {
                    if (charAt39 == 26376 || charAt39 == 50900) {
                        if (charAt41 == 26085 || charAt41 == 51068) {
                            charAt39 = '0';
                        } else if (charAt(this.f158bp + 10) != 26085 && charAt(this.f158bp + 10) != 51068) {
                            return false;
                        } else {
                            i7 = 11;
                        }
                    } else if (charAt38 != 26376 && charAt38 != 50900) {
                        return false;
                    } else {
                        if (charAt40 == 26085 || charAt40 == 51068) {
                            charAt40 = charAt39;
                            charAt39 = '0';
                        } else if (charAt41 != 26085 && charAt41 != 51068) {
                            return false;
                        }
                        charAt38 = charAt37;
                        charAt37 = '0';
                    }
                    c2 = charAt40;
                    charAt40 = charAt34;
                    c3 = charAt35;
                    c4 = charAt37;
                    c5 = charAt38;
                    c6 = charAt39;
                    i8 = 10;
                }
                if (checkDate(charAt32, charAt33, charAt40, c3, c4, c5, c6, c2)) {
                    return false;
                }
                setCalendar(charAt32, charAt33, charAt40, c3, c4, c5, c6, c2);
                char charAt42 = charAt(this.f158bp + i8);
                if (charAt42 == 'T' || (charAt42 == ' ' && !z)) {
                    int i15 = i8 + 9;
                    if (i < i15 || charAt(this.f158bp + i8 + 3) != ':' || charAt(this.f158bp + i8 + 6) != ':') {
                        return false;
                    }
                    char charAt43 = charAt(this.f158bp + i8 + 1);
                    char charAt44 = charAt(this.f158bp + i8 + 2);
                    char charAt45 = charAt(this.f158bp + i8 + 4);
                    char charAt46 = charAt(this.f158bp + i8 + 5);
                    char charAt47 = charAt(this.f158bp + i8 + 7);
                    char charAt48 = charAt(this.f158bp + i8 + 8);
                    if (!checkTime(charAt43, charAt44, charAt45, charAt46, charAt47, charAt48)) {
                        return false;
                    }
                    setTime(charAt43, charAt44, charAt45, charAt46, charAt47, charAt48);
                    char charAt49 = charAt(this.f158bp + i8 + 9);
                    if (charAt49 != '.') {
                        this.calendar.set(14, 0);
                        int i16 = this.f158bp + i15;
                        this.f158bp = i16;
                        this.f159ch = charAt(i16);
                        this.token = 5;
                        if (charAt49 != 'Z' || this.calendar.getTimeZone().getRawOffset() == 0) {
                            return true;
                        }
                        String[] availableIDs = TimeZone.getAvailableIDs(0);
                        if (availableIDs.length <= 0) {
                            return true;
                        }
                        this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                        return true;
                    }
                    int i17 = i8 + 11;
                    if (i >= i17 && (charAt = charAt(this.f158bp + i8 + 10)) >= '0' && charAt <= '9') {
                        int i18 = charAt - '0';
                        if (i <= i17 || (charAt4 = charAt(this.f158bp + i8 + 11)) < '0' || charAt4 > '9') {
                            i9 = 1;
                        } else {
                            i18 = (i18 * 10) + (charAt4 - '0');
                            i9 = 2;
                        }
                        if (i9 == 2 && (charAt3 = charAt(this.f158bp + i8 + 12)) >= '0' && charAt3 <= '9') {
                            i18 = (i18 * 10) + (charAt3 - '0');
                            i9 = 3;
                        }
                        this.calendar.set(14, i18);
                        char charAt50 = charAt(this.f158bp + i8 + 10 + i9);
                        if (charAt50 == '+' || charAt50 == '-') {
                            char charAt51 = charAt(this.f158bp + i8 + 10 + i9 + 1);
                            if (charAt51 >= '0' && charAt51 <= '1' && (charAt2 = charAt(this.f158bp + i8 + 10 + i9 + 2)) >= '0' && charAt2 <= '9') {
                                char charAt52 = charAt(this.f158bp + i8 + 10 + i9 + 3);
                                if (charAt52 == ':') {
                                    if (charAt(this.f158bp + i8 + 10 + i9 + 4) != '0' || charAt(this.f158bp + i8 + 10 + i9 + 5) != '0') {
                                        return false;
                                    }
                                    i10 = 6;
                                } else if (charAt52 != '0') {
                                    i10 = 3;
                                } else if (charAt(this.f158bp + i8 + 10 + i9 + 4) != '0') {
                                    return false;
                                } else {
                                    i10 = 5;
                                }
                                setTimeZone(charAt50, charAt51, charAt2);
                                i11 = i10;
                            }
                        } else if (charAt50 == 'Z') {
                            if (this.calendar.getTimeZone().getRawOffset() != 0) {
                                String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                                if (availableIDs2.length > 0) {
                                    this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                                }
                            }
                            i11 = 1;
                        } else {
                            i11 = 0;
                        }
                        int i19 = i8 + 10 + i9 + i11;
                        char charAt53 = charAt(this.f158bp + i19);
                        if (charAt53 != 26 && charAt53 != '\"') {
                            return false;
                        }
                        int i20 = this.f158bp + i19;
                        this.f158bp = i20;
                        this.f159ch = charAt(i20);
                        this.token = 5;
                        return true;
                    }
                    return false;
                } else if (charAt42 != '\"' && charAt42 != 26 && charAt42 != 26085 && charAt42 != 51068) {
                    if ((charAt42 != '+' && charAt42 != '-') || this.len != i8 + 6 || charAt(this.f158bp + i8 + 3) != ':' || charAt(this.f158bp + i8 + 4) != '0' || charAt(this.f158bp + i8 + 5) != '0') {
                        return false;
                    }
                    setTime('0', '0', '0', '0', '0', '0');
                    this.calendar.set(14, 0);
                    setTimeZone(charAt42, charAt(this.f158bp + i8 + 1), charAt(this.f158bp + i8 + 2));
                    return true;
                } else {
                    i6 = 5;
                    this.calendar.set(11, 0);
                    this.calendar.set(12, 0);
                    this.calendar.set(13, 0);
                    this.calendar.set(14, 0);
                    int i21 = this.f158bp + i8;
                    this.f158bp = i21;
                    this.f159ch = charAt(i21);
                }
            }
            c6 = charAt40;
            charAt40 = charAt34;
            c2 = charAt41;
            c3 = charAt35;
            c4 = charAt37;
            c5 = charAt38;
            i8 = i7;
            if (checkDate(charAt32, charAt33, charAt40, c3, c4, c5, c6, c2)) {
            }
        }
        this.token = i6;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c3, code lost:
        if (r0 != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c6, code lost:
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long scanLongValue() {
        long j;
        boolean z = false;
        this.f160np = 0;
        if (this.f159ch == '-') {
            this.f160np = 0 + 1;
            int i = this.f158bp + 1;
            this.f158bp = i;
            if (i >= this.len) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("syntax error, ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(info());
                throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            this.f159ch = this.text.charAt(i);
            j = Long.MIN_VALUE;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        long j2 = 0;
        while (true) {
            char c = this.f159ch;
            if (c < '0' || c > '9') {
                break;
            }
            int i2 = c - '0';
            if (j2 < JsonReader.MIN_INCOMPLETE_INTEGER) {
                throw new JSONException("error long value, " + j2 + ", " + info());
            }
            long j3 = j2 * 10;
            long j4 = i2;
            if (j3 < j + j4) {
                throw new JSONException("error long value, " + j3 + ", " + info());
            }
            j2 = j3 - j4;
            this.f160np++;
            int i3 = this.f158bp + 1;
            this.f158bp = i3;
            this.f159ch = i3 >= this.len ? EOI : this.text.charAt(i3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        if (r0 >= r9.len) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001a, code lost:
        if (r0 >= r9.len) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0104, code lost:
        if (r0 >= r9.len) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ea, code lost:
        r0 = r9.text.charAt(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00f0, code lost:
        r9.f159ch = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0025, code lost:
        r9.f159ch = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e7, code lost:
        r0 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00e5, code lost:
        if (r0 >= r9.len) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0025, code lost:
        r9.f159ch = r9.text.charAt(r0);
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x003d -> B:5:0x001c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0104 -> B:65:0x00e7). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x00ea -> B:64:0x00f0). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void scanNumber() {
        int i;
        int i2;
        int i3 = this.f158bp;
        this.f160np = i3;
        this.exp = false;
        if (this.f159ch == '-') {
            this.f161sp++;
            i2 = i3 + 1;
            this.f158bp = i2;
        }
        char c = this.f159ch;
        if (c < '0' || c > '9') {
            this.isDouble = false;
            if (this.f159ch == '.') {
                this.f161sp++;
                int i4 = this.f158bp + 1;
                this.f158bp = i4;
                this.f159ch = i4 >= this.len ? EOI : this.text.charAt(i4);
                this.isDouble = true;
                while (true) {
                    char c2 = this.f159ch;
                    if (c2 < '0' || c2 > '9') {
                        break;
                    }
                    this.f161sp++;
                    int i5 = this.f158bp + 1;
                    this.f158bp = i5;
                    this.f159ch = i5 >= this.len ? EOI : this.text.charAt(i5);
                }
            }
            char c3 = this.f159ch;
            if (c3 == 'L' || c3 == 'S' || c3 == 'B') {
                this.f161sp++;
                next();
            } else {
                if (c3 == 'F' || c3 == 'D') {
                    this.f161sp++;
                    next();
                } else if (c3 == 'e' || c3 == 'E') {
                    this.f161sp++;
                    int i6 = this.f158bp + 1;
                    this.f158bp = i6;
                    char charAt = i6 >= this.len ? EOI : this.text.charAt(i6);
                    this.f159ch = charAt;
                    if (charAt == '+' || charAt == '-') {
                        this.f161sp++;
                        i = this.f158bp + 1;
                        this.f158bp = i;
                    }
                    char c4 = this.f159ch;
                    if (c4 < '0' || c4 > '9') {
                        char c5 = this.f159ch;
                        if (c5 == 'D' || c5 == 'F') {
                            this.f161sp++;
                            next();
                        }
                        this.exp = true;
                    } else {
                        this.f161sp++;
                        i = this.f158bp + 1;
                        this.f158bp = i;
                    }
                }
                this.isDouble = true;
            }
            this.token = this.isDouble ? 3 : 2;
            return;
        }
        this.f161sp++;
        i2 = this.f158bp + 1;
        this.f158bp = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:157:0x01b9, code lost:
        if (r5 >= r22.len) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x019d, code lost:
        r5 = r22.text.charAt(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x01a3, code lost:
        r22.f159ch = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x019a, code lost:
        r5 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0198, code lost:
        if (r5 >= r22.len) goto L160;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0281 A[Catch: NumberFormatException -> 0x02c3, TryCatch #0 {NumberFormatException -> 0x02c3, blocks: (B:105:0x0268, B:111:0x027b, B:113:0x0281, B:117:0x0292, B:118:0x0289, B:120:0x0290, B:125:0x0297, B:128:0x029d, B:130:0x02a2, B:133:0x02a8, B:135:0x0275, B:136:0x02ad, B:138:0x02b5, B:140:0x02ba), top: B:102:0x0264 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0297 A[Catch: NumberFormatException -> 0x02c3, TryCatch #0 {NumberFormatException -> 0x02c3, blocks: (B:105:0x0268, B:111:0x027b, B:113:0x0281, B:117:0x0292, B:118:0x0289, B:120:0x0290, B:125:0x0297, B:128:0x029d, B:130:0x02a2, B:133:0x02a8, B:135:0x0275, B:136:0x02ad, B:138:0x02b5, B:140:0x02ba), top: B:102:0x0264 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02a2 A[Catch: NumberFormatException -> 0x02c3, TryCatch #0 {NumberFormatException -> 0x02c3, blocks: (B:105:0x0268, B:111:0x027b, B:113:0x0281, B:117:0x0292, B:118:0x0289, B:120:0x0290, B:125:0x0297, B:128:0x029d, B:130:0x02a2, B:133:0x02a8, B:135:0x0275, B:136:0x02ad, B:138:0x02b5, B:140:0x02ba), top: B:102:0x0264 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:142:0x01b9 -> B:145:0x019a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:143:0x019d -> B:144:0x01a3). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Number scanNumberValue() {
        long j;
        boolean z;
        int i;
        char c;
        boolean z2;
        int i2;
        int i3;
        char c2;
        boolean z3;
        char[] cArr;
        int i4;
        int i5;
        int i6;
        char[] cArr2;
        long j2;
        long j3;
        long j4;
        long j5;
        int i7 = this.f158bp;
        this.f160np = 0;
        if (this.f159ch == '-') {
            j = Long.MIN_VALUE;
            this.f160np = 0 + 1;
            int i8 = i7 + 1;
            this.f158bp = i8;
            this.f159ch = i8 >= this.len ? EOI : this.text.charAt(i8);
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        long j6 = 0;
        int i9 = 1;
        boolean z4 = false;
        while (true) {
            char c3 = this.f159ch;
            i = 18;
            c = '0';
            if (c3 < '0' || c3 > '9') {
                break;
            }
            int i10 = c3 - '0';
            if (i9 < 18) {
                j4 = j6 * 10;
                j5 = i10;
            } else {
                if (j6 < JsonReader.MIN_INCOMPLETE_INTEGER) {
                    z4 = true;
                }
                j4 = j6 * 10;
                j5 = i10;
                if (j4 < j + j5) {
                    z4 = true;
                }
            }
            j6 = j4 - j5;
            this.f160np++;
            int i11 = this.f158bp + 1;
            this.f158bp = i11;
            this.f159ch = i11 >= this.len ? EOI : this.text.charAt(i11);
            i9++;
        }
        BigInteger bigInteger = null;
        if (this.f159ch == '.') {
            this.f160np++;
            int i12 = this.f158bp + 1;
            this.f158bp = i12;
            this.f159ch = i12 >= this.len ? EOI : this.text.charAt(i12);
            i2 = 0;
            while (true) {
                char c4 = this.f159ch;
                if (c4 < c || c4 > '9') {
                    break;
                }
                i2++;
                int i13 = c4 - '0';
                if (i9 < i) {
                    j2 = j6 * 10;
                    j3 = i13;
                } else {
                    if (j6 < JsonReader.MIN_INCOMPLETE_INTEGER) {
                        z4 = true;
                    }
                    j2 = j6 * 10;
                    j3 = i13;
                    if (j2 < j + j3) {
                        z4 = true;
                    }
                }
                j6 = j2 - j3;
                this.f160np++;
                int i14 = this.f158bp + 1;
                this.f158bp = i14;
                this.f159ch = i14 >= this.len ? EOI : this.text.charAt(i14);
                i9++;
                c = '0';
                i = 18;
            }
            if (!z) {
                j6 = -j6;
            }
            char c5 = this.f159ch;
            if (c5 == 'F' || c5 == 'D') {
                this.f160np++;
                next();
            }
            z2 = true;
        } else {
            if (!z) {
                j6 = -j6;
            }
            char c6 = this.f159ch;
            if (c6 == 'L') {
                this.f160np++;
                next();
                bigInteger = Long.valueOf(j6);
            } else if (c6 == 'S') {
                this.f160np++;
                next();
                bigInteger = Short.valueOf((short) j6);
            } else if (c6 == 'B') {
                this.f160np++;
                next();
                bigInteger = Byte.valueOf((byte) j6);
            } else if (c6 == 'F') {
                this.f160np++;
                next();
                bigInteger = Float.valueOf((float) j6);
            } else if (c6 == 'D') {
                this.f160np++;
                next();
                bigInteger = Double.valueOf(j6);
            }
            z2 = false;
            i2 = 0;
        }
        char c7 = this.f159ch;
        if (c7 == 'e' || c7 == 'E') {
            this.f160np++;
            int i15 = this.f158bp + 1;
            this.f158bp = i15;
            char charAt = i15 >= this.len ? EOI : this.text.charAt(i15);
            this.f159ch = charAt;
            if (charAt == '+' || charAt == '-') {
                this.f160np++;
                i3 = this.f158bp + 1;
                this.f158bp = i3;
            }
            char c8 = this.f159ch;
            if (c8 < '0' || c8 > '9') {
                char c9 = this.f159ch;
                if (c9 == 'D' || c9 == 'F') {
                    this.f160np++;
                    c2 = this.f159ch;
                    next();
                } else {
                    c2 = 0;
                }
                z3 = true;
            } else {
                this.f160np++;
                i3 = this.f158bp + 1;
                this.f158bp = i3;
            }
        } else {
            c2 = 0;
            z3 = false;
        }
        if (!z2 && !z3) {
            if (z4) {
                int i16 = this.f158bp;
                char[] cArr3 = new char[i16 - i7];
                this.text.getChars(i7, i16, cArr3, 0);
                bigInteger = new BigInteger(new String(cArr3));
            }
            return bigInteger == null ? (j6 <= -2147483648L || j6 >= 2147483647L) ? Long.valueOf(j6) : Integer.valueOf((int) j6) : bigInteger;
        }
        int i17 = this.f158bp - i7;
        if (c2 != 0) {
            i17--;
        }
        if (!z3 && (this.features & Feature.UseBigDecimal.mask) != 0) {
            if (!z4) {
                return BigDecimal.valueOf(j6, i2);
            }
            char[] cArr4 = this.sbuf;
            if (i17 < cArr4.length) {
                i6 = 0;
                this.text.getChars(i7, i7 + i17, cArr4, 0);
                cArr2 = this.sbuf;
            } else {
                i6 = 0;
                char[] cArr5 = new char[i17];
                this.text.getChars(i7, i7 + i17, cArr5, 0);
                cArr2 = cArr5;
            }
            return new BigDecimal(cArr2, i6, i17);
        }
        char[] cArr6 = this.sbuf;
        if (i17 < cArr6.length) {
            this.text.getChars(i7, i7 + i17, cArr6, 0);
            cArr = this.sbuf;
        } else {
            char[] cArr7 = new char[i17];
            this.text.getChars(i7, i7 + i17, cArr7, 0);
            cArr = cArr7;
        }
        try {
            if (i17 > 9 || z3) {
                String str = new String(cArr, 0, i17);
                return c2 == 'F' ? Float.valueOf(str) : Double.valueOf(Double.parseDouble(str));
            }
            char c10 = cArr[0];
            if (c10 != '-' && c10 != '+') {
                i4 = 1;
                int i18 = c10 - '0';
                int i19 = 0;
                for (i5 = i4; i5 < i17; i5++) {
                    char c11 = cArr[i5];
                    if (c11 == '.') {
                        i19 = 1;
                    } else {
                        i18 = (i18 * 10) + (c11 - '0');
                        if (i19 != 0) {
                            i19 *= 10;
                        }
                    }
                }
                if (c2 != 'F') {
                    float f = i18 / i19;
                    if (z) {
                        f = -f;
                    }
                    return Float.valueOf(f);
                }
                double d = i18 / i19;
                if (z) {
                    d = -d;
                }
                return Double.valueOf(d);
            }
            c10 = cArr[1];
            i4 = 2;
            int i182 = c10 - '0';
            int i192 = 0;
            while (i5 < i17) {
            }
            if (c2 != 'F') {
            }
        } catch (NumberFormatException e) {
            throw new JSONException(e.getMessage() + ", " + info(), e);
        }
    }

    public final void scanString() {
        char c = this.f159ch;
        int i = this.f158bp + 1;
        int indexOf = this.text.indexOf(c, i);
        if (indexOf == -1) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unclosed str, ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(info());
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        int i2 = indexOf - i;
        char[] sub_chars = sub_chars(this.f158bp + 1, i2);
        boolean z = false;
        while (i2 > 0 && sub_chars[i2 - 1] == '\\') {
            int i3 = 1;
            for (int i4 = i2 - 2; i4 >= 0 && sub_chars[i4] == '\\'; i4--) {
                i3++;
            }
            if (i3 % 2 == 0) {
                break;
            }
            int indexOf2 = this.text.indexOf(c, indexOf + 1);
            int i5 = (indexOf2 - indexOf) + i2;
            if (i5 >= sub_chars.length) {
                int length = (sub_chars.length * 3) / 2;
                if (length < i5) {
                    length = i5;
                }
                char[] cArr = new char[length];
                System.arraycopy(sub_chars, 0, cArr, 0, sub_chars.length);
                sub_chars = cArr;
            }
            this.text.getChars(indexOf, indexOf2, sub_chars, i2);
            indexOf = indexOf2;
            i2 = i5;
            z = true;
        }
        if (!z) {
            for (int i6 = 0; i6 < i2; i6++) {
                if (sub_chars[i6] == '\\') {
                    z = true;
                }
            }
        }
        this.sbuf = sub_chars;
        this.f161sp = i2;
        this.f160np = this.f158bp;
        this.hasSpecial = z;
        int i7 = indexOf + 1;
        this.f158bp = i7;
        this.f159ch = i7 >= this.len ? EOI : this.text.charAt(i7);
        this.token = 4;
    }

    public String scanStringValue(char c) {
        String str;
        int i = this.f158bp + 1;
        int indexOf = this.text.indexOf(c, i);
        if (indexOf == -1) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unclosed str, ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(info());
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        if (f157V6) {
            str = this.text.substring(i, indexOf);
        } else {
            int i2 = indexOf - i;
            str = new String(sub_chars(this.f158bp + 1, i2), 0, i2);
        }
        if (str.indexOf(92) != -1) {
            while (true) {
                int i3 = 0;
                for (int i4 = indexOf - 1; i4 >= 0 && this.text.charAt(i4) == '\\'; i4--) {
                    i3++;
                }
                if (i3 % 2 == 0) {
                    break;
                }
                indexOf = this.text.indexOf(c, indexOf + 1);
            }
            int i5 = indexOf - i;
            str = readString(sub_chars(this.f158bp + 1, i5), i5);
        }
        int i6 = indexOf + 1;
        this.f158bp = i6;
        this.f159ch = i6 >= this.len ? EOI : this.text.charAt(i6);
        return str;
    }

    public final String scanSymbol(SymbolTable symbolTable) {
        char c;
        while (true) {
            c = this.f159ch;
            if (c != ' ' && c != '\n' && c != '\r' && c != '\t' && c != '\f' && c != '\b') {
                break;
            }
            next();
        }
        if (c == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c == '\'') {
            return scanSymbol(symbolTable, ExtendedMessageFormat.QUOTE);
        }
        if (c == '}') {
            next();
            this.token = 13;
            return null;
        } else if (c == ',') {
            next();
            this.token = 16;
            return null;
        } else if (c != 26) {
            return scanSymbolUnQuoted(symbolTable);
        } else {
            this.token = 20;
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String scanSymbol(SymbolTable symbolTable, char c) {
        String readString;
        int i = this.f158bp + 1;
        int indexOf = this.text.indexOf(c, i);
        if (indexOf == -1) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unclosed str, ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(info());
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        int i2 = indexOf - i;
        char[] sub_chars = sub_chars(this.f158bp + 1, i2);
        boolean z = false;
        while (i2 > 0 && sub_chars[i2 - 1] == '\\') {
            int i3 = 1;
            for (int i4 = i2 - 2; i4 >= 0 && sub_chars[i4] == '\\'; i4--) {
                i3++;
            }
            if (i3 % 2 == 0) {
                break;
            }
            int indexOf2 = this.text.indexOf(c, indexOf + 1);
            int i5 = (indexOf2 - indexOf) + i2;
            if (i5 >= sub_chars.length) {
                int length = (sub_chars.length * 3) / 2;
                if (length < i5) {
                    length = i5;
                }
                char[] cArr = new char[length];
                System.arraycopy(sub_chars, 0, cArr, 0, sub_chars.length);
                sub_chars = cArr;
            }
            this.text.getChars(indexOf, indexOf2, sub_chars, i2);
            indexOf = indexOf2;
            i2 = i5;
            z = true;
        }
        if (!z) {
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                char c2 = sub_chars[i7];
                i6 = (i6 * 31) + c2;
                if (c2 == '\\') {
                    z = true;
                }
            }
            if (!z) {
                readString = i2 < 20 ? symbolTable.addSymbol(sub_chars, 0, i2, i6) : new String(sub_chars, 0, i2);
                int i8 = indexOf + 1;
                this.f158bp = i8;
                this.f159ch = i8 < this.len ? EOI : this.text.charAt(i8);
                return readString;
            }
        }
        readString = readString(sub_chars, i2);
        int i82 = indexOf + 1;
        this.f158bp = i82;
        this.f159ch = i82 < this.len ? EOI : this.text.charAt(i82);
        return readString;
    }

    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        int i = this.f159ch;
        boolean[] zArr = firstIdentifierFlags;
        if (!(i >= zArr.length || zArr[i])) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("illegal identifier : ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f159ch);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(info());
            throw new JSONException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        this.f160np = this.f158bp;
        this.f161sp = 1;
        while (true) {
            char next = next();
            boolean[] zArr2 = identifierFlags;
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            i = (i * 31) + next;
            this.f161sp++;
        }
        this.f159ch = charAt(this.f158bp);
        this.token = 18;
        if (this.f161sp == 4 && this.text.startsWith("null", this.f160np)) {
            return null;
        }
        return symbolTable.addSymbol(this.text, this.f160np, this.f161sp, i);
    }

    public void setTime(char c, char c2, char c3, char c4, char c5, char c6) {
        this.calendar.set(11, (c2 - '0') + ((c - '0') * 10));
        Calendar calendar = this.calendar;
        calendar.set(12, (c4 - '0') + ((c3 - '0') * 10));
        Calendar calendar2 = this.calendar;
        calendar2.set(13, (c6 - '0') + ((c5 - '0') * 10));
    }

    public void setTimeZone(char c, char c2, char c3) {
        int i = ((c3 - '0') + ((c2 - '0') * 10)) * TimeUtils.SECONDS_PER_HOUR * 1000;
        if (c == '-') {
            i = -i;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i) {
            String[] availableIDs = TimeZone.getAvailableIDs(i);
            if (availableIDs.length <= 0) {
                return;
            }
            this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
        }
    }

    public void skipComment() {
        next();
        char c = this.f159ch;
        if (c == '/') {
            do {
                next();
            } while (this.f159ch != '\n');
            next();
            return;
        }
        if (c != '*') {
            throw new JSONException("invalid comment");
        }
        while (true) {
            next();
            while (true) {
                char c2 = this.f159ch;
                if (c2 == 26) {
                    return;
                }
                if (c2 == '*') {
                    next();
                    if (this.f159ch == '/') {
                        next();
                        return;
                    }
                }
            }
        }
    }

    public final void skipWhitespace() {
        while (true) {
            char c = this.f159ch;
            if (c <= '/') {
                if (c == ' ' || c == '\r' || c == '\n' || c == '\t' || c == '\f' || c == '\b') {
                    next();
                } else if (c != '/') {
                    return;
                } else {
                    skipComment();
                }
            } else {
                return;
            }
        }
    }

    public final String stringVal() {
        return this.hasSpecial ? readString(this.sbuf, this.f161sp) : subString(this.f160np + 1, this.f161sp);
    }

    public final char[] sub_chars(int i, int i2) {
        char[] cArr = this.sbuf;
        if (i2 < cArr.length) {
            this.text.getChars(i, i2 + i, cArr, 0);
            return this.sbuf;
        }
        char[] cArr2 = new char[i2];
        this.sbuf = cArr2;
        this.text.getChars(i, i2 + i, cArr2, 0);
        return cArr2;
    }

    public final int token() {
        return this.token;
    }
}

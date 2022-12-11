package org.apache.commons.lang3.math;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.MultiPartWriter;

/* loaded from: classes4.dex */
public class NumberUtils {
    public static final Long LONG_ZERO = 0L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Integer INTEGER_ZERO = 0;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Short SHORT_ZERO = 0;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Double DOUBLE_ZERO = Double.valueOf((double) RoundRectDrawableWithShadow.COS_45);
    public static final Double DOUBLE_ONE = Double.valueOf(1.0d);
    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        if (str.trim().startsWith(MultiPartWriter.__DASHDASH)) {
            throw new NumberFormatException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " is not a valid number."));
        }
        return new BigDecimal(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BigInteger createBigInteger(String str) {
        int i;
        if (str == null) {
            return null;
        }
        int i2 = 10;
        int i3 = 0;
        boolean z = true;
        if (str.startsWith("-")) {
            i3 = 1;
        } else {
            z = false;
        }
        if (str.startsWith("0x", i3) || str.startsWith("0x", i3)) {
            i3 += 2;
        } else if (!str.startsWith("#", i3)) {
            if (str.startsWith("0", i3) && str.length() > (i = i3 + 1)) {
                i2 = 8;
                i3 = i;
            }
            BigInteger bigInteger = new BigInteger(str.substring(i3), i2);
            return !z ? bigInteger.negate() : bigInteger;
        } else {
            i3++;
        }
        i2 = 16;
        BigInteger bigInteger2 = new BigInteger(str.substring(i3), i2);
        if (!z) {
        }
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.decode(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0124, code lost:
        if (r2 == 'l') goto L73;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Number createNumber(String str) throws NumberFormatException {
        int i;
        String str2;
        int i2;
        String str3;
        String str4 = null;
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        String[] strArr = {"0x", "0X", "-0x", "-0X", "#", "-#"};
        char c = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= 6) {
                i = 0;
                break;
            }
            String str5 = strArr[i3];
            if (str.startsWith(str5)) {
                i = str5.length() + 0;
                break;
            }
            i3++;
        }
        if (i > 0) {
            int i4 = i;
            while (i < str.length() && (c = str.charAt(i)) == '0') {
                i4++;
                i++;
            }
            int length = str.length() - i4;
            return (length > 16 || (length == 16 && c > '7')) ? createBigInteger(str) : (length > 8 || (length == 8 && c > '7')) ? createLong(str) : createInteger(str);
        }
        char charAt = str.charAt(str.length() - 1);
        int indexOf = str.indexOf(46);
        int indexOf2 = str.indexOf(69) + str.indexOf(101) + 1;
        if (indexOf > -1) {
            if (indexOf2 <= -1) {
                str3 = str.substring(indexOf + 1);
            } else if (indexOf2 < indexOf || indexOf2 > str.length()) {
                throw new NumberFormatException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " is not a valid number."));
            } else {
                str3 = str.substring(indexOf + 1, indexOf2);
            }
            str2 = str.substring(0, indexOf);
            i2 = str3.length();
        } else {
            if (indexOf2 <= -1) {
                str2 = str;
            } else if (indexOf2 > str.length()) {
                throw new NumberFormatException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " is not a valid number."));
            } else {
                str2 = str.substring(0, indexOf2);
            }
            i2 = 0;
            str3 = null;
        }
        if (Character.isDigit(charAt) || charAt == '.') {
            if (indexOf2 > -1 && indexOf2 < str.length() - 1) {
                str4 = str.substring(indexOf2 + 1, str.length());
            }
            if (str3 == null && str4 == null) {
                try {
                    try {
                        return createInteger(str);
                    } catch (NumberFormatException unused) {
                        return createBigInteger(str);
                    }
                } catch (NumberFormatException unused2) {
                    return createLong(str);
                }
            }
            if (isAllZeros(str2) && isAllZeros(str4)) {
                c = 1;
            }
            if (i2 <= 7) {
                try {
                    Float createFloat = createFloat(str);
                    if (!createFloat.isInfinite()) {
                        if (createFloat.floatValue() != 0.0f || c != 0) {
                            return createFloat;
                        }
                    }
                } catch (NumberFormatException unused3) {
                }
            }
            if (i2 <= 16) {
                try {
                    Double createDouble = createDouble(str);
                    if (!createDouble.isInfinite()) {
                        if (createDouble.doubleValue() != RoundRectDrawableWithShadow.COS_45 || c != 0) {
                            return createDouble;
                        }
                    }
                } catch (NumberFormatException unused4) {
                }
            }
            return createBigDecimal(str);
        }
        if (indexOf2 > -1 && indexOf2 < str.length() - 1) {
            str4 = str.substring(indexOf2 + 1, str.length() - 1);
        }
        String substring = str.substring(0, str.length() - 1);
        boolean z = isAllZeros(str2) && isAllZeros(str4);
        if (charAt != 'D') {
            if (charAt != 'F') {
                if (charAt != 'L') {
                    if (charAt != 'd') {
                        if (charAt != 'f') {
                        }
                    }
                }
                if (str3 != null || str4 != null || ((substring.charAt(0) != '-' || !isDigits(substring.substring(1))) && !isDigits(substring))) {
                    throw new NumberFormatException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " is not a valid number."));
                }
                try {
                    return createLong(substring);
                } catch (NumberFormatException unused5) {
                    return createBigInteger(substring);
                }
            }
            try {
                Float createFloat2 = createFloat(substring);
                if (!createFloat2.isInfinite()) {
                    if (createFloat2.floatValue() != 0.0f || z) {
                        return createFloat2;
                    }
                }
            } catch (NumberFormatException unused6) {
            }
        }
        try {
            Double createDouble2 = createDouble(substring);
            if (!createDouble2.isInfinite()) {
                if (createDouble2.floatValue() != RoundRectDrawableWithShadow.COS_45 || z) {
                    return createDouble2;
                }
            }
        } catch (NumberFormatException unused7) {
        }
        try {
            return createBigDecimal(substring);
        } catch (NumberFormatException unused8) {
            throw new NumberFormatException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " is not a valid number."));
        }
    }

    public static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        return str.length() > 0;
    }

    public static boolean isDigits(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00df, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x00e1, code lost:
        if (r6 != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00e3, code lost:
        if (r11 == false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00e5, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x011d, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0093, code lost:
        if (r3 >= r0.length) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0097, code lost:
        if (r0[r3] < '0') goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x009b, code lost:
        if (r0[r3] > '9') goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x009d, code lost:
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00a0, code lost:
        if (r0[r3] == 'e') goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00a4, code lost:
        if (r0[r3] != 'E') goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00a9, code lost:
        if (r0[r3] != '.') goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00ab, code lost:
        if (r13 != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00ad, code lost:
        if (r12 == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00b0, code lost:
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00b1, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00b2, code lost:
        if (r6 != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00b8, code lost:
        if (r0[r3] == 'd') goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00be, code lost:
        if (r0[r3] == 'D') goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00c2, code lost:
        if (r0[r3] == 'f') goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00c8, code lost:
        if (r0[r3] != 'F') goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00ca, code lost:
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00cf, code lost:
        if (r0[r3] == 'l') goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00d5, code lost:
        if (r0[r3] != 'L') goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x00d8, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00d9, code lost:
        if (r11 == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00db, code lost:
        if (r12 != false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00dd, code lost:
        if (r13 != false) goto L101;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isNumber(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        boolean z = true;
        int i = charArray[0] == '-' ? 1 : 0;
        int i2 = i + 1;
        if (length > i2 && charArray[i] == '0') {
            if (charArray[i2] == 'x' || charArray[i2] == 'X') {
                int i3 = i + 2;
                if (i3 == length) {
                    return false;
                }
                while (i3 < charArray.length) {
                    if ((charArray[i3] < '0' || charArray[i3] > '9') && ((charArray[i3] < 'a' || charArray[i3] > 'f') && (charArray[i3] < 'A' || charArray[i3] > 'F'))) {
                        return false;
                    }
                    i3++;
                }
                return true;
            } else if (Character.isDigit(charArray[i2])) {
                while (i2 < charArray.length) {
                    if (charArray[i2] < '0' || charArray[i2] > '7') {
                        return false;
                    }
                    i2++;
                }
                return true;
            }
        }
        int i4 = length - 1;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (true) {
            if (i >= i4 && (i >= i4 + 1 || !z2 || z3)) {
                break;
            }
            if (charArray[i] >= '0' && charArray[i] <= '9') {
                z2 = false;
                z3 = true;
            } else if (charArray[i] == '.') {
                if (z5 || z4) {
                    break;
                }
                z5 = true;
            } else if (charArray[i] != 'e' && charArray[i] != 'E') {
                if (charArray[i] != '+' && charArray[i] != '-') {
                    return false;
                }
                z2 = false;
                z3 = false;
            } else if (z4 || !z3) {
                return false;
            } else {
                z2 = true;
                z4 = true;
            }
            i++;
            z = true;
        }
        return false;
    }

    public static byte max(byte b, byte b2, byte b3) {
        if (b2 > b) {
            b = b2;
        }
        return b3 > b ? b3 : b;
    }

    public static byte max(byte[] bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            if (bArr[i] > b) {
                b = bArr[i];
            }
        }
        return b;
    }

    public static double max(double d, double d2, double d3) {
        return Math.max(Math.max(d, d2), d3);
    }

    public static double max(double[] dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            if (dArr[i] > d) {
                d = dArr[i];
            }
        }
        return d;
    }

    public static float max(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    public static float max(float[] fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            if (fArr[i] > f) {
                f = fArr[i];
            }
        }
        return f;
    }

    public static int max(int i, int i2, int i3) {
        if (i2 > i) {
            i = i2;
        }
        return i3 > i ? i3 : i;
    }

    public static int max(int[] iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static long max(long j, long j2, long j3) {
        if (j2 > j) {
            j = j2;
        }
        return j3 > j ? j3 : j;
    }

    public static long max(long[] jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] > j) {
                j = jArr[i];
            }
        }
        return j;
    }

    public static short max(short s, short s2, short s3) {
        if (s2 > s) {
            s = s2;
        }
        return s3 > s ? s3 : s;
    }

    public static short max(short[] sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            if (sArr[i] > s) {
                s = sArr[i];
            }
        }
        return s;
    }

    public static byte min(byte b, byte b2, byte b3) {
        if (b2 < b) {
            b = b2;
        }
        return b3 < b ? b3 : b;
    }

    public static byte min(byte[] bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            if (bArr[i] < b) {
                b = bArr[i];
            }
        }
        return b;
    }

    public static double min(double d, double d2, double d3) {
        return Math.min(Math.min(d, d2), d3);
    }

    public static double min(double[] dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            if (dArr[i] < d) {
                d = dArr[i];
            }
        }
        return d;
    }

    public static float min(float f, float f2, float f3) {
        return Math.min(Math.min(f, f2), f3);
    }

    public static float min(float[] fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            if (fArr[i] < f) {
                f = fArr[i];
            }
        }
        return f;
    }

    public static int min(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    public static int min(int[] iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static long min(long j, long j2, long j3) {
        if (j2 < j) {
            j = j2;
        }
        return j3 < j ? j3 : j;
    }

    public static long min(long[] jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] < j) {
                j = jArr[i];
            }
        }
        return j;
    }

    public static short min(short s, short s2, short s3) {
        if (s2 < s) {
            s = s2;
        }
        return s3 < s ? s3 : s;
    }

    public static short min(short[] sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            if (sArr[i] < s) {
                s = sArr[i];
            }
        }
        return s;
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static byte toByte(String str, byte b) {
        if (str == null) {
            return b;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b;
        }
    }

    public static double toDouble(String str) {
        return toDouble(str, RoundRectDrawableWithShadow.COS_45);
    }

    public static double toDouble(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static float toFloat(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static long toLong(String str) {
        return toLong(str, 0L);
    }

    public static long toLong(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static short toShort(String str) {
        return toShort(str, (short) 0);
    }

    public static short toShort(String str, short s) {
        if (str == null) {
            return s;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    public static void validateArray(Object obj) {
        if (obj != null) {
            if (Array.getLength(obj) == 0) {
                throw new IllegalArgumentException("Array cannot be empty.");
            }
            return;
        }
        throw new IllegalArgumentException("The Array must not be null");
    }
}

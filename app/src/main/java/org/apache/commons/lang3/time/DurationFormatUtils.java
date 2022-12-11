package org.apache.commons.lang3.time;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.C1543ak;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class DurationFormatUtils {
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'";

    /* renamed from: y */
    public static final Object f4563y = "y";

    /* renamed from: M */
    public static final Object f4558M = "M";

    /* renamed from: d */
    public static final Object f4560d = "d";

    /* renamed from: H */
    public static final Object f4557H = "H";

    /* renamed from: m */
    public static final Object f4561m = "m";

    /* renamed from: s */
    public static final Object f4562s = C1543ak.f2965aB;

    /* renamed from: S */
    public static final Object f4559S = ExifInterface.LATITUDE_SOUTH;

    /* loaded from: classes4.dex */
    public static class Token {
        public int count;
        public final Object value;

        public Token(Object obj) {
            this.value = obj;
            this.count = 1;
        }

        public Token(Object obj, int i) {
            this.value = obj;
            this.count = i;
        }

        public static boolean containsTokenWithValue(Token[] tokenArr, Object obj) {
            for (Token token : tokenArr) {
                if (token.getValue() == obj) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Token) {
                Token token = (Token) obj;
                if (this.value.getClass() != token.value.getClass() || this.count != token.count) {
                    return false;
                }
                Object obj2 = this.value;
                if (obj2 instanceof StringBuilder) {
                    return obj2.toString().equals(token.value.toString());
                }
                boolean z = obj2 instanceof Number;
                Object obj3 = token.value;
                return z ? obj2.equals(obj3) : obj2 == obj3;
            }
            return false;
        }

        public int getCount() {
            return this.count;
        }

        public Object getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public void increment() {
            this.count++;
        }

        public String toString() {
            return StringUtils.repeat(this.value.toString(), this.count);
        }
    }

    public static String format(Token[] tokenArr, long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z) {
        int i;
        int i2;
        String paddedValue;
        String paddedValue2;
        Token[] tokenArr2 = tokenArr;
        StringBuilder sb = new StringBuilder();
        int length = tokenArr2.length;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < length) {
            Token token = tokenArr2[i3];
            Object value = token.getValue();
            int count = token.getCount();
            if (value instanceof StringBuilder) {
                sb.append(value.toString());
                i2 = length;
                i = i3;
            } else {
                if (value == f4563y) {
                    sb.append(paddedValue(j, z, count));
                    i2 = length;
                    i = i3;
                } else {
                    i = i3;
                    if (value == f4558M) {
                        paddedValue2 = paddedValue(j2, z, count);
                    } else if (value == f4560d) {
                        paddedValue2 = paddedValue(j3, z, count);
                    } else if (value == f4557H) {
                        sb.append(paddedValue(j4, z, count));
                        i2 = length;
                    } else if (value == f4561m) {
                        sb.append(paddedValue(j5, z, count));
                        i2 = length;
                    } else {
                        if (value == f4562s) {
                            i2 = length;
                            sb.append(paddedValue(j6, z, count));
                            z2 = true;
                        } else {
                            i2 = length;
                            if (value == f4559S) {
                                if (z2) {
                                    int i4 = 3;
                                    if (z) {
                                        i4 = Math.max(3, count);
                                    }
                                    paddedValue = paddedValue(j7, true, i4);
                                } else {
                                    paddedValue = paddedValue(j7, z, count);
                                }
                                sb.append(paddedValue);
                                z2 = false;
                            }
                        }
                        i3 = i + 1;
                        length = i2;
                        tokenArr2 = tokenArr;
                    }
                    sb.append(paddedValue2);
                    i2 = length;
                }
                z2 = false;
            }
            i3 = i + 1;
            length = i2;
            tokenArr2 = tokenArr;
        }
        return sb.toString();
    }

    public static String formatDuration(long j, String str) {
        return formatDuration(j, str, true);
    }

    public static String formatDuration(long j, String str, boolean z) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        Token[] lexx = lexx(str);
        if (Token.containsTokenWithValue(lexx, f4560d)) {
            j3 = j / 86400000;
            j2 = j - (86400000 * j3);
        } else {
            j2 = j;
            j3 = 0;
        }
        if (Token.containsTokenWithValue(lexx, f4557H)) {
            j4 = j2 / DateUtils.MILLIS_PER_HOUR;
            j2 -= DateUtils.MILLIS_PER_HOUR * j4;
        } else {
            j4 = 0;
        }
        if (Token.containsTokenWithValue(lexx, f4561m)) {
            j5 = j2 / 60000;
            j2 -= 60000 * j5;
        } else {
            j5 = 0;
        }
        if (Token.containsTokenWithValue(lexx, f4562s)) {
            long j8 = j2 / 1000;
            j7 = j2 - (1000 * j8);
            j6 = j8;
        } else {
            j6 = 0;
            j7 = j2;
        }
        return format(lexx, 0L, 0L, j3, j4, j5, j6, j7, z);
    }

    public static String formatDurationHMS(long j) {
        return formatDuration(j, "H:mm:ss.SSS");
    }

    public static String formatDurationISO(long j) {
        return formatDuration(j, ISO_EXTENDED_FORMAT_PATTERN, false);
    }

    public static String formatDurationWords(long j, boolean z, boolean z2) {
        String formatDuration = formatDuration(j, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (z) {
            formatDuration = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringUtils.SPACE, formatDuration);
            String replaceOnce = StringUtils.replaceOnce(formatDuration, " 0 days", "");
            if (replaceOnce.length() != formatDuration.length()) {
                String replaceOnce2 = StringUtils.replaceOnce(replaceOnce, " 0 hours", "");
                if (replaceOnce2.length() != replaceOnce.length()) {
                    formatDuration = StringUtils.replaceOnce(replaceOnce2, " 0 minutes", "");
                    if (formatDuration.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
                    }
                } else {
                    formatDuration = replaceOnce;
                }
            }
            if (formatDuration.length() != 0) {
                formatDuration = formatDuration.substring(1);
            }
        }
        if (z2) {
            String replaceOnce3 = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
            if (replaceOnce3.length() != formatDuration.length()) {
                formatDuration = StringUtils.replaceOnce(replaceOnce3, " 0 minutes", "");
                if (formatDuration.length() != replaceOnce3.length()) {
                    String replaceOnce4 = StringUtils.replaceOnce(formatDuration, " 0 hours", "");
                    if (replaceOnce4.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(replaceOnce4, " 0 days", "");
                    }
                } else {
                    formatDuration = replaceOnce3;
                }
            }
        }
        return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.SPACE + formatDuration, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriod(long j, long j2, String str) {
        return formatPeriod(j, j2, str, true, TimeZone.getDefault());
    }

    public static String formatPeriod(long j, long j2, String str, boolean z, TimeZone timeZone) {
        Token[] lexx = lexx(str);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(j));
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTime(new Date(j2));
        int i = calendar2.get(14) - calendar.get(14);
        int i2 = calendar2.get(13) - calendar.get(13);
        int i3 = calendar2.get(12) - calendar.get(12);
        int i4 = calendar2.get(11) - calendar.get(11);
        int i5 = calendar2.get(5) - calendar.get(5);
        int i6 = calendar2.get(2) - calendar.get(2);
        int i7 = calendar2.get(1) - calendar.get(1);
        while (i < 0) {
            i += 1000;
            i2--;
        }
        while (i2 < 0) {
            i2 += 60;
            i3--;
        }
        while (i3 < 0) {
            i3 += 60;
            i4--;
        }
        while (i4 < 0) {
            i4 += 24;
            i5--;
        }
        int i8 = 0;
        if (Token.containsTokenWithValue(lexx, f4558M)) {
            while (i5 < 0) {
                i5 += calendar.getActualMaximum(5);
                i6--;
                calendar.add(2, 1);
            }
            while (i6 < 0) {
                i6 += 12;
                i7--;
            }
            if (!Token.containsTokenWithValue(lexx, f4563y) && i7 != 0) {
                while (i7 != 0) {
                    i6 += i7 * 12;
                    i7 = 0;
                }
            }
        } else {
            if (!Token.containsTokenWithValue(lexx, f4563y)) {
                int i9 = calendar2.get(1);
                if (i6 < 0) {
                    i9--;
                }
                while (calendar.get(1) != i9) {
                    int actualMaximum = (calendar.getActualMaximum(6) - calendar.get(6)) + i5;
                    if ((calendar instanceof GregorianCalendar) && calendar.get(2) == 1 && calendar.get(5) == 29) {
                        actualMaximum++;
                    }
                    calendar.add(1, 1);
                    i5 = calendar.get(6) + actualMaximum;
                }
                i7 = 0;
            }
            while (calendar.get(2) != calendar2.get(2)) {
                i5 += calendar.getActualMaximum(5);
                calendar.add(2, 1);
            }
            i6 = 0;
            while (i5 < 0) {
                i5 += calendar.getActualMaximum(5);
                i6--;
                calendar.add(2, 1);
            }
        }
        if (!Token.containsTokenWithValue(lexx, f4560d)) {
            i4 += i5 * 24;
            i5 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, f4557H)) {
            i3 += i4 * 60;
            i4 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, f4561m)) {
            i2 += i3 * 60;
            i3 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, f4562s)) {
            i += i2 * 1000;
        } else {
            i8 = i2;
        }
        return format(lexx, i7, i6, i5, i4, i3, i8, i, z);
    }

    public static String formatPeriodISO(long j, long j2) {
        return formatPeriod(j, j2, ISO_EXTENDED_FORMAT_PATTERN, false, TimeZone.getDefault());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0096 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Token[] lexx(String str) {
        Object obj;
        ArrayList arrayList = new ArrayList(str.length());
        boolean z = false;
        StringBuilder sb = null;
        Token token = null;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (z && charAt != '\'') {
                sb.append(charAt);
            } else if (charAt != '\'') {
                if (charAt == 'H') {
                    obj = f4557H;
                } else if (charAt == 'M') {
                    obj = f4558M;
                } else if (charAt == 'S') {
                    obj = f4559S;
                } else if (charAt == 'd') {
                    obj = f4560d;
                } else if (charAt == 'm') {
                    obj = f4561m;
                } else if (charAt == 's') {
                    obj = f4562s;
                } else if (charAt != 'y') {
                    if (sb == null) {
                        sb = new StringBuilder();
                        arrayList.add(new Token(sb));
                    }
                    sb.append(charAt);
                    obj = null;
                } else {
                    obj = f4563y;
                }
                if (obj != null) {
                    if (token == null || token.getValue() != obj) {
                        Token token2 = new Token(obj);
                        arrayList.add(token2);
                        token = token2;
                    } else {
                        token.increment();
                    }
                    sb = null;
                }
            } else if (z) {
                z = false;
                sb = null;
                obj = null;
                if (obj != null) {
                }
            } else {
                sb = new StringBuilder();
                arrayList.add(new Token(sb));
                z = true;
                obj = null;
                if (obj != null) {
                }
            }
        }
        if (!z) {
            return (Token[]) arrayList.toArray(new Token[arrayList.size()]);
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unmatched quote in format: ", str));
    }

    public static String paddedValue(long j, boolean z, int i) {
        String l = Long.toString(j);
        return z ? StringUtils.leftPad(l, i, '0') : l;
    }
}

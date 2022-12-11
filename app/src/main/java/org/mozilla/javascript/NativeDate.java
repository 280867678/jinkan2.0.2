package org.mozilla.javascript;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.tencent.smtt.sdk.TbsListener;
import com.umeng.commonsdk.stateless.C1754b;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import me.tvspark.outline;
import org.apache.http.message.TokenParser;
import org.fourthline.cling.model.Constants;
import org.mozilla.javascript.v8dtoa.FastDtoa;
import org.simpleframework.xml.core.AnnotationHandler;

/* loaded from: classes5.dex */
public final class NativeDate extends IdScriptableObject {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ConstructorId_UTC = -1;
    public static final int ConstructorId_now = -3;
    public static final int ConstructorId_parse = -2;
    public static final Object DATE_TAG = "Date";
    public static final double HalfTimeDomain = 8.64E15d;
    public static final double HoursPerDay = 24.0d;
    public static final int Id_constructor = 1;
    public static final int Id_getDate = 17;
    public static final int Id_getDay = 19;
    public static final int Id_getFullYear = 13;
    public static final int Id_getHours = 21;
    public static final int Id_getMilliseconds = 27;
    public static final int Id_getMinutes = 23;
    public static final int Id_getMonth = 15;
    public static final int Id_getSeconds = 25;
    public static final int Id_getTime = 11;
    public static final int Id_getTimezoneOffset = 29;
    public static final int Id_getUTCDate = 18;
    public static final int Id_getUTCDay = 20;
    public static final int Id_getUTCFullYear = 14;
    public static final int Id_getUTCHours = 22;
    public static final int Id_getUTCMilliseconds = 28;
    public static final int Id_getUTCMinutes = 24;
    public static final int Id_getUTCMonth = 16;
    public static final int Id_getUTCSeconds = 26;
    public static final int Id_getYear = 12;
    public static final int Id_setDate = 39;
    public static final int Id_setFullYear = 43;
    public static final int Id_setHours = 37;
    public static final int Id_setMilliseconds = 31;
    public static final int Id_setMinutes = 35;
    public static final int Id_setMonth = 41;
    public static final int Id_setSeconds = 33;
    public static final int Id_setTime = 30;
    public static final int Id_setUTCDate = 40;
    public static final int Id_setUTCFullYear = 44;
    public static final int Id_setUTCHours = 38;
    public static final int Id_setUTCMilliseconds = 32;
    public static final int Id_setUTCMinutes = 36;
    public static final int Id_setUTCMonth = 42;
    public static final int Id_setUTCSeconds = 34;
    public static final int Id_setYear = 45;
    public static final int Id_toDateString = 4;
    public static final int Id_toGMTString = 8;
    public static final int Id_toISOString = 46;
    public static final int Id_toJSON = 47;
    public static final int Id_toLocaleDateString = 7;
    public static final int Id_toLocaleString = 5;
    public static final int Id_toLocaleTimeString = 6;
    public static final int Id_toSource = 9;
    public static final int Id_toString = 2;
    public static final int Id_toTimeString = 3;
    public static final int Id_toUTCString = 8;
    public static final int Id_valueOf = 10;
    public static double LocalTZA = 0.0d;
    public static final int MAXARGS = 7;
    public static final int MAX_PROTOTYPE_ID = 47;
    public static final double MinutesPerDay = 1440.0d;
    public static final double MinutesPerHour = 60.0d;
    public static final double SecondsPerDay = 86400.0d;
    public static final double SecondsPerHour = 3600.0d;
    public static final double SecondsPerMinute = 60.0d;
    public static final String js_NaN_date_str = "Invalid Date";
    public static DateFormat localeDateFormatter = null;
    public static DateFormat localeDateTimeFormatter = null;
    public static DateFormat localeTimeFormatter = null;
    public static final double msPerDay = 8.64E7d;
    public static final double msPerHour = 3600000.0d;
    public static final double msPerMinute = 60000.0d;
    public static final double msPerSecond = 1000.0d;
    public static final long serialVersionUID = -8307438915861678966L;
    public static TimeZone thisTimeZone;
    public static DateFormat timeZoneFormatter;
    public double date;

    public NativeDate() {
        if (thisTimeZone == null) {
            TimeZone timeZone = TimeZone.getDefault();
            thisTimeZone = timeZone;
            LocalTZA = timeZone.getRawOffset();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int DateFromTime(double d) {
        int YearFromTime = YearFromTime(d);
        int Day = ((int) (Day(d) - DayFromYear(YearFromTime))) - 59;
        int i = 31;
        if (Day < 0) {
            if (Day < -28) {
                Day += 31;
            }
            return Day + 28 + 1;
        }
        if (IsLeapYear(YearFromTime)) {
            if (Day == 0) {
                return 29;
            }
            Day--;
        }
        int i2 = 30;
        switch (Math.round(Day / 30)) {
            case 0:
                return Day + 1;
            case 1:
                i2 = 31;
                break;
            case 2:
                i = 61;
                break;
            case 3:
                i = 92;
                i2 = 31;
                break;
            case 4:
                i = 122;
                break;
            case 5:
                i = 153;
                i2 = 31;
                break;
            case 6:
                i = 184;
                i2 = 31;
                break;
            case 7:
                i = TbsListener.ErrorCode.COPY_TMPDIR_ERROR;
                break;
            case 8:
                i = 245;
                i2 = 31;
                break;
            case 9:
                i = C1754b.f4002g;
                break;
            case 10:
                return (Day - C1754b.f4002g) + 1;
            default:
                throw Kit.codeBug();
        }
        int i3 = Day - i;
        if (i3 < 0) {
            i3 += i2;
        }
        return i3 + 1;
    }

    public static double Day(double d) {
        return Math.floor(d / 8.64E7d);
    }

    public static double DayFromMonth(int i, int i2) {
        int i3;
        int i4;
        int i5 = i * 30;
        if (i >= 7) {
            i4 = i / 2;
        } else if (i < 2) {
            i3 = i5 + i;
            if (i >= 2 && IsLeapYear(i2)) {
                i3++;
            }
            return i3;
        } else {
            i4 = (i - 1) / 2;
        }
        i3 = (i4 - 1) + i5;
        if (i >= 2) {
            i3++;
        }
        return i3;
    }

    public static double DayFromYear(double d) {
        double floor = Math.floor((d - 1969.0d) / 4.0d);
        return Math.floor((d - 1601.0d) / 400.0d) + ((floor + ((d - 1970.0d) * 365.0d)) - Math.floor((d - 1901.0d) / 100.0d));
    }

    public static double DaylightSavingTA(double d) {
        if (d < RoundRectDrawableWithShadow.COS_45) {
            d = MakeDate(MakeDay(EquivalentYear(YearFromTime(d)), MonthFromTime(d), DateFromTime(d)), TimeWithinDay(d));
        }
        if (thisTimeZone.inDaylightTime(new Date((long) d))) {
            return 3600000.0d;
        }
        return RoundRectDrawableWithShadow.COS_45;
    }

    public static int DaysInMonth(int i, int i2) {
        return i2 == 2 ? IsLeapYear(i) ? 29 : 28 : i2 >= 8 ? 31 - (i2 & 1) : (i2 & 1) + 30;
    }

    public static double DaysInYear(double d) {
        return (Double.isInfinite(d) || Double.isNaN(d)) ? ScriptRuntime.NaN : IsLeapYear((int) d) ? 366.0d : 365.0d;
    }

    public static int EquivalentYear(int i) {
        int DayFromYear = (((int) DayFromYear(i)) + 4) % 7;
        if (DayFromYear < 0) {
            DayFromYear += 7;
        }
        if (IsLeapYear(i)) {
            switch (DayFromYear) {
                case 0:
                    return 1984;
                case 1:
                    return 1996;
                case 2:
                    return 1980;
                case 3:
                    return 1992;
                case 4:
                    return 1976;
                case 5:
                    return 1988;
                case 6:
                    return 1972;
            }
        }
        switch (DayFromYear) {
            case 0:
                return 1978;
            case 1:
                return 1973;
            case 2:
                return 1985;
            case 3:
                return 1986;
            case 4:
                return 1981;
            case 5:
                return 1971;
            case 6:
                return 1977;
        }
        throw Kit.codeBug();
    }

    public static int HourFromTime(double d) {
        double floor = Math.floor(d / 3600000.0d) % 24.0d;
        if (floor < RoundRectDrawableWithShadow.COS_45) {
            floor += 24.0d;
        }
        return (int) floor;
    }

    public static boolean IsLeapYear(int i) {
        return i % 4 == 0 && (i % 100 != 0 || i % 400 == 0);
    }

    public static double LocalTime(double d) {
        return DaylightSavingTA(d) + LocalTZA + d;
    }

    public static double MakeDate(double d, double d2) {
        return (d * 8.64E7d) + d2;
    }

    public static double MakeDay(double d, double d2, double d3) {
        double floor = Math.floor(d2 / 12.0d) + d;
        double d4 = d2 % 12.0d;
        if (d4 < RoundRectDrawableWithShadow.COS_45) {
            d4 += 12.0d;
        }
        return ((DayFromMonth((int) d4, (int) floor) + Math.floor(TimeFromYear(floor) / 8.64E7d)) + d3) - 1.0d;
    }

    public static double MakeTime(double d, double d2, double d3, double d4) {
        return (((((d * 60.0d) + d2) * 60.0d) + d3) * 1000.0d) + d4;
    }

    public static int MinFromTime(double d) {
        double floor = Math.floor(d / 60000.0d) % 60.0d;
        if (floor < RoundRectDrawableWithShadow.COS_45) {
            floor += 60.0d;
        }
        return (int) floor;
    }

    public static int MonthFromTime(double d) {
        int i;
        int YearFromTime = YearFromTime(d);
        int Day = ((int) (Day(d) - DayFromYear(YearFromTime))) - 59;
        if (Day < 0) {
            return Day < -28 ? 0 : 1;
        }
        if (IsLeapYear(YearFromTime)) {
            if (Day == 0) {
                return 1;
            }
            Day--;
        }
        int i2 = Day / 30;
        switch (i2) {
            case 0:
                return 2;
            case 1:
                i = 31;
                break;
            case 2:
                i = 61;
                break;
            case 3:
                i = 92;
                break;
            case 4:
                i = 122;
                break;
            case 5:
                i = 153;
                break;
            case 6:
                i = 184;
                break;
            case 7:
                i = TbsListener.ErrorCode.COPY_TMPDIR_ERROR;
                break;
            case 8:
                i = 245;
                break;
            case 9:
                i = C1754b.f4002g;
                break;
            case 10:
                return 11;
            default:
                throw Kit.codeBug();
        }
        return Day >= i ? i2 + 2 : i2 + 1;
    }

    public static int SecFromTime(double d) {
        double floor = Math.floor(d / 1000.0d) % 60.0d;
        if (floor < RoundRectDrawableWithShadow.COS_45) {
            floor += 60.0d;
        }
        return (int) floor;
    }

    public static double TimeClip(double d) {
        if (d != d || d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY || Math.abs(d) > 8.64E15d) {
            return ScriptRuntime.NaN;
        }
        int i = (d > RoundRectDrawableWithShadow.COS_45 ? 1 : (d == RoundRectDrawableWithShadow.COS_45 ? 0 : -1));
        double d2 = d + RoundRectDrawableWithShadow.COS_45;
        return i > 0 ? Math.floor(d2) : Math.ceil(d2);
    }

    public static double TimeFromYear(double d) {
        return DayFromYear(d) * 8.64E7d;
    }

    public static double TimeWithinDay(double d) {
        double d2 = d % 8.64E7d;
        return d2 < RoundRectDrawableWithShadow.COS_45 ? d2 + 8.64E7d : d2;
    }

    public static int WeekDay(double d) {
        double Day = (Day(d) + 4.0d) % 7.0d;
        if (Day < RoundRectDrawableWithShadow.COS_45) {
            Day += 7.0d;
        }
        return (int) Day;
    }

    public static int YearFromTime(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            return 0;
        }
        double floor = Math.floor(d / 3.1556952E10d) + 1970.0d;
        double TimeFromYear = TimeFromYear(floor);
        if (TimeFromYear > d) {
            floor -= 1.0d;
        } else if ((DaysInYear(floor) * 8.64E7d) + TimeFromYear <= d) {
            floor += 1.0d;
        }
        return (int) floor;
    }

    public static void append0PaddedUint(StringBuilder sb, int i, int i2) {
        if (i < 0) {
            Kit.codeBug();
        }
        int i3 = i2 - 1;
        int i4 = FastDtoa.kTen9;
        if (i < 10) {
            i4 = 1;
        } else if (i < 1000000000) {
            i4 = 1;
            while (true) {
                int i5 = i4 * 10;
                if (i < i5) {
                    break;
                }
                i3--;
                i4 = i5;
            }
        } else {
            i3 -= 9;
        }
        while (i3 > 0) {
            sb.append('0');
            i3--;
        }
        while (i4 != 1) {
            sb.append((char) ((i / i4) + 48));
            i %= i4;
            i4 /= 10;
        }
        sb.append((char) (i + 48));
    }

    public static void appendMonthName(StringBuilder sb, int i) {
        int i2 = i * 3;
        for (int i3 = 0; i3 != 3; i3++) {
            sb.append("JanFebMarAprMayJunJulAugSepOctNovDec".charAt(i2 + i3));
        }
    }

    public static void appendWeekDayName(StringBuilder sb, int i) {
        int i2 = i * 3;
        for (int i3 = 0; i3 != 3; i3++) {
            sb.append("SunMonTueWedThuFriSat".charAt(i2 + i3));
        }
    }

    public static String date_format(double d, int i) {
        StringBuilder sb = new StringBuilder(60);
        double LocalTime = LocalTime(d);
        if (i != 3) {
            appendWeekDayName(sb, WeekDay(LocalTime));
            sb.append(TokenParser.f4579SP);
            appendMonthName(sb, MonthFromTime(LocalTime));
            sb.append(TokenParser.f4579SP);
            append0PaddedUint(sb, DateFromTime(LocalTime), 2);
            sb.append(TokenParser.f4579SP);
            int YearFromTime = YearFromTime(LocalTime);
            if (YearFromTime < 0) {
                sb.append('-');
                YearFromTime = -YearFromTime;
            }
            append0PaddedUint(sb, YearFromTime, 4);
            if (i != 4) {
                sb.append(TokenParser.f4579SP);
            }
        }
        if (i != 4) {
            append0PaddedUint(sb, HourFromTime(LocalTime), 2);
            sb.append(':');
            append0PaddedUint(sb, MinFromTime(LocalTime), 2);
            sb.append(':');
            append0PaddedUint(sb, SecFromTime(LocalTime), 2);
            int floor = (int) Math.floor((DaylightSavingTA(d) + LocalTZA) / 60000.0d);
            int i2 = (floor % 60) + ((floor / 60) * 100);
            if (i2 > 0) {
                sb.append(" GMT+");
            } else {
                sb.append(" GMT-");
                i2 = -i2;
            }
            append0PaddedUint(sb, i2, 4);
            if (timeZoneFormatter == null) {
                timeZoneFormatter = new SimpleDateFormat("zzz");
            }
            if (d < RoundRectDrawableWithShadow.COS_45) {
                d = MakeDate(MakeDay(EquivalentYear(YearFromTime(LocalTime)), MonthFromTime(d), DateFromTime(d)), TimeWithinDay(d));
            }
            sb.append(" (");
            Date date = new Date((long) d);
            synchronized (timeZoneFormatter) {
                sb.append(timeZoneFormatter.format(date));
            }
            sb.append(')');
        }
        return sb.toString();
    }

    public static double date_msecFromArgs(Object[] objArr) {
        double[] dArr = new double[7];
        for (int i = 0; i < 7; i++) {
            if (i < objArr.length) {
                double number = ScriptRuntime.toNumber(objArr[i]);
                if (number != number || Double.isInfinite(number)) {
                    return ScriptRuntime.NaN;
                }
                dArr[i] = ScriptRuntime.toInteger(objArr[i]);
            } else if (i == 2) {
                dArr[i] = 1.0d;
            } else {
                dArr[i] = 0.0d;
            }
        }
        if (dArr[0] >= RoundRectDrawableWithShadow.COS_45 && dArr[0] <= 99.0d) {
            dArr[0] = dArr[0] + 1900.0d;
        }
        return date_msecFromDate(dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5], dArr[6]);
    }

    public static double date_msecFromDate(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        return MakeDate(MakeDay(d, d2, d3), MakeTime(d4, d5, d6, d7));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:105:0x014f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static double date_parseString(String str) {
        int i;
        int i2;
        int i3;
        double parseISOString = parseISOString(str);
        if (parseISOString == parseISOString) {
            return parseISOString;
        }
        int length = str.length();
        int i4 = 0;
        char c = 0;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        double d = -1.0d;
        boolean z = false;
        while (i4 < length) {
            char charAt = str.charAt(i4);
            i4++;
            if (charAt <= ' ' || charAt == ',' || charAt == '-') {
                char c2 = c;
                i = i5;
                if (i4 < length) {
                    char charAt2 = str.charAt(i4);
                    if (charAt == '-' && '0' <= charAt2 && charAt2 <= '9') {
                        c = charAt;
                        i5 = i;
                    }
                }
                i5 = i;
                c = c2;
            } else {
                int i11 = 1;
                if (charAt == '(') {
                    while (i4 < length) {
                        char charAt3 = str.charAt(i4);
                        i4++;
                        if (charAt3 != '(') {
                            if (charAt3 == ')' && i11 - 1 <= 0) {
                                break;
                            }
                        } else {
                            i11++;
                        }
                    }
                } else if ('0' <= charAt && charAt <= '9') {
                    int i12 = charAt - '0';
                    while (i4 < length) {
                        charAt = str.charAt(i4);
                        if ('0' <= charAt && charAt <= '9') {
                            i12 = ((i12 * 10) + charAt) - 48;
                            i4++;
                        }
                        if (c != '+' || c == '-') {
                            i3 = i12 >= 24 ? i12 * 60 : ((i12 / 100) * 60) + (i12 % 100);
                            if (c == '+') {
                                i3 = -i3;
                            }
                            if (d == RoundRectDrawableWithShadow.COS_45 && d != -1.0d) {
                                return ScriptRuntime.NaN;
                            }
                            d = i3;
                            z = true;
                        } else if (i12 >= 70 || (c == '/' && i7 >= 0 && i8 >= 0 && i6 < 0)) {
                            if (i6 >= 0) {
                                return ScriptRuntime.NaN;
                            }
                            if (charAt > ' ' && charAt != ',' && charAt != '/' && i4 < length) {
                                return ScriptRuntime.NaN;
                            }
                            if (i12 < 100) {
                                i12 += Constants.UPNP_MULTICAST_PORT;
                            }
                            i6 = i12;
                        } else if (charAt == ':') {
                            if (i5 < 0) {
                                i5 = i12;
                            } else {
                                if (i10 >= 0) {
                                    return ScriptRuntime.NaN;
                                }
                                i10 = i12;
                            }
                        } else if (charAt == '/') {
                            if (i7 < 0) {
                                i7 = i12 - 1;
                            } else {
                                if (i8 >= 0) {
                                    return ScriptRuntime.NaN;
                                }
                                i8 = i12;
                            }
                        } else if (i4 < length && charAt != ',' && charAt > ' ' && charAt != '-') {
                            return ScriptRuntime.NaN;
                        } else {
                            if (!z || i12 >= 60) {
                                if (i5 < 0 || i10 >= 0) {
                                    if (i10 < 0 || i9 >= 0) {
                                        if (i8 >= 0) {
                                            return ScriptRuntime.NaN;
                                        }
                                        i8 = i12;
                                    } else {
                                        i9 = i12;
                                    }
                                }
                                i10 = i12;
                            } else {
                                d = d < RoundRectDrawableWithShadow.COS_45 ? d - i12 : d + i12;
                            }
                        }
                        c = 0;
                    }
                    if (c != '+') {
                    }
                    if (i12 >= 24) {
                    }
                    if (c == '+') {
                    }
                    if (d == RoundRectDrawableWithShadow.COS_45) {
                    }
                    d = i3;
                    z = true;
                    c = 0;
                } else if (charAt == '/' || charAt == ':' || charAt == '+' || charAt == '-') {
                    i = i5;
                    c = charAt;
                    i5 = i;
                } else {
                    int i13 = i4 - 1;
                    int i14 = i4;
                    while (i14 < length) {
                        char charAt4 = str.charAt(i14);
                        if (('A' <= charAt4 && charAt4 <= 'Z') || ('a' <= charAt4 && charAt4 <= 'z')) {
                            i14++;
                        }
                        i2 = i14 - i13;
                        if (i2 >= 2) {
                            return ScriptRuntime.NaN;
                        }
                        String str2 = "am;pm;monday;tuesday;wednesday;thursday;friday;saturday;sunday;january;february;march;april;may;june;july;august;september;october;november;december;gmt;ut;utc;est;edt;cst;cdt;mst;mdt;pst;pdt;";
                        int i15 = 0;
                        int i16 = 0;
                        while (true) {
                            int indexOf = str2.indexOf(59, i16);
                            if (indexOf < 0) {
                                return ScriptRuntime.NaN;
                            }
                            int i17 = i14;
                            int i18 = i15;
                            String str3 = str2;
                            char c3 = c;
                            int i19 = i13;
                            int i20 = i13;
                            int i21 = i5;
                            if (str2.regionMatches(true, i16, str, i19, i2)) {
                                double d2 = 420.0d;
                                if (i18 >= 2) {
                                    int i22 = i18 - 2;
                                    if (i22 >= 7) {
                                        int i23 = i22 - 7;
                                        if (i23 >= 12) {
                                            switch (i23 - 12) {
                                                case 0:
                                                case 1:
                                                case 2:
                                                    i5 = i21;
                                                    d = 0.0d;
                                                    break;
                                                case 3:
                                                case 6:
                                                    d = 300.0d;
                                                    break;
                                                case 4:
                                                    d2 = 240.0d;
                                                    d = d2;
                                                    break;
                                                case 5:
                                                case 8:
                                                    i5 = i21;
                                                    d = 360.0d;
                                                    break;
                                                case 7:
                                                case 10:
                                                    d = d2;
                                                    break;
                                                case 9:
                                                    d2 = 480.0d;
                                                    d = d2;
                                                    break;
                                                default:
                                                    Kit.codeBug();
                                                    break;
                                            }
                                            c = c3;
                                            i4 = i17;
                                        } else if (i7 >= 0) {
                                            return ScriptRuntime.NaN;
                                        } else {
                                            i7 = i23;
                                        }
                                    }
                                    i5 = i21;
                                    c = c3;
                                    i4 = i17;
                                } else if (i21 > 12 || i21 < 0) {
                                    return ScriptRuntime.NaN;
                                } else {
                                    if (i18 == 0) {
                                        if (i21 == 12) {
                                            i5 = 0;
                                            c = c3;
                                            i4 = i17;
                                        }
                                        i5 = i21;
                                        c = c3;
                                        i4 = i17;
                                    } else {
                                        if (i21 != 12) {
                                            i5 = i21 + 12;
                                            c = c3;
                                            i4 = i17;
                                        }
                                        i5 = i21;
                                        c = c3;
                                        i4 = i17;
                                    }
                                }
                            } else {
                                i16 = indexOf + 1;
                                i15 = i18 + 1;
                                i5 = i21;
                                c = c3;
                                i14 = i17;
                                i13 = i20;
                                str2 = str3;
                            }
                        }
                    }
                    i2 = i14 - i13;
                    if (i2 >= 2) {
                    }
                }
            }
        }
        int i24 = i5;
        if (i6 < 0 || i7 < 0 || i8 < 0) {
            return ScriptRuntime.NaN;
        }
        if (i9 < 0) {
            i9 = 0;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        double date_msecFromDate = date_msecFromDate(i6, i7, i8, i24 < 0 ? 0 : i24, i10, i9, RoundRectDrawableWithShadow.COS_45);
        return d == -1.0d ? internalUTC(date_msecFromDate) : (d * 60000.0d) + date_msecFromDate;
    }

    public static void init(Scriptable scriptable, boolean z) {
        NativeDate nativeDate = new NativeDate();
        nativeDate.date = ScriptRuntime.NaN;
        nativeDate.exportAsJSClass(47, scriptable, z);
    }

    public static double internalUTC(double d) {
        double d2 = LocalTZA;
        return (d - d2) - DaylightSavingTA(d - d2);
    }

    public static Object jsConstructor(Object[] objArr) {
        double TimeClip;
        NativeDate nativeDate = new NativeDate();
        if (objArr.length == 0) {
            TimeClip = now();
        } else if (objArr.length != 1) {
            double date_msecFromArgs = date_msecFromArgs(objArr);
            if (!Double.isNaN(date_msecFromArgs) && !Double.isInfinite(date_msecFromArgs)) {
                date_msecFromArgs = TimeClip(internalUTC(date_msecFromArgs));
            }
            nativeDate.date = date_msecFromArgs;
            return nativeDate;
        } else {
            Object obj = objArr[0];
            if (obj instanceof NativeDate) {
                TimeClip = ((NativeDate) obj).date;
            } else {
                if (obj instanceof Scriptable) {
                    obj = ((Scriptable) obj).getDefaultValue(null);
                }
                TimeClip = TimeClip(obj instanceof CharSequence ? date_parseString(obj.toString()) : ScriptRuntime.toNumber(obj));
            }
        }
        nativeDate.date = TimeClip;
        return nativeDate;
    }

    public static double jsStaticFunction_UTC(Object[] objArr) {
        return objArr.length == 0 ? ScriptRuntime.NaN : TimeClip(date_msecFromArgs(objArr));
    }

    public static String js_toISOString(double d) {
        StringBuilder sb = new StringBuilder(27);
        int YearFromTime = YearFromTime(d);
        int i = 6;
        if (YearFromTime < 0) {
            sb.append('-');
            YearFromTime = -YearFromTime;
        } else if (YearFromTime <= 9999) {
            i = 4;
        }
        append0PaddedUint(sb, YearFromTime, i);
        sb.append('-');
        append0PaddedUint(sb, MonthFromTime(d) + 1, 2);
        sb.append('-');
        append0PaddedUint(sb, DateFromTime(d), 2);
        sb.append('T');
        append0PaddedUint(sb, HourFromTime(d), 2);
        sb.append(':');
        append0PaddedUint(sb, MinFromTime(d), 2);
        sb.append(':');
        append0PaddedUint(sb, SecFromTime(d), 2);
        sb.append('.');
        append0PaddedUint(sb, msFromTime(d), 3);
        sb.append('Z');
        return sb.toString();
    }

    public static String js_toUTCString(double d) {
        StringBuilder sb = new StringBuilder(60);
        appendWeekDayName(sb, WeekDay(d));
        sb.append(", ");
        append0PaddedUint(sb, DateFromTime(d), 2);
        sb.append(TokenParser.f4579SP);
        appendMonthName(sb, MonthFromTime(d));
        sb.append(TokenParser.f4579SP);
        int YearFromTime = YearFromTime(d);
        if (YearFromTime < 0) {
            sb.append('-');
            YearFromTime = -YearFromTime;
        }
        append0PaddedUint(sb, YearFromTime, 4);
        sb.append(TokenParser.f4579SP);
        append0PaddedUint(sb, HourFromTime(d), 2);
        sb.append(':');
        append0PaddedUint(sb, MinFromTime(d), 2);
        sb.append(':');
        append0PaddedUint(sb, SecFromTime(d), 2);
        sb.append(" GMT");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static double makeDate(double d, Object[] objArr, int i) {
        boolean z;
        int i2;
        int length;
        int i3;
        boolean z2;
        double LocalTime;
        double YearFromTime;
        double MonthFromTime;
        if (objArr.length == 0) {
            return ScriptRuntime.NaN;
        }
        int i4 = 0;
        switch (i) {
            case 39:
                z = true;
                i2 = 1;
                length = objArr.length >= i2 ? objArr.length : i2;
                double[] dArr = new double[3];
                z2 = false;
                for (i3 = 0; i3 < length; i3++) {
                    double number = ScriptRuntime.toNumber(objArr[i3]);
                    if (number != number || Double.isInfinite(number)) {
                        z2 = true;
                    } else {
                        dArr[i3] = ScriptRuntime.toInteger(number);
                    }
                }
                if (!z2) {
                    return ScriptRuntime.NaN;
                }
                if (d == d) {
                    LocalTime = z ? LocalTime(d) : d;
                } else if (i2 < 3) {
                    return ScriptRuntime.NaN;
                } else {
                    LocalTime = RoundRectDrawableWithShadow.COS_45;
                }
                if (i2 < 3 || length <= 0) {
                    YearFromTime = YearFromTime(LocalTime);
                } else {
                    YearFromTime = dArr[0];
                    i4 = 1;
                }
                if (i2 < 2 || i4 >= length) {
                    MonthFromTime = MonthFromTime(LocalTime);
                } else {
                    double d2 = dArr[i4];
                    i4++;
                    MonthFromTime = d2;
                }
                double MakeDate = MakeDate(MakeDay(YearFromTime, MonthFromTime, (i2 < 1 || i4 >= length) ? DateFromTime(LocalTime) : dArr[i4]), TimeWithinDay(LocalTime));
                if (z) {
                    MakeDate = internalUTC(MakeDate);
                }
                return TimeClip(MakeDate);
            case 40:
                z = false;
                i2 = 1;
                if (objArr.length >= i2) {
                }
                double[] dArr2 = new double[3];
                z2 = false;
                while (i3 < length) {
                }
                if (!z2) {
                }
                break;
            case 41:
                z = true;
                i2 = 2;
                if (objArr.length >= i2) {
                }
                double[] dArr22 = new double[3];
                z2 = false;
                while (i3 < length) {
                }
                if (!z2) {
                }
                break;
            case 42:
                z = false;
                i2 = 2;
                if (objArr.length >= i2) {
                }
                double[] dArr222 = new double[3];
                z2 = false;
                while (i3 < length) {
                }
                if (!z2) {
                }
                break;
            case 43:
                z = true;
                i2 = 3;
                if (objArr.length >= i2) {
                }
                double[] dArr2222 = new double[3];
                z2 = false;
                while (i3 < length) {
                }
                if (!z2) {
                }
                break;
            case 44:
                z = false;
                i2 = 3;
                if (objArr.length >= i2) {
                }
                double[] dArr22222 = new double[3];
                z2 = false;
                while (i3 < length) {
                }
                if (!z2) {
                }
                break;
            default:
                throw Kit.codeBug();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static double makeTime(double d, Object[] objArr, int i) {
        boolean z;
        int i2;
        int length;
        int i3;
        boolean z2;
        double HourFromTime;
        double MinFromTime;
        double SecFromTime;
        if (objArr.length == 0) {
            return ScriptRuntime.NaN;
        }
        int i4 = 0;
        switch (i) {
            case 31:
                z = true;
                i2 = 1;
                length = objArr.length >= i2 ? objArr.length : i2;
                double[] dArr = new double[4];
                z2 = false;
                for (i3 = 0; i3 < length; i3++) {
                    double number = ScriptRuntime.toNumber(objArr[i3]);
                    if (number != number || Double.isInfinite(number)) {
                        z2 = true;
                    } else {
                        dArr[i3] = ScriptRuntime.toInteger(number);
                    }
                }
                if (!z2 || d != d) {
                    return ScriptRuntime.NaN;
                }
                double LocalTime = z ? LocalTime(d) : d;
                if (i2 < 4 || length <= 0) {
                    HourFromTime = HourFromTime(LocalTime);
                } else {
                    HourFromTime = dArr[0];
                    i4 = 1;
                }
                if (i2 < 3 || i4 >= length) {
                    MinFromTime = MinFromTime(LocalTime);
                } else {
                    MinFromTime = dArr[i4];
                    i4++;
                }
                if (i2 < 2 || i4 >= length) {
                    SecFromTime = SecFromTime(LocalTime);
                } else {
                    double d2 = dArr[i4];
                    i4++;
                    SecFromTime = d2;
                }
                double MakeDate = MakeDate(Day(LocalTime), MakeTime(HourFromTime, MinFromTime, SecFromTime, (i2 < 1 || i4 >= length) ? msFromTime(LocalTime) : dArr[i4]));
                if (z) {
                    MakeDate = internalUTC(MakeDate);
                }
                return TimeClip(MakeDate);
            case 32:
                z = false;
                i2 = 1;
                if (objArr.length >= i2) {
                }
                double[] dArr2 = new double[4];
                z2 = false;
                while (i3 < length) {
                }
                if (!z2) {
                    break;
                }
                return ScriptRuntime.NaN;
            case 33:
                z = true;
                i2 = 2;
                if (objArr.length >= i2) {
                }
                double[] dArr22 = new double[4];
                z2 = false;
                while (i3 < length) {
                }
                if (!z2) {
                }
                return ScriptRuntime.NaN;
            case 34:
                z = false;
                i2 = 2;
                if (objArr.length >= i2) {
                }
                double[] dArr222 = new double[4];
                z2 = false;
                while (i3 < length) {
                }
                if (!z2) {
                }
                return ScriptRuntime.NaN;
            case 35:
                z = true;
                i2 = 3;
                if (objArr.length >= i2) {
                }
                double[] dArr2222 = new double[4];
                z2 = false;
                while (i3 < length) {
                }
                if (!z2) {
                }
                return ScriptRuntime.NaN;
            case 36:
                z = false;
                i2 = 3;
                if (objArr.length >= i2) {
                }
                double[] dArr22222 = new double[4];
                z2 = false;
                while (i3 < length) {
                }
                if (!z2) {
                }
                return ScriptRuntime.NaN;
            case 37:
                z = true;
                i2 = 4;
                if (objArr.length >= i2) {
                }
                double[] dArr222222 = new double[4];
                z2 = false;
                while (i3 < length) {
                }
                if (!z2) {
                }
                return ScriptRuntime.NaN;
            case 38:
                z = false;
                i2 = 4;
                if (objArr.length >= i2) {
                }
                double[] dArr2222222 = new double[4];
                z2 = false;
                while (i3 < length) {
                }
                if (!z2) {
                }
                return ScriptRuntime.NaN;
            default:
                throw Kit.codeBug();
        }
    }

    public static int msFromTime(double d) {
        double d2 = d % 1000.0d;
        if (d2 < RoundRectDrawableWithShadow.COS_45) {
            d2 += 1000.0d;
        }
        return (int) d2;
    }

    public static double now() {
        return System.currentTimeMillis();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
        r0 = -1;
        r13 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00bc, code lost:
        if (r8 != '-') goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00ce, code lost:
        r10 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00cb, code lost:
        if (r8 != '-') goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x011d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0120 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static double parseISOString(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        double date_msecFromDate;
        int i14;
        char c;
        int i15;
        int[] iArr = {1970, 1, 1, 0, 0, 0, 0, -1, -1};
        int length = str.length();
        int i16 = -1;
        if (length != 0) {
            char charAt = str.charAt(0);
            if (charAt == '+' || charAt == '-') {
                i = charAt == '-' ? -1 : 1;
                i2 = 0;
                i3 = 1;
                i4 = 6;
                int i17 = 1;
                while (true) {
                    if (i2 != i16) {
                        int i18 = i3 + (i2 == 0 ? i4 : i2 == 6 ? 3 : 2);
                        if (i18 <= length) {
                            int i19 = 0;
                            while (true) {
                                if (i3 >= i18) {
                                    iArr[i2] = i19;
                                    if (i3 != length) {
                                        i14 = i3 + 1;
                                        char charAt2 = str.charAt(i3);
                                        if (charAt2 == 'Z') {
                                            iArr[7] = 0;
                                            iArr[8] = 0;
                                            if (i2 == 4 || i2 == 5 || i2 == 6) {
                                                i3 = i14;
                                            } else {
                                                i3 = i14;
                                            }
                                        } else {
                                            switch (i2) {
                                                case 0:
                                                case 1:
                                                    c = '-';
                                                    if (charAt2 != '-') {
                                                        if (charAt2 != 'T') {
                                                            i2 = -1;
                                                            break;
                                                        } else {
                                                            i2 = 3;
                                                            break;
                                                        }
                                                    } else {
                                                        i2++;
                                                        break;
                                                    }
                                                case 2:
                                                    i2 = charAt2 == 'T' ? 3 : -1;
                                                    c = '-';
                                                    break;
                                                case 3:
                                                    if (charAt2 == ':') {
                                                        i2 = 4;
                                                        c = '-';
                                                        break;
                                                    }
                                                    i2 = -1;
                                                    c = '-';
                                                case 4:
                                                    if (charAt2 == ':') {
                                                        i2 = 5;
                                                    } else {
                                                        if (charAt2 == '+' || charAt2 == '-') {
                                                            i2 = 7;
                                                        }
                                                        i2 = -1;
                                                    }
                                                    c = '-';
                                                    break;
                                                case 5:
                                                    if (charAt2 == '.') {
                                                        i15 = 6;
                                                        i2 = i15;
                                                        c = '-';
                                                        break;
                                                    } else {
                                                        if (charAt2 != '+') {
                                                        }
                                                        i15 = 7;
                                                        i2 = i15;
                                                        c = '-';
                                                    }
                                                    break;
                                                case 6:
                                                    if (charAt2 != '+') {
                                                    }
                                                    i15 = 7;
                                                    i2 = i15;
                                                    c = '-';
                                                    break;
                                                case 7:
                                                    if (charAt2 != ':') {
                                                        i14--;
                                                    }
                                                    c = '-';
                                                    i2 = 8;
                                                    break;
                                                case 8:
                                                    c = '-';
                                                    i2 = -1;
                                                    break;
                                                default:
                                                    c = '-';
                                                    break;
                                            }
                                            if (i2 == 7) {
                                                i17 = charAt2 == c ? -1 : 1;
                                            }
                                            i3 = i14;
                                            i16 = -1;
                                        }
                                    } else if (i2 == 3 || i2 == 7) {
                                        i2 = -1;
                                    }
                                } else {
                                    char charAt3 = str.charAt(i3);
                                    if (charAt3 >= '0' && charAt3 <= '9') {
                                        i19 = (charAt3 - '0') + (i19 * 10);
                                        i3++;
                                    }
                                }
                            }
                        }
                    }
                }
                i5 = -1;
                if (i2 != i5 && i3 == length) {
                    i6 = iArr[0];
                    i7 = iArr[1];
                    i8 = iArr[2];
                    i9 = iArr[3];
                    i10 = iArr[4];
                    i11 = iArr[5];
                    i12 = iArr[6];
                    i13 = iArr[7];
                    int i20 = iArr[8];
                    if (i6 <= 275943 && i7 >= 1 && i7 <= 12 && i8 >= 1 && i8 <= DaysInMonth(i6, i7) && i9 <= 24 && ((i9 != 24 || (i10 <= 0 && i11 <= 0 && i12 <= 0)) && i10 <= 59 && i11 <= 59 && i13 <= 23 && i20 <= 59)) {
                        date_msecFromDate = date_msecFromDate(i6 * i, i7 - 1, i8, i9, i10, i11, i12);
                        if (i13 != -1) {
                            date_msecFromDate -= (((i13 * 60) + i20) * 60000.0d) * i17;
                        }
                        if (date_msecFromDate >= -8.64E15d && date_msecFromDate <= 8.64E15d) {
                            return date_msecFromDate;
                        }
                    }
                }
                return ScriptRuntime.NaN;
            } else if (charAt == 'T') {
                i = 1;
                i2 = 3;
                i3 = 1;
                i4 = 4;
                int i172 = 1;
                while (true) {
                    if (i2 != i16) {
                    }
                    i3 = i14;
                    i16 = -1;
                }
                i5 = -1;
                if (i2 != i5) {
                    i6 = iArr[0];
                    i7 = iArr[1];
                    i8 = iArr[2];
                    i9 = iArr[3];
                    i10 = iArr[4];
                    i11 = iArr[5];
                    i12 = iArr[6];
                    i13 = iArr[7];
                    int i202 = iArr[8];
                    if (i6 <= 275943) {
                        date_msecFromDate = date_msecFromDate(i6 * i, i7 - 1, i8, i9, i10, i11, i12);
                        if (i13 != -1) {
                        }
                        if (date_msecFromDate >= -8.64E15d) {
                            return date_msecFromDate;
                        }
                    }
                }
                return ScriptRuntime.NaN;
            }
        }
        i = 1;
        i2 = 0;
        i3 = 0;
        i4 = 4;
        int i1722 = 1;
        while (true) {
            if (i2 != i16) {
            }
            i3 = i14;
            i16 = -1;
        }
        i5 = -1;
        if (i2 != i5) {
        }
        return ScriptRuntime.NaN;
    }

    public static String toLocale_helper(double d, int i) {
        DateFormat dateFormat;
        String format;
        if (i == 5) {
            if (localeDateTimeFormatter == null) {
                localeDateTimeFormatter = DateFormat.getDateTimeInstance(1, 1);
            }
            dateFormat = localeDateTimeFormatter;
        } else if (i == 6) {
            if (localeTimeFormatter == null) {
                localeTimeFormatter = DateFormat.getTimeInstance(1);
            }
            dateFormat = localeTimeFormatter;
        } else if (i != 7) {
            throw new AssertionError();
        } else {
            if (localeDateFormatter == null) {
                localeDateFormatter = DateFormat.getDateInstance(1);
            }
            dateFormat = localeDateFormatter;
        }
        synchronized (dateFormat) {
            format = dateFormat.format(new Date((long) d));
        }
        return format;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double d;
        if (!idFunctionObject.hasTag(DATE_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId == -3) {
            return ScriptRuntime.wrapNumber(now());
        }
        if (methodId == -2) {
            return ScriptRuntime.wrapNumber(date_parseString(ScriptRuntime.toString(objArr, 0)));
        }
        if (methodId == -1) {
            return ScriptRuntime.wrapNumber(jsStaticFunction_UTC(objArr));
        }
        if (methodId == 1) {
            return scriptable2 != null ? date_format(now(), 2) : jsConstructor(objArr);
        } else if (methodId == 47) {
            Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
            Object primitive = ScriptRuntime.toPrimitive(object, ScriptRuntime.NumberClass);
            if (primitive instanceof Number) {
                double doubleValue = ((Number) primitive).doubleValue();
                if (doubleValue != doubleValue || Double.isInfinite(doubleValue)) {
                    return null;
                }
            }
            Object property = ScriptableObject.getProperty(object, "toISOString");
            if (property == Scriptable.NOT_FOUND) {
                throw ScriptRuntime.typeError2("msg.function.not.found.in", "toISOString", ScriptRuntime.toString(object));
            }
            if (!(property instanceof Callable)) {
                throw ScriptRuntime.typeError3("msg.isnt.function.in", "toISOString", ScriptRuntime.toString(object), ScriptRuntime.toString(property));
            }
            Object call = ((Callable) property).call(context, scriptable, object, ScriptRuntime.emptyArgs);
            if (!ScriptRuntime.isPrimitive(call)) {
                throw ScriptRuntime.typeError1("msg.toisostring.must.return.primitive", ScriptRuntime.toString(call));
            }
            return call;
        } else if (!(scriptable2 instanceof NativeDate)) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        } else {
            NativeDate nativeDate = (NativeDate) scriptable2;
            double d2 = nativeDate.date;
            switch (methodId) {
                case 2:
                case 3:
                case 4:
                    return d2 == d2 ? date_format(d2, methodId) : js_NaN_date_str;
                case 5:
                case 6:
                case 7:
                    return d2 == d2 ? toLocale_helper(d2, methodId) : js_NaN_date_str;
                case 8:
                    return d2 == d2 ? js_toUTCString(d2) : js_NaN_date_str;
                case 9:
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(new Date(");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ScriptRuntime.toString(d2));
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("))");
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                case 10:
                case 11:
                    return ScriptRuntime.wrapNumber(d2);
                case 12:
                case 13:
                case 14:
                    if (d2 == d2) {
                        if (methodId != 14) {
                            d2 = LocalTime(d2);
                        }
                        d2 = YearFromTime(d2);
                        if (methodId == 12 && (!context.hasFeature(1) || (1900.0d <= d2 && d2 < 2000.0d))) {
                            d2 -= 1900.0d;
                        }
                    }
                    return ScriptRuntime.wrapNumber(d2);
                case 15:
                case 16:
                    if (d2 == d2) {
                        if (methodId == 15) {
                            d2 = LocalTime(d2);
                        }
                        d2 = MonthFromTime(d2);
                    }
                    return ScriptRuntime.wrapNumber(d2);
                case 17:
                case 18:
                    if (d2 == d2) {
                        if (methodId == 17) {
                            d2 = LocalTime(d2);
                        }
                        d2 = DateFromTime(d2);
                    }
                    return ScriptRuntime.wrapNumber(d2);
                case 19:
                case 20:
                    if (d2 == d2) {
                        if (methodId == 19) {
                            d2 = LocalTime(d2);
                        }
                        d2 = WeekDay(d2);
                    }
                    return ScriptRuntime.wrapNumber(d2);
                case 21:
                case 22:
                    if (d2 == d2) {
                        if (methodId == 21) {
                            d2 = LocalTime(d2);
                        }
                        d2 = HourFromTime(d2);
                    }
                    return ScriptRuntime.wrapNumber(d2);
                case 23:
                case 24:
                    if (d2 == d2) {
                        if (methodId == 23) {
                            d2 = LocalTime(d2);
                        }
                        d2 = MinFromTime(d2);
                    }
                    return ScriptRuntime.wrapNumber(d2);
                case 25:
                case 26:
                    if (d2 == d2) {
                        if (methodId == 25) {
                            d2 = LocalTime(d2);
                        }
                        d2 = SecFromTime(d2);
                    }
                    return ScriptRuntime.wrapNumber(d2);
                case 27:
                case 28:
                    if (d2 == d2) {
                        if (methodId == 27) {
                            d2 = LocalTime(d2);
                        }
                        d2 = msFromTime(d2);
                    }
                    return ScriptRuntime.wrapNumber(d2);
                case 29:
                    if (d2 == d2) {
                        d2 = (d2 - LocalTime(d2)) / 60000.0d;
                    }
                    return ScriptRuntime.wrapNumber(d2);
                case 30:
                    double TimeClip = TimeClip(ScriptRuntime.toNumber(objArr, 0));
                    nativeDate.date = TimeClip;
                    return ScriptRuntime.wrapNumber(TimeClip);
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                    double makeTime = makeTime(d2, objArr, methodId);
                    nativeDate.date = makeTime;
                    return ScriptRuntime.wrapNumber(makeTime);
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                    double makeDate = makeDate(d2, objArr, methodId);
                    nativeDate.date = makeDate;
                    return ScriptRuntime.wrapNumber(makeDate);
                case 45:
                    double number = ScriptRuntime.toNumber(objArr, 0);
                    if (number != number || Double.isInfinite(number)) {
                        d = ScriptRuntime.NaN;
                    } else {
                        double LocalTime = d2 != d2 ? 0.0d : LocalTime(d2);
                        if (number >= RoundRectDrawableWithShadow.COS_45 && number <= 99.0d) {
                            number += 1900.0d;
                        }
                        d = TimeClip(internalUTC(MakeDate(MakeDay(number, MonthFromTime(LocalTime), DateFromTime(LocalTime)), TimeWithinDay(LocalTime))));
                    }
                    nativeDate.date = d;
                    return ScriptRuntime.wrapNumber(d);
                case 46:
                    if (d2 != d2) {
                        throw ScriptRuntime.constructError("RangeError", ScriptRuntime.getMessage0("msg.invalid.date"));
                    }
                    return js_toISOString(d2);
                default:
                    throw new IllegalArgumentException(String.valueOf(methodId));
            }
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        addIdFunctionProperty(idFunctionObject, DATE_TAG, -3, "now", 0);
        addIdFunctionProperty(idFunctionObject, DATE_TAG, -2, "parse", 1);
        addIdFunctionProperty(idFunctionObject, DATE_TAG, -1, "UTC", 7);
        super.fillConstructorProperties(idFunctionObject);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0219 A[FALL_THROUGH] */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int findPrototypeId(String str) {
        String str2;
        int i = 2;
        switch (str.length()) {
            case 6:
                char charAt = str.charAt(0);
                if (charAt != 'g') {
                    if (charAt == 't') {
                        i = 47;
                        str2 = "toJSON";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 19;
                    str2 = "getDay";
                    break;
                }
            case 7:
                char charAt2 = str.charAt(3);
                if (charAt2 == 'D') {
                    char charAt3 = str.charAt(0);
                    if (charAt3 == 'g') {
                        i = 17;
                        str2 = "getDate";
                        break;
                    } else {
                        if (charAt3 == 's') {
                            i = 39;
                            str2 = "setDate";
                            break;
                        }
                        str2 = null;
                        i = 0;
                    }
                } else if (charAt2 == 'T') {
                    char charAt4 = str.charAt(0);
                    if (charAt4 == 'g') {
                        i = 11;
                        str2 = "getTime";
                        break;
                    } else {
                        if (charAt4 == 's') {
                            i = 30;
                            str2 = "setTime";
                            break;
                        }
                        str2 = null;
                        i = 0;
                    }
                } else if (charAt2 != 'Y') {
                    if (charAt2 == 'u') {
                        i = 10;
                        str2 = "valueOf";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    char charAt5 = str.charAt(0);
                    if (charAt5 == 'g') {
                        i = 12;
                        str2 = "getYear";
                        break;
                    } else {
                        if (charAt5 == 's') {
                            i = 45;
                            str2 = "setYear";
                            break;
                        }
                        str2 = null;
                        i = 0;
                    }
                }
            case 8:
                char charAt6 = str.charAt(3);
                if (charAt6 == 'H') {
                    char charAt7 = str.charAt(0);
                    if (charAt7 == 'g') {
                        i = 21;
                        str2 = "getHours";
                        break;
                    } else {
                        if (charAt7 == 's') {
                            i = 37;
                            str2 = "setHours";
                            break;
                        }
                        str2 = null;
                        i = 0;
                    }
                } else if (charAt6 == 'M') {
                    char charAt8 = str.charAt(0);
                    if (charAt8 == 'g') {
                        i = 15;
                        str2 = "getMonth";
                        break;
                    } else {
                        if (charAt8 == 's') {
                            i = 41;
                            str2 = "setMonth";
                            break;
                        }
                        str2 = null;
                        i = 0;
                    }
                } else if (charAt6 == 'o') {
                    str2 = "toSource";
                    i = 9;
                    break;
                } else {
                    if (charAt6 == 't') {
                        str2 = AnnotationHandler.STRING;
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 9:
                i = 20;
                str2 = "getUTCDay";
                break;
            case 10:
                char charAt9 = str.charAt(3);
                if (charAt9 == 'M') {
                    char charAt10 = str.charAt(0);
                    if (charAt10 != 'g') {
                        if (charAt10 == 's') {
                            i = 35;
                            str2 = "setMinutes";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 23;
                        str2 = "getMinutes";
                        break;
                    }
                } else if (charAt9 == 'S') {
                    char charAt11 = str.charAt(0);
                    if (charAt11 == 'g') {
                        i = 25;
                        str2 = "getSeconds";
                        break;
                    } else {
                        if (charAt11 == 's') {
                            i = 33;
                            str2 = "setSeconds";
                            break;
                        }
                        str2 = null;
                        i = 0;
                    }
                } else {
                    if (charAt9 == 'U') {
                        char charAt12 = str.charAt(0);
                        if (charAt12 != 'g') {
                            if (charAt12 == 's') {
                                i = 40;
                                str2 = "setUTCDate";
                                break;
                            }
                        } else {
                            i = 18;
                            str2 = "getUTCDate";
                            break;
                        }
                    }
                    str2 = null;
                    i = 0;
                }
            case 11:
                char charAt13 = str.charAt(3);
                if (charAt13 != 'F') {
                    if (charAt13 == 'M') {
                        str2 = "toGMTString";
                    } else if (charAt13 == 's') {
                        i = 1;
                        str2 = "constructor";
                        break;
                    } else {
                        switch (charAt13) {
                            case 'S':
                                i = 46;
                                str2 = "toISOString";
                                break;
                            case 'T':
                                str2 = "toUTCString";
                                break;
                            case 'U':
                                char charAt14 = str.charAt(0);
                                if (charAt14 != 'g') {
                                    if (charAt14 == 's') {
                                        char charAt15 = str.charAt(9);
                                        if (charAt15 != 'r') {
                                            if (charAt15 == 't') {
                                                i = 42;
                                                str2 = "setUTCMonth";
                                                break;
                                            }
                                        } else {
                                            i = 38;
                                            str2 = "setUTCHours";
                                            break;
                                        }
                                    }
                                } else {
                                    char charAt16 = str.charAt(9);
                                    if (charAt16 != 'r') {
                                        if (charAt16 == 't') {
                                            i = 16;
                                            str2 = "getUTCMonth";
                                            break;
                                        }
                                    } else {
                                        i = 22;
                                        str2 = "getUTCHours";
                                        break;
                                    }
                                }
                            default:
                                str2 = null;
                                i = 0;
                                break;
                        }
                    }
                    i = 8;
                    break;
                } else {
                    char charAt17 = str.charAt(0);
                    if (charAt17 == 'g') {
                        i = 13;
                        str2 = "getFullYear";
                        break;
                    } else {
                        if (charAt17 == 's') {
                            i = 43;
                            str2 = "setFullYear";
                            break;
                        }
                        str2 = null;
                        i = 0;
                    }
                }
            case 12:
                char charAt18 = str.charAt(2);
                if (charAt18 != 'D') {
                    if (charAt18 == 'T') {
                        str2 = "toTimeString";
                        i = 3;
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 4;
                    str2 = "toDateString";
                    break;
                }
            case 13:
                char charAt19 = str.charAt(0);
                if (charAt19 == 'g') {
                    char charAt20 = str.charAt(6);
                    if (charAt20 != 'M') {
                        if (charAt20 == 'S') {
                            i = 26;
                            str2 = "getUTCSeconds";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 24;
                        str2 = "getUTCMinutes";
                        break;
                    }
                } else {
                    if (charAt19 == 's') {
                        char charAt21 = str.charAt(6);
                        if (charAt21 != 'M') {
                            if (charAt21 == 'S') {
                                i = 34;
                                str2 = "setUTCSeconds";
                                break;
                            }
                        } else {
                            i = 36;
                            str2 = "setUTCMinutes";
                            break;
                        }
                    }
                    str2 = null;
                    i = 0;
                }
            case 14:
                char charAt22 = str.charAt(0);
                if (charAt22 != 'g') {
                    if (charAt22 != 's') {
                        if (charAt22 == 't') {
                            i = 5;
                            str2 = "toLocaleString";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 44;
                        str2 = "setUTCFullYear";
                        break;
                    }
                } else {
                    i = 14;
                    str2 = "getUTCFullYear";
                    break;
                }
            case 15:
                char charAt23 = str.charAt(0);
                if (charAt23 != 'g') {
                    if (charAt23 == 's') {
                        i = 31;
                        str2 = "setMilliseconds";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 27;
                    str2 = "getMilliseconds";
                    break;
                }
            case 17:
                i = 29;
                str2 = "getTimezoneOffset";
                break;
            case 18:
                char charAt24 = str.charAt(0);
                if (charAt24 != 'g') {
                    if (charAt24 != 's') {
                        if (charAt24 == 't') {
                            char charAt25 = str.charAt(8);
                            if (charAt25 != 'D') {
                                if (charAt25 == 'T') {
                                    str2 = "toLocaleTimeString";
                                    i = 6;
                                    break;
                                }
                            } else {
                                i = 7;
                                str2 = "toLocaleDateString";
                                break;
                            }
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 32;
                        str2 = "setUTCMilliseconds";
                        break;
                    }
                } else {
                    i = 28;
                    str2 = "getUTCMilliseconds";
                    break;
                }
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Date";
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        if (cls == null) {
            cls = ScriptRuntime.StringClass;
        }
        return super.getDefaultValue(cls);
    }

    public double getJSTimeValue() {
        return this.date;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 0;
        switch (i) {
            case 1:
                str = "constructor";
                i2 = 7;
                break;
            case 2:
                str = AnnotationHandler.STRING;
                break;
            case 3:
                str = "toTimeString";
                break;
            case 4:
                str = "toDateString";
                break;
            case 5:
                str = "toLocaleString";
                break;
            case 6:
                str = "toLocaleTimeString";
                break;
            case 7:
                str = "toLocaleDateString";
                break;
            case 8:
                str = "toUTCString";
                break;
            case 9:
                str = "toSource";
                break;
            case 10:
                str = "valueOf";
                break;
            case 11:
                str = "getTime";
                break;
            case 12:
                str = "getYear";
                break;
            case 13:
                str = "getFullYear";
                break;
            case 14:
                str = "getUTCFullYear";
                break;
            case 15:
                str = "getMonth";
                break;
            case 16:
                str = "getUTCMonth";
                break;
            case 17:
                str = "getDate";
                break;
            case 18:
                str = "getUTCDate";
                break;
            case 19:
                str = "getDay";
                break;
            case 20:
                str = "getUTCDay";
                break;
            case 21:
                str = "getHours";
                break;
            case 22:
                str = "getUTCHours";
                break;
            case 23:
                str = "getMinutes";
                break;
            case 24:
                str = "getUTCMinutes";
                break;
            case 25:
                str = "getSeconds";
                break;
            case 26:
                str = "getUTCSeconds";
                break;
            case 27:
                str = "getMilliseconds";
                break;
            case 28:
                str = "getUTCMilliseconds";
                break;
            case 29:
                str = "getTimezoneOffset";
                break;
            case 30:
                str = "setTime";
                i2 = 1;
                break;
            case 31:
                str = "setMilliseconds";
                i2 = 1;
                break;
            case 32:
                str = "setUTCMilliseconds";
                i2 = 1;
                break;
            case 33:
                str = "setSeconds";
                i2 = 2;
                break;
            case 34:
                str = "setUTCSeconds";
                i2 = 2;
                break;
            case 35:
                str = "setMinutes";
                i2 = 3;
                break;
            case 36:
                str = "setUTCMinutes";
                i2 = 3;
                break;
            case 37:
                str2 = "setHours";
                str = str2;
                i2 = 4;
                break;
            case 38:
                str2 = "setUTCHours";
                str = str2;
                i2 = 4;
                break;
            case 39:
                str = "setDate";
                i2 = 1;
                break;
            case 40:
                str = "setUTCDate";
                i2 = 1;
                break;
            case 41:
                str = "setMonth";
                i2 = 2;
                break;
            case 42:
                str = "setUTCMonth";
                i2 = 2;
                break;
            case 43:
                str = "setFullYear";
                i2 = 3;
                break;
            case 44:
                str = "setUTCFullYear";
                i2 = 3;
                break;
            case 45:
                str = "setYear";
                i2 = 1;
                break;
            case 46:
                str = "toISOString";
                break;
            case 47:
                str = "toJSON";
                i2 = 1;
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(DATE_TAG, i, str, i2);
    }
}

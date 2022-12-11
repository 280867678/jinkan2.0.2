package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import me.tvspark.outline;

/* loaded from: classes4.dex */
public class DateUtils {
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_HOUR = 3600000;
    public static final long MILLIS_PER_MINUTE = 60000;
    public static final long MILLIS_PER_SECOND = 1000;
    public static final int MODIFY_CEILING = 2;
    public static final int MODIFY_ROUND = 1;
    public static final int MODIFY_TRUNCATE = 0;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;
    public static final int[][] fields = {new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, 1001}, new int[]{1}, new int[]{0}};

    /* loaded from: classes4.dex */
    public static class DateIterator implements Iterator<Calendar> {
        public final Calendar endFinal;
        public final Calendar spot;

        public DateIterator(Calendar calendar, Calendar calendar2) {
            this.endFinal = calendar2;
            this.spot = calendar;
            calendar.add(5, -1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.spot.before(this.endFinal);
        }

        @Override // java.util.Iterator
        public Calendar next() {
            if (!this.spot.equals(this.endFinal)) {
                this.spot.add(5, 1);
                return (Calendar) this.spot.clone();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static Date add(Date date, int i, int i2) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(i, i2);
            return calendar.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date addDays(Date date, int i) {
        return add(date, 5, i);
    }

    public static Date addHours(Date date, int i) {
        return add(date, 11, i);
    }

    public static Date addMilliseconds(Date date, int i) {
        return add(date, 14, i);
    }

    public static Date addMinutes(Date date, int i) {
        return add(date, 12, i);
    }

    public static Date addMonths(Date date, int i) {
        return add(date, 2, i);
    }

    public static Date addSeconds(Date date, int i) {
        return add(date, 13, i);
    }

    public static Date addWeeks(Date date, int i) {
        return add(date, 3, i);
    }

    public static Date addYears(Date date, int i) {
        return add(date, 1, i);
    }

    public static Calendar ceiling(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, 2);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date ceiling(Object obj, int i) {
        if (obj != null) {
            if (obj instanceof Date) {
                return ceiling((Date) obj, i);
            }
            if (obj instanceof Calendar) {
                return ceiling((Calendar) obj, i).getTime();
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not find ceiling of for type: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj.getClass());
            throw new ClassCastException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date ceiling(Date date, int i) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            modify(calendar, i, 2);
            return calendar.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static long getFragment(Calendar calendar, int i, TimeUnit timeUnit) {
        int i2;
        if (calendar != null) {
            long j = 0;
            int i3 = timeUnit == TimeUnit.DAYS ? 0 : 1;
            if (i != 1) {
                if (i == 2) {
                    i2 = calendar.get(5);
                }
                if (i == 1 && i != 2 && i != 5 && i != 6) {
                    switch (i) {
                        case 11:
                            break;
                        case 12:
                            j += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
                            break;
                        case 13:
                            break;
                        case 14:
                            return j;
                        default:
                            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("The fragment ", i, " is not supported"));
                    }
                    return j + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
                }
                j += timeUnit.convert(calendar.get(11), TimeUnit.HOURS);
                j += timeUnit.convert(calendar.get(12), TimeUnit.MINUTES);
                j += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
                return j + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
            }
            i2 = calendar.get(6);
            j = 0 + timeUnit.convert(i2 - i3, TimeUnit.DAYS);
            if (i == 1) {
            }
            j += timeUnit.convert(calendar.get(11), TimeUnit.HOURS);
            j += timeUnit.convert(calendar.get(12), TimeUnit.MINUTES);
            j += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
            return j + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static long getFragment(Date date, int i, TimeUnit timeUnit) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return getFragment(calendar, i, timeUnit);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static long getFragmentInDays(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.DAYS);
    }

    public static long getFragmentInDays(Date date, int i) {
        return getFragment(date, i, TimeUnit.DAYS);
    }

    public static long getFragmentInHours(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.HOURS);
    }

    public static long getFragmentInHours(Date date, int i) {
        return getFragment(date, i, TimeUnit.HOURS);
    }

    public static long getFragmentInMilliseconds(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInMilliseconds(Date date, int i) {
        return getFragment(date, i, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInMinutes(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.MINUTES);
    }

    public static long getFragmentInMinutes(Date date, int i) {
        return getFragment(date, i, TimeUnit.MINUTES);
    }

    public static long getFragmentInSeconds(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.SECONDS);
    }

    public static long getFragmentInSeconds(Date date, int i) {
        return getFragment(date, i, TimeUnit.SECONDS);
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static boolean isSameDay(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return isSameDay(calendar, calendar2);
    }

    public static boolean isSameInstant(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return calendar.getTime().getTime() == calendar2.getTime().getTime();
    }

    public static boolean isSameInstant(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return date.getTime() == date2.getTime();
    }

    public static boolean isSameLocalTime(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return calendar.get(14) == calendar2.get(14) && calendar.get(13) == calendar2.get(13) && calendar.get(12) == calendar2.get(12) && calendar.get(11) == calendar2.get(11) && calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1) && calendar.get(0) == calendar2.get(0) && calendar.getClass() == calendar2.getClass();
    }

    public static Iterator<?> iterator(Object obj, int i) {
        if (obj != null) {
            if (obj instanceof Date) {
                return iterator((Date) obj, i);
            }
            if (!(obj instanceof Calendar)) {
                throw new ClassCastException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not iterate based on ", obj));
            }
            return iterator((Calendar) obj, i);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Iterator<Calendar> iterator(Calendar calendar, int i) {
        Calendar calendar2;
        Calendar calendar3;
        int i2;
        if (calendar != null) {
            int i3 = 2;
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    Calendar truncate = truncate(calendar, 5);
                    Calendar truncate2 = truncate(calendar, 5);
                    if (i == 2) {
                        calendar2 = truncate;
                        calendar3 = truncate2;
                        i2 = 1;
                        break;
                    } else {
                        if (i == 3) {
                            i3 = calendar.get(7);
                            i2 = i3 - 1;
                        } else if (i != 4) {
                            i2 = 7;
                            i3 = 1;
                        } else {
                            i3 = calendar.get(7) - 3;
                            i2 = calendar.get(7) + 3;
                        }
                        calendar2 = truncate;
                        calendar3 = truncate2;
                        break;
                    }
                case 5:
                case 6:
                    calendar2 = truncate(calendar, 2);
                    calendar3 = (Calendar) calendar2.clone();
                    calendar3.add(2, 1);
                    calendar3.add(5, -1);
                    if (i != 6) {
                        i3 = 1;
                        i2 = 7;
                        break;
                    }
                    i2 = 1;
                    break;
                default:
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("The range style ", i, " is not valid."));
            }
            if (i3 < 1) {
                i3 += 7;
            }
            if (i3 > 7) {
                i3 -= 7;
            }
            if (i2 < 1) {
                i2 += 7;
            }
            if (i2 > 7) {
                i2 -= 7;
            }
            while (calendar2.get(7) != i3) {
                calendar2.add(5, -1);
            }
            while (calendar3.get(7) != i2) {
                calendar3.add(5, 1);
            }
            return new DateIterator(calendar2, calendar3);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Iterator<Calendar> iterator(Date date, int i) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return iterator(calendar, i);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00cd, code lost:
        if (r4 > 7) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00cf, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e8, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00d1, code lost:
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00e5, code lost:
        if (r4 >= 6) goto L72;
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x011b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void modify(Calendar calendar, int i, int i2) {
        int i3;
        boolean z;
        if (calendar.get(1) <= 280000000) {
            if (i == 14) {
                return;
            }
            Date time = calendar.getTime();
            long time2 = time.getTime();
            int i4 = calendar.get(14);
            if (i2 == 0 || i4 < 500) {
                time2 -= i4;
            }
            boolean z2 = i == 13;
            int i5 = calendar.get(13);
            if (!z2 && (i2 == 0 || i5 < 30)) {
                time2 -= i5 * 1000;
            }
            if (i == 12) {
                z2 = true;
            }
            int i6 = calendar.get(12);
            if (!z2 && (i2 == 0 || i6 < 30)) {
                time2 -= i6 * 60000;
            }
            if (time.getTime() != time2) {
                time.setTime(time2);
                calendar.setTime(time);
            }
            int[][] iArr = fields;
            int length = iArr.length;
            int i7 = 0;
            boolean z3 = false;
            while (i7 < length) {
                int[] iArr2 = iArr[i7];
                for (int i8 : iArr2) {
                    if (i8 == i) {
                        if (i2 != 2 && (i2 != 1 || !z3)) {
                            return;
                        }
                        if (i == 1001) {
                            if (calendar.get(5) == 1) {
                                calendar.add(5, 15);
                                return;
                            }
                            calendar.add(5, -15);
                            calendar.add(2, 1);
                            return;
                        } else if (i != 9) {
                            calendar.add(iArr2[0], 1);
                            return;
                        } else if (calendar.get(11) == 0) {
                            calendar.add(11, 12);
                            return;
                        } else {
                            calendar.add(11, -12);
                            calendar.add(5, 1);
                            return;
                        }
                    }
                }
                if (i != 9) {
                    if (i == 1001 && iArr2[0] == 5) {
                        i3 = calendar.get(5) - 1;
                        if (i3 >= 15) {
                            i3 -= 15;
                        }
                    }
                    z = false;
                    boolean z4 = z3;
                    i3 = 0;
                    if (!z) {
                        int actualMinimum = calendar.getActualMinimum(iArr2[0]);
                        int actualMaximum = calendar.getActualMaximum(iArr2[0]);
                        int i9 = calendar.get(iArr2[0]) - actualMinimum;
                        z4 = i9 > (actualMaximum - actualMinimum) / 2;
                        i3 = i9;
                    }
                    if (i3 == 0) {
                        calendar.set(iArr2[0], calendar.get(iArr2[0]) - i3);
                    }
                    i7++;
                    z3 = z4;
                } else {
                    if (iArr2[0] == 11) {
                        i3 = calendar.get(11);
                        if (i3 >= 12) {
                            i3 -= 12;
                        }
                    }
                    z = false;
                    boolean z42 = z3;
                    i3 = 0;
                    if (!z) {
                    }
                    if (i3 == 0) {
                    }
                    i7++;
                    z3 = z42;
                }
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("The field ", i, " is not supported"));
        }
        throw new ArithmeticException("Calendar value too large for accurate calculations");
    }

    public static Date parseDate(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, locale, strArr, true);
    }

    public static Date parseDate(String str, String... strArr) throws ParseException {
        return parseDate(str, null, strArr);
    }

    public static Date parseDateStrictly(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, null, strArr, false);
    }

    public static Date parseDateStrictly(String str, String... strArr) throws ParseException {
        return parseDateStrictly(str, null, strArr);
    }

    public static Date parseDateWithLeniency(String str, Locale locale, String[] strArr, boolean z) throws ParseException {
        if (str == null || strArr == null) {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }
        SimpleDateFormat simpleDateFormat = locale == null ? new SimpleDateFormat() : new SimpleDateFormat("", locale);
        simpleDateFormat.setLenient(z);
        ParsePosition parsePosition = new ParsePosition(0);
        for (String str2 : strArr) {
            simpleDateFormat.applyPattern(str2.endsWith("ZZ") ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, -1, 0) : str2);
            parsePosition.setIndex(0);
            String replaceAll = str2.endsWith("ZZ") ? str.replaceAll("([-+][0-9][0-9]):([0-9][0-9])$", "$1$2") : str;
            Date parse = simpleDateFormat.parse(replaceAll, parsePosition);
            if (parse != null && parsePosition.getIndex() == replaceAll.length()) {
                return parse;
            }
        }
        throw new ParseException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to parse the date: ", str), -1);
    }

    public static Calendar round(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, 1);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date round(Object obj, int i) {
        if (obj != null) {
            if (obj instanceof Date) {
                return round((Date) obj, i);
            }
            if (!(obj instanceof Calendar)) {
                throw new ClassCastException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not round ", obj));
            }
            return round((Calendar) obj, i).getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date round(Date date, int i) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            modify(calendar, i, 1);
            return calendar.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date set(Date date, int i, int i2) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setLenient(false);
            calendar.setTime(date);
            calendar.set(i, i2);
            return calendar.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date setDays(Date date, int i) {
        return set(date, 5, i);
    }

    public static Date setHours(Date date, int i) {
        return set(date, 11, i);
    }

    public static Date setMilliseconds(Date date, int i) {
        return set(date, 14, i);
    }

    public static Date setMinutes(Date date, int i) {
        return set(date, 12, i);
    }

    public static Date setMonths(Date date, int i) {
        return set(date, 2, i);
    }

    public static Date setSeconds(Date date, int i) {
        return set(date, 13, i);
    }

    public static Date setYears(Date date, int i) {
        return set(date, 1, i);
    }

    public static Calendar toCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Calendar truncate(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, 0);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date truncate(Object obj, int i) {
        if (obj != null) {
            if (obj instanceof Date) {
                return truncate((Date) obj, i);
            }
            if (!(obj instanceof Calendar)) {
                throw new ClassCastException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not truncate ", obj));
            }
            return truncate((Calendar) obj, i).getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date truncate(Date date, int i) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            modify(calendar, i, 0);
            return calendar.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static int truncatedCompareTo(Calendar calendar, Calendar calendar2, int i) {
        return truncate(calendar, i).compareTo(truncate(calendar2, i));
    }

    public static int truncatedCompareTo(Date date, Date date2, int i) {
        return truncate(date, i).compareTo(truncate(date2, i));
    }

    public static boolean truncatedEquals(Calendar calendar, Calendar calendar2, int i) {
        return truncatedCompareTo(calendar, calendar2, i) == 0;
    }

    public static boolean truncatedEquals(Date date, Date date2, int i) {
        return truncatedCompareTo(date, date2, i) == 0;
    }
}

package org.apache.commons.lang3.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import me.tvspark.outline;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* loaded from: classes4.dex */
public class FastDatePrinter implements DatePrinter, Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    public static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = new ConcurrentHashMap(7);
    public static final long serialVersionUID = 1;
    public final Locale mLocale;
    public transient int mMaxLengthEstimate;
    public final String mPattern;
    public transient Rule[] mRules;
    public final TimeZone mTimeZone;

    /* loaded from: classes4.dex */
    public static class CharacterLiteral implements Rule {
        public final char mValue;

        public CharacterLiteral(char c) {
            this.mValue = c;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 1;
        }
    }

    /* loaded from: classes4.dex */
    public interface NumberRule extends Rule {
        void appendTo(StringBuffer stringBuffer, int i);
    }

    /* loaded from: classes4.dex */
    public static class PaddedNumberField implements NumberRule {
        public final int mField;
        public final int mSize;

        public PaddedNumberField(int i, int i2) {
            if (i2 >= 3) {
                this.mField = i;
                this.mSize = i2;
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i) {
            int length;
            if (i < 100) {
                int i2 = this.mSize;
                while (true) {
                    i2--;
                    if (i2 < 2) {
                        stringBuffer.append((char) ((i / 10) + 48));
                        stringBuffer.append((char) ((i % 10) + 48));
                        return;
                    }
                    stringBuffer.append('0');
                }
            } else {
                if (i < 1000) {
                    length = 3;
                } else {
                    Validate.isTrue(i > -1, "Negative values should not be possible", i);
                    length = Integer.toString(i).length();
                }
                int i3 = this.mSize;
                while (true) {
                    i3--;
                    if (i3 < length) {
                        stringBuffer.append(Integer.toString(i));
                        return;
                    }
                    stringBuffer.append('0');
                }
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 4;
        }
    }

    /* loaded from: classes4.dex */
    public interface Rule {
        void appendTo(StringBuffer stringBuffer, Calendar calendar);

        int estimateLength();
    }

    /* loaded from: classes4.dex */
    public static class StringLiteral implements Rule {
        public final String mValue;

        public StringLiteral(String str) {
            this.mValue = str;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mValue.length();
        }
    }

    /* loaded from: classes4.dex */
    public static class TextField implements Rule {
        public final int mField;
        public final String[] mValues;

        public TextField(int i, String[] strArr) {
            this.mField = i;
            this.mValues = strArr;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValues[calendar.get(this.mField)]);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            int length = this.mValues.length;
            int i = 0;
            while (true) {
                length--;
                if (length >= 0) {
                    int length2 = this.mValues[length].length();
                    if (length2 > i) {
                        i = length2;
                    }
                } else {
                    return i;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class TimeZoneDisplayKey {
        public final Locale mLocale;
        public final int mStyle;
        public final TimeZone mTimeZone;

        public TimeZoneDisplayKey(TimeZone timeZone, boolean z, int i, Locale locale) {
            this.mTimeZone = timeZone;
            if (z) {
                this.mStyle = Integer.MIN_VALUE | i;
            } else {
                this.mStyle = i;
            }
            this.mLocale = locale;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeZoneDisplayKey)) {
                return false;
            }
            TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
            return this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) && this.mStyle == timeZoneDisplayKey.mStyle && this.mLocale.equals(timeZoneDisplayKey.mLocale);
        }

        public int hashCode() {
            int hashCode = this.mLocale.hashCode();
            return this.mTimeZone.hashCode() + ((hashCode + (this.mStyle * 31)) * 31);
        }
    }

    /* loaded from: classes4.dex */
    public static class TimeZoneNameRule implements Rule {
        public final String mDaylight;
        public final Locale mLocale;
        public final String mStandard;
        public final int mStyle;

        public TimeZoneNameRule(TimeZone timeZone, Locale locale, int i) {
            this.mLocale = locale;
            this.mStyle = i;
            this.mStandard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, i, locale);
            this.mDaylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, i, locale);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            TimeZone timeZone = calendar.getTimeZone();
            stringBuffer.append(FastDatePrinter.getTimeZoneDisplay(timeZone, timeZone.useDaylightTime() && calendar.get(16) != 0, this.mStyle, this.mLocale));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return Math.max(this.mStandard.length(), this.mDaylight.length());
        }
    }

    /* loaded from: classes4.dex */
    public static class TimeZoneNumberRule implements Rule {
        public static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        public static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        public final boolean mColon;

        public TimeZoneNumberRule(boolean z) {
            this.mColon = z;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(16) + calendar.get(15);
            if (i < 0) {
                stringBuffer.append('-');
                i = -i;
            } else {
                stringBuffer.append('+');
            }
            int i2 = i / 3600000;
            stringBuffer.append((char) ((i2 / 10) + 48));
            stringBuffer.append((char) ((i2 % 10) + 48));
            if (this.mColon) {
                stringBuffer.append(':');
            }
            int i3 = (i / 60000) - (i2 * 60);
            stringBuffer.append((char) ((i3 / 10) + 48));
            stringBuffer.append((char) ((i3 % 10) + 48));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 5;
        }
    }

    /* loaded from: classes4.dex */
    public static class TwelveHourField implements NumberRule {
        public final NumberRule mRule;

        public TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(StringBuffer stringBuffer, int i) {
            this.mRule.appendTo(stringBuffer, i);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(10);
            if (i == 0) {
                i = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(stringBuffer, i);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }
    }

    /* loaded from: classes4.dex */
    public static class TwentyFourHourField implements NumberRule {
        public final NumberRule mRule;

        public TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(StringBuffer stringBuffer, int i) {
            this.mRule.appendTo(stringBuffer, i);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(11);
            if (i == 0) {
                i = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(stringBuffer, i);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }
    }

    /* loaded from: classes4.dex */
    public static class TwoDigitMonthField implements NumberRule {
        public static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i) {
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }
    }

    /* loaded from: classes4.dex */
    public static class TwoDigitNumberField implements NumberRule {
        public final int mField;

        public TwoDigitNumberField(int i) {
            this.mField = i;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i) {
            if (i >= 100) {
                stringBuffer.append(Integer.toString(i));
                return;
            }
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }
    }

    /* loaded from: classes4.dex */
    public static class TwoDigitYearField implements NumberRule {
        public static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i) {
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(1) % 100);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }
    }

    /* loaded from: classes4.dex */
    public static class UnpaddedMonthField implements NumberRule {
        public static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i) {
            if (i >= 10) {
                stringBuffer.append((char) ((i / 10) + 48));
                i %= 10;
            }
            stringBuffer.append((char) (i + 48));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }
    }

    /* loaded from: classes4.dex */
    public static class UnpaddedNumberField implements NumberRule {
        public final int mField;

        public UnpaddedNumberField(int i) {
            this.mField = i;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(StringBuffer stringBuffer, int i) {
            if (i >= 10) {
                if (i >= 100) {
                    stringBuffer.append(Integer.toString(i));
                    return;
                } else {
                    stringBuffer.append((char) ((i / 10) + 48));
                    i %= 10;
                }
            }
            stringBuffer.append((char) (i + 48));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 4;
        }
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        init();
    }

    private String applyRulesToString(Calendar calendar) {
        return applyRules(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public static String getTimeZoneDisplay(TimeZone timeZone, boolean z, int i, Locale locale) {
        TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z, i, locale);
        String str = cTimeZoneDisplayCache.get(timeZoneDisplayKey);
        if (str == null) {
            String displayName = timeZone.getDisplayName(z, i, locale);
            String putIfAbsent = cTimeZoneDisplayCache.putIfAbsent(timeZoneDisplayKey, displayName);
            return putIfAbsent != null ? putIfAbsent : displayName;
        }
        return str;
    }

    private void init() {
        List<Rule> parsePattern = parsePattern();
        Rule[] ruleArr = (Rule[]) parsePattern.toArray(new Rule[parsePattern.size()]);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int i = 0;
        while (true) {
            length--;
            if (length < 0) {
                this.mMaxLengthEstimate = i;
                return;
            }
            i += this.mRules[length].estimateLength();
        }
    }

    private GregorianCalendar newCalendar() {
        return new GregorianCalendar(this.mTimeZone, this.mLocale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init();
    }

    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        for (Rule rule : this.mRules) {
            rule.appendTo(stringBuffer, calendar);
        }
        return stringBuffer;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
        return this.mPattern.equals(fastDatePrinter.mPattern) && this.mTimeZone.equals(fastDatePrinter.mTimeZone) && this.mLocale.equals(fastDatePrinter.mLocale);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(long j) {
        GregorianCalendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j);
        return applyRulesToString(newCalendar);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Calendar calendar) {
        return format(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Date date) {
        GregorianCalendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return applyRulesToString(newCalendar);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(long j, StringBuffer stringBuffer) {
        return format(new Date(j), stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unknown class: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return applyRules(calendar, stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        GregorianCalendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return applyRules(newCalendar, stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        return this.mPattern;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public int hashCode() {
        return (((this.mLocale.hashCode() * 13) + this.mTimeZone.hashCode()) * 13) + this.mPattern.hashCode();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public List<Rule> parsePattern() {
        Object selectNumberRule;
        Locale locale;
        int i;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.mPattern.length();
        int[] iArr = new int[1];
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            iArr[i2] = i3;
            String parseToken = parseToken(this.mPattern, iArr);
            int i4 = iArr[i2];
            int length2 = parseToken.length();
            if (length2 == 0) {
                return arrayList;
            }
            char charAt = parseToken.charAt(i2);
            if (charAt != 'y') {
                if (charAt != 'z') {
                    int i5 = 11;
                    switch (charAt) {
                        case '\'':
                            String substring = parseToken.substring(1);
                            if (substring.length() != 1) {
                                selectNumberRule = new StringLiteral(substring);
                                break;
                            } else {
                                selectNumberRule = new CharacterLiteral(substring.charAt(0));
                                break;
                            }
                        case 'K':
                            i5 = 10;
                            selectNumberRule = selectNumberRule(i5, length2);
                            break;
                        case 'M':
                            if (length2 < 4) {
                                if (length2 != 3) {
                                    if (length2 != 2) {
                                        selectNumberRule = UnpaddedMonthField.INSTANCE;
                                        break;
                                    } else {
                                        selectNumberRule = TwoDigitMonthField.INSTANCE;
                                        break;
                                    }
                                } else {
                                    selectNumberRule = new TextField(2, shortMonths);
                                    break;
                                }
                            } else {
                                selectNumberRule = new TextField(2, months);
                                break;
                            }
                        case 'S':
                            i5 = 14;
                            selectNumberRule = selectNumberRule(i5, length2);
                            break;
                        case 'W':
                            selectNumberRule = selectNumberRule(4, length2);
                            break;
                        case 'Z':
                            if (length2 != 1) {
                                selectNumberRule = TimeZoneNumberRule.INSTANCE_COLON;
                                break;
                            } else {
                                selectNumberRule = TimeZoneNumberRule.INSTANCE_NO_COLON;
                                break;
                            }
                        case 'a':
                            selectNumberRule = new TextField(9, amPmStrings);
                            break;
                        case 'd':
                            i5 = 5;
                            selectNumberRule = selectNumberRule(i5, length2);
                            break;
                        case 'h':
                            selectNumberRule = new TwelveHourField(selectNumberRule(10, length2));
                            break;
                        case 'k':
                            selectNumberRule = new TwentyFourHourField(selectNumberRule(11, length2));
                            break;
                        case 'm':
                            i5 = 12;
                            selectNumberRule = selectNumberRule(i5, length2);
                            break;
                        case 's':
                            i5 = 13;
                            selectNumberRule = selectNumberRule(i5, length2);
                            break;
                        case 'w':
                            i5 = 3;
                            selectNumberRule = selectNumberRule(i5, length2);
                            break;
                        default:
                            switch (charAt) {
                                case 'D':
                                    i5 = 6;
                                    selectNumberRule = selectNumberRule(i5, length2);
                                    break;
                                case 'E':
                                    selectNumberRule = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                                    break;
                                case 'F':
                                    i5 = 8;
                                    selectNumberRule = selectNumberRule(i5, length2);
                                    break;
                                case 'G':
                                    selectNumberRule = new TextField(0, eras);
                                    break;
                                case 'H':
                                    selectNumberRule = selectNumberRule(i5, length2);
                                    break;
                                default:
                                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Illegal pattern component: ", parseToken));
                            }
                    }
                } else {
                    TimeZone timeZone = this.mTimeZone;
                    if (length2 >= 4) {
                        locale = this.mLocale;
                        i = 1;
                    } else {
                        locale = this.mLocale;
                        i = 0;
                    }
                    selectNumberRule = new TimeZoneNameRule(timeZone, locale, i);
                }
            } else if (length2 == 2) {
                selectNumberRule = TwoDigitYearField.INSTANCE;
            } else {
                if (length2 < 4) {
                    length2 = 4;
                }
                selectNumberRule = selectNumberRule(1, length2);
            }
            arrayList.add(selectNumberRule);
            i3 = i4 + 1;
            i2 = 0;
        }
        return arrayList;
    }

    public String parseToken(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb.append(charAt);
            while (true) {
                int i2 = i + 1;
                if (i2 >= length || str.charAt(i2) != charAt) {
                    break;
                }
                sb.append(charAt);
                i = i2;
            }
        } else {
            sb.append(ExtendedMessageFormat.QUOTE);
            boolean z = false;
            while (i < length) {
                char charAt2 = str.charAt(i);
                if (charAt2 != '\'') {
                    if (!z && ((charAt2 >= 'A' && charAt2 <= 'Z') || (charAt2 >= 'a' && charAt2 <= 'z'))) {
                        i--;
                        break;
                    }
                    sb.append(charAt2);
                } else {
                    int i3 = i + 1;
                    if (i3 >= length || str.charAt(i3) != '\'') {
                        z = !z;
                    } else {
                        sb.append(charAt2);
                        i = i3;
                    }
                }
                i++;
            }
        }
        iArr[0] = i;
        return sb.toString();
    }

    public NumberRule selectNumberRule(int i, int i2) {
        return i2 != 1 ? i2 != 2 ? new PaddedNumberField(i, i2) : new TwoDigitNumberField(i) : new UnpaddedNumberField(i);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("FastDatePrinter[");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mPattern);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mLocale);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mTimeZone.getID());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

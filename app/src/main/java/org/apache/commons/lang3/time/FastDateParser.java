package org.apache.commons.lang3.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.outline;
import org.apache.http.message.TokenParser;

/* loaded from: classes4.dex */
public class FastDateParser implements DateParser, Serializable {
    public static final long serialVersionUID = 2;
    public final int century;
    public transient String currentFormatField;
    public final Locale locale;
    public transient Strategy nextStrategy;
    public transient Pattern parsePattern;
    public final String pattern;
    public final int startYear;
    public transient Strategy[] strategies;
    public final TimeZone timeZone;
    public static final Locale JAPANESE_IMPERIAL = new Locale("ja", "JP", "JP");
    public static final Pattern formatPattern = Pattern.compile("D+|E+|F+|G+|H+|K+|M+|S+|W+|Z+|a+|d+|h+|k+|m+|s+|w+|y+|z+|''|'[^']++(''[^']*+)*+'|[^'A-Za-z]++");
    public static final ConcurrentMap<Locale, Strategy>[] caches = new ConcurrentMap[17];
    public static final Strategy ABBREVIATED_YEAR_STRATEGY = new NumberStrategy(1) { // from class: org.apache.commons.lang3.time.FastDateParser.1
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy, org.apache.commons.lang3.time.FastDateParser.Strategy
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 100) {
                parseInt = fastDateParser.adjustYear(parseInt);
            }
            calendar.set(1, parseInt);
        }
    };
    public static final Strategy NUMBER_MONTH_STRATEGY = new NumberStrategy(2) { // from class: org.apache.commons.lang3.time.FastDateParser.2
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(int i) {
            return i - 1;
        }
    };
    public static final Strategy LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
    public static final Strategy WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
    public static final Strategy WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
    public static final Strategy DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
    public static final Strategy DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
    public static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
    public static final Strategy HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
    public static final Strategy MODULO_HOUR_OF_DAY_STRATEGY = new NumberStrategy(11) { // from class: org.apache.commons.lang3.time.FastDateParser.3
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(int i) {
            return i % 24;
        }
    };
    public static final Strategy MODULO_HOUR_STRATEGY = new NumberStrategy(10) { // from class: org.apache.commons.lang3.time.FastDateParser.4
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(int i) {
            return i % 12;
        }
    };
    public static final Strategy HOUR_STRATEGY = new NumberStrategy(10);
    public static final Strategy MINUTE_STRATEGY = new NumberStrategy(12);
    public static final Strategy SECOND_STRATEGY = new NumberStrategy(13);
    public static final Strategy MILLISECOND_STRATEGY = new NumberStrategy(14);

    /* loaded from: classes4.dex */
    public static class CopyQuotedStrategy extends Strategy {
        public final String formatField;

        public CopyQuotedStrategy(String str) {
            super();
            this.formatField = str;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean addRegex(FastDateParser fastDateParser, StringBuilder sb) {
            FastDateParser.escapeRegex(sb, this.formatField, true);
            return false;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            char charAt = this.formatField.charAt(0);
            if (charAt == '\'') {
                charAt = this.formatField.charAt(1);
            }
            return Character.isDigit(charAt);
        }
    }

    /* loaded from: classes4.dex */
    public static class NumberStrategy extends Strategy {
        public final int field;

        public NumberStrategy(int i) {
            super();
            this.field = i;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean addRegex(FastDateParser fastDateParser, StringBuilder sb) {
            String str;
            if (fastDateParser.isNextNumber()) {
                sb.append("(\\p{Nd}{");
                sb.append(fastDateParser.getFieldWidth());
                str = "}+)";
            } else {
                str = "(\\p{Nd}++)";
            }
            sb.append(str);
            return true;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            return true;
        }

        public int modify(int i) {
            return i;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            calendar.set(this.field, modify(Integer.parseInt(str)));
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class Strategy {
        public Strategy() {
        }

        public abstract boolean addRegex(FastDateParser fastDateParser, StringBuilder sb);

        public boolean isNumber() {
            return false;
        }

        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
        }
    }

    /* loaded from: classes4.dex */
    public static class TextStrategy extends Strategy {
        public final int field;
        public final Map<String, Integer> keyValues;

        public TextStrategy(int i, Calendar calendar, Locale locale) {
            super();
            this.field = i;
            this.keyValues = FastDateParser.getDisplayNames(i, calendar, locale);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean addRegex(FastDateParser fastDateParser, StringBuilder sb) {
            sb.append('(');
            for (String str : this.keyValues.keySet()) {
                FastDateParser.escapeRegex(sb, str, false).append('|');
            }
            sb.setCharAt(sb.length() - 1, ')');
            return true;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            Integer num = this.keyValues.get(str);
            if (num != null) {
                calendar.set(this.field, num.intValue());
                return;
            }
            StringBuilder sb = new StringBuilder(str);
            sb.append(" not in (");
            for (String str2 : this.keyValues.keySet()) {
                sb.append(str2);
                sb.append(TokenParser.f4579SP);
            }
            sb.setCharAt(sb.length() - 1, ')');
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* loaded from: classes4.dex */
    public static class TimeZoneStrategy extends Strategy {

        /* renamed from: ID */
        public static final int f4564ID = 0;
        public static final int LONG_DST = 3;
        public static final int LONG_STD = 1;
        public static final int SHORT_DST = 4;
        public static final int SHORT_STD = 2;
        public final SortedMap<String, TimeZone> tzNames = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        public final String validTimeZoneChars;

        public TimeZoneStrategy(Locale locale) {
            super();
            String[][] zoneStrings;
            for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
                if (!strArr[0].startsWith("GMT")) {
                    TimeZone timeZone = TimeZone.getTimeZone(strArr[0]);
                    if (!this.tzNames.containsKey(strArr[1])) {
                        this.tzNames.put(strArr[1], timeZone);
                    }
                    if (!this.tzNames.containsKey(strArr[2])) {
                        this.tzNames.put(strArr[2], timeZone);
                    }
                    if (timeZone.useDaylightTime()) {
                        if (!this.tzNames.containsKey(strArr[3])) {
                            this.tzNames.put(strArr[3], timeZone);
                        }
                        if (!this.tzNames.containsKey(strArr[4])) {
                            this.tzNames.put(strArr[4], timeZone);
                        }
                    }
                }
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(GMT[+\\-]\\d{0,1}\\d{2}|[+\\-]\\d{2}:?\\d{2}|");
            for (String str : this.tzNames.keySet()) {
                FastDateParser.escapeRegex(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str, false).append('|');
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setCharAt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() - 1, ')');
            this.validTimeZoneChars = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean addRegex(FastDateParser fastDateParser, StringBuilder sb) {
            sb.append(this.validTimeZoneChars);
            return true;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            TimeZone timeZone;
            if (str.charAt(0) == '+' || str.charAt(0) == '-') {
                timeZone = TimeZone.getTimeZone("GMT" + str);
            } else if (str.startsWith("GMT")) {
                timeZone = TimeZone.getTimeZone(str);
            } else {
                timeZone = this.tzNames.get(str);
                if (timeZone == null) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, " is not a supported timezone name"));
                }
            }
            calendar.setTimeZone(timeZone);
        }
    }

    public FastDateParser(String str, TimeZone timeZone, Locale locale) {
        this(str, timeZone, locale, null);
    }

    public FastDateParser(String str, TimeZone timeZone, Locale locale, Date date) {
        int i;
        this.pattern = str;
        this.timeZone = timeZone;
        this.locale = locale;
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        if (date != null) {
            calendar.setTime(date);
            i = calendar.get(1);
        } else if (locale.equals(JAPANESE_IMPERIAL)) {
            i = 0;
        } else {
            calendar.setTime(new Date());
            i = calendar.get(1) - 80;
        }
        int i2 = (i / 100) * 100;
        this.century = i2;
        this.startYear = i - i2;
        init(calendar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int adjustYear(int i) {
        int i2 = this.century + i;
        return i >= this.startYear ? i2 : i2 + 100;
    }

    public static StringBuilder escapeRegex(StringBuilder sb, String str, boolean z) {
        sb.append("\\Q");
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != '\'') {
                if (charAt == '\\' && (i = i + 1) != str.length()) {
                    sb.append(charAt);
                    charAt = str.charAt(i);
                    if (charAt == 'E') {
                        sb.append("E\\\\E\\");
                        charAt = 'Q';
                    }
                }
            } else if (!z) {
                continue;
            } else {
                i++;
                if (i == str.length()) {
                    return sb;
                }
                charAt = str.charAt(i);
            }
            sb.append(charAt);
            i++;
        }
        sb.append("\\E");
        return sb;
    }

    public static ConcurrentMap<Locale, Strategy> getCache(int i) {
        ConcurrentMap<Locale, Strategy> concurrentMap;
        synchronized (caches) {
            if (caches[i] == null) {
                caches[i] = new ConcurrentHashMap(3);
            }
            concurrentMap = caches[i];
        }
        return concurrentMap;
    }

    public static Map<String, Integer> getDisplayNames(int i, Calendar calendar, Locale locale) {
        return calendar.getDisplayNames(i, 0, locale);
    }

    private Strategy getLocaleSpecificStrategy(int i, Calendar calendar) {
        ConcurrentMap<Locale, Strategy> cache = getCache(i);
        Strategy strategy = cache.get(this.locale);
        if (strategy == null) {
            strategy = i == 15 ? new TimeZoneStrategy(this.locale) : new TextStrategy(i, calendar, this.locale);
            Strategy putIfAbsent = cache.putIfAbsent(this.locale, strategy);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
        }
        return strategy;
    }

    private Strategy getStrategy(String str, Calendar calendar) {
        int i;
        char charAt = str.charAt(0);
        if (charAt == 'y') {
            return str.length() > 2 ? LITERAL_YEAR_STRATEGY : ABBREVIATED_YEAR_STRATEGY;
        }
        if (charAt != 'z') {
            switch (charAt) {
                case '\'':
                    if (str.length() > 2) {
                        return new CopyQuotedStrategy(str.substring(1, str.length() - 1));
                    }
                    return new CopyQuotedStrategy(str);
                case 'K':
                    return HOUR_STRATEGY;
                case 'M':
                    return str.length() >= 3 ? getLocaleSpecificStrategy(2, calendar) : NUMBER_MONTH_STRATEGY;
                case 'S':
                    return MILLISECOND_STRATEGY;
                case 'W':
                    return WEEK_OF_MONTH_STRATEGY;
                case 'Z':
                    break;
                case 'a':
                    i = 9;
                    return getLocaleSpecificStrategy(i, calendar);
                case 'd':
                    return DAY_OF_MONTH_STRATEGY;
                case 'h':
                    return MODULO_HOUR_STRATEGY;
                case 'k':
                    return HOUR_OF_DAY_STRATEGY;
                case 'm':
                    return MINUTE_STRATEGY;
                case 's':
                    return SECOND_STRATEGY;
                case 'w':
                    return WEEK_OF_YEAR_STRATEGY;
                default:
                    switch (charAt) {
                        case 'D':
                            return DAY_OF_YEAR_STRATEGY;
                        case 'E':
                            i = 7;
                            return getLocaleSpecificStrategy(i, calendar);
                        case 'F':
                            return DAY_OF_WEEK_IN_MONTH_STRATEGY;
                        case 'G':
                            return getLocaleSpecificStrategy(0, calendar);
                        case 'H':
                            return MODULO_HOUR_OF_DAY_STRATEGY;
                    }
                    return new CopyQuotedStrategy(str);
            }
        }
        i = 15;
        return getLocaleSpecificStrategy(i, calendar);
    }

    private void init(Calendar calendar) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        Matcher matcher = formatPattern.matcher(this.pattern);
        if (!matcher.lookingAt()) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Illegal pattern character '");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.pattern.charAt(matcher.regionStart()));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("'");
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        String group = matcher.group();
        this.currentFormatField = group;
        Strategy strategy = getStrategy(group, calendar);
        while (true) {
            matcher.region(matcher.end(), matcher.regionEnd());
            if (!matcher.lookingAt()) {
                break;
            }
            String group2 = matcher.group();
            this.nextStrategy = getStrategy(group2, calendar);
            if (strategy.addRegex(this, sb)) {
                arrayList.add(strategy);
            }
            this.currentFormatField = group2;
            strategy = this.nextStrategy;
        }
        this.nextStrategy = null;
        if (matcher.regionStart() != matcher.regionEnd()) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to parse \"");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.pattern);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("\" ; gave up at index ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(matcher.regionStart());
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
        if (strategy.addRegex(this, sb)) {
            arrayList.add(strategy);
        }
        this.currentFormatField = null;
        this.strategies = (Strategy[]) arrayList.toArray(new Strategy[arrayList.size()]);
        this.parsePattern = Pattern.compile(sb.toString());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(Calendar.getInstance(this.timeZone, this.locale));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateParser)) {
            return false;
        }
        FastDateParser fastDateParser = (FastDateParser) obj;
        return this.pattern.equals(fastDateParser.pattern) && this.timeZone.equals(fastDateParser.timeZone) && this.locale.equals(fastDateParser.locale);
    }

    public int getFieldWidth() {
        return this.currentFormatField.length();
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        return this.locale;
    }

    public Pattern getParsePattern() {
        return this.parsePattern;
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        return this.pattern;
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public int hashCode() {
        return (((this.locale.hashCode() * 13) + this.timeZone.hashCode()) * 13) + this.pattern.hashCode();
    }

    public boolean isNextNumber() {
        Strategy strategy = this.nextStrategy;
        return strategy != null && strategy.isNumber();
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str) throws ParseException {
        Date parse = parse(str, new ParsePosition(0));
        if (parse == null) {
            if (!this.locale.equals(JAPANESE_IMPERIAL)) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unparseable date: \"", str, "\" does not match ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.parsePattern.pattern());
                throw new ParseException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), 0);
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(The ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.locale);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" locale does not support dates before 1868 AD)\n");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Unparseable date: \"");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\" does not match ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.parsePattern.pattern());
            throw new ParseException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), 0);
        }
        return parse;
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        Matcher matcher = this.parsePattern.matcher(str.substring(index));
        if (!matcher.lookingAt()) {
            return null;
        }
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        calendar.clear();
        int i = 0;
        while (true) {
            Strategy[] strategyArr = this.strategies;
            if (i >= strategyArr.length) {
                parsePosition.setIndex(matcher.end() + index);
                return calendar.getTime();
            }
            int i2 = i + 1;
            strategyArr[i].setCalendar(this, calendar, matcher.group(i2));
            i = i2;
        }
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str) throws ParseException {
        return parse(str);
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("FastDateParser[");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.pattern);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.locale);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.timeZone.getID());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

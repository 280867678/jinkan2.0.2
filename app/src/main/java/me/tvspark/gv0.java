package me.tvspark;

import com.umeng.analytics.pro.C1543ak;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;
import org.fourthline.cling.model.Constants;
import org.seamless.xhtml.XHTMLElement;

/* loaded from: classes4.dex */
public class gv0 {
    public static TreeMap<String, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new TreeMap<>(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    public static TreeMap<String, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new TreeMap<>(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    public static HashSet<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashSet<>();
    public static TreeMap<String, TimeZone> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new TreeMap<>();

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Comparator<String> {
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            return str.compareToIgnoreCase(str2);
        }
    }

    static {
        String[] availableIDs;
        Locale[] availableLocales;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add("MEZ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add("Uhr");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(XHTMLElement.XPATH_PREFIX);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add("pm");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add("PM");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add("AM");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add("o'clock");
        for (String str : TimeZone.getAvailableIDs()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(str, TimeZone.getTimeZone(str));
        }
        for (Locale locale : DateFormatSymbols.getAvailableLocales()) {
            if (!"ja".equals(locale.getLanguage()) && !"ko".equals(locale.getLanguage()) && !"zh".equals(locale.getLanguage())) {
                DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
                String[] months = dateFormatSymbols.getMonths();
                for (int i = 0; i < months.length; i++) {
                    if (months[i].length() != 0) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, months[i], Integer.valueOf(i));
                    }
                }
                String[] shortMonths = dateFormatSymbols.getShortMonths();
                for (int i2 = 0; i2 < shortMonths.length; i2++) {
                    String str2 = shortMonths[i2];
                    if (str2.length() != 0 && !Character.isDigit(str2.charAt(str2.length() - 1))) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, shortMonths[i2], Integer.valueOf(i2));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, shortMonths[i2].replace(".", ""), Integer.valueOf(i2));
                    }
                }
                String[] weekdays = dateFormatSymbols.getWeekdays();
                for (int i3 = 0; i3 < weekdays.length; i3++) {
                    String str3 = weekdays[i3];
                    if (str3.length() != 0) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str3, Integer.valueOf(i3));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str3.replace(".", ""), Integer.valueOf(i3));
                    }
                }
                String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
                for (int i4 = 0; i4 < shortWeekdays.length; i4++) {
                    String str4 = shortWeekdays[i4];
                    if (str4.length() != 0) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str4, Integer.valueOf(i4));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str4.replace(".", ""), Integer.valueOf(i4));
                    }
                }
            }
        }
    }

    public static Integer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        int intValue;
        if (Character.isDigit(str.charAt(0))) {
            intValue = Integer.parseInt(str) - 1;
        } else {
            Integer num = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str);
            if (num == null) {
                throw new NullPointerException("can not parse " + str + " as month");
            }
            intValue = num.intValue();
        }
        return Integer.valueOf(intValue);
    }

    public static Date Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringTokenizer stringTokenizer, Calendar calendar, String str) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
        calendar.set(11, Integer.parseInt(str));
        if (stringTokenizer.hasMoreTokens() && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringTokenizer, stringTokenizer.nextToken(), calendar)) != null) {
            calendar.set(12, Integer.parseInt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
            if (stringTokenizer.hasMoreTokens() && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringTokenizer, stringTokenizer.nextToken(), calendar)) != null) {
                calendar.set(13, Integer.parseInt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3));
                if (stringTokenizer.hasMoreTokens() && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringTokenizer, stringTokenizer.nextToken(), calendar)) != null) {
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringTokenizer, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, calendar);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.length() == 4 && Character.isDigit(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.charAt(0))) {
                        calendar.set(1, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5));
                    }
                    return calendar.getTime();
                }
                return calendar.getTime();
            }
            return calendar.getTime();
        }
        return calendar.getTime();
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        int parseInt = Integer.parseInt(str);
        return parseInt < 100 ? parseInt > 23 ? parseInt + 2000 : parseInt + Constants.UPNP_MULTICAST_PORT : parseInt;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringTokenizer stringTokenizer, String str, Calendar calendar) {
        while (true) {
            TimeZone timeZone = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str);
            if (timeZone != null) {
                calendar.setTimeZone(timeZone);
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
            } else if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(str)) {
                return str;
            } else {
                if (str.equalsIgnoreCase("pm")) {
                    calendar.add(9, 1);
                }
                if (str.equalsIgnoreCase("am")) {
                    calendar.add(9, 0);
                }
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
            }
            str = stringTokenizer.nextToken();
        }
    }

    public static Date Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        String str = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (!(obj instanceof String)) {
            throw new RuntimeException("Primitive: Can not convert " + obj.getClass().getName() + " to int");
        }
        StringTokenizer stringTokenizer = new StringTokenizer((String) obj, " -/:,.+");
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        String nextToken = stringTokenizer.nextToken();
        if (nextToken.length() == 4 && Character.isDigit(nextToken.charAt(0))) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(2000, 0, 0, 0, 0, 0);
            gregorianCalendar.setTimeInMillis(0L);
            gregorianCalendar.set(1, Integer.parseInt(nextToken));
            if (stringTokenizer.hasMoreTokens()) {
                gregorianCalendar.set(2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringTokenizer.nextToken()).intValue());
                if (stringTokenizer.hasMoreTokens()) {
                    String nextToken2 = stringTokenizer.nextToken();
                    if (Character.isDigit(nextToken2.charAt(0))) {
                        if (nextToken2.length() == 5 && nextToken2.charAt(2) == 'T') {
                            gregorianCalendar.set(5, Integer.parseInt(nextToken2.substring(0, 2)));
                            str = nextToken2.substring(3);
                        } else {
                            gregorianCalendar.set(5, Integer.parseInt(nextToken2));
                        }
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringTokenizer, gregorianCalendar, str);
                    }
                }
            }
            return gregorianCalendar.getTime();
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.containsKey(nextToken)) {
            if (!stringTokenizer.hasMoreTokens()) {
                return null;
            }
            nextToken = stringTokenizer.nextToken();
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.containsKey(nextToken)) {
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(2000, 0, 0, 0, 0, 0);
            Integer num = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(nextToken);
            if (num == null) {
                throw new NullPointerException("can not parse " + nextToken + " as month");
            }
            gregorianCalendar2.set(2, num.intValue());
            if (!stringTokenizer.hasMoreTokens()) {
                return null;
            }
            gregorianCalendar2.set(5, Integer.parseInt(stringTokenizer.nextToken()));
            if (!stringTokenizer.hasMoreTokens()) {
                return null;
            }
            String nextToken3 = stringTokenizer.nextToken();
            if (Character.isLetter(nextToken3.charAt(0))) {
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
                nextToken3 = stringTokenizer.nextToken();
            }
            if (nextToken3.length() == 4) {
                gregorianCalendar2.set(1, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nextToken3));
            } else if (nextToken3.length() == 2) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringTokenizer, gregorianCalendar2, nextToken3);
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringTokenizer, gregorianCalendar2, (String) null);
        } else if (!Character.isDigit(nextToken.charAt(0))) {
            return null;
        } else {
            GregorianCalendar gregorianCalendar3 = new GregorianCalendar(2000, 0, 0, 0, 0, 0);
            gregorianCalendar3.set(5, Integer.parseInt(nextToken));
            if (!stringTokenizer.hasMoreTokens()) {
                return null;
            }
            gregorianCalendar3.set(2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringTokenizer.nextToken()).intValue());
            if (!stringTokenizer.hasMoreTokens()) {
                return null;
            }
            gregorianCalendar3.set(1, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringTokenizer.nextToken()));
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringTokenizer, gregorianCalendar3, (String) null);
        }
    }

    public static Date Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringTokenizer stringTokenizer, Calendar calendar, String str) {
        if (str == null) {
            if (!stringTokenizer.hasMoreTokens()) {
                return calendar.getTime();
            }
            str = stringTokenizer.nextToken();
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringTokenizer, calendar, str);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TreeMap<String, Integer> treeMap, String str, Integer num) {
        treeMap.put(str, num);
        treeMap.put(str.replace("é", "e").replace("û", C1543ak.f2970aG), num);
    }
}

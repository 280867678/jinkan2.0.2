package org.seamless.util.time;

import java.io.Serializable;
import java.util.Date;
import me.tvspark.outline;
import org.fourthline.cling.model.Constants;

/* loaded from: classes5.dex */
public class DateRange implements Serializable {
    public Date end;
    public Date start;

    /* loaded from: classes5.dex */
    public enum Preset {
        ALL(new DateRange(null)),
        YEAR_TO_DATE(new DateRange(new Date(DateRange.getCurrentYear(), 0, 1))),
        MONTH_TO_DATE(new DateRange(new Date(DateRange.getCurrentYear(), DateRange.getCurrentMonth(), 1))),
        LAST_MONTH(DateRange.getMonthOf(new Date(DateRange.getCurrentYear(), DateRange.getCurrentMonth() - 1, 1))),
        LAST_YEAR(new DateRange(new Date(DateRange.getCurrentYear() - 1, 0, 1), new Date(DateRange.getCurrentYear() - 1, 11, 31)));
        
        public DateRange dateRange;

        Preset(DateRange dateRange) {
            this.dateRange = dateRange;
        }

        public DateRange getDateRange() {
            return this.dateRange;
        }
    }

    public DateRange() {
    }

    public DateRange(String str, String str2) throws NumberFormatException {
        if (str != null) {
            this.start = new Date(Long.valueOf(str).longValue());
        }
        if (str2 != null) {
            this.end = new Date(Long.valueOf(str2).longValue());
        }
    }

    public DateRange(Date date) {
        this.start = date;
    }

    public DateRange(Date date, Date date2) {
        this.start = date;
        this.end = date2;
    }

    public static int getCurrentDayOfMonth() {
        return new Date().getDate();
    }

    public static int getCurrentMonth() {
        return new Date().getMonth();
    }

    public static int getCurrentYear() {
        return new Date().getYear();
    }

    public static int getDaysInMonth(Date date) {
        int month = date.getMonth();
        int year = date.getYear() + Constants.UPNP_MULTICAST_PORT;
        boolean z = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        int[] iArr = new int[12];
        iArr[0] = 31;
        iArr[1] = z ? 29 : 28;
        iArr[2] = 31;
        iArr[3] = 30;
        iArr[4] = 31;
        iArr[5] = 30;
        iArr[6] = 31;
        iArr[7] = 31;
        iArr[8] = 30;
        iArr[9] = 31;
        iArr[10] = 30;
        iArr[11] = 31;
        return iArr[month];
    }

    public static DateRange getMonthOf(Date date) {
        return new DateRange(new Date(date.getYear(), date.getMonth(), 1), new Date(date.getYear(), date.getMonth(), getDaysInMonth(date)));
    }

    public static DateRange valueOf(String str) {
        if (!str.contains("dr=")) {
            return null;
        }
        String substring = str.substring(str.indexOf("dr=") + 3);
        String[] split = substring.substring(0, substring.indexOf(";")).split(",");
        if (split.length != 2) {
            return null;
        }
        try {
            return new DateRange(!split[0].equals("0") ? new Date(Long.valueOf(split[0]).longValue()) : null, !split[1].equals("0") ? new Date(Long.valueOf(split[1]).longValue()) : null);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DateRange.class != obj.getClass()) {
            return false;
        }
        DateRange dateRange = (DateRange) obj;
        Date date = this.end;
        if (date == null ? dateRange.end != null : !date.equals(dateRange.end)) {
            return false;
        }
        Date date2 = this.start;
        Date date3 = dateRange.start;
        return date2 == null ? date3 == null : date2.equals(date3);
    }

    public Date getEnd() {
        return this.end;
    }

    public Date getOneDayBeforeStart() {
        if (getStart() != null) {
            return new Date(getStart().getTime() - 86400000);
        }
        throw new IllegalStateException("Can't get day before start date because start date is null");
    }

    public Date getStart() {
        return this.start;
    }

    public boolean hasStartOrEnd() {
        return (getStart() == null && getEnd() == null) ? false : true;
    }

    public int hashCode() {
        Date date = this.start;
        int i = 0;
        int hashCode = (date != null ? date.hashCode() : 0) * 31;
        Date date2 = this.end;
        if (date2 != null) {
            i = date2.hashCode();
        }
        return hashCode + i;
    }

    public boolean isInRange(Date date) {
        return getStart() != null && getStart().getTime() < date.getTime() && (getEnd() == null || getEnd().getTime() > date.getTime());
    }

    public boolean isStartAfter(Date date) {
        return getStart() != null && getStart().getTime() > date.getTime();
    }

    public boolean isValid() {
        return getStart() != null && (getEnd() == null || getStart().getTime() <= getEnd().getTime());
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("dr=");
        Object obj = "0";
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getStart() != null ? Long.valueOf(getStart().getTime()) : obj);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
        if (getEnd() != null) {
            obj = Long.valueOf(getEnd().getTime());
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(";");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

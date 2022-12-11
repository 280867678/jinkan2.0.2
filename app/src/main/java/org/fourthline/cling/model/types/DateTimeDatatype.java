package org.fourthline.cling.model.types;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class DateTimeDatatype extends AbstractDatatype<Calendar> {
    public String[] readFormats;
    public String writeFormat;

    public DateTimeDatatype(String[] strArr, String str) {
        this.readFormats = strArr;
        this.writeFormat = str;
    }

    public Date getDateValue(String str, String[] strArr) {
        String normalizeTimeZone = normalizeTimeZone(str);
        Date date = null;
        for (String str2 : strArr) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
            simpleDateFormat.setTimeZone(getTimeZone());
            try {
                date = simpleDateFormat.parse(normalizeTimeZone);
            } catch (ParseException unused) {
            }
        }
        return date;
    }

    @Override // org.fourthline.cling.model.types.AbstractDatatype, org.fourthline.cling.model.types.Datatype
    public String getString(Calendar calendar) throws InvalidValueException {
        if (calendar == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.writeFormat);
        simpleDateFormat.setTimeZone(getTimeZone());
        return simpleDateFormat.format(calendar.getTime());
    }

    public TimeZone getTimeZone() {
        return TimeZone.getDefault();
    }

    public String normalizeTimeZone(String str) {
        StringBuilder sb;
        String substring;
        if (str.endsWith("Z")) {
            sb = new StringBuilder();
            sb.append(str.substring(0, str.length() - 1));
            substring = "+0000";
        } else if (str.length() <= 7 || str.charAt(str.length() - 3) != ':') {
            return str;
        } else {
            if (str.charAt(str.length() - 6) != '-' && str.charAt(str.length() - 6) != '+') {
                return str;
            }
            sb = new StringBuilder();
            sb.append(str.substring(0, str.length() - 3));
            substring = str.substring(str.length() - 2);
        }
        sb.append(substring);
        return sb.toString();
    }

    @Override // org.fourthline.cling.model.types.AbstractDatatype, org.fourthline.cling.model.types.Datatype
    /* renamed from: valueOf  reason: collision with other method in class */
    public Calendar mo5215valueOf(String str) throws InvalidValueException {
        if (str.equals("")) {
            return null;
        }
        Date dateValue = getDateValue(str, this.readFormats);
        if (dateValue == null) {
            throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse date/time from: ", str));
        }
        Calendar calendar = Calendar.getInstance(getTimeZone());
        calendar.setTime(dateValue);
        return calendar;
    }
}

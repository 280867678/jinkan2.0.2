package org.simpleframework.xml.transform;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes5.dex */
public enum DateType {
    FULL("yyyy-MM-dd HH:mm:ss.S z"),
    LONG("yyyy-MM-dd HH:mm:ss z"),
    NORMAL("yyyy-MM-dd z"),
    SHORT("yyyy-MM-dd");
    
    public DateFormat format;

    /* loaded from: classes5.dex */
    public static class DateFormat {
        public SimpleDateFormat format;

        public DateFormat(String str) {
            this.format = new SimpleDateFormat(str);
        }

        public synchronized Date getDate(String str) throws Exception {
            return this.format.parse(str);
        }

        public synchronized String getText(Date date) throws Exception {
            return this.format.format(date);
        }
    }

    DateType(String str) {
        this.format = new DateFormat(str);
    }

    public static Date getDate(String str) throws Exception {
        return getType(str).getFormat().getDate(str);
    }

    private DateFormat getFormat() {
        return this.format;
    }

    public static String getText(Date date) throws Exception {
        return FULL.getFormat().getText(date);
    }

    public static DateType getType(String str) {
        int length = str.length();
        return length > 23 ? FULL : length > 20 ? LONG : length > 11 ? NORMAL : SHORT;
    }
}

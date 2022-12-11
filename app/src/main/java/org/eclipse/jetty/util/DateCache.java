package org.eclipse.jetty.util;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import me.tvspark.outline;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* loaded from: classes5.dex */
public class DateCache {
    public static String DEFAULT_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";
    public static long __hitWindow = 3600;
    public DateFormatSymbols _dfs;
    public String _formatString;
    public long _lastMinutes;
    public int _lastMs;
    public String _lastResult;
    public long _lastSeconds;
    public Locale _locale;
    public SimpleDateFormat _minFormat;
    public String _minFormatString;
    public String _secFormatString;
    public String _secFormatString0;
    public String _secFormatString1;
    public SimpleDateFormat _tzFormat;
    public String _tzFormatString;

    public DateCache() {
        this(DEFAULT_FORMAT);
        getFormat().setTimeZone(TimeZone.getDefault());
    }

    public DateCache(String str) {
        this._lastMinutes = -1L;
        this._lastSeconds = -1L;
        this._lastMs = -1;
        this._lastResult = null;
        this._locale = null;
        this._dfs = null;
        this._formatString = str;
        setTimeZone(TimeZone.getDefault());
    }

    public DateCache(String str, DateFormatSymbols dateFormatSymbols) {
        this._lastMinutes = -1L;
        this._lastSeconds = -1L;
        this._lastMs = -1;
        this._lastResult = null;
        this._locale = null;
        this._dfs = null;
        this._formatString = str;
        this._dfs = dateFormatSymbols;
        setTimeZone(TimeZone.getDefault());
    }

    public DateCache(String str, Locale locale) {
        this._lastMinutes = -1L;
        this._lastSeconds = -1L;
        this._lastMs = -1;
        this._lastResult = null;
        this._locale = null;
        this._dfs = null;
        this._formatString = str;
        this._locale = locale;
        setTimeZone(TimeZone.getDefault());
    }

    private void setMinFormatString() {
        if (this._tzFormatString.indexOf("ss.SSS") < 0) {
            int indexOf = this._tzFormatString.indexOf("ss");
            this._minFormatString = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this._tzFormatString.substring(0, indexOf), "'ss'", this._tzFormatString.substring(indexOf + 2));
            return;
        }
        throw new IllegalStateException("ms not supported");
    }

    private synchronized void setTzFormatString(TimeZone timeZone) {
        String str;
        int indexOf = this._formatString.indexOf("ZZZ");
        if (indexOf >= 0) {
            String substring = this._formatString.substring(0, indexOf);
            String substring2 = this._formatString.substring(indexOf + 3);
            int rawOffset = timeZone.getRawOffset();
            StringBuilder sb = new StringBuilder(this._formatString.length() + 10);
            sb.append(substring);
            sb.append("'");
            if (rawOffset >= 0) {
                sb.append('+');
            } else {
                rawOffset = -rawOffset;
                sb.append('-');
            }
            int i = rawOffset / 60000;
            int i2 = i / 60;
            int i3 = i % 60;
            if (i2 < 10) {
                sb.append('0');
            }
            sb.append(i2);
            if (i3 < 10) {
                sb.append('0');
            }
            sb.append(i3);
            sb.append(ExtendedMessageFormat.QUOTE);
            sb.append(substring2);
            str = sb.toString();
        } else {
            str = this._formatString;
        }
        this._tzFormatString = str;
        setMinFormatString();
    }

    public synchronized String format(long j) {
        long j2 = j / 1000;
        if (j2 >= this._lastSeconds && (this._lastSeconds <= 0 || j2 <= this._lastSeconds + __hitWindow)) {
            if (this._lastSeconds == j2) {
                return this._lastResult;
            }
            Date date = new Date(j);
            long j3 = j2 / 60;
            if (this._lastMinutes != j3) {
                this._lastMinutes = j3;
                String format = this._minFormat.format(date);
                this._secFormatString = format;
                int indexOf = format.indexOf("ss");
                this._secFormatString0 = this._secFormatString.substring(0, indexOf);
                this._secFormatString1 = this._secFormatString.substring(indexOf + 2);
            }
            this._lastSeconds = j2;
            StringBuilder sb = new StringBuilder(this._secFormatString.length());
            sb.append(this._secFormatString0);
            int i = (int) (j2 % 60);
            if (i < 10) {
                sb.append('0');
            }
            sb.append(i);
            sb.append(this._secFormatString1);
            String sb2 = sb.toString();
            this._lastResult = sb2;
            return sb2;
        }
        return this._tzFormat.format(new Date(j));
    }

    public synchronized String format(Date date) {
        return format(date.getTime());
    }

    public void format(long j, StringBuilder sb) {
        sb.append(format(j));
    }

    public SimpleDateFormat getFormat() {
        return this._minFormat;
    }

    public String getFormatString() {
        return this._formatString;
    }

    public TimeZone getTimeZone() {
        return this._tzFormat.getTimeZone();
    }

    public int lastMs() {
        return this._lastMs;
    }

    public String now() {
        long currentTimeMillis = System.currentTimeMillis();
        this._lastMs = (int) (currentTimeMillis % 1000);
        return format(currentTimeMillis);
    }

    public synchronized void setTimeZone(TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat;
        setTzFormatString(timeZone);
        if (this._locale != null) {
            this._tzFormat = new SimpleDateFormat(this._tzFormatString, this._locale);
            simpleDateFormat = new SimpleDateFormat(this._minFormatString, this._locale);
        } else if (this._dfs != null) {
            this._tzFormat = new SimpleDateFormat(this._tzFormatString, this._dfs);
            simpleDateFormat = new SimpleDateFormat(this._minFormatString, this._dfs);
        } else {
            this._tzFormat = new SimpleDateFormat(this._tzFormatString);
            simpleDateFormat = new SimpleDateFormat(this._minFormatString);
        }
        this._minFormat = simpleDateFormat;
        this._tzFormat.setTimeZone(timeZone);
        this._minFormat.setTimeZone(timeZone);
        this._lastSeconds = -1L;
        this._lastMinutes = -1L;
    }

    public void setTimeZoneID(String str) {
        setTimeZone(TimeZone.getTimeZone(str));
    }
}

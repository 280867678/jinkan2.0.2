package org.eclipse.jetty.util.ajax;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.eclipse.jetty.util.DateCache;
import org.eclipse.jetty.util.ajax.JSON;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class JSONDateConvertor implements JSON.Convertor {
    public static final Logger LOG = Log.getLogger(JSONDateConvertor.class);
    public final DateCache _dateCache;
    public final SimpleDateFormat _format;
    public final boolean _fromJSON;

    public JSONDateConvertor() {
        this(false);
    }

    public JSONDateConvertor(String str, TimeZone timeZone, boolean z) {
        DateCache dateCache = new DateCache(str);
        this._dateCache = dateCache;
        dateCache.setTimeZone(timeZone);
        this._fromJSON = z;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        this._format = simpleDateFormat;
        simpleDateFormat.setTimeZone(timeZone);
    }

    public JSONDateConvertor(String str, TimeZone timeZone, boolean z, Locale locale) {
        DateCache dateCache = new DateCache(str, locale);
        this._dateCache = dateCache;
        dateCache.setTimeZone(timeZone);
        this._fromJSON = z;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, new DateFormatSymbols(locale));
        this._format = simpleDateFormat;
        simpleDateFormat.setTimeZone(timeZone);
    }

    public JSONDateConvertor(boolean z) {
        this(DateCache.DEFAULT_FORMAT, TimeZone.getTimeZone("GMT"), z);
    }

    @Override // org.eclipse.jetty.util.ajax.JSON.Convertor
    public Object fromJSON(Map map) {
        Object parseObject;
        if (this._fromJSON) {
            try {
                synchronized (this._format) {
                    parseObject = this._format.parseObject((String) map.get("value"));
                }
                return parseObject;
            } catch (Exception e) {
                LOG.warn(e);
                return null;
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override // org.eclipse.jetty.util.ajax.JSON.Convertor
    public void toJSON(Object obj, JSON.Output output) {
        String format = this._dateCache.format((Date) obj);
        if (!this._fromJSON) {
            output.add(format);
            return;
        }
        output.addClass(obj.getClass());
        output.add("value", format);
    }
}

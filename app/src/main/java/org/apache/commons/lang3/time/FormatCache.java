package org.apache.commons.lang3.time;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes4.dex */
public abstract class FormatCache<F extends Format> {
    public static final int NONE = -1;
    public static final ConcurrentMap<MultipartKey, String> cDateTimeInstanceCache = new ConcurrentHashMap(7);
    public final ConcurrentMap<MultipartKey, F> cInstanceCache = new ConcurrentHashMap(7);

    /* loaded from: classes4.dex */
    public static class MultipartKey {
        public int hashCode;
        public final Object[] keys;

        public MultipartKey(Object... objArr) {
            this.keys = objArr;
        }

        public boolean equals(Object obj) {
            return Arrays.equals(this.keys, ((MultipartKey) obj).keys);
        }

        public int hashCode() {
            Object[] objArr;
            if (this.hashCode == 0) {
                int i = 0;
                for (Object obj : this.keys) {
                    if (obj != null) {
                        i = obj.hashCode() + (i * 7);
                    }
                }
                this.hashCode = i;
            }
            return this.hashCode;
        }
    }

    private F getDateTimeInstance(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return getInstance(getPatternForStyle(num, num2, locale), timeZone, locale);
    }

    public static String getPatternForStyle(Integer num, Integer num2, Locale locale) {
        MultipartKey multipartKey = new MultipartKey(num, num2, locale);
        String str = cDateTimeInstanceCache.get(multipartKey);
        if (str == null) {
            try {
                String pattern = ((SimpleDateFormat) (num == null ? DateFormat.getTimeInstance(num2.intValue(), locale) : num2 == null ? DateFormat.getDateInstance(num.intValue(), locale) : DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale))).toPattern();
                String putIfAbsent = cDateTimeInstanceCache.putIfAbsent(multipartKey, pattern);
                return putIfAbsent != null ? putIfAbsent : pattern;
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("No date time pattern for locale: " + locale);
            }
        }
        return str;
    }

    public abstract F createInstance(String str, TimeZone timeZone, Locale locale);

    public F getDateInstance(int i, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance(Integer.valueOf(i), (Integer) null, timeZone, locale);
    }

    public F getDateTimeInstance(int i, int i2, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance(Integer.valueOf(i), Integer.valueOf(i2), timeZone, locale);
    }

    public F getInstance() {
        return getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    public F getInstance(String str, TimeZone timeZone, Locale locale) {
        if (str != null) {
            if (timeZone == null) {
                timeZone = TimeZone.getDefault();
            }
            if (locale == null) {
                locale = Locale.getDefault();
            }
            MultipartKey multipartKey = new MultipartKey(str, timeZone, locale);
            F f = this.cInstanceCache.get(multipartKey);
            if (f != null) {
                return f;
            }
            F createInstance = createInstance(str, timeZone, locale);
            F putIfAbsent = this.cInstanceCache.putIfAbsent(multipartKey, createInstance);
            return putIfAbsent != null ? putIfAbsent : createInstance;
        }
        throw new NullPointerException("pattern must not be null");
    }

    public F getTimeInstance(int i, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance((Integer) null, Integer.valueOf(i), timeZone, locale);
    }
}

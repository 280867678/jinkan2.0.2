package me.tvspark;

import android.annotation.TargetApi;
import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: me.tvspark.po */
/* loaded from: classes4.dex */
public class C2488po {
    public static AtomicReference<C2451oo> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();

    @TargetApi(24)
    public static DateFormat Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMEd", locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
        return instanceForSkeleton;
    }

    public static Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Calendar) null);
    }

    public static java.text.DateFormat Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(0, locale);
        dateInstance.setTimeZone(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        return dateInstance;
    }

    public static Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTimeInMillis(j);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).getTimeInMillis();
    }

    @TargetApi(24)
    public static DateFormat Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("MMMEd", locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
        return instanceForSkeleton;
    }

    public static Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Calendar calendar) {
        Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(calendar);
        Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(1), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(2), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(5));
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static java.util.TimeZone Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return java.util.TimeZone.getTimeZone("UTC");
    }

    public static Calendar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C2451oo c2451oo = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get();
        if (c2451oo == null) {
            c2451oo = C2451oo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        java.util.TimeZone timeZone = c2451oo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = c2451oo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.setTimeZone(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        return calendar;
    }
}

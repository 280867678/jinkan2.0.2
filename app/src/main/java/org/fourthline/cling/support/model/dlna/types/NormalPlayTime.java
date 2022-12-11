package org.fourthline.cling.support.model.dlna.types;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.outline;
import org.fourthline.cling.model.types.InvalidValueException;

/* loaded from: classes5.dex */
public class NormalPlayTime {
    public static final Pattern pattern = Pattern.compile("^(\\d+):(\\d{1,2}):(\\d{1,2})(\\.(\\d{1,3}))?|(\\d+)(\\.(\\d{1,3}))?$", 2);
    public long milliseconds;

    /* renamed from: org.fourthline.cling.support.model.dlna.types.NormalPlayTime$1 */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C30991 {

        /* renamed from: $SwitchMap$org$fourthline$cling$support$model$dlna$types$NormalPlayTime$Format */
        public static final /* synthetic */ int[] f4653x61cef210;

        static {
            int[] iArr = new int[Format.values().length];
            f4653x61cef210 = iArr;
            try {
                Format format = Format.TIME;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum Format {
        SECONDS,
        TIME
    }

    public NormalPlayTime(long j) {
        if (j >= 0) {
            this.milliseconds = j;
            return;
        }
        throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid parameter milliseconds: ", j));
    }

    public NormalPlayTime(long j, long j2, long j3, long j4) throws InvalidValueException {
        if (j >= 0) {
            if (j2 < 0 || j2 > 59) {
                throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid parameter minutes: ", j));
            }
            if (j3 < 0 || j3 > 59) {
                throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid parameter seconds: ", j));
            }
            if (j4 < 0 || j4 > 999) {
                throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid parameter milliseconds: ", j4));
            }
            this.milliseconds = (((j2 * 60) + (j * 60 * 60) + j3) * 1000) + j4;
            return;
        }
        throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid parameter hours: ", j));
    }

    public static NormalPlayTime valueOf(String str) throws InvalidValueException {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            try {
                if (matcher.group(1) != null) {
                    return new NormalPlayTime(Long.parseLong(matcher.group(1)), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)), Long.parseLong(matcher.group(5)) * ((int) Math.pow(10.0d, 3 - matcher.group(5).length())));
                }
                return new NormalPlayTime((Long.parseLong(matcher.group(8)) * ((int) Math.pow(10.0d, 3 - matcher.group(8).length()))) + (Long.parseLong(matcher.group(6)) * 1000));
            } catch (NumberFormatException unused) {
            }
        }
        throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse NormalPlayTime: ", str));
    }

    public long getMilliseconds() {
        return this.milliseconds;
    }

    public String getString() {
        return getString(Format.SECONDS);
    }

    public String getString(Format format) {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(this.milliseconds);
        long j = this.milliseconds % 1000;
        if (format.ordinal() != 1) {
            return String.format(Locale.ROOT, "%d.%03d", Long.valueOf(seconds), Long.valueOf(j));
        }
        long seconds2 = TimeUnit.MILLISECONDS.toSeconds(this.milliseconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(this.milliseconds));
        return String.format(Locale.ROOT, "%d:%02d:%02d.%03d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(this.milliseconds)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(this.milliseconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(this.milliseconds))), Long.valueOf(seconds2), Long.valueOf(j));
    }

    public void setMilliseconds(long j) {
        if (j >= 0) {
            this.milliseconds = j;
            return;
        }
        throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid parameter milliseconds: ", j));
    }
}

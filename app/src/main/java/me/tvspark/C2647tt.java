package me.tvspark;

import com.umeng.analytics.pro.C1543ak;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.seamless.xhtml.XHTMLElement;

/* renamed from: me.tvspark.tt */
/* loaded from: classes4.dex */
public final class C2647tt {
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2799xt Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AbstractC2799xt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.tt$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final /* synthetic */ int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public C2647tt Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "This stopwatch is already running.");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TimeUnit timeUnit) {
        return timeUnit.convert(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), TimeUnit.NANOSECONDS);
    }

    public String toString() {
        String str;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        TimeUnit timeUnit = TimeUnit.DAYS.convert(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.DAYS : TimeUnit.HOURS.convert(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.HOURS : TimeUnit.MINUTES.convert(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.MINUTES : TimeUnit.SECONDS.convert(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.SECONDS : TimeUnit.MILLISECONDS.convert(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.MILLISECONDS : TimeUnit.MICROSECONDS.convert(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.MICROSECONDS : TimeUnit.NANOSECONDS;
        double convert = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 / TimeUnit.NANOSECONDS.convert(1L, timeUnit);
        StringBuilder sb = new StringBuilder();
        sb.append(C2536qt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(convert));
        sb.append(StringUtils.SPACE);
        switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[timeUnit.ordinal()]) {
            case 1:
                str = "ns";
                break;
            case 2:
                str = "μs";
                break;
            case 3:
                str = "ms";
                break;
            case 4:
                str = C1543ak.f2965aB;
                break;
            case 5:
                str = "min";
                break;
            case 6:
                str = XHTMLElement.XPATH_PREFIX;
                break;
            case 7:
                str = "d";
                break;
            default:
                throw new AssertionError();
        }
        sb.append(str);
        return sb.toString();
    }
}

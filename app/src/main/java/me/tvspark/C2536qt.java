package me.tvspark;

import com.google.common.base.Enums;
import com.google.common.base.JdkPattern;
import com.google.common.base.Optional;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* renamed from: me.tvspark.qt */
/* loaded from: classes4.dex */
public final class C2536qt {
    public static final AbstractC2499pt Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);

    /* renamed from: me.tvspark.qt$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2499pt {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }
    }

    static {
        Logger.getLogger(C2536qt.class.getName());
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return str == null || str.isEmpty();
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return System.nanoTime();
    }

    public static <T extends Enum<T>> Optional<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<T> cls, String str) {
        WeakReference<? extends Enum<?>> weakReference = Enums.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls).get(str);
        return weakReference == null ? Optional.absent() : Optional.m3933of(cls.cast(weakReference.get()));
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double d) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d));
    }

    public static AbstractC2234it Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (str != null) {
            if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
                throw null;
            }
            return new JdkPattern(Pattern.compile(str));
        }
        throw null;
    }
}

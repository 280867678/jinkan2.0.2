package me.tvspark;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: me.tvspark.wh */
/* loaded from: classes4.dex */
public final class C2750wh {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.wh$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @Nullable
        public final PointF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("\\{([^}]*)\\}");
        public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("\\\\an(\\d+)");

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable PointF pointF) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = pointF;
        }

        @Nullable
        public static PointF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            String group;
            String group2;
            Matcher matcher = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(str);
            Matcher matcher2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(str);
            boolean find = matcher.find();
            boolean find2 = matcher2.find();
            if (find) {
                if (find2) {
                    String.valueOf(str).length();
                }
                group = matcher.group(1);
                group2 = matcher.group(2);
            } else if (!find2) {
                return null;
            } else {
                group = matcher2.group(1);
                group2 = matcher2.group(2);
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
            float parseFloat = Float.parseFloat(group.trim());
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group2);
            return new PointF(parseFloat, Float.parseFloat(group2.trim()));
        }
    }

    /* renamed from: me.tvspark.wh$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        }
    }

    public C2750wh(String str, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        boolean z;
        try {
            int parseInt = Integer.parseInt(str.trim());
            switch (parseInt) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            "Ignoring unknown alignment: ".concat(valueOf);
            return -1;
        }
        new String("Ignoring unknown alignment: ");
        return -1;
    }
}

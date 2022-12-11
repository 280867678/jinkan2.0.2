package me.tvspark;

/* renamed from: me.tvspark.xy */
/* loaded from: classes4.dex */
public abstract class AbstractC2804xy {

    /* renamed from: me.tvspark.xy$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2804xy {
        public final double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double d) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = d;
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
    }

    /* renamed from: me.tvspark.xy$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2804xy {
        public final double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double d, double d2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = d;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = d2;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Double.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
    }

    /* renamed from: me.tvspark.xy$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2804xy {
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        public String toString() {
            return "NaN";
        }
    }
}

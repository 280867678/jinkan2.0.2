package androidx.constraintlayout.motion.utils;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class Easing {
    public static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    public static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    public static final String LINEAR = "cubic(1, 1, 0, 0)";
    public static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    public String str = "identity";
    public static Easing sDefault = new Easing();
    public static final String STANDARD_NAME = "standard";
    public static final String ACCELERATE_NAME = "accelerate";
    public static final String DECELERATE_NAME = "decelerate";
    public static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = {STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};

    /* loaded from: classes3.dex */
    public static class CubicEasing extends Easing {
        public static double d_error = 1.0E-4d;
        public static double error = 0.01d;

        /* renamed from: x1 */
        public double f13x1;

        /* renamed from: x2 */
        public double f14x2;

        /* renamed from: y1 */
        public double f15y1;

        /* renamed from: y2 */
        public double f16y2;

        public CubicEasing(double d, double d2, double d3, double d4) {
            setup(d, d2, d3, d4);
        }

        public CubicEasing(String str) {
            this.str = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f13x1 = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i);
            this.f15y1 = Double.parseDouble(str.substring(i, indexOf3).trim());
            int i2 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i2);
            this.f14x2 = Double.parseDouble(str.substring(i2, indexOf4).trim());
            int i3 = indexOf4 + 1;
            this.f16y2 = Double.parseDouble(str.substring(i3, str.indexOf(41, i3)).trim());
        }

        private double getDiffX(double d) {
            double d2 = 1.0d - d;
            double d3 = this.f13x1;
            double d4 = d2 * 3.0d * d2 * d3;
            double d5 = this.f14x2;
            return ((1.0d - d5) * 3.0d * d * d) + ((d5 - d3) * d2 * 6.0d * d) + d4;
        }

        private double getDiffY(double d) {
            double d2 = 1.0d - d;
            double d3 = this.f15y1;
            double d4 = d2 * 3.0d * d2 * d3;
            double d5 = this.f16y2;
            return ((1.0d - d5) * 3.0d * d * d) + ((d5 - d3) * d2 * 6.0d * d) + d4;
        }

        private double getX(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            double d4 = d2 * d3 * d;
            double d5 = d3 * d * d;
            return (this.f14x2 * d5) + (this.f13x1 * d4) + (d * d * d);
        }

        private double getY(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            double d4 = d2 * d3 * d;
            double d5 = d3 * d * d;
            return (this.f16y2 * d5) + (this.f15y1 * d4) + (d * d * d);
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double get(double d) {
            if (d <= RoundRectDrawableWithShadow.COS_45) {
                return RoundRectDrawableWithShadow.COS_45;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d2 > error) {
                d2 *= 0.5d;
                d3 = getX(d3) < d ? d3 + d2 : d3 - d2;
            }
            double d4 = d3 - d2;
            double x = getX(d4);
            double d5 = d3 + d2;
            double x2 = getX(d5);
            double y = getY(d4);
            return (((d - x) * (getY(d5) - y)) / (x2 - x)) + y;
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double getDiff(double d) {
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d2 > d_error) {
                d2 *= 0.5d;
                d3 = getX(d3) < d ? d3 + d2 : d3 - d2;
            }
            double d4 = d3 - d2;
            double d5 = d3 + d2;
            return (getY(d5) - getY(d4)) / (getX(d5) - getX(d4));
        }

        public void setup(double d, double d2, double d3, double d4) {
            this.f13x1 = d;
            this.f15y1 = d2;
            this.f14x2 = d3;
            this.f16y2 = d4;
        }
    }

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals(ACCELERATE_NAME)) {
                    c = 1;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals(DECELERATE_NAME)) {
                    c = 2;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals(LINEAR_NAME)) {
                    c = 3;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals(STANDARD_NAME)) {
                    c = 0;
                    break;
                }
                break;
        }
        if (c == 0) {
            return new CubicEasing(STANDARD);
        }
        if (c == 1) {
            return new CubicEasing(ACCELERATE);
        }
        if (c == 2) {
            return new CubicEasing(DECELERATE);
        }
        if (c == 3) {
            return new CubicEasing(LINEAR);
        }
        Arrays.toString(NAMED_EASING);
        return sDefault;
    }

    public double get(double d) {
        return d;
    }

    public double getDiff(double d) {
        return 1.0d;
    }

    public String toString() {
        return this.str;
    }
}

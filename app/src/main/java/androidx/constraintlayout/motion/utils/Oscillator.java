package androidx.constraintlayout.motion.utils;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.util.Arrays;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    public double[] mArea;
    public int mType;
    public float[] mPeriod = new float[0];
    public double[] mPosition = new double[0];
    public double PI2 = 6.283185307179586d;
    public boolean mNormalized = false;

    public void addPoint(double d, float f) {
        int length = this.mPeriod.length + 1;
        int binarySearch = Arrays.binarySearch(this.mPosition, d);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.mPosition[binarySearch] = d;
        this.mPeriod[binarySearch] = f;
        this.mNormalized = false;
    }

    public double getDP(double d) {
        if (d <= RoundRectDrawableWithShadow.COS_45) {
            d = 1.0E-5d;
        } else if (d >= 1.0d) {
            d = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d);
        if (binarySearch <= 0 && binarySearch != 0) {
            int i = (-binarySearch) - 1;
            float[] fArr = this.mPeriod;
            int i2 = i - 1;
            double d2 = fArr[i] - fArr[i2];
            double[] dArr = this.mPosition;
            double d3 = d2 / (dArr[i] - dArr[i2]);
            return (fArr[i2] - (d3 * dArr[i2])) + (d * d3);
        }
        return RoundRectDrawableWithShadow.COS_45;
    }

    public double getP(double d) {
        if (d < RoundRectDrawableWithShadow.COS_45) {
            d = 0.0d;
        } else if (d > 1.0d) {
            d = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return RoundRectDrawableWithShadow.COS_45;
        }
        int i = (-binarySearch) - 1;
        float[] fArr = this.mPeriod;
        int i2 = i - 1;
        double d2 = fArr[i] - fArr[i2];
        double[] dArr = this.mPosition;
        double d3 = d2 / (dArr[i] - dArr[i2]);
        return ((((d * d) - (dArr[i2] * dArr[i2])) * d3) / 2.0d) + ((d - dArr[i2]) * (fArr[i2] - (dArr[i2] * d3))) + this.mArea[i2];
    }

    public double getSlope(double d) {
        switch (this.mType) {
            case 1:
                return RoundRectDrawableWithShadow.COS_45;
            case 2:
                return Math.signum((((getP(d) * 4.0d) + 3.0d) % 4.0d) - 2.0d) * getDP(d) * 4.0d;
            case 3:
                return getDP(d) * 2.0d;
            case 4:
                return (-getDP(d)) * 2.0d;
            case 5:
                return Math.sin(getP(d) * this.PI2) * getDP(d) * (-this.PI2);
            case 6:
                return ((((getP(d) * 4.0d) + 2.0d) % 4.0d) - 2.0d) * getDP(d) * 4.0d;
            default:
                return Math.cos(getP(d) * this.PI2) * getDP(d) * this.PI2;
        }
    }

    public double getValue(double d) {
        double abs;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (getP(d) % 1.0d));
            case 2:
                abs = Math.abs((((getP(d) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((getP(d) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((getP(d) * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(getP(d) * this.PI2);
            case 6:
                double abs2 = 1.0d - Math.abs(((getP(d) * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            default:
                return Math.sin(getP(d) * this.PI2);
        }
        return 1.0d - abs;
    }

    public void normalize() {
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        int i;
        double d = 0.0d;
        int i2 = 0;
        while (true) {
            if (i2 >= this.mPeriod.length) {
                break;
            }
            d += fArr[i2];
            i2++;
        }
        double d2 = 0.0d;
        int i3 = 1;
        while (true) {
            if (i3 >= this.mPeriod.length) {
                break;
            }
            double[] dArr = this.mPosition;
            d2 += (dArr[i3] - dArr[i3 - 1]) * ((fArr2[i] + fArr2[i3]) / 2.0f);
            i3++;
        }
        int i4 = 0;
        while (true) {
            float[] fArr4 = this.mPeriod;
            if (i4 >= fArr4.length) {
                break;
            }
            fArr4[i4] = (float) (fArr4[i4] * (d / d2));
            i4++;
        }
        this.mArea[0] = 0.0d;
        int i5 = 1;
        while (true) {
            if (i5 >= this.mPeriod.length) {
                this.mNormalized = true;
                return;
            }
            int i6 = i5 - 1;
            double[] dArr2 = this.mPosition;
            double d3 = dArr2[i5] - dArr2[i6];
            double[] dArr3 = this.mArea;
            dArr3[i5] = (d3 * ((fArr3[i6] + fArr3[i5]) / 2.0f)) + dArr3[i6];
            i5++;
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("pos =");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Arrays.toString(this.mPosition));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" period=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Arrays.toString(this.mPeriod));
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}

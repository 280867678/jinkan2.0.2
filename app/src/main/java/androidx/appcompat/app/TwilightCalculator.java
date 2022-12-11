package androidx.appcompat.app;

/* loaded from: classes3.dex */
public class TwilightCalculator {
    public static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10471976f;

    /* renamed from: C1 */
    public static final float f8C1 = 0.0334196f;

    /* renamed from: C2 */
    public static final float f9C2 = 3.49066E-4f;

    /* renamed from: C3 */
    public static final float f10C3 = 5.236E-6f;
    public static final int DAY = 0;
    public static final float DEGREES_TO_RADIANS = 0.017453292f;

    /* renamed from: J0 */
    public static final float f11J0 = 9.0E-4f;
    public static final int NIGHT = 1;
    public static final float OBLIQUITY = 0.4092797f;
    public static final long UTC_2000 = 946728000000L;
    public static TwilightCalculator sInstance;
    public int state;
    public long sunrise;
    public long sunset;

    public static TwilightCalculator getInstance() {
        if (sInstance == null) {
            sInstance = new TwilightCalculator();
        }
        return sInstance;
    }

    public void calculateTwilight(long j, double d, double d2) {
        float f;
        float f2;
        double d3;
        double d4 = (0.01720197f * (((float) (j - UTC_2000)) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(f2 * 3.0f) * 5.236000106378924E-6d) + (Math.sin(2.0f * f2) * 3.4906598739326E-4d) + (Math.sin(d4) * 0.03341960161924362d) + d4 + 1.796593063d + 3.141592653589793d;
        double sin2 = (Math.sin(2.0d * sin) * (-0.0069d)) + (Math.sin(d4) * 0.0053d) + ((float) Math.round((f - 9.0E-4f) - d3)) + 9.0E-4f + ((-d2) / 360.0d);
        double asin = Math.asin(Math.sin(0.4092797040939331d) * Math.sin(sin));
        double d5 = 0.01745329238474369d * d;
        double sin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(asin) * Math.sin(d5))) / (Math.cos(asin) * Math.cos(d5));
        if (sin3 >= 1.0d) {
            this.state = 1;
        } else if (sin3 > -1.0d) {
            double acos = (float) (Math.acos(sin3) / 6.283185307179586d);
            this.sunset = Math.round((sin2 + acos) * 8.64E7d) + UTC_2000;
            long round = Math.round((sin2 - acos) * 8.64E7d) + UTC_2000;
            this.sunrise = round;
            if (round >= j || this.sunset <= j) {
                this.state = 1;
                return;
            } else {
                this.state = 0;
                return;
            }
        } else {
            this.state = 0;
        }
        this.sunset = -1L;
        this.sunrise = -1L;
    }
}

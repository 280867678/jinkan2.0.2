package me.tvspark;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.google.common.math.Stats;
import com.google.common.primitives.Doubles;

/* renamed from: me.tvspark.zy */
/* loaded from: classes4.dex */
public final class C2878zy {
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = RoundRectDrawableWithShadow.COS_45;
    public double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = RoundRectDrawableWithShadow.COS_45;
    public double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Double.NaN;
    public double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Double.NaN;

    public static double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double d, double d2) {
        if (Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d)) {
            return d2;
        }
        if (!Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d2) && d != d2) {
            return Double.NaN;
        }
        return d;
    }

    public Stats Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new Stats(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(double d) {
        long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (j == 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1L;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = d;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = d;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = d;
            if (Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d)) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Double.NaN;
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j + 1;
        if (!Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d) || !Doubles.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, d);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Double.NaN;
        } else {
            double d2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            double d3 = d - d2;
            double d4 = (d3 / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + d2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = d4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((d - d4) * d3) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Math.min(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, d);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Math.max(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, d);
    }
}

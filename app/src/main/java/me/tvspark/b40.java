package me.tvspark;

import androidx.cardview.widget.RoundRectDrawableWithShadow;

/* loaded from: classes4.dex */
public class b40 extends a40 {
    public Double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public b40() {
        Double valueOf = Double.valueOf((double) RoundRectDrawableWithShadow.COS_45);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = valueOf;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = valueOf;
    }

    @Override // me.tvspark.a40
    public Number Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue() != RoundRectDrawableWithShadow.COS_45 ? Double.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue() / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue()) : Double.valueOf((double) RoundRectDrawableWithShadow.COS_45);
    }

    @Override // me.tvspark.a40
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Number number) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Double.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue() + 1.0d);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Double.valueOf(number.doubleValue() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue());
    }
}

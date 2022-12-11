package me.tvspark;

import androidx.cardview.widget.RoundRectDrawableWithShadow;

/* loaded from: classes4.dex */
public class e40 extends a40 {
    public Double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public e40() {
        Double valueOf = Double.valueOf((double) RoundRectDrawableWithShadow.COS_45);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = valueOf;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = valueOf;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = valueOf;
    }

    @Override // me.tvspark.a40
    public Number Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Double.valueOf(Math.sqrt((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue() / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue()) - (((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue() * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue()) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue()) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue())));
    }

    @Override // me.tvspark.a40
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Number number) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Double.valueOf(number.doubleValue() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Double.valueOf((number.doubleValue() * number.doubleValue()) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Double.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue() + 1.0d);
    }
}

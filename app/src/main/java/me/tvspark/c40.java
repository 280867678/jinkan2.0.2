package me.tvspark;

/* loaded from: classes4.dex */
public class c40 extends a40 {
    public Double Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Double.valueOf(Double.MIN_VALUE);

    @Override // me.tvspark.a40
    public Number Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.a40
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Number number) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.doubleValue() < number.doubleValue()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Double.valueOf(number.doubleValue());
        }
    }
}

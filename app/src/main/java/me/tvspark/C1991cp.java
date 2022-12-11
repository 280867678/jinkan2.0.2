package me.tvspark;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

/* renamed from: me.tvspark.cp */
/* loaded from: classes4.dex */
public class C1991cp implements TypeEvaluator<Float> {
    public FloatEvaluator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new FloatEvaluator();

    public C1991cp(C1954bp c1954bp) {
    }

    @Override // android.animation.TypeEvaluator
    public Float evaluate(float f, Float f2, Float f3) {
        float floatValue = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.evaluate(f, (Number) f2, (Number) f3).floatValue();
        if (floatValue < 0.1f) {
            floatValue = 0.0f;
        }
        return Float.valueOf(floatValue);
    }
}

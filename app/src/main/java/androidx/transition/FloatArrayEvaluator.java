package androidx.transition;

import android.animation.TypeEvaluator;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    public float[] mArray;

    public FloatArrayEvaluator(float[] fArr) {
        this.mArray = fArr;
    }

    @Override // android.animation.TypeEvaluator
    public float[] evaluate(float f, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.mArray;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i = 0; i < fArr3.length; i++) {
            float f2 = fArr[i];
            fArr3[i] = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fArr2[i], f2, f, f2);
        }
        return fArr3;
    }
}

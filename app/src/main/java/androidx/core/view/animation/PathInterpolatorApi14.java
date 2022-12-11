package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class PathInterpolatorApi14 implements Interpolator {
    public static final float PRECISION = 0.002f;

    /* renamed from: mX */
    public final float[] f57mX;

    /* renamed from: mY */
    public final float[] f58mY;

    public PathInterpolatorApi14(float f, float f2) {
        this(createQuad(f, f2));
    }

    public PathInterpolatorApi14(float f, float f2, float f3, float f4) {
        this(createCubic(f, f2, f3, f4));
    }

    public PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.f57mX = new float[i];
        this.f58mY = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((i2 * length) / (i - 1), fArr, null);
            this.f57mX[i2] = fArr[0];
            this.f58mY[i2] = fArr[1];
        }
    }

    public static Path createCubic(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }

    public static Path createQuad(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f57mX.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f57mX[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f57mX;
        float f2 = fArr[length] - fArr[i];
        if (f2 == 0.0f) {
            return this.f58mY[i];
        }
        float[] fArr2 = this.f58mY;
        float f3 = fArr2[i];
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fArr2[length], f3, (f - fArr[i]) / f2, f3);
    }
}

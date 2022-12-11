package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* loaded from: classes3.dex */
public class PathProperty<T> extends Property<T, Float> {
    public float mCurrentFraction;
    public final float mPathLength;
    public final PathMeasure mPathMeasure;
    public final Property<T, PointF> mProperty;
    public final float[] mPosition = new float[2];
    public final PointF mPointF = new PointF();

    public PathProperty(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.mProperty = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.mPathMeasure = pathMeasure;
        this.mPathLength = pathMeasure.getLength();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public Float get(T t) {
        return Float.valueOf(this.mCurrentFraction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    /* renamed from: get  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Float mo4373get(Object obj) {
        return get((PathProperty<T>) obj);
    }

    /* renamed from: set  reason: avoid collision after fix types in other method */
    public void set2(T t, Float f) {
        this.mCurrentFraction = f.floatValue();
        this.mPathMeasure.getPosTan(f.floatValue() * this.mPathLength, this.mPosition, null);
        PointF pointF = this.mPointF;
        float[] fArr = this.mPosition;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.mProperty.set(t, pointF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Object obj, Float f) {
        set2((PathProperty<T>) obj, f);
    }
}

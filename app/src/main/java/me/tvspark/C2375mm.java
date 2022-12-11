package me.tvspark;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* renamed from: me.tvspark.mm */
/* loaded from: classes4.dex */
public class C2375mm extends Property<ImageView, Matrix> {
    public final Matrix Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Matrix();

    public C2375mm() {
        super(Matrix.class, "imageMatrixProperty");
    }

    @Override // android.util.Property
    @NonNull
    public Matrix get(@NonNull ImageView imageView) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(imageView.getImageMatrix());
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.util.Property
    public void set(@NonNull ImageView imageView, @NonNull Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}

package me.tvspark;

import android.graphics.Paint;
import android.graphics.Path;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: me.tvspark.cq */
/* loaded from: classes4.dex */
public class C1992cq {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final Paint Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final Paint Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwww = new int[3];
    public static final float[] Wwwwwwwwwwwwwwwwwwwwwwwww = {0.0f, 0.5f, 1.0f};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwww = new int[4];
    public static final float[] Wwwwwwwwwwwwwwwwwwwwwww = {0.0f, 0.0f, 0.5f, 1.0f};
    public final Path Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new Path();
    public Paint Wwwwwwwwwwwwwwwwwwwwwwwwwww = new Paint();
    @NonNull
    public final Paint Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Paint();

    public C1992cq() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-16777216);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.setColor(0);
        Paint paint = new Paint(4);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = paint;
        paint.setStyle(Paint.Style.FILL);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Paint(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ColorUtils.setAlphaComponent(i, 68);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ColorUtils.setAlphaComponent(i, 20);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = ColorUtils.setAlphaComponent(i, 0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setColor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}

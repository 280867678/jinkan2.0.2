package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import me.tvspark.AbstractC2758wp;

/* loaded from: classes3.dex */
public final class DeterminateDrawable<S> extends AbstractC2758wp {
    public boolean Wwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends FloatPropertyCompat<DeterminateDrawable> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            super(str);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(DeterminateDrawable determinateDrawable) {
            return determinateDrawable.Wwwwwwwwwwwwwwwww * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(DeterminateDrawable determinateDrawable, float f) {
            DeterminateDrawable determinateDrawable2 = determinateDrawable;
            determinateDrawable2.Wwwwwwwwwwwwwwwww = f / 10000.0f;
            determinateDrawable2.invalidateSelf();
        }
    }

    static {
        new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("indicatorLevel");
    }

    @Override // me.tvspark.AbstractC2758wp
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2, boolean z3) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, z2, z3);
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (getBounds().isEmpty() || !isVisible() || !canvas.getClipBounds(rect)) {
            return;
        }
        canvas.save();
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        boolean z = this.Wwwwwwwwwwwwwwww;
        throw null;
    }
}

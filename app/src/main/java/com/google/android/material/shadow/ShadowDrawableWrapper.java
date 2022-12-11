package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapper;

@Deprecated
/* loaded from: classes3.dex */
public class ShadowDrawableWrapper extends DrawableWrapper {
    public static final double Wwwwwwwwwwwwwwwwwwwwww = Math.cos(Math.toRadians(45.0d));
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwwww;

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
            int i = getBounds().left;
            throw null;
        } else {
            canvas.save();
            throw null;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        int ceil = (int) Math.ceil(this.Wwwwwwwwwwwwwwwwwwwwwwww * 1.5f);
        int ceil2 = (int) Math.ceil(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        throw null;
    }
}

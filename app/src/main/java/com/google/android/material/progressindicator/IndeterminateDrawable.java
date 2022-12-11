package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import me.tvspark.AbstractC2758wp;

/* loaded from: classes3.dex */
public final class IndeterminateDrawable<S> extends AbstractC2758wp {
    @Override // me.tvspark.AbstractC2758wp
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2, boolean z3) {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, z2, z3);
        isRunning();
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
}

package com.google.android.exoplayer2.p022ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;

/* renamed from: com.google.android.exoplayer2.ui.AspectRatioFrameLayout */
/* loaded from: classes3.dex */
public final class AspectRatioFrameLayout extends FrameLayout {
    public int Wwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: com.google.android.exoplayer2.ui.AspectRatioFrameLayout$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public boolean Wwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwww;
        public float Wwwwwwwwwwwwwwwwwwwwwww;
        public float Wwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // java.lang.Runnable
        public void run() {
            this.Wwwwwwwwwwwwwwwwwwwww = false;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AspectRatioFrameLayout.this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.AspectRatioFrameLayout$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, boolean z);
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Wwwwwwwwwwwwwwwwwwwww = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.AspectRatioFrameLayout, 0, 0);
            try {
                this.Wwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getInt(R$styleable.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    }

    public int getResizeMode() {
        return this.Wwwwwwwwwwwwwwwwwwwww;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
        if (r4 > 0.0f) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
        if (r4 > 0.0f) goto L27;
     */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Wwwwwwwwwwwwwwwwwwwwww <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = measuredWidth;
        float f2 = measuredHeight;
        float f3 = f / f2;
        float f4 = (this.Wwwwwwwwwwwwwwwwwwwwww / f3) - 1.0f;
        if (Math.abs(f4) <= 0.01f) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = f3;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = false;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = true;
            AspectRatioFrameLayout.this.post(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        int i3 = this.Wwwwwwwwwwwwwwwwwwwww;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 4) {
                    }
                }
                measuredWidth = (int) (f2 * this.Wwwwwwwwwwwwwwwwwwwwww);
            }
            measuredHeight = (int) (f / this.Wwwwwwwwwwwwwwwwwwwwww);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww = f3;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww = true;
        if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww = true;
            AspectRatioFrameLayout.this.post(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f) {
        if (this.Wwwwwwwwwwwwwwwwwwwwww != f) {
            this.Wwwwwwwwwwwwwwwwwwwwww = f;
            requestLayout();
        }
    }

    public void setAspectRatioListener(@Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void setResizeMode(int i) {
        if (this.Wwwwwwwwwwwwwwwwwwwww != i) {
            this.Wwwwwwwwwwwwwwwwwwwww = i;
            requestLayout();
        }
    }
}

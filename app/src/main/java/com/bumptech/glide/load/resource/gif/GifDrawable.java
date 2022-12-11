package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.C1965c;
import me.tvspark.Illlllllllllllllllllll;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.Kkkkkkk;
import me.tvspark.Kkkkkkkkkkkkkkkk;

/* loaded from: classes3.dex */
public class GifDrawable extends Drawable implements C1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Animatable, Animatable2Compat {
    public List<Animatable2Compat.AnimationCallback> Wwwwwwwwwwwwww;
    public Rect Wwwwwwwwwwwwwww;
    public Paint Wwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwww = true;
    public int Wwwwwwwwwwwwwwwwww = -1;

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Drawable.ConstantState {
        @VisibleForTesting
        public final C1965c Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1965c c1965c) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1965c;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new GifDrawable(this);
        }
    }

    public GifDrawable(Context context, Kkkkkkk kkkkkkk, Illlllllllllllllllllll<Bitmap> illlllllllllllllllllll, int i, int i2, Bitmap bitmap) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C1965c(Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context), kkkkkkk, i, i2, illlllllllllllllllllll, bitmap));
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwww = false;
        C1965c c1965c = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(this);
        if (c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!this.Wwwwwwwwwwwwwwwwwwwww, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != 1) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = true;
            C1965c c1965c = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c1965c.Wwwwwwwwwwwwwwwwwwwwwwww) {
                throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
            }
            if (!c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(this)) {
                boolean isEmpty = c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty();
                c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(this);
                if (isEmpty && !c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                    c1965c.Wwwwwwwwwwwwwwwwwwwwwwww = false;
                    c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            } else {
                throw new IllegalStateException("Cannot subscribe twice in a row");
            }
        }
        invalidateSelf();
    }

    public final Paint Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwww = new Paint(2);
        }
        return this.Wwwwwwwwwwwwwwww;
    }

    public Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.C1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        C1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww : -1) == this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - 1) {
            this.Wwwwwwwwwwwwwwwwwww++;
        }
        int i = this.Wwwwwwwwwwwwwwwwww;
        if (i == -1 || this.Wwwwwwwwwwwwwwwwwww < i) {
            return;
        }
        List<Animatable2Compat.AnimationCallback> list = this.Wwwwwwwwwwwwww;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.Wwwwwwwwwwwwww.get(i2).onAnimationEnd(this);
            }
        }
        stop();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.Wwwwwwwwwwwwww;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap;
        if (this.Wwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        if (this.Wwwwwwwwwwwwwwwww) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.Wwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwww = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.Wwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwww = false;
        }
        C1965c c1965c = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1965c.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            bitmap = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww;
        } else {
            bitmap = c1965c.Wwwwwwwwwwwwwwwwwwwwww;
        }
        if (this.Wwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwww = new Rect();
        }
        canvas.drawBitmap(bitmap, (Rect) null, this.Wwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.Wwwwwwwwwwwwwwwww = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.Wwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwww = new ArrayList();
        }
        this.Wwwwwwwwwwwwww.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!this.Wwwwwwwwwwwwwwwwwwwww, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.Wwwwwwwwwwwwwwwwwwww = z;
        if (!z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else if (this.Wwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.Wwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwww = 0;
        if (this.Wwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.Wwwwwwwwwwwwwwwwwwwwww = false;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.Wwwwwwwwwwwwww;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    public GifDrawable(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}

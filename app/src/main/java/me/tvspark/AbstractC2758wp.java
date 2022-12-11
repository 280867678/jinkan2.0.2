package me.tvspark;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: me.tvspark.wp */
/* loaded from: classes4.dex */
public abstract class AbstractC2758wp extends Drawable implements Animatable2Compat {
    public static final Property<AbstractC2758wp, Float> Wwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Float.class, "growFraction");
    public int Wwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    public List<Animatable2Compat.AnimationCallback> Wwwwwwwwwwwwwwwwwwwwww;
    public ValueAnimator Wwwwwwwwwwwwwwwwwwwwwww;
    public ValueAnimator Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.wp$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Property<AbstractC2758wp, Float> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(AbstractC2758wp abstractC2758wp) {
            throw null;
        }

        @Override // android.util.Property
        public void set(AbstractC2758wp abstractC2758wp, Float f) {
            AbstractC2758wp abstractC2758wp2 = abstractC2758wp;
            float floatValue = f.floatValue();
            if (abstractC2758wp2.Wwwwwwwwwwwwwwwwwwww != floatValue) {
                abstractC2758wp2.Wwwwwwwwwwwwwwwwwwww = floatValue;
                abstractC2758wp2.invalidateSelf();
            }
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z = this.Wwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwww = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.Wwwwwwwwwwwwwwwwwwwww = z;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2, boolean z3) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, Wwwwwwwwwwwwwwwwww, 0.0f, 1.0f);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = ofFloat;
            ofFloat.setDuration(500L);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            ValueAnimator valueAnimator = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = valueAnimator;
            valueAnimator.addListener(new C2680up(this));
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwww == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, Wwwwwwwwwwwwwwwwww, 1.0f, 0.0f);
            this.Wwwwwwwwwwwwwwwwwwwwwww = ofFloat2;
            ofFloat2.setDuration(500L);
            this.Wwwwwwwwwwwwwwwwwwwwwww.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            ValueAnimator valueAnimator2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = valueAnimator2;
            valueAnimator2.addListener(new C2721vp(this));
        }
        if (isVisible() || z) {
            ValueAnimator valueAnimator3 = z ? this.Wwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (!z3) {
                if (valueAnimator3.isRunning()) {
                    valueAnimator3.end();
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(valueAnimator3);
                }
                return super.setVisible(z, false);
            } else if (z3 && valueAnimator3.isRunning()) {
                return false;
            } else {
                if (z) {
                    super.setVisible(z, false);
                }
                throw null;
            }
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        this.Wwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwww = null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.Wwwwwwwwwwwwwwwwwww;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ValueAnimator valueAnimator = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (!(valueAnimator != null && valueAnimator.isRunning())) {
            ValueAnimator valueAnimator2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            return valueAnimator2 != null && valueAnimator2.isRunning();
        }
        return true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (this.Wwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        }
        if (!this.Wwwwwwwwwwwwwwwwwwwwww.contains(animationCallback)) {
            this.Wwwwwwwwwwwwwwwwwwwwww.add(animationCallback);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.Wwwwwwwwwwwwwwwwwww = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        throw null;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, true, false);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, true, false);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (list == null || !list.contains(animationCallback)) {
            return false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww.remove(animationCallback);
        if (!this.Wwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            return true;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = null;
        return true;
    }
}

package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.ArrayList;

@RequiresApi(21)
/* renamed from: me.tvspark.ep */
/* loaded from: classes4.dex */
public class C2082ep extends C1954bp {

    /* renamed from: me.tvspark.ep$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends MaterialShapeDrawable {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2416nq c2416nq) {
            super(c2416nq);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    public C2082ep(FloatingActionButton floatingActionButton, AbstractC2046dq abstractC2046dq) {
        super(floatingActionButton, abstractC2046dq);
    }

    @Override // me.tvspark.C1954bp
    public void Wwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.C1954bp
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        return FloatingActionButton.this.Wwwwwwwwwwwww || !Wwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.C1954bp
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return false;
    }

    @Override // me.tvspark.C1954bp
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.C1954bp
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.C1954bp
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwww.getElevation();
    }

    @NonNull
    public final Animator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.Wwwwwwwwww, Key.ELEVATION, f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.Wwwwwwwwww, View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(C1954bp.Www);
        return animatorSet;
    }

    @Override // me.tvspark.C1954bp
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3) {
        if (Build.VERSION.SDK_INT == 21) {
            this.Wwwwwwwwww.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(C1954bp.Kkkkkkkkkkkkkkkkkkkkkkkkkk, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, f3));
            stateListAnimator.addState(C1954bp.Kkkkkkkkkkkkkkkkkkkkkkkkk, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, f2));
            stateListAnimator.addState(C1954bp.Kkkkkkkkkkkkkkkkkkkkkkkk, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, f2));
            stateListAnimator.addState(C1954bp.Kkkkkkkkkkkkkkkkkkkkkkk, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.Wwwwwwwwww, Key.ELEVATION, f).setDuration(0L));
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 24) {
                FloatingActionButton floatingActionButton = this.Wwwwwwwwww;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.Wwwwwwwwww, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(C1954bp.Www);
            stateListAnimator.addState(C1954bp.Kkkkkkkkkkkkkkkkkkkkkk, animatorSet);
            stateListAnimator.addState(C1954bp.Kkkkkkkkkkkkkkkkkkkkk, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 0.0f));
            this.Wwwwwwwwww.setStateListAnimator(stateListAnimator);
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.C1954bp
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Rect rect) {
        if (FloatingActionButton.this.Wwwwwwwwwwwww) {
            super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rect);
            return;
        }
        int sizeDimension = !Wwwwwwwwwwwwwwwwwwwwwwww() ? (this.Wwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwww.getSizeDimension()) / 2 : 0;
        rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
    }

    @Override // me.tvspark.C1954bp
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr) {
        FloatingActionButton floatingActionButton;
        if (Build.VERSION.SDK_INT == 21) {
            float f = 0.0f;
            if (this.Wwwwwwwwww.isEnabled()) {
                this.Wwwwwwwwww.setElevation(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (this.Wwwwwwwwww.isPressed()) {
                    floatingActionButton = this.Wwwwwwwwww;
                    f = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                } else if (this.Wwwwwwwwww.isFocused() || this.Wwwwwwwwww.isHovered()) {
                    floatingActionButton = this.Wwwwwwwwww;
                    f = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                floatingActionButton.setTranslationZ(f);
            }
            this.Wwwwwwwwww.setElevation(0.0f);
            floatingActionButton = this.Wwwwwwwwww;
            floatingActionButton.setTranslationZ(f);
        }
    }

    @Override // me.tvspark.C1954bp
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable drawable;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2416nq) Preconditions.checkNotNull(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTintList(colorStateList);
        if (mode != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTintMode(mode);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww.getContext());
        if (i > 0) {
            Context context = this.Wwwwwwwwww.getContext();
            C2757wo c2757wo = new C2757wo((C2416nq) Preconditions.checkNotNull(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            int color = ContextCompat.getColor(context, com.google.android.material.R$color.design_fab_stroke_top_outer_color);
            int color2 = ContextCompat.getColor(context, com.google.android.material.R$color.design_fab_stroke_top_inner_color);
            int color3 = ContextCompat.getColor(context, com.google.android.material.R$color.design_fab_stroke_end_inner_color);
            int color4 = ContextCompat.getColor(context, com.google.android.material.R$color.design_fab_stroke_end_outer_color);
            c2757wo.Wwwwwwwwwwwwwwwwwwwwwwwwww = color;
            c2757wo.Wwwwwwwwwwwwwwwwwwwwwwwww = color2;
            c2757wo.Wwwwwwwwwwwwwwwwwwwwwwww = color3;
            c2757wo.Wwwwwwwwwwwwwwwwwwwwwww = color4;
            float f = i;
            if (c2757wo.Wwwwwwwwwwwwwwwwwwwwwwwwwww != f) {
                c2757wo.Wwwwwwwwwwwwwwwwwwwwwwwwwww = f;
                c2757wo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setStrokeWidth(f * 1.3333f);
                c2757wo.Wwwwwwwwwwwwwwwwwwwww = true;
                c2757wo.invalidateSelf();
            }
            c2757wo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2757wo;
            drawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), (Drawable) Preconditions.checkNotNull(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)});
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            drawable = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList2), drawable, null);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = rippleDrawable;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = rippleDrawable;
    }

    @Override // me.tvspark.C1954bp
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList));
        } else if (drawable == null) {
        } else {
            DrawableCompat.setTintList(drawable, C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList));
        }
    }
}

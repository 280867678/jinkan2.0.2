package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.bt */
/* loaded from: classes4.dex */
public final class C1958bt implements AbstractC2086et {
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1.0f;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1.1f;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0.8f;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1.0f;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;

    /* renamed from: me.tvspark.bt$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AnimatorListenerAdapter {
        public final /* synthetic */ float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, float f, float f2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setScaleX(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setScaleY(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public static Animator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, float f, float f2) {
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.SCALE_X, scaleX * f, scaleX * f2), PropertyValuesHolder.ofFloat(View.SCALE_Y, f * scaleY, f2 * scaleY));
        ofPropertyValuesHolder.addListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, scaleX, scaleY));
        return ofPropertyValuesHolder;
    }

    @Override // me.tvspark.AbstractC2086et
    @Nullable
    public Animator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float f;
        float f2;
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return null;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            f = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            f2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            f = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            f2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, f, f2);
    }

    @Override // me.tvspark.AbstractC2086et
    @Nullable
    public Animator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float f;
        float f2;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            f = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            f2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            f = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            f2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, f, f2);
    }
}

package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.us */
/* loaded from: classes4.dex */
public final class C2683us implements AbstractC2086et {
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1.0f;

    /* renamed from: me.tvspark.us$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AnimatorListenerAdapter {
        public final /* synthetic */ float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, float f) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAlpha(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* renamed from: me.tvspark.us$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, float f, float f2, float f3, float f4) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAlpha(C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    public static Animator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, float f, float f2, @FloatRange(from = 0.0d, m4213to = 1.0d) float f3, @FloatRange(from = 0.0d, m4213to = 1.0d) float f4, float f5) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, f, f2, f3, f4));
        ofFloat.addListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, f5));
        return ofFloat;
    }

    @Override // me.tvspark.AbstractC2086et
    @Nullable
    public Animator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, alpha, 0.0f, 0.0f, 1.0f, alpha);
    }

    @Override // me.tvspark.AbstractC2086et
    @Nullable
    public Animator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, 0.0f, alpha, 0.0f, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, alpha);
    }
}

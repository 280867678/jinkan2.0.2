package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: me.tvspark.kp */
/* loaded from: classes4.dex */
public final class C2304kp {
    public final ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList<>();
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    @Nullable
    public ValueAnimator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public final Animator.AnimatorListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: me.tvspark.kp$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final ValueAnimator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr, ValueAnimator valueAnimator) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = valueAnimator;
        }
    }

    /* renamed from: me.tvspark.kp$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AnimatorListenerAdapter {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C2304kp c2304kp = C2304kp.this;
            if (c2304kp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == animator) {
                c2304kp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            }
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr, ValueAnimator valueAnimator) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr, valueAnimator);
        valueAnimator.addListener(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}

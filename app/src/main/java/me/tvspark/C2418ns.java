package me.tvspark;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.transformation.FabTransformationBehavior;

/* renamed from: me.tvspark.ns */
/* loaded from: classes4.dex */
public class C2418ns implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2418ns(FabTransformationBehavior fabTransformationBehavior, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.invalidate();
    }
}

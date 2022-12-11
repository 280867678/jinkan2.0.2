package me.tvspark;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: me.tvspark.tm */
/* loaded from: classes4.dex */
public class C2640tm implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ AppBarLayout.BaseBehavior Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ AppBarLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ CoordinatorLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2640tm(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = baseBehavior;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = coordinatorLayout;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = appBarLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}

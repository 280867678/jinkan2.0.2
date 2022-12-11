package com.lzf.easyfloat.anim;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import com.arialyy.aria.core.inf.IOptionConstant;
import com.lzf.easyfloat.enums.SidePattern;
import com.lzf.easyfloat.interfaces.OnAppFloatAnimator;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes3.dex */
public class AppFloatDefaultAnimator implements OnAppFloatAnimator {
    private final int initValue(View view, WindowManager.LayoutParams layoutParams, WindowManager windowManager) {
        Rect rect = new Rect();
        windowManager.getDefaultDisplay().getRectSize(rect);
        int i = layoutParams.x;
        return i < rect.right - (view.getRight() + i) ? -view.getRight() : rect.right;
    }

    @Override // com.lzf.easyfloat.interfaces.OnAppFloatAnimator
    public Animator enterAnim(final View view, final WindowManager.LayoutParams layoutParams, final WindowManager windowManager, SidePattern sidePattern) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, "view");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(layoutParams, IOptionConstant.params);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(windowManager, "windowManager");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sidePattern, "sidePattern");
        ValueAnimator ofInt = ValueAnimator.ofInt(initValue(view, layoutParams, windowManager), layoutParams.x);
        ofInt.setDuration(500L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lzf.easyfloat.anim.AppFloatDefaultAnimator$enterAnim$$inlined$apply$lambda$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WindowManager.LayoutParams layoutParams2 = layoutParams;
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) valueAnimator, "it");
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue != null) {
                    layoutParams2.x = ((Integer) animatedValue).intValue();
                    windowManager.updateViewLayout(view, layoutParams);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
        });
        return ofInt;
    }

    @Override // com.lzf.easyfloat.interfaces.OnAppFloatAnimator
    public Animator exitAnim(final View view, final WindowManager.LayoutParams layoutParams, final WindowManager windowManager, SidePattern sidePattern) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, "view");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(layoutParams, IOptionConstant.params);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(windowManager, "windowManager");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sidePattern, "sidePattern");
        ValueAnimator ofInt = ValueAnimator.ofInt(layoutParams.x, initValue(view, layoutParams, windowManager));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lzf.easyfloat.anim.AppFloatDefaultAnimator$exitAnim$$inlined$apply$lambda$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WindowManager.LayoutParams layoutParams2 = layoutParams;
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) valueAnimator, "it");
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue != null) {
                    layoutParams2.x = ((Integer) animatedValue).intValue();
                    windowManager.updateViewLayout(view, layoutParams);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
        });
        return ofInt;
    }
}

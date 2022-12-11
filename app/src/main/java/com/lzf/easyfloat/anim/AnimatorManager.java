package com.lzf.easyfloat.anim;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.lzf.easyfloat.enums.SidePattern;
import com.lzf.easyfloat.interfaces.OnFloatAnimator;
import me.tvspark.ef0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes3.dex */
public final class AnimatorManager {
    public final OnFloatAnimator onFloatAnimator;
    public final ViewGroup parentView;
    public final SidePattern sidePattern;
    public final View view;

    public AnimatorManager(OnFloatAnimator onFloatAnimator, View view, ViewGroup viewGroup, SidePattern sidePattern) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, "view");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, "parentView");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sidePattern, "sidePattern");
        this.onFloatAnimator = onFloatAnimator;
        this.view = view;
        this.parentView = viewGroup;
        this.sidePattern = sidePattern;
    }

    public final Animator enterAnim() {
        OnFloatAnimator onFloatAnimator = this.onFloatAnimator;
        if (onFloatAnimator != null) {
            return onFloatAnimator.enterAnim(this.view, this.parentView, this.sidePattern);
        }
        return null;
    }

    public final Animator exitAnim() {
        OnFloatAnimator onFloatAnimator = this.onFloatAnimator;
        if (onFloatAnimator != null) {
            return onFloatAnimator.exitAnim(this.view, this.parentView, this.sidePattern);
        }
        return null;
    }
}

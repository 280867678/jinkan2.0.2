package com.lzf.easyfloat.interfaces;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.lzf.easyfloat.enums.SidePattern;
import me.tvspark.ef0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes3.dex */
public interface OnFloatAnimator {

    @ef0
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static Animator enterAnim(OnFloatAnimator onFloatAnimator, View view, ViewGroup viewGroup, SidePattern sidePattern) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, "view");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, "parentView");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sidePattern, "sidePattern");
            return null;
        }

        public static Animator exitAnim(OnFloatAnimator onFloatAnimator, View view, ViewGroup viewGroup, SidePattern sidePattern) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, "view");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, "parentView");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sidePattern, "sidePattern");
            return null;
        }
    }

    Animator enterAnim(View view, ViewGroup viewGroup, SidePattern sidePattern);

    Animator exitAnim(View view, ViewGroup viewGroup, SidePattern sidePattern);
}

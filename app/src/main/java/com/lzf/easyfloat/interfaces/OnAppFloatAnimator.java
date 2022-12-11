package com.lzf.easyfloat.interfaces;

import android.animation.Animator;
import android.view.View;
import android.view.WindowManager;
import com.arialyy.aria.core.inf.IOptionConstant;
import com.lzf.easyfloat.enums.SidePattern;
import me.tvspark.ef0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes3.dex */
public interface OnAppFloatAnimator {

    @ef0
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static Animator enterAnim(OnAppFloatAnimator onAppFloatAnimator, View view, WindowManager.LayoutParams layoutParams, WindowManager windowManager, SidePattern sidePattern) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, "view");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(layoutParams, IOptionConstant.params);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(windowManager, "windowManager");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sidePattern, "sidePattern");
            return null;
        }

        public static Animator exitAnim(OnAppFloatAnimator onAppFloatAnimator, View view, WindowManager.LayoutParams layoutParams, WindowManager windowManager, SidePattern sidePattern) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, "view");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(layoutParams, IOptionConstant.params);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(windowManager, "windowManager");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sidePattern, "sidePattern");
            return null;
        }
    }

    Animator enterAnim(View view, WindowManager.LayoutParams layoutParams, WindowManager windowManager, SidePattern sidePattern);

    Animator exitAnim(View view, WindowManager.LayoutParams layoutParams, WindowManager windowManager, SidePattern sidePattern);
}

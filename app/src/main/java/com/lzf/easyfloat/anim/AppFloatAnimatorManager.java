package com.lzf.easyfloat.anim;

import android.animation.Animator;
import android.view.View;
import android.view.WindowManager;
import com.arialyy.aria.core.inf.IOptionConstant;
import com.lzf.easyfloat.data.FloatConfig;
import com.lzf.easyfloat.interfaces.OnAppFloatAnimator;
import me.tvspark.ef0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes3.dex */
public final class AppFloatAnimatorManager {
    public final FloatConfig config;
    public final WindowManager.LayoutParams params;
    public final View view;
    public final WindowManager windowManager;

    public AppFloatAnimatorManager(View view, WindowManager.LayoutParams layoutParams, WindowManager windowManager, FloatConfig floatConfig) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, "view");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(layoutParams, IOptionConstant.params);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(windowManager, "windowManager");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatConfig, "config");
        this.view = view;
        this.params = layoutParams;
        this.windowManager = windowManager;
        this.config = floatConfig;
    }

    public final Animator enterAnim() {
        OnAppFloatAnimator appFloatAnimator = this.config.getAppFloatAnimator();
        if (appFloatAnimator != null) {
            return appFloatAnimator.enterAnim(this.view, this.params, this.windowManager, this.config.getSidePattern());
        }
        return null;
    }

    public final Animator exitAnim() {
        OnAppFloatAnimator appFloatAnimator = this.config.getAppFloatAnimator();
        if (appFloatAnimator != null) {
            return appFloatAnimator.exitAnim(this.view, this.params, this.windowManager, this.config.getSidePattern());
        }
        return null;
    }
}

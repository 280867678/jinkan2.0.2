package com.lzf.easyfloat.widget.activityfloat;

import android.app.Activity;
import android.content.ComponentName;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActivityChooserModel;
import com.lzf.easyfloat.data.FloatConfig;
import com.lzf.easyfloat.interfaces.FloatCallbacks;
import com.lzf.easyfloat.interfaces.OnFloatCallbacks;
import kotlin.Pair;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.nh0;
import me.tvspark.of0;

@ef0
/* loaded from: classes3.dex */
public final class ActivityFloatManager {
    public final Activity activity;
    public FrameLayout parentFrame;

    public ActivityFloatManager(Activity activity) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.activity = activity;
        Window window = activity.getWindow();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) window, "activity.window");
        View findViewById = window.getDecorView().findViewById(16908290);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) findViewById, "activity.window.decorVie…yId(android.R.id.content)");
        this.parentFrame = (FrameLayout) findViewById;
    }

    private final FloatingView floatingView(String str) {
        return (FloatingView) this.parentFrame.findViewWithTag(getTag(str));
    }

    public static /* synthetic */ View getFloatView$default(ActivityFloatManager activityFloatManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return activityFloatManager.getFloatView(str);
    }

    private final String getTag(String str) {
        if (str != null) {
            return str;
        }
        ComponentName componentName = this.activity.getComponentName();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) componentName, "activity.componentName");
        return componentName.getClassName();
    }

    public static /* synthetic */ boolean isShow$default(ActivityFloatManager activityFloatManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return activityFloatManager.isShow(str);
    }

    public static /* synthetic */ void setDragEnable$default(ActivityFloatManager activityFloatManager, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        activityFloatManager.setDragEnable(z, str);
    }

    public final void createFloat(FloatConfig floatConfig) {
        FloatCallbacks.Builder builder;
        nh0<Boolean, String, View, of0> createdResult$easyfloat_release;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatConfig, "config");
        FloatingView floatingView = new FloatingView(this.activity, null, 2, null);
        floatingView.setTag(getTag(floatConfig.getFloatTag()));
        int i = -1;
        int i2 = floatConfig.getWidthMatch() ? -1 : -2;
        if (!floatConfig.getHeightMatch()) {
            i = -2;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i);
        if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatConfig.getLocationPair(), new Pair(0, 0))) {
            layoutParams.gravity = floatConfig.getGravity();
        }
        floatingView.setLayoutParams(layoutParams);
        floatingView.setFloatConfig(floatConfig);
        this.parentFrame.addView(floatingView);
        floatConfig.setLayoutView(floatingView);
        OnFloatCallbacks callbacks = floatConfig.getCallbacks();
        if (callbacks != null) {
            callbacks.createdResult(true, null, floatingView);
        }
        FloatCallbacks floatCallbacks = floatConfig.getFloatCallbacks();
        if (floatCallbacks == null || (builder = floatCallbacks.getBuilder()) == null || (createdResult$easyfloat_release = builder.getCreatedResult$easyfloat_release()) == null) {
            return;
        }
        createdResult$easyfloat_release.invoke(true, null, floatingView);
    }

    public final of0 dismiss(String str) {
        FloatingView floatingView = floatingView(str);
        if (floatingView != null) {
            floatingView.exitAnim$easyfloat_release();
            return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final View getFloatView(String str) {
        FloatConfig config;
        FloatingView floatingView = floatingView(str);
        if (floatingView == null || (config = floatingView.getConfig()) == null) {
            return null;
        }
        return config.getLayoutView();
    }

    public final boolean isShow(String str) {
        FloatingView floatingView = floatingView(str);
        return floatingView != null && floatingView.getVisibility() == 0;
    }

    public final void setDragEnable(boolean z, String str) {
        FloatConfig config;
        FloatingView floatingView = floatingView(str);
        if (floatingView == null || (config = floatingView.getConfig()) == null) {
            return;
        }
        config.setDragEnable(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [me.tvspark.ih0] */
    public final FloatingView setVisibility(String str, int i) {
        FloatCallbacks.Builder builder;
        ih0<View, of0> show$easyfloat_release;
        FloatCallbacks.Builder builder2;
        FloatingView floatingView = floatingView(str);
        if (floatingView != null) {
            floatingView.setVisibility(i);
            if (i == 8) {
                OnFloatCallbacks callbacks = floatingView.getConfig().getCallbacks();
                if (callbacks != null) {
                    callbacks.hide(floatingView);
                }
                FloatCallbacks floatCallbacks = floatingView.getConfig().getFloatCallbacks();
                if (floatCallbacks == null || (builder2 = floatCallbacks.getBuilder()) == null || (show$easyfloat_release = builder2.getHide$easyfloat_release()) == null) {
                    return floatingView;
                }
            } else {
                OnFloatCallbacks callbacks2 = floatingView.getConfig().getCallbacks();
                if (callbacks2 != null) {
                    callbacks2.show(floatingView);
                }
                FloatCallbacks floatCallbacks2 = floatingView.getConfig().getFloatCallbacks();
                if (floatCallbacks2 == null || (builder = floatCallbacks2.getBuilder()) == null || (show$easyfloat_release = builder.getShow$easyfloat_release()) == null) {
                    return floatingView;
                }
            }
            show$easyfloat_release.mo4916invoke(floatingView);
            return floatingView;
        }
        return null;
    }
}

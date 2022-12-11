package com.lzf.easyfloat.widget.appfloat;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import com.arialyy.aria.core.inf.IOptionConstant;
import com.lzf.easyfloat.anim.AppFloatAnimatorManager;
import com.lzf.easyfloat.data.FloatConfig;
import com.lzf.easyfloat.enums.ShowPattern;
import com.lzf.easyfloat.interfaces.FloatCallbacks;
import com.lzf.easyfloat.interfaces.OnFloatCallbacks;
import com.lzf.easyfloat.interfaces.OnFloatTouchListener;
import com.lzf.easyfloat.interfaces.OnInvokeView;
import com.lzf.easyfloat.utils.DisplayUtils;
import com.lzf.easyfloat.utils.LifecycleUtils;
import com.lzf.easyfloat.utils.Logger;
import com.lzf.easyfloat.widget.appfloat.ParentFrameLayout;
import com.p038qq.p039e.comm.constants.ErrorCode;
import com.umeng.analytics.pro.C1615d;
import kotlin.Pair;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.nh0;
import me.tvspark.of0;

@ef0
/* loaded from: classes3.dex */
public final class AppFloatManager {
    public FloatConfig config;
    public final Context context;
    public ParentFrameLayout frameLayout;
    public WindowManager.LayoutParams params;
    public TouchUtils touchUtils;
    public WindowManager windowManager;

    public AppFloatManager(Context context, FloatConfig floatConfig) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatConfig, "config");
        this.context = context;
        this.config = floatConfig;
    }

    public static final /* synthetic */ TouchUtils access$getTouchUtils$p(AppFloatManager appFloatManager) {
        TouchUtils touchUtils = appFloatManager.touchUtils;
        if (touchUtils != null) {
            return touchUtils;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("touchUtils");
        throw null;
    }

    private final void addView() {
        ParentFrameLayout parentFrameLayout = new ParentFrameLayout(this.context, this.config, null, 0, 12, null);
        this.frameLayout = parentFrameLayout;
        if (parentFrameLayout != null) {
            parentFrameLayout.setTag(this.config.getFloatTag());
        }
        LayoutInflater from = LayoutInflater.from(this.context);
        Integer layoutId = this.config.getLayoutId();
        if (layoutId == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        final View inflate = from.inflate(layoutId.intValue(), (ViewGroup) this.frameLayout, true);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) inflate, "floatingView");
        inflate.setVisibility(4);
        WindowManager windowManager = this.windowManager;
        if (windowManager == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("windowManager");
            throw null;
        }
        ParentFrameLayout parentFrameLayout2 = this.frameLayout;
        WindowManager.LayoutParams layoutParams = this.params;
        if (layoutParams == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
            throw null;
        }
        windowManager.addView(parentFrameLayout2, layoutParams);
        ParentFrameLayout parentFrameLayout3 = this.frameLayout;
        if (parentFrameLayout3 != null) {
            parentFrameLayout3.setTouchListener(new OnFloatTouchListener() { // from class: com.lzf.easyfloat.widget.appfloat.AppFloatManager$addView$1
                @Override // com.lzf.easyfloat.interfaces.OnFloatTouchListener
                public void onTouch(MotionEvent motionEvent) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(motionEvent, NotificationCompat.CATEGORY_EVENT);
                    TouchUtils access$getTouchUtils$p = AppFloatManager.access$getTouchUtils$p(AppFloatManager.this);
                    ParentFrameLayout frameLayout = AppFloatManager.this.getFrameLayout();
                    if (frameLayout != null) {
                        access$getTouchUtils$p.updateFloat(frameLayout, motionEvent, AppFloatManager.this.getWindowManager(), AppFloatManager.this.getParams());
                    } else {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                }
            });
        }
        ParentFrameLayout parentFrameLayout4 = this.frameLayout;
        if (parentFrameLayout4 == null) {
            return;
        }
        parentFrameLayout4.setLayoutListener(new ParentFrameLayout.OnLayoutListener() { // from class: com.lzf.easyfloat.widget.appfloat.AppFloatManager$addView$2
            @Override // com.lzf.easyfloat.widget.appfloat.ParentFrameLayout.OnLayoutListener
            public void onLayout() {
                FloatCallbacks.Builder builder;
                nh0<Boolean, String, View, of0> createdResult$easyfloat_release;
                AppFloatManager appFloatManager = AppFloatManager.this;
                appFloatManager.setGravity(appFloatManager.getFrameLayout());
                FloatConfig config = AppFloatManager.this.getConfig();
                if (config.getFilterSelf$easyfloat_release() || ((config.getShowPattern() == ShowPattern.BACKGROUND && LifecycleUtils.INSTANCE.isForeground()) || (config.getShowPattern() == ShowPattern.FOREGROUND && !LifecycleUtils.INSTANCE.isForeground()))) {
                    AppFloatManager.setVisible$default(AppFloatManager.this, 8, false, 2, null);
                } else {
                    AppFloatManager appFloatManager2 = AppFloatManager.this;
                    View view = inflate;
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) view, "floatingView");
                    appFloatManager2.enterAnim(view);
                }
                config.setLayoutView(inflate);
                OnInvokeView invokeView = config.getInvokeView();
                if (invokeView != null) {
                    invokeView.invoke(inflate);
                }
                OnFloatCallbacks callbacks = config.getCallbacks();
                if (callbacks != null) {
                    callbacks.createdResult(true, null, inflate);
                }
                FloatCallbacks floatCallbacks = config.getFloatCallbacks();
                if (floatCallbacks == null || (builder = floatCallbacks.getBuilder()) == null || (createdResult$easyfloat_release = builder.getCreatedResult$easyfloat_release()) == null) {
                    return;
                }
                createdResult$easyfloat_release.invoke(true, null, inflate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enterAnim(final View view) {
        if (this.frameLayout == null || this.config.isAnim()) {
            return;
        }
        ParentFrameLayout parentFrameLayout = this.frameLayout;
        if (parentFrameLayout == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        WindowManager.LayoutParams layoutParams = this.params;
        if (layoutParams == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
            throw null;
        }
        WindowManager windowManager = this.windowManager;
        if (windowManager == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("windowManager");
            throw null;
        }
        Animator enterAnim = new AppFloatAnimatorManager(parentFrameLayout, layoutParams, windowManager, this.config).enterAnim();
        if (enterAnim != null) {
            WindowManager.LayoutParams layoutParams2 = this.params;
            if (layoutParams2 == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
                throw null;
            }
            layoutParams2.flags = 552;
            enterAnim.addListener(new Animator.AnimatorListener() { // from class: com.lzf.easyfloat.widget.appfloat.AppFloatManager$enterAnim$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AppFloatManager.this.getConfig().setAnim(false);
                    AppFloatManager.this.getParams().flags = 40;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    view.setVisibility(0);
                    AppFloatManager.this.getConfig().setAnim(true);
                }
            });
            enterAnim.start();
            return;
        }
        view.setVisibility(0);
        WindowManager windowManager2 = this.windowManager;
        if (windowManager2 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("windowManager");
            throw null;
        }
        WindowManager.LayoutParams layoutParams3 = this.params;
        if (layoutParams3 != null) {
            windowManager2.updateViewLayout(view, layoutParams3);
        } else {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void floatOver() {
        try {
            this.config.setAnim(false);
            FloatManager.INSTANCE.remove(this.config.getFloatTag());
            WindowManager windowManager = this.windowManager;
            if (windowManager != null) {
                windowManager.removeView(this.frameLayout);
            } else {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("windowManager");
                throw null;
            }
        } catch (Exception e) {
            Logger logger = Logger.INSTANCE;
            logger.m3697e("浮窗关闭出现异常：" + e);
        }
    }

    private final void initParams() {
        Object systemService = this.context.getSystemService("window");
        if (systemService != null) {
            this.windowManager = (WindowManager) systemService;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = Build.VERSION.SDK_INT >= 26 ? 2038 : ErrorCode.INNER_ERROR;
            layoutParams.format = 1;
            layoutParams.gravity = 8388659;
            layoutParams.flags = 40;
            int i = -1;
            layoutParams.width = this.config.getWidthMatch() ? -1 : -2;
            if (!this.config.getHeightMatch()) {
                i = -2;
            }
            layoutParams.height = i;
            if (true ^ ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.config.getLocationPair(), new Pair(0, 0))) {
                layoutParams.x = this.config.getLocationPair().getFirst().intValue();
                layoutParams.y = this.config.getLocationPair().getSecond().intValue();
            }
            this.params = layoutParams;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013f  */
    @SuppressLint({"RtlHardcoded"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setGravity(View view) {
        WindowManager.LayoutParams layoutParams;
        WindowManager.LayoutParams layoutParams2;
        int width;
        WindowManager.LayoutParams layoutParams3;
        int height;
        if ((!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.config.getLocationPair(), new Pair(0, 0))) || view == null) {
            return;
        }
        Rect rect = new Rect();
        WindowManager windowManager = this.windowManager;
        if (windowManager == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("windowManager");
            throw null;
        }
        windowManager.getDefaultDisplay().getRectSize(rect);
        int statusBarHeight = rect.bottom - DisplayUtils.INSTANCE.statusBarHeight(view);
        switch (this.config.getGravity()) {
            case 1:
            case 49:
                layoutParams2 = this.params;
                if (layoutParams2 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
                    throw null;
                }
                width = (rect.right - view.getWidth()) >> 1;
                layoutParams2.x = width;
                layoutParams = this.params;
                if (layoutParams == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
                    throw null;
                }
                layoutParams.x = this.config.getOffsetPair().getFirst().intValue() + layoutParams.x;
                WindowManager.LayoutParams layoutParams4 = this.params;
                if (layoutParams4 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
                    throw null;
                }
                layoutParams4.y = this.config.getOffsetPair().getSecond().intValue() + layoutParams4.y;
                WindowManager windowManager2 = this.windowManager;
                if (windowManager2 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("windowManager");
                    throw null;
                }
                WindowManager.LayoutParams layoutParams5 = this.params;
                if (layoutParams5 != null) {
                    windowManager2.updateViewLayout(view, layoutParams5);
                    return;
                } else {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
                    throw null;
                }
            case 5:
            case 53:
            case 8388613:
            case 8388661:
                layoutParams2 = this.params;
                if (layoutParams2 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
                    throw null;
                }
                width = rect.right - view.getWidth();
                layoutParams2.x = width;
                layoutParams = this.params;
                if (layoutParams == null) {
                }
                break;
            case 16:
            case 19:
            case 8388627:
                layoutParams3 = this.params;
                if (layoutParams3 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
                    throw null;
                }
                height = (statusBarHeight - view.getHeight()) >> 1;
                layoutParams3.y = height;
                layoutParams = this.params;
                if (layoutParams == null) {
                }
                break;
            case 17:
                WindowManager.LayoutParams layoutParams6 = this.params;
                if (layoutParams6 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
                    throw null;
                }
                layoutParams6.x = (rect.right - view.getWidth()) >> 1;
                layoutParams3 = this.params;
                if (layoutParams3 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
                    throw null;
                }
                height = (statusBarHeight - view.getHeight()) >> 1;
                layoutParams3.y = height;
                layoutParams = this.params;
                if (layoutParams == null) {
                }
                break;
            case 21:
            case 8388629:
                WindowManager.LayoutParams layoutParams7 = this.params;
                if (layoutParams7 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
                    throw null;
                }
                layoutParams7.x = rect.right - view.getWidth();
                layoutParams3 = this.params;
                if (layoutParams3 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
                    throw null;
                }
                height = (statusBarHeight - view.getHeight()) >> 1;
                layoutParams3.y = height;
                layoutParams = this.params;
                if (layoutParams == null) {
                }
                break;
            case 80:
            case 83:
            case 8388691:
                layoutParams3 = this.params;
                if (layoutParams3 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
                    throw null;
                }
                height = statusBarHeight - view.getHeight();
                layoutParams3.y = height;
                layoutParams = this.params;
                if (layoutParams == null) {
                }
                break;
            case 81:
                WindowManager.LayoutParams layoutParams8 = this.params;
                if (layoutParams8 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
                    throw null;
                }
                layoutParams8.x = (rect.right - view.getWidth()) >> 1;
                layoutParams3 = this.params;
                if (layoutParams3 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
                    throw null;
                }
                height = statusBarHeight - view.getHeight();
                layoutParams3.y = height;
                layoutParams = this.params;
                if (layoutParams == null) {
                }
                break;
            case 85:
            case 8388693:
                WindowManager.LayoutParams layoutParams9 = this.params;
                if (layoutParams9 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
                    throw null;
                }
                layoutParams9.x = rect.right - view.getWidth();
                layoutParams3 = this.params;
                if (layoutParams3 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
                    throw null;
                }
                height = statusBarHeight - view.getHeight();
                layoutParams3.y = height;
                layoutParams = this.params;
                if (layoutParams == null) {
                }
                break;
            default:
                layoutParams = this.params;
                if (layoutParams == null) {
                }
                break;
        }
    }

    public static /* synthetic */ void setVisible$default(AppFloatManager appFloatManager, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        appFloatManager.setVisible(i, z);
    }

    public final of0 createFloat() {
        FloatCallbacks.Builder builder;
        nh0<Boolean, String, View, of0> createdResult$easyfloat_release;
        try {
            this.touchUtils = new TouchUtils(this.context, this.config);
            initParams();
            addView();
            this.config.setShow(true);
            return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } catch (Exception e) {
            OnFloatCallbacks callbacks = this.config.getCallbacks();
            if (callbacks != null) {
                callbacks.createdResult(false, String.valueOf(e), null);
            }
            FloatCallbacks floatCallbacks = this.config.getFloatCallbacks();
            if (floatCallbacks != null && (builder = floatCallbacks.getBuilder()) != null && (createdResult$easyfloat_release = builder.getCreatedResult$easyfloat_release()) != null) {
                return createdResult$easyfloat_release.invoke(false, String.valueOf(e), null);
            }
            return null;
        }
    }

    public final void exitAnim() {
        if (this.frameLayout == null || this.config.isAnim()) {
            return;
        }
        ParentFrameLayout parentFrameLayout = this.frameLayout;
        if (parentFrameLayout == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        WindowManager.LayoutParams layoutParams = this.params;
        if (layoutParams == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
            throw null;
        }
        WindowManager windowManager = this.windowManager;
        if (windowManager == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("windowManager");
            throw null;
        }
        Animator exitAnim = new AppFloatAnimatorManager(parentFrameLayout, layoutParams, windowManager, this.config).exitAnim();
        if (exitAnim == null) {
            floatOver();
            return;
        }
        WindowManager.LayoutParams layoutParams2 = this.params;
        if (layoutParams2 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
            throw null;
        }
        layoutParams2.flags = 552;
        exitAnim.addListener(new Animator.AnimatorListener() { // from class: com.lzf.easyfloat.widget.appfloat.AppFloatManager$exitAnim$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AppFloatManager.this.floatOver();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                AppFloatManager.this.getConfig().setAnim(true);
            }
        });
        exitAnim.start();
    }

    public final FloatConfig getConfig() {
        return this.config;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ParentFrameLayout getFrameLayout() {
        return this.frameLayout;
    }

    public final WindowManager.LayoutParams getParams() {
        WindowManager.LayoutParams layoutParams = this.params;
        if (layoutParams != null) {
            return layoutParams;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IOptionConstant.params);
        throw null;
    }

    public final WindowManager getWindowManager() {
        WindowManager windowManager = this.windowManager;
        if (windowManager != null) {
            return windowManager;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("windowManager");
        throw null;
    }

    public final void setConfig(FloatConfig floatConfig) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatConfig, "<set-?>");
        this.config = floatConfig;
    }

    public final void setFrameLayout(ParentFrameLayout parentFrameLayout) {
        this.frameLayout = parentFrameLayout;
    }

    public final void setParams(WindowManager.LayoutParams layoutParams) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(layoutParams, "<set-?>");
        this.params = layoutParams;
    }

    public final void setVisible(int i, boolean z) {
        FloatCallbacks.Builder builder;
        ih0<View, of0> hide$easyfloat_release;
        FloatCallbacks.Builder builder2;
        ParentFrameLayout parentFrameLayout = this.frameLayout;
        if (parentFrameLayout != null) {
            if (parentFrameLayout == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            } else if (parentFrameLayout.getChildCount() < 1) {
            } else {
                this.config.setNeedShow$easyfloat_release(z);
                ParentFrameLayout parentFrameLayout2 = this.frameLayout;
                if (parentFrameLayout2 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                parentFrameLayout2.setVisibility(i);
                ParentFrameLayout parentFrameLayout3 = this.frameLayout;
                if (parentFrameLayout3 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                View childAt = parentFrameLayout3.getChildAt(0);
                if (i == 0) {
                    this.config.setShow(true);
                    OnFloatCallbacks callbacks = this.config.getCallbacks();
                    if (callbacks != null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) childAt, "view");
                        callbacks.show(childAt);
                    }
                    FloatCallbacks floatCallbacks = this.config.getFloatCallbacks();
                    if (floatCallbacks == null || (builder2 = floatCallbacks.getBuilder()) == null || (hide$easyfloat_release = builder2.getShow$easyfloat_release()) == null) {
                        return;
                    }
                } else {
                    this.config.setShow(false);
                    OnFloatCallbacks callbacks2 = this.config.getCallbacks();
                    if (callbacks2 != null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) childAt, "view");
                        callbacks2.hide(childAt);
                    }
                    FloatCallbacks floatCallbacks2 = this.config.getFloatCallbacks();
                    if (floatCallbacks2 == null || (builder = floatCallbacks2.getBuilder()) == null || (hide$easyfloat_release = builder.getHide$easyfloat_release()) == null) {
                        return;
                    }
                }
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) childAt, "view");
                hide$easyfloat_release.mo4916invoke(childAt);
            }
        }
    }

    public final void setWindowManager(WindowManager windowManager) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(windowManager, "<set-?>");
        this.windowManager = windowManager;
    }
}

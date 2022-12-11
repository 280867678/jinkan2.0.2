package com.lzf.easyfloat.widget.appfloat;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import com.arialyy.aria.core.inf.IOptionConstant;
import com.lzf.easyfloat.data.FloatConfig;
import com.lzf.easyfloat.enums.SidePattern;
import com.lzf.easyfloat.interfaces.FloatCallbacks;
import com.lzf.easyfloat.interfaces.OnFloatCallbacks;
import com.lzf.easyfloat.utils.DisplayUtils;
import com.umeng.analytics.pro.C1615d;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.mh0;
import me.tvspark.of0;

@ef0
/* loaded from: classes3.dex */
public final class TouchUtils {
    public int bottomDistance;
    public final FloatConfig config;
    public final Context context;
    public int emptyHeight;
    public float lastX;
    public float lastY;
    public int leftDistance;
    public int minX;
    public int minY;
    public int parentHeight;
    public int parentWidth;
    public int rightDistance;
    public int topDistance;
    public Rect parentRect = new Rect();
    public final int[] location = new int[2];
    public boolean hasStatusBar = true;

    @ef0
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[SidePattern.values().length];
            $EnumSwitchMapping$0 = iArr;
            SidePattern sidePattern = SidePattern.LEFT;
            iArr[1] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            SidePattern sidePattern2 = SidePattern.RIGHT;
            iArr2[2] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            SidePattern sidePattern3 = SidePattern.TOP;
            iArr3[3] = 3;
            int[] iArr4 = $EnumSwitchMapping$0;
            SidePattern sidePattern4 = SidePattern.BOTTOM;
            iArr4[4] = 4;
            int[] iArr5 = $EnumSwitchMapping$0;
            SidePattern sidePattern5 = SidePattern.AUTO_HORIZONTAL;
            iArr5[5] = 5;
            int[] iArr6 = $EnumSwitchMapping$0;
            SidePattern sidePattern6 = SidePattern.AUTO_VERTICAL;
            iArr6[6] = 6;
            int[] iArr7 = $EnumSwitchMapping$0;
            SidePattern sidePattern7 = SidePattern.AUTO_SIDE;
            iArr7[7] = 7;
            int[] iArr8 = new int[SidePattern.values().length];
            $EnumSwitchMapping$1 = iArr8;
            SidePattern sidePattern8 = SidePattern.RESULT_LEFT;
            iArr8[8] = 1;
            int[] iArr9 = $EnumSwitchMapping$1;
            SidePattern sidePattern9 = SidePattern.RESULT_RIGHT;
            iArr9[9] = 2;
            int[] iArr10 = $EnumSwitchMapping$1;
            SidePattern sidePattern10 = SidePattern.RESULT_TOP;
            iArr10[10] = 3;
            int[] iArr11 = $EnumSwitchMapping$1;
            SidePattern sidePattern11 = SidePattern.RESULT_BOTTOM;
            iArr11[11] = 4;
            int[] iArr12 = $EnumSwitchMapping$1;
            SidePattern sidePattern12 = SidePattern.RESULT_HORIZONTAL;
            iArr12[12] = 5;
            int[] iArr13 = $EnumSwitchMapping$1;
            SidePattern sidePattern13 = SidePattern.RESULT_VERTICAL;
            iArr13[13] = 6;
            int[] iArr14 = $EnumSwitchMapping$1;
            SidePattern sidePattern14 = SidePattern.RESULT_SIDE;
            iArr14[14] = 7;
            int[] iArr15 = new int[SidePattern.values().length];
            $EnumSwitchMapping$2 = iArr15;
            SidePattern sidePattern15 = SidePattern.RESULT_LEFT;
            iArr15[8] = 1;
            int[] iArr16 = $EnumSwitchMapping$2;
            SidePattern sidePattern16 = SidePattern.RESULT_RIGHT;
            iArr16[9] = 2;
            int[] iArr17 = $EnumSwitchMapping$2;
            SidePattern sidePattern17 = SidePattern.RESULT_HORIZONTAL;
            iArr17[12] = 3;
            int[] iArr18 = $EnumSwitchMapping$2;
            SidePattern sidePattern18 = SidePattern.RESULT_TOP;
            iArr18[10] = 4;
            int[] iArr19 = $EnumSwitchMapping$2;
            SidePattern sidePattern19 = SidePattern.RESULT_BOTTOM;
            iArr19[11] = 5;
            int[] iArr20 = $EnumSwitchMapping$2;
            SidePattern sidePattern20 = SidePattern.RESULT_VERTICAL;
            iArr20[13] = 6;
            int[] iArr21 = $EnumSwitchMapping$2;
            SidePattern sidePattern21 = SidePattern.RESULT_SIDE;
            iArr21[14] = 7;
        }
    }

    public TouchUtils(Context context, FloatConfig floatConfig) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatConfig, "config");
        this.context = context;
        this.config = floatConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dragEnd(View view) {
        FloatCallbacks.Builder builder;
        ih0<View, of0> dragEnd$easyfloat_release;
        this.config.setAnim(false);
        OnFloatCallbacks callbacks = this.config.getCallbacks();
        if (callbacks != null) {
            callbacks.dragEnd(view);
        }
        FloatCallbacks floatCallbacks = this.config.getFloatCallbacks();
        if (floatCallbacks == null || (builder = floatCallbacks.getBuilder()) == null || (dragEnd$easyfloat_release = builder.getDragEnd$easyfloat_release()) == null) {
            return;
        }
        dragEnd$easyfloat_release.mo4916invoke(view);
    }

    private final void initDistanceValue(WindowManager.LayoutParams layoutParams, View view) {
        int i = layoutParams.x;
        this.leftDistance = i;
        this.rightDistance = this.parentWidth - (view.getRight() + i);
        int i2 = layoutParams.y;
        this.topDistance = i2;
        this.bottomDistance = this.hasStatusBar ? ((this.parentHeight - statusBarHeight(view)) - this.topDistance) - view.getHeight() : (this.parentHeight - i2) - view.getHeight();
        this.minX = Math.min(this.leftDistance, this.rightDistance);
        this.minY = Math.min(this.topDistance, this.bottomDistance);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0029, code lost:
        if (r9.hasStatusBar != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
        r0 = r9.emptyHeight;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
        r0 = r9.emptyHeight - statusBarHeight(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0035, code lost:
        if (r9.hasStatusBar != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003a, code lost:
        if (r9.hasStatusBar != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004e, code lost:
        if (r0 < r3) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r0 < r3) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0051, code lost:
        r0 = r11.x;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void sideAnim(final View view, final WindowManager.LayoutParams layoutParams, final WindowManager windowManager) {
        int i;
        int i2;
        final boolean z;
        initDistanceValue(layoutParams, view);
        switch (this.config.getSidePattern().ordinal()) {
            case 8:
                i = 0;
                z = true;
                int[] iArr = new int[2];
                iArr[0] = z ? layoutParams.x : layoutParams.y;
                iArr[1] = i;
                final ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lzf.easyfloat.widget.appfloat.TouchUtils$sideAnim$1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        try {
                            if (z) {
                                WindowManager.LayoutParams layoutParams2 = layoutParams;
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) valueAnimator, "it");
                                Object animatedValue = valueAnimator.getAnimatedValue();
                                if (animatedValue == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                                }
                                layoutParams2.x = ((Integer) animatedValue).intValue();
                            } else {
                                WindowManager.LayoutParams layoutParams3 = layoutParams;
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) valueAnimator, "it");
                                Object animatedValue2 = valueAnimator.getAnimatedValue();
                                if (animatedValue2 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                                }
                                layoutParams3.y = ((Integer) animatedValue2).intValue();
                            }
                            windowManager.updateViewLayout(view, layoutParams);
                        } catch (Exception unused) {
                            ofInt.cancel();
                        }
                    }
                });
                ofInt.addListener(new Animator.AnimatorListener() { // from class: com.lzf.easyfloat.widget.appfloat.TouchUtils$sideAnim$2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        TouchUtils.this.dragEnd(view);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        TouchUtils.this.dragEnd(view);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        TouchUtils.this.getConfig().setAnim(true);
                    }
                });
                ofInt.start();
                return;
            case 9:
                int i3 = layoutParams.x;
                i2 = this.rightDistance;
                i = i3 + i2;
                z = true;
                int[] iArr2 = new int[2];
                iArr2[0] = z ? layoutParams.x : layoutParams.y;
                iArr2[1] = i;
                final ValueAnimator ofInt2 = ValueAnimator.ofInt(iArr2);
                ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lzf.easyfloat.widget.appfloat.TouchUtils$sideAnim$1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        try {
                            if (z) {
                                WindowManager.LayoutParams layoutParams2 = layoutParams;
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) valueAnimator, "it");
                                Object animatedValue = valueAnimator.getAnimatedValue();
                                if (animatedValue == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                                }
                                layoutParams2.x = ((Integer) animatedValue).intValue();
                            } else {
                                WindowManager.LayoutParams layoutParams3 = layoutParams;
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) valueAnimator, "it");
                                Object animatedValue2 = valueAnimator.getAnimatedValue();
                                if (animatedValue2 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                                }
                                layoutParams3.y = ((Integer) animatedValue2).intValue();
                            }
                            windowManager.updateViewLayout(view, layoutParams);
                        } catch (Exception unused) {
                            ofInt2.cancel();
                        }
                    }
                });
                ofInt2.addListener(new Animator.AnimatorListener() { // from class: com.lzf.easyfloat.widget.appfloat.TouchUtils$sideAnim$2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        TouchUtils.this.dragEnd(view);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        TouchUtils.this.dragEnd(view);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        TouchUtils.this.getConfig().setAnim(true);
                    }
                });
                ofInt2.start();
                return;
            case 10:
                i = 0;
                z = false;
                int[] iArr22 = new int[2];
                iArr22[0] = z ? layoutParams.x : layoutParams.y;
                iArr22[1] = i;
                final ValueAnimator ofInt22 = ValueAnimator.ofInt(iArr22);
                ofInt22.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lzf.easyfloat.widget.appfloat.TouchUtils$sideAnim$1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        try {
                            if (z) {
                                WindowManager.LayoutParams layoutParams2 = layoutParams;
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) valueAnimator, "it");
                                Object animatedValue = valueAnimator.getAnimatedValue();
                                if (animatedValue == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                                }
                                layoutParams2.x = ((Integer) animatedValue).intValue();
                            } else {
                                WindowManager.LayoutParams layoutParams3 = layoutParams;
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) valueAnimator, "it");
                                Object animatedValue2 = valueAnimator.getAnimatedValue();
                                if (animatedValue2 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                                }
                                layoutParams3.y = ((Integer) animatedValue2).intValue();
                            }
                            windowManager.updateViewLayout(view, layoutParams);
                        } catch (Exception unused) {
                            ofInt22.cancel();
                        }
                    }
                });
                ofInt22.addListener(new Animator.AnimatorListener() { // from class: com.lzf.easyfloat.widget.appfloat.TouchUtils$sideAnim$2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        TouchUtils.this.dragEnd(view);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        TouchUtils.this.dragEnd(view);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        TouchUtils.this.getConfig().setAnim(true);
                    }
                });
                ofInt22.start();
                return;
            case 11:
                break;
            case 12:
                int i4 = this.leftDistance;
                i2 = this.rightDistance;
                break;
            case 13:
                if (this.topDistance >= this.bottomDistance) {
                    break;
                }
                i = 0;
                z = false;
                int[] iArr222 = new int[2];
                iArr222[0] = z ? layoutParams.x : layoutParams.y;
                iArr222[1] = i;
                final ValueAnimator ofInt222 = ValueAnimator.ofInt(iArr222);
                ofInt222.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lzf.easyfloat.widget.appfloat.TouchUtils$sideAnim$1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        try {
                            if (z) {
                                WindowManager.LayoutParams layoutParams2 = layoutParams;
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) valueAnimator, "it");
                                Object animatedValue = valueAnimator.getAnimatedValue();
                                if (animatedValue == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                                }
                                layoutParams2.x = ((Integer) animatedValue).intValue();
                            } else {
                                WindowManager.LayoutParams layoutParams3 = layoutParams;
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) valueAnimator, "it");
                                Object animatedValue2 = valueAnimator.getAnimatedValue();
                                if (animatedValue2 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                                }
                                layoutParams3.y = ((Integer) animatedValue2).intValue();
                            }
                            windowManager.updateViewLayout(view, layoutParams);
                        } catch (Exception unused) {
                            ofInt222.cancel();
                        }
                    }
                });
                ofInt222.addListener(new Animator.AnimatorListener() { // from class: com.lzf.easyfloat.widget.appfloat.TouchUtils$sideAnim$2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        TouchUtils.this.dragEnd(view);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        TouchUtils.this.dragEnd(view);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        TouchUtils.this.getConfig().setAnim(true);
                    }
                });
                ofInt222.start();
                return;
            case 14:
                if (this.minX >= this.minY) {
                    if (this.topDistance >= this.bottomDistance) {
                        break;
                    }
                    i = 0;
                    z = false;
                    int[] iArr2222 = new int[2];
                    iArr2222[0] = z ? layoutParams.x : layoutParams.y;
                    iArr2222[1] = i;
                    final ValueAnimator ofInt2222 = ValueAnimator.ofInt(iArr2222);
                    ofInt2222.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lzf.easyfloat.widget.appfloat.TouchUtils$sideAnim$1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            try {
                                if (z) {
                                    WindowManager.LayoutParams layoutParams2 = layoutParams;
                                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) valueAnimator, "it");
                                    Object animatedValue = valueAnimator.getAnimatedValue();
                                    if (animatedValue == null) {
                                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                                    }
                                    layoutParams2.x = ((Integer) animatedValue).intValue();
                                } else {
                                    WindowManager.LayoutParams layoutParams3 = layoutParams;
                                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) valueAnimator, "it");
                                    Object animatedValue2 = valueAnimator.getAnimatedValue();
                                    if (animatedValue2 == null) {
                                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                                    }
                                    layoutParams3.y = ((Integer) animatedValue2).intValue();
                                }
                                windowManager.updateViewLayout(view, layoutParams);
                            } catch (Exception unused) {
                                ofInt2222.cancel();
                            }
                        }
                    });
                    ofInt2222.addListener(new Animator.AnimatorListener() { // from class: com.lzf.easyfloat.widget.appfloat.TouchUtils$sideAnim$2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            TouchUtils.this.dragEnd(view);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            TouchUtils.this.dragEnd(view);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            TouchUtils.this.getConfig().setAnim(true);
                        }
                    });
                    ofInt2222.start();
                    return;
                }
                int i5 = this.leftDistance;
                i2 = this.rightDistance;
                break;
            default:
                return;
        }
    }

    private final int statusBarHeight(View view) {
        return DisplayUtils.INSTANCE.statusBarHeight(view);
    }

    public final FloatConfig getConfig() {
        return this.config;
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010f, code lost:
        if (r7.leftDistance == r4) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateFloat(View view, MotionEvent motionEvent, WindowManager windowManager, WindowManager.LayoutParams layoutParams) {
        FloatCallbacks.Builder builder;
        ih0<View, of0> dragEnd$easyfloat_release;
        FloatCallbacks.Builder builder2;
        mh0<View, MotionEvent, of0> drag$easyfloat_release;
        FloatCallbacks.Builder builder3;
        mh0<View, MotionEvent, of0> touchEvent$easyfloat_release;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, "view");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(motionEvent, NotificationCompat.CATEGORY_EVENT);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(windowManager, "windowManager");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(layoutParams, IOptionConstant.params);
        OnFloatCallbacks callbacks = this.config.getCallbacks();
        if (callbacks != null) {
            callbacks.touchEvent(view, motionEvent);
        }
        FloatCallbacks floatCallbacks = this.config.getFloatCallbacks();
        if (floatCallbacks != null && (builder3 = floatCallbacks.getBuilder()) != null && (touchEvent$easyfloat_release = builder3.getTouchEvent$easyfloat_release()) != null) {
            touchEvent$easyfloat_release.mo4918invoke(view, motionEvent);
        }
        boolean z = false;
        r1 = 0;
        r1 = 0;
        int height = 0;
        r1 = 0;
        int i = 0;
        if (!this.config.getDragEnable() || this.config.isAnim()) {
            this.config.setDrag(false);
            return;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.config.setDrag(false);
            this.lastX = motionEvent.getRawX();
            this.lastY = motionEvent.getRawY();
            this.parentWidth = DisplayUtils.INSTANCE.getScreenWidth(this.context);
            this.parentHeight = this.config.getDisplayHeight().getDisplayRealHeight(this.context);
            view.getLocationOnScreen(this.location);
            if (this.location[1] > layoutParams.y) {
                z = true;
            }
            this.hasStatusBar = z;
            this.emptyHeight = this.parentHeight - view.getHeight();
        } else if (action == 1) {
            if (!this.config.isDrag()) {
                return;
            }
            switch (this.config.getSidePattern().ordinal()) {
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                    sideAnim(view, layoutParams, windowManager);
                    return;
                default:
                    OnFloatCallbacks callbacks2 = this.config.getCallbacks();
                    if (callbacks2 != null) {
                        callbacks2.dragEnd(view);
                    }
                    FloatCallbacks floatCallbacks2 = this.config.getFloatCallbacks();
                    if (floatCallbacks2 == null || (builder = floatCallbacks2.getBuilder()) == null || (dragEnd$easyfloat_release = builder.getDragEnd$easyfloat_release()) == null) {
                        return;
                    }
                    dragEnd$easyfloat_release.mo4916invoke(view);
                    return;
            }
        } else if (action != 2) {
        } else {
            float rawX = motionEvent.getRawX() - this.lastX;
            float rawY = motionEvent.getRawY() - this.lastY;
            if (!this.config.isDrag()) {
                if ((rawY * rawY) + (rawX * rawX) < 81) {
                    return;
                }
            }
            this.config.setDrag(true);
            int i2 = layoutParams.x + ((int) rawX);
            int i3 = layoutParams.y + ((int) rawY);
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 > this.parentWidth - view.getWidth()) {
                i2 = this.parentWidth - view.getWidth();
            }
            if (i3 < 0) {
                i3 = 0;
            } else if (i3 > this.emptyHeight - statusBarHeight(view)) {
                if (this.hasStatusBar) {
                    i3 = this.emptyHeight - statusBarHeight(view);
                } else {
                    int i4 = this.emptyHeight;
                    if (i3 > i4) {
                        i3 = i4;
                    }
                }
            }
            switch (this.config.getSidePattern().ordinal()) {
                case 1:
                    break;
                case 2:
                    i = this.parentWidth - view.getWidth();
                    break;
                case 3:
                    i = i2;
                    i3 = 0;
                    break;
                case 4:
                    height = this.parentHeight - view.getHeight();
                    i3 = height;
                    i = i2;
                    break;
                case 5:
                    float rawX2 = motionEvent.getRawX() * 2;
                    int i5 = this.parentWidth;
                    if (rawX2 > i5) {
                        i = i5 - view.getWidth();
                        break;
                    }
                    break;
                case 6:
                    float rawY2 = (motionEvent.getRawY() - this.parentRect.top) * 2;
                    int i6 = this.parentHeight;
                    if (rawY2 > i6) {
                        height = i6 - view.getHeight();
                    }
                    i3 = height;
                    i = i2;
                    break;
                case 7:
                    this.leftDistance = (int) motionEvent.getRawX();
                    this.rightDistance = this.parentWidth - ((int) motionEvent.getRawX());
                    int i7 = this.parentRect.top;
                    this.topDistance = ((int) motionEvent.getRawY()) - i7;
                    this.bottomDistance = (this.parentHeight + i7) - ((int) motionEvent.getRawY());
                    this.minX = Math.min(this.leftDistance, this.rightDistance);
                    int min = Math.min(this.topDistance, this.bottomDistance);
                    this.minY = min;
                    int i8 = this.minX;
                    if (i8 >= min) {
                        if (this.topDistance != min) {
                            height = this.parentHeight - view.getHeight();
                        }
                        i3 = height;
                        i = i2;
                        break;
                    } else {
                        break;
                    }
                default:
                    i = i2;
                    break;
            }
            layoutParams.x = i;
            layoutParams.y = i3;
            windowManager.updateViewLayout(view, layoutParams);
            OnFloatCallbacks callbacks3 = this.config.getCallbacks();
            if (callbacks3 != null) {
                callbacks3.drag(view, motionEvent);
            }
            FloatCallbacks floatCallbacks3 = this.config.getFloatCallbacks();
            if (floatCallbacks3 != null && (builder2 = floatCallbacks3.getBuilder()) != null && (drag$easyfloat_release = builder2.getDrag$easyfloat_release()) != null) {
                drag$easyfloat_release.mo4918invoke(view, motionEvent);
            }
            this.lastX = motionEvent.getRawX();
            this.lastY = motionEvent.getRawY();
        }
    }
}

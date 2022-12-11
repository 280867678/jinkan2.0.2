package com.lzf.easyfloat.widget.activityfloat;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import com.lzf.easyfloat.anim.AnimatorManager;
import com.lzf.easyfloat.data.FloatConfig;
import com.lzf.easyfloat.enums.SidePattern;
import com.lzf.easyfloat.interfaces.FloatCallbacks;
import com.lzf.easyfloat.interfaces.OnFloatAnimator;
import com.lzf.easyfloat.interfaces.OnFloatCallbacks;
import com.lzf.easyfloat.interfaces.OnInvokeView;
import com.lzf.easyfloat.utils.Logger;
import com.umeng.analytics.pro.C1615d;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.mh0;
import me.tvspark.of0;
import me.tvspark.outline;
import me.tvspark.xg0;

@ef0
/* loaded from: classes3.dex */
public abstract class AbstractDragFloatingView extends FrameLayout {
    public HashMap _$_findViewCache;
    public int bottomDistance;
    public FloatConfig config;
    public Rect floatRect;
    public boolean isCreated;
    public int lastX;
    public int lastY;
    public int leftDistance;
    public int minX;
    public int minY;
    public int parentHeight;
    public Rect parentRect;
    public ViewGroup parentView;
    public int parentWidth;
    public int rightDistance;
    public int topDistance;

    @ef0
    /* renamed from: com.lzf.easyfloat.widget.activityfloat.AbstractDragFloatingView$1 */
    /* loaded from: classes3.dex */
    public static final class View$OnClickListenerC10361 implements View.OnClickListener {
        public static final View$OnClickListenerC10361 INSTANCE = new View$OnClickListenerC10361();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractDragFloatingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        this.parentRect = new Rect();
        this.floatRect = new Rect();
        new FrameLayout(context, attributeSet, i);
        this.config = new FloatConfig(null, null, null, false, false, false, false, false, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, false, false, ViewCompat.MEASURED_SIZE_MASK, null);
        initView(context);
        setOnClickListener(View$OnClickListenerC10361.INSTANCE);
    }

    public /* synthetic */ AbstractDragFloatingView(Context context, AttributeSet attributeSet, int i, int i2, gi0 gi0Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void enterAnim() {
        if (this.parentView == null) {
            return;
        }
        OnFloatAnimator floatAnimator = this.config.getFloatAnimator();
        ViewGroup viewGroup = this.parentView;
        if (viewGroup == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        Animator enterAnim = new AnimatorManager(floatAnimator, this, viewGroup, this.config.getSidePattern()).enterAnim();
        if (enterAnim != null) {
            enterAnim.addListener(new Animator.AnimatorListener() { // from class: com.lzf.easyfloat.widget.activityfloat.AbstractDragFloatingView$enterAnim$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AbstractDragFloatingView.this.getConfig().setAnim(false);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    AbstractDragFloatingView.this.getConfig().setAnim(true);
                }
            });
        }
        if (enterAnim == null) {
            return;
        }
        enterAnim.start();
    }

    private final void initDistanceValue() {
        getGlobalVisibleRect(this.floatRect);
        Rect rect = this.floatRect;
        int i = rect.left;
        Rect rect2 = this.parentRect;
        int i2 = i - rect2.left;
        this.leftDistance = i2;
        int i3 = rect2.right - rect.right;
        this.rightDistance = i3;
        this.topDistance = rect.top - rect2.top;
        this.bottomDistance = rect2.bottom - rect.bottom;
        this.minX = Math.min(i2, i3);
        this.minY = Math.min(this.topDistance, this.bottomDistance);
        Logger logger = Logger.INSTANCE;
        logger.m3695i(this.leftDistance + "   " + this.rightDistance + "   " + this.topDistance + "   " + this.bottomDistance);
    }

    private final void initParent() {
        if (getParent() == null || !(getParent() instanceof ViewGroup)) {
            return;
        }
        ViewParent parent = getParent();
        if (parent == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.parentView = viewGroup;
        if (viewGroup == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        this.parentHeight = viewGroup.getHeight();
        ViewGroup viewGroup2 = this.parentView;
        if (viewGroup2 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        this.parentWidth = viewGroup2.getWidth();
        ViewGroup viewGroup3 = this.parentView;
        if (viewGroup3 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        viewGroup3.getGlobalVisibleRect(this.parentRect);
        Logger logger = Logger.INSTANCE;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("parentRect: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.parentRect);
        logger.m3697e(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r0 < r2) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x006d, code lost:
        r0 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006a, code lost:
        if (r0 < r2) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void sideAnim() {
        float translationX;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        float translationY;
        float f2;
        initDistanceValue();
        int ordinal = this.config.getSidePattern().ordinal();
        float f3 = 0.0f;
        String str = Key.TRANSLATION_Y;
        switch (ordinal) {
            case 8:
                translationX = getTranslationX();
                i = this.leftDistance;
                i2 = -i;
                float f4 = i2;
                translationY = f4 + getTranslationX();
                str = Key.TRANSLATION_X;
                float f5 = translationX;
                f3 = translationY;
                f2 = f5;
                break;
            case 9:
                translationX = getTranslationX();
                i2 = this.rightDistance;
                float f42 = i2;
                translationY = f42 + getTranslationX();
                str = Key.TRANSLATION_X;
                float f52 = translationX;
                f3 = translationY;
                f2 = f52;
                break;
            case 10:
                translationX = getTranslationY();
                i4 = this.topDistance;
                i5 = -i4;
                f = i5;
                translationY = f + getTranslationY();
                float f522 = translationX;
                f3 = translationY;
                f2 = f522;
                break;
            case 11:
                translationX = getTranslationY();
                i5 = this.bottomDistance;
                f = i5;
                translationY = f + getTranslationY();
                float f5222 = translationX;
                f3 = translationY;
                f2 = f5222;
                break;
            case 12:
                translationX = getTranslationX();
                i = this.leftDistance;
                i3 = this.rightDistance;
                break;
            case 13:
                translationX = getTranslationY();
                i4 = this.topDistance;
                int i6 = this.bottomDistance;
                if (i4 >= i6) {
                    f = i6;
                    translationY = f + getTranslationY();
                    float f52222 = translationX;
                    f3 = translationY;
                    f2 = f52222;
                    break;
                }
                i5 = -i4;
                f = i5;
                translationY = f + getTranslationY();
                float f522222 = translationX;
                f3 = translationY;
                f2 = f522222;
            case 14:
                if (this.minX >= this.minY) {
                    float translationY2 = getTranslationY();
                    int i7 = this.topDistance;
                    int i8 = this.bottomDistance;
                    float translationY3 = getTranslationY() + (i7 < i8 ? -i7 : i8);
                    f2 = translationY2;
                    f3 = translationY3;
                    break;
                } else {
                    translationX = getTranslationX();
                    i = this.leftDistance;
                    i3 = this.rightDistance;
                    break;
                }
            default:
                str = Key.TRANSLATION_X;
                f2 = 0.0f;
                break;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, str, f2, f3);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.lzf.easyfloat.widget.activityfloat.AbstractDragFloatingView$sideAnim$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AbstractDragFloatingView.this.touchOver();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                AbstractDragFloatingView.this.getConfig().setAnim(true);
            }
        });
        ofFloat.start();
    }

    private final Pair<Float, Float> sideForLatest(float f, float f2) {
        int i = this.minX;
        int i2 = this.minY;
        if (i < i2) {
            f = this.leftDistance == i ? 0.0f : this.parentWidth - getWidth();
        } else {
            f2 = this.topDistance == i2 ? 0.0f : this.parentHeight - getHeight();
        }
        return new Pair<>(Float.valueOf(f), Float.valueOf(f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void touchOver() {
        FloatCallbacks.Builder builder;
        ih0<View, of0> dragEnd$easyfloat_release;
        this.config.setAnim(false);
        this.config.setDrag(false);
        OnFloatCallbacks callbacks = this.config.getCallbacks();
        if (callbacks != null) {
            callbacks.dragEnd(this);
        }
        FloatCallbacks floatCallbacks = this.config.getFloatCallbacks();
        if (floatCallbacks == null || (builder = floatCallbacks.getBuilder()) == null || (dragEnd$easyfloat_release = builder.getDragEnd$easyfloat_release()) == null) {
            return;
        }
        dragEnd$easyfloat_release.mo4916invoke(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final void updateView(MotionEvent motionEvent) {
        FloatCallbacks.Builder builder;
        mh0<View, MotionEvent, of0> drag$easyfloat_release;
        FloatCallbacks.Builder builder2;
        mh0<View, MotionEvent, of0> touchEvent$easyfloat_release;
        OnFloatCallbacks callbacks = this.config.getCallbacks();
        if (callbacks != null) {
            callbacks.touchEvent(this, motionEvent);
        }
        FloatCallbacks floatCallbacks = this.config.getFloatCallbacks();
        if (floatCallbacks != null && (builder2 = floatCallbacks.getBuilder()) != null && (touchEvent$easyfloat_release = builder2.getTouchEvent$easyfloat_release()) != null) {
            touchEvent$easyfloat_release.mo4918invoke(this, motionEvent);
        }
        if (!this.config.getDragEnable() || this.config.isAnim()) {
            this.config.setDrag(false);
            setPressed(true);
            return;
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.config.setDrag(false);
            setPressed(true);
            this.lastX = rawX;
            this.lastY = rawY;
            getParent().requestDisallowInterceptTouchEvent(true);
            initParent();
        } else if (action == 1) {
            setPressed(!this.config.isDrag());
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
                    sideAnim();
                    return;
                default:
                    touchOver();
                    return;
            }
        } else if (action != 2 || this.parentHeight <= 0 || this.parentWidth <= 0) {
        } else {
            int i = rawX - this.lastX;
            int i2 = rawY - this.lastY;
            if (!this.config.isDrag()) {
                if ((i2 * i2) + (i * i) < 81) {
                    return;
                }
            }
            this.config.setDrag(true);
            float x = getX() + i;
            float y = getY() + i2;
            float f = 0;
            float f2 = 0.0f;
            if (x < f) {
                x = 0.0f;
            } else if (x > this.parentWidth - getWidth()) {
                x = this.parentWidth - getWidth();
            }
            if (y < f) {
                y = 0.0f;
            } else if (y > this.parentHeight - getHeight()) {
                y = this.parentHeight - getHeight();
            }
            switch (this.config.getSidePattern().ordinal()) {
                case 1:
                    break;
                case 2:
                    f2 = this.parentRect.right - getWidth();
                    break;
                case 3:
                    f2 = x;
                    y = 0.0f;
                    break;
                case 4:
                    f2 = this.parentRect.bottom - getHeight();
                    y = f2;
                    f2 = x;
                    break;
                case 5:
                    Rect rect = this.parentRect;
                    int i3 = (rawX * 2) - rect.left;
                    int i4 = rect.right;
                    if (i3 > i4) {
                        f2 = i4 - getWidth();
                        break;
                    }
                    break;
                case 6:
                    Rect rect2 = this.parentRect;
                    int i5 = rawY - rect2.top;
                    int i6 = rect2.bottom;
                    if (i5 > i6 - rawY) {
                        f2 = i6 - getHeight();
                    }
                    y = f2;
                    f2 = x;
                    break;
                case 7:
                    Rect rect3 = this.parentRect;
                    int i7 = rawX - rect3.left;
                    this.leftDistance = i7;
                    int i8 = rect3.right - rawX;
                    this.rightDistance = i8;
                    this.topDistance = rawY - rect3.top;
                    this.bottomDistance = rect3.bottom - rawY;
                    this.minX = Math.min(i7, i8);
                    this.minY = Math.min(this.topDistance, this.bottomDistance);
                    Pair<Float, Float> sideForLatest = sideForLatest(x, y);
                    f2 = sideForLatest.getFirst().floatValue();
                    y = sideForLatest.getSecond().floatValue();
                    break;
                default:
                    f2 = x;
                    break;
            }
            setX(f2);
            setY(y);
            this.lastX = rawX;
            this.lastY = rawY;
            OnFloatCallbacks callbacks2 = this.config.getCallbacks();
            if (callbacks2 != null) {
                callbacks2.drag(this, motionEvent);
            }
            FloatCallbacks floatCallbacks2 = this.config.getFloatCallbacks();
            if (floatCallbacks2 == null || (builder = floatCallbacks2.getBuilder()) == null || (drag$easyfloat_release = builder.getDrag$easyfloat_release()) == null) {
                return;
            }
            drag$easyfloat_release.mo4918invoke(this, motionEvent);
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void exitAnim$easyfloat_release() {
        if (this.config.isAnim() || this.parentView == null) {
            return;
        }
        OnFloatAnimator floatAnimator = this.config.getFloatAnimator();
        ViewGroup viewGroup = this.parentView;
        if (viewGroup == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        Animator exitAnim = new AnimatorManager(floatAnimator, this, viewGroup, this.config.getSidePattern()).exitAnim();
        if (exitAnim != null) {
            exitAnim.addListener(new Animator.AnimatorListener() { // from class: com.lzf.easyfloat.widget.activityfloat.AbstractDragFloatingView$exitAnim$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ViewGroup viewGroup2;
                    AbstractDragFloatingView.this.getConfig().setAnim(false);
                    viewGroup2 = AbstractDragFloatingView.this.parentView;
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(AbstractDragFloatingView.this);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    AbstractDragFloatingView.this.getConfig().setAnim(true);
                }
            });
            exitAnim.start();
            return;
        }
        ViewGroup viewGroup2 = this.parentView;
        if (viewGroup2 == null) {
            return;
        }
        viewGroup2.removeView(this);
    }

    public final FloatConfig getConfig() {
        return this.config;
    }

    public abstract Integer getLayoutId();

    public final void initView(Context context) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        if (getLayoutId() != null) {
            LayoutInflater from = LayoutInflater.from(context);
            Integer layoutId = getLayoutId();
            if (layoutId == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            View inflate = from.inflate(layoutId.intValue(), this);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) inflate, "LayoutInflater.from(cont…te(getLayoutId()!!, this)");
            renderView(inflate);
            OnInvokeView invokeView = this.config.getInvokeView();
            if (invokeView == null) {
                return;
            }
            invokeView.invoke(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        FloatCallbacks.Builder builder;
        xg0<of0> dismiss$easyfloat_release;
        super.onDetachedFromWindow();
        OnFloatCallbacks callbacks = this.config.getCallbacks();
        if (callbacks != null) {
            callbacks.dismiss();
        }
        FloatCallbacks floatCallbacks = this.config.getFloatCallbacks();
        if (floatCallbacks == null || (builder = floatCallbacks.getBuilder()) == null || (dismiss$easyfloat_release = builder.getDismiss$easyfloat_release()) == null) {
            return;
        }
        dismiss$easyfloat_release.mo4969invoke();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            updateView(motionEvent);
        }
        return this.config.isDrag() || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.isCreated) {
            this.isCreated = true;
            if (true ^ ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.config.getLocationPair(), new Pair(0, 0))) {
                setX(this.config.getLocationPair().getFirst().intValue());
                setY(this.config.getLocationPair().getSecond().intValue());
            } else {
                setX(this.config.getOffsetPair().getFirst().floatValue() + getX());
                setY(this.config.getOffsetPair().getSecond().floatValue() + getY());
            }
            initParent();
            initDistanceValue();
            enterAnim();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            updateView(motionEvent);
        }
        return this.config.isDrag() || super.onTouchEvent(motionEvent);
    }

    public abstract void renderView(View view);

    public final void setConfig(FloatConfig floatConfig) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(floatConfig, "<set-?>");
        this.config = floatConfig;
    }
}

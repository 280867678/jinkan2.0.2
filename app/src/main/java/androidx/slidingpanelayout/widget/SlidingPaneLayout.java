package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.AbstractC0047Px;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SlidingPaneLayout extends ViewGroup {
    public static final int DEFAULT_FADE_COLOR = -858993460;
    public static final int DEFAULT_OVERHANG_SIZE = 32;
    public static final int MIN_FLING_VELOCITY = 400;
    public static final String TAG = "SlidingPaneLayout";
    public boolean mCanSlide;
    public int mCoveredFadeColor;
    public boolean mDisplayListReflectionLoaded;
    public final ViewDragHelper mDragHelper;
    public boolean mFirstLayout;
    public Method mGetDisplayList;
    public float mInitialMotionX;
    public float mInitialMotionY;
    public boolean mIsUnableToDrag;
    public final int mOverhangSize;
    public PanelSlideListener mPanelSlideListener;
    public int mParallaxBy;
    public float mParallaxOffset;
    public final ArrayList<DisableLayerRunnable> mPostedRunnables;
    public boolean mPreservedOpenState;
    public Field mRecreateDisplayList;
    public Drawable mShadowDrawableLeft;
    public Drawable mShadowDrawableRight;
    public float mSlideOffset;
    public int mSlideRange;
    public View mSlideableView;
    public int mSliderFadeColor;
    public final Rect mTmpRect;

    /* loaded from: classes3.dex */
    public class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public final Rect mTmpRect = new Rect();

        public AccessibilityDelegate() {
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.mTmpRect;
            accessibilityNodeInfoCompat2.getBoundsInParent(rect);
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
        }

        public boolean filter(View view) {
            return SlidingPaneLayout.this.isDimmed(view);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, obtain);
            copyNodeInfoNoChildren(accessibilityNodeInfoCompat, obtain);
            obtain.recycle();
            accessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.setSource(view);
            ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!filter(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!filter(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class DisableLayerRunnable implements Runnable {
        public final View mChildView;

        public DisableLayerRunnable(View view) {
            this.mChildView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mChildView.getParent() == SlidingPaneLayout.this) {
                this.mChildView.setLayerType(0, null);
                SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
            }
            SlidingPaneLayout.this.mPostedRunnables.remove(this);
        }
    }

    /* loaded from: classes3.dex */
    public class DragHelperCallback extends ViewDragHelper.Callback {
        public DragHelperCallback() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.mSlideableView.getLayoutParams();
            if (!SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.mSlideRange + paddingLeft);
            }
            int width = SlidingPaneLayout.this.getWidth() - (SlidingPaneLayout.this.mSlideableView.getWidth() + (SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
            return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.mSlideRange);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.mSlideRange;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i, int i2) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.mDragHelper.captureChildView(slidingPaneLayout.mSlideableView, i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            SlidingPaneLayout.this.setAllChildrenVisible();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            SlidingPaneLayout slidingPaneLayout;
            boolean z;
            if (SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0) {
                SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                if (slidingPaneLayout2.mSlideOffset == 0.0f) {
                    slidingPaneLayout2.updateObscuredViewsVisibility(slidingPaneLayout2.mSlideableView);
                    SlidingPaneLayout slidingPaneLayout3 = SlidingPaneLayout.this;
                    slidingPaneLayout3.dispatchOnPanelClosed(slidingPaneLayout3.mSlideableView);
                    slidingPaneLayout = SlidingPaneLayout.this;
                    z = false;
                } else {
                    slidingPaneLayout2.dispatchOnPanelOpened(slidingPaneLayout2.mSlideableView);
                    slidingPaneLayout = SlidingPaneLayout.this;
                    z = true;
                }
                slidingPaneLayout.mPreservedOpenState = z;
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.onPanelDragged(i);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.mSlideRange;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.mSlideableView.getWidth();
            } else {
                paddingLeft = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i > 0 || (i == 0 && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.mSlideRange;
                }
            }
            SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            if (SlidingPaneLayout.this.mIsUnableToDrag) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).slideable;
        }
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int[] ATTRS = {16843137};
        public Paint dimPaint;
        public boolean dimWhenOffset;
        public boolean slideable;
        public float weight;

        public LayoutParams() {
            super(-1, -1);
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.weight = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.weight = 0.0f;
            this.weight = layoutParams.weight;
        }
    }

    /* loaded from: classes3.dex */
    public interface PanelSlideListener {
        void onPanelClosed(@NonNull View view);

        void onPanelOpened(@NonNull View view);

        void onPanelSlide(@NonNull View view, float f);
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: createFromParcel */
            public SavedState mo4370createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: createFromParcel */
            public SavedState mo4371createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: newArray */
            public SavedState[] mo4372newArray(int i) {
                return new SavedState[i];
            }
        };
        public boolean isOpen;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isOpen = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isOpen ? 1 : 0);
        }
    }

    /* loaded from: classes3.dex */
    public static class SimplePanelSlideListener implements PanelSlideListener {
        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f) {
        }
    }

    public SlidingPaneLayout(@NonNull Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSliderFadeColor = DEFAULT_FADE_COLOR;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList<>();
        float f = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int) ((32.0f * f) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper create = ViewDragHelper.create(this, 0.5f, new DragHelperCallback());
        this.mDragHelper = create;
        create.setMinVelocity(f * 400.0f);
    }

    private boolean closePane(View view, int i) {
        if (this.mFirstLayout || smoothSlideTo(0.0f, i)) {
            this.mPreservedOpenState = false;
            return true;
        }
        return false;
    }

    private void dimChildView(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) ((((-16777216) & i) >>> 24) * f)) << 24) | (i & ViewCompat.MEASURED_SIZE_MASK);
            if (layoutParams.dimPaint == null) {
                layoutParams.dimPaint = new Paint();
            }
            layoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.dimPaint);
            }
            invalidateChildRegion(view);
        } else if (view.getLayerType() == 0) {
        } else {
            Paint paint = layoutParams.dimPaint;
            if (paint != null) {
                paint.setColorFilter(null);
            }
            DisableLayerRunnable disableLayerRunnable = new DisableLayerRunnable(view);
            this.mPostedRunnables.add(disableLayerRunnable);
            ViewCompat.postOnAnimation(this, disableLayerRunnable);
        }
    }

    private boolean openPane(View view, int i) {
        if (this.mFirstLayout || smoothSlideTo(1.0f, i)) {
            this.mPreservedOpenState = true;
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parallaxOtherViews(float f) {
        boolean z;
        int childCount;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (layoutParams.dimWhenOffset) {
            if ((isLayoutRtlSupport ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) <= 0) {
                z = true;
                childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt != this.mSlideableView) {
                        int i2 = this.mParallaxBy;
                        this.mParallaxOffset = f;
                        int i3 = ((int) ((1.0f - this.mParallaxOffset) * i2)) - ((int) ((1.0f - f) * i2));
                        if (isLayoutRtlSupport) {
                            i3 = -i3;
                        }
                        childAt.offsetLeftAndRight(i3);
                        if (z) {
                            float f2 = this.mParallaxOffset;
                            dimChildView(childAt, isLayoutRtlSupport ? f2 - 1.0f : 1.0f - f2, this.mCoveredFadeColor);
                        }
                    }
                }
            }
        }
        z = false;
        childCount = getChildCount();
        while (i < childCount) {
        }
    }

    public static boolean viewIsOpaque(View view) {
        return view.isOpaque();
    }

    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z) {
            if (view.canScrollHorizontally(isLayoutRtlSupport() ? i : -i)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public boolean closePane() {
        return closePane(this.mSlideableView, 0);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelper.continueSettling(true)) {
            if (!this.mCanSlide) {
                this.mDragHelper.abort();
            } else {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    public void dispatchOnPanelClosed(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelOpened(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelSlide(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelSlide(view, this.mSlideOffset);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i;
        int i2;
        super.draw(canvas);
        Drawable drawable = isLayoutRtlSupport() ? this.mShadowDrawableRight : this.mShadowDrawableLeft;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (isLayoutRtlSupport()) {
            i2 = childAt.getRight();
            i = intrinsicWidth + i2;
        } else {
            int left = childAt.getLeft();
            int i3 = left - intrinsicWidth;
            i = left;
            i2 = i3;
        }
        drawable.setBounds(i2, top, i, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null) {
            canvas.getClipBounds(this.mTmpRect);
            if (isLayoutRtlSupport()) {
                Rect rect = this.mTmpRect;
                rect.left = Math.max(rect.left, this.mSlideableView.getRight());
            } else {
                Rect rect2 = this.mTmpRect;
                rect2.right = Math.min(rect2.right, this.mSlideableView.getLeft());
            }
            canvas.clipRect(this.mTmpRect);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return drawChild;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @ColorInt
    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    @AbstractC0047Px
    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    @ColorInt
    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    public void invalidateChildRegion(View view) {
        ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).dimPaint);
    }

    public boolean isDimmed(View view) {
        if (view == null) {
            return false;
        }
        return this.mCanSlide && ((LayoutParams) view.getLayoutParams()).dimWhenOffset && this.mSlideOffset > 0.0f;
    }

    public boolean isLayoutRtlSupport() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public boolean isOpen() {
        return !this.mCanSlide || this.mSlideOffset == 1.0f;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int size = this.mPostedRunnables.size();
        for (int i = 0; i < size; i++) {
            this.mPostedRunnables.get(i).run();
        }
        this.mPostedRunnables.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.mPreservedOpenState = !this.mDragHelper.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.mDragHelper.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.mDragHelper.cancel();
            return false;
        } else {
            if (actionMasked == 0) {
                this.mIsUnableToDrag = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) x, (int) y) && isDimmed(this.mSlideableView)) {
                    z = true;
                    return this.mDragHelper.shouldInterceptTouchEvent(motionEvent) || z;
                }
            } else if (actionMasked == 2) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float abs = Math.abs(x2 - this.mInitialMotionX);
                float abs2 = Math.abs(y2 - this.mInitialMotionY);
                if (abs > this.mDragHelper.getTouchSlop() && abs2 > abs) {
                    this.mDragHelper.cancel();
                    this.mIsUnableToDrag = true;
                    return false;
                }
            }
            z = false;
            if (this.mDragHelper.shouldInterceptTouchEvent(motionEvent)) {
                return true;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        ViewDragHelper viewDragHelper = this.mDragHelper;
        if (isLayoutRtlSupport) {
            viewDragHelper.setEdgeTrackingEnabled(2);
        } else {
            viewDragHelper.setEdgeTrackingEnabled(1);
        }
        int i10 = i3 - i;
        int paddingRight = isLayoutRtlSupport ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = isLayoutRtlSupport ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            this.mSlideOffset = (!this.mCanSlide || !this.mPreservedOpenState) ? 0.0f : 1.0f;
        }
        int i11 = paddingRight;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.slideable) {
                    int i13 = i10 - paddingLeft;
                    int min = (Math.min(paddingRight, i13 - this.mOverhangSize) - i11) - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    this.mSlideRange = min;
                    int i14 = isLayoutRtlSupport ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    layoutParams.dimWhenOffset = (measuredWidth / 2) + ((i11 + i14) + min) > i13;
                    int i15 = (int) (min * this.mSlideOffset);
                    i5 = i14 + i15 + i11;
                    this.mSlideOffset = i15 / this.mSlideRange;
                    i6 = 0;
                } else if (!this.mCanSlide || (i7 = this.mParallaxBy) == 0) {
                    i5 = paddingRight;
                    i6 = 0;
                } else {
                    i6 = (int) ((1.0f - this.mSlideOffset) * i7);
                    i5 = paddingRight;
                }
                if (isLayoutRtlSupport) {
                    i9 = (i10 - i5) + i6;
                    i8 = i9 - measuredWidth;
                } else {
                    i8 = i5 - i6;
                    i9 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                i11 = i5;
                paddingRight = childAt.getWidth() + paddingRight;
            }
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.mParallaxBy != 0) {
                    parallaxOtherViews(this.mSlideOffset);
                }
                if (((LayoutParams) this.mSlideableView.getLayoutParams()).dimWhenOffset) {
                    dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
                }
            } else {
                for (int i16 = 0; i16 < childCount; i16++) {
                    dimChildView(getChildAt(i16), 0.0f, this.mSliderFadeColor);
                }
            }
            updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ea  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        int paddingTop;
        int i3;
        int i4;
        int i5;
        int measuredHeight;
        int makeMeasureSpec;
        int i6;
        int i7;
        int measuredHeight2;
        int makeMeasureSpec2;
        float f;
        int i8;
        int makeMeasureSpec3;
        int makeMeasureSpec4;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
            if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = 300;
            }
        }
        boolean z = false;
        if (mode2 == Integer.MIN_VALUE) {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            i3 = 0;
        } else if (mode2 != 1073741824) {
            i3 = 0;
            paddingTop = 0;
        } else {
            i3 = (size2 - getPaddingTop()) - getPaddingBottom();
            paddingTop = i3;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        this.mSlideableView = null;
        int i9 = paddingLeft;
        int i10 = 0;
        boolean z2 = false;
        float f2 = 0.0f;
        while (true) {
            i4 = 8;
            if (i10 >= childCount) {
                break;
            }
            View childAt = getChildAt(i10);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.dimWhenOffset = z;
            } else {
                float f3 = layoutParams.weight;
                if (f3 > 0.0f) {
                    f2 += f3;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width == 0) {
                    }
                }
                int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                if (i12 == -2) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i11, Integer.MIN_VALUE);
                    f = f2;
                    i8 = Integer.MIN_VALUE;
                } else {
                    f = f2;
                    i8 = Integer.MIN_VALUE;
                    makeMeasureSpec3 = i12 == -1 ? View.MeasureSpec.makeMeasureSpec(paddingLeft - i11, 1073741824) : View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                }
                int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                if (i13 == -2) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, i8);
                } else {
                    makeMeasureSpec4 = i13 == -1 ? View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824) : View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                }
                childAt.measure(makeMeasureSpec3, makeMeasureSpec4);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight3 = childAt.getMeasuredHeight();
                if (mode2 == i8 && measuredHeight3 > i3) {
                    i3 = Math.min(measuredHeight3, paddingTop);
                }
                i9 -= measuredWidth;
                boolean z3 = i9 < 0;
                layoutParams.slideable = z3;
                z2 |= z3;
                if (z3) {
                    this.mSlideableView = childAt;
                }
                f2 = f;
            }
            i10++;
            z = false;
        }
        if (z2 || f2 > 0.0f) {
            int i14 = paddingLeft - this.mOverhangSize;
            int i15 = 0;
            while (i15 < childCount) {
                View childAt2 = getChildAt(i15);
                if (childAt2.getVisibility() != i4) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i4) {
                        boolean z4 = ((ViewGroup.MarginLayoutParams) layoutParams2).width == 0 && layoutParams2.weight > 0.0f;
                        int measuredWidth2 = z4 ? 0 : childAt2.getMeasuredWidth();
                        if (!z2 || childAt2 == this.mSlideableView) {
                            if (layoutParams2.weight > 0.0f) {
                                if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0) {
                                    measuredHeight = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                    if (measuredHeight == -2) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                    } else if (measuredHeight == -1) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                    } else {
                                        i5 = 1073741824;
                                    }
                                    if (!z2) {
                                        int i16 = paddingLeft - (((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                                        i6 = i14;
                                        int makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
                                        if (measuredWidth2 != i16) {
                                            childAt2.measure(makeMeasureSpec5, makeMeasureSpec);
                                        }
                                        i15++;
                                        i14 = i6;
                                        i4 = 8;
                                    } else {
                                        i6 = i14;
                                        childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2 + ((int) ((layoutParams2.weight * Math.max(0, i9)) / f2)), 1073741824), makeMeasureSpec);
                                        i15++;
                                        i14 = i6;
                                        i4 = 8;
                                    }
                                } else {
                                    i5 = 1073741824;
                                    measuredHeight = childAt2.getMeasuredHeight();
                                }
                                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, i5);
                                if (!z2) {
                                }
                            }
                        } else if (((ViewGroup.MarginLayoutParams) layoutParams2).width < 0 && (measuredWidth2 > i14 || layoutParams2.weight > 0.0f)) {
                            if (z4) {
                                measuredHeight2 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                if (measuredHeight2 == -2) {
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                    i7 = 1073741824;
                                } else if (measuredHeight2 == -1) {
                                    i7 = 1073741824;
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    i7 = 1073741824;
                                }
                                childAt2.measure(View.MeasureSpec.makeMeasureSpec(i14, i7), makeMeasureSpec2);
                            } else {
                                i7 = 1073741824;
                                measuredHeight2 = childAt2.getMeasuredHeight();
                            }
                            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight2, i7);
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i14, i7), makeMeasureSpec2);
                        }
                    }
                }
                i6 = i14;
                i15++;
                i14 = i6;
                i4 = 8;
            }
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + i3);
        this.mCanSlide = z2;
        if (this.mDragHelper.getViewDragState() == 0 || z2) {
            return;
        }
        this.mDragHelper.abort();
    }

    public void onPanelDragged(int i) {
        if (this.mSlideableView == null) {
            this.mSlideOffset = 0.0f;
            return;
        }
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        int width = this.mSlideableView.getWidth();
        if (isLayoutRtlSupport) {
            i = (getWidth() - i) - width;
        }
        float paddingRight = (i - ((isLayoutRtlSupport ? getPaddingRight() : getPaddingLeft()) + (isLayoutRtlSupport ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin))) / this.mSlideRange;
        this.mSlideOffset = paddingRight;
        if (this.mParallaxBy != 0) {
            parallaxOtherViews(paddingRight);
        }
        if (layoutParams.dimWhenOffset) {
            dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
        dispatchOnPanelSlide(this.mSlideableView);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            openPane();
        } else {
            closePane();
        }
        this.mPreservedOpenState = savedState.isOpen;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isOpen = isSlideable() ? isOpen() : this.mPreservedOpenState;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.mFirstLayout = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.mDragHelper.processTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
        } else if (actionMasked == 1 && isDimmed(this.mSlideableView)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f = x2 - this.mInitialMotionX;
            float f2 = y2 - this.mInitialMotionY;
            int touchSlop = this.mDragHelper.getTouchSlop();
            if ((f2 * f2) + (f * f) < touchSlop * touchSlop && this.mDragHelper.isViewUnder(this.mSlideableView, (int) x2, (int) y2)) {
                closePane(this.mSlideableView, 0);
            }
        }
        return true;
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.mCanSlide) {
            return;
        }
        this.mPreservedOpenState = view == this.mSlideableView;
    }

    public void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public void setCoveredFadeColor(@ColorInt int i) {
        this.mCoveredFadeColor = i;
    }

    public void setPanelSlideListener(@Nullable PanelSlideListener panelSlideListener) {
        this.mPanelSlideListener = panelSlideListener;
    }

    public void setParallaxDistance(@AbstractC0047Px int i) {
        this.mParallaxBy = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@Nullable Drawable drawable) {
        this.mShadowDrawableLeft = drawable;
    }

    public void setShadowDrawableRight(@Nullable Drawable drawable) {
        this.mShadowDrawableRight = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i));
    }

    public void setSliderFadeColor(@ColorInt int i) {
        this.mSliderFadeColor = i;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    public boolean smoothSlideTo(float f, int i) {
        int paddingLeft;
        if (!this.mCanSlide) {
            return false;
        }
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (isLayoutRtlSupport) {
            int paddingRight = getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            int width = this.mSlideableView.getWidth();
            paddingLeft = (int) (getWidth() - (((f * this.mSlideRange) + paddingRight) + width));
        } else {
            paddingLeft = (int) ((f * this.mSlideRange) + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
        }
        ViewDragHelper viewDragHelper = this.mDragHelper;
        View view = this.mSlideableView;
        if (!viewDragHelper.smoothSlideViewTo(view, paddingLeft, view.getTop())) {
            return false;
        }
        setAllChildrenVisible();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    public void updateObscuredViewsVisibility(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        View childAt;
        boolean z;
        View view2 = view;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        int width = isLayoutRtlSupport ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = isLayoutRtlSupport ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !viewIsOpaque(view)) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i = view.getLeft();
            i2 = view.getRight();
            i3 = view.getTop();
            i4 = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount && (childAt = getChildAt(i5)) != view2) {
            if (childAt.getVisibility() == 8) {
                z = isLayoutRtlSupport;
            } else {
                z = isLayoutRtlSupport;
                childAt.setVisibility((Math.max(isLayoutRtlSupport ? paddingLeft : width, childAt.getLeft()) < i || Math.max(paddingTop, childAt.getTop()) < i3 || Math.min(isLayoutRtlSupport ? width : paddingLeft, childAt.getRight()) > i2 || Math.min(height, childAt.getBottom()) > i4) ? 0 : 4);
            }
            i5++;
            view2 = view;
            isLayoutRtlSupport = z;
        }
    }
}

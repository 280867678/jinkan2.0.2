package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.C0186R;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes3.dex */
public class Layer extends ConstraintHelper {
    public static final String TAG = "Layer";
    public boolean mApplyElevationOnAttach;
    public boolean mApplyVisibilityOnAttach;
    public ConstraintLayout mContainer;
    public float mRotationCenterX = Float.NaN;
    public float mRotationCenterY = Float.NaN;
    public float mGroupRotateAngle = Float.NaN;
    public float mScaleX = 1.0f;
    public float mScaleY = 1.0f;
    public float mComputedCenterX = Float.NaN;
    public float mComputedCenterY = Float.NaN;
    public float mComputedMaxX = Float.NaN;
    public float mComputedMaxY = Float.NaN;
    public float mComputedMinX = Float.NaN;
    public float mComputedMinY = Float.NaN;
    public boolean mNeedBounds = true;
    public View[] mViews = null;
    public float mShiftX = 0.0f;
    public float mShiftY = 0.0f;

    public Layer(Context context) {
        super(context);
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Layer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void reCacheViews() {
        int i;
        if (this.mContainer == null || (i = this.mCount) == 0) {
            return;
        }
        View[] viewArr = this.mViews;
        if (viewArr == null || viewArr.length != i) {
            this.mViews = new View[this.mCount];
        }
        for (int i2 = 0; i2 < this.mCount; i2++) {
            this.mViews[i2] = this.mContainer.getViewById(this.mIds[i2]);
        }
    }

    private void transform() {
        if (this.mContainer == null) {
            return;
        }
        if (this.mViews == null) {
            reCacheViews();
        }
        calcCenters();
        double radians = Math.toRadians(this.mGroupRotateAngle);
        float sin = (float) Math.sin(radians);
        float cos = (float) Math.cos(radians);
        float f = this.mScaleX;
        float f2 = f * cos;
        float f3 = this.mScaleY;
        float f4 = (-f3) * sin;
        float f5 = f * sin;
        float f6 = f3 * cos;
        for (int i = 0; i < this.mCount; i++) {
            View view = this.mViews[i];
            int left = view.getLeft();
            int top = view.getTop();
            float right = ((view.getRight() + left) / 2) - this.mComputedCenterX;
            float bottom = ((view.getBottom() + top) / 2) - this.mComputedCenterY;
            view.setTranslationX((((f4 * bottom) + (f2 * right)) - right) + this.mShiftX);
            view.setTranslationY((((f6 * bottom) + (right * f5)) - bottom) + this.mShiftY);
            view.setScaleY(this.mScaleY);
            view.setScaleX(this.mScaleX);
            view.setRotation(this.mGroupRotateAngle);
        }
    }

    public void calcCenters() {
        if (this.mContainer == null) {
            return;
        }
        if (!this.mNeedBounds && !Float.isNaN(this.mComputedCenterX) && !Float.isNaN(this.mComputedCenterY)) {
            return;
        }
        if (!Float.isNaN(this.mRotationCenterX) && !Float.isNaN(this.mRotationCenterY)) {
            this.mComputedCenterY = this.mRotationCenterY;
            this.mComputedCenterX = this.mRotationCenterX;
            return;
        }
        View[] views = getViews(this.mContainer);
        int left = views[0].getLeft();
        int top = views[0].getTop();
        int right = views[0].getRight();
        int bottom = views[0].getBottom();
        for (int i = 0; i < this.mCount; i++) {
            View view = views[i];
            left = Math.min(left, view.getLeft());
            top = Math.min(top, view.getTop());
            right = Math.max(right, view.getRight());
            bottom = Math.max(bottom, view.getBottom());
        }
        this.mComputedMaxX = right;
        this.mComputedMaxY = bottom;
        this.mComputedMinX = left;
        this.mComputedMinY = top;
        this.mComputedCenterX = Float.isNaN(this.mRotationCenterX) ? (left + right) / 2 : this.mRotationCenterX;
        this.mComputedCenterY = Float.isNaN(this.mRotationCenterY) ? (top + bottom) / 2 : this.mRotationCenterY;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mUseViewMeasure = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0186R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0186R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.mApplyVisibilityOnAttach = true;
                } else if (index == C0186R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.mApplyElevationOnAttach = true;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContainer = (ConstraintLayout) getParent();
        if (this.mApplyVisibilityOnAttach || this.mApplyElevationOnAttach) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i = 0; i < this.mCount; i++) {
                View viewById = this.mContainer.getViewById(this.mIds[i]);
                if (viewById != null) {
                    if (this.mApplyVisibilityOnAttach) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.mApplyElevationOnAttach && elevation > 0.0f) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setPivotX(float f) {
        this.mRotationCenterX = f;
        transform();
    }

    @Override // android.view.View
    public void setPivotY(float f) {
        this.mRotationCenterY = f;
        transform();
    }

    @Override // android.view.View
    public void setRotation(float f) {
        this.mGroupRotateAngle = f;
        transform();
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        this.mScaleX = f;
        transform();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        this.mScaleY = f;
        transform();
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        this.mShiftX = f;
        transform();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        this.mShiftY = f;
        transform();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        applyLayoutFeatures();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout constraintLayout) {
        reCacheViews();
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        ConstraintWidget constraintWidget = ((ConstraintLayout.LayoutParams) getLayoutParams()).getConstraintWidget();
        constraintWidget.setWidth(0);
        constraintWidget.setHeight(0);
        calcCenters();
        layout(((int) this.mComputedMinX) - getPaddingLeft(), ((int) this.mComputedMinY) - getPaddingTop(), getPaddingRight() + ((int) this.mComputedMaxX), getPaddingBottom() + ((int) this.mComputedMaxY));
        if (!Float.isNaN(this.mGroupRotateAngle)) {
            transform();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePreDraw(ConstraintLayout constraintLayout) {
        this.mContainer = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f || !Float.isNaN(this.mGroupRotateAngle)) {
            this.mGroupRotateAngle = rotation;
        }
    }
}

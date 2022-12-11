package androidx.percentlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.percentlayout.C0463R;

@Deprecated
/* loaded from: classes3.dex */
public class PercentLayoutHelper {
    public static final boolean DEBUG = false;
    public static final String TAG = "PercentLayout";
    public static final boolean VERBOSE = false;
    public final ViewGroup mHost;

    @Deprecated
    /* loaded from: classes3.dex */
    public static class PercentLayoutInfo {
        public float aspectRatio;
        public float widthPercent = -1.0f;
        public float heightPercent = -1.0f;
        public float leftMarginPercent = -1.0f;
        public float topMarginPercent = -1.0f;
        public float rightMarginPercent = -1.0f;
        public float bottomMarginPercent = -1.0f;
        public float startMarginPercent = -1.0f;
        public float endMarginPercent = -1.0f;
        public final PercentMarginLayoutParams mPreservedParams = new PercentMarginLayoutParams(0, 0);

        public void fillLayoutParams(ViewGroup.LayoutParams layoutParams, int i, int i2) {
            PercentMarginLayoutParams percentMarginLayoutParams = this.mPreservedParams;
            int i3 = layoutParams.width;
            ((ViewGroup.MarginLayoutParams) percentMarginLayoutParams).width = i3;
            ((ViewGroup.MarginLayoutParams) percentMarginLayoutParams).height = layoutParams.height;
            boolean z = false;
            boolean z2 = (percentMarginLayoutParams.mIsWidthComputedFromAspectRatio || i3 == 0) && this.widthPercent < 0.0f;
            PercentMarginLayoutParams percentMarginLayoutParams2 = this.mPreservedParams;
            if ((percentMarginLayoutParams2.mIsHeightComputedFromAspectRatio || ((ViewGroup.MarginLayoutParams) percentMarginLayoutParams2).height == 0) && this.heightPercent < 0.0f) {
                z = true;
            }
            float f = this.widthPercent;
            if (f >= 0.0f) {
                layoutParams.width = Math.round(i * f);
            }
            float f2 = this.heightPercent;
            if (f2 >= 0.0f) {
                layoutParams.height = Math.round(i2 * f2);
            }
            float f3 = this.aspectRatio;
            if (f3 >= 0.0f) {
                if (z2) {
                    layoutParams.width = Math.round(layoutParams.height * f3);
                    this.mPreservedParams.mIsWidthComputedFromAspectRatio = true;
                }
                if (!z) {
                    return;
                }
                layoutParams.height = Math.round(layoutParams.width / this.aspectRatio);
                this.mPreservedParams.mIsHeightComputedFromAspectRatio = true;
            }
        }

        public void fillMarginLayoutParams(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
            fillLayoutParams(marginLayoutParams, i, i2);
            PercentMarginLayoutParams percentMarginLayoutParams = this.mPreservedParams;
            ((ViewGroup.MarginLayoutParams) percentMarginLayoutParams).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) percentMarginLayoutParams).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) percentMarginLayoutParams).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) percentMarginLayoutParams).bottomMargin = marginLayoutParams.bottomMargin;
            MarginLayoutParamsCompat.setMarginStart(percentMarginLayoutParams, MarginLayoutParamsCompat.getMarginStart(marginLayoutParams));
            MarginLayoutParamsCompat.setMarginEnd(this.mPreservedParams, MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams));
            float f = this.leftMarginPercent;
            if (f >= 0.0f) {
                marginLayoutParams.leftMargin = Math.round(i * f);
            }
            float f2 = this.topMarginPercent;
            if (f2 >= 0.0f) {
                marginLayoutParams.topMargin = Math.round(i2 * f2);
            }
            float f3 = this.rightMarginPercent;
            if (f3 >= 0.0f) {
                marginLayoutParams.rightMargin = Math.round(i * f3);
            }
            float f4 = this.bottomMarginPercent;
            if (f4 >= 0.0f) {
                marginLayoutParams.bottomMargin = Math.round(i2 * f4);
            }
            boolean z = false;
            float f5 = this.startMarginPercent;
            boolean z2 = true;
            if (f5 >= 0.0f) {
                MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, Math.round(i * f5));
                z = true;
            }
            float f6 = this.endMarginPercent;
            if (f6 >= 0.0f) {
                MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, Math.round(i * f6));
            } else {
                z2 = z;
            }
            if (!z2 || view == null) {
                return;
            }
            MarginLayoutParamsCompat.resolveLayoutDirection(marginLayoutParams, ViewCompat.getLayoutDirection(view));
        }

        @Deprecated
        public void fillMarginLayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
            fillMarginLayoutParams(null, marginLayoutParams, i, i2);
        }

        public void restoreLayoutParams(ViewGroup.LayoutParams layoutParams) {
            PercentMarginLayoutParams percentMarginLayoutParams = this.mPreservedParams;
            if (!percentMarginLayoutParams.mIsWidthComputedFromAspectRatio) {
                layoutParams.width = ((ViewGroup.MarginLayoutParams) percentMarginLayoutParams).width;
            }
            PercentMarginLayoutParams percentMarginLayoutParams2 = this.mPreservedParams;
            if (!percentMarginLayoutParams2.mIsHeightComputedFromAspectRatio) {
                layoutParams.height = ((ViewGroup.MarginLayoutParams) percentMarginLayoutParams2).height;
            }
            PercentMarginLayoutParams percentMarginLayoutParams3 = this.mPreservedParams;
            percentMarginLayoutParams3.mIsWidthComputedFromAspectRatio = false;
            percentMarginLayoutParams3.mIsHeightComputedFromAspectRatio = false;
        }

        public void restoreMarginLayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            restoreLayoutParams(marginLayoutParams);
            PercentMarginLayoutParams percentMarginLayoutParams = this.mPreservedParams;
            marginLayoutParams.leftMargin = ((ViewGroup.MarginLayoutParams) percentMarginLayoutParams).leftMargin;
            marginLayoutParams.topMargin = ((ViewGroup.MarginLayoutParams) percentMarginLayoutParams).topMargin;
            marginLayoutParams.rightMargin = ((ViewGroup.MarginLayoutParams) percentMarginLayoutParams).rightMargin;
            marginLayoutParams.bottomMargin = ((ViewGroup.MarginLayoutParams) percentMarginLayoutParams).bottomMargin;
            MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, MarginLayoutParamsCompat.getMarginStart(percentMarginLayoutParams));
            MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, MarginLayoutParamsCompat.getMarginEnd(this.mPreservedParams));
        }

        public String toString() {
            return String.format("PercentLayoutInformation width: %f height %f, margins (%f, %f,  %f, %f, %f, %f)", Float.valueOf(this.widthPercent), Float.valueOf(this.heightPercent), Float.valueOf(this.leftMarginPercent), Float.valueOf(this.topMarginPercent), Float.valueOf(this.rightMarginPercent), Float.valueOf(this.bottomMarginPercent), Float.valueOf(this.startMarginPercent), Float.valueOf(this.endMarginPercent));
        }
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public interface PercentLayoutParams {
        PercentLayoutInfo getPercentLayoutInfo();
    }

    /* loaded from: classes3.dex */
    public static class PercentMarginLayoutParams extends ViewGroup.MarginLayoutParams {
        public boolean mIsHeightComputedFromAspectRatio;
        public boolean mIsWidthComputedFromAspectRatio;

        public PercentMarginLayoutParams(int i, int i2) {
            super(i, i2);
        }
    }

    public PercentLayoutHelper(@NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            this.mHost = viewGroup;
            return;
        }
        throw new IllegalArgumentException("host must be non-null");
    }

    public static void fetchWidthAndHeight(ViewGroup.LayoutParams layoutParams, TypedArray typedArray, int i, int i2) {
        layoutParams.width = typedArray.getLayoutDimension(i, 0);
        layoutParams.height = typedArray.getLayoutDimension(i2, 0);
    }

    public static PercentLayoutInfo getPercentLayoutInfo(Context context, AttributeSet attributeSet) {
        PercentLayoutInfo percentLayoutInfo;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0463R.styleable.PercentLayout_Layout);
        float fraction = obtainStyledAttributes.getFraction(C0463R.styleable.PercentLayout_Layout_layout_widthPercent, 1, 1, -1.0f);
        if (fraction != -1.0f) {
            percentLayoutInfo = new PercentLayoutInfo();
            percentLayoutInfo.widthPercent = fraction;
        } else {
            percentLayoutInfo = null;
        }
        float fraction2 = obtainStyledAttributes.getFraction(C0463R.styleable.PercentLayout_Layout_layout_heightPercent, 1, 1, -1.0f);
        if (fraction2 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.heightPercent = fraction2;
        }
        float fraction3 = obtainStyledAttributes.getFraction(C0463R.styleable.PercentLayout_Layout_layout_marginPercent, 1, 1, -1.0f);
        if (fraction3 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.leftMarginPercent = fraction3;
            percentLayoutInfo.topMarginPercent = fraction3;
            percentLayoutInfo.rightMarginPercent = fraction3;
            percentLayoutInfo.bottomMarginPercent = fraction3;
        }
        float fraction4 = obtainStyledAttributes.getFraction(C0463R.styleable.PercentLayout_Layout_layout_marginLeftPercent, 1, 1, -1.0f);
        if (fraction4 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.leftMarginPercent = fraction4;
        }
        float fraction5 = obtainStyledAttributes.getFraction(C0463R.styleable.PercentLayout_Layout_layout_marginTopPercent, 1, 1, -1.0f);
        if (fraction5 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.topMarginPercent = fraction5;
        }
        float fraction6 = obtainStyledAttributes.getFraction(C0463R.styleable.PercentLayout_Layout_layout_marginRightPercent, 1, 1, -1.0f);
        if (fraction6 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.rightMarginPercent = fraction6;
        }
        float fraction7 = obtainStyledAttributes.getFraction(C0463R.styleable.PercentLayout_Layout_layout_marginBottomPercent, 1, 1, -1.0f);
        if (fraction7 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.bottomMarginPercent = fraction7;
        }
        float fraction8 = obtainStyledAttributes.getFraction(C0463R.styleable.PercentLayout_Layout_layout_marginStartPercent, 1, 1, -1.0f);
        if (fraction8 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.startMarginPercent = fraction8;
        }
        float fraction9 = obtainStyledAttributes.getFraction(C0463R.styleable.PercentLayout_Layout_layout_marginEndPercent, 1, 1, -1.0f);
        if (fraction9 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.endMarginPercent = fraction9;
        }
        float fraction10 = obtainStyledAttributes.getFraction(C0463R.styleable.PercentLayout_Layout_layout_aspectRatio, 1, 1, -1.0f);
        if (fraction10 != -1.0f) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.aspectRatio = fraction10;
        }
        obtainStyledAttributes.recycle();
        return percentLayoutInfo;
    }

    public static boolean shouldHandleMeasuredHeightTooSmall(View view, PercentLayoutInfo percentLayoutInfo) {
        return (view.getMeasuredHeightAndState() & (-16777216)) == 16777216 && percentLayoutInfo.heightPercent >= 0.0f && ((ViewGroup.MarginLayoutParams) percentLayoutInfo.mPreservedParams).height == -2;
    }

    public static boolean shouldHandleMeasuredWidthTooSmall(View view, PercentLayoutInfo percentLayoutInfo) {
        return (view.getMeasuredWidthAndState() & (-16777216)) == 16777216 && percentLayoutInfo.widthPercent >= 0.0f && ((ViewGroup.MarginLayoutParams) percentLayoutInfo.mPreservedParams).width == -2;
    }

    public void adjustChildren(int i, int i2) {
        PercentLayoutInfo percentLayoutInfo;
        int size = (View.MeasureSpec.getSize(i) - this.mHost.getPaddingLeft()) - this.mHost.getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i2) - this.mHost.getPaddingTop()) - this.mHost.getPaddingBottom();
        int childCount = this.mHost.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mHost.getChildAt(i3);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof PercentLayoutParams) && (percentLayoutInfo = ((PercentLayoutParams) layoutParams).getPercentLayoutInfo()) != null) {
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    percentLayoutInfo.fillMarginLayoutParams(childAt, (ViewGroup.MarginLayoutParams) layoutParams, size, size2);
                } else {
                    percentLayoutInfo.fillLayoutParams(layoutParams, size, size2);
                }
            }
        }
    }

    public boolean handleMeasuredStateTooSmall() {
        PercentLayoutInfo percentLayoutInfo;
        int childCount = this.mHost.getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mHost.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof PercentLayoutParams) && (percentLayoutInfo = ((PercentLayoutParams) layoutParams).getPercentLayoutInfo()) != null) {
                if (shouldHandleMeasuredWidthTooSmall(childAt, percentLayoutInfo)) {
                    layoutParams.width = -2;
                    z = true;
                }
                if (shouldHandleMeasuredHeightTooSmall(childAt, percentLayoutInfo)) {
                    layoutParams.height = -2;
                    z = true;
                }
            }
        }
        return z;
    }

    public void restoreOriginalParams() {
        PercentLayoutInfo percentLayoutInfo;
        int childCount = this.mHost.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewGroup.LayoutParams layoutParams = this.mHost.getChildAt(i).getLayoutParams();
            if ((layoutParams instanceof PercentLayoutParams) && (percentLayoutInfo = ((PercentLayoutParams) layoutParams).getPercentLayoutInfo()) != null) {
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    percentLayoutInfo.restoreMarginLayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
                } else {
                    percentLayoutInfo.restoreLayoutParams(layoutParams);
                }
            }
        }
    }
}

package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0049R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class LinearLayoutCompat extends ViewGroup {
    public static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    public static final int INDEX_BOTTOM = 2;
    public static final int INDEX_CENTER_VERTICAL = 0;
    public static final int INDEX_FILL = 3;
    public static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    public static final int VERTICAL_GRAVITY_COUNT = 4;
    public boolean mBaselineAligned;
    public int mBaselineAlignedChildIndex;
    public int mBaselineChildTop;
    public Drawable mDivider;
    public int mDividerHeight;
    public int mDividerPadding;
    public int mDividerWidth;
    public int mGravity;
    public int[] mMaxAscent;
    public int[] mMaxDescent;
    public int mOrientation;
    public int mShowDividers;
    public int mTotalLength;
    public boolean mUseLargestChild;
    public float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes3.dex */
    public @interface DividerMode {
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes3.dex */
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0049R.styleable.LinearLayoutCompat, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, C0049R.styleable.LinearLayoutCompat, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        int i2 = obtainStyledAttributes.getInt(C0049R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(C0049R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(C0049R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(C0049R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(C0049R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(C0049R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(C0049R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(C0049R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(C0049R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).height == -1) {
                    int i4 = ((LinearLayout.LayoutParams) layoutParams).width;
                    ((LinearLayout.LayoutParams) layoutParams).width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) layoutParams).width = i4;
                }
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                    int i4 = ((LinearLayout.LayoutParams) layoutParams).height;
                    ((LinearLayout.LayoutParams) layoutParams).height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                    ((LinearLayout.LayoutParams) layoutParams).height = i4;
                }
            }
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int i;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View virtualChildAt = getVirtualChildAt(i2);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                drawVerticalDivider(canvas, isLayoutRtl ? virtualChildAt.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin : (virtualChildAt.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.mDividerWidth);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (isLayoutRtl) {
                    left = virtualChildAt2.getLeft();
                    i = ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    right = (left - i) - this.mDividerWidth;
                } else {
                    right = virtualChildAt2.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            } else if (isLayoutRtl) {
                right = getPaddingLeft();
            } else {
                left = getWidth();
                i = getPaddingRight();
                right = (left - i) - this.mDividerWidth;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    public void drawDividersVertical(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View virtualChildAt = getVirtualChildAt(i);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt.getLayoutParams())).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            drawHorizontalDivider(canvas, virtualChildAt2 == null ? (getHeight() - getPaddingBottom()) - this.mDividerHeight : virtualChildAt2.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt2.getLayoutParams())).bottomMargin);
        }
    }

    public void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    public void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* renamed from: generateDefaultLayoutParams */
    public LayoutParams mo4275generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i != 1) {
            return null;
        }
        return new LayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: generateLayoutParams */
    public LayoutParams mo4276generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: generateLayoutParams */
    public LayoutParams mo4277generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.mBaselineAlignedChildIndex;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.mBaselineAlignedChildIndex != 0) {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            return -1;
        }
        int i3 = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
            if (i == 16) {
                i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
            } else if (i == 80) {
                i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
            }
        }
        return i3 + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getLocationOffset(View view) {
        return 0;
    }

    public int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        } else if (i == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        } else if ((this.mShowDividers & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutHorizontal(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i14 = i4 - i2;
        int paddingBottom = i14 - getPaddingBottom();
        int paddingBottom2 = (i14 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i15 = this.mGravity;
        int i16 = i15 & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i15, ViewCompat.getLayoutDirection(this));
        int paddingLeft = absoluteGravity != 1 ? absoluteGravity != 5 ? getPaddingLeft() : ((getPaddingLeft() + i3) - i) - this.mTotalLength : getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        if (isLayoutRtl) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i17 = 0;
        while (i17 < virtualChildCount) {
            int i18 = (i6 * i17) + i5;
            View virtualChildAt = getVirtualChildAt(i18);
            if (virtualChildAt == null) {
                paddingLeft = measureNullChild(i18) + paddingLeft;
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i19 = i17;
                if (z) {
                    i7 = virtualChildCount;
                    if (((LinearLayout.LayoutParams) layoutParams).height != -1) {
                        i8 = virtualChildAt.getBaseline();
                        i9 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                        if (i9 < 0) {
                            i9 = i16;
                        }
                        i10 = i9 & 112;
                        i11 = i16;
                        if (i10 != 16) {
                            i12 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + ((LinearLayout.LayoutParams) layoutParams).topMargin) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        } else if (i10 == 48) {
                            i12 = ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop;
                            if (i8 != -1) {
                                i12 = (iArr[1] - i8) + i12;
                            }
                        } else if (i10 != 80) {
                            i12 = paddingTop;
                        } else {
                            i12 = (paddingBottom - measuredHeight) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            if (i8 != -1) {
                                i12 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - i8);
                            }
                        }
                        if (hasDividerBeforeChildAt(i18)) {
                            paddingLeft += this.mDividerWidth;
                        }
                        int i20 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                        i13 = paddingTop;
                        setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i20, i12, measuredWidth, measuredHeight);
                        paddingLeft = getNextLocationOffset(virtualChildAt) + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + i20;
                        i17 = getChildrenSkipCount(virtualChildAt, i18) + i19;
                        i17++;
                        virtualChildCount = i7;
                        i16 = i11;
                        paddingTop = i13;
                    }
                } else {
                    i7 = virtualChildCount;
                }
                i8 = -1;
                i9 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                if (i9 < 0) {
                }
                i10 = i9 & 112;
                i11 = i16;
                if (i10 != 16) {
                }
                if (hasDividerBeforeChildAt(i18)) {
                }
                int i202 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                i13 = paddingTop;
                setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i202, i12, measuredWidth, measuredHeight);
                paddingLeft = getNextLocationOffset(virtualChildAt) + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + i202;
                i17 = getChildrenSkipCount(virtualChildAt, i18) + i19;
                i17++;
                virtualChildCount = i7;
                i16 = i11;
                paddingTop = i13;
            }
            i13 = paddingTop;
            i7 = virtualChildCount;
            i11 = i16;
            i17++;
            virtualChildCount = i7;
            i16 = i11;
            paddingTop = i13;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutVertical(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int i7 = i3 - i;
        int paddingRight = i7 - getPaddingRight();
        int paddingRight2 = (i7 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i8 = this.mGravity;
        int i9 = i8 & 112;
        int i10 = i8 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int paddingTop = i9 != 16 ? i9 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.mTotalLength : getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
        int i11 = 0;
        while (i11 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i11);
            if (virtualChildAt == null) {
                paddingTop = measureNullChild(i11) + paddingTop;
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i12 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                if (i12 < 0) {
                    i12 = i10;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i12, ViewCompat.getLayoutDirection(this)) & 7;
                if (absoluteGravity == 1) {
                    i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                } else if (absoluteGravity != 5) {
                    i6 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                    int i13 = i6;
                    if (hasDividerBeforeChildAt(i11)) {
                        paddingTop += this.mDividerHeight;
                    }
                    int i14 = paddingTop + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    setChildFrame(virtualChildAt, i13, getLocationOffset(virtualChildAt) + i14, measuredWidth, measuredHeight);
                    paddingTop = getNextLocationOffset(virtualChildAt) + measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i14;
                    i11 += getChildrenSkipCount(virtualChildAt, i11);
                } else {
                    i5 = paddingRight - measuredWidth;
                }
                i6 = i5 - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                int i132 = i6;
                if (hasDividerBeforeChildAt(i11)) {
                }
                int i142 = paddingTop + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                setChildFrame(virtualChildAt, i132, getLocationOffset(virtualChildAt) + i142, measuredWidth, measuredHeight);
                paddingTop = getNextLocationOffset(virtualChildAt) + measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i142;
                i11 += getChildrenSkipCount(virtualChildAt, i11);
            }
            i11++;
        }
    }

    public void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:172:0x03a9, code lost:
        if (r8 > 0) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x03b6, code lost:
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x03b7, code lost:
        r14.measure(android.view.View.MeasureSpec.makeMeasureSpec(r8, r3), r0);
        r9 = android.view.View.combineMeasuredStates(r9, r14.getMeasuredState() & (-16777216));
        r0 = r0;
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x03b4, code lost:
        if (r8 < 0) goto L173;
     */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measureHorizontal(int i, int i2) {
        int[] iArr;
        int i3;
        int max;
        int i4;
        int i5;
        int max2;
        int i6;
        int i7;
        int i8;
        float f;
        int i9;
        boolean z;
        int baseline;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z2;
        boolean z3;
        View view;
        int i15;
        boolean z4;
        int measuredHeight;
        int childrenSkipCount;
        int baseline2;
        int i16;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr2 = this.mMaxAscent;
        int[] iArr3 = this.mMaxDescent;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z5 = this.mBaselineAligned;
        boolean z6 = this.mUseLargestChild;
        int i17 = 1073741824;
        boolean z7 = mode == 1073741824;
        float f2 = 0.0f;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        boolean z8 = false;
        int i23 = 0;
        boolean z9 = true;
        boolean z10 = false;
        while (true) {
            iArr = iArr3;
            if (i18 >= virtualChildCount) {
                break;
            }
            View virtualChildAt = getVirtualChildAt(i18);
            if (virtualChildAt == null) {
                this.mTotalLength = measureNullChild(i18) + this.mTotalLength;
            } else if (virtualChildAt.getVisibility() == 8) {
                i18 += getChildrenSkipCount(virtualChildAt, i18);
            } else {
                if (hasDividerBeforeChildAt(i18)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                float f3 = ((LinearLayout.LayoutParams) layoutParams).weight;
                float f4 = f2 + f3;
                if (mode == i17 && ((LinearLayout.LayoutParams) layoutParams).width == 0 && f3 > 0.0f) {
                    int i24 = this.mTotalLength;
                    if (z7) {
                        this.mTotalLength = ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin + i24;
                    } else {
                        this.mTotalLength = Math.max(i24, ((LinearLayout.LayoutParams) layoutParams).leftMargin + i24 + ((LinearLayout.LayoutParams) layoutParams).rightMargin);
                    }
                    if (z5) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                        i14 = i18;
                        z2 = z6;
                        z3 = z5;
                        view = virtualChildAt;
                    } else {
                        i14 = i18;
                        z2 = z6;
                        z3 = z5;
                        view = virtualChildAt;
                        i15 = 1073741824;
                        z8 = true;
                        if (mode2 == i15 && ((LinearLayout.LayoutParams) layoutParams).height == -1) {
                            z4 = true;
                            z10 = true;
                        } else {
                            z4 = false;
                        }
                        int i25 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i25;
                        i23 = View.combineMeasuredStates(i23, view.getMeasuredState());
                        if (z3 && (baseline2 = view.getBaseline()) != -1) {
                            i16 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                            if (i16 < 0) {
                                i16 = this.mGravity;
                            }
                            int i26 = (((i16 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i26] = Math.max(iArr2[i26], baseline2);
                            iArr[i26] = Math.max(iArr[i26], measuredHeight - baseline2);
                        }
                        i20 = Math.max(i20, measuredHeight);
                        z9 = !z9 && ((LinearLayout.LayoutParams) layoutParams).height == -1;
                        if (((LinearLayout.LayoutParams) layoutParams).weight <= 0.0f) {
                            if (!z4) {
                                i25 = measuredHeight;
                            }
                            i22 = Math.max(i22, i25);
                        } else {
                            int i27 = i22;
                            if (!z4) {
                                i25 = measuredHeight;
                            }
                            i21 = Math.max(i21, i25);
                            i22 = i27;
                        }
                        int i28 = i14;
                        childrenSkipCount = getChildrenSkipCount(view, i28) + i28;
                        f2 = f4;
                        i18 = childrenSkipCount + 1;
                        iArr3 = iArr;
                        z6 = z2;
                        z5 = z3;
                        i17 = 1073741824;
                    }
                } else {
                    if (((LinearLayout.LayoutParams) layoutParams).width != 0 || ((LinearLayout.LayoutParams) layoutParams).weight <= 0.0f) {
                        i13 = Integer.MIN_VALUE;
                    } else {
                        ((LinearLayout.LayoutParams) layoutParams).width = -2;
                        i13 = 0;
                    }
                    i14 = i18;
                    int i29 = i13;
                    z2 = z6;
                    z3 = z5;
                    measureChildBeforeLayout(virtualChildAt, i14, i, f4 == 0.0f ? this.mTotalLength : 0, i2, 0);
                    if (i29 != Integer.MIN_VALUE) {
                        ((LinearLayout.LayoutParams) layoutParams).width = i29;
                    }
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    if (z7) {
                        view = virtualChildAt;
                        this.mTotalLength = getNextLocationOffset(view) + ((LinearLayout.LayoutParams) layoutParams).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + this.mTotalLength;
                    } else {
                        view = virtualChildAt;
                        int i30 = this.mTotalLength;
                        this.mTotalLength = Math.max(i30, getNextLocationOffset(view) + i30 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin);
                    }
                    if (z2) {
                        i19 = Math.max(measuredWidth, i19);
                    }
                }
                i15 = 1073741824;
                if (mode2 == i15) {
                }
                z4 = false;
                int i252 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                measuredHeight = view.getMeasuredHeight() + i252;
                i23 = View.combineMeasuredStates(i23, view.getMeasuredState());
                if (z3) {
                    i16 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                    if (i16 < 0) {
                    }
                    int i262 = (((i16 & 112) >> 4) & (-2)) >> 1;
                    iArr2[i262] = Math.max(iArr2[i262], baseline2);
                    iArr[i262] = Math.max(iArr[i262], measuredHeight - baseline2);
                }
                i20 = Math.max(i20, measuredHeight);
                if (!z9) {
                }
                if (((LinearLayout.LayoutParams) layoutParams).weight <= 0.0f) {
                }
                int i282 = i14;
                childrenSkipCount = getChildrenSkipCount(view, i282) + i282;
                f2 = f4;
                i18 = childrenSkipCount + 1;
                iArr3 = iArr;
                z6 = z2;
                z5 = z3;
                i17 = 1073741824;
            }
            childrenSkipCount = i18;
            z2 = z6;
            z3 = z5;
            i18 = childrenSkipCount + 1;
            iArr3 = iArr;
            z6 = z2;
            z5 = z3;
            i17 = 1073741824;
        }
        boolean z11 = z6;
        boolean z12 = z5;
        int i31 = i20;
        int i32 = i21;
        int i33 = i22;
        int i34 = i23;
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            max = i31;
            i3 = i34;
        } else {
            i3 = i34;
            max = Math.max(i31, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z11 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int i35 = 0;
            while (i35 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i35);
                if (virtualChildAt2 == null) {
                    this.mTotalLength = measureNullChild(i35) + this.mTotalLength;
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i35 += getChildrenSkipCount(virtualChildAt2, i35);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    int i36 = this.mTotalLength;
                    if (z7) {
                        this.mTotalLength = getNextLocationOffset(virtualChildAt2) + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + i19 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + i36;
                    } else {
                        i12 = max;
                        this.mTotalLength = Math.max(i36, getNextLocationOffset(virtualChildAt2) + i36 + i19 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin);
                        i35++;
                        max = i12;
                    }
                }
                i12 = max;
                i35++;
                max = i12;
            }
        }
        int i37 = max;
        int paddingRight = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
        this.mTotalLength = paddingRight;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, 0);
        int i38 = (16777215 & resolveSizeAndState) - this.mTotalLength;
        if (z8 || (i38 != 0 && f2 > 0.0f)) {
            float f5 = this.mWeightSum;
            if (f5 > 0.0f) {
                f2 = f5;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.mTotalLength = 0;
            int i39 = i32;
            int i40 = i3;
            int i41 = -1;
            int i42 = 0;
            while (i42 < virtualChildCount) {
                View virtualChildAt3 = getVirtualChildAt(i42);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    i7 = i38;
                    i8 = virtualChildCount;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f6 = ((LinearLayout.LayoutParams) layoutParams3).weight;
                    if (f6 > 0.0f) {
                        int i43 = (int) ((i38 * f6) / f2);
                        float f7 = f2 - f6;
                        int i44 = i38 - i43;
                        i8 = virtualChildCount;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop() + ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin, ((LinearLayout.LayoutParams) layoutParams3).height);
                        if (((LinearLayout.LayoutParams) layoutParams3).width == 0) {
                            i11 = 1073741824;
                            if (mode == 1073741824) {
                            }
                        } else {
                            i11 = 1073741824;
                        }
                        i43 = virtualChildAt3.getMeasuredWidth() + i43;
                    } else {
                        i7 = i38;
                        i8 = virtualChildCount;
                    }
                    int i45 = this.mTotalLength;
                    if (z7) {
                        this.mTotalLength = getNextLocationOffset(virtualChildAt3) + virtualChildAt3.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + i45;
                        f = f2;
                    } else {
                        f = f2;
                        this.mTotalLength = Math.max(i45, getNextLocationOffset(virtualChildAt3) + virtualChildAt3.getMeasuredWidth() + i45 + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin);
                    }
                    boolean z13 = mode2 != 1073741824 && ((LinearLayout.LayoutParams) layoutParams3).height == -1;
                    int i46 = ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i46;
                    i41 = Math.max(i41, measuredHeight2);
                    if (!z13) {
                        i46 = measuredHeight2;
                    }
                    int max3 = Math.max(i39, i46);
                    if (z9) {
                        i9 = -1;
                        if (((LinearLayout.LayoutParams) layoutParams3).height == -1) {
                            z = true;
                            if (z12 && (baseline = virtualChildAt3.getBaseline()) != i9) {
                                i10 = ((LinearLayout.LayoutParams) layoutParams3).gravity;
                                if (i10 < 0) {
                                    i10 = this.mGravity;
                                }
                                int i47 = (((i10 & 112) >> 4) & (-2)) >> 1;
                                iArr2[i47] = Math.max(iArr2[i47], baseline);
                                iArr[i47] = Math.max(iArr[i47], measuredHeight2 - baseline);
                            }
                            z9 = z;
                            i39 = max3;
                            f2 = f;
                        }
                    } else {
                        i9 = -1;
                    }
                    z = false;
                    if (z12) {
                        i10 = ((LinearLayout.LayoutParams) layoutParams3).gravity;
                        if (i10 < 0) {
                        }
                        int i472 = (((i10 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i472] = Math.max(iArr2[i472], baseline);
                        iArr[i472] = Math.max(iArr[i472], measuredHeight2 - baseline);
                    }
                    z9 = z;
                    i39 = max3;
                    f2 = f;
                }
                i42++;
                i38 = i7;
                virtualChildCount = i8;
            }
            i4 = i2;
            i5 = virtualChildCount;
            this.mTotalLength = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
            max2 = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i41 : Math.max(i41, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            i6 = i39;
            i3 = i40;
        } else {
            i6 = Math.max(i32, i33);
            if (z11 && mode != 1073741824) {
                for (int i48 = 0; i48 < virtualChildCount; i48++) {
                    View virtualChildAt4 = getVirtualChildAt(i48);
                    if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt4.getLayoutParams())).weight > 0.0f) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(i19, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i4 = i2;
            i5 = virtualChildCount;
            max2 = i37;
        }
        if (z9 || mode2 == 1073741824) {
            i6 = max2;
        }
        setMeasuredDimension(resolveSizeAndState | (i3 & (-16777216)), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + i6, getSuggestedMinimumHeight()), i4, i3 << 16));
        if (z10) {
            forceUniformHeight(i5, i);
        }
    }

    public int measureNullChild(int i) {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:148:0x02d3, code lost:
        if (r15 > 0) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02e0, code lost:
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02e1, code lost:
        r13.measure(r0, android.view.View.MeasureSpec.makeMeasureSpec(r15, r10));
        r1 = android.view.View.combineMeasuredStates(r1, r13.getMeasuredState() & androidx.core.view.InputDeviceCompat.SOURCE_ANY);
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x02de, code lost:
        if (r15 < 0) goto L149;
     */
    /* JADX WARN: Removed duplicated region for block: B:157:0x031e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        View view;
        int max;
        boolean z2;
        int max2;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i19 = this.mBaselineAlignedChildIndex;
        boolean z3 = this.mUseLargestChild;
        float f = 0.0f;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            int i26 = 8;
            int i27 = i23;
            if (i25 >= virtualChildCount) {
                int i28 = i20;
                int i29 = i22;
                int i30 = i24;
                int i31 = virtualChildCount;
                int i32 = mode2;
                int i33 = i21;
                if (this.mTotalLength > 0) {
                    i3 = i31;
                    if (hasDividerBeforeChildAt(i3)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i3 = i31;
                }
                if (z3 && (i32 == Integer.MIN_VALUE || i32 == 0)) {
                    this.mTotalLength = 0;
                    int i34 = 0;
                    while (i34 < i3) {
                        View virtualChildAt = getVirtualChildAt(i34);
                        if (virtualChildAt == null) {
                            this.mTotalLength = measureNullChild(i34) + this.mTotalLength;
                        } else if (virtualChildAt.getVisibility() == i26) {
                            i34 += getChildrenSkipCount(virtualChildAt, i34);
                        } else {
                            LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                            int i35 = this.mTotalLength;
                            this.mTotalLength = Math.max(i35, getNextLocationOffset(virtualChildAt) + i35 + i29 + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin);
                        }
                        i34++;
                        i26 = 8;
                    }
                }
                int paddingBottom = getPaddingBottom() + getPaddingTop() + this.mTotalLength;
                this.mTotalLength = paddingBottom;
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, 0);
                int i36 = (16777215 & resolveSizeAndState) - this.mTotalLength;
                if (z4 || (i36 != 0 && f > 0.0f)) {
                    float f2 = this.mWeightSum;
                    if (f2 > 0.0f) {
                        f = f2;
                    }
                    this.mTotalLength = 0;
                    int i37 = i36;
                    int i38 = i30;
                    i4 = i28;
                    int i39 = 0;
                    while (i39 < i3) {
                        View virtualChildAt2 = getVirtualChildAt(i39);
                        if (virtualChildAt2.getVisibility() == 8) {
                            i7 = i37;
                        } else {
                            LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                            float f3 = ((LinearLayout.LayoutParams) layoutParams2).weight;
                            if (f3 > 0.0f) {
                                int i40 = (int) ((i37 * f3) / f);
                                float f4 = f - f3;
                                i7 = i37 - i40;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin, ((LinearLayout.LayoutParams) layoutParams2).width);
                                if (((LinearLayout.LayoutParams) layoutParams2).height == 0) {
                                    i10 = 1073741824;
                                    if (i32 == 1073741824) {
                                    }
                                } else {
                                    i10 = 1073741824;
                                }
                                i40 = virtualChildAt2.getMeasuredHeight() + i40;
                            } else {
                                i7 = i37;
                            }
                            int i41 = ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                            int measuredWidth = virtualChildAt2.getMeasuredWidth() + i41;
                            i33 = Math.max(i33, measuredWidth);
                            float f5 = f;
                            if (mode != 1073741824) {
                                i8 = i4;
                                i9 = -1;
                                if (((LinearLayout.LayoutParams) layoutParams2).width == -1) {
                                    z = true;
                                    if (!z) {
                                        i41 = measuredWidth;
                                    }
                                    int max3 = Math.max(i38, i41);
                                    boolean z7 = !z5 && ((LinearLayout.LayoutParams) layoutParams2).width == i9;
                                    int i42 = this.mTotalLength;
                                    this.mTotalLength = Math.max(i42, getNextLocationOffset(virtualChildAt2) + virtualChildAt2.getMeasuredHeight() + i42 + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin);
                                    z5 = z7;
                                    i4 = i8;
                                    i38 = max3;
                                    f = f5;
                                }
                            } else {
                                i8 = i4;
                                i9 = -1;
                            }
                            z = false;
                            if (!z) {
                            }
                            int max32 = Math.max(i38, i41);
                            if (!z5) {
                            }
                            int i422 = this.mTotalLength;
                            this.mTotalLength = Math.max(i422, getNextLocationOffset(virtualChildAt2) + virtualChildAt2.getMeasuredHeight() + i422 + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin);
                            z5 = z7;
                            i4 = i8;
                            i38 = max32;
                            f = f5;
                        }
                        i39++;
                        i37 = i7;
                    }
                    i5 = i;
                    this.mTotalLength = getPaddingBottom() + getPaddingTop() + this.mTotalLength;
                    i6 = i38;
                } else {
                    i6 = Math.max(i30, i27);
                    if (z3 && i32 != 1073741824) {
                        for (int i43 = 0; i43 < i3; i43++) {
                            View virtualChildAt3 = getVirtualChildAt(i43);
                            if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt3.getLayoutParams())).weight > 0.0f) {
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i29, 1073741824));
                            }
                        }
                    }
                    i5 = i;
                    i4 = i28;
                }
                if (z5 || mode == 1073741824) {
                    i6 = i33;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + i6, getSuggestedMinimumWidth()), i5, i4), resolveSizeAndState);
                if (!z6) {
                    return;
                }
                forceUniformWidth(i3, i2);
                return;
            }
            View virtualChildAt4 = getVirtualChildAt(i25);
            if (virtualChildAt4 == null) {
                this.mTotalLength = measureNullChild(i25) + this.mTotalLength;
                i14 = virtualChildCount;
                i15 = mode2;
                i23 = i27;
            } else {
                int i44 = i20;
                if (virtualChildAt4.getVisibility() == 8) {
                    i25 += getChildrenSkipCount(virtualChildAt4, i25);
                    i14 = virtualChildCount;
                    i23 = i27;
                    i20 = i44;
                    i15 = mode2;
                } else {
                    if (hasDividerBeforeChildAt(i25)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt4.getLayoutParams();
                    float f6 = ((LinearLayout.LayoutParams) layoutParams3).weight;
                    float f7 = f + f6;
                    if (mode2 == 1073741824 && ((LinearLayout.LayoutParams) layoutParams3).height == 0 && f6 > 0.0f) {
                        int i45 = this.mTotalLength;
                        this.mTotalLength = Math.max(i45, ((LinearLayout.LayoutParams) layoutParams3).topMargin + i45 + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin);
                        max = i22;
                        view = virtualChildAt4;
                        i17 = i24;
                        i12 = i44;
                        i13 = i21;
                        z4 = true;
                        i14 = virtualChildCount;
                        i15 = mode2;
                        i16 = i27;
                        i18 = i25;
                    } else {
                        int i46 = i21;
                        if (((LinearLayout.LayoutParams) layoutParams3).height != 0 || ((LinearLayout.LayoutParams) layoutParams3).weight <= 0.0f) {
                            i11 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) layoutParams3).height = -2;
                            i11 = 0;
                        }
                        i12 = i44;
                        int i47 = i11;
                        i13 = i46;
                        int i48 = i22;
                        i14 = virtualChildCount;
                        i15 = mode2;
                        i16 = i27;
                        i17 = i24;
                        i18 = i25;
                        measureChildBeforeLayout(virtualChildAt4, i25, i, 0, i2, f7 == 0.0f ? this.mTotalLength : 0);
                        if (i47 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) layoutParams3).height = i47;
                        }
                        int measuredHeight = virtualChildAt4.getMeasuredHeight();
                        int i49 = this.mTotalLength;
                        view = virtualChildAt4;
                        this.mTotalLength = Math.max(i49, getNextLocationOffset(view) + i49 + measuredHeight + ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin);
                        max = z3 ? Math.max(measuredHeight, i48) : i48;
                    }
                    if (i19 >= 0 && i19 == i18 + 1) {
                        this.mBaselineChildTop = this.mTotalLength;
                    }
                    if (i18 < i19 && ((LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || ((LinearLayout.LayoutParams) layoutParams3).width != -1) {
                        z2 = false;
                    } else {
                        z2 = true;
                        z6 = true;
                    }
                    int i50 = ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i50;
                    int max4 = Math.max(i13, measuredWidth2);
                    int combineMeasuredStates = View.combineMeasuredStates(i12, view.getMeasuredState());
                    z5 = z5 && ((LinearLayout.LayoutParams) layoutParams3).width == -1;
                    if (((LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                        if (!z2) {
                            i50 = measuredWidth2;
                        }
                        i23 = Math.max(i16, i50);
                        max2 = i17;
                    } else {
                        if (!z2) {
                            i50 = measuredWidth2;
                        }
                        max2 = Math.max(i17, i50);
                        i23 = i16;
                    }
                    i22 = max;
                    f = f7;
                    i24 = max2;
                    i20 = combineMeasuredStates;
                    i25 = getChildrenSkipCount(view, i18) + i18;
                    i21 = max4;
                }
            }
            i25++;
            mode2 = i15;
            virtualChildCount = i14;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.mBaselineAlignedChildIndex = i;
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("base aligned child index out of range (0, ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getChildCount());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        boolean z = false;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        if (drawable == null) {
            z = true;
        }
        setWillNotDraw(z);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}

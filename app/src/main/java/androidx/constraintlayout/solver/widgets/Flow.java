package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    public ConstraintWidget[] mDisplayedWidgets;
    public int mHorizontalStyle = -1;
    public int mVerticalStyle = -1;
    public int mFirstHorizontalStyle = -1;
    public int mFirstVerticalStyle = -1;
    public int mLastHorizontalStyle = -1;
    public int mLastVerticalStyle = -1;
    public float mHorizontalBias = 0.5f;
    public float mVerticalBias = 0.5f;
    public float mFirstHorizontalBias = 0.5f;
    public float mFirstVerticalBias = 0.5f;
    public float mLastHorizontalBias = 0.5f;
    public float mLastVerticalBias = 0.5f;
    public int mHorizontalGap = 0;
    public int mVerticalGap = 0;
    public int mHorizontalAlign = 2;
    public int mVerticalAlign = 2;
    public int mWrapMode = 0;
    public int mMaxElementsWrap = -1;
    public int mOrientation = 0;
    public ArrayList<WidgetsList> mChainList = new ArrayList<>();
    public ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    public ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    public int[] mAlignedDimensions = null;
    public int mDisplayedWidgetsCount = 0;

    /* loaded from: classes3.dex */
    public class WidgetsList {
        public ConstraintAnchor mBottom;
        public ConstraintAnchor mLeft;
        public int mMax;
        public int mOrientation;
        public int mPaddingBottom;
        public int mPaddingLeft;
        public int mPaddingRight;
        public int mPaddingTop;
        public ConstraintAnchor mRight;
        public ConstraintAnchor mTop;
        public ConstraintWidget biggest = null;
        public int biggestDimension = 0;
        public int mWidth = 0;
        public int mHeight = 0;
        public int mStartIndex = 0;
        public int mCount = 0;
        public int mNbMatchConstraintsWidgets = 0;

        public WidgetsList(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2) {
            this.mOrientation = 0;
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mMax = 0;
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
            this.mMax = i2;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            int i = this.mCount;
            for (int i2 = 0; i2 < i && this.mStartIndex + i2 < Flow.this.mDisplayedWidgetsCount; i2++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i2];
                if (this.mOrientation == 0) {
                    int width = constraintWidget.getWidth();
                    int i3 = Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i3 = 0;
                    }
                    this.mWidth = width + i3 + this.mWidth;
                    int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.biggest == null || this.biggestDimension < widgetHeight) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetHeight;
                        this.mHeight = widgetHeight;
                    }
                } else {
                    int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                    int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    int i4 = Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i4 = 0;
                    }
                    this.mHeight = widgetHeight2 + i4 + this.mHeight;
                    if (this.biggest == null || this.biggestDimension < widgetWidth) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetWidth;
                        this.mWidth = widgetWidth;
                    }
                }
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            int i = 0;
            if (this.mOrientation == 0) {
                int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetWidth = 0;
                }
                int i2 = Flow.this.mHorizontalGap;
                if (constraintWidget.getVisibility() != 8) {
                    i = i2;
                }
                this.mWidth = widgetWidth + i + this.mWidth;
                int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.biggest == null || this.biggestDimension < widgetHeight) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetHeight;
                    this.mHeight = widgetHeight;
                }
            } else {
                int widgetWidth2 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetHeight2 = 0;
                }
                int i3 = Flow.this.mVerticalGap;
                if (constraintWidget.getVisibility() != 8) {
                    i = i3;
                }
                this.mHeight = widgetHeight2 + i + this.mHeight;
                if (this.biggest == null || this.biggestDimension < widgetWidth2) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetWidth2;
                    this.mWidth = widgetWidth2;
                }
            }
            this.mCount++;
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:138:0x024c  */
        /* JADX WARN: Removed duplicated region for block: B:150:0x029a  */
        /* JADX WARN: Removed duplicated region for block: B:152:0x02a5  */
        /* JADX WARN: Removed duplicated region for block: B:159:0x02d0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void createConstraints(boolean z, int i, boolean z2) {
            ConstraintAnchor constraintAnchor;
            ConstraintAnchor constraintAnchor2;
            int i2;
            ConstraintWidget constraintWidget;
            ConstraintAnchor constraintAnchor3;
            ConstraintAnchor constraintAnchor4;
            ConstraintAnchor constraintAnchor5;
            ConstraintAnchor constraintAnchor6;
            ConstraintWidget constraintWidget2;
            ConstraintAnchor constraintAnchor7;
            ConstraintAnchor constraintAnchor8;
            int i3 = this.mCount;
            for (int i4 = 0; i4 < i3 && this.mStartIndex + i4 < Flow.this.mDisplayedWidgetsCount; i4++) {
                ConstraintWidget constraintWidget3 = Flow.this.mDisplayedWidgets[this.mStartIndex + i4];
                if (constraintWidget3 != null) {
                    constraintWidget3.resetAnchors();
                }
            }
            if (i3 == 0 || this.biggest == null) {
                return;
            }
            boolean z3 = z2 && i == 0;
            int i5 = -1;
            int i6 = -1;
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = z ? (i3 - 1) - i7 : i7;
                if (this.mStartIndex + i8 >= Flow.this.mDisplayedWidgetsCount) {
                    break;
                }
                if (Flow.this.mDisplayedWidgets[this.mStartIndex + i8].getVisibility() == 0) {
                    if (i5 == -1) {
                        i5 = i7;
                    }
                    i6 = i7;
                }
            }
            ConstraintWidget constraintWidget4 = null;
            if (this.mOrientation == 0) {
                ConstraintWidget constraintWidget5 = this.biggest;
                constraintWidget5.setVerticalChainStyle(Flow.this.mVerticalStyle);
                int i9 = this.mPaddingTop;
                if (i > 0) {
                    i9 += Flow.this.mVerticalGap;
                }
                constraintWidget5.mTop.connect(this.mTop, i9);
                if (z2) {
                    constraintWidget5.mBottom.connect(this.mBottom, this.mPaddingBottom);
                }
                if (i > 0) {
                    this.mTop.mOwner.mBottom.connect(constraintWidget5.mTop, 0);
                }
                if (Flow.this.mVerticalAlign == 3 && !constraintWidget5.hasBaseline()) {
                    for (int i10 = 0; i10 < i3; i10++) {
                        int i11 = z ? (i3 - 1) - i10 : i10;
                        if (this.mStartIndex + i11 >= Flow.this.mDisplayedWidgetsCount) {
                            break;
                        }
                        constraintWidget2 = Flow.this.mDisplayedWidgets[this.mStartIndex + i11];
                        if (constraintWidget2.hasBaseline()) {
                            break;
                        }
                    }
                }
                constraintWidget2 = constraintWidget5;
                int i12 = 0;
                while (i12 < i3) {
                    int i13 = z ? (i3 - 1) - i12 : i12;
                    if (this.mStartIndex + i13 >= Flow.this.mDisplayedWidgetsCount) {
                        return;
                    }
                    ConstraintWidget constraintWidget6 = Flow.this.mDisplayedWidgets[this.mStartIndex + i13];
                    if (i12 == 0) {
                        constraintWidget6.connect(constraintWidget6.mLeft, this.mLeft, this.mPaddingLeft);
                    }
                    if (i13 == 0) {
                        int i14 = Flow.this.mHorizontalStyle;
                        float f = Flow.this.mHorizontalBias;
                        if (this.mStartIndex == 0 && Flow.this.mFirstHorizontalStyle != -1) {
                            i14 = Flow.this.mFirstHorizontalStyle;
                            f = Flow.this.mFirstHorizontalBias;
                        } else if (z2 && Flow.this.mLastHorizontalStyle != -1) {
                            i14 = Flow.this.mLastHorizontalStyle;
                            f = Flow.this.mLastHorizontalBias;
                        }
                        constraintWidget6.setHorizontalChainStyle(i14);
                        constraintWidget6.setHorizontalBiasPercent(f);
                    }
                    if (i12 == i3 - 1) {
                        constraintWidget6.connect(constraintWidget6.mRight, this.mRight, this.mPaddingRight);
                    }
                    if (constraintWidget4 != null) {
                        constraintWidget6.mLeft.connect(constraintWidget4.mRight, Flow.this.mHorizontalGap);
                        if (i12 == i5) {
                            constraintWidget6.mLeft.setGoneMargin(this.mPaddingLeft);
                        }
                        constraintWidget4.mRight.connect(constraintWidget6.mLeft, 0);
                        if (i12 == i6 + 1) {
                            constraintWidget4.mRight.setGoneMargin(this.mPaddingRight);
                        }
                    }
                    if (constraintWidget6 != constraintWidget5) {
                        if (Flow.this.mVerticalAlign != 3 || !constraintWidget2.hasBaseline() || constraintWidget6 == constraintWidget2 || !constraintWidget6.hasBaseline()) {
                            int i15 = Flow.this.mVerticalAlign;
                            if (i15 != 0) {
                                if (i15 != 1) {
                                    ConstraintAnchor constraintAnchor9 = constraintWidget6.mTop;
                                    if (z3) {
                                        constraintAnchor9.connect(this.mTop, this.mPaddingTop);
                                        constraintWidget6.mBottom.connect(this.mBottom, this.mPaddingBottom);
                                    } else {
                                        constraintAnchor9.connect(constraintWidget5.mTop, 0);
                                    }
                                }
                                constraintAnchor7 = constraintWidget6.mBottom;
                                constraintAnchor8 = constraintWidget5.mBottom;
                            } else {
                                constraintAnchor7 = constraintWidget6.mTop;
                                constraintAnchor8 = constraintWidget5.mTop;
                            }
                        } else {
                            constraintAnchor7 = constraintWidget6.mBaseline;
                            constraintAnchor8 = constraintWidget2.mBaseline;
                        }
                        constraintAnchor7.connect(constraintAnchor8, 0);
                    }
                    i12++;
                    constraintWidget4 = constraintWidget6;
                }
                return;
            }
            ConstraintWidget constraintWidget7 = this.biggest;
            constraintWidget7.setHorizontalChainStyle(Flow.this.mHorizontalStyle);
            int i16 = this.mPaddingLeft;
            if (i > 0) {
                i16 += Flow.this.mHorizontalGap;
            }
            if (!z) {
                constraintWidget7.mLeft.connect(this.mLeft, i16);
                if (z2) {
                    constraintWidget7.mRight.connect(this.mRight, this.mPaddingRight);
                }
                if (i > 0) {
                    constraintAnchor = this.mLeft.mOwner.mRight;
                    constraintAnchor2 = constraintWidget7.mLeft;
                    constraintAnchor.connect(constraintAnchor2, 0);
                }
                i2 = 0;
                while (i2 < i3) {
                    constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i2];
                    if (i2 == 0) {
                    }
                    if (i2 == i3 - 1) {
                    }
                    if (constraintWidget4 != null) {
                    }
                    if (constraintWidget != constraintWidget7) {
                    }
                    i2++;
                    constraintWidget4 = constraintWidget;
                }
                return;
            }
            constraintWidget7.mRight.connect(this.mRight, i16);
            if (z2) {
                constraintWidget7.mLeft.connect(this.mLeft, this.mPaddingRight);
            }
            if (i > 0) {
                constraintAnchor = this.mRight.mOwner.mLeft;
                constraintAnchor2 = constraintWidget7.mRight;
                constraintAnchor.connect(constraintAnchor2, 0);
            }
            i2 = 0;
            while (i2 < i3 && this.mStartIndex + i2 < Flow.this.mDisplayedWidgetsCount) {
                constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i2];
                if (i2 == 0) {
                    constraintWidget.connect(constraintWidget.mTop, this.mTop, this.mPaddingTop);
                    int i17 = Flow.this.mVerticalStyle;
                    float f2 = Flow.this.mVerticalBias;
                    if (this.mStartIndex == 0 && Flow.this.mFirstVerticalStyle != -1) {
                        i17 = Flow.this.mFirstVerticalStyle;
                        f2 = Flow.this.mFirstVerticalBias;
                    } else if (z2 && Flow.this.mLastVerticalStyle != -1) {
                        i17 = Flow.this.mLastVerticalStyle;
                        f2 = Flow.this.mLastVerticalBias;
                    }
                    constraintWidget.setVerticalChainStyle(i17);
                    constraintWidget.setVerticalBiasPercent(f2);
                }
                if (i2 == i3 - 1) {
                    constraintWidget.connect(constraintWidget.mBottom, this.mBottom, this.mPaddingBottom);
                }
                if (constraintWidget4 != null) {
                    constraintWidget.mTop.connect(constraintWidget4.mBottom, Flow.this.mVerticalGap);
                    if (i2 == i5) {
                        constraintWidget.mTop.setGoneMargin(this.mPaddingTop);
                    }
                    constraintWidget4.mBottom.connect(constraintWidget.mTop, 0);
                    if (i2 == i6 + 1) {
                        constraintWidget4.mBottom.setGoneMargin(this.mPaddingBottom);
                    }
                }
                if (constraintWidget != constraintWidget7) {
                    int i18 = Flow.this.mHorizontalAlign;
                    if (z) {
                        if (i18 != 0) {
                            if (i18 == 1) {
                                constraintAnchor5 = constraintWidget.mLeft;
                                constraintAnchor6 = constraintWidget7.mLeft;
                                constraintAnchor5.connect(constraintAnchor6, 0);
                            } else if (i18 == 2) {
                                constraintWidget.mLeft.connect(constraintWidget7.mLeft, 0);
                            }
                        }
                        constraintAnchor5 = constraintWidget.mRight;
                        constraintAnchor6 = constraintWidget7.mRight;
                        constraintAnchor5.connect(constraintAnchor6, 0);
                    } else {
                        if (i18 != 0) {
                            if (i18 != 1) {
                                if (i18 == 2) {
                                    ConstraintAnchor constraintAnchor10 = constraintWidget.mLeft;
                                    if (z3) {
                                        constraintAnchor10.connect(this.mLeft, this.mPaddingLeft);
                                        constraintWidget.mRight.connect(this.mRight, this.mPaddingRight);
                                    } else {
                                        constraintAnchor10.connect(constraintWidget7.mLeft, 0);
                                    }
                                }
                                i2++;
                                constraintWidget4 = constraintWidget;
                            }
                            constraintAnchor3 = constraintWidget.mRight;
                            constraintAnchor4 = constraintWidget7.mRight;
                        } else {
                            constraintAnchor3 = constraintWidget.mLeft;
                            constraintAnchor4 = constraintWidget7.mLeft;
                        }
                        constraintAnchor3.connect(constraintAnchor4, 0);
                        i2++;
                        constraintWidget4 = constraintWidget;
                    }
                }
                i2++;
                constraintWidget4 = constraintWidget;
            }
        }

        public int getHeight() {
            return this.mOrientation == 1 ? this.mHeight - Flow.this.mVerticalGap : this.mHeight;
        }

        public int getWidth() {
            return this.mOrientation == 0 ? this.mWidth - Flow.this.mHorizontalGap : this.mWidth;
        }

        public void measureMatchConstraints(int i) {
            Flow flow;
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour;
            int width;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour;
            int i2;
            int i3 = this.mNbMatchConstraintsWidgets;
            if (i3 == 0) {
                return;
            }
            int i4 = this.mCount;
            int i5 = i / i3;
            for (int i6 = 0; i6 < i4 && this.mStartIndex + i6 < Flow.this.mDisplayedWidgetsCount; i6++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i6];
                if (this.mOrientation == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        flow = Flow.this;
                        horizontalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
                        dimensionBehaviour = constraintWidget.getVerticalDimensionBehaviour();
                        i2 = constraintWidget.getHeight();
                        width = i5;
                        flow.measure(constraintWidget, horizontalDimensionBehaviour, width, dimensionBehaviour, i2);
                    }
                } else {
                    if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                        flow = Flow.this;
                        horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
                        width = constraintWidget.getWidth();
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
                        i2 = i5;
                        flow.measure(constraintWidget, horizontalDimensionBehaviour, width, dimensionBehaviour, i2);
                    }
                }
            }
            recomputeDimensions();
        }

        public void setStartIndex(int i) {
            this.mStartIndex = i;
        }

        public void setup(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2, int i3, int i4, int i5, int i6) {
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i2;
            this.mPaddingTop = i3;
            this.mPaddingRight = i4;
            this.mPaddingBottom = i5;
            this.mMax = i6;
        }
    }

    private void createAlignedConstraints(boolean z) {
        ConstraintWidget constraintWidget;
        if (this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null) {
            return;
        }
        for (int i = 0; i < this.mDisplayedWidgetsCount; i++) {
            this.mDisplayedWidgets[i].resetAnchors();
        }
        int[] iArr = this.mAlignedDimensions;
        int i2 = iArr[0];
        int i3 = iArr[1];
        ConstraintWidget constraintWidget2 = null;
        for (int i4 = 0; i4 < i2; i4++) {
            ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[z ? (i2 - i4) - 1 : i4];
            if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                if (i4 == 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                    constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                    constraintWidget3.setHorizontalBiasPercent(this.mHorizontalBias);
                }
                if (i4 == i2 - 1) {
                    constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                }
                if (i4 > 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                    constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
        }
        for (int i5 = 0; i5 < i3; i5++) {
            ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i5];
            if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                if (i5 == 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                    constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                    constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                }
                if (i5 == i3 - 1) {
                    constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                }
                if (i5 > 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                    constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = (i7 * i2) + i6;
                if (this.mOrientation == 1) {
                    i8 = (i6 * i3) + i7;
                }
                ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                if (i8 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i8]) != null && constraintWidget.getVisibility() != 8) {
                    ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i6];
                    ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i7];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                        constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                        constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetHeight(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i2 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (constraintWidget.mMatchConstraintPercentHeight * i);
                if (i3 != constraintWidget.getHeight()) {
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i3);
                }
                return i3;
            } else if (i2 == 1) {
                return constraintWidget.getHeight();
            } else {
                if (i2 == 3) {
                    return (int) ((constraintWidget.getWidth() * constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
        }
        return constraintWidget.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetWidth(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i2 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (constraintWidget.mMatchConstraintPercentWidth * i);
                if (i3 != constraintWidget.getWidth()) {
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i3, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i3;
            } else if (i2 == 1) {
                return constraintWidget.getWidth();
            } else {
                if (i2 == 3) {
                    return (int) ((constraintWidget.getHeight() * constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
        }
        return constraintWidget.getWidth();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0119 -> B:21:0x0061). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x011b -> B:21:0x0061). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x0121 -> B:21:0x0061). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0123 -> B:21:0x0061). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void measureAligned(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        int i4;
        boolean z;
        ConstraintWidget constraintWidget;
        int i5 = this.mMaxElementsWrap;
        if (i2 == 0) {
            if (i5 <= 0) {
                i5 = 0;
                int i6 = 0;
                for (int i7 = 0; i7 < i; i7++) {
                    if (i7 > 0) {
                        i6 += this.mHorizontalGap;
                    }
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i7];
                    if (constraintWidget2 != null) {
                        i6 += getWidgetWidth(constraintWidget2, i3);
                        if (i6 > i3) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            i4 = i5;
            i5 = 0;
        } else {
            if (i5 <= 0) {
                i5 = 0;
                int i8 = 0;
                for (int i9 = 0; i9 < i; i9++) {
                    if (i9 > 0) {
                        i8 += this.mVerticalGap;
                    }
                    ConstraintWidget constraintWidget3 = constraintWidgetArr[i9];
                    if (constraintWidget3 != null) {
                        i8 += getWidgetHeight(constraintWidget3, i3);
                        if (i8 > i3) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            i4 = 0;
        }
        if (this.mAlignedDimensions == null) {
            this.mAlignedDimensions = new int[2];
        }
        if ((i5 != 0 || i2 != 1) && (i4 != 0 || i2 != 0)) {
            z = false;
            while (!z) {
                if (i2 == 0) {
                    i5 = (int) Math.ceil(i / i4);
                } else {
                    i4 = (int) Math.ceil(i / i5);
                }
                ConstraintWidget[] constraintWidgetArr2 = this.mAlignedBiggestElementsInCols;
                if (constraintWidgetArr2 == null || constraintWidgetArr2.length < i4) {
                    this.mAlignedBiggestElementsInCols = new ConstraintWidget[i4];
                } else {
                    Arrays.fill(constraintWidgetArr2, (Object) null);
                }
                ConstraintWidget[] constraintWidgetArr3 = this.mAlignedBiggestElementsInRows;
                if (constraintWidgetArr3 == null || constraintWidgetArr3.length < i5) {
                    this.mAlignedBiggestElementsInRows = new ConstraintWidget[i5];
                } else {
                    Arrays.fill(constraintWidgetArr3, (Object) null);
                }
                for (int i10 = 0; i10 < i4; i10++) {
                    for (int i11 = 0; i11 < i5; i11++) {
                        int i12 = (i11 * i4) + i10;
                        if (i2 == 1) {
                            i12 = (i10 * i5) + i11;
                        }
                        if (i12 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i12]) != null) {
                            int widgetWidth = getWidgetWidth(constraintWidget, i3);
                            ConstraintWidget[] constraintWidgetArr4 = this.mAlignedBiggestElementsInCols;
                            if (constraintWidgetArr4[i10] == null || constraintWidgetArr4[i10].getWidth() < widgetWidth) {
                                this.mAlignedBiggestElementsInCols[i10] = constraintWidget;
                            }
                            int widgetHeight = getWidgetHeight(constraintWidget, i3);
                            ConstraintWidget[] constraintWidgetArr5 = this.mAlignedBiggestElementsInRows;
                            if (constraintWidgetArr5[i11] == null || constraintWidgetArr5[i11].getHeight() < widgetHeight) {
                                this.mAlignedBiggestElementsInRows[i11] = constraintWidget;
                            }
                        }
                    }
                }
                int i13 = 0;
                for (int i14 = 0; i14 < i4; i14++) {
                    ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInCols[i14];
                    if (constraintWidget4 != null) {
                        if (i14 > 0) {
                            i13 += this.mHorizontalGap;
                        }
                        i13 += getWidgetWidth(constraintWidget4, i3);
                    }
                }
                int i15 = 0;
                for (int i16 = 0; i16 < i5; i16++) {
                    ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInRows[i16];
                    if (constraintWidget5 != null) {
                        if (i16 > 0) {
                            i15 += this.mVerticalGap;
                        }
                        i15 += getWidgetHeight(constraintWidget5, i3);
                    }
                }
                iArr[0] = i13;
                iArr[1] = i15;
                if (i2 != 0) {
                    if (i15 > i3 && i5 > 1) {
                        i5--;
                    }
                } else if (i13 > i3 && i4 > 1) {
                    i4--;
                }
                while (!z) {
                }
            }
            int[] iArr2 = this.mAlignedDimensions;
            iArr2[0] = i4;
            iArr2[1] = i5;
        }
        z = true;
        while (!z) {
        }
        int[] iArr22 = this.mAlignedDimensions;
        iArr22[0] = i4;
        iArr22[1] = i5;
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        int i4;
        int i5;
        ConstraintAnchor constraintAnchor;
        int paddingRight;
        ConstraintAnchor constraintAnchor2;
        int paddingBottom;
        int i6;
        if (i == 0) {
            return;
        }
        this.mChainList.clear();
        WidgetsList widgetsList = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
        this.mChainList.add(widgetsList);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        if (i2 == 0) {
            while (i9 < i) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i9];
                int widgetWidth = getWidgetWidth(constraintWidget, i3);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i7++;
                }
                int i10 = i7;
                boolean z = (i8 == i3 || (this.mHorizontalGap + i8) + widgetWidth > i3) && widgetsList.biggest != null;
                if (!z && i9 > 0 && (i6 = this.mMaxElementsWrap) > 0 && i9 % i6 == 0) {
                    z = true;
                }
                if (z) {
                    widgetsList = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
                    widgetsList.setStartIndex(i9);
                    this.mChainList.add(widgetsList);
                } else if (i9 > 0) {
                    i8 = this.mHorizontalGap + widgetWidth + i8;
                    widgetsList.add(constraintWidget);
                    i9++;
                    i7 = i10;
                }
                i8 = widgetWidth;
                widgetsList.add(constraintWidget);
                i9++;
                i7 = i10;
            }
        } else {
            while (i9 < i) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i9];
                int widgetHeight = getWidgetHeight(constraintWidget2, i3);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i7++;
                }
                int i11 = i7;
                boolean z2 = (i8 == i3 || (this.mVerticalGap + i8) + widgetHeight > i3) && widgetsList.biggest != null;
                if (!z2 && i9 > 0 && (i4 = this.mMaxElementsWrap) > 0 && i9 % i4 == 0) {
                    z2 = true;
                }
                if (z2) {
                    widgetsList = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
                    widgetsList.setStartIndex(i9);
                    this.mChainList.add(widgetsList);
                } else if (i9 > 0) {
                    i8 = this.mVerticalGap + widgetHeight + i8;
                    widgetsList.add(constraintWidget2);
                    i9++;
                    i7 = i11;
                }
                i8 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i9++;
                i7 = i11;
            }
        }
        int size = this.mChainList.size();
        ConstraintAnchor constraintAnchor3 = this.mLeft;
        ConstraintAnchor constraintAnchor4 = this.mTop;
        ConstraintAnchor constraintAnchor5 = this.mRight;
        ConstraintAnchor constraintAnchor6 = this.mBottom;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight2 = getPaddingRight();
        int paddingBottom2 = getPaddingBottom();
        boolean z3 = getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i7 > 0 && z3) {
            for (int i12 = 0; i12 < size; i12++) {
                WidgetsList widgetsList2 = this.mChainList.get(i12);
                widgetsList2.measureMatchConstraints(i3 - (i2 == 0 ? widgetsList2.getWidth() : widgetsList2.getHeight()));
            }
        }
        int i13 = paddingTop;
        int i14 = paddingRight2;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor4;
        ConstraintAnchor constraintAnchor8 = constraintAnchor3;
        int i19 = paddingBottom2;
        while (i17 < size) {
            WidgetsList widgetsList3 = this.mChainList.get(i17);
            if (i2 == 0) {
                if (i17 < size - 1) {
                    constraintAnchor2 = this.mChainList.get(i17 + 1).biggest.mTop;
                    paddingBottom = 0;
                } else {
                    constraintAnchor2 = this.mBottom;
                    paddingBottom = getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor9 = widgetsList3.biggest.mBottom;
                ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                int i20 = i15;
                ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                int i21 = i16;
                ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                i5 = i17;
                widgetsList3.setup(i2, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i18, i13, i14, paddingBottom, i3);
                int max = Math.max(i21, widgetsList3.getWidth());
                int height = widgetsList3.getHeight() + i20;
                if (i5 > 0) {
                    height += this.mVerticalGap;
                }
                constraintAnchor8 = constraintAnchor11;
                i16 = max;
                i15 = height;
                constraintAnchor7 = constraintAnchor9;
                i13 = 0;
                constraintAnchor = constraintAnchor14;
                int i22 = paddingBottom;
                constraintAnchor6 = constraintAnchor2;
                i19 = i22;
            } else {
                ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                int i23 = i15;
                int i24 = i16;
                i5 = i17;
                if (i5 < size - 1) {
                    constraintAnchor = this.mChainList.get(i5 + 1).biggest.mLeft;
                    paddingRight = 0;
                } else {
                    constraintAnchor = this.mRight;
                    paddingRight = getPaddingRight();
                }
                ConstraintAnchor constraintAnchor16 = widgetsList3.biggest.mRight;
                widgetsList3.setup(i2, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i18, i13, paddingRight, i19, i3);
                int width = widgetsList3.getWidth() + i24;
                int max2 = Math.max(i23, widgetsList3.getHeight());
                if (i5 > 0) {
                    width += this.mHorizontalGap;
                }
                i15 = max2;
                i16 = width;
                i14 = paddingRight;
                constraintAnchor8 = constraintAnchor16;
                i18 = 0;
            }
            i17 = i5 + 1;
            constraintAnchor5 = constraintAnchor;
        }
        iArr[0] = i16;
        iArr[1] = i15;
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        WidgetsList widgetsList;
        if (i == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
            this.mChainList.add(widgetsList);
        } else {
            WidgetsList widgetsList2 = this.mChainList.get(0);
            widgetsList2.clear();
            widgetsList = widgetsList2;
            widgetsList.setup(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i3);
        }
        for (int i4 = 0; i4 < i; i4++) {
            widgetsList.add(constraintWidgetArr[i4]);
        }
        iArr[0] = widgetsList.getWidth();
        iArr[1] = widgetsList.getHeight();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        super.addToSolver(linearSystem);
        boolean isRtl = getParent() != null ? ((ConstraintWidgetContainer) getParent()).isRtl() : false;
        int i = this.mWrapMode;
        if (i != 0) {
            if (i == 1) {
                int size = this.mChainList.size();
                int i2 = 0;
                while (i2 < size) {
                    this.mChainList.get(i2).createConstraints(isRtl, i2, i2 == size + (-1));
                    i2++;
                }
            } else if (i == 2) {
                createAlignedConstraints(isRtl);
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(isRtl, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (r18.mVerticalStyle == (-1)) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0056, code lost:
        r18.mVerticalStyle = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0054, code lost:
        if (r18.mVerticalStyle == (-1)) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00dc  */
    @Override // androidx.constraintlayout.solver.widgets.VirtualLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measure(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int[] iArr;
        boolean z;
        char c;
        if (this.mWidgetsCount > 0 && !measureChildren()) {
            setMeasure(0, 0);
            needsCallbackFromSolver(false);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int[] iArr2 = new int[2];
        int i7 = (i2 - paddingLeft) - paddingRight;
        if (this.mOrientation == 1) {
            i7 = (i4 - paddingTop) - paddingBottom;
        }
        int i8 = i7;
        if (this.mOrientation == 0) {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
        } else if (this.mHorizontalStyle == -1) {
            this.mHorizontalStyle = 0;
        }
        ConstraintWidget[] constraintWidgetArr = this.mWidgets;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            i5 = this.mWidgetsCount;
            if (i9 >= i5) {
                break;
            }
            if (this.mWidgets[i9].getVisibility() == 8) {
                i10++;
            }
            i9++;
        }
        if (i10 > 0) {
            constraintWidgetArr = new ConstraintWidget[i5 - i10];
            int i11 = 0;
            for (int i12 = 0; i12 < this.mWidgetsCount; i12++) {
                ConstraintWidget constraintWidget = this.mWidgets[i12];
                if (constraintWidget.getVisibility() != 8) {
                    constraintWidgetArr[i11] = constraintWidget;
                    i11++;
                }
            }
            i6 = i11;
        } else {
            i6 = i5;
        }
        this.mDisplayedWidgets = constraintWidgetArr;
        this.mDisplayedWidgetsCount = i6;
        int i13 = this.mWrapMode;
        if (i13 == 0) {
            iArr = iArr2;
            z = true;
            measureNoWrap(constraintWidgetArr, i6, this.mOrientation, i8, iArr2);
        } else if (i13 == 1) {
            iArr = iArr2;
            z = true;
            measureChainWrap(constraintWidgetArr, i6, this.mOrientation, i8, iArr2);
        } else if (i13 != 2) {
            iArr = iArr2;
            c = 0;
            z = true;
            int i14 = iArr[c] + paddingLeft + paddingRight;
            char c2 = z ? 1 : 0;
            char c3 = z ? 1 : 0;
            char c4 = z ? 1 : 0;
            char c5 = z ? 1 : 0;
            char c6 = z ? 1 : 0;
            char c7 = z ? 1 : 0;
            int i15 = iArr[c2] + paddingTop + paddingBottom;
            if (i != 1073741824) {
                i14 = i2;
            } else if (i == Integer.MIN_VALUE) {
                i14 = Math.min(i14, i2);
            } else if (i != 0) {
                i14 = 0;
            }
            if (i3 != 1073741824) {
                i15 = i4;
            } else if (i3 == Integer.MIN_VALUE) {
                i15 = Math.min(i15, i4);
            } else if (i3 != 0) {
                i15 = 0;
            }
            setMeasure(i14, i15);
            setWidth(i14);
            setHeight(i15);
            if (this.mWidgetsCount <= 0) {
                z = false;
            }
            needsCallbackFromSolver(z);
        } else {
            z = true;
            iArr = iArr2;
            measureAligned(constraintWidgetArr, i6, this.mOrientation, i8, iArr2);
        }
        c = 0;
        int i142 = iArr[c] + paddingLeft + paddingRight;
        char c22 = z ? 1 : 0;
        char c32 = z ? 1 : 0;
        char c42 = z ? 1 : 0;
        char c52 = z ? 1 : 0;
        char c62 = z ? 1 : 0;
        char c72 = z ? 1 : 0;
        int i152 = iArr[c22] + paddingTop + paddingBottom;
        if (i != 1073741824) {
        }
        if (i3 != 1073741824) {
        }
        setMeasure(i142, i152);
        setWidth(i142);
        setHeight(i152);
        if (this.mWidgetsCount <= 0) {
        }
        needsCallbackFromSolver(z);
    }

    public void setFirstHorizontalBias(float f) {
        this.mFirstHorizontalBias = f;
    }

    public void setFirstHorizontalStyle(int i) {
        this.mFirstHorizontalStyle = i;
    }

    public void setFirstVerticalBias(float f) {
        this.mFirstVerticalBias = f;
    }

    public void setFirstVerticalStyle(int i) {
        this.mFirstVerticalStyle = i;
    }

    public void setHorizontalAlign(int i) {
        this.mHorizontalAlign = i;
    }

    public void setHorizontalBias(float f) {
        this.mHorizontalBias = f;
    }

    public void setHorizontalGap(int i) {
        this.mHorizontalGap = i;
    }

    public void setHorizontalStyle(int i) {
        this.mHorizontalStyle = i;
    }

    public void setLastHorizontalBias(float f) {
        this.mLastHorizontalBias = f;
    }

    public void setLastHorizontalStyle(int i) {
        this.mLastHorizontalStyle = i;
    }

    public void setLastVerticalBias(float f) {
        this.mLastVerticalBias = f;
    }

    public void setLastVerticalStyle(int i) {
        this.mLastVerticalStyle = i;
    }

    public void setMaxElementsWrap(int i) {
        this.mMaxElementsWrap = i;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setVerticalAlign(int i) {
        this.mVerticalAlign = i;
    }

    public void setVerticalBias(float f) {
        this.mVerticalBias = f;
    }

    public void setVerticalGap(int i) {
        this.mVerticalGap = i;
    }

    public void setVerticalStyle(int i) {
        this.mVerticalStyle = i;
    }

    public void setWrapMode(int i) {
        this.mWrapMode = i;
    }
}

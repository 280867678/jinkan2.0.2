package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ChainHead {
    public boolean mDefined;
    public ConstraintWidget mFirst;
    public ConstraintWidget mFirstMatchConstraintWidget;
    public ConstraintWidget mFirstVisibleWidget;
    public boolean mHasComplexMatchWeights;
    public boolean mHasDefinedWeights;
    public boolean mHasRatio;
    public boolean mHasUndefinedWeights;
    public ConstraintWidget mHead;
    public boolean mIsRtl;
    public ConstraintWidget mLast;
    public ConstraintWidget mLastMatchConstraintWidget;
    public ConstraintWidget mLastVisibleWidget;
    public boolean mOptimizable;
    public int mOrientation;
    public int mTotalMargins;
    public int mTotalSize;
    public float mTotalWeight = 0.0f;
    public int mVisibleWidgets;
    public ArrayList<ConstraintWidget> mWeightedMatchConstraintsWidgets;
    public int mWidgetsCount;
    public int mWidgetsMatchCount;

    public ChainHead(ConstraintWidget constraintWidget, int i, boolean z) {
        this.mIsRtl = false;
        this.mFirst = constraintWidget;
        this.mOrientation = i;
        this.mIsRtl = z;
    }

    private void defineChainProperties() {
        int i = this.mOrientation * 2;
        ConstraintWidget constraintWidget = this.mFirst;
        boolean z = true;
        this.mOptimizable = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z2 = false;
        while (!z2) {
            this.mWidgetsCount++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.mNextChainWidget;
            int i2 = this.mOrientation;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i2] = null;
            constraintWidget.mListNextMatchConstraintsWidget[i2] = null;
            if (constraintWidget.getVisibility() != 8) {
                this.mVisibleWidgets++;
                if (constraintWidget.getDimensionBehaviour(this.mOrientation) != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mTotalSize = constraintWidget.getLength(this.mOrientation) + this.mTotalSize;
                }
                int margin = constraintWidget.mListAnchors[i].getMargin() + this.mTotalSize;
                this.mTotalSize = margin;
                int i3 = i + 1;
                this.mTotalSize = constraintWidget.mListAnchors[i3].getMargin() + margin;
                int margin2 = constraintWidget.mListAnchors[i].getMargin() + this.mTotalMargins;
                this.mTotalMargins = margin2;
                this.mTotalMargins = constraintWidget.mListAnchors[i3].getMargin() + margin2;
                if (this.mFirstVisibleWidget == null) {
                    this.mFirstVisibleWidget = constraintWidget;
                }
                this.mLastVisibleWidget = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
                int i4 = this.mOrientation;
                if (dimensionBehaviourArr[i4] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    int[] iArr = constraintWidget.mResolvedMatchConstraintDefault;
                    if (iArr[i4] == 0 || iArr[i4] == 3 || iArr[i4] == 2) {
                        this.mWidgetsMatchCount++;
                        float[] fArr = constraintWidget.mWeight;
                        int i5 = this.mOrientation;
                        float f = fArr[i5];
                        if (f > 0.0f) {
                            this.mTotalWeight += fArr[i5];
                        }
                        if (isMatchConstraintEqualityCandidate(constraintWidget, this.mOrientation)) {
                            if (f < 0.0f) {
                                this.mHasUndefinedWeights = true;
                            } else {
                                this.mHasDefinedWeights = true;
                            }
                            if (this.mWeightedMatchConstraintsWidgets == null) {
                                this.mWeightedMatchConstraintsWidgets = new ArrayList<>();
                            }
                            this.mWeightedMatchConstraintsWidgets.add(constraintWidget);
                        }
                        if (this.mFirstMatchConstraintWidget == null) {
                            this.mFirstMatchConstraintWidget = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.mLastMatchConstraintWidget;
                        if (constraintWidget4 != null) {
                            constraintWidget4.mListNextMatchConstraintsWidget[this.mOrientation] = constraintWidget;
                        }
                        this.mLastMatchConstraintWidget = constraintWidget;
                    }
                    if (this.mOrientation != 0 ? !(constraintWidget.mMatchConstraintDefaultHeight == 0 && constraintWidget.mMatchConstraintMinHeight == 0 && constraintWidget.mMatchConstraintMaxHeight == 0) : !(constraintWidget.mMatchConstraintDefaultWidth == 0 && constraintWidget.mMatchConstraintMinWidth == 0 && constraintWidget.mMatchConstraintMaxWidth == 0)) {
                        this.mOptimizable = false;
                    }
                    if (constraintWidget.mDimensionRatio != 0.0f) {
                        this.mOptimizable = false;
                        this.mHasRatio = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.mNextChainWidget[this.mOrientation] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i + 1].mTarget;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.mOwner;
                ConstraintAnchor[] constraintAnchorArr = constraintWidget5.mListAnchors;
                if (constraintAnchorArr[i].mTarget != null && constraintAnchorArr[i].mTarget.mOwner == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z2 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.mFirstVisibleWidget;
        if (constraintWidget6 != null) {
            this.mTotalSize -= constraintWidget6.mListAnchors[i].getMargin();
        }
        ConstraintWidget constraintWidget7 = this.mLastVisibleWidget;
        if (constraintWidget7 != null) {
            this.mTotalSize -= constraintWidget7.mListAnchors[i + 1].getMargin();
        }
        this.mLast = constraintWidget;
        if (this.mOrientation != 0 || !this.mIsRtl) {
            this.mHead = this.mFirst;
        } else {
            this.mHead = constraintWidget;
        }
        if (!this.mHasDefinedWeights || !this.mHasUndefinedWeights) {
            z = false;
        }
        this.mHasComplexMatchWeights = z;
    }

    public static boolean isMatchConstraintEqualityCandidate(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget.getVisibility() != 8 && constraintWidget.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int[] iArr = constraintWidget.mResolvedMatchConstraintDefault;
            if (iArr[i] == 0 || iArr[i] == 3) {
                return true;
            }
        }
        return false;
    }

    public void define() {
        if (!this.mDefined) {
            defineChainProperties();
        }
        this.mDefined = true;
    }

    public ConstraintWidget getFirst() {
        return this.mFirst;
    }

    public ConstraintWidget getFirstMatchConstraintWidget() {
        return this.mFirstMatchConstraintWidget;
    }

    public ConstraintWidget getFirstVisibleWidget() {
        return this.mFirstVisibleWidget;
    }

    public ConstraintWidget getHead() {
        return this.mHead;
    }

    public ConstraintWidget getLast() {
        return this.mLast;
    }

    public ConstraintWidget getLastMatchConstraintWidget() {
        return this.mLastMatchConstraintWidget;
    }

    public ConstraintWidget getLastVisibleWidget() {
        return this.mLastVisibleWidget;
    }

    public float getTotalWeight() {
        return this.mTotalWeight;
    }
}

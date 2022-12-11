package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class Chain {
    public static final boolean DEBUG = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        int i3;
        ChainHead[] chainHeadArr;
        if (i == 0) {
            int i4 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = i4;
            i2 = 0;
        } else {
            i2 = 2;
            i3 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.define();
            applyChainConstraints(constraintWidgetContainer, linearSystem, i, i2, chainHead);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L314;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x0046, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x0044, code lost:
        if (r2.mVerticalChainStyle == 2) goto L314;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0265 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x04d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0516 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:161:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03a0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03a8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        ConstraintWidget constraintWidget;
        ArrayList<ConstraintWidget> arrayList;
        ConstraintWidget constraintWidget2;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        int i3;
        ConstraintWidget constraintWidget3;
        int i4;
        ConstraintAnchor constraintAnchor4;
        SolverVariable solverVariable;
        ConstraintAnchor constraintAnchor5;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget4;
        ConstraintAnchor constraintAnchor6;
        int margin;
        int i5;
        int margin2;
        ConstraintAnchor constraintAnchor7;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ConstraintWidget constraintWidget5;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        int size;
        int i6;
        ArrayList<ConstraintWidget> arrayList2;
        int i7;
        boolean z4;
        ConstraintWidget constraintWidget6;
        boolean z5;
        int i8;
        ConstraintWidget constraintWidget7 = chainHead.mFirst;
        ConstraintWidget constraintWidget8 = chainHead.mLast;
        ConstraintWidget constraintWidget9 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget10 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget11 = chainHead.mHead;
        float f = chainHead.mTotalWeight;
        boolean z6 = constraintWidgetContainer.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            z = constraintWidget11.mHorizontalChainStyle == 0;
            z2 = constraintWidget11.mHorizontalChainStyle == 1;
        } else {
            z = constraintWidget11.mVerticalChainStyle == 0;
            z2 = constraintWidget11.mVerticalChainStyle == 1;
        }
        ConstraintWidget constraintWidget12 = constraintWidget7;
        boolean z7 = z2;
        boolean z8 = z;
        boolean z9 = false;
        while (true) {
            constraintWidget = null;
            if (z9) {
                break;
            }
            ConstraintAnchor constraintAnchor8 = constraintWidget12.mListAnchors[i2];
            int i9 = z3 ? 1 : 4;
            int margin3 = constraintAnchor8.getMargin();
            float f2 = f;
            boolean z10 = z9;
            boolean z11 = constraintWidget12.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget12.mResolvedMatchConstraintDefault[i] == 0;
            ConstraintAnchor constraintAnchor9 = constraintAnchor8.mTarget;
            if (constraintAnchor9 != null && constraintWidget12 != constraintWidget7) {
                margin3 = constraintAnchor9.getMargin() + margin3;
            }
            int i10 = margin3;
            if (!z3 || constraintWidget12 == constraintWidget7 || constraintWidget12 == constraintWidget9) {
                z4 = z7;
            } else {
                z4 = z7;
                i9 = 5;
            }
            ConstraintAnchor constraintAnchor10 = constraintAnchor8.mTarget;
            if (constraintAnchor10 != null) {
                if (constraintWidget12 == constraintWidget9) {
                    z5 = z8;
                    constraintWidget6 = constraintWidget11;
                    linearSystem.addGreaterThan(constraintAnchor8.mSolverVariable, constraintAnchor10.mSolverVariable, i10, 6);
                } else {
                    constraintWidget6 = constraintWidget11;
                    z5 = z8;
                    linearSystem.addGreaterThan(constraintAnchor8.mSolverVariable, constraintAnchor10.mSolverVariable, i10, 8);
                }
                linearSystem.addEquality(constraintAnchor8.mSolverVariable, constraintAnchor8.mTarget.mSolverVariable, i10, (!z11 || z3) ? i9 : 5);
            } else {
                constraintWidget6 = constraintWidget11;
                z5 = z8;
            }
            if (z6) {
                if (constraintWidget12.getVisibility() == 8 || constraintWidget12.mListDimensionBehaviors[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i8 = 0;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = constraintWidget12.mListAnchors;
                    i8 = 0;
                    linearSystem.addGreaterThan(constraintAnchorArr[i2 + 1].mSolverVariable, constraintAnchorArr[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(constraintWidget12.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i8, 8);
            }
            ConstraintAnchor constraintAnchor11 = constraintWidget12.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor11 != null) {
                ConstraintWidget constraintWidget13 = constraintAnchor11.mOwner;
                ConstraintAnchor[] constraintAnchorArr2 = constraintWidget13.mListAnchors;
                if (constraintAnchorArr2[i2].mTarget != null && constraintAnchorArr2[i2].mTarget.mOwner == constraintWidget12) {
                    constraintWidget = constraintWidget13;
                }
            }
            if (constraintWidget != null) {
                constraintWidget12 = constraintWidget;
                z9 = z10;
            } else {
                z9 = true;
            }
            z7 = z4;
            f = f2;
            z8 = z5;
            constraintWidget11 = constraintWidget6;
        }
        ConstraintWidget constraintWidget14 = constraintWidget11;
        float f3 = f;
        boolean z12 = z8;
        boolean z13 = z7;
        if (constraintWidget10 != null) {
            int i11 = i2 + 1;
            if (constraintWidget8.mListAnchors[i11].mTarget != null) {
                ConstraintAnchor constraintAnchor12 = constraintWidget10.mListAnchors[i11];
                if ((constraintWidget10.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget10.mResolvedMatchConstraintDefault[i] == 0) && !z3) {
                    ConstraintAnchor constraintAnchor13 = constraintAnchor12.mTarget;
                    if (constraintAnchor13.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor12.mSolverVariable, constraintAnchor13.mSolverVariable, -constraintAnchor12.getMargin(), 5);
                        linearSystem.addLowerThan(constraintAnchor12.mSolverVariable, constraintWidget8.mListAnchors[i11].mTarget.mSolverVariable, -constraintAnchor12.getMargin(), 6);
                        if (z6) {
                            int i12 = i2 + 1;
                            SolverVariable solverVariable7 = constraintWidgetContainer.mListAnchors[i12].mSolverVariable;
                            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget8.mListAnchors;
                            linearSystem.addGreaterThan(solverVariable7, constraintAnchorArr3[i12].mSolverVariable, constraintAnchorArr3[i12].getMargin(), 8);
                        }
                        arrayList = chainHead.mWeightedMatchConstraintsWidgets;
                        if (arrayList != null && (size = arrayList.size()) > 1) {
                            float f4 = (chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f3 : chainHead.mWidgetsMatchCount;
                            float f5 = 0.0f;
                            ConstraintWidget constraintWidget15 = null;
                            i6 = 0;
                            float f6 = 0.0f;
                            while (i6 < size) {
                                ConstraintWidget constraintWidget16 = arrayList.get(i6);
                                float f7 = constraintWidget16.mWeight[i];
                                if (f7 < f5) {
                                    if (chainHead.mHasComplexMatchWeights) {
                                        ConstraintAnchor[] constraintAnchorArr4 = constraintWidget16.mListAnchors;
                                        linearSystem.addEquality(constraintAnchorArr4[i2 + 1].mSolverVariable, constraintAnchorArr4[i2].mSolverVariable, 0, 4);
                                        arrayList2 = arrayList;
                                        i7 = size;
                                        i6++;
                                        size = i7;
                                        arrayList = arrayList2;
                                        f5 = 0.0f;
                                    } else {
                                        f7 = 1.0f;
                                        f5 = 0.0f;
                                    }
                                }
                                if (f7 == f5) {
                                    ConstraintAnchor[] constraintAnchorArr5 = constraintWidget16.mListAnchors;
                                    linearSystem.addEquality(constraintAnchorArr5[i2 + 1].mSolverVariable, constraintAnchorArr5[i2].mSolverVariable, 0, 8);
                                    arrayList2 = arrayList;
                                    i7 = size;
                                    i6++;
                                    size = i7;
                                    arrayList = arrayList2;
                                    f5 = 0.0f;
                                } else {
                                    if (constraintWidget15 != null) {
                                        ConstraintAnchor[] constraintAnchorArr6 = constraintWidget15.mListAnchors;
                                        SolverVariable solverVariable8 = constraintAnchorArr6[i2].mSolverVariable;
                                        int i13 = i2 + 1;
                                        SolverVariable solverVariable9 = constraintAnchorArr6[i13].mSolverVariable;
                                        ConstraintAnchor[] constraintAnchorArr7 = constraintWidget16.mListAnchors;
                                        arrayList2 = arrayList;
                                        SolverVariable solverVariable10 = constraintAnchorArr7[i2].mSolverVariable;
                                        SolverVariable solverVariable11 = constraintAnchorArr7[i13].mSolverVariable;
                                        i7 = size;
                                        ArrayRow createRow = linearSystem.createRow();
                                        createRow.createRowEqualMatchDimensions(f6, f4, f7, solverVariable8, solverVariable9, solverVariable10, solverVariable11);
                                        linearSystem.addConstraint(createRow);
                                    } else {
                                        arrayList2 = arrayList;
                                        i7 = size;
                                    }
                                    f6 = f7;
                                    constraintWidget15 = constraintWidget16;
                                    i6++;
                                    size = i7;
                                    arrayList = arrayList2;
                                    f5 = 0.0f;
                                }
                            }
                        }
                        if (constraintWidget9 == null && (constraintWidget9 == constraintWidget10 || z3)) {
                            ConstraintAnchor constraintAnchor14 = constraintWidget7.mListAnchors[i2];
                            int i14 = i2 + 1;
                            ConstraintAnchor constraintAnchor15 = constraintWidget8.mListAnchors[i14];
                            ConstraintAnchor constraintAnchor16 = constraintAnchor14.mTarget;
                            SolverVariable solverVariable12 = constraintAnchor16 != null ? constraintAnchor16.mSolverVariable : null;
                            ConstraintAnchor constraintAnchor17 = constraintAnchor15.mTarget;
                            SolverVariable solverVariable13 = constraintAnchor17 != null ? constraintAnchor17.mSolverVariable : null;
                            ConstraintAnchor constraintAnchor18 = constraintWidget9.mListAnchors[i2];
                            ConstraintAnchor constraintAnchor19 = constraintWidget10.mListAnchors[i14];
                            if (solverVariable12 != null && solverVariable13 != null) {
                                linearSystem.addCentering(constraintAnchor18.mSolverVariable, solverVariable12, constraintAnchor18.getMargin(), i == 0 ? constraintWidget14.mHorizontalBiasPercent : constraintWidget14.mVerticalBiasPercent, solverVariable13, constraintAnchor19.mSolverVariable, constraintAnchor19.getMargin(), 7);
                            }
                        } else if (z12 || constraintWidget9 == null) {
                            int i15 = 8;
                            if (z13 && constraintWidget9 != null) {
                                int i16 = chainHead.mWidgetsMatchCount;
                                boolean z14 = i16 <= 0 && chainHead.mWidgetsCount == i16;
                                constraintWidget2 = constraintWidget9;
                                ConstraintWidget constraintWidget17 = constraintWidget2;
                                while (constraintWidget2 != null) {
                                    ConstraintWidget constraintWidget18 = constraintWidget2.mNextChainWidget[i];
                                    while (constraintWidget18 != null && constraintWidget18.getVisibility() == i15) {
                                        constraintWidget18 = constraintWidget18.mNextChainWidget[i];
                                    }
                                    if (constraintWidget2 == constraintWidget9 || constraintWidget2 == constraintWidget10 || constraintWidget18 == null) {
                                        constraintWidget3 = constraintWidget17;
                                        i4 = 8;
                                    } else {
                                        ConstraintWidget constraintWidget19 = constraintWidget18 == constraintWidget10 ? null : constraintWidget18;
                                        ConstraintAnchor constraintAnchor20 = constraintWidget2.mListAnchors[i2];
                                        SolverVariable solverVariable14 = constraintAnchor20.mSolverVariable;
                                        ConstraintAnchor constraintAnchor21 = constraintAnchor20.mTarget;
                                        if (constraintAnchor21 != null) {
                                            SolverVariable solverVariable15 = constraintAnchor21.mSolverVariable;
                                        }
                                        int i17 = i2 + 1;
                                        SolverVariable solverVariable16 = constraintWidget17.mListAnchors[i17].mSolverVariable;
                                        int margin4 = constraintAnchor20.getMargin();
                                        int margin5 = constraintWidget2.mListAnchors[i17].getMargin();
                                        if (constraintWidget19 != null) {
                                            constraintAnchor4 = constraintWidget19.mListAnchors[i2];
                                            solverVariable = constraintAnchor4.mSolverVariable;
                                            constraintAnchor5 = constraintAnchor4.mTarget;
                                            if (constraintAnchor5 == null) {
                                                solverVariable2 = null;
                                                int margin6 = constraintAnchor4 == null ? constraintAnchor4.getMargin() + margin5 : margin5;
                                                int margin7 = constraintWidget17.mListAnchors[i17].getMargin() + margin4;
                                                int i18 = !z14 ? 8 : 4;
                                                if (solverVariable14 != null || solverVariable16 == null || solverVariable == null || solverVariable2 == null) {
                                                    constraintWidget4 = constraintWidget19;
                                                    constraintWidget3 = constraintWidget17;
                                                    i4 = 8;
                                                } else {
                                                    constraintWidget4 = constraintWidget19;
                                                    int i19 = margin6;
                                                    constraintWidget3 = constraintWidget17;
                                                    i4 = 8;
                                                    linearSystem.addCentering(solverVariable14, solverVariable16, margin7, 0.5f, solverVariable, solverVariable2, i19, i18);
                                                }
                                                constraintWidget18 = constraintWidget4;
                                            }
                                        } else {
                                            constraintAnchor4 = constraintWidget10.mListAnchors[i2];
                                            solverVariable = constraintAnchor4 != null ? constraintAnchor4.mSolverVariable : null;
                                            constraintAnchor5 = constraintWidget2.mListAnchors[i17];
                                        }
                                        solverVariable2 = constraintAnchor5.mSolverVariable;
                                        if (constraintAnchor4 == null) {
                                        }
                                        int margin72 = constraintWidget17.mListAnchors[i17].getMargin() + margin4;
                                        if (!z14) {
                                        }
                                        if (solverVariable14 != null) {
                                        }
                                        constraintWidget4 = constraintWidget19;
                                        constraintWidget3 = constraintWidget17;
                                        i4 = 8;
                                        constraintWidget18 = constraintWidget4;
                                    }
                                    if (constraintWidget2.getVisibility() == i4) {
                                        constraintWidget2 = constraintWidget3;
                                    }
                                    constraintWidget17 = constraintWidget2;
                                    i15 = 8;
                                    constraintWidget2 = constraintWidget18;
                                }
                                ConstraintAnchor constraintAnchor22 = constraintWidget9.mListAnchors[i2];
                                constraintAnchor = constraintWidget7.mListAnchors[i2].mTarget;
                                int i20 = i2 + 1;
                                constraintAnchor2 = constraintWidget10.mListAnchors[i20];
                                constraintAnchor3 = constraintWidget8.mListAnchors[i20].mTarget;
                                if (constraintAnchor != null) {
                                    i3 = 5;
                                } else if (constraintWidget9 != constraintWidget10) {
                                    i3 = 5;
                                    linearSystem.addEquality(constraintAnchor22.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor22.getMargin(), 5);
                                } else {
                                    i3 = 5;
                                    if (constraintAnchor3 != null) {
                                        linearSystem.addCentering(constraintAnchor22.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor22.getMargin(), 0.5f, constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, constraintAnchor2.getMargin(), 5);
                                    }
                                }
                                if (constraintAnchor3 != null && constraintWidget9 != constraintWidget10) {
                                    linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
                                }
                            }
                        } else {
                            int i21 = chainHead.mWidgetsMatchCount;
                            boolean z15 = i21 > 0 && chainHead.mWidgetsCount == i21;
                            ConstraintWidget constraintWidget20 = constraintWidget9;
                            ConstraintWidget constraintWidget21 = constraintWidget20;
                            while (constraintWidget20 != null) {
                                ConstraintWidget constraintWidget22 = constraintWidget20.mNextChainWidget[i];
                                while (constraintWidget22 != null && constraintWidget22.getVisibility() == 8) {
                                    constraintWidget22 = constraintWidget22.mNextChainWidget[i];
                                }
                                if (constraintWidget22 != null || constraintWidget20 == constraintWidget10) {
                                    ConstraintAnchor constraintAnchor23 = constraintWidget20.mListAnchors[i2];
                                    SolverVariable solverVariable17 = constraintAnchor23.mSolverVariable;
                                    ConstraintAnchor constraintAnchor24 = constraintAnchor23.mTarget;
                                    SolverVariable solverVariable18 = constraintAnchor24 != null ? constraintAnchor24.mSolverVariable : null;
                                    if (constraintWidget21 != constraintWidget20) {
                                        constraintAnchor6 = constraintWidget21.mListAnchors[i2 + 1];
                                    } else {
                                        if (constraintWidget20 == constraintWidget9 && constraintWidget21 == constraintWidget20) {
                                            ConstraintAnchor[] constraintAnchorArr8 = constraintWidget7.mListAnchors;
                                            if (constraintAnchorArr8[i2].mTarget != null) {
                                                constraintAnchor6 = constraintAnchorArr8[i2].mTarget;
                                            } else {
                                                solverVariable18 = null;
                                            }
                                        }
                                        margin = constraintAnchor23.getMargin();
                                        i5 = i2 + 1;
                                        margin2 = constraintWidget20.mListAnchors[i5].getMargin();
                                        if (constraintWidget22 == null) {
                                            constraintAnchor7 = constraintWidget22.mListAnchors[i2];
                                            SolverVariable solverVariable19 = constraintAnchor7.mSolverVariable;
                                            solverVariable4 = constraintWidget20.mListAnchors[i5].mSolverVariable;
                                            solverVariable3 = solverVariable19;
                                        } else {
                                            constraintAnchor7 = constraintWidget8.mListAnchors[i5].mTarget;
                                            solverVariable3 = constraintAnchor7 != null ? constraintAnchor7.mSolverVariable : null;
                                            solverVariable4 = constraintWidget20.mListAnchors[i5].mSolverVariable;
                                        }
                                        if (constraintAnchor7 != null) {
                                            margin2 += constraintAnchor7.getMargin();
                                        }
                                        if (constraintWidget21 != null) {
                                            margin += constraintWidget21.mListAnchors[i5].getMargin();
                                        }
                                        if (solverVariable17 != null && solverVariable18 != null && solverVariable3 != null && solverVariable4 != null) {
                                            if (constraintWidget20 == constraintWidget9) {
                                                margin = constraintWidget9.mListAnchors[i2].getMargin();
                                            }
                                            int i22 = margin;
                                            constraintWidget5 = constraintWidget22;
                                            linearSystem.addCentering(solverVariable17, solverVariable18, i22, 0.5f, solverVariable3, solverVariable4, constraintWidget20 != constraintWidget10 ? constraintWidget10.mListAnchors[i5].getMargin() : margin2, !z15 ? 8 : 5);
                                            if (constraintWidget20.getVisibility() != 8) {
                                                constraintWidget21 = constraintWidget20;
                                            }
                                            constraintWidget20 = constraintWidget5;
                                        }
                                    }
                                    solverVariable18 = constraintAnchor6.mSolverVariable;
                                    margin = constraintAnchor23.getMargin();
                                    i5 = i2 + 1;
                                    margin2 = constraintWidget20.mListAnchors[i5].getMargin();
                                    if (constraintWidget22 == null) {
                                    }
                                    if (constraintAnchor7 != null) {
                                    }
                                    if (constraintWidget21 != null) {
                                    }
                                    if (solverVariable17 != null) {
                                        if (constraintWidget20 == constraintWidget9) {
                                        }
                                        int i222 = margin;
                                        if (constraintWidget20 != constraintWidget10) {
                                        }
                                        constraintWidget5 = constraintWidget22;
                                        linearSystem.addCentering(solverVariable17, solverVariable18, i222, 0.5f, solverVariable3, solverVariable4, constraintWidget20 != constraintWidget10 ? constraintWidget10.mListAnchors[i5].getMargin() : margin2, !z15 ? 8 : 5);
                                        if (constraintWidget20.getVisibility() != 8) {
                                        }
                                        constraintWidget20 = constraintWidget5;
                                    }
                                }
                                constraintWidget5 = constraintWidget22;
                                if (constraintWidget20.getVisibility() != 8) {
                                }
                                constraintWidget20 = constraintWidget5;
                            }
                        }
                        if ((z12 && !z13) || constraintWidget9 == null || constraintWidget9 == constraintWidget10) {
                            return;
                        }
                        ConstraintAnchor constraintAnchor25 = constraintWidget9.mListAnchors[i2];
                        int i23 = i2 + 1;
                        ConstraintAnchor constraintAnchor26 = constraintWidget10.mListAnchors[i23];
                        ConstraintAnchor constraintAnchor27 = constraintAnchor25.mTarget;
                        solverVariable5 = constraintAnchor27 != null ? constraintAnchor27.mSolverVariable : null;
                        ConstraintAnchor constraintAnchor28 = constraintAnchor26.mTarget;
                        SolverVariable solverVariable20 = constraintAnchor28 != null ? constraintAnchor28.mSolverVariable : null;
                        if (constraintWidget8 != constraintWidget10) {
                            ConstraintAnchor constraintAnchor29 = constraintWidget8.mListAnchors[i23].mTarget;
                            if (constraintAnchor29 != null) {
                                constraintWidget = constraintAnchor29.mSolverVariable;
                            }
                            solverVariable6 = constraintWidget;
                        } else {
                            solverVariable6 = solverVariable20;
                        }
                        if (constraintWidget9 == constraintWidget10) {
                            ConstraintAnchor[] constraintAnchorArr9 = constraintWidget9.mListAnchors;
                            ConstraintAnchor constraintAnchor30 = constraintAnchorArr9[i2];
                            constraintAnchor26 = constraintAnchorArr9[i23];
                            constraintAnchor25 = constraintAnchor30;
                        }
                        if (solverVariable5 != null || solverVariable6 == null) {
                            return;
                        }
                        linearSystem.addCentering(constraintAnchor25.mSolverVariable, solverVariable5, constraintAnchor25.getMargin(), 0.5f, solverVariable6, constraintAnchor26.mSolverVariable, constraintWidget10.mListAnchors[i23].getMargin(), 5);
                        return;
                    }
                }
                if (z3) {
                    ConstraintAnchor constraintAnchor31 = constraintAnchor12.mTarget;
                    if (constraintAnchor31.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor12.mSolverVariable, constraintAnchor31.mSolverVariable, -constraintAnchor12.getMargin(), 4);
                    }
                }
                linearSystem.addLowerThan(constraintAnchor12.mSolverVariable, constraintWidget8.mListAnchors[i11].mTarget.mSolverVariable, -constraintAnchor12.getMargin(), 6);
                if (z6) {
                }
                arrayList = chainHead.mWeightedMatchConstraintsWidgets;
                if (arrayList != null) {
                    if (chainHead.mHasUndefinedWeights) {
                    }
                    float f52 = 0.0f;
                    ConstraintWidget constraintWidget152 = null;
                    i6 = 0;
                    float f62 = 0.0f;
                    while (i6 < size) {
                    }
                }
                if (constraintWidget9 == null) {
                }
                if (z12) {
                }
                int i152 = 8;
                if (z13) {
                    int i162 = chainHead.mWidgetsMatchCount;
                    if (i162 <= 0) {
                    }
                    constraintWidget2 = constraintWidget9;
                    ConstraintWidget constraintWidget172 = constraintWidget2;
                    while (constraintWidget2 != null) {
                    }
                    ConstraintAnchor constraintAnchor222 = constraintWidget9.mListAnchors[i2];
                    constraintAnchor = constraintWidget7.mListAnchors[i2].mTarget;
                    int i202 = i2 + 1;
                    constraintAnchor2 = constraintWidget10.mListAnchors[i202];
                    constraintAnchor3 = constraintWidget8.mListAnchors[i202].mTarget;
                    if (constraintAnchor != null) {
                    }
                    if (constraintAnchor3 != null) {
                        linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
                    }
                }
                if (z12) {
                }
                ConstraintAnchor constraintAnchor252 = constraintWidget9.mListAnchors[i2];
                int i232 = i2 + 1;
                ConstraintAnchor constraintAnchor262 = constraintWidget10.mListAnchors[i232];
                ConstraintAnchor constraintAnchor272 = constraintAnchor252.mTarget;
                if (constraintAnchor272 != null) {
                }
                ConstraintAnchor constraintAnchor282 = constraintAnchor262.mTarget;
                if (constraintAnchor282 != null) {
                }
                if (constraintWidget8 != constraintWidget10) {
                }
                if (constraintWidget9 == constraintWidget10) {
                }
                if (solverVariable5 != null) {
                    return;
                }
                return;
            }
        }
        if (z6) {
        }
        arrayList = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList != null) {
        }
        if (constraintWidget9 == null) {
        }
        if (z12) {
        }
        int i1522 = 8;
        if (z13) {
        }
        if (z12) {
        }
        ConstraintAnchor constraintAnchor2522 = constraintWidget9.mListAnchors[i2];
        int i2322 = i2 + 1;
        ConstraintAnchor constraintAnchor2622 = constraintWidget10.mListAnchors[i2322];
        ConstraintAnchor constraintAnchor2722 = constraintAnchor2522.mTarget;
        if (constraintAnchor2722 != null) {
        }
        ConstraintAnchor constraintAnchor2822 = constraintAnchor2622.mTarget;
        if (constraintAnchor2822 != null) {
        }
        if (constraintWidget8 != constraintWidget10) {
        }
        if (constraintWidget9 == constraintWidget10) {
        }
        if (solverVariable5 != null) {
        }
    }
}

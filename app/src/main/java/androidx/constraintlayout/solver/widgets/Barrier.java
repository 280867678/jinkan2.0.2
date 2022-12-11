package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.HashMap;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    public int mBarrierType = 0;
    public boolean mAllowsGoneWidget = true;
    public int mMargin = 0;

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        Object[] objArr;
        boolean z;
        SolverVariable solverVariable;
        ConstraintAnchor constraintAnchor;
        int i;
        int i2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        constraintAnchorArr[0] = this.mLeft;
        constraintAnchorArr[2] = this.mTop;
        constraintAnchorArr[1] = this.mRight;
        constraintAnchorArr[3] = this.mBottom;
        int i3 = 0;
        while (true) {
            objArr = this.mListAnchors;
            if (i3 >= objArr.length) {
                break;
            }
            objArr[i3].mSolverVariable = linearSystem.createObjectVariable(objArr[i3]);
            i3++;
        }
        int i4 = this.mBarrierType;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor2 = objArr[i4];
        for (int i5 = 0; i5 < this.mWidgetsCount; i5++) {
            ConstraintWidget constraintWidget = this.mWidgets[i5];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i = this.mBarrierType) == 0 || i == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i2 = this.mBarrierType) == 2 || i2 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                z = true;
                break;
            }
        }
        z = false;
        boolean z2 = this.mLeft.hasCenteredDependents() || this.mRight.hasCenteredDependents();
        boolean z3 = this.mTop.hasCenteredDependents() || this.mBottom.hasCenteredDependents();
        boolean z4 = !z && ((this.mBarrierType == 0 && z2) || ((this.mBarrierType == 2 && z3) || ((this.mBarrierType == 1 && z2) || (this.mBarrierType == 3 && z3))));
        int i6 = 5;
        if (!z4) {
            i6 = 4;
        }
        for (int i7 = 0; i7 < this.mWidgetsCount; i7++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i7];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                ConstraintAnchor[] constraintAnchorArr2 = constraintWidget2.mListAnchors;
                int i8 = this.mBarrierType;
                constraintAnchorArr2[i8].mSolverVariable = createObjectVariable;
                int i9 = (constraintAnchorArr2[i8].mTarget == null || constraintAnchorArr2[i8].mTarget.mOwner != this) ? 0 : constraintAnchorArr2[i8].mMargin + 0;
                int i10 = this.mBarrierType;
                if (i10 == 0 || i10 == 2) {
                    linearSystem.addLowerBarrier(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin - i9, z);
                } else {
                    linearSystem.addGreaterBarrier(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin + i9, z);
                }
                linearSystem.addEquality(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin + i9, i6);
            }
        }
        int i11 = this.mBarrierType;
        if (i11 == 0) {
            linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
            solverVariable = this.mLeft.mSolverVariable;
            constraintAnchor = this.mParent.mLeft;
        } else if (i11 == 1) {
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
            solverVariable = this.mLeft.mSolverVariable;
            constraintAnchor = this.mParent.mRight;
        } else if (i11 == 2) {
            linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
            solverVariable = this.mTop.mSolverVariable;
            constraintAnchor = this.mParent.mTop;
        } else if (i11 != 3) {
            return;
        } else {
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
            solverVariable = this.mTop.mSolverVariable;
            constraintAnchor = this.mParent.mBottom;
        }
        linearSystem.addEquality(solverVariable, constraintAnchor.mSolverVariable, 0, 0);
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Barrier barrier = (Barrier) constraintWidget;
        this.mBarrierType = barrier.mBarrierType;
        this.mAllowsGoneWidget = barrier.mAllowsGoneWidget;
        this.mMargin = barrier.mMargin;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    public void markWidgets() {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            int i2 = this.mBarrierType;
            if (i2 == 0 || i2 == 1) {
                constraintWidget.setInBarrier(0, true);
            } else if (i2 == 2 || i2 == 3) {
                constraintWidget.setInBarrier(1, true);
            }
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        this.mAllowsGoneWidget = z;
    }

    public void setBarrierType(int i) {
        this.mBarrierType = i;
    }

    public void setMargin(int i) {
        this.mMargin = i;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[Barrier] ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getDebugName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" {");
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (i > 0) {
                sb = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, ", ");
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(constraintWidget.getDebugName());
            sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
        }
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "}");
    }
}

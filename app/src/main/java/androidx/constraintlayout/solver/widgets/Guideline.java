package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Guideline extends ConstraintWidget {
    public static final int HORIZONTAL = 0;
    public static final int RELATIVE_BEGIN = 1;
    public static final int RELATIVE_END = 2;
    public static final int RELATIVE_PERCENT = 0;
    public static final int RELATIVE_UNKNWON = -1;
    public static final int VERTICAL = 1;
    public float mRelativePercent = -1.0f;
    public int mRelativeBegin = -1;
    public int mRelativeEnd = -1;
    public ConstraintAnchor mAnchor = this.mTop;
    public int mOrientation = 0;
    public int mMinimumPosition = 0;

    /* renamed from: androidx.constraintlayout.solver.widgets.Guideline$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C01761 {

        /* renamed from: $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type */
        public static final /* synthetic */ int[] f39x4c44d048;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f39x4c44d048 = iArr;
            try {
                ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f39x4c44d048;
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                iArr2[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f39x4c44d048;
                ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f39x4c44d048;
                ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                iArr4[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = f39x4c44d048;
                ConstraintAnchor.Type type5 = ConstraintAnchor.Type.BASELINE;
                iArr5[5] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = f39x4c44d048;
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.CENTER;
                iArr6[6] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = f39x4c44d048;
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.CENTER_X;
                iArr7[7] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                int[] iArr8 = f39x4c44d048;
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.CENTER_Y;
                iArr8[8] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                int[] iArr9 = f39x4c44d048;
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.NONE;
                iArr9[0] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public Guideline() {
        this.mAnchors.clear();
        this.mAnchors.add(this.mAnchor);
        int length = this.mListAnchors.length;
        for (int i = 0; i < length; i++) {
            this.mListAnchors[i] = this.mAnchor;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) getParent();
        if (constraintWidgetContainer == null) {
            return;
        }
        ConstraintAnchor anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget constraintWidget = this.mParent;
        boolean z = true;
        boolean z2 = constraintWidget != null && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (this.mOrientation == 0) {
            anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.TOP);
            anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintWidget constraintWidget2 = this.mParent;
            if (constraintWidget2 == null || constraintWidget2.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                z = false;
            }
            z2 = z;
        }
        if (this.mRelativeBegin != -1) {
            SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mAnchor);
            linearSystem.addEquality(createObjectVariable, linearSystem.createObjectVariable(anchor), this.mRelativeBegin, 8);
            if (!z2) {
                return;
            }
            linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), createObjectVariable, 0, 5);
        } else if (this.mRelativeEnd == -1) {
            if (this.mRelativePercent == -1.0f) {
                return;
            }
            linearSystem.addConstraint(LinearSystem.createRowDimensionPercent(linearSystem, linearSystem.createObjectVariable(this.mAnchor), linearSystem.createObjectVariable(anchor2), this.mRelativePercent));
        } else {
            SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mAnchor);
            SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(anchor2);
            linearSystem.addEquality(createObjectVariable2, createObjectVariable3, -this.mRelativeEnd, 8);
            if (!z2) {
                return;
            }
            linearSystem.addGreaterThan(createObjectVariable2, linearSystem.createObjectVariable(anchor), 0, 5);
            linearSystem.addGreaterThan(createObjectVariable3, createObjectVariable2, 0, 5);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Guideline guideline = (Guideline) constraintWidget;
        this.mRelativePercent = guideline.mRelativePercent;
        this.mRelativeBegin = guideline.mRelativeBegin;
        this.mRelativeEnd = guideline.mRelativeEnd;
        setOrientation(guideline.mOrientation);
    }

    public void cyclePosition() {
        if (this.mRelativeBegin != -1) {
            inferRelativePercentPosition();
        } else if (this.mRelativePercent != -1.0f) {
            inferRelativeEndPosition();
        } else if (this.mRelativeEnd == -1) {
        } else {
            inferRelativeBeginPosition();
        }
    }

    public ConstraintAnchor getAnchor() {
        return this.mAnchor;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (type.ordinal()) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
            case 3:
                if (this.mOrientation == 1) {
                    return this.mAnchor;
                }
                break;
            case 2:
            case 4:
                if (this.mOrientation == 0) {
                    return this.mAnchor;
                }
                break;
        }
        throw new AssertionError(type.name());
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getRelativeBegin() {
        return this.mRelativeBegin;
    }

    public int getRelativeBehaviour() {
        if (this.mRelativePercent != -1.0f) {
            return 0;
        }
        if (this.mRelativeBegin != -1) {
            return 1;
        }
        return this.mRelativeEnd != -1 ? 2 : -1;
    }

    public int getRelativeEnd() {
        return this.mRelativeEnd;
    }

    public float getRelativePercent() {
        return this.mRelativePercent;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        return "Guideline";
    }

    public void inferRelativeBeginPosition() {
        int x = getX();
        if (this.mOrientation == 0) {
            x = getY();
        }
        setGuideBegin(x);
    }

    public void inferRelativeEndPosition() {
        int width = getParent().getWidth() - getX();
        if (this.mOrientation == 0) {
            width = getParent().getHeight() - getY();
        }
        setGuideEnd(width);
    }

    public void inferRelativePercentPosition() {
        float x = getX() / getParent().getWidth();
        if (this.mOrientation == 0) {
            x = getY() / getParent().getHeight();
        }
        setGuidePercent(x);
    }

    public boolean isPercent() {
        return this.mRelativePercent != -1.0f && this.mRelativeBegin == -1 && this.mRelativeEnd == -1;
    }

    public void setGuideBegin(int i) {
        if (i > -1) {
            this.mRelativePercent = -1.0f;
            this.mRelativeBegin = i;
            this.mRelativeEnd = -1;
        }
    }

    public void setGuideEnd(int i) {
        if (i > -1) {
            this.mRelativePercent = -1.0f;
            this.mRelativeBegin = -1;
            this.mRelativeEnd = i;
        }
    }

    public void setGuidePercent(float f) {
        if (f > -1.0f) {
            this.mRelativePercent = f;
            this.mRelativeBegin = -1;
            this.mRelativeEnd = -1;
        }
    }

    public void setGuidePercent(int i) {
        setGuidePercent(i / 100.0f);
    }

    public void setMinimumPosition(int i) {
        this.mMinimumPosition = i;
    }

    public void setOrientation(int i) {
        if (this.mOrientation == i) {
            return;
        }
        this.mOrientation = i;
        this.mAnchors.clear();
        this.mAnchor = this.mOrientation == 1 ? this.mLeft : this.mTop;
        this.mAnchors.add(this.mAnchor);
        int length = this.mListAnchors.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.mListAnchors[i2] = this.mAnchor;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromSolver(LinearSystem linearSystem) {
        if (getParent() == null) {
            return;
        }
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mAnchor);
        if (this.mOrientation == 1) {
            setX(objectVariableValue);
            setY(0);
            setHeight(getParent().getHeight());
            setWidth(0);
            return;
        }
        setX(0);
        setY(objectVariableValue);
        setWidth(getParent().getWidth());
        setHeight(0);
    }
}

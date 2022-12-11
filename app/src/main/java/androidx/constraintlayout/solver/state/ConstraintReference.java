package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class ConstraintReference implements Reference {
    public Object key;
    public ConstraintWidget mConstraintWidget;
    public final State mState;
    public Object mView;
    public int mHorizontalChainStyle = 0;
    public int mVerticalChainStyle = 0;
    public float mHorizontalBias = 0.5f;
    public float mVerticalBias = 0.5f;
    public int mMarginLeft = 0;
    public int mMarginRight = 0;
    public int mMarginStart = 0;
    public int mMarginEnd = 0;
    public int mMarginTop = 0;
    public int mMarginBottom = 0;
    public int mMarginLeftGone = 0;
    public int mMarginRightGone = 0;
    public int mMarginStartGone = 0;
    public int mMarginEndGone = 0;
    public int mMarginTopGone = 0;
    public int mMarginBottomGone = 0;
    public Object mLeftToLeft = null;
    public Object mLeftToRight = null;
    public Object mRightToLeft = null;
    public Object mRightToRight = null;
    public Object mStartToStart = null;
    public Object mStartToEnd = null;
    public Object mEndToStart = null;
    public Object mEndToEnd = null;
    public Object mTopToTop = null;
    public Object mTopToBottom = null;
    public Object mBottomToTop = null;
    public Object mBottomToBottom = null;
    public Object mBaselineToBaseline = null;
    public State.Constraint mLast = null;
    public Dimension mHorizontalDimension = Dimension.Fixed(Dimension.WRAP_DIMENSION);
    public Dimension mVerticalDimension = Dimension.Fixed(Dimension.WRAP_DIMENSION);

    /* renamed from: androidx.constraintlayout.solver.state.ConstraintReference$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C01691 {

        /* renamed from: $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint */
        public static final /* synthetic */ int[] f32x7d4bfe12;

        static {
            int[] iArr = new int[State.Constraint.values().length];
            f32x7d4bfe12 = iArr;
            try {
                State.Constraint constraint = State.Constraint.LEFT_TO_LEFT;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f32x7d4bfe12;
                State.Constraint constraint2 = State.Constraint.LEFT_TO_RIGHT;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f32x7d4bfe12;
                State.Constraint constraint3 = State.Constraint.RIGHT_TO_LEFT;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f32x7d4bfe12;
                State.Constraint constraint4 = State.Constraint.RIGHT_TO_RIGHT;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = f32x7d4bfe12;
                State.Constraint constraint5 = State.Constraint.START_TO_START;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = f32x7d4bfe12;
                State.Constraint constraint6 = State.Constraint.START_TO_END;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = f32x7d4bfe12;
                State.Constraint constraint7 = State.Constraint.END_TO_START;
                iArr7[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                int[] iArr8 = f32x7d4bfe12;
                State.Constraint constraint8 = State.Constraint.END_TO_END;
                iArr8[7] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                int[] iArr9 = f32x7d4bfe12;
                State.Constraint constraint9 = State.Constraint.TOP_TO_TOP;
                iArr9[8] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                int[] iArr10 = f32x7d4bfe12;
                State.Constraint constraint10 = State.Constraint.TOP_TO_BOTTOM;
                iArr10[9] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                int[] iArr11 = f32x7d4bfe12;
                State.Constraint constraint11 = State.Constraint.BOTTOM_TO_TOP;
                iArr11[10] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                int[] iArr12 = f32x7d4bfe12;
                State.Constraint constraint12 = State.Constraint.BOTTOM_TO_BOTTOM;
                iArr12[11] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                int[] iArr13 = f32x7d4bfe12;
                State.Constraint constraint13 = State.Constraint.BASELINE_TO_BASELINE;
                iArr13[12] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                int[] iArr14 = f32x7d4bfe12;
                State.Constraint constraint14 = State.Constraint.CENTER_HORIZONTALLY;
                iArr14[13] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                int[] iArr15 = f32x7d4bfe12;
                State.Constraint constraint15 = State.Constraint.CENTER_VERTICALLY;
                iArr15[14] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface ConstraintReferenceFactory {
        ConstraintReference create(State state);
    }

    /* loaded from: classes3.dex */
    public class IncorrectConstraintException extends Exception {
        public final ArrayList<String> mErrors;

        public IncorrectConstraintException(ArrayList<String> arrayList) {
            this.mErrors = arrayList;
        }

        public ArrayList<String> getErrors() {
            return this.mErrors;
        }

        @Override // java.lang.Throwable
        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("IncorrectConstraintException: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mErrors.toString());
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    public ConstraintReference(State state) {
        this.mState = state;
    }

    private void applyConnection(ConstraintWidget constraintWidget, Object obj, State.Constraint constraint) {
        ConstraintAnchor anchor;
        ConstraintAnchor.Type type;
        ConstraintAnchor anchor2;
        int i;
        int i2;
        ConstraintAnchor.Type type2;
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        ConstraintAnchor.Type type5;
        ConstraintAnchor.Type type6;
        ConstraintWidget target = getTarget(obj);
        if (target == null) {
            return;
        }
        int i3 = C01691.f32x7d4bfe12[constraint.ordinal()];
        switch (constraint.ordinal()) {
            case 0:
                anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
                type = ConstraintAnchor.Type.LEFT;
                anchor2 = target.getAnchor(type);
                i = this.mMarginLeft;
                i2 = this.mMarginLeftGone;
                anchor.connect(anchor2, i, i2, false);
                return;
            case 1:
                anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
                type = ConstraintAnchor.Type.RIGHT;
                anchor2 = target.getAnchor(type);
                i = this.mMarginLeft;
                i2 = this.mMarginLeftGone;
                anchor.connect(anchor2, i, i2, false);
                return;
            case 2:
                anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT);
                type2 = ConstraintAnchor.Type.LEFT;
                anchor2 = target.getAnchor(type2);
                i = this.mMarginRight;
                i2 = this.mMarginRightGone;
                anchor.connect(anchor2, i, i2, false);
                return;
            case 3:
                anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT);
                type2 = ConstraintAnchor.Type.RIGHT;
                anchor2 = target.getAnchor(type2);
                i = this.mMarginRight;
                i2 = this.mMarginRightGone;
                anchor.connect(anchor2, i, i2, false);
                return;
            case 4:
                anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
                type3 = ConstraintAnchor.Type.LEFT;
                anchor2 = target.getAnchor(type3);
                i = this.mMarginStart;
                i2 = this.mMarginStartGone;
                anchor.connect(anchor2, i, i2, false);
                return;
            case 5:
                anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
                type3 = ConstraintAnchor.Type.RIGHT;
                anchor2 = target.getAnchor(type3);
                i = this.mMarginStart;
                i2 = this.mMarginStartGone;
                anchor.connect(anchor2, i, i2, false);
                return;
            case 6:
                anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT);
                type4 = ConstraintAnchor.Type.LEFT;
                anchor2 = target.getAnchor(type4);
                i = this.mMarginEnd;
                i2 = this.mMarginEndGone;
                anchor.connect(anchor2, i, i2, false);
                return;
            case 7:
                anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT);
                type4 = ConstraintAnchor.Type.RIGHT;
                anchor2 = target.getAnchor(type4);
                i = this.mMarginEnd;
                i2 = this.mMarginEndGone;
                anchor.connect(anchor2, i, i2, false);
                return;
            case 8:
                anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
                type5 = ConstraintAnchor.Type.TOP;
                anchor2 = target.getAnchor(type5);
                i = this.mMarginTop;
                i2 = this.mMarginTopGone;
                anchor.connect(anchor2, i, i2, false);
                return;
            case 9:
                anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
                type5 = ConstraintAnchor.Type.BOTTOM;
                anchor2 = target.getAnchor(type5);
                i = this.mMarginTop;
                i2 = this.mMarginTopGone;
                anchor.connect(anchor2, i, i2, false);
                return;
            case 10:
                anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM);
                type6 = ConstraintAnchor.Type.TOP;
                anchor2 = target.getAnchor(type6);
                i = this.mMarginBottom;
                i2 = this.mMarginBottomGone;
                anchor.connect(anchor2, i, i2, false);
                return;
            case 11:
                anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM);
                type6 = ConstraintAnchor.Type.BOTTOM;
                anchor2 = target.getAnchor(type6);
                i = this.mMarginBottom;
                i2 = this.mMarginBottomGone;
                anchor.connect(anchor2, i, i2, false);
                return;
            case 12:
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.BASELINE;
                constraintWidget.immediateConnect(type7, target, type7, 0, 0);
                return;
            default:
                return;
        }
    }

    private void dereference() {
        this.mLeftToLeft = get(this.mLeftToLeft);
        this.mLeftToRight = get(this.mLeftToRight);
        this.mRightToLeft = get(this.mRightToLeft);
        this.mRightToRight = get(this.mRightToRight);
        this.mStartToStart = get(this.mStartToStart);
        this.mStartToEnd = get(this.mStartToEnd);
        this.mEndToStart = get(this.mEndToStart);
        this.mEndToEnd = get(this.mEndToEnd);
        this.mTopToTop = get(this.mTopToTop);
        this.mTopToBottom = get(this.mTopToBottom);
        this.mBottomToTop = get(this.mBottomToTop);
        this.mBottomToBottom = get(this.mBottomToBottom);
        this.mBaselineToBaseline = get(this.mBaselineToBaseline);
    }

    private Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return !(obj instanceof ConstraintReference) ? this.mState.reference(obj) : obj;
    }

    private ConstraintWidget getTarget(Object obj) {
        if (obj instanceof Reference) {
            return ((Reference) obj).getConstraintWidget();
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void apply() {
        ConstraintWidget constraintWidget = this.mConstraintWidget;
        if (constraintWidget == null) {
            return;
        }
        this.mHorizontalDimension.apply(this.mState, constraintWidget, 0);
        this.mVerticalDimension.apply(this.mState, this.mConstraintWidget, 1);
        dereference();
        applyConnection(this.mConstraintWidget, this.mLeftToLeft, State.Constraint.LEFT_TO_LEFT);
        applyConnection(this.mConstraintWidget, this.mLeftToRight, State.Constraint.LEFT_TO_RIGHT);
        applyConnection(this.mConstraintWidget, this.mRightToLeft, State.Constraint.RIGHT_TO_LEFT);
        applyConnection(this.mConstraintWidget, this.mRightToRight, State.Constraint.RIGHT_TO_RIGHT);
        applyConnection(this.mConstraintWidget, this.mStartToStart, State.Constraint.START_TO_START);
        applyConnection(this.mConstraintWidget, this.mStartToEnd, State.Constraint.START_TO_END);
        applyConnection(this.mConstraintWidget, this.mEndToStart, State.Constraint.END_TO_START);
        applyConnection(this.mConstraintWidget, this.mEndToEnd, State.Constraint.END_TO_END);
        applyConnection(this.mConstraintWidget, this.mTopToTop, State.Constraint.TOP_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mTopToBottom, State.Constraint.TOP_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mBottomToTop, State.Constraint.BOTTOM_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mBottomToBottom, State.Constraint.BOTTOM_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mBaselineToBaseline, State.Constraint.BASELINE_TO_BASELINE);
        int i = this.mHorizontalChainStyle;
        if (i != 0) {
            this.mConstraintWidget.setHorizontalChainStyle(i);
        }
        int i2 = this.mVerticalChainStyle;
        if (i2 != 0) {
            this.mConstraintWidget.setVerticalChainStyle(i2);
        }
        this.mConstraintWidget.setHorizontalBiasPercent(this.mHorizontalBias);
        this.mConstraintWidget.setVerticalBiasPercent(this.mVerticalBias);
    }

    public ConstraintReference baseline() {
        this.mLast = State.Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    public ConstraintReference baselineToBaseline(Object obj) {
        this.mLast = State.Constraint.BASELINE_TO_BASELINE;
        this.mBaselineToBaseline = obj;
        return this;
    }

    public ConstraintReference bias(float f) {
        State.Constraint constraint = this.mLast;
        if (constraint == null) {
            return this;
        }
        switch (constraint.ordinal()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 13:
                this.mHorizontalBias = f;
                break;
            case 8:
            case 9:
            case 10:
            case 11:
            case 14:
                this.mVerticalBias = f;
                break;
        }
        return this;
    }

    public ConstraintReference bottom() {
        this.mLast = this.mBottomToTop != null ? State.Constraint.BOTTOM_TO_TOP : State.Constraint.BOTTOM_TO_BOTTOM;
        return this;
    }

    public ConstraintReference bottomToBottom(Object obj) {
        this.mLast = State.Constraint.BOTTOM_TO_BOTTOM;
        this.mBottomToBottom = obj;
        return this;
    }

    public ConstraintReference bottomToTop(Object obj) {
        this.mLast = State.Constraint.BOTTOM_TO_TOP;
        this.mBottomToTop = obj;
        return this;
    }

    public ConstraintReference centerHorizontally(Object obj) {
        Object obj2 = get(obj);
        this.mStartToStart = obj2;
        this.mEndToEnd = obj2;
        this.mLast = State.Constraint.CENTER_HORIZONTALLY;
        this.mHorizontalBias = 0.5f;
        return this;
    }

    public ConstraintReference centerVertically(Object obj) {
        Object obj2 = get(obj);
        this.mTopToTop = obj2;
        this.mBottomToBottom = obj2;
        this.mLast = State.Constraint.CENTER_VERTICALLY;
        this.mVerticalBias = 0.5f;
        return this;
    }

    public ConstraintReference clear() {
        State.Constraint constraint = this.mLast;
        if (constraint != null) {
            switch (constraint.ordinal()) {
                case 0:
                case 1:
                    this.mLeftToLeft = null;
                    this.mLeftToRight = null;
                    this.mMarginLeft = 0;
                    this.mMarginLeftGone = 0;
                    break;
                case 2:
                case 3:
                    this.mRightToLeft = null;
                    this.mRightToRight = null;
                    this.mMarginRight = 0;
                    this.mMarginRightGone = 0;
                    break;
                case 4:
                case 5:
                    this.mStartToStart = null;
                    this.mStartToEnd = null;
                    this.mMarginStart = 0;
                    this.mMarginStartGone = 0;
                    break;
                case 6:
                case 7:
                    this.mEndToStart = null;
                    this.mEndToEnd = null;
                    this.mMarginEnd = 0;
                    this.mMarginEndGone = 0;
                    break;
                case 8:
                case 9:
                    this.mTopToTop = null;
                    this.mTopToBottom = null;
                    this.mMarginTop = 0;
                    this.mMarginTopGone = 0;
                    break;
                case 10:
                case 11:
                    this.mBottomToTop = null;
                    this.mBottomToBottom = null;
                    this.mMarginBottom = 0;
                    break;
                case 12:
                    this.mBaselineToBaseline = null;
                    break;
            }
            return this;
        }
        this.mLeftToLeft = null;
        this.mLeftToRight = null;
        this.mMarginLeft = 0;
        this.mRightToLeft = null;
        this.mRightToRight = null;
        this.mMarginRight = 0;
        this.mStartToStart = null;
        this.mStartToEnd = null;
        this.mMarginStart = 0;
        this.mEndToStart = null;
        this.mEndToEnd = null;
        this.mMarginEnd = 0;
        this.mTopToTop = null;
        this.mTopToBottom = null;
        this.mMarginTop = 0;
        this.mBottomToTop = null;
        this.mBottomToBottom = null;
        this.mMarginBottom = 0;
        this.mBaselineToBaseline = null;
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mMarginLeftGone = 0;
        this.mMarginRightGone = 0;
        this.mMarginStartGone = 0;
        this.mMarginEndGone = 0;
        this.mMarginTopGone = 0;
        this.mMarginBottomGone = 0;
        return this;
    }

    public ConstraintReference clearHorizontal() {
        start().clear();
        end().clear();
        left().clear();
        right().clear();
        return this;
    }

    public ConstraintReference clearVertical() {
        top().clear();
        baseline().clear();
        bottom().clear();
        return this;
    }

    public ConstraintWidget createConstraintWidget() {
        return new ConstraintWidget(getWidth().getValue(), getHeight().getValue());
    }

    public ConstraintReference end() {
        this.mLast = this.mEndToStart != null ? State.Constraint.END_TO_START : State.Constraint.END_TO_END;
        return this;
    }

    public ConstraintReference endToEnd(Object obj) {
        this.mLast = State.Constraint.END_TO_END;
        this.mEndToEnd = obj;
        return this;
    }

    public ConstraintReference endToStart(Object obj) {
        this.mLast = State.Constraint.END_TO_START;
        this.mEndToStart = obj;
        return this;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.mConstraintWidget == null) {
            ConstraintWidget createConstraintWidget = createConstraintWidget();
            this.mConstraintWidget = createConstraintWidget;
            createConstraintWidget.setCompanionWidget(this.mView);
        }
        return this.mConstraintWidget;
    }

    public Dimension getHeight() {
        return this.mVerticalDimension;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public Object getKey() {
        return this.key;
    }

    public int getVerticalChainStyle(int i) {
        return this.mVerticalChainStyle;
    }

    public Object getView() {
        return this.mView;
    }

    public Dimension getWidth() {
        return this.mHorizontalDimension;
    }

    public ConstraintReference height(Dimension dimension) {
        return setHeight(dimension);
    }

    public ConstraintReference horizontalBias(float f) {
        this.mHorizontalBias = f;
        return this;
    }

    public ConstraintReference left() {
        this.mLast = this.mLeftToLeft != null ? State.Constraint.LEFT_TO_LEFT : State.Constraint.LEFT_TO_RIGHT;
        return this;
    }

    public ConstraintReference leftToLeft(Object obj) {
        this.mLast = State.Constraint.LEFT_TO_LEFT;
        this.mLeftToLeft = obj;
        return this;
    }

    public ConstraintReference leftToRight(Object obj) {
        this.mLast = State.Constraint.LEFT_TO_RIGHT;
        this.mLeftToRight = obj;
        return this;
    }

    public ConstraintReference margin(int i) {
        State.Constraint constraint = this.mLast;
        if (constraint != null) {
            switch (constraint.ordinal()) {
                case 0:
                case 1:
                    this.mMarginLeft = i;
                    break;
                case 2:
                case 3:
                    this.mMarginRight = i;
                    break;
                case 4:
                case 5:
                    this.mMarginStart = i;
                    break;
                case 6:
                case 7:
                    this.mMarginEnd = i;
                    break;
                case 8:
                case 9:
                    this.mMarginTop = i;
                    break;
            }
            return this;
        }
        this.mMarginLeft = i;
        this.mMarginRight = i;
        this.mMarginStart = i;
        this.mMarginEnd = i;
        this.mMarginTop = i;
        this.mMarginBottom = i;
        return this;
    }

    public ConstraintReference margin(Object obj) {
        return margin(this.mState.convertDimension(obj));
    }

    public ConstraintReference marginGone(int i) {
        State.Constraint constraint = this.mLast;
        if (constraint != null) {
            switch (constraint.ordinal()) {
                case 0:
                case 1:
                    this.mMarginLeftGone = i;
                    break;
                case 2:
                case 3:
                    this.mMarginRightGone = i;
                    break;
                case 4:
                case 5:
                    this.mMarginStartGone = i;
                    break;
                case 6:
                case 7:
                    this.mMarginEndGone = i;
                    break;
                case 8:
                case 9:
                    this.mMarginTopGone = i;
                    break;
            }
            return this;
        }
        this.mMarginLeftGone = i;
        this.mMarginRightGone = i;
        this.mMarginStartGone = i;
        this.mMarginEndGone = i;
        this.mMarginTopGone = i;
        this.mMarginBottomGone = i;
        return this;
    }

    public ConstraintReference right() {
        this.mLast = this.mRightToLeft != null ? State.Constraint.RIGHT_TO_LEFT : State.Constraint.RIGHT_TO_RIGHT;
        return this;
    }

    public ConstraintReference rightToLeft(Object obj) {
        this.mLast = State.Constraint.RIGHT_TO_LEFT;
        this.mRightToLeft = obj;
        return this;
    }

    public ConstraintReference rightToRight(Object obj) {
        this.mLast = State.Constraint.RIGHT_TO_RIGHT;
        this.mRightToRight = obj;
        return this;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setConstraintWidget(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return;
        }
        this.mConstraintWidget = constraintWidget;
        constraintWidget.setCompanionWidget(this.mView);
    }

    public ConstraintReference setHeight(Dimension dimension) {
        this.mVerticalDimension = dimension;
        return this;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setKey(Object obj) {
        this.key = obj;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public void setView(Object obj) {
        this.mView = obj;
        ConstraintWidget constraintWidget = this.mConstraintWidget;
        if (constraintWidget != null) {
            constraintWidget.setCompanionWidget(obj);
        }
    }

    public ConstraintReference setWidth(Dimension dimension) {
        this.mHorizontalDimension = dimension;
        return this;
    }

    public ConstraintReference start() {
        this.mLast = this.mStartToStart != null ? State.Constraint.START_TO_START : State.Constraint.START_TO_END;
        return this;
    }

    public ConstraintReference startToEnd(Object obj) {
        this.mLast = State.Constraint.START_TO_END;
        this.mStartToEnd = obj;
        return this;
    }

    public ConstraintReference startToStart(Object obj) {
        this.mLast = State.Constraint.START_TO_START;
        this.mStartToStart = obj;
        return this;
    }

    public ConstraintReference top() {
        this.mLast = this.mTopToTop != null ? State.Constraint.TOP_TO_TOP : State.Constraint.TOP_TO_BOTTOM;
        return this;
    }

    public ConstraintReference topToBottom(Object obj) {
        this.mLast = State.Constraint.TOP_TO_BOTTOM;
        this.mTopToBottom = obj;
        return this;
    }

    public ConstraintReference topToTop(Object obj) {
        this.mLast = State.Constraint.TOP_TO_TOP;
        this.mTopToTop = obj;
        return this;
    }

    public void validate() throws IncorrectConstraintException {
        ArrayList arrayList = new ArrayList();
        if (this.mLeftToLeft != null && this.mLeftToRight != null) {
            arrayList.add("LeftToLeft and LeftToRight both defined");
        }
        if (this.mRightToLeft != null && this.mRightToRight != null) {
            arrayList.add("RightToLeft and RightToRight both defined");
        }
        if (this.mStartToStart != null && this.mStartToEnd != null) {
            arrayList.add("StartToStart and StartToEnd both defined");
        }
        if (this.mEndToStart != null && this.mEndToEnd != null) {
            arrayList.add("EndToStart and EndToEnd both defined");
        }
        if ((this.mLeftToLeft != null || this.mLeftToRight != null || this.mRightToLeft != null || this.mRightToRight != null) && (this.mStartToStart != null || this.mStartToEnd != null || this.mEndToStart != null || this.mEndToEnd != null)) {
            arrayList.add("Both left/right and start/end constraints defined");
        }
        if (arrayList.size() <= 0) {
            return;
        }
        throw new IncorrectConstraintException(arrayList);
    }

    public ConstraintReference verticalBias(float f) {
        this.mVerticalBias = f;
        return this;
    }

    public ConstraintReference width(Dimension dimension) {
        return setWidth(dimension);
    }
}

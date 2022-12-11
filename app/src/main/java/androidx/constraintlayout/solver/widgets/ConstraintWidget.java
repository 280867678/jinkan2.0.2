package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    public static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    public static final int DIMENSION_HORIZONTAL = 0;
    public static final int DIMENSION_VERTICAL = 1;
    public static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    public static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    public static final int WRAP = -2;
    public boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public HorizontalWidgetRun horizontalRun;
    public boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    public ArrayList<ConstraintAnchor> mAnchors;
    public ConstraintAnchor mBaseline;
    public int mBaselineDistance;
    public ConstraintAnchor mBottom;
    public boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    public ConstraintAnchor mCenterX;
    public ConstraintAnchor mCenterY;
    public float mCircleConstraintAngle;
    public Object mCompanionWidget;
    public int mContainerItemSkip;
    public String mDebugName;
    public float mDimensionRatio;
    public int mDimensionRatioSide;
    public int mDistToBottom;
    public int mDistToLeft;
    public int mDistToRight;
    public int mDistToTop;
    public boolean mGroupsToSolver;
    public int mHeight;
    public float mHorizontalBiasPercent;
    public boolean mHorizontalChainFixedPosition;
    public int mHorizontalChainStyle;
    public ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    public boolean mHorizontalWrapVisited;
    public boolean mInVirtuaLayout;
    public boolean mIsHeightWrapContent;
    public boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    public ConstraintAnchor mLeft;
    public boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    public ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    public int[] mMaxDimension;
    public int mMinHeight;
    public int mMinWidth;
    public ConstraintWidget[] mNextChainWidget;
    public int mOffsetX;
    public int mOffsetY;
    public boolean mOptimizerMeasurable;
    public ConstraintWidget mParent;
    public int mRelX;
    public int mRelY;
    public float mResolvedDimensionRatio;
    public int mResolvedDimensionRatioSide;
    public boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    public boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    public boolean mTopHasCentered;
    public String mType;
    public float mVerticalBiasPercent;
    public boolean mVerticalChainFixedPosition;
    public int mVerticalChainStyle;
    public ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    public boolean mVerticalWrapVisited;
    public int mVisibility;
    public float[] mWeight;
    public int mWidth;

    /* renamed from: mX */
    public int f35mX;

    /* renamed from: mY */
    public int f36mY;
    public boolean measured;
    public WidgetRun[] run;
    public ChainRun verticalChainRun;
    public VerticalWidgetRun verticalRun;
    public int[] wrapMeasure;

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C01751 {

        /* renamed from: $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type */
        public static final /* synthetic */ int[] f37x4c44d048;

        /* renamed from: $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour */
        public static final /* synthetic */ int[] f38xdde91696;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            f38xdde91696 = iArr;
            try {
                DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f38xdde91696;
                DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f38xdde91696;
                DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_PARENT;
                iArr3[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f38xdde91696;
                DimensionBehaviour dimensionBehaviour4 = DimensionBehaviour.MATCH_CONSTRAINT;
                iArr4[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr5 = new int[ConstraintAnchor.Type.values().length];
            f37x4c44d048 = iArr5;
            try {
                ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                iArr5[1] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = f37x4c44d048;
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
                iArr6[2] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = f37x4c44d048;
                ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
                iArr7[3] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                int[] iArr8 = f37x4c44d048;
                ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                iArr8[4] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                int[] iArr9 = f37x4c44d048;
                ConstraintAnchor.Type type5 = ConstraintAnchor.Type.BASELINE;
                iArr9[5] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                int[] iArr10 = f37x4c44d048;
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.CENTER;
                iArr10[6] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                int[] iArr11 = f37x4c44d048;
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.CENTER_X;
                iArr11[7] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                int[] iArr12 = f37x4c44d048;
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.CENTER_Y;
                iArr12[8] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                int[] iArr13 = f37x4c44d048;
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.NONE;
                iArr13[0] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedHasRatio = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f35mX = 0;
        this.f36mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedHasRatio = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f35mX = 0;
        this.f36mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.f35mX = i;
        this.f36mY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        addAnchors();
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0340 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x042e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0406 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void applyConstraints(LinearSystem linearSystem, boolean z, boolean z2, boolean z3, boolean z4, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z6, boolean z7, boolean z8, boolean z9, int i5, int i6, int i7, int i8, float f2, boolean z10) {
        int i9;
        boolean z11;
        int i10;
        SolverVariable solverVariable3;
        int i11;
        int i12;
        int i13;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        boolean z12;
        boolean z13;
        SolverVariable createObjectVariable;
        ConstraintWidget constraintWidget;
        ConstraintAnchor.Type type;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        int i14;
        int i15;
        int i16;
        char c;
        int i17;
        ConstraintAnchor constraintAnchor3;
        boolean z14;
        boolean z15;
        int i18;
        boolean z16;
        int i19;
        int i20;
        boolean z17;
        boolean z18;
        SolverVariable solverVariable11;
        int i21;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        SolverVariable solverVariable12;
        int i22;
        SolverVariable solverVariable13;
        SolverVariable solverVariable14;
        int i23;
        int i24;
        boolean z19;
        ConstraintWidget constraintWidget4;
        int i25;
        int i26;
        int i27;
        boolean z20;
        boolean z21;
        int i28;
        int i29;
        SolverVariable solverVariable15;
        int i30;
        int i31 = i7;
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(constraintAnchor);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(constraintAnchor2);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(constraintAnchor2.getTarget());
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().nonresolvedWidgets++;
        }
        boolean isConnected = constraintAnchor.isConnected();
        boolean isConnected2 = constraintAnchor2.isConnected();
        boolean isConnected3 = this.mCenter.isConnected();
        int i32 = isConnected ? 1 : 0;
        if (isConnected2) {
            i32++;
        }
        if (isConnected3) {
            i32++;
        }
        int i33 = i32;
        int i34 = z6 ? 3 : i5;
        int ordinal = dimensionBehaviour.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1 && ordinal == 2) {
                i9 = i34;
                if (i9 != 4) {
                    z11 = true;
                    if (this.mVisibility != 8) {
                        i10 = 0;
                        z11 = false;
                    } else {
                        i10 = i2;
                    }
                    if (z10) {
                        if (!isConnected && !isConnected2 && !isConnected3) {
                            linearSystem.addEquality(createObjectVariable2, i);
                        } else if (isConnected && !isConnected2) {
                            solverVariable3 = createObjectVariable5;
                            linearSystem.addEquality(createObjectVariable2, createObjectVariable4, constraintAnchor.getMargin(), 8);
                            if (z11) {
                                if (i33 == 2 || z6 || !(i9 == 1 || i9 == 0)) {
                                    if (i31 == -2) {
                                        i31 = i10;
                                    }
                                    int i35 = i8 == -2 ? i10 : i8;
                                    if (i10 > 0 && i9 != 1) {
                                        i10 = 0;
                                    }
                                    if (i31 > 0) {
                                        linearSystem.addGreaterThan(createObjectVariable3, createObjectVariable2, i31, 8);
                                        i10 = Math.max(i10, i31);
                                    }
                                    if (i35 > 0) {
                                        if (!z2 || i9 != 1) {
                                            i11 = 8;
                                            linearSystem.addLowerThan(createObjectVariable3, createObjectVariable2, i35, 8);
                                        } else {
                                            i11 = 8;
                                        }
                                        i10 = Math.min(i10, i35);
                                    } else {
                                        i11 = 8;
                                    }
                                    if (i9 == 1) {
                                        if (z2) {
                                            linearSystem.addEquality(createObjectVariable3, createObjectVariable2, i10, i11);
                                        } else {
                                            linearSystem.addEquality(createObjectVariable3, createObjectVariable2, i10, 5);
                                            linearSystem.addLowerThan(createObjectVariable3, createObjectVariable2, i10, i11);
                                        }
                                        i33 = i33;
                                        i12 = i31;
                                        i13 = i35;
                                    } else if (i9 != 2) {
                                        i33 = i33;
                                        i12 = i31;
                                        i13 = i35;
                                        solverVariable4 = createObjectVariable4;
                                        solverVariable5 = createObjectVariable3;
                                        solverVariable6 = solverVariable3;
                                        z12 = z11;
                                        z13 = true;
                                        if (!z10) {
                                            solverVariable7 = solverVariable2;
                                            solverVariable8 = solverVariable5;
                                            solverVariable9 = createObjectVariable2;
                                            solverVariable10 = solverVariable;
                                            i14 = 0;
                                            i15 = 2;
                                            i16 = 8;
                                            c = 1;
                                            i17 = i33;
                                        } else if (z7) {
                                            solverVariable7 = solverVariable2;
                                            solverVariable8 = solverVariable5;
                                            solverVariable9 = createObjectVariable2;
                                            solverVariable10 = solverVariable;
                                            i17 = i33;
                                            i14 = 0;
                                            i15 = 2;
                                            i16 = 8;
                                            c = 1;
                                        } else {
                                            if ((isConnected || isConnected2 || isConnected3) && (!isConnected || isConnected2)) {
                                                if (!isConnected && isConnected2) {
                                                    linearSystem.addEquality(solverVariable5, solverVariable6, -constraintAnchor2.getMargin(), 8);
                                                    if (z2) {
                                                        linearSystem.addGreaterThan(createObjectVariable2, solverVariable, 0, 5);
                                                    }
                                                } else if (isConnected && isConnected2) {
                                                    ConstraintWidget constraintWidget5 = constraintAnchor.mTarget.mOwner;
                                                    ConstraintWidget constraintWidget6 = constraintAnchor2.mTarget.mOwner;
                                                    ConstraintWidget parent = getParent();
                                                    int i36 = 6;
                                                    if (z12) {
                                                        if (i9 == 0) {
                                                            if (i13 == 0 && i12 == 0) {
                                                                z20 = false;
                                                                z21 = true;
                                                                i28 = 8;
                                                                i29 = 8;
                                                            } else {
                                                                z20 = true;
                                                                z21 = false;
                                                                i28 = 5;
                                                                i29 = 5;
                                                            }
                                                            if ((constraintWidget5 instanceof Barrier) || (constraintWidget6 instanceof Barrier)) {
                                                                z15 = z20;
                                                                i20 = i29;
                                                                z14 = false;
                                                                i18 = 6;
                                                                i19 = 4;
                                                            } else {
                                                                z15 = z20;
                                                                i19 = i28;
                                                                i20 = i29;
                                                                z14 = false;
                                                                i18 = 6;
                                                            }
                                                            z16 = z21;
                                                        } else {
                                                            if (i9 == 1) {
                                                                z14 = true;
                                                                z15 = true;
                                                                i18 = 6;
                                                                z16 = false;
                                                                i19 = 4;
                                                            } else if (i9 != 3) {
                                                                z14 = false;
                                                                z15 = false;
                                                            } else if (this.mResolvedDimensionRatioSide == -1) {
                                                                z14 = true;
                                                                z15 = true;
                                                                i18 = z8 ? z2 ? 5 : 4 : 8;
                                                                z16 = true;
                                                                i19 = 5;
                                                            } else if (z6) {
                                                                if (!(i6 == 2 || i6 == 1)) {
                                                                    i26 = 5;
                                                                    i27 = 8;
                                                                } else {
                                                                    i26 = 4;
                                                                    i27 = 5;
                                                                }
                                                                i19 = i26;
                                                                i20 = i27;
                                                                z14 = true;
                                                                z15 = true;
                                                                i18 = 6;
                                                                z16 = true;
                                                            } else {
                                                                if (i13 > 0) {
                                                                    z14 = true;
                                                                    z15 = true;
                                                                    i18 = 6;
                                                                    z16 = true;
                                                                    i19 = 5;
                                                                } else if (i13 != 0 || i12 != 0) {
                                                                    z14 = true;
                                                                    z15 = true;
                                                                    i18 = 6;
                                                                    z16 = true;
                                                                    i19 = 4;
                                                                } else if (!z8) {
                                                                    z14 = true;
                                                                    z15 = true;
                                                                    i18 = 6;
                                                                    z16 = true;
                                                                    i19 = 8;
                                                                } else {
                                                                    i20 = (constraintWidget5 == parent || constraintWidget6 == parent) ? 5 : 4;
                                                                    z14 = true;
                                                                    z15 = true;
                                                                    i18 = 6;
                                                                    z16 = true;
                                                                    i19 = 4;
                                                                }
                                                                i20 = 5;
                                                            }
                                                            i20 = 8;
                                                        }
                                                        if (z14 || solverVariable4 != solverVariable6 || constraintWidget5 == parent) {
                                                            z17 = z14;
                                                            z18 = true;
                                                        } else {
                                                            z17 = false;
                                                            z18 = false;
                                                        }
                                                        if (!z15) {
                                                            if (this.mVisibility == 8) {
                                                                i18 = 4;
                                                            }
                                                            solverVariable11 = solverVariable5;
                                                            i21 = i9;
                                                            constraintWidget3 = constraintWidget6;
                                                            constraintWidget2 = parent;
                                                            i22 = 8;
                                                            solverVariable12 = createObjectVariable2;
                                                            linearSystem.addCentering(createObjectVariable2, solverVariable4, constraintAnchor.getMargin(), f, solverVariable6, solverVariable11, constraintAnchor2.getMargin(), i18);
                                                        } else {
                                                            solverVariable11 = solverVariable5;
                                                            i21 = i9;
                                                            constraintWidget2 = parent;
                                                            constraintWidget3 = constraintWidget6;
                                                            solverVariable12 = createObjectVariable2;
                                                            i22 = 8;
                                                        }
                                                        if (this.mVisibility != i22) {
                                                            return;
                                                        }
                                                        if (z17) {
                                                            int i37 = (!z2 || solverVariable4 == solverVariable6 || z12 || (!(constraintWidget5 instanceof Barrier) && !(constraintWidget3 instanceof Barrier))) ? i20 : 6;
                                                            solverVariable14 = solverVariable12;
                                                            linearSystem.addGreaterThan(solverVariable14, solverVariable4, constraintAnchor.getMargin(), i37);
                                                            solverVariable13 = solverVariable11;
                                                            linearSystem.addLowerThan(solverVariable13, solverVariable6, -constraintAnchor2.getMargin(), i37);
                                                            i20 = i37;
                                                        } else {
                                                            solverVariable13 = solverVariable11;
                                                            solverVariable14 = solverVariable12;
                                                        }
                                                        if (!z2 || !z9 || (constraintWidget5 instanceof Barrier) || (constraintWidget3 instanceof Barrier)) {
                                                            i23 = i19;
                                                            i24 = i20;
                                                            z19 = z18;
                                                        } else {
                                                            i23 = 6;
                                                            i24 = 6;
                                                            z19 = true;
                                                        }
                                                        if (z19) {
                                                            if (!z16 || (z8 && !z3)) {
                                                                constraintWidget4 = constraintWidget2;
                                                            } else {
                                                                constraintWidget4 = constraintWidget2;
                                                                if (constraintWidget5 != constraintWidget4 && constraintWidget3 != constraintWidget4) {
                                                                    i36 = i23;
                                                                }
                                                                if ((constraintWidget5 instanceof Guideline) || (constraintWidget3 instanceof Guideline)) {
                                                                    i36 = 5;
                                                                }
                                                                if ((constraintWidget5 instanceof Barrier) || (constraintWidget3 instanceof Barrier)) {
                                                                    i36 = 5;
                                                                }
                                                                i23 = Math.max(z8 ? 5 : i36, i23);
                                                            }
                                                            if (z2) {
                                                                i25 = Math.min(i24, i23);
                                                                if (z6 && !z8 && (constraintWidget5 == constraintWidget4 || constraintWidget3 == constraintWidget4)) {
                                                                    i25 = 4;
                                                                }
                                                            } else {
                                                                i25 = i23;
                                                            }
                                                            linearSystem.addEquality(solverVariable14, solverVariable4, constraintAnchor.getMargin(), i25);
                                                            linearSystem.addEquality(solverVariable13, solverVariable6, -constraintAnchor2.getMargin(), i25);
                                                        }
                                                        if (z2) {
                                                            int margin = solverVariable == solverVariable4 ? constraintAnchor.getMargin() : 0;
                                                            if (solverVariable4 != solverVariable) {
                                                                linearSystem.addGreaterThan(solverVariable14, solverVariable, margin, 5);
                                                            }
                                                        }
                                                        if (z2 && z12) {
                                                            if (i3 == 0 && i12 == 0) {
                                                                if (!z12 || i21 != 3) {
                                                                    linearSystem.addGreaterThan(solverVariable13, solverVariable14, 0, 5);
                                                                } else {
                                                                    linearSystem.addGreaterThan(solverVariable13, solverVariable14, 0, i22);
                                                                }
                                                            }
                                                            if (z2 || !z13) {
                                                                return;
                                                            }
                                                            if (constraintAnchor2.mTarget != null) {
                                                                i30 = constraintAnchor2.getMargin();
                                                                solverVariable15 = solverVariable2;
                                                            } else {
                                                                solverVariable15 = solverVariable2;
                                                                i30 = 0;
                                                            }
                                                            if (solverVariable6 == solverVariable15) {
                                                                return;
                                                            }
                                                            linearSystem.addGreaterThan(solverVariable15, solverVariable13, i30, 5);
                                                            return;
                                                        }
                                                        if (z2) {
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    z14 = true;
                                                    z15 = true;
                                                    i18 = 6;
                                                    z16 = false;
                                                    i19 = 4;
                                                    i20 = 5;
                                                    if (z14) {
                                                    }
                                                    z17 = z14;
                                                    z18 = true;
                                                    if (!z15) {
                                                    }
                                                    if (this.mVisibility != i22) {
                                                    }
                                                }
                                            }
                                            solverVariable13 = solverVariable5;
                                            if (z2) {
                                            }
                                        }
                                        if (i17 < i15 || !z2 || !z13) {
                                            return;
                                        }
                                        linearSystem.addGreaterThan(solverVariable9, solverVariable10, i14, i16);
                                        boolean z22 = z || this.mBaseline.mTarget == null;
                                        if (!z && (constraintAnchor3 = this.mBaseline.mTarget) != null) {
                                            ConstraintWidget constraintWidget7 = constraintAnchor3.mOwner;
                                            if (constraintWidget7.mDimensionRatio != 0.0f) {
                                                DimensionBehaviour[] dimensionBehaviourArr = constraintWidget7.mListDimensionBehaviors;
                                                DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[i14];
                                                DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
                                                if (dimensionBehaviour2 == dimensionBehaviour3 && dimensionBehaviourArr[c] == dimensionBehaviour3) {
                                                    z22 = true;
                                                }
                                            }
                                            z22 = false;
                                        }
                                        if (!z22) {
                                            return;
                                        }
                                        linearSystem.addGreaterThan(solverVariable7, solverVariable8, i14, i16);
                                        return;
                                    } else {
                                        if (constraintAnchor.getType() == ConstraintAnchor.Type.TOP || constraintAnchor.getType() == ConstraintAnchor.Type.BOTTOM) {
                                            createObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.TOP));
                                            constraintWidget = this.mParent;
                                            type = ConstraintAnchor.Type.BOTTOM;
                                        } else {
                                            createObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                                            constraintWidget = this.mParent;
                                            type = ConstraintAnchor.Type.RIGHT;
                                        }
                                        i12 = i31;
                                        i13 = i35;
                                        solverVariable6 = solverVariable3;
                                        solverVariable4 = createObjectVariable4;
                                        i33 = i33;
                                        solverVariable5 = createObjectVariable3;
                                        linearSystem.addConstraint(linearSystem.createRow().createRowDimensionRatio(createObjectVariable3, createObjectVariable2, linearSystem.createObjectVariable(constraintWidget.getAnchor(type)), createObjectVariable, f2));
                                        z13 = z4;
                                    }
                                } else {
                                    int max = Math.max(i31, i10);
                                    if (i8 > 0) {
                                        max = Math.min(i8, max);
                                    }
                                    linearSystem.addEquality(createObjectVariable3, createObjectVariable2, max, 8);
                                    z13 = z4;
                                    i33 = i33;
                                    i12 = i31;
                                    i13 = i8;
                                    solverVariable4 = createObjectVariable4;
                                    solverVariable5 = createObjectVariable3;
                                    solverVariable6 = solverVariable3;
                                }
                                z12 = false;
                                if (!z10) {
                                }
                                if (i17 < i15) {
                                    return;
                                }
                                return;
                            }
                            if (z5) {
                                linearSystem.addEquality(createObjectVariable3, createObjectVariable2, 0, 3);
                                if (i3 > 0) {
                                    linearSystem.addGreaterThan(createObjectVariable3, createObjectVariable2, i3, 8);
                                }
                                if (i4 < Integer.MAX_VALUE) {
                                    linearSystem.addLowerThan(createObjectVariable3, createObjectVariable2, i4, 8);
                                }
                            } else {
                                linearSystem.addEquality(createObjectVariable3, createObjectVariable2, i10, 8);
                            }
                            i12 = i31;
                            i13 = i8;
                            solverVariable4 = createObjectVariable4;
                            solverVariable5 = createObjectVariable3;
                            solverVariable6 = solverVariable3;
                            z12 = z11;
                            z13 = z4;
                            if (!z10) {
                            }
                            if (i17 < i15) {
                            }
                        }
                    }
                    solverVariable3 = createObjectVariable5;
                    if (z11) {
                    }
                    solverVariable4 = createObjectVariable4;
                    solverVariable5 = createObjectVariable3;
                    solverVariable6 = solverVariable3;
                    z12 = z11;
                    z13 = z4;
                    if (!z10) {
                    }
                    if (i17 < i15) {
                    }
                }
            }
            i9 = i34;
        } else {
            i9 = i34;
        }
        z11 = false;
        if (this.mVisibility != 8) {
        }
        if (z10) {
        }
        solverVariable3 = createObjectVariable5;
        if (z11) {
        }
        solverVariable4 = createObjectVariable4;
        solverVariable5 = createObjectVariable3;
        solverVariable6 = solverVariable3;
        z12 = z11;
        z13 = z4;
        if (!z10) {
        }
        if (i17 < i15) {
        }
    }

    private boolean isChainHead(int i) {
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        if (constraintAnchorArr[i2].mTarget != null && constraintAnchorArr[i2].mTarget.mTarget != constraintAnchorArr[i2]) {
            int i3 = i2 + 1;
            if (constraintAnchorArr[i3].mTarget != null && constraintAnchorArr[i3].mTarget.mTarget == constraintAnchorArr[i3]) {
                return true;
            }
        }
        return false;
    }

    public boolean addFirst() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0297  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addToSolver(LinearSystem linearSystem) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        SolverVariable solverVariable;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        boolean z9;
        SolverVariable solverVariable6;
        DependencyNode dependencyNode;
        LinearSystem linearSystem2;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        int i5;
        int i6;
        int i7;
        boolean z10;
        SolverVariable solverVariable10;
        SolverVariable solverVariable11;
        ConstraintWidget constraintWidget;
        LinearSystem linearSystem3;
        SolverVariable solverVariable12;
        SolverVariable solverVariable13;
        SolverVariable solverVariable14;
        SolverVariable solverVariable15;
        boolean z11;
        int i8;
        int i9;
        int i10;
        boolean isInHorizontalChain;
        boolean isInVerticalChain;
        ConstraintWidget constraintWidget2 = this;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(constraintWidget2.mRight);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(constraintWidget2.mTop);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(constraintWidget2.mBottom);
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(constraintWidget2.mBaseline);
        Metrics metrics = LinearSystem.sMetrics;
        if (metrics != null) {
            metrics.widgets++;
        }
        HorizontalWidgetRun horizontalWidgetRun = constraintWidget2.horizontalRun;
        if (horizontalWidgetRun.start.resolved && horizontalWidgetRun.end.resolved) {
            VerticalWidgetRun verticalWidgetRun = constraintWidget2.verticalRun;
            if (verticalWidgetRun.start.resolved && verticalWidgetRun.end.resolved) {
                Metrics metrics2 = LinearSystem.sMetrics;
                if (metrics2 != null) {
                    metrics2.graphSolved++;
                }
                linearSystem.addEquality(createObjectVariable, constraintWidget2.horizontalRun.start.value);
                linearSystem.addEquality(createObjectVariable2, constraintWidget2.horizontalRun.end.value);
                linearSystem.addEquality(createObjectVariable3, constraintWidget2.verticalRun.start.value);
                linearSystem.addEquality(createObjectVariable4, constraintWidget2.verticalRun.end.value);
                linearSystem.addEquality(createObjectVariable5, constraintWidget2.verticalRun.baseline.value);
                ConstraintWidget constraintWidget3 = constraintWidget2.mParent;
                if (constraintWidget3 == null) {
                    return;
                }
                boolean z12 = constraintWidget3 != null && constraintWidget3.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
                ConstraintWidget constraintWidget4 = constraintWidget2.mParent;
                boolean z13 = constraintWidget4 != null && constraintWidget4.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
                if (z12 && constraintWidget2.isTerminalWidget[0] && !isInHorizontalChain()) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mParent.mRight), createObjectVariable2, 0, 8);
                }
                if (!z13 || !constraintWidget2.isTerminalWidget[1] || isInVerticalChain()) {
                    return;
                }
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mParent.mBottom), createObjectVariable4, 0, 8);
                return;
            }
        }
        Metrics metrics3 = LinearSystem.sMetrics;
        if (metrics3 != null) {
            metrics3.linearSolved++;
        }
        ConstraintWidget constraintWidget5 = constraintWidget2.mParent;
        if (constraintWidget5 != null) {
            boolean z14 = constraintWidget5 != null && constraintWidget5.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
            ConstraintWidget constraintWidget6 = constraintWidget2.mParent;
            boolean z15 = constraintWidget6 != null && constraintWidget6.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
            if (constraintWidget2.isChainHead(0)) {
                ((ConstraintWidgetContainer) constraintWidget2.mParent).addChain(constraintWidget2, 0);
                isInHorizontalChain = true;
            } else {
                isInHorizontalChain = isInHorizontalChain();
            }
            if (constraintWidget2.isChainHead(1)) {
                ((ConstraintWidgetContainer) constraintWidget2.mParent).addChain(constraintWidget2, 1);
                isInVerticalChain = true;
            } else {
                isInVerticalChain = isInVerticalChain();
            }
            if (!isInHorizontalChain && z14 && constraintWidget2.mVisibility != 8 && constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mParent.mRight), createObjectVariable2, 0, 1);
            }
            if (!isInVerticalChain && z15 && constraintWidget2.mVisibility != 8 && constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget == null && constraintWidget2.mBaseline == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mParent.mBottom), createObjectVariable4, 0, 1);
            }
            z2 = z14;
            z = z15;
            z4 = isInHorizontalChain;
            z3 = isInVerticalChain;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        int i11 = constraintWidget2.mWidth;
        int i12 = constraintWidget2.mMinWidth;
        if (i11 < i12) {
            i11 = i12;
        }
        int i13 = constraintWidget2.mHeight;
        int i14 = constraintWidget2.mMinHeight;
        if (i13 < i14) {
            i13 = i14;
        }
        boolean z16 = constraintWidget2.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z17 = constraintWidget2.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT;
        constraintWidget2.mResolvedDimensionRatioSide = constraintWidget2.mDimensionRatioSide;
        float f = constraintWidget2.mDimensionRatio;
        constraintWidget2.mResolvedDimensionRatio = f;
        int i15 = constraintWidget2.mMatchConstraintDefaultWidth;
        int i16 = constraintWidget2.mMatchConstraintDefaultHeight;
        int i17 = i11;
        if (f <= 0.0f || constraintWidget2.mVisibility == 8) {
            solverVariable = createObjectVariable5;
            i = i13;
            i2 = i16;
            i3 = i15;
            i4 = i17;
            z5 = false;
        } else {
            solverVariable = createObjectVariable5;
            if (constraintWidget2.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i15 == 0) {
                i15 = 3;
            }
            if (constraintWidget2.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i16 == 0) {
                i16 = 3;
            }
            DimensionBehaviour[] dimensionBehaviourArr = constraintWidget2.mListDimensionBehaviors;
            DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
            DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2) {
                i10 = 3;
                if (i15 == 3 && i16 == 3) {
                    constraintWidget2.setupDimensionRatio(z2, z, z16, z17);
                    i = i13;
                    i2 = i16;
                    i3 = i15;
                    i4 = i17;
                    z5 = true;
                }
            } else {
                i10 = 3;
            }
            DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidget2.mListDimensionBehaviors;
            DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr2[0];
            DimensionBehaviour dimensionBehaviour4 = DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour3 == dimensionBehaviour4 && i15 == i10) {
                constraintWidget2.mResolvedDimensionRatioSide = 0;
                int i18 = (int) (constraintWidget2.mResolvedDimensionRatio * constraintWidget2.mHeight);
                if (dimensionBehaviourArr2[1] != dimensionBehaviour4) {
                    i4 = i18;
                    i = i13;
                    i2 = i16;
                    z5 = false;
                    i3 = 4;
                } else {
                    i4 = i18;
                    i = i13;
                    i2 = i16;
                    i3 = i15;
                    z5 = true;
                }
            } else {
                if (constraintWidget2.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i16 == 3) {
                    constraintWidget2.mResolvedDimensionRatioSide = 1;
                    if (constraintWidget2.mDimensionRatioSide == -1) {
                        constraintWidget2.mResolvedDimensionRatio = 1.0f / constraintWidget2.mResolvedDimensionRatio;
                    }
                    i13 = (int) (constraintWidget2.mResolvedDimensionRatio * constraintWidget2.mWidth);
                    if (constraintWidget2.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
                        i = i13;
                        i3 = i15;
                        i4 = i17;
                        z5 = false;
                        i2 = 4;
                    }
                }
                i = i13;
                i2 = i16;
                i3 = i15;
                i4 = i17;
                z5 = true;
            }
        }
        int[] iArr = constraintWidget2.mResolvedMatchConstraintDefault;
        iArr[0] = i3;
        iArr[1] = i2;
        constraintWidget2.mResolvedHasRatio = z5;
        if (z5 && ((i9 = constraintWidget2.mResolvedDimensionRatioSide) == 0 || i9 == -1)) {
            z6 = true;
            boolean z18 = constraintWidget2.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT && (constraintWidget2 instanceof ConstraintWidgetContainer);
            int i19 = !z18 ? 0 : i4;
            boolean z19 = !constraintWidget2.mCenter.isConnected();
            boolean[] zArr = constraintWidget2.mIsInBarrier;
            boolean z20 = zArr[0];
            boolean z21 = zArr[1];
            SolverVariable solverVariable16 = null;
            if (constraintWidget2.mHorizontalResolution == 2) {
                HorizontalWidgetRun horizontalWidgetRun2 = constraintWidget2.horizontalRun;
                DependencyNode dependencyNode2 = horizontalWidgetRun2.start;
                if (dependencyNode2.resolved && horizontalWidgetRun2.end.resolved) {
                    linearSystem.addEquality(createObjectVariable, dependencyNode2.value);
                    linearSystem.addEquality(createObjectVariable2, constraintWidget2.horizontalRun.end.value);
                    if (constraintWidget2.mParent != null && z2 && constraintWidget2.isTerminalWidget[0] && !isInHorizontalChain()) {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mParent.mRight), createObjectVariable2, 0, 8);
                    }
                    z7 = z;
                    z8 = z5;
                    solverVariable2 = createObjectVariable4;
                    solverVariable3 = createObjectVariable3;
                    solverVariable4 = createObjectVariable2;
                    solverVariable5 = createObjectVariable;
                    z9 = z2;
                    solverVariable6 = solverVariable;
                    VerticalWidgetRun verticalWidgetRun2 = constraintWidget2.verticalRun;
                    dependencyNode = verticalWidgetRun2.start;
                    if (dependencyNode.resolved || !verticalWidgetRun2.end.resolved) {
                        linearSystem2 = linearSystem;
                        solverVariable7 = solverVariable6;
                        solverVariable8 = solverVariable2;
                        solverVariable9 = solverVariable3;
                        i5 = 8;
                        i6 = 0;
                        i7 = 1;
                        z10 = true;
                    } else {
                        linearSystem2 = linearSystem;
                        solverVariable9 = solverVariable3;
                        linearSystem2.addEquality(solverVariable9, dependencyNode.value);
                        solverVariable8 = solverVariable2;
                        linearSystem2.addEquality(solverVariable8, constraintWidget2.verticalRun.end.value);
                        solverVariable7 = solverVariable6;
                        linearSystem2.addEquality(solverVariable7, constraintWidget2.verticalRun.baseline.value);
                        ConstraintWidget constraintWidget7 = constraintWidget2.mParent;
                        if (constraintWidget7 == null || z3 || !z7) {
                            i5 = 8;
                            i6 = 0;
                            i7 = 1;
                        } else {
                            i7 = 1;
                            if (constraintWidget2.isTerminalWidget[1]) {
                                i5 = 8;
                                i6 = 0;
                                linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(constraintWidget7.mBottom), solverVariable8, 0, 8);
                            } else {
                                i5 = 8;
                                i6 = 0;
                            }
                        }
                        z10 = false;
                    }
                    if (constraintWidget2.mVerticalResolution == 2 ? false : z10) {
                        boolean z22 = constraintWidget2.mListDimensionBehaviors[i7] == DimensionBehaviour.WRAP_CONTENT && (constraintWidget2 instanceof ConstraintWidgetContainer);
                        if (z22) {
                            i = 0;
                        }
                        boolean z23 = z8 && ((i8 = constraintWidget2.mResolvedDimensionRatioSide) == i7 || i8 == -1);
                        ConstraintWidget constraintWidget8 = constraintWidget2.mParent;
                        SolverVariable createObjectVariable6 = constraintWidget8 != null ? linearSystem2.createObjectVariable(constraintWidget8.mBottom) : null;
                        ConstraintWidget constraintWidget9 = constraintWidget2.mParent;
                        if (constraintWidget9 != null) {
                            solverVariable16 = linearSystem2.createObjectVariable(constraintWidget9.mTop);
                        }
                        if (constraintWidget2.mBaselineDistance > 0 || constraintWidget2.mVisibility == i5) {
                            linearSystem2.addEquality(solverVariable7, solverVariable9, getBaselineDistance(), i5);
                            ConstraintAnchor constraintAnchor = constraintWidget2.mBaseline.mTarget;
                            if (constraintAnchor != null) {
                                linearSystem2.addEquality(solverVariable7, linearSystem2.createObjectVariable(constraintAnchor), i6, i5);
                                if (z7) {
                                    linearSystem2.addGreaterThan(createObjectVariable6, linearSystem2.createObjectVariable(constraintWidget2.mBottom), i6, 5);
                                }
                                z11 = false;
                                solverVariable10 = solverVariable8;
                                SolverVariable solverVariable17 = solverVariable16;
                                solverVariable11 = solverVariable9;
                                applyConstraints(linearSystem, false, z7, z9, constraintWidget2.isTerminalWidget[i7], solverVariable17, createObjectVariable6, constraintWidget2.mListDimensionBehaviors[i7], z22, constraintWidget2.mTop, constraintWidget2.mBottom, constraintWidget2.f36mY, i, constraintWidget2.mMinHeight, constraintWidget2.mMaxDimension[i7], constraintWidget2.mVerticalBiasPercent, z23, z3, z4, z21, i2, i3, constraintWidget2.mMatchConstraintMinHeight, constraintWidget2.mMatchConstraintMaxHeight, constraintWidget2.mMatchConstraintPercentHeight, z11);
                            } else if (constraintWidget2.mVisibility == i5) {
                                linearSystem2.addEquality(solverVariable7, solverVariable9, i6, i5);
                            }
                        }
                        z11 = z19;
                        solverVariable10 = solverVariable8;
                        SolverVariable solverVariable172 = solverVariable16;
                        solverVariable11 = solverVariable9;
                        applyConstraints(linearSystem, false, z7, z9, constraintWidget2.isTerminalWidget[i7], solverVariable172, createObjectVariable6, constraintWidget2.mListDimensionBehaviors[i7], z22, constraintWidget2.mTop, constraintWidget2.mBottom, constraintWidget2.f36mY, i, constraintWidget2.mMinHeight, constraintWidget2.mMaxDimension[i7], constraintWidget2.mVerticalBiasPercent, z23, z3, z4, z21, i2, i3, constraintWidget2.mMatchConstraintMinHeight, constraintWidget2.mMatchConstraintMaxHeight, constraintWidget2.mMatchConstraintPercentHeight, z11);
                    } else {
                        solverVariable10 = solverVariable8;
                        solverVariable11 = solverVariable9;
                    }
                    if (z8) {
                        int i20 = 8;
                        constraintWidget = this;
                        int i21 = constraintWidget.mResolvedDimensionRatioSide;
                        float f2 = constraintWidget.mResolvedDimensionRatio;
                        if (i21 == 1) {
                            linearSystem3 = linearSystem;
                            solverVariable12 = solverVariable10;
                            solverVariable13 = solverVariable11;
                            solverVariable14 = solverVariable4;
                            solverVariable15 = solverVariable5;
                        } else {
                            i20 = 8;
                            linearSystem3 = linearSystem;
                            solverVariable12 = solverVariable4;
                            solverVariable13 = solverVariable5;
                            solverVariable14 = solverVariable10;
                            solverVariable15 = solverVariable11;
                        }
                        linearSystem3.addRatio(solverVariable12, solverVariable13, solverVariable14, solverVariable15, f2, i20);
                    } else {
                        constraintWidget = this;
                    }
                    if (!constraintWidget.mCenter.isConnected()) {
                        return;
                    }
                    linearSystem.addCenterPoint(constraintWidget, constraintWidget.mCenter.getTarget().getOwner(), (float) Math.toRadians(constraintWidget.mCircleConstraintAngle + 90.0f), constraintWidget.mCenter.getMargin());
                    return;
                }
                ConstraintWidget constraintWidget10 = constraintWidget2.mParent;
                SolverVariable createObjectVariable7 = constraintWidget10 != null ? linearSystem.createObjectVariable(constraintWidget10.mRight) : null;
                ConstraintWidget constraintWidget11 = constraintWidget2.mParent;
                z7 = z;
                z9 = z2;
                z8 = z5;
                solverVariable6 = solverVariable;
                solverVariable2 = createObjectVariable4;
                solverVariable3 = createObjectVariable3;
                solverVariable4 = createObjectVariable2;
                solverVariable5 = createObjectVariable;
                applyConstraints(linearSystem, true, z9, z7, constraintWidget2.isTerminalWidget[0], constraintWidget11 != null ? linearSystem.createObjectVariable(constraintWidget11.mLeft) : null, createObjectVariable7, constraintWidget2.mListDimensionBehaviors[0], z18, constraintWidget2.mLeft, constraintWidget2.mRight, constraintWidget2.f35mX, i19, constraintWidget2.mMinWidth, constraintWidget2.mMaxDimension[0], constraintWidget2.mHorizontalBiasPercent, z6, z4, z3, z20, i3, i2, constraintWidget2.mMatchConstraintMinWidth, constraintWidget2.mMatchConstraintMaxWidth, constraintWidget2.mMatchConstraintPercentWidth, z19);
            } else {
                z7 = z;
                z8 = z5;
                solverVariable2 = createObjectVariable4;
                solverVariable3 = createObjectVariable3;
                solverVariable4 = createObjectVariable2;
                solverVariable5 = createObjectVariable;
                z9 = z2;
                solverVariable6 = solverVariable;
            }
            constraintWidget2 = this;
            VerticalWidgetRun verticalWidgetRun22 = constraintWidget2.verticalRun;
            dependencyNode = verticalWidgetRun22.start;
            if (dependencyNode.resolved) {
            }
            linearSystem2 = linearSystem;
            solverVariable7 = solverVariable6;
            solverVariable8 = solverVariable2;
            solverVariable9 = solverVariable3;
            i5 = 8;
            i6 = 0;
            i7 = 1;
            z10 = true;
            if (constraintWidget2.mVerticalResolution == 2 ? false : z10) {
            }
            if (z8) {
            }
            if (!constraintWidget.mCenter.isConnected()) {
            }
        }
        z6 = false;
        if (constraintWidget2.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT) {
        }
        if (!z18) {
        }
        boolean z192 = !constraintWidget2.mCenter.isConnected();
        boolean[] zArr2 = constraintWidget2.mIsInBarrier;
        boolean z202 = zArr2[0];
        boolean z212 = zArr2[1];
        SolverVariable solverVariable162 = null;
        if (constraintWidget2.mHorizontalResolution == 2) {
        }
        constraintWidget2 = this;
        VerticalWidgetRun verticalWidgetRun222 = constraintWidget2.verticalRun;
        dependencyNode = verticalWidgetRun222.start;
        if (dependencyNode.resolved) {
        }
        linearSystem2 = linearSystem;
        solverVariable7 = solverVariable6;
        solverVariable8 = solverVariable2;
        solverVariable9 = solverVariable3;
        i5 = 8;
        i6 = 0;
        i7 = 1;
        z10 = true;
        if (constraintWidget2.mVerticalResolution == 2 ? false : z10) {
        }
        if (z8) {
        }
        if (!constraintWidget.mCenter.isConnected()) {
        }
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x01e0, code lost:
        if (r6.isConnected() != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01b1, code lost:
        if (r6.isConnected() != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e2, code lost:
        r4.reset();
        r6.reset();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        ConstraintAnchor opposite;
        ConstraintAnchor anchor;
        ConstraintAnchor.Type type3;
        ConstraintAnchor anchor2;
        ConstraintAnchor anchor3;
        boolean z;
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.CENTER;
        if (type == type4) {
            ConstraintAnchor.Type type5 = ConstraintAnchor.Type.LEFT;
            if (type2 == type4) {
                ConstraintAnchor anchor4 = getAnchor(type5);
                ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                boolean z2 = true;
                if ((anchor4 == null || !anchor4.isConnected()) && (anchor5 == null || !anchor5.isConnected())) {
                    ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
                    connect(type6, constraintWidget, type6, 0);
                    ConstraintAnchor.Type type7 = ConstraintAnchor.Type.RIGHT;
                    connect(type7, constraintWidget, type7, 0);
                    z = true;
                } else {
                    z = false;
                }
                if ((anchor6 == null || !anchor6.isConnected()) && (anchor7 == null || !anchor7.isConnected())) {
                    ConstraintAnchor.Type type8 = ConstraintAnchor.Type.TOP;
                    connect(type8, constraintWidget, type8, 0);
                    ConstraintAnchor.Type type9 = ConstraintAnchor.Type.BOTTOM;
                    connect(type9, constraintWidget, type9, 0);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    anchor3 = getAnchor(ConstraintAnchor.Type.CENTER);
                    type2 = ConstraintAnchor.Type.CENTER;
                } else if (z) {
                    anchor3 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                    type2 = ConstraintAnchor.Type.CENTER_X;
                } else if (!z2) {
                    return;
                } else {
                    anchor3 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                    type2 = ConstraintAnchor.Type.CENTER_Y;
                }
                anchor2 = constraintWidget.getAnchor(type2);
                anchor3.connect(anchor2, 0);
            }
            if (type2 == type5 || type2 == ConstraintAnchor.Type.RIGHT) {
                connect(ConstraintAnchor.Type.LEFT, constraintWidget, type2, 0);
                connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
            } else if (type2 != ConstraintAnchor.Type.TOP && type2 != ConstraintAnchor.Type.BOTTOM) {
                return;
            } else {
                connect(ConstraintAnchor.Type.TOP, constraintWidget, type2, 0);
                connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
            }
            type3 = ConstraintAnchor.Type.CENTER;
        } else if (type == ConstraintAnchor.Type.CENTER_X && (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor8 = getAnchor(ConstraintAnchor.Type.LEFT);
            anchor2 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor9 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor8.connect(anchor2, 0);
            anchor9.connect(anchor2, 0);
            anchor3 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            anchor3.connect(anchor2, 0);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
            getAnchor(ConstraintAnchor.Type.TOP).connect(anchor10, 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor10, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(anchor10, 0);
            return;
        } else {
            ConstraintAnchor.Type type10 = ConstraintAnchor.Type.CENTER_X;
            if (type == type10 && type2 == type10) {
                getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT), 0);
                getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT), 0);
                type3 = ConstraintAnchor.Type.CENTER_X;
            } else {
                ConstraintAnchor.Type type11 = ConstraintAnchor.Type.CENTER_Y;
                if (type != type11 || type2 != type11) {
                    ConstraintAnchor anchor11 = getAnchor(type);
                    ConstraintAnchor anchor12 = constraintWidget.getAnchor(type2);
                    if (!anchor11.isValidConnection(anchor12)) {
                        return;
                    }
                    if (type == ConstraintAnchor.Type.BASELINE) {
                        ConstraintAnchor anchor13 = getAnchor(ConstraintAnchor.Type.TOP);
                        ConstraintAnchor anchor14 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                        if (anchor13 != null) {
                            anchor13.reset();
                        }
                        if (anchor14 != null) {
                            anchor14.reset();
                        }
                        i = 0;
                    } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                        ConstraintAnchor anchor15 = getAnchor(ConstraintAnchor.Type.BASELINE);
                        if (anchor15 != null) {
                            anchor15.reset();
                        }
                        ConstraintAnchor anchor16 = getAnchor(ConstraintAnchor.Type.CENTER);
                        if (anchor16.getTarget() != anchor12) {
                            anchor16.reset();
                        }
                        opposite = getAnchor(type).getOpposite();
                        anchor = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                    } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                        ConstraintAnchor anchor17 = getAnchor(ConstraintAnchor.Type.CENTER);
                        if (anchor17.getTarget() != anchor12) {
                            anchor17.reset();
                        }
                        opposite = getAnchor(type).getOpposite();
                        anchor = getAnchor(ConstraintAnchor.Type.CENTER_X);
                    }
                    anchor11.connect(anchor12, i);
                    return;
                }
                getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP), 0);
                getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM), 0);
                type3 = ConstraintAnchor.Type.CENTER_Y;
            }
        }
        anchor3 = getAnchor(type3);
        anchor2 = constraintWidget.getAnchor(type2);
        anchor3.connect(anchor2, 0);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = constraintWidget.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = constraintWidget.mResolvedDimensionRatio;
        int[] iArr3 = constraintWidget.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.hasBaseline = constraintWidget.hasBaseline;
        this.inPlaceholder = constraintWidget.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget constraintWidget2 = null;
        this.mParent = this.mParent == null ? null : hashMap.get(constraintWidget.mParent);
        this.mWidth = constraintWidget.mWidth;
        this.mHeight = constraintWidget.mHeight;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
        this.f35mX = constraintWidget.f35mX;
        this.f36mY = constraintWidget.f36mY;
        this.mRelX = constraintWidget.mRelX;
        this.mRelY = constraintWidget.mRelY;
        this.mOffsetX = constraintWidget.mOffsetX;
        this.mOffsetY = constraintWidget.mOffsetY;
        this.mBaselineDistance = constraintWidget.mBaselineDistance;
        this.mMinWidth = constraintWidget.mMinWidth;
        this.mMinHeight = constraintWidget.mMinHeight;
        this.mHorizontalBiasPercent = constraintWidget.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = constraintWidget.mVerticalBiasPercent;
        this.mCompanionWidget = constraintWidget.mCompanionWidget;
        this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
        this.mVisibility = constraintWidget.mVisibility;
        this.mDebugName = constraintWidget.mDebugName;
        this.mType = constraintWidget.mType;
        this.mDistToTop = constraintWidget.mDistToTop;
        this.mDistToLeft = constraintWidget.mDistToLeft;
        this.mDistToRight = constraintWidget.mDistToRight;
        this.mDistToBottom = constraintWidget.mDistToBottom;
        this.mLeftHasCentered = constraintWidget.mLeftHasCentered;
        this.mRightHasCentered = constraintWidget.mRightHasCentered;
        this.mTopHasCentered = constraintWidget.mTopHasCentered;
        this.mBottomHasCentered = constraintWidget.mBottomHasCentered;
        this.mHorizontalWrapVisited = constraintWidget.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = constraintWidget.mVerticalWrapVisited;
        this.mOptimizerMeasurable = constraintWidget.mOptimizerMeasurable;
        this.mGroupsToSolver = constraintWidget.mGroupsToSolver;
        this.mHorizontalChainStyle = constraintWidget.mHorizontalChainStyle;
        this.mVerticalChainStyle = constraintWidget.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = constraintWidget.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = constraintWidget.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget3 = constraintWidget.mHorizontalNextWidget;
        this.mHorizontalNextWidget = constraintWidget3 == null ? null : hashMap.get(constraintWidget3);
        ConstraintWidget constraintWidget4 = constraintWidget.mVerticalNextWidget;
        if (constraintWidget4 != null) {
            constraintWidget2 = hashMap.get(constraintWidget4);
        }
        this.mVerticalNextWidget = constraintWidget2;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (type.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i != 1) {
            return -1.0f;
        }
        return this.mVerticalBiasPercent;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i != 1) {
            return null;
        }
        return getVerticalDimensionBehaviour();
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        if (isInHorizontalChain()) {
            ConstraintWidget constraintWidget = this;
            ConstraintWidget constraintWidget2 = null;
            while (constraintWidget2 == null && constraintWidget != null) {
                ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
                ConstraintWidget owner = target == null ? null : target.getOwner();
                if (owner == getParent()) {
                    return constraintWidget;
                }
                ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
                if (target2 == null || target2.getOwner() == constraintWidget) {
                    constraintWidget = owner;
                } else {
                    constraintWidget2 = constraintWidget;
                }
            }
            return constraintWidget2;
        }
        return null;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int i = 0;
        if (constraintAnchor != null) {
            i = 0 + constraintAnchor.mMargin;
        }
        ConstraintAnchor constraintAnchor2 = this.mRight;
        return constraintAnchor2 != null ? i + constraintAnchor2.mMargin : i;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i != 1) {
            return 0;
        }
        return getHeight();
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public ConstraintWidget getNextChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i != 0) {
            if (i != 1 || (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) == null || constraintAnchor2.mTarget != constraintAnchor) {
                return null;
            }
            return constraintAnchor2.mOwner;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
            return constraintAnchor4.mOwner;
        }
        return null;
    }

    public int getOptimizerWrapHeight() {
        int i;
        int i2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultHeight == 1) {
                i = Math.max(this.mMatchConstraintMinHeight, i2);
            } else {
                i = this.mMatchConstraintMinHeight;
                if (i > 0) {
                    this.mHeight = i;
                } else {
                    i = 0;
                }
            }
            int i3 = this.mMatchConstraintMaxHeight;
            return (i3 <= 0 || i3 >= i) ? i : i3;
        }
        return i2;
    }

    public int getOptimizerWrapWidth() {
        int i;
        int i2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultWidth == 1) {
                i = Math.max(this.mMatchConstraintMinWidth, i2);
            } else {
                i = this.mMatchConstraintMinWidth;
                if (i > 0) {
                    this.mWidth = i;
                } else {
                    i = 0;
                }
            }
            int i3 = this.mMatchConstraintMaxWidth;
            return (i3 <= 0 || i3 >= i) ? i : i3;
        }
        return i2;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i != 0) {
            if (i != 1 || (constraintAnchor2 = (constraintAnchor = this.mTop).mTarget) == null || constraintAnchor2.mTarget != constraintAnchor) {
                return null;
            }
            return constraintAnchor2.mOwner;
        }
        ConstraintAnchor constraintAnchor3 = this.mLeft;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
            return constraintAnchor4.mOwner;
        }
        return null;
    }

    public int getRelativePositioning(int i) {
        if (i == 0) {
            return this.mRelX;
        }
        if (i != 1) {
            return 0;
        }
        return this.mRelY;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getRootX() {
        return this.f35mX + this.mOffsetX;
    }

    public int getRootY() {
        return this.f36mY + this.mOffsetY;
    }

    public WidgetRun getRun(int i) {
        if (i == 0) {
            return this.horizontalRun;
        }
        if (i != 1) {
            return null;
        }
        return this.verticalRun;
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        if (isInVerticalChain()) {
            ConstraintWidget constraintWidget = this;
            ConstraintWidget constraintWidget2 = null;
            while (constraintWidget2 == null && constraintWidget != null) {
                ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
                ConstraintWidget owner = target == null ? null : target.getOwner();
                if (owner == getParent()) {
                    return constraintWidget;
                }
                ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
                if (target2 == null || target2.getOwner() == constraintWidget) {
                    constraintWidget = owner;
                } else {
                    constraintWidget2 = constraintWidget;
                }
            }
            return constraintWidget2;
        }
        return null;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int i = 0;
        if (this.mLeft != null) {
            i = 0 + this.mTop.mMargin;
        }
        return this.mRight != null ? i + this.mBottom.mMargin : i;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.f35mX : ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.f35mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.f36mY : ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.f36mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, true);
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null || constraintAnchor2.mTarget != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.mRight;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
        }
        return true;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null || constraintAnchor2.mTarget != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.mBottom;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
        }
        return true;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.f35mX = 0;
        this.f36mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtuaLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (constraintAnchor != anchor5) {
                if (constraintAnchor == anchor6) {
                    if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                        anchor.reset();
                        anchor2.reset();
                    }
                    this.mHorizontalBiasPercent = 0.5f;
                } else if (constraintAnchor == anchor7) {
                    if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                        anchor3.reset();
                        anchor4.reset();
                    }
                } else if (constraintAnchor == anchor || constraintAnchor == anchor2 ? !(!anchor.isConnected() || anchor.getTarget() != anchor2.getTarget()) : !((constraintAnchor != anchor3 && constraintAnchor != anchor4) || !anchor3.isConnected() || anchor3.getTarget() != anchor4.getTarget())) {
                    anchor5.reset();
                }
                constraintAnchor.reset();
            }
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor.reset();
                anchor2.reset();
            }
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
            this.mVerticalBiasPercent = 0.5f;
            constraintAnchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i = 0; i < size; i++) {
                this.mAnchors.get(i).reset();
            }
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
        this.hasBaseline = i > 0;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mContainerItemSkip = i;
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        if (this.mBaselineDistance > 0) {
            SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
            createObjectVariable5.setName(str + ".baseline");
        }
    }

    public void setDimension(int i, int i2) {
        this.mWidth = i;
        int i3 = this.mMinWidth;
        if (i < i3) {
            this.mWidth = i3;
        }
        this.mHeight = i2;
        int i4 = this.mMinHeight;
        if (i2 < i4) {
            this.mHeight = i4;
        }
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:31:0x0085). Please submit an issue!!! */
    public void setDimensionRatio(String str) {
        float f;
        int i = 0;
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int i2 = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i3 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                i2 = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i2 = 1;
            }
            i3 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(i3);
            if (substring2.length() > 0) {
                f = Float.parseFloat(substring2);
            }
            f = 0.0f;
        } else {
            String substring3 = str.substring(i3, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                float parseFloat = Float.parseFloat(substring3);
                float parseFloat2 = Float.parseFloat(substring4);
                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                    f = i2 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                }
            }
            f = 0.0f;
        }
        i = (f > i ? 1 : (f == i ? 0 : -1));
        if (i <= 0) {
            return;
        }
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i2;
    }

    public void setFrame(int i, int i2, int i3) {
        if (i3 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i3 != 1) {
        } else {
            setVerticalDimension(i, i2);
        }
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.f35mX = i;
        this.f36mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i7 < (i6 = this.mWidth)) {
            i7 = i6;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i8 < (i5 = this.mHeight)) {
            i8 = i5;
        }
        this.mWidth = i7;
        this.mHeight = i8;
        int i9 = this.mMinHeight;
        if (i8 < i9) {
            this.mHeight = i9;
        }
        int i10 = this.mWidth;
        int i11 = this.mMinWidth;
        if (i10 >= i11) {
            return;
        }
        this.mWidth = i11;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        ConstraintAnchor constraintAnchor;
        int ordinal = type.ordinal();
        if (ordinal == 1) {
            constraintAnchor = this.mLeft;
        } else if (ordinal == 2) {
            constraintAnchor = this.mTop;
        } else if (ordinal == 3) {
            constraintAnchor = this.mRight;
        } else if (ordinal != 4) {
            return;
        } else {
            constraintAnchor = this.mBottom;
        }
        constraintAnchor.mGoneMargin = i;
    }

    public void setHasBaseline(boolean z) {
        this.hasBaseline = z;
    }

    public void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public void setHorizontalDimension(int i, int i2) {
        this.f35mX = i;
        int i3 = i2 - i;
        this.mWidth = i3;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.mWidth = i4;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f <= 0.0f || f >= 1.0f || this.mMatchConstraintDefaultWidth != 0) {
            return;
        }
        this.mMatchConstraintDefaultWidth = 2;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setInBarrier(int i, boolean z) {
        this.mIsInBarrier[i] = z;
    }

    public void setInPlaceholder(boolean z) {
        this.inPlaceholder = z;
    }

    public void setInVirtualLayout(boolean z) {
        this.mInVirtuaLayout = z;
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 != 1) {
        } else {
            setHeight(i);
        }
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mMinHeight = i;
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mMinWidth = i;
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setOrigin(int i, int i2) {
        this.f35mX = i;
        this.f36mY = i2;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setRelativePositioning(int i, int i2) {
        if (i2 == 0) {
            this.mRelX = i;
        } else if (i2 != 1) {
        } else {
            this.mRelY = i;
        }
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public void setVerticalDimension(int i, int i2) {
        this.f36mY = i;
        int i3 = i2 - i;
        this.mHeight = i3;
        int i4 = this.mMinHeight;
        if (i3 < i4) {
            this.mHeight = i4;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f <= 0.0f || f >= 1.0f || this.mMatchConstraintDefaultHeight != 0) {
            return;
        }
        this.mMatchConstraintDefaultHeight = 2;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public void setX(int i) {
        this.f35mX = i;
    }

    public void setY(int i) {
        this.f36mY = i;
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mMatchConstraintMinWidth != 0 || this.mMatchConstraintMinHeight <= 0) {
            } else {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(this.mType != null ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("type: "), this.mType, StringUtils.SPACE) : str);
        if (this.mDebugName != null) {
            str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("id: "), this.mDebugName, StringUtils.SPACE);
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.f35mX);
        sb.append(", ");
        sb.append(this.f36mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, this.mHeight, ")");
    }

    public void updateFromRuns(boolean z, boolean z2) {
        int i;
        int i2;
        boolean isResolved = z & this.horizontalRun.isResolved();
        boolean isResolved2 = z2 & this.verticalRun.isResolved();
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        int i3 = horizontalWidgetRun.start.value;
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        int i4 = verticalWidgetRun.start.value;
        int i5 = horizontalWidgetRun.end.value;
        int i6 = verticalWidgetRun.end.value;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i3 = 0;
            i6 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (isResolved) {
            this.f35mX = i3;
        }
        if (isResolved2) {
            this.f36mY = i4;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (isResolved) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i8 < (i2 = this.mWidth)) {
                i8 = i2;
            }
            this.mWidth = i8;
            int i10 = this.mMinWidth;
            if (i8 < i10) {
                this.mWidth = i10;
            }
        }
        if (!isResolved2) {
            return;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i9 < (i = this.mHeight)) {
            i9 = i;
        }
        this.mHeight = i9;
        int i11 = this.mMinHeight;
        if (i9 >= i11) {
            return;
        }
        this.mHeight = i11;
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        DependencyNode dependencyNode = horizontalWidgetRun.start;
        if (dependencyNode.resolved) {
            DependencyNode dependencyNode2 = horizontalWidgetRun.end;
            if (dependencyNode2.resolved) {
                objectVariableValue = dependencyNode.value;
                objectVariableValue3 = dependencyNode2.value;
            }
        }
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        DependencyNode dependencyNode3 = verticalWidgetRun.start;
        if (dependencyNode3.resolved) {
            DependencyNode dependencyNode4 = verticalWidgetRun.end;
            if (dependencyNode4.resolved) {
                objectVariableValue2 = dependencyNode3.value;
                objectVariableValue4 = dependencyNode4.value;
            }
        }
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue4 = 0;
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }
}

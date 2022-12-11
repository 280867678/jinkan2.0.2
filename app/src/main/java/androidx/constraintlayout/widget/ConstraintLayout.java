package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ConstraintLayout extends ViewGroup {
    public static final boolean DEBUG = false;
    public static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    public static final boolean MEASURE = false;
    public static final String TAG = "ConstraintLayout";
    public static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.0.1";
    public ConstraintsChangedListener mConstraintsChangedListener;
    public Metrics mMetrics;
    public SparseArray<View> mChildrenByIds = new SparseArray<>();
    public ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList<>(4);
    public ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    public int mMinWidth = 0;
    public int mMinHeight = 0;
    public int mMaxWidth = Integer.MAX_VALUE;
    public int mMaxHeight = Integer.MAX_VALUE;
    public boolean mDirtyHierarchy = true;
    public int mOptimizationLevel = Optimizer.OPTIMIZATION_STANDARD;
    public ConstraintSet mConstraintSet = null;
    public ConstraintLayoutStates mConstraintLayoutSpec = null;
    public int mConstraintSetId = -1;
    public HashMap<String, Integer> mDesignIds = new HashMap<>();
    public int mLastMeasureWidth = -1;
    public int mLastMeasureHeight = -1;
    public int mLastMeasureWidthSize = -1;
    public int mLastMeasureHeightSize = -1;
    public int mLastMeasureWidthMode = 0;
    public int mLastMeasureHeightMode = 0;
    public SparseArray<ConstraintWidget> mTempMapIdToWidget = new SparseArray<>();
    public Measurer mMeasurer = new Measurer(this);
    public int mOnMeasureWidthMeasureSpec = 0;
    public int mOnMeasureHeightMeasureSpec = 0;

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C01851 {

        /* renamed from: $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour */
        public static final /* synthetic */ int[] f47xdde91696;

        static {
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            f47xdde91696 = iArr;
            try {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f47xdde91696;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f47xdde91696;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                iArr3[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f47xdde91696;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                iArr4[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int END = 7;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public int baselineToBaseline;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String constraintTag;
        public String dimensionRatio;
        public int dimensionRatioSide;
        public float dimensionRatioValue;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endToEnd;
        public int endToStart;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public boolean helped;
        public float horizontalBias;
        public int horizontalChainStyle;
        public boolean horizontalDimensionFixed;
        public float horizontalWeight;
        public boolean isGuideline;
        public boolean isHelper;
        public boolean isInPlaceholder;
        public boolean isVirtualGroup;
        public int leftToLeft;
        public int leftToRight;
        public int matchConstraintDefaultHeight;
        public int matchConstraintDefaultWidth;
        public int matchConstraintMaxHeight;
        public int matchConstraintMaxWidth;
        public int matchConstraintMinHeight;
        public int matchConstraintMinWidth;
        public float matchConstraintPercentHeight;
        public float matchConstraintPercentWidth;
        public boolean needsBaseline;
        public int orientation;
        public int resolveGoneLeftMargin;
        public int resolveGoneRightMargin;
        public int resolvedGuideBegin;
        public int resolvedGuideEnd;
        public float resolvedGuidePercent;
        public float resolvedHorizontalBias;
        public int resolvedLeftToLeft;
        public int resolvedLeftToRight;
        public int resolvedRightToLeft;
        public int resolvedRightToRight;
        public int rightToLeft;
        public int rightToRight;
        public int startToEnd;
        public int startToStart;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        public boolean verticalDimensionFixed;
        public float verticalWeight;
        public ConstraintWidget widget;

        /* loaded from: classes3.dex */
        public static class Table {
            public static final int ANDROID_ORIENTATION = 1;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
            public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
            public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
            public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
            public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
            public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
            public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
            public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
            public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
            public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
            public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
            public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
            public static final int LAYOUT_CONSTRAINT_TAG = 51;
            public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int UNUSED = 0;
            public static final SparseIntArray map;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                map = sparseIntArray;
                sparseIntArray.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                map.append(C0186R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                map.append(C0186R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i;
            float parseFloat;
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0186R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = Table.map.get(index);
                switch (i3) {
                    case 1:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.circleConstraint);
                        this.circleConstraint = resourceId;
                        if (resourceId == -1) {
                            this.circleConstraint = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                        break;
                    case 4:
                        float f = obtainStyledAttributes.getFloat(index, this.circleAngle) % 360.0f;
                        this.circleAngle = f;
                        if (f < 0.0f) {
                            this.circleAngle = (360.0f - f) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 6:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 7:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.leftToLeft);
                        this.leftToLeft = resourceId2;
                        if (resourceId2 == -1) {
                            this.leftToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.leftToRight);
                        this.leftToRight = resourceId3;
                        if (resourceId3 == -1) {
                            this.leftToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.rightToLeft);
                        this.rightToLeft = resourceId4;
                        if (resourceId4 == -1) {
                            this.rightToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.rightToRight);
                        this.rightToRight = resourceId5;
                        if (resourceId5 == -1) {
                            this.rightToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.topToTop);
                        this.topToTop = resourceId6;
                        if (resourceId6 == -1) {
                            this.topToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.topToBottom);
                        this.topToBottom = resourceId7;
                        if (resourceId7 == -1) {
                            this.topToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.bottomToTop);
                        this.bottomToTop = resourceId8;
                        if (resourceId8 == -1) {
                            this.bottomToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.bottomToBottom);
                        this.bottomToBottom = resourceId9;
                        if (resourceId9 == -1) {
                            this.bottomToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.baselineToBaseline);
                        this.baselineToBaseline = resourceId10;
                        if (resourceId10 == -1) {
                            this.baselineToBaseline = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.startToEnd);
                        this.startToEnd = resourceId11;
                        if (resourceId11 == -1) {
                            this.startToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.startToStart);
                        this.startToStart = resourceId12;
                        if (resourceId12 == -1) {
                            this.startToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.endToStart);
                        this.endToStart = resourceId13;
                        if (resourceId13 == -1) {
                            this.endToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.endToEnd);
                        this.endToEnd = resourceId14;
                        if (resourceId14 == -1) {
                            this.endToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 22:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 23:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 24:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 25:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 26:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 27:
                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                        break;
                    case 28:
                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                        break;
                    case 29:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 30:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 31:
                        this.matchConstraintDefaultWidth = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 32:
                        this.matchConstraintDefaultHeight = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 33:
                        try {
                            this.matchConstraintMinWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinWidth);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinWidth) == -2) {
                                this.matchConstraintMinWidth = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.matchConstraintMaxWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxWidth);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxWidth) == -2) {
                                this.matchConstraintMaxWidth = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.matchConstraintPercentWidth = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentWidth));
                        this.matchConstraintDefaultWidth = 2;
                        break;
                    case 36:
                        try {
                            this.matchConstraintMinHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinHeight);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinHeight) == -2) {
                                this.matchConstraintMinHeight = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.matchConstraintMaxHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxHeight);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxHeight) == -2) {
                                this.matchConstraintMaxHeight = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.matchConstraintPercentHeight = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentHeight));
                        this.matchConstraintDefaultHeight = 2;
                        break;
                    default:
                        switch (i3) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.dimensionRatio = string;
                                this.dimensionRatioValue = Float.NaN;
                                this.dimensionRatioSide = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int indexOf = this.dimensionRatio.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i = 0;
                                    } else {
                                        String substring = this.dimensionRatio.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                                            this.dimensionRatioSide = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.dimensionRatioSide = 1;
                                        }
                                        i = indexOf + 1;
                                    }
                                    int indexOf2 = this.dimensionRatio.indexOf(58);
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.dimensionRatio.substring(i, indexOf2);
                                        String substring3 = this.dimensionRatio.substring(indexOf2 + 1);
                                        if (substring2.length() > 0 && substring3.length() > 0) {
                                            try {
                                                float parseFloat2 = Float.parseFloat(substring2);
                                                float parseFloat3 = Float.parseFloat(substring3);
                                                parseFloat = (parseFloat2 > 0.0f && parseFloat3 > 0.0f) ? this.dimensionRatioSide == 1 ? Math.abs(parseFloat3 / parseFloat2) : Math.abs(parseFloat2 / parseFloat3) : parseFloat;
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    } else {
                                        String substring4 = this.dimensionRatio.substring(i);
                                        if (substring4.length() <= 0) {
                                            break;
                                        } else {
                                            parseFloat = Float.parseFloat(substring4);
                                        }
                                    }
                                    this.dimensionRatioValue = parseFloat;
                                    break;
                                } else {
                                    continue;
                                }
                                break;
                            case 45:
                                this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                                continue;
                            case 46:
                                this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                                continue;
                            case 47:
                                this.horizontalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.verticalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                                continue;
                            case 50:
                                this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                                continue;
                            case 51:
                                this.constraintTag = obtainStyledAttributes.getString(index);
                                continue;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            this.guideBegin = layoutParams.guideBegin;
            this.guideEnd = layoutParams.guideEnd;
            this.guidePercent = layoutParams.guidePercent;
            this.leftToLeft = layoutParams.leftToLeft;
            this.leftToRight = layoutParams.leftToRight;
            this.rightToLeft = layoutParams.rightToLeft;
            this.rightToRight = layoutParams.rightToRight;
            this.topToTop = layoutParams.topToTop;
            this.topToBottom = layoutParams.topToBottom;
            this.bottomToTop = layoutParams.bottomToTop;
            this.bottomToBottom = layoutParams.bottomToBottom;
            this.baselineToBaseline = layoutParams.baselineToBaseline;
            this.circleConstraint = layoutParams.circleConstraint;
            this.circleRadius = layoutParams.circleRadius;
            this.circleAngle = layoutParams.circleAngle;
            this.startToEnd = layoutParams.startToEnd;
            this.startToStart = layoutParams.startToStart;
            this.endToStart = layoutParams.endToStart;
            this.endToEnd = layoutParams.endToEnd;
            this.goneLeftMargin = layoutParams.goneLeftMargin;
            this.goneTopMargin = layoutParams.goneTopMargin;
            this.goneRightMargin = layoutParams.goneRightMargin;
            this.goneBottomMargin = layoutParams.goneBottomMargin;
            this.goneStartMargin = layoutParams.goneStartMargin;
            this.goneEndMargin = layoutParams.goneEndMargin;
            this.horizontalBias = layoutParams.horizontalBias;
            this.verticalBias = layoutParams.verticalBias;
            this.dimensionRatio = layoutParams.dimensionRatio;
            this.dimensionRatioValue = layoutParams.dimensionRatioValue;
            this.dimensionRatioSide = layoutParams.dimensionRatioSide;
            this.horizontalWeight = layoutParams.horizontalWeight;
            this.verticalWeight = layoutParams.verticalWeight;
            this.horizontalChainStyle = layoutParams.horizontalChainStyle;
            this.verticalChainStyle = layoutParams.verticalChainStyle;
            this.constrainedWidth = layoutParams.constrainedWidth;
            this.constrainedHeight = layoutParams.constrainedHeight;
            this.matchConstraintDefaultWidth = layoutParams.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = layoutParams.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = layoutParams.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = layoutParams.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = layoutParams.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = layoutParams.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = layoutParams.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = layoutParams.matchConstraintPercentHeight;
            this.editorAbsoluteX = layoutParams.editorAbsoluteX;
            this.editorAbsoluteY = layoutParams.editorAbsoluteY;
            this.orientation = layoutParams.orientation;
            this.horizontalDimensionFixed = layoutParams.horizontalDimensionFixed;
            this.verticalDimensionFixed = layoutParams.verticalDimensionFixed;
            this.needsBaseline = layoutParams.needsBaseline;
            this.isGuideline = layoutParams.isGuideline;
            this.resolvedLeftToLeft = layoutParams.resolvedLeftToLeft;
            this.resolvedLeftToRight = layoutParams.resolvedLeftToRight;
            this.resolvedRightToLeft = layoutParams.resolvedRightToLeft;
            this.resolvedRightToRight = layoutParams.resolvedRightToRight;
            this.resolveGoneLeftMargin = layoutParams.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = layoutParams.resolveGoneRightMargin;
            this.resolvedHorizontalBias = layoutParams.resolvedHorizontalBias;
            this.constraintTag = layoutParams.constraintTag;
            this.widget = layoutParams.widget;
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }

        public ConstraintWidget getConstraintWidget() {
            return this.widget;
        }

        public void reset() {
            ConstraintWidget constraintWidget = this.widget;
            if (constraintWidget != null) {
                constraintWidget.reset();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:51:0x00d6, code lost:
            if (r1 > 0) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00d8, code lost:
            ((android.view.ViewGroup.MarginLayoutParams) r6).rightMargin = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x00e5, code lost:
            if (r1 > 0) goto L52;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00f7  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void resolveLayoutDirection(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            float f;
            int i7 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i8 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i);
            boolean z = false;
            boolean z2 = 1 == getLayoutDirection();
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolveGoneLeftMargin = this.goneLeftMargin;
            this.resolveGoneRightMargin = this.goneRightMargin;
            this.resolvedHorizontalBias = this.horizontalBias;
            this.resolvedGuideBegin = this.guideBegin;
            this.resolvedGuideEnd = this.guideEnd;
            this.resolvedGuidePercent = this.guidePercent;
            if (z2) {
                int i9 = this.startToEnd;
                if (i9 != -1) {
                    this.resolvedRightToLeft = i9;
                } else {
                    int i10 = this.startToStart;
                    if (i10 != -1) {
                        this.resolvedRightToRight = i10;
                    }
                    i3 = this.endToStart;
                    if (i3 != -1) {
                        this.resolvedLeftToRight = i3;
                        z = true;
                    }
                    i4 = this.endToEnd;
                    if (i4 != -1) {
                        this.resolvedLeftToLeft = i4;
                        z = true;
                    }
                    i5 = this.goneStartMargin;
                    if (i5 != -1) {
                        this.resolveGoneRightMargin = i5;
                    }
                    i6 = this.goneEndMargin;
                    if (i6 != -1) {
                        this.resolveGoneLeftMargin = i6;
                    }
                    if (z) {
                        this.resolvedHorizontalBias = 1.0f - this.horizontalBias;
                    }
                    if (this.isGuideline && this.orientation == 1) {
                        f = this.guidePercent;
                        if (f == -1.0f) {
                            this.resolvedGuidePercent = 1.0f - f;
                            this.resolvedGuideBegin = -1;
                            this.resolvedGuideEnd = -1;
                        } else {
                            int i11 = this.guideBegin;
                            if (i11 != -1) {
                                this.resolvedGuideEnd = i11;
                                this.resolvedGuideBegin = -1;
                            } else {
                                int i12 = this.guideEnd;
                                if (i12 != -1) {
                                    this.resolvedGuideBegin = i12;
                                    this.resolvedGuideEnd = -1;
                                }
                            }
                            this.resolvedGuidePercent = -1.0f;
                        }
                    }
                }
                z = true;
                i3 = this.endToStart;
                if (i3 != -1) {
                }
                i4 = this.endToEnd;
                if (i4 != -1) {
                }
                i5 = this.goneStartMargin;
                if (i5 != -1) {
                }
                i6 = this.goneEndMargin;
                if (i6 != -1) {
                }
                if (z) {
                }
                if (this.isGuideline) {
                    f = this.guidePercent;
                    if (f == -1.0f) {
                    }
                }
            } else {
                int i13 = this.startToEnd;
                if (i13 != -1) {
                    this.resolvedLeftToRight = i13;
                }
                int i14 = this.startToStart;
                if (i14 != -1) {
                    this.resolvedLeftToLeft = i14;
                }
                int i15 = this.endToStart;
                if (i15 != -1) {
                    this.resolvedRightToLeft = i15;
                }
                int i16 = this.endToEnd;
                if (i16 != -1) {
                    this.resolvedRightToRight = i16;
                }
                int i17 = this.goneStartMargin;
                if (i17 != -1) {
                    this.resolveGoneLeftMargin = i17;
                }
                int i18 = this.goneEndMargin;
                if (i18 != -1) {
                    this.resolveGoneRightMargin = i18;
                }
            }
            if (this.endToStart == -1 && this.endToEnd == -1 && this.startToStart == -1 && this.startToEnd == -1) {
                int i19 = this.rightToLeft;
                if (i19 == -1) {
                    int i20 = this.rightToRight;
                    if (i20 != -1) {
                        this.resolvedRightToRight = i20;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0) {
                        }
                    }
                    i2 = this.leftToLeft;
                    if (i2 == -1) {
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i7;
                }
                this.resolvedRightToLeft = i19;
                if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0) {
                }
                i2 = this.leftToLeft;
                if (i2 == -1) {
                    this.resolvedLeftToLeft = i2;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i7 <= 0) {
                        return;
                    }
                } else {
                    int i21 = this.leftToRight;
                    if (i21 == -1) {
                        return;
                    }
                    this.resolvedLeftToRight = i21;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i7 <= 0) {
                        return;
                    }
                }
                ((ViewGroup.MarginLayoutParams) this).leftMargin = i7;
            }
        }

        public void setWidgetDebugName(String str) {
            this.widget.setDebugName(str);
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (((ViewGroup.MarginLayoutParams) this).width == -2 && this.constrainedWidth) {
                this.horizontalDimensionFixed = false;
                if (this.matchConstraintDefaultWidth == 0) {
                    this.matchConstraintDefaultWidth = 1;
                }
            }
            if (((ViewGroup.MarginLayoutParams) this).height == -2 && this.constrainedHeight) {
                this.verticalDimensionFixed = false;
                if (this.matchConstraintDefaultHeight == 0) {
                    this.matchConstraintDefaultHeight = 1;
                }
            }
            int i = ((ViewGroup.MarginLayoutParams) this).width;
            if (i == 0 || i == -1) {
                this.horizontalDimensionFixed = false;
                if (((ViewGroup.MarginLayoutParams) this).width == 0 && this.matchConstraintDefaultWidth == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.constrainedWidth = true;
                }
            }
            int i2 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i2 == 0 || i2 == -1) {
                this.verticalDimensionFixed = false;
                if (((ViewGroup.MarginLayoutParams) this).height == 0 && this.matchConstraintDefaultHeight == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent == -1.0f && this.guideBegin == -1 && this.guideEnd == -1) {
                return;
            }
            this.isGuideline = true;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (!(this.widget instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
                this.widget = new androidx.constraintlayout.solver.widgets.Guideline();
            }
            ((androidx.constraintlayout.solver.widgets.Guideline) this.widget).setOrientation(this.orientation);
        }
    }

    /* loaded from: classes3.dex */
    public class Measurer implements BasicMeasure.Measurer {
        public ConstraintLayout layout;
        public int layoutHeightSpec;
        public int layoutWidthSpec;
        public int paddingBottom;
        public int paddingHeight;
        public int paddingTop;
        public int paddingWidth;

        public Measurer(ConstraintLayout constraintLayout) {
            this.layout = constraintLayout;
        }

        public void captureLayoutInfos(int i, int i2, int i3, int i4, int i5, int i6) {
            this.paddingTop = i3;
            this.paddingBottom = i4;
            this.paddingWidth = i5;
            this.paddingHeight = i6;
            this.layoutWidthSpec = i;
            this.layoutHeightSpec = i2;
        }

        @Override // androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer
        public final void didMeasures() {
            int childCount = this.layout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.layout.getChildAt(i);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).updatePostMeasure(this.layout);
                }
            }
            int size = this.layout.mConstraintHelpers.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    ((ConstraintHelper) this.layout.mConstraintHelpers.get(i2)).updatePostMeasure(this.layout);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x01f3  */
        /* JADX WARN: Removed duplicated region for block: B:103:0x01fb A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0213 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:111:0x021e  */
        /* JADX WARN: Removed duplicated region for block: B:113:0x0224  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x0208 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:118:0x01ee  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x01dc  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x01ca  */
        /* JADX WARN: Removed duplicated region for block: B:121:0x01b4  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x0137  */
        /* JADX WARN: Removed duplicated region for block: B:128:0x0130  */
        /* JADX WARN: Removed duplicated region for block: B:153:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x013c  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0148  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0153  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0171 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x023b  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0242  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0250  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0255  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0252  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x023d  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x018a  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01a9  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01c0  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x01d7  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x01e1  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x01e9  */
        @Override // androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer
        @SuppressLint({"WrongCall"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void measure(ConstraintWidget constraintWidget, BasicMeasure.Measure measure) {
            int i;
            boolean z;
            int ordinal;
            int makeMeasureSpec;
            boolean z2;
            boolean z3;
            boolean z4;
            int measuredWidth;
            int measuredHeight;
            int baseline;
            int i2;
            int max;
            int i3;
            int max2;
            int i4;
            int measuredWidth2;
            int measuredHeight2;
            int i5;
            boolean z5;
            int childMeasureSpec;
            int makeMeasureSpec2;
            if (constraintWidget == null) {
                return;
            }
            if (constraintWidget.getVisibility() == 8 && !constraintWidget.isInPlaceholder()) {
                measure.measuredWidth = 0;
                measure.measuredHeight = 0;
                measure.measuredBaseline = 0;
                return;
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = measure.verticalBehavior;
            int i6 = measure.horizontalDimension;
            int i7 = measure.verticalDimension;
            int i8 = this.paddingTop + this.paddingBottom;
            int i9 = this.paddingWidth;
            View view = (View) constraintWidget.getCompanionWidget();
            int ordinal2 = dimensionBehaviour.ordinal();
            if (ordinal2 != 0) {
                if (ordinal2 == 1) {
                    i = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i9, -2);
                    constraintWidget.wrapMeasure[2] = -2;
                } else if (ordinal2 == 2) {
                    i = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i9, -2);
                    boolean z6 = constraintWidget.mMatchConstraintDefaultWidth == 1;
                    int[] iArr = constraintWidget.wrapMeasure;
                    iArr[2] = 0;
                    if (measure.useCurrentDimensions) {
                        boolean z7 = !(!z6 || iArr[3] == 0 || iArr[0] == constraintWidget.getWidth()) || (view instanceof Placeholder);
                        if (!z6 || z7) {
                            i = View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824);
                        }
                    }
                } else if (ordinal2 != 3) {
                    i = 0;
                } else {
                    i = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, constraintWidget.getHorizontalMargin() + i9, -1);
                    constraintWidget.wrapMeasure[2] = -1;
                }
                z = true;
                ordinal = dimensionBehaviour2.ordinal();
                if (ordinal == 0) {
                    if (ordinal != 1) {
                        if (ordinal == 2) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i8, -2);
                            boolean z8 = constraintWidget.mMatchConstraintDefaultHeight == 1;
                            int[] iArr2 = constraintWidget.wrapMeasure;
                            iArr2[3] = 0;
                            if (measure.useCurrentDimensions) {
                                boolean z9 = !(!z8 || iArr2[2] == 0 || iArr2[1] == constraintWidget.getHeight()) || (view instanceof Placeholder);
                                if (!z8 || z9) {
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
                                }
                            }
                        } else if (ordinal != 3) {
                            z2 = false;
                            makeMeasureSpec = 0;
                            boolean z10 = dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                            boolean z11 = dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                            boolean z12 = dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED;
                            boolean z13 = dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED;
                            z3 = !z10 && constraintWidget.mDimensionRatio > 0.0f;
                            z4 = !z11 && constraintWidget.mDimensionRatio > 0.0f;
                            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                            if (!measure.useCurrentDimensions || !z10 || constraintWidget.mMatchConstraintDefaultWidth != 0 || !z11 || constraintWidget.mMatchConstraintDefaultHeight != 0) {
                                if ((view instanceof VirtualLayout) || !(constraintWidget instanceof androidx.constraintlayout.solver.widgets.VirtualLayout)) {
                                    view.measure(i, makeMeasureSpec);
                                } else {
                                    ((VirtualLayout) view).onMeasure((androidx.constraintlayout.solver.widgets.VirtualLayout) constraintWidget, i, makeMeasureSpec);
                                }
                                measuredWidth = view.getMeasuredWidth();
                                measuredHeight = view.getMeasuredHeight();
                                baseline = view.getBaseline();
                                if (!z) {
                                    int[] iArr3 = constraintWidget.wrapMeasure;
                                    i2 = 0;
                                    iArr3[0] = measuredWidth;
                                    iArr3[2] = measuredHeight;
                                } else {
                                    i2 = 0;
                                    int[] iArr4 = constraintWidget.wrapMeasure;
                                    iArr4[0] = 0;
                                    iArr4[2] = 0;
                                }
                                if (!z2) {
                                    int[] iArr5 = constraintWidget.wrapMeasure;
                                    iArr5[1] = measuredHeight;
                                    iArr5[3] = measuredWidth;
                                } else {
                                    int[] iArr6 = constraintWidget.wrapMeasure;
                                    iArr6[1] = i2;
                                    iArr6[3] = i2;
                                }
                                int i10 = constraintWidget.mMatchConstraintMinWidth;
                                max = i10 <= 0 ? Math.max(i10, measuredWidth) : measuredWidth;
                                i3 = constraintWidget.mMatchConstraintMaxWidth;
                                if (i3 > 0) {
                                    max = Math.min(i3, max);
                                }
                                int i11 = constraintWidget.mMatchConstraintMinHeight;
                                max2 = i11 <= 0 ? Math.max(i11, measuredHeight) : measuredHeight;
                                i4 = constraintWidget.mMatchConstraintMaxHeight;
                                if (i4 > 0) {
                                    max2 = Math.min(i4, max2);
                                }
                                if (!z3 && z12) {
                                    max = (int) ((max2 * constraintWidget.mDimensionRatio) + 0.5f);
                                } else if (z4 && z13) {
                                    max2 = (int) ((max / constraintWidget.mDimensionRatio) + 0.5f);
                                }
                                if (measuredWidth == max || measuredHeight != max2) {
                                    if (measuredWidth != max) {
                                        i = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
                                    }
                                    if (measuredHeight != max2) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max2, 1073741824);
                                    }
                                    view.measure(i, makeMeasureSpec);
                                    measuredWidth2 = view.getMeasuredWidth();
                                    measuredHeight2 = view.getMeasuredHeight();
                                    baseline = view.getBaseline();
                                } else {
                                    measuredWidth2 = max;
                                    measuredHeight2 = max2;
                                }
                                i5 = -1;
                            } else {
                                measuredWidth2 = 0;
                                measuredHeight2 = 0;
                                i5 = -1;
                                baseline = 0;
                            }
                            boolean z14 = baseline == i5;
                            measure.measuredNeedsSolverPass = measuredWidth2 == measure.horizontalDimension || measuredHeight2 != measure.verticalDimension;
                            z5 = !layoutParams.needsBaseline ? true : z14;
                            if (z5 && baseline != -1 && constraintWidget.getBaselineDistance() != baseline) {
                                measure.measuredNeedsSolverPass = true;
                            }
                            measure.measuredWidth = measuredWidth2;
                            measure.measuredHeight = measuredHeight2;
                            measure.measuredHasBaseline = z5;
                            measure.measuredBaseline = baseline;
                        } else {
                            makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, constraintWidget.getVerticalMargin() + i8, -1);
                            constraintWidget.wrapMeasure[3] = -1;
                        }
                        makeMeasureSpec = makeMeasureSpec2;
                    } else {
                        childMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i8, -2);
                        constraintWidget.wrapMeasure[3] = -2;
                    }
                    makeMeasureSpec = childMeasureSpec;
                    z2 = true;
                    if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    }
                    if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    }
                    if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                    }
                    if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                    }
                    if (!z10) {
                    }
                    if (!z11) {
                    }
                    LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                    if (!measure.useCurrentDimensions) {
                    }
                    if (view instanceof VirtualLayout) {
                    }
                    view.measure(i, makeMeasureSpec);
                    measuredWidth = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    if (!z) {
                    }
                    if (!z2) {
                    }
                    int i102 = constraintWidget.mMatchConstraintMinWidth;
                    if (i102 <= 0) {
                    }
                    i3 = constraintWidget.mMatchConstraintMaxWidth;
                    if (i3 > 0) {
                    }
                    int i112 = constraintWidget.mMatchConstraintMinHeight;
                    if (i112 <= 0) {
                    }
                    i4 = constraintWidget.mMatchConstraintMaxHeight;
                    if (i4 > 0) {
                    }
                    if (!z3) {
                    }
                    if (z4) {
                        max2 = (int) ((max / constraintWidget.mDimensionRatio) + 0.5f);
                    }
                    if (measuredWidth == max) {
                    }
                    if (measuredWidth != max) {
                    }
                    if (measuredHeight != max2) {
                    }
                    view.measure(i, makeMeasureSpec);
                    measuredWidth2 = view.getMeasuredWidth();
                    measuredHeight2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    i5 = -1;
                    if (baseline == i5) {
                    }
                    measure.measuredNeedsSolverPass = measuredWidth2 == measure.horizontalDimension || measuredHeight2 != measure.verticalDimension;
                    if (!layoutParams2.needsBaseline) {
                    }
                    if (z5) {
                        measure.measuredNeedsSolverPass = true;
                    }
                    measure.measuredWidth = measuredWidth2;
                    measure.measuredHeight = measuredHeight2;
                    measure.measuredHasBaseline = z5;
                    measure.measuredBaseline = baseline;
                }
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                constraintWidget.wrapMeasure[3] = i7;
                z2 = false;
                if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                }
                if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                }
                if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                }
                if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                }
                if (!z10) {
                }
                if (!z11) {
                }
                LayoutParams layoutParams22 = (LayoutParams) view.getLayoutParams();
                if (!measure.useCurrentDimensions) {
                }
                if (view instanceof VirtualLayout) {
                }
                view.measure(i, makeMeasureSpec);
                measuredWidth = view.getMeasuredWidth();
                measuredHeight = view.getMeasuredHeight();
                baseline = view.getBaseline();
                if (!z) {
                }
                if (!z2) {
                }
                int i1022 = constraintWidget.mMatchConstraintMinWidth;
                if (i1022 <= 0) {
                }
                i3 = constraintWidget.mMatchConstraintMaxWidth;
                if (i3 > 0) {
                }
                int i1122 = constraintWidget.mMatchConstraintMinHeight;
                if (i1122 <= 0) {
                }
                i4 = constraintWidget.mMatchConstraintMaxHeight;
                if (i4 > 0) {
                }
                if (!z3) {
                }
                if (z4) {
                }
                if (measuredWidth == max) {
                }
                if (measuredWidth != max) {
                }
                if (measuredHeight != max2) {
                }
                view.measure(i, makeMeasureSpec);
                measuredWidth2 = view.getMeasuredWidth();
                measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                i5 = -1;
                if (baseline == i5) {
                }
                measure.measuredNeedsSolverPass = measuredWidth2 == measure.horizontalDimension || measuredHeight2 != measure.verticalDimension;
                if (!layoutParams22.needsBaseline) {
                }
                if (z5) {
                }
                measure.measuredWidth = measuredWidth2;
                measure.measuredHeight = measuredHeight2;
                measure.measuredHasBaseline = z5;
                measure.measuredBaseline = baseline;
            }
            int makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
            constraintWidget.wrapMeasure[2] = i6;
            i = makeMeasureSpec3;
            z = false;
            ordinal = dimensionBehaviour2.ordinal();
            if (ordinal == 0) {
            }
            z2 = false;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            }
            if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            }
            if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            }
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            }
            if (!z10) {
            }
            if (!z11) {
            }
            LayoutParams layoutParams222 = (LayoutParams) view.getLayoutParams();
            if (!measure.useCurrentDimensions) {
            }
            if (view instanceof VirtualLayout) {
            }
            view.measure(i, makeMeasureSpec);
            measuredWidth = view.getMeasuredWidth();
            measuredHeight = view.getMeasuredHeight();
            baseline = view.getBaseline();
            if (!z) {
            }
            if (!z2) {
            }
            int i10222 = constraintWidget.mMatchConstraintMinWidth;
            if (i10222 <= 0) {
            }
            i3 = constraintWidget.mMatchConstraintMaxWidth;
            if (i3 > 0) {
            }
            int i11222 = constraintWidget.mMatchConstraintMinHeight;
            if (i11222 <= 0) {
            }
            i4 = constraintWidget.mMatchConstraintMaxHeight;
            if (i4 > 0) {
            }
            if (!z3) {
            }
            if (z4) {
            }
            if (measuredWidth == max) {
            }
            if (measuredWidth != max) {
            }
            if (measuredHeight != max2) {
            }
            view.measure(i, makeMeasureSpec);
            measuredWidth2 = view.getMeasuredWidth();
            measuredHeight2 = view.getMeasuredHeight();
            baseline = view.getBaseline();
            i5 = -1;
            if (baseline == i5) {
            }
            measure.measuredNeedsSolverPass = measuredWidth2 == measure.horizontalDimension || measuredHeight2 != measure.verticalDimension;
            if (!layoutParams222.needsBaseline) {
            }
            if (z5) {
            }
            measure.measuredWidth = measuredWidth2;
            measure.measuredHeight = measuredHeight2;
            measure.measuredHasBaseline = z5;
            measure.measuredBaseline = baseline;
        }
    }

    public ConstraintLayout(@NonNull Context context) {
        super(context);
        init(null, 0, 0);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet, i, i2);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return max2 > 0 ? max2 : max;
    }

    private final ConstraintWidget getTargetWidget(int i) {
        if (i == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i);
        if (view == null && (view = findViewById(i)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view != null) {
            return ((LayoutParams) view.getLayoutParams()).widget;
        }
        return null;
    }

    private void init(AttributeSet attributeSet, int i, int i2) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mLayoutWidget.setMeasurer(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0186R.styleable.ConstraintLayout_Layout, i, i2);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == C0186R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == C0186R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == C0186R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == C0186R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == C0186R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == C0186R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == C0186R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.load(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void setChildrenConstraints() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ConstraintWidget viewWidget = getViewWidget(getChildAt(i));
            if (viewWidget != null) {
                viewWidget.reset();
            }
        }
        if (isInEditMode) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).setDebugName(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.mConstraintSet;
        if (constraintSet != null) {
            constraintSet.applyToInternal(this, true);
        }
        this.mLayoutWidget.removeAllChildren();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i4 = 0; i4 < size; i4++) {
                this.mConstraintHelpers.get(i4).updatePreLayout(this);
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt3 = getChildAt(i5);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).updatePreLayout(this);
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt4 = getChildAt(i6);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt5 = getChildAt(i7);
            ConstraintWidget viewWidget2 = getViewWidget(childAt5);
            if (viewWidget2 != null) {
                LayoutParams layoutParams = (LayoutParams) childAt5.getLayoutParams();
                this.mLayoutWidget.add(viewWidget2);
                applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, layoutParams, this.mTempMapIdToWidget);
            }
        }
    }

    private boolean updateHierarchy() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            setChildrenConstraints();
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void applyConstraintsFromLayoutParams(boolean z, View view, ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        float f;
        ConstraintWidget constraintWidget2;
        ConstraintAnchor.Type type;
        ConstraintAnchor.Type type2;
        int i;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintAnchor.Type type3;
        int i2;
        ConstraintWidget constraintWidget5;
        ConstraintAnchor.Type type4;
        int i3;
        ConstraintWidget constraintWidget6;
        ConstraintAnchor.Type type5;
        ConstraintAnchor.Type type6;
        int i4;
        int i5;
        ConstraintWidget constraintWidget7;
        int i6;
        ConstraintWidget constraintWidget8;
        ConstraintAnchor.Type type7;
        int i7;
        int i8;
        ConstraintWidget constraintWidget9;
        ConstraintAnchor.Type type8;
        int i9;
        float f2;
        float f3;
        layoutParams.validate();
        layoutParams.helped = false;
        constraintWidget.setVisibility(view.getVisibility());
        if (layoutParams.isInPlaceholder) {
            constraintWidget.setInPlaceholder(true);
            constraintWidget.setVisibility(8);
        }
        constraintWidget.setCompanionWidget(view);
        if (view instanceof ConstraintHelper) {
            ((ConstraintHelper) view).resolveRtl(constraintWidget, this.mLayoutWidget.isRtl());
        }
        if (layoutParams.isGuideline) {
            androidx.constraintlayout.solver.widgets.Guideline guideline = (androidx.constraintlayout.solver.widgets.Guideline) constraintWidget;
            int i10 = layoutParams.resolvedGuideBegin;
            int i11 = layoutParams.resolvedGuideEnd;
            float f4 = layoutParams.resolvedGuidePercent;
            if (f4 != -1.0f) {
                guideline.setGuidePercent(f4);
                return;
            } else if (i10 != -1) {
                guideline.setGuideBegin(i10);
                return;
            } else if (i11 == -1) {
                return;
            } else {
                guideline.setGuideEnd(i11);
                return;
            }
        }
        int i12 = layoutParams.resolvedLeftToLeft;
        int i13 = layoutParams.resolvedLeftToRight;
        int i14 = layoutParams.resolvedRightToLeft;
        int i15 = layoutParams.resolvedRightToRight;
        int i16 = layoutParams.resolveGoneLeftMargin;
        int i17 = layoutParams.resolveGoneRightMargin;
        float f5 = layoutParams.resolvedHorizontalBias;
        int i18 = layoutParams.circleConstraint;
        if (i18 != -1) {
            ConstraintWidget constraintWidget10 = sparseArray.get(i18);
            if (constraintWidget10 != null) {
                constraintWidget.connectCircularConstraint(constraintWidget10, layoutParams.circleAngle, layoutParams.circleRadius);
            }
        } else if (i12 != -1) {
            constraintWidget2 = sparseArray.get(i12);
            if (constraintWidget2 != null) {
                type2 = ConstraintAnchor.Type.LEFT;
                constraintWidget3 = constraintWidget;
                type = type2;
                f = f5;
                i = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                constraintWidget3.immediateConnect(type, constraintWidget2, type2, i, i16);
                if (i14 != -1) {
                    constraintWidget4 = sparseArray.get(i14);
                    if (constraintWidget4 != null) {
                        type4 = ConstraintAnchor.Type.RIGHT;
                        type3 = ConstraintAnchor.Type.LEFT;
                        i2 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        constraintWidget5 = constraintWidget;
                        constraintWidget5.immediateConnect(type4, constraintWidget4, type3, i2, i17);
                    }
                    i3 = layoutParams.topToTop;
                    if (i3 == -1) {
                        constraintWidget6 = sparseArray.get(i3);
                        if (constraintWidget6 != null) {
                            type6 = ConstraintAnchor.Type.TOP;
                            i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            i5 = layoutParams.goneTopMargin;
                            constraintWidget7 = constraintWidget;
                            type5 = type6;
                            constraintWidget7.immediateConnect(type5, constraintWidget6, type6, i4, i5);
                        }
                        i6 = layoutParams.bottomToTop;
                        if (i6 == -1) {
                            constraintWidget8 = sparseArray.get(i6);
                            if (constraintWidget8 != null) {
                                type8 = ConstraintAnchor.Type.BOTTOM;
                                type7 = ConstraintAnchor.Type.TOP;
                                i7 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                                i8 = layoutParams.goneBottomMargin;
                                constraintWidget9 = constraintWidget;
                                constraintWidget9.immediateConnect(type8, constraintWidget8, type7, i7, i8);
                            }
                            i9 = layoutParams.baselineToBaseline;
                            if (i9 != -1) {
                                View view2 = this.mChildrenByIds.get(i9);
                                ConstraintWidget constraintWidget11 = sparseArray.get(layoutParams.baselineToBaseline);
                                if (constraintWidget11 != null && view2 != null && (view2.getLayoutParams() instanceof LayoutParams)) {
                                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                                    layoutParams.needsBaseline = true;
                                    layoutParams2.needsBaseline = true;
                                    constraintWidget.getAnchor(ConstraintAnchor.Type.BASELINE).connect(constraintWidget11.getAnchor(ConstraintAnchor.Type.BASELINE), 0, -1, true);
                                    constraintWidget.setHasBaseline(true);
                                    layoutParams2.widget.setHasBaseline(true);
                                    constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).reset();
                                    constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
                                }
                            }
                            f2 = f;
                            if (f2 >= 0.0f) {
                                constraintWidget.setHorizontalBiasPercent(f2);
                            }
                            f3 = layoutParams.verticalBias;
                            if (f3 >= 0.0f) {
                                constraintWidget.setVerticalBiasPercent(f3);
                            }
                        } else {
                            int i19 = layoutParams.bottomToBottom;
                            if (i19 != -1 && (constraintWidget8 = sparseArray.get(i19)) != null) {
                                type7 = ConstraintAnchor.Type.BOTTOM;
                                i7 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                                i8 = layoutParams.goneBottomMargin;
                                constraintWidget9 = constraintWidget;
                                type8 = type7;
                                constraintWidget9.immediateConnect(type8, constraintWidget8, type7, i7, i8);
                            }
                            i9 = layoutParams.baselineToBaseline;
                            if (i9 != -1) {
                            }
                            f2 = f;
                            if (f2 >= 0.0f) {
                            }
                            f3 = layoutParams.verticalBias;
                            if (f3 >= 0.0f) {
                            }
                        }
                    } else {
                        int i20 = layoutParams.topToBottom;
                        if (i20 != -1 && (constraintWidget6 = sparseArray.get(i20)) != null) {
                            type5 = ConstraintAnchor.Type.TOP;
                            type6 = ConstraintAnchor.Type.BOTTOM;
                            i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            i5 = layoutParams.goneTopMargin;
                            constraintWidget7 = constraintWidget;
                            constraintWidget7.immediateConnect(type5, constraintWidget6, type6, i4, i5);
                        }
                        i6 = layoutParams.bottomToTop;
                        if (i6 == -1) {
                        }
                    }
                } else {
                    if (i15 != -1 && (constraintWidget4 = sparseArray.get(i15)) != null) {
                        type3 = ConstraintAnchor.Type.RIGHT;
                        i2 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        constraintWidget5 = constraintWidget;
                        type4 = type3;
                        constraintWidget5.immediateConnect(type4, constraintWidget4, type3, i2, i17);
                    }
                    i3 = layoutParams.topToTop;
                    if (i3 == -1) {
                    }
                }
            } else {
                f = f5;
                if (i14 != -1) {
                }
            }
        } else {
            f = f5;
            if (i13 != -1 && (constraintWidget2 = sparseArray.get(i13)) != null) {
                type = ConstraintAnchor.Type.LEFT;
                type2 = ConstraintAnchor.Type.RIGHT;
                i = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                constraintWidget3 = constraintWidget;
                constraintWidget3.immediateConnect(type, constraintWidget2, type2, i, i16);
            }
            if (i14 != -1) {
            }
        }
        if (z && (layoutParams.editorAbsoluteX != -1 || layoutParams.editorAbsoluteY != -1)) {
            constraintWidget.setOrigin(layoutParams.editorAbsoluteX, layoutParams.editorAbsoluteY);
        }
        if (layoutParams.horizontalDimensionFixed) {
            constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.setWidth(((ViewGroup.MarginLayoutParams) layoutParams).width);
            if (((ViewGroup.MarginLayoutParams) layoutParams).width == -2) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
            constraintWidget.setHorizontalDimensionBehaviour(layoutParams.constrainedWidth ? ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT : ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            constraintWidget.setWidth(0);
        }
        if (layoutParams.verticalDimensionFixed) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.setHeight(((ViewGroup.MarginLayoutParams) layoutParams).height);
            if (((ViewGroup.MarginLayoutParams) layoutParams).height == -2) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
            constraintWidget.setVerticalDimensionBehaviour(layoutParams.constrainedHeight ? ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT : ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        } else {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            constraintWidget.setHeight(0);
        }
        constraintWidget.setDimensionRatio(layoutParams.dimensionRatio);
        constraintWidget.setHorizontalWeight(layoutParams.horizontalWeight);
        constraintWidget.setVerticalWeight(layoutParams.verticalWeight);
        constraintWidget.setHorizontalChainStyle(layoutParams.horizontalChainStyle);
        constraintWidget.setVerticalChainStyle(layoutParams.verticalChainStyle);
        constraintWidget.setHorizontalMatchStyle(layoutParams.matchConstraintDefaultWidth, layoutParams.matchConstraintMinWidth, layoutParams.matchConstraintMaxWidth, layoutParams.matchConstraintPercentWidth);
        constraintWidget.setVerticalMatchStyle(layoutParams.matchConstraintDefaultHeight, layoutParams.matchConstraintMinHeight, layoutParams.matchConstraintMaxHeight, layoutParams.matchConstraintPercentHeight);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                this.mConstraintHelpers.get(i).updatePreDraw(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i3 = (int) ((parseInt / 1080.0f) * width);
                        int i4 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i3;
                        float f2 = i4;
                        float f3 = i3 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float parseInt4 = i4 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, parseInt4, paint);
                        canvas.drawLine(f3, parseInt4, f, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f3, f2, paint);
                    }
                }
            }
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    @Override // android.view.View
    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.mDesignIds;
        if (hashMap != null && hashMap.containsKey(str)) {
            return this.mDesignIds.get(str);
        }
        return null;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public View getViewById(int i) {
        return this.mChildrenByIds.get(i);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view != null) {
            return ((LayoutParams) view.getLayoutParams()).widget;
        }
        return null;
    }

    public boolean isRtl() {
        return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
    }

    public void loadLayoutDescription(int i) {
        if (i != 0) {
            try {
                this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i);
                return;
            } catch (Resources.NotFoundException unused) {
            }
        }
        this.mConstraintLayoutSpec = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.widget;
            if ((childAt.getVisibility() != 8 || layoutParams.isGuideline || layoutParams.isHelper || layoutParams.isVirtualGroup || isInEditMode) && !layoutParams.isInPlaceholder) {
                int x = constraintWidget.getX();
                int y = constraintWidget.getY();
                int width = constraintWidget.getWidth() + x;
                int height = constraintWidget.getHeight() + y;
                childAt.layout(x, y, width, height);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(x, y, width, height);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.mConstraintHelpers.get(i6).updatePostLayout(this);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.mOnMeasureWidthMeasureSpec = i;
        this.mOnMeasureHeightMeasureSpec = i2;
        this.mLayoutWidget.setRtl(isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                this.mLayoutWidget.updateHierarchy();
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i, i2);
        resolveMeasuredDimension(i, i2, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            androidx.constraintlayout.solver.widgets.Guideline guideline = new androidx.constraintlayout.solver.widgets.Guideline();
            layoutParams.widget = guideline;
            layoutParams.isGuideline = true;
            guideline.setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).isHelper = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.remove(getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        Measurer measurer = this.mMeasurer;
        int i5 = measurer.paddingHeight;
        int resolveSizeAndState = ViewGroup.resolveSizeAndState(i3 + measurer.paddingWidth, i, 0);
        int resolveSizeAndState2 = ViewGroup.resolveSizeAndState(i4 + i5, i2, 0);
        int i6 = resolveSizeAndState & ViewCompat.MEASURED_SIZE_MASK;
        int i7 = resolveSizeAndState2 & ViewCompat.MEASURED_SIZE_MASK;
        int min = Math.min(this.mMaxWidth, i6);
        int min2 = Math.min(this.mMaxHeight, i7);
        if (z) {
            min |= 16777216;
        }
        if (z2) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.mLastMeasureWidth = min;
        this.mLastMeasureHeight = min2;
    }

    public void resolveSystem(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i4 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.mMeasurer.captureLayoutInfos(i2, i3, max, max2, paddingWidth, i4);
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        int max5 = (max3 > 0 || max4 > 0) ? isRtl() ? max4 : max3 : Math.max(0, getPaddingLeft());
        int i5 = size - paddingWidth;
        int i6 = size2 - i4;
        setSelfDimensionBehaviour(constraintWidgetContainer, mode, i5, mode2, i6);
        constraintWidgetContainer.measure(i, mode, i5, mode2, i6, this.mLastMeasureWidth, this.mLastMeasureHeight, max5, max);
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i != 0 || !(obj instanceof String) || !(obj2 instanceof Integer)) {
            return;
        }
        if (this.mDesignIds == null) {
            this.mDesignIds = new HashMap<>();
        }
        String str = (String) obj;
        int indexOf = str.indexOf("/");
        if (indexOf != -1) {
            str = str.substring(indexOf + 1);
        }
        this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
    }

    @Override // android.view.View
    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.setOnConstraintsChanged(constraintsChangedListener);
        }
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
        this.mLayoutWidget.setOptimizationLevel(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
        if (r3 == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        r12 = java.lang.Math.max(0, r7.mMinHeight);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
        if (r3 == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0025, code lost:
        if (r3 == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x002c, code lost:
        r10 = java.lang.Math.max(0, r7.mMinWidth);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x002a, code lost:
        if (r3 == 0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setSelfDimensionBehaviour(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3, int i4) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        Measurer measurer = this.mMeasurer;
        int i5 = measurer.paddingHeight;
        int i6 = measurer.paddingWidth;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        int childCount = getChildCount();
        if (i != Integer.MIN_VALUE) {
            if (i == 0) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (i != 1073741824) {
                dimensionBehaviour = dimensionBehaviour2;
            } else {
                i2 = Math.min(this.mMaxWidth - i6, i2);
                dimensionBehaviour = dimensionBehaviour2;
            }
            i2 = 0;
        } else {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (i3 != Integer.MIN_VALUE) {
            if (i3 == 0) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (i3 == 1073741824) {
                i4 = Math.min(this.mMaxHeight - i5, i4);
            }
            i4 = 0;
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (i2 != constraintWidgetContainer.getWidth() || i4 != constraintWidgetContainer.getHeight()) {
            constraintWidgetContainer.invalidateMeasures();
        }
        constraintWidgetContainer.setX(0);
        constraintWidgetContainer.setY(0);
        constraintWidgetContainer.setMaxWidth(this.mMaxWidth - i6);
        constraintWidgetContainer.setMaxHeight(this.mMaxHeight - i5);
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setHorizontalDimensionBehaviour(dimensionBehaviour);
        constraintWidgetContainer.setWidth(i2);
        constraintWidgetContainer.setVerticalDimensionBehaviour(dimensionBehaviour2);
        constraintWidgetContainer.setHeight(i4);
        constraintWidgetContainer.setMinWidth(this.mMinWidth - i6);
        constraintWidgetContainer.setMinHeight(this.mMinHeight - i5);
    }

    public void setState(int i, int i2, int i3) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i, i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}

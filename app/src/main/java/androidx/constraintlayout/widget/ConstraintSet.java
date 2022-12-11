package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.C0186R;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import me.tvspark.outline;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class ConstraintSet {
    public static final int ALPHA = 43;
    public static final int ANIMATE_RELATIVE_TO = 64;
    public static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    public static final int BARRIER_DIRECTION = 72;
    public static final int BARRIER_MARGIN = 73;
    public static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    public static final int BASELINE_TO_BASELINE = 1;
    public static final int BOTTOM = 4;
    public static final int BOTTOM_MARGIN = 2;
    public static final int BOTTOM_TO_BOTTOM = 3;
    public static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int CHAIN_USE_RTL = 71;
    public static final int CIRCLE = 61;
    public static final int CIRCLE_ANGLE = 63;
    public static final int CIRCLE_RADIUS = 62;
    public static final int CONSTRAINED_HEIGHT = 81;
    public static final int CONSTRAINED_WIDTH = 80;
    public static final int CONSTRAINT_REFERENCED_IDS = 74;
    public static final int CONSTRAINT_TAG = 77;
    public static final boolean DEBUG = false;
    public static final int DIMENSION_RATIO = 5;
    public static final int DRAW_PATH = 66;
    public static final int EDITOR_ABSOLUTE_X = 6;
    public static final int EDITOR_ABSOLUTE_Y = 7;
    public static final int ELEVATION = 44;
    public static final int END = 7;
    public static final int END_MARGIN = 8;
    public static final int END_TO_END = 9;
    public static final int END_TO_START = 10;
    public static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    public static final int GONE_BOTTOM_MARGIN = 11;
    public static final int GONE_END_MARGIN = 12;
    public static final int GONE_LEFT_MARGIN = 13;
    public static final int GONE_RIGHT_MARGIN = 14;
    public static final int GONE_START_MARGIN = 15;
    public static final int GONE_TOP_MARGIN = 16;
    public static final int GUIDE_BEGIN = 17;
    public static final int GUIDE_END = 18;
    public static final int GUIDE_PERCENT = 19;
    public static final int HEIGHT_DEFAULT = 55;
    public static final int HEIGHT_MAX = 57;
    public static final int HEIGHT_MIN = 59;
    public static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    public static final int HORIZONTAL_STYLE = 41;
    public static final int HORIZONTAL_WEIGHT = 39;
    public static final int INVISIBLE = 4;
    public static final int LAYOUT_HEIGHT = 21;
    public static final int LAYOUT_VISIBILITY = 22;
    public static final int LAYOUT_WIDTH = 23;
    public static final int LEFT = 1;
    public static final int LEFT_MARGIN = 24;
    public static final int LEFT_TO_LEFT = 25;
    public static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int MOTION_STAGGER = 79;
    public static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    public static final int PATH_MOTION_ARC = 76;
    public static final int PROGRESS = 68;
    public static final int RIGHT = 2;
    public static final int RIGHT_MARGIN = 28;
    public static final int RIGHT_TO_LEFT = 29;
    public static final int RIGHT_TO_RIGHT = 30;
    public static final int ROTATION = 60;
    public static final int ROTATION_X = 45;
    public static final int ROTATION_Y = 46;
    public static final int SCALE_X = 47;
    public static final int SCALE_Y = 48;
    public static final int START = 6;
    public static final int START_MARGIN = 31;
    public static final int START_TO_END = 32;
    public static final int START_TO_START = 33;
    public static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    public static final int TOP_MARGIN = 34;
    public static final int TOP_TO_BOTTOM = 35;
    public static final int TOP_TO_TOP = 36;
    public static final int TRANSFORM_PIVOT_X = 49;
    public static final int TRANSFORM_PIVOT_Y = 50;
    public static final int TRANSITION_EASING = 65;
    public static final int TRANSITION_PATH_ROTATE = 67;
    public static final int TRANSLATION_X = 51;
    public static final int TRANSLATION_Y = 52;
    public static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    public static final int UNUSED = 82;
    public static final int VERTICAL = 1;
    public static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    public static final int VERTICAL_STYLE = 42;
    public static final int VERTICAL_WEIGHT = 40;
    public static final int VIEW_ID = 38;
    public static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    public static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    public static final int WIDTH_DEFAULT = 54;
    public static final int WIDTH_MAX = 56;
    public static final int WIDTH_MIN = 58;
    public static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    public static SparseIntArray mapToConstant;
    public boolean mValidate;
    public HashMap<String, ConstraintAttribute> mSavedAttributes = new HashMap<>();
    public boolean mForceId = true;
    public HashMap<Integer, Constraint> mConstraints = new HashMap<>();

    /* loaded from: classes3.dex */
    public static class Constraint {
        public int mViewId;
        public final PropertySet propertySet = new PropertySet();
        public final Motion motion = new Motion();
        public final Layout layout = new Layout();
        public final Transform transform = new Transform();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFrom(int i, ConstraintLayout.LayoutParams layoutParams) {
            this.mViewId = i;
            Layout layout = this.layout;
            layout.leftToLeft = layoutParams.leftToLeft;
            layout.leftToRight = layoutParams.leftToRight;
            layout.rightToLeft = layoutParams.rightToLeft;
            layout.rightToRight = layoutParams.rightToRight;
            layout.topToTop = layoutParams.topToTop;
            layout.topToBottom = layoutParams.topToBottom;
            layout.bottomToTop = layoutParams.bottomToTop;
            layout.bottomToBottom = layoutParams.bottomToBottom;
            layout.baselineToBaseline = layoutParams.baselineToBaseline;
            layout.startToEnd = layoutParams.startToEnd;
            layout.startToStart = layoutParams.startToStart;
            layout.endToStart = layoutParams.endToStart;
            layout.endToEnd = layoutParams.endToEnd;
            layout.horizontalBias = layoutParams.horizontalBias;
            layout.verticalBias = layoutParams.verticalBias;
            layout.dimensionRatio = layoutParams.dimensionRatio;
            layout.circleConstraint = layoutParams.circleConstraint;
            layout.circleRadius = layoutParams.circleRadius;
            layout.circleAngle = layoutParams.circleAngle;
            layout.editorAbsoluteX = layoutParams.editorAbsoluteX;
            layout.editorAbsoluteY = layoutParams.editorAbsoluteY;
            layout.orientation = layoutParams.orientation;
            layout.guidePercent = layoutParams.guidePercent;
            layout.guideBegin = layoutParams.guideBegin;
            layout.guideEnd = layoutParams.guideEnd;
            layout.mWidth = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            layout.mHeight = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            layout.leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            layout.rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            layout.topMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            layout.bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            layout.verticalWeight = layoutParams.verticalWeight;
            layout.horizontalWeight = layoutParams.horizontalWeight;
            layout.verticalChainStyle = layoutParams.verticalChainStyle;
            layout.horizontalChainStyle = layoutParams.horizontalChainStyle;
            layout.constrainedWidth = layoutParams.constrainedWidth;
            layout.constrainedHeight = layoutParams.constrainedHeight;
            layout.widthDefault = layoutParams.matchConstraintDefaultWidth;
            layout.heightDefault = layoutParams.matchConstraintDefaultHeight;
            layout.widthMax = layoutParams.matchConstraintMaxWidth;
            layout.heightMax = layoutParams.matchConstraintMaxHeight;
            layout.widthMin = layoutParams.matchConstraintMinWidth;
            layout.heightMin = layoutParams.matchConstraintMinHeight;
            layout.widthPercent = layoutParams.matchConstraintPercentWidth;
            layout.heightPercent = layoutParams.matchConstraintPercentHeight;
            layout.mConstraintTag = layoutParams.constraintTag;
            layout.goneTopMargin = layoutParams.goneTopMargin;
            layout.goneBottomMargin = layoutParams.goneBottomMargin;
            layout.goneLeftMargin = layoutParams.goneLeftMargin;
            layout.goneRightMargin = layoutParams.goneRightMargin;
            layout.goneStartMargin = layoutParams.goneStartMargin;
            layout.goneEndMargin = layoutParams.goneEndMargin;
            layout.endMargin = layoutParams.getMarginEnd();
            this.layout.startMargin = layoutParams.getMarginStart();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFromConstraints(int i, Constraints.LayoutParams layoutParams) {
            fillFrom(i, layoutParams);
            this.propertySet.alpha = layoutParams.alpha;
            Transform transform = this.transform;
            transform.rotation = layoutParams.rotation;
            transform.rotationX = layoutParams.rotationX;
            transform.rotationY = layoutParams.rotationY;
            transform.scaleX = layoutParams.scaleX;
            transform.scaleY = layoutParams.scaleY;
            transform.transformPivotX = layoutParams.transformPivotX;
            transform.transformPivotY = layoutParams.transformPivotY;
            transform.translationX = layoutParams.translationX;
            transform.translationY = layoutParams.translationY;
            transform.translationZ = layoutParams.translationZ;
            transform.elevation = layoutParams.elevation;
            transform.applyElevation = layoutParams.applyElevation;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFromConstraints(ConstraintHelper constraintHelper, int i, Constraints.LayoutParams layoutParams) {
            fillFromConstraints(i, layoutParams);
            if (constraintHelper instanceof Barrier) {
                Layout layout = this.layout;
                layout.mHelperType = 1;
                Barrier barrier = (Barrier) constraintHelper;
                layout.mBarrierDirection = barrier.getType();
                this.layout.mReferenceIds = barrier.getReferencedIds();
                this.layout.mBarrierMargin = barrier.getMargin();
            }
        }

        private ConstraintAttribute get(String str, ConstraintAttribute.AttributeType attributeType) {
            if (!this.mCustomConstraints.containsKey(str)) {
                ConstraintAttribute constraintAttribute = new ConstraintAttribute(str, attributeType);
                this.mCustomConstraints.put(str, constraintAttribute);
                return constraintAttribute;
            }
            ConstraintAttribute constraintAttribute2 = this.mCustomConstraints.get(str);
            if (constraintAttribute2.getType() == attributeType) {
                return constraintAttribute2;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ConstraintAttribute is already a ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(constraintAttribute2.getType().name());
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setColorValue(String str, int i) {
            get(str, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFloatValue(String str, float f) {
            get(str, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIntValue(String str, int i) {
            get(str, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringValue(String str, String str2) {
            get(str, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(str2);
        }

        public void applyTo(ConstraintLayout.LayoutParams layoutParams) {
            Layout layout = this.layout;
            layoutParams.leftToLeft = layout.leftToLeft;
            layoutParams.leftToRight = layout.leftToRight;
            layoutParams.rightToLeft = layout.rightToLeft;
            layoutParams.rightToRight = layout.rightToRight;
            layoutParams.topToTop = layout.topToTop;
            layoutParams.topToBottom = layout.topToBottom;
            layoutParams.bottomToTop = layout.bottomToTop;
            layoutParams.bottomToBottom = layout.bottomToBottom;
            layoutParams.baselineToBaseline = layout.baselineToBaseline;
            layoutParams.startToEnd = layout.startToEnd;
            layoutParams.startToStart = layout.startToStart;
            layoutParams.endToStart = layout.endToStart;
            layoutParams.endToEnd = layout.endToEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = layout.leftMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = layout.rightMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = layout.topMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = layout.bottomMargin;
            layoutParams.goneStartMargin = layout.goneStartMargin;
            layoutParams.goneEndMargin = layout.goneEndMargin;
            layoutParams.goneTopMargin = layout.goneTopMargin;
            layoutParams.goneBottomMargin = layout.goneBottomMargin;
            layoutParams.horizontalBias = layout.horizontalBias;
            layoutParams.verticalBias = layout.verticalBias;
            layoutParams.circleConstraint = layout.circleConstraint;
            layoutParams.circleRadius = layout.circleRadius;
            layoutParams.circleAngle = layout.circleAngle;
            layoutParams.dimensionRatio = layout.dimensionRatio;
            layoutParams.editorAbsoluteX = layout.editorAbsoluteX;
            layoutParams.editorAbsoluteY = layout.editorAbsoluteY;
            layoutParams.verticalWeight = layout.verticalWeight;
            layoutParams.horizontalWeight = layout.horizontalWeight;
            layoutParams.verticalChainStyle = layout.verticalChainStyle;
            layoutParams.horizontalChainStyle = layout.horizontalChainStyle;
            layoutParams.constrainedWidth = layout.constrainedWidth;
            layoutParams.constrainedHeight = layout.constrainedHeight;
            layoutParams.matchConstraintDefaultWidth = layout.widthDefault;
            layoutParams.matchConstraintDefaultHeight = layout.heightDefault;
            layoutParams.matchConstraintMaxWidth = layout.widthMax;
            layoutParams.matchConstraintMaxHeight = layout.heightMax;
            layoutParams.matchConstraintMinWidth = layout.widthMin;
            layoutParams.matchConstraintMinHeight = layout.heightMin;
            layoutParams.matchConstraintPercentWidth = layout.widthPercent;
            layoutParams.matchConstraintPercentHeight = layout.heightPercent;
            layoutParams.orientation = layout.orientation;
            layoutParams.guidePercent = layout.guidePercent;
            layoutParams.guideBegin = layout.guideBegin;
            layoutParams.guideEnd = layout.guideEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = layout.mWidth;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = layout.mHeight;
            String str = layout.mConstraintTag;
            if (str != null) {
                layoutParams.constraintTag = str;
            }
            layoutParams.setMarginStart(this.layout.startMargin);
            layoutParams.setMarginEnd(this.layout.endMargin);
            layoutParams.validate();
        }

        /* renamed from: clone */
        public Constraint m4298clone() {
            Constraint constraint = new Constraint();
            constraint.layout.copyFrom(this.layout);
            constraint.motion.copyFrom(this.motion);
            constraint.propertySet.copyFrom(this.propertySet);
            constraint.transform.copyFrom(this.transform);
            constraint.mViewId = this.mViewId;
            return constraint;
        }
    }

    /* loaded from: classes3.dex */
    public static class Layout {
        public static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
        public static final int BARRIER_DIRECTION = 72;
        public static final int BARRIER_MARGIN = 73;
        public static final int BASELINE_TO_BASELINE = 1;
        public static final int BOTTOM_MARGIN = 2;
        public static final int BOTTOM_TO_BOTTOM = 3;
        public static final int BOTTOM_TO_TOP = 4;
        public static final int CHAIN_USE_RTL = 71;
        public static final int CIRCLE = 61;
        public static final int CIRCLE_ANGLE = 63;
        public static final int CIRCLE_RADIUS = 62;
        public static final int CONSTRAINT_REFERENCED_IDS = 74;
        public static final int DIMENSION_RATIO = 5;
        public static final int EDITOR_ABSOLUTE_X = 6;
        public static final int EDITOR_ABSOLUTE_Y = 7;
        public static final int END_MARGIN = 8;
        public static final int END_TO_END = 9;
        public static final int END_TO_START = 10;
        public static final int GONE_BOTTOM_MARGIN = 11;
        public static final int GONE_END_MARGIN = 12;
        public static final int GONE_LEFT_MARGIN = 13;
        public static final int GONE_RIGHT_MARGIN = 14;
        public static final int GONE_START_MARGIN = 15;
        public static final int GONE_TOP_MARGIN = 16;
        public static final int GUIDE_BEGIN = 17;
        public static final int GUIDE_END = 18;
        public static final int GUIDE_PERCENT = 19;
        public static final int HEIGHT_PERCENT = 70;
        public static final int HORIZONTAL_BIAS = 20;
        public static final int HORIZONTAL_STYLE = 39;
        public static final int HORIZONTAL_WEIGHT = 37;
        public static final int LAYOUT_HEIGHT = 21;
        public static final int LAYOUT_WIDTH = 22;
        public static final int LEFT_MARGIN = 23;
        public static final int LEFT_TO_LEFT = 24;
        public static final int LEFT_TO_RIGHT = 25;
        public static final int ORIENTATION = 26;
        public static final int RIGHT_MARGIN = 27;
        public static final int RIGHT_TO_LEFT = 28;
        public static final int RIGHT_TO_RIGHT = 29;
        public static final int START_MARGIN = 30;
        public static final int START_TO_END = 31;
        public static final int START_TO_START = 32;
        public static final int TOP_MARGIN = 33;
        public static final int TOP_TO_BOTTOM = 34;
        public static final int TOP_TO_TOP = 35;
        public static final int UNSET = -1;
        public static final int UNUSED = 76;
        public static final int VERTICAL_BIAS = 36;
        public static final int VERTICAL_STYLE = 40;
        public static final int VERTICAL_WEIGHT = 38;
        public static final int WIDTH_PERCENT = 69;
        public static SparseIntArray mapToConstant;
        public String mConstraintTag;
        public int mHeight;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public boolean mIsGuideline = false;
        public boolean mApply = false;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int topToTop = -1;
        public int topToBottom = -1;
        public int bottomToTop = -1;
        public int bottomToBottom = -1;
        public int baselineToBaseline = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int endToStart = -1;
        public int endToEnd = -1;
        public float horizontalBias = 0.5f;
        public float verticalBias = 0.5f;
        public String dimensionRatio = null;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public float circleAngle = 0.0f;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int orientation = -1;
        public int leftMargin = -1;
        public int rightMargin = -1;
        public int topMargin = -1;
        public int bottomMargin = -1;
        public int endMargin = -1;
        public int startMargin = -1;
        public int goneLeftMargin = -1;
        public int goneTopMargin = -1;
        public int goneRightMargin = -1;
        public int goneBottomMargin = -1;
        public int goneEndMargin = -1;
        public int goneStartMargin = -1;
        public float verticalWeight = -1.0f;
        public float horizontalWeight = -1.0f;
        public int horizontalChainStyle = 0;
        public int verticalChainStyle = 0;
        public int widthDefault = 0;
        public int heightDefault = 0;
        public int widthMax = -1;
        public int heightMax = -1;
        public int widthMin = -1;
        public int heightMin = -1;
        public float widthPercent = 1.0f;
        public float heightPercent = 1.0f;
        public int mBarrierDirection = -1;
        public int mBarrierMargin = 0;
        public int mHelperType = -1;
        public boolean constrainedWidth = false;
        public boolean constrainedHeight = false;
        public boolean mBarrierAllowsGoneWidgets = true;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(C0186R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            mapToConstant.append(C0186R.styleable.Layout_layout_editor_absoluteX, 6);
            mapToConstant.append(C0186R.styleable.Layout_layout_editor_absoluteY, 7);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintGuide_begin, 17);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintGuide_end, 18);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintGuide_percent, 19);
            mapToConstant.append(C0186R.styleable.Layout_android_orientation, 26);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            mapToConstant.append(C0186R.styleable.Layout_layout_goneMarginLeft, 13);
            mapToConstant.append(C0186R.styleable.Layout_layout_goneMarginTop, 16);
            mapToConstant.append(C0186R.styleable.Layout_layout_goneMarginRight, 14);
            mapToConstant.append(C0186R.styleable.Layout_layout_goneMarginBottom, 11);
            mapToConstant.append(C0186R.styleable.Layout_layout_goneMarginStart, 15);
            mapToConstant.append(C0186R.styleable.Layout_layout_goneMarginEnd, 12);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintVertical_weight, 38);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintVertical_bias, 36);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintDimensionRatio, 5);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintLeft_creator, 76);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintTop_creator, 76);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintRight_creator, 76);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintBottom_creator, 76);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintBaseline_creator, 76);
            mapToConstant.append(C0186R.styleable.Layout_android_layout_marginLeft, 23);
            mapToConstant.append(C0186R.styleable.Layout_android_layout_marginRight, 27);
            mapToConstant.append(C0186R.styleable.Layout_android_layout_marginStart, 30);
            mapToConstant.append(C0186R.styleable.Layout_android_layout_marginEnd, 8);
            mapToConstant.append(C0186R.styleable.Layout_android_layout_marginTop, 33);
            mapToConstant.append(C0186R.styleable.Layout_android_layout_marginBottom, 2);
            mapToConstant.append(C0186R.styleable.Layout_android_layout_width, 22);
            mapToConstant.append(C0186R.styleable.Layout_android_layout_height, 21);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintCircle, 61);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintCircleRadius, 62);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintCircleAngle, 63);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintWidth_percent, 69);
            mapToConstant.append(C0186R.styleable.Layout_layout_constraintHeight_percent, 70);
            mapToConstant.append(C0186R.styleable.Layout_chainUseRtl, 71);
            mapToConstant.append(C0186R.styleable.Layout_barrierDirection, 72);
            mapToConstant.append(C0186R.styleable.Layout_barrierMargin, 73);
            mapToConstant.append(C0186R.styleable.Layout_constraint_referenced_ids, 74);
            mapToConstant.append(C0186R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void copyFrom(Layout layout) {
            this.mIsGuideline = layout.mIsGuideline;
            this.mWidth = layout.mWidth;
            this.mApply = layout.mApply;
            this.mHeight = layout.mHeight;
            this.guideBegin = layout.guideBegin;
            this.guideEnd = layout.guideEnd;
            this.guidePercent = layout.guidePercent;
            this.leftToLeft = layout.leftToLeft;
            this.leftToRight = layout.leftToRight;
            this.rightToLeft = layout.rightToLeft;
            this.rightToRight = layout.rightToRight;
            this.topToTop = layout.topToTop;
            this.topToBottom = layout.topToBottom;
            this.bottomToTop = layout.bottomToTop;
            this.bottomToBottom = layout.bottomToBottom;
            this.baselineToBaseline = layout.baselineToBaseline;
            this.startToEnd = layout.startToEnd;
            this.startToStart = layout.startToStart;
            this.endToStart = layout.endToStart;
            this.endToEnd = layout.endToEnd;
            this.horizontalBias = layout.horizontalBias;
            this.verticalBias = layout.verticalBias;
            this.dimensionRatio = layout.dimensionRatio;
            this.circleConstraint = layout.circleConstraint;
            this.circleRadius = layout.circleRadius;
            this.circleAngle = layout.circleAngle;
            this.editorAbsoluteX = layout.editorAbsoluteX;
            this.editorAbsoluteY = layout.editorAbsoluteY;
            this.orientation = layout.orientation;
            this.leftMargin = layout.leftMargin;
            this.rightMargin = layout.rightMargin;
            this.topMargin = layout.topMargin;
            this.bottomMargin = layout.bottomMargin;
            this.endMargin = layout.endMargin;
            this.startMargin = layout.startMargin;
            this.goneLeftMargin = layout.goneLeftMargin;
            this.goneTopMargin = layout.goneTopMargin;
            this.goneRightMargin = layout.goneRightMargin;
            this.goneBottomMargin = layout.goneBottomMargin;
            this.goneEndMargin = layout.goneEndMargin;
            this.goneStartMargin = layout.goneStartMargin;
            this.verticalWeight = layout.verticalWeight;
            this.horizontalWeight = layout.horizontalWeight;
            this.horizontalChainStyle = layout.horizontalChainStyle;
            this.verticalChainStyle = layout.verticalChainStyle;
            this.widthDefault = layout.widthDefault;
            this.heightDefault = layout.heightDefault;
            this.widthMax = layout.widthMax;
            this.heightMax = layout.heightMax;
            this.widthMin = layout.widthMin;
            this.heightMin = layout.heightMin;
            this.widthPercent = layout.widthPercent;
            this.heightPercent = layout.heightPercent;
            this.mBarrierDirection = layout.mBarrierDirection;
            this.mBarrierMargin = layout.mBarrierMargin;
            this.mHelperType = layout.mHelperType;
            this.mConstraintTag = layout.mConstraintTag;
            int[] iArr = layout.mReferenceIds;
            if (iArr != null) {
                this.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.mReferenceIds = null;
            }
            this.mReferenceIdString = layout.mReferenceIdString;
            this.constrainedWidth = layout.constrainedWidth;
            this.constrainedHeight = layout.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = layout.mBarrierAllowsGoneWidgets;
        }

        public void dump(MotionScene motionScene, StringBuilder sb) {
            Field[] declaredFields = Layout.class.getDeclaredFields();
            sb.append("\n");
            for (Field field : declaredFields) {
                String name = field.getName();
                if (!Modifier.isStatic(field.getModifiers())) {
                    try {
                        Object obj = field.get(this);
                        Class<?> type = field.getType();
                        if (type == Integer.TYPE) {
                            Integer num = (Integer) obj;
                            if (num.intValue() != -1) {
                                Object lookUpConstraintName = motionScene.lookUpConstraintName(num.intValue());
                                sb.append("    ");
                                sb.append(name);
                                sb.append(" = \"");
                                sb.append(lookUpConstraintName == null ? num : lookUpConstraintName);
                            }
                        } else if (type == Float.TYPE) {
                            Float f = (Float) obj;
                            if (f.floatValue() != -1.0f) {
                                sb.append("    ");
                                sb.append(name);
                                sb.append(" = \"");
                                sb.append(f);
                            }
                        }
                        sb.append("\"\n");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0186R.styleable.Layout);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i2 = mapToConstant.get(index);
                if (i2 == 80) {
                    this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                } else if (i2 != 81) {
                    switch (i2) {
                        case 1:
                            this.baselineToBaseline = ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToBaseline);
                            continue;
                        case 2:
                            this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                            continue;
                        case 3:
                            this.bottomToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToBottom);
                            continue;
                        case 4:
                            this.bottomToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToTop);
                            continue;
                        case 5:
                            this.dimensionRatio = obtainStyledAttributes.getString(index);
                            continue;
                        case 6:
                            this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                            continue;
                        case 7:
                            this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                            continue;
                        case 8:
                            this.endMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                            continue;
                        case 9:
                            this.endToEnd = ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToEnd);
                            continue;
                        case 10:
                            this.endToStart = ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToStart);
                            continue;
                        case 11:
                            this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                            continue;
                        case 12:
                            this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                            continue;
                        case 13:
                            this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                            continue;
                        case 14:
                            this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                            continue;
                        case 15:
                            this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                            continue;
                        case 16:
                            this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                            continue;
                        case 17:
                            this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                            continue;
                        case 18:
                            this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                            continue;
                        case 19:
                            this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                            continue;
                        case 20:
                            this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                            continue;
                        case 21:
                            this.mHeight = obtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                            continue;
                        case 22:
                            this.mWidth = obtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                            continue;
                        case 23:
                            this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                            continue;
                        case 24:
                            this.leftToLeft = ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToLeft);
                            continue;
                        case 25:
                            this.leftToRight = ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToRight);
                            continue;
                        case 26:
                            this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                            continue;
                        case 27:
                            this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                            continue;
                        case 28:
                            this.rightToLeft = ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToLeft);
                            continue;
                        case 29:
                            this.rightToRight = ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToRight);
                            continue;
                        case 30:
                            this.startMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                            continue;
                        case 31:
                            this.startToEnd = ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToEnd);
                            continue;
                        case 32:
                            this.startToStart = ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToStart);
                            continue;
                        case 33:
                            this.topMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                            continue;
                        case 34:
                            this.topToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToBottom);
                            continue;
                        case 35:
                            this.topToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToTop);
                            continue;
                        case 36:
                            this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                            continue;
                        case 37:
                            this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                            continue;
                        case 38:
                            this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                            continue;
                        case 39:
                            this.horizontalChainStyle = obtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                            continue;
                        case 40:
                            this.verticalChainStyle = obtainStyledAttributes.getInt(index, this.verticalChainStyle);
                            continue;
                        default:
                            switch (i2) {
                                case 54:
                                    this.widthDefault = obtainStyledAttributes.getInt(index, this.widthDefault);
                                    continue;
                                case 55:
                                    this.heightDefault = obtainStyledAttributes.getInt(index, this.heightDefault);
                                    continue;
                                case 56:
                                    this.widthMax = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                    continue;
                                case 57:
                                    this.heightMax = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                    continue;
                                case 58:
                                    this.widthMin = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                    continue;
                                case 59:
                                    this.heightMin = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                    continue;
                                default:
                                    switch (i2) {
                                        case 61:
                                            this.circleConstraint = ConstraintSet.lookupID(obtainStyledAttributes, index, this.circleConstraint);
                                            continue;
                                        case 62:
                                            this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                            continue;
                                        case 63:
                                            this.circleAngle = obtainStyledAttributes.getFloat(index, this.circleAngle);
                                            continue;
                                        default:
                                            switch (i2) {
                                                case 69:
                                                    this.widthPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 70:
                                                    this.heightPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 71:
                                                    continue;
                                                    continue;
                                                    continue;
                                                case 72:
                                                    this.mBarrierDirection = obtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                                    continue;
                                                case 73:
                                                    this.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                                    continue;
                                                case 74:
                                                    this.mReferenceIdString = obtainStyledAttributes.getString(index);
                                                    continue;
                                                case 75:
                                                    this.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                                    continue;
                                                case 76:
                                                default:
                                                    Integer.toHexString(index);
                                                    mapToConstant.get(index);
                                                    continue;
                                                case 77:
                                                    this.mConstraintTag = obtainStyledAttributes.getString(index);
                                                    continue;
                                            }
                                    }
                            }
                    }
                } else {
                    this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes3.dex */
    public static class Motion {
        public static final int ANIMATE_RELATIVE_TO = 5;
        public static final int MOTION_DRAW_PATH = 4;
        public static final int MOTION_STAGGER = 6;
        public static final int PATH_MOTION_ARC = 2;
        public static final int TRANSITION_EASING = 3;
        public static final int TRANSITION_PATH_ROTATE = 1;
        public static SparseIntArray mapToConstant;
        public boolean mApply = false;
        public int mAnimateRelativeTo = -1;
        public String mTransitionEasing = null;
        public int mPathMotionArc = -1;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public float mPathRotate = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(C0186R.styleable.Motion_motionPathRotate, 1);
            mapToConstant.append(C0186R.styleable.Motion_pathMotionArc, 2);
            mapToConstant.append(C0186R.styleable.Motion_transitionEasing, 3);
            mapToConstant.append(C0186R.styleable.Motion_drawPath, 4);
            mapToConstant.append(C0186R.styleable.Motion_animate_relativeTo, 5);
            mapToConstant.append(C0186R.styleable.Motion_motionStagger, 6);
        }

        public void copyFrom(Motion motion) {
            this.mApply = motion.mApply;
            this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
            this.mTransitionEasing = motion.mTransitionEasing;
            this.mPathMotionArc = motion.mPathMotionArc;
            this.mDrawPath = motion.mDrawPath;
            this.mPathRotate = motion.mPathRotate;
            this.mMotionStagger = motion.mMotionStagger;
        }

        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0186R.styleable.Motion);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.mPathRotate = obtainStyledAttributes.getFloat(index, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
                        break;
                    case 3:
                        this.mTransitionEasing = obtainStyledAttributes.peekValue(index).type == 3 ? obtainStyledAttributes.getString(index) : Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    case 4:
                        this.mDrawPath = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.mAnimateRelativeTo = ConstraintSet.lookupID(obtainStyledAttributes, index, this.mAnimateRelativeTo);
                        break;
                    case 6:
                        this.mMotionStagger = obtainStyledAttributes.getFloat(index, this.mMotionStagger);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes3.dex */
    public static class PropertySet {
        public boolean mApply = false;
        public int visibility = 0;
        public int mVisibilityMode = 0;
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;

        public void copyFrom(PropertySet propertySet) {
            this.mApply = propertySet.mApply;
            this.visibility = propertySet.visibility;
            this.alpha = propertySet.alpha;
            this.mProgress = propertySet.mProgress;
            this.mVisibilityMode = propertySet.mVisibilityMode;
        }

        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0186R.styleable.PropertySet);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0186R.styleable.PropertySet_android_alpha) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == C0186R.styleable.PropertySet_android_visibility) {
                    this.visibility = obtainStyledAttributes.getInt(index, this.visibility);
                    this.visibility = ConstraintSet.VISIBILITY_FLAGS[this.visibility];
                } else if (index == C0186R.styleable.PropertySet_visibilityMode) {
                    this.mVisibilityMode = obtainStyledAttributes.getInt(index, this.mVisibilityMode);
                } else if (index == C0186R.styleable.PropertySet_motionProgress) {
                    this.mProgress = obtainStyledAttributes.getFloat(index, this.mProgress);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes3.dex */
    public static class Transform {
        public static final int ELEVATION = 11;
        public static final int ROTATION = 1;
        public static final int ROTATION_X = 2;
        public static final int ROTATION_Y = 3;
        public static final int SCALE_X = 4;
        public static final int SCALE_Y = 5;
        public static final int TRANSFORM_PIVOT_X = 6;
        public static final int TRANSFORM_PIVOT_Y = 7;
        public static final int TRANSLATION_X = 8;
        public static final int TRANSLATION_Y = 9;
        public static final int TRANSLATION_Z = 10;
        public static SparseIntArray mapToConstant;
        public boolean mApply = false;
        public float rotation = 0.0f;
        public float rotationX = 0.0f;
        public float rotationY = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public float transformPivotX = Float.NaN;
        public float transformPivotY = Float.NaN;
        public float translationX = 0.0f;
        public float translationY = 0.0f;
        public float translationZ = 0.0f;
        public boolean applyElevation = false;
        public float elevation = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(C0186R.styleable.Transform_android_rotation, 1);
            mapToConstant.append(C0186R.styleable.Transform_android_rotationX, 2);
            mapToConstant.append(C0186R.styleable.Transform_android_rotationY, 3);
            mapToConstant.append(C0186R.styleable.Transform_android_scaleX, 4);
            mapToConstant.append(C0186R.styleable.Transform_android_scaleY, 5);
            mapToConstant.append(C0186R.styleable.Transform_android_transformPivotX, 6);
            mapToConstant.append(C0186R.styleable.Transform_android_transformPivotY, 7);
            mapToConstant.append(C0186R.styleable.Transform_android_translationX, 8);
            mapToConstant.append(C0186R.styleable.Transform_android_translationY, 9);
            mapToConstant.append(C0186R.styleable.Transform_android_translationZ, 10);
            mapToConstant.append(C0186R.styleable.Transform_android_elevation, 11);
        }

        public void copyFrom(Transform transform) {
            this.mApply = transform.mApply;
            this.rotation = transform.rotation;
            this.rotationX = transform.rotationX;
            this.rotationY = transform.rotationY;
            this.scaleX = transform.scaleX;
            this.scaleY = transform.scaleY;
            this.transformPivotX = transform.transformPivotX;
            this.transformPivotY = transform.transformPivotY;
            this.translationX = transform.translationX;
            this.translationY = transform.translationY;
            this.translationZ = transform.translationZ;
            this.applyElevation = transform.applyElevation;
            this.elevation = transform.elevation;
        }

        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0186R.styleable.Transform);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                        break;
                    case 2:
                        this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = obtainStyledAttributes.getDimension(index, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = obtainStyledAttributes.getDimension(index, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = obtainStyledAttributes.getDimension(index, this.translationX);
                        break;
                    case 9:
                        this.translationY = obtainStyledAttributes.getDimension(index, this.translationY);
                        break;
                    case 10:
                        this.translationZ = obtainStyledAttributes.getDimension(index, this.translationZ);
                        break;
                    case 11:
                        this.applyElevation = true;
                        this.elevation = obtainStyledAttributes.getDimension(index, this.elevation);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        mapToConstant = sparseIntArray;
        sparseIntArray.append(C0186R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(C0186R.styleable.Constraint_layout_editor_absoluteX, 6);
        mapToConstant.append(C0186R.styleable.Constraint_layout_editor_absoluteY, 7);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintGuide_begin, 17);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintGuide_end, 18);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintGuide_percent, 19);
        mapToConstant.append(C0186R.styleable.Constraint_android_orientation, 27);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        mapToConstant.append(C0186R.styleable.Constraint_layout_goneMarginLeft, 13);
        mapToConstant.append(C0186R.styleable.Constraint_layout_goneMarginTop, 16);
        mapToConstant.append(C0186R.styleable.Constraint_layout_goneMarginRight, 14);
        mapToConstant.append(C0186R.styleable.Constraint_layout_goneMarginBottom, 11);
        mapToConstant.append(C0186R.styleable.Constraint_layout_goneMarginStart, 15);
        mapToConstant.append(C0186R.styleable.Constraint_layout_goneMarginEnd, 12);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintVertical_weight, 40);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintVertical_bias, 37);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintLeft_creator, 82);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintTop_creator, 82);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintRight_creator, 82);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintBottom_creator, 82);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintBaseline_creator, 82);
        mapToConstant.append(C0186R.styleable.Constraint_android_layout_marginLeft, 24);
        mapToConstant.append(C0186R.styleable.Constraint_android_layout_marginRight, 28);
        mapToConstant.append(C0186R.styleable.Constraint_android_layout_marginStart, 31);
        mapToConstant.append(C0186R.styleable.Constraint_android_layout_marginEnd, 8);
        mapToConstant.append(C0186R.styleable.Constraint_android_layout_marginTop, 34);
        mapToConstant.append(C0186R.styleable.Constraint_android_layout_marginBottom, 2);
        mapToConstant.append(C0186R.styleable.Constraint_android_layout_width, 23);
        mapToConstant.append(C0186R.styleable.Constraint_android_layout_height, 21);
        mapToConstant.append(C0186R.styleable.Constraint_android_visibility, 22);
        mapToConstant.append(C0186R.styleable.Constraint_android_alpha, 43);
        mapToConstant.append(C0186R.styleable.Constraint_android_elevation, 44);
        mapToConstant.append(C0186R.styleable.Constraint_android_rotationX, 45);
        mapToConstant.append(C0186R.styleable.Constraint_android_rotationY, 46);
        mapToConstant.append(C0186R.styleable.Constraint_android_rotation, 60);
        mapToConstant.append(C0186R.styleable.Constraint_android_scaleX, 47);
        mapToConstant.append(C0186R.styleable.Constraint_android_scaleY, 48);
        mapToConstant.append(C0186R.styleable.Constraint_android_transformPivotX, 49);
        mapToConstant.append(C0186R.styleable.Constraint_android_transformPivotY, 50);
        mapToConstant.append(C0186R.styleable.Constraint_android_translationX, 51);
        mapToConstant.append(C0186R.styleable.Constraint_android_translationY, 52);
        mapToConstant.append(C0186R.styleable.Constraint_android_translationZ, 53);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintWidth_default, 54);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintHeight_default, 55);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintWidth_max, 56);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintHeight_max, 57);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintWidth_min, 58);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintHeight_min, 59);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintCircle, 61);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintCircleRadius, 62);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintCircleAngle, 63);
        mapToConstant.append(C0186R.styleable.Constraint_animate_relativeTo, 64);
        mapToConstant.append(C0186R.styleable.Constraint_transitionEasing, 65);
        mapToConstant.append(C0186R.styleable.Constraint_drawPath, 66);
        mapToConstant.append(C0186R.styleable.Constraint_transitionPathRotate, 67);
        mapToConstant.append(C0186R.styleable.Constraint_motionStagger, 79);
        mapToConstant.append(C0186R.styleable.Constraint_android_id, 38);
        mapToConstant.append(C0186R.styleable.Constraint_motionProgress, 68);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintWidth_percent, 69);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintHeight_percent, 70);
        mapToConstant.append(C0186R.styleable.Constraint_chainUseRtl, 71);
        mapToConstant.append(C0186R.styleable.Constraint_barrierDirection, 72);
        mapToConstant.append(C0186R.styleable.Constraint_barrierMargin, 73);
        mapToConstant.append(C0186R.styleable.Constraint_constraint_referenced_ids, 74);
        mapToConstant.append(C0186R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        mapToConstant.append(C0186R.styleable.Constraint_pathMotionArc, 76);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constraintTag, 77);
        mapToConstant.append(C0186R.styleable.Constraint_visibilityMode, 78);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constrainedWidth, 80);
        mapToConstant.append(C0186R.styleable.Constraint_layout_constrainedHeight, 81);
    }

    private void addAttributes(ConstraintAttribute.AttributeType attributeType, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (this.mSavedAttributes.containsKey(strArr[i])) {
                ConstraintAttribute constraintAttribute = this.mSavedAttributes.get(strArr[i]);
                if (constraintAttribute.getType() != attributeType) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ConstraintAttribute is already a ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(constraintAttribute.getType().name());
                    throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
            } else {
                this.mSavedAttributes.put(strArr[i], new ConstraintAttribute(strArr[i], attributeType));
            }
        }
    }

    private int[] convertReferenceString(View view, String str) {
        int i;
        Object designInformation;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = C0186R.C0189id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i = ((Integer) designInformation).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    private void createHorizontalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5, int i6, int i7) {
        if (iArr.length >= 2) {
            if (fArr != null && fArr.length != iArr.length) {
                throw new IllegalArgumentException("must have 2 or more widgets in a chain");
            }
            if (fArr != null) {
                get(iArr[0]).layout.horizontalWeight = fArr[0];
            }
            get(iArr[0]).layout.horizontalChainStyle = i5;
            connect(iArr[0], i6, i, i2, -1);
            for (int i8 = 1; i8 < iArr.length; i8++) {
                int i9 = iArr[i8];
                int i10 = i8 - 1;
                connect(iArr[i8], i6, iArr[i10], i7, -1);
                connect(iArr[i10], i7, iArr[i8], i6, -1);
                if (fArr != null) {
                    get(iArr[i8]).layout.horizontalWeight = fArr[i8];
                }
            }
            connect(iArr[iArr.length - 1], i7, i3, i4, -1);
            return;
        }
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }

    private Constraint fillFromAttributeList(Context context, AttributeSet attributeSet) {
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0186R.styleable.Constraint);
        populateConstraint(context, constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private Constraint get(int i) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i))) {
            this.mConstraints.put(Integer.valueOf(i), new Constraint());
        }
        return this.mConstraints.get(Integer.valueOf(i));
    }

    public static int lookupID(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    private void populateConstraint(Context context, Constraint constraint, TypedArray typedArray) {
        Motion motion;
        String str;
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index != C0186R.styleable.Constraint_android_id && C0186R.styleable.Constraint_android_layout_marginStart != index && C0186R.styleable.Constraint_android_layout_marginEnd != index) {
                constraint.motion.mApply = true;
                constraint.layout.mApply = true;
                constraint.propertySet.mApply = true;
                constraint.transform.mApply = true;
            }
            switch (mapToConstant.get(index)) {
                case 1:
                    Layout layout = constraint.layout;
                    layout.baselineToBaseline = lookupID(typedArray, index, layout.baselineToBaseline);
                    break;
                case 2:
                    Layout layout2 = constraint.layout;
                    layout2.bottomMargin = typedArray.getDimensionPixelSize(index, layout2.bottomMargin);
                    break;
                case 3:
                    Layout layout3 = constraint.layout;
                    layout3.bottomToBottom = lookupID(typedArray, index, layout3.bottomToBottom);
                    break;
                case 4:
                    Layout layout4 = constraint.layout;
                    layout4.bottomToTop = lookupID(typedArray, index, layout4.bottomToTop);
                    break;
                case 5:
                    constraint.layout.dimensionRatio = typedArray.getString(index);
                    break;
                case 6:
                    Layout layout5 = constraint.layout;
                    layout5.editorAbsoluteX = typedArray.getDimensionPixelOffset(index, layout5.editorAbsoluteX);
                    break;
                case 7:
                    Layout layout6 = constraint.layout;
                    layout6.editorAbsoluteY = typedArray.getDimensionPixelOffset(index, layout6.editorAbsoluteY);
                    break;
                case 8:
                    Layout layout7 = constraint.layout;
                    layout7.endMargin = typedArray.getDimensionPixelSize(index, layout7.endMargin);
                    break;
                case 9:
                    Layout layout8 = constraint.layout;
                    layout8.endToEnd = lookupID(typedArray, index, layout8.endToEnd);
                    break;
                case 10:
                    Layout layout9 = constraint.layout;
                    layout9.endToStart = lookupID(typedArray, index, layout9.endToStart);
                    break;
                case 11:
                    Layout layout10 = constraint.layout;
                    layout10.goneBottomMargin = typedArray.getDimensionPixelSize(index, layout10.goneBottomMargin);
                    break;
                case 12:
                    Layout layout11 = constraint.layout;
                    layout11.goneEndMargin = typedArray.getDimensionPixelSize(index, layout11.goneEndMargin);
                    break;
                case 13:
                    Layout layout12 = constraint.layout;
                    layout12.goneLeftMargin = typedArray.getDimensionPixelSize(index, layout12.goneLeftMargin);
                    break;
                case 14:
                    Layout layout13 = constraint.layout;
                    layout13.goneRightMargin = typedArray.getDimensionPixelSize(index, layout13.goneRightMargin);
                    break;
                case 15:
                    Layout layout14 = constraint.layout;
                    layout14.goneStartMargin = typedArray.getDimensionPixelSize(index, layout14.goneStartMargin);
                    break;
                case 16:
                    Layout layout15 = constraint.layout;
                    layout15.goneTopMargin = typedArray.getDimensionPixelSize(index, layout15.goneTopMargin);
                    break;
                case 17:
                    Layout layout16 = constraint.layout;
                    layout16.guideBegin = typedArray.getDimensionPixelOffset(index, layout16.guideBegin);
                    break;
                case 18:
                    Layout layout17 = constraint.layout;
                    layout17.guideEnd = typedArray.getDimensionPixelOffset(index, layout17.guideEnd);
                    break;
                case 19:
                    Layout layout18 = constraint.layout;
                    layout18.guidePercent = typedArray.getFloat(index, layout18.guidePercent);
                    break;
                case 20:
                    Layout layout19 = constraint.layout;
                    layout19.horizontalBias = typedArray.getFloat(index, layout19.horizontalBias);
                    break;
                case 21:
                    Layout layout20 = constraint.layout;
                    layout20.mHeight = typedArray.getLayoutDimension(index, layout20.mHeight);
                    break;
                case 22:
                    PropertySet propertySet = constraint.propertySet;
                    propertySet.visibility = typedArray.getInt(index, propertySet.visibility);
                    PropertySet propertySet2 = constraint.propertySet;
                    propertySet2.visibility = VISIBILITY_FLAGS[propertySet2.visibility];
                    break;
                case 23:
                    Layout layout21 = constraint.layout;
                    layout21.mWidth = typedArray.getLayoutDimension(index, layout21.mWidth);
                    break;
                case 24:
                    Layout layout22 = constraint.layout;
                    layout22.leftMargin = typedArray.getDimensionPixelSize(index, layout22.leftMargin);
                    break;
                case 25:
                    Layout layout23 = constraint.layout;
                    layout23.leftToLeft = lookupID(typedArray, index, layout23.leftToLeft);
                    break;
                case 26:
                    Layout layout24 = constraint.layout;
                    layout24.leftToRight = lookupID(typedArray, index, layout24.leftToRight);
                    break;
                case 27:
                    Layout layout25 = constraint.layout;
                    layout25.orientation = typedArray.getInt(index, layout25.orientation);
                    break;
                case 28:
                    Layout layout26 = constraint.layout;
                    layout26.rightMargin = typedArray.getDimensionPixelSize(index, layout26.rightMargin);
                    break;
                case 29:
                    Layout layout27 = constraint.layout;
                    layout27.rightToLeft = lookupID(typedArray, index, layout27.rightToLeft);
                    break;
                case 30:
                    Layout layout28 = constraint.layout;
                    layout28.rightToRight = lookupID(typedArray, index, layout28.rightToRight);
                    break;
                case 31:
                    Layout layout29 = constraint.layout;
                    layout29.startMargin = typedArray.getDimensionPixelSize(index, layout29.startMargin);
                    break;
                case 32:
                    Layout layout30 = constraint.layout;
                    layout30.startToEnd = lookupID(typedArray, index, layout30.startToEnd);
                    break;
                case 33:
                    Layout layout31 = constraint.layout;
                    layout31.startToStart = lookupID(typedArray, index, layout31.startToStart);
                    break;
                case 34:
                    Layout layout32 = constraint.layout;
                    layout32.topMargin = typedArray.getDimensionPixelSize(index, layout32.topMargin);
                    break;
                case 35:
                    Layout layout33 = constraint.layout;
                    layout33.topToBottom = lookupID(typedArray, index, layout33.topToBottom);
                    break;
                case 36:
                    Layout layout34 = constraint.layout;
                    layout34.topToTop = lookupID(typedArray, index, layout34.topToTop);
                    break;
                case 37:
                    Layout layout35 = constraint.layout;
                    layout35.verticalBias = typedArray.getFloat(index, layout35.verticalBias);
                    break;
                case 38:
                    constraint.mViewId = typedArray.getResourceId(index, constraint.mViewId);
                    break;
                case 39:
                    Layout layout36 = constraint.layout;
                    layout36.horizontalWeight = typedArray.getFloat(index, layout36.horizontalWeight);
                    break;
                case 40:
                    Layout layout37 = constraint.layout;
                    layout37.verticalWeight = typedArray.getFloat(index, layout37.verticalWeight);
                    break;
                case 41:
                    Layout layout38 = constraint.layout;
                    layout38.horizontalChainStyle = typedArray.getInt(index, layout38.horizontalChainStyle);
                    break;
                case 42:
                    Layout layout39 = constraint.layout;
                    layout39.verticalChainStyle = typedArray.getInt(index, layout39.verticalChainStyle);
                    break;
                case 43:
                    PropertySet propertySet3 = constraint.propertySet;
                    propertySet3.alpha = typedArray.getFloat(index, propertySet3.alpha);
                    break;
                case 44:
                    Transform transform = constraint.transform;
                    transform.applyElevation = true;
                    transform.elevation = typedArray.getDimension(index, transform.elevation);
                    break;
                case 45:
                    Transform transform2 = constraint.transform;
                    transform2.rotationX = typedArray.getFloat(index, transform2.rotationX);
                    break;
                case 46:
                    Transform transform3 = constraint.transform;
                    transform3.rotationY = typedArray.getFloat(index, transform3.rotationY);
                    break;
                case 47:
                    Transform transform4 = constraint.transform;
                    transform4.scaleX = typedArray.getFloat(index, transform4.scaleX);
                    break;
                case 48:
                    Transform transform5 = constraint.transform;
                    transform5.scaleY = typedArray.getFloat(index, transform5.scaleY);
                    break;
                case 49:
                    Transform transform6 = constraint.transform;
                    transform6.transformPivotX = typedArray.getDimension(index, transform6.transformPivotX);
                    break;
                case 50:
                    Transform transform7 = constraint.transform;
                    transform7.transformPivotY = typedArray.getDimension(index, transform7.transformPivotY);
                    break;
                case 51:
                    Transform transform8 = constraint.transform;
                    transform8.translationX = typedArray.getDimension(index, transform8.translationX);
                    break;
                case 52:
                    Transform transform9 = constraint.transform;
                    transform9.translationY = typedArray.getDimension(index, transform9.translationY);
                    break;
                case 53:
                    Transform transform10 = constraint.transform;
                    transform10.translationZ = typedArray.getDimension(index, transform10.translationZ);
                    break;
                case 54:
                    Layout layout40 = constraint.layout;
                    layout40.widthDefault = typedArray.getInt(index, layout40.widthDefault);
                    break;
                case 55:
                    Layout layout41 = constraint.layout;
                    layout41.heightDefault = typedArray.getInt(index, layout41.heightDefault);
                    break;
                case 56:
                    Layout layout42 = constraint.layout;
                    layout42.widthMax = typedArray.getDimensionPixelSize(index, layout42.widthMax);
                    break;
                case 57:
                    Layout layout43 = constraint.layout;
                    layout43.heightMax = typedArray.getDimensionPixelSize(index, layout43.heightMax);
                    break;
                case 58:
                    Layout layout44 = constraint.layout;
                    layout44.widthMin = typedArray.getDimensionPixelSize(index, layout44.widthMin);
                    break;
                case 59:
                    Layout layout45 = constraint.layout;
                    layout45.heightMin = typedArray.getDimensionPixelSize(index, layout45.heightMin);
                    break;
                case 60:
                    Transform transform11 = constraint.transform;
                    transform11.rotation = typedArray.getFloat(index, transform11.rotation);
                    break;
                case 61:
                    Layout layout46 = constraint.layout;
                    layout46.circleConstraint = lookupID(typedArray, index, layout46.circleConstraint);
                    break;
                case 62:
                    Layout layout47 = constraint.layout;
                    layout47.circleRadius = typedArray.getDimensionPixelSize(index, layout47.circleRadius);
                    break;
                case 63:
                    Layout layout48 = constraint.layout;
                    layout48.circleAngle = typedArray.getFloat(index, layout48.circleAngle);
                    break;
                case 64:
                    Motion motion2 = constraint.motion;
                    motion2.mAnimateRelativeTo = lookupID(typedArray, index, motion2.mAnimateRelativeTo);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        motion = constraint.motion;
                        str = typedArray.getString(index);
                    } else {
                        motion = constraint.motion;
                        str = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                    }
                    motion.mTransitionEasing = str;
                    break;
                case 66:
                    constraint.motion.mDrawPath = typedArray.getInt(index, 0);
                    break;
                case 67:
                    Motion motion3 = constraint.motion;
                    motion3.mPathRotate = typedArray.getFloat(index, motion3.mPathRotate);
                    break;
                case 68:
                    PropertySet propertySet4 = constraint.propertySet;
                    propertySet4.mProgress = typedArray.getFloat(index, propertySet4.mProgress);
                    break;
                case 69:
                    constraint.layout.widthPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    constraint.layout.heightPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    break;
                case 72:
                    Layout layout49 = constraint.layout;
                    layout49.mBarrierDirection = typedArray.getInt(index, layout49.mBarrierDirection);
                    break;
                case 73:
                    Layout layout50 = constraint.layout;
                    layout50.mBarrierMargin = typedArray.getDimensionPixelSize(index, layout50.mBarrierMargin);
                    break;
                case 74:
                    constraint.layout.mReferenceIdString = typedArray.getString(index);
                    break;
                case 75:
                    Layout layout51 = constraint.layout;
                    layout51.mBarrierAllowsGoneWidgets = typedArray.getBoolean(index, layout51.mBarrierAllowsGoneWidgets);
                    break;
                case 76:
                    Motion motion4 = constraint.motion;
                    motion4.mPathMotionArc = typedArray.getInt(index, motion4.mPathMotionArc);
                    break;
                case 77:
                    constraint.layout.mConstraintTag = typedArray.getString(index);
                    break;
                case 78:
                    PropertySet propertySet5 = constraint.propertySet;
                    propertySet5.mVisibilityMode = typedArray.getInt(index, propertySet5.mVisibilityMode);
                    break;
                case 79:
                    Motion motion5 = constraint.motion;
                    motion5.mMotionStagger = typedArray.getFloat(index, motion5.mMotionStagger);
                    break;
                case 80:
                    Layout layout52 = constraint.layout;
                    layout52.constrainedWidth = typedArray.getBoolean(index, layout52.constrainedWidth);
                    break;
                case 81:
                    Layout layout53 = constraint.layout;
                    layout53.constrainedHeight = typedArray.getBoolean(index, layout53.constrainedHeight);
                    break;
                case 82:
                default:
                    Integer.toHexString(index);
                    mapToConstant.get(index);
                    break;
            }
        }
    }

    private String sideToString(int i) {
        switch (i) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public static String[] splitString(String str) {
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] == ',' && !z) {
                arrayList.add(new String(charArray, i, i2 - i));
                i = i2 + 1;
            } else if (charArray[i2] == '\"') {
                z = !z;
            }
        }
        arrayList.add(new String(charArray, i, charArray.length - i));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void addColorAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, strArr);
    }

    public void addFloatAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, strArr);
    }

    public void addIntAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, strArr);
    }

    public void addStringAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, strArr);
    }

    public void addToHorizontalChain(int i, int i2, int i3) {
        connect(i, 1, i2, i2 == 0 ? 1 : 2, 0);
        connect(i, 2, i3, i3 == 0 ? 2 : 1, 0);
        if (i2 != 0) {
            connect(i2, 2, i, 1, 0);
        }
        if (i3 != 0) {
            connect(i3, 1, i, 2, 0);
        }
    }

    public void addToHorizontalChainRTL(int i, int i2, int i3) {
        connect(i, 6, i2, i2 == 0 ? 6 : 7, 0);
        connect(i, 7, i3, i3 == 0 ? 7 : 6, 0);
        if (i2 != 0) {
            connect(i2, 7, i, 6, 0);
        }
        if (i3 != 0) {
            connect(i3, 6, i, 7, 0);
        }
    }

    public void addToVerticalChain(int i, int i2, int i3) {
        connect(i, 3, i2, i2 == 0 ? 3 : 4, 0);
        connect(i, 4, i3, i3 == 0 ? 4 : 3, 0);
        if (i2 != 0) {
            connect(i2, 4, i, 3, 0);
        }
        if (i3 != 0) {
            connect(i3, 3, i, 4, 0);
        }
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                Debug.getName(childAt);
            } else if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (this.mConstraints.containsKey(Integer.valueOf(id))) {
                    ConstraintAttribute.setAttributes(childAt, this.mConstraints.get(Integer.valueOf(id)).mCustomConstraints);
                }
            }
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void applyToHelper(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        int id = constraintHelper.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(id))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            if (!(constraintWidget instanceof HelperWidget)) {
                return;
            }
            constraintHelper.loadParameters(constraint, (HelperWidget) constraintWidget, layoutParams, sparseArray);
        }
    }

    public void applyToInternal(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.mConstraints.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                Debug.getName(childAt);
            } else if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (id != -1 && this.mConstraints.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                    if (childAt instanceof Barrier) {
                        constraint.layout.mHelperType = 1;
                    }
                    int i2 = constraint.layout.mHelperType;
                    if (i2 != -1 && i2 == 1) {
                        Barrier barrier = (Barrier) childAt;
                        barrier.setId(id);
                        barrier.setType(constraint.layout.mBarrierDirection);
                        barrier.setMargin(constraint.layout.mBarrierMargin);
                        barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
                        Layout layout = constraint.layout;
                        int[] iArr = layout.mReferenceIds;
                        if (iArr != null) {
                            barrier.setReferencedIds(iArr);
                        } else {
                            String str = layout.mReferenceIdString;
                            if (str != null) {
                                layout.mReferenceIds = convertReferenceString(barrier, str);
                                barrier.setReferencedIds(constraint.layout.mReferenceIds);
                            }
                        }
                    }
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                    layoutParams.validate();
                    constraint.applyTo(layoutParams);
                    if (z) {
                        ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                    }
                    childAt.setLayoutParams(layoutParams);
                    PropertySet propertySet = constraint.propertySet;
                    if (propertySet.mVisibilityMode == 0) {
                        childAt.setVisibility(propertySet.visibility);
                    }
                    childAt.setAlpha(constraint.propertySet.alpha);
                    childAt.setRotation(constraint.transform.rotation);
                    childAt.setRotationX(constraint.transform.rotationX);
                    childAt.setRotationY(constraint.transform.rotationY);
                    childAt.setScaleX(constraint.transform.scaleX);
                    childAt.setScaleY(constraint.transform.scaleY);
                    if (!Float.isNaN(constraint.transform.transformPivotX)) {
                        childAt.setPivotX(constraint.transform.transformPivotX);
                    }
                    if (!Float.isNaN(constraint.transform.transformPivotY)) {
                        childAt.setPivotY(constraint.transform.transformPivotY);
                    }
                    childAt.setTranslationX(constraint.transform.translationX);
                    childAt.setTranslationY(constraint.transform.translationY);
                    childAt.setTranslationZ(constraint.transform.translationZ);
                    Transform transform = constraint.transform;
                    if (transform.applyElevation) {
                        childAt.setElevation(transform.elevation);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = this.mConstraints.get(num);
            int i3 = constraint2.layout.mHelperType;
            if (i3 != -1 && i3 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                Layout layout2 = constraint2.layout;
                int[] iArr2 = layout2.mReferenceIds;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = layout2.mReferenceIdString;
                    if (str2 != null) {
                        layout2.mReferenceIds = convertReferenceString(barrier2, str2);
                        barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                    }
                }
                barrier2.setType(constraint2.layout.mBarrierDirection);
                barrier2.setMargin(constraint2.layout.mBarrierMargin);
                ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.validateParams();
                constraint2.applyTo(generateDefaultLayoutParams);
                constraintLayout.addView(barrier2, generateDefaultLayoutParams);
            }
            if (constraint2.layout.mIsGuideline) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                constraint2.applyTo(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    public void applyToLayoutParams(int i, ConstraintLayout.LayoutParams layoutParams) {
        if (this.mConstraints.containsKey(Integer.valueOf(i))) {
            this.mConstraints.get(Integer.valueOf(i)).applyTo(layoutParams);
        }
    }

    public void applyToWithoutCustom(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, false);
        constraintLayout.setConstraintSet(null);
    }

    public void center(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        ConstraintSet constraintSet;
        int i8;
        int i9;
        if (i4 >= 0) {
            if (i7 < 0) {
                throw new IllegalArgumentException("margin must be > 0");
            }
            if (f <= 0.0f || f > 1.0f) {
                throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
            }
            if (i3 == 1 || i3 == 2) {
                constraintSet = this;
                i8 = i;
                constraintSet.connect(i8, 1, i2, i3, i4);
                i9 = 2;
            } else if (i3 != 6 && i3 != 7) {
                connect(i, 3, i2, i3, i4);
                connect(i, 4, i5, i6, i7);
                this.mConstraints.get(Integer.valueOf(i)).layout.verticalBias = f;
                return;
            } else {
                constraintSet = this;
                i8 = i;
                constraintSet.connect(i8, 6, i2, i3, i4);
                i9 = 7;
            }
            constraintSet.connect(i8, i9, i5, i6, i7);
            this.mConstraints.get(Integer.valueOf(i)).layout.horizontalBias = f;
            return;
        }
        throw new IllegalArgumentException("margin must be > 0");
    }

    public void centerHorizontally(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        float f;
        ConstraintSet constraintSet;
        int i7;
        int i8;
        int i9;
        if (i2 == 0) {
            i8 = 0;
            i3 = 1;
            i4 = 0;
            i9 = 0;
            i5 = 2;
            i6 = 0;
            f = 0.5f;
            constraintSet = this;
            i7 = i;
        } else {
            i3 = 2;
            i4 = 0;
            i5 = 1;
            i6 = 0;
            f = 0.5f;
            constraintSet = this;
            i7 = i;
            i8 = i2;
            i9 = i2;
        }
        constraintSet.center(i7, i8, i3, i4, i9, i5, i6, f);
    }

    public void centerHorizontally(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 1, i2, i3, i4);
        connect(i, 2, i5, i6, i7);
        this.mConstraints.get(Integer.valueOf(i)).layout.horizontalBias = f;
    }

    public void centerHorizontallyRtl(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        float f;
        ConstraintSet constraintSet;
        int i7;
        int i8;
        int i9;
        if (i2 == 0) {
            i8 = 0;
            i3 = 6;
            i4 = 0;
            i9 = 0;
            i5 = 7;
            i6 = 0;
            f = 0.5f;
            constraintSet = this;
            i7 = i;
        } else {
            i3 = 7;
            i4 = 0;
            i5 = 6;
            i6 = 0;
            f = 0.5f;
            constraintSet = this;
            i7 = i;
            i8 = i2;
            i9 = i2;
        }
        constraintSet.center(i7, i8, i3, i4, i9, i5, i6, f);
    }

    public void centerHorizontallyRtl(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 6, i2, i3, i4);
        connect(i, 7, i5, i6, i7);
        this.mConstraints.get(Integer.valueOf(i)).layout.horizontalBias = f;
    }

    public void centerVertically(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        float f;
        ConstraintSet constraintSet;
        int i7;
        int i8;
        int i9;
        if (i2 == 0) {
            i8 = 0;
            i3 = 3;
            i4 = 0;
            i9 = 0;
            i5 = 4;
            i6 = 0;
            f = 0.5f;
            constraintSet = this;
            i7 = i;
        } else {
            i3 = 4;
            i4 = 0;
            i5 = 3;
            i6 = 0;
            f = 0.5f;
            constraintSet = this;
            i7 = i;
            i8 = i2;
            i9 = i2;
        }
        constraintSet.center(i7, i8, i3, i4, i9, i5, i6, f);
    }

    public void centerVertically(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 3, i2, i3, i4);
        connect(i, 4, i5, i6, i7);
        this.mConstraints.get(Integer.valueOf(i)).layout.verticalBias = f;
    }

    public void clear(int i) {
        this.mConstraints.remove(Integer.valueOf(i));
    }

    public void clear(int i, int i2) {
        if (this.mConstraints.containsKey(Integer.valueOf(i))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
            switch (i2) {
                case 1:
                    Layout layout = constraint.layout;
                    layout.leftToRight = -1;
                    layout.leftToLeft = -1;
                    layout.leftMargin = -1;
                    layout.goneLeftMargin = -1;
                    return;
                case 2:
                    Layout layout2 = constraint.layout;
                    layout2.rightToRight = -1;
                    layout2.rightToLeft = -1;
                    layout2.rightMargin = -1;
                    layout2.goneRightMargin = -1;
                    return;
                case 3:
                    Layout layout3 = constraint.layout;
                    layout3.topToBottom = -1;
                    layout3.topToTop = -1;
                    layout3.topMargin = -1;
                    layout3.goneTopMargin = -1;
                    return;
                case 4:
                    Layout layout4 = constraint.layout;
                    layout4.bottomToTop = -1;
                    layout4.bottomToBottom = -1;
                    layout4.bottomMargin = -1;
                    layout4.goneBottomMargin = -1;
                    return;
                case 5:
                    constraint.layout.baselineToBaseline = -1;
                    return;
                case 6:
                    Layout layout5 = constraint.layout;
                    layout5.startToEnd = -1;
                    layout5.startToStart = -1;
                    layout5.startMargin = -1;
                    layout5.goneStartMargin = -1;
                    return;
                case 7:
                    Layout layout6 = constraint.layout;
                    layout6.endToStart = -1;
                    layout6.endToEnd = -1;
                    layout6.endMargin = -1;
                    layout6.goneEndMargin = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void clone(Context context, int i) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(i, (ViewGroup) null));
    }

    public void clone(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.mConstraints.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                this.mConstraints.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            constraint.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, childAt);
            constraint.fillFrom(id, layoutParams);
            constraint.propertySet.visibility = childAt.getVisibility();
            constraint.propertySet.alpha = childAt.getAlpha();
            constraint.transform.rotation = childAt.getRotation();
            constraint.transform.rotationX = childAt.getRotationX();
            constraint.transform.rotationY = childAt.getRotationY();
            constraint.transform.scaleX = childAt.getScaleX();
            constraint.transform.scaleY = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != RoundRectDrawableWithShadow.COS_45 || pivotY != RoundRectDrawableWithShadow.COS_45) {
                Transform transform = constraint.transform;
                transform.transformPivotX = pivotX;
                transform.transformPivotY = pivotY;
            }
            constraint.transform.translationX = childAt.getTranslationX();
            constraint.transform.translationY = childAt.getTranslationY();
            constraint.transform.translationZ = childAt.getTranslationZ();
            Transform transform2 = constraint.transform;
            if (transform2.applyElevation) {
                transform2.elevation = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                constraint.layout.mBarrierAllowsGoneWidgets = barrier.allowsGoneWidget();
                constraint.layout.mReferenceIds = barrier.getReferencedIds();
                constraint.layout.mBarrierDirection = barrier.getType();
                constraint.layout.mBarrierMargin = barrier.getMargin();
            }
        }
    }

    public void clone(ConstraintSet constraintSet) {
        this.mConstraints.clear();
        for (Integer num : constraintSet.mConstraints.keySet()) {
            this.mConstraints.put(num, constraintSet.mConstraints.get(num).m4298clone());
        }
    }

    public void clone(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.mConstraints.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraints.getChildAt(i);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                this.mConstraints.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            if (childAt instanceof ConstraintHelper) {
                constraint.fillFromConstraints((ConstraintHelper) childAt, id, layoutParams);
            }
            constraint.fillFromConstraints(id, layoutParams);
        }
    }

    public void connect(int i, int i2, int i3, int i4) {
        Layout layout;
        if (!this.mConstraints.containsKey(Integer.valueOf(i))) {
            this.mConstraints.put(Integer.valueOf(i), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    Layout layout2 = constraint.layout;
                    layout2.leftToLeft = i3;
                    layout2.leftToRight = -1;
                    return;
                } else if (i4 != 2) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("left to "), sideToString(i4), " undefined"));
                } else {
                    Layout layout3 = constraint.layout;
                    layout3.leftToRight = i3;
                    layout3.leftToLeft = -1;
                    return;
                }
            case 2:
                if (i4 == 1) {
                    Layout layout4 = constraint.layout;
                    layout4.rightToLeft = i3;
                    layout4.rightToRight = -1;
                    return;
                } else if (i4 != 2) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("right to "), sideToString(i4), " undefined"));
                } else {
                    Layout layout5 = constraint.layout;
                    layout5.rightToRight = i3;
                    layout5.rightToLeft = -1;
                    return;
                }
            case 3:
                if (i4 == 3) {
                    layout = constraint.layout;
                    layout.topToTop = i3;
                    layout.topToBottom = -1;
                    break;
                } else if (i4 != 4) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("right to "), sideToString(i4), " undefined"));
                } else {
                    layout = constraint.layout;
                    layout.topToBottom = i3;
                    layout.topToTop = -1;
                    break;
                }
            case 4:
                if (i4 == 4) {
                    layout = constraint.layout;
                    layout.bottomToBottom = i3;
                    layout.bottomToTop = -1;
                    break;
                } else if (i4 != 3) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("right to "), sideToString(i4), " undefined"));
                } else {
                    layout = constraint.layout;
                    layout.bottomToTop = i3;
                    layout.bottomToBottom = -1;
                    break;
                }
            case 5:
                if (i4 != 5) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("right to "), sideToString(i4), " undefined"));
                }
                Layout layout6 = constraint.layout;
                layout6.baselineToBaseline = i3;
                layout6.bottomToBottom = -1;
                layout6.bottomToTop = -1;
                layout6.topToTop = -1;
                layout6.topToBottom = -1;
                return;
            case 6:
                if (i4 == 6) {
                    Layout layout7 = constraint.layout;
                    layout7.startToStart = i3;
                    layout7.startToEnd = -1;
                    return;
                } else if (i4 != 7) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("right to "), sideToString(i4), " undefined"));
                } else {
                    Layout layout8 = constraint.layout;
                    layout8.startToEnd = i3;
                    layout8.startToStart = -1;
                    return;
                }
            case 7:
                if (i4 == 7) {
                    Layout layout9 = constraint.layout;
                    layout9.endToEnd = i3;
                    layout9.endToStart = -1;
                    return;
                } else if (i4 != 6) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("right to "), sideToString(i4), " undefined"));
                } else {
                    Layout layout10 = constraint.layout;
                    layout10.endToStart = i3;
                    layout10.endToEnd = -1;
                    return;
                }
            default:
                StringBuilder sb = new StringBuilder();
                sb.append(sideToString(i2));
                sb.append(" to ");
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, sideToString(i4), " unknown"));
        }
        layout.baselineToBaseline = -1;
    }

    public void connect(int i, int i2, int i3, int i4, int i5) {
        Layout layout;
        Layout layout2;
        if (!this.mConstraints.containsKey(Integer.valueOf(i))) {
            this.mConstraints.put(Integer.valueOf(i), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.leftToLeft = i3;
                    layout3.leftToRight = -1;
                } else if (i4 != 2) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Left to "), sideToString(i4), " undefined"));
                } else {
                    Layout layout4 = constraint.layout;
                    layout4.leftToRight = i3;
                    layout4.leftToLeft = -1;
                }
                constraint.layout.leftMargin = i5;
                return;
            case 2:
                if (i4 == 1) {
                    Layout layout5 = constraint.layout;
                    layout5.rightToLeft = i3;
                    layout5.rightToRight = -1;
                } else if (i4 != 2) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("right to "), sideToString(i4), " undefined"));
                } else {
                    Layout layout6 = constraint.layout;
                    layout6.rightToRight = i3;
                    layout6.rightToLeft = -1;
                }
                constraint.layout.rightMargin = i5;
                return;
            case 3:
                if (i4 == 3) {
                    layout = constraint.layout;
                    layout.topToTop = i3;
                    layout.topToBottom = -1;
                } else if (i4 != 4) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("right to "), sideToString(i4), " undefined"));
                } else {
                    layout = constraint.layout;
                    layout.topToBottom = i3;
                    layout.topToTop = -1;
                }
                layout.baselineToBaseline = -1;
                constraint.layout.topMargin = i5;
                return;
            case 4:
                if (i4 == 4) {
                    layout2 = constraint.layout;
                    layout2.bottomToBottom = i3;
                    layout2.bottomToTop = -1;
                } else if (i4 != 3) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("right to "), sideToString(i4), " undefined"));
                } else {
                    layout2 = constraint.layout;
                    layout2.bottomToTop = i3;
                    layout2.bottomToBottom = -1;
                }
                layout2.baselineToBaseline = -1;
                constraint.layout.bottomMargin = i5;
                return;
            case 5:
                if (i4 != 5) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("right to "), sideToString(i4), " undefined"));
                }
                Layout layout7 = constraint.layout;
                layout7.baselineToBaseline = i3;
                layout7.bottomToBottom = -1;
                layout7.bottomToTop = -1;
                layout7.topToTop = -1;
                layout7.topToBottom = -1;
                return;
            case 6:
                if (i4 == 6) {
                    Layout layout8 = constraint.layout;
                    layout8.startToStart = i3;
                    layout8.startToEnd = -1;
                } else if (i4 != 7) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("right to "), sideToString(i4), " undefined"));
                } else {
                    Layout layout9 = constraint.layout;
                    layout9.startToEnd = i3;
                    layout9.startToStart = -1;
                }
                constraint.layout.startMargin = i5;
                return;
            case 7:
                if (i4 == 7) {
                    Layout layout10 = constraint.layout;
                    layout10.endToEnd = i3;
                    layout10.endToStart = -1;
                } else if (i4 != 6) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("right to "), sideToString(i4), " undefined"));
                } else {
                    Layout layout11 = constraint.layout;
                    layout11.endToStart = i3;
                    layout11.endToEnd = -1;
                }
                constraint.layout.endMargin = i5;
                return;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append(sideToString(i2));
                sb.append(" to ");
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, sideToString(i4), " unknown"));
        }
    }

    public void constrainCircle(int i, int i2, int i3, float f) {
        Layout layout = get(i).layout;
        layout.circleConstraint = i2;
        layout.circleRadius = i3;
        layout.circleAngle = f;
    }

    public void constrainDefaultHeight(int i, int i2) {
        get(i).layout.heightDefault = i2;
    }

    public void constrainDefaultWidth(int i, int i2) {
        get(i).layout.widthDefault = i2;
    }

    public void constrainHeight(int i, int i2) {
        get(i).layout.mHeight = i2;
    }

    public void constrainMaxHeight(int i, int i2) {
        get(i).layout.heightMax = i2;
    }

    public void constrainMaxWidth(int i, int i2) {
        get(i).layout.widthMax = i2;
    }

    public void constrainMinHeight(int i, int i2) {
        get(i).layout.heightMin = i2;
    }

    public void constrainMinWidth(int i, int i2) {
        get(i).layout.widthMin = i2;
    }

    public void constrainPercentHeight(int i, float f) {
        get(i).layout.heightPercent = f;
    }

    public void constrainPercentWidth(int i, float f) {
        get(i).layout.widthPercent = f;
    }

    public void constrainWidth(int i, int i2) {
        get(i).layout.mWidth = i2;
    }

    public void constrainedHeight(int i, boolean z) {
        get(i).layout.constrainedHeight = z;
    }

    public void constrainedWidth(int i, boolean z) {
        get(i).layout.constrainedWidth = z;
    }

    public void create(int i, int i2) {
        Layout layout = get(i).layout;
        layout.mIsGuideline = true;
        layout.orientation = i2;
    }

    public void createBarrier(int i, int i2, int i3, int... iArr) {
        Layout layout = get(i).layout;
        layout.mHelperType = 1;
        layout.mBarrierDirection = i2;
        layout.mBarrierMargin = i3;
        layout.mIsGuideline = false;
        layout.mReferenceIds = iArr;
    }

    public void createHorizontalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        createHorizontalChain(i, i2, i3, i4, iArr, fArr, i5, 1, 2);
    }

    public void createHorizontalChainRtl(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        createHorizontalChain(i, i2, i3, i4, iArr, fArr, i5, 6, 7);
    }

    public void createVerticalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        if (iArr.length >= 2) {
            if (fArr != null && fArr.length != iArr.length) {
                throw new IllegalArgumentException("must have 2 or more widgets in a chain");
            }
            if (fArr != null) {
                get(iArr[0]).layout.verticalWeight = fArr[0];
            }
            get(iArr[0]).layout.verticalChainStyle = i5;
            connect(iArr[0], 3, i, i2, 0);
            for (int i6 = 1; i6 < iArr.length; i6++) {
                int i7 = iArr[i6];
                int i8 = i6 - 1;
                connect(iArr[i6], 3, iArr[i8], 4, 0);
                connect(iArr[i8], 4, iArr[i6], 3, 0);
                if (fArr != null) {
                    get(iArr[i6]).layout.verticalWeight = fArr[i6];
                }
            }
            connect(iArr[iArr.length - 1], 4, i3, i4, 0);
            return;
        }
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }

    public void dump(MotionScene motionScene, int... iArr) {
        HashSet hashSet;
        Integer[] numArr;
        Set<Integer> keySet = this.mConstraints.keySet();
        if (iArr.length != 0) {
            hashSet = new HashSet();
            for (int i : iArr) {
                hashSet.add(Integer.valueOf(i));
            }
        } else {
            hashSet = new HashSet(keySet);
        }
        System.out.println(hashSet.size() + " constraints");
        StringBuilder sb = new StringBuilder();
        for (Integer num : (Integer[]) hashSet.toArray(new Integer[0])) {
            sb.append("<Constraint id=");
            sb.append(num);
            sb.append(" \n");
            this.mConstraints.get(num).layout.dump(motionScene, sb);
            sb.append("/>\n");
        }
        System.out.println(sb.toString());
    }

    public boolean getApplyElevation(int i) {
        return get(i).transform.applyElevation;
    }

    public Constraint getConstraint(int i) {
        if (this.mConstraints.containsKey(Integer.valueOf(i))) {
            return this.mConstraints.get(Integer.valueOf(i));
        }
        return null;
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public int getHeight(int i) {
        return get(i).layout.mHeight;
    }

    public int[] getKnownIds() {
        Integer[] numArr = (Integer[]) this.mConstraints.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    public Constraint getParameters(int i) {
        return get(i);
    }

    public int[] getReferencedIds(int i) {
        int[] iArr = get(i).layout.mReferenceIds;
        return iArr == null ? new int[0] : Arrays.copyOf(iArr, iArr.length);
    }

    public int getVisibility(int i) {
        return get(i).propertySet.visibility;
    }

    public int getVisibilityMode(int i) {
        return get(i).propertySet.mVisibilityMode;
    }

    public int getWidth(int i) {
        return get(i).layout.mWidth;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    public void load(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    Constraint fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        fillFromAttributeList.layout.mIsGuideline = true;
                    }
                    this.mConstraints.put(Integer.valueOf(fillFromAttributeList.mViewId), fillFromAttributeList);
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x017b, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void load(Context context, XmlPullParser xmlPullParser) {
        Constraint fillFromAttributeList;
        try {
            int eventType = xmlPullParser.getEventType();
            Constraint constraint = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    char c = 3;
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        switch (name.hashCode()) {
                            case -2025855158:
                                if (name.equals("Layout")) {
                                    c = 5;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1984451626:
                                if (name.equals("Motion")) {
                                    c = 6;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1269513683:
                                if (name.equals("PropertySet")) {
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1238332596:
                                if (name.equals("Transform")) {
                                    c = 4;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -71750448:
                                if (name.equals("Guideline")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1331510167:
                                if (name.equals("Barrier")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1791837707:
                                if (name.equals("CustomAttribute")) {
                                    c = 7;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1803088381:
                                if (name.equals("Constraint")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                                fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                constraint = fillFromAttributeList;
                                break;
                            case 1:
                                fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                fillFromAttributeList.layout.mIsGuideline = true;
                                fillFromAttributeList.layout.mApply = true;
                                constraint = fillFromAttributeList;
                                break;
                            case 2:
                                fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                fillFromAttributeList.layout.mHelperType = 1;
                                constraint = fillFromAttributeList;
                                break;
                            case 3:
                                if (constraint == null) {
                                    throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                                constraint.propertySet.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            case 4:
                                if (constraint == null) {
                                    throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                                constraint.transform.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            case 5:
                                if (constraint == null) {
                                    throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                                constraint.layout.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            case 6:
                                if (constraint == null) {
                                    throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                                constraint.motion.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            case 7:
                                if (constraint == null) {
                                    throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                                ConstraintAttribute.parse(context, xmlPullParser, constraint.mCustomConstraints);
                                break;
                        }
                    } else if (eventType != 3) {
                        continue;
                    } else {
                        String name2 = xmlPullParser.getName();
                        if (TAG.equals(name2)) {
                            return;
                        }
                        if (name2.equalsIgnoreCase("Constraint")) {
                            this.mConstraints.put(Integer.valueOf(constraint.mViewId), constraint);
                            constraint = null;
                        }
                    }
                } else {
                    xmlPullParser.getName();
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    public void parseColorAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].split("=");
            if (split2.length != 2) {
                String str2 = split[i];
            } else {
                constraint.setColorValue(split2[0], Color.parseColor(split2[1]));
            }
        }
    }

    public void parseFloatAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].split("=");
            if (split2.length != 2) {
                String str2 = split[i];
            } else {
                constraint.setFloatValue(split2[0], Float.parseFloat(split2[1]));
            }
        }
    }

    public void parseIntAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].split("=");
            if (split2.length != 2) {
                String str2 = split[i];
            } else {
                constraint.setFloatValue(split2[0], Integer.decode(split2[1]).intValue());
            }
        }
    }

    public void parseStringAttributes(Constraint constraint, String str) {
        String[] splitString = splitString(str);
        for (int i = 0; i < splitString.length; i++) {
            String[] split = splitString[i].split("=");
            String str2 = splitString[i];
            constraint.setStringValue(split[0], split[1]);
        }
    }

    public void readFallback(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                this.mConstraints.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            if (!constraint.layout.mApply) {
                constraint.fillFrom(id, layoutParams);
                if (childAt instanceof ConstraintHelper) {
                    constraint.layout.mReferenceIds = ((ConstraintHelper) childAt).getReferencedIds();
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        constraint.layout.mBarrierAllowsGoneWidgets = barrier.allowsGoneWidget();
                        constraint.layout.mBarrierDirection = barrier.getType();
                        constraint.layout.mBarrierMargin = barrier.getMargin();
                    }
                }
                constraint.layout.mApply = true;
            }
            PropertySet propertySet = constraint.propertySet;
            if (!propertySet.mApply) {
                propertySet.visibility = childAt.getVisibility();
                constraint.propertySet.alpha = childAt.getAlpha();
                constraint.propertySet.mApply = true;
            }
            Transform transform = constraint.transform;
            if (!transform.mApply) {
                transform.mApply = true;
                transform.rotation = childAt.getRotation();
                constraint.transform.rotationX = childAt.getRotationX();
                constraint.transform.rotationY = childAt.getRotationY();
                constraint.transform.scaleX = childAt.getScaleX();
                constraint.transform.scaleY = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != RoundRectDrawableWithShadow.COS_45 || pivotY != RoundRectDrawableWithShadow.COS_45) {
                    Transform transform2 = constraint.transform;
                    transform2.transformPivotX = pivotX;
                    transform2.transformPivotY = pivotY;
                }
                constraint.transform.translationX = childAt.getTranslationX();
                constraint.transform.translationY = childAt.getTranslationY();
                constraint.transform.translationZ = childAt.getTranslationZ();
                Transform transform3 = constraint.transform;
                if (transform3.applyElevation) {
                    transform3.elevation = childAt.getElevation();
                }
            }
        }
    }

    public void readFallback(ConstraintSet constraintSet) {
        for (Integer num : constraintSet.mConstraints.keySet()) {
            int intValue = num.intValue();
            Constraint constraint = constraintSet.mConstraints.get(num);
            if (!this.mConstraints.containsKey(Integer.valueOf(intValue))) {
                this.mConstraints.put(Integer.valueOf(intValue), new Constraint());
            }
            Constraint constraint2 = this.mConstraints.get(Integer.valueOf(intValue));
            Layout layout = constraint2.layout;
            if (!layout.mApply) {
                layout.copyFrom(constraint.layout);
            }
            PropertySet propertySet = constraint2.propertySet;
            if (!propertySet.mApply) {
                propertySet.copyFrom(constraint.propertySet);
            }
            Transform transform = constraint2.transform;
            if (!transform.mApply) {
                transform.copyFrom(constraint.transform);
            }
            Motion motion = constraint2.motion;
            if (!motion.mApply) {
                motion.copyFrom(constraint.motion);
            }
            for (String str : constraint.mCustomConstraints.keySet()) {
                if (!constraint2.mCustomConstraints.containsKey(str)) {
                    constraint2.mCustomConstraints.put(str, constraint.mCustomConstraints.get(str));
                }
            }
        }
    }

    public void removeAttribute(String str) {
        this.mSavedAttributes.remove(str);
    }

    public void removeFromHorizontalChain(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        ConstraintSet constraintSet;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        ConstraintSet constraintSet2;
        int i12;
        if (this.mConstraints.containsKey(Integer.valueOf(i))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
            Layout layout = constraint.layout;
            int i13 = layout.leftToRight;
            int i14 = layout.rightToLeft;
            if (i13 == -1 && i14 == -1) {
                int i15 = layout.startToEnd;
                int i16 = layout.endToStart;
                if (i15 != -1 || i16 != -1) {
                    if (i15 != -1 && i16 != -1) {
                        i11 = 0;
                        constraintSet2 = this;
                        constraintSet2.connect(i15, 7, i16, 6, 0);
                        i9 = 6;
                        i10 = 7;
                        i12 = i16;
                        i8 = i13;
                    } else if (i13 != -1 || i16 != -1) {
                        Layout layout2 = constraint.layout;
                        i8 = layout2.rightToRight;
                        if (i8 != -1) {
                            i9 = 7;
                            i10 = 7;
                            i11 = 0;
                            constraintSet2 = this;
                            i12 = i13;
                        } else {
                            i8 = layout2.leftToLeft;
                            if (i8 != -1) {
                                i9 = 6;
                                i10 = 6;
                                i11 = 0;
                                constraintSet2 = this;
                                i12 = i16;
                            }
                        }
                    }
                    constraintSet2.connect(i12, i9, i8, i10, i11);
                }
                clear(i, 6);
                i7 = 7;
            } else {
                if (i13 == -1 || i14 == -1) {
                    if (i13 != -1 || i14 != -1) {
                        Layout layout3 = constraint.layout;
                        i2 = layout3.rightToRight;
                        if (i2 != -1) {
                            i3 = 2;
                            i4 = 2;
                            i5 = 0;
                            constraintSet = this;
                            i6 = i13;
                        } else {
                            i2 = layout3.leftToLeft;
                            if (i2 != -1) {
                                i3 = 1;
                                i4 = 1;
                                i5 = 0;
                                constraintSet = this;
                                i6 = i14;
                            }
                        }
                    }
                    clear(i, 1);
                    i7 = 2;
                } else {
                    i5 = 0;
                    constraintSet = this;
                    constraintSet.connect(i13, 2, i14, 1, 0);
                    i3 = 1;
                    i4 = 2;
                    i6 = i14;
                    i2 = i13;
                }
                constraintSet.connect(i6, i3, i2, i4, i5);
                clear(i, 1);
                i7 = 2;
            }
            clear(i, i7);
        }
    }

    public void removeFromVerticalChain(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        ConstraintSet constraintSet;
        int i6;
        if (this.mConstraints.containsKey(Integer.valueOf(i))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
            Layout layout = constraint.layout;
            int i7 = layout.topToBottom;
            int i8 = layout.bottomToTop;
            if (i7 != -1 || i8 != -1) {
                if (i7 != -1 && i8 != -1) {
                    i5 = 0;
                    constraintSet = this;
                    constraintSet.connect(i7, 4, i8, 3, 0);
                    i3 = 3;
                    i4 = 4;
                    i6 = i8;
                    i2 = i7;
                } else if (i7 != -1 || i8 != -1) {
                    Layout layout2 = constraint.layout;
                    i2 = layout2.bottomToBottom;
                    if (i2 != -1) {
                        i3 = 4;
                        i4 = 4;
                        i5 = 0;
                        constraintSet = this;
                        i6 = i7;
                    } else {
                        i2 = layout2.topToTop;
                        if (i2 != -1) {
                            i3 = 3;
                            i4 = 3;
                            i5 = 0;
                            constraintSet = this;
                            i6 = i8;
                        }
                    }
                }
                constraintSet.connect(i6, i3, i2, i4, i5);
            }
        }
        clear(i, 3);
        clear(i, 4);
    }

    public void setAlpha(int i, float f) {
        get(i).propertySet.alpha = f;
    }

    public void setApplyElevation(int i, boolean z) {
        get(i).transform.applyElevation = z;
    }

    public void setBarrierType(int i, int i2) {
        get(i).layout.mHelperType = i2;
    }

    public void setColorValue(int i, String str, int i2) {
        get(i).setColorValue(str, i2);
    }

    public void setDimensionRatio(int i, String str) {
        get(i).layout.dimensionRatio = str;
    }

    public void setEditorAbsoluteX(int i, int i2) {
        get(i).layout.editorAbsoluteX = i2;
    }

    public void setEditorAbsoluteY(int i, int i2) {
        get(i).layout.editorAbsoluteY = i2;
    }

    public void setElevation(int i, float f) {
        get(i).transform.elevation = f;
        get(i).transform.applyElevation = true;
    }

    public void setFloatValue(int i, String str, float f) {
        get(i).setFloatValue(str, f);
    }

    public void setForceId(boolean z) {
        this.mForceId = z;
    }

    public void setGoneMargin(int i, int i2, int i3) {
        Constraint constraint = get(i);
        switch (i2) {
            case 1:
                constraint.layout.goneLeftMargin = i3;
                return;
            case 2:
                constraint.layout.goneRightMargin = i3;
                return;
            case 3:
                constraint.layout.goneTopMargin = i3;
                return;
            case 4:
                constraint.layout.goneBottomMargin = i3;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                constraint.layout.goneStartMargin = i3;
                return;
            case 7:
                constraint.layout.goneEndMargin = i3;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setGuidelineBegin(int i, int i2) {
        get(i).layout.guideBegin = i2;
        get(i).layout.guideEnd = -1;
        get(i).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int i, int i2) {
        get(i).layout.guideEnd = i2;
        get(i).layout.guideBegin = -1;
        get(i).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int i, float f) {
        get(i).layout.guidePercent = f;
        get(i).layout.guideEnd = -1;
        get(i).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int i, float f) {
        get(i).layout.horizontalBias = f;
    }

    public void setHorizontalChainStyle(int i, int i2) {
        get(i).layout.horizontalChainStyle = i2;
    }

    public void setHorizontalWeight(int i, float f) {
        get(i).layout.horizontalWeight = f;
    }

    public void setIntValue(int i, String str, int i2) {
        get(i).setIntValue(str, i2);
    }

    public void setMargin(int i, int i2, int i3) {
        Constraint constraint = get(i);
        switch (i2) {
            case 1:
                constraint.layout.leftMargin = i3;
                return;
            case 2:
                constraint.layout.rightMargin = i3;
                return;
            case 3:
                constraint.layout.topMargin = i3;
                return;
            case 4:
                constraint.layout.bottomMargin = i3;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                constraint.layout.startMargin = i3;
                return;
            case 7:
                constraint.layout.endMargin = i3;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setReferencedIds(int i, int... iArr) {
        get(i).layout.mReferenceIds = iArr;
    }

    public void setRotation(int i, float f) {
        get(i).transform.rotation = f;
    }

    public void setRotationX(int i, float f) {
        get(i).transform.rotationX = f;
    }

    public void setRotationY(int i, float f) {
        get(i).transform.rotationY = f;
    }

    public void setScaleX(int i, float f) {
        get(i).transform.scaleX = f;
    }

    public void setScaleY(int i, float f) {
        get(i).transform.scaleY = f;
    }

    public void setStringValue(int i, String str, String str2) {
        get(i).setStringValue(str, str2);
    }

    public void setTransformPivot(int i, float f, float f2) {
        Transform transform = get(i).transform;
        transform.transformPivotY = f2;
        transform.transformPivotX = f;
    }

    public void setTransformPivotX(int i, float f) {
        get(i).transform.transformPivotX = f;
    }

    public void setTransformPivotY(int i, float f) {
        get(i).transform.transformPivotY = f;
    }

    public void setTranslation(int i, float f, float f2) {
        Transform transform = get(i).transform;
        transform.translationX = f;
        transform.translationY = f2;
    }

    public void setTranslationX(int i, float f) {
        get(i).transform.translationX = f;
    }

    public void setTranslationY(int i, float f) {
        get(i).transform.translationY = f;
    }

    public void setTranslationZ(int i, float f) {
        get(i).transform.translationZ = f;
    }

    public void setValidateOnParse(boolean z) {
        this.mValidate = z;
    }

    public void setVerticalBias(int i, float f) {
        get(i).layout.verticalBias = f;
    }

    public void setVerticalChainStyle(int i, int i2) {
        get(i).layout.verticalChainStyle = i2;
    }

    public void setVerticalWeight(int i, float f) {
        get(i).layout.verticalWeight = f;
    }

    public void setVisibility(int i, int i2) {
        get(i).propertySet.visibility = i2;
    }

    public void setVisibilityMode(int i, int i2) {
        get(i).propertySet.mVisibilityMode = i2;
    }
}

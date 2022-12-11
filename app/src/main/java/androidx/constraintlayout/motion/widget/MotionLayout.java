package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.C0186R;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.view.NestedScrollingParent3;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    public static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    public static final int MAX_KEY_FRAMES = 50;
    public static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    public float lastPos;
    public float lastY;
    public DesignTool mDesignTool;
    public DevModeDraw mDevModeDraw;
    public int mEndWrapHeight;
    public int mEndWrapWidth;
    public int mHeightMeasureMode;
    public Interpolator mInterpolator;
    public int mLastLayoutHeight;
    public int mLastLayoutWidth;
    public int mOldHeight;
    public int mOldWidth;
    public float mPostInterpolationPosition;
    public MotionScene mScene;
    public float mScrollTargetDT;
    public float mScrollTargetDX;
    public float mScrollTargetDY;
    public long mScrollTargetTime;
    public int mStartWrapHeight;
    public int mStartWrapWidth;
    public StateCache mStateCache;
    public boolean mTransitionInstantly;
    public long mTransitionLastTime;
    public TransitionListener mTransitionListener;
    public int mWidthMeasureMode;
    public float mLastVelocity = 0.0f;
    public int mBeginState = -1;
    public int mCurrentState = -1;
    public int mEndState = -1;
    public int mLastWidthMeasureSpec = 0;
    public int mLastHeightMeasureSpec = 0;
    public boolean mInteractionEnabled = true;
    public HashMap<View, MotionController> mFrameArrayList = new HashMap<>();
    public long mAnimationStartTime = 0;
    public float mTransitionDuration = 1.0f;
    public float mTransitionPosition = 0.0f;
    public float mTransitionLastPosition = 0.0f;
    public float mTransitionGoalPosition = 0.0f;
    public boolean mInTransition = false;
    public boolean mIndirectTransition = false;
    public int mDebugPath = 0;
    public boolean mTemporalInterpolator = false;
    public StopLogic mStopLogic = new StopLogic();
    public DecelerateInterpolator mDecelerateLogic = new DecelerateInterpolator();
    public boolean firstDown = true;
    public boolean mUndergoingMotion = false;
    public boolean mKeepAnimating = false;
    public ArrayList<MotionHelper> mOnShowHelpers = null;
    public ArrayList<MotionHelper> mOnHideHelpers = null;
    public ArrayList<TransitionListener> mTransitionListeners = null;
    public int mFrames = 0;
    public long mLastDrawTime = -1;
    public float mLastFps = 0.0f;
    public int mListenerState = 0;
    public float mListenerPosition = 0.0f;
    public boolean mIsAnimating = false;
    public boolean mMeasureDuringTransition = false;
    public KeyCache mKeyCache = new KeyCache();
    public boolean mInLayout = false;
    public TransitionState mTransitionState = TransitionState.UNDEFINED;
    public Model mModel = new Model();
    public boolean mNeedsFireTransitionCompleted = false;
    public RectF mBoundsCheck = new RectF();
    public View mRegionView = null;
    public ArrayList<Integer> mTransitionCompleted = new ArrayList<>();

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$2 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C01632 {

        /* renamed from: $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState */
        public static final /* synthetic */ int[] f27xabc7e4ac;

        static {
            int[] iArr = new int[TransitionState.values().length];
            f27xabc7e4ac = iArr;
            try {
                TransitionState transitionState = TransitionState.UNDEFINED;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f27xabc7e4ac;
                TransitionState transitionState2 = TransitionState.SETUP;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f27xabc7e4ac;
                TransitionState transitionState3 = TransitionState.MOVING;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f27xabc7e4ac;
                TransitionState transitionState4 = TransitionState.FINISHED;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class DecelerateInterpolator extends MotionInterpolator {
        public float maxA;
        public float initalV = 0.0f;
        public float currentP = 0.0f;

        public DecelerateInterpolator() {
        }

        public void config(float f, float f2, float f3) {
            this.initalV = f;
            this.currentP = f2;
            this.maxA = f3;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.initalV;
            if (f2 > 0.0f) {
                float f3 = this.maxA;
                if (f2 / f3 < f) {
                    f = f2 / f3;
                }
                MotionLayout motionLayout = MotionLayout.this;
                float f4 = this.initalV;
                float f5 = this.maxA;
                motionLayout.mLastVelocity = f4 - (f5 * f);
                return ((f4 * f) - (((f5 * f) * f) / 2.0f)) + this.currentP;
            }
            float f6 = this.maxA;
            if ((-f2) / f6 < f) {
                f = (-f2) / f6;
            }
            MotionLayout motionLayout2 = MotionLayout.this;
            float f7 = this.initalV;
            float f8 = this.maxA;
            motionLayout2.mLastVelocity = (f8 * f) + f7;
            return (((f8 * f) * f) / 2.0f) + (f7 * f) + this.currentP;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
        public float getVelocity() {
            return MotionLayout.this.mLastVelocity;
        }
    }

    /* loaded from: classes3.dex */
    public class DevModeDraw {
        public static final int DEBUG_PATH_TICKS_PER_MS = 16;
        public DashPathEffect mDashPathEffect;
        public Paint mFillPaint;
        public int mKeyFrameCount;
        public Paint mPaint;
        public Paint mPaintGraph;
        public Paint mPaintKeyframes;
        public Path mPath;
        public float[] mPoints;
        public int mShadowTranslate;
        public Paint mTextPaint;
        public final int RED_COLOR = -21965;
        public final int KEYFRAME_COLOR = -2067046;
        public final int GRAPH_COLOR = -13391360;
        public final int SHADOW_COLOR = 1996488704;
        public final int DIAMOND_SIZE = 10;
        public Rect mBounds = new Rect();
        public boolean mPresentationMode = false;
        public float[] mRectangle = new float[8];
        public float[] mKeyFramePoints = new float[100];
        public int[] mPathMode = new int[50];

        public DevModeDraw() {
            this.mShadowTranslate = 1;
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(-21965);
            this.mPaint.setStrokeWidth(2.0f);
            this.mPaint.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.mPaintKeyframes = paint2;
            paint2.setAntiAlias(true);
            this.mPaintKeyframes.setColor(-2067046);
            this.mPaintKeyframes.setStrokeWidth(2.0f);
            this.mPaintKeyframes.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.mPaintGraph = paint3;
            paint3.setAntiAlias(true);
            this.mPaintGraph.setColor(-13391360);
            this.mPaintGraph.setStrokeWidth(2.0f);
            this.mPaintGraph.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.mTextPaint = paint4;
            paint4.setAntiAlias(true);
            this.mTextPaint.setColor(-13391360);
            this.mTextPaint.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            Paint paint5 = new Paint();
            this.mFillPaint = paint5;
            paint5.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.mDashPathEffect = dashPathEffect;
            this.mPaintGraph.setPathEffect(dashPathEffect);
            if (this.mPresentationMode) {
                this.mPaint.setStrokeWidth(8.0f);
                this.mFillPaint.setStrokeWidth(8.0f);
                this.mPaintKeyframes.setStrokeWidth(8.0f);
                this.mShadowTranslate = 4;
            }
        }

        private void drawBasicPath(Canvas canvas) {
            canvas.drawLines(this.mPoints, this.mPaint);
        }

        private void drawPathAsConfigured(Canvas canvas) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.mKeyFrameCount; i++) {
                if (this.mPathMode[i] == 1) {
                    z = true;
                }
                if (this.mPathMode[i] == 2) {
                    z2 = true;
                }
            }
            if (z) {
                drawPathRelative(canvas);
            }
            if (z2) {
                drawPathCartesian(canvas);
            }
        }

        private void drawPathCartesian(Canvas canvas) {
            float[] fArr = this.mPoints;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.mPaintGraph);
            canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.mPaintGraph);
        }

        private void drawPathCartesianTicks(Canvas canvas, float f, float f2) {
            float[] fArr = this.mPoints;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float min = Math.min(f3, f5);
            float max = Math.max(f4, f6);
            float min2 = f - Math.min(f3, f5);
            float max2 = Math.max(f4, f6) - f2;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(((int) (((min2 * 100.0f) / Math.abs(f5 - f3)) + 0.5d)) / 100.0f);
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            getTextBounds(sb, this.mTextPaint);
            canvas.drawText(sb, ((min2 / 2.0f) - (this.mBounds.width() / 2)) + min, f2 - 20.0f, this.mTextPaint);
            canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.mPaintGraph);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(((int) (((max2 * 100.0f) / Math.abs(f6 - f4)) + 0.5d)) / 100.0f);
            String sb2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            getTextBounds(sb2, this.mTextPaint);
            canvas.drawText(sb2, f + 5.0f, max - ((max2 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            canvas.drawLine(f, f2, f, Math.max(f4, f6), this.mPaintGraph);
        }

        private void drawPathRelative(Canvas canvas) {
            float[] fArr = this.mPoints;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.mPaintGraph);
        }

        private void drawPathRelativeTicks(Canvas canvas, float f, float f2) {
            float[] fArr = this.mPoints;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot(f3 - f5, f4 - f6);
            float f7 = f5 - f3;
            float f8 = f6 - f4;
            float f9 = (((f2 - f4) * f8) + ((f - f3) * f7)) / (hypot * hypot);
            float f10 = f3 + (f7 * f9);
            float f11 = f4 + (f9 * f8);
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f10, f11);
            float hypot2 = (float) Math.hypot(f10 - f, f11 - f2);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(((int) ((hypot2 * 100.0f) / hypot)) / 100.0f);
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            getTextBounds(sb, this.mTextPaint);
            canvas.drawTextOnPath(sb, path, (hypot2 / 2.0f) - (this.mBounds.width() / 2), -20.0f, this.mTextPaint);
            canvas.drawLine(f, f2, f10, f11, this.mPaintGraph);
        }

        private void drawPathScreenTicks(Canvas canvas, float f, float f2, int i, int i2) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(((int) ((((f - (i / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i)) + 0.5d)) / 100.0f);
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            getTextBounds(sb, this.mTextPaint);
            canvas.drawText(sb, ((f / 2.0f) - (this.mBounds.width() / 2)) + 0.0f, f2 - 20.0f, this.mTextPaint);
            canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.mPaintGraph);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(((int) ((((f2 - (i2 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i2)) + 0.5d)) / 100.0f);
            String sb2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            getTextBounds(sb2, this.mTextPaint);
            canvas.drawText(sb2, f + 5.0f, 0.0f - ((f2 / 2.0f) - (this.mBounds.height() / 2)), this.mTextPaint);
            canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.mPaintGraph);
        }

        private void drawRectangle(Canvas canvas, MotionController motionController) {
            this.mPath.reset();
            for (int i = 0; i <= 50; i++) {
                motionController.buildRect(i / 50, this.mRectangle, 0);
                Path path = this.mPath;
                float[] fArr = this.mRectangle;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.mPath;
                float[] fArr2 = this.mRectangle;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.mPath;
                float[] fArr3 = this.mRectangle;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.mPath;
                float[] fArr4 = this.mRectangle;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.mPath.close();
            }
            this.mPaint.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.mPath, this.mPaint);
            canvas.translate(-2.0f, -2.0f);
            this.mPaint.setColor(-65536);
            canvas.drawPath(this.mPath, this.mPaint);
        }

        private void drawTicks(Canvas canvas, int i, int i2, MotionController motionController) {
            int i3;
            int i4;
            float f;
            float f2;
            int i5;
            View view = motionController.mView;
            if (view != null) {
                i3 = view.getWidth();
                i4 = motionController.mView.getHeight();
            } else {
                i3 = 0;
                i4 = 0;
            }
            for (int i6 = 1; i6 < i2 - 1; i6++) {
                if (i != 4 || this.mPathMode[i6 - 1] != 0) {
                    float[] fArr = this.mKeyFramePoints;
                    int i7 = i6 * 2;
                    float f3 = fArr[i7];
                    float f4 = fArr[i7 + 1];
                    this.mPath.reset();
                    this.mPath.moveTo(f3, f4 + 10.0f);
                    this.mPath.lineTo(f3 + 10.0f, f4);
                    this.mPath.lineTo(f3, f4 - 10.0f);
                    this.mPath.lineTo(f3 - 10.0f, f4);
                    this.mPath.close();
                    int i8 = i6 - 1;
                    motionController.getKeyFrame(i8);
                    if (i == 4) {
                        int[] iArr = this.mPathMode;
                        if (iArr[i8] == 1) {
                            drawPathRelativeTicks(canvas, f3 - 0.0f, f4 - 0.0f);
                        } else if (iArr[i8] == 2) {
                            drawPathCartesianTicks(canvas, f3 - 0.0f, f4 - 0.0f);
                        } else if (iArr[i8] == 3) {
                            i5 = 3;
                            f = f4;
                            f2 = f3;
                            drawPathScreenTicks(canvas, f3 - 0.0f, f4 - 0.0f, i3, i4);
                            canvas.drawPath(this.mPath, this.mFillPaint);
                        }
                        f = f4;
                        f2 = f3;
                        i5 = 3;
                        canvas.drawPath(this.mPath, this.mFillPaint);
                    } else {
                        f = f4;
                        f2 = f3;
                        i5 = 3;
                    }
                    if (i == 2) {
                        drawPathRelativeTicks(canvas, f2 - 0.0f, f - 0.0f);
                    }
                    if (i == i5) {
                        drawPathCartesianTicks(canvas, f2 - 0.0f, f - 0.0f);
                    }
                    if (i == 6) {
                        drawPathScreenTicks(canvas, f2 - 0.0f, f - 0.0f, i3, i4);
                    }
                    canvas.drawPath(this.mPath, this.mFillPaint);
                }
            }
            float[] fArr2 = this.mPoints;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.mPaintKeyframes);
                float[] fArr3 = this.mPoints;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.mPaintKeyframes);
            }
        }

        private void drawTranslation(Canvas canvas, float f, float f2, float f3, float f4) {
            canvas.drawRect(f, f2, f3, f4, this.mPaintGraph);
            canvas.drawLine(f, f2, f3, f4, this.mPaintGraph);
        }

        public void draw(Canvas canvas, HashMap<View, MotionController> hashMap, int i, int i2) {
            if (hashMap == null || hashMap.size() == 0) {
                return;
            }
            canvas.save();
            if (!MotionLayout.this.isInEditMode() && (i2 & 1) == 2) {
                String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.mEndState) + ":" + MotionLayout.this.getProgress();
                canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.mTextPaint);
                canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.mPaint);
            }
            for (MotionController motionController : hashMap.values()) {
                int drawPath = motionController.getDrawPath();
                if (i2 > 0 && drawPath == 0) {
                    drawPath = 1;
                }
                if (drawPath != 0) {
                    this.mKeyFrameCount = motionController.buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
                    if (drawPath >= 1) {
                        int i3 = i / 16;
                        float[] fArr = this.mPoints;
                        if (fArr == null || fArr.length != i3 * 2) {
                            this.mPoints = new float[i3 * 2];
                            this.mPath = new Path();
                        }
                        int i4 = this.mShadowTranslate;
                        canvas.translate(i4, i4);
                        this.mPaint.setColor(1996488704);
                        this.mFillPaint.setColor(1996488704);
                        this.mPaintKeyframes.setColor(1996488704);
                        this.mPaintGraph.setColor(1996488704);
                        motionController.buildPath(this.mPoints, i3);
                        drawAll(canvas, drawPath, this.mKeyFrameCount, motionController);
                        this.mPaint.setColor(-21965);
                        this.mPaintKeyframes.setColor(-2067046);
                        this.mFillPaint.setColor(-2067046);
                        this.mPaintGraph.setColor(-13391360);
                        int i5 = this.mShadowTranslate;
                        canvas.translate(-i5, -i5);
                        drawAll(canvas, drawPath, this.mKeyFrameCount, motionController);
                        if (drawPath == 5) {
                            drawRectangle(canvas, motionController);
                        }
                    }
                }
            }
            canvas.restore();
        }

        public void drawAll(Canvas canvas, int i, int i2, MotionController motionController) {
            if (i == 4) {
                drawPathAsConfigured(canvas);
            }
            if (i == 2) {
                drawPathRelative(canvas);
            }
            if (i == 3) {
                drawPathCartesian(canvas);
            }
            drawBasicPath(canvas);
            drawTicks(canvas, i, i2, motionController);
        }

        public void getTextBounds(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.mBounds);
        }
    }

    /* loaded from: classes3.dex */
    public class Model {
        public int mEndId;
        public int mStartId;
        public ConstraintWidgetContainer mLayoutStart = new ConstraintWidgetContainer();
        public ConstraintWidgetContainer mLayoutEnd = new ConstraintWidgetContainer();
        public ConstraintSet mStart = null;
        public ConstraintSet mEnd = null;

        public Model() {
        }

        private void debugLayout(String str, ConstraintWidgetContainer constraintWidgetContainer) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, StringUtils.SPACE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Debug.getName((View) constraintWidgetContainer.getCompanionWidget()));
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            String str2 = sb + "  ========= " + constraintWidgetContainer;
            int size = constraintWidgetContainer.getChildren().size();
            for (int i = 0; i < size; i++) {
                String str3 = sb + "[" + i + "] ";
                ConstraintWidget constraintWidget = constraintWidgetContainer.getChildren().get(i);
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
                String str4 = "_";
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(constraintWidget.mTop.mTarget != null ? ExifInterface.GPS_DIRECTION_TRUE : str4);
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(constraintWidget.mBottom.mTarget != null ? "B" : str4);
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(constraintWidget.mLeft.mTarget != null ? "L" : str4);
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                if (constraintWidget.mRight.mTarget != null) {
                    str4 = "R";
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(str4);
                String sb2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString();
                View view = (View) constraintWidget.getCompanionWidget();
                String name = Debug.getName(view);
                if (view instanceof TextView) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name, "(");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append((Object) ((TextView) view).getText());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(")");
                    name = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                }
                String str5 = str3 + "  " + name + StringUtils.SPACE + constraintWidget + StringUtils.SPACE + sb2;
            }
        }

        private void debugLayoutParam(String str, ConstraintLayout.LayoutParams layoutParams) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringUtils.SPACE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(layoutParams.startToStart != -1 ? "SS" : "__");
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            String str2 = "|__";
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(layoutParams.startToEnd != -1 ? "|SE" : str2);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(layoutParams.endToStart != -1 ? "|ES" : str2);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(layoutParams.endToEnd != -1 ? "|EE" : str2);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(layoutParams.leftToLeft != -1 ? "|LL" : str2);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append(layoutParams.leftToRight != -1 ? "|LR" : str2);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.toString());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.append(layoutParams.rightToLeft != -1 ? "|RL" : str2);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.toString());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.append(layoutParams.rightToRight != -1 ? "|RR" : str2);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.toString());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.append(layoutParams.topToTop != -1 ? "|TT" : str2);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.toString());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10.append(layoutParams.topToBottom != -1 ? "|TB" : str2);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10.toString());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11.append(layoutParams.bottomToTop != -1 ? "|BT" : str2);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11.toString());
            if (layoutParams.bottomToBottom != -1) {
                str2 = "|BB";
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12.append(str2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12.toString();
        }

        private void debugWidget(String str, ConstraintWidget constraintWidget) {
            String str2;
            String str3;
            String str4;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringUtils.SPACE);
            String str5 = "B";
            String str6 = "__";
            if (constraintWidget.mTop.mTarget != null) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ExifInterface.GPS_DIRECTION_TRUE);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(constraintWidget.mTop.mTarget.mType == ConstraintAnchor.Type.TOP ? ExifInterface.GPS_DIRECTION_TRUE : str5);
                str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            } else {
                str2 = str6;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str2);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            if (constraintWidget.mBottom.mTarget != null) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str5);
                if (constraintWidget.mBottom.mTarget.mType == ConstraintAnchor.Type.TOP) {
                    str5 = ExifInterface.GPS_DIRECTION_TRUE;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(str5);
                str3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString();
            } else {
                str3 = str6;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(str3);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            String str7 = "R";
            if (constraintWidget.mLeft.mTarget != null) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("L");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.append(constraintWidget.mLeft.mTarget.mType == ConstraintAnchor.Type.LEFT ? "L" : str7);
                str4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.toString();
            } else {
                str4 = str6;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(str4);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
            if (constraintWidget.mRight.mTarget != null) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str7);
                if (constraintWidget.mRight.mTarget.mType == ConstraintAnchor.Type.LEFT) {
                    str7 = "L";
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.append(str7);
                str6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.toString();
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.append(str6);
            String str8 = str + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.toString() + " ---  " + constraintWidget;
        }

        private void setupConstraintWidget(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            SparseArray<ConstraintWidget> sparseArray = new SparseArray<>();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(MotionLayout.this.getId(), constraintWidgetContainer);
            Iterator<ConstraintWidget> it = constraintWidgetContainer.getChildren().iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                sparseArray.put(((View) next.getCompanionWidget()).getId(), next);
            }
            Iterator<ConstraintWidget> it2 = constraintWidgetContainer.getChildren().iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                View view = (View) next2.getCompanionWidget();
                constraintSet.applyToLayoutParams(view.getId(), layoutParams);
                next2.setWidth(constraintSet.getWidth(view.getId()));
                next2.setHeight(constraintSet.getHeight(view.getId()));
                if (view instanceof ConstraintHelper) {
                    constraintSet.applyToHelper((ConstraintHelper) view, next2, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).validateParams();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                next2.setVisibility(constraintSet.getVisibilityMode(view.getId()) == 1 ? view.getVisibility() : constraintSet.getVisibility(view.getId()));
            }
            Iterator<ConstraintWidget> it3 = constraintWidgetContainer.getChildren().iterator();
            while (it3.hasNext()) {
                ConstraintWidget next3 = it3.next();
                if (next3 instanceof VirtualLayout) {
                    Helper helper = (Helper) next3;
                    ((ConstraintHelper) next3.getCompanionWidget()).updatePreLayout(constraintWidgetContainer, helper, sparseArray);
                    ((VirtualLayout) helper).captureWidgets();
                }
            }
        }

        public void build() {
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.mFrameArrayList.clear();
            for (int i = 0; i < childCount; i++) {
                View childAt = MotionLayout.this.getChildAt(i);
                MotionLayout.this.mFrameArrayList.put(childAt, new MotionController(childAt));
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = MotionLayout.this.getChildAt(i2);
                MotionController motionController = MotionLayout.this.mFrameArrayList.get(childAt2);
                if (motionController != null) {
                    if (this.mStart != null) {
                        ConstraintWidget widget = getWidget(this.mLayoutStart, childAt2);
                        if (widget != null) {
                            motionController.setStartState(widget, this.mStart);
                        } else if (MotionLayout.this.mDebugPath != 0) {
                            Debug.getLocation();
                            Debug.getName(childAt2);
                            childAt2.getClass().getName();
                        }
                    }
                    if (this.mEnd != null) {
                        ConstraintWidget widget2 = getWidget(this.mLayoutEnd, childAt2);
                        if (widget2 != null) {
                            motionController.setEndState(widget2, this.mEnd);
                        } else if (MotionLayout.this.mDebugPath != 0) {
                            Debug.getLocation();
                            Debug.getName(childAt2);
                            childAt2.getClass().getName();
                        }
                    }
                }
            }
        }

        public void copy(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            HashMap<ConstraintWidget, ConstraintWidget> hashMap = new HashMap<>();
            hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.getChildren().clear();
            constraintWidgetContainer2.copy(constraintWidgetContainer, hashMap);
            Iterator<ConstraintWidget> it = children.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                ConstraintWidget barrier = next instanceof androidx.constraintlayout.solver.widgets.Barrier ? new androidx.constraintlayout.solver.widgets.Barrier() : next instanceof Guideline ? new Guideline() : next instanceof Flow ? new Flow() : next instanceof Helper ? new HelperWidget() : new ConstraintWidget();
                constraintWidgetContainer2.add(barrier);
                hashMap.put(next, barrier);
            }
            Iterator<ConstraintWidget> it2 = children.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                hashMap.get(next2).copy(next2, hashMap);
            }
        }

        public ConstraintWidget getWidget(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.getCompanionWidget() == view) {
                return constraintWidgetContainer;
            }
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            int size = children.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = children.get(i);
                if (constraintWidget.getCompanionWidget() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        public void initFrom(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.mStart = constraintSet;
            this.mEnd = constraintSet2;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mLayoutStart.setMeasurer(MotionLayout.this.mLayoutWidget.getMeasurer());
            this.mLayoutEnd.setMeasurer(MotionLayout.this.mLayoutWidget.getMeasurer());
            this.mLayoutStart.removeAllChildren();
            this.mLayoutEnd.removeAllChildren();
            copy(MotionLayout.this.mLayoutWidget, this.mLayoutStart);
            copy(MotionLayout.this.mLayoutWidget, this.mLayoutEnd);
            if (MotionLayout.this.mTransitionLastPosition > 0.5d) {
                if (constraintSet != null) {
                    setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
                setupConstraintWidget(this.mLayoutEnd, constraintSet2);
            } else {
                setupConstraintWidget(this.mLayoutEnd, constraintSet2);
                if (constraintSet != null) {
                    setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
            }
            this.mLayoutStart.setRtl(MotionLayout.this.isRtl());
            this.mLayoutStart.updateHierarchy();
            this.mLayoutEnd.setRtl(MotionLayout.this.isRtl());
            this.mLayoutEnd.updateHierarchy();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    this.mLayoutStart.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                    this.mLayoutEnd.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
                if (layoutParams.height != -2) {
                    return;
                }
                this.mLayoutStart.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                this.mLayoutEnd.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        }

        public boolean isNotConfiguredWith(int i, int i2) {
            return (i == this.mStartId && i2 == this.mEndId) ? false : true;
        }

        public void measure(int i, int i2) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.mWidthMeasureMode = mode;
            motionLayout.mHeightMeasureMode = mode2;
            int optimizationLevel = motionLayout.getOptimizationLevel();
            MotionLayout motionLayout2 = MotionLayout.this;
            if (motionLayout2.mCurrentState == motionLayout2.getStartState()) {
                MotionLayout.this.resolveSystem(this.mLayoutEnd, optimizationLevel, i, i2);
                if (this.mStart != null) {
                    MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, i, i2);
                }
            } else {
                if (this.mStart != null) {
                    MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, i, i2);
                }
                MotionLayout.this.resolveSystem(this.mLayoutEnd, optimizationLevel, i, i2);
            }
            if (((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                MotionLayout motionLayout3 = MotionLayout.this;
                motionLayout3.mWidthMeasureMode = mode;
                motionLayout3.mHeightMeasureMode = mode2;
                if (motionLayout3.mCurrentState == motionLayout3.getStartState()) {
                    MotionLayout.this.resolveSystem(this.mLayoutEnd, optimizationLevel, i, i2);
                    if (this.mStart != null) {
                        MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, i, i2);
                    }
                } else {
                    if (this.mStart != null) {
                        MotionLayout.this.resolveSystem(this.mLayoutStart, optimizationLevel, i, i2);
                    }
                    MotionLayout.this.resolveSystem(this.mLayoutEnd, optimizationLevel, i, i2);
                }
                MotionLayout.this.mStartWrapWidth = this.mLayoutStart.getWidth();
                MotionLayout.this.mStartWrapHeight = this.mLayoutStart.getHeight();
                MotionLayout.this.mEndWrapWidth = this.mLayoutEnd.getWidth();
                MotionLayout.this.mEndWrapHeight = this.mLayoutEnd.getHeight();
                MotionLayout motionLayout4 = MotionLayout.this;
                motionLayout4.mMeasureDuringTransition = (motionLayout4.mStartWrapWidth == motionLayout4.mEndWrapWidth && motionLayout4.mStartWrapHeight == motionLayout4.mEndWrapHeight) ? false : true;
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            int i3 = motionLayout5.mStartWrapWidth;
            int i4 = motionLayout5.mStartWrapHeight;
            int i5 = motionLayout5.mWidthMeasureMode;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                MotionLayout motionLayout6 = MotionLayout.this;
                int i6 = motionLayout6.mStartWrapWidth;
                i3 = (int) ((motionLayout6.mPostInterpolationPosition * (motionLayout6.mEndWrapWidth - i6)) + i6);
            }
            int i7 = i3;
            int i8 = MotionLayout.this.mHeightMeasureMode;
            if (i8 == Integer.MIN_VALUE || i8 == 0) {
                MotionLayout motionLayout7 = MotionLayout.this;
                int i9 = motionLayout7.mStartWrapHeight;
                i4 = (int) ((motionLayout7.mPostInterpolationPosition * (motionLayout7.mEndWrapHeight - i9)) + i9);
            }
            MotionLayout.this.resolveMeasuredDimension(i, i2, i7, i4, this.mLayoutStart.isWidthMeasuredTooSmall() || this.mLayoutEnd.isWidthMeasuredTooSmall(), this.mLayoutStart.isHeightMeasuredTooSmall() || this.mLayoutEnd.isHeightMeasuredTooSmall());
        }

        public void reEvaluateState() {
            measure(MotionLayout.this.mLastWidthMeasureSpec, MotionLayout.this.mLastHeightMeasureSpec);
            MotionLayout.this.setupMotionViews();
        }

        public void setMeasuredId(int i, int i2) {
            this.mStartId = i;
            this.mEndId = i2;
        }
    }

    /* loaded from: classes3.dex */
    public interface MotionTracker {
        void addMovement(MotionEvent motionEvent);

        void clear();

        void computeCurrentVelocity(int i);

        void computeCurrentVelocity(int i, float f);

        float getXVelocity();

        float getXVelocity(int i);

        float getYVelocity();

        float getYVelocity(int i);

        void recycle();
    }

    /* loaded from: classes3.dex */
    public static class MyTracker implements MotionTracker {

        /* renamed from: me */
        public static MyTracker f28me = new MyTracker();
        public VelocityTracker tracker;

        public static MyTracker obtain() {
            f28me.tracker = VelocityTracker.obtain();
            return f28me;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void addMovement(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void clear() {
            this.tracker.clear();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i) {
            this.tracker.computeCurrentVelocity(i);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i, float f) {
            this.tracker.computeCurrentVelocity(i, f);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity() {
            return this.tracker.getXVelocity();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity(int i) {
            return this.tracker.getXVelocity(i);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity() {
            return this.tracker.getYVelocity();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity(int i) {
            return getYVelocity(i);
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void recycle() {
            this.tracker.recycle();
            this.tracker = null;
        }
    }

    /* loaded from: classes3.dex */
    public class StateCache {
        public float mProgress = Float.NaN;
        public float mVelocity = Float.NaN;
        public int startState = -1;
        public int endState = -1;
        public final String KeyProgress = "motion.progress";
        public final String KeyVelocity = "motion.velocity";
        public final String KeyStartState = "motion.StartState";
        public final String KeyEndState = "motion.EndState";

        public StateCache() {
        }

        public void apply() {
            if (this.startState != -1 || this.endState != -1) {
                int i = this.startState;
                if (i == -1) {
                    MotionLayout.this.transitionToState(this.endState);
                } else {
                    int i2 = this.endState;
                    if (i2 == -1) {
                        MotionLayout.this.setState(i, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i, i2);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.mVelocity)) {
                if (Float.isNaN(this.mProgress)) {
                    return;
                }
                MotionLayout.this.setProgress(this.mProgress);
                return;
            }
            MotionLayout.this.setProgress(this.mProgress, this.mVelocity);
            this.mProgress = Float.NaN;
            this.mVelocity = Float.NaN;
            this.startState = -1;
            this.endState = -1;
        }

        public Bundle getTransitionState() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.mProgress);
            bundle.putFloat("motion.velocity", this.mVelocity);
            bundle.putInt("motion.StartState", this.startState);
            bundle.putInt("motion.EndState", this.endState);
            return bundle;
        }

        public void recordState() {
            this.endState = MotionLayout.this.mEndState;
            this.startState = MotionLayout.this.mBeginState;
            this.mVelocity = MotionLayout.this.getVelocity();
            this.mProgress = MotionLayout.this.getProgress();
        }

        public void setEndState(int i) {
            this.endState = i;
        }

        public void setProgress(float f) {
            this.mProgress = f;
        }

        public void setStartState(int i) {
            this.startState = i;
        }

        public void setTransitionState(Bundle bundle) {
            this.mProgress = bundle.getFloat("motion.progress");
            this.mVelocity = bundle.getFloat("motion.velocity");
            this.startState = bundle.getInt("motion.StartState");
            this.endState = bundle.getInt("motion.EndState");
        }

        public void setVelocity(float f) {
            this.mVelocity = f;
        }
    }

    /* loaded from: classes3.dex */
    public interface TransitionListener {
        void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f);

        void onTransitionCompleted(MotionLayout motionLayout, int i);

        void onTransitionStarted(MotionLayout motionLayout, int i, int i2);

        void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f);
    }

    /* loaded from: classes3.dex */
    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(@NonNull Context context) {
        super(context);
        init(null);
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void checkStructure() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        int startId = motionScene.getStartId();
        MotionScene motionScene2 = this.mScene;
        checkStructure(startId, motionScene2.getConstraintSet(motionScene2.getStartId()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator<MotionScene.Transition> it = this.mScene.getDefinedTransitions().iterator();
        while (it.hasNext()) {
            MotionScene.Transition next = it.next();
            MotionScene.Transition transition = this.mScene.mCurrentTransition;
            checkStructure(next);
            int startConstraintSetId = next.getStartConstraintSetId();
            int endConstraintSetId = next.getEndConstraintSetId();
            Debug.getName(getContext(), startConstraintSetId);
            Debug.getName(getContext(), endConstraintSetId);
            sparseIntArray.get(startConstraintSetId);
            sparseIntArray2.get(endConstraintSetId);
            sparseIntArray.put(startConstraintSetId, endConstraintSetId);
            sparseIntArray2.put(endConstraintSetId, startConstraintSetId);
            this.mScene.getConstraintSet(startConstraintSetId);
            this.mScene.getConstraintSet(endConstraintSetId);
        }
    }

    private void checkStructure(int i, ConstraintSet constraintSet) {
        Debug.getName(getContext(), i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            if (id == -1) {
                childAt.getClass().getName();
            }
            if (constraintSet.getConstraint(id) == null) {
                Debug.getName(childAt);
            }
        }
        int[] knownIds = constraintSet.getKnownIds();
        for (int i3 = 0; i3 < knownIds.length; i3++) {
            int i4 = knownIds[i3];
            Debug.getName(getContext(), i4);
            findViewById(knownIds[i3]);
            constraintSet.getHeight(i4);
            constraintSet.getWidth(i4);
        }
    }

    private void checkStructure(MotionScene.Transition transition) {
        transition.debugString(getContext());
        transition.getDuration();
        transition.getStartConstraintSetId();
        transition.getEndConstraintSetId();
    }

    private void computeCurrentPositions() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.setStartCurrentState(childAt);
            }
        }
    }

    private void debugPos() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Debug.getLocation();
            Debug.getName(this);
            Debug.getName(getContext(), this.mCurrentState);
            Debug.getName(childAt);
            childAt.getLeft();
            childAt.getTop();
        }
    }

    private void evaluateLayout() {
        boolean z;
        float signum = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long nanoTime = getNanoTime();
        float f = this.mTransitionLastPosition + (!(this.mInterpolator instanceof StopLogic) ? ((((float) (nanoTime - this.mTransitionLastTime)) * signum) * 1.0E-9f) / this.mTransitionDuration : 0.0f);
        if (this.mTransitionInstantly) {
            f = this.mTransitionGoalPosition;
        }
        int i = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
        if ((i <= 0 || f < this.mTransitionGoalPosition) && (signum > 0.0f || f > this.mTransitionGoalPosition)) {
            z = false;
        } else {
            f = this.mTransitionGoalPosition;
            z = true;
        }
        Interpolator interpolator = this.mInterpolator;
        if (interpolator != null && !z) {
            f = this.mTemporalInterpolator ? interpolator.getInterpolation(((float) (nanoTime - this.mAnimationStartTime)) * 1.0E-9f) : interpolator.getInterpolation(f);
        }
        if ((i > 0 && f >= this.mTransitionGoalPosition) || (signum <= 0.0f && f <= this.mTransitionGoalPosition)) {
            f = this.mTransitionGoalPosition;
        }
        this.mPostInterpolationPosition = f;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.interpolate(childAt, f, nanoTime2, this.mKeyCache);
            }
        }
        if (this.mMeasureDuringTransition) {
            requestLayout();
        }
    }

    private void fireTransitionChange() {
        ArrayList<TransitionListener> arrayList;
        if ((this.mTransitionListener != null || ((arrayList = this.mTransitionListeners) != null && !arrayList.isEmpty())) && this.mListenerPosition != this.mTransitionPosition) {
            if (this.mListenerState != -1) {
                TransitionListener transitionListener = this.mTransitionListener;
                if (transitionListener != null) {
                    transitionListener.onTransitionStarted(this, this.mBeginState, this.mEndState);
                }
                ArrayList<TransitionListener> arrayList2 = this.mTransitionListeners;
                if (arrayList2 != null) {
                    Iterator<TransitionListener> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
                    }
                }
                this.mIsAnimating = true;
            }
            this.mListenerState = -1;
            float f = this.mTransitionPosition;
            this.mListenerPosition = f;
            TransitionListener transitionListener2 = this.mTransitionListener;
            if (transitionListener2 != null) {
                transitionListener2.onTransitionChange(this, this.mBeginState, this.mEndState, f);
            }
            ArrayList<TransitionListener> arrayList3 = this.mTransitionListeners;
            if (arrayList3 != null) {
                Iterator<TransitionListener> it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    it2.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
                }
            }
            this.mIsAnimating = true;
        }
    }

    private void fireTransitionStarted(MotionLayout motionLayout, int i, int i2) {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionStarted(this, i, i2);
        }
        ArrayList<TransitionListener> arrayList = this.mTransitionListeners;
        if (arrayList != null) {
            Iterator<TransitionListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionStarted(motionLayout, i, i2);
            }
        }
    }

    private boolean handlesTouchEvent(float f, float f2, View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (handlesTouchEvent(view.getLeft() + f, view.getTop() + f2, viewGroup.getChildAt(i), motionEvent)) {
                    return true;
                }
            }
        }
        this.mBoundsCheck.set(view.getLeft() + f, view.getTop() + f2, f + view.getRight(), f2 + view.getBottom());
        if (motionEvent.getAction() == 0) {
            if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && view.onTouchEvent(motionEvent)) {
                return true;
            }
        } else if (view.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    private void init(AttributeSet attributeSet) {
        MotionScene motionScene;
        int i;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0186R.styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z = true;
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == C0186R.styleable.MotionLayout_layoutDescription) {
                    this.mScene = new MotionScene(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == C0186R.styleable.MotionLayout_currentState) {
                    this.mCurrentState = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == C0186R.styleable.MotionLayout_motionProgress) {
                    this.mTransitionGoalPosition = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.mInTransition = true;
                } else if (index == C0186R.styleable.MotionLayout_applyMotionScene) {
                    z = obtainStyledAttributes.getBoolean(index, z);
                } else if (index == C0186R.styleable.MotionLayout_showPaths) {
                    if (this.mDebugPath == 0) {
                        i = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                        this.mDebugPath = i;
                    }
                } else if (index == C0186R.styleable.MotionLayout_motionDebug) {
                    i = obtainStyledAttributes.getInt(index, 0);
                    this.mDebugPath = i;
                }
            }
            obtainStyledAttributes.recycle();
            MotionScene motionScene2 = this.mScene;
            if (!z) {
                this.mScene = null;
            }
        }
        if (this.mDebugPath != 0) {
            checkStructure();
        }
        if (this.mCurrentState != -1 || (motionScene = this.mScene) == null) {
            return;
        }
        this.mCurrentState = motionScene.getStartId();
        this.mBeginState = this.mScene.getStartId();
        this.mEndState = this.mScene.getEndId();
    }

    private void onNewStateAttachHandlers() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        if (motionScene.autoTransition(this, this.mCurrentState)) {
            requestLayout();
            return;
        }
        int i = this.mCurrentState;
        if (i != -1) {
            this.mScene.addOnClickListeners(this, i);
        }
        if (!this.mScene.supportTouch()) {
            return;
        }
        this.mScene.setupTouch();
    }

    private void processTransitionCompleted() {
        ArrayList<TransitionListener> arrayList;
        if (this.mTransitionListener != null || ((arrayList = this.mTransitionListeners) != null && !arrayList.isEmpty())) {
            this.mIsAnimating = false;
            Iterator<Integer> it = this.mTransitionCompleted.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                TransitionListener transitionListener = this.mTransitionListener;
                if (transitionListener != null) {
                    transitionListener.onTransitionCompleted(this, next.intValue());
                }
                ArrayList<TransitionListener> arrayList2 = this.mTransitionListeners;
                if (arrayList2 != null) {
                    Iterator<TransitionListener> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().onTransitionCompleted(this, next.intValue());
                    }
                }
            }
            this.mTransitionCompleted.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupMotionViews() {
        int childCount = getChildCount();
        this.mModel.build();
        boolean z = true;
        this.mInTransition = true;
        int width = getWidth();
        int height = getHeight();
        int gatPathMotionArc = this.mScene.gatPathMotionArc();
        int i = 0;
        if (gatPathMotionArc != -1) {
            for (int i2 = 0; i2 < childCount; i2++) {
                MotionController motionController = this.mFrameArrayList.get(getChildAt(i2));
                if (motionController != null) {
                    motionController.setPathMotionArc(gatPathMotionArc);
                }
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i3));
            if (motionController2 != null) {
                this.mScene.getKeyFrames(motionController2);
                motionController2.setup(width, height, this.mTransitionDuration, getNanoTime());
            }
        }
        float staggered = this.mScene.getStaggered();
        if (staggered != 0.0f) {
            boolean z2 = ((double) staggered) < RoundRectDrawableWithShadow.COS_45;
            float abs = Math.abs(staggered);
            float f = -3.4028235E38f;
            float f2 = Float.MAX_VALUE;
            int i4 = 0;
            float f3 = Float.MAX_VALUE;
            float f4 = -3.4028235E38f;
            while (true) {
                if (i4 >= childCount) {
                    z = false;
                    break;
                }
                MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i4));
                if (!Float.isNaN(motionController3.mMotionStagger)) {
                    break;
                }
                float finalX = motionController3.getFinalX();
                float finalY = motionController3.getFinalY();
                float f5 = z2 ? finalY - finalX : finalY + finalX;
                f3 = Math.min(f3, f5);
                f4 = Math.max(f4, f5);
                i4++;
            }
            if (!z) {
                while (i < childCount) {
                    MotionController motionController4 = this.mFrameArrayList.get(getChildAt(i));
                    float finalX2 = motionController4.getFinalX();
                    float finalY2 = motionController4.getFinalY();
                    float f6 = z2 ? finalY2 - finalX2 : finalY2 + finalX2;
                    motionController4.mStaggerScale = 1.0f / (1.0f - abs);
                    motionController4.mStaggerOffset = abs - (((f6 - f3) * abs) / (f4 - f3));
                    i++;
                }
                return;
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                MotionController motionController5 = this.mFrameArrayList.get(getChildAt(i5));
                if (!Float.isNaN(motionController5.mMotionStagger)) {
                    f2 = Math.min(f2, motionController5.mMotionStagger);
                    f = Math.max(f, motionController5.mMotionStagger);
                }
            }
            while (i < childCount) {
                MotionController motionController6 = this.mFrameArrayList.get(getChildAt(i));
                if (!Float.isNaN(motionController6.mMotionStagger)) {
                    motionController6.mStaggerScale = 1.0f / (1.0f - abs);
                    float f7 = motionController6.mMotionStagger;
                    motionController6.mStaggerOffset = abs - (z2 ? ((f - f7) / (f - f2)) * abs : ((f7 - f2) * abs) / (f - f2));
                }
                i++;
            }
        }
    }

    public static boolean willJump(float f, float f2, float f3) {
        if (f > 0.0f) {
            float f4 = f / f3;
            return ((f * f4) - (((f3 * f4) * f4) / 2.0f)) + f2 > 1.0f;
        }
        float f5 = (-f) / f3;
        return ((((f3 * f5) * f5) / 2.0f) + (f * f5)) + f2 < 0.0f;
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        if (this.mTransitionListeners == null) {
            this.mTransitionListeners = new ArrayList<>();
        }
        this.mTransitionListeners.add(transitionListener);
    }

    public void animateTo(float f) {
        if (this.mScene == null) {
            return;
        }
        float f2 = this.mTransitionLastPosition;
        float f3 = this.mTransitionPosition;
        if (f2 != f3 && this.mTransitionInstantly) {
            this.mTransitionLastPosition = f3;
        }
        float f4 = this.mTransitionLastPosition;
        if (f4 == f) {
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = f;
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = this.mScene.getInterpolator();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = f4;
        this.mTransitionLastPosition = f4;
        invalidate();
    }

    public void disableAutoTransition(boolean z) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        motionScene.disableAutoTransition(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a3  */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchDraw(Canvas canvas) {
        long j;
        evaluate(false);
        super.dispatchDraw(canvas);
        if (this.mScene == null) {
            return;
        }
        if ((this.mDebugPath & 1) == 1 && !isInEditMode()) {
            this.mFrames++;
            long nanoTime = getNanoTime();
            long j2 = this.mLastDrawTime;
            if (j2 != -1) {
                if (nanoTime - j2 > 200000000) {
                    this.mLastFps = ((int) ((this.mFrames / (((float) j) * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.mFrames = 0;
                }
                Paint paint = new Paint();
                paint.setTextSize(42.0f);
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + " -> ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Debug.getState(this, this.mEndState));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" (progress: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(((float) ((int) (getProgress() * 1000.0f))) / 10.0f);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" ) state=");
                int i = this.mCurrentState;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i != -1 ? "undefined" : Debug.getState(this, i));
                String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                paint.setColor(-16777216);
                canvas.drawText(sb, 11.0f, getHeight() - 29, paint);
                paint.setColor(-7864184);
                canvas.drawText(sb, 10.0f, getHeight() - 30, paint);
            }
            this.mLastDrawTime = nanoTime;
            Paint paint2 = new Paint();
            paint2.setTextSize(42.0f);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + " -> ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Debug.getState(this, this.mEndState));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" (progress: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(((float) ((int) (getProgress() * 1000.0f))) / 10.0f);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" ) state=");
            int i2 = this.mCurrentState;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(i2 != -1 ? "undefined" : Debug.getState(this, i2));
            String sb2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            paint2.setColor(-16777216);
            canvas.drawText(sb2, 11.0f, getHeight() - 29, paint2);
            paint2.setColor(-7864184);
            canvas.drawText(sb2, 10.0f, getHeight() - 30, paint2);
        }
        if (this.mDebugPath <= 1) {
            return;
        }
        if (this.mDevModeDraw == null) {
            this.mDevModeDraw = new DevModeDraw();
        }
        this.mDevModeDraw.draw(canvas, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
    }

    public void enableTransition(int i, boolean z) {
        boolean z2;
        MotionScene.Transition transition = getTransition(i);
        if (z) {
            z2 = true;
        } else {
            MotionScene motionScene = this.mScene;
            if (transition == motionScene.mCurrentTransition) {
                Iterator<MotionScene.Transition> it = motionScene.getTransitionsWithState(this.mCurrentState).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MotionScene.Transition next = it.next();
                    if (next.isEnabled()) {
                        this.mScene.mCurrentTransition = next;
                        break;
                    }
                }
            }
            z2 = false;
        }
        transition.setEnable(z2);
    }

    public void evaluate(boolean z) {
        float f;
        boolean z2;
        int i;
        float interpolation;
        int i2;
        if (this.mTransitionLastTime == -1) {
            this.mTransitionLastTime = getNanoTime();
        }
        float f2 = this.mTransitionLastPosition;
        if (f2 > 0.0f && f2 < 1.0f) {
            this.mCurrentState = -1;
        }
        boolean z3 = true;
        boolean z4 = false;
        if (this.mKeepAnimating || (this.mInTransition && (z || this.mTransitionGoalPosition != this.mTransitionLastPosition))) {
            float signum = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
            long nanoTime = getNanoTime();
            if (!(this.mInterpolator instanceof MotionInterpolator)) {
                f = ((((float) (nanoTime - this.mTransitionLastTime)) * signum) * 1.0E-9f) / this.mTransitionDuration;
                this.mLastVelocity = f;
            } else {
                f = 0.0f;
            }
            float f3 = this.mTransitionLastPosition + f;
            if (this.mTransitionInstantly) {
                f3 = this.mTransitionGoalPosition;
            }
            int i3 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
            if ((i3 <= 0 || f3 < this.mTransitionGoalPosition) && (signum > 0.0f || f3 > this.mTransitionGoalPosition)) {
                z2 = false;
            } else {
                f3 = this.mTransitionGoalPosition;
                this.mInTransition = false;
                z2 = true;
            }
            this.mTransitionLastPosition = f3;
            this.mTransitionPosition = f3;
            this.mTransitionLastTime = nanoTime;
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null && !z2) {
                if (this.mTemporalInterpolator) {
                    interpolation = interpolator.getInterpolation(((float) (nanoTime - this.mAnimationStartTime)) * 1.0E-9f);
                    this.mTransitionLastPosition = interpolation;
                    this.mTransitionLastTime = nanoTime;
                    Interpolator interpolator2 = this.mInterpolator;
                    if (interpolator2 instanceof MotionInterpolator) {
                        float velocity = ((MotionInterpolator) interpolator2).getVelocity();
                        this.mLastVelocity = velocity;
                        if (Math.abs(velocity) * this.mTransitionDuration <= 1.0E-5f) {
                            this.mInTransition = false;
                        }
                        if (velocity > 0.0f && interpolation >= 1.0f) {
                            this.mTransitionLastPosition = 1.0f;
                            this.mInTransition = false;
                            interpolation = 1.0f;
                        }
                        if (velocity < 0.0f && interpolation <= 0.0f) {
                            this.mTransitionLastPosition = 0.0f;
                            this.mInTransition = false;
                            f3 = 0.0f;
                        }
                    }
                } else {
                    interpolation = interpolator.getInterpolation(f3);
                    Interpolator interpolator3 = this.mInterpolator;
                    this.mLastVelocity = interpolator3 instanceof MotionInterpolator ? ((MotionInterpolator) interpolator3).getVelocity() : ((interpolator3.getInterpolation(f3 + f) - interpolation) * signum) / f;
                }
                f3 = interpolation;
            }
            if (Math.abs(this.mLastVelocity) > 1.0E-5f) {
                setState(TransitionState.MOVING);
            }
            if ((i3 > 0 && f3 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f3 <= this.mTransitionGoalPosition)) {
                f3 = this.mTransitionGoalPosition;
                this.mInTransition = false;
            }
            int i4 = (f3 > 1.0f ? 1 : (f3 == 1.0f ? 0 : -1));
            if (i4 >= 0 || f3 <= 0.0f) {
                this.mInTransition = false;
                setState(TransitionState.FINISHED);
            }
            int childCount = getChildCount();
            this.mKeepAnimating = false;
            long nanoTime2 = getNanoTime();
            this.mPostInterpolationPosition = f3;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                MotionController motionController = this.mFrameArrayList.get(childAt);
                if (motionController != null) {
                    this.mKeepAnimating = motionController.interpolate(childAt, f3, nanoTime2, this.mKeyCache) | this.mKeepAnimating;
                }
            }
            boolean z5 = (i3 > 0 && f3 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f3 <= this.mTransitionGoalPosition);
            if (!this.mKeepAnimating && !this.mInTransition && z5) {
                setState(TransitionState.FINISHED);
            }
            if (this.mMeasureDuringTransition) {
                requestLayout();
            }
            this.mKeepAnimating = (!z5) | this.mKeepAnimating;
            if (f3 <= 0.0f && (i = this.mBeginState) != -1 && this.mCurrentState != i) {
                this.mCurrentState = i;
                this.mScene.getConstraintSet(i).applyCustomAttributes(this);
                setState(TransitionState.FINISHED);
                z4 = true;
            }
            if (f3 >= 1.0d) {
                int i6 = this.mCurrentState;
                int i7 = this.mEndState;
                if (i6 != i7) {
                    this.mCurrentState = i7;
                    this.mScene.getConstraintSet(i7).applyCustomAttributes(this);
                    setState(TransitionState.FINISHED);
                    z4 = true;
                }
            }
            if (this.mKeepAnimating || this.mInTransition) {
                invalidate();
            } else if ((i3 > 0 && i4 == 0) || (signum < 0.0f && f3 == 0.0f)) {
                setState(TransitionState.FINISHED);
            }
            if ((!this.mKeepAnimating && this.mInTransition && i3 > 0 && i4 == 0) || (signum < 0.0f && f3 == 0.0f)) {
                onNewStateAttachHandlers();
            }
        }
        float f4 = this.mTransitionLastPosition;
        if (f4 < 1.0f) {
            if (f4 <= 0.0f) {
                if (this.mCurrentState == this.mBeginState) {
                    z3 = z4;
                }
                i2 = this.mBeginState;
            }
            this.mNeedsFireTransitionCompleted |= z4;
            if (z4 && !this.mInLayout) {
                requestLayout();
            }
            this.mTransitionPosition = this.mTransitionLastPosition;
        }
        if (this.mCurrentState == this.mEndState) {
            z3 = z4;
        }
        i2 = this.mEndState;
        this.mCurrentState = i2;
        z4 = z3;
        this.mNeedsFireTransitionCompleted |= z4;
        if (z4) {
            requestLayout();
        }
        this.mTransitionPosition = this.mTransitionLastPosition;
    }

    public void fireTransitionCompleted() {
        int i;
        ArrayList<TransitionListener> arrayList;
        if ((this.mTransitionListener != null || ((arrayList = this.mTransitionListeners) != null && !arrayList.isEmpty())) && this.mListenerState == -1) {
            this.mListenerState = this.mCurrentState;
            if (!this.mTransitionCompleted.isEmpty()) {
                ArrayList<Integer> arrayList2 = this.mTransitionCompleted;
                i = arrayList2.get(arrayList2.size() - 1).intValue();
            } else {
                i = -1;
            }
            int i2 = this.mCurrentState;
            if (i != i2 && i2 != -1) {
                this.mTransitionCompleted.add(Integer.valueOf(i2));
            }
        }
        processTransitionCompleted();
    }

    public void fireTrigger(int i, boolean z, float f) {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionTrigger(this, i, z, f);
        }
        ArrayList<TransitionListener> arrayList = this.mTransitionListeners;
        if (arrayList != null) {
            Iterator<TransitionListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionTrigger(this, i, z, f);
            }
        }
    }

    public void getAnchorDpDt(int i, float f, float f2, float f3, float[] fArr) {
        HashMap<View, MotionController> hashMap = this.mFrameArrayList;
        View viewById = getViewById(i);
        MotionController motionController = hashMap.get(viewById);
        if (motionController != null) {
            motionController.getDpDt(f, f2, f3, fArr);
            float y = viewById.getY();
            int i2 = ((f - this.lastPos) > 0.0f ? 1 : ((f - this.lastPos) == 0.0f ? 0 : -1));
            this.lastPos = f;
            this.lastY = y;
        } else if (viewById != null) {
            viewById.getContext().getResources().getResourceName(i);
        } else {
            String str = "" + i;
        }
    }

    public ConstraintSet getConstraintSet(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSet(i);
    }

    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSetIds();
    }

    public String getConstraintSetNames(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.lookUpConstraintName(i);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public void getDebugMode(boolean z) {
        this.mDebugPath = z ? 2 : 1;
        invalidate();
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        if (this.mDesignTool == null) {
            this.mDesignTool = new DesignTool(this);
        }
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public MotionScene.Transition getTransition(int i) {
        return this.mScene.getTransitionById(i);
    }

    public Bundle getTransitionState() {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.recordState();
        return this.mStateCache.getTransitionState();
    }

    public long getTransitionTimeMs() {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            this.mTransitionDuration = motionScene.getDuration() / 1000.0f;
        }
        return this.mTransitionDuration * 1000.0f;
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View view, float f, float f2, float[] fArr, int i) {
        float f3;
        float f4 = this.mLastVelocity;
        float f5 = this.mTransitionLastPosition;
        if (this.mInterpolator != null) {
            float signum = Math.signum(this.mTransitionGoalPosition - f5);
            float interpolation = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + 1.0E-5f);
            float interpolation2 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
            f4 = (((interpolation - interpolation2) / 1.0E-5f) * signum) / this.mTransitionDuration;
            f3 = interpolation2;
        } else {
            f3 = f5;
        }
        Interpolator interpolator = this.mInterpolator;
        if (interpolator instanceof MotionInterpolator) {
            f4 = ((MotionInterpolator) interpolator).getVelocity();
        }
        MotionController motionController = this.mFrameArrayList.get(view);
        if ((i & 1) == 0) {
            motionController.getPostLayoutDvDp(f3, view.getWidth(), view.getHeight(), f, f2, fArr);
        } else {
            motionController.getDpDt(f3, f, f2, fArr);
        }
        if (i < 2) {
            fArr[0] = fArr[0] * f4;
            fArr[1] = fArr[1] * f4;
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i) {
        if (i == 0) {
            this.mScene = null;
            return;
        }
        try {
            this.mScene = new MotionScene(getContext(), this, i);
            if (!isAttachedToWindow()) {
                return;
            }
            this.mScene.readFallback(this);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            rebuildScene();
            this.mScene.setRtl(isRtl());
        } catch (Exception e) {
            throw new IllegalArgumentException("unable to parse MotionScene file", e);
        }
    }

    public int lookUpConstraintId(String str) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return 0;
        }
        return motionScene.lookUpConstraintId(str);
    }

    public MotionTracker obtainVelocityTracker() {
        return MyTracker.obtain();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i;
        super.onAttachedToWindow();
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (i = this.mCurrentState) != -1) {
            ConstraintSet constraintSet = motionScene.getConstraintSet(i);
            this.mScene.readFallback(this);
            if (constraintSet != null) {
                constraintSet.applyTo(this);
            }
            this.mBeginState = this.mCurrentState;
        }
        onNewStateAttachHandlers();
        StateCache stateCache = this.mStateCache;
        if (stateCache != null) {
            stateCache.apply();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionScene.Transition transition;
        TouchResponse touchResponse;
        int touchRegionId;
        RectF touchRegion;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && this.mInteractionEnabled && (transition = motionScene.mCurrentTransition) != null && transition.isEnabled() && (touchResponse = transition.getTouchResponse()) != null && ((motionEvent.getAction() != 0 || (touchRegion = touchResponse.getTouchRegion(this, new RectF())) == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) && (touchRegionId = touchResponse.getTouchRegionId()) != -1)) {
            View view = this.mRegionView;
            if (view == null || view.getId() != touchRegionId) {
                this.mRegionView = findViewById(touchRegionId);
            }
            View view2 = this.mRegionView;
            if (view2 != null) {
                this.mBoundsCheck.set(view2.getLeft(), this.mRegionView.getTop(), this.mRegionView.getRight(), this.mRegionView.getBottom());
                if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && !handlesTouchEvent(0.0f, 0.0f, this.mRegionView, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        try {
            if (this.mScene == null) {
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (this.mLastLayoutWidth != i5 || this.mLastLayoutHeight != i6) {
                rebuildScene();
                evaluate(true);
            }
            this.mLastLayoutWidth = i5;
            this.mLastLayoutHeight = i6;
            this.mOldWidth = i5;
            this.mOldHeight = i6;
        } finally {
            this.mInLayout = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mScene == null) {
            super.onMeasure(i, i2);
            return;
        }
        boolean z = false;
        boolean z2 = (this.mLastWidthMeasureSpec == i && this.mLastHeightMeasureSpec == i2) ? false : true;
        if (this.mNeedsFireTransitionCompleted) {
            this.mNeedsFireTransitionCompleted = false;
            onNewStateAttachHandlers();
            processTransitionCompleted();
            z2 = true;
        }
        if (this.mDirtyHierarchy) {
            z2 = true;
        }
        this.mLastWidthMeasureSpec = i;
        this.mLastHeightMeasureSpec = i2;
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if ((z2 || this.mModel.isNotConfiguredWith(startId, endId)) && this.mBeginState != -1) {
            super.onMeasure(i, i2);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(startId), this.mScene.getConstraintSet(endId));
            this.mModel.reEvaluateState();
            this.mModel.setMeasuredId(startId, endId);
        } else {
            z = true;
        }
        if (this.mMeasureDuringTransition || z) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int width = this.mLayoutWidget.getWidth() + getPaddingRight() + getPaddingLeft();
            int height = this.mLayoutWidget.getHeight() + paddingBottom;
            int i3 = this.mWidthMeasureMode;
            if (i3 == Integer.MIN_VALUE || i3 == 0) {
                int i4 = this.mStartWrapWidth;
                width = (int) ((this.mPostInterpolationPosition * (this.mEndWrapWidth - i4)) + i4);
                requestLayout();
            }
            int i5 = this.mHeightMeasureMode;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                int i6 = this.mStartWrapHeight;
                height = (int) ((this.mPostInterpolationPosition * (this.mEndWrapHeight - i6)) + i6);
                requestLayout();
            }
            setMeasuredDimension(width, height);
        }
        evaluateLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(final View view, int i, int i2, int[] iArr, int i3) {
        MotionScene.Transition transition;
        TouchResponse touchResponse;
        int touchRegionId;
        MotionScene motionScene = this.mScene;
        if (motionScene == null || (transition = motionScene.mCurrentTransition) == null || !transition.isEnabled()) {
            return;
        }
        MotionScene.Transition transition2 = this.mScene.mCurrentTransition;
        if (transition2 != null && transition2.isEnabled() && (touchResponse = transition2.getTouchResponse()) != null && (touchRegionId = touchResponse.getTouchRegionId()) != -1 && view.getId() != touchRegionId) {
            return;
        }
        MotionScene motionScene2 = this.mScene;
        if (motionScene2 != null && motionScene2.getMoveWhenScrollAtTop()) {
            float f = this.mTransitionPosition;
            if ((f == 1.0f || f == 0.0f) && view.canScrollVertically(-1)) {
                return;
            }
        }
        if (transition2.getTouchResponse() != null && (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 1) != 0) {
            float progressDirection = this.mScene.getProgressDirection(i, i2);
            if ((this.mTransitionLastPosition <= 0.0f && progressDirection < 0.0f) || (this.mTransitionLastPosition >= 1.0f && progressDirection > 0.0f)) {
                view.setNestedScrollingEnabled(false);
                view.post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.1
                    @Override // java.lang.Runnable
                    public void run() {
                        view.setNestedScrollingEnabled(true);
                    }
                });
                return;
            }
        }
        float f2 = this.mTransitionPosition;
        long nanoTime = getNanoTime();
        float f3 = i;
        this.mScrollTargetDX = f3;
        float f4 = i2;
        this.mScrollTargetDY = f4;
        this.mScrollTargetDT = (float) ((nanoTime - this.mScrollTargetTime) * 1.0E-9d);
        this.mScrollTargetTime = nanoTime;
        this.mScene.processScrollMove(f3, f4);
        if (f2 != this.mTransitionPosition) {
            iArr[0] = i;
            iArr[1] = i2;
        }
        evaluate(false);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.mUndergoingMotion = true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (this.mUndergoingMotion || i != 0 || i2 != 0) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
        }
        this.mUndergoingMotion = false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setRtl(isRtl());
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        MotionScene.Transition transition;
        MotionScene motionScene = this.mScene;
        return (motionScene == null || (transition = motionScene.mCurrentTransition) == null || transition.getTouchResponse() == null || (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 2) != 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        float f = this.mScrollTargetDX;
        float f2 = this.mScrollTargetDT;
        motionScene.processScrollUp(f / f2, this.mScrollTargetDY / f2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null || !this.mInteractionEnabled || !motionScene.supportTouch()) {
            return super.onTouchEvent(motionEvent);
        }
        MotionScene.Transition transition = this.mScene.mCurrentTransition;
        if (transition != null && !transition.isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        this.mScene.processTouchEvent(motionEvent, getCurrentState(), this);
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.mTransitionListeners == null) {
                this.mTransitionListeners = new ArrayList<>();
            }
            this.mTransitionListeners.add(motionHelper);
            if (motionHelper.isUsedOnShow()) {
                if (this.mOnShowHelpers == null) {
                    this.mOnShowHelpers = new ArrayList<>();
                }
                this.mOnShowHelpers.add(motionHelper);
            }
            if (!motionHelper.isUseOnHide()) {
                return;
            }
            if (this.mOnHideHelpers == null) {
                this.mOnHideHelpers = new ArrayList<>();
            }
            this.mOnHideHelpers.add(motionHelper);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.mOnHideHelpers;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.reEvaluateState();
        invalidate();
    }

    public boolean removeTransitionListener(TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.mTransitionListeners;
        if (arrayList == null) {
            return false;
        }
        return arrayList.remove(transitionListener);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        if (this.mMeasureDuringTransition || this.mCurrentState != -1 || (motionScene = this.mScene) == null || (transition = motionScene.mCurrentTransition) == null || transition.getLayoutDuringTransition() != 0) {
            super.requestLayout();
        }
    }

    public void setDebugMode(int i) {
        this.mDebugPath = i;
        invalidate();
    }

    public void setInteractionEnabled(boolean z) {
        this.mInteractionEnabled = z;
    }

    public void setInterpolatedProgress(float f) {
        if (this.mScene != null) {
            setState(TransitionState.MOVING);
            Interpolator interpolator = this.mScene.getInterpolator();
            if (interpolator != null) {
                setProgress(interpolator.getInterpolation(f));
                return;
            }
        }
        setProgress(f);
    }

    public void setOnHide(float f) {
        ArrayList<MotionHelper> arrayList = this.mOnHideHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mOnHideHelpers.get(i).setProgress(f);
            }
        }
    }

    public void setOnShow(float f) {
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mOnShowHelpers.get(i).setProgress(f);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
        if (r3.mTransitionLastPosition == 0.0f) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
        r0 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
        if (r3.mTransitionLastPosition == 1.0f) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setProgress(float f) {
        TransitionState transitionState;
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setProgress(f);
            return;
        }
        if (f <= 0.0f) {
            this.mCurrentState = this.mBeginState;
        } else if (f >= 1.0f) {
            this.mCurrentState = this.mEndState;
        } else {
            this.mCurrentState = -1;
            transitionState = TransitionState.MOVING;
        }
        setState(transitionState);
        if (this.mScene == null) {
            return;
        }
        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = f;
        this.mTransitionPosition = f;
        this.mTransitionLastTime = -1L;
        this.mAnimationStartTime = -1L;
        this.mInterpolator = null;
        this.mInTransition = true;
        invalidate();
    }

    public void setProgress(float f, float f2) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setProgress(f);
            this.mStateCache.setVelocity(f2);
            return;
        }
        setProgress(f);
        setState(TransitionState.MOVING);
        this.mLastVelocity = f2;
        animateTo(1.0f);
    }

    public void setScene(MotionScene motionScene) {
        this.mScene = motionScene;
        motionScene.setRtl(isRtl());
        rebuildScene();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i, int i2, int i3) {
        setState(TransitionState.SETUP);
        this.mCurrentState = i;
        this.mBeginState = -1;
        this.mEndState = -1;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i, i2, i3);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        motionScene.getConstraintSet(i).applyTo(this);
    }

    public void setState(TransitionState transitionState) {
        if (transitionState == TransitionState.FINISHED && this.mCurrentState == -1) {
            return;
        }
        TransitionState transitionState2 = this.mTransitionState;
        this.mTransitionState = transitionState;
        TransitionState transitionState3 = TransitionState.MOVING;
        if (transitionState2 == transitionState3 && transitionState == transitionState3) {
            fireTransitionChange();
        }
        int ordinal = transitionState2.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            if (transitionState == TransitionState.MOVING) {
                fireTransitionChange();
            }
            if (transitionState != TransitionState.FINISHED) {
                return;
            }
        } else if (ordinal != 2 || transitionState != TransitionState.FINISHED) {
            return;
        }
        fireTransitionCompleted();
    }

    public void setTransition(int i) {
        if (this.mScene != null) {
            MotionScene.Transition transition = getTransition(i);
            this.mBeginState = transition.getStartConstraintSetId();
            this.mEndState = transition.getEndConstraintSetId();
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new StateCache();
                }
                this.mStateCache.setStartState(this.mBeginState);
                this.mStateCache.setEndState(this.mEndState);
                return;
            }
            float f = Float.NaN;
            int i2 = this.mCurrentState;
            float f2 = 0.0f;
            if (i2 == this.mBeginState) {
                f = 0.0f;
            } else if (i2 == this.mEndState) {
                f = 1.0f;
            }
            this.mScene.setTransition(transition);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            rebuildScene();
            if (!Float.isNaN(f)) {
                f2 = f;
            }
            this.mTransitionLastPosition = f2;
            if (!Float.isNaN(f)) {
                setProgress(f);
                return;
            }
            Debug.getLocation();
            transitionToStart();
        }
    }

    public void setTransition(int i, int i2) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setStartState(i);
            this.mStateCache.setEndState(i2);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        this.mBeginState = i;
        this.mEndState = i2;
        motionScene.setTransition(i, i2);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(i), this.mScene.getConstraintSet(i2));
        rebuildScene();
        this.mTransitionLastPosition = 0.0f;
        transitionToStart();
    }

    public void setTransition(MotionScene.Transition transition) {
        this.mScene.setTransition(transition);
        setState(TransitionState.SETUP);
        float f = this.mCurrentState == this.mScene.getEndId() ? 1.0f : 0.0f;
        this.mTransitionLastPosition = f;
        this.mTransitionPosition = f;
        this.mTransitionGoalPosition = f;
        this.mTransitionLastTime = transition.isTransitionFlag(1) ? -1L : getNanoTime();
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if (startId == this.mBeginState && endId == this.mEndState) {
            return;
        }
        this.mBeginState = startId;
        this.mEndState = endId;
        this.mScene.setTransition(startId, endId);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
        this.mModel.reEvaluateState();
        rebuildScene();
    }

    public void setTransitionDuration(int i) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        motionScene.setDuration(i);
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.mTransitionListener = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.setTransitionState(bundle);
        if (isAttachedToWindow()) {
            this.mStateCache.apply();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return Debug.getName(context, this.mBeginState) + "->" + Debug.getName(context, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    public void touchAnimateTo(int i, float f, float f2) {
        Interpolator interpolator;
        if (this.mScene == null || this.mTransitionLastPosition == f) {
            return;
        }
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = getNanoTime();
        this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
        this.mTransitionGoalPosition = f;
        this.mInTransition = true;
        if (i != 0 && i != 1 && i != 2) {
            if (i != 4) {
                if (i == 5) {
                    if (!willJump(f2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration())) {
                        this.mStopLogic.config(this.mTransitionLastPosition, f, f2, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
                        this.mLastVelocity = 0.0f;
                    }
                }
                this.mTransitionInstantly = false;
                this.mAnimationStartTime = getNanoTime();
                invalidate();
            }
            this.mDecelerateLogic.config(f2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
            interpolator = this.mDecelerateLogic;
            this.mInterpolator = interpolator;
            this.mTransitionInstantly = false;
            this.mAnimationStartTime = getNanoTime();
            invalidate();
        }
        if (i == 1) {
            f = 0.0f;
        } else if (i == 2) {
            f = 1.0f;
        }
        this.mStopLogic.config(this.mTransitionLastPosition, f, f2, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
        int i2 = this.mCurrentState;
        this.mTransitionGoalPosition = f;
        this.mCurrentState = i2;
        interpolator = this.mStopLogic;
        this.mInterpolator = interpolator;
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = getNanoTime();
        invalidate();
    }

    public void transitionToEnd() {
        animateTo(1.0f);
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    public void transitionToState(int i) {
        if (isAttachedToWindow()) {
            transitionToState(i, -1, -1);
            return;
        }
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.setEndState(i);
    }

    public void transitionToState(int i, int i2, int i3) {
        StateSet stateSet;
        int convertToConstraintSet;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (stateSet = motionScene.mStateSet) != null && (convertToConstraintSet = stateSet.convertToConstraintSet(this.mCurrentState, i, i2, i3)) != -1) {
            i = convertToConstraintSet;
        }
        int i4 = this.mCurrentState;
        if (i4 == i) {
            return;
        }
        if (this.mBeginState == i) {
            animateTo(0.0f);
        } else if (this.mEndState == i) {
            animateTo(1.0f);
        } else {
            this.mEndState = i;
            if (i4 != -1) {
                setTransition(i4, i);
                animateTo(1.0f);
                this.mTransitionLastPosition = 0.0f;
                transitionToEnd();
                return;
            }
            this.mTemporalInterpolator = false;
            this.mTransitionGoalPosition = 1.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionLastTime = getNanoTime();
            this.mAnimationStartTime = getNanoTime();
            this.mTransitionInstantly = false;
            this.mInterpolator = null;
            this.mTransitionDuration = this.mScene.getDuration() / 1000.0f;
            this.mBeginState = -1;
            this.mScene.setTransition(-1, this.mEndState);
            this.mScene.getStartId();
            int childCount = getChildCount();
            this.mFrameArrayList.clear();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                this.mFrameArrayList.put(childAt, new MotionController(childAt));
            }
            this.mInTransition = true;
            this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(i));
            rebuildScene();
            this.mModel.build();
            computeCurrentPositions();
            int width = getWidth();
            int height = getHeight();
            for (int i6 = 0; i6 < childCount; i6++) {
                MotionController motionController = this.mFrameArrayList.get(getChildAt(i6));
                this.mScene.getKeyFrames(motionController);
                motionController.setup(width, height, this.mTransitionDuration, getNanoTime());
            }
            float staggered = this.mScene.getStaggered();
            if (staggered != 0.0f) {
                float f = Float.MAX_VALUE;
                float f2 = -3.4028235E38f;
                for (int i7 = 0; i7 < childCount; i7++) {
                    MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i7));
                    float finalY = motionController2.getFinalY() + motionController2.getFinalX();
                    f = Math.min(f, finalY);
                    f2 = Math.max(f2, finalY);
                }
                for (int i8 = 0; i8 < childCount; i8++) {
                    MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i8));
                    float finalX = motionController3.getFinalX();
                    float finalY2 = motionController3.getFinalY();
                    motionController3.mStaggerScale = 1.0f / (1.0f - staggered);
                    motionController3.mStaggerOffset = staggered - ((((finalX + finalY2) - f) * staggered) / (f2 - f));
                }
            }
            this.mTransitionPosition = 0.0f;
            this.mTransitionLastPosition = 0.0f;
            this.mInTransition = true;
            invalidate();
        }
    }

    public void updateState() {
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
    }

    public void updateState(int i, ConstraintSet constraintSet) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setConstraintSet(i, constraintSet);
        }
        updateState();
        if (this.mCurrentState == i) {
            constraintSet.applyTo(this);
        }
    }
}

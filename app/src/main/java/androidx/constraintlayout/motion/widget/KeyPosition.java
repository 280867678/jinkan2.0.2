package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.C0186R;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class KeyPosition extends KeyPositionBase {
    public static final int KEY_TYPE = 2;
    public static final String NAME = "KeyPosition";
    public static final String PERCENT_X = "percentX";
    public static final String PERCENT_Y = "percentY";
    public static final String TAG = "KeyPosition";
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    public String mTransitionEasing = null;
    public int mPathMotionArc = Key.UNSET;
    public int mDrawPath = 0;
    public float mPercentWidth = Float.NaN;
    public float mPercentHeight = Float.NaN;
    public float mPercentX = Float.NaN;
    public float mPercentY = Float.NaN;
    public float mAltPercentX = Float.NaN;
    public float mAltPercentY = Float.NaN;
    public int mPositionType = 0;
    public float mCalculatedPositionX = Float.NaN;
    public float mCalculatedPositionY = Float.NaN;

    /* loaded from: classes3.dex */
    public static class Loader {
        public static final int CURVE_FIT = 4;
        public static final int DRAW_PATH = 5;
        public static final int FRAME_POSITION = 2;
        public static final int PATH_MOTION_ARC = 10;
        public static final int PERCENT_HEIGHT = 12;
        public static final int PERCENT_WIDTH = 11;
        public static final int PERCENT_X = 6;
        public static final int PERCENT_Y = 7;
        public static final int SIZE_PERCENT = 8;
        public static final int TARGET_ID = 1;
        public static final int TRANSITION_EASING = 3;
        public static final int TYPE = 9;
        public static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(C0186R.styleable.KeyPosition_motionTarget, 1);
            mAttrMap.append(C0186R.styleable.KeyPosition_framePosition, 2);
            mAttrMap.append(C0186R.styleable.KeyPosition_transitionEasing, 3);
            mAttrMap.append(C0186R.styleable.KeyPosition_curveFit, 4);
            mAttrMap.append(C0186R.styleable.KeyPosition_drawPath, 5);
            mAttrMap.append(C0186R.styleable.KeyPosition_percentX, 6);
            mAttrMap.append(C0186R.styleable.KeyPosition_percentY, 7);
            mAttrMap.append(C0186R.styleable.KeyPosition_keyPositionType, 9);
            mAttrMap.append(C0186R.styleable.KeyPosition_sizePercent, 8);
            mAttrMap.append(C0186R.styleable.KeyPosition_percentWidth, 11);
            mAttrMap.append(C0186R.styleable.KeyPosition_percentHeight, 12);
            mAttrMap.append(C0186R.styleable.KeyPosition_pathMotionArc, 10);
        }

        public static void read(KeyPosition keyPosition, TypedArray typedArray) {
            float f;
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyPosition.mTargetId);
                            keyPosition.mTargetId = resourceId;
                            if (resourceId != -1) {
                            }
                            keyPosition.mTargetString = typedArray.getString(index);
                        } else {
                            if (typedArray.peekValue(index).type != 3) {
                                keyPosition.mTargetId = typedArray.getResourceId(index, keyPosition.mTargetId);
                                continue;
                            }
                            keyPosition.mTargetString = typedArray.getString(index);
                        }
                    case 2:
                        keyPosition.mFramePosition = typedArray.getInt(index, keyPosition.mFramePosition);
                        continue;
                    case 3:
                        keyPosition.mTransitionEasing = typedArray.peekValue(index).type == 3 ? typedArray.getString(index) : Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                        continue;
                    case 4:
                        keyPosition.mCurveFit = typedArray.getInteger(index, keyPosition.mCurveFit);
                        continue;
                    case 5:
                        keyPosition.mDrawPath = typedArray.getInt(index, keyPosition.mDrawPath);
                        continue;
                    case 6:
                        keyPosition.mPercentX = typedArray.getFloat(index, keyPosition.mPercentX);
                        continue;
                    case 7:
                        keyPosition.mPercentY = typedArray.getFloat(index, keyPosition.mPercentY);
                        continue;
                    case 8:
                        f = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        keyPosition.mPercentWidth = f;
                        break;
                    case 9:
                        keyPosition.mPositionType = typedArray.getInt(index, keyPosition.mPositionType);
                        continue;
                    case 10:
                        keyPosition.mPathMotionArc = typedArray.getInt(index, keyPosition.mPathMotionArc);
                        continue;
                    case 11:
                        keyPosition.mPercentWidth = typedArray.getFloat(index, keyPosition.mPercentWidth);
                        continue;
                    case 12:
                        f = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        break;
                    default:
                        Integer.toHexString(index);
                        mAttrMap.get(index);
                        continue;
                }
                keyPosition.mPercentHeight = f;
            }
            int i2 = keyPosition.mFramePosition;
        }
    }

    public KeyPosition() {
        this.mType = 2;
    }

    private void calcCartesianPosition(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float f7 = 0.0f;
        float f8 = Float.isNaN(this.mPercentX) ? 0.0f : this.mPercentX;
        float f9 = Float.isNaN(this.mAltPercentY) ? 0.0f : this.mAltPercentY;
        float f10 = Float.isNaN(this.mPercentY) ? 0.0f : this.mPercentY;
        if (!Float.isNaN(this.mAltPercentX)) {
            f7 = this.mAltPercentX;
        }
        this.mCalculatedPositionX = (int) ((f7 * f6) + (f8 * f5) + f);
        this.mCalculatedPositionY = (int) ((f6 * f10) + (f5 * f9) + f2);
    }

    private void calcPathPosition(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float f7 = this.mPercentX;
        float f8 = (f5 * f7) + f;
        float f9 = this.mPercentY;
        this.mCalculatedPositionX = ((-f6) * f9) + f8;
        this.mCalculatedPositionY = (f5 * f9) + (f6 * f7) + f2;
    }

    private void calcScreenPosition(int i, int i2) {
        float f = this.mPercentX;
        float f2 = 0;
        this.mCalculatedPositionX = ((i - 0) * f) + f2;
        this.mCalculatedPositionY = ((i2 - 0) * f) + f2;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void calcPosition(int i, int i2, float f, float f2, float f3, float f4) {
        int i3 = this.mPositionType;
        if (i3 == 1) {
            calcPathPosition(f, f2, f3, f4);
        } else if (i3 != 2) {
            calcCartesianPosition(f, f2, f3, f4);
        } else {
            calcScreenPosition(i, i2);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public float getPositionX() {
        return this.mCalculatedPositionX;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public float getPositionY() {
        return this.mCalculatedPositionY;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public boolean intersects(int i, int i2, RectF rectF, RectF rectF2, float f, float f2) {
        calcPosition(i, i2, rectF.centerX(), rectF.centerY(), rectF2.centerX(), rectF2.centerY());
        return Math.abs(f - this.mCalculatedPositionX) < 20.0f && Math.abs(f2 - this.mCalculatedPositionY) < 20.0f;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, C0186R.styleable.KeyPosition));
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void positionAttributes(View view, RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        int i = this.mPositionType;
        if (i == 1) {
            positionPathAttributes(rectF, rectF2, f, f2, strArr, fArr);
        } else if (i != 2) {
            positionCartAttributes(rectF, rectF2, f, f2, strArr, fArr);
        } else {
            positionScreenAttributes(view, rectF, rectF2, f, f2, strArr, fArr);
        }
    }

    public void positionCartAttributes(RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
        if (strArr[0] == null) {
            strArr[0] = PERCENT_X;
            fArr[0] = (f - centerX) / centerX2;
            strArr[1] = PERCENT_Y;
            fArr[1] = (f2 - centerY) / centerY2;
            return;
        }
        float f3 = (f - centerX) / centerX2;
        if (PERCENT_X.equals(strArr[0])) {
            fArr[0] = f3;
            fArr[1] = (f2 - centerY) / centerY2;
            return;
        }
        fArr[1] = f3;
        fArr[0] = (f2 - centerY) / centerY2;
    }

    public void positionPathAttributes(RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
        float hypot = (float) Math.hypot(centerX2, centerY2);
        if (hypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f3 = centerX2 / hypot;
        float f4 = centerY2 / hypot;
        float f5 = f2 - centerY;
        float f6 = f - centerX;
        float f7 = ((f3 * f5) - (f6 * f4)) / hypot;
        float f8 = ((f4 * f5) + (f3 * f6)) / hypot;
        if (strArr[0] != null) {
            if (!PERCENT_X.equals(strArr[0])) {
                return;
            }
            fArr[0] = f8;
            fArr[1] = f7;
            return;
        }
        strArr[0] = PERCENT_X;
        strArr[1] = PERCENT_Y;
        fArr[0] = f8;
        fArr[1] = f7;
    }

    public void positionScreenAttributes(View view, RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        rectF.centerX();
        rectF.centerY();
        rectF2.centerX();
        rectF2.centerY();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        if (strArr[0] == null) {
            strArr[0] = PERCENT_X;
            fArr[0] = f / width;
            strArr[1] = PERCENT_Y;
            fArr[1] = f2 / height;
            return;
        }
        float f3 = f / width;
        if (PERCENT_X.equals(strArr[0])) {
            fArr[0] = f3;
            fArr[1] = f2 / height;
            return;
        }
        fArr[1] = f3;
        fArr[0] = f2 / height;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        char c;
        float f;
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 428090547:
                if (str.equals(PERCENT_X)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 428090548:
                if (str.equals(PERCENT_Y)) {
                    c = 6;
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
                this.mTransitionEasing = obj.toString();
                return;
            case 1:
                this.mDrawPath = toInt(obj);
                return;
            case 2:
                this.mPercentWidth = toFloat(obj);
                return;
            case 3:
                f = toFloat(obj);
                break;
            case 4:
                f = toFloat(obj);
                this.mPercentWidth = f;
                break;
            case 5:
                this.mPercentX = toFloat(obj);
                return;
            case 6:
                this.mPercentY = toFloat(obj);
                return;
            default:
                return;
        }
        this.mPercentHeight = f;
    }
}

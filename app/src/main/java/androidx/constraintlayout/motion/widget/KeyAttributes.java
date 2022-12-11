package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.widget.C0186R;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class KeyAttributes extends Key {
    public static final int KEY_TYPE = 1;
    public static final String NAME = "KeyAttribute";
    public static final String TAG = "KeyAttribute";
    public String mTransitionEasing;
    public int mCurveFit = -1;
    public boolean mVisibility = false;
    public float mAlpha = Float.NaN;
    public float mElevation = Float.NaN;
    public float mRotation = Float.NaN;
    public float mRotationX = Float.NaN;
    public float mRotationY = Float.NaN;
    public float mPivotX = Float.NaN;
    public float mPivotY = Float.NaN;
    public float mTransitionPathRotate = Float.NaN;
    public float mScaleX = Float.NaN;
    public float mScaleY = Float.NaN;
    public float mTranslationX = Float.NaN;
    public float mTranslationY = Float.NaN;
    public float mTranslationZ = Float.NaN;
    public float mProgress = Float.NaN;

    /* loaded from: classes3.dex */
    public static class Loader {
        public static final int ANDROID_ALPHA = 1;
        public static final int ANDROID_ELEVATION = 2;
        public static final int ANDROID_PIVOT_X = 19;
        public static final int ANDROID_PIVOT_Y = 20;
        public static final int ANDROID_ROTATION = 4;
        public static final int ANDROID_ROTATION_X = 5;
        public static final int ANDROID_ROTATION_Y = 6;
        public static final int ANDROID_SCALE_X = 7;
        public static final int ANDROID_SCALE_Y = 14;
        public static final int ANDROID_TRANSLATION_X = 15;
        public static final int ANDROID_TRANSLATION_Y = 16;
        public static final int ANDROID_TRANSLATION_Z = 17;
        public static final int CURVE_FIT = 13;
        public static final int FRAME_POSITION = 12;
        public static final int PROGRESS = 18;
        public static final int TARGET_ID = 10;
        public static final int TRANSITION_EASING = 9;
        public static final int TRANSITION_PATH_ROTATE = 8;
        public static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(C0186R.styleable.KeyAttribute_android_alpha, 1);
            mAttrMap.append(C0186R.styleable.KeyAttribute_android_elevation, 2);
            mAttrMap.append(C0186R.styleable.KeyAttribute_android_rotation, 4);
            mAttrMap.append(C0186R.styleable.KeyAttribute_android_rotationX, 5);
            mAttrMap.append(C0186R.styleable.KeyAttribute_android_rotationY, 6);
            mAttrMap.append(C0186R.styleable.KeyAttribute_android_transformPivotX, 19);
            mAttrMap.append(C0186R.styleable.KeyAttribute_android_transformPivotY, 20);
            mAttrMap.append(C0186R.styleable.KeyAttribute_android_scaleX, 7);
            mAttrMap.append(C0186R.styleable.KeyAttribute_transitionPathRotate, 8);
            mAttrMap.append(C0186R.styleable.KeyAttribute_transitionEasing, 9);
            mAttrMap.append(C0186R.styleable.KeyAttribute_motionTarget, 10);
            mAttrMap.append(C0186R.styleable.KeyAttribute_framePosition, 12);
            mAttrMap.append(C0186R.styleable.KeyAttribute_curveFit, 13);
            mAttrMap.append(C0186R.styleable.KeyAttribute_android_scaleY, 14);
            mAttrMap.append(C0186R.styleable.KeyAttribute_android_translationX, 15);
            mAttrMap.append(C0186R.styleable.KeyAttribute_android_translationY, 16);
            mAttrMap.append(C0186R.styleable.KeyAttribute_android_translationZ, 17);
            mAttrMap.append(C0186R.styleable.KeyAttribute_motionProgress, 18);
        }

        public static void read(KeyAttributes keyAttributes, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        keyAttributes.mAlpha = typedArray.getFloat(index, keyAttributes.mAlpha);
                        break;
                    case 2:
                        keyAttributes.mElevation = typedArray.getDimension(index, keyAttributes.mElevation);
                        break;
                    case 3:
                    case 11:
                    default:
                        Integer.toHexString(index);
                        mAttrMap.get(index);
                        break;
                    case 4:
                        keyAttributes.mRotation = typedArray.getFloat(index, keyAttributes.mRotation);
                        break;
                    case 5:
                        keyAttributes.mRotationX = typedArray.getFloat(index, keyAttributes.mRotationX);
                        break;
                    case 6:
                        keyAttributes.mRotationY = typedArray.getFloat(index, keyAttributes.mRotationY);
                        break;
                    case 7:
                        keyAttributes.mScaleX = typedArray.getFloat(index, keyAttributes.mScaleX);
                        break;
                    case 8:
                        keyAttributes.mTransitionPathRotate = typedArray.getFloat(index, keyAttributes.mTransitionPathRotate);
                        break;
                    case 9:
                        keyAttributes.mTransitionEasing = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                            keyAttributes.mTargetId = resourceId;
                            if (resourceId != -1) {
                                break;
                            }
                            keyAttributes.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            if (typedArray.peekValue(index).type != 3) {
                                keyAttributes.mTargetId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                                break;
                            }
                            keyAttributes.mTargetString = typedArray.getString(index);
                        }
                    case 12:
                        keyAttributes.mFramePosition = typedArray.getInt(index, keyAttributes.mFramePosition);
                        break;
                    case 13:
                        keyAttributes.mCurveFit = typedArray.getInteger(index, keyAttributes.mCurveFit);
                        break;
                    case 14:
                        keyAttributes.mScaleY = typedArray.getFloat(index, keyAttributes.mScaleY);
                        break;
                    case 15:
                        keyAttributes.mTranslationX = typedArray.getDimension(index, keyAttributes.mTranslationX);
                        break;
                    case 16:
                        keyAttributes.mTranslationY = typedArray.getDimension(index, keyAttributes.mTranslationY);
                        break;
                    case 17:
                        keyAttributes.mTranslationZ = typedArray.getDimension(index, keyAttributes.mTranslationZ);
                        break;
                    case 18:
                        keyAttributes.mProgress = typedArray.getFloat(index, keyAttributes.mProgress);
                        break;
                    case 19:
                        keyAttributes.mPivotX = typedArray.getDimension(index, keyAttributes.mPivotX);
                        break;
                    case 20:
                        keyAttributes.mPivotY = typedArray.getDimension(index, keyAttributes.mPivotY);
                        break;
                }
            }
        }
    }

    public KeyAttributes() {
        this.mType = 1;
        this.mCustomConstraints = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0054, code lost:
        if (r1.equals(androidx.constraintlayout.motion.widget.Key.TRANSITION_PATH_ROTATE) != false) goto L12;
     */
    @Override // androidx.constraintlayout.motion.widget.Key
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addValues(HashMap<String, SplineSet> hashMap) {
        int i;
        float f;
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            SplineSet splineSet = hashMap.get(next);
            char c = 7;
            if (!next.startsWith(Key.CUSTOM)) {
                switch (next.hashCode()) {
                    case -1249320806:
                        if (next.equals(Key.ROTATION_X)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1249320805:
                        if (next.equals(Key.ROTATION_Y)) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1225497657:
                        if (next.equals(Key.TRANSLATION_X)) {
                            c = '\n';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1225497656:
                        if (next.equals(Key.TRANSLATION_Y)) {
                            c = 11;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1225497655:
                        if (next.equals(Key.TRANSLATION_Z)) {
                            c = '\f';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1001078227:
                        if (next.equals("progress")) {
                            c = '\r';
                            break;
                        }
                        c = 65535;
                        break;
                    case -908189618:
                        if (next.equals(Key.SCALE_X)) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case -908189617:
                        if (next.equals(Key.SCALE_Y)) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    case -760884510:
                        if (next.equals(Key.PIVOT_X)) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case -760884509:
                        if (next.equals(Key.PIVOT_Y)) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case -40300674:
                        if (next.equals(Key.ROTATION)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -4379043:
                        if (next.equals(Key.ELEVATION)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 37232917:
                        break;
                    case 92909918:
                        if (next.equals(Key.ALPHA)) {
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
                        if (Float.isNaN(this.mAlpha)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mAlpha;
                            splineSet.setPoint(i, f);
                            break;
                        }
                    case 1:
                        if (Float.isNaN(this.mElevation)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mElevation;
                            splineSet.setPoint(i, f);
                            break;
                        }
                    case 2:
                        if (Float.isNaN(this.mRotation)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mRotation;
                            splineSet.setPoint(i, f);
                            break;
                        }
                    case 3:
                        if (Float.isNaN(this.mRotationX)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mRotationX;
                            splineSet.setPoint(i, f);
                            break;
                        }
                    case 4:
                        if (Float.isNaN(this.mRotationY)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mRotationY;
                            splineSet.setPoint(i, f);
                            break;
                        }
                    case 5:
                        if (Float.isNaN(this.mRotationX)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mPivotX;
                            splineSet.setPoint(i, f);
                            break;
                        }
                    case 6:
                        if (Float.isNaN(this.mRotationY)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mPivotY;
                            splineSet.setPoint(i, f);
                            break;
                        }
                    case 7:
                        if (Float.isNaN(this.mTransitionPathRotate)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mTransitionPathRotate;
                            splineSet.setPoint(i, f);
                            break;
                        }
                    case '\b':
                        if (Float.isNaN(this.mScaleX)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mScaleX;
                            splineSet.setPoint(i, f);
                            break;
                        }
                    case '\t':
                        if (Float.isNaN(this.mScaleY)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mScaleY;
                            splineSet.setPoint(i, f);
                            break;
                        }
                    case '\n':
                        if (Float.isNaN(this.mTranslationX)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mTranslationX;
                            splineSet.setPoint(i, f);
                            break;
                        }
                    case 11:
                        if (Float.isNaN(this.mTranslationY)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mTranslationY;
                            splineSet.setPoint(i, f);
                            break;
                        }
                    case '\f':
                        if (Float.isNaN(this.mTranslationZ)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mTranslationZ;
                            splineSet.setPoint(i, f);
                            break;
                        }
                    case '\r':
                        if (Float.isNaN(this.mProgress)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mProgress;
                            splineSet.setPoint(i, f);
                            break;
                        }
                }
            } else {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(next.substring(7));
                if (constraintAttribute != null) {
                    ((SplineSet.CustomSet) splineSet).setPoint(this.mFramePosition, constraintAttribute);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add(Key.ALPHA);
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add(Key.ELEVATION);
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add(Key.ROTATION_X);
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add(Key.ROTATION_Y);
        }
        if (!Float.isNaN(this.mPivotX)) {
            hashSet.add(Key.PIVOT_X);
        }
        if (!Float.isNaN(this.mPivotY)) {
            hashSet.add(Key.PIVOT_Y);
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add(Key.TRANSLATION_X);
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add(Key.TRANSLATION_Y);
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add(Key.TRANSLATION_Z);
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add(Key.TRANSITION_PATH_ROTATE);
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add(Key.SCALE_X);
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add(Key.SCALE_Y);
        }
        if (!Float.isNaN(this.mProgress)) {
            hashSet.add("progress");
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, C0186R.styleable.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> hashMap) {
        if (this.mCurveFit == -1) {
            return;
        }
        if (!Float.isNaN(this.mAlpha)) {
            hashMap.put(Key.ALPHA, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mElevation)) {
            hashMap.put(Key.ELEVATION, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotation)) {
            hashMap.put(Key.ROTATION, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashMap.put(Key.ROTATION_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashMap.put(Key.ROTATION_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mPivotX)) {
            hashMap.put(Key.PIVOT_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mPivotY)) {
            hashMap.put(Key.PIVOT_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashMap.put(Key.TRANSLATION_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashMap.put(Key.TRANSLATION_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashMap.put(Key.TRANSLATION_Z, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashMap.put(Key.TRANSITION_PATH_ROTATE, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashMap.put(Key.SCALE_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashMap.put(Key.SCALE_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mProgress)) {
            hashMap.put("progress", Integer.valueOf(this.mCurveFit));
        }
        if (this.mCustomConstraints.size() <= 0) {
            return;
        }
        for (String str : this.mCustomConstraints.keySet()) {
            hashMap.put(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("CUSTOM,", str), Integer.valueOf(this.mCurveFit));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        char c;
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals("motionProgress")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1249320806:
                if (str.equals(Key.ROTATION_X)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (str.equals(Key.ROTATION_Y)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (str.equals(Key.TRANSLATION_X)) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals(Key.TRANSLATION_Y)) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals(Key.SCALE_X)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals(Key.SCALE_Y)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -4379043:
                if (str.equals(Key.ELEVATION)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 37232917:
                if (str.equals(Key.TRANSITION_PATH_ROTATE)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 92909918:
                if (str.equals(Key.ALPHA)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1317633238:
                if (str.equals("mTranslationZ")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c = '\f';
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
                this.mAlpha = toFloat(obj);
                return;
            case 1:
                this.mCurveFit = toInt(obj);
                return;
            case 2:
                this.mElevation = toFloat(obj);
                return;
            case 3:
                this.mProgress = toFloat(obj);
                return;
            case 4:
                this.mRotation = toFloat(obj);
                return;
            case 5:
                this.mRotationX = toFloat(obj);
                return;
            case 6:
                this.mRotationY = toFloat(obj);
                return;
            case 7:
                this.mPivotX = toFloat(obj);
                return;
            case '\b':
                this.mPivotY = toFloat(obj);
                return;
            case '\t':
                this.mScaleX = toFloat(obj);
                return;
            case '\n':
                this.mScaleY = toFloat(obj);
                return;
            case 11:
                this.mTransitionEasing = obj.toString();
                return;
            case '\f':
                this.mVisibility = toBoolean(obj);
                return;
            case '\r':
                this.mTransitionPathRotate = toFloat(obj);
                return;
            case 14:
                this.mTranslationX = toFloat(obj);
                return;
            case 15:
                this.mTranslationY = toFloat(obj);
                return;
            case 16:
                this.mTranslationZ = toFloat(obj);
                return;
            default:
                return;
        }
    }
}

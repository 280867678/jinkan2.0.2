package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import androidx.constraintlayout.widget.C0186R;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class KeyTimeCycle extends Key {
    public static final int KEY_TYPE = 3;
    public static final String NAME = "KeyTimeCycle";
    public static final String TAG = "KeyTimeCycle";
    public String mTransitionEasing;
    public CurveFit mWaveOffsetSpline;
    public CurveFit mWavePeriodSpline;
    public int mCurveFit = -1;
    public float mAlpha = Float.NaN;
    public float mElevation = Float.NaN;
    public float mRotation = Float.NaN;
    public float mRotationX = Float.NaN;
    public float mRotationY = Float.NaN;
    public float mTransitionPathRotate = Float.NaN;
    public float mScaleX = Float.NaN;
    public float mScaleY = Float.NaN;
    public float mTranslationX = Float.NaN;
    public float mTranslationY = Float.NaN;
    public float mTranslationZ = Float.NaN;
    public float mProgress = Float.NaN;
    public int mWaveShape = 0;
    public float mWavePeriod = Float.NaN;
    public float mWaveOffset = 0.0f;

    /* loaded from: classes3.dex */
    public static class Loader {
        public static final int ANDROID_ALPHA = 1;
        public static final int ANDROID_ELEVATION = 2;
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
        public static final int WAVE_OFFSET = 21;
        public static final int WAVE_PERIOD = 20;
        public static final int WAVE_SHAPE = 19;
        public static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(C0186R.styleable.KeyTimeCycle_android_alpha, 1);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_android_elevation, 2);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_android_rotation, 4);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_android_rotationX, 5);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_android_rotationY, 6);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_android_scaleX, 7);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_transitionPathRotate, 8);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_transitionEasing, 9);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_motionTarget, 10);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_framePosition, 12);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_curveFit, 13);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_android_scaleY, 14);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_android_translationX, 15);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_android_translationY, 16);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_android_translationZ, 17);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_motionProgress, 18);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_wavePeriod, 20);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_waveOffset, 21);
            mAttrMap.append(C0186R.styleable.KeyTimeCycle_waveShape, 19);
        }

        public static void read(KeyTimeCycle keyTimeCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        keyTimeCycle.mAlpha = typedArray.getFloat(index, keyTimeCycle.mAlpha);
                        break;
                    case 2:
                        keyTimeCycle.mElevation = typedArray.getDimension(index, keyTimeCycle.mElevation);
                        break;
                    case 3:
                    case 11:
                    default:
                        Integer.toHexString(index);
                        mAttrMap.get(index);
                        break;
                    case 4:
                        keyTimeCycle.mRotation = typedArray.getFloat(index, keyTimeCycle.mRotation);
                        break;
                    case 5:
                        keyTimeCycle.mRotationX = typedArray.getFloat(index, keyTimeCycle.mRotationX);
                        break;
                    case 6:
                        keyTimeCycle.mRotationY = typedArray.getFloat(index, keyTimeCycle.mRotationY);
                        break;
                    case 7:
                        keyTimeCycle.mScaleX = typedArray.getFloat(index, keyTimeCycle.mScaleX);
                        break;
                    case 8:
                        keyTimeCycle.mTransitionPathRotate = typedArray.getFloat(index, keyTimeCycle.mTransitionPathRotate);
                        break;
                    case 9:
                        keyTimeCycle.mTransitionEasing = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyTimeCycle.mTargetId);
                            keyTimeCycle.mTargetId = resourceId;
                            if (resourceId != -1) {
                                break;
                            }
                            keyTimeCycle.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            if (typedArray.peekValue(index).type != 3) {
                                keyTimeCycle.mTargetId = typedArray.getResourceId(index, keyTimeCycle.mTargetId);
                                break;
                            }
                            keyTimeCycle.mTargetString = typedArray.getString(index);
                        }
                    case 12:
                        keyTimeCycle.mFramePosition = typedArray.getInt(index, keyTimeCycle.mFramePosition);
                        break;
                    case 13:
                        keyTimeCycle.mCurveFit = typedArray.getInteger(index, keyTimeCycle.mCurveFit);
                        break;
                    case 14:
                        keyTimeCycle.mScaleY = typedArray.getFloat(index, keyTimeCycle.mScaleY);
                        break;
                    case 15:
                        keyTimeCycle.mTranslationX = typedArray.getDimension(index, keyTimeCycle.mTranslationX);
                        break;
                    case 16:
                        keyTimeCycle.mTranslationY = typedArray.getDimension(index, keyTimeCycle.mTranslationY);
                        break;
                    case 17:
                        keyTimeCycle.mTranslationZ = typedArray.getDimension(index, keyTimeCycle.mTranslationZ);
                        break;
                    case 18:
                        keyTimeCycle.mProgress = typedArray.getFloat(index, keyTimeCycle.mProgress);
                        break;
                    case 19:
                        keyTimeCycle.mWaveShape = typedArray.getInt(index, keyTimeCycle.mWaveShape);
                        break;
                    case 20:
                        keyTimeCycle.mWavePeriod = typedArray.getFloat(index, keyTimeCycle.mWavePeriod);
                        break;
                    case 21:
                        keyTimeCycle.mWaveOffset = typedArray.peekValue(index).type == 5 ? typedArray.getDimension(index, keyTimeCycle.mWaveOffset) : typedArray.getFloat(index, keyTimeCycle.mWaveOffset);
                        break;
                }
            }
        }
    }

    public KeyTimeCycle() {
        this.mType = 3;
        this.mCustomConstraints = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x007c, code lost:
        if (r1.equals(androidx.constraintlayout.motion.widget.Key.SCALE_Y) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addTimeValues(HashMap<String, TimeCycleSplineSet> hashMap) {
        int i;
        float f;
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            TimeCycleSplineSet timeCycleSplineSet = hashMap.get(next);
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
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1225497656:
                        if (next.equals(Key.TRANSLATION_Y)) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1225497655:
                        if (next.equals(Key.TRANSLATION_Z)) {
                            c = '\n';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1001078227:
                        if (next.equals("progress")) {
                            c = 11;
                            break;
                        }
                        c = 65535;
                        break;
                    case -908189618:
                        if (next.equals(Key.SCALE_X)) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case -908189617:
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
                        if (next.equals(Key.TRANSITION_PATH_ROTATE)) {
                            c = 5;
                            break;
                        }
                        c = 65535;
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
                            timeCycleSplineSet.setPoint(i, f, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 1:
                        if (Float.isNaN(this.mElevation)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mElevation;
                            timeCycleSplineSet.setPoint(i, f, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 2:
                        if (Float.isNaN(this.mRotation)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mRotation;
                            timeCycleSplineSet.setPoint(i, f, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 3:
                        if (Float.isNaN(this.mRotationX)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mRotationX;
                            timeCycleSplineSet.setPoint(i, f, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 4:
                        if (Float.isNaN(this.mRotationY)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mRotationY;
                            timeCycleSplineSet.setPoint(i, f, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 5:
                        if (Float.isNaN(this.mTransitionPathRotate)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mTransitionPathRotate;
                            timeCycleSplineSet.setPoint(i, f, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 6:
                        if (Float.isNaN(this.mScaleX)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mScaleX;
                            timeCycleSplineSet.setPoint(i, f, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 7:
                        if (Float.isNaN(this.mScaleY)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mScaleY;
                            timeCycleSplineSet.setPoint(i, f, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case '\b':
                        if (Float.isNaN(this.mTranslationX)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mTranslationX;
                            timeCycleSplineSet.setPoint(i, f, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case '\t':
                        if (Float.isNaN(this.mTranslationY)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mTranslationY;
                            timeCycleSplineSet.setPoint(i, f, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case '\n':
                        if (Float.isNaN(this.mTranslationZ)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mTranslationZ;
                            timeCycleSplineSet.setPoint(i, f, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 11:
                        if (Float.isNaN(this.mProgress)) {
                            break;
                        } else {
                            i = this.mFramePosition;
                            f = this.mProgress;
                            timeCycleSplineSet.setPoint(i, f, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                }
            } else {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(next.substring(7));
                if (constraintAttribute != null) {
                    ((TimeCycleSplineSet.CustomSet) timeCycleSplineSet).setPoint(this.mFramePosition, constraintAttribute, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
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
        if (!Float.isNaN(this.mScaleY)) {
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
        Loader.read(this, context.obtainStyledAttributes(attributeSet, C0186R.styleable.KeyTimeCycle));
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
        if (!Float.isNaN(this.mScaleX)) {
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
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c = '\t';
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
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals(Key.TRANSLATION_Y)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals(Key.SCALE_X)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals(Key.SCALE_Y)) {
                    c = '\b';
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
                    c = '\n';
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
                    c = '\r';
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
                this.mScaleX = toFloat(obj);
                return;
            case '\b':
                this.mScaleY = toFloat(obj);
                return;
            case '\t':
                this.mTransitionEasing = obj.toString();
                return;
            case '\n':
                this.mTransitionPathRotate = toFloat(obj);
                return;
            case 11:
                this.mTranslationX = toFloat(obj);
                return;
            case '\f':
                this.mTranslationY = toFloat(obj);
                return;
            case '\r':
                this.mTranslationZ = toFloat(obj);
                return;
            default:
                return;
        }
    }
}

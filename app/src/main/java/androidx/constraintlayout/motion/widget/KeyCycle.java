package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.C0186R;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class KeyCycle extends Key {
    public static final int KEY_TYPE = 4;
    public static final String NAME = "KeyCycle";
    public static final String TAG = "KeyCycle";
    public String mTransitionEasing = null;
    public int mCurveFit = 0;
    public int mWaveShape = -1;
    public float mWavePeriod = Float.NaN;
    public float mWaveOffset = 0.0f;
    public float mProgress = Float.NaN;
    public int mWaveVariesBy = -1;
    public float mAlpha = Float.NaN;
    public float mElevation = Float.NaN;
    public float mRotation = Float.NaN;
    public float mTransitionPathRotate = Float.NaN;
    public float mRotationX = Float.NaN;
    public float mRotationY = Float.NaN;
    public float mScaleX = Float.NaN;
    public float mScaleY = Float.NaN;
    public float mTranslationX = Float.NaN;
    public float mTranslationY = Float.NaN;
    public float mTranslationZ = Float.NaN;

    /* loaded from: classes3.dex */
    public static class Loader {
        public static final int ANDROID_ALPHA = 9;
        public static final int ANDROID_ELEVATION = 10;
        public static final int ANDROID_ROTATION = 11;
        public static final int ANDROID_ROTATION_X = 12;
        public static final int ANDROID_ROTATION_Y = 13;
        public static final int ANDROID_SCALE_X = 15;
        public static final int ANDROID_SCALE_Y = 16;
        public static final int ANDROID_TRANSLATION_X = 17;
        public static final int ANDROID_TRANSLATION_Y = 18;
        public static final int ANDROID_TRANSLATION_Z = 19;
        public static final int CURVE_FIT = 4;
        public static final int FRAME_POSITION = 2;
        public static final int PROGRESS = 20;
        public static final int TARGET_ID = 1;
        public static final int TRANSITION_EASING = 3;
        public static final int TRANSITION_PATH_ROTATE = 14;
        public static final int WAVE_OFFSET = 7;
        public static final int WAVE_PERIOD = 6;
        public static final int WAVE_SHAPE = 5;
        public static final int WAVE_VARIES_BY = 8;
        public static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(C0186R.styleable.KeyCycle_motionTarget, 1);
            mAttrMap.append(C0186R.styleable.KeyCycle_framePosition, 2);
            mAttrMap.append(C0186R.styleable.KeyCycle_transitionEasing, 3);
            mAttrMap.append(C0186R.styleable.KeyCycle_curveFit, 4);
            mAttrMap.append(C0186R.styleable.KeyCycle_waveShape, 5);
            mAttrMap.append(C0186R.styleable.KeyCycle_wavePeriod, 6);
            mAttrMap.append(C0186R.styleable.KeyCycle_waveOffset, 7);
            mAttrMap.append(C0186R.styleable.KeyCycle_waveVariesBy, 8);
            mAttrMap.append(C0186R.styleable.KeyCycle_android_alpha, 9);
            mAttrMap.append(C0186R.styleable.KeyCycle_android_elevation, 10);
            mAttrMap.append(C0186R.styleable.KeyCycle_android_rotation, 11);
            mAttrMap.append(C0186R.styleable.KeyCycle_android_rotationX, 12);
            mAttrMap.append(C0186R.styleable.KeyCycle_android_rotationY, 13);
            mAttrMap.append(C0186R.styleable.KeyCycle_transitionPathRotate, 14);
            mAttrMap.append(C0186R.styleable.KeyCycle_android_scaleX, 15);
            mAttrMap.append(C0186R.styleable.KeyCycle_android_scaleY, 16);
            mAttrMap.append(C0186R.styleable.KeyCycle_android_translationX, 17);
            mAttrMap.append(C0186R.styleable.KeyCycle_android_translationY, 18);
            mAttrMap.append(C0186R.styleable.KeyCycle_android_translationZ, 19);
            mAttrMap.append(C0186R.styleable.KeyCycle_motionProgress, 20);
        }

        public static void read(KeyCycle keyCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyCycle.mTargetId);
                            keyCycle.mTargetId = resourceId;
                            if (resourceId != -1) {
                                break;
                            }
                            keyCycle.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            if (typedArray.peekValue(index).type != 3) {
                                keyCycle.mTargetId = typedArray.getResourceId(index, keyCycle.mTargetId);
                                break;
                            }
                            keyCycle.mTargetString = typedArray.getString(index);
                        }
                    case 2:
                        keyCycle.mFramePosition = typedArray.getInt(index, keyCycle.mFramePosition);
                        break;
                    case 3:
                        keyCycle.mTransitionEasing = typedArray.getString(index);
                        break;
                    case 4:
                        keyCycle.mCurveFit = typedArray.getInteger(index, keyCycle.mCurveFit);
                        break;
                    case 5:
                        keyCycle.mWaveShape = typedArray.getInt(index, keyCycle.mWaveShape);
                        break;
                    case 6:
                        keyCycle.mWavePeriod = typedArray.getFloat(index, keyCycle.mWavePeriod);
                        break;
                    case 7:
                        keyCycle.mWaveOffset = typedArray.peekValue(index).type == 5 ? typedArray.getDimension(index, keyCycle.mWaveOffset) : typedArray.getFloat(index, keyCycle.mWaveOffset);
                        break;
                    case 8:
                        keyCycle.mWaveVariesBy = typedArray.getInt(index, keyCycle.mWaveVariesBy);
                        break;
                    case 9:
                        keyCycle.mAlpha = typedArray.getFloat(index, keyCycle.mAlpha);
                        break;
                    case 10:
                        keyCycle.mElevation = typedArray.getDimension(index, keyCycle.mElevation);
                        break;
                    case 11:
                        keyCycle.mRotation = typedArray.getFloat(index, keyCycle.mRotation);
                        break;
                    case 12:
                        keyCycle.mRotationX = typedArray.getFloat(index, keyCycle.mRotationX);
                        break;
                    case 13:
                        keyCycle.mRotationY = typedArray.getFloat(index, keyCycle.mRotationY);
                        break;
                    case 14:
                        keyCycle.mTransitionPathRotate = typedArray.getFloat(index, keyCycle.mTransitionPathRotate);
                        break;
                    case 15:
                        keyCycle.mScaleX = typedArray.getFloat(index, keyCycle.mScaleX);
                        break;
                    case 16:
                        keyCycle.mScaleY = typedArray.getFloat(index, keyCycle.mScaleY);
                        break;
                    case 17:
                        keyCycle.mTranslationX = typedArray.getDimension(index, keyCycle.mTranslationX);
                        break;
                    case 18:
                        keyCycle.mTranslationY = typedArray.getDimension(index, keyCycle.mTranslationY);
                        break;
                    case 19:
                        keyCycle.mTranslationZ = typedArray.getDimension(index, keyCycle.mTranslationZ);
                        break;
                    case 20:
                        keyCycle.mProgress = typedArray.getFloat(index, keyCycle.mProgress);
                        break;
                    default:
                        Integer.toHexString(index);
                        mAttrMap.get(index);
                        break;
                }
            }
        }
    }

    public KeyCycle() {
        this.mType = 4;
        this.mCustomConstraints = new HashMap<>();
    }

    public void addCycleValues(HashMap<String, KeyCycleOscillator> hashMap) {
        for (String str : hashMap.keySet()) {
            if (str.startsWith(Key.CUSTOM)) {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str.substring(7));
                if (constraintAttribute != null && constraintAttribute.getType() == ConstraintAttribute.AttributeType.FLOAT_TYPE) {
                    hashMap.get(str).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, constraintAttribute.getValueToInterpolate(), constraintAttribute);
                }
            }
            float value = getValue(str);
            if (!Float.isNaN(value)) {
                hashMap.get(str).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, value);
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
        int i;
        float f;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("add ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(hashMap.size());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" values");
        Debug.logStack("KeyCycle", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), 2);
        for (String str : hashMap.keySet()) {
            SplineSet splineSet = hashMap.get(str);
            char c = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals(Key.ROTATION_X)) {
                        c = 3;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals(Key.ROTATION_Y)) {
                        c = 4;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals(Key.TRANSLATION_X)) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals(Key.TRANSLATION_Y)) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals(Key.TRANSLATION_Z)) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals(Key.SCALE_X)) {
                        c = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals(Key.SCALE_Y)) {
                        c = 7;
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals(Key.ROTATION)) {
                        c = 2;
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals(Key.ELEVATION)) {
                        c = 1;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals(Key.TRANSITION_PATH_ROTATE)) {
                        c = 5;
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals(Key.ALPHA)) {
                        c = 0;
                        break;
                    }
                    break;
                case 156108012:
                    if (str.equals(Key.WAVE_OFFSET)) {
                        c = 11;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    i = this.mFramePosition;
                    f = this.mAlpha;
                    break;
                case 1:
                    i = this.mFramePosition;
                    f = this.mElevation;
                    break;
                case 2:
                    i = this.mFramePosition;
                    f = this.mRotation;
                    break;
                case 3:
                    i = this.mFramePosition;
                    f = this.mRotationX;
                    break;
                case 4:
                    i = this.mFramePosition;
                    f = this.mRotationY;
                    break;
                case 5:
                    i = this.mFramePosition;
                    f = this.mTransitionPathRotate;
                    break;
                case 6:
                    i = this.mFramePosition;
                    f = this.mScaleX;
                    break;
                case 7:
                    i = this.mFramePosition;
                    f = this.mScaleY;
                    break;
                case '\b':
                    i = this.mFramePosition;
                    f = this.mTranslationX;
                    break;
                case '\t':
                    i = this.mFramePosition;
                    f = this.mTranslationY;
                    break;
                case '\n':
                    i = this.mFramePosition;
                    f = this.mTranslationZ;
                    break;
                case 11:
                    i = this.mFramePosition;
                    f = this.mWaveOffset;
                    break;
                case '\f':
                    i = this.mFramePosition;
                    f = this.mProgress;
                    break;
            }
            splineSet.setPoint(i, f);
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
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add(Key.SCALE_X);
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add(Key.SCALE_Y);
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add(Key.TRANSITION_PATH_ROTATE);
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
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public float getValue(String str) {
        char c;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals(Key.ROTATION_X)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (str.equals(Key.ROTATION_Y)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (str.equals(Key.TRANSLATION_X)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals(Key.TRANSLATION_Y)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals(Key.TRANSLATION_Z)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals(Key.SCALE_X)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals(Key.SCALE_Y)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -4379043:
                if (str.equals(Key.ELEVATION)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 37232917:
                if (str.equals(Key.TRANSITION_PATH_ROTATE)) {
                    c = 5;
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
            case 156108012:
                if (str.equals(Key.WAVE_OFFSET)) {
                    c = 11;
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
                return this.mAlpha;
            case 1:
                return this.mElevation;
            case 2:
                return this.mRotation;
            case 3:
                return this.mRotationX;
            case 4:
                return this.mRotationY;
            case 5:
                return this.mTransitionPathRotate;
            case 6:
                return this.mScaleX;
            case 7:
                return this.mScaleY;
            case '\b':
                return this.mTranslationX;
            case '\t':
                return this.mTranslationY;
            case '\n':
                return this.mTranslationZ;
            case 11:
                return this.mWaveOffset;
            case '\f':
                return this.mProgress;
            default:
                return Float.NaN;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, C0186R.styleable.KeyCycle));
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
            case 156108012:
                if (str.equals(Key.WAVE_OFFSET)) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 184161818:
                if (str.equals(Key.WAVE_PERIOD)) {
                    c = 14;
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
            case 14:
                this.mWavePeriod = toFloat(obj);
                return;
            case 15:
                this.mWaveOffset = toFloat(obj);
                return;
            default:
                return;
        }
    }
}

package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    public static final int OFF_HEIGHT = 4;
    public static final int OFF_PATH_ROTATE = 5;
    public static final int OFF_POSITION = 0;
    public static final int OFF_WIDTH = 3;
    public static final int OFF_X = 1;
    public static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 3;
    public static final String TAG = "MotionPaths";
    public static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    public LinkedHashMap<String, ConstraintAttribute> attributes;
    public float height;
    public int mDrawPath;
    public Easing mKeyFrameEasing;
    public int mMode;
    public int mPathMotionArc;
    public float mPathRotate;
    public float mProgress;
    public double[] mTempDelta;
    public double[] mTempValue;
    public float position;
    public float time;
    public float width;

    /* renamed from: x */
    public float f29x;

    /* renamed from: y */
    public float f30y;

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    public MotionPaths(int i, int i2, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        int i3 = keyPosition.mPositionType;
        if (i3 == 1) {
            initPath(keyPosition, motionPaths, motionPaths2);
        } else if (i3 != 2) {
            initCartesian(keyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i, i2, keyPosition, motionPaths, motionPaths2);
        }
    }

    private boolean diff(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    public static final float xRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return (((f5 - f3) * f2) - ((f6 - f4) * f)) + f3;
    }

    public static final float yRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return ((f6 - f4) * f2) + ((f5 - f3) * f) + f4;
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mProgress = constraint.propertySet.mProgress;
        for (String str : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute.getType() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.attributes.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z) {
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        zArr[1] = zArr[1] | diff(this.f29x, motionPaths.f29x) | z;
        zArr[2] = z | diff(this.f30y, motionPaths.f30y) | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.f29x, this.f30y, this.width, this.height, this.mPathRotate};
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] < 6) {
                dArr[i] = fArr[iArr[i2]];
                i++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.width;
        float f2 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f3 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 3) {
                f = f3;
            } else if (i3 == 4) {
                f2 = f3;
            }
        }
        fArr[i] = f;
        fArr[i + 1] = f2;
    }

    public void getCenter(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.f29x;
        float f2 = this.f30y;
        float f3 = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        fArr[i] = (f3 / 2.0f) + f + 0.0f;
        fArr[i + 1] = (f4 / 2.0f) + f2 + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i) {
        ConstraintAttribute constraintAttribute = this.attributes.get(str);
        if (constraintAttribute.noOfInterpValues() == 1) {
            dArr[i] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int noOfInterpValues = constraintAttribute.noOfInterpValues();
        float[] fArr = new float[noOfInterpValues];
        constraintAttribute.getValuesToInterpolate(fArr);
        int i2 = 0;
        while (i2 < noOfInterpValues) {
            dArr[i] = fArr[i2];
            i2++;
            i++;
        }
        return noOfInterpValues;
    }

    public int getCustomDataCount(String str) {
        return this.attributes.get(str).noOfInterpValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.f29x;
        float f2 = this.f30y;
        float f3 = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        float f6 = f3 + f;
        float f7 = f4 + f2;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i4 = i + 1;
        fArr[i] = f + 0.0f;
        int i5 = i4 + 1;
        fArr[i4] = f2 + 0.0f;
        int i6 = i5 + 1;
        fArr[i5] = f6 + 0.0f;
        int i7 = i6 + 1;
        fArr[i6] = f2 + 0.0f;
        int i8 = i7 + 1;
        fArr[i7] = f6 + 0.0f;
        int i9 = i8 + 1;
        fArr[i8] = f7 + 0.0f;
        fArr[i9] = f + 0.0f;
        fArr[i9 + 1] = f7 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.attributes.containsKey(str);
    }

    public void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f2 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f3 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f4 = motionPaths2.width;
        float f5 = motionPaths.width;
        float f6 = f4 - f5;
        float f7 = motionPaths2.height;
        float f8 = motionPaths.height;
        float f9 = f7 - f8;
        this.position = this.time;
        float f10 = motionPaths.f29x;
        float f11 = motionPaths.f30y;
        float f12 = ((f4 / 2.0f) + motionPaths2.f29x) - ((f5 / 2.0f) + f10);
        float f13 = ((f7 / 2.0f) + motionPaths2.f30y) - ((f8 / 2.0f) + f11);
        float f14 = f6 * f2;
        float f15 = f14 / 2.0f;
        this.f29x = (int) (((f12 * f) + f10) - f15);
        float f16 = (f13 * f) + f11;
        float f17 = f9 * f3;
        float f18 = f17 / 2.0f;
        this.f30y = (int) (f16 - f18);
        this.width = (int) (f5 + f14);
        this.height = (int) (f8 + f17);
        float f19 = Float.isNaN(keyPosition.mPercentX) ? f : keyPosition.mPercentX;
        float f20 = 0.0f;
        float f21 = Float.isNaN(keyPosition.mAltPercentY) ? 0.0f : keyPosition.mAltPercentY;
        if (!Float.isNaN(keyPosition.mPercentY)) {
            f = keyPosition.mPercentY;
        }
        if (!Float.isNaN(keyPosition.mAltPercentX)) {
            f20 = keyPosition.mAltPercentX;
        }
        this.mMode = 2;
        this.f29x = (int) (((f20 * f13) + ((f19 * f12) + motionPaths.f29x)) - f15);
        this.f30y = (int) (((f13 * f) + ((f12 * f21) + motionPaths.f30y)) - f18);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        float f2;
        float f3 = keyPosition.mFramePosition / 100.0f;
        this.time = f3;
        this.mDrawPath = keyPosition.mDrawPath;
        float f4 = Float.isNaN(keyPosition.mPercentWidth) ? f3 : keyPosition.mPercentWidth;
        float f5 = Float.isNaN(keyPosition.mPercentHeight) ? f3 : keyPosition.mPercentHeight;
        float f6 = motionPaths2.width - motionPaths.width;
        float f7 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            f3 = keyPosition.mPercentX;
        }
        float f8 = motionPaths.f29x;
        float f9 = motionPaths.width;
        float f10 = motionPaths.f30y;
        float f11 = motionPaths.height;
        float f12 = ((motionPaths2.width / 2.0f) + motionPaths2.f29x) - ((f9 / 2.0f) + f8);
        float f13 = ((motionPaths2.height / 2.0f) + motionPaths2.f30y) - ((f11 / 2.0f) + f10);
        float f14 = f12 * f3;
        float f15 = (f6 * f4) / 2.0f;
        this.f29x = (int) ((f8 + f14) - f15);
        float f16 = f3 * f13;
        float f17 = (f7 * f5) / 2.0f;
        this.f30y = (int) ((f10 + f16) - f17);
        this.width = (int) (f9 + f);
        this.height = (int) (f11 + f2);
        float f18 = Float.isNaN(keyPosition.mPercentY) ? 0.0f : keyPosition.mPercentY;
        this.mMode = 1;
        float f19 = (int) ((motionPaths.f29x + f14) - f15);
        this.f29x = f19;
        float f20 = (int) ((motionPaths.f30y + f16) - f17);
        this.f30y = f20;
        this.f29x = f19 + ((-f13) * f18);
        this.f30y = f20 + (f12 * f18);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initScreen(int i, int i2, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f2 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f3 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f4 = motionPaths2.width;
        float f5 = motionPaths.width;
        float f6 = f4 - f5;
        float f7 = motionPaths2.height;
        float f8 = motionPaths.height;
        float f9 = f7 - f8;
        this.position = this.time;
        float f10 = motionPaths.f29x;
        float f11 = motionPaths.f30y;
        float f12 = (f4 / 2.0f) + motionPaths2.f29x;
        float f13 = (f7 / 2.0f) + motionPaths2.f30y;
        float f14 = f6 * f2;
        this.f29x = (int) ((((f12 - ((f5 / 2.0f) + f10)) * f) + f10) - (f14 / 2.0f));
        float f15 = f9 * f3;
        this.f30y = (int) ((((f13 - ((f8 / 2.0f) + f11)) * f) + f11) - (f15 / 2.0f));
        this.width = (int) (f5 + f14);
        this.height = (int) (f8 + f15);
        this.mMode = 3;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            this.f29x = (int) (keyPosition.mPercentX * ((int) (i - this.width)));
        }
        if (!Float.isNaN(keyPosition.mPercentY)) {
            this.f30y = (int) (keyPosition.mPercentY * ((int) (i2 - this.height)));
        }
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void setBounds(float f, float f2, float f3, float f4) {
        this.f29x = f;
        this.f30y = f2;
        this.width = f3;
        this.height = f4;
    }

    public void setDpDt(float f, float f2, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f7 = (float) dArr[i];
            double d = dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f3 = f7;
            } else if (i2 == 2) {
                f5 = f7;
            } else if (i2 == 3) {
                f4 = f7;
            } else if (i2 == 4) {
                f6 = f7;
            }
        }
        float f8 = f3 - ((0.0f * f4) / 2.0f);
        float f9 = f5 - ((0.0f * f6) / 2.0f);
        fArr[0] = (((f4 * 1.0f) + f8) * f) + ((1.0f - f) * f8) + 0.0f;
        fArr[1] = (((f6 * 1.0f) + f9) * f2) + ((1.0f - f2) * f9) + 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00bb, code lost:
        if (java.lang.Float.isNaN(Float.NaN) == false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setView(View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float degrees;
        float f;
        float f2 = this.f29x;
        float f3 = this.f30y;
        float f4 = this.width;
        float f5 = this.height;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i];
            this.mTempDelta = new double[i];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.mTempValue[iArr[i2]] = dArr[i2];
            this.mTempDelta[iArr[i2]] = dArr2[i2];
        }
        int i3 = 0;
        float f6 = Float.NaN;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        while (true) {
            double[] dArr4 = this.mTempValue;
            if (i3 >= dArr4.length) {
                break;
            }
            boolean isNaN = Double.isNaN(dArr4[i3]);
            double d = RoundRectDrawableWithShadow.COS_45;
            if (!isNaN || !(dArr3 == null || dArr3[i3] == RoundRectDrawableWithShadow.COS_45)) {
                if (dArr3 != null) {
                    d = dArr3[i3];
                }
                if (!Double.isNaN(this.mTempValue[i3])) {
                    d = this.mTempValue[i3] + d;
                }
                f = f2;
                float f11 = (float) d;
                float f12 = (float) this.mTempDelta[i3];
                if (i3 == 1) {
                    f7 = f12;
                    f2 = f11;
                } else if (i3 == 2) {
                    f3 = f11;
                    f9 = f12;
                } else if (i3 == 3) {
                    f4 = f11;
                    f8 = f12;
                } else if (i3 == 4) {
                    f5 = f11;
                    f10 = f12;
                } else if (i3 == 5) {
                    f2 = f;
                    f6 = f11;
                }
                i3++;
            } else {
                f = f2;
            }
            f2 = f;
            i3++;
        }
        float f13 = f2;
        if (Float.isNaN(f6)) {
            degrees = Float.NaN;
        } else {
            float f14 = Float.NaN;
            if (Float.isNaN(Float.NaN)) {
                f14 = 0.0f;
            }
            degrees = (float) (Math.toDegrees(Math.atan2((f10 / 2.0f) + f9, (f8 / 2.0f) + f7)) + f6 + f14);
        }
        view.setRotation(degrees);
        float f15 = f13 + 0.5f;
        int i4 = (int) f15;
        float f16 = f3 + 0.5f;
        int i5 = (int) f16;
        int i6 = (int) (f15 + f4);
        int i7 = (int) (f16 + f5);
        int i8 = i6 - i4;
        int i9 = i7 - i5;
        if ((i8 == view.getMeasuredWidth() && i9 == view.getMeasuredHeight()) ? false : true) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i9, 1073741824));
        }
        view.layout(i4, i5, i6, i7);
    }
}

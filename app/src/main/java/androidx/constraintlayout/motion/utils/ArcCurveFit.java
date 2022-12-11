package androidx.constraintlayout.motion.utils;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    public static final int START_HORIZONTAL = 2;
    public static final int START_LINEAR = 3;
    public static final int START_VERTICAL = 1;
    public Arc[] mArcs;
    public final double[] mTime;

    /* loaded from: classes3.dex */
    public static class Arc {
        public static final double EPSILON = 0.001d;
        public static final String TAG = "Arc";
        public static double[] ourPercent = new double[91];
        public boolean linear;
        public double mArcDistance;
        public double mArcVelocity;
        public double mEllipseA;
        public double mEllipseB;
        public double mEllipseCenterX;
        public double mEllipseCenterY;
        public double[] mLut;
        public double mOneOverDeltaTime;
        public double mTime1;
        public double mTime2;
        public double mTmpCosAngle;
        public double mTmpSinAngle;
        public boolean mVertical;
        public double mX1;
        public double mX2;
        public double mY1;
        public double mY2;

        public Arc(int i, double d, double d2, double d3, double d4, double d5, double d6) {
            boolean z = false;
            this.linear = false;
            this.mVertical = i == 1 ? true : z;
            this.mTime1 = d;
            this.mTime2 = d2;
            this.mOneOverDeltaTime = 1.0d / (d2 - d);
            if (3 == i) {
                this.linear = true;
            }
            double d7 = d5 - d3;
            double d8 = d6 - d4;
            if (!this.linear && Math.abs(d7) >= 0.001d && Math.abs(d8) >= 0.001d) {
                this.mLut = new double[101];
                this.mEllipseA = d7 * (this.mVertical ? -1 : 1);
                this.mEllipseB = d8 * (this.mVertical ? 1 : -1);
                this.mEllipseCenterX = this.mVertical ? d5 : d3;
                this.mEllipseCenterY = this.mVertical ? d4 : d6;
                buildTable(d3, d4, d5, d6);
                this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                return;
            }
            this.linear = true;
            this.mX1 = d3;
            this.mX2 = d5;
            this.mY1 = d4;
            this.mY2 = d6;
            double hypot = Math.hypot(d8, d7);
            this.mArcDistance = hypot;
            this.mArcVelocity = hypot * this.mOneOverDeltaTime;
            double d9 = this.mTime2;
            double d10 = this.mTime1;
            this.mEllipseCenterX = d7 / (d9 - d10);
            this.mEllipseCenterY = d8 / (d9 - d10);
        }

        private void buildTable(double d, double d2, double d3, double d4) {
            double[] dArr;
            double[] dArr2;
            double d5;
            double d6 = d3 - d;
            double d7 = d2 - d4;
            int i = 0;
            double d8 = RoundRectDrawableWithShadow.COS_45;
            double d9 = RoundRectDrawableWithShadow.COS_45;
            double d10 = RoundRectDrawableWithShadow.COS_45;
            while (true) {
                if (i >= ourPercent.length) {
                    break;
                }
                double d11 = d8;
                double radians = Math.toRadians((i * 90.0d) / (dArr.length - 1));
                double sin = Math.sin(radians) * d6;
                double cos = Math.cos(radians) * d7;
                if (i > 0) {
                    d5 = Math.hypot(sin - d9, cos - d10) + d11;
                    ourPercent[i] = d5;
                } else {
                    d5 = d11;
                }
                i++;
                d10 = cos;
                d8 = d5;
                d9 = sin;
            }
            double d12 = d8;
            this.mArcDistance = d12;
            int i2 = 0;
            while (true) {
                double[] dArr3 = ourPercent;
                if (i2 >= dArr3.length) {
                    break;
                }
                dArr3[i2] = dArr3[i2] / d12;
                i2++;
            }
            int i3 = 0;
            while (true) {
                if (i3 < this.mLut.length) {
                    double length = i3 / (dArr2.length - 1);
                    int binarySearch = Arrays.binarySearch(ourPercent, length);
                    if (binarySearch >= 0) {
                        this.mLut[i3] = binarySearch / (ourPercent.length - 1);
                    } else if (binarySearch == -1) {
                        this.mLut[i3] = 0.0d;
                    } else {
                        int i4 = -binarySearch;
                        int i5 = i4 - 2;
                        double[] dArr4 = ourPercent;
                        this.mLut[i3] = (((length - dArr4[i5]) / (dArr4[i4 - 1] - dArr4[i5])) + i5) / (dArr4.length - 1);
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }

        public double getDX() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double hypot = this.mArcVelocity / Math.hypot(d, (-this.mEllipseB) * this.mTmpSinAngle);
            if (this.mVertical) {
                d = -d;
            }
            return d * hypot;
        }

        public double getDY() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double d2 = (-this.mEllipseB) * this.mTmpSinAngle;
            double hypot = this.mArcVelocity / Math.hypot(d, d2);
            return this.mVertical ? (-d2) * hypot : d2 * hypot;
        }

        public double getLinearDX(double d) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d) {
            double d2 = (d - this.mTime1) * this.mOneOverDeltaTime;
            double d3 = this.mX1;
            return ((this.mX2 - d3) * d2) + d3;
        }

        public double getLinearY(double d) {
            double d2 = (d - this.mTime1) * this.mOneOverDeltaTime;
            double d3 = this.mY1;
            return ((this.mY2 - d3) * d2) + d3;
        }

        public double getX() {
            return (this.mEllipseA * this.mTmpSinAngle) + this.mEllipseCenterX;
        }

        public double getY() {
            return (this.mEllipseB * this.mTmpCosAngle) + this.mEllipseCenterY;
        }

        public double lookup(double d) {
            if (d <= RoundRectDrawableWithShadow.COS_45) {
                return RoundRectDrawableWithShadow.COS_45;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d * (dArr.length - 1);
            int i = (int) length;
            double d2 = length - i;
            return ((dArr[i + 1] - dArr[i]) * d2) + dArr[i];
        }

        public void setPoint(double d) {
            double lookup = lookup((this.mVertical ? this.mTime2 - d : d - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(lookup);
            this.mTmpCosAngle = Math.cos(lookup);
        }
    }

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        int i;
        this.mTime = dArr;
        this.mArcs = new Arc[dArr.length - 1];
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        while (i2 < this.mArcs.length) {
            int i5 = iArr[i2];
            if (i5 == 0) {
                i = 3;
            } else if (i5 == 1) {
                i3 = 1;
                i = 1;
            } else if (i5 == 2) {
                i3 = 2;
                i = 2;
            } else if (i5 != 3) {
                i = i4;
            } else {
                i3 = i3 == 1 ? 2 : 1;
                i = i3;
            }
            int i6 = i2 + 1;
            this.mArcs[i2] = new Arc(i, dArr[i2], dArr[i6], dArr2[i2][0], dArr2[i2][1], dArr2[i6][0], dArr2[i6][1]);
            i4 = i;
            i2 = i6;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d, int i) {
        Arc[] arcArr = this.mArcs;
        int i2 = 0;
        if (d < arcArr[0].mTime1) {
            d = arcArr[0].mTime1;
        } else if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i2 < arcArr2.length) {
                if (d <= arcArr2[i2].mTime2) {
                    if (arcArr2[i2].linear) {
                        return i == 0 ? arcArr2[i2].getLinearX(d) : arcArr2[i2].getLinearY(d);
                    }
                    arcArr2[i2].setPoint(d);
                    Arc[] arcArr3 = this.mArcs;
                    return i == 0 ? arcArr3[i2].getX() : arcArr3[i2].getY();
                }
                i2++;
            } else {
                return Double.NaN;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        if (d < arcArr[0].mTime1) {
            d = arcArr[0].mTime1;
        }
        Arc[] arcArr2 = this.mArcs;
        if (d > arcArr2[arcArr2.length - 1].mTime2) {
            d = arcArr2[arcArr2.length - 1].mTime2;
        }
        int i = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i < arcArr3.length) {
                if (d <= arcArr3[i].mTime2) {
                    if (arcArr3[i].linear) {
                        dArr[0] = arcArr3[i].getLinearX(d);
                        dArr[1] = this.mArcs[i].getLinearY(d);
                        return;
                    }
                    arcArr3[i].setPoint(d);
                    dArr[0] = this.mArcs[i].getX();
                    dArr[1] = this.mArcs[i].getY();
                    return;
                }
                i++;
            } else {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        Arc[] arcArr = this.mArcs;
        if (d < arcArr[0].mTime1) {
            d = arcArr[0].mTime1;
        } else if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        int i = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i < arcArr2.length) {
                if (d <= arcArr2[i].mTime2) {
                    if (arcArr2[i].linear) {
                        fArr[0] = (float) arcArr2[i].getLinearX(d);
                        fArr[1] = (float) this.mArcs[i].getLinearY(d);
                        return;
                    }
                    arcArr2[i].setPoint(d);
                    fArr[0] = (float) this.mArcs[i].getX();
                    fArr[1] = (float) this.mArcs[i].getY();
                    return;
                }
                i++;
            } else {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        Arc[] arcArr = this.mArcs;
        int i2 = 0;
        if (d < arcArr[0].mTime1) {
            d = arcArr[0].mTime1;
        }
        Arc[] arcArr2 = this.mArcs;
        if (d > arcArr2[arcArr2.length - 1].mTime2) {
            d = arcArr2[arcArr2.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i2 < arcArr3.length) {
                if (d <= arcArr3[i2].mTime2) {
                    if (arcArr3[i2].linear) {
                        return i == 0 ? arcArr3[i2].getLinearDX(d) : arcArr3[i2].getLinearDY(d);
                    }
                    arcArr3[i2].setPoint(d);
                    Arc[] arcArr4 = this.mArcs;
                    return i == 0 ? arcArr4[i2].getDX() : arcArr4[i2].getDY();
                }
                i2++;
            } else {
                return Double.NaN;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        if (d < arcArr[0].mTime1) {
            d = arcArr[0].mTime1;
        } else if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        int i = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i < arcArr2.length) {
                if (d <= arcArr2[i].mTime2) {
                    if (arcArr2[i].linear) {
                        dArr[0] = arcArr2[i].getLinearDX(d);
                        dArr[1] = this.mArcs[i].getLinearDY(d);
                        return;
                    }
                    arcArr2[i].setPoint(d);
                    dArr[0] = this.mArcs[i].getDX();
                    dArr[1] = this.mArcs[i].getDY();
                    return;
                }
                i++;
            } else {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }
}

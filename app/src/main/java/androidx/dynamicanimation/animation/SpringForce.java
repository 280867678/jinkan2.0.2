package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: classes3.dex */
public final class SpringForce implements Force {
    public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2f;
    public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75f;
    public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5f;
    public static final float DAMPING_RATIO_NO_BOUNCY = 1.0f;
    public static final float STIFFNESS_HIGH = 10000.0f;
    public static final float STIFFNESS_LOW = 200.0f;
    public static final float STIFFNESS_MEDIUM = 1500.0f;
    public static final float STIFFNESS_VERY_LOW = 50.0f;
    public static final double UNSET = Double.MAX_VALUE;
    public static final double VELOCITY_THRESHOLD_MULTIPLIER = 62.5d;
    public double mDampedFreq;
    public double mDampingRatio;
    public double mFinalPosition;
    public double mGammaMinus;
    public double mGammaPlus;
    public boolean mInitialized;
    public final DynamicAnimation.MassState mMassState;
    public double mNaturalFreq;
    public double mValueThreshold;
    public double mVelocityThreshold;

    public SpringForce() {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
    }

    public SpringForce(float f) {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
        this.mFinalPosition = f;
    }

    private void init() {
        if (this.mInitialized) {
            return;
        }
        if (this.mFinalPosition == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d = this.mDampingRatio;
        if (d > 1.0d) {
            double d2 = this.mNaturalFreq;
            this.mGammaPlus = (Math.sqrt((d * d) - 1.0d) * d2) + ((-d) * d2);
            double d3 = this.mDampingRatio;
            double d4 = this.mNaturalFreq;
            this.mGammaMinus = ((-d3) * d4) - (Math.sqrt((d3 * d3) - 1.0d) * d4);
        } else if (d >= RoundRectDrawableWithShadow.COS_45 && d < 1.0d) {
            this.mDampedFreq = Math.sqrt(1.0d - (d * d)) * this.mNaturalFreq;
        }
        this.mInitialized = true;
    }

    @Override // androidx.dynamicanimation.animation.Force
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float getAcceleration(float f, float f2) {
        float finalPosition = f - getFinalPosition();
        double d = this.mNaturalFreq;
        return (float) (((-(d * d)) * finalPosition) - (((d * 2.0d) * this.mDampingRatio) * f2));
    }

    public float getDampingRatio() {
        return (float) this.mDampingRatio;
    }

    public float getFinalPosition() {
        return (float) this.mFinalPosition;
    }

    public float getStiffness() {
        double d = this.mNaturalFreq;
        return (float) (d * d);
    }

    @Override // androidx.dynamicanimation.animation.Force
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isAtEquilibrium(float f, float f2) {
        return ((double) Math.abs(f2)) < this.mVelocityThreshold && ((double) Math.abs(f - getFinalPosition())) < this.mValueThreshold;
    }

    public SpringForce setDampingRatio(@FloatRange(from = 0.0d) float f) {
        if (f >= 0.0f) {
            this.mDampingRatio = f;
            this.mInitialized = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public SpringForce setFinalPosition(float f) {
        this.mFinalPosition = f;
        return this;
    }

    public SpringForce setStiffness(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f > 0.0f) {
            this.mNaturalFreq = Math.sqrt(f);
            this.mInitialized = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public void setValueThreshold(double d) {
        double abs = Math.abs(d);
        this.mValueThreshold = abs;
        this.mVelocityThreshold = abs * 62.5d;
    }

    public DynamicAnimation.MassState updateValues(double d, double d2, long j) {
        double cos;
        double d3;
        init();
        double d4 = j / 1000.0d;
        double d5 = d - this.mFinalPosition;
        double d6 = this.mDampingRatio;
        if (d6 > 1.0d) {
            double d7 = this.mGammaMinus;
            double d8 = this.mGammaPlus;
            double d9 = d5 - (((d7 * d5) - d2) / (d7 - d8));
            double d10 = ((d5 * d7) - d2) / (d7 - d8);
            d3 = (Math.pow(2.718281828459045d, this.mGammaPlus * d4) * d10) + (Math.pow(2.718281828459045d, d7 * d4) * d9);
            double d11 = this.mGammaMinus;
            double pow = Math.pow(2.718281828459045d, d11 * d4) * d9 * d11;
            double d12 = this.mGammaPlus;
            cos = (Math.pow(2.718281828459045d, d12 * d4) * d10 * d12) + pow;
        } else if (d6 == 1.0d) {
            double d13 = this.mNaturalFreq;
            double d14 = (d13 * d5) + d2;
            double d15 = (d14 * d4) + d5;
            double pow2 = Math.pow(2.718281828459045d, (-d13) * d4) * d15;
            double pow3 = Math.pow(2.718281828459045d, (-this.mNaturalFreq) * d4) * d15;
            double d16 = this.mNaturalFreq;
            cos = (Math.pow(2.718281828459045d, (-d16) * d4) * d14) + (pow3 * (-d16));
            d3 = pow2;
        } else {
            double d17 = 1.0d / this.mDampedFreq;
            double d18 = this.mNaturalFreq;
            double d19 = ((d6 * d18 * d5) + d2) * d17;
            double sin = ((Math.sin(this.mDampedFreq * d4) * d19) + (Math.cos(this.mDampedFreq * d4) * d5)) * Math.pow(2.718281828459045d, (-d6) * d18 * d4);
            double d20 = this.mNaturalFreq;
            double d21 = this.mDampingRatio;
            double d22 = (-d20) * sin * d21;
            double pow4 = Math.pow(2.718281828459045d, (-d21) * d20 * d4);
            double d23 = this.mDampedFreq;
            double d24 = (-d23) * d5;
            double d25 = this.mDampedFreq;
            cos = (((Math.cos(d25 * d4) * d19 * d25) + (Math.sin(d23 * d4) * d24)) * pow4) + d22;
            d3 = sin;
        }
        DynamicAnimation.MassState massState = this.mMassState;
        massState.mValue = (float) (d3 + this.mFinalPosition);
        massState.mVelocity = (float) cos;
        return massState;
    }
}

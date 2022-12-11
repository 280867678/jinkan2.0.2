package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* loaded from: classes3.dex */
public class CircularPropagation extends VisibilityPropagation {
    public float mPropagationSpeed = 3.0f;

    public static float distance(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((f6 * f6) + (f5 * f5));
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i;
        int round;
        int i2;
        if (transitionValues == null && transitionValues2 == null) {
            return 0L;
        }
        if (transitionValues2 == null || getViewVisibility(transitionValues) == 0) {
            i = -1;
        } else {
            transitionValues = transitionValues2;
            i = 1;
        }
        int viewX = getViewX(transitionValues);
        int viewY = getViewY(transitionValues);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            i2 = epicenter.centerX();
            round = epicenter.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round2 = Math.round(viewGroup.getTranslationX() + (viewGroup.getWidth() / 2) + iArr[0]);
            int i3 = iArr[1];
            round = Math.round(viewGroup.getTranslationY() + (viewGroup.getHeight() / 2) + i3);
            i2 = round2;
        }
        float distance = distance(viewX, viewY, i2, round) / distance(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return Math.round((((float) (duration * i)) / this.mPropagationSpeed) * distance);
    }

    public void setPropagationSpeed(float f) {
        if (f != 0.0f) {
            this.mPropagationSpeed = f;
            return;
        }
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }
}

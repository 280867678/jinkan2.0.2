package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;

/* loaded from: classes3.dex */
public class TransitionBuilder {
    public static final String TAG = "TransitionBuilder";

    public static MotionScene.Transition buildTransition(MotionScene motionScene, int i, int i2, ConstraintSet constraintSet, int i3, ConstraintSet constraintSet2) {
        MotionScene.Transition transition = new MotionScene.Transition(i, motionScene, i2, i3);
        updateConstraintSetInMotionScene(motionScene, transition, constraintSet, constraintSet2);
        return transition;
    }

    public static void updateConstraintSetInMotionScene(MotionScene motionScene, MotionScene.Transition transition, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
        int startConstraintSetId = transition.getStartConstraintSetId();
        int endConstraintSetId = transition.getEndConstraintSetId();
        motionScene.setConstraintSet(startConstraintSetId, constraintSet);
        motionScene.setConstraintSet(endConstraintSetId, constraintSet2);
    }

    public static void validate(MotionLayout motionLayout) {
        MotionScene motionScene = motionLayout.mScene;
        if (motionScene != null) {
            if (!motionScene.validateLayout(motionLayout)) {
                throw new RuntimeException("MotionLayout doesn't have the right motion scene.");
            }
            if (motionScene.mCurrentTransition != null && !motionScene.getDefinedTransitions().isEmpty()) {
                return;
            }
            throw new RuntimeException("Invalid motion layout. Motion Scene doesn't have any transition.");
        }
        throw new RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
    }
}

package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class AlignVerticallyReference extends HelperReference {
    public float mBias = 0.5f;
    public Object mBottomToBottom;
    public Object mBottomToTop;
    public Object mTopToBottom;
    public Object mTopToTop;

    public AlignVerticallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    @Override // androidx.constraintlayout.solver.state.HelperReference
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void apply() {
        Object obj;
        float f;
        Iterator<Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            ConstraintReference constraints = this.mState.constraints(it.next());
            constraints.clearVertical();
            Object obj2 = this.mTopToTop;
            if (obj2 == null) {
                Object obj3 = this.mTopToBottom;
                if (obj3 != null) {
                    constraints.topToBottom(obj3);
                    obj = this.mBottomToTop;
                    if (obj == null) {
                        constraints.bottomToTop(obj);
                    } else {
                        Object obj4 = this.mBottomToBottom;
                        if (obj4 == null) {
                            obj4 = State.PARENT;
                        }
                        constraints.bottomToBottom(obj4);
                    }
                    f = this.mBias;
                    if (f == 0.5f) {
                        constraints.verticalBias(f);
                    }
                } else {
                    obj2 = State.PARENT;
                }
            }
            constraints.topToTop(obj2);
            obj = this.mBottomToTop;
            if (obj == null) {
            }
            f = this.mBias;
            if (f == 0.5f) {
            }
        }
    }

    public void bias(float f) {
        this.mBias = f;
    }

    public void bottomToBottom(Object obj) {
        this.mBottomToBottom = obj;
    }

    public void bottomToTop(Object obj) {
        this.mBottomToTop = obj;
    }

    public void topToBottom(Object obj) {
        this.mTopToBottom = obj;
    }

    public void topToTop(Object obj) {
        this.mTopToTop = obj;
    }
}

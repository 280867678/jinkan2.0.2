package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class AlignHorizontallyReference extends HelperReference {
    public float mBias = 0.5f;
    public Object mEndToEnd;
    public Object mEndToStart;
    public Object mStartToEnd;
    public Object mStartToStart;

    public AlignHorizontallyReference(State state) {
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
            constraints.clearHorizontal();
            Object obj2 = this.mStartToStart;
            if (obj2 == null) {
                Object obj3 = this.mStartToEnd;
                if (obj3 != null) {
                    constraints.startToEnd(obj3);
                    obj = this.mEndToStart;
                    if (obj == null) {
                        constraints.endToStart(obj);
                    } else {
                        Object obj4 = this.mEndToEnd;
                        if (obj4 == null) {
                            obj4 = State.PARENT;
                        }
                        constraints.endToEnd(obj4);
                    }
                    f = this.mBias;
                    if (f == 0.5f) {
                        constraints.horizontalBias(f);
                    }
                } else {
                    obj2 = State.PARENT;
                }
            }
            constraints.startToStart(obj2);
            obj = this.mEndToStart;
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

    public void endToEnd(Object obj) {
        this.mEndToEnd = obj;
    }

    public void endToStart(Object obj) {
        this.mEndToStart = obj;
    }

    public void startToEnd(Object obj) {
        this.mStartToEnd = obj;
    }

    public void startToStart(Object obj) {
        this.mStartToStart = obj;
    }
}

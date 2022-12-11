package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class HorizontalChainReference extends ChainReference {
    public Object mEndToEnd;
    public Object mEndToStart;
    public Object mStartToEnd;
    public Object mStartToStart;

    /* renamed from: androidx.constraintlayout.solver.state.helpers.HorizontalChainReference$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C01721 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Chain;

        static {
            int[] iArr = new int[State.Chain.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Chain = iArr;
            try {
                State.Chain chain = State.Chain.SPREAD;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$androidx$constraintlayout$solver$state$State$Chain;
                State.Chain chain2 = State.Chain.SPREAD_INSIDE;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$androidx$constraintlayout$solver$state$State$Chain;
                State.Chain chain3 = State.Chain.PACKED;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public HorizontalChainReference(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Iterator<Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            this.mState.constraints(it.next()).clearHorizontal();
        }
        Iterator<Object> it2 = this.mReferences.iterator();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        while (it2.hasNext()) {
            ConstraintReference constraints = this.mState.constraints(it2.next());
            if (constraintReference2 == null) {
                Object obj = this.mStartToStart;
                if (obj == null) {
                    Object obj2 = this.mStartToEnd;
                    if (obj2 != null) {
                        constraints.startToEnd(obj2);
                        constraintReference2 = constraints;
                    } else {
                        obj = State.PARENT;
                    }
                }
                constraints.startToStart(obj);
                constraintReference2 = constraints;
            }
            if (constraintReference != null) {
                constraintReference.endToStart(constraints.getKey());
                constraints.startToEnd(constraintReference.getKey());
            }
            constraintReference = constraints;
        }
        if (constraintReference != null) {
            Object obj3 = this.mEndToStart;
            if (obj3 != null) {
                constraintReference.endToStart(obj3);
            } else {
                Object obj4 = this.mEndToEnd;
                if (obj4 == null) {
                    obj4 = State.PARENT;
                }
                constraintReference.endToEnd(obj4);
            }
        }
        if (constraintReference2 != null) {
            float f = this.mBias;
            if (f != 0.5f) {
                constraintReference2.horizontalBias(f);
            }
        }
        int ordinal = this.mStyle.ordinal();
        if (ordinal == 0) {
            constraintReference2.setHorizontalChainStyle(0);
            return;
        }
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                return;
            }
        }
        constraintReference2.setHorizontalChainStyle(i);
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

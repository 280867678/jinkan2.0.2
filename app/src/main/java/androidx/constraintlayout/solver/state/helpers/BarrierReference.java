package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.HelperWidget;

/* loaded from: classes3.dex */
public class BarrierReference extends HelperReference {
    public Barrier mBarrierWidget;
    public State.Direction mDirection;
    public int mMargin;

    /* renamed from: androidx.constraintlayout.solver.state.helpers.BarrierReference$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C01711 {

        /* renamed from: $SwitchMap$androidx$constraintlayout$solver$state$State$Direction */
        public static final /* synthetic */ int[] f33xf452c4aa;

        static {
            int[] iArr = new int[State.Direction.values().length];
            f33xf452c4aa = iArr;
            try {
                State.Direction direction = State.Direction.LEFT;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f33xf452c4aa;
                State.Direction direction2 = State.Direction.START;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f33xf452c4aa;
                State.Direction direction3 = State.Direction.RIGHT;
                iArr3[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f33xf452c4aa;
                State.Direction direction4 = State.Direction.END;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = f33xf452c4aa;
                State.Direction direction5 = State.Direction.TOP;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = f33xf452c4aa;
                State.Direction direction6 = State.Direction.BOTTOM;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public BarrierReference(State state) {
        super(state, State.Helper.BARRIER);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r0 != 5) goto L15;
     */
    @Override // androidx.constraintlayout.solver.state.HelperReference
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void apply() {
        getHelperWidget();
        int ordinal = this.mDirection.ordinal();
        int i = 3;
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal == 4) {
                            i = 2;
                        }
                        this.mBarrierWidget.setBarrierType(i);
                        this.mBarrierWidget.setMargin(this.mMargin);
                    }
                }
            }
            i = 1;
            this.mBarrierWidget.setBarrierType(i);
            this.mBarrierWidget.setMargin(this.mMargin);
        }
        i = 0;
        this.mBarrierWidget.setBarrierType(i);
        this.mBarrierWidget.setMargin(this.mMargin);
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public HelperWidget getHelperWidget() {
        if (this.mBarrierWidget == null) {
            this.mBarrierWidget = new Barrier();
        }
        return this.mBarrierWidget;
    }

    public void margin(int i) {
        this.mMargin = i;
    }

    public void margin(Object obj) {
        margin(this.mState.convertDimension(obj));
    }

    public void setBarrierDirection(State.Direction direction) {
        this.mDirection = direction;
    }
}

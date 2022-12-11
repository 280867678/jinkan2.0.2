package kotlin.coroutines.jvm.internal;

import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.mg0;
import me.tvspark.ng0;
import me.tvspark.og0;
import me.tvspark.pg0;

@ef0
/* loaded from: classes4.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    public final og0 _context;
    public transient mg0<Object> intercepted;

    public ContinuationImpl(mg0<Object> mg0Var) {
        this(mg0Var, mg0Var != null ? mg0Var.getContext() : null);
    }

    public ContinuationImpl(mg0<Object> mg0Var, og0 og0Var) {
        super(mg0Var);
        this._context = og0Var;
    }

    @Override // me.tvspark.mg0
    public og0 getContext() {
        og0 og0Var = this._context;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(og0Var);
        return og0Var;
    }

    public final mg0<Object> intercepted() {
        mg0<Object> mg0Var = this.intercepted;
        if (mg0Var == null) {
            ng0 ng0Var = (ng0) getContext().get(ng0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (ng0Var == null || (mg0Var = ng0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)) == null) {
                mg0Var = this;
            }
            this.intercepted = mg0Var;
        }
        return mg0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        mg0<?> mg0Var = this.intercepted;
        if (mg0Var != null && mg0Var != this) {
            og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = getContext().get(ng0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            ((ng0) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var);
        }
        this.intercepted = pg0.Wwwwwwwwwwwwwwwwwwwwwwww;
    }
}

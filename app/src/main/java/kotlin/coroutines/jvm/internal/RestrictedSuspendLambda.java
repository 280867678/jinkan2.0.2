package kotlin.coroutines.jvm.internal;

import me.tvspark.ef0;
import me.tvspark.hi0;
import me.tvspark.ii0;
import me.tvspark.ki0;
import me.tvspark.mg0;

@ef0
/* loaded from: classes4.dex */
public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements hi0<Object> {
    public final int arity;

    public RestrictedSuspendLambda(int i) {
        this(i, null);
    }

    public RestrictedSuspendLambda(int i, mg0<Object> mg0Var) {
        super(mg0Var);
        this.arity = i;
    }

    @Override // me.tvspark.hi0
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() == null) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ki0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "Reflection.renderLambdaToString(this)");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return super.toString();
    }
}

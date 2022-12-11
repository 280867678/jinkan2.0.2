package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.EmptyCoroutineContext;
import me.tvspark.ef0;
import me.tvspark.mg0;
import me.tvspark.og0;

@ef0
/* loaded from: classes4.dex */
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(mg0<Object> mg0Var) {
        super(mg0Var);
        if (mg0Var != null) {
            if (!(mg0Var.getContext() == EmptyCoroutineContext.INSTANCE)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // me.tvspark.mg0
    public og0 getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}

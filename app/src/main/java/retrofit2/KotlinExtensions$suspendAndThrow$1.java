package retrofit2;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import me.tvspark.ef0;
import me.tvspark.mg0;
import me.tvspark.rg0;

@rg0(m188c = "retrofit2.KotlinExtensions", m187f = "KotlinExtensions.kt", m186l = {113}, m185m = "suspendAndThrow")
@ef0
/* loaded from: classes5.dex */
public final class KotlinExtensions$suspendAndThrow$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public KotlinExtensions$suspendAndThrow$1(mg0 mg0Var) {
        super(mg0Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return KotlinExtensions.suspendAndThrow(null, this);
    }
}

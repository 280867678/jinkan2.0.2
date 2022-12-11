package kotlin.coroutines;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.mh0;
import me.tvspark.ng0;
import me.tvspark.og0;

@ef0
/* loaded from: classes4.dex */
public final class CoroutineContext$plus$1 extends Lambda implements mh0<og0, og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, og0> {
    public static final CoroutineContext$plus$1 INSTANCE = new CoroutineContext$plus$1();

    public CoroutineContext$plus$1() {
        super(2);
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final og0 mo4918invoke(og0 og0Var, og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(og0Var, "acc");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "element");
        og0 minusKey = og0Var.minusKey(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getKey());
        if (minusKey == EmptyCoroutineContext.INSTANCE) {
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        ng0 ng0Var = (ng0) minusKey.get(ng0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (ng0Var == null) {
            return new CombinedContext(minusKey, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        og0 minusKey2 = minusKey.minusKey(ng0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return minusKey2 == EmptyCoroutineContext.INSTANCE ? new CombinedContext(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ng0Var) : new CombinedContext(new CombinedContext(minusKey2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), ng0Var);
    }
}

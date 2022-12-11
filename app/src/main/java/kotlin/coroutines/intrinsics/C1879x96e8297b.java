package kotlin.coroutines.intrinsics;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.mg0;
import me.tvspark.og0;
import me.tvspark.r40;

@ef0
/* renamed from: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2 */
/* loaded from: classes4.dex */
public final class C1879x96e8297b extends ContinuationImpl {
    public final /* synthetic */ ih0 $block;
    public final /* synthetic */ mg0 $completion;
    public final /* synthetic */ og0 $context;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1879x96e8297b(ih0 ih0Var, mg0 mg0Var, og0 og0Var, mg0 mg0Var2, og0 og0Var2) {
        super(mg0Var2, og0Var2);
        this.$block = ih0Var;
        this.$completion = mg0Var;
        this.$context = og0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            this.label = 1;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            return this.$block.mo4916invoke(this);
        } else if (i != 1) {
            throw new IllegalStateException("This coroutine had already completed".toString());
        } else {
            this.label = 2;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            return obj;
        }
    }
}

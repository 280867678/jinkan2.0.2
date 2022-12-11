package kotlin.coroutines.intrinsics;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import me.tvspark.ef0;
import me.tvspark.mg0;
import me.tvspark.mh0;
import me.tvspark.ni0;
import me.tvspark.og0;
import me.tvspark.r40;

@ef0
/* renamed from: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4 */
/* loaded from: classes4.dex */
public final class C1877xa50de663 extends ContinuationImpl {
    public final /* synthetic */ mg0 $completion;
    public final /* synthetic */ og0 $context;
    public final /* synthetic */ Object $receiver$inlined;
    public final /* synthetic */ mh0 $this_createCoroutineUnintercepted$inlined;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1877xa50de663(mg0 mg0Var, og0 og0Var, mg0 mg0Var2, og0 og0Var2, mh0 mh0Var, Object obj) {
        super(mg0Var2, og0Var2);
        this.$completion = mg0Var;
        this.$context = og0Var;
        this.$this_createCoroutineUnintercepted$inlined = mh0Var;
        this.$receiver$inlined = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.label = 2;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            return obj;
        }
        this.label = 1;
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        mh0 mh0Var = this.$this_createCoroutineUnintercepted$inlined;
        if (mh0Var == null) {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        ni0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mh0Var, 2);
        return mh0Var.mo4918invoke(this.$receiver$inlined, this);
    }
}

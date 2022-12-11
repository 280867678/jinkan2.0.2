package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import me.tvspark.ak0;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.mg0;
import me.tvspark.mh0;
import me.tvspark.of0;
import me.tvspark.r40;
import me.tvspark.rg0;
import me.tvspark.zj0;

@rg0(m188c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", m187f = "_Sequences.kt", m186l = {2666}, m185m = "invokeSuspend")
@ef0
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$zipWithNext$2 extends RestrictedSuspendLambda implements mh0<ak0<? super R>, mg0<? super of0>, Object> {
    public final /* synthetic */ zj0 $this_zipWithNext;
    public final /* synthetic */ mh0 $transform;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* renamed from: p$ */
    public ak0 f4487p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$zipWithNext$2(zj0 zj0Var, mh0 mh0Var, mg0 mg0Var) {
        super(2, mg0Var);
        this.$this_zipWithNext = zj0Var;
        this.$transform = mh0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final mg0<of0> create(Object obj, mg0<?> mg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var, "completion");
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.$this_zipWithNext, this.$transform, mg0Var);
        sequencesKt___SequencesKt$zipWithNext$2.f4487p$ = (ak0) obj;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke */
    public final Object mo4918invoke(Object obj, mg0<? super of0> mg0Var) {
        return ((SequencesKt___SequencesKt$zipWithNext$2) create(obj, mg0Var)).invokeSuspend(of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ak0 ak0Var;
        Object next;
        Iterator it;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            ak0 ak0Var2 = this.f4487p$;
            Iterator it2 = this.$this_zipWithNext.iterator();
            if (!it2.hasNext()) {
                return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            ak0Var = ak0Var2;
            next = it2.next();
            it = it2;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Object obj2 = this.L$3;
            it = (Iterator) this.L$1;
            ak0Var = (ak0) this.L$0;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            next = obj2;
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            Object mo4918invoke = this.$transform.mo4918invoke(next, next2);
            this.L$0 = ak0Var;
            this.L$1 = it;
            this.L$2 = next;
            this.L$3 = next2;
            this.label = 1;
            if (ak0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ak0) mo4918invoke, (mg0<? super of0>) this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            next = next2;
        }
        return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}

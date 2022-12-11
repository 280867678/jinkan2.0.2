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

@rg0(m188c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", m187f = "_Sequences.kt", m186l = {2139, 2142}, m185m = "invokeSuspend")
@ef0
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$runningReduce$1 extends RestrictedSuspendLambda implements mh0<ak0<? super S>, mg0<? super of0>, Object> {
    public final /* synthetic */ mh0 $operation;
    public final /* synthetic */ zj0 $this_runningReduce;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* renamed from: p$ */
    public ak0 f4485p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$runningReduce$1(zj0 zj0Var, mh0 mh0Var, mg0 mg0Var) {
        super(2, mg0Var);
        this.$this_runningReduce = zj0Var;
        this.$operation = mh0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final mg0<of0> create(Object obj, mg0<?> mg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var, "completion");
        SequencesKt___SequencesKt$runningReduce$1 sequencesKt___SequencesKt$runningReduce$1 = new SequencesKt___SequencesKt$runningReduce$1(this.$this_runningReduce, this.$operation, mg0Var);
        sequencesKt___SequencesKt$runningReduce$1.f4485p$ = (ak0) obj;
        return sequencesKt___SequencesKt$runningReduce$1;
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke */
    public final Object mo4918invoke(Object obj, mg0<? super of0> mg0Var) {
        return ((SequencesKt___SequencesKt$runningReduce$1) create(obj, mg0Var)).invokeSuspend(of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
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
            ak0Var = this.f4485p$;
            Iterator it2 = this.$this_runningReduce.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                this.L$0 = ak0Var;
                this.L$1 = it2;
                this.L$2 = next;
                this.label = 1;
                if (ak0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ak0) next, (mg0<? super of0>) this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                it = it2;
            }
            return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else if (i != 1 && i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            next = this.L$2;
            it = (Iterator) this.L$1;
            ak0Var = (ak0) this.L$0;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        }
        while (it.hasNext()) {
            next = this.$operation.mo4918invoke(next, it.next());
            this.L$0 = ak0Var;
            this.L$1 = it;
            this.L$2 = next;
            this.label = 2;
            if (ak0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ak0) next, (mg0<? super of0>) this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}

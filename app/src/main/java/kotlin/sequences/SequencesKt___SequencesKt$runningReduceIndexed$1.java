package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import me.tvspark.ak0;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.mg0;
import me.tvspark.mh0;
import me.tvspark.nh0;
import me.tvspark.of0;
import me.tvspark.r40;
import me.tvspark.rg0;
import me.tvspark.zj0;

@rg0(m188c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", m187f = "_Sequences.kt", m186l = {2168, 2172}, m185m = "invokeSuspend")
@ef0
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$runningReduceIndexed$1 extends RestrictedSuspendLambda implements mh0<ak0<? super S>, mg0<? super of0>, Object> {
    public final /* synthetic */ nh0 $operation;
    public final /* synthetic */ zj0 $this_runningReduceIndexed;
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* renamed from: p$ */
    public ak0 f4486p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$runningReduceIndexed$1(zj0 zj0Var, nh0 nh0Var, mg0 mg0Var) {
        super(2, mg0Var);
        this.$this_runningReduceIndexed = zj0Var;
        this.$operation = nh0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final mg0<of0> create(Object obj, mg0<?> mg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var, "completion");
        SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1 = new SequencesKt___SequencesKt$runningReduceIndexed$1(this.$this_runningReduceIndexed, this.$operation, mg0Var);
        sequencesKt___SequencesKt$runningReduceIndexed$1.f4486p$ = (ak0) obj;
        return sequencesKt___SequencesKt$runningReduceIndexed$1;
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke */
    public final Object mo4918invoke(Object obj, mg0<? super of0> mg0Var) {
        return ((SequencesKt___SequencesKt$runningReduceIndexed$1) create(obj, mg0Var)).invokeSuspend(of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0061  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ak0 ak0Var;
        Iterator it;
        Object next;
        SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        int i2 = 1;
        if (i == 0) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            ak0Var = this.f4486p$;
            it = this.$this_runningReduceIndexed.iterator();
            if (it.hasNext()) {
                next = it.next();
                this.L$0 = ak0Var;
                this.L$1 = it;
                this.L$2 = next;
                this.label = 1;
                if (ak0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ak0) next, (mg0<? super of0>) this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = this.I$0;
            Object obj2 = this.L$2;
            it = (Iterator) this.L$1;
            ak0Var = (ak0) this.L$0;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            sequencesKt___SequencesKt$runningReduceIndexed$1 = this;
            i2 = i3;
            next = obj2;
            while (it.hasNext()) {
                nh0 nh0Var = sequencesKt___SequencesKt$runningReduceIndexed$1.$operation;
                int i4 = i2 + 1;
                if (i2 < 0) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                Object invoke = nh0Var.invoke(new Integer(i2), next, it.next());
                sequencesKt___SequencesKt$runningReduceIndexed$1.L$0 = ak0Var;
                sequencesKt___SequencesKt$runningReduceIndexed$1.L$1 = it;
                sequencesKt___SequencesKt$runningReduceIndexed$1.L$2 = invoke;
                sequencesKt___SequencesKt$runningReduceIndexed$1.I$0 = i4;
                sequencesKt___SequencesKt$runningReduceIndexed$1.label = 2;
                if (ak0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ak0) invoke, (mg0<? super of0>) sequencesKt___SequencesKt$runningReduceIndexed$1) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                next = invoke;
                i2 = i4;
            }
            return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            next = this.L$2;
            it = (Iterator) this.L$1;
            ak0Var = (ak0) this.L$0;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        }
        sequencesKt___SequencesKt$runningReduceIndexed$1 = this;
        while (it.hasNext()) {
        }
        return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}

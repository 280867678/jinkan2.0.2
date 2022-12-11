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

@rg0(m188c = "kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", m187f = "_Sequences.kt", m186l = {2081, 2085}, m185m = "invokeSuspend")
@ef0
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$runningFold$1 extends RestrictedSuspendLambda implements mh0<ak0<? super R>, mg0<? super of0>, Object> {
    public final /* synthetic */ Object $initial;
    public final /* synthetic */ mh0 $operation;
    public final /* synthetic */ zj0 $this_runningFold;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* renamed from: p$ */
    public ak0 f4483p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$runningFold$1(zj0 zj0Var, Object obj, mh0 mh0Var, mg0 mg0Var) {
        super(2, mg0Var);
        this.$this_runningFold = zj0Var;
        this.$initial = obj;
        this.$operation = mh0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final mg0<of0> create(Object obj, mg0<?> mg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var, "completion");
        SequencesKt___SequencesKt$runningFold$1 sequencesKt___SequencesKt$runningFold$1 = new SequencesKt___SequencesKt$runningFold$1(this.$this_runningFold, this.$initial, this.$operation, mg0Var);
        sequencesKt___SequencesKt$runningFold$1.f4483p$ = (ak0) obj;
        return sequencesKt___SequencesKt$runningFold$1;
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke */
    public final Object mo4918invoke(Object obj, mg0<? super of0> mg0Var) {
        return ((SequencesKt___SequencesKt$runningFold$1) create(obj, mg0Var)).invokeSuspend(of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x004e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ak0 ak0Var;
        Object obj2;
        ak0 ak0Var2;
        Iterator it;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            ak0Var = this.f4483p$;
            Object obj3 = this.$initial;
            this.L$0 = ak0Var;
            this.label = 1;
            if (ak0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ak0) obj3, (mg0<? super of0>) this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) this.L$3;
            Object obj4 = this.L$1;
            ak0Var2 = (ak0) this.L$0;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            obj2 = obj4;
            while (it.hasNext()) {
                Object next = it.next();
                obj2 = this.$operation.mo4918invoke(obj2, next);
                this.L$0 = ak0Var2;
                this.L$1 = obj2;
                this.L$2 = next;
                this.L$3 = it;
                this.label = 2;
                if (ak0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ak0) obj2, (mg0<? super of0>) this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            ak0Var = (ak0) this.L$0;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        }
        obj2 = this.$initial;
        ak0Var2 = ak0Var;
        it = this.$this_runningFold.iterator();
        while (it.hasNext()) {
        }
        return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}

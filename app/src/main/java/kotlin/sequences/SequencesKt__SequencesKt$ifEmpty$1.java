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
import me.tvspark.xg0;
import me.tvspark.zj0;

@rg0(m188c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", m187f = "Sequences.kt", m186l = {69, 71}, m185m = "invokeSuspend")
@ef0
/* loaded from: classes4.dex */
public final class SequencesKt__SequencesKt$ifEmpty$1 extends RestrictedSuspendLambda implements mh0<ak0<? super T>, mg0<? super of0>, Object> {
    public final /* synthetic */ xg0 $defaultValue;
    public final /* synthetic */ zj0 $this_ifEmpty;
    public Object L$0;
    public Object L$1;
    public int label;

    /* renamed from: p$ */
    public ak0 f4481p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt__SequencesKt$ifEmpty$1(zj0 zj0Var, xg0 xg0Var, mg0 mg0Var) {
        super(2, mg0Var);
        this.$this_ifEmpty = zj0Var;
        this.$defaultValue = xg0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final mg0<of0> create(Object obj, mg0<?> mg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var, "completion");
        SequencesKt__SequencesKt$ifEmpty$1 sequencesKt__SequencesKt$ifEmpty$1 = new SequencesKt__SequencesKt$ifEmpty$1(this.$this_ifEmpty, this.$defaultValue, mg0Var);
        sequencesKt__SequencesKt$ifEmpty$1.f4481p$ = (ak0) obj;
        return sequencesKt__SequencesKt$ifEmpty$1;
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke */
    public final Object mo4918invoke(Object obj, mg0<? super of0> mg0Var) {
        return ((SequencesKt__SequencesKt$ifEmpty$1) create(obj, mg0Var)).invokeSuspend(of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            ak0 ak0Var = this.f4481p$;
            Iterator it = this.$this_ifEmpty.iterator();
            if (it.hasNext()) {
                this.L$0 = ak0Var;
                this.L$1 = it;
                this.label = 1;
                if (ak0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it, (mg0<? super of0>) this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                this.L$0 = ak0Var;
                this.L$1 = it;
                this.label = 2;
                if (ak0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((zj0) this.$defaultValue.mo4969invoke(), (mg0<? super of0>) this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        } else if (i != 1 && i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Iterator it2 = (Iterator) this.L$1;
            ak0 ak0Var2 = (ak0) this.L$0;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        }
        return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}

package kotlin.sequences;

import java.util.List;
import java.util.NoSuchElementException;
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
import me.tvspark.ti0;
import me.tvspark.zj0;

@rg0(m188c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", m187f = "Sequences.kt", m186l = {145}, m185m = "invokeSuspend")
@ef0
/* loaded from: classes4.dex */
public final class SequencesKt__SequencesKt$shuffled$1 extends RestrictedSuspendLambda implements mh0<ak0<? super T>, mg0<? super of0>, Object> {
    public final /* synthetic */ ti0 $random;
    public final /* synthetic */ zj0 $this_shuffled;
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* renamed from: p$ */
    public ak0 f4482p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt__SequencesKt$shuffled$1(zj0 zj0Var, ti0 ti0Var, mg0 mg0Var) {
        super(2, mg0Var);
        this.$this_shuffled = zj0Var;
        this.$random = ti0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final mg0<of0> create(Object obj, mg0<?> mg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var, "completion");
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(this.$this_shuffled, this.$random, mg0Var);
        sequencesKt__SequencesKt$shuffled$1.f4482p$ = (ak0) obj;
        return sequencesKt__SequencesKt$shuffled$1;
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke */
    public final Object mo4918invoke(Object obj, mg0<? super of0> mg0Var) {
        return ((SequencesKt__SequencesKt$shuffled$1) create(obj, mg0Var)).invokeSuspend(of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ak0 ak0Var;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            ak0 ak0Var2 = this.f4482p$;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.$this_shuffled);
            ak0Var = ak0Var2;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (List) this.L$1;
            ak0Var = (ak0) this.L$0;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        }
        while (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.$random.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size());
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "$this$removeLast");
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "$this$lastIndex");
                Object remove = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() - 1);
                Object obj2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, remove) : remove;
                this.L$0 = ak0Var;
                this.L$1 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.I$0 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.L$2 = remove;
                this.L$3 = obj2;
                this.label = 1;
                if (ak0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ak0) obj2, (mg0<? super of0>) this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                throw new NoSuchElementException("List is empty.");
            }
        }
        return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}

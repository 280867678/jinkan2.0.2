package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import me.tvspark.ak0;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.mg0;
import me.tvspark.mh0;
import me.tvspark.of0;
import me.tvspark.r40;
import me.tvspark.rg0;
import me.tvspark.zj0;

@rg0(m188c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", m187f = "Sequences.kt", m186l = {332}, m185m = "invokeSuspend")
@ef0
/* loaded from: classes4.dex */
public final class SequencesKt__SequencesKt$flatMapIndexed$1 extends RestrictedSuspendLambda implements mh0<ak0<? super R>, mg0<? super of0>, Object> {
    public final /* synthetic */ ih0 $iterator;
    public final /* synthetic */ zj0 $source;
    public final /* synthetic */ mh0 $transform;
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* renamed from: p$ */
    public ak0 f4480p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt__SequencesKt$flatMapIndexed$1(zj0 zj0Var, mh0 mh0Var, ih0 ih0Var, mg0 mg0Var) {
        super(2, mg0Var);
        this.$source = zj0Var;
        this.$transform = mh0Var;
        this.$iterator = ih0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final mg0<of0> create(Object obj, mg0<?> mg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var, "completion");
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.$source, this.$transform, this.$iterator, mg0Var);
        sequencesKt__SequencesKt$flatMapIndexed$1.f4480p$ = (ak0) obj;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke */
    public final Object mo4918invoke(Object obj, mg0<? super of0> mg0Var) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) create(obj, mg0Var)).invokeSuspend(of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ak0 ak0Var;
        Iterator it;
        int i;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            ak0Var = this.f4480p$;
            it = this.$source.iterator();
            i = 0;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            it = (Iterator) this.L$2;
            int i3 = this.I$0;
            ak0Var = (ak0) this.L$0;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            i = i3;
        }
        while (it.hasNext()) {
            Object next = it.next();
            mh0 mh0Var = this.$transform;
            int i4 = i + 1;
            if (i < 0) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            Object mo4918invoke = mh0Var.mo4918invoke(new Integer(i), next);
            this.L$0 = ak0Var;
            this.I$0 = i4;
            this.L$1 = next;
            this.L$2 = it;
            this.L$3 = mo4918invoke;
            this.label = 1;
            if (ak0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Iterator) this.$iterator.mo4916invoke(mo4918invoke), (mg0<? super of0>) this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            i = i4;
        }
        return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}

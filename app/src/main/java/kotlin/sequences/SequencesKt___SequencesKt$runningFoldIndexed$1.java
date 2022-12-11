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

@rg0(m188c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", m187f = "_Sequences.kt", m186l = {2109, 2114}, m185m = "invokeSuspend")
@ef0
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$runningFoldIndexed$1 extends RestrictedSuspendLambda implements mh0<ak0<? super R>, mg0<? super of0>, Object> {
    public final /* synthetic */ Object $initial;
    public final /* synthetic */ nh0 $operation;
    public final /* synthetic */ zj0 $this_runningFoldIndexed;
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* renamed from: p$ */
    public ak0 f4484p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$runningFoldIndexed$1(zj0 zj0Var, Object obj, nh0 nh0Var, mg0 mg0Var) {
        super(2, mg0Var);
        this.$this_runningFoldIndexed = zj0Var;
        this.$initial = obj;
        this.$operation = nh0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final mg0<of0> create(Object obj, mg0<?> mg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mg0Var, "completion");
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.$this_runningFoldIndexed, this.$initial, this.$operation, mg0Var);
        sequencesKt___SequencesKt$runningFoldIndexed$1.f4484p$ = (ak0) obj;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke */
    public final Object mo4918invoke(Object obj, mg0<? super of0> mg0Var) {
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1) create(obj, mg0Var)).invokeSuspend(of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0051  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ak0 ak0Var;
        int i;
        Object obj2;
        ak0 ak0Var2;
        Iterator it;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            ak0Var = this.f4484p$;
            Object obj3 = this.$initial;
            this.L$0 = ak0Var;
            this.label = 1;
            if (ak0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ak0) obj3, (mg0<? super of0>) this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) this.L$3;
            obj2 = this.L$1;
            int i3 = this.I$0;
            ak0Var2 = (ak0) this.L$0;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            i = i3;
            while (it.hasNext()) {
                Object next = it.next();
                nh0 nh0Var = this.$operation;
                int i4 = i + 1;
                if (i < 0) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                obj2 = nh0Var.invoke(new Integer(i), obj2, next);
                this.L$0 = ak0Var2;
                this.I$0 = i4;
                this.L$1 = obj2;
                this.L$2 = next;
                this.L$3 = it;
                this.label = 2;
                if (ak0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ak0) obj2, (mg0<? super of0>) this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                i = i4;
            }
            return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            ak0Var = (ak0) this.L$0;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
        }
        i = 0;
        obj2 = this.$initial;
        ak0Var2 = ak0Var;
        it = this.$this_runningFoldIndexed.iterator();
        while (it.hasNext()) {
        }
        return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}

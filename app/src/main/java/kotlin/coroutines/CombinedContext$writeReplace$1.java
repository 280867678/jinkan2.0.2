package kotlin.coroutines;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.mh0;
import me.tvspark.of0;
import me.tvspark.og0;

@ef0
/* loaded from: classes4.dex */
public final class CombinedContext$writeReplace$1 extends Lambda implements mh0<of0, og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, of0> {
    public final /* synthetic */ og0[] $elements;
    public final /* synthetic */ Ref$IntRef $index;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombinedContext$writeReplace$1(og0[] og0VarArr, Ref$IntRef ref$IntRef) {
        super(2);
        this.$elements = og0VarArr;
        this.$index = ref$IntRef;
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ of0 mo4918invoke(of0 of0Var, og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        invoke2(of0Var, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return of0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(of0 of0Var, og0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(of0Var, "<anonymous parameter 0>");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "element");
        og0[] og0VarArr = this.$elements;
        Ref$IntRef ref$IntRef = this.$index;
        int i = ref$IntRef.element;
        ref$IntRef.element = i + 1;
        og0VarArr[i] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}

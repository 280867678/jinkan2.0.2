package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.xg0;

@ef0
/* loaded from: classes4.dex */
public final class SequencesKt__SequencesKt$generateSequence$1 extends Lambda implements ih0<T, T> {
    public final /* synthetic */ xg0 $nextFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt__SequencesKt$generateSequence$1(xg0 xg0Var) {
        super(1);
        this.$nextFunction = xg0Var;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public final T mo4916invoke(T t) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, "it");
        return this.$nextFunction.mo4969invoke();
    }
}

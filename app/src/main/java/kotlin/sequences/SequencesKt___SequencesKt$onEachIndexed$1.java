package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.mh0;

@ef0
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$onEachIndexed$1 extends Lambda implements mh0<Integer, T, T> {
    public final /* synthetic */ mh0 $action;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$onEachIndexed$1(mh0 mh0Var) {
        super(2);
        this.$action = mh0Var;
    }

    public final T invoke(int i, T t) {
        this.$action.mo4918invoke(Integer.valueOf(i), t);
        return t;
    }

    @Override // me.tvspark.mh0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo4918invoke(Integer num, Object obj) {
        return invoke(num.intValue(), (int) obj);
    }
}

package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;

@ef0
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$onEach$1 extends Lambda implements ih0<T, T> {
    public final /* synthetic */ ih0 $action;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$onEach$1(ih0 ih0Var) {
        super(1);
        this.$action = ih0Var;
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public final T mo4916invoke(T t) {
        this.$action.mo4916invoke(t);
        return t;
    }
}

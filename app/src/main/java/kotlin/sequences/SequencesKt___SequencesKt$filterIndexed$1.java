package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
import me.tvspark.bg0;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.mh0;

@ef0
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$filterIndexed$1 extends Lambda implements ih0<bg0<? extends T>, Boolean> {
    public final /* synthetic */ mh0 $predicate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$filterIndexed$1(mh0 mh0Var) {
        super(1);
        this.$predicate = mh0Var;
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Boolean mo4916invoke(Object obj) {
        return Boolean.valueOf(invoke((bg0) obj));
    }

    public final boolean invoke(bg0<? extends T> bg0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bg0Var, "it");
        return ((Boolean) this.$predicate.mo4918invoke(0, null)).booleanValue();
    }
}

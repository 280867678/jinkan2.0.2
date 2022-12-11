package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import me.tvspark.ck0;
import me.tvspark.ef0;
import me.tvspark.ih0;

@ef0
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$minus$1$iterator$1 extends Lambda implements ih0<T, Boolean> {
    public final /* synthetic */ Ref$BooleanRef $removed;
    public final /* synthetic */ ck0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$minus$1$iterator$1(ck0 ck0Var, Ref$BooleanRef ref$BooleanRef) {
        super(1);
        this.this$0 = ck0Var;
        this.$removed = ref$BooleanRef;
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Boolean mo4916invoke(Object obj) {
        return Boolean.valueOf(mo4916invoke((SequencesKt___SequencesKt$minus$1$iterator$1) obj));
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke  reason: collision with other method in class */
    public final Boolean mo4916invoke(T t) {
        if (this.$removed.element) {
            return 1;
        }
        throw null;
    }
}

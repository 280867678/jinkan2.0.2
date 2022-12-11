package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.outline;
import me.tvspark.zj0;

@ef0
/* loaded from: classes4.dex */
public final class SequencesKt___SequencesKt$requireNoNulls$1 extends Lambda implements ih0<T, T> {
    public final /* synthetic */ zj0 $this_requireNoNulls;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$requireNoNulls$1(zj0 zj0Var) {
        super(1);
        this.$this_requireNoNulls = zj0Var;
    }

    @Override // me.tvspark.ih0
    /* renamed from: invoke */
    public final T mo4916invoke(T t) {
        if (t != 0) {
            return t;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("null element found in ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.$this_requireNoNulls);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('.');
        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }
}
